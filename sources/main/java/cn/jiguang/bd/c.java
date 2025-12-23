package cn.jiguang.bd;

import android.text.TextUtils;
import cn.jiguang.bz.j;
import cn.jiguang.bz.n;
import java.io.File;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public long f1985a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f1986b;

    /* renamed from: c, reason: collision with root package name */
    private File f1987c;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f1988d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1989e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1990f;

    public static c a(File file, Set<String> set) {
        JSONObject a6 = a(file);
        if (a6 != null) {
            return new c(file, a6, n.a(a6, set), false);
        }
        j.b(file);
        return null;
    }

    public static c a(File file, JSONObject jSONObject) {
        JSONObject a6 = a(file);
        if (a6 != null) {
            return new c(file, a6, jSONObject, true);
        }
        j.b(file);
        return null;
    }

    private c(File file, JSONObject jSONObject, JSONObject jSONObject2, boolean z5) {
        this.f1987c = file;
        this.f1988d = jSONObject;
        this.f1986b = jSONObject2;
        this.f1985a = file.length();
        this.f1990f = z5;
        this.f1989e = z5;
    }

    public static JSONObject a(File file) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        try {
            String c6 = j.c(file);
            if (TextUtils.isEmpty(c6) || (optJSONArray = (jSONObject = new JSONObject(c6)).optJSONArray("content")) == null) {
                return null;
            }
            if (optJSONArray.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a(c cVar, File file) {
        if (cVar != null) {
            try {
                if (this.f1985a + cVar.f1985a <= 40960) {
                    JSONArray jSONArray = this.f1988d.getJSONArray("content");
                    JSONArray jSONArray2 = cVar.f1988d.getJSONArray("content");
                    for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                        jSONArray.put(jSONArray2.getJSONObject(i6));
                    }
                    this.f1985a += cVar.f1985a;
                    this.f1989e = true;
                    j.b(cVar.f1987c);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, this.f1987c.getName());
        if (this.f1990f) {
            n.a(this.f1988d, this.f1986b);
        }
        boolean equals = this.f1987c.equals(file2);
        if (this.f1989e || !equals) {
            j.b(file2, this.f1988d.toString());
        }
        if (!equals) {
            j.b(this.f1987c);
        }
        return false;
    }
}
