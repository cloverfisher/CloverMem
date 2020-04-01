package com.shiguang1q84.clovermemory.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataItemDao {

    @Query("SELECT * FROM DATAITEM")
    LiveData<List<DataItem>> getAll();

    @Query("SELECT * FROM DATAITEM WHERE position LIKE :position ")
    DataItem getDataItemByPostion(int position);

    @Update
    void updateDataItem(DataItem... dataItem);

    @Insert
    void insertDataItem(DataItem... dataItem);

    @Insert
    void insertAll(List<DataItem> dataItems);

    @Delete
    void delete(DataItem dataItem);


}
