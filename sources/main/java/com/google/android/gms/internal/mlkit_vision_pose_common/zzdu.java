package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdu implements Closeable {
    private final Reader zzb;
    private long zzi;
    private int zzj;
    private int[] zzk;
    private String[] zzm;
    private int[] zzn;
    private zzdd zzc = zzdd.LEGACY_STRICT;
    private final char[] zzd = new char[1024];
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    private int zzh = 0;
    int zza = 0;
    private int zzl = 1;

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0140, code lost:
    
        r3 = r1 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0142, code lost:
    
        if (r0 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0144, code lost:
    
        r0 = new java.lang.StringBuilder(java.lang.Math.max(r3 + r3, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0150, code lost:
    
        r0.append(r4, r2, r3);
        r11.zze = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f1, code lost:
    
        throw zzp("Malformed Unicode escape \\u".concat(new java.lang.String(r6, r11.zze, 4)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String zzr(char r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzdu.zzr(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0048, code lost:
    
        zzt();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String zzs() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r5.zze
            int r3 = r3 + r2
            int r4 = r5.zzf
            if (r3 >= r4) goto L4c
            char[] r4 = r5.zzd
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L59
            r4 = 10
            if (r3 == r4) goto L59
            r4 = 12
            if (r3 == r4) goto L59
            r4 = 13
            if (r3 == r4) goto L59
            r4 = 32
            if (r3 == r4) goto L59
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L59
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L59
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L59
            r4 = 58
            if (r3 == r4) goto L59
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L59;
                case 92: goto L48;
                case 93: goto L59;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.zzt()
            goto L59
        L4c:
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 >= r3) goto L5b
            int r3 = r2 + 1
            boolean r3 = r5.zzw(r3)
            if (r3 == 0) goto L59
            goto L3
        L59:
            r0 = r2
            goto L7b
        L5b:
            if (r1 != 0) goto L68
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L68:
            char[] r3 = r5.zzd
            int r4 = r5.zze
            r1.append(r3, r4, r2)
            int r3 = r5.zze
            int r3 = r3 + r2
            r5.zze = r3
            r2 = 1
            boolean r2 = r5.zzw(r2)
            if (r2 != 0) goto L2
        L7b:
            if (r1 != 0) goto L87
            char[] r1 = r5.zzd
            java.lang.String r2 = new java.lang.String
            int r3 = r5.zze
            r2.<init>(r1, r3, r0)
            goto L92
        L87:
            char[] r2 = r5.zzd
            int r3 = r5.zze
            r1.append(r2, r3, r0)
            java.lang.String r2 = r1.toString()
        L92:
            int r1 = r5.zze
            int r1 = r1 + r0
            r5.zze = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzdu.zzs():java.lang.String");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza = 0;
        this.zzk[0] = 8;
        this.zzl = 1;
        this.zzb.close();
    }

    static {
        zzdf.zza = new zzdt();
    }

    private final int zzo(boolean z5) throws IOException {
        int i6;
        int i7 = this.zze;
        int i8 = this.zzf;
        while (true) {
            if (i7 == i8) {
                this.zze = i7;
                if (!zzw(1)) {
                    if (z5) {
                        throw new EOFException("End of input".concat(zzc()));
                    }
                    return -1;
                }
                i7 = this.zze;
                i8 = this.zzf;
            }
            char[] cArr = this.zzd;
            int i9 = i7 + 1;
            char c6 = cArr[i7];
            if (c6 == '\n') {
                this.zzg++;
                this.zzh = i9;
            } else if (c6 != ' ' && c6 != '\r' && c6 != '\t') {
                if (c6 == '/') {
                    this.zze = i9;
                    if (i9 == i8) {
                        this.zze = i7;
                        boolean zzw = zzw(2);
                        this.zze++;
                        if (!zzw) {
                            return 47;
                        }
                    }
                    zzt();
                    int i10 = this.zze;
                    char c7 = cArr[i10];
                    if (c7 == '*') {
                        this.zze = i10 + 1;
                        while (true) {
                            if (this.zze + 2 > this.zzf && !zzw(2)) {
                                throw zzp("Unterminated comment");
                            }
                            char[] cArr2 = this.zzd;
                            int i11 = this.zze;
                            if (cArr2[i11] != '\n') {
                                while (i6 < 2) {
                                    i6 = this.zzd[this.zze + i6] == "*/".charAt(i6) ? i6 + 1 : 0;
                                }
                                i7 = this.zze + 2;
                                i8 = this.zzf;
                                break;
                            }
                            this.zzg++;
                            this.zzh = i11 + 1;
                            this.zze++;
                        }
                    } else {
                        if (c7 != '/') {
                            return 47;
                        }
                        this.zze = i10 + 1;
                        zzv();
                        i7 = this.zze;
                        i8 = this.zzf;
                    }
                } else {
                    if (c6 != '#') {
                        this.zze = i9;
                        return c6;
                    }
                    this.zze = i9;
                    zzt();
                    zzv();
                    i7 = this.zze;
                    i8 = this.zzf;
                }
            }
            i7 = i9;
        }
    }

    private final zzdx zzp(String str) throws zzdx {
        throw new zzdx(str + zzc() + "\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#malformed-json");
    }

    private final void zzt() throws zzdx {
        if (this.zzc != zzdd.LENIENT) {
            throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        }
    }

    private final void zzu(int i6) throws zzdx {
        int i7 = this.zzl;
        if (i7 - 1 >= 1280) {
            throw new zzdx("Nesting limit 1280 reached" + zzc());
        }
        int[] iArr = this.zzk;
        if (i7 == iArr.length) {
            int i8 = i7 + i7;
            this.zzk = Arrays.copyOf(iArr, i8);
            this.zzn = Arrays.copyOf(this.zzn, i8);
            this.zzm = (String[]) Arrays.copyOf(this.zzm, i8);
        }
        int[] iArr2 = this.zzk;
        int i9 = this.zzl;
        this.zzl = i9 + 1;
        iArr2[i9] = i6;
    }

    private final void zzv() throws IOException {
        char c6;
        do {
            if (this.zze >= this.zzf && !zzw(1)) {
                return;
            }
            char[] cArr = this.zzd;
            int i6 = this.zze;
            int i7 = i6 + 1;
            this.zze = i7;
            c6 = cArr[i6];
            if (c6 == '\n') {
                this.zzg++;
                this.zzh = i7;
                return;
            }
        } while (c6 != '\r');
    }

    private final boolean zzw(int i6) throws IOException {
        int i7;
        int i8 = this.zzh;
        int i9 = this.zze;
        this.zzh = i8 - i9;
        char[] cArr = this.zzd;
        int i10 = this.zzf;
        if (i10 != i9) {
            int i11 = i10 - i9;
            this.zzf = i11;
            System.arraycopy(cArr, i9, cArr, 0, i11);
        } else {
            this.zzf = 0;
        }
        this.zze = 0;
        do {
            Reader reader = this.zzb;
            int i12 = this.zzf;
            int read = reader.read(cArr, i12, 1024 - i12);
            if (read == -1) {
                return false;
            }
            i7 = this.zzf + read;
            this.zzf = i7;
            if (this.zzg == 0 && this.zzh == 0 && i7 > 0 && cArr[0] == 65279) {
                this.zze++;
                this.zzh = 1;
                i6++;
            }
        } while (i7 < i6);
        return true;
    }

    private final boolean zzx(char c6) throws IOException {
        if (c6 == '\t' || c6 == '\n' || c6 == '\f' || c6 == '\r' || c6 == ' ') {
            return false;
        }
        if (c6 != '#') {
            if (c6 == ',') {
                return false;
            }
            if (c6 != '/' && c6 != '=') {
                if (c6 == '{' || c6 == '}' || c6 == ':') {
                    return false;
                }
                if (c6 != ';') {
                    switch (c6) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        zzt();
        return false;
    }

    public final String toString() {
        return zzdu.class.getSimpleName().concat(zzc());
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x022b, code lost:
    
        if (zzx(r1) == false) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02b4, code lost:
    
        if (r4 == 1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01b3, code lost:
    
        r8 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x022f, code lost:
    
        if (r15 != 2) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0231, code lost:
    
        if (r16 == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0237, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0239, code lost:
    
        if (r17 == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x023b, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0244, code lost:
    
        if (r11 != r20) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0246, code lost:
    
        if (r3 != false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x024c, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x024d, code lost:
    
        r24.zzi = r11;
        r24.zze += r10;
        r3 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0256, code lost:
    
        r24.zza = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0249, code lost:
    
        if (r3 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0240, code lost:
    
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x023d, code lost:
    
        r8 = 2;
        r15 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0259, code lost:
    
        if (r15 == r8) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x025c, code lost:
    
        if (r15 == 4) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x025e, code lost:
    
        if (r15 != 7) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0260, code lost:
    
        r24.zzj = r10;
        r3 = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0295 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzdu.zza():int");
    }

    public final zzdd zzb() {
        return this.zzc;
    }

    final String zzc() {
        int i6 = this.zzg + 1;
        int i7 = this.zze - this.zzh;
        StringBuilder sb = new StringBuilder();
        sb.append(v0.f47959c);
        for (int i8 = 0; i8 < this.zzl; i8++) {
            int i9 = this.zzk[i8];
            switch (i9) {
                case 1:
                case 2:
                    int i10 = this.zzn[i8];
                    sb.append('[');
                    sb.append(i10);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.zzm[i8];
                    if (str != null) {
                        sb.append(str);
                        break;
                    } else {
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError("Unknown scope value: " + i9);
            }
        }
        return " at line " + i6 + " column " + (i7 + 1) + " path " + sb.toString();
    }

    public final String zzd() throws IOException {
        String zzr;
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        if (i6 == 14) {
            zzr = zzs();
        } else if (i6 == 12) {
            zzr = zzr('\'');
        } else {
            if (i6 != 13) {
                throw zzq("a name");
            }
            zzr = zzr('\"');
        }
        this.zza = 0;
        this.zzm[this.zzl - 1] = zzr;
        return zzr;
    }

    public final String zze() throws IOException {
        String str;
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        if (i6 == 10) {
            str = zzs();
        } else if (i6 == 8) {
            str = zzr('\'');
        } else if (i6 == 9) {
            str = zzr('\"');
        } else if (i6 == 11) {
            str = null;
        } else if (i6 == 15) {
            str = Long.toString(this.zzi);
        } else {
            if (i6 != 16) {
                throw zzq("a string");
            }
            String str2 = new String(this.zzd, this.zze, this.zzj);
            this.zze += this.zzj;
            str = str2;
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i7 = this.zzl - 1;
        iArr[i7] = iArr[i7] + 1;
        return str;
    }

    public final void zzf() throws IOException {
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        if (i6 != 3) {
            throw zzq("BEGIN_ARRAY");
        }
        zzu(1);
        this.zzn[this.zzl - 1] = 0;
        this.zza = 0;
    }

    public final void zzg() throws IOException {
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        if (i6 != 1) {
            throw zzq("BEGIN_OBJECT");
        }
        zzu(3);
        this.zza = 0;
    }

    public final void zzh() throws IOException {
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        if (i6 != 4) {
            throw zzq("END_ARRAY");
        }
        int i7 = this.zzl;
        this.zzl = i7 - 1;
        int[] iArr = this.zzn;
        int i8 = i7 - 2;
        iArr[i8] = iArr[i8] + 1;
        this.zza = 0;
    }

    public final void zzi() throws IOException {
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        if (i6 != 2) {
            throw zzq("END_OBJECT");
        }
        int i7 = this.zzl;
        int i8 = i7 - 1;
        this.zzl = i8;
        this.zzm[i8] = null;
        int[] iArr = this.zzn;
        int i9 = i7 - 2;
        iArr[i9] = iArr[i9] + 1;
        this.zza = 0;
    }

    public final void zzj() throws IOException {
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        if (i6 != 7) {
            throw zzq("null");
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i7 = this.zzl - 1;
        iArr[i7] = iArr[i7] + 1;
    }

    public final boolean zzl() throws IOException {
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        return (i6 == 2 || i6 == 4 || i6 == 17) ? false : true;
    }

    public final boolean zzm() throws IOException {
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        if (i6 == 5) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i7 = this.zzl - 1;
            iArr[i7] = iArr[i7] + 1;
            return true;
        }
        if (i6 != 6) {
            throw zzq("a boolean");
        }
        this.zza = 0;
        int[] iArr2 = this.zzn;
        int i8 = this.zzl - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return false;
    }

    public final int zzn() throws IOException {
        int i6 = this.zza;
        if (i6 == 0) {
            i6 = zza();
        }
        switch (i6) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }

    public zzdu(Reader reader) {
        int[] iArr = new int[32];
        this.zzk = iArr;
        iArr[0] = 6;
        this.zzm = new String[32];
        this.zzn = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.zzb = reader;
    }

    private final IllegalStateException zzq(String str) throws IOException {
        String str2;
        int zzn = zzn();
        String zza = zzdv.zza(zzn());
        String zzc = zzc();
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(str);
        sb.append(" but was ");
        sb.append(zza);
        sb.append(zzc);
        sb.append("\nSee ");
        if (zzn == 9) {
            str2 = "adapter-not-null-safe";
        } else {
            str2 = "unexpected-json-structure";
        }
        sb.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(sb.toString());
    }

    public final void zzk(zzdd zzddVar) {
        Objects.requireNonNull(zzddVar);
        this.zzc = zzddVar;
    }
}
