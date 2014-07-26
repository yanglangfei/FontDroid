/*
 * Copyright (c) 2014 HollowSoft @Igor Morais
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 *
 *          You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hollowsoft.example.fontdroid.view;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.hollowsoft.example.fontdroid.R;

/**
 * @author Igor Morais
 * @author Mor41s.1gor@gmail.com
 */
public final class MainScreen extends FragmentActivity implements TabListener, OnPageChangeListener {

    private ActionBar actionBar;

    private ViewPager viewPager;

    @Override
    protected void onCreate(final Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.main_screen);

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        viewPager = (ViewPager) findViewById(R.id.main_screen_menu_view_pager);
        viewPager.setAdapter(new MenuAdapter(getSupportFragmentManager(), this));
        viewPager.setOnPageChangeListener(this);

        for (final String name : getResources().getStringArray(R.array.menu)) {
            actionBar.addTab(actionBar.newTab().setText(name).setTabListener(this));
        }
    }

    @Override
    public void onTabReselected(final Tab tab, final FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabSelected(final Tab tab, final FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(final Tab tab, final FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onPageScrollStateChanged(final int state) {

    }

    @Override
    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(final int position) {
        actionBar.setSelectedNavigationItem(position);
    }
}
