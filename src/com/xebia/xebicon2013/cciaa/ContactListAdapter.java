package com.xebia.xebicon2013.cciaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 *
 */
public class ContactListAdapter extends BaseAdapter {

    private final Contact[] contacts;
    private final LayoutInflater inflater;

    public ContactListAdapter(Context context, Contact[] contacts) {
        this.contacts = contacts;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactView view;
        if (convertView == null) {
            view = (ContactView) inflater.inflate(R.layout.list_item, null);
        } else {
            view = (ContactView) convertView;
        }
        Contact item = getItem(position);
        view.showContact(item);
        return view;
    }

    @Override
    public int getCount() {
        return contacts.length;
    }

    @Override
    public Contact getItem(int position) {
        return contacts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
