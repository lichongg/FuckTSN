package com.bykv.vk.component.ttvideo.mediakit.net;

import com.bytedance.sdk.component.utils.vl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLDNSManager {
    public static Map<Integer, CreateConstructor> dnsMap;
    private static AVMDLDNSManager mInstance;

    public synchronized CreateConstructor getCreateConstructor(int i6) throws Exception {
        if (!dnsMap.containsKey(Integer.valueOf(i6))) {
            return null;
        }
        return dnsMap.get(Integer.valueOf(i6));
    }

    public synchronized void registerDnsConstructor(int i6, CreateConstructor createConstructor) {
        try {
            dnsMap.put(Integer.valueOf(i6), createConstructor);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    public static AVMDLDNSManager getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDNSManager.class) {
                if (mInstance == null) {
                    try {
                        mInstance = new AVMDLDNSManager();
                    } catch (Exception e6) {
                        vl.j(e6);
                        mInstance = null;
                    }
                }
            }
        }
        return mInstance;
    }

    private void initDnsMap() throws Exception {
        DefaultConstructor defaultConstructor = new DefaultConstructor();
        dnsMap.put(1, defaultConstructor);
        dnsMap.put(2, defaultConstructor);
        dnsMap.put(3, defaultConstructor);
    }

    private AVMDLDNSManager() throws Exception {
        dnsMap = new HashMap();
        initDnsMap();
    }
}
