package com.google.android.gms.internal.mlkit_vision_pose_common;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzvk {
    private final String zza;

    public final boolean equals(Object obj) {
        if (obj instanceof zzvk) {
            return this.zza.equals(((zzvk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String zza() {
        return this.zza;
    }

    zzvk(String str) {
        boolean z5;
        boolean z6;
        boolean z7;
        Preconditions.checkNotNull(str, "Null FID");
        int length = str.length();
        if (length == 22) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Invalid FID: must be exactly 22 characters: ".concat(str));
        char charAt = str.charAt(0);
        if (charAt >= 'c' && charAt <= 'f') {
            z6 = true;
        } else {
            z6 = false;
        }
        Preconditions.checkArgument(z6, "Invalid FID: must start with [c-f]: ".concat(str));
        for (int i6 = 0; i6 < length; i6++) {
            char charAt2 = str.charAt(i6);
            if ((charAt2 >= '0' && charAt2 <= '9') || ((charAt2 >= 'a' && charAt2 <= 'z') || ((charAt2 >= 'A' && charAt2 <= 'Z') || charAt2 == '-' || charAt2 == '_'))) {
                z7 = true;
            } else {
                z7 = false;
            }
            Preconditions.checkArgument(z7, "Invalid FID: must contain only URL-safe base-64 characters: ".concat(str));
        }
        this.zza = str;
    }
}
