package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f33430b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f33431c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private a f33432a;

    public static b a(String str) {
        return f33430b.get(str);
    }

    public String b(Context context, o1.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z5) {
        String b6;
        synchronized (f33431c) {
            b6 = this.f33432a.b(context, aVar, grsBaseInfo, str, str2, z5);
        }
        return b6;
    }

    public Map<String, String> c(Context context, o1.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z5) {
        Map<String, String> e6;
        synchronized (f33431c) {
            e6 = this.f33432a.e(context, aVar, grsBaseInfo, str, z5);
        }
        return e6;
    }

    public u1.a d() {
        return this.f33432a.g();
    }

    public Set<String> f() {
        return this.f33432a.k();
    }

    public b(Context context, boolean z5) {
        e(context, z5);
        f33430b.put(context.getPackageName(), this);
    }

    private void e(Context context, boolean z5) {
        String[] split;
        List<String> asList;
        long currentTimeMillis = System.currentTimeMillis();
        String a6 = r1.c.a("grs_route_config_files_list.txt", context);
        boolean z6 = false;
        Logger.i("LocalManagerProxy", "initLocalManager configFileListContent TimeCost:%d  Content:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a6);
        if (TextUtils.isEmpty(a6)) {
            long currentTimeMillis2 = System.currentTimeMillis();
            split = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            Logger.i("LocalManagerProxy", "list by AssetsManager, timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
        } else {
            split = a6.split("#");
        }
        if (split == null) {
            asList = new ArrayList<>();
        } else {
            asList = Arrays.asList(split);
        }
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.f33432a = new d(false, z5);
        if (asList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f33432a = new d(context, appConfigName, z5);
        }
        if (!this.f33432a.n() && asList.contains("grs_sdk_global_route_config.json")) {
            this.f33432a = new c(context, z5);
        }
        this.f33432a.h(context, asList);
        StringBuilder sb = new StringBuilder();
        sb.append("on initLocalManager finish, check appGrs: ");
        if (this.f33432a.f33425a == null) {
            z6 = true;
        }
        sb.append(z6);
        Logger.i("LocalManagerProxy", sb.toString());
    }
}
