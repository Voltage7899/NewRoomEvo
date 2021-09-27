package com.company.roomdb.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    List<User> getAllUser();

    @Insert
    void insertUser(User user);

    @Delete
    void DeleteUser(User user);

}
