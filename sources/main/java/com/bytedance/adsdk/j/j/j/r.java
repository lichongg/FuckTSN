package com.bytedance.adsdk.j.j.j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    static class j extends IOException {
        j() {
            super("APNG Format error");
        }
    }

    public static List<up> j(com.bytedance.adsdk.j.j.xt.j jVar) throws IOException {
        if (!jVar.j("\u0089PNG") || !jVar.j("\r\n\u001a\n")) {
            throw new j();
        }
        ArrayList arrayList = new ArrayList();
        while (jVar.r() > 0) {
            arrayList.add(xt(jVar));
        }
        return arrayList;
    }

    private static up xt(com.bytedance.adsdk.j.j.xt.j jVar) throws IOException {
        up upVar;
        int cw = jVar.cw();
        int xt = jVar.xt();
        int b_ = jVar.b_();
        if (b_ == com.bytedance.adsdk.j.j.j.j.f23157j) {
            upVar = new com.bytedance.adsdk.j.j.j.j();
        } else if (b_ == m.f23159j) {
            upVar = new m();
        } else if (b_ == ae.f23135j) {
            upVar = new ae();
        } else if (b_ == oq.f23161j) {
            upVar = new oq();
        } else if (b_ == qv.f23162j) {
            upVar = new qv();
        } else if (b_ == vl.f23166j) {
            upVar = new vl();
        } else {
            upVar = new up();
        }
        upVar.ae = cw;
        upVar.up = b_;
        upVar.f23165r = xt;
        upVar.xt(jVar);
        upVar.f23164m = jVar.xt();
        return upVar;
    }
}
