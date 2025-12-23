package com.google.android.gms.internal.mlkit_acceleration;

import com.google.android.gms.internal.mlkit_acceleration.zzdr;
import com.google.android.gms.internal.mlkit_acceleration.zzdv;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class zzdr<MessageType extends zzdv<MessageType, BuilderType>, BuilderType extends zzdr<MessageType, BuilderType>> extends zzcb<MessageType, BuilderType> {
    protected zzdv zza;
    private final zzdv zzb;

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfb
    public final /* synthetic */ zzfa zzP() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzcb
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final zzdr clone() {
        zzdr zzdrVar = (zzdr) this.zzb.zzo(5, null, null);
        zzdrVar.zza = zzn();
        return zzdrVar;
    }

    public final zzdr zzk(zzdv zzdvVar) {
        if (!this.zzb.equals(zzdvVar)) {
            if (!this.zza.zzO()) {
                zzq();
            }
            zza(this.zza, zzdvVar);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzez
    /* renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public MessageType zzn() {
        if (!this.zza.zzO()) {
            return (MessageType) this.zza;
        }
        this.zza.zzI();
        return (MessageType) this.zza;
    }

    protected final void zzp() {
        if (this.zza.zzO()) {
            return;
        }
        zzq();
    }

    protected void zzq() {
        zzdv zzB = this.zzb.zzB();
        zza(zzB, this.zza);
        this.zza = zzB;
    }

    protected zzdr(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzO()) {
            this.zza = messagetype.zzB();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzfi.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final MessageType zzl() {
        MessageType zzn = zzn();
        if (zzn.zzN()) {
            return zzn;
        }
        throw new zzgc(zzn);
    }
}
