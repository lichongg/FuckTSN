package com.bytedance.sdk.openadsdk.core.multipro.aidl.j;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.ws;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends j {

    /* renamed from: j, reason: collision with root package name */
    private static HashMap<String, RemoteCallbackList<ws>> f29532j = new HashMap<>();
    private static volatile r xt;

    public static r xt() {
        if (xt == null) {
            synchronized (r.class) {
                try {
                    if (xt == null) {
                        xt = new r();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void j(String str, ws wsVar) throws RemoteException {
        if (wsVar == null) {
            return;
        }
        RemoteCallbackList<ws> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(wsVar);
        f29532j.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void xt(String str, String str2) throws RemoteException {
        RemoteCallbackList<ws> remove = f29532j.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i6 = 0; i6 < beginBroadcast; i6++) {
            ws broadcastItem = remove.getBroadcastItem(i6);
            if (broadcastItem != null) {
                if (str2 == null) {
                    broadcastItem.j();
                } else {
                    broadcastItem.j(str2);
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }
}
