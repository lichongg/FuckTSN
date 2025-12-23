package com.jg.ids.j;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f35552a;

    c(IBinder iBinder) {
        this.f35552a = iBinder;
    }

    @Override // com.jg.ids.j.a
    public final String a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            this.f35552a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // com.jg.ids.j.a
    public final String a(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            obtain.writeString(str);
            this.f35552a.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f35552a;
    }

    @Override // com.jg.ids.j.a
    public final String b(String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
            obtain.writeString(str);
            this.f35552a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            try {
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable th) {
                return readString;
            }
        } catch (Throwable th2) {
            try {
                obtain2.recycle();
                obtain.recycle();
            } catch (Throwable th3) {
            }
            return "";
        }
    }
}
