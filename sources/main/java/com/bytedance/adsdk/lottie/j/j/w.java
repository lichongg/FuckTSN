package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.j.xt.j;
import com.bytedance.adsdk.lottie.model.xt.mi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class w implements jy, j.InterfaceC0316j {
    private final boolean cw;

    /* renamed from: m, reason: collision with root package name */
    private boolean f23286m;

    /* renamed from: r, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.tl f23287r;
    private final com.bytedance.adsdk.lottie.j.xt.jy up;
    private final String xt;

    /* renamed from: j, reason: collision with root package name */
    private final Path f23285j = new Path();
    private final xt ae = new xt();

    private void xt() {
        this.f23286m = false;
        this.f23287r.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.j.xt.j.InterfaceC0316j
    public void j() {
        xt();
    }

    @Override // com.bytedance.adsdk.lottie.j.j.cw
    public void j(List<cw> list, List<cw> list2) {
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < list.size(); i6++) {
            cw cwVar = list.get(i6);
            if (cwVar instanceof tj) {
                tj tjVar = (tj) cwVar;
                if (tjVar.getType() == mi.j.SIMULTANEOUSLY) {
                    this.ae.j(tjVar);
                    tjVar.j(this);
                }
            }
            if (cwVar instanceof mi) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((mi) cwVar);
            }
        }
        this.up.j((List<mi>) arrayList);
    }

    @Override // com.bytedance.adsdk.lottie.j.j.jy
    public Path r() {
        if (this.f23286m) {
            return this.f23285j;
        }
        this.f23285j.reset();
        if (this.cw) {
            this.f23286m = true;
            return this.f23285j;
        }
        Path ae = this.up.ae();
        if (ae == null) {
            return this.f23285j;
        }
        this.f23285j.set(ae);
        this.f23285j.setFillType(Path.FillType.EVEN_ODD);
        this.ae.j(this.f23285j);
        this.f23286m = true;
        return this.f23285j;
    }

    public w(com.bytedance.adsdk.lottie.tl tlVar, com.bytedance.adsdk.lottie.model.layer.cw cwVar, com.bytedance.adsdk.lottie.model.xt.i iVar) {
        this.xt = iVar.j();
        this.cw = iVar.cw();
        this.f23287r = tlVar;
        com.bytedance.adsdk.lottie.j.xt.jy j6 = iVar.xt().j();
        this.up = j6;
        cwVar.j(j6);
        j6.j(this);
    }
}
