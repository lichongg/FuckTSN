package com.google.android.gms.internal.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzb extends Binder implements IInterface {
    protected boolean zza(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
        return false;
    }

    protected zzb(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
        if (i6 > 16777215) {
            if (super.onTransact(i6, parcel, parcel2, i7)) {
                return true;
            }
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
        }
        return zza(i6, parcel, parcel2, i7);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
