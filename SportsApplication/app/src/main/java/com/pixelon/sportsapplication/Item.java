package com.pixelon.sportsapplication;

/**
 * Created by ALi on 4/18/2017.
 */

public class Item  {

   private String listTittle;
    private  String listDetail;
     private  int listThumbnail;

public  Item(String listTittle, String listDetail, int listThumbnail )
    {
    this.listTittle = listTittle;
    this.listDetail = listDetail;
    this.listThumbnail = listThumbnail;
    }


    public String getListDetail() {
        return listDetail;
    }

    public void setListDetail(String listDetail) {
        this.listDetail = listDetail;
    }

    public int getListThumbnail() {
        return listThumbnail;
    }

    public void setListThumbnail(int listThumbnail) {
        this.listThumbnail = listThumbnail;
    }

    public String getListTittle() {
        return listTittle;
    }

    public void setListTittle(String listTittle) {
        this.listTittle = listTittle;
    }
}
