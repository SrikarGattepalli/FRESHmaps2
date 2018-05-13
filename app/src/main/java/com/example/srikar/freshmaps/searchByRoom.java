package com.example.srikar.freshmaps;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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
import java.util.Iterator;

/**
 * Class that allows the user to search for a room
 */
public class searchByRoom extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    /**
     * Method that is called in order to create the view and initialize the list of rooms
     *
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_by_name);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ListView byRoom = (ListView) findViewById(R.id.listViewTeacher);
        final ArrayList<String> teacherNames = new ArrayList<String>();
        teacherNames.addAll(Arrays.asList(getResources().getStringArray(R.array.roomArray)));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teacherNames);
        byRoom.setAdapter(adapter);
        byRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Method that is called when a room number is clicked and searches for the corresponding Room object
             * @param parent the adapter
             * @param view the view where the item was clicked
             * @param position the position in the list of the clicked item
             * @param id the id of the clicked item
             */
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
                String teachers = "";
                Room next = null;
                Iterator iter = a.iterator();
                while (iter.hasNext()) {
                    Room tra = (Room) iter.next();
                    if (tra.hasTwoRooms()) {
                        if (tra.getRoomNumber2().equals(clickedRoom) || tra.getRoomNumber1().equals(clickedRoom)) {
                            teachers += "[" + tra.getTeacher() + "] ";


                        }
                    } else {
                        if (tra.getRoomNumber1().equals(clickedRoom)) {
                            teachers += "[" + tra.getTeacher() + "] ";
                        }
                    }

                }


                Intent intent = new Intent(getApplicationContext(), Mapper.class);
                //based on item add info to intent


                String[] total = {clickedRoom + " is the classroom for the teacher(s): ", clickedRoom, teachers};
                intent.putExtra("total", total);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                startActivity(intent);


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
