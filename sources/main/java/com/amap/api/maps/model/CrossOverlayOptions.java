package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CrossOverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    AVectorCrossAttr f8966a = null;
    private Bitmap bitmapDescriptor = null;

    public AVectorCrossAttr getAttribute() {
        return this.f8966a;
    }

    public Bitmap getRes() {
        return this.bitmapDescriptor;
    }

    public CrossOverlayOptions setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        this.f8966a = aVectorCrossAttr;
        return this;
    }

    public CrossOverlayOptions setRes(Bitmap bitmap) {
        this.bitmapDescriptor = bitmap;
        return this;
    }
}
