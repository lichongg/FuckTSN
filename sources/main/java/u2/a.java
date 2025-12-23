package u2;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.socialbase.appdownloader.m.e;
import com.umeng.analytics.pro.bi;
import java.util.List;

/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static boolean b(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        return m.f().optInt("market_url_opt", 1) == 0 ? "market".equals(scheme) : "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme) || "honormarket".equals(scheme) || "prizeappcenter".equals(scheme);
    }

    public static Uri a(Context context, String str) {
        String string = Settings.System.getString(context.getContentResolver(), "persit.sys.tid");
        Uri.Builder builder = new Uri.Builder();
        if (e.g() && m.f().optInt("enable_honor_market_scheme_opt", 1) == 1) {
            return builder.scheme("honormarket").authority("details").appendQueryParameter("id", str).build();
        }
        if (!TextUtils.isEmpty(string) && m.f().optInt("enable_persit_market_scheme_opt", 1) == 1) {
            return builder.scheme("prizeappcenter").authority("details").appendQueryParameter("pkg", str).build();
        }
        return Uri.parse("market://details?id=".concat(String.valueOf(str)));
    }

    public static String c(@NonNull Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        if (m.f().optInt("market_scheme_opt") == 1 && e.a() && "samsungapps".equals(scheme) && pathSegments != null && pathSegments.size() == 1) {
            return pathSegments.get(0);
        }
        return b.b(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter("pkg"), uri.getQueryParameter(bi.f40972o), uri.getQueryParameter("appId"));
    }
}
