package com.bytedance.pangle.plugin;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.m.ae;
import com.bytedance.pangle.oq;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.r.xt;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.jy;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.api.m;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {

    /* renamed from: j, reason: collision with root package name */
    private static final oq f25437j = oq.j();

    r() {
    }

    private boolean xt(String str, Plugin plugin, StringBuilder sb) {
        if (!g.cw() && !g.tl() && !g.mi()) {
            if ((jy.j().g(plugin.mPkgName, plugin.getVersion()) & 1) != 0) {
                boolean xt = com.bytedance.pangle.up.r.xt(Zeus.getAppApplication());
                boolean ae = jy.j().ae(plugin.mPkgName, plugin.getVersion());
                if (xt && ae) {
                    if (!jy.j().tl(plugin.mPkgName, plugin.getVersion())) {
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean j6 = com.bytedance.pangle.util.xt.xt.j(str, true, false, plugin.mPkgName, plugin.getVersion(), 2);
                        sb.append("removeEntry cost:");
                        sb.append(System.currentTimeMillis() - currentTimeMillis);
                        sb.append(";");
                        jy.j().r(plugin.mPkgName, plugin.getVersion(), true);
                        return j6;
                    }
                    sb.append("removeEntry skip 3;");
                    return false;
                }
                sb.append("removeEntry skip 4 ");
                sb.append(xt);
                sb.append(" ");
                sb.append(ae);
                sb.append(";");
                return false;
            }
            sb.append("removeEntry skip 2;");
            return false;
        }
        sb.append("removeEntry skip 1;");
        return false;
    }

    boolean j(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        if (!plugin.isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
            return false;
        }
        if (plugin.isLoading()) {
            return false;
        }
        if (plugin.isLoaded()) {
            return true;
        }
        synchronized (plugin) {
            try {
                if (plugin.isLoaded()) {
                    return true;
                }
                plugin.setLifeCycle(4);
                oq oqVar = f25437j;
                oqVar.j(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
                com.bytedance.pangle.log.j j6 = com.bytedance.pangle.log.j.j(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
                j(com.bytedance.pangle.r.xt.tl, xt.j.f25459h, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
                ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
                StringBuilder sb = new StringBuilder();
                boolean j7 = plugin.isIsDexPlugin() ? com.bytedance.pangle.cw.xt.j(plugin, sb) : j(str, plugin, sb);
                if ((plugin instanceof j) && plugin.isIsDexPlugin()) {
                    ((j) plugin).j();
                }
                j6.j("loadPluginInternal:".concat(String.valueOf(j7)));
                if (j7) {
                    plugin.setLifeCycle(3);
                    j(com.bytedance.pangle.r.xt.f25452g, xt.j.la, plugin.mPkgName, plugin.getVersion(), j6.j(), sb.toString());
                    ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                    oqVar.j(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
                } else {
                    plugin.setLifeCycle(2);
                    sb.append("plugin:");
                    sb.append(plugin.mPkgName);
                    sb.append(" versionCode:");
                    sb.append(plugin.getVersion());
                    sb.append("load failed;");
                    j(com.bytedance.pangle.r.xt.f25452g, xt.j.gq, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                    ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                    oqVar.j(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
                }
                ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
                if (!plugin.isLoaded()) {
                    return false;
                }
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean j(final java.lang.String r16, final com.bytedance.pangle.plugin.Plugin r17, final java.lang.StringBuilder r18) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.r.j(java.lang.String, com.bytedance.pangle.plugin.Plugin, java.lang.StringBuilder):boolean");
    }

    private void j(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (!TextUtils.isEmpty(activityInfo.processName) && activityInfo.processName.contains(":")) {
                    activityInfo.processName = activityInfo.processName.split(":")[1];
                } else {
                    activityInfo.processName = "main";
                }
                plugin.pluginActivities.put(activityInfo.name, activityInfo);
            }
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.processName) && serviceInfo.processName.contains(":")) {
                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                } else {
                    serviceInfo.processName = "main";
                }
                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
            }
        }
        ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
        if (activityInfoArr2 != null) {
            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                if (!TextUtils.isEmpty(activityInfo2.processName) && activityInfo2.processName.contains(":")) {
                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                } else {
                    activityInfo2.processName = "main";
                }
                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
            }
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                    providerInfo.processName = providerInfo.processName.split(":")[1];
                } else {
                    providerInfo.processName = "main";
                }
                plugin.pluginProvider.put(providerInfo.name, providerInfo);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, ProviderInfo> hashMap = plugin.pluginProvider;
        if (hashMap != null && hashMap.size() > 0) {
            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
        }
        sb.append("installProvider cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(";");
        long currentTimeMillis2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            ZeusApplication zeusApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication = zeusApplication;
            zeusApplication.attach(plugin, Zeus.getAppApplication());
        }
        sb.append("makeApplication cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis2);
        sb.append(";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo j(String str, final Plugin plugin, StringBuilder sb, String str2, File file) throws PackageManager.NameNotFoundException {
        long currentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, 143);
        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
        ApplicationInfo applicationInfo = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
        plugin.mHostApplicationInfoHookSomeField = applicationInfo;
        applicationInfo.nativeLibraryDir = file.getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.sourceDir = str2;
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
            packageArchiveInfo.applicationInfo.sourceDir = str2;
        }
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
            packageArchiveInfo.applicationInfo.publicSourceDir = str2;
        }
        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.pangle.plugin.r.3
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        });
        sb.append("makeResources cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(";");
        return packageArchiveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final Plugin plugin, String str, File file, File file2, StringBuilder sb) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        j(plugin, str, file, file2);
        sb.append("classLoader cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            com.bytedance.pangle.up.up.j(new Runnable() { // from class: com.bytedance.pangle.plugin.r.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        PluginClassLoader pluginClassLoader = plugin.mClassLoader;
                        pluginClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(pluginClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            String str2 = (String) FieldUtils.readStaticField(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                j(plugin, str2);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            sb.append("actStubV1 cost:");
            sb.append(System.currentTimeMillis() - currentTimeMillis2);
            sb.append(";");
            throw th;
        }
        sb.append("actStubV1 cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis2);
        sb.append(";");
    }

    private void j(Plugin plugin, String str, File file, File file2) throws Exception {
        if (j()) {
            PluginClassLoader pluginClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            plugin.mClassLoader = pluginClassLoader;
            j(pluginClassLoader, str);
        } else {
            if (g.cw()) {
                String j6 = ae.j(plugin.mPkgName, plugin.getVersion());
                String[] split = j6.split(":");
                long currentTimeMillis = System.currentTimeMillis();
                boolean j7 = com.bytedance.pangle.m.xt.j(file2.getAbsolutePath(), split);
                StringBuilder sb = new StringBuilder("useDirect:");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append(" ");
                sb.append(!j7);
                ZeusLogger.d(ZeusLogger.TAG_LOAD, sb.toString());
                plugin.mClassLoader = new PluginClassLoader(j7 ? j6 : "", file2, file.getAbsolutePath(), null);
                return;
            }
            plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
        }
    }

    private File j(String str, int i6, String str2) {
        File file = new File(com.bytedance.pangle.up.cw.cw(str, i6));
        if (g.ae()) {
            if (!com.bytedance.pangle.m.xt.j(file + File.separator + com.bytedance.pangle.m.xt.j(str2))) {
                file = null;
            }
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void j(Plugin plugin, String str) throws JSONException {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mapping");
        HashMap hashMap = new HashMap();
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject2.getString(next));
            }
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("forceMappings");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                int optInt = jSONObject2.optInt("minApi", 0);
                int optInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= optInt2 && apiVersionCode >= optInt && (optJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap.put(next2, optJSONObject.getString(next2));
                    }
                }
            }
        }
        for (String str2 : hashMap.keySet()) {
            String str3 = (String) hashMap.get(str2);
            String str4 = plugin.mPkgName;
            StringBuilder sb = new StringBuilder();
            sb.append((str3 == null || !str3.contains(".")) ? plugin.mPkgName + "." : "");
            sb.append((String) hashMap.get(str2));
            ComponentManager.registerActivity(str4, sb.toString(), str2);
        }
    }

    public static void j(String str, int i6, @NonNull String str2, int i7, long j6, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.xt.j(Integer.valueOf(i6)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.xt.j(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.xt.j(Integer.valueOf(i7)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.xt.xt(Long.valueOf(j6))));
            jSONObject2.putOpt(CrashHianalyticsData.MESSAGE, com.bytedance.pangle.log.xt.j(str3));
        } catch (JSONException e6) {
            m.j(e6);
        }
        com.bytedance.pangle.r.xt.j().j(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static boolean j() {
        return g.mi();
    }

    public static boolean j(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                m.j(th);
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return false;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
        return true;
    }
}
