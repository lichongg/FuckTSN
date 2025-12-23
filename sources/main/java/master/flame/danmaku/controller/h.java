package master.flame.danmaku.controller;

import master.flame.danmaku.danmaku.model.m;
import v4.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface h {

    /* renamed from: a, reason: collision with root package name */
    public static final int f49910a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f49911b = 2;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(master.flame.danmaku.danmaku.model.d dVar);

        void b(master.flame.danmaku.danmaku.model.d dVar);

        void c();

        void d();

        void e();
    }

    void a(master.flame.danmaku.danmaku.model.d dVar);

    void b(master.flame.danmaku.danmaku.model.d dVar, boolean z5);

    void c(boolean z5);

    m d(long j6);

    void e();

    void f(master.flame.danmaku.danmaku.parser.a aVar);

    void g(long j6);

    void h(long j6, long j7, long j8);

    void i();

    void j();

    void k();

    a.c l(master.flame.danmaku.danmaku.model.b bVar);

    void m();

    void onPlayStateChanged(int i6);

    void prepare();

    void reset();

    void seek(long j6);

    void start();
}
