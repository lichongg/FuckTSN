package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsSplashSlidePathView extends ImageView {
    private Path Li;
    private Paint Lj;
    private float Lk;
    private float Ll;
    private float Lm;
    private float Ln;
    private int Lo;
    private a Lp;
    private GestureDetector Lq;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(float f6, float f7, float f8, float f9);

        void c(MotionEvent motionEvent);
    }

    public KsSplashSlidePathView(Context context) {
        super(context);
        this.Lo = Color.parseColor("#66ffffff");
        init();
    }

    private void b(float f6, float f7) {
        float abs = Math.abs(f6 - this.Lm);
        float abs2 = Math.abs(f7 - this.Ln);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            Path path = this.Li;
            float f8 = this.Lm;
            float f9 = this.Ln;
            path.quadTo(f8, f9, (f6 + f8) / 2.0f, (f7 + f9) / 2.0f);
            this.Lm = f6;
            this.Ln = f7;
        }
    }

    private void d(MotionEvent motionEvent) {
        if (this.Lq.onTouchEvent(motionEvent)) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Li.reset();
            this.Lk = motionEvent.getX();
            float y5 = motionEvent.getY();
            this.Ll = y5;
            float f6 = this.Lk;
            this.Lm = f6;
            this.Ln = y5;
            this.Li.moveTo(f6, y5);
            invalidate();
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            b(motionEvent.getX(), motionEvent.getY());
            invalidate();
            return;
        }
        this.Li.reset();
        invalidate();
        a aVar = this.Lp;
        if (aVar != null) {
            aVar.a(this.Lk, this.Ll, motionEvent.getX(), motionEvent.getY());
        }
    }

    private void init() {
        this.Li = new Path();
        Paint paint = new Paint();
        this.Lj = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.Lj.setStrokeWidth(com.kwad.sdk.c.a.a.a(getContext(), 15.0f));
        this.Lj.setStyle(Paint.Style.STROKE);
        this.Lj.setColor(this.Lo);
        this.Lj.setDither(true);
        this.Lq = new GestureDetector(new GestureDetector.OnGestureListener() { // from class: com.kwad.components.ad.splashscreen.widget.KsSplashSlidePathView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                if (KsSplashSlidePathView.this.Lp == null) {
                    return false;
                }
                KsSplashSlidePathView.this.Lp.c(motionEvent);
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }
        });
    }

    public void setOnSlideTouchListener(a aVar) {
        this.Lp = aVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.Li, this.Lj);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d(motionEvent);
        return true;
    }

    public KsSplashSlidePathView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Lo = Color.parseColor("#66ffffff");
        init();
    }
}
