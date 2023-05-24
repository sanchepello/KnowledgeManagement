package com.example.knowledgemanagement;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class Authorization extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization);
    }

    public void adoutClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        AboutWindow myDialogFragment = new AboutWindow();
        myDialogFragment.show(manager, "myDialog");

    }

    public void openRegistration(View view) {
        startActivity(new Intent(this, Registration.class));
    }

    public void openMain(View view) {
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS users (login TEXT, password TEXT)");
        db.execSQL("insert or ignore into users values('sanchepello','qwerty');");

        TextView loginText = findViewById(R.id.loginText);
        String logina = loginText.getText().toString();
        TextView passwordText = findViewById(R.id.passwordText);
        String passworda = passwordText.getText().toString();

        if (logina.equals("") || passworda.equals("")) {
            Toast.makeText(getApplicationContext(), "Не все поля заполнены", Toast.LENGTH_SHORT).show();
        } else {
            Cursor query = db.rawQuery("SELECT * FROM users", null);

            while (query.moveToNext()) {
                String c1 = query.getString(0);
                String c2 = query.getString(1);


                if (c1.equals(logina)) {
                    if (c2.equals(passworda)) {
                        Toast.makeText(getApplicationContext(), "Вы успешно вошли", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, Main.class));
                    }  else {
                        Toast.makeText(getApplicationContext(), "неверный пароль", Toast.LENGTH_SHORT).show();
                    }
                    query.close();
                } else {
                    Toast.makeText(getApplicationContext(), "Такого пользователя нет", Toast.LENGTH_SHORT).show();
                }
                db.close();
            }
        }
    }
}