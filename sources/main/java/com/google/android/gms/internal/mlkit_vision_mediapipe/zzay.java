package com.google.android.gms.internal.mlkit_vision_mediapipe;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzay {
    private static final long zza;
    private static final zzay zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;

    static {
        long j6 = 0;
        for (int i6 = 0; i6 < 7; i6++) {
            j6 |= (i6 + 1) << ((int) ((" #(+,-0".charAt(i6) - ' ') * 3));
        }
        zza = j6;
        zzb = new zzay(0, -1, -1);
    }

    static int zzd(String str, boolean z5) {
        int i6 = true != z5 ? 0 : 128;
        for (int i7 = 0; i7 < str.length(); i7++) {
            int zzm = zzm(str.charAt(i7));
            if (zzm < 0) {
                throw new IllegalArgumentException("invalid flags: ".concat(str));
            }
            i6 |= 1 << zzm;
        }
        return i6;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzay) {
            zzay zzayVar = (zzay) obj;
            if (zzayVar.zzc == this.zzc && zzayVar.zzd == this.zzd && zzayVar.zze == this.zze) {
                return true;
            }
        }
        return false;
    }

    public static zzay zzf() {
        return zzb;
    }

    public static zzay zzg(String str, int i6, int i7, boolean z5) throws zzdv {
        if (i6 == i7 && !z5) {
            return zzb;
        }
        int i8 = true != z5 ? 0 : 128;
        while (i6 != i7) {
            int i9 = i6 + 1;
            char charAt = str.charAt(i6);
            if (charAt < ' ' || charAt > '0') {
                if (charAt > '9') {
                    throw zzdv.zza("invalid flag", str, i6);
                }
                int i10 = charAt - '0';
                while (i9 != i7) {
                    int i11 = i9 + 1;
                    char charAt2 = str.charAt(i9);
                    if (charAt2 == '.') {
                        return new zzay(i8, i10, zzn(str, i11, i7));
                    }
                    char c6 = (char) (charAt2 - '0');
                    if (c6 >= '\n') {
                        throw zzdv.zza("invalid width character", str, i9);
                    }
                    i10 = (i10 * 10) + c6;
                    if (i10 > 999999) {
                        throw zzdv.zzc("width too large", str, i6, i7);
                    }
                    i9 = i11;
                }
                return new zzay(i8, i10, -1);
            }
            int zzm = zzm(charAt);
            if (zzm < 0) {
                if (charAt == '.') {
                    return new zzay(i8, -1, zzn(str, i9, i7));
                }
                throw zzdv.zza("invalid flag", str, i6);
            }
            int i12 = 1 << zzm;
            if ((i8 & i12) != 0) {
                throw zzdv.zza("repeated flag", str, i6);
            }
            i8 |= i12;
            i6 = i9;
        }
        return new zzay(i8, -1, -1);
    }

    private static int zzm(char c6) {
        return ((int) ((zza >>> ((c6 - ' ') * 3)) & 7)) - 1;
    }

    private static int zzn(String str, int i6, int i7) throws zzdv {
        if (i6 == i7) {
            throw zzdv.zza("missing precision", str, i6 - 1);
        }
        int i8 = 0;
        for (int i9 = i6; i9 < i7; i9++) {
            char charAt = (char) (str.charAt(i9) - '0');
            if (charAt >= '\n') {
                throw zzdv.zza("invalid precision character", str, i9);
            }
            i8 = (i8 * 10) + charAt;
            if (i8 > 999999) {
                throw zzdv.zzc("precision too large", str, i6, i7);
            }
        }
        if (i8 != 0) {
            return i8;
        }
        if (i7 == i6 + 1) {
            return 0;
        }
        throw zzdv.zzc("invalid precision", str, i6, i7);
    }

    public final int hashCode() {
        return (((this.zzc * 31) + this.zzd) * 31) + this.zze;
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final boolean zzj() {
        return this == zzb;
    }

    public final boolean zzk() {
        return (this.zzc & 128) != 0;
    }

    private zzay(int i6, int i7, int i8) {
        this.zzc = i6;
        this.zzd = i7;
        this.zze = i8;
    }

    public final zzay zze(int i6, boolean z5, boolean z6) {
        if (!zzj()) {
            int i7 = this.zzc;
            int i8 = i7 & 128;
            if (i8 != 0) {
                if (i8 != i7 || this.zzd != -1 || this.zze != -1) {
                    return new zzay(i8, -1, -1);
                }
            } else {
                return zzb;
            }
        }
        return this;
    }

    public final StringBuilder zzh(StringBuilder sb) {
        if (!zzj()) {
            int i6 = this.zzc;
            int i7 = 0;
            while (true) {
                int i8 = i6 & (-129);
                int i9 = 1 << i7;
                if (i9 > i8) {
                    break;
                }
                if ((i8 & i9) != 0) {
                    sb.append(" #(+,-0".charAt(i7));
                }
                i7++;
            }
            int i10 = this.zzd;
            if (i10 != -1) {
                sb.append(i10);
            }
            if (this.zze != -1) {
                sb.append('.');
                sb.append(this.zze);
            }
        }
        return sb;
    }

    public final boolean zzi(zzax zzaxVar) {
        return zzl(zzaxVar.zzb(), zzaxVar.zzd().zza());
    }

    public final boolean zzl(int i6, boolean z5) {
        int i7;
        if (zzj()) {
            return true;
        }
        int i8 = this.zzc;
        if (((~i6) & i8) != 0) {
            return false;
        }
        if (!z5 && this.zze != -1) {
            return false;
        }
        int i9 = this.zzd;
        if ((i8 & 9) == 9 || (i7 = i8 & 96) == 96) {
            return false;
        }
        if (i7 == 0 || i9 != -1) {
            return true;
        }
        return false;
    }
}
