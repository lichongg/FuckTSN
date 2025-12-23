package cn.jiguang.common.app.entity;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f2839a;

    /* renamed from: b, reason: collision with root package name */
    public String f2840b;

    /* renamed from: c, reason: collision with root package name */
    public String f2841c;

    /* renamed from: d, reason: collision with root package name */
    public String f2842d;

    /* renamed from: e, reason: collision with root package name */
    public long f2843e;

    /* renamed from: f, reason: collision with root package name */
    public long f2844f;

    private static CharSequence a(CharSequence charSequence, int i6) {
        return (i6 < 0 || i6 >= charSequence.length()) ? charSequence : charSequence.subSequence(0, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f2839a;
            String str2 = ((c) obj).f2839a;
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
            return new JSONObject().put("pkg", a(this.f2839a, i6)).put("install_time", this.f2843e).put("update_time", this.f2844f).put("sign_md5", this.f2840b).put("sign_sha1", this.f2841c).put("sign_sha256", this.f2842d);
        } catch (JSONException unused) {
            return null;
        }
    }
}
