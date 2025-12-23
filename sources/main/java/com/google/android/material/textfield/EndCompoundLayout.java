package com.google.android.material.textfield;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes5.dex */
class EndCompoundLayout extends LinearLayout {

    @Nullable
    private final AccessibilityManager accessibilityManager;
    private EditText editText;
    private final TextWatcher editTextWatcher;
    private final LinkedHashSet<TextInputLayout.OnEndIconChangedListener> endIconChangedListeners;
    private final EndIconDelegates endIconDelegates;

    @NonNull
    private final FrameLayout endIconFrame;
    private int endIconMinSize;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;

    @NonNull
    private ImageView.ScaleType endIconScaleType;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;

    @NonNull
    private final CheckableImageButton endIconView;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;
    private PorterDuff.Mode errorIconTintMode;

    @NonNull
    private final CheckableImageButton errorIconView;
    private boolean hintExpanded;
    private final TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener;

    @Nullable
    private CharSequence suffixText;

    @NonNull
    private final TextView suffixTextView;
    final TextInputLayout textInputLayout;

    @Nullable
    private AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class EndIconDelegates {
        private final int customEndIconDrawableId;
        private final SparseArray<EndIconDelegate> delegates = new SparseArray<>();
        private final EndCompoundLayout endLayout;
        private final int passwordIconDrawableId;

        private EndIconDelegate create(int i6) {
            if (i6 == -1) {
                return new CustomEndIconDelegate(this.endLayout);
            }
            if (i6 == 0) {
                return new NoEndIconDelegate(this.endLayout);
            }
            if (i6 == 1) {
                return new PasswordToggleEndIconDelegate(this.endLayout, this.passwordIconDrawableId);
            }
            if (i6 == 2) {
                return new ClearTextEndIconDelegate(this.endLayout);
            }
            if (i6 == 3) {
                return new DropdownMenuEndIconDelegate(this.endLayout);
            }
            throw new IllegalArgumentException("Invalid end icon mode: " + i6);
        }

        EndIconDelegate get(int i6) {
            EndIconDelegate endIconDelegate = this.delegates.get(i6);
            if (endIconDelegate != null) {
                return endIconDelegate;
            }
            EndIconDelegate create = create(i6);
            this.delegates.append(i6, create);
            return create;
        }

        EndIconDelegates(EndCompoundLayout endCompoundLayout, TintTypedArray tintTypedArray) {
            this.endLayout = endCompoundLayout;
            this.customEndIconDrawableId = tintTypedArray.getResourceId(R.styleable.TextInputLayout_endIconDrawable, 0);
            this.passwordIconDrawableId = tintTypedArray.getResourceId(R.styleable.TextInputLayout_passwordToggleDrawable, 0);
        }
    }

    void setEndIconContentDescription(@StringRes int i6) {
        setEndIconContentDescription(i6 != 0 ? getResources().getText(i6) : null);
    }

    void setEndIconDrawable(@DrawableRes int i6) {
        setEndIconDrawable(i6 != 0 ? AppCompatResources.getDrawable(getContext(), i6) : null);
    }

    void setErrorIconDrawable(@DrawableRes int i6) {
        setErrorIconDrawable(i6 != 0 ? AppCompatResources.getDrawable(getContext(), i6) : null);
        refreshErrorIconDrawableState();
    }

    void setPasswordVisibilityToggleContentDescription(@StringRes int i6) {
        setPasswordVisibilityToggleContentDescription(i6 != 0 ? getResources().getText(i6) : null);
    }

