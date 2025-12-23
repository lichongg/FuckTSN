package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zad extends com.google.android.gms.internal.base.zab implements zae {
    @Override // com.google.android.gms.internal.base.zab
    protected final boolean zaa(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
        if (i6 == 1) {
            Status status = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleAvailabilityResponse.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            zae(status, moduleAvailabilityResponse);
        } else if (i6 == 2) {
            Status status2 = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleInstallResponse.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            zad(status2, moduleInstallResponse);
        } else if (i6 == 3) {
            Status status3 = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            ModuleInstallIntentResponse moduleInstallIntentResponse = (ModuleInstallIntentResponse) com.google.android.gms.internal.base.zac.zaa(parcel, ModuleInstallIntentResponse.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            zac(status3, moduleInstallIntentResponse);
        } else {
            if (i6 != 4) {
                return false;
            }
            Status status4 = (Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR);
            com.google.android.gms.internal.base.zac.zab(parcel);
            zab(status4);
        }
        return true;
    }

    public zad() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }
}
