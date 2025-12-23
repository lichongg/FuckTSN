package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat;
import com.bjtsn.pose_detection.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Locale;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zac {

    @GuardedBy("cache")
    private static final SimpleArrayMap zaa = new SimpleArrayMap();

    @Nullable
    @GuardedBy("cache")
    private static Locale zab;

    @NonNull
    public static String zad(Context context, int i6) {
        return (i6 == 6 || i6 == 19) ? zag(context, "common_google_play_services_resolution_required_text", zaa(context)) : zac(context, i6);
    }

    @NonNull
    public static String zae(Context context, int i6) {
        String zah = i6 == 6 ? zah(context, "common_google_play_services_resolution_required_title") : zaf(context, i6);
        return zah == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : zah;
    }

    @Nullable
    private static String zah(Context context, String str) {
        SimpleArrayMap simpleArrayMap = zaa;
        synchronized (simpleArrayMap) {
            try {
                Locale locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0);
                if (!locale.equals(zab)) {
                    simpleArrayMap.clear();
                    zab = locale;
                }
                String str2 = (String) simpleArrayMap.get(str);
                if (str2 != null) {
                    return str2;
                }
                Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
                if (remoteResource == null) {
                    return null;
                }
                int identifier = remoteResource.getIdentifier(str, ResIdentify.RES_TYPE_STRING, "com.google.android.gms");
                if (identifier == 0) {
                    return null;
                }
                String string = remoteResource.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                simpleArrayMap.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            if (TextUtils.isEmpty(str)) {
                return packageName;
            }
            return str;
        }
    }

    @NonNull
    public static String zab(Context context, int i6) {
        Resources resources = context.getResources();
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    return resources.getString(android.R.string.ok);
                }
                return resources.getString(R.string.common_google_play_services_enable_button);
            }
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        return resources.getString(R.string.common_google_play_services_install_button);
    }

    @NonNull
    public static String zac(Context context, int i6) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 != 3) {
                    if (i6 != 5) {
                        if (i6 != 7) {
                            if (i6 != 9) {
                                if (i6 != 20) {
                                    switch (i6) {
                                        case 16:
                                            return zag(context, "common_google_play_services_api_unavailable_text", zaa2);
                                        case 17:
                                            return zag(context, "common_google_play_services_sign_in_failed_text", zaa2);
                                        case 18:
                                            return resources.getString(R.string.common_google_play_services_updating_text, zaa2);
                                        default:
                                            return resources.getString(R.string.common_google_play_services_unknown_issue, zaa2);
                                    }
                                }
                                return zag(context, "common_google_play_services_restricted_profile_text", zaa2);
                            }
                            return resources.getString(R.string.common_google_play_services_unsupported_text, zaa2);
                        }
                        return zag(context, "common_google_play_services_network_error_text", zaa2);
                    }
                    return zag(context, "common_google_play_services_invalid_account_text", zaa2);
                }
                return resources.getString(R.string.common_google_play_services_enable_text, zaa2);
            }
            if (DeviceProperties.isWearableWithoutPlayStore(context)) {
                return resources.getString(R.string.common_google_play_services_wear_update_text);
            }
            return resources.getString(R.string.common_google_play_services_update_text, zaa2);
        }
        return resources.getString(R.string.common_google_play_services_install_text, zaa2);
    }

    @Nullable
    public static String zaf(Context context, int i6) {
        Resources resources = context.getResources();
        switch (i6) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                return zah(context, "common_google_play_services_invalid_account_title");
            case 7:
                return zah(context, "common_google_play_services_network_error_title");
            case 8:
            case 9:
            case 10:
            case 11:
            case 16:
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                return null;
            case 17:
                return zah(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                return zah(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String zag(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zah = zah(context, str);
        if (zah == null) {
            zah = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zah, str2);
    }
}
