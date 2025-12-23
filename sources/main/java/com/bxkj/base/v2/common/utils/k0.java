package com.bxkj.base.v2.common.utils;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.annotation.ColorInt;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k0 f16922a = new k0();

    @NotNull
    public final SpannableString a(@NotNull CharSequence string, @ColorInt int i6) {
        kotlin.jvm.internal.g0.p(string, "string");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(i6), 0, string.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, string.length(), 33);
        return spannableString;
    }

    private k0() {
    }
}
