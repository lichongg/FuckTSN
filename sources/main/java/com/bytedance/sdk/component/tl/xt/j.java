package com.bytedance.sdk.component.tl.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.tl.j.ae;
import com.bytedance.sdk.component.tl.j.m;
import com.bytedance.sdk.component.tl.j.up;
import com.bytedance.sdk.component.utils.vl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<String, xt> f26762j = new ConcurrentHashMap<>();
    private static volatile List<com.bytedance.sdk.component.tl.j.cw> xt = new ArrayList();
    private static ConcurrentHashMap<String, up> cw = new ConcurrentHashMap<>();

    public static ae j(com.bytedance.sdk.component.tl.j.j jVar) {
        if (jVar == null || TextUtils.isEmpty(jVar.up()) || jVar.getContext() == null) {
            vl.r("csj_log_error", "config or adLogFrom or context is null");
            return null;
        }
        ConcurrentHashMap<String, xt> concurrentHashMap = f26762j;
        xt xtVar = concurrentHashMap.get(jVar.up());
        if (xtVar == null) {
            xtVar = new xt(jVar);
        } else {
            xtVar.xt(jVar);
        }
        concurrentHashMap.put(jVar.up(), xtVar);
        return xtVar;
    }

    public static void xt(String str) {
        j(false, str);
        cw(str).j();
    }

    public static ae cw(String str) {
        ConcurrentHashMap<String, xt> concurrentHashMap = f26762j;
        xt xtVar = concurrentHashMap.get(str);
        if (xtVar != null) {
            return xtVar;
        }
        xt xtVar2 = new xt();
        concurrentHashMap.put(str, xtVar2);
        return xtVar2;
    }

    public static up up(String str) {
        up upVar = cw.get(str);
        if (upVar == null && (upVar = cw(str).cw()) != null) {
            cw.put(str, upVar);
        }
        return upVar;
    }

    public static void r(String str) {
        cw(str).xt();
    }

    public static void j(m mVar, String str) {
        cw(str).j(mVar);
    }

    public static void j(boolean z5, String str) {
        cw(str).j(z5);
    }

    public static List<com.bytedance.sdk.component.tl.j.cw> j() {
        return xt;
    }

    public static void j(com.bytedance.sdk.component.tl.j.cw cwVar) {
        if (cwVar != null) {
            xt.add(cwVar);
        }
    }

    public static boolean j(String str) {
        xt xtVar = f26762j.get(str);
        return xtVar == null || xtVar.cw() == null || xtVar.r() == null || xtVar.up() == null;
    }

    public static void j(String str, String str2) {
        cw(str).j(str2);
    }

    public static void j(String str, String str2, List<String> list, boolean z5, Map<String, String> map, JSONObject jSONObject) {
        cw(str).j(str2, list, z5, map, jSONObject);
    }

    public static void j(com.bytedance.sdk.component.tl.j.xt xtVar, String str) {
        cw(str).j(xtVar);
    }
}
