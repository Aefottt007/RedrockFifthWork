package com.aefottt.redrock_fifthwork;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.ViewHolder> {
    //全局变量-数据源
    private final ArrayList<RvAdapterBean> rvList;

    //定义内部类ViewHolder，设置适配器元素的种类为该自定义的ViewHolder
    //通过ViewHolder找到组件ID
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView rvImgShow;
        TextView rvTextTitle;
        TextView rvTextContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rvImgShow = itemView.findViewById(R.id.iv_myrv_item_show);
            rvTextTitle = itemView.findViewById(R.id.tv_myrv_item_title);
            rvTextContent = itemView.findViewById(R.id.tv_myrv_item_content);
        }
    }

    //构造器，传入数据源为参数
    public MyRvAdapter(ArrayList<RvAdapterBean> rvList) {
        this.rvList = rvList;
    }

    //Rv适配器重新的第一个方法： 创建ViewHolder
    //先获取到每个Item的布局Layout，然后通过获取到的布局创建新的ViewHolder并返回
    //可以把ViewHolder看作一个缓存池，用来缓存实例化的组件，提升运行效率
    //ViewHolder工作原理： 先把通过ViewHolder获取布局，再在ViewHolder里面通过View布局实例化控件
    //如果当前View不为null的话，就可以直接取出ViewHolder将其存储在View中，减少了组件实例化的次数
    @NonNull
    @Override
    public MyRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myrv_item,parent,false);
        return new ViewHolder(view);
    }

    //重新第二个方法：  绑定ViewHolder
    //对RecyclerView子项数据进行赋值
    @Override
    public void onBindViewHolder(@NonNull MyRvAdapter.ViewHolder holder, int position) {
        //获取当前Bean实例
        RvAdapterBean bean = rvList.get(position);
        //将数据设置到ViewHolder中去
        holder.rvImgShow.setBackgroundResource(bean.getImgId());
        holder.rvTextTitle.setText(bean.getTitle());
        holder.rvTextContent.setText(bean.getContent());
    }

    //返回数据源的长度
    @Override
    public int getItemCount() {
        return rvList.size();
    }
}
