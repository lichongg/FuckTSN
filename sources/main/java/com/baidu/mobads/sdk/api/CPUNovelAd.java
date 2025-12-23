package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.cy;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CPUNovelAd {
    private cy mCpuNovelProd;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j6);
    }

    public void destory() {
        cy cyVar = this.mCpuNovelProd;
        if (cyVar != null) {
            cyVar.y();
        }
    }

    public View getNovelView() {
        return this.mCpuNovelProd.w();
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        cy cyVar = new cy(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = cyVar;
        cyVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }
}
