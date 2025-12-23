package cn.jiguang.common.app.entity;

import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f2827a;

    /* renamed from: b, reason: collision with root package name */
    public String f2828b;

    /* renamed from: c, reason: collision with root package name */
    public String f2829c;

    /* renamed from: d, reason: collision with root package name */
    public int f2830d;

    /* renamed from: e, reason: collision with root package name */
    public int f2831e;

    /* renamed from: f, reason: collision with root package name */
    public int f2832f;

    /* renamed from: g, reason: collision with root package name */
    public String f2833g;

    /* renamed from: h, reason: collision with root package name */
    public String f2834h;

    /* renamed from: i, reason: collision with root package name */
    public String f2835i;

    /* renamed from: j, reason: collision with root package name */
    public long f2836j;

    /* renamed from: k, reason: collision with root package name */
    public long f2837k;

    /* renamed from: l, reason: collision with root package name */
    public String[] f2838l;

    private static CharSequence a(CharSequence charSequence, int i6) {
        return (i6 < 0 || i6 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f2830d != bVar.f2830d) {
                return false;
            }
            String str = this.f2828b;
            String str2 = bVar.f2828b;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public JSONObject a(int i6) {
        try {
            return new JSONObject().put("n", this.f2827a).put("p", a(this.f2828b, i6)).put("vn", this.f2829c).put("c", this.f2830d).put(bi.aL, this.f2831e).put("it", this.f2836j).put("ut", this.f2837k).put(CommonNetImpl.SM, this.f2833g).put("ss", this.f2834h).put("sa", this.f2835i);
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject b(int i6) {
        try {
            return new JSONObject().put(CommonNetImpl.NAME, this.f2827a).put("pkg", a(this.f2828b, i6)).put("ver_name", this.f2829c).put("ver_code", this.f2830d).put("pers", Arrays.toString(this.f2838l));
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject c(int i6) {
        try {
            return new JSONObject().put(CommonNetImpl.NAME, this.f2827a).put("pkg", a(this.f2828b, i6)).put("ver_name", this.f2829c).put("ver_code", this.f2830d).put("install_type", this.f2831e).put("install_time", this.f2836j).put("update_time", this.f2837k);
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject d(int i6) {
        try {
            return new JSONObject().put("pkg", a(this.f2828b, i6)).put("ver_name", this.f2829c).put("third_sdk", this.f2832f);
        } catch (JSONException unused) {
            return null;
        }
    }
}
