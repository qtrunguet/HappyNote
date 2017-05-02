package com.namcf.happynote.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.namcf.happynote.fragment.NoteFragment;
import com.namcf.happynote.objects.MyNote;

import java.util.ArrayList;

/**
 * Created by linuxlord on 5/3/17.
 */

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<MyNote> listNote;

    public MyViewPagerAdapter(FragmentManager fm, ArrayList<MyNote> listNote) {
        super(fm);
        this.listNote = listNote;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fg = new NoteFragment(listNote.get(position));
        return fg;
    }

    @Override
    public int getCount() {
        return listNote.size();
    }
}
