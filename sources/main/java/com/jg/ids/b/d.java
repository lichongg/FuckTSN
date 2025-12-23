package com.jg.ids.b;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f35512a;

    d(IBinder iBinder) {
        this.f35512a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f35512a;
    }

    @Override // com.jg.ids.b.b
    public final String a(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            obtain.writeString(str);
            if (!this.f35512a.transact(1, obtain, obtain2, 0) && c.c() != null) {
                readString = c.c().a(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.b.b
    public final String b(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            obtain.writeString(str);
            if (!this.f35512a.transact(2, obtain, obtain2, 0) && c.c() != null) {
                readString = c.c().b(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.b.b
    public final String c(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            obtain.writeString(str);
            if (!this.f35512a.transact(3, obtain, obtain2, 0) && c.c() != null) {
                readString = c.c().c(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.b.b
    public final String d(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            obtain.writeString(str);
            if (!this.f35512a.transact(4, obtain, obtain2, 0) && c.c() != null) {
                readString = c.c().d(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.b.b
    public final String e(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            obtain.writeString(str);
            if (!this.f35512a.transact(5, obtain, obtain2, 0) && c.c() != null) {
                readString = c.c().e(str);
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.b.b
    public final boolean a() {
        boolean z5;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (!this.f35512a.transact(6, obtain, obtain2, 0) && c.c() != null) {
                z5 = c.c().a();
            } else {
                obtain2.readException();
                z5 = obtain2.readInt() != 0;
            }
            return z5;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // com.jg.ids.b.b
    public final String b() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
            if (!this.f35512a.transact(7, obtain, obtain2, 0) && c.c() != null) {
                readString = c.c().b();
            } else {
                obtain2.readException();
                readString = obtain2.readString();
            }
            return readString;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
