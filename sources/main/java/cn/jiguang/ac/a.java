package cn.jiguang.ac;

import android.annotation.TargetApi;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.provider.c;
import cn.jiguang.bb.f;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    @TargetApi(11)
    public static String a(Context context, Uri uri) {
        try {
            String c6 = cn.jiguang.d.a.c("Oi3ZFT8+schQHSyFZbsdUg==");
            if (TextUtils.isEmpty(c6)) {
                return "";
            }
            int i6 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
            Bundle call = acquireUnstableContentProviderClient.call(c6, null, null);
            if (i6 >= 24) {
                c.a(acquireUnstableContentProviderClient);
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) != 0) {
                return call.getString(CrashHianalyticsData.MESSAGE);
            }
            String string = call.getString("id");
            f.c("NubiaIdManager", "succeed:" + string);
            return string;
        } catch (Exception e6) {
            f.i("NubiaIdManager", "get ids-o err:" + e6.getMessage());
            return null;
        }
    }
}
