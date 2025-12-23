package com.clj.fastble.exception;

import android.bluetooth.BluetoothGatt;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class ConnectException extends BleException {
    private BluetoothGatt bluetoothGatt;
    private int gattStatus;

    public ConnectException(BluetoothGatt bluetoothGatt, int i6) {
        super(101, "Gatt Exception Occurred! ");
        this.bluetoothGatt = bluetoothGatt;
        this.gattStatus = i6;
    }

    public BluetoothGatt getBluetoothGatt() {
        return this.bluetoothGatt;
    }

    public int getGattStatus() {
        return this.gattStatus;
    }

    public ConnectException setBluetoothGatt(BluetoothGatt bluetoothGatt) {
        this.bluetoothGatt = bluetoothGatt;
        return this;
    }

    public ConnectException setGattStatus(int i6) {
        this.gattStatus = i6;
        return this;
    }

    @Override // com.clj.fastble.exception.BleException
    public String toString() {
        return "ConnectException{gattStatus=" + this.gattStatus + ", bluetoothGatt=" + this.bluetoothGatt + "} " + super.toString();
    }
}
