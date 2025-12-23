package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.util.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class GestureCropImageView extends CropImageView {
    private static final int S = 200;
    private ScaleGestureDetector K;
    private h L;
    private GestureDetector M;
    private float N;
    private float O;
    private boolean P;
    private boolean Q;
    private int R;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        /* synthetic */ b(GestureCropImageView gestureCropImageView, a aVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.A(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
            GestureCropImageView.this.k(-f6, -f7);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends h.b {
        private c() {
        }

        /* synthetic */ c(GestureCropImageView gestureCropImageView, a aVar) {
            this();
        }

        @Override // com.yalantis.ucrop.util.h.b, com.yalantis.ucrop.util.h.a
        public boolean a(h hVar) {
            GestureCropImageView.this.i(hVar.c(), GestureCropImageView.this.N, GestureCropImageView.this.O);
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private d() {
        }

        /* synthetic */ d(GestureCropImageView gestureCropImageView, a aVar) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.j(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.N, GestureCropImageView.this.O);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.P = true;
        this.Q = true;
        this.R = 5;
    }

    private void J() {
        a aVar = null;
        this.M = new GestureDetector(getContext(), new b(this, aVar), null, true);
        this.K = new ScaleGestureDetector(getContext(), new d(this, aVar));
        this.L = new h(new c(this, aVar));
    }

    public boolean H() {
        return this.P;
    }

    public boolean I() {
        return this.Q;
    }

    public int getDoubleTapScaleSteps() {
        return this.R;
    }

    public void setDoubleTapScaleSteps(int i6) {
        this.R = i6;
    }

    public void setRotateEnabled(boolean z5) {
        this.P = z5;
    }

    public void setScaleEnabled(boolean z5) {
        this.Q = z5;
    }

    @Override // com.yalantis.ucrop.view.TransformImageView
    protected void g() {
        super.g();
        J();
    }

    protected float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.R));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            s();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.N = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.O = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        this.M.onTouchEvent(motionEvent);
        if (this.Q) {
            this.K.onTouchEvent(motionEvent);
        }
        if (this.P) {
            this.L.d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            y();
        }
        return true;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.P = true;
        this.Q = true;
        this.R = 5;
    }
}
