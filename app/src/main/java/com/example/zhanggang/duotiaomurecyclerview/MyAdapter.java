package com.example.zhanggang.duotiaomurecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * 类作用：
 * 时  间：2017/8/15 - 20:03.
 * 创建人：张刚
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Data> list;
    Context context;

    public MyAdapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
                return  new ViewHolder(inflate);
//            case 1:
//                View inflate1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
//                return new ViewHolder2(inflate1);
//            case 2:
//                View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
//                return   new ViewHolder2(inflate2);
//            case 3:
//                View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
//                return  new ViewHolder2(inflate3);
//            case 4:
//                View inflate4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
//                return  new ViewHolder2(inflate4);
//            case 5:
//                return  new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));
//            case 6:
//                return  new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));
//            case 7:
//                return  new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));
            default:
                return  new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false));
        }
}

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            ViewHolder mholder= (ViewHolder) holder;
            mholder.title_item1.setText(list.get(position).title);
        }else if (holder instanceof ViewHolder2){
            ViewHolder2 mholder = (ViewHolder2) holder;
            mholder.name.setText(list.get(position).name);
            Glide.with(context).load(list.get(position).picture).into(mholder.image);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type%12;
    }

    @Override
    public int getItemCount() {
        if (list.size()==0){
            return 0;
        }else {
            return list.size();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title_item1;
        public ViewHolder(View itemView) {
            super(itemView);
            title_item1=itemView.findViewById(R.id.title_item1);
        }
    }
	
    static class ViewHolder2 extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;
        public ViewHolder2(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            image=itemView.findViewById(R.id.imageview);
        }
    }


}
