package com.clj.fastble.data;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BleDevice implements Parcelable {
    public static final Parcelable.Creator<BleDevice> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private BluetoothDevice f32071a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f32072b;

    /* renamed from: c, reason: collision with root package name */
    private int f32073c;

    /* renamed from: d, reason: collision with root package name */
    private long f32074d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements Parcelable.Creator<BleDevice> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BleDevice createFromParcel(Parcel parcel) {
            return new BleDevice(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BleDevice[] newArray(int i6) {
            return new BleDevice[i6];
        }

        a() {
        }
    }

    public BleDevice(BluetoothDevice bluetoothDevice) {
        this.f32071a = bluetoothDevice;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BluetoothDevice a() {
        return this.f32071a;
    }

    public String b() {
        if (this.f32071a == null) {
            return "";
        }
        return this.f32071a.getName() + this.f32071a.getAddress();
    }

    public String c() {
        BluetoothDevice bluetoothDevice = this.f32071a;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getAddress();
        }
        return null;
    }

    public String d() {
        BluetoothDevice bluetoothDevice = this.f32071a;
        if (bluetoothDevice != null) {
            return bluetoothDevice.getName();
        }
        return null;
    }

    public int e() {
        return this.f32073c;
    }

    public byte[] f() {
        return this.f32072b;
    }

    public long h() {
        return this.f32074d;
    }

    public void i(BluetoothDevice bluetoothDevice) {
        this.f32071a = bluetoothDevice;
    }

    public void k(int i6) {
        this.f32073c = i6;
    }

    public void l(byte[] bArr) {
        this.f32072b = bArr;
    }

    public void m(long j6) {
        this.f32074d = j6;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeParcelable(this.f32071a, i6);
        parcel.writeByteArray(this.f32072b);
        parcel.writeInt(this.f32073c);
        parcel.writeLong(this.f32074d);
    }

    public BleDevice(BluetoothDevice bluetoothDevice, int i6, byte[] bArr, long j6) {
        this.f32071a = bluetoothDevice;
        this.f32072b = bArr;
        this.f32073c = i6;
        this.f32074d = j6;
    }

    protected BleDevice(Parcel parcel) {
        this.f32071a = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        this.f32072b = parcel.createByteArray();
        this.f32073c = parcel.readInt();
        this.f32074d = parcel.readLong();
    }
}
