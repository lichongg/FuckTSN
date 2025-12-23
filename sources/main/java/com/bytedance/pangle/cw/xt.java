package com.bytedance.pangle.cw;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.oq;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.r;
import com.bytedance.pangle.r.xt;
import com.bytedance.pangle.up.cw;
import com.bytedance.pangle.util.ae;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.jy;
import com.bytedance.pangle.util.tl;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static int j(String str) {
        String j6;
        File[] qv;
        int i6 = -1;
        if (TextUtils.isEmpty(str) || (j6 = cw.j(str)) == null) {
            return -1;
        }
        File[] listFiles = new File(j6).listFiles(new FileFilter() { // from class: com.bytedance.pangle.cw.xt.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split("-")[1]);
                if (parseInt > i6 && jy.j().r(str, parseInt) && (qv = cw.qv(str, parseInt)) != null && qv.length > 0) {
                    i6 = parseInt;
                }
            }
        }
        return i6;
    }

    private static String xt(String str) {
        return (str == null || !str.endsWith(":")) ? str : str.substring(0, str.length() - 1);
    }

    public static void j(final String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String j6 = cw.j(str);
        if (TextUtils.isEmpty(j6)) {
            return;
        }
        final String concat = "version-".concat(String.valueOf(i6));
        new File(j6).listFiles(new FileFilter() { // from class: com.bytedance.pangle.cw.xt.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null && !concat.equals(file.getName())) {
                    ae.j(file.getAbsolutePath());
                    if (file.getName().matches("^version-(\\d+)$")) {
                        jy.j().xt(str, Integer.parseInt(file.getName().split("-")[1]), false);
                    }
                }
                return false;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0094, code lost:
    
        if (r5 == 0) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.pangle.cw.j j(java.io.File r7, java.util.List<java.io.File> r8) throws java.io.IOException, org.json.JSONException {
        /*
            java.lang.String r0 = "Zeus/install_pangle"
            r1 = 0
            if (r7 == 0) goto La8
            if (r8 == 0) goto La8
            int r2 = r8.size()
            if (r2 <= 0) goto La8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r2.<init>()     // Catch: java.lang.Throwable -> L79
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L79
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L79
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L75
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L75
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L72
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L72
        L21:
            java.lang.String r6 = r5.readLine()     // Catch: java.lang.Throwable -> L2b
            if (r6 == 0) goto L2d
            r2.append(r6)     // Catch: java.lang.Throwable -> L2b
            goto L21
        L2b:
            r7 = move-exception
            goto L7d
        L2d:
            com.bytedance.pangle.oq r6 = com.bytedance.pangle.oq.j()     // Catch: java.lang.Throwable -> L2b
            com.bytedance.pangle.ZeusPluginDecodeCallback r6 = r6.r()     // Catch: java.lang.Throwable -> L2b
            if (r6 == 0) goto L63
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = r6.decode(r2)     // Catch: java.lang.Throwable -> L2b
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2b
            if (r6 != 0) goto L5d
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2b
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "DexPluginUtils parse dex config json success"
            com.bytedance.pangle.log.ZeusLogger.i(r0, r2)     // Catch: java.lang.Throwable -> L2b
            com.bytedance.pangle.cw.j r7 = com.bytedance.pangle.cw.j.j(r6, r7, r8)     // Catch: java.lang.Throwable -> L2b
            r3.close()
            r4.close()
            r5.close()
            return r7
        L5d:
            java.lang.String r7 = "DexPluginUtils parse dex config fail decode content is empty"
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L2b
            goto L68
        L63:
            java.lang.String r7 = "DexPluginUtils parse dex config fail decode callback is null"
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L2b
        L68:
            r3.close()
            r4.close()
        L6e:
            r5.close()
            goto La8
        L72:
            r7 = move-exception
            r5 = r1
            goto L7d
        L75:
            r7 = move-exception
            r4 = r1
        L77:
            r5 = r4
            goto L7d
        L79:
            r7 = move-exception
            r3 = r1
            r4 = r3
            goto L77
        L7d:
            java.lang.String r8 = "DexPluginUtils parse dex config fail throw error "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = r8.concat(r7)     // Catch: java.lang.Throwable -> L97
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L97
            if (r3 == 0) goto L8f
            r3.close()
        L8f:
            if (r4 == 0) goto L94
            r4.close()
        L94:
            if (r5 == 0) goto La8
            goto L6e
        L97:
            r7 = move-exception
            if (r3 == 0) goto L9d
            r3.close()
        L9d:
            if (r4 == 0) goto La2
            r4.close()
        La2:
            if (r5 == 0) goto La7
            r5.close()
        La7:
            throw r7
        La8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.cw.xt.j(java.io.File, java.util.List):com.bytedance.pangle.cw.j");
    }

    public static boolean j(j jVar, long j6) {
        List<File> list;
        File file;
        if (jVar != null) {
            list = jVar.r();
            file = jVar.up();
        } else {
            list = null;
            file = null;
        }
        if (file == null || list == null || list.size() <= 0) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail config is null");
        } else {
            int cw = jVar.cw();
            String xt = jVar.xt();
            ZeusPluginStateListener.postStateChange(xt, 11, new Object[0]);
            com.bytedance.pangle.plugin.cw.j(com.bytedance.pangle.r.xt.f25455r, xt.j.f25468w, xt, cw, -1L, null);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex start packageName = " + xt + " version is " + cw);
            String qv = jy.j().qv(xt);
            if (!TextUtils.isEmpty(qv) && j(qv) >= cw) {
                com.bytedance.pangle.plugin.cw.j(com.bytedance.pangle.r.xt.up, xt.j.kt, xt, cw, -1L, "dex installed version more than download version can no install new dex zip");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("dex installed version more than download version can no install new dex zip"));
                return false;
            }
            String ae = TextUtils.isEmpty(jVar.ae()) ? xt : jVar.ae();
            if (!cw.oq(ae, cw)) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex no dir need install packageName=" + xt + " version=" + cw);
                    for (File file2 : list) {
                        if (file2.getName().endsWith(".dex")) {
                            String j7 = cw.j(ae, cw, file2.getName());
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex = " + file2.getName());
                            tl.j(file2.getAbsolutePath(), j7);
                        }
                    }
                    if (file.getName().endsWith(".json")) {
                        String vl = cw.vl(ae, cw);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex config = " + file.getName());
                        tl.j(file.getAbsolutePath(), vl);
                    }
                    if (cw.oq(ae, cw)) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex success packageName = " + xt + " version = " + cw);
                        ZeusPluginStateListener.postStateChange(xt, 12, new Object[0]);
                        com.bytedance.pangle.plugin.cw.j(com.bytedance.pangle.r.xt.up, xt.j.mi, xt, cw, SystemClock.elapsedRealtime() - j6, "install success");
                        jy.j().xt(ae, cw, true);
                        if (!TextUtils.isEmpty(jVar.ae())) {
                            jy.j().cw(xt, ae);
                            jy.j().r(xt, qv);
                        }
                        return true;
                    }
                    com.bytedance.pangle.plugin.cw.j(com.bytedance.pangle.r.xt.up, xt.j.kt, xt, cw, -1L, "install dir not exists");
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("install dir not exists"));
                } catch (Exception e6) {
                    com.bytedance.pangle.plugin.cw.j(com.bytedance.pangle.r.xt.up, xt.j.kt, xt, cw, -1L, "throw exception: ".concat(String.valueOf(e6)));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail throw exception");
                    m.j(e6);
                }
            } else {
                com.bytedance.pangle.plugin.cw.j(com.bytedance.pangle.r.xt.up, xt.j.mi, xt, cw, SystemClock.elapsedRealtime() - j6, "install success 已经安装完成");
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex already install packageName = " + xt + " version = " + cw);
                return true;
            }
        }
        return false;
    }

    public static boolean j(Plugin plugin, StringBuilder sb) {
        try {
            if (plugin == null) {
                sb.append("loadDexPlugin fail, plugin == null;");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadDexPlugin fail, plugin is not installed");
                return false;
            }
            if (!(plugin instanceof com.bytedance.pangle.plugin.j)) {
                sb.append("loadDexPlugin fail, plugin must be dexPlugin");
                return false;
            }
            String qv = jy.j().qv(plugin.mPkgName);
            if (TextUtils.isEmpty(qv)) {
                qv = plugin.mPkgName;
            }
            int j6 = j(qv);
            if (j6 == -1) {
                sb.append("loadDexPlugin fail, get Plugin version is -1");
                return false;
            }
            File[] qv2 = cw.qv(qv, j6);
            if (qv2 != null && qv2.length != 0) {
                String vl = cw.vl(qv, j6);
                if (TextUtils.isEmpty(vl)) {
                    sb.append("loadDexPlugin fail, configFileString is empty");
                    return false;
                }
                File file = new File(vl);
                if (file.exists() && file.isFile()) {
                    j j7 = j(file, (List<File>) Arrays.asList(qv2));
                    ((com.bytedance.pangle.plugin.j) plugin).j(j7);
                    if (j7 == null) {
                        sb.append("loadDexPlugin fail, config is null");
                        return false;
                    }
                    if (!j7.j()) {
                        sb.append("loadDexPlugin fail, check dex fail");
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : qv2) {
                        if (file2.isFile()) {
                            sb2.append(file2.getAbsolutePath());
                            sb2.append(":");
                        }
                    }
                    String xt = xt(sb2.toString());
                    if (TextUtils.isEmpty(xt)) {
                        sb.append("loadDexPlugin fail, dexPath is empty");
                        return false;
                    }
                    Map<String, JSONObject> up = oq.j().up();
                    if (up != null && up.size() != 0) {
                        JSONObject jSONObject = up.get(plugin.mPkgName);
                        if (jSONObject != null && jSONObject.has("hostPackageName")) {
                            String optString = jSONObject.optString("hostPackageName");
                            if (TextUtils.isEmpty(optString)) {
                                sb.append("loadDexPlugin fail, hostPackageName is empty");
                                return false;
                            }
                            Plugin plugin2 = Zeus.getPlugin(optString);
                            if (plugin2 != null) {
                                if (g.qv()) {
                                    sb.append("loadDexPlugin addDexPath success dexPath=".concat(String.valueOf(xt)));
                                    return r.j(plugin2.mClassLoader, xt);
                                }
                                if (plugin2.mClassLoader != null) {
                                    ArrayList arrayList = new ArrayList(1);
                                    arrayList.add(new PluginClassLoader(xt, null, null, null));
                                    sb.append("loadDexPlugin setOtherPluginClassLoader success dexPath=");
                                    sb.append(xt);
                                    plugin2.mClassLoader.setOtherPluginClassLoader(arrayList);
                                    return true;
                                }
                                sb.append("loadDexPlugin fail classLoader is null");
                                return false;
                            }
                            sb.append("loadDexPlugin fail, hostPlugin is null hostPackageName=");
                            sb.append(optString);
                            return false;
                        }
                        sb.append("loadDexPlugin fail, dex config can not get hostPackageName");
                        return false;
                    }
                    sb.append("loadDexPlugin fail, getPackageDexManager is empty");
                    return false;
                }
                sb.append("loadDexPlugin fail, config file is not exists or is not file");
                return false;
            }
            sb.append("loadDexPlugin fail, get dex files is null or length is 0");
            return false;
        } catch (Throwable th) {
            sb.append("loadDexPlugin fail, throw error ");
            sb.append(th);
            return false;
        }
    }
}
