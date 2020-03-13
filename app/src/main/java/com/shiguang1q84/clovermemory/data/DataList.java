package com.shiguang1q84.clovermemory.data;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataList {

    //Map<String,String> datalist = new HashMap<>();

    List<DataItem> datalist = new ArrayList<>();
    Context context;

    public DataList(Context context){
        this.context = context;
        createDataList();

    }

    public void createDataList(){
        datalist.clear();
        readAsset();
    }

    private void readAsset() {
        String filename = "defaultdata";
        try {
            InputStream is = context.getAssets().open(filename);//new FileInputStream(filename);
            //DataInputStream datais = new DataInputStream(is);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bfReader = new BufferedReader(isr);
            while(bfReader.ready()){
                String temp  = bfReader.readLine();
                String[] tempStringArr = temp.split(":");
                datalist.add(new DataItem(tempStringArr[0],tempStringArr[1]));
            }


            //datais.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataItem getDataItem(int position){
        return datalist.get(position);
    }
    public int getLength(){
        return datalist.size();
    }
    public  List getDatalist() {
        return datalist;
    }


}
