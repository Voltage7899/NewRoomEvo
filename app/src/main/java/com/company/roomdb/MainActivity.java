package com.company.roomdb;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.company.roomdb.RoomDB.Database;
import com.company.roomdb.RoomDB.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

private Button button;
private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.show);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,add_new_user.class),100);
            }
        });

        initRecyclerView();
        loadUserList();

    }
    private void loadUserList(){
        Database database = Database.getInstance(this.getApplicationContext());
       List<User> userList= database.userDAO().getAllUser();
       userListAdapter.setUserList(userList);

    }
    private void initRecyclerView(){
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        userListAdapter=new UserListAdapter(getApplicationContext());
        recyclerView.setAdapter(userListAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==100){
            loadUserList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}