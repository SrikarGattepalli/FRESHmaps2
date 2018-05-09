package com.example.srikar.freshmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class searchByRoom extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_by_name);

        ListView byRoom = (ListView) findViewById(R.id.listViewTeacher);
        final ArrayList<String> teacherNames = new ArrayList<String>();
        teacherNames.addAll(Arrays.asList(getResources().getStringArray(R.array.roomArray)));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teacherNames);
        byRoom.setAdapter(adapter);
        byRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedRoom = parent.getItemAtPosition((int) id).toString();
                School find = null;
                try {

                    find = new School(getAssets().open("teacherNames.txt"));
                } catch (IOException e) {
                    Log.d("ERROR!!!", e.getMessage());
                }
                find.sortArrayByRoom();
                ArrayList<Room> a = find.getTotalSchool();
                Room next = a.get(0);
                int first = 0;
                int last = a.size()-1;
                while(first<last){
                    if(last-first==1){
                        if(a.get(first).getRoomNumber().equals(clickedRoom)) {
                            next = a.get(first);
                            last = first;
                        }
                        else{
                            next=a.get(last);
                            last=first;
                        }
                    }
                    int mid = (first+last)/2;
                    if(a.get(mid).getRoomNumber().equals(clickedRoom)){
                        next = a.get(mid);
                        break;
                    }
                    else if(a.get(mid).getRoomNumber().compareTo(clickedRoom)<0){
                        first = mid;
                    }
                    else{
                        last = mid;
                    }
                }
                Intent intent = new Intent(getApplicationContext(), Mapper.class);
                //based on item add info to intent

                if(clickedRoom.equals("GYM")){
                    String gym="";
                    for(Room r: a){
                        if(r.getRoomNumber().equals("GYM")){
                            gym+= "["+r.getTeacher()+"] ";
                        }
                    }
                    intent.putExtra("total", clickedRoom + " is the classroom for the teachers: " +gym);
                }
                else{
                    intent.putExtra("total", clickedRoom + " is the classroom for the teacher: " + next.getTeacher());
                }
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

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
