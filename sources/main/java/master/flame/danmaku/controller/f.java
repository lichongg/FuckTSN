package master.flame.danmaku.controller;

import android.view.View;
import master.flame.danmaku.controller.c;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface f {
    public static final int A0 = 0;
    public static final int B0 = 1;
    public static final int C0 = 2;
    public static final int D0 = 3;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        boolean a(m mVar);

        boolean b(f fVar);

        boolean c(m mVar);
    }

    void a(master.flame.danmaku.danmaku.model.d dVar);

    void b(master.flame.danmaku.danmaku.model.d dVar, boolean z5);

    void c(boolean z5);

    boolean d();

    void e();

    void f(boolean z5);

    void g(master.flame.danmaku.danmaku.parser.a aVar, DanmakuContext danmakuContext);

    DanmakuContext getConfig();

    long getCurrentTime();

    m getCurrentVisibleDanmakus();

    int getHeight();

    a getOnDanmakuClickListener();

    View getView();

    int getWidth();

    float getXOff();

    float getYOff();

    long h();

    void hide();

    boolean isHardwareAccelerated();

    boolean isPaused();

    boolean isPrepared();

    boolean isShown();

    void j(Long l6);

    void k();

    void m(Long l6);

    void n(a aVar, float f6, float f7);

    void o(boolean z5);

    void pause();

    void release();

    void resume();

    void setCallback(c.d dVar);

    void setDrawingThreadType(int i6);

    void setOnDanmakuClickListener(a aVar);

    void setVisibility(int i6);

    void show();

    void start();

    void start(long j6);

    void stop();

    void toggle();
}
