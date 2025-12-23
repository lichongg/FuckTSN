package com.bytedance.pangle.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.oq;
import com.bytedance.pangle.util.jy;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private volatile boolean mIsParsePluginConfig;
    private volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    private final r pluginLoader = new r();

    private synchronized void parsePluginConfig() {
        try {
            if (this.mIsParsePluginConfig) {
                return;
            }
            ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
            ArrayList<String> arrayList = new ArrayList();
            try {
                Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
                try {
                    for (String str : bundle.keySet()) {
                        String str2 = g.up;
                        if (str2.startsWith("PANGLE_")) {
                            if (!str.startsWith(str2) && !str.startsWith("ZEUS_PLUGIN_")) {
                            }
                            arrayList.add(bundle.getString(str));
                        } else if (str.startsWith(str2)) {
                            arrayList.add(bundle.getString(str));
                        }
                    }
                    try {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        for (String str3 : arrayList) {
                            try {
                                JSONObject jSONObject = new JSONObject(str3);
                                Plugin jVar = (jSONObject.has("isDexPlugin") && jSONObject.optInt("isDexPlugin") == 1) ? new j(jSONObject) : new Plugin(jSONObject);
                                concurrentHashMap.put(jVar.mPkgName, jVar);
                                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + jVar.mPkgName);
                            } catch (JSONException e6) {
                                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str3.trim(), e6);
                            }
                        }
                        Map<String, JSONObject> up = oq.j().up();
                        if (up != null && up.size() > 0) {
                            for (Map.Entry<String, JSONObject> entry : up.entrySet()) {
                                String key = entry.getKey();
                                JSONObject value = entry.getValue();
                                if (!TextUtils.isEmpty(key) && value != null) {
                                    Plugin jVar2 = (value.has("isDexPlugin") && value.optInt("isDexPlugin") == 1) ? new j(value) : new Plugin(value);
                                    concurrentHashMap.put(jVar2.mPkgName, jVar2);
                                    ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager getPluginsJson. find " + jVar2.mPkgName);
                                }
                            }
                        }
                        this.mPlugins = concurrentHashMap;
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
                    } catch (Exception e7) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e7);
                    }
                    this.mIsParsePluginConfig = true;
                } catch (Exception e8) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager iterator metaData failed.", e8);
                }
            } catch (Exception e9) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e9);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Plugin getPlugin(String str, boolean z5) {
        if (!Zeus.hasInit() && com.bytedance.pangle.util.xt.j()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z5 && plugin != null) {
            plugin.init();
        }
        return plugin;
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.bytedance.pangle.up.r.xt(Zeus.getAppApplication())) {
            com.bytedance.pangle.up.up.xt(new up());
        }
        this.hasInstallFromDownloadDir = true;
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new File(com.bytedance.pangle.up.cw.xt(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new PluginManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            com.bytedance.pangle.up.up.xt(new xt(str, file));
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
        } else {
            ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public void setAllowDownloadPlugin(String str, int i6, boolean z5) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i6 + " " + z5);
        if (getPlugin(str) != null) {
            jy.j().j(str, i6, !z5);
        }
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new xt(str, file).j();
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            jy.j().ae(str);
        }
    }

    private PluginManager() {
    }

    public boolean checkPluginInstalled(String str) {
        boolean z5;
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        if (plugin != null && plugin.isInstalled()) {
            z5 = true;
        } else {
            z5 = false;
        }
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z5);
        return z5;
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        if (plugin != null && plugin.isLoaded()) {
            return true;
        }
        return false;
    }

    public boolean loadPlugin(String str) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "start load plugin:".concat(String.valueOf(str)));
        return this.pluginLoader.j(str);
    }

    public void tryOfflineInternalPlugin(String str, int i6) {
        Plugin plugin = getPlugin(str);
        if (plugin != null && plugin.getInternalVersionCode() == i6) {
            ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i6 + " apiVer:" + plugin.getApiVersionCode());
            jy.j().up(str, plugin.getApiVersionCode());
        }
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }
}
