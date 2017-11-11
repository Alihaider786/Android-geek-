using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using SportsApp.Models;

namespace SportsApp.Controllers
{
    public class FileController : ApiController
    {

        public HttpResponseMessage Get(String category = "All")
        {
            using (FileModelContainer fileModel = new FileModelContainer())
            {
                switch (category.ToLower())
                {
                    case "all":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.FileDatas.Where(u => u.Visibility == "show").ToList());
                        }
                        
                       case "cricket":
                           {

                                    return Request.CreateResponse(HttpStatusCode.OK, fileModel.FileDatas.Where(u => u.Category == "cricket" && u.Visibility == "show").ToList());
                         }

                    case "football":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.FileDatas.Where(u => u.Category == "football" && u.Visibility == "show").ToList());
                        }

                    case "hockey":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.FileDatas.Where(u => u.Category == "hockey" && u.Visibility == "show").ToList());
                        }
                    case "tennis":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.FileDatas.Where(u => u.Category == "tennis" && u.Visibility == "show").ToList());
                        }
                    case "badminton":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.FileDatas.Where(u => u.Category == "badminton" && u.Visibility == "show").ToList());
                        }
                    case "swimming":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.FileDatas.Where(u => u.Category == "swimming" && u.Visibility == "show").ToList());
                        }
                    default:
                        {

                            return Request.CreateErrorResponse(HttpStatusCode.BadRequest, "Category can only be cricket, football, baseball, badminton, tennis and swimming");
                        }


                }


            }

        }

        public HttpResponseMessage Get(int Id)
        {
            using (FileModelContainer fileModel = new FileModelContainer())
            {

                var entity = fileModel.FileDatas.FirstOrDefault(u => u.Id == Id);
                if (entity != null)
                {
                    return Request.CreateResponse(HttpStatusCode.OK, entity);

                }
                else {

                    return Request.CreateErrorResponse(HttpStatusCode.NotFound, "No such id exists");
                }

            }
        }

    }
}
