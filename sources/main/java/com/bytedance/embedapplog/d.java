package com.bytedance.embedapplog;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.tk;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* loaded from: D:\Downloads\app\classes3.dex */
final class d implements tk {
    @Override // com.bytedance.embedapplog.tk
    public boolean j(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.bytedance.embedapplog.tk
    public tk.j xt(Context context) {
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i6 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
            if (acquireContentProviderClient == null) {
                return null;
            }
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i6 >= 24) {
                androidx.core.provider.c.a(acquireContentProviderClient);
            } else {
                acquireContentProviderClient.release();
            }
            if (call == null) {
                return null;
            }
            if (call.getInt("code", -1) == 0) {
                tk.j jVar = new tk.j();
                jVar.xt = call.getString("id");
                return jVar;
            }
            String string = call.getString(CrashHianalyticsData.MESSAGE);
            if (!TextUtils.isEmpty(string)) {
                uc.xt(string);
            }
            return null;
        } catch (Exception e6) {
            uc.j(e6);
            return null;
        }
    }

    d() {
    }
}
