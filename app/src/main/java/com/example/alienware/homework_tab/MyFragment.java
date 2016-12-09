package com.example.alienware.homework_tab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alienware on 2016/12/8.
 */

public class MyFragment extends Fragment {
public MyFragment(){}
    public static MyFragment newInstance(int position){
        MyFragment fragment=new MyFragment();
        Bundle args=new Bundle();
        args.putInt(" ",position);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
   View view=inflater.inflate(R.layout.fragment_main,container,false);
        List<Person> persons=new ArrayList<>();
        DBHelper dbHelper=new DBHelper(getActivity());
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("person",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            String name=cursor.getString(1);
            String number=cursor.getString(2);
            Person person=new Person(name,number);
            persons.add(person);
        }
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyAdapter myAdapter=new MyAdapter(persons);
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}
