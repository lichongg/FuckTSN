package com.beizi.fusion.d.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Context f13384a;

    public String a() {
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i6 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = this.f13384a.getContentResolver().acquireContentProviderClient(parse);
            Bundle call = acquireContentProviderClient.call("getOAID", null, null);
            if (i6 >= 24) {
                androidx.core.provider.c.a(acquireContentProviderClient);
            } else {
                acquireContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
            call.getString(CrashHianalyticsData.MESSAGE);
            return null;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public f(Context context) {
        this.f13384a = context;
    }
}
