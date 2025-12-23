package com.bytedance.pangle.servermanager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.cw;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import com.bytedance.pangle.up;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: m, reason: collision with root package name */
    private static cw f25493m;

    /* renamed from: j, reason: collision with root package name */
    private static final Object f25492j = new Object();
    private static final Object xt = new Object();
    private static final Object cw = new Object();

    /* renamed from: r, reason: collision with root package name */
    private static final Map<String, Boolean> f25494r = new ConcurrentHashMap();
    private static final Map<String, up> up = new ConcurrentHashMap();

    public static up j(String str) {
        Boolean bool = f25494r.get(str);
        if (bool == null || !bool.booleanValue()) {
            up.remove(str);
        }
        Map<String, up> map = up;
        if (map.get(str) == null) {
            synchronized (xt) {
                try {
                    up upVar = (up) j("service", str);
                    if (upVar == null) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                        return null;
                    }
                    map.put(str, upVar);
                } finally {
                }
            }
        }
        return map.get(str);
    }

    public static cw j() {
        Boolean bool = f25494r.get("main");
        if (bool == null || !bool.booleanValue()) {
            f25493m = null;
        }
        if (f25493m == null) {
            synchronized (cw) {
                try {
                    cw cwVar = (cw) j(WiseOpenHianalyticsData.UNION_PACKAGE, "main");
                    if (cwVar == null) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                        return null;
                    }
                    f25493m = cwVar;
                } finally {
                }
            }
        }
        return f25493m;
    }

    private static IBinder j(Uri uri, String str) {
        Bundle call = Zeus.getAppApplication().getContentResolver().call(uri, "query_binder", str, (Bundle) null);
        if (call != null) {
            call.setClassLoader(AbsServerManager.class.getClassLoader());
            j jVar = (j) call.getParcelable("binder");
            if (jVar != null) {
                return jVar.j();
            }
        }
        return null;
    }

    private static IInterface j(String str, final String str2) {
        if (Zeus.hasInit()) {
            ProviderInfo providerInfo = Zeus.getServerManagerHashMap().get(str2);
            if (providerInfo != null) {
                final IBinder j6 = j(Uri.parse("content://" + providerInfo.authority), str);
                if (j6 == null || !j6.isBinderAlive()) {
                    return null;
                }
                try {
                    j6.linkToDeath(new IBinder.DeathRecipient() { // from class: com.bytedance.pangle.servermanager.xt.1
                        @Override // android.os.IBinder.DeathRecipient
                        public void binderDied() {
                            xt.f25494r.put(str2, Boolean.FALSE);
                            ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                            HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = ServiceManagerNative.getInstance().process2ConnAndService.get(j6);
                            if (hashMap != null) {
                                for (ServiceConnection serviceConnection : hashMap.keySet()) {
                                    Iterator<ComponentName> it = hashMap.get(serviceConnection).iterator();
                                    while (it.hasNext()) {
                                        serviceConnection.onServiceDisconnected(it.next());
                                    }
                                }
                            }
                        }
                    }, 0);
                    f25494r.put(str2, Boolean.TRUE);
                    int hashCode = str.hashCode();
                    if (hashCode == -807062458) {
                        if (str.equals(WiseOpenHianalyticsData.UNION_PACKAGE)) {
                            return cw.j.j(j6);
                        }
                        return null;
                    }
                    if (hashCode == 1984153269 && str.equals("service")) {
                        return up.j.j(j6);
                    }
                    return null;
                } catch (RemoteException e6) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e6);
                    return null;
                }
            }
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
    }
}
