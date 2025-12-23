package com.amap.api.col.p0003l;

import android.util.Base64;
import cn.jpush.android.local.JPushConstants;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class m8 {
    public static boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        try {
            p9 p9Var = new p9();
            p9Var.f6925b.put("Content-Type", "application/octet-stream");
            p9Var.f6925b.put("aps_c_src", Base64.encodeToString(p9.a().getBytes(), 2));
            p9Var.f6925b.put("aps_c_key", Base64.encodeToString(p9.b().getBytes(), 2));
            p9Var.f6927d = bArr;
            if (d8.f5914a) {
                p9Var.f6924a = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            } else {
                p9Var.f6924a = (d8.f5915b ? JPushConstants.HTTPS_PRE : JPushConstants.HTTP_PRE) + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            }
            r9 a6 = i9.c().a(p9Var);
            byte[] bArr2 = (a6 == null || a6.f7189a != 200) ? null : a6.f7191c;
            if (bArr2 != null) {
                return "true".equals(new String(bArr2, StandardCharsets.UTF_8));
            }
            return false;
        } catch (Exception e6) {
            o9.a(e6);
            return false;
        }
    }
}
