package com.shiguang1q84.clovermemory.data;

public class DataItem  implements  DataInterface{

    String head;
    String context;



    public DataItem(String head, String context){
        this.head = head;
        this.context = context;
    }

    @Override
    public String getHead() {
        return head;
    }

    @Override
    public String getContext() {
        return context;
    }
}
