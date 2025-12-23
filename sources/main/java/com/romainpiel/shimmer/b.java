package com.romainpiel.shimmer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.romainpiel.shimmer.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public static final int f36818g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static final int f36819h = 1;

    /* renamed from: i, reason: collision with root package name */
    private static final int f36820i = -1;

    /* renamed from: j, reason: collision with root package name */
    private static final long f36821j = 1000;

    /* renamed from: k, reason: collision with root package name */
    private static final long f36822k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static final int f36823l = 0;

    /* renamed from: a, reason: collision with root package name */
    private int f36824a = -1;

    /* renamed from: b, reason: collision with root package name */
    private long f36825b = 1000;

    /* renamed from: c, reason: collision with root package name */
    private long f36826c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f36827d = 0;

    /* renamed from: e, reason: collision with root package name */
    private Animator.AnimatorListener f36828e;

    /* renamed from: f, reason: collision with root package name */
    private ObjectAnimator f36829f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f36830a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.romainpiel.shimmer.b$a$a, reason: collision with other inner class name */
        class C0722a implements Animator.AnimatorListener {
            C0722a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ((c) a.this.f36830a).setShimmering(false);
                a.this.f36830a.postInvalidateOnAnimation();
                b.this.f36829f = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        a(View view) {
            this.f36830a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((c) this.f36830a).setShimmering(true);
            float width = this.f36830a.getWidth();
            float f6 = 0.0f;
            if (b.this.f36827d == 1) {
                f6 = this.f36830a.getWidth();
                width = 0.0f;
            }
            b.this.f36829f = ObjectAnimator.ofFloat(this.f36830a, "gradientX", f6, width);
            b.this.f36829f.setRepeatCount(b.this.f36824a);
            b.this.f36829f.setDuration(b.this.f36825b);
            b.this.f36829f.setStartDelay(b.this.f36826c);
            b.this.f36829f.addListener(new C0722a());
            if (b.this.f36828e != null) {
                b.this.f36829f.addListener(b.this.f36828e);
            }
            b.this.f36829f.start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.romainpiel.shimmer.b$b, reason: collision with other inner class name */
    class C0723b implements d.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f36833a;

        C0723b(Runnable runnable) {
            this.f36833a = runnable;
        }

        @Override // com.romainpiel.shimmer.d.a
        public void a(View view) {
            this.f36833a.run();
        }
    }

    public void h() {
        ObjectAnimator objectAnimator = this.f36829f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public Animator.AnimatorListener i() {
        return this.f36828e;
    }

    public int j() {
        return this.f36827d;
    }

    public long k() {
        return this.f36825b;
    }

    public int l() {
        return this.f36824a;
    }

    public long m() {
        return this.f36826c;
    }

    public boolean n() {
        ObjectAnimator objectAnimator = this.f36829f;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public b o(Animator.AnimatorListener animatorListener) {
        this.f36828e = animatorListener;
        return this;
    }

    public b p(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("The animation direction must be either ANIMATION_DIRECTION_LTR or ANIMATION_DIRECTION_RTL");
        }
        this.f36827d = i6;
        return this;
    }

    public b q(long j6) {
        this.f36825b = j6;
        return this;
    }

    public b r(int i6) {
        this.f36824a = i6;
        return this;
    }

    public b s(long j6) {
        this.f36826c = j6;
        return this;
    }

    public <V extends View & c> void t(V v5) {
        if (n()) {
            return;
        }
        a aVar = new a(v5);
        V v6 = v5;
        if (!v6.a()) {
            v6.setAnimationSetupCallback(new C0723b(aVar));
        } else {
            aVar.run();
        }
    }
}
