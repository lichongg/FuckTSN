package com.bytedance.sdk.openadsdk.mediation.j;

import a1.b;
import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {

    /* renamed from: j, reason: collision with root package name */
    private final Bridge f31736j;

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public <T> T applyFunction(int i6, ValueSet valueSet, Class<T> cls) {
        return (T) this.f31736j.call(i6, valueSet, cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.j.j
    public SparseArray<Object> get() {
        if (this.f31736j.values() == null) {
            return null;
        }
        SparseArray<Object> sparseArray = this.f31736j.values().sparseArray();
        return sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public xt(Bridge bridge) {
        this.f31736j = bridge == null ? a.f22764d : bridge;
    }

    public static Function<SparseArray<Object>, Object> j(Object obj) {
        if (f.a(obj)) {
            return b.a(obj);
        }
        if (obj instanceof Bridge) {
            return new xt((Bridge) obj);
        }
        return null;
    }
}
