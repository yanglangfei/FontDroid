package com.hollowsoft.example.fontdroid.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hollowsoft.example.fontdroid.R;

public class ToggleButtonFragment extends Fragment {

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstance) {
        return inflater.inflate(R.layout.toggle_button_fragment, container, false);
    }
}