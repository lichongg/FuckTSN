package cn.jiguang.bg;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    final g f2072a;

    /* renamed from: b, reason: collision with root package name */
    int f2073b;

    /* renamed from: c, reason: collision with root package name */
    long f2074c;

    /* renamed from: d, reason: collision with root package name */
    long f2075d;

    /* renamed from: e, reason: collision with root package name */
    int f2076e;

    public static d a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d(new g(jSONObject.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP), jSONObject.getInt("port")));
            dVar.f2073b = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            dVar.f2074c = jSONObject.optLong("fetch_time");
            dVar.f2075d = jSONObject.optLong("cost");
            dVar.f2076e = jSONObject.optInt("prefer");
            return dVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f2073b != dVar.f2073b || this.f2074c != dVar.f2074c || this.f2075d != dVar.f2075d || this.f2076e != dVar.f2076e) {
            return false;
        }
        g gVar = this.f2072a;
        g gVar2 = dVar.f2072a;
        return gVar != null ? gVar.equals(gVar2) : gVar2 == null;
    }

    public String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, this.f2072a.f2081a);
            jSONObject.put("port", this.f2072a.f2082b);
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, this.f2073b);
            jSONObject.put("fetch_time", this.f2074c);
            jSONObject.put("cost", this.f2075d);
            jSONObject.put("prefer", this.f2076e);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public int hashCode() {
        g gVar = this.f2072a;
        int hashCode = (((gVar != null ? gVar.hashCode() : 0) * 31) + this.f2073b) * 31;
        long j6 = this.f2074c;
        int i6 = (hashCode + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.f2075d;
        return ((i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.f2076e;
    }

    public String toString() {
        return "IpInfo{ipPort=" + this.f2072a + ", status=" + this.f2073b + ", fetchTime=" + this.f2074c + ", cost=" + this.f2075d + ", prefer=" + this.f2076e + '}';
    }

    public d(g gVar) {
        this.f2072a = gVar;
    }
}
