package com.jg.ids.d;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private IBinder f35518a;

    d(IBinder iBinder) {
        this.f35518a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f35518a;
    }

    @Override // com.jg.ids.d.b
    public final boolean a() {
        boolean z5;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f35518a.transact(1, obtain, obtain2, 0) && c.d() != null) {
                z5 = c.d().a();
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

    @Override // com.jg.ids.d.b
    public final String a(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            obtain.writeString(str);
            if (!this.f35518a.transact(2, obtain, obtain2, 0) && c.d() != null) {
                readString = c.d().a(str);
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

    @Override // com.jg.ids.d.b
    public final String b() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f35518a.transact(3, obtain, obtain2, 0) && c.d() != null) {
                readString = c.d().b();
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

    @Override // com.jg.ids.d.b
    public final String c() {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            if (!this.f35518a.transact(4, obtain, obtain2, 0) && c.d() != null) {
                readString = c.d().c();
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

    @Override // com.jg.ids.d.b
    public final String b(String str) {
        String readString;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.android.creator.IdsSupplier");
            obtain.writeString(str);
            if (!this.f35518a.transact(5, obtain, obtain2, 0) && c.d() != null) {
                readString = c.d().b(str);
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
