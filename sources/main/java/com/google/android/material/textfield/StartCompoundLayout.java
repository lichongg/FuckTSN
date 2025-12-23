package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes5.dex */
class StartCompoundLayout extends LinearLayout {
    private boolean hintExpanded;

    @Nullable
    private CharSequence prefixText;
    private final TextView prefixTextView;
    private int startIconMinSize;
    private View.OnLongClickListener startIconOnLongClickListener;

    @NonNull
    private ImageView.ScaleType startIconScaleType;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final TextInputLayout textInputLayout;

    private void initPrefixTextView(TintTypedArray tintTypedArray) {
        this.prefixTextView.setVisibility(8);
        this.prefixTextView.setId(R.id.textinput_prefix_text);
        this.prefixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(this.prefixTextView, 1);
        setPrefixTextAppearance(tintTypedArray.getResourceId(R.styleable.TextInputLayout_prefixTextAppearance, 0));
        int i6 = R.styleable.TextInputLayout_prefixTextColor;
        if (tintTypedArray.hasValue(i6)) {
            setPrefixTextColor(tintTypedArray.getColorStateList(i6));
        }
        setPrefixText(tintTypedArray.getText(R.styleable.TextInputLayout_prefixText));
    }

    private void updateVisibility() {
        int i6 = (this.prefixText == null || this.hintExpanded) ? 8 : 0;
        setVisibility((this.startIconView.getVisibility() == 0 || i6 == 0) ? 0 : 8);
        this.prefixTextView.setVisibility(i6);
        this.textInputLayout.updateDummyDrawables();
    }

    @Nullable
    CharSequence getPrefixText() {
        return this.prefixText;
    }

    @Nullable
    ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    @NonNull
    TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    @Nullable
    CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    @Nullable
    Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    int getStartIconMinSize() {
        return this.startIconMinSize;
    }

    @NonNull
    ImageView.ScaleType getStartIconScaleType() {
        return this.startIconScaleType;
    }

    boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    void onHintStateChanged(boolean z5) {
        this.hintExpanded = z5;
        updateVisibility();
    }

    void refreshStartIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.startIconView, this.startIconTintList);
    }

    void setPrefixTextAppearance(@StyleRes int i6) {
        TextViewCompat.setTextAppearance(this.prefixTextView, i6);
    }

    void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    void setStartIconCheckable(boolean z5) {
        this.startIconView.setCheckable(z5);
    }

    void setStartIconDrawable(@Nullable Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, this.startIconTintMode);
            setStartIconVisible(true);
            refreshStartIconDrawableState();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription(null);
        }
    }

    void setStartIconMinSize(@Px int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        }
        if (i6 != this.startIconMinSize) {
            this.startIconMinSize = i6;
            IconHelper.setIconMinSize(this.startIconView, i6);
        }
    }

    void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IconHelper.setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        IconHelper.setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    void setStartIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.startIconScaleType = scaleType;
        IconHelper.setIconScaleType(this.startIconView, scaleType);
    }

    void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, colorStateList, this.startIconTintMode);
        }
    }

    void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            IconHelper.applyIconTint(this.textInputLayout, this.startIconView, this.startIconTintList, mode);
        }
    }

    void setupAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.prefixTextView.getVisibility() != 0) {
            accessibilityNodeInfoCompat.setTraversalAfter(this.startIconView);
        } else {
            accessibilityNodeInfoCompat.setLabelFor(this.prefixTextView);
            accessibilityNodeInfoCompat.setTraversalAfter(this.prefixTextView);
        }
    }

    void updatePrefixTextViewPadding() {
        EditText editText = this.textInputLayout.editText;
        if (editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.prefixTextView, isStartIconVisible() ? 0 : ViewCompat.getPaddingStart(editText), editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
    }

    StartCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.textInputLayout = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.startIconView = checkableImageButton;
        IconHelper.setCompatRippleBackgroundIfNeeded(checkableImageButton);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.prefixTextView = appCompatTextView;
        initStartIconView(tintTypedArray);
        initPrefixTextView(tintTypedArray);
        addView(checkableImageButton);
        addView(appCompatTextView);
    }

    private void initStartIconView(TintTypedArray tintTypedArray) {
        if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i6 = R.styleable.TextInputLayout_startIconTint;
        if (tintTypedArray.hasValue(i6)) {
            this.startIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, i6);
        }
        int i7 = R.styleable.TextInputLayout_startIconTintMode;
        if (tintTypedArray.hasValue(i7)) {
            this.startIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(i7, -1), null);
        }
        int i8 = R.styleable.TextInputLayout_startIconDrawable;
        if (tintTypedArray.hasValue(i8)) {
            setStartIconDrawable(tintTypedArray.getDrawable(i8));
            int i9 = R.styleable.TextInputLayout_startIconContentDescription;
            if (tintTypedArray.hasValue(i9)) {
                setStartIconContentDescription(tintTypedArray.getText(i9));
            }
            setStartIconCheckable(tintTypedArray.getBoolean(R.styleable.TextInputLayout_startIconCheckable, true));
        }
        setStartIconMinSize(tintTypedArray.getDimensionPixelSize(R.styleable.TextInputLayout_startIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        int i10 = R.styleable.TextInputLayout_startIconScaleType;
        if (tintTypedArray.hasValue(i10)) {
            setStartIconScaleType(IconHelper.convertScaleType(tintTypedArray.getInt(i10, -1)));
        }
    }

    int getPrefixTextStartOffset() {
        int i6;
        if (isStartIconVisible()) {
            i6 = this.startIconView.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) this.startIconView.getLayoutParams());
        } else {
            i6 = 0;
        }
        return ViewCompat.getPaddingStart(this) + ViewCompat.getPaddingStart(this.prefixTextView) + i6;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        updatePrefixTextViewPadding();
    }

    void setPrefixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.prefixText = charSequence2;
        this.prefixTextView.setText(charSequence);
        updateVisibility();
    }

    void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    void setStartIconVisible(boolean z5) {
        int i6;
        if (isStartIconVisible() != z5) {
            CheckableImageButton checkableImageButton = this.startIconView;
            if (z5) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            checkableImageButton.setVisibility(i6);
            updatePrefixTextViewPadding();
            updateVisibility();
        }
    }
}
