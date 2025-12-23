package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zag extends com.google.android.gms.internal.base.zab implements zah {
    @Override // com.google.android.gms.internal.base.zab
    protected final boolean zaa(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
        if (i6 != 1) {
            return false;
        }
        ModuleInstallStatusUpdate moduleInstallStatusUpdate = (ModuleInstallStatusUpdate) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleInstallStatusUpdate.CREATOR);
        com.google.android.gms.internal.base.zac.zab(parcel);
        zab(moduleInstallStatusUpdate);
        return true;
    }

    public zag() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallStatusListener");
    }
}
