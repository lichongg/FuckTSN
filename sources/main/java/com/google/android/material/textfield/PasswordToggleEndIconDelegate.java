package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class PasswordToggleEndIconDelegate extends EndIconDelegate {

    @Nullable
    private EditText editText;
    private int iconResId;
    private final View.OnClickListener onIconClickListener;

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isIconCheckable() {
        return true;
    }

    public static /* synthetic */ void a(PasswordToggleEndIconDelegate passwordToggleEndIconDelegate, View view) {
        EditText editText = passwordToggleEndIconDelegate.editText;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        if (passwordToggleEndIconDelegate.hasPasswordTransformation()) {
            passwordToggleEndIconDelegate.editText.setTransformationMethod(null);
        } else {
            passwordToggleEndIconDelegate.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            passwordToggleEndIconDelegate.editText.setSelection(selectionEnd);
        }
        passwordToggleEndIconDelegate.refreshIconState();
    }

    private boolean hasPasswordTransformation() {
        EditText editText = this.editText;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean isInputTypePassword(EditText editText) {
        if (editText != null) {
            return editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    @StringRes
    int getIconContentDescriptionResId() {
        return R.string.password_toggle_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    @DrawableRes
    int getIconDrawableResId() {
        return this.iconResId;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void onEditTextAttached(@Nullable EditText editText) {
        this.editText = editText;
        refreshIconState();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void setUp() {
        if (isInputTypePassword(this.editText)) {
            this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void tearDown() {
        EditText editText = this.editText;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    PasswordToggleEndIconDelegate(@NonNull EndCompoundLayout endCompoundLayout, @DrawableRes int i6) {
        super(endCompoundLayout);
        this.iconResId = R.drawable.design_password_eye;
        this.onIconClickListener = new View.OnClickListener() { // from class: com.google.android.material.textfield.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordToggleEndIconDelegate.a(PasswordToggleEndIconDelegate.this, view);
            }
        };
        if (i6 != 0) {
            this.iconResId = i6;
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    void beforeEditTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        refreshIconState();
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    boolean isIconChecked() {
        return !hasPasswordTransformation();
    }
}
