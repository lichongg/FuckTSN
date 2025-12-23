package com.bytedance.sdk.openadsdk.core.multipro.aidl.j;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.az;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends j {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, RemoteCallbackList<az>> f29533j = Collections.synchronizedMap(new HashMap());
    private static volatile up xt;

    private synchronized void cw(String str, String str2) {
        try {
            if (f29533j != null) {
                RemoteCallbackList<az> remove = "recycleRes".equals(str2) ? f29533j.remove(str) : f29533j.get(str);
                if (remove != null) {
                    int beginBroadcast = remove.beginBroadcast();
                    for (int i6 = 0; i6 < beginBroadcast; i6++) {
                        try {
                            az broadcastItem = remove.getBroadcastItem(i6);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.xt();
                                } else if ("onAdClose".equals(str2)) {
                                    broadcastItem.r();
                                } else if ("onVideoComplete".equals(str2)) {
                                    broadcastItem.up();
                                } else if ("onSkippedVideo".equals(str2)) {
                                    broadcastItem.m();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    broadcastItem.cw();
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.j();
                                }
                            }
                        } catch (Throwable th) {
                            vl.cw("MultiProcess", "fullScreen2 method " + str2 + " throws Exception :", th);
                        }
                    }
                    remove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remove.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            vl.cw("MultiProcess", "fullScreen1 method " + str2 + " throws Exception :", th2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public synchronized void j(String str, az azVar) throws RemoteException {
        RemoteCallbackList<az> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(azVar);
        f29533j.put(str, remoteCallbackList);
    }

    public static up xt() {
        if (xt == null) {
            synchronized (up.class) {
                try {
                    if (xt == null) {
                        xt = new up();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void j(String str, String str2) throws RemoteException {
        cw(str, str2);
    }
}
