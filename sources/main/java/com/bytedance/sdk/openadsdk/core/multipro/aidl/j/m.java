package com.bytedance.sdk.openadsdk.core.multipro.aidl.j;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m extends j {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, RemoteCallbackList<i>> f29531j = Collections.synchronizedMap(new HashMap());
    private static volatile m xt;

    private synchronized Bundle cw(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<i>> map = f29531j;
            if (map != null) {
                RemoteCallbackList<i> remove = "recycleRes".equals(str2) ? map.remove(str) : map.get(str);
                if (remove != null) {
                    int beginBroadcast = remove.beginBroadcast();
                    for (int i6 = 0; i6 < beginBroadcast; i6++) {
                        try {
                            i broadcastItem = remove.getBroadcastItem(i6);
                            if (broadcastItem != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = broadcastItem.j(bundle.getInt("callback_extra_key_next_play_again_count"));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remove.kill();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return bundle2;
    }

    public static m xt() {
        if (xt == null) {
            synchronized (m.class) {
                try {
                    if (xt == null) {
                        xt = new m();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void j(String str, i iVar) throws RemoteException {
        RemoteCallbackList<i> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iVar);
        f29531j.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public Bundle xt(String str, String str2, Bundle bundle) throws RemoteException {
        return cw(str, str2, bundle);
    }
}
