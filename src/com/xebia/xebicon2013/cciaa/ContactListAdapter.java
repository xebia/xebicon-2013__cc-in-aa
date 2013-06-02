package com.xebia.xebicon2013.cciaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContactListAdapter extends BaseAdapter {

    private final Contact[] contacts;
    private final LayoutInflater inflater;

    public ContactListAdapter(Context context, Contact[] contacts) {
        this.contacts = contacts;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Contact item = getItem(position);
        final View view = (convertView == null)
            ? inflater.inflate(R.layout.list_item, null)
            : convertView;

        TextView nameView = ((TextView) view.findViewById(R.id.contact_name));
        if (item.getName() != null) {
            nameView.setText(item.getName());
        } else if (item.getEmail() != null) {
            nameView.setText(item.getEmail());
        } else {
            nameView.setText(R.string.unidentified);
        }

        TextView emailView = (TextView) view.findViewById(R.id.contact_email);
        if (item.getEmail() != null) {
            emailView.setText(item.getEmail());
            emailView.setVisibility(item.getName() == null ? View.GONE : View.VISIBLE);
        } else {
            emailView.setVisibility(View.GONE);
        }

        TextView addressView = (TextView) view.findViewById(R.id.contact_address);
        if (item.getAddressLines() != null) {
            addressView.setText(item.getAddressLines());
            addressView.setVisibility(View.VISIBLE);
        } else {
            addressView.setVisibility(View.GONE);
        }
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
