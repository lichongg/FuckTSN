package com.bytedance.sdk.component.m.j;

import com.bytedance.sdk.component.m.g;
import com.bytedance.sdk.component.m.vl;
import java.util.WeakHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    public static vl j() {
        return new vl() { // from class: com.bytedance.sdk.component.m.j.xt.1

            /* renamed from: j, reason: collision with root package name */
            private WeakHashMap<String, String> f26597j = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.m.vl
            public String j(g gVar) {
                return j(gVar.xt() + "#width=" + gVar.cw() + "#height=" + gVar.r() + "#scaletype=" + gVar.up() + "#bitmapConfig=" + gVar.tl());
            }

            @Override // com.bytedance.sdk.component.m.vl
            public String xt(g gVar) {
                return j(gVar.xt());
            }

            private String j(String str) {
                String str2 = this.f26597j.get(str);
                if (str2 != null) {
                    return str2;
                }
                String j6 = com.bytedance.sdk.component.m.cw.cw.cw.j(str);
                this.f26597j.put(str, j6);
                return j6;
            }
        };
    }
}
