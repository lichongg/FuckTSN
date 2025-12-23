package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzfd<T> implements zzfm<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfa zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzeo zzm;
    private final zzgd zzn;
    private final zzdj zzo;
    private final zzff zzp;
    private final zzev zzq;

    private zzfd(int[] iArr, Object[] objArr, int i6, int i7, zzfa zzfaVar, int i8, boolean z5, int[] iArr2, int i9, int i10, zzff zzffVar, zzeo zzeoVar, zzgd zzgdVar, zzdj zzdjVar, zzev zzevVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i6;
        this.zzf = i7;
        this.zzi = zzfaVar instanceof zzdv;
        boolean z6 = false;
        if (zzdjVar != null && zzdjVar.zzh(zzfaVar)) {
            z6 = true;
        }
        this.zzh = z6;
        this.zzj = iArr2;
        this.zzk = i9;
        this.zzl = i10;
        this.zzp = zzffVar;
        this.zzm = zzeoVar;
        this.zzn = zzgdVar;
        this.zzo = zzdjVar;
        this.zzg = zzfaVar;
        this.zzq = zzevVar;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final int zzb(Object obj) {
        int i6;
        long doubleToLongBits;
        int i7;
        int floatToIntBits;
        int i8;
        int i9 = 0;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzu = zzu(i10);
            int[] iArr = this.zzc;
            int i11 = 1048575 & zzu;
            int zzt = zzt(zzu);
            int i12 = iArr[i10];
            long j6 = i11;
            int i13 = 37;
            switch (zzt) {
                case 0:
                    i6 = i9 * 53;
                    doubleToLongBits = Double.doubleToLongBits(zzgn.zza(obj, j6));
                    byte[] bArr = zzeb.zzd;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 1:
                    i7 = i9 * 53;
                    floatToIntBits = Float.floatToIntBits(zzgn.zzb(obj, j6));
                    i9 = i7 + floatToIntBits;
                    break;
                case 2:
                    i6 = i9 * 53;
                    doubleToLongBits = zzgn.zzd(obj, j6);
                    byte[] bArr2 = zzeb.zzd;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 3:
                    i6 = i9 * 53;
                    doubleToLongBits = zzgn.zzd(obj, j6);
                    byte[] bArr3 = zzeb.zzd;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 4:
                    i7 = i9 * 53;
                    floatToIntBits = zzgn.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 5:
                    i6 = i9 * 53;
                    doubleToLongBits = zzgn.zzd(obj, j6);
                    byte[] bArr4 = zzeb.zzd;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 6:
                    i7 = i9 * 53;
                    floatToIntBits = zzgn.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 7:
                    i7 = i9 * 53;
                    floatToIntBits = zzeb.zza(zzgn.zzw(obj, j6));
                    i9 = i7 + floatToIntBits;
                    break;
                case 8:
                    i7 = i9 * 53;
                    floatToIntBits = ((String) zzgn.zzf(obj, j6)).hashCode();
                    i9 = i7 + floatToIntBits;
                    break;
                case 9:
                    i8 = i9 * 53;
                    Object zzf = zzgn.zzf(obj, j6);
                    if (zzf != null) {
                        i13 = zzf.hashCode();
                    }
                    i9 = i8 + i13;
                    break;
                case 10:
                    i7 = i9 * 53;
                    floatToIntBits = zzgn.zzf(obj, j6).hashCode();
                    i9 = i7 + floatToIntBits;
                    break;
                case 11:
                    i7 = i9 * 53;
                    floatToIntBits = zzgn.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 12:
                    i7 = i9 * 53;
                    floatToIntBits = zzgn.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 13:
                    i7 = i9 * 53;
                    floatToIntBits = zzgn.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 14:
                    i6 = i9 * 53;
                    doubleToLongBits = zzgn.zzd(obj, j6);
                    byte[] bArr5 = zzeb.zzd;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 15:
                    i7 = i9 * 53;
                    floatToIntBits = zzgn.zzc(obj, j6);
                    i9 = i7 + floatToIntBits;
                    break;
                case 16:
                    i6 = i9 * 53;
                    doubleToLongBits = zzgn.zzd(obj, j6);
                    byte[] bArr6 = zzeb.zzd;
                    i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                    break;
                case 17:
                    i8 = i9 * 53;
                    Object zzf2 = zzgn.zzf(obj, j6);
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
                    floatToIntBits = zzgn.zzf(obj, j6).hashCode();
                    i9 = i7 + floatToIntBits;
                    break;
                case 50:
                    i7 = i9 * 53;
                    floatToIntBits = zzgn.zzf(obj, j6).hashCode();
                    i9 = i7 + floatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzn(obj, j6));
                        byte[] bArr7 = zzeb.zzd;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = Float.floatToIntBits(zzo(obj, j6));
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzR(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzv(obj, j6);
                        byte[] bArr8 = zzeb.zzd;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzR(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzv(obj, j6);
                        byte[] bArr9 = zzeb.zzd;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzp(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzR(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzv(obj, j6);
                        byte[] bArr10 = zzeb.zzd;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzp(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzeb.zza(zzS(obj, j6));
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = ((String) zzgn.zzf(obj, j6)).hashCode();
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzgn.zzf(obj, j6).hashCode();
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzgn.zzf(obj, j6).hashCode();
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzp(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzp(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzp(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzR(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzv(obj, j6);
                        byte[] bArr11 = zzeb.zzd;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzp(obj, j6);
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzR(obj, i12, i10)) {
                        i6 = i9 * 53;
                        doubleToLongBits = zzv(obj, j6);
                        byte[] bArr12 = zzeb.zzd;
                        i9 = i6 + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzR(obj, i12, i10)) {
                        i7 = i9 * 53;
                        floatToIntBits = zzgn.zzf(obj, j6).hashCode();
                        i9 = i7 + floatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i9 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return hashCode;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    final int zzc(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.mlkit_acceleration.zzcf r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzfd.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_acceleration.zzcf):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x076d A[Catch: all -> 0x0798, TryCatch #4 {all -> 0x0798, blocks: (B:36:0x0051, B:105:0x0127, B:107:0x0768, B:109:0x076d, B:110:0x0772, B:119:0x0139, B:120:0x0151, B:121:0x0169, B:122:0x0181, B:123:0x0199, B:125:0x01a9, B:128:0x01b0, B:129:0x01b6, B:130:0x01c4, B:131:0x01dc, B:132:0x01f0, B:133:0x0208, B:134:0x0216, B:135:0x022e, B:136:0x0246, B:137:0x025e, B:138:0x0276, B:139:0x028e, B:140:0x02a6, B:141:0x02be, B:142:0x02d6, B:144:0x02ec, B:146:0x02f2, B:147:0x030d, B:148:0x0311, B:151:0x0302, B:152:0x0312, B:153:0x032a, B:154:0x033e, B:155:0x0352, B:156:0x0366, B:157:0x037a, B:170:0x03ad, B:171:0x03bb, B:172:0x03cf, B:173:0x03e3, B:174:0x03f7, B:175:0x040b, B:176:0x041f, B:177:0x0433, B:178:0x0447, B:179:0x045b, B:180:0x046f, B:181:0x0483, B:182:0x0497, B:183:0x04ab, B:188:0x04d2, B:189:0x04e0, B:190:0x04f4, B:191:0x050c, B:193:0x0518, B:194:0x052a, B:195:0x053c, B:196:0x0550, B:197:0x0564, B:198:0x0578, B:199:0x058c, B:200:0x05a0, B:201:0x05b4, B:202:0x05c8, B:203:0x05dc, B:204:0x05f4, B:205:0x0609, B:206:0x061e, B:207:0x0633, B:208:0x0648, B:210:0x0658, B:213:0x065f, B:214:0x0665, B:215:0x0670, B:216:0x0685, B:217:0x069a, B:218:0x06b2, B:219:0x06c0, B:220:0x06d5, B:221:0x06ea, B:222:0x06ff, B:223:0x0714, B:224:0x0729, B:225:0x073e, B:226:0x0753), top: B:35:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0778 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x07a6 A[LOOP:1: B:26:0x07a2->B:28:0x07a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x07b9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.mlkit_acceleration.zzfl r19, com.google.android.gms.internal.mlkit_acceleration.zzdi r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2124
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzfd.zzh(java.lang.Object, com.google.android.gms.internal.mlkit_acceleration.zzfl, com.google.android.gms.internal.mlkit_acceleration.zzdi):void");
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzi(Object obj, byte[] bArr, int i6, int i7, zzcf zzcfVar) throws IOException {
        zzc(obj, bArr, i6, i7, 0, zzcfVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final boolean zzk(Object obj, Object obj2) {
        boolean zzG;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzu = zzu(i6);
            long j6 = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i6) && Double.doubleToLongBits(zzgn.zza(obj, j6)) == Double.doubleToLongBits(zzgn.zza(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 1:
                    if (zzL(obj, obj2, i6) && Float.floatToIntBits(zzgn.zzb(obj, j6)) == Float.floatToIntBits(zzgn.zzb(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 2:
                    if (zzL(obj, obj2, i6) && zzgn.zzd(obj, j6) == zzgn.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 3:
                    if (zzL(obj, obj2, i6) && zzgn.zzd(obj, j6) == zzgn.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 4:
                    if (zzL(obj, obj2, i6) && zzgn.zzc(obj, j6) == zzgn.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 5:
                    if (zzL(obj, obj2, i6) && zzgn.zzd(obj, j6) == zzgn.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 6:
                    if (zzL(obj, obj2, i6) && zzgn.zzc(obj, j6) == zzgn.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 7:
                    if (zzL(obj, obj2, i6) && zzgn.zzw(obj, j6) == zzgn.zzw(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 8:
                    if (zzL(obj, obj2, i6) && zzfo.zzG(zzgn.zzf(obj, j6), zzgn.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 9:
                    if (zzL(obj, obj2, i6) && zzfo.zzG(zzgn.zzf(obj, j6), zzgn.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 10:
                    if (zzL(obj, obj2, i6) && zzfo.zzG(zzgn.zzf(obj, j6), zzgn.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                case 11:
                    if (zzL(obj, obj2, i6) && zzgn.zzc(obj, j6) == zzgn.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 12:
                    if (zzL(obj, obj2, i6) && zzgn.zzc(obj, j6) == zzgn.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 13:
                    if (zzL(obj, obj2, i6) && zzgn.zzc(obj, j6) == zzgn.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 14:
                    if (zzL(obj, obj2, i6) && zzgn.zzd(obj, j6) == zzgn.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 15:
                    if (zzL(obj, obj2, i6) && zzgn.zzc(obj, j6) == zzgn.zzc(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 16:
                    if (zzL(obj, obj2, i6) && zzgn.zzd(obj, j6) == zzgn.zzd(obj2, j6)) {
                        continue;
                    }
                    return false;
                case 17:
                    if (zzL(obj, obj2, i6) && zzfo.zzG(zzgn.zzf(obj, j6), zzgn.zzf(obj2, j6))) {
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
                    zzG = zzfo.zzG(zzgn.zzf(obj, j6), zzgn.zzf(obj2, j6));
                    break;
                case 50:
                    zzG = zzfo.zzG(zzgn.zzf(obj, j6), zzgn.zzf(obj2, j6));
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
                    long zzr = zzr(i6) & 1048575;
                    if (zzgn.zzc(obj, zzr) == zzgn.zzc(obj2, zzr) && zzfo.zzG(zzgn.zzf(obj, j6), zzgn.zzf(obj2, j6))) {
                        continue;
                    }
                    return false;
                default:
            }
            if (!zzG) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    private final void zzF(Object obj, Object obj2, int i6) {
        int i7 = this.zzc[i6];
        if (zzR(obj2, i7, i6)) {
            int zzu = zzu(i6) & 1048575;
            Unsafe unsafe = zzb;
            long j6 = zzu;
            Object object = unsafe.getObject(obj2, j6);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i6] + " is present but null: " + obj2.toString());
            }
            zzfm zzx = zzx(i6);
            if (!zzR(obj, i7, i6)) {
                if (zzQ(object)) {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, j6, zze);
                } else {
                    unsafe.putObject(obj, j6, object);
                }
                zzI(obj, i7, i6);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, j6, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
        }
    }

    private final void zzJ(Object obj, int i6, Object obj2) {
        zzb.putObject(obj, zzu(i6) & 1048575, obj2);
        zzH(obj, i6);
    }

    private final void zzK(Object obj, int i6, int i7, Object obj2) {
        zzb.putObject(obj, zzu(i7) & 1048575, obj2);
        zzI(obj, i6, i7);
    }

    private static boolean zzM(int i6) {
        return (i6 & 536870912) != 0;
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzdv) {
            return ((zzdv) obj).zzO();
        }
        return true;
    }

    private static final void zzT(int i6, Object obj, zzgv zzgvVar) throws IOException {
        if (obj instanceof String) {
            zzgvVar.zzF(i6, (String) obj);
        } else {
            zzgvVar.zzd(i6, (zzcs) obj);
        }
    }

    static zzge zzd(Object obj) {
        zzdv zzdvVar = (zzdv) obj;
        zzge zzgeVar = zzdvVar.zzc;
        if (zzgeVar != zzge.zzc()) {
            return zzgeVar;
        }
        zzge zzf = zzge.zzf();
        zzdvVar.zzc = zzf;
        return zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.mlkit_acceleration.zzfd zzm(java.lang.Class r32, com.google.android.gms.internal.mlkit_acceleration.zzex r33, com.google.android.gms.internal.mlkit_acceleration.zzff r34, com.google.android.gms.internal.mlkit_acceleration.zzeo r35, com.google.android.gms.internal.mlkit_acceleration.zzgd r36, com.google.android.gms.internal.mlkit_acceleration.zzdj r37, com.google.android.gms.internal.mlkit_acceleration.zzev r38) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_acceleration.zzfd.zzm(java.lang.Class, com.google.android.gms.internal.mlkit_acceleration.zzex, com.google.android.gms.internal.mlkit_acceleration.zzff, com.google.android.gms.internal.mlkit_acceleration.zzeo, com.google.android.gms.internal.mlkit_acceleration.zzgd, com.google.android.gms.internal.mlkit_acceleration.zzdj, com.google.android.gms.internal.mlkit_acceleration.zzev):com.google.android.gms.internal.mlkit_acceleration.zzfd");
    }

    private final int zzq(int i6) {
        if (i6 < this.zze || i6 > this.zzf) {
            return -1;
        }
        return zzs(i6, 0);
    }

    private final int zzr(int i6) {
        return this.zzc[i6 + 2];
    }

    private final int zzs(int i6, int i7) {
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

    private static int zzt(int i6) {
        return (i6 >>> 20) & 255;
    }

    private final int zzu(int i6) {
        return this.zzc[i6 + 1];
    }

    private final zzdz zzw(int i6) {
        int i7 = i6 / 3;
        return (zzdz) this.zzd[i7 + i7 + 1];
    }

    private final zzfm zzx(int i6) {
        Object[] objArr = this.zzd;
        int i7 = i6 / 3;
        int i8 = i7 + i7;
        zzfm zzfmVar = (zzfm) objArr[i8];
        if (zzfmVar != null) {
            return zzfmVar;
        }
        zzfm zzb2 = zzfi.zza().zzb((Class) objArr[i8 + 1]);
        this.zzd[i8] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i6, Object obj2, zzgd zzgdVar, Object obj3) {
        int i7 = this.zzc[i6];
        Object zzf = zzgn.zzf(obj, zzu(i6) & 1048575);
        if (zzf == null || zzw(i6) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i6) {
        int i7 = i6 / 3;
        return this.zzd[i7 + i7];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final int zza(Object obj) {
        int i6;
        int zzw;
        int zzw2;
        int zzw3;
        int zzx;
        int zzw4;
        int zzw5;
        int zzw6;
        int zzd;
        int zzw7;
        int zzh;
        int i7;
        int zzg;
        int size;
        int zzl;
        int zzw8;
        int zzw9;
        int zzw10;
        int i8;
        int zze;
        int zzw11;
        int zzw12;
        int i9;
        int zzw13;
        int zzw14;
        int zzd2;
        int zzw15;
        zzfd<T> zzfdVar = this;
        Object obj2 = obj;
        Unsafe unsafe = zzb;
        int i10 = 1048575;
        int i11 = 0;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i11 < zzfdVar.zzc.length) {
            int zzu = zzfdVar.zzu(i11);
            int zzt = zzt(zzu);
            int[] iArr = zzfdVar.zzc;
            int i15 = iArr[i11];
            int i16 = iArr[i11 + 2];
            int i17 = i16 & i10;
            if (zzt <= 17) {
                if (i17 != i12) {
                    i13 = i17 == i10 ? 0 : unsafe.getInt(obj2, i17);
                    i12 = i17;
                }
                i6 = 1 << (i16 >>> 20);
            } else {
                i6 = 0;
            }
            int i18 = zzu & i10;
            if (zzt >= zzdo.zzJ.zza()) {
                zzdo.zzW.zza();
            }
            int i19 = i14;
            long j6 = i18;
            switch (zzt) {
                case 0:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzw = zzdd.zzw(i15 << 3);
                        zzh = zzw + 8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 1:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzw2 = zzdd.zzw(i15 << 3);
                        zzw5 = zzw2 + 4;
                        i14 = i19 + zzw5;
                        zzfdVar = this;
                        obj2 = obj;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    obj2 = obj;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 2:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        long j7 = unsafe.getLong(obj2, j6);
                        zzw3 = zzdd.zzw(i15 << 3);
                        zzx = zzdd.zzx(j7);
                        i7 = zzw3 + zzx;
                        i14 = i19 + i7;
                        zzfdVar = this;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 3:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        long j8 = unsafe.getLong(obj2, j6);
                        zzw3 = zzdd.zzw(i15 << 3);
                        zzx = zzdd.zzx(j8);
                        i7 = zzw3 + zzx;
                        i14 = i19 + i7;
                        zzfdVar = this;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 4:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        long j9 = unsafe.getInt(obj2, j6);
                        zzw3 = zzdd.zzw(i15 << 3);
                        zzx = zzdd.zzx(j9);
                        i7 = zzw3 + zzx;
                        i14 = i19 + i7;
                        zzfdVar = this;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 5:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzw4 = zzdd.zzw(i15 << 3);
                        zzw5 = zzw4 + 8;
                        i14 = i19 + zzw5;
                        zzfdVar = this;
                        obj2 = obj;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    obj2 = obj;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 6:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzw2 = zzdd.zzw(i15 << 3);
                        zzw5 = zzw2 + 4;
                        i14 = i19 + zzw5;
                        zzfdVar = this;
                        obj2 = obj;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    obj2 = obj;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 7:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzw5 = zzdd.zzw(i15 << 3) + 1;
                        i14 = i19 + zzw5;
                        zzfdVar = this;
                        obj2 = obj;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    obj2 = obj;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 8:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        int i20 = i15 << 3;
                        Object object = unsafe.getObject(obj2, j6);
                        if (object instanceof zzcs) {
                            zzw6 = zzdd.zzw(i20);
                            zzd = ((zzcs) object).zzd();
                            zzw7 = zzdd.zzw(zzd);
                            i7 = zzw6 + zzw7 + zzd;
                            i14 = i19 + i7;
                            zzfdVar = this;
                            i11 += 3;
                            i10 = 1048575;
                        } else {
                            zzw3 = zzdd.zzw(i20);
                            zzx = zzdd.zzv((String) object);
                            i7 = zzw3 + zzx;
                            i14 = i19 + i7;
                            zzfdVar = this;
                            i11 += 3;
                            i10 = 1048575;
                        }
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 9:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzh = zzfo.zzh(i15, unsafe.getObject(obj2, j6), zzfdVar.zzx(i11));
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 10:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzcs zzcsVar = (zzcs) unsafe.getObject(obj2, j6);
                        zzw6 = zzdd.zzw(i15 << 3);
                        zzd = zzcsVar.zzd();
                        zzw7 = zzdd.zzw(zzd);
                        i7 = zzw6 + zzw7 + zzd;
                        i14 = i19 + i7;
                        zzfdVar = this;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 11:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        int i21 = unsafe.getInt(obj2, j6);
                        zzw3 = zzdd.zzw(i15 << 3);
                        zzx = zzdd.zzw(i21);
                        i7 = zzw3 + zzx;
                        i14 = i19 + i7;
                        zzfdVar = this;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 12:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        long j10 = unsafe.getInt(obj2, j6);
                        zzw3 = zzdd.zzw(i15 << 3);
                        zzx = zzdd.zzx(j10);
                        i7 = zzw3 + zzx;
                        i14 = i19 + i7;
                        zzfdVar = this;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 13:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzw2 = zzdd.zzw(i15 << 3);
                        zzw5 = zzw2 + 4;
                        i14 = i19 + zzw5;
                        zzfdVar = this;
                        obj2 = obj;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    obj2 = obj;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 14:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzw4 = zzdd.zzw(i15 << 3);
                        zzw5 = zzw4 + 8;
                        i14 = i19 + zzw5;
                        zzfdVar = this;
                        obj2 = obj;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    obj2 = obj;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 15:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        int i22 = unsafe.getInt(obj2, j6);
                        zzw3 = zzdd.zzw(i15 << 3);
                        zzx = zzdd.zzw((i22 >> 31) ^ (i22 + i22));
                        i7 = zzw3 + zzx;
                        i14 = i19 + i7;
                        zzfdVar = this;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 16:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        long j11 = unsafe.getLong(obj2, j6);
                        zzw3 = zzdd.zzw(i15 << 3);
                        zzx = zzdd.zzx((j11 >> 63) ^ (j11 + j11));
                        i7 = zzw3 + zzx;
                        i14 = i19 + i7;
                        zzfdVar = this;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzfdVar = this;
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 17:
                    if (zzfdVar.zzO(obj2, i11, i12, i13, i6)) {
                        zzh = zzdd.zzt(i15, (zzfa) unsafe.getObject(obj2, j6), zzfdVar.zzx(i11));
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 18:
                    zzh = zzfo.zzd(i15, (List) unsafe.getObject(obj2, j6), false);
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 19:
                    zzh = zzfo.zzb(i15, (List) unsafe.getObject(obj2, j6), false);
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 20:
                    List list = (List) unsafe.getObject(obj2, j6);
                    int i23 = zzfo.zza;
                    if (list.size() != 0) {
                        zzg = zzfo.zzg(list) + (list.size() * zzdd.zzw(i15 << 3));
                        i14 = zzg + i19;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzg = 0;
                    i14 = zzg + i19;
                    i11 += 3;
                    i10 = 1048575;
                case 21:
                    List list2 = (List) unsafe.getObject(obj2, j6);
                    int i24 = zzfo.zza;
                    size = list2.size();
                    if (size != 0) {
                        zzl = zzfo.zzl(list2);
                        zzw8 = zzdd.zzw(i15 << 3);
                        i8 = size * zzw8;
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzh = 0;
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 22:
                    List list3 = (List) unsafe.getObject(obj2, j6);
                    int i25 = zzfo.zza;
                    size = list3.size();
                    if (size != 0) {
                        zzl = zzfo.zzf(list3);
                        zzw8 = zzdd.zzw(i15 << 3);
                        i8 = size * zzw8;
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzh = 0;
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 23:
                    zzh = zzfo.zzd(i15, (List) unsafe.getObject(obj2, j6), false);
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 24:
                    zzh = zzfo.zzb(i15, (List) unsafe.getObject(obj2, j6), false);
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 25:
                    List list4 = (List) unsafe.getObject(obj2, j6);
                    int i26 = zzfo.zza;
                    int size2 = list4.size();
                    if (size2 != 0) {
                        zzh = size2 * (zzdd.zzw(i15 << 3) + 1);
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzh = 0;
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 26:
                    List list5 = (List) unsafe.getObject(obj2, j6);
                    int i27 = zzfo.zza;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        zzg = zzdd.zzw(i15 << 3) * size3;
                        if (list5 instanceof zzei) {
                            zzei zzeiVar = (zzei) list5;
                            for (int i28 = 0; i28 < size3; i28++) {
                                Object zzf = zzeiVar.zzf(i28);
                                if (zzf instanceof zzcs) {
                                    int zzd3 = ((zzcs) zzf).zzd();
                                    zzg += zzdd.zzw(zzd3) + zzd3;
                                } else {
                                    zzg += zzdd.zzv((String) zzf);
                                }
                            }
                        } else {
                            for (int i29 = 0; i29 < size3; i29++) {
                                Object obj3 = list5.get(i29);
                                if (obj3 instanceof zzcs) {
                                    int zzd4 = ((zzcs) obj3).zzd();
                                    zzg += zzdd.zzw(zzd4) + zzd4;
                                } else {
                                    zzg += zzdd.zzv((String) obj3);
                                }
                            }
                        }
                        i14 = zzg + i19;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzg = 0;
                    i14 = zzg + i19;
                    i11 += 3;
                    i10 = 1048575;
                case 27:
                    List list6 = (List) unsafe.getObject(obj2, j6);
                    zzfm zzx2 = zzfdVar.zzx(i11);
                    int i30 = zzfo.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        zzw9 = 0;
                    } else {
                        zzw9 = zzdd.zzw(i15 << 3) * size4;
                        for (int i31 = 0; i31 < size4; i31++) {
                            Object obj4 = list6.get(i31);
                            if (obj4 instanceof zzeg) {
                                int zza2 = ((zzeg) obj4).zza();
                                zzw9 += zzdd.zzw(zza2) + zza2;
                            } else {
                                zzw9 += zzdd.zzu((zzfa) obj4, zzx2);
                            }
                        }
                    }
                    i14 = i19 + zzw9;
                    i11 += 3;
                    i10 = 1048575;
                case 28:
                    List list7 = (List) unsafe.getObject(obj2, j6);
                    int i32 = zzfo.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        zzw10 = 0;
                    } else {
                        zzw10 = size5 * zzdd.zzw(i15 << 3);
                        for (int i33 = 0; i33 < list7.size(); i33++) {
                            int zzd5 = ((zzcs) list7.get(i33)).zzd();
                            zzw10 += zzdd.zzw(zzd5) + zzd5;
                        }
                    }
                    i14 = i19 + zzw10;
                    i11 += 3;
                    i10 = 1048575;
                case 29:
                    List list8 = (List) unsafe.getObject(obj2, j6);
                    int i34 = zzfo.zza;
                    size = list8.size();
                    if (size != 0) {
                        zzl = zzfo.zzk(list8);
                        zzw8 = zzdd.zzw(i15 << 3);
                        i8 = size * zzw8;
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzh = 0;
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 30:
                    List list9 = (List) unsafe.getObject(obj2, j6);
                    int i35 = zzfo.zza;
                    size = list9.size();
                    if (size != 0) {
                        zzl = zzfo.zza(list9);
                        zzw8 = zzdd.zzw(i15 << 3);
                        i8 = size * zzw8;
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzh = 0;
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 31:
                    zzh = zzfo.zzb(i15, (List) unsafe.getObject(obj2, j6), false);
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 32:
                    zzh = zzfo.zzd(i15, (List) unsafe.getObject(obj2, j6), false);
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 33:
                    List list10 = (List) unsafe.getObject(obj2, j6);
                    int i36 = zzfo.zza;
                    size = list10.size();
                    if (size != 0) {
                        zzl = zzfo.zzi(list10);
                        zzw8 = zzdd.zzw(i15 << 3);
                        i8 = size * zzw8;
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzh = 0;
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 34:
                    List list11 = (List) unsafe.getObject(obj2, j6);
                    int i37 = zzfo.zza;
                    size = list11.size();
                    if (size != 0) {
                        zzl = zzfo.zzj(list11);
                        zzw8 = zzdd.zzw(i15 << 3);
                        i8 = size * zzw8;
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    zzh = 0;
                    i14 = i19 + zzh;
                    i11 += 3;
                    i10 = 1048575;
                case 35:
                    zze = zzfo.zze((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 36:
                    zze = zzfo.zzc((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 37:
                    zze = zzfo.zzg((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 38:
                    zze = zzfo.zzl((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 39:
                    zze = zzfo.zzf((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 40:
                    zze = zzfo.zze((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 41:
                    zze = zzfo.zzc((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 42:
                    List list12 = (List) unsafe.getObject(obj2, j6);
                    int i38 = zzfo.zza;
                    zze = list12.size();
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 43:
                    zze = zzfo.zzk((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 44:
                    zze = zzfo.zza((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 45:
                    zze = zzfo.zzc((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 46:
                    zze = zzfo.zze((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 47:
                    zze = zzfo.zzi((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 48:
                    zze = zzfo.zzj((List) unsafe.getObject(obj2, j6));
                    if (zze > 0) {
                        zzw11 = zzdd.zzw(i15 << 3);
                        zzw12 = zzdd.zzw(zze);
                        zzw10 = zzw11 + zzw12 + zze;
                        i14 = i19 + zzw10;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 49:
                    List list13 = (List) unsafe.getObject(obj2, j6);
                    zzfm zzx3 = zzfdVar.zzx(i11);
                    int i39 = zzfo.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        i9 = 0;
                    } else {
                        i9 = 0;
                        for (int i40 = 0; i40 < size6; i40++) {
                            i9 += zzdd.zzt(i15, (zzfa) list13.get(i40), zzx3);
                        }
                    }
                    i14 = i19 + i9;
                    i11 += 3;
                    i10 = 1048575;
                case 50:
                    zzeu zzeuVar = (zzeu) unsafe.getObject(obj2, j6);
                    if (!zzeuVar.isEmpty()) {
                        Iterator it = zzeuVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 51:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzw = zzdd.zzw(i15 << 3);
                        zzh = zzw + 8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 52:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzw13 = zzdd.zzw(i15 << 3);
                        zzh = zzw13 + 4;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 53:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        long zzv = zzv(obj2, j6);
                        zzl = zzdd.zzw(i15 << 3);
                        i8 = zzdd.zzx(zzv);
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 54:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        long zzv2 = zzv(obj2, j6);
                        zzl = zzdd.zzw(i15 << 3);
                        i8 = zzdd.zzx(zzv2);
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 55:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        long zzp = zzp(obj2, j6);
                        zzl = zzdd.zzw(i15 << 3);
                        i8 = zzdd.zzx(zzp);
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 56:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzw = zzdd.zzw(i15 << 3);
                        zzh = zzw + 8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 57:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzw13 = zzdd.zzw(i15 << 3);
                        zzh = zzw13 + 4;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 58:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzh = zzdd.zzw(i15 << 3) + 1;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 59:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        int i41 = i15 << 3;
                        Object object2 = unsafe.getObject(obj2, j6);
                        if (object2 instanceof zzcs) {
                            zzw14 = zzdd.zzw(i41);
                            zzd2 = ((zzcs) object2).zzd();
                            zzw15 = zzdd.zzw(zzd2);
                            zzh = zzw14 + zzw15 + zzd2;
                            i14 = i19 + zzh;
                            i11 += 3;
                            i10 = 1048575;
                        } else {
                            zzl = zzdd.zzw(i41);
                            i8 = zzdd.zzv((String) object2);
                            zzh = zzl + i8;
                            i14 = i19 + zzh;
                            i11 += 3;
                            i10 = 1048575;
                        }
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 60:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzh = zzfo.zzh(i15, unsafe.getObject(obj2, j6), zzfdVar.zzx(i11));
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 61:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzcs zzcsVar2 = (zzcs) unsafe.getObject(obj2, j6);
                        zzw14 = zzdd.zzw(i15 << 3);
                        zzd2 = zzcsVar2.zzd();
                        zzw15 = zzdd.zzw(zzd2);
                        zzh = zzw14 + zzw15 + zzd2;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 62:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        int zzp2 = zzp(obj2, j6);
                        zzl = zzdd.zzw(i15 << 3);
                        i8 = zzdd.zzw(zzp2);
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 63:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        long zzp3 = zzp(obj2, j6);
                        zzl = zzdd.zzw(i15 << 3);
                        i8 = zzdd.zzx(zzp3);
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 64:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzw13 = zzdd.zzw(i15 << 3);
                        zzh = zzw13 + 4;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 65:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzw = zzdd.zzw(i15 << 3);
                        zzh = zzw + 8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 66:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        int zzp4 = zzp(obj2, j6);
                        zzl = zzdd.zzw(i15 << 3);
                        i8 = zzdd.zzw((zzp4 >> 31) ^ (zzp4 + zzp4));
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 67:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        long zzv3 = zzv(obj2, j6);
                        zzl = zzdd.zzw(i15 << 3);
                        i8 = zzdd.zzx((zzv3 >> 63) ^ (zzv3 + zzv3));
                        zzh = zzl + i8;
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                case 68:
                    if (zzfdVar.zzR(obj2, i15, i11)) {
                        zzh = zzdd.zzt(i15, (zzfa) unsafe.getObject(obj2, j6), zzfdVar.zzx(i11));
                        i14 = i19 + zzh;
                        i11 += 3;
                        i10 = 1048575;
                    }
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
                default:
                    i14 = i19;
                    i11 += 3;
                    i10 = 1048575;
            }
        }
        zzgd zzgdVar = zzfdVar.zzn;
        int zza3 = i14 + zzgdVar.zza(zzgdVar.zzd(obj2));
        if (!zzfdVar.zzh) {
            return zza3;
        }
        zzfdVar.zzo.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final Object zze() {
        return ((zzdv) this.zzg).zzB();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzj(Object obj, zzgv zzgvVar) throws IOException {
        int i6;
        zzfd<T> zzfdVar = this;
        if (zzfdVar.zzh) {
            zzfdVar.zzo.zza(obj);
            throw null;
        }
        int[] iArr = zzfdVar.zzc;
        Unsafe unsafe = zzb;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 1048575;
        int i10 = 0;
        while (i8 < iArr.length) {
            int zzu = zzfdVar.zzu(i8);
            int[] iArr2 = zzfdVar.zzc;
            int zzt = zzt(zzu);
            int i11 = iArr2[i8];
            if (zzt <= 17) {
                int i12 = iArr2[i8 + 2];
                int i13 = i12 & i7;
                if (i13 != i9) {
                    i10 = i13 == i7 ? 0 : unsafe.getInt(obj, i13);
                    i9 = i13;
                }
                i6 = 1 << (i12 >>> 20);
            } else {
                i6 = 0;
            }
            long j6 = zzu & i7;
            switch (zzt) {
                case 0:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzf(i11, zzgn.zza(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 1:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzo(i11, zzgn.zzb(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 2:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzt(i11, unsafe.getLong(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 3:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzJ(i11, unsafe.getLong(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 4:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzr(i11, unsafe.getInt(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 5:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzm(i11, unsafe.getLong(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 6:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzk(i11, unsafe.getInt(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 7:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzb(i11, zzgn.zzw(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 8:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzT(i11, unsafe.getObject(obj, j6), zzgvVar);
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 9:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzv(i11, unsafe.getObject(obj, j6), zzfdVar.zzx(i8));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 10:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzd(i11, (zzcs) unsafe.getObject(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 11:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzH(i11, unsafe.getInt(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 12:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzi(i11, unsafe.getInt(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 13:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzw(i11, unsafe.getInt(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 14:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzy(i11, unsafe.getLong(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 15:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzA(i11, unsafe.getInt(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 16:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzC(i11, unsafe.getLong(obj, j6));
                    }
                    zzfdVar = this;
                    i8 += 3;
                    i7 = 1048575;
                case 17:
                    if (zzfdVar.zzO(obj, i8, i9, i10, i6)) {
                        zzgvVar.zzq(i11, unsafe.getObject(obj, j6), zzfdVar.zzx(i8));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 18:
                    zzfo.zzt(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 19:
                    zzfo.zzx(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 20:
                    zzfo.zzz(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 21:
                    zzfo.zzF(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 22:
                    zzfo.zzy(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 23:
                    zzfo.zzw(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 24:
                    zzfo.zzv(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 25:
                    zzfo.zzs(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 26:
                    int i14 = zzfdVar.zzc[i8];
                    List list = (List) unsafe.getObject(obj, j6);
                    int i15 = zzfo.zza;
                    if (list != null && !list.isEmpty()) {
                        zzgvVar.zzG(i14, list);
                    }
                    i8 += 3;
                    i7 = 1048575;
                    break;
                case 27:
                    int i16 = zzfdVar.zzc[i8];
                    List list2 = (List) unsafe.getObject(obj, j6);
                    zzfm zzx = zzfdVar.zzx(i8);
                    int i17 = zzfo.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i18 = 0; i18 < list2.size(); i18++) {
                            ((zzde) zzgvVar).zzv(i16, list2.get(i18), zzx);
                        }
                    }
                    i8 += 3;
                    i7 = 1048575;
                    break;
                case 28:
                    int i19 = zzfdVar.zzc[i8];
                    List list3 = (List) unsafe.getObject(obj, j6);
                    int i20 = zzfo.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzgvVar.zze(i19, list3);
                    }
                    i8 += 3;
                    i7 = 1048575;
                    break;
                case 29:
                    zzfo.zzE(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 30:
                    zzfo.zzu(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 31:
                    zzfo.zzA(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 32:
                    zzfo.zzB(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 33:
                    zzfo.zzC(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 34:
                    zzfo.zzD(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, false);
                    i8 += 3;
                    i7 = 1048575;
                case 35:
                    zzfo.zzt(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 36:
                    zzfo.zzx(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 37:
                    zzfo.zzz(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 38:
                    zzfo.zzF(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 39:
                    zzfo.zzy(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 40:
                    zzfo.zzw(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 41:
                    zzfo.zzv(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 42:
                    zzfo.zzs(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 43:
                    zzfo.zzE(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 44:
                    zzfo.zzu(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 45:
                    zzfo.zzA(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 46:
                    zzfo.zzB(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 47:
                    zzfo.zzC(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 48:
                    zzfo.zzD(zzfdVar.zzc[i8], (List) unsafe.getObject(obj, j6), zzgvVar, true);
                    i8 += 3;
                    i7 = 1048575;
                case 49:
                    int i21 = zzfdVar.zzc[i8];
                    List list4 = (List) unsafe.getObject(obj, j6);
                    zzfm zzx2 = zzfdVar.zzx(i8);
                    int i22 = zzfo.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i23 = 0; i23 < list4.size(); i23++) {
                            ((zzde) zzgvVar).zzq(i21, list4.get(i23), zzx2);
                        }
                    }
                    i8 += 3;
                    i7 = 1048575;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j6) != null) {
                        throw null;
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 51:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzf(i11, zzn(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 52:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzo(i11, zzo(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 53:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzt(i11, zzv(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 54:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzJ(i11, zzv(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 55:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzr(i11, zzp(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 56:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzm(i11, zzv(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 57:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzk(i11, zzp(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 58:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzb(i11, zzS(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 59:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzT(i11, unsafe.getObject(obj, j6), zzgvVar);
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 60:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzv(i11, unsafe.getObject(obj, j6), zzfdVar.zzx(i8));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 61:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzd(i11, (zzcs) unsafe.getObject(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 62:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzH(i11, zzp(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 63:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzi(i11, zzp(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 64:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzw(i11, zzp(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 65:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzy(i11, zzv(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 66:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzA(i11, zzp(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 67:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzC(i11, zzv(obj, j6));
                    }
                    i8 += 3;
                    i7 = 1048575;
                case 68:
                    if (zzfdVar.zzR(obj, i11, i8)) {
                        zzgvVar.zzq(i11, unsafe.getObject(obj, j6), zzfdVar.zzx(i8));
                    }
                    i8 += 3;
                    i7 = 1048575;
                default:
                    i8 += 3;
                    i7 = 1048575;
            }
        }
        zzgd zzgdVar = zzfdVar.zzn;
        zzgdVar.zzp(zzgdVar.zzd(obj), zzgvVar);
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final boolean zzl(Object obj) {
        int i6;
        int i7;
        int i8;
        int i9 = 1048575;
        int i10 = 0;
        int i11 = 0;
        while (i11 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i12 = iArr[i11];
            int i13 = iArr2[i12];
            int zzu = zzu(i12);
            int i14 = this.zzc[i12 + 2];
            int i15 = i14 & 1048575;
            int i16 = 1 << (i14 >>> 20);
            if (i15 != i9) {
                if (i15 != 1048575) {
                    i10 = zzb.getInt(obj, i15);
                }
                i6 = i10;
                i9 = i15;
            } else {
                i6 = i10;
            }
            if ((268435456 & zzu) != 0) {
                i7 = i12;
                i8 = i9;
                if (!zzO(obj, i7, i8, i6, i16)) {
                    return false;
                }
            } else {
                i7 = i12;
                i8 = i9;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, i13, i7) && !zzP(obj, zzu, zzx(i7))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzeu) zzgn.zzf(obj, zzu & 1048575)).isEmpty()) {
                            throw null;
                        }
                    }
                }
                List list = (List) zzgn.zzf(obj, zzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzfm zzx = zzx(i7);
                    for (int i17 = 0; i17 < list.size(); i17++) {
                        if (!zzx.zzl(list.get(i17))) {
                            return false;
                        }
                    }
                }
            } else if (zzO(obj, i7, i8, i6, i16) && !zzP(obj, zzu, zzx(i7))) {
                return false;
            }
            i11++;
            i9 = i8;
            i10 = i6;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private final Object zzA(Object obj, int i6) {
        zzfm zzx = zzx(i6);
        int zzu = zzu(i6) & 1048575;
        if (!zzN(obj, i6)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private final Object zzB(Object obj, int i6, int i7) {
        zzfm zzx = zzx(i7);
        if (!zzR(obj, i6, i7)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i7) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object zze = zzx.zze();
        if (object != null) {
            zzx.zzg(zze, object);
        }
        return zze;
    }

    private static Field zzC(Class cls, String str) {
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

    private static void zzD(Object obj) {
        if (zzQ(obj)) {
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i6) {
        if (!zzN(obj2, i6)) {
            return;
        }
        int zzu = zzu(i6) & 1048575;
        Unsafe unsafe = zzb;
        long j6 = zzu;
        Object object = unsafe.getObject(obj2, j6);
        if (object != null) {
            zzfm zzx = zzx(i6);
            if (!zzN(obj, i6)) {
                if (!zzQ(object)) {
                    unsafe.putObject(obj, j6, object);
                } else {
                    Object zze = zzx.zze();
                    zzx.zzg(zze, object);
                    unsafe.putObject(obj, j6, zze);
                }
                zzH(obj, i6);
                return;
            }
            Object object2 = unsafe.getObject(obj, j6);
            if (!zzQ(object2)) {
                Object zze2 = zzx.zze();
                zzx.zzg(zze2, object2);
                unsafe.putObject(obj, j6, zze2);
                object2 = zze2;
            }
            zzx.zzg(object2, object);
            return;
        }
        throw new IllegalStateException("Source subfield " + this.zzc[i6] + " is present but null: " + obj2.toString());
    }

    private final void zzG(Object obj, int i6, zzfl zzflVar) throws IOException {
        long j6 = i6 & 1048575;
        if (zzM(i6)) {
            zzgn.zzs(obj, j6, zzflVar.zzs());
        } else if (this.zzi) {
            zzgn.zzs(obj, j6, zzflVar.zzr());
        } else {
            zzgn.zzs(obj, j6, zzflVar.zzp());
        }
    }

    private final void zzH(Object obj, int i6) {
        int zzr = zzr(i6);
        long j6 = 1048575 & zzr;
        if (j6 == 1048575) {
            return;
        }
        zzgn.zzq(obj, j6, (1 << (zzr >>> 20)) | zzgn.zzc(obj, j6));
    }

    private final void zzI(Object obj, int i6, int i7) {
        zzgn.zzq(obj, zzr(i7) & 1048575, i6);
    }

    private final boolean zzL(Object obj, Object obj2, int i6) {
        if (zzN(obj, i6) == zzN(obj2, i6)) {
            return true;
        }
        return false;
    }

    private final boolean zzN(Object obj, int i6) {
        int zzr = zzr(i6);
        long j6 = zzr & 1048575;
        if (j6 == 1048575) {
            int zzu = zzu(i6);
            long j7 = zzu & 1048575;
            switch (zzt(zzu)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzgn.zza(obj, j7)) == 0) {
                        return false;
                    }
                    return true;
                case 1:
                    if (Float.floatToRawIntBits(zzgn.zzb(obj, j7)) == 0) {
                        return false;
                    }
                    return true;
                case 2:
                    if (zzgn.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 3:
                    if (zzgn.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 4:
                    if (zzgn.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 5:
                    if (zzgn.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 6:
                    if (zzgn.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 7:
                    return zzgn.zzw(obj, j7);
                case 8:
                    Object zzf = zzgn.zzf(obj, j7);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                    if (zzf instanceof zzcs) {
                        if (zzcs.zzb.equals(zzf)) {
                            return false;
                        }
                        return true;
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (zzgn.zzf(obj, j7) == null) {
                        return false;
                    }
                    return true;
                case 10:
                    if (zzcs.zzb.equals(zzgn.zzf(obj, j7))) {
                        return false;
                    }
                    return true;
                case 11:
                    if (zzgn.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 12:
                    if (zzgn.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 13:
                    if (zzgn.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 14:
                    if (zzgn.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 15:
                    if (zzgn.zzc(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 16:
                    if (zzgn.zzd(obj, j7) == 0) {
                        return false;
                    }
                    return true;
                case 17:
                    if (zzgn.zzf(obj, j7) == null) {
                        return false;
                    }
                    return true;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if ((zzgn.zzc(obj, j6) & (1 << (zzr >>> 20))) == 0) {
            return false;
        }
        return true;
    }

    private final boolean zzO(Object obj, int i6, int i7, int i8, int i9) {
        if (i7 == 1048575) {
            return zzN(obj, i6);
        }
        if ((i8 & i9) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzP(Object obj, int i6, zzfm zzfmVar) {
        return zzfmVar.zzl(zzgn.zzf(obj, i6 & 1048575));
    }

    private final boolean zzR(Object obj, int i6, int i7) {
        if (zzgn.zzc(obj, zzr(i7) & 1048575) == i6) {
            return true;
        }
        return false;
    }

    private static boolean zzS(Object obj, long j6) {
        return ((Boolean) zzgn.zzf(obj, j6)).booleanValue();
    }

    private static double zzn(Object obj, long j6) {
        return ((Double) zzgn.zzf(obj, j6)).doubleValue();
    }

    private static float zzo(Object obj, long j6) {
        return ((Float) zzgn.zzf(obj, j6)).floatValue();
    }

    private static int zzp(Object obj, long j6) {
        return ((Integer) zzgn.zzf(obj, j6)).intValue();
    }

    private static long zzv(Object obj, long j6) {
        return ((Long) zzgn.zzf(obj, j6)).longValue();
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzdv) {
                zzdv zzdvVar = (zzdv) obj;
                zzdvVar.zzL(Integer.MAX_VALUE);
                zzdvVar.zza = 0;
                zzdvVar.zzJ();
            }
            int[] iArr = this.zzc;
            for (int i6 = 0; i6 < iArr.length; i6 += 3) {
                int zzu = zzu(i6);
                int i7 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j6 = i7;
                if (zzt != 9) {
                    if (zzt != 60 && zzt != 68) {
                        switch (zzt) {
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
                                this.zzm.zzb(obj, j6);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j6);
                                if (object != null) {
                                    ((zzeu) object).zzc();
                                    unsafe.putObject(obj, j6, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (zzR(obj, this.zzc[i6], i6)) {
                        zzx(i6).zzf(zzb.getObject(obj, j6));
                    }
                }
                if (zzN(obj, i6)) {
                    zzx(i6).zzf(zzb.getObject(obj, j6));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_acceleration.zzfm
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int zzu = zzu(i6);
            int i7 = 1048575 & zzu;
            int[] iArr = this.zzc;
            int zzt = zzt(zzu);
            int i8 = iArr[i6];
            long j6 = i7;
            switch (zzt) {
                case 0:
                    if (zzN(obj2, i6)) {
                        zzgn.zzo(obj, j6, zzgn.zza(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzN(obj2, i6)) {
                        zzgn.zzp(obj, j6, zzgn.zzb(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzN(obj2, i6)) {
                        zzgn.zzr(obj, j6, zzgn.zzd(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzN(obj2, i6)) {
                        zzgn.zzr(obj, j6, zzgn.zzd(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzN(obj2, i6)) {
                        zzgn.zzq(obj, j6, zzgn.zzc(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzN(obj2, i6)) {
                        zzgn.zzr(obj, j6, zzgn.zzd(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzN(obj2, i6)) {
                        zzgn.zzq(obj, j6, zzgn.zzc(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzN(obj2, i6)) {
                        zzgn.zzm(obj, j6, zzgn.zzw(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzN(obj2, i6)) {
                        zzgn.zzs(obj, j6, zzgn.zzf(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i6);
                    break;
                case 10:
                    if (zzN(obj2, i6)) {
                        zzgn.zzs(obj, j6, zzgn.zzf(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzN(obj2, i6)) {
                        zzgn.zzq(obj, j6, zzgn.zzc(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzN(obj2, i6)) {
                        zzgn.zzq(obj, j6, zzgn.zzc(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzN(obj2, i6)) {
                        zzgn.zzq(obj, j6, zzgn.zzc(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzN(obj2, i6)) {
                        zzgn.zzr(obj, j6, zzgn.zzd(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzN(obj2, i6)) {
                        zzgn.zzq(obj, j6, zzgn.zzc(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzN(obj2, i6)) {
                        zzgn.zzr(obj, j6, zzgn.zzd(obj2, j6));
                        zzH(obj, i6);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i6);
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
                    this.zzm.zzc(obj, obj2, j6);
                    break;
                case 50:
                    int i9 = zzfo.zza;
                    zzgn.zzs(obj, j6, zzev.zzb(zzgn.zzf(obj, j6), zzgn.zzf(obj2, j6)));
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
                    if (zzR(obj2, i8, i6)) {
                        zzgn.zzs(obj, j6, zzgn.zzf(obj2, j6));
                        zzI(obj, i8, i6);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzF(obj, obj2, i6);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i8, i6)) {
                        zzgn.zzs(obj, j6, zzgn.zzf(obj2, j6));
                        zzI(obj, i8, i6);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i6);
                    break;
            }
        }
        zzfo.zzq(this.zzn, obj, obj2);
        if (!this.zzh) {
            return;
        }
        this.zzo.zza(obj2);
        throw null;
    }
}
