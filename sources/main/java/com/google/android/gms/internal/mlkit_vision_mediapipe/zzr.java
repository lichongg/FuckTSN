package com.google.android.gms.internal.mlkit_vision_mediapipe;

import io.netty.util.internal.StringUtil;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzr extends zzai {
    zzr(String str, Class cls, boolean z5) {
        super("group_by", cls, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzai
    public final void zza(Iterator it, zzah zzahVar) {
        if (it.hasNext()) {
            Object next = it.next();
            if (!it.hasNext()) {
                zzahVar.zza(zzf(), next);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            sb.append(next);
            do {
                sb.append(StringUtil.COMMA);
                sb.append(it.next());
            } while (it.hasNext());
            String zzf = zzf();
            sb.append(']');
            zzahVar.zza(zzf, sb.toString());
        }
    }
}
