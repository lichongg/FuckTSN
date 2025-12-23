package cn.jiguang.bg;

import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.bi;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public String f2115a;

    /* renamed from: b, reason: collision with root package name */
    public int f2116b;

    /* renamed from: c, reason: collision with root package name */
    public g f2117c;

    /* renamed from: d, reason: collision with root package name */
    public long f2118d;

    /* renamed from: e, reason: collision with root package name */
    public long f2119e;

    /* renamed from: f, reason: collision with root package name */
    public long f2120f;

    /* renamed from: g, reason: collision with root package name */
    public int f2121g;

    /* renamed from: h, reason: collision with root package name */
    public double f2122h;

    /* renamed from: i, reason: collision with root package name */
    public double f2123i;

    /* renamed from: j, reason: collision with root package name */
    public long f2124j;

    /* renamed from: k, reason: collision with root package name */
    public int f2125k;

    public static m a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                m mVar = new m();
                mVar.f2115a = jSONObject.optString("appkey");
                mVar.f2116b = jSONObject.getInt("type");
                mVar.f2117c = g.a(jSONObject.getString("addr"));
                mVar.f2119e = jSONObject.getLong("rtime");
                mVar.f2120f = jSONObject.getLong(bi.aX);
                mVar.f2121g = jSONObject.getInt(TKDownloadReason.KSAD_TK_NET);
                mVar.f2125k = jSONObject.getInt("code");
                mVar.f2118d = jSONObject.optLong("uid");
                mVar.f2122h = jSONObject.optDouble(com.umeng.analytics.pro.d.C);
                mVar.f2123i = jSONObject.optDouble(com.umeng.analytics.pro.d.D);
                mVar.f2124j = jSONObject.optLong("ltime");
                return mVar;
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static LinkedList<m> a(String str) {
        LinkedList<m> linkedList = new LinkedList<>();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    linkedList.add(a(jSONArray.getJSONObject(i6)));
                }
            } catch (JSONException unused) {
            }
        }
        return linkedList;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f2115a)) {
                jSONObject.put("appkey", this.f2115a);
            }
            jSONObject.put("type", this.f2116b);
            jSONObject.put("addr", this.f2117c.toString());
            jSONObject.put("rtime", this.f2119e);
            jSONObject.put(bi.aX, this.f2120f);
            jSONObject.put(TKDownloadReason.KSAD_TK_NET, this.f2121g);
            jSONObject.put("code", this.f2125k);
            long j6 = this.f2118d;
            if (j6 != 0) {
                jSONObject.put("uid", j6);
            }
            if (a(this.f2122h, this.f2123i)) {
                jSONObject.put(com.umeng.analytics.pro.d.C, this.f2122h);
                jSONObject.put(com.umeng.analytics.pro.d.D, this.f2123i);
                jSONObject.put("ltime", this.f2124j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static boolean a(double d6, double d7) {
        return d6 > -90.0d && d6 < 90.0d && d7 > -180.0d && d7 < 180.0d;
    }
}
