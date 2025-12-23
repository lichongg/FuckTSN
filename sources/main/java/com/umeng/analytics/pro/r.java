package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static final int f41433a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f41434b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f41435c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f41436d = 3;

    /* renamed from: e, reason: collision with root package name */
    private final long f41437e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.umeng.analytics.pro.r$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* synthetic */ r(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static r a() {
        return a.f41438a;
    }

    public void b(JSONObject jSONObject, Context context) {
        int a6 = a(context);
        if (a6 == 1) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            if (jSONObject.has(d.f41195n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(d.f41195n);
                    int length = jSONArray.length();
                    for (int i6 = 0; i6 < length; i6++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                        if (jSONObject2.has(d.aA)) {
                            jSONObject2.remove(d.aA);
                        }
                        if (jSONObject2.has(d.aB)) {
                            jSONObject2.remove(d.aB);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            i.a(context).a(false, true);
            return;
        }
        if (a6 == 2) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            if (jSONObject.has(d.f41195n)) {
                jSONObject.remove(d.f41195n);
            }
            try {
                jSONObject.put(d.f41195n, c());
            } catch (Exception unused2) {
            }
            i.a(context).a(false, true);
            return;
        }
        if (a6 == 3) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            jSONObject.remove(d.f41195n);
            i.a(context).a(false, true);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final r f41438a = new r(null);

        private a() {
        }
    }

    private r() {
        this.f41437e = 60000L;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(d.f41197p, currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    private void a(JSONObject jSONObject, boolean z5) {
        if (!z5 && jSONObject.has(d.f41195n)) {
            jSONObject.remove(d.f41195n);
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(d.Z)) {
            jSONObject.remove(d.Z);
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        int a6 = a(context);
        if (a6 == 1) {
            a(jSONObject, true);
            i.a(context).b(false, true);
        } else {
            if (a6 == 2) {
                jSONObject.remove(d.f41195n);
                try {
                    jSONObject.put(d.f41195n, b());
                } catch (Exception unused) {
                }
                a(jSONObject, true);
                i.a(context).b(false, true);
                return;
            }
            if (a6 == 3) {
                a(jSONObject, false);
                i.a(context).b(false, true);
            }
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(d.f41197p, currentTimeMillis);
            jSONObject.put(d.f41198q, currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}
