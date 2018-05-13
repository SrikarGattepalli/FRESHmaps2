package com.example.srikar.freshmaps;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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

/**
 * Class that allows the user to search for a teacher form the list of all teachers
 */
public class searchByTeacher extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    @Override
    /**
     * Method that is called to create the view and initialize the list of teachers. Later, the method calls the Mapper activity to display the room for this teacher.
     * @param savedInstanceState initial state of the app
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_by_name);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ListView byTeacher = (ListView) findViewById(R.id.listViewTeacher);
        final ArrayList<String> teacherNames = new ArrayList<String>();
        teacherNames.addAll(Arrays.asList(getResources().getStringArray(R.array.teacherArray)));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teacherNames);
        byTeacher.setAdapter(adapter);
        byTeacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Handles the consecutive actions once a teacher's name is selected from the list.
             * @param parent
             *              - the adapter view that is used for thsi list view.
             * @param view
             *              - the exact view object that was clicked.
             * @param position
             *              - the position of the view/teacher's name that was clicked
             * @param id
             *              - the id of the view/teacher's name that was clicked.
             */
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
                int last = a.size() - 1;
                while (first < last) {
                    if (last - first == 1) {
                        if (a.get(first).getTeacher().equals(clickedName)) {
                            next = a.get(first);
                            last = first;
                        } else {
                            next = a.get(last);
                            last = first;
                        }
                    }
                    int mid = (first + last) / 2;
                    if (a.get(mid).getTeacher().equals(clickedName)) {
                        next = a.get(mid);
                        break;
                    } else if (a.get(mid).getTeacher().compareTo(clickedName) < 0) {
                        first = mid;
                    } else {
                        last = mid;
                    }
                }

                Intent intent = new Intent(getApplicationContext(), Mapper.class);
                String d = "";
                if (next.hasTwoRooms()) {
                    d = next.getRoomNumber1() + "/" + next.getRoomNumber2();
                } else {
                    d = next.getRoomNumber1();
                }
                String[] total = {clickedName + " is in room ", d, d};
                //based on item add info to intent
                intent.putExtra("total", total);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

    }

    /**
     * Method that creates a search bar and filters the items depending on input
     *
     * @param menu the menu
     * @return false if searching needs to continue, true otherwise
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            /**
             * Method that is called when enter is clicked
             * @param query the input in the search bar
             * @return false if successful
             */
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            /**
             * method that filters the search list
             * @param newText the text that has been inputted
             * @return false if successful
             */
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}
