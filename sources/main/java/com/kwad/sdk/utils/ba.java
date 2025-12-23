package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ba {
    public static Resources dn(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.Pp().getResources();
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static String getPackageName(Context context) {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk() ? "com.kwad.sdk" : context.getPackageName();
    }

    public static int aw(Context context, String str) {
        Resources dn = dn(context);
        if (dn == null) {
            dn = context.getResources();
        }
        return dn.getIdentifier(str, ResIdentify.RES_TYPE_DRAWABLE, context.getPackageName());
    }

    public static int getAppIconId(Context context) {
        int i6;
        try {
            i6 = y.getPackageInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()), context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i6 = 0;
        }
        if (i6 <= 0) {
            return aw(context, "ksad_notification_small_icon");
        }
        return i6;
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }
}
