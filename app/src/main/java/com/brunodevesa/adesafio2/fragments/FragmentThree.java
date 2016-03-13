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
public class FragmentThree extends Fragment{


    TextView tv_fragment_three;
    Context mContext;
    LinearLayout mLinearLayout;

    int counter_fragment_three = 1;

    public FragmentThree() {
        // required
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        mLinearLayout = (LinearLayout)view.findViewById(R.id.fragment_three_id);

        tv_fragment_three = (TextView)view.findViewById(R.id.tv_fragment_three);

        return  view;

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

            String tv_fragment_three_format = getResources().getString(R.string.tv_fragment_one);
            String tv_fragment_three_msg = String.format(tv_fragment_three_format, counter_fragment_three);
            tv_fragment_three.setText(String.valueOf(tv_fragment_three_msg));

            counter_fragment_three++;


            if (!isVisibleToUser) {
                Log.d("MyFragment", "Not visible anymore.");
                // TODO stop audio playback
                counter_fragment_three--;
            }
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


    public static FragmentThree newInstance(){
        return new FragmentThree();
    }

}
