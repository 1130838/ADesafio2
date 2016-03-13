package com.brunodevesa.adesafio2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brunodevesa.adesafio2.R;

/**
 * Created by brunodevesa on 13/03/16.
 */
public class FragmentTwo extends Fragment {

    TextView tv_fragment_two;
    Context mContext;
    LinearLayout mLinearLayout;

    int counter_fragment_two = 1;

    public FragmentTwo() {
        // required
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.fragment_two_id);

        tv_fragment_two = (TextView) view.findViewById(R.id.tv_fragment_two);

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
            // important
            String tv_fragment_two_format = getResources().getString(R.string.tv_fragment_two);
            String tv_fragment_two_msg = String.format(tv_fragment_two_format, counter_fragment_two);
            tv_fragment_two.setText(String.valueOf(tv_fragment_two_msg));

            counter_fragment_two++;

            if (!isVisibleToUser) {
                Log.d("MyFragment", "Not visible anymore");
                counter_fragment_two--; // ask teacher : how do i stop the fragment to not update its thing ?
            }
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }
}
