package com.google.android.gms.internal.mlkit_vision_pose_common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzau {
    static Object zzd(int i6) {
        if (i6 >= 2 && i6 <= 1073741824 && Integer.highestOneBit(i6) == i6) {
            return i6 <= 256 ? new byte[i6] : i6 <= 65536 ? new short[i6] : new int[i6];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i6);
    }

    static int zza(int i6) {
        return (i6 < 32 ? 4 : 2) * (i6 + 1);
    }

    static int zzc(Object obj, int i6) {
        return obj instanceof byte[] ? ((byte[]) obj)[i6] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i6] : ((int[]) obj)[i6];
    }

    static void zze(Object obj, int i6, int i7) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i6] = (byte) i7;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i6] = (short) i7;
        } else {
            ((int[]) obj)[i6] = i7;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        if (r5 != (-1)) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        zze(r11, r1, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        r12[r5] = (r12[r5] & r4) | (r7 & r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int zzb(@javax.annotation.CheckForNull java.lang.Object r8, @javax.annotation.CheckForNull java.lang.Object r9, int r10, java.lang.Object r11, int[] r12, java.lang.Object[] r13, @javax.annotation.CheckForNull java.lang.Object[] r14) {
        /*
            int r0 = com.google.android.gms.internal.mlkit_vision_pose_common.zzav.zzb(r8)
            r1 = r0 & r10
            int r2 = zzc(r11, r1)
            r3 = -1
            if (r2 == 0) goto L3e
            int r4 = ~r10
            r0 = r0 & r4
            r5 = -1
        L10:
            int r2 = r2 + r3
            r6 = r12[r2]
            r7 = r6 & r10
            r6 = r6 & r4
            if (r6 != r0) goto L39
            r6 = r13[r2]
            boolean r6 = com.google.android.gms.internal.mlkit_vision_pose_common.zzp.zza(r8, r6)
            if (r6 == 0) goto L39
            if (r14 == 0) goto L2a
            r6 = r14[r2]
            boolean r6 = com.google.android.gms.internal.mlkit_vision_pose_common.zzp.zza(r9, r6)
            if (r6 == 0) goto L39
        L2a:
            if (r5 != r3) goto L30
            zze(r11, r1, r7)
            return r2
        L30:
            r8 = r12[r5]
            r8 = r8 & r4
            r9 = r7 & r10
            r8 = r8 | r9
            r12[r5] = r8
            return r2
        L39:
            if (r7 == 0) goto L3e
            r5 = r2
            r2 = r7
            goto L10
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzau.zzb(java.lang.Object, java.lang.Object, int, java.lang.Object, int[], java.lang.Object[], java.lang.Object[]):int");
    }
}
