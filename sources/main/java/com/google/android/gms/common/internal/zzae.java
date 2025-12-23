package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzae extends com.google.android.gms.internal.common.zza implements zzag {
    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzi() throws RemoteException {
        Parcel zzB = zzB(7, zza());
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }

    zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzg() throws RemoteException {
        Parcel zzB = zzB(9, zza());
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final com.google.android.gms.common.zzq zze(com.google.android.gms.common.zzo zzoVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzoVar);
        Parcel zzB = zzB(6, zza);
        com.google.android.gms.common.zzq zzqVar = (com.google.android.gms.common.zzq) com.google.android.gms.internal.common.zzc.zza(zzB, com.google.android.gms.common.zzq.CREATOR);
        zzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final com.google.android.gms.common.zzq zzf(com.google.android.gms.common.zzo zzoVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzoVar);
        Parcel zzB = zzB(8, zza);
        com.google.android.gms.common.zzq zzqVar = (com.google.android.gms.common.zzq) com.google.android.gms.internal.common.zzc.zza(zzB, com.google.android.gms.common.zzq.CREATOR);
        zzB.recycle();
        return zzqVar;
    }

    @Override // com.google.android.gms.common.internal.zzag
    public final boolean zzh(com.google.android.gms.common.zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zzc(zza, zzsVar);
        com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
        Parcel zzB = zzB(5, zza);
        boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
        zzB.recycle();
        return zzf;
    }
}
