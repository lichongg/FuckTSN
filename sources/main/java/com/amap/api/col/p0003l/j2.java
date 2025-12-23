package com.amap.api.col.p0003l;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.tencent.bugly.BuglyStrategy;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class j2 implements TileProvider {

    /* renamed from: c, reason: collision with root package name */
    private MapConfig f6611c;

    /* renamed from: a, reason: collision with root package name */
    private final int f6609a = 256;

    /* renamed from: b, reason: collision with root package name */
    private final int f6610b = 256;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f6612d = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends k2 {

        /* renamed from: r, reason: collision with root package name */
        private int f6613r;

        /* renamed from: s, reason: collision with root package name */
        private int f6614s;

        /* renamed from: t, reason: collision with root package name */
        private int f6615t;

        /* renamed from: u, reason: collision with root package name */
        private String f6616u;

        /* renamed from: v, reason: collision with root package name */
        private String f6617v;

        /* renamed from: w, reason: collision with root package name */
        Random f6618w = new Random();

        public a(int i6, int i7, int i8, String str) {
            this.f6617v = "";
            this.f6613r = i6;
            this.f6614s = i7;
            this.f6615t = i8;
            this.f6616u = str;
            this.f6617v = i();
        }

        private String i() {
            if (u2.b(this.f6613r, this.f6614s, this.f6615t) || this.f6615t < 6) {
                return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", Integer.valueOf((this.f6618w.nextInt(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH) % 4) + 1));
            }
            if (MapsInitializer.isLoadWorldGridMap()) {
                return "http://restsdk.amap.com/v4/gridmap?";
            }
            return null;
        }

        @Override // com.amap.api.col.p0003l.Cif
        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(f4.j(d.f5883f));
            stringBuffer.append("&channel=amapapi");
            if (u2.b(this.f6613r, this.f6614s, this.f6615t) || this.f6615t < 6) {
                stringBuffer.append("&z=");
                stringBuffer.append(this.f6615t);
                stringBuffer.append("&x=");
                stringBuffer.append(this.f6613r);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f6614s);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            } else if (MapsInitializer.isLoadWorldGridMap()) {
                stringBuffer.append("&x=");
                stringBuffer.append(this.f6613r);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f6614s);
                stringBuffer.append("&z=");
                stringBuffer.append(this.f6615t);
                stringBuffer.append("&ds=0");
                stringBuffer.append("&dpitype=webrd");
                stringBuffer.append("&lang=");
                stringBuffer.append(this.f6616u);
                stringBuffer.append("&scale=2");
            }
            return this.f6617v + appendTsScode(stringBuffer.toString());
        }
    }

    private byte[] a(int i6, int i7, int i8, String str) throws IOException {
        try {
            return new a(i6, i7, i8, str).makeHttpRequestWithInterrupted();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i6, int i7, int i8) {
        try {
            if (!this.f6612d) {
                if (this.f6611c.getMapLanguage().equals("zh_cn")) {
                    if (!MapsInitializer.isLoadWorldGridMap()) {
                        return TileProvider.NO_TILE;
                    }
                    if (i8 < 6 || u2.b(i6, i7, i8)) {
                        return TileProvider.NO_TILE;
                    }
                } else if (!MapsInitializer.isLoadWorldGridMap() && i8 >= 6 && !u2.b(i6, i7, i8)) {
                    return TileProvider.NO_TILE;
                }
            }
            MapConfig mapConfig = this.f6611c;
            byte[] a6 = a(i6, i7, i8, mapConfig != null ? mapConfig.getMapLanguage() : "zh_cn");
            return a6 == null ? TileProvider.NO_TILE : Tile.obtain(this.f6609a, this.f6610b, a6);
        } catch (IOException unused) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileHeight() {
        return this.f6610b;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final int getTileWidth() {
        return this.f6609a;
    }

    public j2(MapConfig mapConfig) {
        this.f6611c = mapConfig;
    }
}
