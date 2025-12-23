package junit.extensions;

import junit.framework.f;
import junit.framework.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b extends c {

    /* renamed from: b, reason: collision with root package name */
    private int f43464b;

    @Override // junit.extensions.c, junit.framework.f
    public void a(j jVar) {
        for (int i6 = 0; i6 < this.f43464b && !jVar.n(); i6++) {
            super.a(jVar);
        }
    }

    @Override // junit.extensions.c
    public String toString() {
        return super.toString() + "(repeated)";
    }

    public b(f fVar, int i6) {
        super(fVar);
        if (i6 >= 0) {
            this.f43464b = i6;
            return;
        }
        throw new IllegalArgumentException("Repetition count must be >= 0");
    }

    @Override // junit.extensions.c, junit.framework.f
    public int c() {
        return super.c() * this.f43464b;
    }
}
