package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Button;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";

    @Nullable
    private String accessibilityClassName;
    private boolean broadcasting;
    private boolean checked;

    @Nullable
    private Drawable icon;
    private int iconGravity;

    @Px
    private int iconLeft;

    @Px
    private int iconPadding;

    @Px
    private int iconSize;

    @Nullable
    private ColorStateList iconTint;

    @Nullable
    private PorterDuff.Mode iconTintMode;

    @Px
    private int iconTop;

    @NonNull
    private final MaterialButtonHelper materialButtonHelper;

    @NonNull
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;

    @Nullable
    private OnPressedChangeListener onPressedChangeListenerInternal;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<MaterialButton> {
        private int mIconPaddingId;
        private boolean mPropertiesMapped = false;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(@NonNull PropertyMapper propertyMapper) {
            int mapInt;
            mapInt = propertyMapper.mapInt("iconPadding", com.google.android.material.R.attr.iconPadding);
            this.mIconPaddingId = mapInt;
            this.mPropertiesMapped = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(@NonNull MaterialButton materialButton, @NonNull PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw c.a();
            }
            propertyReader.readInt(this.mIconPaddingId, materialButton.getIconPadding());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton materialButton, boolean z5);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.button.MaterialButton.SavedState.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i6) {
                return new SavedState[i6];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        boolean checked;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }

        private void readFromParcel(@NonNull Parcel parcel) {
            boolean z5 = true;
            if (parcel.readInt() != 1) {
                z5 = false;
            }
            this.checked = z5;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeInt(this.checked ? 1 : 0);
        }
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    private boolean isIconEnd() {
        int i6 = this.iconGravity;
        return i6 == 3 || i6 == 4;
    }

    private boolean isIconStart() {
        int i6 = this.iconGravity;
        return i6 == 1 || i6 == 2;
    }

    private boolean isIconTop() {
        int i6 = this.iconGravity;
        return i6 == 16 || i6 == 32;
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        return (materialButtonHelper == null || materialButtonHelper.isBackgroundOverwritten()) ? false : true;
    }

    private void updateIcon(boolean z5) {
        Drawable drawable = this.icon;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.icon = mutate;
            DrawableCompat.setTintList(mutate, this.iconTint);
            PorterDuff.Mode mode = this.iconTintMode;
            if (mode != null) {
                DrawableCompat.setTintMode(this.icon, mode);
            }
            int i6 = this.iconSize;
            if (i6 == 0) {
                i6 = this.icon.getIntrinsicWidth();
            }
            int i7 = this.iconSize;
            if (i7 == 0) {
                i7 = this.icon.getIntrinsicHeight();
            }
            Drawable drawable2 = this.icon;
            int i8 = this.iconLeft;
            int i9 = this.iconTop;
            drawable2.setBounds(i8, i9, i6 + i8, i7 + i9);
            this.icon.setVisible(true, z5);
        }
        if (z5) {
            resetIconDrawable();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((!isIconStart() || drawable3 == this.icon) && ((!isIconEnd() || drawable5 == this.icon) && (!isIconTop() || drawable4 == this.icon))) {
            return;
        }
        resetIconDrawable();
    }

    private void updateIconPosition(int i6, int i7) {
        if (this.icon == null || getLayout() == null) {
            return;
        }
        if (!isIconStart() && !isIconEnd()) {
            if (isIconTop()) {
                this.iconLeft = 0;
                if (this.iconGravity == 16) {
                    this.iconTop = 0;
                    updateIcon(false);
                    return;
                }
                int i8 = this.iconSize;
                if (i8 == 0) {
                    i8 = this.icon.getIntrinsicHeight();
                }
                int max = Math.max(0, (((((i7 - getTextHeight()) - getPaddingTop()) - i8) - this.iconPadding) - getPaddingBottom()) / 2);
                if (this.iconTop != max) {
                    this.iconTop = max;
                    updateIcon(false);
                    return;
                }
                return;
            }
            return;
        }
        this.iconTop = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i9 = this.iconGravity;
        if (i9 == 1 || i9 == 3 || ((i9 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i9 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.iconLeft = 0;
            updateIcon(false);
            return;
        }
        int i10 = this.iconSize;
        if (i10 == 0) {
            i10 = this.icon.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i6 - getTextLayoutWidth()) - ViewCompat.getPaddingEnd(this)) - i10) - this.iconPadding) - ViewCompat.getPaddingStart(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (isLayoutRTL() != (this.iconGravity == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.iconLeft != textLayoutWidth) {
            this.iconLeft = textLayoutWidth;
            updateIcon(false);
        }
    }

    public void addOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.add(onCheckedChangeListener);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    @NonNull
    String getA11yClassName() {
        if (TextUtils.isEmpty(this.accessibilityClassName)) {
            return (isCheckable() ? CompoundButton.class : Button.class).getName();
        }
        return this.accessibilityClassName;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    @Px
    public int getIconPadding() {
        return this.iconPadding;
    }

    @Px
    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    @Dimension
    public int getInsetBottom() {
        return this.materialButtonHelper.getInsetBottom();
    }

    @Dimension
    public int getInsetTop() {
        return this.materialButtonHelper.getInsetTop();
    }

    public boolean isCheckable() {
        MaterialButtonHelper materialButtonHelper = this.materialButtonHelper;
        return materialButtonHelper != null && materialButtonHelper.isCheckable();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.materialButtonHelper.isToggleCheckedStateOnClick();
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i6) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i6 + 2);
        if (isCheckable()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.materialButtonHelper.isToggleCheckedStateOnClick()) {
            toggle();
        }
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(@NonNull OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.remove(onCheckedChangeListener);
    }

    void setA11yClassName(@Nullable String str) {
        this.accessibilityClassName = str;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i6) {
        setBackgroundDrawable(i6 != 0 ? AppCompatResources.getDrawable(getContext(), i6) : null);
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.icon != drawable) {
            this.icon = drawable;
            updateIcon(true);
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i6) {
        if (this.iconGravity != i6) {
            this.iconGravity = i6;
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i6) {
        if (this.iconPadding != i6) {
            this.iconPadding = i6;
            setCompoundDrawablePadding(i6);
        }
    }

    public void setIconResource(@DrawableRes int i6) {
        setIcon(i6 != 0 ? AppCompatResources.getDrawable(getContext(), i6) : null);
    }

    public void setIconSize(@Px int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.iconSize != i6) {
            this.iconSize = i6;
            updateIcon(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setInsetBottom(@Dimension int i6) {
        this.materialButtonHelper.setInsetBottom(i6);
    }

    public void setInsetTop(@Dimension int i6) {
        this.materialButtonHelper.setInsetTop(i6);
    }

    void setOnPressedChangeListenerInternal(@Nullable OnPressedChangeListener onPressedChangeListener) {
        this.onPressedChangeListenerInternal = onPressedChangeListener;
    }

    @Override // android.view.View
    public void setPressed(boolean z5) {
        OnPressedChangeListener onPressedChangeListener = this.onPressedChangeListenerInternal;
        if (onPressedChangeListener != null) {
            onPressedChangeListener.onPressedChanged(this, z5);
        }
        super.setPressed(z5);
    }

    public void setToggleCheckedStateOnClick(boolean z5) {
        this.materialButtonHelper.setToggleCheckedStateOnClick(z5);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButton.DEF_STYLE_RES
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.onCheckedChangeListeners = r7
            r7 = 0
            r6.checked = r7
            r6.broadcasting = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButton
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r9 = r8.getDimensionPixelSize(r9, r7)
            r6.iconPadding = r9
            int r9 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            r2 = -1
            int r9 = r8.getInt(r9, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r9 = com.google.android.material.internal.ViewUtils.parseTintMode(r9, r2)
            r6.iconTintMode = r9
            android.content.Context r9 = r6.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r9 = com.google.android.material.resources.MaterialResources.getColorStateList(r9, r8, r2)
            r6.iconTint = r9
            android.content.Context r9 = r6.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r9 = com.google.android.material.resources.MaterialResources.getDrawable(r9, r8, r2)
            r6.icon = r9
            int r9 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r2 = 1
            int r9 = r8.getInteger(r9, r2)
            r6.iconGravity = r9
            int r9 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r9 = r8.getDimensionPixelSize(r9, r7)
            r6.iconSize = r9
            com.google.android.material.shape.ShapeAppearanceModel$Builder r9 = com.google.android.material.shape.ShapeAppearanceModel.builder(r0, r1, r3, r4)
            com.google.android.material.shape.ShapeAppearanceModel r9 = r9.build()
            com.google.android.material.button.MaterialButtonHelper r0 = new com.google.android.material.button.MaterialButtonHelper
            r0.<init>(r6, r9)
            r6.materialButtonHelper = r0
            r0.loadFromAttributes(r8)
            r8.recycle()
            int r8 = r6.iconPadding
            r6.setCompoundDrawablePadding(r8)
            android.graphics.drawable.Drawable r8 = r6.icon
            if (r8 == 0) goto L82
            r7 = 1
        L82:
            r6.updateIcon(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        if (textAlignment != 1) {
            if (textAlignment != 6 && textAlignment != 3) {
                if (textAlignment != 4) {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (gravity != 1) {
            if (gravity != 5 && gravity != 8388613) {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f6 = 0.0f;
        for (int i6 = 0; i6 < lineCount; i6++) {
            f6 = Math.max(f6, getLayout().getLineWidth(i6));
        }
        return (int) Math.ceil(f6);
    }

    private boolean isLayoutRTL() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return true;
        }
        return false;
    }

    private void resetIconDrawable() {
        if (isIconStart()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.icon, null, null, null);
        } else if (isIconEnd()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.icon, null);
        } else if (isIconTop()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.icon, null, null);
        }
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getCornerRadius();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getRippleColor();
        }
        return null;
    }

    @Override // com.google.android.material.shape.Shapeable
    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getShapeAppearanceModel();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeColor();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeWidth();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintList();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintMode();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        MaterialButtonHelper materialButtonHelper;
        super.onLayout(z5, i6, i7, i8, i9);
        if (Build.VERSION.SDK_INT == 21 && (materialButtonHelper = this.materialButtonHelper) != null) {
            materialButtonHelper.updateMaskBounds(i9 - i7, i8 - i6);
        }
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        super.onTextChanged(charSequence, i6, i7, i8);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon != null) {
            if (this.icon.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i6) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setBackgroundColor(i6);
        } else {
            super.setBackgroundColor(i6);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (isUsingOriginalBackground()) {
            if (drawable != getBackground()) {
                this.materialButtonHelper.setBackgroundOverwritten();
                super.setBackgroundDrawable(drawable);
                return;
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z5) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCheckable(z5);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        if (isCheckable() && isEnabled() && this.checked != z5) {
            this.checked = z5;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).onButtonCheckedStateChanged(this, this.checked);
            }
            if (!this.broadcasting) {
                this.broadcasting = true;
                Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
                while (it.hasNext()) {
                    it.next().onCheckedChanged(this, this.checked);
                }
                this.broadcasting = false;
            }
        }
    }

    public void setCornerRadius(@Px int i6) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCornerRadius(i6);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i6) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i6));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f6) {
        super.setElevation(f6);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.getMaterialShapeDrawable().setElevation(f6);
        }
    }

    public void setIconTintResource(@ColorRes int i6) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i6));
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i6) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i6));
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearanceModel(shapeAppearanceModel);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    void setShouldDrawSurfaceColorStroke(boolean z5) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShouldDrawSurfaceColorStroke(z5);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeColor(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i6) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i6));
        }
    }

    public void setStrokeWidth(@Px int i6) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeWidth(i6);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i6) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i6));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintList(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintMode(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setTextAlignment(int i6) {
        super.setTextAlignment(i6);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }
}
