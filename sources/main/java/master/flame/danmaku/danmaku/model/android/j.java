package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.lang.ref.SoftReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class j extends i {
    @Override // master.flame.danmaku.danmaku.model.android.i, master.flame.danmaku.danmaku.model.android.b
    public void e(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z5) {
        CharSequence charSequence = dVar.f50056c;
        if (!(charSequence instanceof Spanned) || charSequence == null) {
            super.e(dVar, textPaint, z5);
            return;
        }
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(dVar.f50056c, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        dVar.f50069p = staticLayout.getWidth();
        dVar.f50070q = staticLayout.getHeight();
        dVar.f50058e = new SoftReference(staticLayout);
    }

    @Override // master.flame.danmaku.danmaku.model.android.i
    public void j(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f6, float f7, Paint paint) {
        if (dVar.f50058e == null) {
            super.j(dVar, str, canvas, f6, f7, paint);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.i
    public void k(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f6, float f7, TextPaint textPaint, boolean z5) {
        StaticLayout staticLayout;
        Object obj = dVar.f50058e;
        if (obj == null) {
            super.k(dVar, str, canvas, f6, f7, textPaint, z5);
            return;
        }
        StaticLayout staticLayout2 = (StaticLayout) ((SoftReference) obj).get();
        int i6 = dVar.J;
        boolean z6 = false;
        boolean z7 = (i6 & 1) != 0;
        boolean z8 = (i6 & 2) != 0;
        if (z8 || staticLayout2 == null) {
            if (z8) {
                dVar.J = i6 & (-3);
            }
            CharSequence charSequence = dVar.f50056c;
            if (charSequence == null) {
                return;
            }
            if (z7) {
                staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(dVar.f50056c, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                dVar.f50069p = staticLayout.getWidth();
                dVar.f50070q = staticLayout.getHeight();
                dVar.J &= -2;
            } else {
                staticLayout = new StaticLayout(charSequence, textPaint, (int) dVar.f50069p, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            staticLayout2 = staticLayout;
            dVar.f50058e = new SoftReference(staticLayout2);
        }
        if (f6 != 0.0f && f7 != 0.0f) {
            canvas.save();
            canvas.translate(f6, f7 + textPaint.ascent());
            z6 = true;
        }
        staticLayout2.draw(canvas);
        if (z6) {
            canvas.restore();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void a(master.flame.danmaku.danmaku.model.d dVar) {
        super.a(dVar);
        Object obj = dVar.f50058e;
        if (obj instanceof SoftReference) {
            ((SoftReference) obj).clear();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.i, master.flame.danmaku.danmaku.model.android.b
    public void b() {
        super.b();
        System.gc();
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void g(master.flame.danmaku.danmaku.model.d dVar) {
        a(dVar);
        super.g(dVar);
    }
}
