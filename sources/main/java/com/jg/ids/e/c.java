package com.jg.ids.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        b dVar;
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                dVar = new d(iBinder);
            } else {
                dVar = (b) queryLocalInterface;
            }
            return dVar;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
        boolean z5 = true;
        try {
            switch (i6) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    parcel2.writeNoException();
                    parcel2.writeString(a());
                    break;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean a6 = a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(a6 ? 1 : 0);
                    break;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    break;
                default:
                    z5 = super.onTransact(i6, parcel, parcel2, i7);
                    break;
            }
        } catch (Throwable th) {
        }
        return z5;
    }
}
