package com.bytedance.sdk.openadsdk.live.j;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements ILiveHostActionParam {

    /* renamed from: j, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f31573j;

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z5, String str, String str2, Map<String, String> map) {
        if (this.f31573j != null) {
            this.f31573j.apply(a.a().i(0, z5).h(1, str).h(2, str2).g(3, map).e(-99999987, 1).k().sparseArray());
        }
    }

    public xt(Function<SparseArray<Object>, Object> function) {
        this.f31573j = function;
    }
}
