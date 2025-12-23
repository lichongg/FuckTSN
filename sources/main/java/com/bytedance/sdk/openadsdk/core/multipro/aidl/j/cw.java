package com.bytedance.sdk.openadsdk.core.multipro.aidl.j;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.jy;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends j {

    /* renamed from: j, reason: collision with root package name */
    public static HashMap<String, RemoteCallbackList<jy>> f29530j = new HashMap<>();
    private static volatile cw xt;

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void j(String str, jy jyVar) throws RemoteException {
        if (jyVar == null) {
            return;
        }
        RemoteCallbackList<jy> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(jyVar);
        f29530j.put(str, remoteCallbackList);
    }

    public static cw xt() {
        if (xt == null) {
            synchronized (cw.class) {
                try {
                    if (xt == null) {
                        xt = new cw();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void j(String str, int i6) throws RemoteException {
        RemoteCallbackList<jy> remove = f29530j.remove(str);
        if (remove == null) {
            return;
        }
        int beginBroadcast = remove.beginBroadcast();
        for (int i7 = 0; i7 < beginBroadcast; i7++) {
            jy broadcastItem = remove.getBroadcastItem(i7);
            if (broadcastItem != null) {
                if (i6 == 1) {
                    broadcastItem.j();
                } else if (i6 == 2) {
                    broadcastItem.xt();
                } else if (i6 != 3) {
                    broadcastItem.cw();
                } else {
                    broadcastItem.cw();
                }
            }
        }
        remove.finishBroadcast();
        remove.kill();
    }
}
