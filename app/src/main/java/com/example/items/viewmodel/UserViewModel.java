package com.example.items.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.items.model.UserModel;
import com.example.items.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    private LiveData<List<UserModel>> allUsers;
    private List<UserModel> userModelList;

    public UserViewModel(@NonNull Application application) {
        super(application);

        repository = new UserRepository(application);

        allUsers = repository.getData();

        userModelList = repository.getList();

    }

    public void insert(UserModel model){
        repository.insert(model);
    }

    public LiveData<List<UserModel>> getData(){
        return allUsers;
    }

    public List<UserModel> getList(){
        return userModelList;
    }

}
