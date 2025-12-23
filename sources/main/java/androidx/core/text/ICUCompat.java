package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    static class Api24Impl {
        @DoNotInline
        static ULocale addLikelySubtags(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        @DoNotInline
        static String getScript(Object obj) {
            return ((ULocale) obj).getScript();
        }

        private Api24Impl() {
        }

        @DoNotInline
        static ULocale forLocale(Locale locale) {
            return ULocale.forLocale(locale);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String getScriptBelowApi21(String str) {
        try {
            Method method = sGetScriptMethod;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String getScript(Locale locale) {
            return locale.getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e6) {
                throw new IllegalStateException(e6);
            }
        }
    }

    @Nullable
    public static String maximizeAndGetScript(@NonNull Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(locale)));
        }
        try {
            return Api21Impl.getScript((Locale) sAddLikelySubtagsMethod.invoke(null, locale));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return Api21Impl.getScript(locale);
        }
    }

    private ICUCompat() {
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String addLikelySubtagsBelowApi21(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = sAddLikelySubtagsMethod;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return locale2;
    }
}
