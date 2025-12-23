package pl.droidsonroids.gif;

import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final GifInfoHandle f51802a;

    public d(@NonNull l lVar) throws IOException {
        this(lVar, null);
    }

    public d(@NonNull l lVar, @Nullable h hVar) throws IOException {
        GifInfoHandle c6 = lVar.c();
        this.f51802a = c6;
        if (hVar != null) {
            c6.K(hVar.f51832a, hVar.f51833b);
        }
    }

    public long b() {
        return this.f51802a.b();
    }

    public String c() {
        return this.f51802a.c();
    }

    public int d() {
        return this.f51802a.g();
    }

    public int e(@IntRange(from = 0) int i6) {
        return this.f51802a.h(i6);
    }

    public int f() {
        return this.f51802a.i();
    }

    public int g() {
        return this.f51802a.j();
    }

    public int h() {
        return this.f51802a.n();
    }

    public long i() {
        return this.f51802a.p();
    }

    public int j() {
        return this.f51802a.q();
    }

    public boolean k() {
        return this.f51802a.n() > 1 && d() > 0;
    }

    public void l() {
        this.f51802a.A();
    }

    private void a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (bitmap.getWidth() >= this.f51802a.q() && bitmap.getHeight() >= this.f51802a.i()) {
                if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                    return;
                }
                throw new IllegalArgumentException("Only Config.ARGB_8888 is supported. Current bitmap config: " + bitmap.getConfig());
            }
            throw new IllegalArgumentException("Bitmap ia too small, size must be greater than or equal to GIF size");
        }
        throw new IllegalArgumentException("Bitmap is recycled");
    }

    public void m(@IntRange(from = 0, to = 2147483647L) int i6, @NonNull Bitmap bitmap) {
        a(bitmap);
        this.f51802a.G(i6, bitmap);
    }

    public void n(@IntRange(from = 0, to = 2147483647L) int i6, @NonNull Bitmap bitmap) {
        a(bitmap);
        this.f51802a.I(i6, bitmap);
    }
}
