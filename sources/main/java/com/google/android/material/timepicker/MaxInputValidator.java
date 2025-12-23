package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class MaxInputValidator implements InputFilter {
    private int max;

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i8, i9, charSequence.subSequence(i6, i7).toString());
            if (Integer.parseInt(sb.toString()) <= this.max) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i6) {
        this.max = i6;
    }

    public MaxInputValidator(int i6) {
        this.max = i6;
    }
}
