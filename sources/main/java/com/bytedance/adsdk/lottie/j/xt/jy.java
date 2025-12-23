package com.bytedance.adsdk.lottie.j.xt;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.j.j.mi;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class jy extends j<com.bytedance.adsdk.lottie.model.xt.ws, Path> {

    /* renamed from: m, reason: collision with root package name */
    private List<mi> f23308m;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.xt.ws f23309r;
    private final Path up;

    public void j(List<mi> list) {
        this.f23308m = list;
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j
    /* renamed from: xt, reason: merged with bridge method [inline-methods] */
    public Path j(com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt.ws> jVar, float f6) {
        this.f23309r.j(jVar.f23337j, jVar.xt, f6);
        com.bytedance.adsdk.lottie.model.xt.ws wsVar = this.f23309r;
        List<mi> list = this.f23308m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                wsVar = this.f23308m.get(size).j(wsVar);
            }
        }
        com.bytedance.adsdk.lottie.up.tl.j(wsVar, this.up);
        return this.up;
    }

    public jy(List<com.bytedance.adsdk.lottie.m.j<com.bytedance.adsdk.lottie.model.xt.ws>> list) {
        super(list);
        this.f23309r = new com.bytedance.adsdk.lottie.model.xt.ws();
        this.up = new Path();
    }
}
