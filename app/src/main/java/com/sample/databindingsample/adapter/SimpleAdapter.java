package com.sample.databindingsample.adapter;

import com.sample.databindingsample.R;

import java.util.List;
import java.util.UUID;

public class SimpleAdapter extends DynamicRecyclerAdapter<String> {
    public SimpleAdapter(List<String> data) {
        super(data);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item;
    }

    @Override
    protected String getUniqueId(String dataItem) {
        return dataItem;
    }
}
