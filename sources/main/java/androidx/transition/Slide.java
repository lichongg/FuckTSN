package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Slide extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    private CalculateSlide mSlideCalculator;
    private int mSlideEdge;
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    private static final CalculateSlide sCalculateLeft = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.1
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };
    private static final CalculateSlide sCalculateStart = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.2
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view) {
            if (ViewCompat.getLayoutDirection(viewGroup) == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };
    private static final CalculateSlide sCalculateTop = new CalculateSlideVertical() { // from class: androidx.transition.Slide.3
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    };
    private static final CalculateSlide sCalculateRight = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.4
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };
    private static final CalculateSlide sCalculateEnd = new CalculateSlideHorizontal() { // from class: androidx.transition.Slide.5
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view) {
            if (ViewCompat.getLayoutDirection(viewGroup) == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };
    private static final CalculateSlide sCalculateBottom = new CalculateSlideVertical() { // from class: androidx.transition.Slide.6
        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private interface CalculateSlide {
        float getGoneX(ViewGroup viewGroup, View view);

        float getGoneY(ViewGroup viewGroup, View view);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface GravityFlag {
    }

    public Slide() {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(80);
    }

    public void setSlideEdge(int i6) {
        if (i6 == 3) {
            this.mSlideCalculator = sCalculateLeft;
        } else if (i6 == 5) {
            this.mSlideCalculator = sCalculateRight;
        } else if (i6 == 48) {
            this.mSlideCalculator = sCalculateTop;
        } else if (i6 == 80) {
            this.mSlideCalculator = sCalculateBottom;
        } else if (i6 == 8388611) {
            this.mSlideCalculator = sCalculateStart;
        } else {
            if (i6 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.mSlideCalculator = sCalculateEnd;
        }
        this.mSlideEdge = i6;
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.setSide(i6);
        setPropagation(sidePropagation);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class CalculateSlideHorizontal implements CalculateSlide {
        private CalculateSlideHorizontal() {
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneY(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class CalculateSlideVertical implements CalculateSlide {
        private CalculateSlideVertical() {
        }

        @Override // androidx.transition.Slide.CalculateSlide
        public float getGoneX(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_POSITION, iArr);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get(PROPNAME_SCREEN_POSITION);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return TranslationAnimationCreator.createAnimation(view, transitionValues2, iArr[0], iArr[1], this.mSlideCalculator.getGoneX(viewGroup, view), this.mSlideCalculator.getGoneY(viewGroup, view), translationX, translationY, sDecelerate, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        return TranslationAnimationCreator.createAnimation(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.mSlideCalculator.getGoneX(viewGroup, view), this.mSlideCalculator.getGoneY(viewGroup, view), sAccelerate, this);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    public Slide(int i6) {
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        setSlideEdge(i6);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSlideCalculator = sCalculateBottom;
        this.mSlideEdge = 80;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.SLIDE);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        obtainStyledAttributes.recycle();
        setSlideEdge(namedInt);
    }
}
