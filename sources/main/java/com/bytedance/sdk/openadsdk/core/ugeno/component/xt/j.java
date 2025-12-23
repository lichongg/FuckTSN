package com.bytedance.sdk.openadsdk.core.ugeno.component.xt;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.adsdk.ugeno.m.tl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.ugeno.component.xt.up;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public static int f30660j = 0;
    public static int xt = 1;
    private up.j cw;

    /* renamed from: r, reason: collision with root package name */
    private int f30661r = 60;
    private int up = xt;

    public int j(RecyclerView recyclerView) {
        up.j jVar;
        View cw;
        up.j jVar2 = null;
        com.bytedance.sdk.component.widget.recycler.up upVar = recyclerView.getLayoutManager() instanceof com.bytedance.sdk.component.widget.recycler.up ? (com.bytedance.sdk.component.widget.recycler.up) recyclerView.getLayoutManager() : null;
        if (upVar != null) {
            int qv = upVar.qv();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int oq = upVar.oq(); oq <= qv; oq++) {
                Object cw2 = recyclerView.cw(oq);
                if ((cw2 instanceof up.j) && (cw = (jVar = (up.j) cw2).cw()) != null && j(cw, this.f30661r)) {
                    if (this.up == f30660j) {
                        jVar.K_();
                        this.cw = jVar;
                        return oq;
                    }
                    linkedHashMap.put(Integer.valueOf(oq), jVar);
                }
            }
            int i6 = Integer.MAX_VALUE;
            int i7 = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int xt2 = xt(((up.j) entry.getValue()).cw());
                if (xt2 < i6) {
                    up.j jVar3 = (up.j) entry.getValue();
                    i7 = ((Integer) entry.getKey()).intValue();
                    jVar2 = jVar3;
                    i6 = xt2;
                }
            }
            up.j jVar4 = this.cw;
            if (jVar4 != jVar2) {
                if (jVar4 != null) {
                    jVar4.J_();
                }
                this.cw = jVar2;
            }
            up.j jVar5 = this.cw;
            if (jVar5 != null) {
                jVar5.K_();
                return i7;
            }
        }
        return -1;
    }

    private int xt(View view) {
        int j6 = (int) (tl.j(view.getContext()) / 2.3d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs((iArr[1] + (view.getHeight() / 2)) - j6);
    }

    public void j() {
        up.j jVar = this.cw;
        if (jVar == null || jVar.cw() == null || j(this.cw.cw(), this.f30661r)) {
            return;
        }
        this.cw.J_();
    }

    private int j(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean j(View view, int i6) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && j(view) >= i6;
    }
}
