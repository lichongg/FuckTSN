package cn.jpush.android.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import cn.jpush.android.helper.Logger;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private int f3782a;

    /* renamed from: b, reason: collision with root package name */
    private int f3783b;

    /* renamed from: c, reason: collision with root package name */
    private int f3784c;

    /* renamed from: d, reason: collision with root package name */
    private long f3785d;

    /* renamed from: e, reason: collision with root package name */
    private View f3786e;

    /* renamed from: f, reason: collision with root package name */
    private a f3787f;

    /* renamed from: g, reason: collision with root package name */
    private int f3788g = 1;

    /* renamed from: h, reason: collision with root package name */
    private int f3789h = 1;

    /* renamed from: i, reason: collision with root package name */
    private float f3790i;

    /* renamed from: j, reason: collision with root package name */
    private float f3791j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3792k;

    /* renamed from: l, reason: collision with root package name */
    private int f3793l;

    /* renamed from: m, reason: collision with root package name */
    private Object f3794m;

    /* renamed from: n, reason: collision with root package name */
    private VelocityTracker f3795n;

    /* renamed from: o, reason: collision with root package name */
    private float f3796o;

    /* renamed from: p, reason: collision with root package name */
    private float f3797p;

    /* renamed from: q, reason: collision with root package name */
    private int f3798q;

    public interface a {
        void a(View view, Object obj);

        boolean a(Object obj);
    }

    protected float a() {
        return this.f3786e.getTranslationY();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked;
        boolean z5;
        VelocityTracker velocityTracker;
        try {
            motionEvent.offsetLocation(0.0f, this.f3797p);
            if (this.f3789h < 2) {
                this.f3789h = this.f3786e.getHeight();
            }
            actionMasked = motionEvent.getActionMasked();
        } catch (Throwable th) {
            Logger.w("InAppSWTouchListener", "onTouch error." + th.getMessage());
        }
        if (actionMasked == 0) {
            this.f3790i = motionEvent.getRawX();
            this.f3791j = motionEvent.getRawY();
            a aVar = this.f3787f;
            if (aVar != null && aVar.a(this.f3794m)) {
                VelocityTracker obtain = VelocityTracker.obtain();
                this.f3795n = obtain;
                obtain.addMovement(motionEvent);
            }
            return false;
        }
        boolean z6 = true;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker2 = this.f3795n;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.f3790i;
                    float rawY = motionEvent.getRawY() - this.f3791j;
                    if (Math.abs(rawY) > this.f3782a && Math.abs(rawX) < Math.abs(rawY) / 2.0f) {
                        int i6 = this.f3798q;
                        if (i6 == 0) {
                            if (rawY > 0.0f) {
                            }
                        } else if (i6 == 1 && rawY < 0.0f) {
                        }
                        this.f3792k = true;
                        this.f3793l = rawY > 0.0f ? this.f3782a : -this.f3782a;
                        this.f3786e.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f3786e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.f3792k) {
                        this.f3797p = rawY;
                        a(rawY - this.f3793l);
                        b(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawY) * 2.0f) / this.f3789h))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && (velocityTracker = this.f3795n) != null) {
                velocityTracker.recycle();
                this.f3795n = null;
                this.f3796o = 0.0f;
                this.f3797p = 0.0f;
                this.f3790i = 0.0f;
            }
            return false;
        }
        if (this.f3795n == null) {
            return false;
        }
        float rawY2 = motionEvent.getRawY() - this.f3790i;
        this.f3795n.addMovement(motionEvent);
        this.f3795n.computeCurrentVelocity(1000);
        if (Math.abs(rawY2) <= this.f3789h / 2 || !this.f3792k) {
            z5 = false;
            z6 = false;
        } else {
            z5 = rawY2 < 0.0f;
        }
        if (z6) {
            a(z5);
        } else if (this.f3792k) {
            b();
        }
        VelocityTracker velocityTracker3 = this.f3795n;
        if (velocityTracker3 != null) {
            velocityTracker3.recycle();
        }
        this.f3795n = null;
        this.f3796o = 0.0f;
        this.f3797p = 0.0f;
        this.f3790i = 0.0f;
        this.f3791j = 0.0f;
        this.f3792k = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            View view = this.f3786e;
            if (view != null) {
                final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                this.f3786e.getHeight();
                final int width = this.f3786e.getWidth();
                ValueAnimator duration = ValueAnimator.ofInt(width, 1).setDuration(this.f3785d);
                duration.addListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.s.b.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Logger.d("InAppSWTouchListener", "[onAnimationEnd] ...");
                        if (b.this.f3787f != null) {
                            b.this.f3787f.a(b.this.f3786e, b.this.f3794m);
                        }
                        b.this.f3786e.setAlpha(1.0f);
                        b.this.f3786e.setTranslationY(0.0f);
                        layoutParams.width = width;
                        b.this.f3786e.setLayoutParams(layoutParams);
                    }
                });
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.s.b.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        b.this.f3786e.setLayoutParams(layoutParams);
                    }
                });
                duration.start();
            }
        } catch (Throwable th) {
            Logger.w("InAppSWTouchListener", "[performDismiss] failed." + th.getMessage());
        }
    }

    protected void a(float f6) {
        this.f3786e.setTranslationY(f6);
    }

    protected void b() {
        a(0.0f, 1.0f, null);
    }

    public b(cn.jpush.android.u.b bVar, Object obj, int i6, a aVar) {
        View e6 = bVar.e();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(e6.getContext());
        this.f3782a = viewConfiguration.getScaledTouchSlop();
        this.f3783b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f3784c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3785d = 500L;
        this.f3786e = e6;
        this.f3798q = i6;
        this.f3794m = obj;
        this.f3787f = aVar;
    }

    private void a(float f6, float f7, AnimatorListenerAdapter animatorListenerAdapter) {
        try {
            final float a6 = a();
            final float f8 = f6 - a6;
            final float alpha = this.f3786e.getAlpha();
            final float f9 = f7 - alpha;
            Logger.i("InAppSWTouchListener", "animateTo, beginTranslation: " + a6 + ", translationDiff: " + f8 + ", beginAlpha: , alphaDiff: " + f9);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            if (ofFloat != null) {
                ofFloat.setDuration(this.f3785d);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.s.b.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = a6 + (valueAnimator.getAnimatedFraction() * f8);
                        float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f9);
                        b.this.a(animatedFraction);
                        b.this.b(animatedFraction2);
                    }
                });
                if (animatorListenerAdapter != null) {
                    ofFloat.addListener(animatorListenerAdapter);
                }
                ofFloat.start();
            }
        } catch (Throwable th) {
            Logger.w("InAppSWTouchListener", "[animateTo] failed" + th.getMessage());
        }
    }

    protected void b(float f6) {
        this.f3786e.setAlpha(f6);
    }

    protected void a(boolean z5) {
        int i6 = this.f3789h;
        if (z5) {
            i6 = -i6;
        }
        Logger.d("InAppSWTouchListener", "[startDismissAnimationY] dismissTop: " + z5 + ", viewHeight: " + this.f3789h);
        a((float) i6, 0.0f, new AnimatorListenerAdapter() { // from class: cn.jpush.android.s.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.c();
            }
        });
    }
}
