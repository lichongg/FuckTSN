package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.a0;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(api = 28)
/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class k<T> implements com.bumptech.glide.load.g<ImageDecoder.Source, T> {

    /* renamed from: b, reason: collision with root package name */
    private static final String f15759b = "ImageDecoder";

    /* renamed from: a, reason: collision with root package name */
    final a0 f15760a = a0.d();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ImageDecoder.OnHeaderDecodedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f15761a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f15762b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f15763c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DecodeFormat f15764d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ DownsampleStrategy f15765e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PreferredColorSpace f15766f;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bumptech.glide.load.resource.k$a$a, reason: collision with other inner class name */
        class C0166a implements ImageDecoder.OnPartialImageListener {
            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }

            C0166a() {
            }
        }

        a(int i6, int i7, boolean z5, DecodeFormat decodeFormat, DownsampleStrategy downsampleStrategy, PreferredColorSpace preferredColorSpace) {
            this.f15761a = i6;
            this.f15762b = i7;
            this.f15763c = z5;
            this.f15764d = decodeFormat;
            this.f15765e = downsampleStrategy;
            this.f15766f = preferredColorSpace;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            Size size;
            ColorSpace.Named named;
            ColorSpace colorSpace;
            ColorSpace.Named named2;
            ColorSpace colorSpace2;
            ColorSpace colorSpace3;
            ColorSpace colorSpace4;
            boolean isWideGamut;
            if (k.this.f15760a.g(this.f15761a, this.f15762b, this.f15763c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f15764d == DecodeFormat.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0166a());
            size = imageInfo.getSize();
            int i6 = this.f15761a;
            if (i6 == Integer.MIN_VALUE) {
                i6 = size.getWidth();
            }
            int i7 = this.f15762b;
            if (i7 == Integer.MIN_VALUE) {
                i7 = size.getHeight();
            }
            float b6 = this.f15765e.b(size.getWidth(), size.getHeight(), i6, i7);
            int round = Math.round(size.getWidth() * b6);
            int round2 = Math.round(b6 * size.getHeight());
            if (Log.isLoggable(k.f15759b, 2)) {
                size.getWidth();
                size.getHeight();
            }
            imageDecoder.setTargetSize(round, round2);
            int i8 = Build.VERSION.SDK_INT;
            if (i8 < 28) {
                if (i8 >= 26) {
                    named = ColorSpace.Named.SRGB;
                    colorSpace = ColorSpace.get(named);
                    imageDecoder.setTargetColorSpace(colorSpace);
                    return;
                }
                return;
            }
            if (this.f15766f == PreferredColorSpace.DISPLAY_P3) {
                colorSpace3 = imageInfo.getColorSpace();
                if (colorSpace3 != null) {
                    colorSpace4 = imageInfo.getColorSpace();
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        named2 = ColorSpace.Named.DISPLAY_P3;
                        colorSpace2 = ColorSpace.get(named2);
                        imageDecoder.setTargetColorSpace(colorSpace2);
                    }
                }
            }
            named2 = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named2);
            imageDecoder.setTargetColorSpace(colorSpace2);
        }
    }

    protected abstract u<T> c(ImageDecoder.Source source, int i6, int i7, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    public final boolean e(@NonNull ImageDecoder.Source source, @NonNull com.bumptech.glide.load.f fVar) {
        return true;
    }

    @Nullable
    public final u<T> d(@NonNull ImageDecoder.Source source, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        DecodeFormat decodeFormat = (DecodeFormat) fVar.c(com.bumptech.glide.load.resource.bitmap.u.f15660g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) fVar.c(DownsampleStrategy.f15561h);
        com.bumptech.glide.load.e<Boolean> eVar = com.bumptech.glide.load.resource.bitmap.u.f15664k;
        return c(source, i6, i7, new a(i6, i7, fVar.c(eVar) != null && ((Boolean) fVar.c(eVar)).booleanValue(), decodeFormat, downsampleStrategy, (PreferredColorSpace) fVar.c(com.bumptech.glide.load.resource.bitmap.u.f15661h)));
    }

    @Override // com.bumptech.glide.load.g
    public /* bridge */ /* synthetic */ boolean a(@NonNull ImageDecoder.Source source, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return e(com.bumptech.glide.load.resource.a.a(source), fVar);
    }

    @Override // com.bumptech.glide.load.g
    @Nullable
    public /* bridge */ /* synthetic */ u b(@NonNull ImageDecoder.Source source, int i6, int i7, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return d(com.bumptech.glide.load.resource.a.a(source), i6, i7, fVar);
    }
}
