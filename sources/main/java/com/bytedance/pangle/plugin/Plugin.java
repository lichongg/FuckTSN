package com.bytedance.pangle.plugin;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ae;
import com.bytedance.pangle.util.jy;
import com.bytedance.pangle.util.vl;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: D:\Downloads\app\classes3.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_LOADING = 4;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    protected int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    protected volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsDexPlugin;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    protected int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    protected volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    final Object installLock = new Object();
    final Object initializeLock = new Object();

    public JSONObject getJsonConfig() {
        return null;
    }

    boolean install(File file, com.bytedance.pangle.ae.j.up upVar) {
        boolean z5 = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = upVar.f25383j;
            int i6 = upVar.xt;
            synchronized (this.installLock) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                    boolean checkValid = checkValid(file, str, i6);
                    if (checkValid) {
                        String str2 = com.bytedance.pangle.util.cw.j(file)[0];
                        z5 = cw.j(file, str, i6);
                        if (z5) {
                            jy.j().xt(this.mPkgName, str2);
                            jy.j().xt(this.mPkgName, i6, true);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i6 + " identity=" + str2);
                            ae.j(file);
                        }
                    }
                    synchronized (this) {
                        try {
                            if (!checkValid) {
                                ae.j(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i6);
                            } else if (this.mLifeCycle == 3) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i6);
                            } else if (z5) {
                                updateToInstalled(i6);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i6);
                            } else {
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i6);
                                ae.j(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i6);
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z5;
        } catch (Throwable th2) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th2);
            return z5;
        }
    }

    private boolean checkValid(File file, String str, int i6) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i6 < this.mMinVersionCode || i6 > this.mMaxVersionCode) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i6), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)));
            return false;
        }
        if (i6 < this.mVersionCode && isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i6), Integer.valueOf(this.mVersionCode)));
            return false;
        }
        if (file == null || !file.exists()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        if (i6 == this.mVersionCode && jy.j().oq(str).equals(com.bytedance.pangle.util.cw.j(file)[0])) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i6 + " true");
        return true;
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.up.cw.j(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    jy.j().xt(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        ae.j(this.mPackageDir);
    }

    private void setupInternalPlugin() {
        int j6;
        if (jy.j().m(this.mPkgName, this.mApiVersionCode)) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(g.f25394r)) {
                    if (str.startsWith(this.mPkgName + "_") && (j6 = vl.j(str.split("_")[1], -1)) != -1) {
                        this.mInternalPath = g.f25394r + "/" + str;
                        this.mInternalVersionCode = j6;
                        return;
                    }
                }
            } catch (IOException e6) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e6);
            }
        }
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.up.cw.j(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i6 = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i6 && jy.j().r(this.mPkgName, parseInt) && new File(com.bytedance.pangle.up.cw.xt(this.mPkgName, parseInt)).exists()) {
                    i6 = parseInt;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i6);
        return i6;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public String getNativeLibraryDir() {
        int i6 = this.mVersionCode;
        return i6 > 0 ? com.bytedance.pangle.up.cw.r(this.mPkgName, i6) : com.bytedance.pangle.up.cw.j(this.mPkgName);
    }

    void init() {
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            try {
                if (this.mInitialized) {
                    return;
                }
                if (com.bytedance.pangle.up.r.xt(Zeus.getAppApplication())) {
                    int i6 = 0;
                    boolean cw = jy.j().xt(this.mPkgName) ? jy.j().cw(this.mPkgName) : false;
                    deleteIfNeeded();
                    int installedMaxVer = getInstalledMaxVer();
                    if (checkVersionValid(installedMaxVer, this.mApiVersionCode, cw)) {
                        i6 = modifyResIfNeed(installedMaxVer);
                        updateToInstalled(i6);
                    }
                    deleteOtherExpiredVer(i6);
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                    jy.j().j(this.mPkgName);
                    jy.j().r(this.mPkgName);
                    jy.j().j(this.mPkgName, com.bytedance.pangle.util.xt.j(Zeus.getAppApplication()));
                    jy.j().j(this.mPkgName, this.mApiVersionCode);
                } else {
                    updateInstallStateFromMainProcess();
                }
                this.mInitialized = true;
                installInternalPlugin();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    public boolean isIsDexPlugin() {
        return this.mIsDexPlugin;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isLoading() {
        return this.mLifeCycle == 4;
    }

    public void setLifeCycle(int i6) {
        this.mLifeCycle = i6;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    protected void updateToInstalled(int i6) {
        this.mVersionCode = i6;
        this.mLifeCycle = 2;
    }

    public Plugin(JSONObject jSONObject) throws JSONException {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mIsDexPlugin = false;
        this.mPkgName = jSONObject.getString(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME);
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        if (jSONObject.has("isDexPlugin")) {
            this.mIsDexPlugin = jSONObject.getInt("isDexPlugin") == 1;
        }
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString(SocialOperation.GAME_SIGNATURE, "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString("appKey", "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (optJSONArray != null) {
            for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                this.mSharedHostSos.add((String) optJSONArray.get(i6));
            }
        }
        setupInternalPlugin();
    }

    private boolean checkVersionValid(int i6, int i7, boolean z5) {
        boolean z6;
        int up = jy.j().up(this.mPkgName);
        boolean z7 = false;
        if (up > i7) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(up), Integer.valueOf(i7))));
            return false;
        }
        if (i6 >= 0 && i6 >= this.mMinVersionCode && i6 <= this.mMaxVersionCode) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6 && i7 != -1) {
            int xt = jy.j().xt(this.mPkgName, i6);
            int cw = jy.j().cw(this.mPkgName, i6);
            if (i7 < xt || i7 > cw) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i7), Integer.valueOf(xt), Integer.valueOf(cw))));
                z6 = false;
            }
        }
        if (z6 && z5 && com.bytedance.pangle.up.xt.xt(new File(com.bytedance.pangle.up.cw.xt(this.mPkgName, i6)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i6))));
        } else {
            z7 = z6;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z7);
        return z7;
    }

    private void deleteOtherExpiredVer(int i6) {
        if (com.bytedance.pangle.up.r.xt(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.up.cw.j(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i6));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !"data".equals(file.getName())) {
                        ae.j(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            jy.j().xt(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.up.r.xt(Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (!TextUtils.isEmpty(this.mInternalPath)) {
                com.bytedance.pangle.up.up.j(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                        File file;
                        try {
                            if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                                file = new File(com.bytedance.pangle.up.cw.cw(), Plugin.this.mPkgName + ".7z.zip");
                            } else {
                                file = new File(com.bytedance.pangle.up.cw.cw(), Plugin.this.mPkgName + ".apk");
                            }
                            ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                            ae.j(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                            if (file.exists()) {
                                new xt(Plugin.this.mPkgName, file).run();
                                return;
                            }
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                        } catch (Throwable th) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. ", th);
                        }
                    }
                });
            }
        }
    }

    private int modifyResIfNeed(int i6) {
        String j6 = com.bytedance.pangle.util.xt.j(Zeus.getAppApplication());
        if (TextUtils.isEmpty(j6) || !TextUtils.equals(jy.j().m(this.mPkgName), j6)) {
            if (!this.mUnInstallPluginWhenHostChange && !GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
                ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i6);
                int j7 = new com.bytedance.pangle.res.j.cw().j(new File(com.bytedance.pangle.up.cw.xt(this.mPkgName, i6)), true, new StringBuilder());
                if (j7 != 100 && j7 != 200) {
                    return 0;
                }
            } else {
                ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i6);
                return 0;
            }
        }
        return i6;
    }

    protected void deleteIfNeeded() {
        if (com.bytedance.pangle.up.r.xt(Zeus.getAppApplication()) && jy.j().g(this.mPkgName)) {
            jy.j().tl(this.mPkgName);
            deleteInstalledPlugin();
            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
        }
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        if (this.mLifeCycle >= 2) {
            return true;
        }
        return false;
    }

    public boolean isVersionInstalled(int i6) {
        return jy.j().r(this.mPkgName, i6);
    }

    public void setApiCompatVersion(int i6, int i7, int i8) {
        jy.j().j(this.mPkgName, i6, i7, i8);
    }

    protected void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.cw j6;
        try {
            if (!com.bytedance.pangle.up.r.xt(Zeus.getAppApplication()) && this.mLifeCycle < 2 && (j6 = com.bytedance.pangle.servermanager.xt.j()) != null && j6.j(this.mPkgName)) {
                updateToInstalled(j6.xt(this.mPkgName));
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PPM, "updateInstallStateFromMainProcess error. process = " + com.bytedance.pangle.up.r.j(Zeus.getAppApplication()), th);
        }
    }
}
