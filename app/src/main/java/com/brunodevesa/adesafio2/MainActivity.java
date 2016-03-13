package com.brunodevesa.adesafio2;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.brunodevesa.adesafio2.adapters.MyPagerAdapter;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    MyPagerAdapter mMyPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager_id);

        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mMyPagerAdapter);

        viewPager.addOnPageChangeListener(this);


        viewPager.setOffscreenPageLimit(0);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Fragment fragment = mMyPagerAdapter.getFragment(position);
        if (fragment != null) {
            fragment.onResume();
            fragment.setUserVisibleHint(false);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
