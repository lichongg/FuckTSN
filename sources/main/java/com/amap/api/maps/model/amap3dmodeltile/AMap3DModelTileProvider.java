package com.amap.api.maps.model.amap3dmodeltile;

import com.amap.api.col.p0003l.d;
import com.amap.api.col.p0003l.f4;
import com.amap.api.col.p0003l.k2;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class AMap3DModelTileProvider implements TileProvider {
    private static final String DEFAULT_URL = "https://lbs-3dtiles-service.amap.com/basemap/tiles/staging?compose=building@1669011850923&compose=tree@1668678765481&z=%d&x=%d&y=%d";
    private int tileSize = 256;
    private String url;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class AMap3DModelRequest extends k2 {
        private String baseQueryStr;
        private String baseUrl;

        @Override // com.amap.api.col.p0003l.Cif
        public String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.baseQueryStr);
            stringBuffer.append("&key=");
            stringBuffer.append(f4.j(d.f5883f));
            return this.baseUrl + appendTsScode(stringBuffer.toString());
        }

        public AMap3DModelRequest(String str) {
            this.baseUrl = "";
            this.baseQueryStr = "";
            this.isPostFlag = false;
            if (!str.contains("?")) {
                this.baseUrl = str + "?";
                return;
            }
            String[] split = str.split("\\?");
            if (split.length > 1) {
                this.baseUrl = split[0] + "?";
                this.baseQueryStr = split[1];
            }
        }
    }

    private String b(int i6, int i7, int i8) {
        String str = this.url;
        if (str == null) {
            str = DEFAULT_URL;
        }
        return String.format(str, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
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

    public final void setUrl(String str) {
        this.url = str;
    }

    private byte[] a(int i6, int i7, int i8) {
        try {
            return new AMap3DModelRequest(b(i6, i7, i8)).makeHttpRequestWithInterrupted();
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
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
}
