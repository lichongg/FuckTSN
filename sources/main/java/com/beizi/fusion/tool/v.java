package com.beizi.fusion.tool;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.RequestInfo;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    private static String f13775a = "HttpUtil";

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e0, code lost:
    
        if (r6 == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ce, code lost:
    
        if (r6 == 0) goto L62;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8 A[Catch: IOException -> 0x00b2, TRY_ENTER, TryCatch #9 {IOException -> 0x00b2, blocks: (B:49:0x00c6, B:51:0x00cb, B:38:0x00d8, B:40:0x00dd, B:58:0x00ae), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd A[Catch: IOException -> 0x00b2, TRY_LEAVE, TryCatch #9 {IOException -> 0x00b2, blocks: (B:49:0x00c6, B:51:0x00cb, B:38:0x00d8, B:40:0x00dd, B:58:0x00ae), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c6 A[Catch: IOException -> 0x00b2, TRY_ENTER, TryCatch #9 {IOException -> 0x00b2, blocks: (B:49:0x00c6, B:51:0x00cb, B:38:0x00d8, B:40:0x00dd, B:58:0x00ae), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cb A[Catch: IOException -> 0x00b2, TRY_LEAVE, TryCatch #9 {IOException -> 0x00b2, blocks: (B:49:0x00c6, B:51:0x00cb, B:38:0x00d8, B:40:0x00dd, B:58:0x00ae), top: B:2:0x0006 }] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.v.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private static byte[] b(Context context, String str) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", "5.2.1.20");
            jSONObject.put("srcType", 1);
            jSONObject.put("timeStamp", System.currentTimeMillis());
            jSONObject.put("appid", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkUID", devInfo.getSdkUID());
            jSONObject2.put("sdkUIDOrig", devInfo.getSdkUIDOrig());
            jSONObject2.put("os", devInfo.getOs());
            jSONObject2.put("platform", 2);
            jSONObject2.put("devType", Integer.valueOf(devInfo.getDevType()));
            jSONObject2.put(bn.f10754j, devInfo.getBrand());
            jSONObject2.put(bn.f10753i, devInfo.getModel());
            jSONObject2.put("resolution", devInfo.getResolution());
            jSONObject2.put("screenSize", devInfo.getScreenSize());
            jSONObject2.put("language", devInfo.getLanguage());
            jSONObject2.put("density", devInfo.getDensity());
            jSONObject2.put("root", devInfo.getRoot());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TKDownloadReason.KSAD_TK_NET, Integer.valueOf(envInfo.getNet()));
            jSONObject3.put("isp", Integer.valueOf(envInfo.getIsp()));
            jSONObject.putOpt("devInfo", jSONObject2);
            jSONObject.putOpt("envInfo", jSONObject3);
            String a6 = b.a(y.a(), jSONObject.toString());
            if (!TextUtils.isEmpty(a6)) {
                return a6.getBytes();
            }
            return null;
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0128, code lost:
    
        if (r2 != 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0106, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0104, code lost:
    
        if (r2 != 0) goto L76;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7, byte[] r8) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.v.a(java.lang.String, byte[]):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v24, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r11, java.io.File r12) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.v.a(java.lang.String, java.io.File):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00e3, code lost:
    
        if (r7 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x014a, code lost:
    
        if (r7 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e5, code lost:
    
        r7.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0114 A[Catch: IOException -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #9 {IOException -> 0x00ea, blocks: (B:67:0x0114, B:53:0x00e5), top: B:8:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.InputStreamReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x00eb -> B:53:0x014d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.Boolean r8) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.tool.v.a(android.content.Context, java.lang.String, java.lang.String, java.lang.Boolean):java.lang.String");
    }

    private static byte[] a(Context context, String str) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", str);
            jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, ap.c(context));
            jSONObject.put("installTime", String.valueOf(ap.a(context)));
            jSONObject.put("updateTime", String.valueOf(ap.b(context)));
            jSONObject.put("uploadTime", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("appVersion", ap.d(context));
            jSONObject.put("sdkVersion", "5.2.1.20");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkUID", devInfo.getSdkUID());
            jSONObject2.put("sdkUIDOrig", devInfo.getSdkUIDOrig());
            if (!TextUtils.isEmpty(devInfo.getOaid())) {
                jSONObject2.put("oaid", devInfo.getOaid());
            } else if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
                jSONObject2.put("oaid", requestInfo.getCustomOaid());
            }
            if (!TextUtils.isEmpty(devInfo.getHonorOaid())) {
                jSONObject2.put("honorOaid", devInfo.getHonorOaid());
            }
            jSONObject2.put("gaid", devInfo.getGaid());
            jSONObject2.put("os", devInfo.getOs());
            jSONObject2.put("platform", "2");
            jSONObject2.put("devType", devInfo.getDevType());
            jSONObject2.put(bn.f10754j, devInfo.getBrand());
            jSONObject2.put(bn.f10753i, devInfo.getModel());
            jSONObject2.put("resolution", devInfo.getResolution());
            jSONObject2.put("screenSize", devInfo.getScreenSize());
            jSONObject2.put("language", devInfo.getLanguage());
            jSONObject2.put("density", devInfo.getDensity());
            jSONObject2.put("root", devInfo.getRoot());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TKDownloadReason.KSAD_TK_NET, envInfo.getNet());
            jSONObject3.put("isp", envInfo.getIsp());
            jSONObject3.put("developerMode", ap.g(context));
            jSONObject3.put("isDebugApk", ap.f(context));
            jSONObject3.put("isDebugConnected", Debug.isDebuggerConnected());
            jSONObject3.put("isWifiProxy", ap.h(context));
            jSONObject3.put("isVpn", ap.b());
            jSONObject3.put("isSimulator", q.a().a(context));
            jSONObject.putOpt("devInfo", jSONObject2);
            jSONObject.putOpt("envInfo", jSONObject3);
            String a6 = a.a(jSONObject.toString(), y.b());
            if (TextUtils.isEmpty(a6)) {
                return null;
            }
            return a6.getBytes();
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
