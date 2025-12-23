package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzmx {
    private static final zzmx zza = new zzmx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzmx(int i6, int[] iArr, Object[] objArr, boolean z5) {
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
        if (obj == null || !(obj instanceof zzmx)) {
            return false;
        }
        zzmx zzmxVar = (zzmx) obj;
        int i6 = this.zzb;
        if (i6 == zzmxVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzmxVar.zzc;
            int i7 = 0;
            while (true) {
                if (i7 >= i6) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmxVar.zzd;
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
            zzly.zzb(sb, i6, String.valueOf(this.zzc[i7] >>> 3), this.zzd[i7]);
        }
    }

    final void zzk(zznj zznjVar) throws IOException {
        for (int i6 = 0; i6 < this.zzb; i6++) {
            zznjVar.zzw(this.zzc[i6] >>> 3, this.zzd[i6]);
        }
    }

    private zzmx() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzmx zzc() {
        return zza;
    }

    static zzmx zze(zzmx zzmxVar, zzmx zzmxVar2) {
        int i6 = zzmxVar.zzb + zzmxVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzmxVar.zzc, i6);
        System.arraycopy(zzmxVar2.zzc, 0, copyOf, zzmxVar.zzb, zzmxVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzmxVar.zzd, i6);
        System.arraycopy(zzmxVar2.zzd, 0, copyOf2, zzmxVar.zzb, zzmxVar2.zzb);
        return new zzmx(i6, copyOf, copyOf2, true);
    }

    static zzmx zzf() {
        return new zzmx(0, new int[8], new Object[8], true);
    }

    private final void zzm(int i6) {
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
        int zzz;
        int zzA;
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
                    i6 = zzjw.zzz(i11 << 3) + 8;
                } else if (i12 == 2) {
                    int i13 = i11 << 3;
                    zzjo zzjoVar = (zzjo) this.zzd[i9];
                    int zzz2 = zzjw.zzz(i13);
                    int zzd = zzjoVar.zzd();
                    i6 = zzz2 + zzjw.zzz(zzd) + zzd;
                } else if (i12 == 3) {
                    int zzz3 = zzjw.zzz(i11 << 3);
                    zzz = zzz3 + zzz3;
                    zzA = ((zzmx) this.zzd[i9]).zza();
                } else {
                    if (i12 != 5) {
                        throw new IllegalStateException(new zzla("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.zzd[i9]).getClass();
                    i6 = zzjw.zzz(i11 << 3) + 4;
                }
                i8 += i6;
            } else {
                int i14 = i11 << 3;
                long longValue = ((Long) this.zzd[i9]).longValue();
                zzz = zzjw.zzz(i14);
                zzA = zzjw.zzA(longValue);
            }
            i6 = zzz + zzA;
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
            zzjo zzjoVar = (zzjo) this.zzd[i8];
            int zzz = zzjw.zzz(8);
            int zzz2 = zzjw.zzz(16) + zzjw.zzz(i9);
            int zzz3 = zzjw.zzz(24);
            int zzd = zzjoVar.zzd();
            i7 += zzz + zzz + zzz2 + zzz3 + zzjw.zzz(zzd) + zzd;
        }
        this.zze = i7;
        return i7;
    }

    final zzmx zzd(zzmx zzmxVar) {
        if (zzmxVar.equals(zza)) {
            return this;
        }
        zzg();
        int i6 = this.zzb + zzmxVar.zzb;
        zzm(i6);
        System.arraycopy(zzmxVar.zzc, 0, this.zzc, this.zzb, zzmxVar.zzb);
        System.arraycopy(zzmxVar.zzd, 0, this.zzd, this.zzb, zzmxVar.zzb);
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

    public final void zzl(zznj zznjVar) throws IOException {
        if (this.zzb != 0) {
            for (int i6 = 0; i6 < this.zzb; i6++) {
                int i7 = this.zzc[i6];
                Object obj = this.zzd[i6];
                int i8 = i7 & 7;
                int i9 = i7 >>> 3;
                if (i8 == 0) {
                    zznjVar.zzt(i9, ((Long) obj).longValue());
                } else if (i8 == 1) {
                    zznjVar.zzm(i9, ((Long) obj).longValue());
                } else if (i8 == 2) {
                    zznjVar.zzd(i9, (zzjo) obj);
                } else if (i8 == 3) {
                    zznjVar.zzF(i9);
                    ((zzmx) obj).zzl(zznjVar);
                    zznjVar.zzh(i9);
                } else {
                    if (i8 != 5) {
                        throw new RuntimeException(new zzla("Protocol message tag had invalid wire type."));
                    }
                    zznjVar.zzk(i9, ((Integer) obj).intValue());
                }
            }
        }
    }

    final void zzj(int i6, Object obj) {
        zzg();
        zzm(this.zzb + 1);
        int[] iArr = this.zzc;
        int i7 = this.zzb;
        iArr[i7] = i6;
        this.zzd[i7] = obj;
        this.zzb = i7 + 1;
    }
}
