package com.example.srikar.freshmaps;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Tab that holds the information for a Liaison schedule at EVHS
 */
public class Tab3Liaison extends Fragment {

    String periodItems[] = {"Period 1", "Period 2", "Period 3", "Break", "4th Period", "Liaison",
            "5th Period", "Lunch", "6th Period", "7th Period"};

    String periodTimes[] = {"7:15 – 8:10", "8:15 – 9:10", "9:15 – 10:05", "10:05 – 10:20",
            "10:25 – 11:15", "11:20 – 11:50",
            "11:50 - 12:40", "12:40 – 1:10", "1:15 – 2:05",
            "2:10‐3:00"};

    /**
     * Method that creates the tab within the appropiate view
     *
     * @param inflater           manipulator of XML layouts
     * @param container          the view group where the tab witll be located
     * @param savedInstanceState the state of the app
     * @return the tab view of the schedule
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1regular, container, false);


        ListView listView = (ListView) view.findViewById(R.id.regularMenu);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        return view;
    }

    /**
     * Class that reads the arrays that hold the information on the schedule
     */
    class CustomAdapter extends BaseAdapter {
        /**
         * Getter methiod for the length of the array
         *
         * @return the length of the read in array
         */
        @Override
        public int getCount() {
            return periodItems.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        /**
         * Method that sets the text of the view to the schedule
         *
         * @param position    the position of the wanted period and time
         * @param convertView the view where the text will be set
         * @param parent      the group of views where the view is located
         * @return the view with the updated text to fit the schedule
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.period_layout, null);
            TextView periodView = (TextView) view.findViewById(R.id.periodMenu);
            TextView timeView = view.findViewById(R.id.timeMenu);

            periodView.setText(periodItems[position]);
            timeView.setText(periodTimes[position]);
            return view;
        }
    }


}