package com.example.deeksha.newsappppp.model;

/**
 * Created by deeksha on 6/27/2017.
 */
 public class NewsItem {

    private String author,title,description;
    private String urlToImage;
    private String url;
    private String publishedAt;

    public NewsItem()
    {
        
    }
    public NewsItem(String title, String description,String publishedAt, String url){
        this.title= title;
        this.description = description;
        this.publishedAt=publishedAt;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }
}
