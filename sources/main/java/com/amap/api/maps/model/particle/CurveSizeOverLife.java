package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class CurveSizeOverLife extends SizeOverLife {

    /* renamed from: x, reason: collision with root package name */
    private float f9001x;

    /* renamed from: y, reason: collision with root package name */
    private float f9002y;

    /* renamed from: z, reason: collision with root package name */
    private float f9003z;

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f6) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f6) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f6) {
        return 0.0f;
    }

    public CurveSizeOverLife(float f6, float f7, float f8) {
        this.f9001x = f6;
        this.f9002y = f7;
        this.f9003z = f8;
        this.type = 0;
    }
}
