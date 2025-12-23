package com.google.android.gms.internal.mlkit_vision_mediapipe;

import com.snail.antifake.deviceid.e;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import okio.Utf8;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzba implements zzah {
    private static final Set zza = new HashSet(Arrays.asList(Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class));
    private final StringBuilder zzd;
    private boolean zze = false;
    private final String zzb = "[CONTEXT ";
    private final String zzc = " ]";

    @Override // com.google.android.gms.internal.mlkit_vision_mediapipe.zzah
    public final void zza(String str, @NullableDecl Object obj) {
        if (this.zze) {
            this.zzd.append(' ');
        } else {
            if (this.zzd.length() > 0) {
                StringBuilder sb = this.zzd;
                sb.append((sb.length() > 1000 || this.zzd.indexOf(e.f37542d) != -1) ? '\n' : ' ');
            }
            this.zzd.append(this.zzb);
            this.zze = true;
        }
        StringBuilder sb2 = this.zzd;
        sb2.append(str);
        sb2.append('=');
        if (obj == null) {
            sb2.append(true);
            return;
        }
        if (zza.contains(obj.getClass())) {
            sb2.append(obj);
            return;
        }
        sb2.append('\"');
        String obj2 = obj.toString();
        int i6 = 0;
        while (true) {
            int zzc = zzc(obj2, i6);
            if (zzc == -1) {
                sb2.append((CharSequence) obj2, i6, obj2.length());
                sb2.append('\"');
                return;
            }
            sb2.append((CharSequence) obj2, i6, zzc);
            i6 = zzc + 1;
            char charAt = obj2.charAt(zzc);
            if (charAt == '\t') {
                charAt = 't';
            } else if (charAt == '\n') {
                charAt = 'n';
            } else if (charAt == '\r') {
                charAt = 'r';
            } else if (charAt != '\"' && charAt != '\\') {
                sb2.append(Utf8.REPLACEMENT_CHARACTER);
            }
            sb2.append("\\");
            sb2.append(charAt);
        }
    }

    public final void zzb() {
        if (this.zze) {
            this.zzd.append(this.zzc);
        }
    }

    public zzba(String str, String str2, StringBuilder sb) {
        this.zzd = sb;
    }

    private static int zzc(String str, int i6) {
        while (i6 < str.length()) {
            char charAt = str.charAt(i6);
            if (charAt >= ' ' && charAt != '\"' && charAt != '\\') {
                i6++;
            } else {
                return i6;
            }
        }
        return -1;
    }
}
