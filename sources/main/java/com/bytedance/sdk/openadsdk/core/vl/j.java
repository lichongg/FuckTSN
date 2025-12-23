package com.bytedance.sdk.openadsdk.core.vl;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.j.cw.r;
import com.bytedance.sdk.component.adexpress.j.xt.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.openadsdk.core.tj.hh;
import com.bytedance.sdk.openadsdk.core.tj.n;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    public static void j(List<n> list, ae.j jVar) {
        r g6;
        if (jVar == null) {
            return;
        }
        if (list == null || list.size() <= 0) {
            jVar.xt();
            jVar.xt();
            return;
        }
        ArrayList<r> arrayList = new ArrayList();
        for (n nVar : list) {
            if (nVar != null && !hh.tl(nVar) && (g6 = hh.g(nVar)) != null) {
                arrayList.add(g6);
            }
        }
        if (arrayList.size() <= 0) {
            jVar.xt();
            return;
        }
        for (r rVar : arrayList) {
            String str = rVar.f25813m;
            final String str2 = rVar.f25812j;
            final String str3 = rVar.cw;
            final String str4 = rVar.xt;
            final String str5 = rVar.f25814r;
            final String str6 = rVar.up;
            final String m6 = TextUtils.isEmpty(str) ? com.bytedance.sdk.component.adexpress.j.j.j.j().cw() != null ? com.bytedance.sdk.component.adexpress.j.j.j.j().cw().m() : "" : str;
            final ae.j jVar2 = jVar;
            com.bytedance.sdk.component.oq.ae.j(new g("saveTemplate") { // from class: com.bytedance.sdk.openadsdk.core.vl.j.1
                @Override // java.lang.Runnable
                public void run() {
                    ae.j().j(str2, str3, str4, str5, str6, m6, jVar2);
                }
            }, 10);
            jVar = jVar2;
        }
    }
}
