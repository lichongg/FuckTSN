package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Calendar;
import java.util.Date;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzaw extends zzdt implements zzdp {
    protected final Object[] zza;
    protected final StringBuilder zzb;
    private int zzc;

    private static void zzm(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzbf.zza(obj));
        sb.append("]");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdp
    public final void zze(Object obj, zzdm zzdmVar, zzay zzayVar) {
        if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof Long)) {
            StringBuilder sb = new StringBuilder("%");
            zzayVar.zzh(sb);
            sb.append(true != zzayVar.zzk() ? 't' : 'T');
            sb.append(zzdmVar.zza());
            this.zzb.append(String.format(zzbf.zza, sb.toString(), obj));
            return;
        }
        zzm(this.zzb, obj, "%t" + zzdmVar.zza());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdp
    public final void zzf() {
        this.zzb.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdp
    public final void zzg() {
        this.zzb.append("null");
    }

    protected zzaw(zzcj zzcjVar, Object[] objArr, StringBuilder sb) {
        super(zzcjVar);
        this.zzc = 0;
        zzdy.zza(objArr, "arguments");
        this.zza = objArr;
        this.zzb = sb;
    }

    public static StringBuilder zzb(zzbb zzbbVar, StringBuilder sb) {
        if (zzbbVar.zzi() != null) {
            zzaw zzawVar = new zzaw(zzbbVar.zzi(), zzbbVar.zzq(), sb);
            StringBuilder sb2 = (StringBuilder) zzawVar.zzj();
            if (zzbbVar.zzq().length > zzawVar.zzh()) {
                sb2.append(" [ERROR: UNUSED LOG ARGUMENTS]");
            }
            return sb2;
        }
        sb.append(zzbf.zza(zzbbVar.zzj()));
        return sb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdt
    public final /* bridge */ /* synthetic */ Object zza() {
        zzi().zzd(this.zzb, zzk(), this.zzc, zzk().length());
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdt
    public final void zzc(int i6, int i7, zzdo zzdoVar) {
        zzi().zzd(this.zzb, zzk(), this.zzc, i6);
        zzdoVar.zze(this, this.zza);
        this.zzc = i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        if ((r7 instanceof java.math.BigDecimal) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003b, code lost:
    
        if ((r7 instanceof java.math.BigInteger) == false) goto L16;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(java.lang.Object r7, com.google.android.gms.internal.mlkit_vision_mediapipe.zzax r8, com.google.android.gms.internal.mlkit_vision_mediapipe.zzay r9) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzaw.zzd(java.lang.Object, com.google.android.gms.internal.mlkit_vision_mediapipe.zzax, com.google.android.gms.internal.mlkit_vision_mediapipe.zzay):void");
    }
}
