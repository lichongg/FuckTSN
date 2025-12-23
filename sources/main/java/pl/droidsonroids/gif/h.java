package pl.droidsonroids.gif;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    char f51832a;

    /* renamed from: b, reason: collision with root package name */
    boolean f51833b;

    private void a() {
        this.f51832a = (char) 1;
        this.f51833b = false;
    }

    public void d(@IntRange(from = 1, to = 65535) int i6) {
        if (i6 < 1 || i6 > 65535) {
            this.f51832a = (char) 1;
        } else {
            this.f51832a = (char) i6;
        }
    }

    void b(@Nullable h hVar) {
        if (hVar == null) {
            a();
        } else {
            this.f51833b = hVar.f51833b;
            this.f51832a = hVar.f51832a;
        }
    }

    public void c(boolean z5) {
        this.f51833b = z5;
    }

    public h() {
        a();
    }
}
