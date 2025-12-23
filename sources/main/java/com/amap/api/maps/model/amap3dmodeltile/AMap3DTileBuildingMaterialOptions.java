package com.amap.api.maps.model.amap3dmodeltile;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class AMap3DTileBuildingMaterialOptions {
    public float metallicFactor;
    public float roughnessFactor;
    public String type;

    public AMap3DTileBuildingMaterialOptions(String str, float f6, float f7) {
        this.type = str;
        this.metallicFactor = f6;
        this.roughnessFactor = f7;
    }
}
