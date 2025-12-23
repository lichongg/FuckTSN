package com.bytedance.sdk.openadsdk.core.j;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.tj;
import com.bytedance.sdk.openadsdk.i.cw.xt.ws;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends com.bytedance.sdk.openadsdk.tj.j.xt.j.m implements xt {

    /* renamed from: j, reason: collision with root package name */
    private long f29192j;

    @Override // com.bytedance.sdk.openadsdk.core.j.xt
    public long xt() {
        return this.f29192j;
    }

    public tl(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.f29192j = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.m
    public void j(final int i6, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(i6, str);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.tl.1
                @Override // java.lang.Runnable
                public void run() {
                    tl.super.j(i6, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.tj.j.xt.j.m
    public void j(final List<ws> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.j(list);
        } else {
            tj.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.j.tl.2
                @Override // java.lang.Runnable
                public void run() {
                    tl.super.j(list);
                }
            });
        }
    }
}
