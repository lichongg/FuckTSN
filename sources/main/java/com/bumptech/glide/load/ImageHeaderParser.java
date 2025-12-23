package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface ImageHeaderParser {

    /* renamed from: a, reason: collision with root package name */
    public static final int f14908a = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        ImageType(boolean z5) {
            this.hasAlpha = z5;
        }
    }

    int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException;

    int b(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException;

    @NonNull
    ImageType getType(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException;
}
