package pl.droidsonroids.gif;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import pl.droidsonroids.gif.annotations.Beta;
import pl.droidsonroids.gif.g;
import pl.droidsonroids.gif.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class g<T extends g<T>> {

    /* renamed from: a, reason: collision with root package name */
    private l f51827a;

    /* renamed from: b, reason: collision with root package name */
    private e f51828b;

    /* renamed from: c, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f51829c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f51830d = true;

    /* renamed from: e, reason: collision with root package name */
    private final h f51831e = new h();

    protected abstract T t();

    public e a() throws IOException {
        l lVar = this.f51827a;
        if (lVar != null) {
            return lVar.a(this.f51828b, this.f51829c, this.f51830d, this.f51831e);
        }
        throw new NullPointerException("Source is not set");
    }

    public T b(ContentResolver contentResolver, Uri uri) {
        this.f51827a = new l.j(contentResolver, uri);
        return t();
    }

    public T c(AssetFileDescriptor assetFileDescriptor) {
        this.f51827a = new l.b(assetFileDescriptor);
        return t();
    }

    public T d(AssetManager assetManager, String str) {
        this.f51827a = new l.c(assetManager, str);
        return t();
    }

    public T e(Resources resources, int i6) {
        this.f51827a = new l.i(resources, i6);
        return t();
    }

    public T f(File file) {
        this.f51827a = new l.g(file);
        return t();
    }

    public T g(FileDescriptor fileDescriptor) {
        this.f51827a = new l.f(fileDescriptor);
        return t();
    }

    public T h(InputStream inputStream) {
        this.f51827a = new l.h(inputStream);
        return t();
    }

    public T i(String str) {
        this.f51827a = new l.g(str);
        return t();
    }

    public T j(ByteBuffer byteBuffer) {
        this.f51827a = new l.e(byteBuffer);
        return t();
    }

    public T k(byte[] bArr) {
        this.f51827a = new l.d(bArr);
        return t();
    }

    public ScheduledThreadPoolExecutor l() {
        return this.f51829c;
    }

    public l m() {
        return this.f51827a;
    }

    public e n() {
        return this.f51828b;
    }

    public h o() {
        return this.f51831e;
    }

    public boolean p() {
        return this.f51830d;
    }

    @Beta
    public T q(@Nullable h hVar) {
        this.f51831e.b(hVar);
        return t();
    }

    public T r(boolean z5) {
        this.f51830d = z5;
        return t();
    }

    public T s(@IntRange(from = 1, to = 65535) int i6) {
        this.f51831e.d(i6);
        return t();
    }

    public T v(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f51829c = scheduledThreadPoolExecutor;
        return t();
    }

    public T w(int i6) {
        this.f51829c = new ScheduledThreadPoolExecutor(i6);
        return t();
    }

    public T x(e eVar) {
        this.f51828b = eVar;
        return t();
    }

    public T u(boolean z5) {
        return r(z5);
    }
}
