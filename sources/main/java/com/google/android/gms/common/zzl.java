package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class zzl extends zzj {
    private static final WeakReference zza = new WeakReference(null);
    private WeakReference zzb;

    protected abstract byte[] zzb();

    @Override // com.google.android.gms.common.zzj
    final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            try {
                bArr = (byte[]) this.zzb.get();
                if (bArr == null) {
                    bArr = zzb();
                    this.zzb = new WeakReference(bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    zzl(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }
}
