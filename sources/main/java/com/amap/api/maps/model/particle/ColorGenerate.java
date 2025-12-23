package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class ColorGenerate {

    @JBindingExclude
    protected final int TYPE_DEFAULT = -1;

    @JBindingExclude
    protected final int TYPE_RANDOMCOLORBETWEENTWOCONSTANTS = 0;
    protected int type = -1;

    public abstract float[] getColor();
}
