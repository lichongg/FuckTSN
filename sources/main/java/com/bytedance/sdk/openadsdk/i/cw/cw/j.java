package com.bytedance.sdk.openadsdk.i.cw.cw;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public final PluginValueSet f31380j;

    public boolean ae() {
        return this.f31380j.booleanValue(261007);
    }

    public boolean av() {
        return this.f31380j.booleanValue(261017);
    }

    public com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.j az() {
        return new com.bytedance.sdk.openadsdk.mediation.init.j.xt.j.j((SparseArray) this.f31380j.objectValue(261016, SparseArray.class));
    }

    public boolean cw() {
        return this.f31380j.booleanValue(261003);
    }

    public int[] g() {
        return (int[]) this.f31380j.objectValue(261009, int[].class);
    }

    public Map<String, Object> i() {
        return (Map) this.f31380j.objectValue(261018, Map.class);
    }

    public String j() {
        return (String) this.f31380j.objectValue(261001, String.class);
    }

    public int jy() {
        return this.f31380j.intValue(261014);
    }

    public int m() {
        return this.f31380j.intValue(261006);
    }

    public boolean oq() {
        return this.f31380j.booleanValue(261011);
    }

    public r qv() {
        return new r((SparseArray) this.f31380j.objectValue(261012, SparseArray.class));
    }

    public String r() {
        return (String) this.f31380j.objectValue(261004, String.class);
    }

    public boolean tl() {
        return this.f31380j.booleanValue(261008);
    }

    public String up() {
        return (String) this.f31380j.objectValue(261005, String.class);
    }

    public int vl() {
        return this.f31380j.intValue(261013);
    }

    public int ws() {
        return this.f31380j.intValue(261015);
    }

    public String xt() {
        return (String) this.f31380j.objectValue(261002, String.class);
    }

    public j(SparseArray<Object> sparseArray) {
        this.f31380j = e.i(sparseArray).k();
    }
}
