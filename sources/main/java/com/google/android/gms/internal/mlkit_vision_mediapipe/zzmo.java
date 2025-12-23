package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzmo implements Iterator {
    final /* synthetic */ zzms zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i6;
        Object[] objArr;
        this.zzc = true;
        int i7 = this.zzb + 1;
        this.zzb = i7;
        zzms zzmsVar = this.zza;
        i6 = zzmsVar.zzb;
        if (i7 >= i6) {
            return (Map.Entry) zza().next();
        }
        objArr = zzmsVar.zza;
        return (zzmm) objArr[i7];
    }

    /* synthetic */ zzmo(zzms zzmsVar, zzmn zzmnVar) {
        this.zza = zzmsVar;
    }

    private final Iterator zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i6;
        Map map;
        int i7 = this.zzb + 1;
        zzms zzmsVar = this.zza;
        i6 = zzmsVar.zzb;
        if (i7 < i6) {
            return true;
        }
        map = zzmsVar.zzc;
        return !map.isEmpty() && zza().hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i6;
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzo();
        int i7 = this.zzb;
        zzms zzmsVar = this.zza;
        i6 = zzmsVar.zzb;
        if (i7 >= i6) {
            zza().remove();
        } else {
            this.zzb = i7 - 1;
            zzmsVar.zzm(i7);
        }
    }
}
