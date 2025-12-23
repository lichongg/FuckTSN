package com.beizi.ad.lance.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class k {
    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return a(context, a(str));
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return false;
    }

    public static Intent a(String str) {
        return a(str, (String) null);
    }

    public static Intent a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        intent.setFlags(268435456);
        return intent;
    }

    public static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }
}
