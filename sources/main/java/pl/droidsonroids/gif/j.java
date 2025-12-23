package pl.droidsonroids.gif;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final GifInfoHandle f51835a;

    public int a() {
        return this.f51835a.d();
    }

    public int b() {
        return this.f51835a.g();
    }

    public int c(@IntRange(from = 0) int i6) {
        return this.f51835a.h(i6);
    }

    public int d() {
        return this.f51835a.i();
    }

    public int e() {
        return this.f51835a.n();
    }

    public int f() {
        return this.f51835a.q();
    }

    public void g(int i6, int i7) {
        this.f51835a.r(i6, i7);
    }

    public void h(int i6, int i7) {
        this.f51835a.s(i6, i7);
    }

    public void i() {
        GifInfoHandle gifInfoHandle = this.f51835a;
        if (gifInfoHandle != null) {
            gifInfoHandle.A();
        }
    }

    public void j(@IntRange(from = 0) int i6) {
        this.f51835a.H(i6);
    }

    public void k(@FloatRange(from = 0.0d, fromInclusive = false) float f6) {
        this.f51835a.L(f6);
    }

    public void l() {
        this.f51835a.M();
    }

    public void m() {
        this.f51835a.N();
    }

    public j(l lVar, @Nullable h hVar) throws IOException {
        hVar = hVar == null ? new h() : hVar;
        GifInfoHandle c6 = lVar.c();
        this.f51835a = c6;
        c6.K(hVar.f51832a, hVar.f51833b);
        c6.t();
    }

    protected final void finalize() throws Throwable {
        try {
            i();
        } finally {
            super.finalize();
        }
    }
}
