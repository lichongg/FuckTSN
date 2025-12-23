package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class TranslateAnimation extends Animation {

    /* renamed from: x, reason: collision with root package name */
    @JBindingInclude
    private double f8999x;

    /* renamed from: y, reason: collision with root package name */
    @JBindingInclude
    private double f9000y;

    @Override // com.amap.api.maps.model.animation.Animation
    protected String getAnimationType() {
        return "TranslateAnimation";
    }

    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new GLTranslateAnimation(latLng);
        this.f8999x = latLng.latitude;
        this.f9000y = latLng.longitude;
    }
}
