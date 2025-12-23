package cn.bluemobi.dylan.photoview.library;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a, reason: collision with root package name */
    private d f1305a;

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public void a(d dVar) {
        this.f1305a = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        d dVar = this.f1305a;
        if (dVar == null) {
            return false;
        }
        try {
            float scale = dVar.getScale();
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            if (scale < this.f1305a.getMediumScale()) {
                d dVar2 = this.f1305a;
                dVar2.a(dVar2.getMediumScale(), x5, y5, true);
            } else if (scale < this.f1305a.getMediumScale() || scale >= this.f1305a.getMaximumScale()) {
                d dVar3 = this.f1305a;
                dVar3.a(dVar3.getMinimumScale(), x5, y5, true);
            } else {
                d dVar4 = this.f1305a;
                dVar4.a(dVar4.getMaximumScale(), x5, y5, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        d dVar = this.f1305a;
        if (dVar == null) {
            return false;
        }
        ImageView u5 = dVar.u();
        if (this.f1305a.getOnPhotoTapListener() != null && (displayRect = this.f1305a.getDisplayRect()) != null) {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            if (displayRect.contains(x5, y5)) {
                this.f1305a.getOnPhotoTapListener().a(u5, (x5 - displayRect.left) / displayRect.width(), (y5 - displayRect.top) / displayRect.height());
                return true;
            }
        }
        if (this.f1305a.getOnViewTapListener() != null) {
            this.f1305a.getOnViewTapListener().a(u5, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    public b(d dVar) {
        a(dVar);
    }
}
