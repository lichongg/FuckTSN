package com.jg.ids.i;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f35539a;

    public f(IBinder iBinder) {
        this.f35539a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f35539a;
    }

    @Override // com.jg.ids.i.h
    public final String a(String str, String str2, String str3) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.oplus.stdid.IStdID");
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.f35539a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readString();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
