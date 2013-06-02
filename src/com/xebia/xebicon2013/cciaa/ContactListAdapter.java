package com.xebia.xebicon2013.cciaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        Contact item = getItem(position);
        String name = item.getName();
        String email = item.getEmail();
        String address = item.getAddressLines();
        TextView nameView = (TextView) convertView.findViewById(R.id.contact_name);
        TextView emailView = (TextView) convertView.findViewById(R.id.contact_email);
        TextView addressView = (TextView) convertView.findViewById(R.id.contact_address);
        if (name != null) {
            nameView.setText(name);
        } else if (email != null) {
            nameView.setText(email);
        } else {
            nameView.setText(R.string.unidentified);
        }
        if (email != null) {
            emailView.setText(email);
            emailView.setVisibility(name == null ? View.GONE : View.VISIBLE);
        } else {
            emailView.setVisibility(View.GONE);
        }
        if (address != null) {
            addressView.setText(address);
            addressView.setVisibility(View.VISIBLE);
        } else {
            addressView.setVisibility(View.GONE);
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
