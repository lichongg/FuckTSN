package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    private static final int DEFAULT_LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final int DEFAULT_LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;

    @Dimension
    private static final int MIN_TOUCH_TARGET_DP = 48;
    private static final String TAG = "BaseSlider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;

    @NonNull
    private final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;

    @NonNull
    private final Paint activeTicksPaint;

    @NonNull
    private final Paint activeTrackPaint;

    @NonNull
    private final List<L> changeListeners;

    @Nullable
    private Drawable customThumbDrawable;

    @NonNull
    private List<Drawable> customThumbDrawablesForValues;

    @NonNull
    private final MaterialShapeDrawable defaultThumbDrawable;
    private int defaultThumbRadius;
    private int defaultTickActiveRadius;
    private int defaultTickInactiveRadius;
    private int defaultTrackHeight;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;

    @NonNull
    private ColorStateList haloColor;

    @NonNull
    private final Paint haloPaint;
    private int haloRadius;

    @NonNull
    private final Paint inactiveTicksPaint;

    @NonNull
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private int labelPadding;
    private int labelStyle;

    @NonNull
    private final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;

    @Dimension(unit = 1)
    private int minTouchTargetSize;
    private int minTrackSidePadding;
    private int minWidgetHeight;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;
    private boolean thumbIsPressed;

    @NonNull
    private final Paint thumbPaint;
    private int thumbRadius;
    private int tickActiveRadius;

    @NonNull
    private ColorStateList tickColorActive;

    @NonNull
    private ColorStateList tickColorInactive;
    private int tickInactiveRadius;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;

    @NonNull
    private final List<T> touchListeners;
    private float touchPosition;

    @NonNull
    private ColorStateList trackColorActive;

    @NonNull
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;
    static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    private static final int LABEL_ANIMATION_ENTER_DURATION_ATTR = R.attr.motionDurationMedium4;
    private static final int LABEL_ANIMATION_EXIT_DURATION_ATTR = R.attr.motionDurationShort3;
    private static final int LABEL_ANIMATION_ENTER_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int LABEL_ANIMATION_EXIT_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }

        void setVirtualViewId(int i6) {
            this.virtualViewId = i6;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        final Rect virtualViewBounds;

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f6, float f7) {
            for (int i6 = 0; i6 < this.slider.getValues().size(); i6++) {
                this.slider.updateBoundsForVirtualViewId(i6, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) f6, (int) f7)) {
                    return i6;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int i6 = 0; i6 < this.slider.getValues().size(); i6++) {
                list.add(Integer.valueOf(i6));
            }
        }

        @NonNull
        private String startOrEndDescription(int i6) {
            return i6 == this.slider.getValues().size() + (-1) ? this.slider.getContext().getString(R.string.material_slider_range_end) : i6 == 0 ? this.slider.getContext().getString(R.string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i6, int i7, Bundle bundle) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            if (i7 != 4096 && i7 != 8192) {
                if (i7 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.slider.snapThumbToValue(i6, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.slider.updateHaloHotspot();
                        this.slider.postInvalidate();
                        invalidateVirtualView(i6);
                        return true;
                    }
                }
                return false;
            }
            float calculateStepIncrement = this.slider.calculateStepIncrement(20);
            if (i7 == 8192) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            if (this.slider.isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            if (!this.slider.snapThumbToValue(i6, MathUtils.clamp(this.slider.getValues().get(i6).floatValue() + calculateStepIncrement, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                return false;
            }
            this.slider.updateHaloHotspot();
            this.slider.postInvalidate();
            invalidateVirtualView(i6);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i6, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.slider.getValues();
            float floatValue = values.get(i6).floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.slider.getContentDescription() != null) {
                sb.append(this.slider.getContentDescription());
                sb.append(",");
            }
            String formatValue = this.slider.formatValue(floatValue);
            String string = this.slider.getContext().getString(R.string.material_slider_value);
            if (values.size() > 1) {
                string = startOrEndDescription(i6);
            }
            sb.append(String.format(Locale.US, "%s, %s", string, formatValue));
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.slider.updateBoundsForVirtualViewId(i6, this.virtualViewBounds);
            accessibilityNodeInfoCompat.setBoundsInParent(this.virtualViewBounds);
        }

        AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.virtualViewBounds = new Rect();
            this.slider = baseSlider;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() { // from class: com.google.android.material.slider.BaseSlider.SliderState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState[] newArray(int i6) {
                return new SliderState[i6];
            }
        };
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.values = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }

    private float calculateStepIncrement() {
        float f6 = this.stepSize;
        if (f6 == 0.0f) {
            return 1.0f;
        }
        return f6;
    }

    private float dimenToValue(float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        float f7 = (f6 - this.trackSidePadding) / this.trackWidth;
        float f8 = this.valueFrom;
        return (f7 * (f8 - this.valueTo)) + f8;
    }

    private void drawThumbs(@NonNull Canvas canvas, int i6, int i7) {
        Canvas canvas2;
        int i8;
        int i9;
        int i10 = 0;
        while (i10 < this.values.size()) {
            float floatValue = this.values.get(i10).floatValue();
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                canvas2 = canvas;
                i8 = i6;
                i9 = i7;
                drawThumbDrawable(canvas2, i8, i9, floatValue, drawable);
            } else {
                canvas2 = canvas;
                i8 = i6;
                i9 = i7;
                if (i10 < this.customThumbDrawablesForValues.size()) {
                    drawThumbDrawable(canvas2, i8, i9, floatValue, this.customThumbDrawablesForValues.get(i10));
                } else {
                    if (!isEnabled()) {
                        canvas2.drawCircle(this.trackSidePadding + (normalizeValue(floatValue) * i8), i9, this.thumbRadius, this.thumbPaint);
                    }
                    drawThumbDrawable(canvas2, i8, i9, floatValue, this.defaultThumbDrawable);
                }
            }
            i10++;
            canvas = canvas2;
            i6 = i8;
            i7 = i9;
        }
    }

    private void focusThumbOnFocusGained(int i6) {
        if (i6 == 1) {
            moveFocus(Integer.MAX_VALUE);
            return;
        }
        if (i6 == 2) {
            moveFocus(Integer.MIN_VALUE);
        } else if (i6 == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else {
            if (i6 != 66) {
                return;
            }
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        }
    }

    private static boolean isMouseEvent(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private static int pivotIndex(float[] fArr, float f6) {
        return Math.round(f6 * ((fArr.length / 2) - 1));
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i6, @NonNull KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i6, keyEvent);
    }

    void setCustomThumbDrawable(@DrawableRes int i6) {
        setCustomThumbDrawable(getResources().getDrawable(i6));
    }

    void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            drawableArr[i6] = getResources().getDrawable(iArr[i6]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    public void setStepSize(float f6) {
        if (f6 < 0.0f) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.valueOf(f6), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
        }
        if (this.stepSize != f6) {
            this.stepSize = f6;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    private void adjustCustomThumbDrawableBounds(Drawable drawable) {
        int i6 = this.thumbRadius * 2;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i6, i6);
        } else {
            float max = i6 / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
        }
    }

    @Nullable
    private Float calculateIncrementForKey(int i6) {
        float calculateStepIncrement = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
        if (i6 == 21) {
            if (!isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            return Float.valueOf(calculateStepIncrement);
        }
        if (i6 == 22) {
            if (isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            return Float.valueOf(calculateStepIncrement);
        }
        if (i6 == 69) {
            return Float.valueOf(-calculateStepIncrement);
        }
        if (i6 == 70 || i6 == 81) {
            return Float.valueOf(calculateStepIncrement);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateStepIncrement(int i6) {
        float calculateStepIncrement = calculateStepIncrement();
        return (this.valueTo - this.valueFrom) / calculateStepIncrement <= i6 ? calculateStepIncrement : Math.round(r1 / r4) * calculateStepIncrement;
    }

    private int calculateTrackCenter() {
        return (this.widgetHeight / 2) + ((this.labelBehavior == 1 || shouldAlwaysShowLabel()) ? this.labels.get(0).getIntrinsicHeight() : 0);
    }

    private ValueAnimator createLabelAnimator(boolean z5) {
        int resolveThemeDuration;
        TimeInterpolator resolveThemeInterpolator;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getAnimatorCurrentValueOrDefault(z5 ? this.labelsOutAnimator : this.labelsInAnimator, z5 ? 0.0f : 1.0f), z5 ? 1.0f : 0.0f);
        if (z5) {
            resolveThemeDuration = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_ENTER_DURATION_ATTR, 83);
            resolveThemeInterpolator = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_ENTER_EASING_ATTR, AnimationUtils.DECELERATE_INTERPOLATOR);
        } else {
            resolveThemeDuration = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_EXIT_DURATION_ATTR, 117);
            resolveThemeInterpolator = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_EXIT_EASING_ATTR, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        }
        ofFloat.setDuration(resolveThemeDuration);
        ofFloat.setInterpolator(resolveThemeInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.slider.BaseSlider.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Iterator it = BaseSlider.this.labels.iterator();
                while (it.hasNext()) {
                    ((TooltipDrawable) it.next()).setRevealFraction(floatValue);
                }
                ViewCompat.postInvalidateOnAnimation(BaseSlider.this);
            }
        });
        return ofFloat;
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable tooltipDrawable : subList) {
                if (ViewCompat.isAttachedToWindow(this)) {
                    detachLabelFromContentView(tooltipDrawable);
                }
            }
            subList.clear();
        }
        while (true) {
            if (this.labels.size() >= this.values.size()) {
                break;
            }
            TooltipDrawable createFromAttributes = TooltipDrawable.createFromAttributes(getContext(), null, 0, this.labelStyle);
            this.labels.add(createFromAttributes);
            if (ViewCompat.isAttachedToWindow(this)) {
                attachLabelToContentView(createFromAttributes);
            }
        }
        int i6 = this.labels.size() != 1 ? 1 : 0;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setStrokeWidth(i6);
        }
    }

    private void dispatchOnChangedFromUser(int i6) {
        Iterator<L> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            it.next().onValueChange(this, this.values.get(i6).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        scheduleAccessibilityEventSender(i6);
    }

    private void dispatchOnChangedProgrammatically() {
        for (L l6 : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                l6.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    private void drawInactiveTrack(@NonNull Canvas canvas, int i6, int i7) {
        float[] activeRange = getActiveRange();
        float f6 = i6;
        float f7 = this.trackSidePadding + (activeRange[1] * f6);
        if (f7 < r4 + i6) {
            float f8 = i7;
            canvas.drawLine(f7, f8, r4 + i6, f8, this.inactiveTrackPaint);
        }
        int i8 = this.trackSidePadding;
        float f9 = i8 + (activeRange[0] * f6);
        if (f9 > i8) {
            float f10 = i8;
            float f11 = i7;
            canvas.drawLine(f10, f11, f9, f11, this.inactiveTrackPaint);
        }
    }

    private void ensureLabelsAdded() {
        if (this.labelBehavior == 2) {
            return;
        }
        if (!this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = true;
            ValueAnimator createLabelAnimator = createLabelAnimator(true);
            this.labelsInAnimator = createLabelAnimator;
            this.labelsOutAnimator = null;
            createLabelAnimator.start();
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        for (int i6 = 0; i6 < this.values.size() && it.hasNext(); i6++) {
            if (i6 != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(i6).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())));
        }
        setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator createLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = createLabelAnimator;
            this.labelsInAnimator = null;
            createLabelAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.slider.BaseSlider.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(BaseSlider.this);
                    Iterator it = BaseSlider.this.labels.iterator();
                    while (it.hasNext()) {
                        contentViewOverlay.remove((TooltipDrawable) it.next());
                    }
                }
            });
            this.labelsOutAnimator.start();
        }
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator valueAnimator, float f6) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f6;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private float getValueOfTouchPosition() {
        double snapPosition = snapPosition(this.touchPosition);
        if (isRtl()) {
            snapPosition = 1.0d - snapPosition;
        }
        float f6 = this.valueTo;
        return (float) ((snapPosition * (f6 - r3)) + this.valueFrom);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f6 = this.touchPosition;
        if (isRtl()) {
            f6 = 1.0f - f6;
        }
        float f7 = this.valueTo;
        float f8 = this.valueFrom;
        return (f6 * (f7 - f8)) + f8;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackHeight);
        this.activeTrackPaint.setStrokeWidth(this.trackHeight);
    }

    private boolean isMultipleOfStepSize(float f6) {
        double doubleValue = new BigDecimal(Float.toString(f6)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < 1.0E-4d;
    }

    private void loadResources(@NonNull Resources resources) {
        this.minWidgetHeight = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.defaultTrackHeight = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        int i6 = R.dimen.mtrl_slider_tick_radius;
        this.defaultTickActiveRadius = resources.getDimensionPixelSize(i6);
        this.defaultTickInactiveRadius = resources.getDimensionPixelSize(i6);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void maybeCalculateTicksCoordinates() {
        if (this.stepSize <= 0.0f) {
            return;
        }
        validateConfigurationIfDirty();
        int min = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != min * 2) {
            this.ticksCoordinates = new float[min * 2];
        }
        float f6 = this.trackWidth / (min - 1);
        for (int i6 = 0; i6 < min * 2; i6 += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i6] = this.trackSidePadding + ((i6 / 2.0f) * f6);
            fArr2[i6 + 1] = calculateTrackCenter();
        }
    }

    private void maybeDrawTicks(@NonNull Canvas canvas) {
        if (!this.tickVisible || this.stepSize <= 0.0f) {
            return;
        }
        float[] activeRange = getActiveRange();
        int pivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
        int pivotIndex2 = pivotIndex(this.ticksCoordinates, activeRange[1]);
        int i6 = pivotIndex * 2;
        canvas.drawPoints(this.ticksCoordinates, 0, i6, this.inactiveTicksPaint);
        int i7 = pivotIndex2 * 2;
        canvas.drawPoints(this.ticksCoordinates, i6, i7 - i6, this.activeTicksPaint);
        float[] fArr = this.ticksCoordinates;
        canvas.drawPoints(fArr, i7, fArr.length - i7, this.inactiveTicksPaint);
    }

    private boolean maybeIncreaseTrackSidePadding() {
        int max = this.minTrackSidePadding + Math.max(Math.max(Math.max(this.thumbRadius - this.defaultThumbRadius, 0), Math.max((this.trackHeight - this.defaultTrackHeight) / 2, 0)), Math.max(Math.max(this.tickActiveRadius - this.defaultTickActiveRadius, 0), Math.max(this.tickInactiveRadius - this.defaultTickInactiveRadius, 0)));
        if (this.trackSidePadding == max) {
            return false;
        }
        this.trackSidePadding = max;
        if (!ViewCompat.isLaidOut(this)) {
            return true;
        }
        updateTrackWidth(getWidth());
        return true;
    }

    private boolean moveFocus(int i6) {
        int i7 = this.focusedThumbIdx;
        int clamp = (int) MathUtils.clamp(i7 + i6, 0L, this.values.size() - 1);
        this.focusedThumbIdx = clamp;
        if (clamp == i7) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = clamp;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private float normalizeValue(float f6) {
        float f7 = this.valueFrom;
        float f8 = (f6 - f7) / (this.valueTo - f7);
        return isRtl() ? 1.0f - f8 : f8;
    }

    @Nullable
    private Boolean onKeyDownNoActiveThumb(int i6, @NonNull KeyEvent keyEvent) {
        if (i6 == 61) {
            return keyEvent.hasNoModifiers() ? Boolean.valueOf(moveFocus(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(moveFocus(-1)) : Boolean.FALSE;
        }
        if (i6 != 66) {
            if (i6 != 81) {
                if (i6 == 69) {
                    moveFocus(-1);
                    return Boolean.TRUE;
                }
                if (i6 != 70) {
                    switch (i6) {
                        case 21:
                            moveFocusInAbsoluteDirection(-1);
                            break;
                        case 22:
                            moveFocusInAbsoluteDirection(1);
                            break;
                    }
                    return Boolean.TRUE;
                }
            }
            moveFocus(1);
            return Boolean.TRUE;
        }
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void onStartTrackingTouch() {
        Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStopTrackingTouch(this);
        }
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i6) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Slider, i6, DEF_STYLE_RES, new int[0]);
        this.labelStyle = obtainStyledAttributes.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip);
        this.valueFrom = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        this.stepSize = obtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        this.minTouchTargetSize = (int) Math.ceil(obtainStyledAttributes.getDimension(R.styleable.Slider_minTouchTargetSize, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        int i7 = R.styleable.Slider_trackColor;
        boolean hasValue = obtainStyledAttributes.hasValue(i7);
        int i8 = hasValue ? i7 : R.styleable.Slider_trackColorInactive;
        if (!hasValue) {
            i7 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, i8);
        if (colorStateList == null) {
            colorStateList = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i7);
        if (colorStateList2 == null) {
            colorStateList2 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.defaultThumbDrawable.setFillColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbColor));
        int i9 = R.styleable.Slider_thumbStrokeColor;
        if (obtainStyledAttributes.hasValue(i9)) {
            setThumbStrokeColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, i9));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        this.tickVisible = obtainStyledAttributes.getBoolean(R.styleable.Slider_tickVisible, true);
        int i10 = R.styleable.Slider_tickColor;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i10);
        int i11 = hasValue2 ? i10 : R.styleable.Slider_tickColorInactive;
        if (!hasValue2) {
            i10 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i11);
        if (colorStateList4 == null) {
            colorStateList4 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i10);
        if (colorStateList5 == null) {
            colorStateList5 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setTickActiveRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusActive, 0));
        setTickInactiveRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusInactive, 0));
        setLabelBehavior(obtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0));
        if (!obtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    private void scheduleAccessibilityEventSender(int i6) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.accessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.accessibilityEventSender.setVirtualViewId(i6);
        postDelayed(this.accessibilityEventSender, 200L);
    }

    private boolean shouldAlwaysShowLabel() {
        return this.labelBehavior == 3;
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || !(getBackground() instanceof RippleDrawable);
    }

    private boolean snapActiveThumbToValue(float f6) {
        return snapThumbToValue(this.activeThumbIdx, f6);
    }

    private double snapPosition(float f6) {
        float f7 = this.stepSize;
        if (f7 <= 0.0f) {
            return f6;
        }
        return Math.round(f6 * r0) / ((int) ((this.valueTo - this.valueFrom) / f7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapThumbToValue(int i6, float f6) {
        this.focusedThumbIdx = i6;
        if (Math.abs(f6 - this.values.get(i6).floatValue()) < 1.0E-4d) {
            return false;
        }
        this.values.set(i6, Float.valueOf(getClampedValue(i6, f6)));
        dispatchOnChangedFromUser(i6);
        return true;
    }

    private void updateTrackWidth(int i6) {
        this.trackWidth = Math.max(i6 - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValueFrom();
            validateValueTo();
            validateStepSize();
            validateValues();
            validateMinSeparation();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.valueOf(this.stepSize), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
        }
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
        }
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, Float.valueOf(this.valueTo), Float.valueOf(this.valueFrom)));
        }
    }

    private void validateValues() {
        Iterator<Float> it = this.values.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() < this.valueFrom || next.floatValue() > this.valueTo) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, next, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
            }
            if (this.stepSize > 0.0f && !valueLandsOnTick(next.floatValue())) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, next, Float.valueOf(this.valueFrom), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)));
            }
        }
    }

    private boolean valueLandsOnTick(float f6) {
        return isMultipleOfStepSize(f6 - this.valueFrom);
    }

    private void warnAboutFloatingPointError() {
        float f6 = this.stepSize;
        if (f6 == 0.0f) {
            return;
        }
        if (((int) f6) != f6) {
            String.format(WARNING_FLOATING_POINT_ERROR, "stepSize", Float.valueOf(f6));
        }
        float f7 = this.valueFrom;
        if (((int) f7) != f7) {
            String.format(WARNING_FLOATING_POINT_ERROR, "valueFrom", Float.valueOf(f7));
        }
        float f8 = this.valueTo;
        if (((int) f8) != f8) {
            String.format(WARNING_FLOATING_POINT_ERROR, "valueTo", Float.valueOf(f8));
        }
    }

    public void addOnChangeListener(@NonNull L l6) {
        this.changeListeners.add(l6);
    }

    public void addOnSliderTouchListener(@NonNull T t5) {
        this.touchListeners.add(t5);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @VisibleForTesting
    void forceDrawCompatHalo(boolean z5) {
        this.forceDrawCompatHalo = z5;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @Dimension
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.defaultThumbDrawable.getElevation();
    }

    @Dimension
    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.defaultThumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.defaultThumbDrawable.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.defaultThumbDrawable.getFillColor();
    }

    @Dimension
    public int getTickActiveRadius() {
        return this.tickActiveRadius;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @Dimension
    public int getTickInactiveRadius() {
        return this.tickInactiveRadius;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Dimension
    public int getTrackHeight() {
        return this.trackHeight;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    @Dimension
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    @Dimension
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @NonNull
    List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.labelsAreAnimatedIn = false;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            detachLabelFromContentView(it.next());
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            maybeCalculateTicksCoordinates();
        }
        super.onDraw(canvas);
        int calculateTrackCenter = calculateTrackCenter();
        drawInactiveTrack(canvas, this.trackWidth, calculateTrackCenter);
        if (((Float) Collections.max(getValues())).floatValue() > this.valueFrom) {
            drawActiveTrack(canvas, this.trackWidth, calculateTrackCenter);
        }
        maybeDrawTicks(canvas);
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawCompatHalo(canvas, this.trackWidth, calculateTrackCenter);
        }
        if ((this.activeThumbIdx != -1 || shouldAlwaysShowLabel()) && isEnabled()) {
            ensureLabelsAdded();
        } else {
            ensureLabelsRemoved();
        }
        drawThumbs(canvas, this.trackWidth, calculateTrackCenter);
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, View.MeasureSpec.makeMeasureSpec(this.widgetHeight + ((this.labelBehavior == 1 || shouldAlwaysShowLabel()) ? this.labels.get(0).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
    }

    protected boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float valueToX = valueToX(valueOfTouchPositionAbsolute);
        this.activeThumbIdx = 0;
        float abs = Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i6 = 1; i6 < this.values.size(); i6++) {
            float abs2 = Math.abs(this.values.get(i6).floatValue() - valueOfTouchPositionAbsolute);
            float valueToX2 = valueToX(this.values.get(i6).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z5 = !isRtl() ? valueToX2 - valueToX >= 0.0f : valueToX2 - valueToX <= 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.activeThumbIdx = i6;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (Math.abs(valueToX2 - valueToX) < this.scaledTouchSlop) {
                        this.activeThumbIdx = -1;
                        return false;
                    }
                    if (z5) {
                        this.activeThumbIdx = i6;
                    }
                }
            }
            abs = abs2;
        }
        return this.activeThumbIdx != -1;
    }

    public void removeOnChangeListener(@NonNull L l6) {
        this.changeListeners.remove(l6);
    }

    public void removeOnSliderTouchListener(@NonNull T t5) {
        this.touchListeners.remove(t5);
    }

    protected void setActiveThumbIndex(int i6) {
        this.activeThumbIdx = i6;
    }

    void setCustomThumbDrawable(@NonNull Drawable drawable) {
        this.customThumbDrawable = initializeCustomThumbDrawable(drawable);
        this.customThumbDrawablesForValues.clear();
        postInvalidate();
    }

    public void setFocusedThumbIndex(int i6) {
        if (i6 < 0 || i6 >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i6;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i6);
        postInvalidate();
    }

    public void setHaloRadius(@IntRange(from = 0) @Dimension int i6) {
        if (i6 == this.haloRadius) {
            return;
        }
        this.haloRadius = i6;
        Drawable background = getBackground();
        if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
        }
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.haloColor)) {
            return;
        }
        this.haloColor = colorStateList;
        Drawable background = getBackground();
        if (!shouldDrawCompatHalo() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.haloPaint.setColor(getColorForState(colorStateList));
        this.haloPaint.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i6) {
        if (this.labelBehavior != i6) {
            this.labelBehavior = i6;
            requestLayout();
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    protected void setSeparationUnit(int i6) {
        this.separationUnit = i6;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setThumbElevation(float f6) {
        this.defaultThumbDrawable.setElevation(f6);
    }

    public void setThumbRadius(@IntRange(from = 0) @Dimension int i6) {
        if (i6 == this.thumbRadius) {
            return;
        }
        this.thumbRadius = i6;
        this.defaultThumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbRadius).build());
        MaterialShapeDrawable materialShapeDrawable = this.defaultThumbDrawable;
        int i7 = this.thumbRadius;
        materialShapeDrawable.setBounds(0, 0, i7 * 2, i7 * 2);
        Drawable drawable = this.customThumbDrawable;
        if (drawable != null) {
            adjustCustomThumbDrawableBounds(drawable);
        }
        Iterator<Drawable> it = this.customThumbDrawablesForValues.iterator();
        while (it.hasNext()) {
            adjustCustomThumbDrawableBounds(it.next());
        }
        updateWidgetLayout();
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.defaultThumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i6) {
        if (i6 != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i6));
        }
    }

    public void setThumbStrokeWidth(float f6) {
        this.defaultThumbDrawable.setStrokeWidth(f6);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i6) {
        if (i6 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i6));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.defaultThumbDrawable.getFillColor())) {
            return;
        }
        this.defaultThumbDrawable.setFillColor(colorStateList);
        invalidate();
    }

    public void setTickActiveRadius(@IntRange(from = 0) @Dimension int i6) {
        if (this.tickActiveRadius != i6) {
            this.tickActiveRadius = i6;
            this.activeTicksPaint.setStrokeWidth(i6 * 2);
            updateWidgetLayout();
        }
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(@IntRange(from = 0) @Dimension int i6) {
        if (this.tickInactiveRadius != i6) {
            this.tickInactiveRadius = i6;
            this.inactiveTicksPaint.setStrokeWidth(i6 * 2);
            updateWidgetLayout();
        }
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickVisible(boolean z5) {
        if (this.tickVisible != z5) {
            this.tickVisible = z5;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Dimension int i6) {
        if (this.trackHeight != i6) {
            this.trackHeight = i6;
            invalidateTrack();
            updateWidgetLayout();
        }
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setValueFrom(float f6) {
        this.valueFrom = f6;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f6) {
        this.valueTo = f6;
        this.dirtyConfig = true;
        postInvalidate();
    }

    void updateBoundsForVirtualViewId(int i6, Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i6).floatValue()) * this.trackWidth));
        int calculateTrackCenter = calculateTrackCenter();
        int i7 = this.thumbRadius;
        int i8 = this.minTouchTargetSize;
        if (i7 <= i8) {
            i7 = i8;
        }
        int i9 = i7 / 2;
        rect.set(normalizeValue - i9, calculateTrackCenter - i9, normalizeValue + i9, calculateTrackCenter + i9);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i6, DEF_STYLE_RES), attributeSet, i6);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.defaultThumbDrawable = materialShapeDrawable;
        this.customThumbDrawablesForValues = Collections.EMPTY_LIST;
        this.separationUnit = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        Paint.Style style2 = Paint.Style.FILL;
        paint3.setStyle(style2);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(style2);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(style);
        paint6.setStrokeCap(cap);
        loadResources(context2.getResources());
        processAttributes(context2, attributeSet, i6);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(tooltipDrawable);
            tooltipDrawable.detachView(ViewUtils.getContentView(this));
        }
    }

    private void drawActiveTrack(@NonNull Canvas canvas, int i6, int i7) {
        float[] activeRange = getActiveRange();
        int i8 = this.trackSidePadding;
        float f6 = i6;
        float f7 = i7;
        canvas.drawLine(i8 + (activeRange[0] * f6), f7, i8 + (activeRange[1] * f6), f7, this.activeTrackPaint);
    }

    private void drawThumbDrawable(@NonNull Canvas canvas, int i6, int i7, float f6, @NonNull Drawable drawable) {
        canvas.save();
        canvas.translate((this.trackSidePadding + ((int) (normalizeValue(f6) * i6))) - (drawable.getBounds().width() / 2.0f), i7 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatValue(float f6) {
        String str;
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f6);
        }
        if (((int) f6) == f6) {
            str = "%.0f";
        } else {
            str = "%.2f";
        }
        return String.format(str, Float.valueOf(f6));
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() == 1) {
            floatValue2 = this.valueFrom;
        }
        float normalizeValue = normalizeValue(floatValue2);
        float normalizeValue2 = normalizeValue(floatValue);
        if (isRtl()) {
            return new float[]{normalizeValue2, normalizeValue};
        }
        return new float[]{normalizeValue, normalizeValue2};
    }

    private float getClampedValue(int i6, float f6) {
        float floatValue;
        float floatValue2;
        float minSeparation = getMinSeparation();
        if (this.separationUnit == 0) {
            minSeparation = dimenToValue(minSeparation);
        }
        if (isRtl()) {
            minSeparation = -minSeparation;
        }
        int i7 = i6 + 1;
        if (i7 >= this.values.size()) {
            floatValue = this.valueTo;
        } else {
            floatValue = this.values.get(i7).floatValue() - minSeparation;
        }
        int i8 = i6 - 1;
        if (i8 < 0) {
            floatValue2 = this.valueFrom;
        } else {
            floatValue2 = this.values.get(i8).floatValue() + minSeparation;
        }
        return MathUtils.clamp(f6, floatValue2, floatValue);
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private Drawable initializeCustomThumbDrawable(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        adjustCustomThumbDrawableBounds(newDrawable);
        return newDrawable;
    }

    private boolean isInVerticalScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private boolean isPotentialVerticalScroll(MotionEvent motionEvent) {
        if (!isMouseEvent(motionEvent) && isInVerticalScrollingContainer()) {
            return true;
        }
        return false;
    }

    private void maybeDrawCompatHalo(@NonNull Canvas canvas, int i6, int i7) {
        Canvas canvas2;
        if (shouldDrawCompatHalo()) {
            int normalizeValue = (int) (this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * i6));
            if (Build.VERSION.SDK_INT < 28) {
                int i8 = this.haloRadius;
                canvas2 = canvas;
                canvas2.clipRect(normalizeValue - i8, i7 - i8, normalizeValue + i8, i8 + i7, Region.Op.UNION);
            } else {
                canvas2 = canvas;
            }
            canvas2.drawCircle(normalizeValue, i7, this.haloRadius, this.haloPaint);
        }
    }

    private boolean maybeIncreaseWidgetHeight() {
        int max = Math.max(this.minWidgetHeight, Math.max(this.trackHeight + getPaddingTop() + getPaddingBottom(), (this.thumbRadius * 2) + getPaddingTop() + getPaddingBottom()));
        if (max == this.widgetHeight) {
            return false;
        }
        this.widgetHeight = max;
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int i6) {
        if (isRtl()) {
            if (i6 == Integer.MIN_VALUE) {
                i6 = Integer.MAX_VALUE;
            } else {
                i6 = -i6;
            }
        }
        return moveFocus(i6);
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f6) {
        tooltipDrawable.setText(formatValue(f6));
        int normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f6) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int calculateTrackCenter = calculateTrackCenter() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(normalizeValue, calculateTrackCenter - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + normalizeValue, calculateTrackCenter);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.values.size() == arrayList.size() && this.values.equals(arrayList)) {
                return;
            }
            this.values = arrayList;
            this.dirtyConfig = true;
            this.focusedThumbIdx = 0;
            updateHaloHotspot();
            createLabelPool();
            dispatchOnChangedProgrammatically();
            postInvalidate();
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (!shouldDrawCompatHalo() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int normalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding);
                int calculateTrackCenter = calculateTrackCenter();
                int i6 = this.haloRadius;
                DrawableCompat.setHotspotBounds(background, normalizeValue - i6, calculateTrackCenter - i6, normalizeValue + i6, calculateTrackCenter + i6);
            }
        }
    }

    private void updateWidgetLayout() {
        boolean maybeIncreaseWidgetHeight = maybeIncreaseWidgetHeight();
        boolean maybeIncreaseTrackSidePadding = maybeIncreaseTrackSidePadding();
        if (maybeIncreaseWidgetHeight) {
            requestLayout();
        } else if (maybeIncreaseTrackSidePadding) {
            postInvalidate();
        }
    }

    private void validateMinSeparation() {
        float minSeparation = getMinSeparation();
        if (minSeparation >= 0.0f) {
            float f6 = this.stepSize;
            if (f6 > 0.0f && minSeparation > 0.0f) {
                if (this.separationUnit == 1) {
                    if (minSeparation < f6 || !isMultipleOfStepSize(minSeparation)) {
                        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE, Float.valueOf(minSeparation), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)));
                    }
                    return;
                }
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT, Float.valueOf(minSeparation), Float.valueOf(this.stepSize)));
            }
            return;
        }
        throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION, Float.valueOf(minSeparation)));
    }

    private float valueToX(float f6) {
        return (normalizeValue(f6) * this.trackWidth) + this.trackSidePadding;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (TooltipDrawable tooltipDrawable : this.labels) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.defaultThumbDrawable.isStateful()) {
            this.defaultThumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    final boolean isRtl() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            attachLabelToContentView(it.next());
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z5, int i6, @Nullable Rect rect) {
        super.onFocusChanged(z5, i6, rect);
        if (!z5) {
            this.activeThumbIdx = -1;
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        } else {
            focusThumbOnFocusGained(i6);
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i6, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i6, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            Boolean onKeyDownNoActiveThumb = onKeyDownNoActiveThumb(i6, keyEvent);
            if (onKeyDownNoActiveThumb != null) {
                return onKeyDownNoActiveThumb.booleanValue();
            }
            return super.onKeyDown(i6, keyEvent);
        }
        this.isLongPress |= keyEvent.isLongPress();
        Float calculateIncrementForKey = calculateIncrementForKey(i6);
        if (calculateIncrementForKey != null) {
            if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + calculateIncrementForKey.floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i6 != 23) {
            if (i6 != 61) {
                if (i6 != 66) {
                    return super.onKeyDown(i6, keyEvent);
                }
            } else {
                if (keyEvent.hasNoModifiers()) {
                    return moveFocus(1);
                }
                if (!keyEvent.isShiftPressed()) {
                    return false;
                }
                return moveFocus(-1);
            }
        }
        this.activeThumbIdx = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        updateTrackWidth(i6);
        updateHaloHotspot();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        if (r2 != 3) goto L47;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i6) {
        ViewOverlayImpl contentViewOverlay;
        super.onVisibilityChanged(view, i6);
        if (i6 != 0 && (contentViewOverlay = ViewUtils.getContentViewOverlay(this)) != null) {
            Iterator<TooltipDrawable> it = this.labels.iterator();
            while (it.hasNext()) {
                contentViewOverlay.remove(it.next());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        int i6;
        super.setEnabled(z5);
        if (z5) {
            i6 = 0;
        } else {
            i6 = 2;
        }
        setLayerType(i6, null);
    }

    public void setHaloRadiusResource(@DimenRes int i6) {
        setHaloRadius(getResources().getDimensionPixelSize(i6));
    }

    public void setThumbElevationResource(@DimenRes int i6) {
        setThumbElevation(getResources().getDimension(i6));
    }

    public void setThumbRadiusResource(@DimenRes int i6) {
        setThumbRadius(getResources().getDimensionPixelSize(i6));
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.customThumbDrawablesForValues.add(initializeCustomThumbDrawable(drawable));
        }
        postInvalidate();
    }
}
