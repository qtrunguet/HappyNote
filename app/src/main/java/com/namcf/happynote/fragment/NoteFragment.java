package com.namcf.happynote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.namcf.happynote.R;
import com.namcf.happynote.objects.MyNote;

/**
 * Created by linuxlord on 4/26/17.
 */

public class NoteFragment extends Fragment{

    public static String CLASS_NAME = "NoteFragment";

    private TextView date;
    private EditText edtTitle;
    private EditText edtNote;

    private Spinner spnDay, spnTime;
    private TextView btnAlarm;

    private ImageView btnDeleteAlarm;
    private LinearLayout liner;

    private MyNote myNote;

    public NoteFragment(MyNote myNote) {
        this.myNote = myNote;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);

        date = (TextView) view.findViewById(R.id.tvDate);
        edtTitle = (EditText) view.findViewById(R.id.edtTitle);
        edtNote = (EditText) view.findViewById(R.id.edtNote);
        liner = (LinearLayout) view.findViewById(R.id.linerNote);

        date.setText(myNote.getDate());
        edtTitle.setText(myNote.getTitle());
        edtNote.setText(myNote.getNote());
        liner.setBackgroundColor(ContextCompat.getColor(getActivity(), myNote.getColor()));

        spnDay = (Spinner) view.findViewById(R.id.spnDay);
        spnTime = (Spinner) view.findViewById(R.id.spnTime);

        edtNote = (EditText) view.findViewById(R.id.edtNote);
        edtTitle = (EditText) view.findViewById(R.id.edtTitle);


        btnDeleteAlarm = (ImageView) view.findViewById(R.id.btnDeleteAlarm);
        btnDeleteAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                offAlarm();
            }
        });

        btnAlarm = (TextView) view.findViewById(R.id.btnAlarm);
        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAlarm();
            }
        });

        return view;
    }

    public void onAlarm() {
        btnAlarm.setVisibility(View.GONE);
        spnDay.setVisibility(View.VISIBLE);
        spnTime.setVisibility(View.VISIBLE);
        btnDeleteAlarm.setVisibility(View.VISIBLE);
    }

    public void offAlarm() {
        btnAlarm.setVisibility(View.VISIBLE);
        spnDay.setVisibility(View.GONE);
        spnTime.setVisibility(View.GONE);
        btnDeleteAlarm.setVisibility(View.GONE);
    }

    public MyNote getMyNote(){
        String title = edtTitle.getText().toString();
        myNote.setTitle(title.equals("") ? "UnTitle" : title);
        myNote.setNote(edtNote.getText().toString());
        myNote.setDate(date.getText().toString());
        return myNote;
    }

    public boolean checkInput() {
        if (edtNote.getText().toString().equals("")) {
            Toast.makeText(getContext(), "Chua nhap noi dung!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public LinearLayout getLayoutParent(){
        return liner;
    }

}
