package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    static final Object wait = new Object();

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static Application getAppApplication() {
        if (sApplication == null) {
            xt.j();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.up.j.j(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static Plugin getPlugin(String str, boolean z5) {
        return PluginManager.getInstance().getPlugin(str, z5);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        Resources resources;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (plugin = getPlugin(str)) != null && (resources = plugin.mResources) != null) {
            new com.bytedance.pangle.res.j().j(resources.getAssets(), str2, false);
        }
    }

    public static void addPackageDexManager(String str, JSONObject jSONObject) {
        Map<String, JSONObject> up = oq.j().up();
        if (!TextUtils.isEmpty(str) && jSONObject != null && jSONObject.length() > 0) {
            up.put(str, jSONObject);
        }
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        oq.j().j(zeusPluginEventCallback);
    }

    public static String getHostAbi() {
        return com.bytedance.pangle.up.xt.j();
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.up.xt.xt();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static int getMaxInstallVer(String str) {
        if (com.bytedance.pangle.up.r.xt(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static boolean hasInit() {
        return oq.j().xt();
    }

    public static void hookHuaWeiVerifier(Application application) {
        com.bytedance.pangle.receiver.j.j(application);
    }

    public static void init(Application application) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "start init");
        oq.j().j(application);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.bytedance.pangle.service.j.j.xt().cw();
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.up.r.xt(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str, boolean z5) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str, false);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static void registerPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            cw j6 = com.bytedance.pangle.servermanager.xt.j();
            if (j6 != null) {
                j6.j(zeusPluginInstallListener.hashCode(), new com.bytedance.pangle.ae.xt(zeusPluginInstallListener));
            }
        } catch (RemoteException e6) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e6);
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        oq.j().j(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        oq.j().xt(zeusPluginEventCallback);
    }

    public static void setAllowDownloadPlugin(String str, int i6, boolean z5) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i6, z5);
    }

    public static void setDecodeCallback(ZeusPluginDecodeCallback zeusPluginDecodeCallback) {
        oq.j().j(zeusPluginDecodeCallback);
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, "start");
        cw j6 = com.bytedance.pangle.servermanager.xt.j();
        if (j6 != null) {
            try {
                return j6.j(str, str2);
            } catch (RemoteException e6) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e6);
                return false;
            }
        }
        return false;
    }

    public static void triggerBgDexOpt() {
        com.bytedance.pangle.m.m.j();
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        oq.j().xt(zeusPluginStateListener);
    }

    public static boolean waitInit(int i6) {
        if (oq.j().xt()) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            try {
                if (!oq.j().xt()) {
                    try {
                        if (i6 == -1) {
                            obj.wait();
                        } else {
                            obj.wait(i6);
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return oq.j().xt();
    }

    public void unregisterPluginInstallListener(ZeusPluginInstallListener zeusPluginInstallListener) {
        try {
            cw j6 = com.bytedance.pangle.servermanager.xt.j();
            if (j6 != null) {
                j6.j(zeusPluginInstallListener.hashCode());
            }
        } catch (RemoteException e6) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "unregisterPluginInstallListener error.", e6);
        }
    }
}
