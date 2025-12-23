package com.bytedance.adsdk.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.r.f;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.IntRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl extends Drawable implements Animatable, Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f23516a;
    private boolean ae;
    private Map<String, Typeface> av;
    private com.bytedance.adsdk.lottie.xt.j az;

    /* renamed from: c, reason: collision with root package name */
    private Matrix f23517c;
    private mi ch;
    kt cw;
    private RectF ed;

    /* renamed from: f, reason: collision with root package name */
    private boolean f23518f;

    /* renamed from: g, reason: collision with root package name */
    private xt f23519g;
    private Paint gq;
    private Matrix gx;

    /* renamed from: h, reason: collision with root package name */
    private Rect f23520h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f23521i;

    /* renamed from: j, reason: collision with root package name */
    String f23522j;
    private String jy;
    private com.bytedance.adsdk.lottie.model.layer.r kt;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f23523l;
    private RectF la;

    /* renamed from: m, reason: collision with root package name */
    private boolean f23524m;
    private boolean mi;

    /* renamed from: n, reason: collision with root package name */
    private tj f23525n;
    private LottieAnimationView nd;
    private final ArrayList<j> oq;

    /* renamed from: p, reason: collision with root package name */
    private Canvas f23526p;
    private final ValueAnimator.AnimatorUpdateListener qv;

    /* renamed from: r, reason: collision with root package name */
    private m f23527r;
    private boolean rh;
    private Rect rn;

    /* renamed from: s, reason: collision with root package name */
    private boolean f23528s;
    private int tj;
    private boolean tl;
    private RectF uf;
    private final com.bytedance.adsdk.lottie.up.m up;

    /* renamed from: v, reason: collision with root package name */
    private boolean f23529v;
    private com.bytedance.adsdk.lottie.xt.xt vl;

    /* renamed from: w, reason: collision with root package name */
    private boolean f23530w;
    private Rect wq;
    private r ws;

    /* renamed from: x, reason: collision with root package name */
    private boolean f23531x;
    cw xt;

    private interface j {
        void j(m mVar);
    }

    private enum xt {
        NONE,
        PLAY,
        RESUME
    }

    public mi ae() {
        return this.f23528s ? mi.SOFTWARE : mi.HARDWARE;
    }

    public com.bytedance.adsdk.lottie.model.layer.r cw() {
        return this.kt;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean m() {
        return this.f23530w;
    }

    public boolean r() {
        return this.mi;
    }

    public boolean tl() {
        return this.f23528s;
    }

    public String up() {
        return this.jy;
    }

    private void ed() {
        if (this.f23526p != null) {
            return;
        }
        this.f23526p = new Canvas();
        this.ed = new RectF();
        this.f23517c = new Matrix();
        this.gx = new Matrix();
        this.f23520h = new Rect();
        this.la = new RectF();
        this.gq = new com.bytedance.adsdk.lottie.j.j();
        this.rn = new Rect();
        this.wq = new Rect();
        this.uf = new RectF();
    }

    private void gq() {
        m mVar = this.f23527r;
        if (mVar == null) {
            return;
        }
        this.f23528s = this.ch.j(Build.VERSION.SDK_INT, mVar.j(), mVar.xt());
    }

    private boolean rn() {
        return this.f23524m || this.ae;
    }

    private com.bytedance.adsdk.lottie.xt.xt wq() {
        com.bytedance.adsdk.lottie.xt.xt xtVar = this.vl;
        if (xtVar != null && !xtVar.j(getContext())) {
            this.vl = null;
        }
        if (this.vl == null) {
            this.vl = new com.bytedance.adsdk.lottie.xt.xt(getCallback(), this.jy, this.ws, this.f23527r.i());
        }
        return this.vl;
    }

    public m a() {
        return this.f23527r;
    }

    public void ae(boolean z5) {
        this.ae = z5;
    }

    public float av() {
        return this.up.av();
    }

    public float az() {
        return this.up.az();
    }

    public kt ch() {
        return this.cw;
    }

    public void cw(boolean z5) {
        this.f23518f = z5;
        m mVar = this.f23527r;
        if (mVar != null) {
            mVar.xt(z5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        up.j("Drawable#draw");
        try {
            if (this.f23528s) {
                j(canvas, this.kt);
            } else {
                j(canvas);
            }
        } catch (Throwable th) {
            com.bytedance.adsdk.lottie.up.up.xt("Lottie crashed in draw!", th);
        }
        this.rh = false;
        up.xt("Drawable#draw");
    }

    public int f() {
        return this.up.getRepeatCount();
    }

    public w g() {
        m mVar = this.f23527r;
        if (mVar != null) {
            return mVar.cw();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.tj;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        m mVar = this.f23527r;
        if (mVar == null) {
            return -1;
        }
        return mVar.r().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        m mVar = this.f23527r;
        if (mVar == null) {
            return -1;
        }
        return mVar.r().width();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float h() {
        return this.up.m();
    }

    public float i() {
        return this.up.oq();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.rh) {
            return;
        }
        this.rh = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void j(tj tjVar) {
        this.f23525n = tjVar;
    }

    @MainThread
    public void jy() {
        this.oq.clear();
        this.up.vl();
        if (isVisible()) {
            return;
        }
        this.f23519g = xt.NONE;
    }

    public int kt() {
        return (int) this.up.ae();
    }

    public void l() {
        this.oq.clear();
        this.up.cancel();
        if (isVisible()) {
            return;
        }
        this.f23519g = xt.NONE;
    }

    public RectF la() {
        return this.ed;
    }

    public void m(boolean z5) {
        this.tl = z5;
    }

    public void mi() {
        this.up.removeAllListeners();
    }

    public boolean oq() {
        return this.f23531x;
    }

    public void p() {
        this.oq.clear();
        this.up.jy();
        if (isVisible()) {
            return;
        }
        this.f23519g = xt.NONE;
    }

    public void qv() {
        if (this.up.isRunning()) {
            this.up.cancel();
            if (!isVisible()) {
                this.f23519g = xt.NONE;
            }
        }
        this.f23527r = null;
        com.bytedance.adsdk.lottie.model.layer.r rVar = this.kt;
        if (rVar != null) {
            j(rVar);
        }
        this.kt = null;
        this.vl = null;
        this.up.tl();
        invalidateSelf();
    }

    public void r(boolean z5) {
        if (this.f23529v == z5) {
            return;
        }
        this.f23529v = z5;
        com.bytedance.adsdk.lottie.model.layer.r rVar = this.kt;
        if (rVar != null) {
            rVar.j(z5);
        }
    }

    public boolean s() {
        return this.av == null && this.cw == null && this.f23527r.az().size() > 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i6) {
        this.tj = i6;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.bytedance.adsdk.lottie.up.up.xt("Use addColorFilter instead.");
    }

    @SuppressLint({"WrongConstant"})
    public int tj() {
        return this.up.getRepeatMode();
    }

    public void tl(boolean z5) {
        this.up.cw(z5);
    }

    public void up(boolean z5) {
        this.f23531x = z5;
    }

    public boolean v() {
        com.bytedance.adsdk.lottie.up.m mVar = this.up;
        if (mVar == null) {
            return false;
        }
        return mVar.isRunning();
    }

    @MainThread
    public void vl() {
        if (this.kt == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.6
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar) {
                    tl.this.vl();
                }
            });
            return;
        }
        gq();
        if (rn() || f() == 0) {
            if (isVisible()) {
                this.up.qv();
                this.f23519g = xt.NONE;
            } else {
                this.f23519g = xt.PLAY;
            }
        }
        if (rn()) {
            return;
        }
        cw((int) (i() < 0.0f ? az() : av()));
        this.up.vl();
        if (isVisible()) {
            return;
        }
        this.f23519g = xt.NONE;
    }

    public void w() {
        this.up.removeAllUpdateListeners();
        this.up.addUpdateListener(this.qv);
    }

    @MainThread
    public void ws() {
        if (this.kt == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.7
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar) {
                    tl.this.ws();
                }
            });
            return;
        }
        gq();
        if (rn() || f() == 0) {
            if (isVisible()) {
                this.up.ws();
                this.f23519g = xt.NONE;
            } else {
                this.f23519g = xt.RESUME;
            }
        }
        if (rn()) {
            return;
        }
        cw((int) (i() < 0.0f ? az() : av()));
        this.up.vl();
        if (isVisible()) {
            return;
        }
        this.f23519g = xt.NONE;
    }

    public LottieAnimationView xt() {
        return this.nd;
    }

    public tl(LottieAnimationView lottieAnimationView) {
        com.bytedance.adsdk.lottie.up.m mVar = new com.bytedance.adsdk.lottie.up.m();
        this.up = mVar;
        this.f23524m = true;
        this.ae = false;
        this.tl = false;
        this.f23519g = xt.NONE;
        this.oq = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.lottie.tl.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (tl.this.kt != null) {
                    tl.this.kt.j(tl.this.up.m());
                }
            }
        };
        this.qv = animatorUpdateListener;
        this.f23530w = false;
        this.mi = true;
        this.tj = 255;
        this.ch = mi.AUTOMATIC;
        this.f23528s = false;
        this.f23516a = new Matrix();
        this.rh = false;
        this.nd = lottieAnimationView;
        mVar.addUpdateListener(animatorUpdateListener);
    }

    private boolean c() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (!(parent instanceof ViewGroup) || ((ViewGroup) parent).getClipChildren()) {
            return false;
        }
        return true;
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback == null || !(callback instanceof View)) {
            return null;
        }
        return ((View) callback).getContext();
    }

    private com.bytedance.adsdk.lottie.xt.j uf() {
        if (getCallback() == null) {
            return null;
        }
        if (this.az == null) {
            com.bytedance.adsdk.lottie.xt.j jVar = new com.bytedance.adsdk.lottie.xt.j(getCallback(), this.xt);
            this.az = jVar;
            String str = this.f23522j;
            if (str != null) {
                jVar.j(str);
            }
        }
        return this.az;
    }

    public void ae(String str) {
        this.f23522j = str;
        com.bytedance.adsdk.lottie.xt.j uf = uf();
        if (uf != null) {
            uf.j(str);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return v();
    }

    public tj j() {
        return this.f23525n;
    }

    public g m(String str) {
        m mVar = this.f23527r;
        if (mVar == null) {
            return null;
        }
        return mVar.i().get(str);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j6) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j6);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z5, z6);
        if (z5) {
            xt xtVar = this.f23519g;
            if (xtVar == xt.PLAY) {
                vl();
                return visible;
            }
            if (xtVar == xt.RESUME) {
                ws();
                return visible;
            }
        } else {
            if (this.up.isRunning()) {
                p();
                this.f23519g = xt.RESUME;
                return visible;
            }
            if (isVisible) {
                this.f23519g = xt.NONE;
            }
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        vl();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        jy();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void up(int i6) {
        this.up.setRepeatCount(i6);
    }

    boolean x() {
        if (isVisible()) {
            return this.up.isRunning();
        }
        xt xtVar = this.f23519g;
        if (xtVar != xt.PLAY && xtVar != xt.RESUME) {
            return false;
        }
        return true;
    }

    public void xt(boolean z5) {
        this.f23530w = z5;
    }

    public void j(boolean z5, Context context) {
        if (this.f23521i == z5) {
            return;
        }
        this.f23521i = z5;
        if (this.f23527r != null) {
            j(context);
        }
    }

    public Bitmap up(String str) {
        com.bytedance.adsdk.lottie.xt.xt wq = wq();
        if (wq != null) {
            return wq.j(str);
        }
        return null;
    }

    public void xt(final int i6) {
        if (this.f23527r == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.10
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar) {
                    tl.this.xt(i6);
                }
            });
        } else {
            this.up.xt(i6 + 0.99f);
        }
    }

    public void cw(final String str) {
        m mVar = this.f23527r;
        if (mVar == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.13
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar2) {
                    tl.this.cw(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.m cw = mVar.cw(str);
        if (cw != null) {
            xt((int) (cw.f23437j + cw.xt));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void r(final String str) {
        m mVar = this.f23527r;
        if (mVar == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.2
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar2) {
                    tl.this.r(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.m cw = mVar.cw(str);
        if (cw != null) {
            int i6 = (int) cw.f23437j;
            j(i6, ((int) cw.xt) + i6);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public void xt(@FloatRange(from = 0.0d, to = 1.0d) final float f6) {
        m mVar = this.f23527r;
        if (mVar == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.11
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar2) {
                    tl.this.xt(f6);
                }
            });
        } else {
            this.up.xt(com.bytedance.adsdk.lottie.up.tl.j(mVar.m(), this.f23527r.ae(), f6));
        }
    }

    public void j(boolean z5) {
        if (z5 != this.mi) {
            this.mi = z5;
            com.bytedance.adsdk.lottie.model.layer.r rVar = this.kt;
            if (rVar != null) {
                rVar.xt(z5);
            }
            invalidateSelf();
        }
    }

    public void cw(float f6) {
        this.up.cw(f6);
    }

    public void xt(final String str) {
        m mVar = this.f23527r;
        if (mVar == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.12
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar2) {
                    tl.this.xt(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.lottie.model.m cw = mVar.cw(str);
        if (cw != null) {
            j((int) cw.f23437j);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void cw(final int i6) {
        if (this.f23527r == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.4
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar) {
                    tl.this.cw(i6);
                }
            });
        } else {
            this.up.j(i6);
        }
    }

    public void r(@FloatRange(from = 0.0d, to = 1.0d) final float f6) {
        if (this.f23527r == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.5
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar) {
                    tl.this.r(f6);
                }
            });
            return;
        }
        up.j("Drawable#setProgress");
        this.up.j(this.f23527r.j(f6));
        up.xt("Drawable#setProgress");
    }

    public void j(String str) {
        this.jy = str;
    }

    public boolean j(m mVar, Context context) {
        if (this.f23527r == mVar) {
            return false;
        }
        this.rh = true;
        qv();
        this.f23527r = mVar;
        j(context);
        this.up.j(mVar);
        r(this.up.getAnimatedFraction());
        Iterator it = new ArrayList(this.oq).iterator();
        while (it.hasNext()) {
            j jVar = (j) it.next();
            if (jVar != null) {
                jVar.j(mVar);
            }
            it.remove();
        }
        this.oq.clear();
        mVar.xt(this.f23518f);
        gq();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void xt(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.up.removeUpdateListener(animatorUpdateListener);
    }

    public void xt(Animator.AnimatorListener animatorListener) {
        this.up.removeListener(animatorListener);
    }

    private void xt(int i6, int i7) {
        Bitmap bitmap = this.f23523l;
        if (bitmap != null && bitmap.getWidth() >= i6 && this.f23523l.getHeight() >= i7) {
            if (this.f23523l.getWidth() > i6 || this.f23523l.getHeight() > i7) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f23523l, 0, 0, i6, i7);
                this.f23523l = createBitmap;
                this.f23526p.setBitmap(createBitmap);
                this.rh = true;
                return;
            }
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        this.f23523l = createBitmap2;
        this.f23526p.setBitmap(createBitmap2);
        this.rh = true;
    }

    public void r(int i6) {
        this.up.setRepeatMode(i6);
    }

    public void j(mi miVar) {
        this.ch = miVar;
        gq();
    }

    private void j(Context context) {
        m mVar = this.f23527r;
        if (mVar == null) {
            return;
        }
        com.bytedance.adsdk.lottie.model.layer.r rVar = this.kt;
        if (rVar != null) {
            j(rVar);
        }
        com.bytedance.adsdk.lottie.model.layer.r rVar2 = new com.bytedance.adsdk.lottie.model.layer.r(this, f.j(mVar), mVar.ws(), mVar, context);
        this.kt = rVar2;
        if (this.f23529v) {
            rVar2.j(true);
        }
        this.kt.xt(this.mi);
    }

    private void j(com.bytedance.adsdk.lottie.model.layer.r rVar) {
        if (rVar != null) {
            rVar.cw();
            List<com.bytedance.adsdk.lottie.model.layer.cw> ws = rVar.ws();
            if (ws != null) {
                for (com.bytedance.adsdk.lottie.model.layer.cw cwVar : ws) {
                    if (cwVar instanceof com.bytedance.adsdk.lottie.model.layer.r) {
                        j((com.bytedance.adsdk.lottie.model.layer.r) cwVar);
                    } else if (cwVar != null) {
                        cwVar.cw();
                    }
                }
            }
        }
    }

    public void j(final int i6) {
        if (this.f23527r == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.8
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar) {
                    tl.this.j(i6);
                }
            });
        } else {
            this.up.j(i6);
        }
    }

    public void j(final float f6) {
        m mVar = this.f23527r;
        if (mVar == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.9
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar2) {
                    tl.this.j(f6);
                }
            });
        } else {
            j((int) com.bytedance.adsdk.lottie.up.tl.j(mVar.m(), this.f23527r.ae(), f6));
        }
    }

    public void j(final int i6, final int i7) {
        if (this.f23527r == null) {
            this.oq.add(new j() { // from class: com.bytedance.adsdk.lottie.tl.3
                @Override // com.bytedance.adsdk.lottie.tl.j
                public void j(m mVar) {
                    tl.this.j(i6, i7);
                }
            });
        } else {
            this.up.j(i6, i7 + 0.99f);
        }
    }

    public void j(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.up.addUpdateListener(animatorUpdateListener);
    }

    public void j(Animator.AnimatorListener animatorListener) {
        this.up.addListener(animatorListener);
    }

    public void j(Boolean bool) {
        this.f23524m = bool.booleanValue();
    }

    public void j(r rVar) {
        this.ws = rVar;
        com.bytedance.adsdk.lottie.xt.xt xtVar = this.vl;
        if (xtVar != null) {
            xtVar.j(rVar);
        }
    }

    public void j(cw cwVar) {
        this.xt = cwVar;
        com.bytedance.adsdk.lottie.xt.j jVar = this.az;
        if (jVar != null) {
            jVar.j(cwVar);
        }
    }

    public void j(Map<String, Typeface> map) {
        if (map == this.av) {
            return;
        }
        this.av = map;
        invalidateSelf();
    }

    public void j(kt ktVar) {
        this.cw = ktVar;
    }

    public Bitmap j(String str, Bitmap bitmap) {
        com.bytedance.adsdk.lottie.xt.xt wq = wq();
        if (wq == null) {
            com.bytedance.adsdk.lottie.up.up.xt("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap j6 = wq.j(str, bitmap);
        invalidateSelf();
        return j6;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface j(com.bytedance.adsdk.lottie.model.cw cwVar) {
        Map<String, Typeface> map = this.av;
        if (map != null) {
            String j6 = cwVar.j();
            if (map.containsKey(j6)) {
                return map.get(j6);
            }
            String xt2 = cwVar.xt();
            if (map.containsKey(xt2)) {
                return map.get(xt2);
            }
            String str = cwVar.j() + "-" + cwVar.cw();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.lottie.xt.j uf = uf();
        if (uf != null) {
            return uf.j(cwVar);
        }
        return null;
    }

    private void j(Canvas canvas) {
        com.bytedance.adsdk.lottie.model.layer.r rVar = this.kt;
        m mVar = this.f23527r;
        if (rVar == null || mVar == null) {
            return;
        }
        this.f23516a.reset();
        if (!getBounds().isEmpty()) {
            this.f23516a.preScale(r2.width() / mVar.r().width(), r2.height() / mVar.r().height());
            this.f23516a.preTranslate(r2.left, r2.top);
        }
        rVar.j(canvas, this.f23516a, this.tj);
    }

    private void j(Canvas canvas, com.bytedance.adsdk.lottie.model.layer.r rVar) {
        if (this.f23527r == null || rVar == null) {
            return;
        }
        ed();
        canvas.getMatrix(this.f23517c);
        canvas.getClipBounds(this.f23520h);
        j(this.f23520h, this.la);
        this.f23517c.mapRect(this.la);
        j(this.la, this.f23520h);
        if (this.mi) {
            this.ed.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            rVar.j(this.ed, (Matrix) null, false);
        }
        this.f23517c.mapRect(this.ed);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        j(this.ed, width, height);
        if (!c()) {
            RectF rectF = this.ed;
            Rect rect = this.f23520h;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int ceil = (int) Math.ceil(this.ed.width());
        int ceil2 = (int) Math.ceil(this.ed.height());
        if (ceil == 0 || ceil2 == 0) {
            return;
        }
        xt(ceil, ceil2);
        if (this.rh) {
            this.f23516a.set(this.f23517c);
            this.f23516a.preScale(width, height);
            Matrix matrix = this.f23516a;
            RectF rectF2 = this.ed;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.f23523l.eraseColor(0);
            rVar.j(this.f23526p, this.f23516a, this.tj);
            this.f23517c.invert(this.gx);
            this.gx.mapRect(this.uf, this.ed);
            j(this.uf, this.wq);
        }
        this.rn.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.f23523l, this.rn, this.wq, this.gq);
    }

    private void j(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void j(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void j(RectF rectF, float f6, float f7) {
        rectF.set(rectF.left * f6, rectF.top * f7, rectF.right * f6, rectF.bottom * f7);
    }
}
