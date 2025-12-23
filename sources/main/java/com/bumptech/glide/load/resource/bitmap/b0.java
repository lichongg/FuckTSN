package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
interface b0 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.data.k f15585a;

        /* renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.bitmap_recycle.b f15586b;

        /* renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f15587c;

        @Override // com.bumptech.glide.load.resource.bitmap.b0
        public void a() {
            this.f15585a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b0
        public int b() throws IOException {
            return com.bumptech.glide.load.b.b(this.f15587c, this.f15585a.a(), this.f15586b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b0
        @Nullable
        public Bitmap c(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f15585a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b0
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.b.getType(this.f15587c, this.f15585a.a(), this.f15586b);
        }

        a(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f15586b = (com.bumptech.glide.load.engine.bitmap_recycle.b) com.bumptech.glide.util.k.d(bVar);
            this.f15587c = (List) com.bumptech.glide.util.k.d(list);
            this.f15585a = new com.bumptech.glide.load.data.k(inputStream, bVar);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    public static final class b implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.bitmap_recycle.b f15588a;

        /* renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f15589b;

        /* renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f15590c;

        @Override // com.bumptech.glide.load.resource.bitmap.b0
        public int b() throws IOException {
            return com.bumptech.glide.load.b.a(this.f15589b, this.f15590c, this.f15588a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b0
        @Nullable
        public Bitmap c(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f15590c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b0
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.b.getType(this.f15589b, this.f15590c, this.f15588a);
        }

        b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f15588a = (com.bumptech.glide.load.engine.bitmap_recycle.b) com.bumptech.glide.util.k.d(bVar);
            this.f15589b = (List) com.bumptech.glide.util.k.d(list);
            this.f15590c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.b0
        public void a() {
        }
    }

    void a();

    int b() throws IOException;

    @Nullable
    Bitmap c(BitmapFactory.Options options) throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
