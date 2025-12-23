package com.bxkj.student.common.crop.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ClipView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f17708a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f17709b;

    /* renamed from: c, reason: collision with root package name */
    private float f17710c;

    /* renamed from: d, reason: collision with root package name */
    private int f17711d;

    /* renamed from: e, reason: collision with root package name */
    private int f17712e;

    /* renamed from: f, reason: collision with root package name */
    private int f17713f;

    /* renamed from: g, reason: collision with root package name */
    private int f17714g;

    /* renamed from: h, reason: collision with root package name */
    private ClipType f17715h;

    /* renamed from: i, reason: collision with root package name */
    private Xfermode f17716i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum ClipType {
        CIRCLE,
        RECTANGLE
    }

    public ClipView(Context context) {
        this(context, null);
    }

    public ClipView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public int a(float size, Context context) {
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        return (int) ((size * r0.density) + 0.5d);
    }

    public Rect getClipRect() {
        Rect rect = new Rect();
        rect.left = (getWidth() / 2) - (this.f17713f / 2);
        rect.right = (getWidth() / 2) + (this.f17713f / 2);
        rect.top = (getHeight() / 2) - (this.f17714g / 2);
        rect.bottom = (getHeight() / 2) + (this.f17714g / 2);
        return rect;
    }

    public void setClipBorderWidth(int clipBorderWidth) {
        this.f17711d = clipBorderWidth;
        this.f17709b.setStrokeWidth(clipBorderWidth);
        invalidate();
    }

    public void setClipType(ClipType clipType) {
        this.f17715h = clipType;
    }

    public void setmHorizontalPadding(float mHorizontalPadding) {
        this.f17710c = mHorizontalPadding;
        this.f17712e = ((int) (b(getContext()) - (mHorizontalPadding * 2.0f))) / 2;
        this.f17713f = a(295.0f, getContext());
        this.f17714g = a(413.0f, getContext());
    }

    public ClipView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f17708a = new Paint();
        this.f17709b = new Paint();
        this.f17715h = ClipType.CIRCLE;
        this.f17708a.setAntiAlias(true);
        this.f17709b.setStyle(Paint.Style.STROKE);
        this.f17709b.setColor(-1);
        this.f17709b.setStrokeWidth(this.f17711d);
        this.f17709b.setAntiAlias(true);
        this.f17716i = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawColor(Color.parseColor("#a8000000"));
        this.f17708a.setXfermode(this.f17716i);
        ClipType clipType = this.f17715h;
        if (clipType == ClipType.CIRCLE) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f17712e, this.f17708a);
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.f17712e, this.f17709b);
        } else if (clipType == ClipType.RECTANGLE) {
            canvas.drawRect((getWidth() / 2) - (this.f17713f / 2), (getHeight() / 2) - (this.f17714g / 2), (getWidth() / 2) + (this.f17713f / 2), (getHeight() / 2) + (this.f17714g / 2), this.f17708a);
            canvas.drawRect((getWidth() / 2) - (this.f17713f / 2), (getHeight() / 2) - (this.f17714g / 2), (getWidth() / 2) + (this.f17713f / 2), (getHeight() / 2) + (this.f17714g / 2), this.f17709b);
        }
        canvas.restore();
    }
}
