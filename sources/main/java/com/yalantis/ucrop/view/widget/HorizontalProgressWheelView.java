package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class HorizontalProgressWheelView extends View {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f42903a;

    /* renamed from: b, reason: collision with root package name */
    private a f42904b;

    /* renamed from: c, reason: collision with root package name */
    private float f42905c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f42906d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f42907e;

    /* renamed from: f, reason: collision with root package name */
    private int f42908f;

    /* renamed from: g, reason: collision with root package name */
    private int f42909g;

    /* renamed from: h, reason: collision with root package name */
    private int f42910h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f42911i;

    /* renamed from: j, reason: collision with root package name */
    private float f42912j;

    /* renamed from: k, reason: collision with root package name */
    private int f42913k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a();

        void b();

        void onScroll(float f6, float f7);
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(MotionEvent motionEvent, float f6) {
        this.f42912j -= f6;
        postInvalidate();
        this.f42905c = motionEvent.getX();
        a aVar = this.f42904b;
        if (aVar != null) {
            aVar.onScroll(-f6, this.f42912j);
        }
    }

    public void setMiddleLineColor(@ColorInt int i6) {
        this.f42913k = i6;
        invalidate();
    }

    public void setScrollingListener(a aVar) {
        this.f42904b = aVar;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f42903a = new Rect();
        a();
    }

    private void a() {
        this.f42913k = ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.f42908f = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.f42909g = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.f42910h = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.f42906d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f42906d.setStrokeWidth(this.f42908f);
        this.f42906d.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        Paint paint2 = new Paint(this.f42906d);
        this.f42907e = paint2;
        paint2.setColor(this.f42913k);
        this.f42907e.setStrokeCap(Paint.Cap.ROUND);
        this.f42907e.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f42903a);
        int width = this.f42903a.width() / (this.f42908f + this.f42910h);
        float f6 = this.f42912j % (r3 + r2);
        for (int i6 = 0; i6 < width; i6++) {
            int i7 = width / 4;
            if (i6 < i7) {
                this.f42906d.setAlpha((int) ((i6 / i7) * 255.0f));
            } else if (i6 > (width * 3) / 4) {
                this.f42906d.setAlpha((int) (((width - i6) / i7) * 255.0f));
            } else {
                this.f42906d.setAlpha(255);
            }
            float f7 = -f6;
            Rect rect = this.f42903a;
            Rect rect2 = this.f42903a;
            canvas.drawLine(rect.left + f7 + ((this.f42908f + this.f42910h) * i6), rect.centerY() - (this.f42909g / 4.0f), f7 + rect2.left + ((this.f42908f + this.f42910h) * i6), rect2.centerY() + (this.f42909g / 4.0f), this.f42906d);
        }
        canvas.drawLine(this.f42903a.centerX(), this.f42903a.centerY() - (this.f42909g / 2.0f), this.f42903a.centerX(), (this.f42909g / 2.0f) + this.f42903a.centerY(), this.f42907e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x5 = motionEvent.getX() - this.f42905c;
                    if (x5 != 0.0f) {
                        if (!this.f42911i) {
                            this.f42911i = true;
                            a aVar = this.f42904b;
                            if (aVar != null) {
                                aVar.b();
                            }
                        }
                        b(motionEvent, x5);
                    }
                }
            } else {
                a aVar2 = this.f42904b;
                if (aVar2 != null) {
                    this.f42911i = false;
                    aVar2.a();
                }
            }
        } else {
            this.f42905c = motionEvent.getX();
        }
        return true;
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f42903a = new Rect();
    }
}
