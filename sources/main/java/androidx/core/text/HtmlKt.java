package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class HtmlKt {
    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i6, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        if ((i7 & 2) != 0) {
            imageGetter = null;
        }
        if ((i7 & 4) != 0) {
            tagHandler = null;
        }
        return HtmlCompat.fromHtml(str, i6, imageGetter, tagHandler);
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        return HtmlCompat.toHtml(spanned, i6);
    }

    @NotNull
    public static final Spanned parseAsHtml(@NotNull String str, int i6, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        return HtmlCompat.fromHtml(str, i6, imageGetter, tagHandler);
    }

    @NotNull
    public static final String toHtml(@NotNull Spanned spanned, int i6) {
        return HtmlCompat.toHtml(spanned, i6);
    }
}
