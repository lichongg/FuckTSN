package com.kuaishou.weapon.p0;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class o {
    private static p b(JSONObject jSONObject) {
        try {
            p pVar = new p();
            pVar.a(jSONObject.optInt("wk"));
            pVar.a(jSONObject.optString("wan"));
            pVar.b(jSONObject.optString("wm"));
            pVar.b(jSONObject.optInt("wo"));
            pVar.c(jSONObject.optInt("wpr"));
            pVar.c(jSONObject.optString(bi.f35784q));
            pVar.e(jSONObject.optInt("ws", 1));
            pVar.d(jSONObject.optInt("wh", 0));
            pVar.f(jSONObject.optInt("wt"));
            pVar.d(jSONObject.optString("wu"));
            pVar.e(jSONObject.optString("wv"));
            JSONArray jSONArray = jSONObject.getJSONArray("wa");
            ArrayList arrayList = null;
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                p.a aVar = new p.a();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                aVar.a(jSONObject2.optInt(t.f36150k));
                aVar.b(jSONObject2.optInt(com.umeng.analytics.pro.bi.aL));
                aVar.a(jSONObject2.getString("n"));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar);
            }
            pVar.a(arrayList);
            p.b bVar = new p.b();
            JSONObject jSONObject3 = jSONObject.getJSONObject("we");
            bVar.a(jSONObject3.optInt("duration"));
            bVar.b(jSONObject3.optInt("network"));
            pVar.a(bVar);
            return pVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public static s a(JSONObject jSONObject) {
        boolean z5;
        boolean z6;
        int a6;
        int b6;
        boolean z7;
        p b7 = b(jSONObject);
        if (b7 == null) {
            return null;
        }
        int a7 = b7.a();
        String l6 = b7.l();
        String j6 = b7.j();
        if (b7.d() == 1) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (b7.h() == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        int e6 = b7.e();
        String c6 = b7.c();
        String f6 = b7.f();
        String b8 = b7.b();
        PackageInfo packageInfo = new PackageInfo();
        try {
            packageInfo.packageName = f6;
            packageInfo.versionName = l6;
            ApplicationInfo applicationInfo = new ApplicationInfo();
            if (!TextUtils.isEmpty(f6) && !TextUtils.isEmpty(b8) && b8.startsWith(".")) {
                applicationInfo.name = f6 + b8;
                applicationInfo.className = f6 + b8;
            }
            applicationInfo.theme = b7.i();
            packageInfo.applicationInfo = applicationInfo;
            List<p.a> m6 = b7.m();
            if (m6 != null && m6.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < m6.size(); i6++) {
                    ActivityInfo activityInfo = new ActivityInfo();
                    activityInfo.name = m6.get(i6).c();
                    activityInfo.theme = m6.get(i6).b();
                    activityInfo.labelRes = m6.get(i6).a();
                    if (!TextUtils.isEmpty(activityInfo.name)) {
                        arrayList.add(activityInfo);
                    }
                }
                if (arrayList.size() > 0) {
                    packageInfo.activities = (ActivityInfo[]) arrayList.toArray(new ActivityInfo[arrayList.size()]);
                }
            }
        } catch (Throwable unused) {
        }
        s sVar = new s(packageInfo, a7, f6, l6, j6, c6);
        sVar.f36136v = z5;
        sVar.f36138x = e6;
        if (b7.k() == null) {
            a6 = 0;
        } else {
            a6 = b7.k().a();
        }
        if (b7.k() == null) {
            b6 = -1;
        } else {
            b6 = b7.k().b();
        }
        sVar.f36134t = a6;
        sVar.f36135u = b6;
        sVar.f36133s = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT > 29 && z6) {
            if (b7.g() == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            z6 = z7;
        }
        sVar.f36139y = z6;
        return sVar;
    }
}
