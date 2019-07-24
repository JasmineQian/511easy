package com.example.demo.bean;

public class Image {


    private long id;
    private String hostname;
    private String url;
    private String newname;
    private String originalname;
    private String creationdt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNewname() {
        return newname;
    }

    public void setNewname(String newname) {
        this.newname = newname;
    }

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname;
    }

    public String getCreationdt() {
        return creationdt;
    }

    public void setCreationdt(String creationdt) {
        this.creationdt = creationdt;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", hostname='" + hostname + '\'' +
                ", url='" + url + '\'' +
                ", newname='" + newname + '\'' +
                ", originalname='" + originalname + '\'' +
                ", creationdt='" + creationdt + '\'' +
                '}';
    }
}
