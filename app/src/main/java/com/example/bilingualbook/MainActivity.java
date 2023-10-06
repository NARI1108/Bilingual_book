package com.example.bilingualbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

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
        //Creating menu option items.
        menu.add(0, 1, 1,getResources().getString(R.string.about_us));
        menu.add(0, 2, 2,getResources().getString(R.string.change_lan));
        menu.add(0, 3, 3,getResources().getString(R.string.guide_book));
        return super.onCreateOptionsMenu(menu);
    }
    //The click method on each of the menu items.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        //It takes the ID of each item to identify them.
        int id = item.getItemId();
        //By typing a conditional switch case command, we specify what to do by clicking on each item.
        switch (id){
            case 1: new AlertDialog.Builder(this).setTitle("about us").setMessage(getResources().getString(R.string.hello_world)).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.change_lan), Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.guide_book), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}