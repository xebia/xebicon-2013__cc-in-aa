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
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Contact item = getItem(position);
        String name = item.getName();
        String email = item.getEmail();
        String address = item.getAddressLines();
        if (name != null) {
            holder.nameView.setText(name);
        } else if (email != null) {
            holder.nameView.setText(email);
        } else {
            holder.nameView.setText(R.string.unidentified);
        }
        if (email != null) {
            holder.emailView.setText(email);
            holder.emailView.setVisibility(name == null ? View.GONE : View.VISIBLE);
        } else {
            holder.emailView.setVisibility(View.GONE);
        }
        if (address != null) {
            holder.addressView.setText(address);
            holder.addressView.setVisibility(View.VISIBLE);
        } else {
            holder.addressView.setVisibility(View.GONE);
        }
        return convertView;
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
