package cn.bluemobi.dylan.photoview.library.gestures;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@TargetApi(8)
/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends b {

    /* renamed from: l, reason: collision with root package name */
    protected final ScaleGestureDetector f1359l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                c.this.f1349a.f(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.a, cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean c() {
        return this.f1359l.isInProgress();
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.b, cn.bluemobi.dylan.photoview.library.gestures.a, cn.bluemobi.dylan.photoview.library.gestures.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1359l.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public c(Context context) {
        super(context);
        this.f1359l = new ScaleGestureDetector(context, new a());
    }
}
