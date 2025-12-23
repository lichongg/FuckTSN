package com.bytedance.adsdk.ugeno.cw;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private List<C0319j> cw;

    /* renamed from: j, reason: collision with root package name */
    private String f23604j;

    /* renamed from: m, reason: collision with root package name */
    private String f23605m;

    /* renamed from: r, reason: collision with root package name */
    private long f23606r;
    private long up;
    private float xt;

    /* renamed from: com.bytedance.adsdk.ugeno.cw.j$j, reason: collision with other inner class name */
    public static class C0319j {
        private float ae;
        private String cw;

        /* renamed from: g, reason: collision with root package name */
        private String f23607g;

        /* renamed from: j, reason: collision with root package name */
        private long f23608j;

        /* renamed from: m, reason: collision with root package name */
        private float f23609m;
        private String oq;

        /* renamed from: r, reason: collision with root package name */
        private long f23610r;
        private float[] tl;
        private String up;
        private float xt;

        public String cw() {
            return this.cw;
        }

        public long j() {
            return this.f23608j;
        }

        public long r() {
            return this.f23610r;
        }

        public float xt() {
            return this.xt;
        }

        public float[] ae() {
            return this.tl;
        }

        public void cw(float f6) {
            this.ae = f6;
        }

        public String g() {
            return this.oq;
        }

        public String getType() {
            return this.up;
        }

        public void j(long j6) {
            this.f23608j = j6;
        }

        public float m() {
            return this.ae;
        }

        public void r(String str) {
            this.f23607g = str;
        }

        public String tl() {
            return this.f23607g;
        }

        public float up() {
            return this.f23609m;
        }

        public void xt(long j6) {
            this.f23610r = j6;
        }

        public void cw(String str) {
            this.oq = str;
        }

        public void j(float f6) {
            this.xt = f6;
        }

        public void xt(String str) {
            this.up = str;
        }

        public void j(String str) {
            this.cw = str;
        }

        public void xt(float f6) {
            this.f23609m = f6;
        }

        public void j(float[] fArr) {
            this.tl = fArr;
        }

        public static C0319j j(JSONObject jSONObject, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
            if (jSONObject == null) {
                return null;
            }
            C0319j c0319j = new C0319j();
            c0319j.j(jSONObject.optLong("duration"));
            String optString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", optString)) {
                c0319j.j(-1.0f);
            } else {
                try {
                    c0319j.j(Float.parseFloat(optString));
                } catch (NumberFormatException unused) {
                    c0319j.j(0.0f);
                }
            }
            c0319j.j(jSONObject.optString("loopMode"));
            c0319j.xt(jSONObject.optString("type"));
            if (TextUtils.equals(c0319j.getType(), "ripple")) {
                c0319j.cw(jSONObject.optString("rippleColor"));
            }
            View g6 = cwVar.g();
            Context context = g6 != null ? g6.getContext() : null;
            if (TextUtils.equals(c0319j.getType(), "backgroundColor")) {
                String j6 = com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("valueTo"), cwVar.oq());
                int j7 = com.bytedance.adsdk.ugeno.m.j.j(jSONObject.optString("valueFrom"));
                int j8 = com.bytedance.adsdk.ugeno.m.j.j(j6);
                c0319j.xt(j7);
                c0319j.cw(j8);
            } else if ((TextUtils.equals(c0319j.getType(), "translateX") || TextUtils.equals(c0319j.getType(), "translateY")) && context != null) {
                try {
                    float j9 = com.bytedance.adsdk.ugeno.m.tl.j(context, (float) jSONObject.optDouble("valueFrom"));
                    float j10 = com.bytedance.adsdk.ugeno.m.tl.j(context, (float) jSONObject.optDouble("valueTo"));
                    c0319j.xt(j9);
                    c0319j.cw(j10);
                } catch (Exception unused2) {
                    com.bytedance.sdk.component.utils.vl.r("animation", "animation ");
                }
            } else {
                c0319j.xt((float) jSONObject.optDouble("valueFrom"));
                c0319j.cw((float) jSONObject.optDouble("valueTo"));
            }
            c0319j.r(jSONObject.optString("interpolator"));
            c0319j.xt(com.bytedance.adsdk.ugeno.m.cw.j(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("startDelay"), cwVar.oq()), 0L));
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                float[] fArr = new float[optJSONArray.length()];
                int i6 = 0;
                if ((TextUtils.equals(c0319j.getType(), "translateX") || TextUtils.equals(c0319j.getType(), "translateY")) && context != null) {
                    while (i6 < optJSONArray.length()) {
                        fArr[i6] = com.bytedance.adsdk.ugeno.m.tl.j(context, (float) j.j(optJSONArray.optString(i6), cwVar.oq()));
                        i6++;
                    }
                } else {
                    while (i6 < optJSONArray.length()) {
                        fArr[i6] = (float) j.j(optJSONArray.optString(i6), cwVar.oq());
                        i6++;
                    }
                }
                c0319j.j(fArr);
            }
            return c0319j;
        }
    }

    public String j() {
        return this.f23604j;
    }

    public float xt() {
        return this.xt;
    }

    public List<C0319j> cw() {
        return this.cw;
    }

    public void j(String str) {
        this.f23604j = str;
    }

    public String m() {
        return this.f23605m;
    }

    public long r() {
        return this.f23606r;
    }

    public long up() {
        return this.up;
    }

    public void xt(long j6) {
        this.up = j6;
    }

    public void j(float f6) {
        this.xt = f6;
    }

    public void xt(String str) {
        this.f23605m = str;
    }

    public void j(List<C0319j> list) {
        this.cw = list;
    }

    public void j(long j6) {
        this.f23606r = j6;
    }

    public static j j(String str, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return j(new JSONObject(str), cwVar);
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    public static j j(JSONObject jSONObject, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        return j(jSONObject, null, cwVar);
    }

    public static j j(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        jVar.j(jSONObject.optString("ordering"));
        String optString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", optString)) {
            jVar.j(-1.0f);
        } else {
            try {
                jVar.j(Float.parseFloat(optString));
            } catch (NumberFormatException unused) {
                jVar.j(0.0f);
            }
        }
        jVar.j(jSONObject.optLong("duration", 0L));
        jVar.xt(com.bytedance.adsdk.ugeno.m.cw.j(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("startDelay"), cwVar.oq()), 0L));
        jVar.xt(jSONObject.optString("loopMode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("animators");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i6);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.m.xt.j(jSONObject2, optJSONObject);
                }
                arrayList.add(C0319j.j(optJSONObject, cwVar));
            }
            jVar.j(arrayList);
        }
        return jVar;
    }

    public static double j(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.m.cw.j(com.bytedance.adsdk.ugeno.r.xt.j((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
