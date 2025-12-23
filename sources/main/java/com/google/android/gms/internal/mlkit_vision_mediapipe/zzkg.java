package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzkg {
    private static final zzkg zzb = new zzkg(true);
    final zzms zza = new zzml();
    private boolean zzc;
    private boolean zzd;

    private zzkg() {
    }

    private zzkg(boolean z5) {
        zzh();
        zzh();
    }

    static int zza(zznh zznhVar, int i6, Object obj) {
        zzjw.zzz(i6 << 3);
        if (zznh.zzj == null) {
            byte[] bArr = zzkz.zzb;
            if (((zzlw) obj) instanceof zziw) {
                throw null;
            }
        }
        zzni zzniVar = zzni.INT;
        throw null;
    }

    public static zzkg zze() {
        return zzb;
    }

    private static Object zzm(Object obj) {
        if (obj instanceof zzmb) {
            return ((zzmb) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static boolean zzp(Object obj) {
        if (obj instanceof zzlx) {
            return ((zzlx) obj).zzp();
        }
        if (obj instanceof zzlg) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkg) {
            return this.zza.equals(((zzkg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzc() {
        int zzc = this.zza.zzc();
        int i6 = 0;
        for (int i7 = 0; i7 < zzc; i7++) {
            i6 += zzq(this.zza.zzg(i7));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            i6 += zzq((Map.Entry) it.next());
        }
        return i6;
    }

    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzkg clone() {
        zzkg zzkgVar = new zzkg();
        int zzc = this.zza.zzc();
        for (int i6 = 0; i6 < zzc; i6++) {
            Map.Entry zzg = this.zza.zzg(i6);
            zzkgVar.zzj((zzkf) ((zzmm) zzg).zza(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzkgVar.zzj((zzkf) entry.getKey(), entry.getValue());
        }
        zzkgVar.zzd = this.zzd;
        return zzkgVar;
    }

    public final Object zzf(zzkf zzkfVar) {
        Object obj = this.zza.get(zzkfVar);
        if (obj instanceof zzlg) {
            throw null;
        }
        return obj;
    }

    public final Iterator zzg() {
        return this.zza.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzlf(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzh() {
        if (this.zzc) {
            return;
        }
        int zzc = this.zza.zzc();
        for (int i6 = 0; i6 < zzc; i6++) {
            Map.Entry zzg = this.zza.zzg(i6);
            if (zzg.getValue() instanceof zzkr) {
                ((zzkr) zzg.getValue()).zzC();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzi(zzkg zzkgVar) {
        int zzc = zzkgVar.zza.zzc();
        for (int i6 = 0; i6 < zzc; i6++) {
            zzn(zzkgVar.zza.zzg(i6));
        }
        Iterator it = zzkgVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzn((Map.Entry) it.next());
        }
    }

    public final boolean zzk() {
        return this.zzc;
    }

    public final boolean zzl() {
        int zzc = this.zza.zzc();
        for (int i6 = 0; i6 < zzc; i6++) {
            if (!zzo(this.zza.zzg(i6))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zzo((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static int zzb(zzkf zzkfVar, Object obj) {
        zznh zzd = zzkfVar.zzd();
        int zza = zzkfVar.zza();
        if (zzkfVar.zzg()) {
            List list = (List) obj;
            int size = list.size();
            if (zzkfVar.zzf()) {
                if (list.isEmpty()) {
                    return 0;
                }
                if (size <= 0) {
                    return zzjw.zzz(zza << 3) + zzjw.zzz(0);
                }
                list.get(0);
                zznh zznhVar = zznh.zza;
                zzni zzniVar = zzni.INT;
                throw null;
            }
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                i6 += zza(zzd, zza, list.get(i7));
            }
            return i6;
        }
        return zza(zzd, zza, obj);
    }

    private final void zzn(Map.Entry entry) {
        zzlw zzk;
        zzkf zzkfVar = (zzkf) entry.getKey();
        Object value = entry.getValue();
        boolean z5 = value instanceof zzlg;
        if (zzkfVar.zzg()) {
            if (!z5) {
                Object zzf = zzf(zzkfVar);
                List list = (List) value;
                int size = list.size();
                if (zzf == null) {
                    zzf = new ArrayList(size);
                }
                List list2 = (List) zzf;
                for (int i6 = 0; i6 < size; i6++) {
                    list2.add(zzm(list.get(i6)));
                }
                this.zza.put(zzkfVar, zzf);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        }
        if (zzkfVar.zze() == zzni.MESSAGE) {
            Object zzf2 = zzf(zzkfVar);
            if (zzf2 == null) {
                this.zza.put(zzkfVar, zzm(value));
                if (z5) {
                    this.zzd = true;
                    return;
                }
                return;
            }
            if (!z5) {
                if (zzf2 instanceof zzmb) {
                    zzk = zzkfVar.zzc((zzmb) zzf2, (zzmb) value);
                } else {
                    zzk = zzkfVar.zzb(((zzlw) zzf2).zzK(), (zzlw) value).zzk();
                }
                this.zza.put(zzkfVar, zzk);
                return;
            }
            throw null;
        }
        if (!z5) {
            this.zza.put(zzkfVar, zzm(value));
            return;
        }
        throw new IllegalStateException("Lazy fields must be message-valued");
    }

    private static boolean zzo(Map.Entry entry) {
        zzkf zzkfVar = (zzkf) entry.getKey();
        if (zzkfVar.zze() == zzni.MESSAGE) {
            if (zzkfVar.zzg()) {
                List list = (List) entry.getValue();
                int size = list.size();
                for (int i6 = 0; i6 < size; i6++) {
                    if (!zzp(list.get(i6))) {
                        return false;
                    }
                }
                return true;
            }
            return zzp(entry.getValue());
        }
        return true;
    }

    private static final int zzq(Map.Entry entry) {
        int i6;
        int zzz;
        int zzz2;
        int zzn;
        int zzz3;
        zzkf zzkfVar = (zzkf) entry.getKey();
        Object value = entry.getValue();
        if (zzkfVar.zze() == zzni.MESSAGE && !zzkfVar.zzg() && !zzkfVar.zzf()) {
            if (value instanceof zzlg) {
                int zza = ((zzkf) entry.getKey()).zza();
                int zzz4 = zzjw.zzz(8);
                i6 = zzz4 + zzz4;
                zzz = zzjw.zzz(16) + zzjw.zzz(zza);
                zzz2 = zzjw.zzz(24);
                zzn = ((zzlg) value).zza();
                zzz3 = zzjw.zzz(zzn);
            } else {
                int zza2 = ((zzkf) entry.getKey()).zza();
                int zzz5 = zzjw.zzz(8);
                i6 = zzz5 + zzz5;
                zzz = zzjw.zzz(16) + zzjw.zzz(zza2);
                zzz2 = zzjw.zzz(24);
                zzn = ((zzlw) value).zzn();
                zzz3 = zzjw.zzz(zzn);
            }
            return i6 + zzz + zzz2 + zzz3 + zzn;
        }
        return zzb(zzkfVar, value);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzr(com.google.android.gms.internal.mlkit_vision_mediapipe.zzkf r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.mlkit_vision_mediapipe.zznh r0 = r4.zzd()
            byte[] r1 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzkz.zzb
            r5.getClass()
            com.google.android.gms.internal.mlkit_vision_mediapipe.zznh r1 = com.google.android.gms.internal.mlkit_vision_mediapipe.zznh.zza
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzni r1 = com.google.android.gms.internal.mlkit_vision_mediapipe.zzni.INT
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzni r0 = r0.zza()
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
            boolean r0 = r5 instanceof com.google.android.gms.internal.mlkit_vision_mediapipe.zzlw
            if (r0 != 0) goto L21
            boolean r0 = r5 instanceof com.google.android.gms.internal.mlkit_vision_mediapipe.zzlg
            if (r0 == 0) goto L48
        L21:
            return
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L2a
            boolean r0 = r5 instanceof com.google.android.gms.internal.mlkit_vision_mediapipe.zzkt
            if (r0 == 0) goto L48
        L2a:
            return
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.mlkit_vision_mediapipe.zzjo
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
            com.google.android.gms.internal.mlkit_vision_mediapipe.zznh r4 = r4.zzd()
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzni r4 = r4.zza()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzkg.zzr(com.google.android.gms.internal.mlkit_vision_mediapipe.zzkf, java.lang.Object):void");
    }

    public final void zzj(zzkf zzkfVar, Object obj) {
        if (zzkfVar.zzg()) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i6 = 0; i6 < size; i6++) {
                    Object obj2 = list.get(i6);
                    zzr(zzkfVar, obj2);
                    arrayList.add(obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzr(zzkfVar, obj);
        }
        if (obj instanceof zzlg) {
            this.zzd = true;
        }
        this.zza.put(zzkfVar, obj);
    }
}
