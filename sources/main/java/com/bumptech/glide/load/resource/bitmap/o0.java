package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class o0<T> implements com.bumptech.glide.load.g<T, Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15646d = "VideoDecoder";

    /* renamed from: e, reason: collision with root package name */
    public static final long f15647e = -1;

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    static final int f15648f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Long> f15649g = com.bumptech.glide.load.e.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: h, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<Integer> f15650h = com.bumptech.glide.load.e.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: i, reason: collision with root package name */
    private static final e f15651i = new e();

    /* renamed from: a, reason: collision with root package name */
    private final f<T> f15652a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.e f15653b;

    /* renamed from: c, reason: collision with root package name */
    private final e f15654c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements e.b<Long> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f15655a = ByteBuffer.allocate(8);

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Long l6, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f15655a) {
                this.f15655a.position(0);
                messageDigest.update(this.f15655a.putLong(l6.longValue()).array());
            }
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements e.b<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f15656a = ByteBuffer.allocate(4);

        @Override // com.bumptech.glide.load.e.b
        public void update(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f15656a) {
                this.f15656a.position(0);
                messageDigest.update(this.f15656a.putInt(num.intValue()).array());
            }
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o0.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(23)
    static final class d implements f<ByteBuffer> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends MediaDataSource {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ByteBuffer f15657a;

            a(ByteBuffer byteBuffer) {
                this.f15657a = byteBuffer;
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f15657a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j6, byte[] bArr, int i6, int i7) {
                if (j6 >= this.f15657a.limit()) {
                    return -1;
                }
                this.f15657a.position((int) j6);
                int min = Math.min(i7, this.f15657a.remaining());
                this.f15657a.get(bArr, i6, min);
                return min;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o0.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }

        d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    static class e {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }

        e() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @VisibleForTesting
    interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class h extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    o0(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, f<T> fVar) {
        this(eVar, fVar, f15651i);
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull T t5, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o0.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    @VisibleForTesting
    o0(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, f<T> fVar, e eVar2) {
        this.f15653b = eVar;
        this.f15652a = fVar;
        this.f15654c = eVar2;
    }

    public static com.bumptech.glide.load.g<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new o0(eVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static com.bumptech.glide.load.g<ByteBuffer, Bitmap> d(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new o0(eVar, new d());
    }

    @Nullable
    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j6, int i6, int i7, int i8, DownsampleStrategy downsampleStrategy) {
        Bitmap g6 = (Build.VERSION.SDK_INT < 27 || i7 == Integer.MIN_VALUE || i8 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f15559f) ? null : g(mediaMetadataRetriever, j6, i6, i7, i8, downsampleStrategy);
        if (g6 == null) {
            g6 = f(mediaMetadataRetriever, j6, i6);
        }
        if (g6 != null) {
            return g6;
        }
        throw new h();
    }

    @Nullable
    @TargetApi(27)
    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j6, int i6, int i7, int i8, DownsampleStrategy downsampleStrategy) {
        Bitmap scaledFrameAtTime;
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b6 = downsampleStrategy.b(parseInt, parseInt2, i7, i8);
            scaledFrameAtTime = mediaMetadataRetriever.getScaledFrameAtTime(j6, i6, Math.round(parseInt * b6), Math.round(b6 * parseInt2));
            return scaledFrameAtTime;
        } catch (Throwable unused) {
            Log.isLoggable(f15646d, 3);
            return null;
        }
    }

    public static com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> h(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new o0(eVar, new g());
    }

    @Override // com.bumptech.glide.load.g
    public com.bumptech.glide.load.engine.u<Bitmap> b(@NonNull T t5, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        long longValue = ((Long) fVar.c(f15649g)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) fVar.c(f15650h);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.c(DownsampleStrategy.f15561h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f15560g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever a6 = this.f15654c.a();
        try {
            this.f15652a.a(a6, t5);
            Bitmap e6 = e(a6, longValue, num.intValue(), i6, i7, downsampleStrategy2);
            a6.release();
            return com.bumptech.glide.load.resource.bitmap.g.c(e6, this.f15653b);
        } catch (Throwable th) {
            a6.release();
            throw th;
        }
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j6, int i6) {
        return mediaMetadataRetriever.getFrameAtTime(j6, i6);
    }
}
