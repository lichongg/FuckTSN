package com.bytedance.sdk.openadsdk.core.xt.j;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class j {
    protected qv cw;

    /* renamed from: j, reason: collision with root package name */
    protected n f31325j;

    /* renamed from: r, reason: collision with root package name */
    protected View f31326r;
    protected Context xt;

    public abstract int j(Map<String, Object> map, cw cwVar);

    public void j(qv qvVar) {
        this.cw = qvVar;
    }

    public void j(View view) {
        this.f31326r = view;
    }
}
