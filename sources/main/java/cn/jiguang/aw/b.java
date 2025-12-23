package cn.jiguang.aw;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.az.g;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.umeng.analytics.pro.bi;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Context f1802a;

    /* renamed from: b, reason: collision with root package name */
    private int f1803b;

    /* renamed from: c, reason: collision with root package name */
    private String f1804c;

    /* renamed from: d, reason: collision with root package name */
    private int f1805d;

    /* renamed from: e, reason: collision with root package name */
    private int f1806e;

    /* renamed from: f, reason: collision with root package name */
    private int f1807f;

    /* renamed from: g, reason: collision with root package name */
    private int f1808g;

    /* renamed from: h, reason: collision with root package name */
    private int f1809h;

    /* renamed from: i, reason: collision with root package name */
    private int f1810i;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, Integer> f1811j;

    /* renamed from: k, reason: collision with root package name */
    private String f1812k;

    public b() {
    }

    public int a() {
        return this.f1803b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (a() != bVar.a() || this.f1806e != bVar.f1806e || this.f1805d != bVar.f1805d || this.f1807f != bVar.f1807f) {
                return false;
            }
            String str = this.f1804c;
            if (str == null ? bVar.f1804c != null : !str.equals(bVar.f1804c)) {
                return false;
            }
            String str2 = this.f1812k;
            String str3 = bVar.f1812k;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public b(Context context, a aVar, int i6, int i7) {
        if (aVar != null) {
            this.f1803b = aVar.f1800k;
            this.f1804c = aVar.f1801l;
        }
        this.f1802a = context;
        a(i6, i7);
        this.f1811j = new HashMap();
        this.f1812k = g.a(context);
    }

    public void a(int i6, int i7) {
        this.f1805d = i6;
        this.f1806e = i7;
        String a6 = cn.jiguang.av.a.a(i6, 4);
        if (TextUtils.isEmpty(a6)) {
            return;
        }
        try {
            this.f1807f = Integer.parseInt(a6);
        } catch (Throwable unused) {
        }
    }

    public boolean b() {
        Context context;
        if (TextUtils.isEmpty(this.f1812k) || (context = this.f1802a) == null) {
            return false;
        }
        return !this.f1812k.equals(context.getPackageName());
    }

    public void c() {
        this.f1808g++;
    }

    public void d() {
        this.f1809h++;
    }

    public String e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cl", this.f1804c);
            jSONObject.put("type", this.f1803b);
            jSONObject.put(bi.bg, this.f1806e);
            jSONObject.put("plugin_id", this.f1805d);
            jSONObject.put(bi.bo, this.f1807f);
            jSONObject.put("cnt_start", this.f1808g);
            jSONObject.put("cnt_suc", this.f1809h);
            jSONObject.put("cnt_fai", this.f1810i);
            jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, this.f1812k);
            Set<Map.Entry<String, Integer>> entrySet = this.f1811j.entrySet();
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : entrySet) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("error_msg", entry.getKey());
                jSONObject2.put("count", entry.getValue());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("msg", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String f() {
        return this.f1812k;
    }

    public void a(b bVar) {
        if (equals(bVar)) {
            this.f1808g += bVar.f1808g;
            this.f1809h += bVar.f1809h;
            this.f1810i += bVar.f1810i;
            for (String str : bVar.f1811j.keySet()) {
                if (this.f1811j.containsKey(str)) {
                    Integer num = this.f1811j.get(str);
                    Integer num2 = bVar.f1811j.get(str);
                    if (num != null && num2 != null) {
                        this.f1811j.put(str, Integer.valueOf(num.intValue() + num2.intValue()));
                    }
                } else {
                    Integer num3 = bVar.f1811j.get(str);
                    if (num3 != null) {
                        this.f1811j.put(str, num3);
                    }
                }
            }
        }
    }

    public void a(String str) {
        this.f1810i++;
        Integer num = this.f1811j.get(str);
        if (num == null) {
            this.f1811j.put(str, 0);
        } else {
            this.f1811j.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f1803b = jSONObject.optInt("type");
        this.f1804c = jSONObject.optString("cl");
        this.f1806e = jSONObject.optInt(bi.bg);
        this.f1805d = jSONObject.optInt("plugin_id");
        this.f1807f = jSONObject.optInt(bi.bo);
        this.f1808g = jSONObject.optInt("cnt_start");
        this.f1809h = jSONObject.optInt("cnt_suc");
        this.f1810i = jSONObject.optInt("cnt_fai");
        this.f1812k = jSONObject.optString(ContentProviderManager.PLUGIN_PROCESS_NAME);
        JSONArray optJSONArray = jSONObject.optJSONArray("msg");
        this.f1811j = new HashMap();
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                this.f1811j.put(optJSONObject.optString("error_msg"), Integer.valueOf(optJSONObject.optInt("count")));
            }
        }
    }
}
