package com.brunodevesa.adesafio2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.brunodevesa.adesafio2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brunodevesa on 13/03/16.
 */
public class FragmentThree extends Fragment {

    TextView tv_fragment_three;
    Context mContext;
    LinearLayout mLinearLayout;

    ArrayAdapter<String> adapter;

    ListView mListView;
    int counter_fragment_three = 1;

    List<String> things;

    public FragmentThree() {
        // required
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        things = new ArrayList<>();
        things.add("First thing");
        adapter = new ArrayAdapter<>(this.mContext, android.R.layout.simple_list_item_1, things);


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);

        mLinearLayout = (LinearLayout) view.findViewById(R.id.fragment_three_id);
        mListView = (ListView) view.findViewById(R.id.listView);
        tv_fragment_three = (TextView) view.findViewById(R.id.tv_fragment_three);

        mListView.setAdapter(adapter);

        registerForContextMenu(mListView); // importante o registo !!

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // Make sure that we are currently visible
        if (this.isVisible()) {
            // important:
            things.add(counter_fragment_three, "thing #" + counter_fragment_three);
            adapter.notifyDataSetChanged();

            String tv_fragment_three_format = getResources().getString(R.string.tv_fragment_one);
            String tv_fragment_three_msg = String.format(tv_fragment_three_format, counter_fragment_three);
            tv_fragment_three.setText(String.valueOf(tv_fragment_three_msg));

            counter_fragment_three++;



            if (!isVisibleToUser) {
                Log.d("MyFragment", "Not visible anymore.");
                counter_fragment_three--;
                things.remove(counter_fragment_three);
            }
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


    public static FragmentThree newInstance() {
        return new FragmentThree();
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch(item.getItemId()) {
            case R.id.share:
                Toast.makeText(mContext, "Sharing", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(mContext, "Deleting", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        getActivity().getMenuInflater().inflate(R.menu.context_menu, menu);
    }




}
