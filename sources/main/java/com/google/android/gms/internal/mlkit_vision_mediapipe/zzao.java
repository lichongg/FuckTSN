package com.google.android.gms.internal.mlkit_vision_mediapipe;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzao {
    public static final zzao zzc = new zzaj();
    public static final zzao zzd = new zzaj();

    protected abstract void zzb();

    @NullableDecl
    static zzao zzc(@NullableDecl zzao zzaoVar, @NullableDecl zzao zzaoVar2) {
        zzao zzaoVar3;
        zzao zzaoVar4;
        return zzaoVar == null ? zzaoVar2 : (zzaoVar2 == null || zzaoVar == (zzaoVar3 = zzc) || zzaoVar2 == (zzaoVar4 = zzd)) ? zzaoVar : (zzaoVar2 == zzaoVar3 || zzaoVar == zzaoVar4) ? zzaoVar2 : new zzak(zzaoVar, zzaoVar2);
    }

    protected zzao() {
    }
}
