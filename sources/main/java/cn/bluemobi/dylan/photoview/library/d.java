package cn.bluemobi.dylan.photoview.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d implements cn.bluemobi.dylan.photoview.library.c, View.OnTouchListener, cn.bluemobi.dylan.photoview.library.gestures.e, ViewTreeObserver.OnGlobalLayoutListener {
    private static final String B = "PhotoViewAttacher";
    private static final boolean C = Log.isLoggable(B, 3);
    static final Interpolator D = new AccelerateDecelerateInterpolator();
    static final int E = -1;
    static final int F = 0;
    static final int G = 1;
    static final int H = 2;
    private ImageView.ScaleType A;

    /* renamed from: a, reason: collision with root package name */
    int f1310a;

    /* renamed from: b, reason: collision with root package name */
    private float f1311b;

    /* renamed from: c, reason: collision with root package name */
    private float f1312c;

    /* renamed from: d, reason: collision with root package name */
    private float f1313d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1314e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1315f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<ImageView> f1316g;

    /* renamed from: h, reason: collision with root package name */
    private GestureDetector f1317h;

    /* renamed from: i, reason: collision with root package name */
    private cn.bluemobi.dylan.photoview.library.gestures.d f1318i;

    /* renamed from: j, reason: collision with root package name */
    private final Matrix f1319j;

    /* renamed from: k, reason: collision with root package name */
    private final Matrix f1320k;

    /* renamed from: l, reason: collision with root package name */
    private final Matrix f1321l;

    /* renamed from: m, reason: collision with root package name */
    private final RectF f1322m;

    /* renamed from: n, reason: collision with root package name */
    private final float[] f1323n;

    /* renamed from: o, reason: collision with root package name */
    private e f1324o;

    /* renamed from: p, reason: collision with root package name */
    private f f1325p;

    /* renamed from: q, reason: collision with root package name */
    private h f1326q;

    /* renamed from: r, reason: collision with root package name */
    private View.OnLongClickListener f1327r;

    /* renamed from: s, reason: collision with root package name */
    private g f1328s;

    /* renamed from: t, reason: collision with root package name */
    private int f1329t;

    /* renamed from: u, reason: collision with root package name */
    private int f1330u;

    /* renamed from: v, reason: collision with root package name */
    private int f1331v;

    /* renamed from: w, reason: collision with root package name */
    private int f1332w;

    /* renamed from: x, reason: collision with root package name */
    private RunnableC0017d f1333x;

    /* renamed from: y, reason: collision with root package name */
    private int f1334y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f1335z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (d.this.f1327r != null) {
                d.this.f1327r.onLongClick(d.this.u());
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final float f1338a;

        /* renamed from: b, reason: collision with root package name */
        private final float f1339b;

        /* renamed from: c, reason: collision with root package name */
        private final long f1340c = System.currentTimeMillis();

        /* renamed from: d, reason: collision with root package name */
        private final float f1341d;

        /* renamed from: e, reason: collision with root package name */
        private final float f1342e;

        public c(float f6, float f7, float f8, float f9) {
            this.f1338a = f8;
            this.f1339b = f9;
            this.f1341d = f6;
            this.f1342e = f7;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView u5 = d.this.u();
            if (u5 == null) {
                return;
            }
            float a6 = a();
            float f6 = this.f1341d;
            d.this.f((f6 + ((this.f1342e - f6) * a6)) / d.this.getScale(), this.f1338a, this.f1339b);
            if (a6 < 1.0f) {
                cn.bluemobi.dylan.photoview.library.a.d(u5, this);
            }
        }

        private float a() {
            return d.D.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f1340c) * 1.0f) / d.this.f1310a));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: cn.bluemobi.dylan.photoview.library.d$d, reason: collision with other inner class name */
    private class RunnableC0017d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final cn.bluemobi.dylan.photoview.library.scrollerproxy.d f1344a;

        /* renamed from: b, reason: collision with root package name */
        private int f1345b;

        /* renamed from: c, reason: collision with root package name */
        private int f1346c;

        public RunnableC0017d(Context context) {
            this.f1344a = cn.bluemobi.dylan.photoview.library.scrollerproxy.d.f(context);
        }

        public void b(int i6, int i7, int i8, int i9) {
            int i10;
            int i11;
            int i12;
            int i13;
            RectF displayRect = d.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int round = Math.round(-displayRect.left);
            float f6 = i6;
            if (f6 < displayRect.width()) {
                i11 = Math.round(displayRect.width() - f6);
                i10 = 0;
            } else {
                i10 = round;
                i11 = i10;
            }
            int round2 = Math.round(-displayRect.top);
            float f7 = i7;
            if (f7 < displayRect.height()) {
                i13 = Math.round(displayRect.height() - f7);
                i12 = 0;
            } else {
                i12 = round2;
                i13 = i12;
            }
            this.f1345b = round;
            this.f1346c = round2;
            if (d.C) {
                i.a.a().d(d.B, "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i11 + " MaxY:" + i13);
            }
            if (round == i11 && round2 == i13) {
                return;
            }
            this.f1344a.b(round, round2, i8, i9, i10, i11, i12, i13, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView u5;
            if (this.f1344a.g() || (u5 = d.this.u()) == null || !this.f1344a.a()) {
                return;
            }
            int d6 = this.f1344a.d();
            int e6 = this.f1344a.e();
            if (d.C) {
                i.a.a().d(d.B, "fling run(). CurrentX:" + this.f1345b + " CurrentY:" + this.f1346c + " NewX:" + d6 + " NewY:" + e6);
            }
            d.this.f1321l.postTranslate(this.f1345b - d6, this.f1346c - e6);
            d dVar = d.this;
            dVar.B(dVar.t());
            this.f1345b = d6;
            this.f1346c = e6;
            cn.bluemobi.dylan.photoview.library.a.d(u5, this);
        }

        public void a() {
            if (d.C) {
                i.a.a().d(d.B, "Cancel Fling");
            }
            this.f1344a.c(true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void a(RectF rectF);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface f {
        void a(View view, float f6, float f7);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g {
        void a(float f6, float f7, float f8);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface h {
        void a(View view, float f6, float f7);
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setScale(float f6) {
        b(f6, false);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1337a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f1337a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1337a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1337a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1337a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1337a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public d(ImageView imageView, boolean z5) {
        this.f1310a = 200;
        this.f1311b = 1.0f;
        this.f1312c = 1.75f;
        this.f1313d = 3.0f;
        this.f1314e = true;
        this.f1315f = false;
        this.f1319j = new Matrix();
        this.f1320k = new Matrix();
        this.f1321l = new Matrix();
        this.f1322m = new RectF();
        this.f1323n = new float[9];
        this.f1334y = 2;
        this.A = ImageView.ScaleType.FIT_CENTER;
        this.f1316g = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        C(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f1318i = cn.bluemobi.dylan.photoview.library.gestures.f.a(imageView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new a());
        this.f1317h = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new cn.bluemobi.dylan.photoview.library.b(this));
        setZoomable(z5);
    }

    private void A() {
        this.f1321l.reset();
        B(t());
        p();
    }

    private static void C(ImageView imageView) {
        if (imageView == null || (imageView instanceof cn.bluemobi.dylan.photoview.library.c)) {
            return;
        }
        ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;
        if (scaleType.equals(imageView.getScaleType())) {
            return;
        }
        imageView.setScaleType(scaleType);
    }

    private void m() {
        RunnableC0017d runnableC0017d = this.f1333x;
        if (runnableC0017d != null) {
            runnableC0017d.a();
            this.f1333x = null;
        }
    }

    private static void q(float f6, float f7, float f8) {
        if (f6 >= f7) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f7 >= f8) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private int v(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private int w(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float x(Matrix matrix, int i6) {
        matrix.getValues(this.f1323n);
        return this.f1323n[i6];
    }

    private static boolean y(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean z(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (b.f1337a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.e
    public void c(float f6, float f7, float f8, float f9) {
        if (C) {
            i.a.a().d(B, "onFling. sX: " + f6 + " sY: " + f7 + " Vx: " + f8 + " Vy: " + f9);
        }
        ImageView u5 = u();
        RunnableC0017d runnableC0017d = new RunnableC0017d(u5.getContext());
        this.f1333x = runnableC0017d;
        runnableC0017d.b(w(u5), v(u5), (int) f8, (int) f9);
        u5.post(this.f1333x);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public boolean d() {
        return this.f1335z;
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.e
    public void e(float f6, float f7) {
        if (this.f1318i.c()) {
            return;
        }
        if (C) {
            i.a.a().d(B, String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f6), Float.valueOf(f7)));
        }
        ImageView u5 = u();
        this.f1321l.postTranslate(f6, f7);
        n();
        ViewParent parent = u5.getParent();
        if (!this.f1314e || this.f1318i.c() || this.f1315f) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i6 = this.f1334y;
        if ((i6 == 2 || ((i6 == 0 && f6 >= 1.0f) || (i6 == 1 && f6 <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.gestures.e
    public void f(float f6, float f7, float f8) {
        if (C) {
            i.a.a().d(B, String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)));
        }
        if (getScale() < this.f1313d || f6 < 1.0f) {
            g gVar = this.f1328s;
            if (gVar != null) {
                gVar.a(f6, f7, f8);
            }
            this.f1321l.postScale(f6, f6, f7, f8);
            n();
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public boolean g(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        ImageView u5 = u();
        if (u5 == null || u5.getDrawable() == null) {
            return false;
        }
        this.f1321l.set(matrix);
        B(t());
        p();
        return true;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public Matrix getDisplayMatrix() {
        return new Matrix(t());
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMaximumScale() {
        return this.f1313d;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMediumScale() {
        return this.f1312c;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getMinimumScale() {
        return this.f1311b;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public f getOnPhotoTapListener() {
        return this.f1325p;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public h getOnViewTapListener() {
        return this.f1326q;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(x(this.f1321l, 0), 2.0d)) + ((float) Math.pow(x(this.f1321l, 3), 2.0d)));
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public ImageView.ScaleType getScaleType() {
        return this.A;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.f1335z
            r1 = 0
            if (r0 == 0) goto La1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = y(r0)
            if (r0 == 0) goto La1
            android.view.ViewParent r0 = r11.getParent()
            int r2 = r12.getAction()
            r3 = 1
            if (r2 == 0) goto L49
            if (r2 == r3) goto L20
            r0 = 3
            if (r2 == r0) goto L20
        L1e:
            r5 = r10
            goto L5e
        L20:
            float r0 = r10.getScale()
            float r2 = r10.f1311b
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L1e
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L1e
            cn.bluemobi.dylan.photoview.library.d$c r4 = new cn.bluemobi.dylan.photoview.library.d$c
            float r6 = r10.getScale()
            float r7 = r10.f1311b
            float r8 = r0.centerX()
            float r9 = r0.centerY()
            r5 = r10
            r4.<init>(r6, r7, r8, r9)
            r11.post(r4)
            r11 = 1
            goto L5f
        L49:
            r5 = r10
            if (r0 == 0) goto L50
            r0.requestDisallowInterceptTouchEvent(r3)
            goto L5b
        L50:
            i.b r11 = i.a.a()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r2 = "onTouch getParent() returned null"
            r11.i(r0, r2)
        L5b:
            r10.m()
        L5e:
            r11 = 0
        L5f:
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r5.f1318i
            if (r0 == 0) goto L95
            boolean r11 = r0.c()
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r5.f1318i
            boolean r0 = r0.b()
            cn.bluemobi.dylan.photoview.library.gestures.d r2 = r5.f1318i
            boolean r2 = r2.onTouchEvent(r12)
            if (r11 != 0) goto L7f
            cn.bluemobi.dylan.photoview.library.gestures.d r11 = r5.f1318i
            boolean r11 = r11.c()
            if (r11 != 0) goto L7f
            r11 = 1
            goto L80
        L7f:
            r11 = 0
        L80:
            if (r0 != 0) goto L8c
            cn.bluemobi.dylan.photoview.library.gestures.d r0 = r5.f1318i
            boolean r0 = r0.b()
            if (r0 != 0) goto L8c
            r0 = 1
            goto L8d
        L8c:
            r0 = 0
        L8d:
            if (r11 == 0) goto L92
            if (r0 == 0) goto L92
            r1 = 1
        L92:
            r5.f1315f = r1
            r11 = r2
        L95:
            android.view.GestureDetector r0 = r5.f1317h
            if (r0 == 0) goto La0
            boolean r12 = r0.onTouchEvent(r12)
            if (r12 == 0) goto La0
            return r3
        La0:
            return r11
        La1:
            r5 = r10
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.bluemobi.dylan.photoview.library.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void r() {
        WeakReference<ImageView> weakReference = this.f1316g;
        if (weakReference == null) {
            return;
        }
        ImageView imageView = weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
            imageView.setOnTouchListener(null);
            m();
        }
        GestureDetector gestureDetector = this.f1317h;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.f1324o = null;
        this.f1325p = null;
        this.f1326q = null;
        this.f1316g = null;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setAllowParentInterceptOnEdge(boolean z5) {
        this.f1314e = z5;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMaximumScale(float f6) {
        q(this.f1311b, this.f1312c, f6);
        this.f1313d = f6;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMediumScale(float f6) {
        q(this.f1311b, f6, this.f1313d);
        this.f1312c = f6;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setMinimumScale(float f6) {
        q(f6, this.f1312c, this.f1313d);
        this.f1311b = f6;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.f1317h.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.f1317h.setOnDoubleTapListener(new cn.bluemobi.dylan.photoview.library.b(this));
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f1327r = onLongClickListener;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnMatrixChangeListener(e eVar) {
        this.f1324o = eVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnPhotoTapListener(f fVar) {
        this.f1325p = fVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnScaleChangeListener(g gVar) {
        this.f1328s = gVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setOnViewTapListener(h hVar) {
        this.f1326q = hVar;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setPhotoViewRotation(float f6) {
        this.f1321l.setRotate(f6 % 360.0f);
        n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setRotationBy(float f6) {
        this.f1321l.postRotate(f6 % 360.0f);
        n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setRotationTo(float f6) {
        this.f1321l.setRotate(f6 % 360.0f);
        n();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setZoomTransitionDuration(int i6) {
        if (i6 < 0) {
            i6 = 200;
        }
        this.f1310a = i6;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setZoomable(boolean z5) {
        this.f1335z = z5;
        update();
    }

    public Matrix t() {
        this.f1320k.set(this.f1319j);
        this.f1320k.postConcat(this.f1321l);
        return this.f1320k;
    }

    public ImageView u() {
        WeakReference<ImageView> weakReference = this.f1316g;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            r();
            i.a.a().i(B, "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(Matrix matrix) {
        RectF s5;
        ImageView u5 = u();
        if (u5 != null) {
            o();
            u5.setImageMatrix(matrix);
            if (this.f1324o != null && (s5 = s(matrix)) != null) {
                this.f1324o.a(s5);
            }
        }
    }

    private void D(Drawable drawable) {
        ImageView u5 = u();
        if (u5 != null && drawable != null) {
            float w5 = w(u5);
            float v5 = v(u5);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.f1319j.reset();
            float f6 = intrinsicWidth;
            float f7 = w5 / f6;
            float f8 = intrinsicHeight;
            float f9 = v5 / f8;
            ImageView.ScaleType scaleType = this.A;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.f1319j.postTranslate((w5 - f6) / 2.0f, (v5 - f8) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f7, f9);
                this.f1319j.postScale(max, max);
                this.f1319j.postTranslate((w5 - (f6 * max)) / 2.0f, (v5 - (f8 * max)) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f7, f9));
                this.f1319j.postScale(min, min);
                this.f1319j.postTranslate((w5 - (f6 * min)) / 2.0f, (v5 - (f8 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f6, f8);
                RectF rectF2 = new RectF(0.0f, 0.0f, w5, v5);
                int i6 = b.f1337a[this.A.ordinal()];
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 4) {
                            if (i6 == 5) {
                                this.f1319j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                            }
                        } else {
                            this.f1319j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                        }
                    } else {
                        this.f1319j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                    }
                } else {
                    this.f1319j.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                }
            }
            A();
        }
    }

    private void n() {
        if (p()) {
            B(t());
        }
    }

    private void o() {
        ImageView u5 = u();
        if (u5 != null && !(u5 instanceof cn.bluemobi.dylan.photoview.library.c) && !ImageView.ScaleType.MATRIX.equals(u5.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean p() {
        RectF s5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        ImageView u5 = u();
        if (u5 == null || (s5 = s(t())) == null) {
            return false;
        }
        float height = s5.height();
        float width = s5.width();
        float v5 = v(u5);
        float f12 = 0.0f;
        if (height <= v5) {
            int i6 = b.f1337a[this.A.ordinal()];
            if (i6 != 2) {
                if (i6 != 3) {
                    v5 = (v5 - height) / 2.0f;
                    f7 = s5.top;
                } else {
                    v5 -= height;
                    f7 = s5.top;
                }
                f8 = v5 - f7;
            } else {
                f6 = s5.top;
                f8 = -f6;
            }
        } else {
            f6 = s5.top;
            if (f6 <= 0.0f) {
                f7 = s5.bottom;
                if (f7 >= v5) {
                    f8 = 0.0f;
                }
                f8 = v5 - f7;
            }
            f8 = -f6;
        }
        float w5 = w(u5);
        if (width <= w5) {
            int i7 = b.f1337a[this.A.ordinal()];
            if (i7 != 2) {
                if (i7 != 3) {
                    f10 = (w5 - width) / 2.0f;
                    f11 = s5.left;
                } else {
                    f10 = w5 - width;
                    f11 = s5.left;
                }
                f9 = f10 - f11;
            } else {
                f9 = -s5.left;
            }
            f12 = f9;
            this.f1334y = 2;
        } else {
            float f13 = s5.left;
            if (f13 > 0.0f) {
                this.f1334y = 0;
                f12 = -f13;
            } else {
                float f14 = s5.right;
                if (f14 < w5) {
                    f12 = w5 - f14;
                    this.f1334y = 1;
                } else {
                    this.f1334y = -1;
                }
            }
        }
        this.f1321l.postTranslate(f12, f8);
        return true;
    }

    private RectF s(Matrix matrix) {
        Drawable drawable;
        ImageView u5 = u();
        if (u5 != null && (drawable = u5.getDrawable()) != null) {
            this.f1322m.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.f1322m);
            return this.f1322m;
        }
        return null;
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void a(float f6, float f7, float f8, boolean z5) {
        ImageView u5 = u();
        if (u5 != null) {
            if (f6 >= this.f1311b && f6 <= this.f1313d) {
                if (z5) {
                    u5.post(new c(getScale(), f6, f7, f8));
                    return;
                } else {
                    this.f1321l.setScale(f6, f6, f7, f8);
                    n();
                    return;
                }
            }
            i.a.a().i(B, "Scale must be within the range of minScale and maxScale");
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void b(float f6, boolean z5) {
        if (u() != null) {
            a(f6, r0.getRight() / 2, r0.getBottom() / 2, z5);
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public RectF getDisplayRect() {
        p();
        return s(t());
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public Bitmap getVisibleRectangleBitmap() {
        ImageView u5 = u();
        if (u5 == null) {
            return null;
        }
        return u5.getDrawingCache();
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void h(float f6, float f7, float f8) {
        q(f6, f7, f8);
        this.f1311b = f6;
        this.f1312c = f7;
        this.f1313d = f8;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView u5 = u();
        if (u5 != null) {
            if (this.f1335z) {
                int top2 = u5.getTop();
                int right = u5.getRight();
                int bottom = u5.getBottom();
                int left = u5.getLeft();
                if (top2 != this.f1329t || bottom != this.f1331v || left != this.f1332w || right != this.f1330u) {
                    D(u5.getDrawable());
                    this.f1329t = top2;
                    this.f1330u = right;
                    this.f1331v = bottom;
                    this.f1332w = left;
                    return;
                }
                return;
            }
            D(u5.getDrawable());
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMaxScale(float f6) {
        setMaximumScale(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMidScale(float f6) {
        setMediumScale(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    @Deprecated
    public void setMinScale(float f6) {
        setMinimumScale(f6);
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (z(scaleType) && scaleType != this.A) {
            this.A = scaleType;
            update();
        }
    }

    public void update() {
        ImageView u5 = u();
        if (u5 != null) {
            if (this.f1335z) {
                C(u5);
                D(u5.getDrawable());
            } else {
                A();
            }
        }
    }

    @Override // cn.bluemobi.dylan.photoview.library.c
    public cn.bluemobi.dylan.photoview.library.c getIPhotoViewImplementation() {
        return this;
    }
}
