package com.example.knowledgemanagement;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddPost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
    }

    public void backClick(View view) {
        onBackPressed();
    }

    public void addPost(View view) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS posts (author TEXT, title TEXT, content TEXT)");

        TextView titletext = findViewById(R.id.titleText);
        TextView contentText = findViewById(R.id.postText);

        String title = titletext.getText().toString();
        String content = contentText.getText().toString();

        db.execSQL("insert into posts values ('username','" + title + "','" + content+ "');");
    }
}