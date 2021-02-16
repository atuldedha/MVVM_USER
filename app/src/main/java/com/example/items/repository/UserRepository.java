package com.example.items.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.items.dao.DaoClass;
import com.example.items.database.DatabaseClass;
import com.example.items.model.UserModel;

import java.util.List;

public class UserRepository {

    private DaoClass daoClass;
    private LiveData<List<UserModel>> model;
    private List<UserModel> userModelList;

    public UserRepository(Application application){

        DatabaseClass database = DatabaseClass.getDatabase(application);

        daoClass = database.getDao();

        model = daoClass.getData();

        userModelList = daoClass.getList();
    }

    public void insert(UserModel model){
        new InsertUserAsyncTask(daoClass).execute(model);
    }

    public LiveData<List<UserModel>> getData(){
        return model;
    }

    public List<UserModel> getList(){
        return userModelList;
    }

    private static class InsertUserAsyncTask extends AsyncTask<UserModel, Void, Void>{

        private DaoClass daoClass;

        private InsertUserAsyncTask(DaoClass daoClass){
            this.daoClass = daoClass;
        }

        @Override
        protected Void doInBackground(UserModel... userModels) {

            daoClass.addData(userModels[0]);

            return null;
        }
    }

}
