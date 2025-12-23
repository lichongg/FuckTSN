package com.bytedance.pangle.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.servermanager.xt;
import com.bytedance.pangle.tl;
import com.bytedance.pangle.up;
import com.bytedance.sdk.openadsdk.api.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@Keep
/* loaded from: D:\Downloads\app\classes4.dex */
public class ServiceManagerNative {
    private static volatile ServiceManagerNative sInstance;
    private final HashMap<ServiceConnection, tl> serviceConn2ServiceConn = new HashMap<>();
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService = new HashMap<>();
    private HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service = new HashMap<>();

    public static ServiceManagerNative getInstance() {
        if (sInstance == null) {
            synchronized (ServiceManagerNative.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ServiceManagerNative();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public void unbindServiceNative(ServiceConnection serviceConnection) {
        HashSet<ServiceInfo> hashSet = this.conn2Service.get(serviceConnection);
        if (hashSet != null) {
            Iterator<ServiceInfo> it = hashSet.iterator();
            while (it.hasNext()) {
                try {
                    xt.j(it.next().processName).unbindService(this.serviceConn2ServiceConn.get(serviceConnection));
                } catch (RemoteException e6) {
                    m.j(e6);
                }
            }
        }
    }

    private ServiceManagerNative() {
    }

    public boolean bindServiceNative(Context context, Intent intent, final ServiceConnection serviceConnection, int i6, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.bindService(intent, serviceConnection, i6);
        }
        if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
            this.serviceConn2ServiceConn.put(serviceConnection, new tl.j() { // from class: com.bytedance.pangle.service.client.ServiceManagerNative.1
                @Override // com.bytedance.pangle.tl
                public void j(ComponentName componentName, IBinder iBinder) {
                    serviceConnection.onServiceConnected(componentName, iBinder);
                }

                @Override // com.bytedance.pangle.tl
                public int j() {
                    return serviceConnection.hashCode();
                }
            });
        }
        if (this.conn2Service.get(serviceConnection) == null) {
            this.conn2Service.put(serviceConnection, new HashSet<>());
        }
        this.conn2Service.get(serviceConnection).add(queryServiceFromPlugin);
        up j6 = xt.j(queryServiceFromPlugin.processName);
        IBinder asBinder = j6.asBinder();
        HashMap<ServiceConnection, HashSet<ComponentName>> hashMap = this.process2ConnAndService.get(asBinder);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.process2ConnAndService.put(asBinder, hashMap);
        }
        HashSet<ComponentName> hashSet = hashMap.get(serviceConnection);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            hashMap.put(serviceConnection, hashSet);
        }
        hashSet.add(intent.getComponent());
        try {
            return j6.bindService(intent, this.serviceConn2ServiceConn.get(serviceConnection), i6, str);
        } catch (RemoteException e6) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed!", e6);
            return false;
        }
    }

    public ServiceInfo queryServiceFromPlugin(Intent intent, String str) {
        Zeus.loadPlugin(str);
        ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        return PluginManager.getInstance().getPlugin(str).pluginServices.get(component.getClassName());
    }

    public ComponentName startServiceNative(Context context, Intent intent, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.startService(intent);
        }
        try {
            return xt.j(queryServiceFromPlugin.processName).startService(intent, str);
        } catch (RemoteException e6) {
            m.j(e6);
            return null;
        }
    }

    public boolean stopServiceNative(Context context, Intent intent, String str) {
        ServiceInfo queryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (queryServiceFromPlugin == null) {
            return context.stopService(intent);
        }
        try {
            return xt.j(queryServiceFromPlugin.processName).stopService(intent, str);
        } catch (RemoteException e6) {
            m.j(e6);
            return false;
        }
    }
}
