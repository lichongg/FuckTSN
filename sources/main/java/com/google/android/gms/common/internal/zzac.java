package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzac extends com.google.android.gms.internal.common.zzb implements IGmsCallbacks {
    @Override // com.google.android.gms.internal.common.zzb
    protected final boolean zza(int i6, Parcel parcel, Parcel parcel2, int i7) throws RemoteException {
        if (i6 == 1) {
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) com.google.android.gms.internal.common.zzc.zza(parcel, Bundle.CREATOR);
            com.google.android.gms.internal.common.zzc.zzb(parcel);
            onPostInitComplete(readInt, readStrongBinder, bundle);
        } else if (i6 == 2) {
            int readInt2 = parcel.readInt();
            Bundle bundle2 = (Bundle) com.google.android.gms.internal.common.zzc.zza(parcel, Bundle.CREATOR);
            com.google.android.gms.internal.common.zzc.zzb(parcel);
            zzb(readInt2, bundle2);
        } else {
            if (i6 != 3) {
                return false;
            }
            int readInt3 = parcel.readInt();
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) com.google.android.gms.internal.common.zzc.zza(parcel, zzk.CREATOR);
            com.google.android.gms.internal.common.zzc.zzb(parcel);
            zzc(readInt3, readStrongBinder2, zzkVar);
        }
        parcel2.writeNoException();
        return true;
    }

    public zzac() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }
}
