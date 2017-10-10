package com.pixelon.sportsapplication.Models;

/**
 * Created by ALi on 4/18/2017.
 */

public class CategoryItem {

   private String listTittle;
    private  String listDetail;
   //  private  int listThumbnail;

public CategoryItem(String listTittle, String listDetail )
    {
    this.listTittle = listTittle;
    this.listDetail = listDetail;
   // this.listThumbnail = listThumbnail;
    }


    public String getListDetail() {
        return listDetail;
    }

    public void setListDetail(String listDetail) {
        this.listDetail = listDetail;
    }


    public String getListTittle() {
        return listTittle;
    }

    public void setListTittle(String listTittle) {
        this.listTittle = listTittle;
    }
}
