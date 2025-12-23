package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSpannableString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n+ 2 SpannedString.kt\nandroidx/core/text/SpannedStringKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,66:1\n31#2,4:67\n13579#3,2:71\n*S KotlinDebug\n*F\n+ 1 SpannableString.kt\nandroidx/core/text/SpannableStringKt\n*L\n32#1:67,4\n32#1:71,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class SpannableStringKt {
    public static final void set(@NotNull Spannable spannable, int i6, int i7, @NotNull Object obj) {
        spannable.setSpan(obj, i6, i7, 17);
    }

    public static final void set(@NotNull Spannable spannable, @NotNull kotlin.ranges.m mVar, @NotNull Object obj) {
        spannable.setSpan(obj, mVar.getStart().intValue(), mVar.getEndInclusive().intValue(), 17);
    }

    public static final void clearSpans(@NotNull Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }
}
