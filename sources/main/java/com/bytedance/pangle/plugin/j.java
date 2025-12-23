package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ae;
import com.bytedance.pangle.util.jy;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends Plugin {

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.pangle.cw.j f25436j;

    @Override // com.bytedance.pangle.plugin.Plugin
    boolean install(File file, com.bytedance.pangle.ae.j.up upVar) {
        boolean z5 = false;
        if (upVar != null) {
            try {
                com.bytedance.pangle.cw.j jVar = upVar.cw;
                if (jVar != null) {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + jVar);
                    String xt = jVar.xt();
                    int cw = jVar.cw();
                    synchronized (this.installLock) {
                        try {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + xt + " plugin=" + this);
                            boolean j6 = jVar.j();
                            if (j6 && (z5 = com.bytedance.pangle.cw.xt.j(jVar, SystemClock.elapsedRealtime()))) {
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + xt + " version=" + cw);
                            }
                            synchronized (this) {
                                try {
                                    if (!j6) {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + xt + ":" + cw);
                                    } else if (this.mLifeCycle == 3) {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + xt + ":" + this.mVersionCode);
                                    } else if (z5) {
                                        updateToInstalled(cw);
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + xt + ":" + cw);
                                    } else {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + xt + ":" + cw);
                                    }
                                    ae.j(file);
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + xt + " version=" + cw + " apkFile=" + file);
                                } finally {
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return z5;
                }
            } catch (Throwable th2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "DexPlugin DEX ZIP IMPOSSIBLE!!!", th2);
            }
        }
        return z5;
    }

    public void j(com.bytedance.pangle.cw.j jVar) {
        this.f25436j = jVar;
    }

    private void j(int i6) {
        if (com.bytedance.pangle.up.r.xt(Zeus.getAppApplication())) {
            xt();
            String qv = jy.j().qv(this.mPkgName);
            if (TextUtils.isEmpty(qv)) {
                com.bytedance.pangle.cw.xt.j(this.mPkgName, i6);
            } else {
                com.bytedance.pangle.cw.xt.j(qv, i6);
            }
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.bytedance.pangle.cw.j jVar = this.f25436j;
        if (jVar == null) {
            return null;
        }
        return jVar.m();
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    void init() {
        com.bytedance.pangle.cw.j jVar;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            try {
                if (this.mInitialized) {
                    return;
                }
                if (com.bytedance.pangle.up.r.xt(Zeus.getAppApplication())) {
                    deleteIfNeeded();
                    String qv = jy.j().qv(this.mPkgName);
                    if (TextUtils.isEmpty(qv)) {
                        qv = this.mPkgName;
                    }
                    int j6 = com.bytedance.pangle.cw.xt.j(qv);
                    if (j6 != -1) {
                        File[] qv2 = com.bytedance.pangle.up.cw.qv(qv, j6);
                        File file = new File(com.bytedance.pangle.up.cw.vl(qv, j6));
                        if (qv2 != null) {
                            try {
                            } catch (Exception e6) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins fail throw exception ".concat(String.valueOf(e6)));
                                m.j(e6);
                            }
                            if (qv2.length > 0) {
                                this.f25436j = com.bytedance.pangle.cw.xt.j(file, (List<File>) Arrays.asList(qv2));
                                if (qv2 == null && qv2.length > 0 && file.isFile() && (jVar = this.f25436j) != null && jVar.j()) {
                                    updateToInstalled(j6);
                                } else {
                                    j6 = 0;
                                }
                                j(j6);
                                ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                                jy.j().j(this.mPkgName);
                                jy.j().r(this.mPkgName);
                                jy.j().j(this.mPkgName, com.bytedance.pangle.util.xt.j(Zeus.getAppApplication()));
                                jy.j().j(this.mPkgName, this.mApiVersionCode);
                            }
                        }
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                        if (qv2 == null) {
                        }
                        j6 = 0;
                        j(j6);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        jy.j().j(this.mPkgName);
                        jy.j().r(this.mPkgName);
                        jy.j().j(this.mPkgName, com.bytedance.pangle.util.xt.j(Zeus.getAppApplication()));
                        jy.j().j(this.mPkgName, this.mApiVersionCode);
                    }
                    j();
                } else {
                    updateInstallStateFromMainProcess();
                }
                this.mInitialized = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public String toString() {
        return "DexPlugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }

    public j(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    private void cw() {
        String qv = jy.j().qv(this.mPkgName);
        if (!TextUtils.isEmpty(qv)) {
            String j6 = com.bytedance.pangle.up.cw.j(qv);
            ae.j(j6);
            jy.j().vl(this.mPkgName);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(j6)));
        }
    }

    private void xt() {
        List<String> jy = jy.j().jy(this.mPkgName);
        if (jy != null && jy.size() > 0) {
            for (String str : jy) {
                if (!TextUtils.isEmpty(str)) {
                    int j6 = com.bytedance.pangle.cw.xt.j(str);
                    if (j6 != -1) {
                        jy.j().xt(str, j6, false);
                    }
                    ae.j(com.bytedance.pangle.up.cw.j(str));
                }
            }
            jy.j().ws(this.mPkgName);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(jy)));
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    protected void deleteIfNeeded() {
        if (com.bytedance.pangle.up.r.xt(Zeus.getAppApplication()) && jy.j().g(this.mPkgName)) {
            jy.j().tl(this.mPkgName);
            String j6 = com.bytedance.pangle.up.cw.j(this.mPkgName);
            ae.j(j6);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + j6);
            xt();
            cw();
        }
    }

    public void j() {
        String j6 = com.bytedance.pangle.up.cw.j(this.mPkgName);
        if (TextUtils.isEmpty(j6)) {
            return;
        }
        File[] listFiles = new File(j6).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + j6);
            ae.j(j6);
        }
    }
}
