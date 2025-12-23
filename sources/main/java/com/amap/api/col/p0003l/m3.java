package com.amap.api.col.p0003l;

import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m3 extends BaseOverlay {

    /* renamed from: b, reason: collision with root package name */
    private eo f6757b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<IGlOverlayLayer> f6758c;

    public m3(IGlOverlayLayer iGlOverlayLayer, eo eoVar, String str) {
        super(str);
        this.f6758c = new WeakReference<>(iGlOverlayLayer);
        this.f6757b = eoVar;
    }
}
