package com.xebia.xebicon2013.cciaa;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ContactView extends LinearLayout {

    public static final Contact EMPTY = new Contact(null, null, null, null);
    private TextView nameView;
    private TextView emailView;
    private TextView addressView;
    private Contact contact = EMPTY;

    /** Inherited constructor. */
    public ContactView(Context context) {
        super(context);
        init(context);
    }

    /** Inherited constructor. */
    public ContactView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /** Inherited constructor. */
    public ContactView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.contact_view, this, true);
        nameView = (TextView) findViewById(R.id.contact_name);
        emailView = (TextView) findViewById(R.id.contact_email);
        addressView = (TextView) findViewById(R.id.contact_address);
    }

    public void showContact(Contact contact) {
        this.contact = (contact != null ? contact : EMPTY);
        String name = contact.getName();
        String email = contact.getEmail();
        String address = contact.getAddressLines();
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
    }
}
