package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.n;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CpuChannelResponse {
    private n mCpuChannelInfo;

    public int getChannelId() {
        n nVar = this.mCpuChannelInfo;
        if (nVar != null) {
            return nVar.a();
        }
        return -1;
    }

    public String getChannelName() {
        n nVar = this.mCpuChannelInfo;
        return nVar != null ? nVar.b() : "";
    }

    public CpuChannelResponse(n nVar) {
        this.mCpuChannelInfo = nVar;
    }
}
