package cn.jiguang.b;

import android.content.Context;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.ba.g;
import cn.jiguang.bb.f;
import cn.jiguang.bz.d;
import cn.jiguang.bz.o;
import com.umeng.analytics.pro.bi;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b extends cn.jiguang.by.b implements ReportCallBack {
    private JSONObject a(Context context) {
        JSONArray c6 = a.c(context);
        if (c6 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("crashlogs", c6);
            jSONObject.put(bi.T, o.c(context));
            cn.jiguang.d.a.a(context, jSONObject, "crash_log");
            Object a6 = g.a().a(68);
            JSONObject jSONObject2 = a6 instanceof JSONObject ? (JSONObject) a6 : null;
            if (jSONObject2 != null && jSONObject2.length() > 0) {
                jSONObject.put("device_info", jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // cn.jiguang.by.b
    public void a() {
        try {
            Context a6 = d.a(null);
            if (a6 == null) {
                f.i("ReportCrashLogDirect", "ReportDirect context is null");
                return;
            }
            JSONObject a7 = a(a6);
            if (a7 != null) {
                cn.jiguang.bd.f.a(a6, a7, this);
            }
        } catch (Throwable th) {
            f.l("ReportCrashLogDirect", "run report crash e:" + th);
        }
    }

    @Override // cn.jiguang.api.ReportCallBack
    public void onFinish(int i6) {
        f.i("ReportCrashLogDirect", "ReportDirect finish : " + i6);
        if (i6 == 0) {
            a.d(d.a(null));
        }
    }

    public b() {
        this.f2653h = "ReportCrashLogDirect";
    }
}
