package com.amap.api.col.p0003l;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceReq;
import com.bxkj.base.v2.common.utils.g0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class h implements TileSourceProvider {

    /* renamed from: a, reason: collision with root package name */
    private int f6388a = 256;

    /* renamed from: b, reason: collision with root package name */
    private final TileOverlaySource f6389b;

    /* renamed from: c, reason: collision with root package name */
    private final TileOverlaySource f6390c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends k2 {

        /* renamed from: r, reason: collision with root package name */
        private String f6391r;

        /* renamed from: s, reason: collision with root package name */
        private String f6392s;

        public a(int i6, int i7, int i8, String str) {
            this.f6391r = "";
            this.f6392s = "";
            String format = String.format(str, Integer.valueOf(i8), Integer.valueOf(i6), Integer.valueOf(i7));
            if (!format.contains("?")) {
                this.f6391r = format + "?";
                return;
            }
            String[] split = format.split("\\?");
            if (split.length > 1) {
                this.f6391r = split[0] + "?";
                this.f6392s = split[1];
            }
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f6392s);
            stringBuffer.append("&key=");
            stringBuffer.append(f4.j(d.f5883f));
            stringBuffer.append("&channel=amapapi");
            return this.f6391r + appendTsScode(stringBuffer.toString());
        }

        @Override // com.amap.api.col.p0003l.k2, com.amap.api.col.p0003l.Cif
        public final Map<String, String> getRequestHead() {
            return super.getRequestHead();
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i6, int i7, int i8) {
        return null;
    }

    private Tile a(TileSourceReq tileSourceReq) {
        String str = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH;
        try {
            int i6 = tileSourceReq.f10283x;
            if (i6 > 0) {
                i6 /= 10;
            }
            int i7 = tileSourceReq.f10284y;
            if (i7 > 0) {
                i7 /= 10;
            }
            FileInputStream fileInputStream = new FileInputStream(new File(str + tileSourceReq.zoom + "/" + i6 + "/" + i7 + "/" + tileSourceReq.f10283x + "_" + tileSourceReq.f10284y + g0.f16898c));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            int i8 = this.f6388a;
            Tile tile = new Tile(i8, i8, bArr, true);
            fileInputStream.close();
            return tile;
        } catch (FileNotFoundException unused) {
            int i9 = tileSourceReq.f10283x;
            int i10 = tileSourceReq.zoom;
            int i11 = i9 >> (i10 - 6);
            int i12 = tileSourceReq.f10284y >> (i10 - 6);
            if (i11 >= 51 && i11 <= 53 && i12 >= 28 && i12 <= 31) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(str + "default.png"));
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    int i13 = this.f6388a;
                    Tile tile2 = new Tile(i13, i13, bArr2, true);
                    fileInputStream2.close();
                    return tile2;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return TileProvider.NO_TILE;
                }
            }
            return TileProvider.NO_TILE;
        } catch (IOException unused2) {
            return TileProvider.NO_TILE;
        }
    }

    private byte[] b(int i6, int i7, int i8, String str) {
        try {
            return new a(i6, i7, i8, str).makeHttpRequestWithInterrupted();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final Tile getTile(TileSourceReq tileSourceReq) {
        if (tileSourceReq == null) {
            return TileProvider.NO_TILE;
        }
        Tile tile = TileProvider.NO_TILE;
        try {
            String url = tileSourceReq.sourceType == this.f6390c.getId() ? this.f6390c.getUrl() : this.f6389b.getUrl();
            if (url == null) {
                return tile;
            }
            Tile a6 = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH != null ? a(tileSourceReq) : tile;
            if (a6 != tile) {
                return a6;
            }
            int i6 = this.f6388a;
            return new Tile(i6, i6, b(tileSourceReq.f10283x, tileSourceReq.f10284y, tileSourceReq.zoom, url), true);
        } catch (Exception e6) {
            Tile tile2 = TileProvider.NO_TILE;
            e6.printStackTrace();
            return tile2;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f6388a;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f6388a;
    }

    public h(TileOverlaySource tileOverlaySource, TileOverlaySource tileOverlaySource2) {
        this.f6389b = tileOverlaySource;
        this.f6390c = tileOverlaySource2;
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public final void cancel(TileSourceReq tileSourceReq) {
    }
}
