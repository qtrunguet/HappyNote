package com.namcf.happynote.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.namcf.happynote.R;
import com.namcf.happynote.objects.MyNote;

import java.util.ArrayList;

/**
 * Created by linuxlord on 4/27/17.
 */

public class NoteAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<MyNote> listNote;
    private ICallMain mICallMain;

    public NoteAdapter(Context context, ArrayList<MyNote> listNote) {
        this.context = context;
        this.listNote = listNote;
    }

    @Override
    public int getCount() {
        return listNote.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null){
            view = View.inflate(context, R.layout.item_note, null);
        }

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        TextView tvNoteContent = (TextView) view.findViewById(R.id.tvNoteContent);
        TextView tvDate = (TextView) view.findViewById(R.id.tvDate);
        ImageView btnDelete = (ImageView) view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mICallMain != null){
                    mICallMain.deleteNote(position);
                }
            }
        });

        tvTitle.setText(listNote.get(position).getTitle());
        tvNoteContent.setText(listNote.get(position).getNote());
        tvDate.setText(listNote.get(position).getDate());


        return view;
    }

    public void setmICallMain(ICallMain mICallMain) {
        this.mICallMain = mICallMain;
    }

    public interface ICallMain{
        public void deleteNote(int pos);
    }
}
