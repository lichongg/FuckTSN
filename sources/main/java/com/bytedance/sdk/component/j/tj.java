package com.bytedance.sdk.component.j;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.bytedance.sdk.component.j.qv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
class tj {
    private final qv.j cw;

    /* renamed from: r, reason: collision with root package name */
    private final String f26503r;
    private final LruCache<String, cw> xt;

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, List<xt>> f26502j = new ConcurrentHashMap();
    private volatile boolean up = false;

    private static final class xt {
        List<String> cw;

        /* renamed from: j, reason: collision with root package name */
        Pattern f26506j;

        /* renamed from: r, reason: collision with root package name */
        List<String> f26507r;
        v xt;

        private xt() {
        }
    }

    private static String xt(String str) {
        String[] split;
        int length;
        if (str == null || (length = (split = str.split("[.]")).length) < 2) {
            return null;
        }
        if (length == 2) {
            return str;
        }
        return split[length - 2] + "." + split[length - 1];
    }

    cw j(String str, Set<String> set) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        cw cwVar = new cw();
        if (authority == null || authority.isEmpty()) {
            cwVar.f26505j = v.PUBLIC;
            return cwVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(".".concat(String.valueOf(str2)))) {
                cwVar.f26505j = v.PRIVATE;
                return cwVar;
            }
        }
        cw cwVar2 = this.xt.get(builder);
        return cwVar2 != null ? cwVar2 : j(builder);
    }

    static final class cw {

        /* renamed from: j, reason: collision with root package name */
        v f26505j = v.PUBLIC;
        Set<String> xt = new HashSet();
        Set<String> cw = new HashSet();

        cw() {
        }
    }

    static class j extends IllegalStateException {
        j(String str) {
            super(str);
        }
    }

    private List<xt> cw(String str) throws j {
        if (this.up) {
            return this.f26502j.get(str);
        }
        throw new j("Permission config is outdated!");
    }

    private static String r(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    @WorkerThread
    tj(String str, int i6, qv.j jVar, final Executor executor, JSONObject jSONObject) {
        this.f26503r = str;
        if (i6 <= 0) {
            this.xt = new LruCache<>(16);
        } else {
            this.xt = new LruCache<>(i6);
        }
        this.cw = jVar;
        if (jSONObject == null) {
            r(str);
            new Object() { // from class: com.bytedance.sdk.component.j.tj.1
            };
        } else {
            update(jSONObject);
        }
    }

    void update(JSONObject jSONObject) {
        j(jSONObject);
        r(this.f26503r);
    }

    @WorkerThread
    private static xt xt(JSONObject jSONObject) throws JSONException {
        xt xtVar = new xt();
        xtVar.f26506j = Pattern.compile(jSONObject.getString("pattern"));
        xtVar.xt = v.j(jSONObject.getString("group"));
        xtVar.cw = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("included_methods");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                xtVar.cw.add(optJSONArray.getString(i6));
            }
        }
        xtVar.f26507r = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                xtVar.f26507r.add(optJSONArray2.getString(i7));
            }
        }
        return xtVar;
    }

    @WorkerThread
    private void j(JSONObject jSONObject) {
        this.f26502j.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.f26502j.put(next, linkedList);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    linkedList.add(xt(jSONArray.getJSONObject(i6)));
                }
            }
        } catch (JSONException e6) {
            g.xt("Parse configurations failed, response: " + jSONObject.toString(), e6);
        }
        this.up = true;
    }

    private cw j(String str) throws j {
        cw cwVar = new cw();
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String xt2 = xt(authority);
        if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(authority) && xt2 != null) {
            List<xt> cw2 = cw(xt2);
            if (cw2 == null) {
                return cwVar;
            }
            for (xt xtVar : cw2) {
                if (xtVar.f26506j.matcher(str).find()) {
                    if (xtVar.xt.compareTo(cwVar.f26505j) >= 0) {
                        cwVar.f26505j = xtVar.xt;
                    }
                    cwVar.xt.addAll(xtVar.cw);
                    cwVar.cw.addAll(xtVar.f26507r);
                }
            }
            this.xt.put(str, cwVar);
            return cwVar;
        }
        cwVar.f26505j = v.PUBLIC;
        return cwVar;
    }
}
