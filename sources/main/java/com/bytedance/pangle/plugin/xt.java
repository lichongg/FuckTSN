package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.r.xt;
import com.bytedance.pangle.util.ae;
import com.bytedance.sdk.openadsdk.api.m;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class xt implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    private File f25447j;
    private final String xt;

    private File j(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] listFiles = new File(file.getParent()).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return null;
        }
        for (File file2 : listFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    private void xt() {
        int i6 = 3;
        while (i6 > 0) {
            i6--;
            try {
                File file = new File(this.f25447j.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                ae.xt(this.f25447j.getAbsolutePath(), file.getAbsolutePath());
                File[] listFiles = file.listFiles();
                File file2 = this.f25447j;
                if (listFiles != null && listFiles.length > 0) {
                    file2 = listFiles[0];
                }
                File j6 = j(file2);
                if (j6 != null && j6.exists() && j6.isFile()) {
                    this.f25447j = j6;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i6));
                    return;
                }
            } catch (Exception e6) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e6);
                m.j(e6);
            }
        }
    }

    private com.bytedance.pangle.ae.j.up cw() {
        com.bytedance.pangle.cw.j j6;
        if (this.f25447j == null) {
            return null;
        }
        try {
            File file = new File(this.f25447j.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                ae.j(file);
                file.mkdirs();
            }
            ae.xt(this.f25447j.getAbsolutePath(), file.getAbsolutePath());
            File[] listFiles = file.listFiles();
            LinkedList linkedList = new LinkedList();
            File file2 = null;
            for (File file3 : listFiles) {
                if (file3.getName().equals("config.json")) {
                    file2 = file3;
                } else if (file3.getName().endsWith(".dex")) {
                    linkedList.add(file3);
                }
            }
            ae.j(this.f25447j);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.f25447j);
            this.f25447j = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (j6 = com.bytedance.pangle.cw.xt.j(file2, linkedList)) != null) {
                return new com.bytedance.pangle.ae.j.up(j6);
            }
        } catch (Exception e6) {
            m.j(e6);
        }
        return null;
    }

    xt(String str, File file) {
        this.f25447j = file;
        this.xt = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        j();
    }

    private static void j(String str, int i6, @NonNull String str2, int i7, long j6, String str3) {
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

    boolean j() {
        com.bytedance.pangle.ae.j.up j6;
        File file = this.f25447j;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            j6 = cw();
            if (j6 != null) {
                j(com.bytedance.pangle.r.xt.ae, xt.j.mi, this.xt, 0, SystemClock.elapsedRealtime() - elapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (ae.xt(this.f25447j)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                xt();
                j(com.bytedance.pangle.r.xt.ae, xt.j.rn, this.xt, 0, SystemClock.elapsedRealtime() - elapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            j6 = com.bytedance.pangle.ae.j.r.j(this.f25447j);
        }
        if (j6 == null) {
            ZeusPluginStateListener.postStateChange(this.xt, 7, " read local file package info failed !!! pluginPkg = " + this.xt + " mApkFile.exists = " + this.f25447j.exists());
            StringBuilder sb = new StringBuilder("PluginInstallRunnable read local file package info failed !!! pluginPkg = ");
            sb.append(this.xt);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb.toString());
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(j6.f25383j);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.xt, 7, " plugin == null !!! pluginPkg = " + this.xt);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + j6.f25383j);
            return false;
        }
        boolean install = plugin.install(this.f25447j, j6);
        if (install) {
            ZeusPluginStateListener.postStateChange(j6.f25383j, 6, new Object[0]);
            return install;
        }
        ZeusPluginStateListener.postStateChange(j6.f25383j, 7, "Internal error.");
        return install;
    }
}
