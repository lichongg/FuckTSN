package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class v {

    /* renamed from: c, reason: collision with root package name */
    private static final int f41462c = 5;

    /* renamed from: d, reason: collision with root package name */
    private static JSONArray f41463d = new JSONArray();

    /* renamed from: e, reason: collision with root package name */
    private static Object f41464e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Long> f41467f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    Stack<String> f41465a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f41466b = PageNameMonitor.getInstance();

    protected int a() {
        return 2;
    }

    public void b(String str) {
        Long l6;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f41467f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.f41465a.size() == 0) {
                UMLog.aq(j.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f41467f) {
            l6 = this.f41467f.get(str);
            this.f41467f.remove(str);
        }
        if (l6 == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f41465a.size() > 0 && str.equals(this.f41465a.peek())) {
            this.f41465a.pop();
        }
        long currentTimeMillis = System.currentTimeMillis() - l6.longValue();
        synchronized (f41464e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(d.f41203v, str);
                jSONObject.put("duration", currentTimeMillis);
                jSONObject.put(d.f41205x, l6);
                jSONObject.put("type", a());
                f41463d.put(jSONObject);
                if (f41463d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.f41465a.size() == 0) {
            return;
        }
        UMLog.aq(j.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f41464e) {
                    jSONArray = f41463d.toString();
                    f41463d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f41465a.size() != 0) {
            String[] strArr = {this.f41465a.peek()};
            UMLog.aq(j.F, 0, "\\|", new String[]{"@"}, strArr, null, null);
        }
        this.f41466b.customPageBegin(str);
        synchronized (this.f41467f) {
            try {
                this.f41467f.put(str, Long.valueOf(System.currentTimeMillis()));
                if (UMConfigure.isDebugLog()) {
                    this.f41465a.push(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f41467f) {
            try {
                str = null;
                long j6 = 0;
                for (Map.Entry<String, Long> entry : this.f41467f.entrySet()) {
                    if (entry.getValue().longValue() > j6) {
                        long longValue = entry.getValue().longValue();
                        str = entry.getKey();
                        j6 = longValue;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str != null) {
            b(str);
        }
    }
}
