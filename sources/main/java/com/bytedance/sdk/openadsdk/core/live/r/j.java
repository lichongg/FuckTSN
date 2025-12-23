package com.bytedance.sdk.openadsdk.core.live.r;

import com.bytedance.sdk.openadsdk.core.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    public final String f29487j;
    public final List<String> xt = new ArrayList();

    public static void j(String str, String str2) {
        j jVar = (j) x.j(str, j.class);
        if (jVar != null) {
            jVar.j(str2);
            return;
        }
        j jVar2 = new j(str);
        jVar2.j(str2);
        x.j(str, jVar2, j.class);
    }

    public j(String str) {
        this.f29487j = str;
    }

    public void j(String str) {
        this.xt.add(str);
    }
}
