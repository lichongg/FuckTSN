package com.bytedance.msdk.tl.r;

import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.g;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, Object> f25229j;

    public static void j(Map map) {
        f25229j = map;
    }

    public static class j implements g {
        private ws xt(g.j jVar) {
            try {
                Field field = jVar.getClass().getDeclaredFields()[0];
                field.setAccessible(true);
                Object obj = field.get(jVar);
                Field declaredField = obj.getClass().getDeclaredField("request");
                declaredField.setAccessible(true);
                s sVar = (s) declaredField.get(obj);
                declaredField.set(obj, sVar.m().j(String.valueOf(jVar.j().xt().ae().xt("b4oil169.fn.bytedance.net").j(b.f50154a).xt())).xt("case-id", (String) cw.f25229j.get("case_id")).j());
                return jVar.j();
            } catch (Throwable th) {
                vl.j(th);
                return jVar.j();
            }
        }

        @Override // com.bytedance.sdk.component.xt.j.g
        public av j(g.j jVar) throws IOException {
            ws j6 = jVar.j();
            String aeVar = j6.xt().toString();
            if (aeVar.contains("/api/ad/union/mediation/config") || aeVar.contains("/api/ad/union/mediation/exchange")) {
                j6 = xt(jVar);
            }
            return jVar.j(j6);
        }
    }

    public static boolean j() {
        return com.bytedance.msdk.core.j.qv().ch();
    }
}
