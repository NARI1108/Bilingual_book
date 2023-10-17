package com.example.bilingualbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    TextView txt_title;
    ListView list_View;
//    Creating an array to store the title of the items in the list view.
    String [] array_items = new String[9];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        typeFace();
        arrayItems();
        adapter();
        click();
    }
//    Connecting an XML layer to this main layer (Main Activity.java).
    public void findViews(){
        txt_title = findViewById(R.id.txt_title);
        list_View = findViewById(R.id.list_view);
    }
//    Creating and initializing the adapter for the list view and connecting it to the list view.
    public void adapter(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.row_items,R.id.txt_index,array_items);
        list_View.setAdapter(adapter);
    }
//    We use the typeface class to set the desired font for widgets.
    public void typeFace(){
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/brush.TTF");
        txt_title.setTypeface(typeface);
    }
//    Creating the menu.
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
//        Creating menu option items.
        menu.add(0, 1, 1,getResources().getString(R.string.about_us));
        menu.add(0, 2, 2,getResources().getString(R.string.guide_book));
//      Create a submenu with its own sub-menu items.
        SubMenu subMenu = menu.addSubMenu(0,3,3,getResources().getString(R.string.change_lan));
        subMenu.add(1,4,1,"English");
        subMenu.add(1,5,2,"فارسی");

        return super.onCreateOptionsMenu(menu);
    }
//       The click method on each of the menu items.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
//        It takes the ID of each item to identify them.
        int id = item.getItemId();
//        By typing a conditional switch case command, we specify what to do by clicking on each item.
        switch (id){
            case 1: setContentView(R.layout.activity_about_us);
                break;
            case 2: setContentView(R.layout.activity_help);
                break;
            case 4: setLocal("EN");
                startActivity(new Intent(MainActivity.this,MainActivity.class)); finish();
                break;
            case 5: setLocal("FA");
                startActivity(new Intent(MainActivity.this,MainActivity.class)); finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
        public void arrayItems(){
//        Array quantization of story list.
        array_items[0] = getResources().getString(R.string.chart_1);
        array_items[1] = getResources().getString(R.string.chart_2);
        array_items[2] = getResources().getString(R.string.chart_3);
        array_items[3] = getResources().getString(R.string.chart_4);
        array_items[4] = getResources().getString(R.string.chart_5);
        array_items[5] = getResources().getString(R.string.chart_6);
        array_items[6] = getResources().getString(R.string.chart_7);
        array_items[7] = getResources().getString(R.string.chart_8);
        array_items[8] = getResources().getString(R.string.chart_9);
    }
    public void click(){
//        Defining click event for view list items.
        list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//             Because only 4 stories have been completed, we made a condition that if the 4th story is clicked on, show a message to the user.
               if(position<4){
                   intent = new Intent(MainActivity.this,story.class);
//                 Transferring the position of each item to the next activity to identify the owners.
                   intent.putExtra("pos",position);
                   startActivity(intent);
               }else {
                   Toast.makeText(getApplicationContext(), getResources().getString(R.string.coming_soon), Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
//    The method of changing the locale of the program to change the language of the app to other languages.
    private void setLocal(String language){
        Locale myLocale = new Locale(language);
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = myLocale;
        DisplayMetrics displayMetrics =resources.getDisplayMetrics();
        resources.updateConfiguration(configuration,displayMetrics);
    }
}