package com.google.android.gms.internal.mlkit_acceleration;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzge {
    private static final zzge zza = new zzge(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzge(int i6, int[] iArr, Object[] objArr, boolean z5) {
        this.zze = -1;
        this.zzb = i6;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzge)) {
            return false;
        }
        zzge zzgeVar = (zzge) obj;
        int i6 = this.zzb;
        if (i6 == zzgeVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgeVar.zzc;
            int i7 = 0;
            while (true) {
                if (i7 >= i6) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgeVar.zzd;
                    int i8 = this.zzb;
                    for (int i9 = 0; i9 < i8; i9++) {
                        if (objArr[i9].equals(objArr2[i9])) {
                        }
                    }
                    return true;
                }
                if (iArr[i7] != iArr2[i7]) {
                    break;
                }
                i7++;
            }
        }
        return false;
    }

    final void zzi(StringBuilder sb, int i6) {
        for (int i7 = 0; i7 < this.zzb; i7++) {
            zzfc.zzb(sb, i6, String.valueOf(this.zzc[i7] >>> 3), this.zzd[i7]);
        }
    }

    private zzge() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzge zzc() {
        return zza;
    }

    static zzge zze(zzge zzgeVar, zzge zzgeVar2) {
        int i6 = zzgeVar.zzb + zzgeVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzgeVar.zzc, i6);
        System.arraycopy(zzgeVar2.zzc, 0, copyOf, zzgeVar.zzb, zzgeVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgeVar.zzd, i6);
        System.arraycopy(zzgeVar2.zzd, 0, copyOf2, zzgeVar.zzb, zzgeVar2.zzb);
        return new zzge(i6, copyOf, copyOf2, true);
    }

    static zzge zzf() {
        return new zzge(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i6) {
        int[] iArr = this.zzc;
        if (i6 > iArr.length) {
            int i7 = this.zzb;
            int i8 = i7 + (i7 / 2);
            if (i8 >= i6) {
                i6 = i8;
            }
            if (i6 < 8) {
                i6 = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i6);
            this.zzd = Arrays.copyOf(this.zzd, i6);
        }
    }

    public final int hashCode() {
        int i6 = this.zzb;
        int i7 = i6 + 527;
        int[] iArr = this.zzc;
        int i8 = 17;
        int i9 = 17;
        for (int i10 = 0; i10 < i6; i10++) {
            i9 = (i9 * 31) + iArr[i10];
        }
        int i11 = ((i7 * 31) + i9) * 31;
        Object[] objArr = this.zzd;
        int i12 = this.zzb;
        for (int i13 = 0; i13 < i12; i13++) {
            i8 = (i8 * 31) + objArr[i13].hashCode();
        }
        return i11 + i8;
    }

    public final int zza() {
        int zzw;
        int zzx;
        int i6;
        int i7 = this.zze;
        if (i7 != -1) {
            return i7;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.zzb; i9++) {
            int i10 = this.zzc[i9];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 != 0) {
                if (i12 == 1) {
                    ((Long) this.zzd[i9]).getClass();
                    i6 = zzdd.zzw(i11 << 3) + 8;
                } else if (i12 == 2) {
                    int i13 = i11 << 3;
                    zzcs zzcsVar = (zzcs) this.zzd[i9];
                    int zzw2 = zzdd.zzw(i13);
                    int zzd = zzcsVar.zzd();
                    i6 = zzw2 + zzdd.zzw(zzd) + zzd;
                } else if (i12 == 3) {
                    int zzw3 = zzdd.zzw(i11 << 3);
                    zzw = zzw3 + zzw3;
                    zzx = ((zzge) this.zzd[i9]).zza();
                } else {
                    if (i12 != 5) {
                        throw new IllegalStateException(zzed.zza());
                    }
                    ((Integer) this.zzd[i9]).getClass();
                    i6 = zzdd.zzw(i11 << 3) + 4;
                }
                i8 += i6;
            } else {
                int i14 = i11 << 3;
                long longValue = ((Long) this.zzd[i9]).longValue();
                zzw = zzdd.zzw(i14);
                zzx = zzdd.zzx(longValue);
            }
            i6 = zzw + zzx;
            i8 += i6;
        }
        this.zze = i8;
        return i8;
    }

    public final int zzb() {
        int i6 = this.zze;
        if (i6 != -1) {
            return i6;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.zzb; i8++) {
            int i9 = this.zzc[i8] >>> 3;
            zzcs zzcsVar = (zzcs) this.zzd[i8];
            int zzw = zzdd.zzw(8);
            int zzw2 = zzdd.zzw(16) + zzdd.zzw(i9);
            int zzw3 = zzdd.zzw(24);
            int zzd = zzcsVar.zzd();
            i7 += zzw + zzw + zzw2 + zzw3 + zzdd.zzw(zzd) + zzd;
        }
        this.zze = i7;
        return i7;
    }

    final zzge zzd(zzge zzgeVar) {
        if (zzgeVar.equals(zza)) {
            return this;
        }
        zzg();
        int i6 = this.zzb + zzgeVar.zzb;
        zzl(i6);
        System.arraycopy(zzgeVar.zzc, 0, this.zzc, this.zzb, zzgeVar.zzb);
        System.arraycopy(zzgeVar.zzd, 0, this.zzd, this.zzb, zzgeVar.zzb);
        this.zzb = i6;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzk(zzgv zzgvVar) throws IOException {
        if (this.zzb != 0) {
            for (int i6 = 0; i6 < this.zzb; i6++) {
                int i7 = this.zzc[i6];
                Object obj = this.zzd[i6];
                int i8 = i7 & 7;
                int i9 = i7 >>> 3;
                if (i8 == 0) {
                    zzgvVar.zzt(i9, ((Long) obj).longValue());
                } else if (i8 == 1) {
                    zzgvVar.zzm(i9, ((Long) obj).longValue());
                } else if (i8 == 2) {
                    zzgvVar.zzd(i9, (zzcs) obj);
                } else if (i8 == 3) {
                    zzgvVar.zzE(i9);
                    ((zzge) obj).zzk(zzgvVar);
                    zzgvVar.zzh(i9);
                } else {
                    if (i8 != 5) {
                        throw new RuntimeException(zzed.zza());
                    }
                    zzgvVar.zzk(i9, ((Integer) obj).intValue());
                }
            }
        }
    }

    final void zzj(int i6, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i7 = this.zzb;
        iArr[i7] = i6;
        this.zzd[i7] = obj;
        this.zzb = i7 + 1;
    }
}
