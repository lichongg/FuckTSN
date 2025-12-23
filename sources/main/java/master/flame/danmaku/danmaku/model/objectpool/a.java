package master.flame.danmaku.danmaku.model.objectpool;

import java.io.PrintStream;
import master.flame.danmaku.danmaku.model.objectpool.c;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
class a<T extends c<T>> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final d<T> f50107a;

    /* renamed from: b, reason: collision with root package name */
    private final int f50108b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f50109c;

    /* renamed from: d, reason: collision with root package name */
    private T f50110d;

    /* renamed from: e, reason: collision with root package name */
    private int f50111e;

    a(d<T> dVar) {
        this.f50107a = dVar;
        this.f50108b = 0;
        this.f50109c = true;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.b
    public T acquire() {
        T t5 = this.f50110d;
        if (t5 != null) {
            this.f50110d = (T) t5.b();
            this.f50111e--;
        } else {
            t5 = this.f50107a.b();
        }
        if (t5 != null) {
            t5.g(null);
            t5.h(false);
            this.f50107a.c(t5);
        }
        return t5;
    }

    @Override // master.flame.danmaku.danmaku.model.objectpool.b
    public void a(T t5) {
        if (!t5.i()) {
            if (this.f50109c || this.f50111e < this.f50108b) {
                this.f50111e++;
                t5.g(this.f50110d);
                t5.h(true);
                this.f50110d = t5;
            }
            this.f50107a.a(t5);
            return;
        }
        PrintStream printStream = System.out;
        t5.toString();
        printStream.getClass();
    }

    a(d<T> dVar, int i6) {
        if (i6 > 0) {
            this.f50107a = dVar;
            this.f50108b = i6;
            this.f50109c = false;
            return;
        }
        throw new IllegalArgumentException("The pool limit must be > 0");
    }
}
