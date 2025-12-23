package com.bytedance.sdk.component.cw.xt.j.cw;

import com.bytedance.sdk.component.cw.xt.mi;
import com.bytedance.sdk.component.cw.xt.s;
import java.net.Proxy;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class g {
    public static String j(s sVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(sVar.xt());
        sb.append(' ');
        if (xt(sVar, type)) {
            sb.append(sVar.j());
        } else {
            sb.append(j(sVar.j()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean xt(s sVar, Proxy.Type type) {
        if (!sVar.tl() && type == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }

    public static String j(mi miVar) {
        String g6 = miVar.g();
        try {
            String qv = miVar.qv();
            if (qv != null) {
                return g6 + '?' + qv;
            }
        } catch (OutOfMemoryError unused) {
        }
        return g6;
    }
}
