package com.sample.databindingsample.adapter;

import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public abstract class ArrayMapAdapter<T, ViewHolder extends RecyclerView.ViewHolder>
                                             extends RecyclerView.Adapter<ViewHolder> {
    protected final ArrayMap<String, T> data;

    public ArrayMapAdapter(List<T> data) {
        this.data = new ArrayMap<>(data.size());
        for(T dataItem : data) {
            this.data.put(getUniqueId(dataItem), dataItem);
        }
    }

    protected abstract String getUniqueId(T dataItem);

    public ArrayMapAdapter(ArrayMap<String, T> data) {
        this.data = data;
    }

    public void put(T item) {
        putAndNotify(item);
    }

    public void remove(T item) {
        String uniqueId = getUniqueId(item);
        data.remove(uniqueId);
        notifyItemRemoved(data.indexOfKey(uniqueId));
    }

    public void putAll(List<T> items) {
        for(T item : items) {
            putAndNotify(item);
        }
    }

    private void putAndNotify(T item) {
        String uniqueId = getUniqueId(item);
        if (data.put(uniqueId, item) != null) {
            notifyItemChanged(data.indexOfKey(uniqueId));
        } else {
            notifyItemInserted(data.indexOfKey(uniqueId));
        }
    }

    public void clear() {
        int initialSize = data.size();
        data.clear();

        notifyItemRangeRemoved(0, initialSize);
    }

    public T get(int position) {
        String key = data.keyAt(position);
        return data.get(key);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
