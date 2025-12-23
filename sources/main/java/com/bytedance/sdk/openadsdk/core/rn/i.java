package com.bytedance.sdk.openadsdk.core.rn;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.openadsdk.core.v.j.j;

/* loaded from: D:\Downloads\app\classes4.dex */
public class i {

    public interface j {
        void j();

        void j(com.bytedance.sdk.openadsdk.core.v.j.xt xtVar, com.bytedance.sdk.component.m.qv qvVar);
    }

    public static void j(com.bytedance.sdk.openadsdk.ws.xt xtVar, int i6, int i7, final j jVar, String str, int i8, com.bytedance.sdk.component.m.ws wsVar, boolean z5) {
        com.bytedance.sdk.component.utils.vl.r("splashLoadAd", " getImageBytes url ".concat(String.valueOf(xtVar)));
        com.bytedance.sdk.openadsdk.core.v.up.j().cw().j(xtVar, new j.xt() { // from class: com.bytedance.sdk.openadsdk.core.rn.i.1
            @Override // com.bytedance.sdk.openadsdk.core.v.j.j.xt
            public void j(com.bytedance.sdk.component.m.qv qvVar, com.bytedance.sdk.openadsdk.core.v.j.xt xtVar2) {
                j jVar2;
                if (xtVar2.r() && (jVar2 = j.this) != null) {
                    jVar2.j(xtVar2, qvVar);
                    return;
                }
                j jVar3 = j.this;
                if (jVar3 != null) {
                    jVar3.j();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.v.j.j.xt
            public void j(int i9, String str2, Throwable th) {
                j jVar2 = j.this;
                if (jVar2 != null) {
                    jVar2.j();
                }
            }
        }, i6, i7, str, i8, wsVar, z5);
    }

    public static Drawable j(byte[] bArr, int i6) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }
        return new ColorDrawable(0);
    }
}
