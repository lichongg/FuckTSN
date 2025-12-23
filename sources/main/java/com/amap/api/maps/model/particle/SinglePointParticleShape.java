package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class SinglePointParticleShape extends ParticleShapeModule {
    private float[] point_3;

    public SinglePointParticleShape(float f6, float f7, float f8, boolean z5) {
        this.point_3 = new float[]{f6, f7, f8};
        this.isUseRatio = z5;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return this.point_3;
    }

    public SinglePointParticleShape(float f6, float f7, float f8) {
        this(f6, f7, f8, false);
    }
}
