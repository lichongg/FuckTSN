package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private static final Map<String, List<String>> aYp;

    static {
        HashMap hashMap = new HashMap();
        aYp = hashMap;
        hashMap.put("huawei", Arrays.asList("com.huawei.appmarket"));
        hashMap.put("oppo", Arrays.asList("com.oppo.market", "com.heytap.market"));
        hashMap.put("vivo", Arrays.asList("com.bbk.appstore"));
        hashMap.put("xiaomi", Arrays.asList("com.xiaomi.market"));
        hashMap.put("oneplus", Arrays.asList("com.oppo.market"));
        hashMap.put("meizu", Arrays.asList("com.meizu.mstore"));
        hashMap.put("samsung", Arrays.asList("com.sec.android.app.samsungapps"));
        hashMap.put("smartisan", Arrays.asList("com.smartisanos.appstore"));
        hashMap.put("realme", Arrays.asList("com.oppo.market"));
        hashMap.put("honor", Arrays.asList("com.hihonor.appmarket", "com.huawei.appmarket"));
    }

    public static boolean a(Context context, final String str, final AdTemplate adTemplate) {
        SceneImpl sceneImpl;
        if (bb.Rl() && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.adStyle != 4) {
            if (TextUtils.isEmpty(str)) {
                com.kwad.sdk.commercial.b.a.a(adTemplate, "com.xiaomi.market", 0, 1);
                return false;
            }
            if (com.kwad.sdk.core.download.a.b.a(context, str, new b.C0682b() { // from class: com.kwad.sdk.utils.e.1
                @Override // com.kwad.sdk.core.download.a.b.C0682b, com.kwad.sdk.core.download.a.b.a
                public final void onError(Throwable th) {
                    super.onError(th);
                    com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1, bw.s(th));
                }

                @Override // com.kwad.sdk.core.download.a.b.C0682b, com.kwad.sdk.core.download.a.b.a
                public final void onStart() {
                    super.onStart();
                    com.kwad.sdk.commercial.b.a.a(AdTemplate.this, str, "com.xiaomi.market", 0, 1);
                }

                @Override // com.kwad.sdk.core.download.a.b.C0682b, com.kwad.sdk.core.download.a.b.a
                public final void onSuccess() {
                    super.onSuccess();
                    AdTemplate adTemplate2 = AdTemplate.this;
                    adTemplate2.mXiaomiAppStoreDetailViewOpen = true;
                    adTemplate2.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate2, str, "com.xiaomi.market", 0, 1);
                }
            }) == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(Context context, AdTemplate adTemplate) {
        String str;
        Throwable th;
        String str2;
        int i6;
        Intent intent;
        String str3;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        String cW = com.kwad.sdk.core.response.b.a.cW(el);
        String ay = com.kwad.sdk.core.response.b.a.ay(el);
        Map<String, List<String>> map = aYp;
        String str4 = Build.BRAND;
        List<String> list = map.get(str4.toLowerCase());
        if (list != null && !list.isEmpty()) {
            str = list.get(0);
        } else {
            list = new ArrayList<>();
            str = "";
        }
        String str5 = str;
        if (context == null) {
            return false;
        }
        if (TextUtils.isEmpty(cW)) {
            com.kwad.sdk.commercial.b.a.a(adTemplate, str5, 1, 0);
            return false;
        }
        try {
            if ("samsung".equals(str4)) {
                cW = "http://apps.samsung.com/appquery/appDetail.as?appId=" + ay;
            }
            com.kwad.sdk.commercial.b.a.a(adTemplate, cW, str5, 1, 0);
            intent = new Intent("android.intent.action.VIEW", Uri.parse(cW));
            intent.addFlags(268435456);
            for (String str6 : list) {
                PackageInfo packageInfo = y.getPackageInfo(context, str6, 1);
                if (packageInfo != null && (str3 = packageInfo.packageName) != null && str3.equals(str6)) {
                    intent.setPackage(str3);
                    intent.setFlags(268435456);
                    context.startActivity(intent);
                    adTemplate.mClickOpenAppStore = true;
                    com.kwad.sdk.commercial.b.a.b(adTemplate, cW, str6, 1, 0);
                    return true;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = cW;
            i6 = 1;
        }
        try {
            context.startActivity(intent);
            adTemplate.mClickOpenAppStore = true;
            com.kwad.sdk.commercial.b.a.b(adTemplate, cW, str5, 0, 0);
            return true;
        } catch (Throwable th3) {
            th = th3;
            str2 = cW;
            i6 = 0;
            com.kwad.sdk.commercial.b.a.a(adTemplate, str2, str5, i6, 0, bw.s(th));
            return false;
        }
    }
}
