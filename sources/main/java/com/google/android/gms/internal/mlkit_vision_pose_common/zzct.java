package com.google.android.gms.internal.mlkit_vision_pose_common;

import com.snail.antifake.deviceid.e;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzct {
    public static final zzct zza = new zzct("", "", false);
    private final String zzb;
    private final String zzc;
    private final boolean zzd;

    static {
        new zzct(e.f37542d, "  ", true);
    }

    public final String zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    private zzct(String str, String str2, boolean z5) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (str.matches("[\r\n]*")) {
            if (str2.matches("[ \t]*")) {
                this.zzb = str;
                this.zzc = str2;
                this.zzd = z5;
                return;
            }
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
    }
}
