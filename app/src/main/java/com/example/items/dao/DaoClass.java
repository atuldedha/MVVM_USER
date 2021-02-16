package com.example.items.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.items.model.UserModel;

import java.util.List;

@Dao
public interface DaoClass {

    @Insert
    void addData(UserModel model);

    @Query("select * from user")
    LiveData<List<UserModel>> getData();

    @Query("select * from user")
    List<UserModel> getList();

}
