package master.flame.danmaku.ui.widget;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import master.flame.danmaku.controller.f;
import master.flame.danmaku.danmaku.model.android.e;
import master.flame.danmaku.danmaku.model.d;
import master.flame.danmaku.danmaku.model.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final GestureDetector f50266a;

    /* renamed from: b, reason: collision with root package name */
    private f f50267b;

    /* renamed from: c, reason: collision with root package name */
    private RectF f50268c;

    /* renamed from: d, reason: collision with root package name */
    private float f50269d;

    /* renamed from: e, reason: collision with root package name */
    private float f50270e;

    /* renamed from: f, reason: collision with root package name */
    private final GestureDetector.OnGestureListener f50271f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: master.flame.danmaku.ui.widget.a$a, reason: collision with other inner class name */
    class C0975a extends GestureDetector.SimpleOnGestureListener {
        C0975a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (a.this.f50267b == null || a.this.f50267b.getOnDanmakuClickListener() == null) {
                return false;
            }
            a aVar = a.this;
            aVar.f50269d = aVar.f50267b.getXOff();
            a aVar2 = a.this;
            aVar2.f50270e = aVar2.f50267b.getYOff();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (a.this.f50267b.getOnDanmakuClickListener() == null) {
                return;
            }
            a aVar = a.this;
            aVar.f50269d = aVar.f50267b.getXOff();
            a aVar2 = a.this;
            aVar2.f50270e = aVar2.f50267b.getYOff();
            m n6 = a.this.n(motionEvent.getX(), motionEvent.getY());
            if (n6 == null || n6.isEmpty()) {
                return;
            }
            a.this.l(n6, true);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            m n6 = a.this.n(motionEvent.getX(), motionEvent.getY());
            boolean z5 = false;
            if (n6 != null && !n6.isEmpty()) {
                z5 = a.this.l(n6, false);
            }
            return !z5 ? a.this.m() : z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends m.c<d> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f50273e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f50274f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ m f50275g;

        b(float f6, float f7, m mVar) {
            this.f50273e = f6;
            this.f50274f = f7;
            this.f50275g = mVar;
        }

        @Override // master.flame.danmaku.danmaku.model.m.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public int a(d dVar) {
            if (dVar == null) {
                return 0;
            }
            a.this.f50268c.set(dVar.g(), dVar.l(), dVar.i(), dVar.d());
            if (!a.this.f50268c.intersect(this.f50273e - a.this.f50269d, this.f50274f - a.this.f50270e, this.f50273e + a.this.f50269d, this.f50274f + a.this.f50270e)) {
                return 0;
            }
            this.f50275g.j(dVar);
            return 0;
        }
    }

    public static synchronized a j(f fVar) {
        a aVar;
        synchronized (a.class) {
            aVar = new a(fVar);
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(m mVar, boolean z5) {
        f.a onDanmakuClickListener = this.f50267b.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return z5 ? onDanmakuClickListener.c(mVar) : onDanmakuClickListener.a(mVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        f.a onDanmakuClickListener = this.f50267b.getOnDanmakuClickListener();
        if (onDanmakuClickListener != null) {
            return onDanmakuClickListener.b(this.f50267b);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m n(float f6, float f7) {
        e eVar = new e();
        this.f50268c.setEmpty();
        m currentVisibleDanmakus = this.f50267b.getCurrentVisibleDanmakus();
        if (currentVisibleDanmakus != null && !currentVisibleDanmakus.isEmpty()) {
            currentVisibleDanmakus.a(new b(f6, f7, eVar));
        }
        return eVar;
    }

    public boolean k(MotionEvent motionEvent) {
        return this.f50266a.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private a(f fVar) {
        C0975a c0975a = new C0975a();
        this.f50271f = c0975a;
        this.f50267b = fVar;
        this.f50268c = new RectF();
        this.f50266a = new GestureDetector(((View) fVar).getContext(), c0975a);
    }
}
