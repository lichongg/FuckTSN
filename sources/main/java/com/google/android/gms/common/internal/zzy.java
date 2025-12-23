package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzy extends com.google.android.gms.internal.common.zza implements zzaa {
    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() throws RemoteException {
        Parcel zzB = zzB(2, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() throws RemoteException {
        Parcel zzB = zzB(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }

    zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }
}
