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
import com.namcf.happynote.objects.RealmController;

import java.util.ArrayList;

import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private ImageView btnAdd;
    private GridView gridview;

    public static RealmController realmController;
    public static NoteAdapter adapter;
    public static ArrayList<MyNote> listNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hello world

        realmController = new RealmController(this);

        initListNote();
        initGridView();

        this.init();
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

    public static void initListNote() {
        if (listNote == null) {
            listNote = new ArrayList<MyNote>();
        } else {
            listNote.clear();
        }

        RealmResults<MyNote> results = realmController.getData();
        for (MyNote n : results) {
            listNote.add(n);
        }

//        for (int i=0; i< 4; i++){
//            MyNote n = new MyNote("Di hoc", "lam bai kiem tra", "09/02/2017");
//            listNote.add(n);
//        }


    }

    public void initGridView() {
        gridview = (GridView) findViewById(R.id.gridView);
        adapter = new NoteAdapter(this, listNote);
        adapter.setmICallMain(new NoteAdapter.ICallMain() {
            @Override
            public void deleteNote(int pos) {
                realmController.removeNote(listNote.get(pos));
                initListNote();
                refreshList();
            }
        });
        gridview.setAdapter(adapter);
    }

    public static void addNote(MyNote myNote){
        realmController.addNote(myNote);
        initListNote();
    }

    public static void refreshList(){
        adapter.notifyDataSetChanged();
    }
}
