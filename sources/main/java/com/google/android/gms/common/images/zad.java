package com.google.android.gms.common.images;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zad {
    public final Uri zaa;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zad) {
            return Objects.equal(((zad) obj).zaa, this.zaa);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa);
    }

    public zad(Uri uri) {
        this.zaa = uri;
    }
}
