package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.j.j;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.m.ae;
import com.bytedance.pangle.m.m;
import com.bytedance.pangle.oq;
import com.bytedance.pangle.r.xt;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.jy;
import com.bytedance.pangle.util.tl;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static final oq f25429j = oq.j();

    public static class j extends IOException {
        private j(String str) {
            super(str);
        }

        private j(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> ae(File file, String str, int i6, StringBuffer stringBuffer) throws j {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.util.up<Boolean, Map<String, List<ZipEntry>>> j6 = com.bytedance.pangle.up.xt.j(file);
                boolean booleanValue = j6.f25547j.booleanValue();
                Map<String, List<ZipEntry>> map = j6.xt;
                if (booleanValue) {
                    return map;
                }
                throw new j(str2);
            } catch (Exception e6) {
                j(com.bytedance.pangle.r.xt.up, xt.j.f25456a, str, i6, -1L, null);
                f25429j.j(1100, -5, str, i6, e6);
                throw new j(str2, e6);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cw(String str, int i6) throws j {
        try {
            if (!g.ae() && !g.g()) {
                return;
            }
            jy.j().cw(str, i6, false);
            com.bytedance.pangle.m.xt.j(Zeus.getAppApplication()).edit().putInt(str, i6).apply();
            m.j();
        } catch (Exception e6) {
            j(com.bytedance.pangle.r.xt.up, xt.j.f25466s, str, i6, -1L, null);
            throw new j("dexOpt2失败", e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(File file, String str, int i6, StringBuffer stringBuffer) throws j {
        long currentTimeMillis = System.currentTimeMillis();
        String xt = com.bytedance.pangle.up.cw.xt(str, i6);
        try {
            try {
                tl.j(file.getAbsolutePath(), xt);
                return xt;
            } catch (Exception e6) {
                j(com.bytedance.pangle.r.xt.up, xt.j.f25467v, str, i6, -1L, null);
                f25429j.j(1100, -6, str, i6, e6);
                throw new j("安装包拷贝失败", e6);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(File file, String str, int i6, StringBuffer stringBuffer) throws j {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.tl.up.j(file.getAbsolutePath(), str)) {
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
            } catch (Exception e6) {
                j(com.bytedance.pangle.r.xt.up, xt.j.tj, str, i6, -1L, null);
                f25429j.j(1100, -3, str, i6, e6);
                throw new j(e6.getMessage(), e6);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean oq(File file, String str, int i6, StringBuffer stringBuffer) throws j {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (g.cw()) {
                    ae.j(file, str, i6);
                    com.bytedance.pangle.m.xt.j(Zeus.getAppApplication()).edit().putInt(str, i6).apply();
                    m.j();
                } else if (g.tl()) {
                    String cw = com.bytedance.pangle.up.cw.cw(str, i6);
                    String xt = com.bytedance.pangle.up.cw.xt(str, i6);
                    StringBuilder sb = new StringBuilder();
                    sb.append(cw);
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append(com.bytedance.pangle.m.xt.j(xt));
                    String sb2 = sb.toString();
                    if (com.bytedance.pangle.m.xt.j(xt, cw + str2 + com.bytedance.pangle.m.xt.j(xt)) && com.bytedance.pangle.m.xt.j(sb2)) {
                        stringBuffer.append("dexOpt1 cost:");
                        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                        stringBuffer.append(";");
                        return true;
                    }
                }
                stringBuffer.append("dexOpt1 cost:");
                stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
                stringBuffer.append(";");
                return false;
            } catch (Exception e6) {
                j(com.bytedance.pangle.r.xt.up, xt.j.f25466s, str, i6, -1L, null);
                throw new j("dexOpt1失败", e6);
            }
        } catch (Throwable th) {
            stringBuffer.append("dexOpt1 cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tl(File file, String str, int i6, StringBuffer stringBuffer) throws j {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!asList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new j("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        }
                    }
                }
            } catch (Exception e6) {
                j(com.bytedance.pangle.r.xt.up, xt.j.f25457f, str, i6, -1L, null);
                f25429j.j(1100, -4, str, i6, e6);
                throw new j("安装包权限校验失败", e6);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
        }
    }

    private static void xt(String str, int i6) {
        int xt = jy.j().xt(str, i6, "install");
        int xt2 = jy.j().xt(str, i6, "load");
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (xt > 3 || xt2 > 3) {
            removeApkEntryFlag = 0;
        }
        jy.j().j(str, i6, removeApkEntryFlag);
        jy.j().r(str, i6, false);
    }

    static boolean j(final File file, final String str, final int i6) {
        int i7;
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            oq oqVar = f25429j;
            oqVar.j(1000, 0, str, i6, null);
            com.bytedance.pangle.log.j j6 = com.bytedance.pangle.log.j.j(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            j(com.bytedance.pangle.r.xt.f25455r, xt.j.f25468w, str, i6, -1L, null);
            xt(str, i6);
            com.bytedance.pangle.util.ae.j(com.bytedance.pangle.up.cw.j(str, i6));
            j.InterfaceC0386j interfaceC0386j = new j.InterfaceC0386j() { // from class: com.bytedance.pangle.plugin.cw.1
                @Override // com.bytedance.pangle.j.j.InterfaceC0386j
                public void j() throws Throwable {
                    cw.m(file, str, i6, stringBuffer);
                }
            };
            try {
                j.InterfaceC0386j interfaceC0386j2 = new j.InterfaceC0386j() { // from class: com.bytedance.pangle.plugin.cw.2
                    @Override // com.bytedance.pangle.j.j.InterfaceC0386j
                    public void j() throws Throwable {
                        final Map ae = cw.ae(file, str, i6, stringBuffer);
                        cw.tl(file, str, i6, stringBuffer);
                        cw.xt(cw.g(file, str, i6, stringBuffer), str, i6, stringBuffer);
                        if (g.tl() || g.cw()) {
                            final boolean[] zArr2 = {false};
                            com.bytedance.pangle.j.j.j(false, new j.InterfaceC0386j() { // from class: com.bytedance.pangle.plugin.cw.2.1
                                @Override // com.bytedance.pangle.j.j.InterfaceC0386j
                                public void j() throws Throwable {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    cw.xt(str, i6, (Map<String, List<ZipEntry>>) ae, stringBuffer);
                                }
                            }, new j.InterfaceC0386j() { // from class: com.bytedance.pangle.plugin.cw.2.2
                                @Override // com.bytedance.pangle.j.j.InterfaceC0386j
                                public void j() throws Throwable {
                                    boolean[] zArr3 = zArr2;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    zArr3[0] = cw.oq(file, str, i6, stringBuffer);
                                }
                            });
                            zArr[0] = cw.xt(str, i6, zArr2[0], stringBuffer);
                        } else {
                            cw.xt(str, i6, (Map<String, List<ZipEntry>>) ae, stringBuffer);
                            zArr[0] = cw.xt(str, i6, false, stringBuffer);
                            cw.cw(str, i6);
                        }
                    }
                };
                stringBuffer = stringBuffer;
                zArr = zArr;
                com.bytedance.pangle.j.j.j(false, interfaceC0386j, interfaceC0386j2);
                com.bytedance.pangle.util.ae.j(file);
                j(com.bytedance.pangle.r.xt.up, xt.j.mi, str, i6, j6.j(), stringBuffer.toString());
                j6.j("success");
                oqVar.j(1100, 0, str, i6, null);
                return true;
            } catch (Throwable th) {
                th = th;
                stringBuffer = stringBuffer;
                zArr = zArr;
                Throwable th2 = th;
                if (th2 instanceof j) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th2);
                    i7 = i6;
                } else {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th2);
                    j(com.bytedance.pangle.r.xt.up, xt.j.kt, str, i6, -1L, stringBuffer.toString());
                    f25429j.j(1100, -1, str, i6, th2);
                    i7 = i6;
                }
                if (zArr[0]) {
                    jy.j().j(str, i7, "install");
                }
                return false;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xt(String str, int i6, boolean z5, StringBuffer stringBuffer) {
        int g6 = jy.j().g(str, i6);
        boolean z6 = (g6 & 1) != 0;
        boolean z7 = (g6 & 2) != 0;
        if (!z6 && !z7) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z8 = z5 && z6;
        String xt = com.bytedance.pangle.up.cw.xt(str, i6);
        long currentTimeMillis = System.currentTimeMillis();
        boolean j6 = com.bytedance.pangle.util.xt.xt.j(xt, z8, z7, str, i6, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        return j6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(String str, String str2, int i6, StringBuffer stringBuffer) throws j {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int j6 = new com.bytedance.pangle.res.j.cw().j(new File(str), false, sb);
        stringBuffer.append(j6 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(";");
        if (j6 == 100 || j6 == 200) {
            return;
        }
        String sb2 = sb.toString();
        j(com.bytedance.pangle.r.xt.up, xt.j.f25462l, str2, i6, -1L, sb2);
        f25429j.j(1100, -2, str2, i6, null);
        throw new j("modifyRes failed. result = " + j6 + ", errorLog = " + sb2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xt(String str, int i6, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) throws j {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.up.xt.j(new File(com.bytedance.pangle.up.cw.xt(str, i6)), new File(com.bytedance.pangle.up.cw.r(str, i6)), str, map);
            } catch (Exception e6) {
                j(com.bytedance.pangle.r.xt.up, xt.j.f25469x, str, i6, -1L, com.bytedance.pangle.log.xt.j((Object) e6));
                f25429j.j(1100, -7, str, i6, e6);
                throw new j("安装包动态库拷贝失败", e6);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(";");
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
            com.bytedance.sdk.openadsdk.api.m.j(e6);
        }
        com.bytedance.pangle.r.xt.j().j(str, jSONObject, jSONObject3, jSONObject2);
    }
}
