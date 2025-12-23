package com.amap.api.col.p0003l;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class ha {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Boolean> f6437a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f6438b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static ha f6439a = new ha(0);
    }

    /* synthetic */ ha(byte b6) {
        this();
    }

    private ha() {
        this.f6437a = new ConcurrentHashMap();
        this.f6438b = new AtomicBoolean(false);
        e();
    }

    private void e() {
        this.f6437a.put("feature_mvt", Boolean.TRUE);
        Map<String, Boolean> map = this.f6437a;
        Boolean bool = Boolean.FALSE;
        map.put("feature_gltf", bool);
        this.f6437a.put("feature_terrain", bool);
    }

    public final void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mvt_able");
        g4.x(optString, true);
        this.f6437a.put("feature_mvt", Boolean.valueOf(g4.x(optString, true)));
        this.f6437a.put("feature_gltf", Boolean.valueOf(g4.x(jSONObject.optString("gltf_able"), false)));
        this.f6437a.put("feature_terrain", Boolean.valueOf(g4.x(jSONObject.optString("terrain_able"), false)));
        this.f6438b.set(true);
    }

    public final boolean c(String str) {
        if (this.f6437a.containsKey(str)) {
            return this.f6437a.get(str).booleanValue();
        }
        return false;
    }

    public final boolean d() {
        return this.f6438b.get();
    }

    public static ha a() {
        return a.f6439a;
    }
}
