package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzaf extends com.google.android.gms.internal.common.zzb implements zzag {
    public static zzag zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return queryLocalInterface instanceof zzag ? (zzag) queryLocalInterface : new zzae(iBinder);
    }
}
