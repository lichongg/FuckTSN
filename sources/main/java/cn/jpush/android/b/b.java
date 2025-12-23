package cn.jpush.android.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements Serializable {
    private static final long serialVersionUID = 2310616383854860780L;

    /* renamed from: a, reason: collision with root package name */
    public String f3536a;

    /* renamed from: b, reason: collision with root package name */
    public long f3537b;

    /* renamed from: c, reason: collision with root package name */
    public String f3538c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3539d;

    /* renamed from: e, reason: collision with root package name */
    public long f3540e;

    /* renamed from: f, reason: collision with root package name */
    public double f3541f = 200.0d;

    /* renamed from: g, reason: collision with root package name */
    public double f3542g = 200.0d;

    /* renamed from: h, reason: collision with root package name */
    public String f3543h;

    /* renamed from: i, reason: collision with root package name */
    public int f3544i;

    /* renamed from: j, reason: collision with root package name */
    public String f3545j;

    /* renamed from: k, reason: collision with root package name */
    public String f3546k;

    /* renamed from: l, reason: collision with root package name */
    public int f3547l;

    /* renamed from: m, reason: collision with root package name */
    public int f3548m;

    /* renamed from: n, reason: collision with root package name */
    public int f3549n;

    /* renamed from: o, reason: collision with root package name */
    public long f3550o;

    /* renamed from: p, reason: collision with root package name */
    public String f3551p;

    /* renamed from: q, reason: collision with root package name */
    public int f3552q;

    /* renamed from: r, reason: collision with root package name */
    public String f3553r;

    /* renamed from: s, reason: collision with root package name */
    public int f3554s;

    /* renamed from: t, reason: collision with root package name */
    public cn.jpush.android.d.d f3555t;

    public static b a(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.f3546k = jSONObject.optString("op");
            bVar.f3536a = jSONObject.optString("geofenceid");
            bVar.f3545j = jSONObject.optString(CommonNetImpl.NAME);
            bVar.f3537b = jSONObject.optLong("radius");
            bVar.f3538c = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            bVar.f3539d = jSONObject.optBoolean("repeat");
            bVar.f3547l = jSONObject.optInt("repeat_week_num");
            bVar.f3548m = jSONObject.optInt("repeat_day_num");
            bVar.f3549n = jSONObject.optInt("repeat_time");
            bVar.f3540e = jSONObject.optLong("expiration");
            bVar.f3544i = jSONObject.optInt("type", 1);
            bVar.f3541f = jSONObject.optDouble("lon", 200.0d);
            bVar.f3542g = jSONObject.optDouble(com.umeng.analytics.pro.d.C, 200.0d);
            bVar.f3550o = jSONObject.optLong("lastTime");
            bVar.f3551p = jSONObject.optString("lastTimeWeek");
            bVar.f3552q = jSONObject.optInt("weekNum");
            bVar.f3553r = jSONObject.optString("lastTimeDay");
            bVar.f3554s = jSONObject.optInt("dayNum");
            bVar.f3543h = jSONObject.optString("lastGeoStatus");
            String optString = jSONObject.optString("entity");
            if (!TextUtils.isEmpty(optString)) {
                bVar.f3555t = cn.jpush.android.d.d.a(optString, context.getPackageName(), JCoreHelper.getAppKey(context), 0L);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static b a(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.w("Geofence", "geofence json is null");
                return null;
            }
            b bVar = new b();
            Logger.d("Geofence", "geofence message:" + jSONObject.toString());
            bVar.f3546k = jSONObject.optString("op");
            bVar.f3536a = jSONObject.optString("geofenceid");
            bVar.f3545j = jSONObject.optString(CommonNetImpl.NAME);
            bVar.f3537b = jSONObject.optLong("radius");
            bVar.f3538c = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            bVar.f3539d = jSONObject.optBoolean("repeat");
            bVar.f3547l = jSONObject.optInt("repeat_week_num");
            bVar.f3548m = jSONObject.optInt("repeat_day_num");
            bVar.f3549n = jSONObject.optInt("repeat_time");
            bVar.f3540e = jSONObject.optLong("expiration");
            bVar.f3544i = jSONObject.optInt("type", 1);
            JSONObject optJSONObject = jSONObject.optJSONObject(AutoScrollViewPager.f4187g);
            if (optJSONObject != null) {
                bVar.f3541f = optJSONObject.optDouble("lon", 200.0d);
                bVar.f3542g = optJSONObject.optDouble(com.umeng.analytics.pro.d.C, 200.0d);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void b(JSONObject jSONObject) {
        try {
            if (jSONObject.has(CommonNetImpl.NAME)) {
                this.f3545j = jSONObject.optString(CommonNetImpl.NAME);
            }
            long optLong = jSONObject.optLong("radius", -1L);
            if (optLong > 0) {
                this.f3537b = optLong;
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_STATUS)) {
                this.f3538c = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            }
            if (jSONObject.has("repeat")) {
                boolean optBoolean = jSONObject.optBoolean("repeat");
                this.f3539d = optBoolean;
                if (optBoolean) {
                    if (jSONObject.has("repeat_week_num")) {
                        this.f3547l = jSONObject.optInt("repeat_week_num");
                    }
                    if (jSONObject.has("repeat_day_num")) {
                        this.f3548m = jSONObject.optInt("repeat_day_num");
                    }
                    if (jSONObject.has("repeat_time")) {
                        this.f3549n = jSONObject.optInt("repeat_time");
                    }
                }
            }
            if (jSONObject.has("expiration")) {
                this.f3540e = jSONObject.optLong("expiration");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(AutoScrollViewPager.f4187g);
            if (optJSONObject != null) {
                double optDouble = optJSONObject.optDouble("lon", 200.0d);
                double optDouble2 = optJSONObject.optDouble(com.umeng.analytics.pro.d.C, 200.0d);
                if (optDouble >= -180.0d && optDouble <= 180.0d && optDouble2 >= -90.0d && optDouble2 <= 90.0d) {
                    this.f3541f = optDouble;
                    this.f3542g = optDouble2;
                    return;
                }
                Logger.w("Geofence", "update center failed because value invalid, [" + optDouble2 + "," + optDouble + "]");
            }
        } catch (Throwable unused) {
        }
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("op", this.f3546k);
            jSONObject.put("geofenceid", this.f3536a);
            jSONObject.put(CommonNetImpl.NAME, this.f3545j);
            jSONObject.put("radius", this.f3537b);
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, this.f3538c);
            jSONObject.put("repeat", this.f3539d);
            jSONObject.put("repeat_week_num", this.f3547l);
            jSONObject.put("repeat_day_num", this.f3548m);
            jSONObject.put("repeat_time", this.f3549n);
            jSONObject.put("expiration", this.f3540e);
            jSONObject.put("type", this.f3544i);
            jSONObject.put("lon", this.f3541f);
            jSONObject.put(com.umeng.analytics.pro.d.C, this.f3542g);
            jSONObject.put("lastTime", this.f3550o);
            jSONObject.put("lastTimeWeek", this.f3551p);
            jSONObject.put("weekNum", this.f3552q);
            jSONObject.put("lastTimeDay", this.f3553r);
            jSONObject.put("dayNum", this.f3554s);
            jSONObject.put("lastGeoStatus", this.f3543h);
            cn.jpush.android.d.d dVar = this.f3555t;
            if (dVar != null) {
                jSONObject.put("entity", dVar.f3593i);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(b bVar) {
        this.f3543h = bVar.f3543h;
        this.f3550o = bVar.f3550o;
        this.f3551p = bVar.f3551p;
        this.f3553r = bVar.f3553r;
        this.f3552q = bVar.f3552q;
        this.f3554s = bVar.f3554s;
    }
}
