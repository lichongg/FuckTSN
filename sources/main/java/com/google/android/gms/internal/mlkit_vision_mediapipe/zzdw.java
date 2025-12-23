package com.google.android.gms.internal.mlkit_vision_mediapipe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class zzdw extends zzdu {
    private static final String zza;

    abstract int zza(zzdt zzdtVar, int i6, String str, int i7, int i8, int i9) throws zzdv;

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdu
    public final void zzd(StringBuilder sb, String str, int i6, int i7) {
        int i8 = i6;
        while (i6 < i7) {
            int i9 = i6 + 1;
            if (str.charAt(i6) == '%') {
                if (i9 == i7) {
                    break;
                }
                char charAt = str.charAt(i9);
                if (charAt == '%') {
                    sb.append((CharSequence) str, i8, i9);
                } else if (charAt == 'n') {
                    sb.append((CharSequence) str, i8, i6);
                    sb.append(zza);
                }
                i8 = i6 + 2;
                i6 = i8;
            }
            i6 = i9;
        }
        if (i8 < i7) {
            sb.append((CharSequence) str, i8, i7);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        if (r0.matches("\\n|\\r(?:\\n)?") == false) goto L4;
     */
    static {
        /*
            java.lang.String r0 = "line.separator"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.SecurityException -> Le
            java.lang.String r1 = "\\n|\\r(?:\\n)?"
            boolean r1 = r0.matches(r1)     // Catch: java.lang.SecurityException -> Le
            if (r1 != 0) goto L10
        Le:
            java.lang.String r0 = "\n"
        L10:
            com.google.android.gms.internal.mlkit_vision_mediapipe.zzdw.zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzdw.<clinit>():void");
    }

    static int zze(String str, int i6) throws zzdv {
        while (i6 < str.length()) {
            int i7 = i6 + 1;
            if (str.charAt(i6) != '%') {
                i6 = i7;
            } else if (i7 < str.length()) {
                char charAt = str.charAt(i7);
                if (charAt != '%' && charAt != 'n') {
                    return i6;
                }
                i6 += 2;
            } else {
                throw zzdv.zzd("trailing unquoted '%' character", str, i6);
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
    
        r1 = r15;
        r4 = zze(r3, zza(r1, r2, r3, r4, r5, r6));
        r15 = r1;
        r1 = r2;
        r0 = r9;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzdu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzc(com.google.android.gms.internal.mlkit_vision_mediapipe.zzdt r15) throws com.google.android.gms.internal.mlkit_vision_mediapipe.zzdv {
        /*
            Method dump skipped, instructions count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzdw.zzc(com.google.android.gms.internal.mlkit_vision_mediapipe.zzdt):void");
    }
}
