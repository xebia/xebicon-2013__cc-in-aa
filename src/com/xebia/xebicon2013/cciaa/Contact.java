package com.xebia.xebicon2013.cciaa;

/**
 * (Yes, I'm aware Android has a contacts API.)
 */
public class Contact {
    private final String name;
    private final String email;
    private final String address1;
    private final String address2;

    public Contact(String name, String email, String address1, String address2) {
        this.email = email;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddressLines() {
        if (address1 == null && address2 == null) {
            return null;
        } else if (address1 != null && address2 == null) {
            return address1;
        } else if (address1 == null && address2 != null) {
            return address2;
        }
        return address1 + '\n' + address2;
    }
}
