package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class RandomColorBetWeenTwoConstants extends ColorGenerate {

    /* renamed from: a, reason: collision with root package name */
    private float f9004a;

    /* renamed from: a1, reason: collision with root package name */
    private float f9005a1;

    /* renamed from: b, reason: collision with root package name */
    private float f9006b;

    /* renamed from: b1, reason: collision with root package name */
    private float f9007b1;

    /* renamed from: g, reason: collision with root package name */
    private float f9008g;

    /* renamed from: g1, reason: collision with root package name */
    private float f9009g1;

    /* renamed from: r, reason: collision with root package name */
    private float f9010r;

    /* renamed from: r1, reason: collision with root package name */
    private float f9011r1;

    @JBindingExclude
    private float[] color = {1.0f, 1.0f, 1.0f, 1.0f};

    @JBindingExclude
    private Random random = new Random();

    @Override // com.amap.api.maps.model.particle.ColorGenerate
    public float[] getColor() {
        float[] fArr = this.color;
        float nextFloat = this.random.nextFloat();
        float f6 = this.f9011r1;
        float f7 = this.f9010r;
        fArr[0] = (nextFloat * (f6 - f7)) + f7;
        float[] fArr2 = this.color;
        float nextFloat2 = this.random.nextFloat();
        float f8 = this.f9009g1;
        float f9 = this.f9008g;
        fArr2[1] = (nextFloat2 * (f8 - f9)) + f9;
        float[] fArr3 = this.color;
        float nextFloat3 = this.random.nextFloat();
        float f10 = this.f9007b1;
        float f11 = this.f9006b;
        fArr3[2] = (nextFloat3 * (f10 - f11)) + f11;
        float[] fArr4 = this.color;
        float nextFloat4 = this.random.nextFloat();
        float f12 = this.f9005a1;
        float f13 = this.f9004a;
        fArr4[3] = (nextFloat4 * (f12 - f13)) + f13;
        return this.color;
    }

    @JBindingExclude
    public RandomColorBetWeenTwoConstants(float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f9010r = f6 / 255.0f;
        this.f9008g = f7 / 255.0f;
        this.f9006b = f8 / 255.0f;
        this.f9004a = f9 / 255.0f;
        this.f9011r1 = f10 / 255.0f;
        this.f9009g1 = f11 / 255.0f;
        this.f9007b1 = f12 / 255.0f;
        this.f9005a1 = f13 / 255.0f;
        this.type = 0;
    }
}
