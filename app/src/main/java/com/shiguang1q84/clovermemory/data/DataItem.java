package com.shiguang1q84.clovermemory.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DataItem{


    @PrimaryKey(autoGenerate = true)
    public int position;

    @ColumnInfo(name="head")
    public String head;
    @ColumnInfo(name="content")
    public String content;



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

    public int getPosition(){return position;}

}
