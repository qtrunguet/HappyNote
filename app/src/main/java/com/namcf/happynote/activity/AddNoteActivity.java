package com.namcf.happynote.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.namcf.happynote.R;
import com.namcf.happynote.fragment.NoteFragment;
import com.namcf.happynote.objects.MyNote;
import com.namcf.happynote.objects.ToolBarController;

/**
 * Created by linuxlord on 4/26/17.
 */

public class AddNoteActivity extends FragmentActivity {

    private ImageView btnBack, btnSave, btnGrid, btnCamera;
    private Fragment fgNote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.initFgNote();
        this.init();

    }

    public void initFgNote(){
        fgNote = new NoteFragment(new MyNote());
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, fgNote, NoteFragment.CLASS_NAME).commit();
    }

    public void addNote() {
        MyNote n = ((NoteFragment)fgNote).getMyNote();
        MainActivity.addNote(n);
        MainActivity.refreshList();
    }

    public void init() {
        btnBack = (ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSave = (ImageView) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((NoteFragment)fgNote).checkInput()){
                    return;
                }
                addNote();
                finish();
            }
        });

        btnGrid = (ImageView) findViewById(R.id.btnGrid);
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyNote myNote = ((NoteFragment)fgNote).getMyNote();
                LinearLayout liner = ((NoteFragment)fgNote).getLayoutParent();
                ToolBarController.selectColorLayout(AddNoteActivity.this, myNote, liner);
            }
        });
    }

}
