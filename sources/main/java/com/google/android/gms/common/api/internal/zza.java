package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zza implements Runnable {
    final /* synthetic */ LifecycleCallback zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzb zzc;

    zza(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.zzc = zzbVar;
        this.zza = lifecycleCallback;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        zzb zzbVar = this.zzc;
        i6 = zzbVar.zzc;
        if (i6 > 0) {
            LifecycleCallback lifecycleCallback = this.zza;
            bundle = zzbVar.zzd;
            if (bundle != null) {
                String str = this.zzb;
                bundle3 = zzbVar.zzd;
                bundle2 = bundle3.getBundle(str);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i7 = this.zzc.zzc;
        if (i7 >= 2) {
            this.zza.onStart();
        }
        i8 = this.zzc.zzc;
        if (i8 >= 3) {
            this.zza.onResume();
        }
        i9 = this.zzc.zzc;
        if (i9 >= 4) {
            this.zza.onStop();
        }
        i10 = this.zzc.zzc;
        if (i10 >= 5) {
            this.zza.onDestroy();
        }
    }
}
