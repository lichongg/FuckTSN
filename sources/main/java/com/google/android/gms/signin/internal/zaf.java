package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zaf extends com.google.android.gms.internal.base.zaa implements IInterface {
    zaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zae(int i6) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i6);
        zac(7, zaa);
    }

    public final void zaf(IAccountAccessor iAccountAccessor, int i6, boolean z5) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, iAccountAccessor);
        zaa.writeInt(i6);
        zaa.writeInt(z5 ? 1 : 0);
        zac(9, zaa);
    }

    public final void zag(zai zaiVar, zae zaeVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zac(zaa, zaiVar);
        com.google.android.gms.internal.base.zac.zad(zaa, zaeVar);
        zac(12, zaa);
    }
}
