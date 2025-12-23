package com.bytedance.sdk.openadsdk.mediation.init.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public final PluginValueSet f31734j;

    public String ae() {
        return (String) this.f31734j.objectValue(264107, String.class);
    }

    public cw cw() {
        return new cw((SparseArray) this.f31734j.objectValue(264103, SparseArray.class));
    }

    public boolean g() {
        return this.f31734j.booleanValue(264109);
    }

    public String j() {
        return (String) this.f31734j.objectValue(264101, String.class);
    }

    public JSONObject m() {
        return (JSONObject) this.f31734j.objectValue(264106, JSONObject.class);
    }

    public boolean oq() {
        return this.f31734j.booleanValue(264110);
    }

    public String qv() {
        return (String) this.f31734j.objectValue(264111, String.class);
    }

    public Map<String, Object> r() {
        return (Map) this.f31734j.objectValue(264104, Map.class);
    }

    public boolean tl() {
        return this.f31734j.booleanValue(264108);
    }

    public boolean up() {
        return this.f31734j.booleanValue(264105);
    }

    public boolean xt() {
        return this.f31734j.booleanValue(264102);
    }

    public j(SparseArray<Object> sparseArray) {
        this.f31734j = e.i(sparseArray).k();
    }
}
