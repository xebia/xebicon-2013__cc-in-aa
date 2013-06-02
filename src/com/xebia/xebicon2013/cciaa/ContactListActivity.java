package com.xebia.xebicon2013.cciaa;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

public class ContactListActivity extends ListActivity
{
    private final Contact[] contacts = new Contact[] {
            new Contact("Peter Petersen", "peterp@example.com", null, null),
            new Contact("John Johnson", "john@example.com", "42 Somesuch Street", "32123 Hopscotch, AL"),
            new Contact(null, "denise.daniels@example.com", null, null),
            new Contact("Sarah S.", null, "1 Chemist's Avenue", "60223 Nowhere, WY"),
            new Contact(null, null, "312 Spook Blvd", "Langley, VA")
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setListAdapter(new ContactListAdapter(this, contacts));
    }
}
