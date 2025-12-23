package com.bytedance.j.xt.cw;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.j.xt.tl.f;
import com.bytedance.j.xt.tl.i;
import com.bytedance.j.xt.tl.o;
import com.bytedance.j.xt.up.j.h;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.component.utils.vl;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected JSONObject f24176a;

    public b() {
        this.f24176a = new JSONObject();
    }

    public static b d(long j6, Context context, @Nullable Thread thread, @NonNull Throwable th) {
        if (j6 == 0) {
            j6 = System.currentTimeMillis();
        }
        b bVar = new b();
        bVar.l("isJava", 1);
        bVar.l("event_type", "java_crash");
        bVar.l("timestamp", Long.valueOf(System.currentTimeMillis()));
        bVar.l("data", o.b(th));
        bVar.l("isOOM", Boolean.valueOf(o.i(th)));
        bVar.l("crash_time", Long.valueOf(j6));
        bVar.l(ContentProviderManager.PLUGIN_PROCESS_NAME, f.j(context));
        if (!f.m(context)) {
            bVar.l("remote_process", 1);
        }
        f.e(context, bVar.k());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            bVar.l("crash_thread_name", name);
        }
        bVar.l("all_thread_stacks", o.e(name));
        return bVar;
    }

    public b a(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e6) {
                    vl.j(e6);
                }
            }
            l("filters", jSONObject);
        }
        return this;
    }

    public b b(int i6, String str) {
        try {
            this.f24176a.put("miniapp_id", i6);
            this.f24176a.put("miniapp_version", str);
            return this;
        } catch (JSONException e6) {
            vl.j(e6);
            return this;
        }
    }

    public b c(long j6) {
        try {
            l(d.f41197p, Long.valueOf(j6));
            l("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j6)));
            return this;
        } catch (Exception e6) {
            vl.j(e6);
            return this;
        }
    }

    public b e(c cVar) {
        l("header", cVar.e());
        return this;
    }

    public b f(h hVar) {
        l("activity_trace", hVar.k());
        l("running_tasks", hVar.B());
        return this;
    }

    public b h(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            l("patch_info", jSONArray);
            return this;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        l("patch_info", jSONArray);
        return this;
    }

    public b i(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.f24176a.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(bi.f40972o, str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.f24176a.put("plugin_info", jSONArray);
        return this;
    }

    public b j(JSONObject jSONObject) {
        l("storage", jSONObject);
        return this;
    }

    public JSONObject k() {
        return this.f24176a;
    }

    public void l(@NonNull String str, @Nullable Object obj) {
        try {
            this.f24176a.put(str, obj);
        } catch (Exception e6) {
            i.c(e6);
        }
    }

    public b m(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        l("logcat", jSONArray);
        return this;
    }

    public b n(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e6) {
                    i.c(e6);
                }
            }
            try {
                this.f24176a.put("sdk_info", jSONObject);
            } catch (JSONException e7) {
                vl.j(e7);
            }
        }
        return this;
    }

    public b(JSONObject jSONObject) {
        this.f24176a = jSONObject;
    }

    public b g(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            l("session_id", str);
        }
        return this;
    }
}
