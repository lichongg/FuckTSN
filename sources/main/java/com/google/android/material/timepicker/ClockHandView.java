package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class ClockHandView extends View {
    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private boolean animatingOnTouchUp;
    private final int animationDuration;
    private final TimeInterpolator animationInterpolator;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private int currentLevel;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private boolean isMultiLevel;
    private final List<OnRotateListener> listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private final ValueAnimator rotationAnimator;
    private final int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;

    @Px
    private final int selectorStrokeWidth;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnActionUpListener {
        void onActionUp(@FloatRange(from = 0.0d, to = 360.0d) float f6, boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnRotateListener {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float f6, boolean z5);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    @Dimension
    private int getLeveledCircleRadius(int i6) {
        return i6 == 2 ? Math.round(this.circleRadius * 0.66f) : this.circleRadius;
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float f6) {
        setHandRotation(f6, false);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    private void setHandRotationInternal(@FloatRange(from = 0.0d, to = 360.0d) float f6, boolean z5) {
        float f7 = f6 % 360.0f;
        this.originalDeg = f7;
        this.degRad = Math.toRadians(f7 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float leveledCircleRadius = getLeveledCircleRadius(this.currentLevel);
        float cos = width + (((float) Math.cos(this.degRad)) * leveledCircleRadius);
        float sin = height + (leveledCircleRadius * ((float) Math.sin(this.degRad)));
        RectF rectF = this.selectorBox;
        int i6 = this.selectorRadius;
        rectF.set(cos - i6, sin - i6, cos + i6, sin + i6);
        Iterator<OnRotateListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onRotate(f7, z5);
        }
        invalidate();
    }

    public void addOnRotateListener(OnRotateListener onRotateListener) {
        this.listeners.add(onRotateListener);
    }

    int getCurrentLevel() {
        return this.currentLevel;
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    @FloatRange(from = 0.0d, to = VirtualEarthProjection.MAX_LONGITUDE)
    public float getHandRotation() {
        return this.originalDeg;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    public void setAnimateOnTouchUp(boolean z5) {
        this.animatingOnTouchUp = z5;
    }

    public void setCircleRadius(@Dimension int i6) {
        this.circleRadius = i6;
        invalidate();
    }

    void setCurrentLevel(int i6) {
        this.currentLevel = i6;
        invalidate();
    }

    public void setHandRotation(@FloatRange(from = 0.0d, to = 360.0d) float f6, boolean z5) {
        ValueAnimator valueAnimator = this.rotationAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z5) {
            setHandRotationInternal(f6, false);
            return;
        }
        Pair<Float, Float> valuesForAnimation = getValuesForAnimation(f6);
        this.rotationAnimator.setFloatValues(((Float) valuesForAnimation.first).floatValue(), ((Float) valuesForAnimation.second).floatValue());
        this.rotationAnimator.setDuration(this.animationDuration);
        this.rotationAnimator.setInterpolator(this.animationInterpolator);
        this.rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ClockHandView.a(ClockHandView.this, valueAnimator2);
            }
        });
        this.rotationAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.timepicker.ClockHandView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.rotationAnimator.start();
    }

    void setMultiLevel(boolean z5) {
        if (this.isMultiLevel && !z5) {
            this.currentLevel = 1;
        }
        this.isMultiLevel = z5;
        invalidate();
    }

    public void setOnActionUpListener(OnActionUpListener onActionUpListener) {
        this.onActionUpListener = onActionUpListener;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.rotationAnimator = new ValueAnimator();
        this.listeners = new ArrayList();
        Paint paint = new Paint();
        this.paint = paint;
        this.selectorBox = new RectF();
        this.currentLevel = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i6, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.animationDuration = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationLong2, 200);
        this.animationInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        this.selectorStrokeWidth = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = r7.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void a(ClockHandView clockHandView, ValueAnimator valueAnimator) {
        clockHandView.getClass();
        clockHandView.setHandRotationInternal(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void adjustLevel(float f6, float f7) {
        int i6 = 2;
        if (MathUtils.dist(getWidth() / 2, getHeight() / 2, f6, f7) > getLeveledCircleRadius(2) + ViewUtils.dpToPx(getContext(), 12)) {
            i6 = 1;
        }
        this.currentLevel = i6;
    }

    private void drawSelector(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f6 = width;
        float leveledCircleRadius = getLeveledCircleRadius(this.currentLevel);
        float cos = (((float) Math.cos(this.degRad)) * leveledCircleRadius) + f6;
        float f7 = height;
        float sin = (leveledCircleRadius * ((float) Math.sin(this.degRad))) + f7;
        this.paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.selectorRadius, this.paint);
        double sin2 = Math.sin(this.degRad);
        double cos2 = Math.cos(this.degRad);
        this.paint.setStrokeWidth(this.selectorStrokeWidth);
        canvas.drawLine(f6, f7, width + ((int) (cos2 * r2)), height + ((int) (r2 * sin2)), this.paint);
        canvas.drawCircle(f6, f7, this.centerDotRadius, this.paint);
    }

    private int getDegreesFromXY(float f6, float f7) {
        int degrees = (int) Math.toDegrees(Math.atan2(f7 - (getHeight() / 2), f6 - (getWidth() / 2)));
        int i6 = degrees + 90;
        if (i6 < 0) {
            return degrees + 450;
        }
        return i6;
    }

    private Pair<Float, Float> getValuesForAnimation(float f6) {
        float handRotation = getHandRotation();
        if (Math.abs(handRotation - f6) > 180.0f) {
            if (handRotation > 180.0f && f6 < 180.0f) {
                f6 += 360.0f;
            }
            if (handRotation < 180.0f && f6 > 180.0f) {
                handRotation += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(handRotation), Float.valueOf(f6));
    }

    private boolean handleTouchInput(float f6, float f7, boolean z5, boolean z6, boolean z7) {
        boolean z8;
        float degreesFromXY = getDegreesFromXY(f6, f7);
        boolean z9 = false;
        if (getHandRotation() != degreesFromXY) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z6 && z8) {
            return true;
        }
        if (!z8 && !z5) {
            return false;
        }
        if (z7 && this.animatingOnTouchUp) {
            z9 = true;
        }
        setHandRotation(degreesFromXY, z9);
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSelector(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (!this.rotationAnimator.isRunning()) {
            setHandRotation(getHandRotation());
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean handleTouchInput;
        OnActionUpListener onActionUpListener;
        boolean z8;
        boolean z9;
        int actionMasked = motionEvent.getActionMasked();
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z5 = false;
                z6 = false;
            } else {
                int i6 = (int) (x5 - this.downX);
                int i7 = (int) (y5 - this.downY);
                if ((i6 * i6) + (i7 * i7) > this.scaledTouchSlop) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                this.isInTapRegion = z8;
                z5 = this.changedDuringTouch;
                if (actionMasked == 1) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (this.isMultiLevel) {
                    adjustLevel(x5, y5);
                }
                z7 = z9;
                z6 = false;
                handleTouchInput = this.changedDuringTouch | handleTouchInput(x5, y5, z5, z6, z7);
                this.changedDuringTouch = handleTouchInput;
                if (handleTouchInput && z7 && (onActionUpListener = this.onActionUpListener) != null) {
                    onActionUpListener.onActionUp(getDegreesFromXY(x5, y5), this.isInTapRegion);
                }
                return true;
            }
        } else {
            this.downX = x5;
            this.downY = y5;
            this.isInTapRegion = true;
            this.changedDuringTouch = false;
            z5 = false;
            z6 = true;
        }
        z7 = false;
        handleTouchInput = this.changedDuringTouch | handleTouchInput(x5, y5, z5, z6, z7);
        this.changedDuringTouch = handleTouchInput;
        if (handleTouchInput) {
            onActionUpListener.onActionUp(getDegreesFromXY(x5, y5), this.isInTapRegion);
        }
        return true;
    }
}
