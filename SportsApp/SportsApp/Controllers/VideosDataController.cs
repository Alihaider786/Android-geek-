using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Http.Description;
using SportsApp.Models;

namespace SportsApp.Controllers
{
    public class VideosDataController : ApiController
    {
        public HttpResponseMessage Get(String category = "All")
        {
            using (FileModelContainer fileModel = new FileModelContainer())
            {
                switch (category.ToLower())
                {
                    case "all":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u=> u.Visibility=="show").ToList());
                        }

                    case "batting":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "batting" && u.Visibility =="show").ToList());
                        }

                    case "bowling":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "bowling" && u.Visibility == "show").ToList());
                        }

                    case "fielding":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "fielding" && u.Visibility == "show").ToList());
                        }
                    case "stretching":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "stretching" && u.Visibility == "show").ToList());
                        }
                    case "training":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "training" && u.Visibility == "show").ToList());
                        }
                    case "footballdefending":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "footballdefending" && u.Visibility == "show").ToList());
                        }
                    case "footballattacking":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "footballattacking" && u.Visibility == "show").ToList());
                        }
                    case "footballmidfield":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "footballmidfield" && u.Visibility == "show").ToList());
                        }
                    case "footballgoalkeeping":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "footballgoalkeeping" && u.Visibility == "show").ToList());
                        }
                    case "hockeydefending":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "hockeydefending" && u.Visibility == "show").ToList());
                        }
                    case "hockeyattacking":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "hockeyattacking" && u.Visibility == "show").ToList());
                        }
                    case "hockeymidfield":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "hockeymidfield" && u.Visibility == "show").ToList());
                        }
                    case "hockeygoalkeeping":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "hockeygoalkeeping" && u.Visibility == "show").ToList());
                        }
                    case "tennisgrip":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "tennisgrip" && u.Visibility == "show").ToList());
                        }
                    case "tennisserve":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "tennisserve" && u.Visibility == "show").ToList());
                        }
                    case "tennisforehand":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "tennisforehand" && u.Visibility == "show").ToList());
                        }
                    case "tennisbackhand":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "tennisbackhand" && u.Visibility == "show").ToList());
                        }
                    case "tennisvolley":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "tennisvolley" && u.Visibility == "show").ToList());
                        }
                    case "badmintonserve":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "badmintonserve" && u.Visibility == "show").ToList());
                        }
                    case "badmintongrip":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "badmintongrip" && u.Visibility == "show").ToList());
                        }
                    case "badmintonstroke":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "badmintonstroke" && u.Visibility == "show").ToList());
                        }
                    case "badmintonspin":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "badmintonspin" && u.Visibility == "show").ToList());
                        }
                    case "swimmingbutterfly":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "swimmingbutterfly" && u.Visibility == "show").ToList());
                        }
                    case "swimmingbackstroke":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "swimmingbackstroke" && u.Visibility == "show").ToList());
                        }
                    case "swimmingbreaststroke":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "swimmingbreaststroke" && u.Visibility == "show").ToList());
                        }
                    case "swimmingfreestyle":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Videos.Where(u => u.Category == "swimmingfreestyle" && u.Visibility == "show").ToList());
                        }
                    default:
                        {

                            return Request.CreateErrorResponse(HttpStatusCode.BadRequest, "Unknown Category");
                        }


                }


            }

        }



        // GET: api/ImagesData
        public HttpResponseMessage Get(int Id)
        {
            using (FileModelContainer fileModel = new FileModelContainer())
            {

                var entity = fileModel.Videos.FirstOrDefault(u => u.Id == Id);
                if (entity != null)
                {
                    return Request.CreateResponse(HttpStatusCode.OK, entity);

                }
                else
                {

                    return Request.CreateErrorResponse(HttpStatusCode.NotFound, "No such id exists");
                }

            }
        }
    }
}