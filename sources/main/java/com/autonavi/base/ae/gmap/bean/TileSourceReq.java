package com.autonavi.base.ae.gmap.bean;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class TileSourceReq {
    public int sourceType;

    /* renamed from: x, reason: collision with root package name */
    public int f10283x;

    /* renamed from: y, reason: collision with root package name */
    public int f10284y;
    public int zoom;

    @JBindingExclude
    public String toString() {
        return "TileSourceReq{x=" + this.f10283x + ", y=" + this.f10284y + ", zoom=" + this.zoom + ", sourceId=" + this.sourceType + '}';
    }
}
