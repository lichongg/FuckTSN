package xyz.adscope.ad;

import android.animation.Animator;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class r4 implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    private Animator f55927a;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NonNull Animator animator) {
        this.f55927a = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NonNull Animator animator) {
        Animator animator2 = this.f55927a;
        if (animator2 != null) {
            animator2.start();
        }
    }

    public r4(Animator animator) {
        this.f55927a = animator;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NonNull Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NonNull Animator animator) {
    }
}
