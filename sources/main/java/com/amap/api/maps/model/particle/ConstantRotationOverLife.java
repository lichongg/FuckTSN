package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class ConstantRotationOverLife extends RotationOverLife {
    private float rotate;

    @Override // com.amap.api.maps.model.particle.RotationOverLife
    public float getRotate() {
        return this.rotate;
    }

    public ConstantRotationOverLife(float f6) {
        this.rotate = f6;
        this.type = 0;
    }
}
