package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes5.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;

    @Px
    private int slideDistance = -1;
    private int slideEdge;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface GravityFlag {
    }

    private static Animator createTranslationXAnimator(final View view, float f6, float f7, final float f8) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f6, f7));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.platform.SlideDistanceProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f8);
            }
        });
        return ofPropertyValuesHolder;
    }

    private static Animator createTranslationYAnimator(final View view, float f6, float f7, final float f8) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f6, f7));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.platform.SlideDistanceProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f8);
            }
        });
        return ofPropertyValuesHolder;
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i6 = this.slideDistance;
        return i6 != -1 ? i6 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.slideDistance;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideDistance(@Px int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = i6;
    }

    public void setSlideEdge(int i6) {
        this.slideEdge = i6;
    }

    public SlideDistanceProvider(int i6) {
        this.slideEdge = i6;
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i6, @Px int i7) {
        float f6;
        float f7;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i6 != 3) {
            if (i6 != 5) {
                if (i6 != 48) {
                    if (i6 != 80) {
                        if (i6 != 8388611) {
                            if (i6 == 8388613) {
                                if (isRtl(view)) {
                                    f7 = translationX - i7;
                                } else {
                                    f7 = i7 + translationX;
                                }
                                return createTranslationXAnimator(view2, f7, translationX, translationX);
                            }
                            throw new IllegalArgumentException("Invalid slide direction: " + i6);
                        }
                        if (isRtl(view)) {
                            f6 = i7 + translationX;
                        } else {
                            f6 = translationX - i7;
                        }
                        return createTranslationXAnimator(view2, f6, translationX, translationX);
                    }
                    return createTranslationYAnimator(view2, i7 + translationY, translationY, translationY);
                }
                return createTranslationYAnimator(view2, translationY - i7, translationY, translationY);
            }
            return createTranslationXAnimator(view2, translationX - i7, translationX, translationX);
        }
        return createTranslationXAnimator(view2, i7 + translationX, translationX, translationX);
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i6, @Px int i7) {
        float f6;
        float f7;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i6 != 3) {
            if (i6 != 5) {
                if (i6 != 48) {
                    if (i6 != 80) {
                        if (i6 != 8388611) {
                            if (i6 == 8388613) {
                                if (isRtl(view)) {
                                    f7 = i7 + translationX;
                                } else {
                                    f7 = translationX - i7;
                                }
                                return createTranslationXAnimator(view2, translationX, f7, translationX);
                            }
                            throw new IllegalArgumentException("Invalid slide direction: " + i6);
                        }
                        if (isRtl(view)) {
                            f6 = translationX - i7;
                        } else {
                            f6 = i7 + translationX;
                        }
                        return createTranslationXAnimator(view2, translationX, f6, translationX);
                    }
                    return createTranslationYAnimator(view2, translationY, translationY - i7, translationY);
                }
                return createTranslationYAnimator(view2, translationY, i7 + translationY, translationY);
            }
            return createTranslationXAnimator(view2, translationX, i7 + translationX, translationX);
        }
        return createTranslationXAnimator(view2, translationX, translationX - i7, translationX);
    }

    private static boolean isRtl(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }
}
