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
public class FragmentOne extends Fragment{

    TextView tv_fragment_one;
    Context mContext;
    LinearLayout mLinearLayout;

    int counter_fragment_one = 1;

    public FragmentOne() {
        // required
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        mLinearLayout = (LinearLayout)view.findViewById(R.id.fragment_one_id);

        tv_fragment_one = (TextView)view.findViewById(R.id.tv_fragment_one);

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
            String tv_fragment_one_format = getResources().getString(R.string.tv_fragment_one);
            String tv_fragment_one_msg = String.format(tv_fragment_one_format, counter_fragment_one);
            tv_fragment_one.setText(String.valueOf(tv_fragment_one_msg));
            counter_fragment_one++;


            if (!isVisibleToUser) {
                Log.d("MyFragment", "Not visible anymore. ");
                // TODO stop audio playback
                counter_fragment_one--;
            }
        }
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }


    public static FragmentOne newInstance(){
        return new FragmentOne();
    }

}
