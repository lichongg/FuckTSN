package com.amap.api.maps.model;

import com.amap.api.col.p0003l.k2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class MVTTileProvider implements TileProvider {
    private String id;
    private String key;
    private int tileSize = 256;
    private String url;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends k2 {

        /* renamed from: a, reason: collision with root package name */
        String f8970a;

        public a(String str) {
            this.isPostFlag = false;
            this.f8970a = str;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            return this.f8970a;
        }
    }

    private byte[] a(int i6, int i7, int i8) {
        try {
            return new a(a(i6, i7, i8, this.tileSize)).makeHttpRequestWithInterrupted();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.tileSize;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.tileSize;
    }

    public final String getUrl() {
        return this.url;
    }

    public MVTTileProvider(String str, String str2, String str3) {
        this.url = str;
        this.key = str2;
        this.id = str3;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i6, int i7, int i8) {
        byte[] a6 = a(i8, i6, i7);
        if (a6 == null) {
            return TileProvider.NO_TILE;
        }
        int i9 = this.tileSize;
        return new Tile(i9, i9, a6, false);
    }

    private String a(int i6, int i7, int i8, int i9) {
        return String.format(this.url + "?z=%d&x=%d&y=%d&size=%d&key=" + this.key + "&id=" + this.id, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
    }
}
