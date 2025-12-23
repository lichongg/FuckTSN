package com.amap.api.maps.model;

import com.amap.api.col.p0003l.b3;
import com.autonavi.amap.mapcore.DPoint;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public WeightedLatLng(LatLng latLng, double d6) {
        if (latLng == null) {
            throw new IllegalArgumentException("latLng can not null");
        }
        this.latLng = latLng;
        this.mPoint = b3.t(latLng);
        if (d6 >= 0.0d) {
            this.intensity = d6;
        } else {
            this.intensity = 1.0d;
        }
    }

    protected DPoint getPoint() {
        return this.mPoint;
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }
}
