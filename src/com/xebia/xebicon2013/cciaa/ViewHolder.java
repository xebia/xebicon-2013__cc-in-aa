package com.xebia.xebicon2013.cciaa;

import android.view.View;
import android.widget.TextView;

public class ViewHolder {
    public final TextView nameView;
    public final TextView emailView;
    public final TextView addressView;

    public ViewHolder(View listItem) {
        nameView = (TextView) listItem.findViewById(R.id.contact_name);
        emailView = (TextView) listItem.findViewById(R.id.contact_email);
        addressView = (TextView) listItem.findViewById(R.id.contact_address);
    }
}
