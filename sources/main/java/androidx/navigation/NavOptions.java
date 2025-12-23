package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class NavOptions {

    @AnimRes
    @AnimatorRes
    private int mEnterAnim;

    @AnimRes
    @AnimatorRes
    private int mExitAnim;

    @AnimRes
    @AnimatorRes
    private int mPopEnterAnim;

    @AnimRes
    @AnimatorRes
    private int mPopExitAnim;

    @IdRes
    private int mPopUpTo;
    private boolean mPopUpToInclusive;
    private boolean mSingleTop;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Builder {
        boolean mPopUpToInclusive;
        boolean mSingleTop;

        @IdRes
        int mPopUpTo = -1;

        @AnimRes
        @AnimatorRes
        int mEnterAnim = -1;

        @AnimRes
        @AnimatorRes
        int mExitAnim = -1;

        @AnimRes
        @AnimatorRes
        int mPopEnterAnim = -1;

        @AnimRes
        @AnimatorRes
        int mPopExitAnim = -1;

        @NonNull
        public NavOptions build() {
            return new NavOptions(this.mSingleTop, this.mPopUpTo, this.mPopUpToInclusive, this.mEnterAnim, this.mExitAnim, this.mPopEnterAnim, this.mPopExitAnim);
        }

        @NonNull
        public Builder setEnterAnim(@AnimRes @AnimatorRes int i6) {
            this.mEnterAnim = i6;
            return this;
        }

        @NonNull
        public Builder setExitAnim(@AnimRes @AnimatorRes int i6) {
            this.mExitAnim = i6;
            return this;
        }

        @NonNull
        public Builder setLaunchSingleTop(boolean z5) {
            this.mSingleTop = z5;
            return this;
        }

        @NonNull
        public Builder setPopEnterAnim(@AnimRes @AnimatorRes int i6) {
            this.mPopEnterAnim = i6;
            return this;
        }

        @NonNull
        public Builder setPopExitAnim(@AnimRes @AnimatorRes int i6) {
            this.mPopExitAnim = i6;
            return this;
        }

        @NonNull
        public Builder setPopUpTo(@IdRes int i6, boolean z5) {
            this.mPopUpTo = i6;
            this.mPopUpToInclusive = z5;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && NavOptions.class == obj.getClass()) {
            NavOptions navOptions = (NavOptions) obj;
            if (this.mSingleTop == navOptions.mSingleTop && this.mPopUpTo == navOptions.mPopUpTo && this.mPopUpToInclusive == navOptions.mPopUpToInclusive && this.mEnterAnim == navOptions.mEnterAnim && this.mExitAnim == navOptions.mExitAnim && this.mPopEnterAnim == navOptions.mPopEnterAnim && this.mPopExitAnim == navOptions.mPopExitAnim) {
                return true;
            }
        }
        return false;
    }

    @AnimRes
    @AnimatorRes
    public int getEnterAnim() {
        return this.mEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getExitAnim() {
        return this.mExitAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getPopEnterAnim() {
        return this.mPopEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getPopExitAnim() {
        return this.mPopExitAnim;
    }

    @IdRes
    public int getPopUpTo() {
        return this.mPopUpTo;
    }

    public boolean isPopUpToInclusive() {
        return this.mPopUpToInclusive;
    }

    public boolean shouldLaunchSingleTop() {
        return this.mSingleTop;
    }

    NavOptions(boolean z5, @IdRes int i6, boolean z6, @AnimRes @AnimatorRes int i7, @AnimRes @AnimatorRes int i8, @AnimRes @AnimatorRes int i9, @AnimRes @AnimatorRes int i10) {
        this.mSingleTop = z5;
        this.mPopUpTo = i6;
        this.mPopUpToInclusive = z6;
        this.mEnterAnim = i7;
        this.mExitAnim = i8;
        this.mPopEnterAnim = i9;
        this.mPopExitAnim = i10;
    }

    public int hashCode() {
        return ((((((((((((shouldLaunchSingleTop() ? 1 : 0) * 31) + getPopUpTo()) * 31) + (isPopUpToInclusive() ? 1 : 0)) * 31) + getEnterAnim()) * 31) + getExitAnim()) * 31) + getPopEnterAnim()) * 31) + getPopExitAnim();
    }
}
