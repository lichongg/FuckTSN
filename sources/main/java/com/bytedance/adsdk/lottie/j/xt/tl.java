package com.bytedance.adsdk.lottie.j.xt;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {
    private final List<com.bytedance.adsdk.lottie.model.xt.tl> cw;

    /* renamed from: j, reason: collision with root package name */
    private final List<j<com.bytedance.adsdk.lottie.model.xt.ws, Path>> f23313j;
    private final List<j<Integer, Integer>> xt;

    public List<j<Integer, Integer>> cw() {
        return this.xt;
    }

    public List<com.bytedance.adsdk.lottie.model.xt.tl> j() {
        return this.cw;
    }

    public List<j<com.bytedance.adsdk.lottie.model.xt.ws, Path>> xt() {
        return this.f23313j;
    }

    public tl(List<com.bytedance.adsdk.lottie.model.xt.tl> list) {
        this.cw = list;
        this.f23313j = new ArrayList(list.size());
        this.xt = new ArrayList(list.size());
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.f23313j.add(list.get(i6).xt().j());
            this.xt.add(list.get(i6).cw().j());
        }
    }
}
