package com.bytedance.sdk.component.m;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.util.concurrent.ExecutorService;

@ATSApi
/* loaded from: D:\Downloads\app\classes4.dex */
public interface oq {
    @ATSMethod(12)
    oq cw(int i6);

    @ATSMethod(7)
    oq cw(String str);

    @ATSMethod(20)
    oq cw(boolean z5);

    @ATSMethod(3)
    g j(ImageView imageView);

    @ATSMethod(2)
    g j(av avVar);

    @ATSMethod(1)
    g j(av avVar, int i6);

    @ATSMethod(10)
    oq j(int i6);

    @ATSMethod(9)
    oq j(Bitmap.Config config);

    @ATSMethod(8)
    oq j(ImageView.ScaleType scaleType);

    @ATSMethod(13)
    oq j(kt ktVar);

    @ATSMethod(17)
    oq j(tl tlVar);

    @ATSMethod(21)
    oq j(ws wsVar);

    @ATSMethod(6)
    oq j(xt xtVar);

    @ATSMethod(4)
    oq j(String str);

    @ATSMethod(16)
    oq j(ExecutorService executorService);

    @ATSMethod(14)
    oq j(boolean z5);

    @ATSMethod(18)
    oq r(int i6);

    @ATSMethod(19)
    oq up(int i6);

    @ATSMethod(11)
    oq xt(int i6);

    @ATSMethod(5)
    oq xt(String str);

    @ATSMethod(15)
    oq xt(boolean z5);
}
