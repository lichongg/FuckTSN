package com.bytedance.sdk.openadsdk.core.j;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.i.cw.xt.jy;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends com.bytedance.sdk.openadsdk.tj.j.xt.j.up implements xt {

    /* renamed from: j, reason: collision with root package name */
    private long f29169j;

    @Override // com.bytedance.sdk.openadsdk.core.j.xt
    public long xt() {
        return this.f29169j;
    }

    public ae(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.f29169j = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.up
    public void j(final int i6, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(i6, str);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.ae.1
                @Override // java.lang.Runnable
                public void run() {
                    ae.super.j(i6, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.up
    public void j(final List<jy> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(list);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.ae.2
                @Override // java.lang.Runnable
                public void run() {
                    ae.super.j(list);
                }
            });
        }
    }
}
