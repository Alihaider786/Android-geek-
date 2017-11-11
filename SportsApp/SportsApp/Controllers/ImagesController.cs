using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Threading.Tasks;
using System.Net;
using System.Web;
using System.Web.Mvc;
using SportsApp.Models;
using System.IO;

namespace SportsApp.Controllers
{
    public class ImagesController : Controller
    {
        private FileModelContainer db = new FileModelContainer();

        // GET: Images
        public async Task<ActionResult> Index()
        {
            return View(await db.Images.ToListAsync());
        }

        // GET: Images/Details/5
        public async Task<ActionResult> Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Images images = await db.Images.FindAsync(id);
            if (images == null)
            {
                return HttpNotFound();
            }
            return View(images);
        }

        // GET: Images/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Images/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(String UrlToImage, HttpPostedFileBase uploadFile, String Categoty, String Title, String Description)
        {
            Images images = new Images();
            if (ModelState.IsValid)
            {
                if (UrlToImage != "")
                {
                    images.UrlToImage = UrlToImage;
                }

                else
                {
                    try

                    {
                        var fileName = Path.GetFileName(uploadFile.FileName);
                        var path = Path.Combine(Server.MapPath("~/Content/files"), fileName);
                        uploadFile.SaveAs(path);
                        images.UrlToImage = "http://mobileappsports.azurewebsites.net/Content/files/" + fileName;



                    }
                    catch { }

                }
                images.Visibility = "show";
                images.Categoty = Categoty;
                images.Title = Title;
                images.Description = Description;
                 db.Images.Add(images);
                await db.SaveChangesAsync();
                return RedirectToAction("Index");

            }

            return View(images);
        }

        // GET: Images/Edit/5
        public async Task<ActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Images images = await db.Images.FindAsync(id);
            if (images == null)
            {
                return HttpNotFound();
            }
            return View(images);
        }

        // POST: Images/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit(int id, String UrlToImage, HttpPostedFileBase uploadFile, String Categoty, String Title, String Description)
        {
            Images images = await db.Images.FindAsync(id);
            if (ModelState.IsValid)
            {
                if (UrlToImage != "")
                {
                    images.UrlToImage = UrlToImage;
                }

                else
                {
                    try

                    {
                        var fileName = Path.GetFileName(uploadFile.FileName);
                        var path = Path.Combine(Server.MapPath("~/Content/files"), fileName);
                        uploadFile.SaveAs(path);
                        images.UrlToImage = "http://mobileappsports.azurewebsites.net/Content/files/" + fileName;



                    }
                    catch { }

                }
                images.Categoty = Categoty;
                images.Title = Title;
                images.Visibility = "show";
                images.Description = Description;
                db.Entry(images).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            return View(images);
        }

        // GET: Images/Delete/5
        public async Task<ActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Images images = await db.Images.FindAsync(id);
            if (images == null)
            {
                return HttpNotFound();
            }
            return View(images);
        }

        // POST: Images/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            Images images = await db.Images.FindAsync(id);
            String[] arr = images.UrlToImage.Split('/');
            String filename = arr[arr.Length - 1];
            var path = Path.Combine(Server.MapPath("~/Content/files"), filename);
            if (System.IO.File.Exists(path))
                System.IO.File.Delete(path);
            db.Images.Remove(images);
            await db.SaveChangesAsync();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
        public ActionResult Visibility(int id)
        {
            Images data = db.Images.Where(u => u.Id == id).FirstOrDefault();
            if (data.Visibility == "show")
            {
                data.Visibility = "hide";

            }
            else if (data.Visibility == "hide")
            { data.Visibility = "show"; }
            db.Images.Add(data);
            db.Entry(data).State = EntityState.Modified;

            db.SaveChanges();

            return RedirectToAction("Index");


        }
    }
}
