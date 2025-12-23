package com.bxkj.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SideBar extends AppCompatTextView {

    /* renamed from: c, reason: collision with root package name */
    private String[] f17173c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f17174d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f17175e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f17176f;

    /* renamed from: g, reason: collision with root package name */
    private Canvas f17177g;

    /* renamed from: h, reason: collision with root package name */
    private int f17178h;

    /* renamed from: i, reason: collision with root package name */
    private int f17179i;

    /* renamed from: j, reason: collision with root package name */
    private int f17180j;

    /* renamed from: k, reason: collision with root package name */
    float f17181k;

    /* renamed from: l, reason: collision with root package name */
    private float f17182l;

    /* renamed from: m, reason: collision with root package name */
    private float f17183m;

    /* renamed from: n, reason: collision with root package name */
    private int f17184n;

    /* renamed from: o, reason: collision with root package name */
    private int f17185o;

    /* renamed from: p, reason: collision with root package name */
    private a f17186p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(int i6, String str);
    }

    public SideBar(Context context) {
        this(context, null);
    }

    private void a(float f6) {
        int i6 = -1;
        if (f6 != 0.0f) {
            int i7 = 0;
            while (true) {
                String[] strArr = this.f17173c;
                if (i7 >= strArr.length) {
                    break;
                }
                int i8 = this.f17178h;
                float f7 = i8 * i7;
                int i9 = i7 + 1;
                float f8 = i8 * i9;
                if (f6 >= f7 && f6 < f8) {
                    a aVar = this.f17186p;
                    if (aVar != null) {
                        aVar.a(i7, strArr[i7]);
                    }
                    Paint.FontMetrics fontMetrics = this.f17175e.getFontMetrics();
                    this.f17177g.drawText(this.f17173c[i7], ((this.f17179i - getPaddingRight()) - this.f17182l) - (fontMetrics.descent - fontMetrics.ascent), this.f17181k + (this.f17178h * i7), this.f17175e);
                    i6 = i7;
                }
                i7 = i9;
            }
        }
        c(f6, i6);
    }

    private void c(float f6, int i6) {
        int i7 = 0;
        if (i6 != -1) {
            while (i7 < this.f17173c.length) {
                float f7 = this.f17181k;
                int i8 = this.f17178h;
                float f8 = (i8 * i7) + f7;
                float abs = 1.0f - Math.abs((f6 - f8) / ((f7 + (i8 * (i6 < i7 ? this.f17185o + i6 : i6 - this.f17185o))) - f8));
                float paddingRight = this.f17179i - getPaddingRight();
                this.f17176f.setTextSize(getTextSize() + (getTextSize() * abs));
                float f9 = paddingRight - (this.f17182l * abs);
                if (f9 > paddingRight) {
                    this.f17177g.drawText(this.f17173c[i7], paddingRight, this.f17181k + (this.f17178h * i7), this.f17174d);
                } else {
                    this.f17177g.drawText(this.f17173c[i7], f9, this.f17181k + (this.f17178h * i7), this.f17176f);
                }
                i7++;
            }
            return;
        }
        this.f17179i = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f17180j = measuredHeight;
        this.f17178h = measuredHeight / this.f17173c.length;
        Paint.FontMetrics fontMetrics = this.f17174d.getFontMetrics();
        this.f17181k = fontMetrics.descent - fontMetrics.ascent;
        while (true) {
            String[] strArr = this.f17173c;
            if (i7 >= strArr.length) {
                return;
            }
            this.f17177g.drawText(strArr[i7], this.f17179i - getPaddingRight(), this.f17181k + (this.f17178h * i7), this.f17174d);
            i7++;
        }
    }

    private void d(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SideBar);
            this.f17184n = obtainStyledAttributes.getInteger(R.styleable.SideBar_scaleSize, 1);
            this.f17185o = obtainStyledAttributes.getInteger(R.styleable.SideBar_scaleItemCount, 6);
            this.f17182l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SideBar_scaleWidth, b(100));
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.f17174d = paint;
        paint.setColor(getCurrentTextColor());
        this.f17174d.setTextSize(getTextSize());
        Paint paint2 = this.f17174d;
        Paint.Align align = Paint.Align.CENTER;
        paint2.setTextAlign(align);
        Paint paint3 = new Paint(1);
        this.f17175e = paint3;
        paint3.setColor(getCurrentTextColor());
        this.f17175e.setTextSize(getTextSize() * (this.f17184n + 3));
        this.f17175e.setTextAlign(align);
        Paint paint4 = new Paint(1);
        this.f17176f = paint4;
        paint4.setColor(getCurrentTextColor());
        this.f17176f.setTextSize(getTextSize() * (this.f17184n + 1));
        this.f17176f.setTextAlign(align);
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f17177g = canvas;
        a(this.f17183m);
    }

    public void setDataResource(String[] strArr) {
        this.f17173c = strArr;
        invalidate();
    }

    public void setOnStrSelectCallBack(a aVar) {
        this.f17186p = aVar;
    }

    public void setScaleItemCount(int i6) {
        this.f17185o = i6;
        invalidate();
    }

    public void setScaleSize(int i6) {
        this.f17184n = i6;
        invalidate();
    }

    public SideBar(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f17173c = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "#"};
        this.f17183m = 0.0f;
        this.f17184n = 1;
        this.f17185o = 6;
        d(attributeSet);
    }

    private int b(int i6) {
        return (int) ((i6 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.f17183m = 0.0f;
                        invalidate();
                        return true;
                    }
                }
            } else if (motionEvent.getX() > ((this.f17179i - getPaddingRight()) - this.f17181k) - 10.0f) {
                this.f17183m = 0.0f;
                invalidate();
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getX() > ((this.f17179i - getPaddingRight()) - this.f17181k) - 10.0f) {
            this.f17183m = motionEvent.getY();
            invalidate();
            return true;
        }
        this.f17183m = 0.0f;
        invalidate();
        return super.onTouchEvent(motionEvent);
    }
}
