package com.abhnin.pincodelocator;

/**
 * Created by Sony on 5/14/2017.
 */

public class PinCodeData {
    private String pin, locality;

    public PinCodeData(String pin, String locality) {

        this.pin = pin;
        this.locality = locality;

    }

    public String getPin() {
        return pin;
    }

    public String getLocality() {
        return locality;
    }
}
