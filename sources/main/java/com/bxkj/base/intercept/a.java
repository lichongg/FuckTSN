package com.bxkj.base.intercept;

import cn.bluemobi.dylan.http.MD5Utils;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import okhttp3.Interceptor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a implements Interceptor {
    private int d() {
        try {
            return BaseApp.c().getPackageManager().getPackageInfo(BaseApp.c().getPackageName(), 0).versionCode;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    private static String a(String str, String str2, boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (z5) {
            try {
                sb.append(URLEncoder.encode(str2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
                sb.append(str2);
            }
        } else {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String b(Map<String, String> map) {
        return c0.b.f1042a.i(BaseApp.c(), LoginUser.getLoginUser().getToken(), map);
    }

    public static String c(Map<String, String> map, boolean z5) {
        if (z5) {
            return b(map);
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < arrayList.size() - 1; i6++) {
            String str = (String) arrayList.get(i6);
            sb.append(a(str, map.get(str), false));
            sb.append(ContainerUtils.FIELD_DELIMITER);
        }
        String str2 = (String) arrayList.get(arrayList.size() - 1);
        sb.append(a(str2, map.get(str2), false));
        try {
            return URLEncoder.encode(MD5Utils.md5(sb.toString()), "UTF-8");
        } catch (UnsupportedEncodingException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00bc  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r18) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.intercept.a.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
