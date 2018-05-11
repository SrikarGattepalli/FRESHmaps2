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


public class Tab1Regular extends Fragment{

    String periodItems[] = {"Period 1", "Period 2", "Period 3", "Break", "4th Period",
                            "5th Period", "Lunch", "6th Period", "7th Period"};

    String periodTimes[] = {"7:15 – 8:10", "8:15 – 9:15", "9:20 – 10:15", "10:15 – 10:30",
                            "10:35 – 11:30", "11:35 – 12:30","12:30 – 1:00", "1:05 – 2:00",
                            "2:05‐3:00"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1regular, container, false);


        ListView listView = (ListView)view.findViewById(R.id.regularMenu);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

//        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
//                getActivity(),
//                android.R.layout.simple_list_item_1,
//                periodItems
//        );
//
//        listView.setAdapter(listViewAdapter);

        return view;
    }

    class CustomAdapter extends BaseAdapter{

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
