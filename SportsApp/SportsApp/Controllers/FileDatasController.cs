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
    public class FileDatasController : Controller
    {
        private FileModelContainer db = new FileModelContainer();

        // GET: FileDatas
        public async Task<ActionResult> Index()
        {
            return View(await db.FileDatas.ToListAsync());
        }

        // GET: FileDatas/Details/5
        public async Task<ActionResult> Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            FileData fileData = await db.FileDatas.FindAsync(id);
            if (fileData == null)
            {
                return HttpNotFound();
            }
            return View(fileData);
        }

        // GET: FileDatas/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: FileDatas/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(String Tittle, String Description, String Category, String createdBy, String Date, HttpPostedFileBase uploadFile)
        {
            FileData fileData = new FileData();
            if (ModelState.IsValid)
            {
                try
                {
                    var fileName = Path.GetFileName(uploadFile.FileName);
                    var path = Path.Combine(Server.MapPath("~/Content/files"), fileName);
                    uploadFile.SaveAs(path);

                    fileData.Tittle = Tittle;
                    fileData.Description = Description;
                    fileData.Category = Category;
                    fileData.Date = Date;
                    fileData.createdBy = createdBy;
                    fileData.Visibility = "show";
                    fileData.PdfUrl = "http://mobileappsports.azurewebsites.net/Content/files/" + fileName;
                    db.FileDatas.Add(fileData);
                    await db.SaveChangesAsync();


                    return RedirectToAction("Index");
                }
                catch
                { }

            }
            return View(fileData);
        }
        // GET: FileDatas/Edit/5
        public async Task<ActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            FileData fileData = await db.FileDatas.FindAsync(id);
            if (fileData == null)
            {
                return HttpNotFound();
            }
            return View(fileData);
        }

        // POST: FileDatas/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit(int Id, String Tittle, String Description, String Category,String createdBy, String Date, HttpPostedFileBase uploadFile)
        {
            FileData fileData = await db.FileDatas.FindAsync(Id);
            
            if (ModelState.IsValid)
            {


                try
                {
                    var fileName = Path.GetFileName(uploadFile.FileName);
                    var path = Path.Combine(Server.MapPath("~/Content/files"), fileName);
                    uploadFile.SaveAs(path);


                    fileData.Tittle = Tittle;
                    fileData.Description = Description;
                    fileData.Category = Category;
                    fileData.PdfUrl = "http://mobileappsports.azurewebsites.net/Content/files/" + fileName;
                    db.Entry(fileData).State = EntityState.Modified;
                    await db.SaveChangesAsync();
                    return RedirectToAction("Index");
                }
                catch {


                }

            }
            return View(fileData);
        }

        // GET: FileDatas/Delete/5
        public async Task<ActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            FileData fileData = await db.FileDatas.FindAsync(id);
            if (fileData == null)
            {
                return HttpNotFound();
            }
            return View(fileData);
        }

        // POST: FileDatas/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            FileData fileData = await db.FileDatas.FindAsync(id);
            String[] arr = fileData.PdfUrl.Split('/');
            String filename = arr[arr.Length - 1];
            var path = Path.Combine(Server.MapPath("~/Content/files"), filename);
            if (System.IO.File.Exists(path))
                System.IO.File.Delete(path);
            db.FileDatas.Remove(fileData);
            await db.SaveChangesAsync();
            return RedirectToAction("Index");
        }
        public ActionResult Visibility(int id)
        {
            FileData data = db.FileDatas.Where(u => u.Id == id).FirstOrDefault();
            if (data.Visibility == "show")
            {
                data.Visibility = "hide";

            }
            else if(data.Visibility == "hide")
            { data.Visibility = "show"; }
            db.FileDatas.Add(data);
            db.Entry(data).State = EntityState.Modified;
       
            db.SaveChanges();

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
