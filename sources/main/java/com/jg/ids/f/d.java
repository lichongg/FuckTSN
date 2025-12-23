package com.jg.ids.f;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f35527a;

    d(IBinder iBinder) {
        this.f35527a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f35527a;
    }

    @Override // com.jg.ids.f.b
    public final String a() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (!this.f35527a.transact(1, obtain, obtain2, 0) && c.c() != null) {
                readString = c.c().a();
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

    @Override // com.jg.ids.f.b
    public final boolean b() {
        boolean z5;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (!this.f35527a.transact(2, obtain, obtain2, 0) && c.c() != null) {
                z5 = c.c().b();
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
}
