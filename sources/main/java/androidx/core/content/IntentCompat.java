package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class IntentCompat {

    @SuppressLint({"ActionValue"})
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static <T> T[] getParcelableArrayExtra(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return (T[]) intent.getParcelableArrayExtra(str, cls);
        }

        @DoNotInline
        static <T> ArrayList<T> getParcelableArrayListExtra(@NonNull Intent intent, @Nullable String str, @NonNull Class<? extends T> cls) {
            return intent.getParcelableArrayListExtra(str, cls);
        }

        @DoNotInline
        static <T> T getParcelableExtra(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return (T) intent.getParcelableExtra(str, cls);
        }

        @DoNotInline
        static <T extends Serializable> T getSerializableExtra(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
            return (T) intent.getSerializableExtra(str, cls);
        }
    }

    @Nullable
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static Parcelable[] getParcelableArrayExtra(@NonNull Intent intent, @Nullable String str, @NonNull Class<? extends Parcelable> cls) {
        return Build.VERSION.SDK_INT >= 34 ? (Parcelable[]) Api33Impl.getParcelableArrayExtra(intent, str, cls) : intent.getParcelableArrayExtra(str);
    }

    @Nullable
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> getParcelableArrayListExtra(@NonNull Intent intent, @Nullable String str, @NonNull Class<? extends T> cls) {
        return Build.VERSION.SDK_INT >= 34 ? Api33Impl.getParcelableArrayListExtra(intent, str, cls) : intent.getParcelableArrayListExtra(str);
    }

    @Nullable
    public static <T> T getParcelableExtra(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (T) Api33Impl.getParcelableExtra(intent, str, cls);
        }
        T t5 = (T) intent.getParcelableExtra(str);
        if (cls.isInstance(t5)) {
            return t5;
        }
        return null;
    }

    @Nullable
    public static <T extends Serializable> T getSerializableExtra(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return (T) Api33Impl.getSerializableExtra(intent, str, cls);
        }
        T t5 = (T) intent.getSerializableExtra(str);
        if (cls.isInstance(t5)) {
            return t5;
        }
        return null;
    }

    private IntentCompat() {
    }

    @NonNull
    public static Intent createManageUnusedAppRestrictionsIntent(@NonNull Context context, @NonNull String str) {
        if (PackageManagerCompat.areUnusedAppRestrictionsAvailable(context.getPackageManager())) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 31) {
                return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, str, null));
            }
            Intent data = new Intent(PackageManagerCompat.ACTION_PERMISSION_REVOCATION_SETTINGS).setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, str, null));
            if (i6 >= 30) {
                return data;
            }
            return data.setPackage((String) Preconditions.checkNotNull(PackageManagerCompat.getPermissionRevocationVerifierApp(context.getPackageManager())));
        }
        throw new UnsupportedOperationException("Unused App Restriction features are not available on this device");
    }

    @NonNull
    public static Intent makeMainSelectorActivity(@NonNull String str, @NonNull String str2) {
        return Intent.makeMainSelectorActivity(str, str2);
    }
}
