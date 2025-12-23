package com.acse.ottn;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import com.acse.ottn.i;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s4 extends q4 {

    /* renamed from: c, reason: collision with root package name */
    public static final long f5100c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<ViewPropertyAnimator> f5101b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i.a f5102a;

        public a(i.a aVar) {
            this.f5102a = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5102a.d(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5102a.b(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            this.f5102a.c(null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f5102a.a(null);
        }
    }

    @Override // com.acse.ottn.q4
    public q4 a(long j6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public long b() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getDuration();
        }
        return -1L;
    }

    @Override // com.acse.ottn.q4
    public long c() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            return viewPropertyAnimator.getStartDelay();
        }
        return -1L;
    }

    @Override // com.acse.ottn.q4
    public void d() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.start();
        }
    }

    @Override // com.acse.ottn.q4
    public q4 e(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationX(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 f(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationXBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 g(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationY(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 h(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationYBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 i(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleX(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 j(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleXBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 k(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleY(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 l(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.scaleYBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 m(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 n(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationXBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 o(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationY(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 p(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationYBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 q(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.x(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 r(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.xBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 s(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.y(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 t(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.yBy(f6);
        }
        return this;
    }

    public s4(View view) {
        this.f5101b = new WeakReference<>(view.animate());
    }

    @Override // com.acse.ottn.q4
    public q4 a(Interpolator interpolator) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setInterpolator(interpolator);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 b(long j6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setStartDelay(j6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 c(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotation(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 d(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.rotationBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 a(i.a aVar) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            if (aVar == null) {
                viewPropertyAnimator.setListener(null);
                return this;
            }
            viewPropertyAnimator.setListener(new a(aVar));
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public q4 b(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alphaBy(f6);
        }
        return this;
    }

    @Override // com.acse.ottn.q4
    public void a() {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // com.acse.ottn.q4
    public q4 a(float f6) {
        ViewPropertyAnimator viewPropertyAnimator = this.f5101b.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(f6);
        }
        return this;
    }
}
