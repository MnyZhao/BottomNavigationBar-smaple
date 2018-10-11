package com.mny.navbar;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * app:itemIconTint="@drawable/ischeck" 设置icon 颜色 在xml中
 * app:itemTextColor="@drawable/ischeck" 设置文字颜色 在xml中
 * 也可以通过ColorStateList来设置
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ViewPager mVP;
    BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    mVP.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    mVP.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    mVP.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mVP = findViewById(R.id.viewPager);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance("主页"));
        fragments.add(BlankFragment.newInstance("仪表盘"));
        fragments.add(BlankFragment.newInstance("通知"));
        mVP.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments));
        mVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                /*将menu item 选中  会触发OnNavigationItemSelectedListener*/
                navigation.setSelectedItemId(navigation.getMenu().getItem(i).getItemId());
                /*将menu item 设置为选中状态不会触发OnNavigationItemSelectedListener*/
//                navigation.getMenu().getItem(i).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
