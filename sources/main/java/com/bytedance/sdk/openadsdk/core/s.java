package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.a;
import com.bytedance.sdk.openadsdk.core.tj.nd;
import com.bytedance.sdk.openadsdk.core.tj.xp;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface s<T> {

    public interface cw<T> {
        void j(int i6, String str);

        void j(T t5);
    }

    public interface j {
        void j(boolean z5, long j6, long j7);
    }

    public interface r {
        void j(int i6, String str);

        void j(a.cw cwVar);
    }

    public interface up {
        void j(int i6, String str);

        void j(a.r rVar);
    }

    public interface xt {
        void j(int i6, String str, com.bytedance.sdk.openadsdk.core.tj.xt xtVar);

        void j(com.bytedance.sdk.openadsdk.core.tj.j jVar, com.bytedance.sdk.openadsdk.core.tj.xt xtVar);
    }

    void cw(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6, xt xtVar2);

    com.bytedance.sdk.component.adexpress.j.cw.j j(int i6);

    com.bytedance.sdk.openadsdk.core.tj.r j(com.bytedance.sdk.openadsdk.core.tj.n nVar, String str);

    String j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar);

    String j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, boolean z5, int i6);

    void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, List<com.bytedance.sdk.openadsdk.i.cw.xt.m> list);

    void j(xp xpVar, String str, String str2, cw cwVar, int i6, long j6);

    void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6, xt xtVar2);

    void j(String str);

    void j(String str, String str2, j jVar);

    void j(List<com.bytedance.sdk.openadsdk.core.up.xt.r> list, com.bytedance.sdk.openadsdk.core.up.xt.xt xtVar);

    void j(Map<String, Object> map, Function<SparseArray<Object>, Object> function);

    void j(Function<SparseArray<Object>, Object> function);

    void j(JSONObject jSONObject, cw<com.bytedance.sdk.component.g.xt> cwVar);

    void j(JSONObject jSONObject, r rVar);

    void j(JSONObject jSONObject, up upVar);

    void j(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.up.xt.xt xtVar);

    void xt(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, nd ndVar, int i6, xt xtVar2);
}
