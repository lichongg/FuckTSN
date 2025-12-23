package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class LocaleManagerCompat {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(33)
    static class Api33Impl {
        @DoNotInline
        static LocaleList localeManagerGetApplicationLocales(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        @DoNotInline
        static LocaleList localeManagerGetSystemLocales(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }

        private Api33Impl() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static LocaleListCompat getLocales(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat getApplicationLocales(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 33) {
            return LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(context));
        }
        Object localeManagerForApplication = getLocaleManagerForApplication(context);
        return localeManagerForApplication != null ? LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(localeManagerForApplication)) : LocaleListCompat.getEmptyLocaleList();
    }

    @VisibleForTesting
    static LocaleListCompat getConfigurationLocales(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? Api24Impl.getLocales(configuration) : LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(configuration.locale));
    }

    @RequiresApi(33)
    private static Object getLocaleManagerForApplication(Context context) {
        return context.getSystemService("locale");
    }

    private LocaleManagerCompat() {
    }

    @NonNull
    @AnyThread
    public static LocaleListCompat getSystemLocales(@NonNull Context context) {
        LocaleListCompat emptyLocaleList = LocaleListCompat.getEmptyLocaleList();
        if (Build.VERSION.SDK_INT >= 33) {
            Object localeManagerForApplication = getLocaleManagerForApplication(context);
            if (localeManagerForApplication != null) {
                return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(localeManagerForApplication));
            }
            return emptyLocaleList;
        }
        return getConfigurationLocales(Resources.getSystem().getConfiguration());
    }
}
