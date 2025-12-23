package com.jg.ids.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: D:\Downloads\app\classes10.dex */
public abstract class b extends Binder implements a {
    public static a a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new c(iBinder) : (a) queryLocalInterface;
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
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String a6 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a6);
                    break;
                case 2:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b6 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b6);
                    break;
                case 3:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    boolean c6 = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(c6 ? 1 : 0);
                    break;
                case 4:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String a7 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a7);
                    break;
                case 5:
                    parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                    String b7 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b7);
                    break;
                case 1598968902:
                    parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
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
