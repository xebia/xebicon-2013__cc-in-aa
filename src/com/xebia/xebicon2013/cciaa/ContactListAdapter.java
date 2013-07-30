package com.xebia.xebicon2013.cciaa;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 *
 */
public class ContactListAdapter extends BaseAdapter {

    private final Contact[] contacts;
    private final Context context;

    public ContactListAdapter(Context context, Contact[] contacts) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactView view;
        if (convertView == null) {
            view = new ContactView(context);
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
