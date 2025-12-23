package cn.jpush.android.b;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.n.e;
import cn.jpush.android.n.f;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private c f3559a;

    /* renamed from: b, reason: collision with root package name */
    private f f3560b;

    /* renamed from: cn.jpush.android.b.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f3561a = new d(null);
    }

    private d() {
        f();
    }

    public static d a() {
        return a.f3561a;
    }

    /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void a(int i6) {
        e.a().a(i6);
    }

    public void b() {
        this.f3559a.b();
    }

    public void c() {
        this.f3559a.a();
    }

    public void d() {
        this.f3560b.a();
    }

    public void e() {
        this.f3560b.b();
    }

    private void f() {
        Context a6 = m.a();
        e.a().a(a6);
        this.f3559a = new cn.jpush.android.b.a(a6);
        this.f3560b = new f(a6);
    }

    public void a(long j6) {
        this.f3559a.a(j6);
    }

    public void a(long j6, int i6, cn.jpush.android.n.d dVar) {
        this.f3560b.a(j6, i6, dVar);
    }

    public void a(b bVar) {
        Logger.dd("GeofenceManager", "recv geofence...");
        e.a().b(bVar);
    }

    public void a(cn.jpush.android.n.b bVar) {
        this.f3560b.a(bVar);
    }

    public void a(String str) {
        e.a().a(str);
    }

    public void a(JSONObject jSONObject) {
        String str;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                return;
            }
            String optString = jSONObject2.optString("op");
            String optString2 = jSONObject2.optString("geofenceid");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                int hashCode = optString.hashCode();
                if (hashCode != 96417) {
                    if (hashCode != 99339) {
                        if (hashCode == 116009 && optString.equals("upd")) {
                            e.a().a(optString2, jSONObject2, true);
                            return;
                        }
                    } else if (optString.equals("del")) {
                        e.a().a(optString2);
                        return;
                    }
                } else if (optString.equals("add")) {
                    e.a().b(b.a(jSONObject2));
                    return;
                }
                str = "operation " + optString + " not supported";
                Logger.w("GeofenceManager", str);
            }
            str = "json error: required key not found";
            Logger.w("GeofenceManager", str);
        } catch (Throwable th) {
            Logger.w("GeofenceManager", "json error:" + th);
        }
    }
}
