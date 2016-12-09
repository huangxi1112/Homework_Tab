package com.example.alienware.homework_tab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Person> mlist;
    private LayoutInflater inflater;

    public MyAdapter(List<Person> list){
        mlist=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.re_item1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

   @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
     final Person person=mlist.get(position);
       holder.textView.setText(person.getName());
       holder.textView2.setText(person.getNumber());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView,textView2;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
            textView2=(TextView)itemView.findViewById(R.id.textView2);
        }}
}
