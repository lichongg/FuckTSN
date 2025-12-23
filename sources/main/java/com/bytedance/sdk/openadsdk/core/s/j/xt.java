package com.bytedance.sdk.openadsdk.core.s.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.oq.g;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.utils.ws;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.i.r;
import com.bytedance.sdk.openadsdk.i.up;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private static final HashMap<String, String> ae;
    private static final String cw;

    /* renamed from: g, reason: collision with root package name */
    private static long f30189g;

    /* renamed from: j, reason: collision with root package name */
    private static final String f30190j;
    private static long tl;
    private static final xt up;
    private static final String xt;

    /* renamed from: m, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f30191m;

    /* renamed from: r, reason: collision with root package name */
    private FileOutputStream f30192r;

    private static final class j {
        public boolean ae;
        public String cw;

        /* renamed from: g, reason: collision with root package name */
        public int f30197g;

        /* renamed from: j, reason: collision with root package name */
        public String f30198j;

        /* renamed from: m, reason: collision with root package name */
        public String f30199m;
        public int oq;
        public String qv;

        /* renamed from: r, reason: collision with root package name */
        public String f30200r;
        public int tl;
        public String up;
        public int xt;

        private j() {
        }

        public boolean j() {
            return TextUtils.equals(this.f30198j, "com.byted.mixed");
        }

        public String toString() {
            try {
                return new JSONObject().put(bi.f40972o, this.f30198j).put("version_code", this.xt).put("sign", this.up).put("max_version", this.f30197g).put("min_version", this.tl).put("is_revert", this.ae).put(TKDownloadReason.KSAD_TK_MD5, this.f30199m).put("plugin_file", this.qv).toString();
            } catch (JSONException unused) {
                return "";
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.s.j.xt$xt, reason: collision with other inner class name */
    private static final class C0475xt extends Exception {

        /* renamed from: j, reason: collision with root package name */
        private int f30201j;

        int j() {
            return this.f30201j;
        }

        public C0475xt(int i6, String str) {
            super(str);
            this.f30201j = i6;
        }
    }

    private static File cw(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.xt.j(context, "tt_pangle_bykv_file", 0);
    }

    private static File r(Context context) {
        return new File(cw(context), xt);
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append("next");
        f30190j = sb.toString();
        xt = str + "tmp";
        cw = str + "conf";
        up = new xt();
        ae = new HashMap<>();
    }

    private static boolean cw(j jVar) {
        if (j(jVar)) {
            return 7012 == jVar.xt;
        }
        JSONObject optJSONObject = oq.i().rn().optJSONObject(jVar.f30198j);
        return (optJSONObject != null ? xt(optJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0) == jVar.xt;
    }

    private static File m(Context context) {
        return new File(cw(context), cw);
    }

    private static int r(j jVar) {
        JSONObject optJSONObject;
        if (j(jVar)) {
            return 7012;
        }
        if (!oq.i().rn().has(jVar.f30198j) || (optJSONObject = oq.i().rn().optJSONObject(jVar.f30198j)) == null) {
            return 0;
        }
        return xt(optJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION));
    }

    private static File up(Context context) {
        return new File(cw(context), f30190j);
    }

    private void xt(Context context) {
        FileOutputStream fileOutputStream = this.f30192r;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        File r5 = r(context);
        if (r5.exists()) {
            for (File file : r5.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private xt() {
    }

    public static xt j() {
        return up;
    }

    public void j(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(v.getContext().getApplicationContext());
        ae.xt(new g("updatePlugin") { // from class: com.bytedance.sdk.openadsdk.core.s.j.xt.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xt.this.j(origApplicationContext, (List<j>) xt.cw(jSONArray));
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<j> cw(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    j jVar = new j();
                    jVar.f30198j = j(optJSONObject.optString(bi.f40972o));
                    jVar.xt = optJSONObject.optInt("version_code");
                    jVar.cw = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                    jVar.f30200r = optJSONObject.optString("download_url");
                    jVar.up = optJSONObject.optString("sign");
                    jVar.tl = xt(optJSONObject.optString("min_version"));
                    jVar.f30197g = xt(optJSONObject.optString("max_version"));
                    jVar.oq = optJSONObject.optInt("plugin_update_network", -2);
                    arrayList.add(jVar);
                }
            }
        }
        return arrayList;
    }

    private boolean j(Context context, int i6, String str) {
        int j6 = oq.i().s().j(str);
        if (oq.i().hl()) {
            return j(j6);
        }
        if (i6 != -1) {
            if (i6 != 1 && i6 != 2 && i6 != 3) {
                if (i6 == 4 || i6 == 5) {
                    return false;
                }
                if (j6 == 3) {
                    i6 = 1;
                }
            }
            return j(i6);
        }
        i6 = j6;
        return j(i6);
    }

    private boolean xt(j jVar, int i6) {
        j(jVar);
        return (i6 == 21 || i6 == 18) ? false : true;
    }

    private static boolean xt(j jVar) {
        int xt2;
        JSONObject optJSONObject;
        if (j(jVar)) {
            xt2 = h.xt;
        } else {
            xt2 = (!oq.i().rn().has(jVar.f30198j) || (optJSONObject = oq.i().rn().optJSONObject(jVar.f30198j)) == null) ? 0 : xt(optJSONObject.optString("sdk_version"));
        }
        return xt2 >= jVar.tl && xt2 <= jVar.f30197g;
    }

    private boolean j(int i6) {
        if (i6 != 1) {
            if (i6 == 3 || i6 == 4 || i6 == 5) {
                return false;
            }
        } else if (!ws.r(v.getContext())) {
            return false;
        }
        return true;
    }

    public void j(Function<SparseArray<Object>, Object> function) {
        this.f30191m = function;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final Context context, List<j> list) {
        synchronized ("__tt_pl_up_lock__") {
            try {
                try {
                } catch (Exception e6) {
                    com.bytedance.sdk.openadsdk.core.kt.ws.j().j("", 7012, 0, "", 14, e6.getMessage(), 0L);
                    vl.xt("PluginUpdater", "Handle file error: " + e6);
                }
                if (!j(context)) {
                    xt(context);
                    return;
                }
                list.size();
                final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                for (final j jVar : list) {
                    ae.xt(new g("pl download") { // from class: com.bytedance.sdk.openadsdk.core.s.j.xt.2
                        @Override // java.lang.Runnable
                        public void run() {
                            xt.this.j(context, jVar);
                            countDownLatch.countDown();
                        }
                    });
                }
                countDownLatch.await();
                xt(context);
            } catch (Throwable th) {
                xt(context);
                throw th;
            }
        }
    }

    private static boolean xt(int i6) {
        File j6 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(v.getContext());
        if (j6 == null) {
            return false;
        }
        return new File(j6.getParent() + "/pangle_p/com.byted.pangle/version-" + i6).exists();
    }

    public static String xt() {
        String str;
        String j6 = com.bytedance.sdk.openadsdk.core.s.xt.xt.j();
        if ("arm64-v8a".equals(j6)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(j6)) {
            str = "@32";
        } else if ("armeabi".equals(j6)) {
            str = "@armeabi";
        } else {
            str = "";
        }
        return "com.byted.live.lite" + str;
    }

    private boolean j(Context context) {
        try {
            File r5 = r(context);
            if (!r5.exists()) {
                r5.mkdirs();
            }
            File file = new File(r5, "update.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.exists()) {
                vl.xt("PluginUpdater", "create lock file failed");
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.f30192r = fileOutputStream;
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            if (tryLock != null && tryLock.isValid()) {
                return true;
            }
            vl.xt("PluginUpdater", "Acquire file lock failed");
            this.f30192r.close();
            return false;
        } catch (Throwable th) {
            FileOutputStream fileOutputStream2 = this.f30192r;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            }
            vl.xt("PluginUpdater", "Try get file lock failed:" + th);
            return false;
        }
    }

    private static int xt(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(".", ""));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private static boolean j(j jVar) {
        return "com.byted.pangle".equals(jVar.f30198j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(android.content.Context r13, com.bytedance.sdk.openadsdk.core.s.j.xt.j r14) {
        /*
            r12 = this;
            int r0 = r14.oq     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            java.lang.String r1 = r14.f30198j     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            boolean r0 = r12.j(r13, r0, r1)     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            if (r0 != 0) goto L31
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            r13.<init>()     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            com.bytedance.sdk.openadsdk.core.oq r0 = com.bytedance.sdk.openadsdk.core.oq.i()     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            com.bytedance.sdk.openadsdk.core.s.j r0 = r0.s()     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            r13.append(r0)     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            java.lang.String r0 = ":"
            r13.append(r0)     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            int r0 = r14.oq     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            r13.append(r0)     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            java.lang.String r13 = r13.toString()     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            r0 = 20
            r9 = r13
            r8 = 20
            goto L51
        L2e:
            r0 = move-exception
            r13 = r0
            goto L41
        L31:
            java.io.File r0 = r(r13)     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            int r0 = j(r13, r0, r14)     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            r12.j(r14, r0)     // Catch: com.bytedance.sdk.openadsdk.core.s.j.xt.C0475xt -> L2e
            java.lang.String r13 = ""
        L3e:
            r9 = r13
            r8 = r0
            goto L51
        L41:
            int r0 = r13.j()
            java.lang.String r13 = r13.getMessage()
            java.lang.String r1 = r14.f30198j
            r2 = 1004(0x3ec, float:1.407E-42)
            r12.j(r1, r2)
            goto L3e
        L51:
            boolean r13 = j(r14)
            if (r13 == 0) goto L5c
            r13 = 7012(0x1b64, float:9.826E-42)
            r5 = 7012(0x1b64, float:9.826E-42)
            goto L5e
        L5c:
            r13 = 0
            r5 = 0
        L5e:
            com.bytedance.sdk.openadsdk.core.kt.ws r3 = com.bytedance.sdk.openadsdk.core.kt.ws.j()
            java.lang.String r4 = r14.f30198j
            int r6 = r14.xt
            java.lang.String r7 = r14.f30200r
            long r13 = com.bytedance.sdk.openadsdk.core.s.j.xt.f30189g
            long r0 = com.bytedance.sdk.openadsdk.core.s.j.xt.tl
            long r10 = r13 - r0
            r3.j(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.s.j.xt.j(android.content.Context, com.bytedance.sdk.openadsdk.core.s.j.xt$j):void");
    }

    private void j(j jVar, int i6) {
        SparseArray<Object> xt2;
        Object apply;
        PluginValueSet pluginValueSet;
        if (this.f30191m == null || !xt(jVar, i6)) {
            return;
        }
        SparseArray<Object> xt3 = r.j().j(2, jVar.toString()).j(3, jVar.f30198j).xt();
        boolean z5 = i6 == 6 || i6 == 10 || i6 == 16;
        SparseArray<Object> xt4 = up.j().j(z5).j(z5 ? 0 : 1004).j(xt3).xt();
        try {
            if (com.bytedance.sdk.openadsdk.i.cw.r.j(h.xt)) {
                xt2 = r.j(xt4).j(1).j(SparseArray.class).xt();
            } else {
                xt2 = r.j().j(1).j(SparseArray.class).j(-99999979, xt4).xt();
            }
            apply = this.f30191m.apply(xt2);
            if (apply instanceof SparseArray) {
                pluginValueSet = e.i((SparseArray) apply).k();
            } else {
                pluginValueSet = (com.bytedance.sdk.openadsdk.i.cw.r.j(h.xt) && (apply instanceof PluginValueSet)) ? (PluginValueSet) apply : null;
            }
            if (pluginValueSet == null || !pluginValueSet.booleanValue(4) || jVar.qv == null) {
                return;
            }
            HashMap<String, String> hashMap = ae;
            hashMap.put(jVar.f30198j, new File(jVar.qv).getName());
            j(jVar.f30198j, jVar.cw);
            hashMap.values();
        } catch (Exception e6) {
            vl.cw("PluginUpdater", "Download pl done, but install error:" + e6.getMessage());
        }
    }

    private static void j(String str, String str2) {
        if (str == null) {
            return;
        }
        oq.i().j(str, str2);
    }

    private static int j(Context context, File file, j jVar) throws C0475xt {
        String str;
        if (jVar == null) {
            return 2;
        }
        try {
            if (TextUtils.isEmpty(jVar.f30200r)) {
                return 2;
            }
            if (TextUtils.isEmpty(jVar.f30198j)) {
                return 12;
            }
            if (!j(jVar) && !oq.i().rn().has(jVar.f30198j)) {
                return 17;
            }
            if (cw(jVar)) {
                return 18;
            }
            if (xt(jVar.xt)) {
                return 21;
            }
            if (!xt(jVar)) {
                return 19;
            }
            File m6 = m(context);
            if (!m6.exists()) {
                m6.mkdirs();
            }
            boolean z5 = true;
            if (j(jVar) && h.xt >= jVar.xt) {
                String str2 = "-" + com.bytedance.sdk.component.utils.up.xt(jVar.f30198j) + "-" + h.xt + "-" + h.xt;
                int i6 = h.xt;
                jVar.f30197g = i6;
                jVar.tl = i6;
                jVar.ae = true;
                j(new File(m6, str2 + ".conf"), jVar);
                return 10;
            }
            if (TextUtils.isEmpty(jVar.up) && !jVar.j()) {
                return 1;
            }
            String xt2 = com.bytedance.sdk.component.utils.up.xt(jVar.f30198j);
            StringBuilder sb = new StringBuilder();
            String xt3 = com.bytedance.sdk.component.utils.up.xt(jVar.up);
            if (!TextUtils.isEmpty(xt3)) {
                sb.append(xt3);
                sb.append("-");
            }
            sb.append(xt2);
            sb.append("-");
            sb.append(jVar.tl);
            sb.append("-");
            sb.append(jVar.f30197g);
            String sb2 = sb.toString();
            File up2 = up(context);
            if (!up2.exists()) {
                up2.mkdirs();
            }
            File file2 = new File(up2, sb2 + (jVar.j() ? ".dex.zip" : ".apk"));
            if (file2.exists()) {
                jVar.f30199m = com.bytedance.sdk.component.utils.up.j(file2);
                jVar.qv = file2.getAbsolutePath();
                return 16;
            }
            if (file2.getName().equals(ae.get(jVar.f30198j))) {
                return 21;
            }
            com.bytedance.sdk.openadsdk.core.kt.ws.j().j(jVar.f30198j, j(jVar) ? 7012 : 0, jVar.xt, jVar.f30200r, 7, "", 0L);
            File file3 = new File(file, sb2);
            com.bytedance.sdk.component.g.xt.xt r5 = com.bytedance.sdk.openadsdk.core.v.up.j().xt().r();
            r5.j(jVar.f30200r);
            r5.j(file.getAbsolutePath(), sb2);
            tl = System.currentTimeMillis();
            com.bytedance.sdk.component.g.xt j6 = r5.j();
            if (j6 != null && j6.tl()) {
                f30189g = System.currentTimeMillis();
                if (!file3.exists()) {
                    return 13;
                }
                j(up2, xt2);
                j(m6, xt2);
                if (!file3.renameTo(file2)) {
                    return 5;
                }
                File file4 = new File(m6, file3.getName() + ".conf");
                jVar.f30199m = com.bytedance.sdk.component.utils.up.j(file2);
                jVar.qv = file2.getAbsolutePath();
                if (jVar.xt >= r(jVar)) {
                    z5 = false;
                }
                jVar.ae = z5;
                return j(file4, jVar) ? 6 : 15;
            }
            if (j6 != null) {
                str = j6.j() + " : " + j6.xt();
            } else {
                str = "no response";
            }
            throw new C0475xt(9, str);
        } catch (Exception e6) {
            vl.xt("PluginUpdater", "Download file error: " + e6);
            if (e6 instanceof C0475xt) {
                throw e6;
            }
            throw new C0475xt(14, e6.getMessage());
        }
    }

    private static boolean j(File file, j jVar) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jVar.toString());
            fileWriter.close();
            return true;
        } catch (IOException unused) {
            vl.xt("PluginUpdater", "Write config failed;");
            return false;
        }
    }

    private static void j(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.core.s.j.xt.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 == null || !str2.contains(str)) {
                    return false;
                }
                new File(file2, str2).delete();
                vl.xt("PluginUpdater", "Delete file: ".concat(str2));
                return false;
            }
        });
    }

    public static String j(String str) {
        return ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) ? "com.byted.live.lite" : str;
    }

    public void j(String str, int i6) {
        SparseArray<Object> xt2;
        if (this.f30191m == null) {
            return;
        }
        SparseArray<Object> xt3 = up.j().j(false).j(i6).j(r.j().j(3, str).xt()).xt();
        int i7 = h.xt;
        if (i7 < 7000 && i7 >= 6800) {
            xt2 = r.j(xt3).j(1).j(Void.class).xt();
        } else {
            xt2 = r.j().j(1).j(Void.class).j(-99999979, xt3).xt();
        }
        this.f30191m.apply(xt2);
    }
}
