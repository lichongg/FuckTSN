package com.bytedance.msdk.api.r.j.xt.m;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.r.j.xt.cw.xt;
import com.bytedance.sdk.openadsdk.core.wq.r;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class j extends r {
    private static final String cw = "TTMediationSDK_" + j.class.getSimpleName();

    /* renamed from: r, reason: collision with root package name */
    private xt f24376r;
    private final AtomicBoolean up = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    protected long f24375j = 0;
    protected int xt = 0;

    public void ae() {
        this.xt = 0;
        this.f24375j = 0L;
    }

    public abstract String j();

    @Nullable
    public String j(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract void j(Context context, xt xtVar, Map<String, Object> map);

    public abstract String xt();

    @Nullable
    public String xt(Context context, Map<String, Object> map) {
        return null;
    }

    public final void cw() {
        this.up.set(true);
    }

    public int m() {
        return this.xt;
    }

    public final boolean r() {
        return this.up.get();
    }

    public long up() {
        return this.f24375j;
    }

    public final void xt(Context context, xt xtVar, Map<String, Object> map) {
        this.up.set(false);
        this.f24376r = xtVar;
        j(context, xtVar, map);
    }
}
