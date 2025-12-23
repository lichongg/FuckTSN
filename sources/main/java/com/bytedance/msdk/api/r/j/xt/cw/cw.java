package com.bytedance.msdk.api.r.j.xt.cw;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.i.r;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class cw {
    private final int cw;

    /* renamed from: j, reason: collision with root package name */
    private final String f24367j;

    /* renamed from: r, reason: collision with root package name */
    private final int f24368r;
    private final String up;
    private final String xt;

    public int xt() {
        return this.cw;
    }

    public cw(String str, String str2, int i6, int i7, String str3) {
        this.f24367j = str;
        this.xt = str2;
        this.cw = i6;
        this.f24368r = i7;
        this.up = str3;
    }

    public SparseArray<Object> j() {
        r j6 = r.j();
        j6.j(8003, this.f24367j);
        j6.j(2, this.xt);
        j6.j(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes, Integer.valueOf(this.cw));
        j6.j(8094, Integer.valueOf(this.f24368r));
        j6.j(8547, this.up);
        if (com.bytedance.msdk.core.j.qv().z() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("live_ad_custom_config", com.bytedance.msdk.core.j.qv().z());
            j6.j(8075, hashMap);
        }
        return j6.xt();
    }
}
