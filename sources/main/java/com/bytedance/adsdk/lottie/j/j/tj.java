package com.bytedance.adsdk.lottie.j.j;

import com.bytedance.adsdk.lottie.j.xt.j;
import com.bytedance.adsdk.lottie.model.xt.mi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class tj implements cw, j.InterfaceC0316j {
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> ae;
    private final List<j.InterfaceC0316j> cw = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private final String f23272j;

    /* renamed from: m, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> f23273m;

    /* renamed from: r, reason: collision with root package name */
    private final mi.j f23274r;
    private final com.bytedance.adsdk.lottie.j.xt.j<?, Float> up;
    private final boolean xt;

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
    }

    public com.bytedance.adsdk.lottie.j.xt.j<?, Float> cw() {
        return this.f23273m;
    }

    mi.j getType() {
        return this.f23274r;
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        for (int i6 = 0; i6 < this.cw.size(); i6++) {
            this.cw.get(i6).j();
        }
    }

    public com.bytedance.adsdk.lottie.j.xt.j<?, Float> r() {
        return this.ae;
    }

    public boolean up() {
        return this.xt;
    }

    public com.bytedance.adsdk.lottie.j.xt.j<?, Float> xt() {
        return this.up;
    }

    public tj(com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.mi miVar) {
        this.f23272j = miVar.j();
        this.xt = miVar.up();
        this.f23274r = miVar.getType();
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j6 = miVar.cw().j();
        this.up = j6;
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j7 = miVar.xt().j();
        this.f23273m = j7;
        com.bytedance.adsdk.lottie.j.xt.j<Float, Float> j8 = miVar.r().j();
        this.ae = j8;
        cwVar.j(j6);
        cwVar.j(j7);
        cwVar.j(j8);
        j6.j(this);
        j7.j(this);
        j8.j(this);
    }

    void j(j.InterfaceC0316j interfaceC0316j) {
        this.cw.add(interfaceC0316j);
    }
}
