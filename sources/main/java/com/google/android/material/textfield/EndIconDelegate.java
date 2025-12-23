package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.CheckableImageButton;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
abstract class EndIconDelegate {
    final Context context;
    final CheckableImageButton endIconView;
    final EndCompoundLayout endLayout;
    final TextInputLayout textInputLayout;

    @StringRes
    int getIconContentDescriptionResId() {
        return 0;
    }

    @DrawableRes
    int getIconDrawableResId() {
        return 0;
    }

    View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return null;
    }

    View.OnClickListener getOnIconClickListener() {
        return null;
    }

    View.OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return null;
    }

    AccessibilityManagerCompat.TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return null;
    }

    boolean isBoxBackgroundModeSupported(int i6) {
        return true;
    }

    boolean isIconActivable() {
        return false;
    }

    boolean isIconActivated() {
        return false;
    }

    boolean isIconCheckable() {
        return false;
    }

    boolean isIconChecked() {
        return false;
    }

    boolean shouldTintIconOnError() {
        return false;
    }

    final void refreshIconState() {
        this.endLayout.refreshIconState(false);
    }

    EndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout) {
        this.textInputLayout = endCompoundLayout.textInputLayout;
        this.endLayout = endCompoundLayout;
        this.context = endCompoundLayout.getContext();
        this.endIconView = endCompoundLayout.getEndIconView();
    }

    void setUp() {
    }

    void tearDown() {
    }

    void afterEditTextChanged(Editable editable) {
    }

    void onEditTextAttached(@Nullable EditText editText) {
    }

    void onSuffixVisibilityChanged(boolean z5) {
    }

    void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    void beforeEditTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
    }
}
