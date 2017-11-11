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
    public class ImagesDataController : ApiController
    {
        public HttpResponseMessage Get(String category = "All")
        {
            using (FileModelContainer fileModel = new FileModelContainer())
            {
                switch (category.ToLower())
                {
                    case "all":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Visibility == "show").ToList());
                        }

                    case "batting":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "batting" && u.Visibility=="show").ToList());
                        }

                    case "bowling":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "bowling" && u.Visibility == "show").ToList());
                        }

                    case "fielding":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "fielding" && u.Visibility == "show").ToList());
                        }
                    case "stretching":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "stretching" && u.Visibility == "show").ToList());
                        }
                    case "training":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "training" && u.Visibility == "show").ToList());
                        }
                    case "footballdefending":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "footballdefending" && u.Visibility == "show").ToList());
                        }
                    case "footballattacking":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "footballattacking" && u.Visibility == "show").ToList());
                        }
                    case "footballmidfield":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "footballmidfield" && u.Visibility == "show").ToList());
                        }
                    case "footballgoalkeeping":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "footballgoalkeeping" && u.Visibility == "show").ToList());
                        }
                    case "hockeydefending":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "hockeydefending" && u.Visibility == "show").ToList());
                        }
                    case "hockeyattacking":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "hockeyattacking" && u.Visibility == "show").ToList());
                        }
                    case "hockeymidfield":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "hockeymidfield" && u.Visibility == "show").ToList());
                        }
                    case "hockeygoalkeeping":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "hockeygoalkeeping" && u.Visibility == "show").ToList());
                        }
                    case "tennisgrip":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "tennisgrip" && u.Visibility == "show").ToList());
                        }
                    case "tennisserve":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "tennisserve" && u.Visibility == "show").ToList());
                        }
                    case "tennisforehand":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "tennisforehand" && u.Visibility == "show").ToList());
                        }
                    case "tennisbackhand":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "tennisbackhand" && u.Visibility == "show").ToList());
                        }
                    case "tennisvolley":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "tennisvolley" && u.Visibility == "show").ToList());
                        }
                    case "badmintonserve":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "badmintonserve" && u.Visibility == "show").ToList());
                        }
                    case "badmintongrip":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "badmintongrip" && u.Visibility == "show").ToList());
                        }
                    case "badmintonstroke":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "badmintonstroke" && u.Visibility == "show").ToList());
                        }
                    case "badmintonspin":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "badmintonspin" && u.Visibility == "show").ToList());
                        }
                    case "swimmingbutterfly":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "swimmingbutterfly" && u.Visibility == "show").ToList());
                        }
                    case "swimmingbackstroke":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "swimmingbackstroke" && u.Visibility == "show").ToList());
                        }
                    case "swimmingbreaststroke":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "swimmingbreaststroke" && u.Visibility == "show").ToList());
                        }
                    case "swimmingfreestyle":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.Images.Where(u => u.Categoty == "swimmingfreestyle" && u.Visibility == "show").ToList());
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

                var entity = fileModel.Images.FirstOrDefault(u => u.Id == Id);
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