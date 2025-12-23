package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f40516a;

    /* renamed from: b, reason: collision with root package name */
    private String f40517b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f40518c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f40519d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f40520e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f40521f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f40522g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f40523h = "";

    /* renamed from: i, reason: collision with root package name */
    private List<Serializable> f40524i = Collections.synchronizedList(new ArrayList());

    /* renamed from: j, reason: collision with root package name */
    private List<Serializable> f40525j = Collections.synchronizedList(new ArrayList());

    /* renamed from: k, reason: collision with root package name */
    private Executor f40526k = l.b();

    /* renamed from: l, reason: collision with root package name */
    private boolean f40527l;

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f40516a == null) {
                    f40516a = new b();
                }
                bVar = f40516a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    private c b(String str, String str2, Object obj, Map<String, Object> map) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("attaid", "09400051119");
        hashMap.put(JThirdPlatFormInterface.KEY_TOKEN, "9389887874");
        hashMap.put("time_appid_openid", currentTimeMillis + "_" + this.f40517b + "_" + this.f40519d);
        hashMap.put("time", String.valueOf(currentTimeMillis));
        hashMap.put("openid", this.f40519d);
        hashMap.put("appid", this.f40517b);
        hashMap.put("app_name", this.f40518c);
        hashMap.put(Constants.PARAM_APP_VER, this.f40520e);
        hashMap.put(Constants.PARAM_PKG_NAME, this.f40521f);
        hashMap.put("os", "AND");
        hashMap.put("os_ver", Build.VERSION.RELEASE);
        hashMap.put(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
        hashMap.put(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
        hashMap.put("interface_name", str);
        hashMap.put("interface_data", str2);
        hashMap.put("interface_result", obj == null ? "" : obj.toString());
        hashMap.put("qq_install", this.f40522g);
        hashMap.put(Constants.PARAM_QQ_VER, this.f40523h);
        if (map != null && !map.isEmpty()) {
            Object obj2 = map.get("reserve1");
            hashMap.put("reserve1", obj2 == null ? "" : obj2.toString());
            Object obj3 = map.get("reserve2");
            hashMap.put("reserve2", obj3 == null ? "" : obj3.toString());
            Object obj4 = map.get("reserve3");
            hashMap.put("reserve3", obj4 == null ? "" : obj4.toString());
            Object obj5 = map.get("reserve4");
            hashMap.put("reserve4", obj5 != null ? obj5.toString() : "");
        }
        return new c((HashMap<String, String>) hashMap);
    }

    private void c() {
        while (!this.f40525j.isEmpty()) {
            c cVar = (c) this.f40525j.remove(0);
            cVar.f40530a.put("appid", this.f40517b);
            cVar.f40530a.put("app_name", this.f40518c);
            cVar.f40530a.put(Constants.PARAM_APP_VER, this.f40520e);
            cVar.f40530a.put(Constants.PARAM_PKG_NAME, this.f40521f);
            cVar.f40530a.put("qq_install", this.f40522g);
            cVar.f40530a.put(Constants.PARAM_QQ_VER, this.f40523h);
            cVar.f40530a.put("openid", this.f40519d);
            cVar.f40530a.put("time_appid_openid", cVar.f40530a.get("time") + "_" + this.f40517b + "_" + this.f40519d);
            StringBuilder sb = new StringBuilder();
            sb.append("fixDirtyData--------------------------");
            sb.append(cVar);
            SLog.i("AttaReporter", sb.toString());
            this.f40524i.add(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (!this.f40527l) {
            List<Serializable> b6 = g.b("report_atta");
            this.f40527l = b6.isEmpty();
            this.f40524i.addAll(b6);
            Iterator<Serializable> it = b6.iterator();
            while (it.hasNext()) {
                SLog.i("AttaReporter", "attaReportAtSubThread from db = " + it.next());
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!this.f40524i.isEmpty()) {
            c cVar = (c) this.f40524i.remove(0);
            if (!b(cVar)) {
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (this.f40527l) {
                return;
            }
            SLog.i("AttaReporter", "attaReportAtSubThread clear db");
            g.a("report_atta");
            this.f40527l = true;
            return;
        }
        SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) ((Serializable) it2.next())));
        }
        g.a("report_atta", arrayList);
        this.f40527l = false;
    }

    private b() {
    }

    public void a(String str, Context context) {
        SLog.i("AttaReporter", "init");
        this.f40517b = str;
        this.f40518c = k.a(context);
        this.f40520e = m.d(context, com.tencent.open.utils.g.b());
        this.f40521f = com.tencent.open.utils.g.b();
        this.f40522g = k.b(context) ? "1" : "0";
        this.f40523h = m.c(context, "com.tencent.mobileqq");
        c();
        g.a();
    }

    public void a(String str) {
        SLog.i("AttaReporter", "updateOpenId");
        if (str == null) {
            str = "";
        }
        this.f40519d = str;
    }

    public void a(String str, String str2) {
        a(str, str2, null);
    }

    public void a(String str, String str2, Map<String, Object> map) {
        a(str, str2, "", map);
    }

    public void a(String str, Object obj) {
        a(str, "", obj, null);
    }

    public void a(String str, String str2, Object obj, Map<String, Object> map) {
        c b6 = b(str, str2, obj, map);
        if (!TextUtils.isEmpty(this.f40517b) && !TextUtils.isEmpty(this.f40518c) && com.tencent.open.utils.g.a() != null) {
            a(b6);
            return;
        }
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.f40517b + ", mAppName=" + this.f40518c + ", context=" + com.tencent.open.utils.g.a() + ", " + b6);
        this.f40525j.add(b6);
    }

    private void a(final c cVar) {
        this.f40526k.execute(new Runnable() { // from class: com.tencent.open.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f40524i.add(cVar);
                if (m.b(com.tencent.open.utils.g.a())) {
                    try {
                        b.this.d();
                        return;
                    } catch (Exception e6) {
                        SLog.e("AttaReporter", "Exception", e6);
                        return;
                    }
                }
                SLog.i("AttaReporter", "attaReport net disconnect, " + cVar);
            }
        });
    }

    private boolean b(c cVar) {
        int i6 = 0;
        do {
            i6++;
            try {
                SLog.i("AttaReporter", "doAttaReportItem post " + cVar);
                return com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", cVar.f40530a).d() == 200;
            } catch (Exception e6) {
                SLog.i("AttaReporter", "Exception", e6);
            }
        } while (i6 < 2);
        return false;
    }

    public static String b() {
        return a().f40517b;
    }
}
