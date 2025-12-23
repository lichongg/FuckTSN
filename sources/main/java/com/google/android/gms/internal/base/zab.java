package com.google.android.gms.internal.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zab extends Binder implements IInterface {
    protected boolean zaa(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
        throw null;
    }

    protected zab(String str) {
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
        return zaa(i6, parcel, parcel2, i7);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
