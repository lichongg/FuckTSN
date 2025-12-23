package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip chip;
    private final EditText editText;
    private TextView label;
    private final TextInputLayout textInputLayout;
    private TextWatcher watcher;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.google.android.material.timepicker.ChipTextInputComboView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class TextFormatter extends TextWatcherAdapter {
        private static final String DEFAULT_TEXT = "00";

        private TextFormatter() {
        }

        /* synthetic */ TextFormatter(ChipTextInputComboView chipTextInputComboView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(editable)) {
                String formatText = ChipTextInputComboView.this.formatText(editable);
                Chip chip = ChipTextInputComboView.this.chip;
                if (TextUtils.isEmpty(formatText)) {
                    formatText = ChipTextInputComboView.this.formatText(DEFAULT_TEXT);
                }
                chip.setText(formatText);
                return;
            }
            ChipTextInputComboView.this.chip.setText(ChipTextInputComboView.this.formatText(DEFAULT_TEXT));
        }
    }

    public ChipTextInputComboView(@NonNull Context context) {
        this(context, null);
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void updateHintLocales() {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = getContext().getResources().getConfiguration().getLocales();
            this.editText.setImeHintLocales(locales);
        }
    }

    public void addInputFilter(InputFilter inputFilter) {
        InputFilter[] filters = this.editText.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.editText.setFilters(inputFilterArr);
    }

    @VisibleForTesting
    CharSequence getChipText() {
        return this.chip.getText();
    }

    public TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        this.chip.setChecked(z5);
        this.editText.setVisibility(z5 ? 0 : 4);
        this.chip.setVisibility(z5 ? 8 : 0);
        if (isChecked()) {
            ViewUtils.requestFocusAndShowKeyboard(this.editText, false);
        }
    }

    public void setChipDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.chip, accessibilityDelegateCompat);
    }

    public void setCursorVisible(boolean z5) {
        this.editText.setCursorVisible(z5);
    }

    public void setHelperText(CharSequence charSequence) {
        this.label.setText(charSequence);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.chip.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i6, Object obj) {
        this.chip.setTag(i6, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.chip.toggle();
    }

    public ChipTextInputComboView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.chip = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.textInputLayout = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.editText = editText;
        editText.setVisibility(4);
        TextFormatter textFormatter = new TextFormatter(this, null);
        this.watcher = textFormatter;
        editText.addTextChangedListener(textFormatter);
        updateHintLocales();
        addView(chip);
        addView(textInputLayout);
        this.label = (TextView) findViewById(R.id.material_label);
        editText.setId(ViewCompat.generateViewId());
        ViewCompat.setLabelFor(this.label, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatText(CharSequence charSequence) {
        return TimeModel.formatText(getResources(), charSequence);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateHintLocales();
    }

    public void setText(CharSequence charSequence) {
        String formatText = formatText(charSequence);
        this.chip.setText(formatText);
        if (!TextUtils.isEmpty(formatText)) {
            this.editText.removeTextChangedListener(this.watcher);
            this.editText.setText(formatText);
            this.editText.addTextChangedListener(this.watcher);
        }
    }
}
