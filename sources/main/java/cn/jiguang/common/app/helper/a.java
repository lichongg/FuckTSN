package cn.jiguang.common.app.helper;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.bz.j;
import cn.jiguang.m.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f2878a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicLong f2879b;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, cn.jiguang.common.app.entity.a> f2880c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, cn.jiguang.common.app.entity.a> f2881d;

    /* renamed from: cn.jiguang.common.app.helper.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jiguang.common.app.helper.a$a, reason: collision with other inner class name */
    private static final class C0040a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f2882a = new a(null);
    }

    private a() {
        this.f2879b = new AtomicLong(0L);
        this.f2880c = new LinkedHashMap();
        this.f2881d = new LinkedHashMap();
    }

    public static a a() {
        return C0040a.f2882a;
    }

    private void b(Context context, boolean z5) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = z5 ? "app_active_file" : "app_active";
        try {
            HashMap<String, cn.jiguang.common.app.entity.a> hashMap = z5 ? this.f2881d : this.f2880c;
            String str2 = z5 ? "atv_f.cache" : "atv.cache";
            a(str2, hashMap);
            HashMap<String, cn.jiguang.common.app.entity.a> c6 = c(context, z5);
            cn.jiguang.bb.f.c("JAppActiveHelper", "current type : " + str);
            if (c6 == null || c6.isEmpty()) {
                cn.jiguang.an.a.a(context, "app_active", str, 2);
            } else {
                cn.jiguang.an.a.a(context, "app_active", str, 0);
                cn.jiguang.bb.f.c("JAppActiveHelper", "Collect active size: " + c6.size());
                a(c6, hashMap, str2);
            }
            if (c.a.f3097a) {
                cn.jiguang.bb.f.c("JAppActiveHelper", "collect app active done, cost_time: " + (System.currentTimeMillis() - currentTimeMillis) + ", active size: " + c6.size());
            }
        } catch (Throwable th) {
            cn.jiguang.an.a.a(context, "app_active", str, -1);
            cn.jiguang.bb.f.i("JAppActiveHelper", "Collect app active failed: " + th.getMessage());
        }
    }

    private HashMap<String, cn.jiguang.common.app.entity.a> c(Context context, boolean z5) {
        int size;
        if (z5) {
            return a(1002).a(context, a(context));
        }
        HashMap<String, cn.jiguang.common.app.entity.a> a6 = a(1001).a(context, null);
        if (a6 != null && !a6.isEmpty()) {
            return a6;
        }
        HashMap<String, cn.jiguang.common.app.entity.a> a7 = a(1003).a(context, a(context));
        HashMap<String, cn.jiguang.common.app.entity.a> hashMap = new HashMap<>();
        for (cn.jiguang.common.app.entity.a aVar : a7.values()) {
            if (!TextUtils.isEmpty(aVar.f2820a)) {
                cn.jiguang.common.app.entity.a aVar2 = new cn.jiguang.common.app.entity.a();
                if (aVar.f2826g.size() > 0) {
                    aVar2.f2826g = aVar.f2826g;
                }
                if (aVar.f2824e.size() > 0) {
                    Long l6 = aVar.f2824e.get(0);
                    long longValue = l6.longValue();
                    if (longValue > 0 && ((size = aVar2.f2824e.size()) == 0 || aVar2.f2824e.get(size - 1).longValue() < longValue)) {
                        aVar2.f2824e.add(l6);
                        aVar2.f2823d.add(aVar.f2823d.get(0));
                    }
                }
                aVar2.f2820a = aVar.f2820a;
                hashMap.put(aVar.f2820a, aVar2);
            }
        }
        return hashMap;
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    private cn.jiguang.i.a a(int i6) {
        return i6 != 1001 ? i6 != 1003 ? new cn.jiguang.i.b() : new cn.jiguang.i.c() : new cn.jiguang.i.d();
    }

    private boolean b() {
        return System.currentTimeMillis() - this.f2879b.get() >= 108000000;
    }

    private void c() {
        this.f2879b.set(System.currentTimeMillis());
    }

    public synchronized List<String> a(Context context) {
        try {
            if (this.f2878a == null) {
                this.f2878a = new ArrayList();
            }
            if (this.f2878a.size() > 0 && !b()) {
                return this.f2878a;
            }
            ArrayList arrayList = new ArrayList();
            if (b.a(context, false, (Object) arrayList) instanceof List) {
                c();
                this.f2878a.clear();
                this.f2878a.addAll(arrayList);
            }
            return this.f2878a;
        } catch (Throwable th) {
            throw th;
        }
    }

    private List<Pair<JSONArray, JSONArray>> a(JSONArray jSONArray) {
        StringBuilder sb;
        String str;
        try {
            JSONArray jSONArray2 = new JSONArray();
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i7);
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    int length = optJSONObject.toString().getBytes("UTF-8").length;
                    i6 += length;
                    if (i6 > 102400) {
                        if (jSONArray2.length() > 0) {
                            arrayList.add(new Pair(jSONArray2, new JSONArray()));
                        }
                        jSONArray2 = new JSONArray();
                        jSONArray2.put(optJSONObject);
                        i6 = length;
                    } else {
                        jSONArray2.put(optJSONObject);
                    }
                }
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(new Pair(jSONArray2, new JSONArray()));
            }
            return arrayList;
        } catch (UnsupportedEncodingException e6) {
            e = e6;
            sb = new StringBuilder();
            str = "partition exception:";
            sb.append(str);
            sb.append(e.getMessage());
            cn.jiguang.bb.f.i("JAppActiveHelper", sb.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "partition throwable:";
            sb.append(str);
            sb.append(e.getMessage());
            cn.jiguang.bb.f.i("JAppActiveHelper", sb.toString());
            return null;
        }
    }

    private JSONArray a(List<cn.jiguang.common.app.entity.a> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<cn.jiguang.common.app.entity.a> it = list.iterator();
        while (it.hasNext()) {
            JSONObject b6 = it.next().b(128);
            if (b6 != null) {
                jSONArray.put(b6);
            }
        }
        return jSONArray;
    }

    public synchronized void a(Context context, String str, AtomicBoolean atomicBoolean, boolean z5) {
        HashMap<String, cn.jiguang.common.app.entity.a> hashMap;
        String str2;
        try {
            hashMap = z5 ? this.f2881d : this.f2880c;
            str2 = z5 ? "atv_f.cache" : "atv.cache";
            if (hashMap == null || hashMap.isEmpty()) {
                a(str2, hashMap);
            }
        } finally {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            JSONArray a6 = a(new ArrayList<>(hashMap.values()));
            if (a6.length() == 0) {
                cn.jiguang.bb.f.c("JAppActiveHelper", "no active data to report");
                return;
            }
            List<Pair<JSONArray, JSONArray>> a7 = a(a6);
            if (a7 != null && !a7.isEmpty()) {
                int size = a7.size();
                int i6 = 0;
                while (i6 < size) {
                    JSONObject jSONObject = new JSONObject();
                    Pair<JSONArray, JSONArray> pair = a7.get(i6);
                    i6++;
                    jSONObject.put("slice_index", i6);
                    jSONObject.put("slice_count", size);
                    jSONObject.put("data", pair.first);
                    cn.jiguang.be.b.a(context, jSONObject, "app_active");
                    atomicBoolean.set(false);
                    cn.jiguang.m.b.h(context, str);
                }
                if (a6.length() > 0) {
                    hashMap.clear();
                    j.d(str2);
                }
                return;
            }
            cn.jiguang.bb.f.i("JAppActiveHelper", "it can't report, because partition active data failed");
            return;
        }
        cn.jiguang.bb.f.c("JAppActiveHelper", "local map is empty,no report");
    }

    public void a(Context context, boolean z5) {
        cn.jiguang.bb.f.c("JAppActiveHelper", "start app active collect business");
        b(context, z5);
        if (cn.jiguang.m.b.k(context)) {
            return;
        }
        j.d("wxatv.cache");
        j.d("afm.cache");
        j.d("wxids.cache");
        cn.jiguang.m.b.b(context, true);
        cn.jiguang.bb.f.f("JAppActiveHelper", "clear active cache success");
    }

    private void a(String str, Map<String, cn.jiguang.common.app.entity.a> map) {
        if (map.isEmpty()) {
            try {
                String e6 = j.e(str);
                if (!TextUtils.isEmpty(e6)) {
                    JSONObject jSONObject = new JSONObject(e6);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jiguang.common.app.entity.a a6 = cn.jiguang.common.app.entity.a.a(jSONObject.getJSONObject(keys.next()).toString());
                        map.put(a6.f2820a, a6);
                    }
                }
                cn.jiguang.bb.f.c("JAppActiveHelper", "Read app active from cache file, file size: " + map.size());
            } catch (Throwable th) {
                cn.jiguang.bb.f.c("JAppActiveHelper", "Read app active data from cache file failed, " + th.getMessage());
            }
        }
    }

    private void a(HashMap<String, cn.jiguang.common.app.entity.a> hashMap, HashMap<String, cn.jiguang.common.app.entity.a> hashMap2, String str) {
        int size;
        try {
            for (cn.jiguang.common.app.entity.a aVar : hashMap.values()) {
                cn.jiguang.common.app.entity.a aVar2 = hashMap2.get(aVar.f2820a);
                if (aVar2 == null) {
                    aVar2 = new cn.jiguang.common.app.entity.a();
                }
                int size2 = aVar2.f2824e.size();
                boolean z5 = aVar.f2824e.size() > 0 && aVar.f2824e.get(0).longValue() > 0;
                if (z5) {
                    Long l6 = aVar.f2824e.get(0);
                    long longValue = l6.longValue();
                    if (size2 <= 0 || longValue > aVar2.f2824e.get(size2 - 1).longValue()) {
                        aVar2.f2824e.add(l6);
                        aVar2.f2823d.add(aVar.f2823d.get(0));
                    }
                }
                if (aVar.f2826g.size() > 0) {
                    Long l7 = aVar.f2826g.get(0);
                    long longValue2 = l7.longValue();
                    if (longValue2 > 0 && ((size = aVar2.f2826g.size()) == 0 || (!z5 && aVar2.f2826g.get(size - 1).longValue() != longValue2))) {
                        long currentTimeMillis = System.currentTimeMillis();
                        aVar2.f2826g.add(l7);
                        aVar2.f2824e.add(Long.valueOf(currentTimeMillis));
                        aVar2.f2823d.add(2);
                    }
                }
                aVar2.f2820a = aVar.f2820a;
                aVar2.f2821b = aVar.f2821b;
                aVar2.f2822c = aVar.f2822c;
                hashMap2.put(aVar.f2820a, aVar2);
            }
            a(hashMap2, str);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JAppActiveHelper", "updateAppActiveData error, " + th.getMessage());
        }
    }

    private synchronized void a(Map<String, cn.jiguang.common.app.entity.a> map, String str) {
        if (map != null) {
            if (!map.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, cn.jiguang.common.app.entity.a> entry : map.entrySet()) {
                        cn.jiguang.common.app.entity.a value = entry.getValue();
                        if (value != null) {
                            jSONObject.put(entry.getKey(), value.a(128));
                        }
                    }
                    j.a(str, jSONObject.toString());
                } catch (Throwable th) {
                    cn.jiguang.bb.f.c("JAppActiveHelper", "App active data cache to file failed: " + th.getMessage());
                }
            }
        }
    }
}
