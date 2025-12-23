package com.bykv.vk.component.ttvideo.mediakit.net;

import android.os.Handler;
import com.bytedance.sdk.component.utils.vl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class DefaultConstructor implements CreateConstructor {
    @Override // com.bykv.vk.component.ttvideo.mediakit.net.CreateConstructor
    public BaseDNS createDns(String str, AVMDLNetClient aVMDLNetClient, int i6, Handler handler) {
        try {
            return new HTTPDNS(str, aVMDLNetClient, i6, handler);
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }
}
