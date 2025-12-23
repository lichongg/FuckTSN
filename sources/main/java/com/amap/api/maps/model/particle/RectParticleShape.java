package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class RectParticleShape extends ParticleShapeModule {
    private final float bottom;
    private final float left;
    private final float right;

    /* renamed from: top, reason: collision with root package name */
    private final float f9018top;

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return null;
    }

    public RectParticleShape(float f6, float f7, float f8, float f9, boolean z5) {
        this.left = f6;
        this.f9018top = f7;
        this.right = f8;
        this.bottom = f9;
        this.isUseRatio = z5;
        this.type = 1;
    }
}
