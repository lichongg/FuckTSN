package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class TileOverlaySource {

    @JBindingExclude
    public static int TILESOURCE_TYPE_FBO_TEXTURE = 4;

    @JBindingExclude
    public static int TILESOURCE_TYPE_IMAGE = 1;

    @JBindingExclude
    public static int TILESOURCE_TYPE_IMAGE_DEM = 3;

    @JBindingExclude
    public static int TILESOURCE_TYPE_VECTOR = 2;
    private String attribute;
    private final int id;
    private final int type;
    private final String url;
    private int minZoom = 3;
    private int maxZoom = 20;
    private boolean cacheEnabled = true;

    public int getId() {
        return this.id;
    }

    public int getMaxZoom() {
        return this.maxZoom;
    }

    public int getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCacheEnabled() {
        return this.cacheEnabled;
    }

    public void setCacheEnabled(boolean z5) {
        this.cacheEnabled = z5;
    }

    public void setMaxZoom(int i6) {
        this.maxZoom = i6;
    }

    public void setMinZoom(int i6) {
        this.minZoom = i6;
    }

    public TileOverlaySource(int i6, int i7, String str) {
        this.url = str;
        this.type = i7;
        this.id = i6;
    }
}
