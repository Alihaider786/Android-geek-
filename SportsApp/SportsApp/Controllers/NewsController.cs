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
    public class NewsController : ApiController
    {

        public HttpResponseMessage Get(String category = "All")
        {
            using (FileModelContainer fileModel = new FileModelContainer())
            {
                switch (category.ToLower())
                {
                    case "all":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.NewsDatas.ToList());
                        }

                 

                    case "hockey":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.NewsDatas.Where(u => u.Category == "hockey").ToList());
                        }
                    case "tennis":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.NewsDatas.Where(u => u.Category == "tennis").ToList());
                        }
                    case "badminton":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.NewsDatas.Where(u => u.Category == "badminton").ToList());
                        }
                    case "swimming":
                        {

                            return Request.CreateResponse(HttpStatusCode.OK, fileModel.NewsDatas.Where(u => u.Category == "swimming").ToList());
                        }
                    default:
                        {

                            return Request.CreateErrorResponse(HttpStatusCode.BadRequest, "Category can only be baseball, badminton, tennis and swimming");
                        }


                }


            }

        }

        public HttpResponseMessage Get(int Id)
        {
            using (FileModelContainer fileModel = new FileModelContainer())
            {

                var entity = fileModel.NewsDatas.FirstOrDefault(u => u.Id == Id);
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