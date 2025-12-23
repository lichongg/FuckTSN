package com.bytedance.adsdk.ugeno.j.j;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    protected JSONObject f23681j;
    protected com.bytedance.adsdk.ugeno.xt.cw xt;

    /* renamed from: com.bytedance.adsdk.ugeno.j.j.j$j, reason: collision with other inner class name */
    public static class C0321j {
        public static j j(com.bytedance.adsdk.ugeno.xt.cw cwVar, JSONObject jSONObject) {
            if (cwVar == null || jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("type");
            optString.getClass();
            switch (optString) {
                case "stretch":
                    return new up(cwVar, jSONObject);
                case "ripple":
                    return new xt(cwVar, jSONObject);
                case "rub_in":
                    return new cw(cwVar, jSONObject);
                case "shine":
                    return new r(cwVar, jSONObject);
                default:
                    return null;
            }
        }
    }

    public abstract List<PropertyValuesHolder> cw();

    public void j() {
        this.cw = this.f23681j.optString("type");
        xt();
    }

    public abstract void j(int i6, int i7);

    public abstract void j(Canvas canvas);

    public abstract void xt();

    public String r() {
        return this.cw;
    }

    public j(com.bytedance.adsdk.ugeno.xt.cw cwVar, JSONObject jSONObject) {
        this.f23681j = jSONObject;
        this.xt = cwVar;
        j();
    }
}
