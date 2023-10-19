package com.example.bilingualbook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class about_us extends AppCompatActivity {
    Button btn_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        findViews();
        buttonExit();
    }
    public void findViews(){
        btn_exit = findViewById(R.id.btn_exit);
    }
//    The onBackPressed() method in Android is used to control the function of the device's Back button.
    @Override
    public void onBackPressed() {
        buttonExit();

    }
//    This method is to exit the activity.
    void buttonExit(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}