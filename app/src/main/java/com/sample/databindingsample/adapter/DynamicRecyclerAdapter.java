package com.sample.databindingsample.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v4.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.databindingsample.BR;
import com.sample.databindingsample.databinding.ItemBinding;
import com.sample.databindingsample.holder.BindingHolder;

import java.util.List;

public abstract class DynamicRecyclerAdapter<T> extends ArrayMapAdapter<T, BindingHolder> {

    private LayoutInflater inflater;

    public DynamicRecyclerAdapter(ArrayMap<String, T> data) {
        super(data);
    }

    public DynamicRecyclerAdapter(List<T> data) {
        super(data);
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(inflater == null)
            inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, getItemLayoutId(), parent, false);
        View view = binding.getRoot();
        return new BindingHolder(view, binding);
    }

    @LayoutRes
    protected abstract int getItemLayoutId();

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        T item = get(position);
        holder.binding.setVariable(BR.item, item);
        holder.binding.executePendingBindings();
    }

}
