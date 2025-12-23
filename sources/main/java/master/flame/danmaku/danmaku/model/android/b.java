package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import master.flame.danmaku.danmaku.model.android.a;
import master.flame.danmaku.danmaku.model.o;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected a f49982a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a {
        public abstract void a(master.flame.danmaku.danmaku.model.d dVar, boolean z5);

        public abstract void b(master.flame.danmaku.danmaku.model.d dVar);
    }

    public abstract void b();

    public abstract void d(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f6, float f7, boolean z5, a.C0971a c0971a);

    public abstract void e(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z5);

    public void f(master.flame.danmaku.danmaku.model.d dVar, boolean z5) {
        a aVar = this.f49982a;
        if (aVar != null) {
            aVar.a(dVar, z5);
        }
    }

    public void g(master.flame.danmaku.danmaku.model.d dVar) {
        a aVar = this.f49982a;
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public void h(a aVar) {
        this.f49982a = aVar;
    }

    public boolean c(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f6, float f7, Paint paint, TextPaint textPaint) {
        g gVar;
        o<?> e6 = dVar.e();
        if (e6 != null && (gVar = (g) e6.get()) != null) {
            return gVar.b(canvas, f6, f7, paint);
        }
        return false;
    }

    public void a(master.flame.danmaku.danmaku.model.d dVar) {
    }
}
