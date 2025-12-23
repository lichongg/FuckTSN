package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.f0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int f14909a = 5242880;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f14910a;

        a(InputStream inputStream) {
            this.f14910a = inputStream;
        }

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getType(this.f14910a);
            } finally {
                this.f14910a.reset();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.load.b$b, reason: collision with other inner class name */
    class C0150b implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBuffer f14911a;

        C0150b(ByteBuffer byteBuffer) {
            this.f14911a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.getType(this.f14911a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptorRewinder f14912a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.b f14913b;

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            f0 f0Var;
            f0 f0Var2 = null;
            try {
                f0Var = new f0(new FileInputStream(this.f14912a.a().getFileDescriptor()), this.f14913b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageHeaderParser.ImageType type = imageHeaderParser.getType(f0Var);
                try {
                    f0Var.close();
                } catch (IOException unused) {
                }
                this.f14912a.a();
                return type;
            } catch (Throwable th2) {
                th = th2;
                f0Var2 = f0Var;
                if (f0Var2 != null) {
                    try {
                        f0Var2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f14912a.a();
                throw th;
            }
        }

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f14912a = parcelFileDescriptorRewinder;
            this.f14913b = bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f14914a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.b f14915b;

        d(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f14914a = inputStream;
            this.f14915b = bVar;
        }

        @Override // com.bumptech.glide.load.b.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.b(this.f14914a, this.f14915b);
            } finally {
                this.f14914a.reset();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptorRewinder f14916a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.b f14917b;

        @Override // com.bumptech.glide.load.b.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            f0 f0Var;
            f0 f0Var2 = null;
            try {
                f0Var = new f0(new FileInputStream(this.f14916a.a().getFileDescriptor()), this.f14917b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int b6 = imageHeaderParser.b(f0Var, this.f14917b);
                try {
                    f0Var.close();
                } catch (IOException unused) {
                }
                this.f14916a.a();
                return b6;
            } catch (Throwable th2) {
                th = th2;
                f0Var2 = f0Var;
                if (f0Var2 != null) {
                    try {
                        f0Var2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f14916a.a();
                throw th;
            }
        }

        e(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f14916a = parcelFileDescriptorRewinder;
            this.f14917b = bVar;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface f {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface g {
        ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new f0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return d(list, new a(inputStream));
    }

    @RequiresApi(21)
    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return c(list, new e(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new f0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return c(list, new d(inputStream, bVar));
    }

    private b() {
    }

    private static int c(@NonNull List<ImageHeaderParser> list, f fVar) throws IOException {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            int a6 = fVar.a(list.get(i6));
            if (a6 != -1) {
                return a6;
            }
        }
        return -1;
    }

    @NonNull
    private static ImageHeaderParser.ImageType d(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            ImageHeaderParser.ImageType type = gVar.getType(list.get(i6));
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return d(list, new C0150b(byteBuffer));
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return d(list, new c(parcelFileDescriptorRewinder, bVar));
    }
}
