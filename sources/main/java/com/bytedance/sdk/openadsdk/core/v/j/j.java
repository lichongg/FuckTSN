package com.bytedance.sdk.openadsdk.core.v.j;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.qv;
import com.bytedance.sdk.component.m.ws;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.v.j.j$j, reason: collision with other inner class name */
    public static class C0489j implements xt {
        @Override // com.bytedance.sdk.openadsdk.core.v.j.j.xt
        public void j(int i6, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.v.j.j.xt
        public void j(qv qvVar, com.bytedance.sdk.openadsdk.core.v.j.xt xtVar) {
        }

        C0489j() {
        }
    }

    public interface xt {
        void j(int i6, String str, Throwable th);

        void j(qv qvVar, com.bytedance.sdk.openadsdk.core.v.j.xt xtVar);
    }

    protected void j() {
    }

    public static C0489j xt() {
        return new C0489j();
    }

    public void j(com.bytedance.sdk.openadsdk.ws.xt xtVar, xt xtVar2, int i6, int i7, String str) {
        j(xtVar, xtVar2, i6, i7, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void j(com.bytedance.sdk.openadsdk.ws.xt xtVar, xt xtVar2, int i6, int i7, String str, int i8, ws wsVar, boolean z5) {
        j(xtVar, xtVar2, i6, i7, ImageView.ScaleType.CENTER_INSIDE, str, i8, wsVar, z5);
    }

    public void j(com.bytedance.sdk.openadsdk.ws.xt xtVar, final xt xtVar2, int i6, int i7, ImageView.ScaleType scaleType, String str) {
        com.bytedance.sdk.openadsdk.g.xt.j(xtVar.f31988j).xt(xtVar.xt).j(i6).xt(i7).cw(str).j(Bitmap.Config.RGB_565).j(scaleType).xt(!TextUtils.isEmpty(str)).j(new av() { // from class: com.bytedance.sdk.openadsdk.core.v.j.j.1
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv qvVar) {
                j.this.j(qvVar, xtVar2);
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i8, String str2, Throwable th) {
                j.this.j(i8, str2, th, xtVar2);
            }
        });
        j();
    }

    public void j(com.bytedance.sdk.openadsdk.ws.xt xtVar, final xt xtVar2, int i6, int i7, ImageView.ScaleType scaleType, String str, int i8, ws wsVar, boolean z5) {
        com.bytedance.sdk.openadsdk.g.xt.j(xtVar.f31988j).xt(xtVar.xt).j(i6).xt(i7).cw(str).j(Bitmap.Config.RGB_565).j(scaleType).j(wsVar).j(z5).xt(!TextUtils.isEmpty(str)).j(new av() { // from class: com.bytedance.sdk.openadsdk.core.v.j.j.2
            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(1)
            public void j(qv qvVar) {
                j.this.j(qvVar, xtVar2);
            }

            @Override // com.bytedance.sdk.component.m.av
            @ATSMethod(2)
            public void j(int i9, String str2, Throwable th) {
                j.this.j(i9, str2, th, xtVar2);
            }
        }, i8);
        j();
    }

    protected void j(qv qvVar, xt xtVar) {
        if (xtVar != null) {
            Object cw = qvVar.cw();
            int j6 = j(qvVar);
            if (cw instanceof byte[]) {
                xtVar.j(qvVar, new com.bytedance.sdk.openadsdk.core.v.j.xt((byte[]) cw, j6));
            } else if (cw instanceof Bitmap) {
                xtVar.j(qvVar, new com.bytedance.sdk.openadsdk.core.v.j.xt((Bitmap) cw, j6));
            } else {
                xtVar.j(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int j(qv qvVar) {
        Map<String, String> ae = qvVar.ae();
        if (ae == null) {
            return 0;
        }
        try {
            String str = ae.get("image_size");
            if (str == null || !(str instanceof String)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    protected void j(int i6, String str, Throwable th, xt xtVar) {
        if (xtVar != null) {
            xtVar.j(i6, str, th);
        }
    }
}
