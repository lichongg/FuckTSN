package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzsc implements zzrz {

    @VisibleForTesting
    final List zza;

    @Override // com.google.android.gms.internal.mlkit_common.zzrz
    public final void zza(zzry zzryVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzrz) it.next()).zza(zzryVar);
        }
    }

    public zzsc(Context context, zzsb zzsbVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzsbVar.zzc()) {
            arrayList.add(new zzsp(context, zzsbVar));
        }
    }
}
