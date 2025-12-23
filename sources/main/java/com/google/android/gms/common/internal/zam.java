package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zam extends com.google.android.gms.internal.base.zaa implements IInterface {
    zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper zae(IObjectWrapper iObjectWrapper, zax zaxVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, iObjectWrapper);
        com.google.android.gms.internal.base.zac.zac(zaa, zaxVar);
        Parcel zab = zab(2, zaa);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zab.readStrongBinder());
        zab.recycle();
        return asInterface;
    }
}
