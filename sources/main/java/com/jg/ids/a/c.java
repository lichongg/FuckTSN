package com.jg.ids.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: D:\Downloads\app\classes10.dex */
public abstract class c extends Binder implements b {
    public static b a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new d(iBinder) : (b) queryLocalInterface;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.os.Binder
    public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
        boolean z5 = true;
        try {
            if (i6 != 1598968902) {
                switch (i6) {
                    case 1:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        boolean a6 = a();
                        parcel2.writeNoException();
                        parcel2.writeInt(a6 ? 1 : 0);
                        break;
                    case 2:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String b6 = b();
                        parcel2.writeNoException();
                        parcel2.writeString(b6);
                        break;
                    case 3:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String c6 = c();
                        parcel2.writeNoException();
                        parcel2.writeString(c6);
                        break;
                    case 4:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String d6 = d();
                        parcel2.writeNoException();
                        parcel2.writeString(d6);
                        break;
                    case 5:
                        parcel.enforceInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                        String e6 = e();
                        parcel2.writeNoException();
                        parcel2.writeString(e6);
                        break;
                    default:
                        try {
                            z5 = super.onTransact(i6, parcel, parcel2, i7);
                            break;
                        } catch (RemoteException e7) {
                            break;
                        }
                }
            } else {
                parcel2.writeString("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            }
        } catch (Throwable th) {
        }
        return z5;
    }
}
