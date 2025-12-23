package com.huawei.hms.scankit.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.scankit.R;
import com.huawei.hms.scankit.p.b1;
import com.huawei.hms.scankit.p.b6;
import com.huawei.hms.scankit.p.n6;
import com.huawei.hms.scankit.p.y5;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ScanDrawable extends Drawable implements Animatable {

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator f33889a;

    /* renamed from: b, reason: collision with root package name */
    private final ValueAnimator f33890b;

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f33891c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f33892d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f33893e;

    /* renamed from: f, reason: collision with root package name */
    private final ColorMatrix f33894f;

    /* renamed from: g, reason: collision with root package name */
    private final Matrix f33895g;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f33896h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f33897i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f33898j;

    /* renamed from: k, reason: collision with root package name */
    private final Rect f33899k;

    /* renamed from: l, reason: collision with root package name */
    private int f33900l;

    /* renamed from: m, reason: collision with root package name */
    private int f33901m;

    /* renamed from: n, reason: collision with root package name */
    private float f33902n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f33903o;

    /* renamed from: p, reason: collision with root package name */
    private float f33904p;

    /* renamed from: q, reason: collision with root package name */
    private int f33905q;

    /* renamed from: r, reason: collision with root package name */
    private y5 f33906r;

    /* renamed from: s, reason: collision with root package name */
    private float f33907s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f33908t;

    /* renamed from: u, reason: collision with root package name */
    private Bitmap f33909u;

    /* renamed from: v, reason: collision with root package name */
    private Bitmap f33910v;

    /* renamed from: w, reason: collision with root package name */
    private AnimatorSet f33911w;

    /* renamed from: x, reason: collision with root package name */
    private static final int[] f33886x = {13625597, 357325};

    /* renamed from: y, reason: collision with root package name */
    private static final Interpolator f33887y = new b1(0.4f, 0.0f, 0.4f, 1.0f);

    /* renamed from: z, reason: collision with root package name */
    private static final Interpolator f33888z = new b1(0.4f, 0.0f, 0.7f, 1.0f);
    private static final Interpolator A = new b1(0.25f, 0.0f, 0.4f, 1.0f);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) ScanDrawable.this.f33890b.getAnimatedValue()).floatValue();
            ScanDrawable scanDrawable = ScanDrawable.this;
            scanDrawable.f33905q = scanDrawable.f33899k.top + ((int) (ScanDrawable.this.f33899k.height() * ScanDrawable.f33887y.getInterpolation(floatValue)));
            if (floatValue < 0.389f) {
                ScanDrawable.this.f33904p = ScanDrawable.f33888z.getInterpolation(floatValue / 0.389f);
            } else {
                ScanDrawable.this.f33904p = 1.0f - ScanDrawable.A.getInterpolation((floatValue - 0.389f) / 0.611f);
            }
            ScanDrawable.this.invalidateSelf();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            ScanDrawable.this.f33903o = !r2.f33903o;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            float abs = Math.abs(((Float) ScanDrawable.this.f33890b.getAnimatedValue()).floatValue() - 0.5f);
            ScanDrawable.this.f33908t = !r1.f33908t;
            if (ScanDrawable.this.f33908t) {
                if (abs > 0.35f) {
                    ScanDrawable.this.f33902n = 0.0f;
                } else {
                    ScanDrawable.this.f33902n = n6.a(0.5f);
                }
            }
        }
    }

    public ScanDrawable() {
        this.f33889a = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f33890b = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f33891c = new Matrix();
        this.f33892d = new Paint();
        this.f33893e = new Paint();
        this.f33894f = new ColorMatrix();
        this.f33895g = new Matrix();
        this.f33896h = new Rect();
        this.f33897i = new Rect();
        this.f33898j = new Rect();
        this.f33899k = new Rect();
        this.f33902n = 0.5f;
        this.f33903o = false;
        this.f33904p = 0.0f;
        this.f33908t = true;
        this.f33911w = new AnimatorSet();
        d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private void d() {
        f();
        e();
        AnimatorSet animatorSet = new AnimatorSet();
        this.f33911w = animatorSet;
        animatorSet.playTogether(this.f33890b, this.f33889a);
    }

    private void e() {
        this.f33889a.setInterpolator(new LinearInterpolator());
        this.f33889a.setRepeatMode(2);
        this.f33889a.setRepeatCount(-1);
        this.f33889a.setDuration(500L);
        this.f33889a.setStartDelay(200L);
        this.f33889a.addListener(new c());
    }

    private void f() {
        this.f33890b.setDuration(2000L);
        this.f33890b.setInterpolator(new LinearInterpolator());
        this.f33890b.setRepeatCount(-1);
        this.f33890b.setRepeatMode(2);
        this.f33890b.addUpdateListener(new a());
        this.f33890b.addListener(new b());
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        if (resources == null || xmlPullParser == null || attributeSet == null) {
            return;
        }
        a(resources);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f33911w.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (rect == null) {
            return;
        }
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (isRunning() && canvas != null) {
            if (!this.f33903o) {
                int i6 = this.f33905q;
                this.f33897i.set(0, i6, getBounds().right, i6 - ((int) ((this.f33901m * this.f33904p) * 0.5f)));
                int i7 = this.f33905q;
                this.f33898j.set(0, i7, getBounds().right, i7 - ((int) (this.f33901m * this.f33904p)));
            } else {
                int i8 = this.f33905q;
                this.f33897i.set(0, i8, getBounds().right, ((int) (this.f33901m * this.f33904p * 0.5f)) + i8);
                int i9 = this.f33905q;
                this.f33898j.set(0, i9, getBounds().right, ((int) (this.f33901m * this.f33904p)) + i9);
            }
            a(canvas, this.f33898j);
            b(canvas);
            a(canvas);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (isRunning()) {
            return;
        }
        this.f33903o = false;
        this.f33908t = true;
        a(getBounds());
        this.f33911w.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (isRunning()) {
            this.f33911w.end();
            this.f33906r = null;
        }
    }

    private void b(Canvas canvas) {
        y5 y5Var = this.f33906r;
        if (y5Var == null) {
            return;
        }
        y5Var.a(canvas, this.f33897i);
    }

    private void a(Resources resources) {
        if (resources == null) {
            return;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_light);
        this.f33910v = Bitmap.createBitmap(decodeResource.getWidth() * 2, decodeResource.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(this.f33910v);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        paint.setShader(new BitmapShader(decodeResource, tileMode, tileMode));
        canvas.drawRect(0.0f, 0.0f, decodeResource.getWidth() * 2, decodeResource.getHeight() * 2, paint);
        this.f33909u = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_tail);
        this.f33907s = resources.getDisplayMetrics().density;
    }

    private void a(Rect rect) {
        if (rect.height() == 0) {
            return;
        }
        this.f33899k.set(rect);
        this.f33899k.inset(0, (int) (rect.height() * 0.1f));
        this.f33900l = (int) (rect.height() * 0.18f);
        this.f33901m = (int) (rect.height() * 0.36f);
        Rect rect2 = new Rect(rect);
        rect2.inset((int) (rect.width() * 0.2f), 0);
        float f6 = this.f33907s;
        int width = (int) ((f6 != 0.0f ? 0.001f / (f6 * f6) : 0.001f) * rect2.width() * rect2.height());
        this.f33906r = new y5(new b6(width, 500L).b(0.33f, 1.0f).a(0, -1, 0L, 100L, new LinearInterpolator()).a(-1, 0, 400L, 500L, new LinearInterpolator()), rect2, width, this.f33907s * 2.0f, f33886x);
    }

    public ScanDrawable(Resources resources) {
        this();
        a(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i6) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    private void a(Canvas canvas, Rect rect) {
        Bitmap bitmap = this.f33909u;
        if (bitmap == null || bitmap.getWidth() == 0 || this.f33909u.getHeight() == 0) {
            return;
        }
        this.f33891c.setScale(rect.width() / this.f33909u.getWidth(), rect.height() / this.f33909u.getHeight());
        this.f33891c.postTranslate(rect.left, rect.top);
        canvas.drawBitmap(this.f33909u, this.f33891c, this.f33892d);
        this.f33891c.reset();
    }

    private void a(Canvas canvas) {
        Bitmap bitmap = this.f33910v;
        if (bitmap == null || bitmap.getWidth() == 0 || this.f33910v.getHeight() == 0) {
            return;
        }
        float floatValue = (this.f33904p * 0.5f) + (((Float) this.f33889a.getAnimatedValue()).floatValue() * this.f33902n);
        float f6 = (1.5f - floatValue) * 0.05f;
        float f7 = f6 + 1.0f;
        this.f33894f.set(new float[]{1.0f, f6, f6, f6, 0.0f, f6, f7, f6, f6, 0.0f, f6, f6, f7, f6, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.f33893e.setColorFilter(new ColorMatrixColorFilter(this.f33894f));
        int i6 = (int) (this.f33900l * ((floatValue * 0.2f) + 0.4f));
        if (this.f33903o) {
            int i7 = this.f33905q;
            this.f33896h.set(0, i7 + i6, getBounds().right, i7 - i6);
        } else {
            int i8 = this.f33905q;
            this.f33896h.set(0, i8 - i6, getBounds().right, i8 + i6);
        }
        this.f33895g.setScale(this.f33896h.width() / this.f33910v.getWidth(), this.f33896h.height() / this.f33910v.getHeight());
        Matrix matrix = this.f33895g;
        Rect rect = this.f33896h;
        matrix.postTranslate(rect.left, rect.top);
        canvas.drawBitmap(this.f33910v, this.f33895g, this.f33893e);
        this.f33895g.reset();
    }
}
