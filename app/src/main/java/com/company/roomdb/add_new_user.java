package com.company.roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.company.roomdb.RoomDB.Database;
import com.company.roomdb.RoomDB.User;
import com.company.roomdb.databinding.ActivityAddNewUserBinding;

public class add_new_user extends AppCompatActivity {


    private ActivityAddNewUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_new_user);

        binding = ActivityAddNewUserBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(binding.name.getText().toString(),binding.lastname.getText().toString());
            }
        });

    }

    private void saveNewUser(String name, String last){
        Database database=Database.getInstance(this.getApplicationContext());
        User user =new User();
        user.firstName=name;
        user.lastName=last;
        database.userDAO().insertUser(user);

        finish();

    }
}