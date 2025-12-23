package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33433a = "e";

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f33434b = Collections.unmodifiableSet(new a(16));

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends HashSet<String> {
        a(int i6) {
            super(i6);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    private static String a(Context context, o1.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z5) {
        String serCountry = grsBaseInfo.getSerCountry();
        String regCountry = grsBaseInfo.getRegCountry();
        String issueCountry = grsBaseInfo.getIssueCountry();
        for (String str2 : str.split(">")) {
            if (f33434b.contains(str2.trim())) {
                if ("ser_country".equals(str2.trim()) && !TextUtils.isEmpty(serCountry) && !"UNKNOWN".equals(serCountry)) {
                    Logger.i(f33433a, "current route_by is serCountry and routerCountry is: " + serCountry);
                    return serCountry;
                }
                if ("reg_country".equals(str2.trim()) && !TextUtils.isEmpty(regCountry) && !"UNKNOWN".equals(regCountry)) {
                    Logger.i(f33433a, "current route_by is regCountry and routerCountry is: " + regCountry);
                    return regCountry;
                }
                if ("issue_country".equals(str2.trim()) && !TextUtils.isEmpty(issueCountry) && !"UNKNOWN".equals(issueCountry)) {
                    Logger.i(f33433a, "current route_by is issueCountry and routerCountry is: " + issueCountry);
                    return issueCountry;
                }
                if ("geo_ip".equals(str2.trim())) {
                    String a6 = new com.huawei.hms.framework.network.grs.g.b(context, aVar, grsBaseInfo).a(z5);
                    Logger.i(f33433a, "current route_by is geo_ip and routerCountry is: " + a6);
                    return a6;
                }
            }
        }
        return "";
    }

    public static String b(Context context, o1.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(f33433a, "routeBy must be not empty string or null.");
            return null;
        }
        if (!"no_route".equals(str) && !"unconditional".equals(str)) {
            return a(context, aVar, str, grsBaseInfo, z5);
        }
        Logger.v(f33433a, "routeBy equals NO_ROUTE_POLICY");
        return "no_route_country";
    }
}
