package com.bytedance.sdk.openadsdk.core.multipro.aidl.j;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.rh;
import com.bytedance.sdk.openadsdk.core.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends j {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, RemoteCallbackList<w>> f29529j = Collections.synchronizedMap(new HashMap());
    private static volatile ae xt;

    private synchronized void cw(String str, String str2, Bundle bundle) {
        RemoteCallbackList<w> remoteCallbackList;
        RemoteCallbackList<w> remoteCallbackList2;
        try {
            if (f29529j != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackList = f29529j.remove(str);
                    remoteCallbackList2 = f29529j.remove(rh.j(str));
                } else {
                    remoteCallbackList = f29529j.get(str);
                    remoteCallbackList2 = null;
                }
                if (remoteCallbackList != null) {
                    int beginBroadcast = remoteCallbackList.beginBroadcast();
                    for (int i6 = 0; i6 < beginBroadcast; i6++) {
                        try {
                            w broadcastItem = remoteCallbackList.getBroadcastItem(i6);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.xt();
                                } else if ("onAdClose".equals(str2)) {
                                    broadcastItem.r();
                                } else if ("onVideoComplete".equals(str2)) {
                                    broadcastItem.up();
                                } else if ("onVideoError".equals(str2)) {
                                    broadcastItem.m();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    broadcastItem.cw();
                                } else if ("onRewardVerify".equals(str2)) {
                                    j(broadcastItem, bundle);
                                } else if ("onRewardArrived".equals(str2)) {
                                    xt(broadcastItem, bundle);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    broadcastItem.ae();
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.j();
                                }
                            }
                        } catch (Throwable th) {
                            vl.cw("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackList.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList.kill();
                    }
                }
                if (remoteCallbackList2 != null) {
                    int beginBroadcast2 = remoteCallbackList2.beginBroadcast();
                    for (int i7 = 0; i7 < beginBroadcast2; i7++) {
                        try {
                            w broadcastItem2 = remoteCallbackList2.getBroadcastItem(i7);
                            if (broadcastItem2 != null && "recycleRes".equals(str2)) {
                                broadcastItem2.j();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackList2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackList2.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            vl.cw("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }

    public static ae xt() {
        if (xt == null) {
            synchronized (ae.class) {
                try {
                    if (xt == null) {
                        xt = new ae();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public synchronized void j(String str, w wVar) throws RemoteException {
        RemoteCallbackList<w> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(wVar);
        f29529j.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void j(String str, String str2, Bundle bundle) throws RemoteException {
        cw(str, str2, bundle);
    }

    private void j(w wVar, Bundle bundle) throws RemoteException {
        boolean z5 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i6 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i7 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        wVar.j(z5, i6, string != null ? string : "", i7, string2 != null ? string2 : "");
    }

    private void xt(w wVar, Bundle bundle) throws RemoteException {
        boolean z5 = bundle.getBoolean("callback_extra_key_reward_valid");
        int i6 = bundle.getInt("callback_extra_key_reward_type");
        wVar.j(z5, i6, uf.j(i6, bundle));
    }
}
