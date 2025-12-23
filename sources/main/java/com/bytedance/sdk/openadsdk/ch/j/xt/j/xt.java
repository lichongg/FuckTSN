package com.bytedance.sdk.openadsdk.ch.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f27752j;

    public void j(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 144101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.f27752j.apply(sparseArray);
    }

    public void xt(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 144103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.f27752j.apply(sparseArray);
    }

    public void cw(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 144104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.f27752j.apply(sparseArray);
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f27752j = function == null ? e.f22772d : function;
    }

    public JSONObject j() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 144101);
        sparseArray.put(-99999985, JSONObject.class);
        apply = this.f27752j.apply(sparseArray);
        return (JSONObject) apply;
    }

    public void xt() {
        SparseArray sparseArray = new SparseArray(2);
        sparseArray.put(-99999987, 144105);
        sparseArray.put(-99999985, Void.class);
        this.f27752j.apply(sparseArray);
    }
}
