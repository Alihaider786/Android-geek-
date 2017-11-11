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

namespace SportsApp.Controllers
{
    public class VideosController : Controller
    {
        private FileModelContainer db = new FileModelContainer();

        // GET: Videos
        public async Task<ActionResult> Index()
        {
            return View(await db.Videos.ToListAsync());
        }

        // GET: Videos/Details/5
        public async Task<ActionResult> Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Videos videos = await db.Videos.FindAsync(id);
            if (videos == null)
            {
                return HttpNotFound();
            }
            return View(videos);
        }

        // GET: Videos/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Videos/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(String UrlToVideo, String Category,String Title, String Description)
        {
            Videos videos = new Videos();
            if (ModelState.IsValid)
            {
                videos.UrlToVideo = UrlToVideo;
                videos.Category = Category;
                videos.Title = Title;
                videos.Description = Description;
                videos.Visibility = "show";
                db.Videos.Add(videos);

                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }

            return View(videos);
        }

        // GET: Videos/Edit/5
        public async Task<ActionResult> Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Videos videos = await db.Videos.FindAsync(id);
            if (videos == null)
            {
                return HttpNotFound();
            }
            return View(videos);
        }

        // POST: Videos/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Edit([Bind(Include = "Id,UrlToVideo,Category,Title,Description")] Videos videos)
        {
            if (ModelState.IsValid)
            {
                db.Entry(videos).State = EntityState.Modified;
                await db.SaveChangesAsync();
                return RedirectToAction("Index");
            }
            return View(videos);
        }

        // GET: Videos/Delete/5
        public async Task<ActionResult> Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Videos videos = await db.Videos.FindAsync(id);
            if (videos == null)
            {
                return HttpNotFound();
            }
            return View(videos);
        }

        // POST: Videos/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> DeleteConfirmed(int id)
        {
            Videos videos = await db.Videos.FindAsync(id);
            db.Videos.Remove(videos);
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
            Videos data = db.Videos.Where(u => u.Id == id).FirstOrDefault();
            if (data.Visibility == "show")
            {
                data.Visibility = "hide";

            }
            else if (data.Visibility == "hide")
            { data.Visibility = "show"; }
            db.Videos.Add(data);
            db.Entry(data).State = EntityState.Modified;

            db.SaveChanges();

            return RedirectToAction("Index");


        }
    }
}
