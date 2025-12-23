package com.google.android.gms.internal.mlkit_vision_pose_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzwe implements zzwb {

    @VisibleForTesting
    final List zza;

    @Override // com.google.android.gms.internal.mlkit_vision_pose_common.zzwb
    public final void zza(zzwa zzwaVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzwb) it.next()).zza(zzwaVar);
        }
    }

    public zzwe(Context context, zzwd zzwdVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzwdVar.zzc()) {
            arrayList.add(new zzws(context, zzwdVar));
        }
    }
}
