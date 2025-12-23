package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.google.android.gms.internal.mlkit_vision_mediapipe.zzkk;
import com.google.android.gms.internal.mlkit_vision_mediapipe.zzkr;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzkk<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkk<MessageType, BuilderType>> extends zziu<MessageType, BuilderType> {
    protected zzkr zza;
    private final zzkr zzb;

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlx
    public final /* bridge */ /* synthetic */ zzlw zzm() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zziu
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzkk clone() {
        zzkk zzkkVar = (zzkk) this.zzb.zzb(5, null, null);
        zzkkVar.zza = zzl();
        return zzkkVar;
    }

    public final zzkk zzh(zzkr zzkrVar) {
        if (!this.zzb.equals(zzkrVar)) {
            if (!this.zza.zzH()) {
                zzo();
            }
            zza(this.zza, zzkrVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlv
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public MessageType zzl() {
        if (!this.zza.zzH()) {
            return (MessageType) this.zza;
        }
        this.zza.zzC();
        return (MessageType) this.zza;
    }

    protected final void zzn() {
        if (this.zza.zzH()) {
            return;
        }
        zzo();
    }

    protected void zzo() {
        zzkr zzt = this.zzb.zzt();
        zza(zzt, this.zza);
        this.zza = zzt;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlx
    public final boolean zzp() {
        return zzkr.zzG(this.zza, false);
    }

    protected zzkk(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzH()) {
            this.zza = messagetype.zzt();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzmf.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzlv
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final MessageType zzk() {
        MessageType zzl = zzl();
        if (zzkr.zzG(zzl, true)) {
            return zzl;
        }
        throw new zzmv(zzl);
    }
}
