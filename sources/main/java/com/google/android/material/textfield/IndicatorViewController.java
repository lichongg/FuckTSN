package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class IndicatorViewController {
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    static final int COUNTER_INDEX = 2;
    private static final int DEFAULT_CAPTION_FADE_ANIMATION_DURATION = 167;
    private static final int DEFAULT_CAPTION_TRANSLATION_Y_ANIMATION_DURATION = 217;
    static final int ERROR_INDEX = 0;
    static final int HELPER_INDEX = 1;

    @Nullable
    private Animator captionAnimator;
    private FrameLayout captionArea;
    private int captionDisplayed;
    private final int captionFadeInAnimationDuration;

    @NonNull
    private final TimeInterpolator captionFadeInAnimationInterpolator;
    private final int captionFadeOutAnimationDuration;

    @NonNull
    private final TimeInterpolator captionFadeOutAnimationInterpolator;
    private int captionToShow;
    private final int captionTranslationYAnimationDuration;

    @NonNull
    private final TimeInterpolator captionTranslationYAnimationInterpolator;
    private final float captionTranslationYPx;
    private final Context context;
    private boolean errorEnabled;

    @Nullable
    private CharSequence errorText;
    private int errorTextAppearance;

    @Nullable
    private TextView errorView;
    private int errorViewAccessibilityLiveRegion;

    @Nullable
    private CharSequence errorViewContentDescription;

    @Nullable
    private ColorStateList errorViewTextColor;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;

    @Nullable
    private TextView helperTextView;

    @Nullable
    private ColorStateList helperTextViewTextColor;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;

    @NonNull
    private final TextInputLayout textInputView;
    private Typeface typeface;

    @Nullable
    private TextView getCaptionViewFromDisplayState(int i6) {
        if (i6 == 1) {
            return this.errorView;
        }
        if (i6 != 2) {
            return null;
        }
        return this.helperTextView;
    }

    private boolean isCaptionStateError(int i6) {
        return (i6 != 1 || this.errorView == null || TextUtils.isEmpty(this.errorText)) ? false : true;
    }

    private boolean isCaptionStateHelperText(int i6) {
        return (i6 != 2 || this.helperTextView == null || TextUtils.isEmpty(this.helperText)) ? false : true;
    }

    void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (!this.helperTextEnabled || TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 0;
            } else {
                this.captionToShow = 2;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, ""));
    }

    boolean isCaptionView(int i6) {
        return i6 == 0 || i6 == 1;
    }

    private boolean canAdjustIndicatorPadding() {
        return (this.indicatorArea == null || this.textInputView.getEditText() == null) ? false : true;
    }

    private void createCaptionAnimators(@NonNull List<Animator> list, boolean z5, @Nullable TextView textView, int i6, int i7, int i8) {
        if (textView == null || !z5) {
            return;
        }
        if (i6 == i8 || i6 == i7) {
            ObjectAnimator createCaptionOpacityAnimator = createCaptionOpacityAnimator(textView, i8 == i6);
            if (i6 == i8 && i7 != 0) {
                createCaptionOpacityAnimator.setStartDelay(this.captionFadeOutAnimationDuration);
            }
            list.add(createCaptionOpacityAnimator);
            if (i8 != i6 || i7 == 0) {
                return;
            }
            ObjectAnimator createCaptionTranslationYAnimator = createCaptionTranslationYAnimator(textView);
            createCaptionTranslationYAnimator.setStartDelay(this.captionFadeOutAnimationDuration);
            list.add(createCaptionTranslationYAnimator);
        }
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView textView, boolean z5) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z5 ? 1.0f : 0.0f);
        ofFloat.setDuration(z5 ? this.captionFadeInAnimationDuration : this.captionFadeOutAnimationDuration);
        ofFloat.setInterpolator(z5 ? this.captionFadeInAnimationInterpolator : this.captionFadeOutAnimationInterpolator);
        return ofFloat;
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.captionTranslationYPx, 0.0f);
        ofFloat.setDuration(this.captionTranslationYAnimationDuration);
        ofFloat.setInterpolator(this.captionTranslationYAnimationInterpolator);
        return ofFloat;
    }

    private int getIndicatorPadding(boolean z5, @DimenRes int i6, int i7) {
        return z5 ? this.context.getResources().getDimensionPixelSize(i6) : i7;
    }

    private void setCaptionViewVisibilities(int i6, int i7) {
        TextView captionViewFromDisplayState;
        TextView captionViewFromDisplayState2;
        if (i6 == i7) {
            return;
        }
        if (i7 != 0 && (captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i7)) != null) {
            captionViewFromDisplayState2.setVisibility(0);
            captionViewFromDisplayState2.setAlpha(1.0f);
        }
        if (i6 != 0 && (captionViewFromDisplayState = getCaptionViewFromDisplayState(i6)) != null) {
            captionViewFromDisplayState.setVisibility(4);
            if (i6 == 1) {
                captionViewFromDisplayState.setText((CharSequence) null);
            }
        }
        this.captionDisplayed = i7;
    }

    private void setTextViewTypeface(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void setViewGroupGoneIfEmpty(@NonNull ViewGroup viewGroup, int i6) {
        if (i6 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean shouldAnimateCaptionView(@Nullable TextView textView, @NonNull CharSequence charSequence) {
        if (ViewCompat.isLaidOut(this.textInputView) && this.textInputView.isEnabled()) {
            return (this.captionToShow == this.captionDisplayed && textView != null && TextUtils.equals(textView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    private void updateCaptionViewsVisibility(final int i6, final int i7, boolean z5) {
        IndicatorViewController indicatorViewController;
        if (i6 == i7) {
            return;
        }
        if (z5) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.captionAnimator = animatorSet;
            ArrayList arrayList = new ArrayList();
            indicatorViewController = this;
            indicatorViewController.createCaptionAnimators(arrayList, this.helperTextEnabled, this.helperTextView, 2, i6, i7);
            indicatorViewController.createCaptionAnimators(arrayList, indicatorViewController.errorEnabled, indicatorViewController.errorView, 1, i6, i7);
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            final TextView captionViewFromDisplayState = getCaptionViewFromDisplayState(i6);
            final TextView captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i7);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.IndicatorViewController.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    IndicatorViewController.this.captionDisplayed = i7;
                    IndicatorViewController.this.captionAnimator = null;
                    TextView textView = captionViewFromDisplayState;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i6 == 1 && IndicatorViewController.this.errorView != null) {
                            IndicatorViewController.this.errorView.setText((CharSequence) null);
                        }
                    }
                    TextView textView2 = captionViewFromDisplayState2;
                    if (textView2 != null) {
                        textView2.setTranslationY(0.0f);
                        captionViewFromDisplayState2.setAlpha(1.0f);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    TextView textView = captionViewFromDisplayState2;
                    if (textView != null) {
                        textView.setVisibility(0);
                        captionViewFromDisplayState2.setAlpha(0.0f);
                    }
                }
            });
            animatorSet.start();
        } else {
            indicatorViewController = this;
            setCaptionViewVisibilities(i6, i7);
        }
        indicatorViewController.textInputView.updateEditTextBackground();
        indicatorViewController.textInputView.updateLabelState(z5);
        indicatorViewController.textInputView.updateTextInputBoxState();
    }

    void addIndicator(TextView textView, int i6) {
        if (this.indicatorArea == null && this.captionArea == null) {
            LinearLayout linearLayout = new LinearLayout(this.context);
            this.indicatorArea = linearLayout;
            linearLayout.setOrientation(0);
            this.textInputView.addView(this.indicatorArea, -1, -2);
            this.captionArea = new FrameLayout(this.context);
            this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.textInputView.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (isCaptionView(i6)) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(textView);
        } else {
            this.indicatorArea.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    void cancelCaptionAnimator() {
        Animator animator = this.captionAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean errorIsDisplayed() {
        return isCaptionStateError(this.captionDisplayed);
    }

    boolean errorShouldBeShown() {
        return isCaptionStateError(this.captionToShow);
    }

    int getErrorAccessibilityLiveRegion() {
        return this.errorViewAccessibilityLiveRegion;
    }

    @Nullable
    CharSequence getErrorContentDescription() {
        return this.errorViewContentDescription;
    }

    @Nullable
    CharSequence getErrorText() {
        return this.errorText;
    }

    @ColorInt
    int getErrorViewCurrentTextColor() {
        TextView textView = this.errorView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    ColorStateList getErrorViewTextColors() {
        TextView textView = this.errorView;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence getHelperText() {
        return this.helperText;
    }

    @Nullable
    View getHelperTextView() {
        return this.helperTextView;
    }

    @Nullable
    ColorStateList getHelperTextViewColors() {
        TextView textView = this.helperTextView;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    @ColorInt
    int getHelperTextViewCurrentTextColor() {
        TextView textView = this.helperTextView;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    boolean helperTextIsDisplayed() {
        return isCaptionStateHelperText(this.captionDisplayed);
    }

    boolean helperTextShouldBeShown() {
        return isCaptionStateHelperText(this.captionToShow);
    }

    boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    void removeIndicator(TextView textView, int i6) {
        FrameLayout frameLayout;
        if (this.indicatorArea == null) {
            return;
        }
        if (!isCaptionView(i6) || (frameLayout = this.captionArea) == null) {
            this.indicatorArea.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i7 = this.indicatorsAdded - 1;
        this.indicatorsAdded = i7;
        setViewGroupGoneIfEmpty(this.indicatorArea, i7);
    }

    void setErrorAccessibilityLiveRegion(int i6) {
        this.errorViewAccessibilityLiveRegion = i6;
        TextView textView = this.errorView;
        if (textView != null) {
            ViewCompat.setAccessibilityLiveRegion(textView, i6);
        }
    }

    void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.errorViewContentDescription = charSequence;
        TextView textView = this.errorView;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void setErrorEnabled(boolean z5) {
        if (this.errorEnabled == z5) {
            return;
        }
        cancelCaptionAnimator();
        if (z5) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.context);
            this.errorView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            this.errorView.setTextAlignment(5);
            Typeface typeface = this.typeface;
            if (typeface != null) {
                this.errorView.setTypeface(typeface);
            }
            setErrorTextAppearance(this.errorTextAppearance);
            setErrorViewTextColor(this.errorViewTextColor);
            setErrorContentDescription(this.errorViewContentDescription);
            setErrorAccessibilityLiveRegion(this.errorViewAccessibilityLiveRegion);
            this.errorView.setVisibility(4);
            addIndicator(this.errorView, 0);
        } else {
            hideError();
            removeIndicator(this.errorView, 0);
            this.errorView = null;
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateTextInputBoxState();
        }
        this.errorEnabled = z5;
    }

    void setErrorTextAppearance(@StyleRes int i6) {
        this.errorTextAppearance = i6;
        TextView textView = this.errorView;
        if (textView != null) {
            this.textInputView.setTextAppearanceCompatWithErrorFallback(textView, i6);
        }
    }

    void setErrorViewTextColor(@Nullable ColorStateList colorStateList) {
        this.errorViewTextColor = colorStateList;
        TextView textView = this.errorView;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void setHelperTextAppearance(@StyleRes int i6) {
        this.helperTextTextAppearance = i6;
        TextView textView = this.helperTextView;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i6);
        }
    }

    void setHelperTextEnabled(boolean z5) {
        if (this.helperTextEnabled == z5) {
            return;
        }
        cancelCaptionAnimator();
        if (z5) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.context);
            this.helperTextView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            this.helperTextView.setTextAlignment(5);
            Typeface typeface = this.typeface;
            if (typeface != null) {
                this.helperTextView.setTypeface(typeface);
            }
            this.helperTextView.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.helperTextView, 1);
            setHelperTextAppearance(this.helperTextTextAppearance);
            setHelperTextViewTextColor(this.helperTextViewTextColor);
            addIndicator(this.helperTextView, 1);
            this.helperTextView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.google.android.material.textfield.IndicatorViewController.2
                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    EditText editText = IndicatorViewController.this.textInputView.getEditText();
                    if (editText != null) {
                        accessibilityNodeInfo.setLabeledBy(editText);
                    }
                }
            });
        } else {
            hideHelperText();
            removeIndicator(this.helperTextView, 1);
            this.helperTextView = null;
            this.textInputView.updateEditTextBackground();
            this.textInputView.updateTextInputBoxState();
        }
        this.helperTextEnabled = z5;
    }

    void setHelperTextViewTextColor(@Nullable ColorStateList colorStateList) {
        this.helperTextViewTextColor = colorStateList;
        TextView textView = this.helperTextView;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void setTypefaces(Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            setTextViewTypeface(this.errorView, typeface);
            setTextViewTypeface(this.helperTextView, typeface);
        }
    }

    public IndicatorViewController(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.context = context;
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        int i6 = R.attr.motionDurationShort4;
        this.captionTranslationYAnimationDuration = MotionUtils.resolveThemeDuration(context, i6, DEFAULT_CAPTION_TRANSLATION_Y_ANIMATION_DURATION);
        this.captionFadeInAnimationDuration = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationMedium4, 167);
        this.captionFadeOutAnimationDuration = MotionUtils.resolveThemeDuration(context, i6, 167);
        int i7 = R.attr.motionEasingEmphasizedDecelerateInterpolator;
        this.captionTranslationYAnimationInterpolator = MotionUtils.resolveThemeInterpolator(context, i7, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        this.captionFadeInAnimationInterpolator = MotionUtils.resolveThemeInterpolator(context, i7, timeInterpolator);
        this.captionFadeOutAnimationInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingLinearInterpolator, timeInterpolator);
    }

    void adjustIndicatorPadding() {
        if (canAdjustIndicatorPadding()) {
            EditText editText = this.textInputView.getEditText();
            boolean isFontScaleAtLeast1_3 = MaterialResources.isFontScaleAtLeast1_3(this.context);
            LinearLayout linearLayout = this.indicatorArea;
            int i6 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            ViewCompat.setPaddingRelative(linearLayout, getIndicatorPadding(isFontScaleAtLeast1_3, i6, ViewCompat.getPaddingStart(editText)), getIndicatorPadding(isFontScaleAtLeast1_3, R.dimen.material_helper_text_font_1_3_padding_top, this.context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), getIndicatorPadding(isFontScaleAtLeast1_3, i6, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    void hideHelperText() {
        cancelCaptionAnimator();
        int i6 = this.captionDisplayed;
        if (i6 == 2) {
            this.captionToShow = 0;
        }
        updateCaptionViewsVisibility(i6, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, ""));
    }

    void showError(CharSequence charSequence) {
        cancelCaptionAnimator();
        this.errorText = charSequence;
        this.errorView.setText(charSequence);
        int i6 = this.captionDisplayed;
        if (i6 != 1) {
            this.captionToShow = 1;
        }
        updateCaptionViewsVisibility(i6, this.captionToShow, shouldAnimateCaptionView(this.errorView, charSequence));
    }

    void showHelper(CharSequence charSequence) {
        cancelCaptionAnimator();
        this.helperText = charSequence;
        this.helperTextView.setText(charSequence);
        int i6 = this.captionDisplayed;
        if (i6 != 2) {
            this.captionToShow = 2;
        }
        updateCaptionViewsVisibility(i6, this.captionToShow, shouldAnimateCaptionView(this.helperTextView, charSequence));
    }
}
