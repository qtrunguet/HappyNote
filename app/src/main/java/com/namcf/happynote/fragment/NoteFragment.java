package com.namcf.happynote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.namcf.happynote.R;

/**
 * Created by linuxlord on 4/26/17.
 */

public class NoteFragment extends Fragment{

    private TextView date;
    private EditText edtTitle;
    private EditText editNote;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);




        return view;
    }
}