package com.jg.ids.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.creator.IdsSupplier");
        if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
            return (b) queryLocalInterface;
        }
        return new d(iBinder);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
        switch (i6) {
            case 1:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                boolean a6 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a6 ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String a7 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a7);
                return true;
            case 3:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String b6 = b();
                parcel2.writeNoException();
                parcel2.writeString(b6);
                return true;
            case 4:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String c6 = c();
                parcel2.writeNoException();
                parcel2.writeString(c6);
                return true;
            case 5:
                parcel.enforceInterface("com.android.creator.IdsSupplier");
                String b7 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b7);
                return true;
            case 1598968902:
                parcel2.writeString("com.android.creator.IdsSupplier");
                return true;
            default:
                return super.onTransact(i6, parcel, parcel2, i7);
        }
    }

    public static b d() {
        return null;
    }
}
