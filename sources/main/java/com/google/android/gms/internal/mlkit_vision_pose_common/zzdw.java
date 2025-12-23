package com.google.android.gms.internal.mlkit_vision_pose_common;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzdw implements Closeable, Flushable {
    private static final Pattern zza = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] zzb = new String[128];
    private static final String[] zzc;
    private final Writer zzd;
    private int[] zze = new int[32];
    private int zzf = 0;
    private final zzct zzg;
    private final String zzh;
    private String zzi;
    private final boolean zzj;
    private zzdd zzk;
    private String zzl;

    public final zzdw zzc() throws IOException {
        zzl(1, 2, ']');
        return this;
    }

    public final zzdw zzd() throws IOException {
        zzl(3, 5, '}');
        return this;
    }

    static {
        for (int i6 = 0; i6 <= 31; i6++) {
            zzb[i6] = String.format("\\u%04x", Integer.valueOf(i6));
        }
        String[] strArr = zzb;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        zzc = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    private final int zzk() {
        int i6 = this.zzf;
        if (i6 != 0) {
            return this.zze[i6 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private final void zzo() throws IOException {
        if (this.zzj) {
            return;
        }
        this.zzd.write(this.zzg.zzb());
        int i6 = this.zzf;
        for (int i7 = 1; i7 < i6; i7++) {
            this.zzd.write(this.zzg.zza());
        }
    }

    private final void zzp(int i6) {
        int i7 = this.zzf;
        int[] iArr = this.zze;
        if (i7 == iArr.length) {
            this.zze = Arrays.copyOf(iArr, i7 + i7);
        }
        int[] iArr2 = this.zze;
        int i8 = this.zzf;
        this.zzf = i8 + 1;
        iArr2[i8] = i6;
    }

    private final void zzq(int i6) {
        this.zze[this.zzf - 1] = i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzr(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            java.io.Writer r0 = r8.zzd
            java.lang.String[] r1 = com.google.android.gms.internal.mlkit_vision_pose_common.zzdw.zzb
            r2 = 34
            r0.write(r2)
            int r0 = r9.length()
            r3 = 0
            r4 = 0
        Lf:
            if (r3 >= r0) goto L3d
            int r5 = r3 + 1
            char r6 = r9.charAt(r3)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L20
            r6 = r1[r6]
            if (r6 == 0) goto L3b
            goto L2d
        L20:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L27
            java.lang.String r6 = "\\u2028"
            goto L2d
        L27:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3b
            java.lang.String r6 = "\\u2029"
        L2d:
            if (r4 >= r3) goto L35
            java.io.Writer r7 = r8.zzd
            int r3 = r3 - r4
            r7.write(r9, r4, r3)
        L35:
            java.io.Writer r3 = r8.zzd
            r3.write(r6)
            r4 = r5
        L3b:
            r3 = r5
            goto Lf
        L3d:
            if (r4 >= r0) goto L45
            java.io.Writer r1 = r8.zzd
            int r0 = r0 - r4
            r1.write(r9, r4, r0)
        L45:
            java.io.Writer r9 = r8.zzd
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_pose_common.zzdw.zzr(java.lang.String):void");
    }

    private final void zzs() throws IOException {
        if (this.zzl != null) {
            int zzk = zzk();
            if (zzk == 5) {
                this.zzd.write(this.zzi);
            } else if (zzk != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            zzo();
            zzq(4);
            zzr(this.zzl);
            this.zzl = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzd.close();
        int i6 = this.zzf;
        if (i6 > 1 || (i6 == 1 && this.zze[0] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.zzf = 0;
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.zzf == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.zzd.flush();
    }

    public final zzdw zze(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.zzl != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int zzk = zzk();
        if (zzk != 3 && zzk != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.zzl = str;
        return this;
    }

    public final zzdw zzf() throws IOException {
        if (this.zzl != null) {
            zzs();
        }
        zzn();
        this.zzd.write("null");
        return this;
    }

    public final zzdw zzg(Number number) throws IOException {
        if (number == null) {
            zzf();
            return this;
        }
        zzs();
        String obj = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN")) {
                if (this.zzk != zzdd.LENIENT) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(obj));
                }
            } else if (cls != Float.class && cls != Double.class && !zza.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + String.valueOf(cls) + " is not a valid JSON number: " + obj);
            }
        }
        zzn();
        this.zzd.append((CharSequence) obj);
        return this;
    }

    public final zzdw zzh(String str) throws IOException {
        if (str == null) {
            zzf();
            return this;
        }
        zzs();
        zzn();
        zzr(str);
        return this;
    }

    public zzdw(Writer writer) {
        boolean z5 = false;
        zzp(6);
        this.zzk = zzdd.LEGACY_STRICT;
        Objects.requireNonNull(writer, "out == null");
        this.zzd = writer;
        zzct zzctVar = zzct.zza;
        Objects.requireNonNull(zzctVar);
        this.zzg = zzctVar;
        this.zzi = ",";
        if (zzctVar.zzc()) {
            this.zzh = ": ";
            if (zzctVar.zzb().isEmpty()) {
                this.zzi = ", ";
            }
        } else {
            this.zzh = ":";
        }
        if (zzctVar.zzb().isEmpty() && zzctVar.zza().isEmpty()) {
            z5 = true;
        }
        this.zzj = z5;
    }

    private final zzdw zzl(int i6, int i7, char c6) throws IOException {
        int zzk = zzk();
        if (zzk != i7 && zzk != i6) {
            throw new IllegalStateException("Nesting problem.");
        }
        String str = this.zzl;
        if (str == null) {
            this.zzf--;
            if (zzk == i7) {
                zzo();
            }
            this.zzd.write(c6);
            return this;
        }
        throw new IllegalStateException("Dangling name: ".concat(str));
    }

    private final zzdw zzm(int i6, char c6) throws IOException {
        zzn();
        zzp(i6);
        this.zzd.write(c6);
        return this;
    }

    private final void zzn() throws IOException {
        int zzk = zzk();
        if (zzk != 1) {
            if (zzk != 2) {
                if (zzk != 4) {
                    if (zzk != 6) {
                        if (zzk == 7) {
                            if (this.zzk != zzdd.LENIENT) {
                                throw new IllegalStateException("JSON must have only one top-level value.");
                            }
                        } else {
                            throw new IllegalStateException("Nesting problem.");
                        }
                    }
                    zzq(7);
                    return;
                }
                this.zzd.append((CharSequence) this.zzh);
                zzq(5);
                return;
            }
            this.zzd.append((CharSequence) this.zzi);
            zzo();
            return;
        }
        zzq(2);
        zzo();
    }

    public final zzdw zza() throws IOException {
        zzs();
        zzm(1, '[');
        return this;
    }

    public final zzdw zzb() throws IOException {
        zzs();
        zzm(3, '{');
        return this;
    }

    public final zzdw zzi(boolean z5) throws IOException {
        String str;
        zzs();
        zzn();
        if (true != z5) {
            str = "false";
        } else {
            str = "true";
        }
        this.zzd.write(str);
        return this;
    }

    public final void zzj(zzdd zzddVar) {
        Objects.requireNonNull(zzddVar);
        this.zzk = zzddVar;
    }
}
