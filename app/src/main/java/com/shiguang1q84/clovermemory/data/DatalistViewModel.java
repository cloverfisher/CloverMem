package com.shiguang1q84.clovermemory.data;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DatalistViewModel extends ViewModel {

    private static MutableLiveData<List<DataItem>> datalist;

    public DatalistViewModel(){
        this.getDatalist();
    }

    public DatalistViewModel(InputStream is){
        this.getDatalist();
        this.readAsset(is);
    }

    public MutableLiveData<List<DataItem>> getDatalist() {
        if(datalist == null){
            datalist=new MutableLiveData<List<DataItem>>();
        }
        return datalist;
    }

    public int getSize(){
        return  datalist.getValue().size();
    }

    public void setDatalist(MutableLiveData<List<DataItem>> datalist) {
        this.datalist = datalist;
    }


    public void readAsset(InputStream is){
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bfReader = new BufferedReader(isr);
            List<DataItem> dataItems = new ArrayList<>();
            while(bfReader.ready()){
                String temp  = bfReader.readLine();
                String[] tempStringArr = temp.split(":");
                dataItems.add(new DataItem(tempStringArr[0],tempStringArr[1]));
            }
            datalist.setValue(dataItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
