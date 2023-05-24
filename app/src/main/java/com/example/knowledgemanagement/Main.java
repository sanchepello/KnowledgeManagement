package com.example.knowledgemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    RecyclerView mRecycle;
    public List<Card> cards = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mRecycle = findViewById(R.id.posts);

        initializeData();
        initializeAdapter();
    }

    private void initializeAdapter() {
            RVAdapter adapter = new RVAdapter(cards);
            mRecycle.setAdapter(adapter);
    }

    private void initializeData() {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS posts (author TEXT, title TEXT, content TEXT)");


        Cursor query = db.rawQuery("Select * from posts", null);
        if(query != null) {
            while (query.moveToNext()) {
                String username = query.getString(0);
                String title = query.getString(1);
                String content = query.getString(2);

                cards.add(new Card (username, title, content));
            }

            query.close();
            db.close();
        }
    }


    public void addPost(View view) {
        startActivity(new Intent(this, AddPost.class));
    }

    public void accountCLick(View view) {
        startActivity((new Intent(this, Account.class)));
    }
    public void refresh(View view) {
        recreate();
        initializeData();
        initializeAdapter();
    }

}