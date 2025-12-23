package com.bytedance.sdk.component.tl.xt.r.xt;

import com.baidu.mobads.sdk.internal.bn;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private int f26798j;
    private int xt;

    public int j() {
        return this.f26798j;
    }

    public static j cw() {
        return new j(1, 100, bn.f10749e);
    }

    public static j j(int i6, int i7) {
        return new j(i6, i7, bn.f10749e);
    }

    public int xt() {
        return this.xt;
    }

    j(int i6, int i7, long j6) {
        if (i7 >= i6) {
            this.f26798j = i6;
            this.xt = i7;
            return;
        }
        throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
    }

    public static j j(int i6, int i7, long j6) {
        return new j(i6, i7, j6);
    }
}
