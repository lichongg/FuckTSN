package com.bytedance.sdk.openadsdk.live;

import android.util.SparseArray;
import com.bykv.j.j.j.j.a;
import com.bytedance.android.live.base.api.callback.Callback;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements Callback<Object> {

    /* renamed from: j, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f31570j;

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        if (this.f31570j != null) {
            this.f31570j.apply(a.a().g(0, obj).e(-99999987, 1).k().sparseArray());
        }
    }

    public j(Function<SparseArray<Object>, Object> function) {
        this.f31570j = function;
    }
}
