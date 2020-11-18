package com.aefottt.redrock_fifthwork;

public class RvAdapterBean {
    String title;
    String content;
    int imgId;

    public RvAdapterBean(String title, String content, int imgId) {
        this.title = title;
        this.content = content;
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
