package com.bytedance.sdk.openadsdk.core.ch;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.function.Function;
import org.json.JSONObject;

@ATSApi("pitaya")
/* loaded from: D:\Downloads\app\classes4.dex */
public interface cw {
    @ATSMethod(2)
    boolean cw();

    @ATSMethod(1)
    void j(Context context, Function<SparseArray<Object>, Object> function);

    @ATSMethod(5)
    void j(String str, com.bytedance.sdk.component.tl.j.xt xtVar);

    @ATSMethod(6)
    void j(String str, Function<SparseArray<Object>, Object> function);

    @ATSMethod(4)
    void j(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function);

    @ATSMethod(3)
    boolean r();
}
