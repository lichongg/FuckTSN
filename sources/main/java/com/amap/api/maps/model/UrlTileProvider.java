package com.amap.api.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class UrlTileProvider implements TileProvider {
    private final int height;
    private final int width;

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public abstract URL getTileUrl(int i6, int i7, int i8);

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.height;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.width;
    }

    public UrlTileProvider(int i6, int i7) {
        this.width = i6;
        this.height = i7;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i6, int i7, int i8) {
        URL tileUrl = getTileUrl(i6, i7, i8);
        if (tileUrl == null) {
            return TileProvider.NO_TILE;
        }
        try {
            return Tile.obtain(this.width, this.height, a(tileUrl.openStream()));
        } catch (IOException e6) {
            Tile tile = TileProvider.NO_TILE;
            e6.printStackTrace();
            return tile;
        }
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j6 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j6;
            }
            outputStream.write(bArr, 0, read);
            j6 += read;
        }
    }
}
