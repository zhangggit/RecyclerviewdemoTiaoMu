package com.example.zhanggang.duotiaomurecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Data> list = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= (RecyclerView) findViewById(R.id.xrecyclerview);

        initData();

        adapter = new MyAdapter(list,this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,12);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //获得类型
                int itemViewType = adapter.getItemViewType(position);

                switch (itemViewType){
                    //   case相当于要显示信息的列数  return表示的是每行的个数除以return的值得到case的值
                    case 0:
                        return 12;

                    case 1:
                        return 4;
                    case 2:
                        return 4;
                    case 3:
                        return 4;

                    case 4:
                        return 3;
                    case 5:
                        return 3;
                    case 6:
                        return 3;
                    case 7:
                        return 3;


                    default:
                        return 4;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            Data data = new Data("动漫", "标题" + i, "http://cover2.u17i.com/2017/05/5475960_1495520371_2LOf5OgcNCkN.sbig.jpg");
            data.setType(i);
            list.add(data);
        }
    }

}

