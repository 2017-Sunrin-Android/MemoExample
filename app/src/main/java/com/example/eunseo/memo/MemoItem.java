package com.example.eunseo.memo;

/**
 * Created by eunseo on 2017-09-21.
 */

public class MemoItem {
    private String title;
    private String content;

    public MemoItem(String title, String content){
        this.title=title;
        this.content=content;
    }

    public String getTitle(){ return title; }
    public String getContent(){ return content; }
}
