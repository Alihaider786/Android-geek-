package com.pixelon.sportsapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.pixelon.sportsapplication.CricketFragments.CricketHome;
import com.pixelon.sportsapplication.CricketFragments.CricketNews;
import com.pixelon.sportsapplication.CricketFragments.CricketRules;
import com.pixelon.sportsapplication.FootballFragments.FootballHome;
import com.pixelon.sportsapplication.FootballFragments.FootballNews;
import com.pixelon.sportsapplication.FootballFragments.FootballRules;

public class Football extends AppCompatActivity {

    private FootballPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
*/
    private ViewPager mViewPager;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);
       toolbar = (Toolbar)findViewById(R.id.toolbar_football);
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new FootballPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container_football);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_football);
        tabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cricket, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.

     /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class FootballPagerAdapter extends FragmentPagerAdapter {

        public FootballPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {


            switch (position)
            {
                case 0:
                    FootballHome home = new FootballHome();
                    return home;
                case 1:
                    FootballNews news = new FootballNews();
                    return news;
                case 2:
                    FootballRules rules = new FootballRules();
                    return rules;

                default:
                    return null;

            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "News";
                case 2:
                    return "Rules";

            }
            return null;
        }
    }
}
