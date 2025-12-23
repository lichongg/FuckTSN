package com.google.android.gms.internal.base;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zaa implements IInterface {
    private final IBinder zaa;
    private final String zab;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zaa;
    }

    protected final void zad(int i6, Parcel parcel) throws RemoteException {
        try {
            this.zaa.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    protected zaa(IBinder iBinder, String str) {
        this.zaa = iBinder;
        this.zab = str;
    }

    protected final Parcel zaa() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zab);
        return obtain;
    }

    protected final Parcel zab(int i6, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zaa.transact(2, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e6) {
                obtain.recycle();
                throw e6;
            }
        } finally {
            parcel.recycle();
        }
    }

    protected final void zac(int i6, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zaa.transact(i6, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
