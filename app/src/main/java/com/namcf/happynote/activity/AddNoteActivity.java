package com.namcf.happynote.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.namcf.happynote.R;
import com.namcf.happynote.fragment.NoteFragment;

/**
 * Created by linuxlord on 4/26/17.
 */

public class AddNoteActivity extends FragmentActivity {

    private ImageView btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.init();
        this.initNoteFragment();


    }

    public void init(){
        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initNoteFragment(){
        Fragment fgNote = new NoteFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container, fgNote, "NOTE")
                .addToBackStack(null)
                .commit();
    }
}
