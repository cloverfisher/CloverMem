package com.shiguang1q84.clovermemory.data;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;


@Database(entities = {DataItem.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract DataItemDao dataItemDao();
}
