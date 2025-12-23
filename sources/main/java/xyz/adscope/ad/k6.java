package xyz.adscope.ad;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class k6 {

    /* renamed from: a, reason: collision with root package name */
    private final ValueAnimator f55340a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NonNull Animator animator) {
            k6.this.a(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NonNull Animator animator) {
            k6.this.b(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NonNull Animator animator) {
            k6.this.c(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NonNull Animator animator) {
            k6.this.d(animator);
        }
    }

    protected void a(Animator animator) {
    }

    protected void b(Animator animator) {
    }

    protected void c(Animator animator) {
    }

    protected void a(ValueAnimator valueAnimator) {
    }

    public void b() {
        ValueAnimator valueAnimator = this.f55340a;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f55340a.pause();
    }

    public void c() {
        ValueAnimator valueAnimator = this.f55340a;
        if (valueAnimator == null || valueAnimator.isRunning()) {
            return;
        }
        this.f55340a.start();
    }

    public k6(int i6, int i7, long j6) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i6, i7);
        this.f55340a = ofInt;
        ofInt.setDuration(j6);
        a();
    }

    private void a() {
        this.f55340a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.adscope.ad.k7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                k6.this.a(valueAnimator);
            }
        });
        this.f55340a.addListener(new a());
    }

    public void a(int i6, int i7) {
        ValueAnimator valueAnimator = this.f55340a;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(i6);
            this.f55340a.setRepeatMode(i7);
        }
    }

    protected void d(Animator animator) {
    }
}
