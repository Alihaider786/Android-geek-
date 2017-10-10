package com.pixelon.sportsapplication.Models;

/**
 * Created by ALi on 7/10/2017.
 */

public class RuleItem {

    private String tittle;
    private String description;
    private String pdfUrl;
    private String date;
    private String createdBy;


    public RuleItem(String tittle, String description, String pdfUrl, String date, String createdBy) {
        this.tittle = tittle;
        this.description = description;
        this.pdfUrl = pdfUrl;
        this.date = date;
        this.createdBy = createdBy;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
