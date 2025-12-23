package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class l {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b extends l {

        /* renamed from: a, reason: collision with root package name */
        private final AssetFileDescriptor f51842a;

        public b(@NonNull AssetFileDescriptor assetFileDescriptor) {
            super(null);
            this.f51842a = assetFileDescriptor;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f51842a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends l {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f51843a;

        /* renamed from: b, reason: collision with root package name */
        private final String f51844b;

        public c(@NonNull AssetManager assetManager, @NonNull String str) {
            super(null);
            this.f51843a = assetManager;
            this.f51844b = str;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f51843a.openFd(this.f51844b));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d extends l {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f51845a;

        public d(@NonNull byte[] bArr) {
            super(null);
            this.f51845a = bArr;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws GifIOException {
            return new GifInfoHandle(this.f51845a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e extends l {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f51846a;

        public e(@NonNull ByteBuffer byteBuffer) {
            super(null);
            this.f51846a = byteBuffer;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws GifIOException {
            return new GifInfoHandle(this.f51846a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f extends l {

        /* renamed from: a, reason: collision with root package name */
        private final FileDescriptor f51847a;

        public f(@NonNull FileDescriptor fileDescriptor) {
            super(null);
            this.f51847a = fileDescriptor;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f51847a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g extends l {

        /* renamed from: a, reason: collision with root package name */
        private final String f51848a;

        public g(@NonNull File file) {
            super(null);
            this.f51848a = file.getPath();
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws GifIOException {
            return new GifInfoHandle(this.f51848a);
        }

        public g(@NonNull String str) {
            super(null);
            this.f51848a = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h extends l {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f51849a;

        public h(@NonNull InputStream inputStream) {
            super(null);
            this.f51849a = inputStream;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f51849a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class i extends l {

        /* renamed from: a, reason: collision with root package name */
        private final Resources f51850a;

        /* renamed from: b, reason: collision with root package name */
        private final int f51851b;

        public i(@NonNull Resources resources, @DrawableRes @RawRes int i6) {
            super(null);
            this.f51850a = resources;
            this.f51851b = i6;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return new GifInfoHandle(this.f51850a.openRawResourceFd(this.f51851b));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class j extends l {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f51852a;

        /* renamed from: b, reason: collision with root package name */
        private final Uri f51853b;

        public j(@Nullable ContentResolver contentResolver, @NonNull Uri uri) {
            super(null);
            this.f51852a = contentResolver;
            this.f51853b = uri;
        }

        @Override // pl.droidsonroids.gif.l
        GifInfoHandle c() throws IOException {
            return GifInfoHandle.y(this.f51852a, this.f51853b);
        }
    }

    /* synthetic */ l(a aVar) {
        this();
    }

    abstract GifInfoHandle c() throws IOException;

    private l() {
    }

    final pl.droidsonroids.gif.e a(pl.droidsonroids.gif.e eVar, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z5, pl.droidsonroids.gif.h hVar) throws IOException {
        return new pl.droidsonroids.gif.e(b(hVar), eVar, scheduledThreadPoolExecutor, z5);
    }

    final GifInfoHandle b(@NonNull pl.droidsonroids.gif.h hVar) throws IOException {
        GifInfoHandle c6 = c();
        c6.K(hVar.f51832a, hVar.f51833b);
        return c6;
    }
}
