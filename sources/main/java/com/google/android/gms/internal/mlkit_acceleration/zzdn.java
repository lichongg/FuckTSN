package com.google.android.gms.internal.mlkit_acceleration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzdn {
    private static final zzdn zzb = new zzdn(true);
    final zzfz zza = new zzfp(16);
    private boolean zzc;
    private boolean zzd;

    private zzdn() {
    }

    public static zzdn zza() {
        throw null;
    }

    private zzdn(boolean z5) {
        zzb();
        zzb();
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdn zzdnVar = new zzdn();
        for (int i6 = 0; i6 < this.zza.zzb(); i6++) {
            Map.Entry zzg = this.zza.zzg(i6);
            zzdnVar.zzc((zzdm) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzdnVar.zzc((zzdm) entry.getKey(), entry.getValue());
        }
        zzdnVar.zzd = this.zzd;
        return zzdnVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdn) {
            return this.zza.equals(((zzdn) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        for (int i6 = 0; i6 < this.zza.zzb(); i6++) {
            Map.Entry zzg = this.zza.zzg(i6);
            if (zzg.getValue() instanceof zzdv) {
                ((zzdv) zzg.getValue()).zzI();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.mlkit_acceleration.zzdm r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.mlkit_acceleration.zzgt r0 = r4.zzb()
            byte[] r1 = com.google.android.gms.internal.mlkit_acceleration.zzeb.zzd
            r5.getClass()
            com.google.android.gms.internal.mlkit_acceleration.zzgt r1 = com.google.android.gms.internal.mlkit_acceleration.zzgt.zza
            com.google.android.gms.internal.mlkit_acceleration.zzgu r1 = com.google.android.gms.internal.mlkit_acceleration.zzgu.INT
            com.google.android.gms.internal.mlkit_acceleration.zzgu r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.gms.internal.mlkit_acceleration.zzfa
            if (r0 != 0) goto L21
            boolean r0 = r5 instanceof com.google.android.gms.internal.mlkit_acceleration.zzef
            if (r0 == 0) goto L48
        L21:
            return
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L2a
            boolean r0 = r5 instanceof com.google.android.gms.internal.mlkit_acceleration.zzdx
            if (r0 == 0) goto L48
        L2a:
            return
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.mlkit_acceleration.zzcs
            if (r0 != 0) goto L33
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
        L33:
            return
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.zza()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.android.gms.internal.mlkit_acceleration.zzgt r4 = r4.zzb()
            com.google.android.gms.internal.mlkit_acceleration.zzgu r4 = r4.zza()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r4
            r4 = 2
            r2[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzdn.zzd(com.google.android.gms.internal.mlkit_acceleration.zzdm, java.lang.Object):void");
    }

    public final void zzc(zzdm zzdmVar, Object obj) {
        if (zzdmVar.zzc()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    zzd(zzdmVar, arrayList.get(i6));
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzd(zzdmVar, obj);
        }
        if (obj instanceof zzef) {
            this.zzd = true;
        }
        this.zza.put(zzdmVar, obj);
    }
}
