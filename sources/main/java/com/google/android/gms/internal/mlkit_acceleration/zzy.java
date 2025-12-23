package com.google.android.gms.internal.mlkit_acceleration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzy extends zzad {
    final /* synthetic */ zzz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzy(zzz zzzVar, zzaf zzafVar, CharSequence charSequence) {
        super(zzafVar, charSequence);
        this.zza = zzzVar;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzad
    public final int zzc(int i6) {
        return i6 + this.zza.zza.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r7 = r7 + 1;
     */
    @Override // com.google.android.gms.internal.mlkit_acceleration.zzad
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(int r7) {
        /*
            r6 = this;
            java.lang.CharSequence r0 = r6.zzb
            int r0 = r0.length()
            com.google.android.gms.internal.mlkit_acceleration.zzz r1 = r6.zza
            java.lang.String r1 = r1.zza
            int r1 = r1.length()
            int r0 = r0 - r1
        Lf:
            if (r7 > r0) goto L2d
            r2 = 0
        L12:
            if (r2 >= r1) goto L2c
            java.lang.CharSequence r3 = r6.zzb
            int r4 = r2 + r7
            com.google.android.gms.internal.mlkit_acceleration.zzz r5 = r6.zza
            java.lang.String r5 = r5.zza
            char r3 = r3.charAt(r4)
            char r4 = r5.charAt(r2)
            if (r3 == r4) goto L29
            int r7 = r7 + 1
            goto Lf
        L29:
            int r2 = r2 + 1
            goto L12
        L2c:
            return r7
        L2d:
            r7 = -1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzy.zzd(int):int");
    }
}
