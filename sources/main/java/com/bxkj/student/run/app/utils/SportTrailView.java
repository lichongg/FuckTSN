package com.bxkj.student.run.app.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SportTrailView extends View {

    /* renamed from: l, reason: collision with root package name */
    public static final int f20154l = Color.rgb(124, 252, 0);

    /* renamed from: m, reason: collision with root package name */
    public static final int f20155m = 10;

    /* renamed from: a, reason: collision with root package name */
    private Paint f20156a;

    /* renamed from: b, reason: collision with root package name */
    private Point f20157b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f20158c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f20159d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f20160e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f20161f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f20162g;

    /* renamed from: h, reason: collision with root package name */
    private int f20163h;

    /* renamed from: i, reason: collision with root package name */
    private int f20164i;

    /* renamed from: j, reason: collision with root package name */
    private Path f20165j;

    /* renamed from: k, reason: collision with root package name */
    private float[] f20166k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PathMeasure f20167a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f20168b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f20169c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f20170d;

        a(final PathMeasure val$pathMeasure, final List val$mPositions, final float val$length, final b val$listener) {
            this.f20167a = val$pathMeasure;
            this.f20168b = val$mPositions;
            this.f20169c = val$length;
            this.f20170d = val$listener;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            b bVar;
            float floatValue = ((Float) animation.getAnimatedValue()).floatValue();
            this.f20167a.getPosTan(floatValue, SportTrailView.this.f20166k, null);
            if (floatValue == 0.0f) {
                SportTrailView.this.f20165j.moveTo(((Point) this.f20168b.get(0)).x, ((Point) this.f20168b.get(0)).y);
            }
            this.f20167a.getSegment(0.0f, floatValue, SportTrailView.this.f20165j, true);
            SportTrailView.this.invalidate();
            if (floatValue == this.f20169c && (bVar = this.f20170d) != null) {
                bVar.onFinish();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onFinish();
    }

    public SportTrailView(Context context) {
        this(context, null);
    }

    public SportTrailView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private void e() {
        Paint paint = new Paint();
        this.f20159d = paint;
        paint.setColor(f20154l);
        this.f20159d.setStyle(Paint.Style.STROKE);
        this.f20159d.setStrokeWidth(10.0f);
        this.f20159d.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f20160e = paint2;
        paint2.setAntiAlias(true);
        this.f20160e.setFilterBitmap(true);
        Paint paint3 = new Paint();
        this.f20156a = paint3;
        paint3.setAntiAlias(true);
        this.f20156a.setFilterBitmap(true);
        this.f20165j = new Path();
    }

    public void c() {
        this.f20165j = new Path();
        Bitmap bitmap = this.f20161f;
        if (bitmap != null) {
            bitmap.recycle();
            this.f20161f = null;
        }
        Bitmap bitmap2 = this.f20158c;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f20158c = null;
        }
        invalidate();
    }

    public SportTrailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f20166k = new float[2];
        e();
    }

    public void d(final List<Point> mPositions, @DrawableRes int startPointResId, @DrawableRes int lightBall, final b listener) {
        if (mPositions.size() <= 1) {
            listener.onFinish();
            return;
        }
        Path path = new Path();
        for (int i6 = 0; i6 < mPositions.size(); i6++) {
            if (i6 == 0) {
                path.moveTo(mPositions.get(i6).x, mPositions.get(i6).y);
            } else {
                path.lineTo(mPositions.get(i6).x, mPositions.get(i6).y);
            }
        }
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        if (length < r.a(getContext(), 16.0f)) {
            listener.onFinish();
            return;
        }
        this.f20161f = BitmapFactory.decodeResource(getResources(), lightBall);
        this.f20157b = new Point(mPositions.get(0).x, mPositions.get(0).y);
        this.f20158c = BitmapDescriptorFactory.fromResource(startPointResId).getBitmap();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, length);
        ofFloat.setDuration(3000L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new a(pathMeasure, mPositions, length, listener));
        ofFloat.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f20165j, this.f20159d);
        Bitmap bitmap = this.f20161f;
        if (bitmap != null && this.f20162g != null) {
            int width = bitmap.getWidth();
            int height = this.f20161f.getHeight();
            RectF rectF = new RectF();
            float[] fArr = this.f20166k;
            float f6 = fArr[0];
            float f7 = width;
            rectF.left = f6 - f7;
            rectF.right = f6 + f7;
            float f8 = fArr[1];
            float f9 = height;
            rectF.top = f8 - f9;
            rectF.bottom = f8 + f9;
            canvas.drawBitmap(this.f20161f, (Rect) null, rectF, this.f20160e);
        }
        Bitmap bitmap2 = this.f20158c;
        if (bitmap2 != null && this.f20157b != null) {
            if (this.f20162g == null) {
                int width2 = bitmap2.getWidth() / 2;
                int height2 = this.f20158c.getHeight();
                Rect rect = new Rect();
                this.f20162g = rect;
                Point point = this.f20157b;
                int i6 = point.x;
                rect.left = i6 - width2;
                rect.right = i6 + width2;
                int i7 = point.y;
                rect.top = i7 - height2;
                rect.bottom = i7;
            }
            canvas.drawBitmap(this.f20158c, (Rect) null, this.f20162g, this.f20156a);
        }
    }
}
