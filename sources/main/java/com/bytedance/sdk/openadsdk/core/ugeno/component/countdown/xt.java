package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bytedance.adsdk.ugeno.j;
import com.bytedance.adsdk.ugeno.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends com.bytedance.adsdk.ugeno.xt.cw<CycleCountDownView> {

    /* renamed from: j, reason: collision with root package name */
    private String f30571j;
    private String ll;
    private String oy;
    private String yl;

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public CycleCountDownView j() {
        return new CycleCountDownView(this.xt);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
    }

    public xt(@NonNull Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void j(String str, String str2) {
        super.j(str, str2);
        str.getClass();
        switch (str) {
            case "boxImage":
                ((CycleCountDownView) this.up).setBoxImage(null);
                r.j().xt().j(this.f23861g, str2, new j.InterfaceC0320j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xt.1
                    @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
                    public void j(Bitmap bitmap) {
                        ((CycleCountDownView) ((com.bytedance.adsdk.ugeno.xt.cw) xt.this).up).setBoxImage(bitmap);
                    }
                });
                break;
            case "before":
                this.f30571j = str2;
                break;
            case "finish":
                this.yl = str2;
                break;
            case "text":
                this.oy = str2;
                break;
            case "after":
                this.ll = str2;
                break;
            case "boxFinishImage":
                r.j().xt().j(this.f23861g, str2, new j.InterfaceC0320j() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xt.2
                    @Override // com.bytedance.adsdk.ugeno.j.InterfaceC0320j
                    public void j(Bitmap bitmap) {
                        ((CycleCountDownView) ((com.bytedance.adsdk.ugeno.xt.cw) xt.this).up).setBoxFinish(bitmap);
                    }
                });
                break;
        }
        ((CycleCountDownView) this.up).j(this.f30571j, this.ll, this.oy, this.yl);
    }

    public void j(int i6, int i7, int i8, boolean z5) {
        T t5 = this.up;
        if (t5 != 0) {
            ((CycleCountDownView) t5).j(i6, i7, i8);
            ((CycleCountDownView) this.up).setCanSkip(z5);
            ((CycleCountDownView) this.up).setClickable(z5);
            ((CycleCountDownView) this.up).setEnabled(z5);
        }
    }
}
