package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import master.flame.danmaku.danmaku.model.android.a;
import master.flame.danmaku.danmaku.model.android.k.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class k<VH extends a> extends b {

    /* renamed from: e, reason: collision with root package name */
    public static final int f50044e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f50045f = -2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f50046g = -3;

    /* renamed from: h, reason: collision with root package name */
    public static final int f50047h = -3;

    /* renamed from: d, reason: collision with root package name */
    private SparseArray<List<VH>> f50050d = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final int f50048b = -1;

    /* renamed from: c, reason: collision with root package name */
    private final int f50049c = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        protected final View f50051a;

        public void a(Canvas canvas, a.C0971a c0971a) {
            this.f50051a.draw(canvas);
        }

        public int b() {
            return this.f50051a.getMeasuredHeight();
        }

        public int c() {
            return this.f50051a.getMeasuredWidth();
        }

        public void d(int i6, int i7, int i8, int i9) {
            this.f50051a.layout(i6, i7, i8, i9);
        }

        public void e(int i6, int i7) {
            this.f50051a.measure(i6, i7);
        }

        public a(View view) {
            if (view != null) {
                this.f50051a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }
    }

    public int i(int i6, master.flame.danmaku.danmaku.model.d dVar) {
        return 0;
    }

    public abstract void j(int i6, VH vh, master.flame.danmaku.danmaku.model.d dVar, a.C0971a c0971a, TextPaint textPaint);

    public abstract VH k(int i6);

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void d(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f6, float f7, boolean z5, a.C0971a c0971a) {
        VH vh;
        int i6 = i(dVar.f50072s, dVar);
        List<VH> list = this.f50050d.get(i6);
        boolean z6 = true;
        if (list != null) {
            vh = list.get(z5 ? 1 : 2);
        } else {
            vh = null;
        }
        if (vh == null) {
            return;
        }
        c0971a.j(z5);
        TextPaint l6 = c0971a.l(dVar, z5);
        c0971a.g(dVar, l6, false);
        j(i6, vh, dVar, c0971a, l6);
        vh.e(View.MeasureSpec.makeMeasureSpec(Math.round(dVar.f50069p), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(dVar.f50070q), 1073741824));
        if (z5) {
            z6 = false;
        } else {
            canvas.save();
            canvas.translate(f6, f7);
        }
        if (dVar.f50064k != 0) {
            Paint n6 = c0971a.n(dVar);
            float f8 = (f7 + dVar.f50070q) - c0971a.f49963h;
            canvas.drawLine(f6, f8, f6 + dVar.f50069p, f8, n6);
        }
        if (dVar.f50066m != 0) {
            canvas.drawRect(f6, f7, f6 + dVar.f50069p, f7 + dVar.f50070q, c0971a.k(dVar));
        }
        vh.d(0, 0, (int) dVar.f50069p, (int) dVar.f50070q);
        vh.a(canvas, c0971a);
        if (z6) {
            canvas.restore();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // master.flame.danmaku.danmaku.model.android.b
    public void e(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z5) {
        int i6 = i(dVar.f50072s, dVar);
        List list = this.f50050d.get(i6);
        if (list == null) {
            list = new ArrayList();
            list.add(k(i6));
            list.add(k(i6));
            list.add(k(i6));
            this.f50050d.put(i6, list);
        }
        a aVar = (a) list.get(0);
        j(i6, aVar, dVar, null, textPaint);
        aVar.e(View.MeasureSpec.makeMeasureSpec(this.f50048b, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f50049c, Integer.MIN_VALUE));
        aVar.d(0, 0, aVar.c(), aVar.b());
        dVar.f50069p = aVar.c();
        dVar.f50070q = aVar.b();
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void g(master.flame.danmaku.danmaku.model.d dVar) {
        super.g(dVar);
        dVar.f50059f = null;
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void b() {
    }
}
