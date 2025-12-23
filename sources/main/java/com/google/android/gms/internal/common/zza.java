package com.google.android.gms.internal.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    protected final void zzD(int i6, Parcel parcel) throws RemoteException {
        try {
            this.zza.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    protected zza(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    protected final Parcel zzB(int i6, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zza.transact(i6, parcel, obtain, 0);
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

    protected final void zzC(int i6, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(1, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    protected final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        return obtain;
    }
}
