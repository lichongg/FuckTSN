package com.bytedance.sdk.openadsdk.mediation.manager.j.xt.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31748j;

    public abstract List<xt> getAdLoadInfo();

    public abstract j getBestEcpm();

    public abstract List<j> getCacheList();

    public abstract List<j> getMultiBiddingEcpm();

    public abstract j getShowEcpm();

    public abstract boolean isReady();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return values();
        }
        switch (intValue) {
        }
        return null;
    }

    public SparseArray<Object> values() {
        SparseArray<Object> sparseArray = this.f31748j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> j6 = j();
        this.f31748j = j6;
        return j6;
    }

    private SparseArray<Object> j() {
        return com.bytedance.sdk.openadsdk.i.r.j().xt();
    }
}
