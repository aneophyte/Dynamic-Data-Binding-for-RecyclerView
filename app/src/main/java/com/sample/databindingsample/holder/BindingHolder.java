package com.sample.databindingsample.holder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class BindingHolder extends RecyclerView.ViewHolder {

    public final ViewDataBinding binding;

    public BindingHolder(View itemView, ViewDataBinding binding) {
        super(itemView);
        this.binding = binding;
    }

}
