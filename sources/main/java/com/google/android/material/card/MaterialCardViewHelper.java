package com.google.android.material.card;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final Drawable CHECKED_ICON_NONE;
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public static final int DEFAULT_FADE_ANIM_DURATION = 300;
    private static final int DEFAULT_STROKE_VALUE = -1;

    @NonNull
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;

    @Nullable
    private Drawable checkedIcon;
    private int checkedIconGravity;

    @Dimension
    private int checkedIconMargin;

    @Dimension
    private int checkedIconSize;

    @Nullable
    private ColorStateList checkedIconTint;

    @Nullable
    private LayerDrawable clickableForegroundDrawable;

    @Nullable
    private MaterialShapeDrawable compatRippleDrawable;

    @Nullable
    private Drawable fgDrawable;

    @NonNull
    private final MaterialShapeDrawable foregroundContentDrawable;

    @Nullable
    private MaterialShapeDrawable foregroundShapeDrawable;

    @Nullable
    private ValueAnimator iconAnimator;
    private final TimeInterpolator iconFadeAnimInterpolator;
    private final int iconFadeInAnimDuration;
    private final int iconFadeOutAnimDuration;

    @NonNull
    private final MaterialCardView materialCardView;

    @Nullable
    private ColorStateList rippleColor;

    @Nullable
    private Drawable rippleDrawable;

    @Nullable
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private ColorStateList strokeColor;

    @Dimension
    private int strokeWidth;

    @NonNull
    private final Rect userContentPadding = new Rect();
    private boolean isBackgroundOverwritten = false;
    private float checkedAnimationProgress = 0.0f;

    public void setChecked(boolean z5) {
        setChecked(z5, false);
    }

    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f6) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * f6);
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f6 / 2.0f;
        }
        return 0.0f;
    }

    private float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * 1.5f) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private boolean canClipToOutline() {
        return this.bgDrawable.isRoundRect();
    }

    @NonNull
    private Drawable createCompatRippleDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable createForegroundShapeDrawable = createForegroundShapeDrawable();
        this.compatRippleDrawable = createForegroundShapeDrawable;
        createForegroundShapeDrawable.setFillColor(this.rippleColor);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.compatRippleDrawable);
        return stateListDrawable;
    }

    @NonNull
    private Drawable createForegroundRippleDrawable() {
        if (!RippleUtils.USE_FRAMEWORK_RIPPLE) {
            return createCompatRippleDrawable();
        }
        this.foregroundShapeDrawable = createForegroundShapeDrawable();
        return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
    }

    @NonNull
    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    @NonNull
    private Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
            this.clickableForegroundDrawable = layerDrawable;
            layerDrawable.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap() && this.materialCardView.getUseCompatPadding()) {
            return (float) ((1.0d - COS_45) * this.materialCardView.getCardViewRadius());
        }
        return 0.0f;
    }

    @NonNull
    private Drawable insetDrawable(Drawable drawable) {
        int i6;
        int i7;
        if (this.materialCardView.getUseCompatPadding()) {
            i7 = (int) Math.ceil(calculateVerticalBackgroundPadding());
            i6 = (int) Math.ceil(calculateHorizontalBackgroundPadding());
        } else {
            i6 = 0;
            i7 = 0;
        }
        return new InsetDrawable(drawable, i6, i7, i6, i7) { // from class: com.google.android.material.card.MaterialCardViewHelper.1
            @Override // android.graphics.drawable.Drawable
            public int getMinimumHeight() {
                return -1;
            }

            @Override // android.graphics.drawable.Drawable
            public int getMinimumWidth() {
                return -1;
            }

            @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private boolean isCheckedIconBottom() {
        return (this.checkedIconGravity & 80) == 80;
    }

    private boolean isCheckedIconEnd() {
        return (this.checkedIconGravity & GravityCompat.END) == 8388613;
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding();
    }

    private void updateInsetForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.materialCardView.getForeground() instanceof InsetDrawable)) {
            this.materialCardView.setForeground(insetDrawable(drawable));
        } else {
            ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        }
    }

    private void updateRippleColor() {
        Drawable drawable;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.rippleDrawable) != null) {
            ((RippleDrawable) drawable).setColor(this.rippleColor);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.rippleColor);
        }
    }

    public void animateCheckedIcon(boolean z5) {
        float f6 = z5 ? 1.0f : 0.0f;
        float f7 = z5 ? 1.0f - this.checkedAnimationProgress : this.checkedAnimationProgress;
        ValueAnimator valueAnimator = this.iconAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.iconAnimator = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.checkedAnimationProgress, f6);
        this.iconAnimator = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.card.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                MaterialCardViewHelper.a(MaterialCardViewHelper.this, valueAnimator2);
            }
        });
        this.iconAnimator.setInterpolator(this.iconFadeAnimInterpolator);
        this.iconAnimator.setDuration((long) ((z5 ? this.iconFadeInAnimDuration : this.iconFadeOutAnimDuration) * f7));
        this.iconAnimator.start();
    }

    @RequiresApi(api = 23)
    void forceRippleRedraw() {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i6 = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i6 - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i6);
        }
    }

    @NonNull
    MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    @Nullable
    Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    int getCheckedIconGravity() {
        return this.checkedIconGravity;
    }

    @Dimension
    int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    @Dimension
    int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    @Nullable
    ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    @Nullable
    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @ColorInt
    int getStrokeColor() {
        ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    @Dimension
    int getStrokeWidth() {
        return this.strokeWidth;
    }

    @NonNull
    Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    void loadFromAttributes(@NonNull TypedArray typedArray) {
        ColorStateList colorStateList = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = colorStateList;
        if (colorStateList == null) {
            this.strokeColor = ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z5 = typedArray.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = z5;
        this.materialCardView.setLongClickable(z5);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0));
        this.checkedIconGravity = typedArray.getInteger(com.google.android.material.R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = colorStateList2;
        if (colorStateList2 == null) {
            this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, com.google.android.material.R.attr.colorControlHighlight));
        }
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.fgDrawable = clickableForeground;
        this.materialCardView.setForeground(insetDrawable(clickableForeground));
    }

    void recalculateCheckedIconPosition(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        if (this.clickableForegroundDrawable != null) {
            if (this.materialCardView.getUseCompatPadding()) {
                i8 = (int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
                i9 = (int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
            } else {
                i8 = 0;
                i9 = 0;
            }
            int i12 = isCheckedIconEnd() ? ((i6 - this.checkedIconMargin) - this.checkedIconSize) - i9 : this.checkedIconMargin;
            int i13 = isCheckedIconBottom() ? this.checkedIconMargin : ((i7 - this.checkedIconMargin) - this.checkedIconSize) - i8;
            int i14 = isCheckedIconEnd() ? this.checkedIconMargin : ((i6 - this.checkedIconMargin) - this.checkedIconSize) - i9;
            int i15 = isCheckedIconBottom() ? ((i7 - this.checkedIconMargin) - this.checkedIconSize) - i8 : this.checkedIconMargin;
            if (ViewCompat.getLayoutDirection(this.materialCardView) == 1) {
                i11 = i14;
                i10 = i12;
            } else {
                i10 = i14;
                i11 = i12;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i11, i15, i10, i13);
        }
    }

    void setBackgroundOverwritten(boolean z5) {
        this.isBackgroundOverwritten = z5;
    }

    void setCardBackgroundColor(ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    void setCheckable(boolean z5) {
        this.checkable = z5;
    }

    public void setChecked(boolean z5, boolean z6) {
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            if (z6) {
                animateCheckedIcon(z5);
            } else {
                drawable.setAlpha(z5 ? 255 : 0);
                this.checkedAnimationProgress = z5 ? 1.0f : 0.0f;
            }
        }
    }

    void setCheckedIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.checkedIcon = mutate;
            DrawableCompat.setTintList(mutate, this.checkedIconTint);
            setChecked(this.materialCardView.isChecked());
        } else {
            this.checkedIcon = CHECKED_ICON_NONE;
        }
        LayerDrawable layerDrawable = this.clickableForegroundDrawable;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, this.checkedIcon);
        }
    }

    void setCheckedIconGravity(int i6) {
        this.checkedIconGravity = i6;
        recalculateCheckedIconPosition(this.materialCardView.getMeasuredWidth(), this.materialCardView.getMeasuredHeight());
    }

    void setCheckedIconMargin(@Dimension int i6) {
        this.checkedIconMargin = i6;
    }

    void setCheckedIconSize(@Dimension int i6) {
        this.checkedIconSize = i6;
    }

    void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    void setCornerRadius(float f6) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f6));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f6) {
        this.bgDrawable.setInterpolation(f6);
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f6);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f6);
        }
    }

    void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        this.bgDrawable.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.compatRippleDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor == colorStateList) {
            return;
        }
        this.strokeColor = colorStateList;
        updateStroke();
    }

    void setStrokeWidth(@Dimension int i6) {
        if (i6 == this.strokeWidth) {
            return;
        }
        this.strokeWidth = i6;
        updateStroke();
    }

    void setUserContentPadding(int i6, int i7, int i8, int i9) {
        this.userContentPadding.set(i6, i7, i8, i9);
        updateContentPadding();
    }

    void updateClickable() {
        Drawable drawable = this.fgDrawable;
        Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.fgDrawable = clickableForeground;
        if (drawable != clickableForeground) {
            updateInsetForeground(clickableForeground);
        }
    }

    void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i6, @StyleRes int i7) {
        this.materialCardView = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i6, i7);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.CardView, i6, com.google.android.material.R.style.CardView);
        int i8 = com.google.android.material.R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i8)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(i8, 0.0f));
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        this.iconFadeAnimInterpolator = MotionUtils.resolveThemeInterpolator(materialCardView.getContext(), com.google.android.material.R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.iconFadeInAnimDuration = MotionUtils.resolveThemeDuration(materialCardView.getContext(), com.google.android.material.R.attr.motionDurationShort2, 300);
        this.iconFadeOutAnimDuration = MotionUtils.resolveThemeDuration(materialCardView.getContext(), com.google.android.material.R.attr.motionDurationShort1, 300);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void a(MaterialCardViewHelper materialCardViewHelper, ValueAnimator valueAnimator) {
        materialCardViewHelper.getClass();
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialCardViewHelper.checkedIcon.setAlpha((int) (255.0f * floatValue));
        materialCardViewHelper.checkedAnimationProgress = floatValue;
    }

    void updateContentPadding() {
        float calculateActualCornerPadding;
        if (!shouldAddCornerPaddingInsideCardBackground() && !shouldAddCornerPaddingOutsideCardBackground()) {
            calculateActualCornerPadding = 0.0f;
        } else {
            calculateActualCornerPadding = calculateActualCornerPadding();
        }
        int parentCardViewCalculatedCornerPadding = (int) (calculateActualCornerPadding - getParentCardViewCalculatedCornerPadding());
        MaterialCardView materialCardView = this.materialCardView;
        Rect rect = this.userContentPadding;
        materialCardView.setAncestorContentPadding(rect.left + parentCardViewCalculatedCornerPadding, rect.top + parentCardViewCalculatedCornerPadding, rect.right + parentCardViewCalculatedCornerPadding, rect.bottom + parentCardViewCalculatedCornerPadding);
    }

    void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        CHECKED_ICON_NONE = colorDrawable;
    }
}
