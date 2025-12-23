package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzlz<T> implements zzmi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zznd.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzlw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzmw zzl;
    private final zzkc zzm;

    private zzlz(int[] iArr, Object[] objArr, int i6, int i7, zzlw zzlwVar, boolean z5, int[] iArr2, int i8, int i9, zzmc zzmcVar, zzlj zzljVar, zzmw zzmwVar, zzkc zzkcVar, zzlr zzlrVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i6;
        this.zzf = i7;
        boolean z6 = false;
        if (zzkcVar != null && (zzlwVar instanceof zzkn)) {
            z6 = true;
        }
        this.zzh = z6;
        this.zzi = iArr2;
        this.zzj = i8;
        this.zzk = i9;
        this.zzl = zzmwVar;
        this.zzm = zzkcVar;
        this.zzg = zzlwVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final int zzb(Object obj) {
        int i6;
        long doubleToLongBits;
        int i7;
        int floatToIntBits;
        int i8;
        int i9 = 0;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzs = zzs(i10);
            int[] iArr = this.zzc;
            int i11 = 1048575 & zzs;
            int zzr = zzr(zzs);
            int i12 = iArr[i10];
            long j6 = i11;
            int i13 = 37;
            switch (zzr) {
                case 0:
                    i6 = i9 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zznd.zza(obj, j6));
                    byte[] bArr = zzkz.zzb;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 1:
                    i7 = i9 * 53;
                    floatToIntBits = Float.floatToIntBits(zznd.zzb(obj, j6));
                    i9 = i7 + floatToIntBits;
                    break;
                case 2:
                    i6 = i9 * 53;
                    doubleToLongBits = zznd.zzd(obj, j6);
                    byte[] bArr2 = zzkz.zzb;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 3:
                    i6 = i9 * 53;
                    doubleToLongBits = zznd.zzd(obj, j6);
                    byte[] bArr3 = zzkz.zzb;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 4:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 5:
                    i6 = i9 * 53;
                    doubleToLongBits = zznd.zzd(obj, j6);
                    byte[] bArr4 = zzkz.zzb;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 6:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 7:
                    i7 = i9 * 53;
                    floatToIntBits = zzkz.zza(zznd.zzw(obj, j6));
                    i9 = i7 + floatToIntBits;
                    break;
                case 8:
                    i7 = i9 * 53;
                    floatToIntBits = ((String) zznd.zzf(obj, j6)).hashCode();
                    i9 = i7 + floatToIntBits;
                    break;
                case 9:
                    i8 = i9 * 53;
                    Object zzf = zznd.zzf(obj, j6);
                    if (zzf != null) {
                        i13 = zzf.hashCode();
                    }
                    i9 = i8 + i13;
                    break;
                case 10:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzf(obj, j6).hashCode();
                    i9 = i7 + floatToIntBits;
                    break;
                case 11:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 12:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 13:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 14:
                    i6 = i9 * 53;
                    doubleToLongBits = zznd.zzd(obj, j6);
                    byte[] bArr5 = zzkz.zzb;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 15:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 16:
                    i6 = i9 * 53;
                    doubleToLongBits = zznd.zzd(obj, j6);
                    byte[] bArr6 = zzkz.zzb;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 17:
                    i8 = i9 * 53;
                    Object zzf2 = zznd.zzf(obj, j6);
                    if (zzf2 != null) {
                        i13 = zzf2.hashCode();
                    }
                    i9 = i8 + i13;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzf(obj, j6).hashCode();
                    i9 = i7 + floatToIntBits;
                    break;
                case 50:
                    i7 = i9 * 53;
                    floatToIntBits = zznd.zzf(obj, j6).hashCode();
                    i9 = i7 + floatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzm(obj, j6));
                        byte[] bArr7 = zzkz.zzb;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = Float.floatToIntBits(zzn(obj, j6));
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzM(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzt(obj, j6);
                        byte[] bArr8 = zzkz.zzb;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzM(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzt(obj, j6);
                        byte[] bArr9 = zzkz.zzb;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzo(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzM(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzt(obj, j6);
                        byte[] bArr10 = zzkz.zzb;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzo(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzkz.zza(zzN(obj, j6));
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = ((String) zznd.zzf(obj, j6)).hashCode();
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zznd.zzf(obj, j6).hashCode();
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zznd.zzf(obj, j6).hashCode();
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzo(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzo(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzo(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzM(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzt(obj, j6);
                        byte[] bArr11 = zzkz.zzb;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzo(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzM(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzt(obj, j6);
                        byte[] bArr12 = zzkz.zzb;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzM(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zznd.zzf(obj, j6).hashCode();
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i9 * 53) + ((zzkr) obj).zzc.hashCode();
        return this.zzh ? (hashCode * 53) + ((zzkn) obj).zzb.zza.hashCode() : hashCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0e99, code lost:
    
        if (r9 == 1048575) goto L582;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0e9b, code lost:
    
        r25.putInt(r2, r9, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0ea1, code lost:
    
        r1 = r12.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0ea5, code lost:
    
        if (r1 >= r12.zzk) goto L698;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0ea7, code lost:
    
        r3 = r12.zzi;
        r6 = r12.zzc;
        r3 = r3[r1];
        r6 = r6[r3];
        r6 = com.google.android.gms.internal.mlkit_vision_mediapipe.zznd.zzf(r2, r12.zzs(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0ebd, code lost:
    
        if (r6 != null) goto L588;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0ec4, code lost:
    
        if (r12.zzu(r3) != null) goto L697;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0ec9, code lost:
    
        r6 = (com.google.android.gms.internal.mlkit_vision_mediapipe.zzlq) r6;
        r0 = (com.google.android.gms.internal.mlkit_vision_mediapipe.zzlp) r12.zzw(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0ed1, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0ec6, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0ed4, code lost:
    
        if (r0 != 0) goto L599;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0ed6, code lost:
    
        if (r5 != r4) goto L597;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0ede, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_mediapipe.zzlb("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0ee3, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0edf, code lost:
    
        if (r5 > r4) goto L602;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0ee1, code lost:
    
        if (r15 != r0) goto L602;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0ee9, code lost:
    
        throw new com.google.android.gms.internal.mlkit_vision_mediapipe.zzlb("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0b8f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0ba2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0e14 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0e28 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0e2f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0e43  */
    /* JADX WARN: Removed duplicated region for block: B:756:0x0052 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzc(java.lang.Object r37, byte[] r38, int r39, int r40, int r41, com.google.android.gms.internal.mlkit_vision_mediapipe.zzjd r42) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3962
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzlz.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_mediapipe.zzjd):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final void zzh(Object obj, byte[] bArr, int i6, int i7, zzjd zzjdVar) throws IOException {
        zzc(obj, bArr, i6, i7, 0, zzjdVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final boolean zzj(Object obj, Object obj2) {
        boolean zzE;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzs = zzs(i6);
            long j6 = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (zzH(obj, obj2, i6) && Double.doubleToLongBits(zznd.zza(obj, j6)) == Double.doubleToLongBits(zznd.zza(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzH(obj, obj2, i6) && Float.floatToIntBits(zznd.zzb(obj, j6)) == Float.floatToIntBits(zznd.zzb(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzH(obj, obj2, i6) && zznd.zzd(obj, j6) == zznd.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzH(obj, obj2, i6) && zznd.zzd(obj, j6) == zznd.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzH(obj, obj2, i6) && zznd.zzc(obj, j6) == zznd.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzH(obj, obj2, i6) && zznd.zzd(obj, j6) == zznd.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzH(obj, obj2, i6) && zznd.zzc(obj, j6) == zznd.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzH(obj, obj2, i6) && zznd.zzw(obj, j6) == zznd.zzw(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzH(obj, obj2, i6) && zzmk.zzE(zznd.zzf(obj, j6), zznd.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzH(obj, obj2, i6) && zzmk.zzE(zznd.zzf(obj, j6), zznd.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzH(obj, obj2, i6) && zzmk.zzE(zznd.zzf(obj, j6), zznd.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzH(obj, obj2, i6) && zznd.zzc(obj, j6) == zznd.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzH(obj, obj2, i6) && zznd.zzc(obj, j6) == zznd.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzH(obj, obj2, i6) && zznd.zzc(obj, j6) == zznd.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzH(obj, obj2, i6) && zznd.zzd(obj, j6) == zznd.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzH(obj, obj2, i6) && zznd.zzc(obj, j6) == zznd.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzH(obj, obj2, i6) && zznd.zzd(obj, j6) == zznd.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzH(obj, obj2, i6) && zzmk.zzE(zznd.zzf(obj, j6), zznd.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzE = zzmk.zzE(zznd.zzf(obj, j6), zznd.zzf(obj2, j6));
                    break;
                case 50:
                    zzE = zzmk.zzE(zznd.zzf(obj, j6), zznd.zzf(obj2, j6));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzp = zzp(i6) & 1048575;
                    if (zznd.zzc(obj, zzp) == zznd.zzc(obj2, zzp) && zzmk.zzE(zznd.zzf(obj, j6), zznd.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzE) {
                return false;
            }
        }
        if (!((zzkr) obj).zzc.equals(((zzkr) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzkn) obj).zzb.equals(((zzkn) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final boolean zzk(Object obj) {
        int i6;
        int i7;
        int i8 = 0;
        int i9 = 1048575;
        int i10 = 0;
        while (i8 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i11 = iArr[i8];
            int i12 = iArr2[i11];
            int zzs = zzs(i11);
            int i13 = this.zzc[i11 + 2];
            int i14 = i13 & 1048575;
            int i15 = 1 << (i13 >>> 20);
            if (i14 != i9) {
                if (i14 != 1048575) {
                    i10 = zzb.getInt(obj, i14);
                }
                i7 = i10;
                i6 = i14;
            } else {
                i6 = i9;
                i7 = i10;
            }
            Object obj2 = obj;
            if ((268435456 & zzs) != 0 && !zzJ(obj2, i11, i6, i7, i15)) {
                return false;
            }
            int zzr = zzr(zzs);
            if (zzr != 9 && zzr != 17) {
                if (zzr != 27) {
                    if (zzr == 60 || zzr == 68) {
                        if (zzM(obj2, i12, i11) && !zzK(obj2, zzs, zzv(i11))) {
                            return false;
                        }
                    } else if (zzr != 49) {
                        if (zzr == 50 && !((zzlq) zznd.zzf(obj2, zzs & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zznd.zzf(obj2, zzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzmi zzv = zzv(i11);
                    for (int i16 = 0; i16 < list.size(); i16++) {
                        if (!zzv.zzk(list.get(i16))) {
                            return false;
                        }
                    }
                }
            } else if (zzJ(obj2, i11, i6, i7, i15) && !zzK(obj2, zzs, zzv(i11))) {
                return false;
            }
            i8++;
            obj = obj2;
            i9 = i6;
            i10 = i7;
        }
        return !this.zzh || ((zzkn) obj).zzb.zzl();
    }

    private final void zzC(Object obj, Object obj2, int i6) {
        int i7 = this.zzc[i6];
        if (zzM(obj2, i7, i6)) {
            int zzs = zzs(i6) & 1048575;
            Unsafe unsafe = zzb;
            long j6 = zzs;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i6] + " is present but null: " + obj2.toString());
            }
            zzmi zzv = zzv(i6);
            if (!zzM(obj, i7, i6)) {
                if (zzL(object)) {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j6, zze);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zzE(obj, i7, i6);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j6, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, int i6, Object obj2) {
        zzb.putObject(obj, zzs(i6) & 1048575, obj2);
        zzD(obj, i6);
    }

    private final void zzG(Object obj, int i6, int i7, Object obj2) {
        zzb.putObject(obj, zzs(i7) & 1048575, obj2);
        zzE(obj, i6, i7);
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzkr) {
            return ((zzkr) obj).zzH();
        }
        return true;
    }

    private static final void zzO(int i6, Object obj, zznj zznjVar) throws IOException {
        if (obj instanceof String) {
            zznjVar.zzG(i6, (String) obj);
        } else {
            zznjVar.zzd(i6, (zzjo) obj);
        }
    }

    static zzmx zzd(Object obj) {
        zzkr zzkrVar = (zzkr) obj;
        zzmx zzmxVar = zzkrVar.zzc;
        if (zzmxVar != zzmx.zzc()) {
            return zzmxVar;
        }
        zzmx zzf = zzmx.zzf();
        zzkrVar.zzc = zzf;
        return zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0273  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.mlkit_vision_mediapipe.zzlz zzl(java.lang.Class r32, com.google.android.gms.internal.mlkit_vision_mediapipe.zzlt r33, com.google.android.gms.internal.mlkit_vision_mediapipe.zzmc r34, com.google.android.gms.internal.mlkit_vision_mediapipe.zzlj r35, com.google.android.gms.internal.mlkit_vision_mediapipe.zzmw r36, com.google.android.gms.internal.mlkit_vision_mediapipe.zzkc r37, com.google.android.gms.internal.mlkit_vision_mediapipe.zzlr r38) {
        /*
            Method dump skipped, instructions count: 1044
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzlz.zzl(java.lang.Class, com.google.android.gms.internal.mlkit_vision_mediapipe.zzlt, com.google.android.gms.internal.mlkit_vision_mediapipe.zzmc, com.google.android.gms.internal.mlkit_vision_mediapipe.zzlj, com.google.android.gms.internal.mlkit_vision_mediapipe.zzmw, com.google.android.gms.internal.mlkit_vision_mediapipe.zzkc, com.google.android.gms.internal.mlkit_vision_mediapipe.zzlr):com.google.android.gms.internal.mlkit_vision_mediapipe.zzlz");
    }

    private final int zzp(int i6) {
        return this.zzc[i6 + 2];
    }

    private final int zzq(int i6, int i7) {
        int length = (this.zzc.length / 3) - 1;
        while (i7 <= length) {
            int i8 = (length + i7) >>> 1;
            int i9 = i8 * 3;
            int i10 = this.zzc[i9];
            if (i6 == i10) {
                return i9;
            }
            if (i6 < i10) {
                length = i8 - 1;
            } else {
                i7 = i8 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i6) {
        return (i6 >>> 20) & 255;
    }

    private final int zzs(int i6) {
        return this.zzc[i6 + 1];
    }

    private final zzku zzu(int i6) {
        int i7 = i6 / 3;
        return (zzku) this.zzd[i7 + i7 + 1];
    }

    private final zzmi zzv(int i6) {
        Object[] objArr = this.zzd;
        int i7 = i6 / 3;
        int i8 = i7 + i7;
        zzmi zzmiVar = (zzmi) objArr[i8];
        if (zzmiVar != null) {
            return zzmiVar;
        }
        zzmi zzb2 = zzmf.zza().zzb((Class) objArr[i8 + 1]);
        this.zzd[i8] = zzb2;
        return zzb2;
    }

    private final Object zzw(int i6) {
        int i7 = i6 / 3;
        return this.zzd[i7 + i7];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final int zza(Object obj) {
        int i6;
        int zzz;
        int zzz2;
        int zzA;
        int zzz3;
        int zzz4;
        int zzz5;
        int zzd;
        int zzz6;
        int zzh;
        int zzg;
        int size;
        int zzl;
        int zzz7;
        int zzz8;
        int zzz9;
        int i7;
        int zze;
        int zzz10;
        int zzz11;
        int i8;
        int zzz12;
        int zzz13;
        int zzz14;
        int zzd2;
        int zzz15;
        zzlz<T> zzlzVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i9 = 1048575;
        int i10 = 0;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        while (i10 < zzlzVar.zzc.length) {
            int zzs = zzlzVar.zzs(i10);
            int zzr = zzr(zzs);
            int[] iArr = zzlzVar.zzc;
            int i14 = iArr[i10];
            int i15 = iArr[i10 + 2];
            int i16 = i15 & i9;
            if (zzr <= 17) {
                if (i16 != i11) {
                    i12 = i16 == i9 ? 0 : unsafe.getInt(obj2, i16);
                    i11 = i16;
                }
                i6 = 1 << (i15 >>> 20);
            } else {
                i6 = 0;
            }
            int i17 = zzs & i9;
            if (zzr >= zzkh.zzJ.zza()) {
                zzkh.zzW.zza();
            }
            int i18 = i13;
            long j6 = i17;
            switch (zzr) {
                case 0:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        i13 = i18 + zzjw.zzz(i14 << 3) + 8;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 1:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzz = zzjw.zzz(i14 << 3);
                        zzz4 = zzz + 4;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 2:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        long j7 = unsafe.getLong(obj2, j6);
                        zzz2 = zzjw.zzz(i14 << 3);
                        zzA = zzjw.zzA(j7);
                        zzz4 = zzz2 + zzA;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 3:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        long j8 = unsafe.getLong(obj2, j6);
                        zzz2 = zzjw.zzz(i14 << 3);
                        zzA = zzjw.zzA(j8);
                        zzz4 = zzz2 + zzA;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 4:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        long j9 = unsafe.getInt(obj2, j6);
                        zzz2 = zzjw.zzz(i14 << 3);
                        zzA = zzjw.zzA(j9);
                        zzz4 = zzz2 + zzA;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 5:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzz3 = zzjw.zzz(i14 << 3);
                        zzz4 = zzz3 + 8;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 6:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzz = zzjw.zzz(i14 << 3);
                        zzz4 = zzz + 4;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 7:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzz4 = zzjw.zzz(i14 << 3) + 1;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 8:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        int i19 = i14 << 3;
                        Object object = unsafe.getObject(obj2, j6);
                        if (object instanceof zzjo) {
                            zzz5 = zzjw.zzz(i19);
                            zzd = ((zzjo) object).zzd();
                            zzz6 = zzjw.zzz(zzd);
                            zzz4 = zzz5 + zzz6 + zzd;
                            i13 = i18 + zzz4;
                            zzlzVar = this;
                            i10 += 3;
                            obj2 = obj;
                            i9 = 1048575;
                        } else {
                            zzz2 = zzjw.zzz(i19);
                            zzA = zzjw.zzy((String) object);
                            zzz4 = zzz2 + zzA;
                            i13 = i18 + zzz4;
                            zzlzVar = this;
                            i10 += 3;
                            obj2 = obj;
                            i9 = 1048575;
                        }
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 9:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzh = zzmk.zzh(i14, unsafe.getObject(obj2, j6), zzlzVar.zzv(i10));
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 10:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzjo zzjoVar = (zzjo) unsafe.getObject(obj2, j6);
                        zzz5 = zzjw.zzz(i14 << 3);
                        zzd = zzjoVar.zzd();
                        zzz6 = zzjw.zzz(zzd);
                        zzz4 = zzz5 + zzz6 + zzd;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 11:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        int i20 = unsafe.getInt(obj2, j6);
                        zzz2 = zzjw.zzz(i14 << 3);
                        zzA = zzjw.zzz(i20);
                        zzz4 = zzz2 + zzA;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 12:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        long j10 = unsafe.getInt(obj2, j6);
                        zzz2 = zzjw.zzz(i14 << 3);
                        zzA = zzjw.zzA(j10);
                        zzz4 = zzz2 + zzA;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 13:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzz = zzjw.zzz(i14 << 3);
                        zzz4 = zzz + 4;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 14:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzz3 = zzjw.zzz(i14 << 3);
                        zzz4 = zzz3 + 8;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 15:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        int i21 = unsafe.getInt(obj2, j6);
                        zzz2 = zzjw.zzz(i14 << 3);
                        zzA = zzjw.zzz((i21 >> 31) ^ (i21 + i21));
                        zzz4 = zzz2 + zzA;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 16:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        long j11 = unsafe.getLong(obj2, j6);
                        zzz2 = zzjw.zzz(i14 << 3);
                        zzA = zzjw.zzA((j11 >> 63) ^ (j11 + j11));
                        zzz4 = zzz2 + zzA;
                        i13 = i18 + zzz4;
                        zzlzVar = this;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzlzVar = this;
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 17:
                    if (zzlzVar.zzJ(obj2, i10, i11, i12, i6)) {
                        zzh = zzjw.zzw(i14, (zzlw) unsafe.getObject(obj2, j6), zzlzVar.zzv(i10));
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 18:
                    zzh = zzmk.zzd(i14, (List) unsafe.getObject(obj2, j6), false);
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 19:
                    zzh = zzmk.zzb(i14, (List) unsafe.getObject(obj2, j6), false);
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj2, j6);
                    int i22 = zzmk.zza;
                    if (list.size() != 0) {
                        zzg = zzmk.zzg(list) + (list.size() * zzjw.zzz(i14 << 3));
                        i13 = zzg + i18;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzg = 0;
                    i13 = zzg + i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj2, j6);
                    int i23 = zzmk.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzl = zzmk.zzl(list2);
                        zzz7 = zzjw.zzz(i14 << 3);
                        i7 = size * zzz7;
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzh = 0;
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj2, j6);
                    int i24 = zzmk.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzl = zzmk.zzf(list3);
                        zzz7 = zzjw.zzz(i14 << 3);
                        i7 = size * zzz7;
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzh = 0;
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 23:
                    zzh = zzmk.zzd(i14, (List) unsafe.getObject(obj2, j6), false);
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 24:
                    zzh = zzmk.zzb(i14, (List) unsafe.getObject(obj2, j6), false);
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj2, j6);
                    int i25 = zzmk.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        zzh = size2 * (zzjw.zzz(i14 << 3) + 1);
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzh = 0;
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 26:
                    List list5 = (List) unsafe.getObject(obj2, j6);
                    int i26 = zzmk.zza;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        zzg = zzjw.zzz(i14 << 3) * size3;
                        if (list5 instanceof zzli) {
                            zzli zzliVar = (zzli) list5;
                            for (int i27 = 0; i27 < size3; i27++) {
                                Object zza2 = zzliVar.zza();
                                if (zza2 instanceof zzjo) {
                                    int zzd3 = ((zzjo) zza2).zzd();
                                    zzg += zzjw.zzz(zzd3) + zzd3;
                                } else {
                                    zzg += zzjw.zzy((String) zza2);
                                }
                            }
                        } else {
                            for (int i28 = 0; i28 < size3; i28++) {
                                Object obj3 = list5.get(i28);
                                if (obj3 instanceof zzjo) {
                                    int zzd4 = ((zzjo) obj3).zzd();
                                    zzg += zzjw.zzz(zzd4) + zzd4;
                                } else {
                                    zzg += zzjw.zzy((String) obj3);
                                }
                            }
                        }
                        i13 = zzg + i18;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzg = 0;
                    i13 = zzg + i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 27:
                    List list6 = (List) unsafe.getObject(obj2, j6);
                    zzmi zzv = zzlzVar.zzv(i10);
                    int i29 = zzmk.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        zzz8 = 0;
                    } else {
                        zzz8 = zzjw.zzz(i14 << 3) * size4;
                        for (int i30 = 0; i30 < size4; i30++) {
                            Object obj4 = list6.get(i30);
                            if (obj4 instanceof zzlh) {
                                int zza3 = ((zzlh) obj4).zza();
                                zzz8 += zzjw.zzz(zza3) + zza3;
                            } else {
                                zzz8 += zzjw.zzx((zzlw) obj4, zzv);
                            }
                        }
                    }
                    i13 = i18 + zzz8;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 28:
                    List list7 = (List) unsafe.getObject(obj2, j6);
                    int i31 = zzmk.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        zzz9 = 0;
                    } else {
                        zzz9 = size5 * zzjw.zzz(i14 << 3);
                        for (int i32 = 0; i32 < list7.size(); i32++) {
                            int zzd5 = ((zzjo) list7.get(i32)).zzd();
                            zzz9 += zzjw.zzz(zzd5) + zzd5;
                        }
                    }
                    i13 = i18 + zzz9;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 29:
                    List list8 = (List) unsafe.getObject(obj2, j6);
                    int i33 = zzmk.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzl = zzmk.zzk(list8);
                        zzz7 = zzjw.zzz(i14 << 3);
                        i7 = size * zzz7;
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzh = 0;
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 30:
                    List list9 = (List) unsafe.getObject(obj2, j6);
                    int i34 = zzmk.zza;
                    size = list9.size();
                    if (size != 0) {
                        zzl = zzmk.zza(list9);
                        zzz7 = zzjw.zzz(i14 << 3);
                        i7 = size * zzz7;
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzh = 0;
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 31:
                    zzh = zzmk.zzb(i14, (List) unsafe.getObject(obj2, j6), false);
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 32:
                    zzh = zzmk.zzd(i14, (List) unsafe.getObject(obj2, j6), false);
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 33:
                    List list10 = (List) unsafe.getObject(obj2, j6);
                    int i35 = zzmk.zza;
                    size = list10.size();
                    if (size != 0) {
                        zzl = zzmk.zzi(list10);
                        zzz7 = zzjw.zzz(i14 << 3);
                        i7 = size * zzz7;
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzh = 0;
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 34:
                    List list11 = (List) unsafe.getObject(obj2, j6);
                    int i36 = zzmk.zza;
                    size = list11.size();
                    if (size != 0) {
                        zzl = zzmk.zzj(list11);
                        zzz7 = zzjw.zzz(i14 << 3);
                        i7 = size * zzz7;
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    zzh = 0;
                    i13 = i18 + zzh;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 35:
                    zze = zzmk.zze((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 36:
                    zze = zzmk.zzc((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 37:
                    zze = zzmk.zzg((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 38:
                    zze = zzmk.zzl((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 39:
                    zze = zzmk.zzf((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 40:
                    zze = zzmk.zze((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 41:
                    zze = zzmk.zzc((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 42:
                    List list12 = (List) unsafe.getObject(obj2, j6);
                    int i37 = zzmk.zza;
                    zze = list12.size();
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 43:
                    zze = zzmk.zzk((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 44:
                    zze = zzmk.zza((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 45:
                    zze = zzmk.zzc((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 46:
                    zze = zzmk.zze((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 47:
                    zze = zzmk.zzi((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 48:
                    zze = zzmk.zzj((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzz10 = zzjw.zzz(i14 << 3);
                        zzz11 = zzjw.zzz(zze);
                        zzz9 = zzz10 + zzz11 + zze;
                        i13 = i18 + zzz9;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 49:
                    List list13 = (List) unsafe.getObject(obj2, j6);
                    zzmi zzv2 = zzlzVar.zzv(i10);
                    int i38 = zzmk.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        i8 = 0;
                    } else {
                        i8 = 0;
                        for (int i39 = 0; i39 < size6; i39++) {
                            i8 += zzjw.zzw(i14, (zzlw) list13.get(i39), zzv2);
                        }
                    }
                    i13 = i18 + i8;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 50:
                    zzlq zzlqVar = (zzlq) unsafe.getObject(obj2, j6);
                    if (!zzlqVar.isEmpty()) {
                        Iterator it = zzlqVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 51:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzz12 = zzjw.zzz(i14 << 3);
                        zzh = zzz12 + 8;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 52:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzz13 = zzjw.zzz(i14 << 3);
                        zzh = zzz13 + 4;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 53:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        long zzt = zzt(obj2, j6);
                        zzl = zzjw.zzz(i14 << 3);
                        i7 = zzjw.zzA(zzt);
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 54:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        long zzt2 = zzt(obj2, j6);
                        zzl = zzjw.zzz(i14 << 3);
                        i7 = zzjw.zzA(zzt2);
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 55:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        long zzo = zzo(obj2, j6);
                        zzl = zzjw.zzz(i14 << 3);
                        i7 = zzjw.zzA(zzo);
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 56:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzz12 = zzjw.zzz(i14 << 3);
                        zzh = zzz12 + 8;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 57:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzz13 = zzjw.zzz(i14 << 3);
                        zzh = zzz13 + 4;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 58:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzh = zzjw.zzz(i14 << 3) + 1;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 59:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        int i40 = i14 << 3;
                        Object object2 = unsafe.getObject(obj2, j6);
                        if (object2 instanceof zzjo) {
                            zzz14 = zzjw.zzz(i40);
                            zzd2 = ((zzjo) object2).zzd();
                            zzz15 = zzjw.zzz(zzd2);
                            zzh = zzz14 + zzz15 + zzd2;
                            i13 = i18 + zzh;
                            i10 += 3;
                            obj2 = obj;
                            i9 = 1048575;
                        } else {
                            zzl = zzjw.zzz(i40);
                            i7 = zzjw.zzy((String) object2);
                            zzh = zzl + i7;
                            i13 = i18 + zzh;
                            i10 += 3;
                            obj2 = obj;
                            i9 = 1048575;
                        }
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 60:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzh = zzmk.zzh(i14, unsafe.getObject(obj2, j6), zzlzVar.zzv(i10));
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 61:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzjo zzjoVar2 = (zzjo) unsafe.getObject(obj2, j6);
                        zzz14 = zzjw.zzz(i14 << 3);
                        zzd2 = zzjoVar2.zzd();
                        zzz15 = zzjw.zzz(zzd2);
                        zzh = zzz14 + zzz15 + zzd2;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 62:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        int zzo2 = zzo(obj2, j6);
                        zzl = zzjw.zzz(i14 << 3);
                        i7 = zzjw.zzz(zzo2);
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 63:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        long zzo3 = zzo(obj2, j6);
                        zzl = zzjw.zzz(i14 << 3);
                        i7 = zzjw.zzA(zzo3);
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 64:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzz13 = zzjw.zzz(i14 << 3);
                        zzh = zzz13 + 4;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 65:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzz12 = zzjw.zzz(i14 << 3);
                        zzh = zzz12 + 8;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 66:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        int zzo4 = zzo(obj2, j6);
                        zzl = zzjw.zzz(i14 << 3);
                        i7 = zzjw.zzz((zzo4 >> 31) ^ (zzo4 + zzo4));
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 67:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        long zzt3 = zzt(obj2, j6);
                        zzl = zzjw.zzz(i14 << 3);
                        i7 = zzjw.zzA((zzt3 >> 63) ^ (zzt3 + zzt3));
                        zzh = zzl + i7;
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                case 68:
                    if (zzlzVar.zzM(obj2, i14, i10)) {
                        zzh = zzjw.zzw(i14, (zzlw) unsafe.getObject(obj2, j6), zzlzVar.zzv(i10));
                        i13 = i18 + zzh;
                        i10 += 3;
                        obj2 = obj;
                        i9 = 1048575;
                    }
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
                default:
                    i13 = i18;
                    i10 += 3;
                    obj2 = obj;
                    i9 = 1048575;
            }
        }
        int zza4 = i13 + ((zzkr) obj).zzc.zza();
        if (!zzlzVar.zzh) {
            return zza4;
        }
        zzkg zzkgVar = ((zzkn) obj).zzb;
        int zzc = zzkgVar.zza.zzc();
        int i41 = 0;
        for (int i42 = 0; i42 < zzc; i42++) {
            Map.Entry zzg2 = zzkgVar.zza.zzg(i42);
            i41 += zzkg.zzb((zzkf) ((zzmm) zzg2).zza(), zzg2.getValue());
        }
        for (Map.Entry entry2 : zzkgVar.zza.zzd()) {
            i41 += zzkg.zzb((zzkf) entry2.getKey(), entry2.getValue());
        }
        return zza4 + i41;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final Object zze() {
        return ((zzkr) this.zzg).zzt();
    }

    /* JADX WARN: Removed duplicated region for block: B:251:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0516  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r19, com.google.android.gms.internal.mlkit_vision_mediapipe.zznj r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_mediapipe.zzlz.zzi(java.lang.Object, com.google.android.gms.internal.mlkit_vision_mediapipe.zznj):void");
    }

    private static void zzA(Object obj) {
        if (zzL(obj)) {
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i6) {
        if (!zzI(obj2, i6)) {
            return;
        }
        int zzs = zzs(i6) & 1048575;
        Unsafe unsafe = zzb;
        long j6 = zzs;
        Object object = unsafe.getObject(obj2, j6);
        if (object != null) {
            zzmi zzv = zzv(i6);
            if (!zzI(obj, i6)) {
                if (!zzL(object)) {
                    unsafe.putObject(obj, j6, object);
                } else {
                    Object zze = zzv.zze();
                    zzv.zzg(zze, object);
                    unsafe.putObject(obj, j6, zze);
                }
                zzD(obj, i6);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzL(object2)) {
                Object zze2 = zzv.zze();
                zzv.zzg(zze2, object2);
                unsafe.putObject(obj, j6, zze2);
                object2 = zze2;
            }
            zzv.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i6] + " is present but null: " + obj2.toString());
    }

    private final void zzD(Object obj, int i6) {
        int zzp = zzp(i6);
        long j6 = 1048575 & zzp;
        if (j6 == 1048575) {
            return;
        }
        zznd.zzq(obj, j6, (1 << (zzp >>> 20)) | zznd.zzc(obj, j6));
    }

    private final void zzE(Object obj, int i6, int i7) {
        zznd.zzq(obj, zzp(i7) & 1048575, i6);
    }

    private final boolean zzH(Object obj, Object obj2, int i6) {
        if (zzI(obj, i6) == zzI(obj2, i6)) {
            return true;
        }
        return false;
    }

    private final boolean zzI(Object obj, int i6) {
        int zzp = zzp(i6);
        long j6 = zzp & 1048575;
        if (j6 == 1048575) {
            int zzs = zzs(i6);
            long j7 = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (Double.doubleToRawLongBits(zznd.zza(obj, j7)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zznd.zzb(obj, j7)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zznd.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zznd.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zznd.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zznd.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zznd.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zznd.zzw(obj, j7);
                case 8:
                    Object zzf = zznd.zzf(obj, j7);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (zzf instanceof zzjo) {
                        if (zzjo.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (zznd.zzf(obj, j7) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzjo.zzb.equals(zznd.zzf(obj, j7))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zznd.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zznd.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zznd.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zznd.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zznd.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zznd.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zznd.zzf(obj, j7) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zznd.zzc(obj, j6) & (1 << (zzp >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzJ(Object obj, int i6, int i7, int i8, int i9) {
        if (i7 == 1048575) {
            return zzI(obj, i6);
        }
        if ((i8 & i9) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzK(Object obj, int i6, zzmi zzmiVar) {
        return zzmiVar.zzk(zznd.zzf(obj, i6 & 1048575));
    }

    private final boolean zzM(Object obj, int i6, int i7) {
        if (zznd.zzc(obj, zzp(i7) & 1048575) == i6) {
            return true;
        }
        return false;
    }

    private static boolean zzN(Object obj, long j6) {
        return ((Boolean) zznd.zzf(obj, j6)).booleanValue();
    }

    private static double zzm(Object obj, long j6) {
        return ((Double) zznd.zzf(obj, j6)).doubleValue();
    }

    private static float zzn(Object obj, long j6) {
        return ((Float) zznd.zzf(obj, j6)).floatValue();
    }

    private static int zzo(Object obj, long j6) {
        return ((Integer) zznd.zzf(obj, j6)).intValue();
    }

    private static long zzt(Object obj, long j6) {
        return ((Long) zznd.zzf(obj, j6)).longValue();
    }

    private final Object zzx(Object obj, int i6) {
        zzmi zzv = zzv(i6);
        int zzs = zzs(i6) & 1048575;
        if (!zzI(obj, i6)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzy(Object obj, int i6, int i7) {
        zzmi zzv = zzv(i7);
        if (!zzM(obj, i6, i7)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i7) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzkr) {
                zzkr zzkrVar = (zzkr) obj;
                zzkrVar.zzF(Integer.MAX_VALUE);
                zzkrVar.zza = 0;
                zzkrVar.zzD();
            }
            int[] iArr = this.zzc;
            for (int i6 = 0; i6 < iArr.length; i6 += 3) {
                int zzs = zzs(i6);
                int i7 = 1048575 & zzs;
                int zzr = zzr(zzs);
                long j6 = i7;
                if (zzr != 9) {
                    if (zzr != 60 && zzr != 68) {
                        switch (zzr) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ((zzky) zznd.zzf(obj, j6)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j6);
                                if (object != null) {
                                    ((zzlq) object).zzc();
                                    unsafe.putObject(obj, j6, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzM(obj, this.zzc[i6], i6)) {
                        zzv(i6).zzf(zzb.getObject(obj, j6));
                    }
                }
                if (zzI(obj, i6)) {
                    zzv(i6).zzf(zzb.getObject(obj, j6));
                }
            }
            this.zzl.zza(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzmi
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzs = zzs(i6);
            int i7 = 1048575 & zzs;
            int[] iArr = this.zzc;
            int zzr = zzr(zzs);
            int i8 = iArr[i6];
            long j6 = i7;
            switch (zzr) {
                case 0:
                    if (zzI(obj2, i6)) {
                        zznd.zzo(obj, j6, zznd.zza(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzI(obj2, i6)) {
                        zznd.zzp(obj, j6, zznd.zzb(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzI(obj2, i6)) {
                        zznd.zzr(obj, j6, zznd.zzd(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzI(obj2, i6)) {
                        zznd.zzr(obj, j6, zznd.zzd(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzI(obj2, i6)) {
                        zznd.zzq(obj, j6, zznd.zzc(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzI(obj2, i6)) {
                        zznd.zzr(obj, j6, zznd.zzd(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzI(obj2, i6)) {
                        zznd.zzq(obj, j6, zznd.zzc(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzI(obj2, i6)) {
                        zznd.zzm(obj, j6, zznd.zzw(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzI(obj2, i6)) {
                        zznd.zzs(obj, j6, zznd.zzf(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i6);
                    break;
                case 10:
                    if (zzI(obj2, i6)) {
                        zznd.zzs(obj, j6, zznd.zzf(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzI(obj2, i6)) {
                        zznd.zzq(obj, j6, zznd.zzc(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzI(obj2, i6)) {
                        zznd.zzq(obj, j6, zznd.zzc(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzI(obj2, i6)) {
                        zznd.zzq(obj, j6, zznd.zzc(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzI(obj2, i6)) {
                        zznd.zzr(obj, j6, zznd.zzd(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzI(obj2, i6)) {
                        zznd.zzq(obj, j6, zznd.zzc(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzI(obj2, i6)) {
                        zznd.zzr(obj, j6, zznd.zzd(obj2, j6));
                        zzD(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i6);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzky zzkyVar = (zzky) zznd.zzf(obj, j6);
                    zzky zzkyVar2 = (zzky) zznd.zzf(obj2, j6);
                    int size = zzkyVar.size();
                    int size2 = zzkyVar2.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzkyVar.zzc()) {
                            zzkyVar = zzkyVar.zzd(size2 + size);
                        }
                        zzkyVar.addAll(zzkyVar2);
                    }
                    if (size > 0) {
                        zzkyVar2 = zzkyVar;
                    }
                    zznd.zzs(obj, j6, zzkyVar2);
                    break;
                case 50:
                    int i9 = zzmk.zza;
                    zznd.zzs(obj, j6, zzlr.zza(zznd.zzf(obj, j6), zznd.zzf(obj2, j6)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(obj2, i8, i6)) {
                        zznd.zzs(obj, j6, zznd.zzf(obj2, j6));
                        zzE(obj, i8, i6);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i6);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i8, i6)) {
                        zznd.zzs(obj, j6, zznd.zzf(obj2, j6));
                        zzE(obj, i8, i6);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i6);
                    break;
            }
        }
        zzmk.zzp(this.zzl, obj, obj2);
        if (this.zzh) {
            zzmk.zzo(this.zzm, obj, obj2);
        }
    }
}
