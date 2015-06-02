package com.liangfeizc.databindingsamples.custombindings;

/**
 * Created by rufi on 6/2/15.
 */
public class Contact {
    private final String tel;
    private final String address;

    public Contact(String tel, String address) {
        this.tel = tel;
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }
}
