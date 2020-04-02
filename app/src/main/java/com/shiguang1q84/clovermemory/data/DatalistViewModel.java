package com.shiguang1q84.clovermemory.data;

import android.app.Application;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DatalistViewModel extends AndroidViewModel {

    private LiveData<List<DataItem>> datalist;
    //private List<DataItem> dataItems;
    private AppDataBase db;
    private Application application;
    //TODO
    public DatalistViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
        db = Room.databaseBuilder(application.getApplicationContext(),AppDataBase.class,"mem.db").allowMainThreadQueries().build();
        if(db.dataItemDao()==null) {
            initDatabase();
        }
        DataItem tempDataItem = db.dataItemDao().getDataItemByPostion(4);
        datalist = db.dataItemDao().getAll();
   //     datalist.getValue().size();
        //db.dataItemDao().insertAll(dataItems);
    }

    public void initDatabase(){
        String filename = "defaultdata";
        try {
            InputStream is = application.getApplicationContext().getAssets().open(filename);//new FileInputStream(filename);
            readAsset(is);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void updateDataItem(DataItem dataItem){
        db.dataItemDao().updateDataItem(dataItem);
    }

//    public DatalistViewModel(){
//        this.getDatalist();
//    }

//    public DatalistViewModel(InputStream is){
//        this.getDatalist();
//        this.readAsset(is);
//    }

    public LiveData<List<DataItem>> getDatalist() {
        if(datalist == null){
            datalist=db.dataItemDao().getAll();
        }
        return datalist;
    }

    public int getSize(){
        if(datalist.getValue()!=null){
            return datalist.getValue().size();
        }
        else{
            return 0;
        }
        //return 10;
        //return  datalist.getValue().size();
    }

    public void setDatalist(MutableLiveData<List<DataItem>> datalist) {
        this.datalist = datalist;
    }


    private void readAsset(InputStream is){
        db.clearAllTables();
        //db.
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bfReader = new BufferedReader(isr);
            //dataItems = new ArrayList<>();
            int i = 0;
            while(bfReader.ready()){
                String temp  = bfReader.readLine();
                String[] tempStringArr = temp.split(":");
                db.dataItemDao().insertDataItem(new DataItem(tempStringArr[0],tempStringArr[1]));
                //dataItems.add(new DataItem(tempStringArr[0],tempStringArr[1]));
                i++;
            }
           // datalist.setValue(dataItems);
        } catch (IOException e) {
            e.printStackTrace();
        }
     //   DataItem tempItem = db.dataItemDao().getDataItemByPostion(3);
     //   Log.e("viewmodel", "DateItem3:" + tempItem.getHead());
    }

//    public void readAsset(AppDataBase db){
//        if(db.dataItemDao().getAll().get!=0){
//            datalist.setValue(db.dataItemDao().getAll());
//        }
//    }
}
