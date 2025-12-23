package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public interface TileProvider {
    public static final Tile NO_TILE = Tile.obtain(-1, -1, null);

    @JBindingInclude
    Tile getTile(int i6, int i7, int i8);

    @JBindingInclude
    int getTileHeight();

    @JBindingInclude
    int getTileWidth();
}
