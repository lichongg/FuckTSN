package com.bxkj.student.run.app.utils;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bxkj.student.R;
import com.bxkj.student.run.app.utils.q;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RecordPathView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Context f20127a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f20128b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f20129c;

    /* renamed from: d, reason: collision with root package name */
    private Path f20130d;

    /* renamed from: e, reason: collision with root package name */
    private Path f20131e;

    /* renamed from: f, reason: collision with root package name */
    private PathMeasure f20132f;

    /* renamed from: g, reason: collision with root package name */
    private PathMeasure f20133g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f20134h;

    /* renamed from: i, reason: collision with root package name */
    private float f20135i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f20136j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f20137k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f20138l;

    /* renamed from: m, reason: collision with root package name */
    private Canvas f20139m;

    /* renamed from: n, reason: collision with root package name */
    private float[] f20140n;

    /* renamed from: o, reason: collision with root package name */
    private float[] f20141o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f20142p;

    /* renamed from: q, reason: collision with root package name */
    private float f20143q;

    /* renamed from: r, reason: collision with root package name */
    private long f20144r;

    /* renamed from: s, reason: collision with root package name */
    private ArrayList<q.a> f20145s;

    /* renamed from: t, reason: collision with root package name */
    private d f20146t;

    /* renamed from: u, reason: collision with root package name */
    private int f20147u;

    /* renamed from: v, reason: collision with root package name */
    private int f20148v;

    /* renamed from: w, reason: collision with root package name */
    float f20149w;

    /* renamed from: x, reason: collision with root package name */
    float f20150x;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            RecordPathView.this.f20143q = ((Float) animation.getAnimatedValue()).floatValue();
            RecordPathView.this.d();
            RecordPathView.this.invalidate();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (RecordPathView.this.f20146t != null) {
                RecordPathView.this.f20146t.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements TypeEvaluator {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            return Float.valueOf(fraction);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a();
    }

    public RecordPathView(Context context) {
        super(context);
        this.f20134h = false;
        this.f20140n = new float[2];
        this.f20141o = new float[2];
        this.f20142p = new float[2];
        this.f20143q = 0.0f;
        this.f20127a = context;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        float f6;
        float f7 = this.f20143q * this.f20135i;
        int size = this.f20145s.size();
        int i6 = 0;
        float f8 = 0.0f;
        while (true) {
            if (i6 >= size) {
                f6 = 0.0f;
                break;
            }
            f8 += this.f20145s.get(i6).e();
            if (f8 > f7) {
                this.f20147u = i6;
                f6 = f8 - f7;
                break;
            }
            i6++;
        }
        this.f20130d.reset();
        new PathMeasure(this.f20145s.get(this.f20147u).d(), false).getSegment(0.0f, this.f20145s.get(this.f20147u).e() - f6, this.f20130d, true);
        PathMeasure pathMeasure = new PathMeasure(this.f20130d, false);
        this.f20133g = pathMeasure;
        pathMeasure.getPosTan(pathMeasure.getLength(), this.f20142p, null);
    }

    private void f() {
        Paint paint = new Paint();
        this.f20128b = paint;
        paint.setAntiAlias(true);
        this.f20128b.setStyle(Paint.Style.STROKE);
        this.f20128b.setStrokeWidth(10.0f);
        Paint paint2 = new Paint();
        this.f20129c = paint2;
        paint2.setAntiAlias(true);
        this.f20130d = new Path();
        this.f20136j = BitmapFactory.decodeResource(this.f20127a.getResources(), R.mipmap.ic_marker_start);
        this.f20137k = BitmapFactory.decodeResource(this.f20127a.getResources(), R.mipmap.speed_view_point);
    }

    private void g() {
        ValueAnimator ofObject = ValueAnimator.ofObject(new c(), 0, Float.valueOf(this.f20132f.getLength()));
        ofObject.setDuration(this.f20144r);
        ofObject.setInterpolator(new AccelerateDecelerateInterpolator());
        ofObject.addUpdateListener(new a());
        ofObject.addListener(new b());
        ofObject.start();
    }

    public void e() {
        this.f20130d = new Path();
        Bitmap bitmap = this.f20136j;
        if (bitmap != null) {
            bitmap.recycle();
            this.f20136j = null;
        }
        Bitmap bitmap2 = this.f20137k;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f20137k = null;
        }
        invalidate();
    }

    public void setOnAnimEnd(d onAnimEnd) {
        this.f20146t = onAnimEnd;
    }

    public void setPath(q recordPathAnimUtil) {
        if (recordPathAnimUtil == null || this.f20134h) {
            return;
        }
        this.f20135i = recordPathAnimUtil.d();
        this.f20144r = recordPathAnimUtil.c();
        this.f20145s = recordPathAnimUtil.e();
        this.f20131e = recordPathAnimUtil.f();
        PathMeasure pathMeasure = new PathMeasure(this.f20131e, false);
        this.f20132f = pathMeasure;
        pathMeasure.getPosTan(0.0f, this.f20140n, null);
        PathMeasure pathMeasure2 = this.f20132f;
        pathMeasure2.getPosTan(pathMeasure2.getLength(), this.f20141o, null);
        ArrayList<q.a> arrayList = this.f20145s;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        g();
        this.f20134h = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList<q.a> arrayList = this.f20145s;
        if (arrayList != null && arrayList.size() != 0 && this.f20143q < 1.0f) {
            if (this.f20138l == null) {
                this.f20138l = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                this.f20139m = new Canvas(this.f20138l);
            }
            this.f20139m.save();
            int i6 = this.f20147u;
            int i7 = this.f20148v;
            if (i6 > i7 && i7 > 0) {
                for (int i8 = i7 - 1; i8 < this.f20147u; i8++) {
                    q.a aVar = this.f20145s.get(i8);
                    this.f20128b.setColor(aVar.a());
                    this.f20128b.setShader(aVar.f());
                    this.f20128b.setStrokeWidth(10.0f);
                    this.f20128b.setStyle(Paint.Style.STROKE);
                    this.f20139m.drawPath(aVar.d(), this.f20128b);
                    this.f20128b.setShader(null);
                    this.f20128b.setStrokeWidth(1.0f);
                    this.f20128b.setStyle(Paint.Style.FILL_AND_STROKE);
                    this.f20139m.drawCircle(aVar.b().x, aVar.b().y, 5.0f, this.f20128b);
                }
            }
            this.f20139m.restore();
            canvas.drawBitmap(this.f20138l, 0.0f, 0.0f, this.f20129c);
            this.f20128b.setStyle(Paint.Style.STROKE);
            this.f20128b.setShader(this.f20145s.get(this.f20147u).f());
            this.f20128b.setStrokeWidth(10.0f);
            canvas.drawPath(this.f20130d, this.f20128b);
            canvas.drawBitmap(this.f20137k, this.f20142p[0] - (r0.getWidth() / 2), this.f20142p[1] - (this.f20137k.getHeight() / 2), this.f20129c);
            int i9 = this.f20148v;
            int i10 = this.f20147u;
            if (i9 != i10) {
                this.f20148v = i10;
            }
        }
    }

    public RecordPathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f20134h = false;
        this.f20140n = new float[2];
        this.f20141o = new float[2];
        this.f20142p = new float[2];
        this.f20143q = 0.0f;
        this.f20127a = context;
        f();
    }

    public RecordPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f20134h = false;
        this.f20140n = new float[2];
        this.f20141o = new float[2];
        this.f20142p = new float[2];
        this.f20143q = 0.0f;
        this.f20127a = context;
        f();
    }
}
