package com.example.bilingualbook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        typeFace();
    }
    public void findViews(){
        txt_title = findViewById(R.id.txt_title);
    }
    //We use the typeface class to set the desired font for widgets.
    public void typeFace(){
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/brush.TTF");
        txt_title.setTypeface(typeface);
    }
    //Creating the menu.
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        menu.add(0, 1, 1, "about us");
        menu.add(0, 2, 2, "change Language");
        menu.add(0, 3, 3, "guide Book");
        return super.onCreateOptionsMenu(menu);
    }
}