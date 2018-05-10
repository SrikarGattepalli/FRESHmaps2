package com.example.srikar.freshmaps;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.8F);
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button schedule = findViewById(R.id.bellSchedule);
        final Button name = (Button) findViewById(R.id.searchByTeacher);
        final Button room = (Button) findViewById(R.id.searchByRoom);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schedule.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), bellSchedule.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

        });
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                room.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), searchByRoom.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.startAnimation(buttonClick);
                Intent startIntent = new Intent(getApplicationContext(), searchByTeacher.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        ListView byTeacher = (ListView) findViewById(R.id.listViewTeacher);
        final ArrayList<String> teacherNames = new ArrayList<String>();
        teacherNames.addAll(Arrays.asList(getResources().getStringArray(R.array.teacherArray)));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teacherNames);
        byTeacher.setAdapter(adapter);
        byTeacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedName = parent.getItemAtPosition((int) id).toString();
                School find = null;
                try {

                    find = new School(getAssets().open("teacherNames.txt"));
                } catch (IOException e) {
                    Log.d("ERROR!!!", e.getMessage());
                }
                find.sortArraybyTeacher();
                ArrayList<Room> a = find.getTotalSchool();
                Room next = a.get(0);
                int first = 0;
                int last = a.size()-1;
                while(first<last){
                    if(last-first==1){
                        if(a.get(first).getTeacher().equals(clickedName)) {
                            next = a.get(first);
                            last = first;
                        }
                        else{
                            next=a.get(last);
                            last=first;
                        }
                    }
                    int mid = (first+last)/2;
                    if(a.get(mid).getTeacher().equals(clickedName)){
                        next = a.get(mid);
                        break;
                    }
                    else if(a.get(mid).getTeacher().compareTo(clickedName)<0){
                        first = mid;
                    }
                    else{
                        last = mid;
                    }
                }

                Intent intent = new Intent(getApplicationContext(), Mapper.class);
                //based on item add info to intent
                intent.putExtra("total", clickedName + " is in room " + next.getRoomNumber());
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) findViewById(R.id.listViewTeacherSearch);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    }



