package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public interface GifDecoder {

    /* renamed from: a, reason: collision with root package name */
    public static final int f14803a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f14804b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static final int f14805c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f14806d = 3;

    /* renamed from: e, reason: collision with root package name */
    public static final int f14807e = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface GifDecodeStatus {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        @NonNull
        byte[] a(int i6);

        @NonNull
        Bitmap b(int i6, int i7, @NonNull Bitmap.Config config);

        void c(@NonNull Bitmap bitmap);

        @NonNull
        int[] d(int i6);

        void e(@NonNull byte[] bArr);

        void f(@NonNull int[] iArr);
    }

    void a(@NonNull Bitmap.Config config);

    @Deprecated
    int b();

    void c(@NonNull b bVar, @NonNull byte[] bArr);

    void clear();

    void d();

    int e();

    int f(@Nullable InputStream inputStream, int i6);

    int g();

    @NonNull
    ByteBuffer getData();

    int getHeight();

    int getStatus();

    int getWidth();

    @Nullable
    Bitmap h();

    void i();

    int j();

    int k(int i6);

    int l();

    int m();

    void n(@NonNull b bVar, @NonNull ByteBuffer byteBuffer);

    void o(@NonNull b bVar, @NonNull ByteBuffer byteBuffer, int i6);

    int p();

    int read(@Nullable byte[] bArr);
}
