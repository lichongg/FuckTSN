package com.clj.fastble.exception;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class GattException extends BleException {
    private int gattStatus;

    public GattException(int i6) {
        super(101, "Gatt Exception Occurred! ");
        this.gattStatus = i6;
    }

    public int getGattStatus() {
        return this.gattStatus;
    }

    public GattException setGattStatus(int i6) {
        this.gattStatus = i6;
        return this;
    }

    @Override // com.clj.fastble.exception.BleException
    public String toString() {
        return "GattException{gattStatus=" + this.gattStatus + "} " + super.toString();
    }
}
