package com.kwad.sdk.core.e.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class g {
    private Context mContext;

    public final String getOAID() {
        String str;
        str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i6 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(parse);
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i6 >= 24) {
                androidx.core.provider.c.a(acquireContentProviderClient);
            } else {
                acquireContentProviderClient.release();
            }
            if (call != null) {
                str = call.getInt("code", -1) == 0 ? call.getString("id") : "";
                com.kwad.sdk.core.d.c.i("NubiaDeviceIDHelper", "getOAID oaid:" + str + "faledMsg:" + call.getString(CrashHianalyticsData.MESSAGE));
            }
            return str;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.i("NubiaDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return str;
        }
    }

    public g(Context context) {
        this.mContext = context;
    }
}
