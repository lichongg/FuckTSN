package com.bxkj.base.util;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class w implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    private int f16646a;

    public w() {
        this.f16646a = 2;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i6, int i7, Spanned spanned, int i8, int i9) {
        int length;
        if ("".equals(charSequence.toString())) {
            return null;
        }
        String[] split = spanned.toString().split("\\.");
        if (split.length <= 1 || (length = (split[1].length() + 1) - this.f16646a) <= 0) {
            return null;
        }
        return charSequence.subSequence(i6, i7 - length);
    }

    public w(int i6) {
        this.f16646a = i6;
    }
}
