package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.math.MathUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = new CircularRevealEvaluator();
        private final RevealInfo revealInfo = new RevealInfo((AnonymousClass1) null);

        @Override // android.animation.TypeEvaluator
        @NonNull
        public RevealInfo evaluate(float f6, @NonNull RevealInfo revealInfo, @NonNull RevealInfo revealInfo2) {
            this.revealInfo.set(MathUtils.lerp(revealInfo.centerX, revealInfo2.centerX, f6), MathUtils.lerp(revealInfo.centerY, revealInfo2.centerY, f6), MathUtils.lerp(revealInfo.radius, revealInfo2.radius, f6));
            return this.revealInfo;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");

        private CircularRevealProperty(String str) {
            super(RevealInfo.class, str);
        }

        @Override // android.util.Property
        @Nullable
        public RevealInfo get(@NonNull CircularRevealWidget circularRevealWidget) {
            return circularRevealWidget.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(@NonNull CircularRevealWidget circularRevealWidget, @Nullable RevealInfo revealInfo) {
            circularRevealWidget.setRevealInfo(revealInfo);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");

        private CircularRevealScrimColorProperty(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        public Integer get(@NonNull CircularRevealWidget circularRevealWidget) {
            return Integer.valueOf(circularRevealWidget.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(@NonNull CircularRevealWidget circularRevealWidget, @NonNull Integer num) {
            circularRevealWidget.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        /* synthetic */ RevealInfo(AnonymousClass1 anonymousClass1) {
            this();
        }

        public void set(float f6, float f7, float f8) {
            this.centerX = f6;
            this.centerY = f7;
            this.radius = f8;
        }

        private RevealInfo() {
        }

        public boolean isInvalid() {
            return this.radius == Float.MAX_VALUE;
        }

        public RevealInfo(float f6, float f7, float f8) {
            this.centerX = f6;
            this.centerY = f7;
            this.radius = f8;
        }

        public void set(@NonNull RevealInfo revealInfo) {
            set(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }

        public RevealInfo(@NonNull RevealInfo revealInfo) {
            this(revealInfo.centerX, revealInfo.centerY, revealInfo.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas canvas);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i6);

    void setRevealInfo(@Nullable RevealInfo revealInfo);
}
