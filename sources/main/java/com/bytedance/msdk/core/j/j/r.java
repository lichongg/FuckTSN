package com.bytedance.msdk.core.j.j;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.tj.mi;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements m {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f24487j;
    private String xt;

    @Override // com.bytedance.msdk.core.j.j.m
    public boolean j() {
        return mi.cw();
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public String ae() {
        return this.xt;
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public String cw() {
        return "x_class_name";
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public void j(Function<SparseArray<Object>, Object> function) {
        this.f24487j = function;
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public Function<SparseArray<Object>, Object> m() {
        return this.f24487j;
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public String r() {
        return "x_adn_version";
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public String tl() {
        return "xiaomi";
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public Function<SparseArray<Object>, Object> xt() {
        return up.xt("xiaomi");
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public void j(String str) {
        this.xt = str;
    }

    @Override // com.bytedance.msdk.core.j.j.m
    public String up() {
        return oq.i().ed();
    }
}
