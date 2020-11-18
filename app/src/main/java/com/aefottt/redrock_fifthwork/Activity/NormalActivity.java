package com.aefottt.redrock_fifthwork.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.aefottt.redrock_fifthwork.MyRvAdapter;
import com.aefottt.redrock_fifthwork.R;
import com.aefottt.redrock_fifthwork.RvAdapterBean;

import java.util.ArrayList;

public class NormalActivity extends AppCompatActivity {
    private final ArrayList<RvAdapterBean> rvList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        setUserName();
        setRecyclerView();
    }

    private void setUserName(){
        Intent intent = getIntent();
        String[] userInfo = intent.getStringArrayExtra("userInfo");
        View includeNormalBar = findViewById(R.id.include_normal);
        TextView tv = includeNormalBar.findViewById(R.id.tv_userName);
        tv.setText("【"+ userInfo[0]+"】");
    }

    private void setRecyclerView(){
        initRvData();
        RecyclerView rvNormal = findViewById(R.id.rv_normal);
        rvNormal.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        rvNormal.setAdapter(new MyRvAdapter(rvList));
    }

    private void initRvData(){
        rvList.add(new RvAdapterBean("Purple200","This is a test about Purple200 content",R.color.purple_200));
        rvList.add(new RvAdapterBean("Purple500","about Purple500 content",R.color.purple_500));
        rvList.add(new RvAdapterBean("Purple700","This is a test about Purple700 content",R.color.purple_700));
        rvList.add(new RvAdapterBean("Teal200","Teal200 content",R.color.teal_200));
        rvList.add(new RvAdapterBean("Teal700","This is a test about Teal700 content",R.color.teal_700));
        rvList.add(new RvAdapterBean("IcLauncherBg","This is a test about icon_launcher_background content",R.drawable.ic_launcher_background));
        rvList.add(new RvAdapterBean("Purple200","This is a test about Purple200 content",R.color.purple_200));
        rvList.add(new RvAdapterBean("Purple500","about Purple500 content",R.color.purple_500));
        rvList.add(new RvAdapterBean("Purple700","This is a test about Purple700 content",R.color.purple_700));
        rvList.add(new RvAdapterBean("Teal200","about Teal200 content",R.color.teal_200));
        rvList.add(new RvAdapterBean("Teal700","This is a test about Teal700 content",R.color.teal_700));
        rvList.add(new RvAdapterBean("IcLauncherBg","test about icon_launcher_background content",R.drawable.ic_launcher_background));
        rvList.add(new RvAdapterBean("Purple200","This is a test about Purple200 content",R.color.purple_200));
        rvList.add(new RvAdapterBean("Purple500","This is a test about Purple500 content",R.color.purple_500));
        rvList.add(new RvAdapterBean("Purple700","about Purple700 content",R.color.purple_700));
        rvList.add(new RvAdapterBean("Teal200","This is a test about Teal200 content",R.color.teal_200));
        rvList.add(new RvAdapterBean("Teal700","This is a test about Teal700 content",R.color.teal_700));
        rvList.add(new RvAdapterBean("IcLauncherBg","This is a test about icon_launcher_background content",R.drawable.ic_launcher_background));
    }
}
