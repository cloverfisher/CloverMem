package com.shiguang1q84.clovermemory.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DataItem{


    @PrimaryKey(autoGenerate = true)
    private int position;

    @ColumnInfo(name="head")
    private String head;
    @ColumnInfo(name="content")
    private String content;

    public void setPosition(int position) {
        this.position = position;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public DataItem(String head, String content){
        this.head = head;
        this.content = content;
    }

    public String getHead() {
        return head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String contentStr){
        this.content = contentStr;
    }

    public int getPosition(){return position;}

}
