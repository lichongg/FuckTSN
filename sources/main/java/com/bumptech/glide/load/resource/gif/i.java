package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class i implements com.bumptech.glide.load.g<InputStream, GifDrawable> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15755d = "StreamGifDecoder";

    /* renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f15756a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.g<ByteBuffer, GifDrawable> f15757b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f15758c;

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException unused) {
            Log.isLoggable(f15755d, 5);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return !((Boolean) fVar.c(h.f15754b)).booleanValue() && com.bumptech.glide.load.b.getType(this.f15756a, inputStream, this.f15758c) == ImageHeaderParser.ImageType.GIF;
    }

    public i(List<ImageHeaderParser> list, com.bumptech.glide.load.g<ByteBuffer, GifDrawable> gVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f15756a = list;
        this.f15757b = gVar;
        this.f15758c = bVar;
    }

    @Override // com.bumptech.glide.load.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public u<GifDrawable> b(@NonNull InputStream inputStream, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        byte[] e6 = e(inputStream);
        if (e6 == null) {
            return null;
        }
        return this.f15757b.b(ByteBuffer.wrap(e6), i6, i7, fVar);
    }
}
