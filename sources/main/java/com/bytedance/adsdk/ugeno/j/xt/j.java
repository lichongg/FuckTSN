package com.bytedance.adsdk.ugeno.j.xt;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.j.up;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j {
    protected com.bytedance.adsdk.ugeno.xt.cw ae;
    protected Map<Float, String> cw;

    /* renamed from: j, reason: collision with root package name */
    protected Context f23703j;

    /* renamed from: r, reason: collision with root package name */
    protected up f23705r;
    protected String xt;

    /* renamed from: m, reason: collision with root package name */
    protected List<PropertyValuesHolder> f23704m = new ArrayList();
    protected List<Keyframe> up = new ArrayList();

    public abstract void j(float f6, String str);

    public boolean j() {
        Map<Float, String> map = this.cw;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.cw.containsKey(Float.valueOf(0.0f));
    }

    public abstract TypeEvaluator m();

    public abstract void xt();

    public void cw() {
        Map<Float, String> map = this.cw;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.cw;
        if (map2 instanceof TreeMap) {
            Float f6 = (Float) ((TreeMap) map2).lastKey();
            if (f6.floatValue() != 100.0f) {
                j(100.0f, this.cw.get(f6));
            }
        }
    }

    public String getType() {
        return this.f23705r.cw();
    }

    public void r() {
        Map<Float, String> map = this.cw;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!j()) {
            xt();
        }
        for (Map.Entry<Float, String> entry : this.cw.entrySet()) {
            if (entry != null) {
                j(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        cw();
    }

    public List<PropertyValuesHolder> up() {
        String xt = this.f23705r.xt();
        r();
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(xt, (Keyframe[]) this.up.toArray(new Keyframe[0]));
        TypeEvaluator m6 = m();
        if (m6 != null) {
            ofKeyframe.setEvaluator(m6);
        }
        this.f23704m.add(ofKeyframe);
        return this.f23704m;
    }

    public j(Context context, com.bytedance.adsdk.ugeno.xt.cw cwVar, String str, Map<Float, String> map) {
        this.f23703j = context;
        this.xt = str;
        this.cw = map;
        this.f23705r = up.j(this.xt);
        this.ae = cwVar;
    }
}
