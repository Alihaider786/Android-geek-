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
    public class NewsDataController : Controller
    {
        private FileModelContainer db = new FileModelContainer();

        // GET: NewsData
        public async Task<ActionResult> Index()
        {
            return View(await db.NewsDatas.ToListAsync());
        }

        // GET: NewsData/Details/5
        public async Task<ActionResult> Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            NewsData newsData = await db.NewsDatas.FindAsync(id);
            if (newsData == null)
            {
                return HttpNotFound();
            }
            return View(newsData);
        }

        // GET: NewsData/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: NewsData/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create( String Author, String title, String Description, String PublishedAt, String Url, String UrlToImage,  String Category, HttpPostedFileBase uploadFile)

        {
            NewsData data = new NewsData();
            if (ModelState.IsValid)
            {

                if (UrlToImage != "")
                {
                    data.UrlToImage = UrlToImage;
                }

                else
                {
                    try

                    {
                        var fileName = Path.GetFileName(uploadFile.FileName);
                        var path = Path.Combine(Server.MapPath("~/Content/files"), fileName);
                        uploadFile.SaveAs(path);
                        data.UrlToImage = "http://mobileappsports.azurewebsites.net/Content/files/" + fileName;



                    }
                    catch { }

                    }
                    data.Author = Author;
                    data.title = title;
                    data.Description = Description;
                    data.PublishedAt = PublishedAt;
                    data.Url = Url;
                    data.Category = Category;
                  
               

                    db.NewsDatas.Add(data);
                    await db.SaveChangesAsync();


                    return RedirectToAction("Index");
                
                  
        }
            return View(data);
        }

        // GET: NewsData/Edit/5
        public async Task<ActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            NewsData newsData = await db.NewsDatas.FindAsync(id);
            if (newsData == null)
            {
                return HttpNotFound();
            }
            return View(newsData);
        }

        // POST: NewsData/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit(int id, String Author, String title, String Description, String PublishedAt, String Url, String UrlToImage, String Category, HttpPostedFileBase uploadFile)
        {
            NewsData newsData = await db.NewsDatas.FindAsync(id);
            if (ModelState.IsValid)
            {
                if (UrlToImage != "")
                {
                    newsData.UrlToImage = UrlToImage;
                }

                else
                {
                    try

                    {
                        var fileName = Path.GetFileName(uploadFile.FileName);
                        var path = Path.Combine(Server.MapPath("~/Content/files"), fileName);
                        uploadFile.SaveAs(path);
                        newsData.UrlToImage = "http://mobileappsports.azurewebsites.net/Content/files/" + fileName;



                    }
                    catch { }

                }
                newsData.Author = Author;
                newsData.title = title;
                newsData.Description = Description;
                newsData.PublishedAt = PublishedAt;
                newsData.Url = Url;
                newsData.Category = Category;

                db.Entry(newsData).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            return View(newsData);
        }

        // GET: NewsData/Delete/5
        public async Task<ActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            NewsData newsData = await db.NewsDatas.FindAsync(id);
            if (newsData == null)
            {
                return HttpNotFound();
            }
            return View(newsData);
        }

        // POST: NewsData/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            NewsData newsData = await db.NewsDatas.FindAsync(id);
            String[] arr = newsData.UrlToImage.Split('/');
            String filename = arr[arr.Length - 1];
            var path = Path.Combine(Server.MapPath("~/Content/files"), filename);
            if (System.IO.File.Exists(path))
                System.IO.File.Delete(path);
            db.NewsDatas.Remove(newsData);
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
    }
}
