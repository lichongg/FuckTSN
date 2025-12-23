package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLEmergeAnimation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class EmergeAnimation extends Animation {
    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "EmergeAnimation";
    }

    public EmergeAnimation(LatLng latLng) {
        this.glAnimation = new GLEmergeAnimation(latLng);
    }
}