    void setPasswordVisibilityToggleDrawable(@DrawableRes int i6) {
        setPasswordVisibilityToggleDrawable(i6 != 0 ? AppCompatResources.getDrawable(getContext(), i6) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTouchExplorationStateChangeListenerIfNeeded() {
        if (this.touchExplorationStateChangeListener == null || this.accessibilityManager == null || !ViewCompat.isAttachedToWindow(this)) {
            return;
        }
        AccessibilityManagerCompat.addTouchExplorationStateChangeListener(this.accessibilityManager, this.touchExplorationStateChangeListener);
    }

    private CheckableImageButton createIconView(ViewGroup viewGroup, LayoutInflater layoutInflater, @IdRes int i6) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i6);
        IconHelper.setCompatRippleBackgroundIfNeeded(checkableImageButton);
        if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    private void dispatchOnEndIconChanged(int i6) {
        Iterator<TextInputLayout.OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this.textInputLayout, i6);
        }
    }

    private int getIconResId(EndIconDelegate endIconDelegate) {
        int i6 = this.endIconDelegates.customEndIconDrawableId;
        return i6 == 0 ? endIconDelegate.getIconDrawableResId() : i6;
    }

    private void initEndIconView(TintTypedArray tintTypedArray) {
        int i6 = R.styleable.TextInputLayout_passwordToggleEnabled;
        if (!tintTypedArray.hasValue(i6)) {
            int i7 = R.styleable.TextInputLayout_endIconTint;
            if (tintTypedArray.hasValue(i7)) {
                this.endIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, i7);
            }
            int i8 = R.styleable.TextInputLayout_endIconTintMode;
            if (tintTypedArray.hasValue(i8)) {
                this.endIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(i8, -1), null);
            }
        }
        int i9 = R.styleable.TextInputLayout_endIconMode;
        if (tintTypedArray.hasValue(i9)) {
            setEndIconMode(tintTypedArray.getInt(i9, 0));
            int i10 = R.styleable.TextInputLayout_endIconContentDescription;
            if (tintTypedArray.hasValue(i10)) {
                setEndIconContentDescription(tintTypedArray.getText(i10));
            }
            setEndIconCheckable(tintTypedArray.getBoolean(R.styleable.TextInputLayout_endIconCheckable, true));
        } else if (tintTypedArray.hasValue(i6)) {
            int i11 = R.styleable.TextInputLayout_passwordToggleTint;
            if (tintTypedArray.hasValue(i11)) {
                this.endIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, i11);
            }
            int i12 = R.styleable.TextInputLayout_passwordToggleTintMode;
            if (tintTypedArray.hasValue(i12)) {
                this.endIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(i12, -1), null);
            }
            setEndIconMode(tintTypedArray.getBoolean(i6, false) ? 1 : 0);
            setEndIconContentDescription(tintTypedArray.getText(R.styleable.TextInputLayout_passwordToggleContentDescription));
        }
        setEndIconMinSize(tintTypedArray.getDimensionPixelSize(R.styleable.TextInputLayout_endIconMinSize, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size)));
        int i13 = R.styleable.TextInputLayout_endIconScaleType;
        if (tintTypedArray.hasValue(i13)) {
            setEndIconScaleType(IconHelper.convertScaleType(tintTypedArray.getInt(i13, -1)));
        }
    }

    private void initErrorIconView(TintTypedArray tintTypedArray) {
        int i6 = R.styleable.TextInputLayout_errorIconTint;
        if (tintTypedArray.hasValue(i6)) {
            this.errorIconTintList = MaterialResources.getColorStateList(getContext(), tintTypedArray, i6);
        }
        int i7 = R.styleable.TextInputLayout_errorIconTintMode;
        if (tintTypedArray.hasValue(i7)) {
            this.errorIconTintMode = ViewUtils.parseTintMode(tintTypedArray.getInt(i7, -1), null);
        }
        int i8 = R.styleable.TextInputLayout_errorIconDrawable;
        if (tintTypedArray.hasValue(i8)) {
            setErrorIconDrawable(tintTypedArray.getDrawable(i8));
        }
        this.errorIconView.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(this.errorIconView, 2);
        this.errorIconView.setClickable(false);
        this.errorIconView.setPressable(false);
        this.errorIconView.setFocusable(false);
    }

    private void initSuffixTextView(TintTypedArray tintTypedArray) {
        this.suffixTextView.setVisibility(8);
        this.suffixTextView.setId(R.id.textinput_suffix_text);
        this.suffixTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        ViewCompat.setAccessibilityLiveRegion(this.suffixTextView, 1);
        setSuffixTextAppearance(tintTypedArray.getResourceId(R.styleable.TextInputLayout_suffixTextAppearance, 0));
        int i6 = R.styleable.TextInputLayout_suffixTextColor;
        if (tintTypedArray.hasValue(i6)) {
            setSuffixTextColor(tintTypedArray.getColorStateList(i6));
        }
        setSuffixText(tintTypedArray.getText(R.styleable.TextInputLayout_suffixText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTouchExplorationStateChangeListenerIfNeeded() {
        AccessibilityManager accessibilityManager;
        AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.touchExplorationStateChangeListener;
        if (touchExplorationStateChangeListener == null || (accessibilityManager = this.accessibilityManager) == null) {
            return;
        }
        AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(accessibilityManager, touchExplorationStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOnFocusChangeListenersIfNeeded(EndIconDelegate endIconDelegate) {
        if (this.editText == null) {
            return;
        }
        if (endIconDelegate.getOnEditTextFocusChangeListener() != null) {
            this.editText.setOnFocusChangeListener(endIconDelegate.getOnEditTextFocusChangeListener());
        }
        if (endIconDelegate.getOnIconViewFocusChangeListener() != null) {
            this.endIconView.setOnFocusChangeListener(endIconDelegate.getOnIconViewFocusChangeListener());
        }
    }

    private void tintEndIconOnError(boolean z5) {
        if (!z5 || getEndIconDrawable() == null) {
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
            return;
        }
        Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(mutate, this.textInputLayout.getErrorCurrentTextColors());
        this.endIconView.setImageDrawable(mutate);
    }

    private void updateEndLayoutVisibility() {
        this.endIconFrame.setVisibility((this.endIconView.getVisibility() != 0 || isErrorIconVisible()) ? 8 : 0);
        setVisibility((isEndIconVisible() || isErrorIconVisible() || ((this.suffixText == null || this.hintExpanded) ? '\b' : (char) 0) == 0) ? 0 : 8);
    }

    private void updateSuffixTextVisibility() {
        int visibility = this.suffixTextView.getVisibility();
        int i6 = (this.suffixText == null || this.hintExpanded) ? 8 : 0;
        if (visibility != i6) {
            getEndIconDelegate().onSuffixVisibilityChanged(i6 == 0);
        }
        updateEndLayoutVisibility();
        this.suffixTextView.setVisibility(i6);
        this.textInputLayout.updateDummyDrawables();
    }

    void addOnEndIconChangedListener(@NonNull TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    void checkEndIcon() {
        this.endIconView.performClick();
        this.endIconView.jumpDrawablesToCurrentState();
    }

    void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    @Nullable
    CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    EndIconDelegate getEndIconDelegate() {
        return this.endIconDelegates.get(this.endIconMode);
    }

    @Nullable
    Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    int getEndIconMinSize() {
        return this.endIconMinSize;
    }

    int getEndIconMode() {
        return this.endIconMode;
    }

    @NonNull
    ImageView.ScaleType getEndIconScaleType() {
        return this.endIconScaleType;
    }

    CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    @Nullable
    CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Nullable
    CharSequence getSuffixText() {
        return this.suffixText;
    }

    @Nullable
    ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    boolean isErrorIconVisible() {
        return this.errorIconView.getVisibility() == 0;
    }

    boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    void onHintStateChanged(boolean z5) {
        this.hintExpanded = z5;
        updateSuffixTextVisibility();
    }

    void refreshEndIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.endIconView, this.endIconTintList);
    }

    void refreshErrorIconDrawableState() {
        IconHelper.refreshIconDrawableState(this.textInputLayout, this.errorIconView, this.errorIconTintList);
    }

    void removeOnEndIconChangedListener(@NonNull TextInputLayout.OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    void setEndIconActivated(boolean z5) {
        this.endIconView.setActivated(z5);
    }

    void setEndIconCheckable(boolean z5) {
        this.endIconView.setCheckable(z5);
    }

    void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    void setEndIconDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
        if (drawable != null) {
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
            refreshEndIconDrawableState();
        }
    }

    void setEndIconMinSize(@Px int i6) {
        if (i6 < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (i6 != this.endIconMinSize) {
            this.endIconMinSize = i6;
            IconHelper.setIconMinSize(this.endIconView, i6);
            IconHelper.setIconMinSize(this.errorIconView, i6);
        }
    }

    void setEndIconMode(int i6) {
        if (this.endIconMode == i6) {
            return;
        }
        tearDownDelegate(getEndIconDelegate());
        int i7 = this.endIconMode;
        this.endIconMode = i6;
        dispatchOnEndIconChanged(i7);
        setEndIconVisible(i6 != 0);
        EndIconDelegate endIconDelegate = getEndIconDelegate();
        setEndIconDrawable(getIconResId(endIconDelegate));
        setEndIconContentDescription(endIconDelegate.getIconContentDescriptionResId());
        setEndIconCheckable(endIconDelegate.isIconCheckable());
        if (!endIconDelegate.isBoxBackgroundModeSupported(this.textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + this.textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i6);
        }
        setUpDelegate(endIconDelegate);
        setEndIconOnClickListener(endIconDelegate.getOnIconClickListener());
        EditText editText = this.editText;
        if (editText != null) {
            endIconDelegate.onEditTextAttached(editText);
            setOnFocusChangeListenersIfNeeded(endIconDelegate);
        }
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, this.endIconTintMode);
        refreshIconState(true);
    }

    void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IconHelper.setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        IconHelper.setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    void setEndIconScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.endIconScaleType = scaleType;
        IconHelper.setIconScaleType(this.endIconView, scaleType);
        IconHelper.setIconScaleType(this.errorIconView, scaleType);
    }

    void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, colorStateList, this.endIconTintMode);
        }
    }

    void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, mode);
        }
    }

    void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        IconHelper.setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
    }

    void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        IconHelper.setIconOnLongClickListener(this.errorIconView, onLongClickListener);
    }

    void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.errorIconTintList != colorStateList) {
            this.errorIconTintList = colorStateList;
            IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, colorStateList, this.errorIconTintMode);
        }
    }

    void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.errorIconTintMode != mode) {
            this.errorIconTintMode = mode;
            IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, mode);
        }
    }

    void setPasswordVisibilityToggleEnabled(boolean z5) {
        if (z5 && this.endIconMode != 1) {
            setEndIconMode(1);
        } else {
            if (z5) {
                return;
            }
            setEndIconMode(0);
        }
    }

    void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, colorStateList, this.endIconTintMode);
    }

    void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        IconHelper.applyIconTint(this.textInputLayout, this.endIconView, this.endIconTintList, mode);
    }

    void setSuffixTextAppearance(@StyleRes int i6) {
        TextViewCompat.setTextAppearance(this.suffixTextView, i6);
    }

    void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    void togglePasswordVisibilityToggle(boolean z5) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z5) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    void updateSuffixTextViewPadding() {
        if (this.textInputLayout.editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.textInputLayout.editText.getPaddingTop(), (isEndIconVisible() || isErrorIconVisible()) ? 0 : ViewCompat.getPaddingEnd(this.textInputLayout.editText), this.textInputLayout.editText.getPaddingBottom());
    }

    EndCompoundLayout(TextInputLayout textInputLayout, TintTypedArray tintTypedArray) {
        super(textInputLayout.getContext());
        this.endIconMode = 0;
        this.endIconChangedListeners = new LinkedHashSet<>();
        this.editTextWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.EndCompoundLayout.1
            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EndCompoundLayout.this.getEndIconDelegate().afterEditTextChanged(editable);
            }

            @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
                EndCompoundLayout.this.getEndIconDelegate().beforeEditTextChanged(charSequence, i6, i7, i8);
            }
        };
        TextInputLayout.OnEditTextAttachedListener onEditTextAttachedListener = new TextInputLayout.OnEditTextAttachedListener() { // from class: com.google.android.material.textfield.EndCompoundLayout.2
            @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
            public void onEditTextAttached(@NonNull TextInputLayout textInputLayout2) {
                if (EndCompoundLayout.this.editText == textInputLayout2.getEditText()) {
                    return;
                }
                if (EndCompoundLayout.this.editText != null) {
                    EndCompoundLayout.this.editText.removeTextChangedListener(EndCompoundLayout.this.editTextWatcher);
                    if (EndCompoundLayout.this.editText.getOnFocusChangeListener() == EndCompoundLayout.this.getEndIconDelegate().getOnEditTextFocusChangeListener()) {
                        EndCompoundLayout.this.editText.setOnFocusChangeListener(null);
                    }
                }
                EndCompoundLayout.this.editText = textInputLayout2.getEditText();
                if (EndCompoundLayout.this.editText != null) {
                    EndCompoundLayout.this.editText.addTextChangedListener(EndCompoundLayout.this.editTextWatcher);
                }
                EndCompoundLayout.this.getEndIconDelegate().onEditTextAttached(EndCompoundLayout.this.editText);
                EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
                endCompoundLayout.setOnFocusChangeListenersIfNeeded(endCompoundLayout.getEndIconDelegate());
            }
        };
        this.onEditTextAttachedListener = onEditTextAttachedListener;
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.textInputLayout = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.endIconFrame = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton createIconView = createIconView(this, from, R.id.text_input_error_icon);
        this.errorIconView = createIconView;
        CheckableImageButton createIconView2 = createIconView(frameLayout, from, R.id.text_input_end_icon);
        this.endIconView = createIconView2;
        this.endIconDelegates = new EndIconDelegates(this, tintTypedArray);
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        this.suffixTextView = appCompatTextView;
        initErrorIconView(tintTypedArray);
        initEndIconView(tintTypedArray);
        initSuffixTextView(tintTypedArray);
        frameLayout.addView(createIconView2);
        addView(appCompatTextView);
        addView(frameLayout);
        addView(createIconView);
        textInputLayout.addOnEditTextAttachedListener(onEditTextAttachedListener);
        addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.textfield.EndCompoundLayout.3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                EndCompoundLayout.this.addTouchExplorationStateChangeListenerIfNeeded();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                EndCompoundLayout.this.removeTouchExplorationStateChangeListenerIfNeeded();
            }
        });
    }

    private void setUpDelegate(@NonNull EndIconDelegate endIconDelegate) {
        endIconDelegate.setUp();
        this.touchExplorationStateChangeListener = endIconDelegate.getTouchExplorationStateChangeListener();
        addTouchExplorationStateChangeListenerIfNeeded();
    }

    private void tearDownDelegate(@NonNull EndIconDelegate endIconDelegate) {
        removeTouchExplorationStateChangeListenerIfNeeded();
        this.touchExplorationStateChangeListener = null;
        endIconDelegate.tearDown();
    }

    private void updateErrorIconVisibility() {
        boolean z5;
        int i6 = 0;
        if (getErrorIconDrawable() != null && this.textInputLayout.isErrorEnabled() && this.textInputLayout.shouldShowError()) {
            z5 = true;
        } else {
            z5 = false;
        }
        CheckableImageButton checkableImageButton = this.errorIconView;
        if (!z5) {
            i6 = 8;
        }
        checkableImageButton.setVisibility(i6);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        if (!hasEndIcon()) {
            this.textInputLayout.updateDummyDrawables();
        }
    }

    @Nullable
    CheckableImageButton getCurrentEndIconView() {
        if (isErrorIconVisible()) {
            return this.errorIconView;
        }
        if (hasEndIcon() && isEndIconVisible()) {
            return this.endIconView;
        }
        return null;
    }

    int getSuffixTextEndOffset() {
        int measuredWidth;
        if (!isEndIconVisible() && !isErrorIconVisible()) {
            measuredWidth = 0;
        } else {
            measuredWidth = this.endIconView.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) this.endIconView.getLayoutParams());
        }
        return ViewCompat.getPaddingEnd(this) + ViewCompat.getPaddingEnd(this.suffixTextView) + measuredWidth;
    }

    boolean isEndIconChecked() {
        if (hasEndIcon() && this.endIconView.isChecked()) {
            return true;
        }
        return false;
    }

    void onTextInputBoxStateUpdated() {
        updateErrorIconVisibility();
        refreshErrorIconDrawableState();
        refreshEndIconDrawableState();
        if (getEndIconDelegate().shouldTintIconOnError()) {
            tintEndIconOnError(this.textInputLayout.shouldShowError());
        }
    }

    void refreshIconState(boolean z5) {
        boolean z6;
        boolean isActivated;
        boolean isChecked;
        EndIconDelegate endIconDelegate = getEndIconDelegate();
        boolean z7 = true;
        if (endIconDelegate.isIconCheckable() && (isChecked = this.endIconView.isChecked()) != endIconDelegate.isIconChecked()) {
            this.endIconView.setChecked(!isChecked);
            z6 = true;
        } else {
            z6 = false;
        }
        if (endIconDelegate.isIconActivable() && (isActivated = this.endIconView.isActivated()) != endIconDelegate.isIconActivated()) {
            setEndIconActivated(!isActivated);
        } else {
            z7 = z6;
        }
        if (!z5 && !z7) {
            return;
        }
        refreshEndIconDrawableState();
    }

    void setEndIconVisible(boolean z5) {
        int i6;
        if (isEndIconVisible() != z5) {
            CheckableImageButton checkableImageButton = this.endIconView;
            if (z5) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            checkableImageButton.setVisibility(i6);
            updateEndLayoutVisibility();
            updateSuffixTextViewPadding();
            this.textInputLayout.updateDummyDrawables();
        }
    }

    void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        updateErrorIconVisibility();
        IconHelper.applyIconTint(this.textInputLayout, this.errorIconView, this.errorIconTintList, this.errorIconTintMode);
    }

    void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    void setSuffixText(@Nullable CharSequence charSequence) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        this.suffixText = charSequence2;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }
}
