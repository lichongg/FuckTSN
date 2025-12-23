package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {

    @JBindingExclude
    private Random random = new Random();

    /* renamed from: x1, reason: collision with root package name */
    private float f9012x1;

    /* renamed from: x2, reason: collision with root package name */
    private float f9013x2;

    /* renamed from: y1, reason: collision with root package name */
    private float f9014y1;

    /* renamed from: y2, reason: collision with root package name */
    private float f9015y2;

    /* renamed from: z1, reason: collision with root package name */
    private float f9016z1;

    /* renamed from: z2, reason: collision with root package name */
    private float f9017z2;

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getX() {
        float nextFloat = this.random.nextFloat();
        float f6 = this.f9013x2;
        float f7 = this.f9012x1;
        return (nextFloat * (f6 - f7)) + f7;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getY() {
        float nextFloat = this.random.nextFloat();
        float f6 = this.f9015y2;
        float f7 = this.f9014y1;
        return (nextFloat * (f6 - f7)) + f7;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getZ() {
        float nextFloat = this.random.nextFloat();
        float f6 = this.f9017z2;
        float f7 = this.f9016z1;
        return (nextFloat * (f6 - f7)) + f7;
    }

    public RandomVelocityBetweenTwoConstants(float f6, float f7, float f8, float f9, float f10, float f11) {
        this.f9012x1 = f6;
        this.f9014y1 = f7;
        this.f9016z1 = f8;
        this.f9013x2 = f9;
        this.f9015y2 = f10;
        this.f9017z2 = f11;
        this.type = 0;
    }
}
