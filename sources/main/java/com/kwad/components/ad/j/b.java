package com.kwad.components.ad.j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import java.util.List;
import org.json.JSONArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.commercial.c.a {
        public String LM = br.RT();
        public String LN = br.RV();
        public String LO = br.getOsVersion();
        public String LP = br.Sb();
        public String LQ = bd.getDeviceId();
        public String LR;
        public String LS;
        public int status;
    }

    public static void al(Context context) {
        String b6 = b(context, "SP_OPEN_FILE_RECORD", "");
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportInstallerCheckRecord start installCheckRecord: " + b6);
        if (TextUtils.isEmpty(b6)) {
            return;
        }
        a aVar = new a();
        aVar.status = 1;
        aVar.LR = b6;
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportInstallerCheckRecord report msg:" + aVar.toJson());
        com.kwad.sdk.commercial.b.x(aVar);
        g(context, "SP_OPEN_FILE_RECORD");
    }

    private static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void g(Context context, String str) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    public static void ak(Context context) {
        context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("content://com.kwad.kwadsdk.adFileProvider/ksad_external_files_path/Download/test.apk"), "application/vnd.android.package-archive");
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 131072);
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller installers size: " + queryIntentActivities.size());
        if (queryIntentActivities.size() <= 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller info: " + resolveInfo);
                jSONArray.put(resolveInfo.activityInfo.packageName);
            }
            String jSONArray2 = jSONArray.toString();
            a aVar = new a();
            aVar.status = 2;
            aVar.LS = jSONArray2;
            com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller: " + aVar.toJson());
            com.kwad.sdk.commercial.b.x(aVar);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }
}
