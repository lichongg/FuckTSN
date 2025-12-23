package com.bytedance.sdk.openadsdk.core.component.reward.up;

import com.bytedance.sdk.openadsdk.core.component.reward.xt.m;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private final int f28429j;

    /* renamed from: r, reason: collision with root package name */
    private final m f28430r;
    private final com.bytedance.sdk.openadsdk.core.component.reward.r.j up;
    private int xt;

    public long j() {
        return this.f28430r.h();
    }

    public int cw() {
        return this.xt;
    }

    public void j(int i6) {
        this.cw += i6;
    }

    public int m() {
        return this.up.uf();
    }

    public int r() {
        return this.cw;
    }

    public int up() {
        return this.f28429j;
    }

    public void xt() {
        this.xt++;
    }

    public cw(boolean z5, n nVar, m mVar, com.bytedance.sdk.openadsdk.core.component.reward.r.j jVar) {
        int m6;
        this.f28430r = mVar;
        this.up = jVar;
        if (z5) {
            m6 = v.xt().up(uf.g(nVar));
        } else {
            m6 = v.xt().m(uf.g(nVar));
        }
        this.f28429j = m6;
    }
}
