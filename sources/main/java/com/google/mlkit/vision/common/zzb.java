package com.google.mlkit.vision.common;

import android.media.Image;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzb {
    private final Image zza;

    final Image zza() {
        return this.zza;
    }

    final Image.Plane[] zzb() {
        return this.zza.getPlanes();
    }

    zzb(Image image) {
        this.zza = image;
    }
}
