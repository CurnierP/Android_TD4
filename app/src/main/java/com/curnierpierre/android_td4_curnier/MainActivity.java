package com.pierrecurnier.android_td4_curnier;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements NumberPickerFragment.OnActionListener {

    protected String mData;
    protected ViewPager mViewPager;
    protected ExamplePagerAdapter mExamplePagerAdapter;
    protected TextFragment fragText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initViewPager();
        this.initActionBar();
        this.listenerViewPager();
        fragText = new TextFragment();
    }

    public void onAction(String d) {
        fragText.setValueTextView(d);
    }

    protected void initActionBar(){
        final ActionBar actionBar = getSupportActionBar();
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                // show the given tab

                mViewPager.setCurrentItem(tab.getPosition());
            }
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // hide the given tab
            }
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
                // probably ignore this event
            }
        };
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Text")
                        .setTabListener(tabListener));
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Num")
                        .setTabListener(tabListener));

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // Create a tab listener that is called when the user changes tabs.
    }

    protected void initViewPager(){
        this.mExamplePagerAdapter = new ExamplePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mExamplePagerAdapter);
    }

    protected void listenerViewPager(){
        mViewPager.setOnPageChangeListener(
            new ViewPager.SimpleOnPageChangeListener() {
                @Override
                public void onPageSelected(int position) {
                    getSupportActionBar().setSelectedNavigationItem(position);

                }
            });
    }
    class ExamplePagerAdapter extends FragmentStatePagerAdapter {

        public ExamplePagerAdapter(FragmentManager fm) {
            super(fm);

        }
        @Override
        public Fragment getItem(int i) {
            switch(i){
                case 0 : return fragText;
                case 1 : return new NumberPickerFragment();
                default: return new MyFragment();
            }
        }
        @Override
        public int getCount(){
            //le nombre d’onglet
            return 2;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return "myFrag";
        }


    }

}



