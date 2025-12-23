package com.bytedance.sdk.openadsdk.core.multipro.aidl.j;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.mi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j {

    /* renamed from: j, reason: collision with root package name */
    private static Map<String, RemoteCallbackList<mi>> f29534j = Collections.synchronizedMap(new HashMap());
    private static volatile xt xt;

    public static xt xt() {
        if (xt == null) {
            synchronized (xt.class) {
                try {
                    if (xt == null) {
                        xt = new xt();
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void j(String str, mi miVar) throws RemoteException {
        RemoteCallbackList<mi> remoteCallbackList = f29534j.get(str);
        if (remoteCallbackList == null) {
            remoteCallbackList = new RemoteCallbackList<>();
        }
        remoteCallbackList.register(miVar);
        f29534j.put(str, remoteCallbackList);
        vl.r("DMLibManager", "aidl registerTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        vl.r("DMLibManager", "aidl registerTTAppDownloadListener, mListenerMap size:" + f29534j.size());
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void j(String str, String str2, long j6, long j7, String str3, String str4) throws RemoteException {
        xt(str, str2, j6, j7, str3, str4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.j.j, com.bytedance.sdk.openadsdk.core.av
    public void xt(String str, mi miVar) throws RemoteException {
        Map<String, RemoteCallbackList<mi>> map = f29534j;
        if (map == null) {
            vl.r("DMLibManager", "aidl unregisterTTAppDownloadListener mListenerMap = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        RemoteCallbackList<mi> remove = map.remove(str);
        if (remove == null) {
            vl.r("DMLibManager", "aidl unregisterTTAppDownloadListener cbs = null, materialMd5:".concat(String.valueOf(str)));
            return;
        }
        j(remove);
        vl.r("DMLibManager", "aidl unregisterTTAppDownloadListener, materialMd5:".concat(String.valueOf(str)));
        vl.r("DMLibManager", "aidl unregisterTTAppDownloadListener, mListenerMap size:" + f29534j.size());
    }

    private void j(RemoteCallbackList<mi> remoteCallbackList) {
        if (remoteCallbackList != null) {
            try {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i6 = 0; i6 < beginBroadcast; i6++) {
                    try {
                        mi broadcastItem = remoteCallbackList.getBroadcastItem(i6);
                        if (broadcastItem != null) {
                            ((com.bytedance.sdk.openadsdk.core.multipro.aidl.xt.m) broadcastItem).cw();
                        }
                    } catch (Throwable th) {
                        vl.cw("MultiProcess", "recycleRes1 throw Exception : ", th);
                    }
                }
                remoteCallbackList.finishBroadcast();
                remoteCallbackList.kill();
            } catch (Throwable th2) {
                vl.cw("MultiProcess", "recycleRes2 throw Exception : ", th2);
            }
        }
    }

    private synchronized void xt(String str, String str2, long j6, long j7, String str3, String str4) {
        mi broadcastItem;
        try {
            if (f29534j == null) {
                return;
            }
            if ("recycleRes".equals(str2)) {
                j(f29534j.remove(str));
                vl.r("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, materialMd5:".concat(String.valueOf(str)));
                vl.r("DMLibManager", "aidl executeMultiProcessAppDownloadCallBack recycle res, mListenerMap sizee:" + f29534j.size());
                return;
            }
            RemoteCallbackList<mi> remoteCallbackList = f29534j.get(str);
            if (remoteCallbackList != null) {
                int beginBroadcast = remoteCallbackList.beginBroadcast();
                for (int i6 = 0; i6 < beginBroadcast; i6++) {
                    try {
                        broadcastItem = remoteCallbackList.getBroadcastItem(i6);
                    } catch (Throwable th) {
                        th = th;
                    }
                    if (broadcastItem != null) {
                        if ("onIdle".equals(str2)) {
                            broadcastItem.j();
                        } else if ("onDownloadActive".equals(str2)) {
                            broadcastItem.j(j6, j7, str3, str4);
                        } else if ("onDownloadPaused".equals(str2)) {
                            broadcastItem.xt(j6, j7, str3, str4);
                        } else {
                            if ("onDownloadFailed".equals(str2)) {
                                try {
                                    broadcastItem.cw(j6, j7, str3, str4);
                                } catch (Throwable th2) {
                                    th = th2;
                                    vl.cw("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess1: " + str2 + " throws Exception :", th);
                                }
                            } else if ("onDownloadFinished".equals(str2)) {
                                broadcastItem.j(j6, str3, str4);
                            } else if ("onInstalled".equals(str2)) {
                                broadcastItem.j(str3, str4);
                            }
                        }
                    }
                }
                remoteCallbackList.finishBroadcast();
            }
        } catch (Throwable th3) {
            vl.cw("MultiProcess", "AppDownloadListenerManagerImpl MultiProcess2: " + str2 + " throws Exception :", th3);
        }
    }
}
