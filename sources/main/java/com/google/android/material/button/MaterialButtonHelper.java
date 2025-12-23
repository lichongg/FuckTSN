package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP;

    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean IS_MIN_LOLLIPOP;

    @Nullable
    private ColorStateList backgroundTint;

    @Nullable
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private int elevation;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;

    @Nullable
    private Drawable maskDrawable;
    private final MaterialButton materialButton;

    @Nullable
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private ColorStateList strokeColor;
    private int strokeWidth;
    private boolean shouldDrawSurfaceColorStroke = false;
    private boolean backgroundOverwritten = false;
    private boolean cornerRadiusSet = false;
    private boolean toggleCheckedStateOnClick = true;

    @Nullable
    private MaterialShapeDrawable getMaterialShapeDrawable(boolean z5) {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return IS_MIN_LOLLIPOP ? (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!z5 ? 1 : 0) : (MaterialShapeDrawable) this.rippleDrawable.getDrawable(!z5 ? 1 : 0);
    }

    @Nullable
    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        IS_MIN_LOLLIPOP = true;
        IS_LOLLIPOP = i6 <= 22;
    }

    private Drawable createBackground() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable.initializeElevationOverlay(this.materialButton.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke(this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, R.attr.colorSurface) : 0);
        if (IS_MIN_LOLLIPOP) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.maskDrawable = materialShapeDrawable3;
            DrawableCompat.setTint(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.maskDrawable);
            this.rippleDrawable = rippleDrawable;
            return rippleDrawable;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = rippleDrawableCompat;
        DrawableCompat.setTintList(rippleDrawableCompat, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.maskDrawable});
        this.rippleDrawable = layerDrawable;
        return wrapDrawableWithInset(layerDrawable);
    }

    private void setVerticalInsets(@Dimension int i6, @Dimension int i7) {
        int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        int i8 = this.insetTop;
        int i9 = this.insetBottom;
        this.insetBottom = i7;
        this.insetTop = i6;
        if (!this.backgroundOverwritten) {
            updateBackground();
        }
        ViewCompat.setPaddingRelative(this.materialButton, paddingStart, (paddingTop + i6) - i8, paddingEnd, (paddingBottom + i7) - i9);
    }

    private void updateBackground() {
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(this.elevation);
            materialShapeDrawable.setState(this.materialButton.getDrawableState());
        }
    }

    private void updateButtonShape(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (IS_LOLLIPOP && !this.backgroundOverwritten) {
            int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
            int paddingTop = this.materialButton.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
            int paddingBottom = this.materialButton.getPaddingBottom();
            updateBackground();
            ViewCompat.setPaddingRelative(this.materialButton, paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getSurfaceColorStrokeDrawable() != null) {
            getSurfaceColorStrokeDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    @NonNull
    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getInsetBottom() {
        return this.insetBottom;
    }

    public int getInsetTop() {
        return this.insetTop;
    }

    @Nullable
    public Shapeable getMaskDrawable() {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.rippleDrawable.getNumberOfLayers() > 2 ? (Shapeable) this.rippleDrawable.getDrawable(2) : (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    @Nullable
    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    @NonNull
    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Nullable
    ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    int getStrokeWidth() {
        return this.strokeWidth;
    }

    ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    boolean isCheckable() {
        return this.checkable;
    }

    boolean isToggleCheckedStateOnClick() {
        return this.toggleCheckedStateOnClick;
    }

    void loadFromAttributes(@NonNull TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i6 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i6)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i6, -1);
            this.cornerRadius = dimensionPixelSize;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(dimensionPixelSize));
            this.cornerRadiusSet = true;
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.checkable = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.elevation = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        this.toggleCheckedStateOnClick = typedArray.getBoolean(R.styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            setBackgroundOverwritten();
        } else {
            updateBackground();
        }
        ViewCompat.setPaddingRelative(this.materialButton, paddingStart + this.insetLeft, paddingTop + this.insetTop, paddingEnd + this.insetRight, paddingBottom + this.insetBottom);
    }

    void setCheckable(boolean z5) {
        this.checkable = z5;
    }

    void setCornerRadius(int i6) {
        if (this.cornerRadiusSet && this.cornerRadius == i6) {
            return;
        }
        this.cornerRadius = i6;
        this.cornerRadiusSet = true;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(i6));
    }

    public void setInsetBottom(@Dimension int i6) {
        setVerticalInsets(this.insetTop, i6);
    }

    public void setInsetTop(@Dimension int i6) {
        setVerticalInsets(i6, this.insetBottom);
    }

    void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            boolean z5 = IS_MIN_LOLLIPOP;
            if (z5 && (this.materialButton.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            } else {
                if (z5 || !(this.materialButton.getBackground() instanceof RippleDrawableCompat)) {
                    return;
                }
                ((RippleDrawableCompat) this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            }
        }
    }

    void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        updateButtonShape(shapeAppearanceModel);
    }

    void setShouldDrawSurfaceColorStroke(boolean z5) {
        this.shouldDrawSurfaceColorStroke = z5;
        updateStroke();
    }

    void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    void setStrokeWidth(int i6) {
        if (this.strokeWidth != i6) {
            this.strokeWidth = i6;
            updateStroke();
        }
    }

    void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (getMaterialShapeDrawable() != null) {
                DrawableCompat.setTintList(getMaterialShapeDrawable(), this.backgroundTint);
            }
        }
    }

    void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (getMaterialShapeDrawable() == null || this.backgroundTintMode == null) {
                return;
            }
            DrawableCompat.setTintMode(getMaterialShapeDrawable(), this.backgroundTintMode);
        }
    }

    void setToggleCheckedStateOnClick(boolean z5) {
        this.toggleCheckedStateOnClick = z5;
    }

    void updateMaskBounds(int i6, int i7) {
        Drawable drawable = this.maskDrawable;
        if (drawable != null) {
            drawable.setBounds(this.insetLeft, this.insetTop, i7 - this.insetRight, i6 - this.insetBottom);
        }
    }

    MaterialButtonHelper(MaterialButton materialButton, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.materialButton = materialButton;
        this.shapeAppearanceModel = shapeAppearanceModel;
    }

    private void updateStroke() {
        int i6;
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
            if (surfaceColorStrokeDrawable != null) {
                float f6 = this.strokeWidth;
                if (this.shouldDrawSurfaceColorStroke) {
                    i6 = MaterialColors.getColor(this.materialButton, R.attr.colorSurface);
                } else {
                    i6 = 0;
                }
                surfaceColorStrokeDrawable.setStroke(f6, i6);
            }
        }
    }

    void setBackgroundColor(int i6) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setTint(i6);
        }
    }

    @Nullable
    MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }
}
