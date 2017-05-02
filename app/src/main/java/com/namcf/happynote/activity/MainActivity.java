package com.namcf.happynote.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.namcf.happynote.R;
import com.namcf.happynote.adapter.NoteAdapter;
import com.namcf.happynote.objects.MyNote;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView btnAdd;
    private GridView gridview;
    public static NoteAdapter adapter;
    public static ArrayList<MyNote> listNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hello world

        initListNote();
        initGridView();

        this.init();
      ///  GridView gridview = (GridView) findViewById(R.id.gridview);
       // gridview.setAdapter(new ImageAdapter (this));
    }

    public void init() {

        btnAdd = (ImageView) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    public  void initListNote() {
        listNote = new ArrayList<MyNote>();

        for (int i=0; i< 4; i++){
            MyNote n = new MyNote("Di hoc", "lam bai kiem tra", "09/02/2017");
            listNote.add(n);
        }
    }

    public  void initGridView() {
        gridview = (GridView) findViewById(R.id.gridView);
        adapter = new NoteAdapter(this,listNote);
        gridview.setAdapter(adapter);
    }
}
