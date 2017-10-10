package com.pixelon.sportsapplication.Models;

/**
 * Created by ALi on 7/5/2017.
 */

public class NewsItem {

    private String imageUrl;
    private String author;
    private String tittle;
    private String descp;
    private String newsType;
    private String detailUrl;


    public NewsItem(String imageUrl, String author, String tittle, String descp, String newsType, String detailUrl) {
        this.imageUrl = imageUrl;
        this.author = author;
        this.tittle = tittle;
        this.descp = descp;
        this.newsType = newsType;
        this.detailUrl = detailUrl;
    }


    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }
}
