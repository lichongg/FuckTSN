package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LocaleKt {
    public static final int getLayoutDirection(@NotNull Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
