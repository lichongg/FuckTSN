package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends r {
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.r
    protected com.bykv.vk.openvk.component.video.api.renderview.xt v() {
        m mVar = this.up;
        if (mVar != null) {
            return mVar.i();
        }
        return null;
    }

    public cw(Context context, ViewGroup viewGroup, n nVar, String str, boolean z5, boolean z6, boolean z7) {
        super(context, viewGroup, nVar, str, z5, z6, z7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.r
    public void j(int i6, int i7) {
        super.j(i6, i7);
        m mVar = this.up;
        if (mVar != null && i6 > 0 && i7 > 0) {
            mVar.cw(i6, i7);
            this.up.j(i6, i7);
            xt(-1, -1);
        }
    }
}
