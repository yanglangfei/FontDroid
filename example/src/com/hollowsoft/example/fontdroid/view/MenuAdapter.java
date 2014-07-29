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

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MenuAdapter extends FragmentPagerAdapter {

    private static final int AMOUNT = 13;

    private final Context context;

    public MenuAdapter(final FragmentManager fragmentManager, final Context context) {
        super(fragmentManager);

        this.context = context;
    }

    @Override
    public int getCount() {
        return AMOUNT;
    }

    @Override
    public Fragment getItem(final int position) {
        Fragment fragment;

        switch (position) {

        case 0:
            fragment = AutoCompleteTextViewFragment.instantiate(context,
                    AutoCompleteTextViewFragment.class.getName());
            break;

        case 1:
            fragment = ButtonFragment.instantiate(context, ButtonFragment.class.getName());

            break;

        case 2:
            fragment = CheckBoxFragment.instantiate(context, CheckBoxFragment.class.getName());

            break;

        case 3:
            fragment = CheckedTextViewFragment.instantiate(context, CheckedTextViewFragment.class.getName());

            break;

        case 4:
            fragment = ChronometerFragment.instantiate(context, ChronometerFragment.class.getName());

            break;

        case 5:
            fragment = DigitalClockFragment.instantiate(context, DigitalClockFragment.class.getName());

            break;

        case 6:
            fragment = EditTextFragment.instantiate(context, EditTextFragment.class.getName());

            break;

        case 7:
            fragment = MultiAutoCompleteTextViewFragment.instantiate(context,
                    MultiAutoCompleteTextViewFragment.class.getName());
            break;

        case 8:
            fragment = RadioButtonFragment.instantiate(context, RadioButtonFragment.class.getName());

            break;

        case 9:
            fragment = SwitchFragment.instantiate(context, SwitchFragment.class.getName());

            break;

        case 10:
            fragment = TextClockFragment.instantiate(context, TextClockFragment.class.getName());

            break;

        case 11:
            fragment = TextViewFragment.instantiate(context, TextViewFragment.class.getName());

            break;

        case 12:
            fragment = ToggleButtonFragment.instantiate(context, ToggleButtonFragment.class.getName());

            break;

        default:
            fragment = ButtonFragment.instantiate(context, ButtonFragment.class.getName());

            break;
        }

        return fragment;
    }
}
