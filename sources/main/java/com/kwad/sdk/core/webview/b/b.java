package com.kwad.sdk.core.webview.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import cn.jpush.android.local.JPushConstants;
import com.baidu.mobads.sdk.internal.ca;
import com.google.common.net.HttpHeaders;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static final Map<String, com.kwad.sdk.core.webview.b.a.b> aNr = new ConcurrentHashMap();
    private static final Map<String, String> aNs = new ConcurrentHashMap();

    @Nullable
    public static WebResourceResponse a(Context context, String str, com.kwad.sdk.h.a.b bVar, b.a aVar, boolean z5) {
        com.kwad.sdk.core.webview.b.a.b bVar2;
        try {
            bVar2 = a(context, bVar, str, aVar);
        } catch (Exception e6) {
            c.printStackTraceOnly(e6);
            aVar.msg = "获取配置文件失败 崩溃" + Log.getStackTraceString(e6);
            bVar2 = null;
        }
        if (bVar2 == null) {
            b(z5, aVar.msg);
            if (TextUtils.isEmpty(aVar.msg)) {
                aVar.msg = "获取配置文件失败";
            }
            return null;
        }
        if (TextUtils.isEmpty(bVar2.aNz)) {
            b(z5, "getResource [" + str + "] getFilePath from url fail");
            aVar.msg = "getFilePath from url fail";
            return null;
        }
        if (!com.kwad.sdk.core.webview.b.c.c.fg(bVar2.aNv)) {
            b(z5, "mimetype为: " + bVar2.aNv + "不在拦截范围的文件");
            aVar.msg = "mimetype为: " + bVar2.aNv + "不在拦截范围的文件";
            return null;
        }
        BufferedInputStream gP = w.gP(bVar2.aNz);
        if (gP != null) {
            return a(gP, bVar2);
        }
        b(z5, "getResource [" + str + "] inputStream is null");
        StringBuilder sb = new StringBuilder("inputStream is null,本地加载路径：");
        sb.append(bVar2.aNz);
        aVar.msg = sb.toString();
        return null;
    }

    private static String ac(String str, String str2) {
        return str + Uri.parse(str2).getPath();
    }

    private static void b(boolean z5, String str) {
        if (z5) {
            return;
        }
        c.d("HybridResourceManager", str);
    }

    private static com.kwad.sdk.core.webview.b.a.b eY(String str) {
        return aNr.get(String.valueOf(str.hashCode()));
    }

    private static String eZ(String str) {
        return aNs.get(str);
    }

    private static void ad(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            aNs.put(str, str2);
        }
    }

    private static WebResourceResponse a(InputStream inputStream, com.kwad.sdk.core.webview.b.a.b bVar) {
        String str = bVar.aNv;
        HashMap hashMap = new HashMap();
        hashMap.put("Access-Control-Allow-Origin", bVar.aNy.aNt);
        hashMap.put("Access-Control-Allow-Credentials", "true");
        hashMap.put(HttpHeaders.TIMING_ALLOW_ORIGIN, bVar.aNy.aNu);
        hashMap.put("content-type", str);
        hashMap.put("Date", bVar.aNy.aNw);
        hashMap.put("union-cache ", "1");
        return new WebResourceResponse(bVar.aNv, "", bVar.status, ca.f10845k, hashMap, inputStream);
    }

    private static com.kwad.sdk.core.webview.b.a.b a(Context context, com.kwad.sdk.h.a.b bVar, String str, b.a aVar) {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream = null;
        try {
            String eZ = eZ(bVar.aRp);
            com.kwad.sdk.core.webview.b.a.b eY = !TextUtils.isEmpty(eZ) ? eY(ac(eZ, str)) : null;
            if (eY != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return eY;
            }
            String K = com.kwad.sdk.core.webview.b.c.a.K(context, bVar.aRq);
            if (K == null) {
                aVar.msg = "获取配置文件失败 offlinepackage 为空";
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            File file = new File(K);
            if (!file.exists()) {
                aVar.msg = "获取配置文件失败 下载文件路径不存在 " + K;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) null);
                return null;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
            }
            try {
                String b6 = h.b(inputStreamReader);
                if (TextUtils.isEmpty(b6)) {
                    aVar.msg = "获取配置文件失败 mainfest文件不存在";
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                    return null;
                }
                JSONObject jSONObject = new JSONObject(b6);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    com.kwad.sdk.core.webview.b.a.b bVar2 = new com.kwad.sdk.core.webview.b.a.b();
                    bVar2.parseJson(jSONObject2);
                    String host = Uri.parse(JPushConstants.HTTPS_PRE + next).getHost();
                    bVar2.aNA = host;
                    bVar2.aNz = com.kwad.sdk.core.webview.b.c.a.J(context, bVar.aRq) + "/" + next;
                    if (TextUtils.isEmpty(bVar2.aNv)) {
                        bVar2.aNv = URLConnection.getFileNameMap().getContentTypeFor(bVar2.aNz);
                    }
                    a(next, bVar2);
                    eZ = host;
                }
                ad(bVar.aRp, eZ);
                com.kwad.sdk.core.webview.b.a.b eY2 = eY(ac(eZ, str));
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                return eY2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }

    private static void a(String str, com.kwad.sdk.core.webview.b.a.b bVar) {
        aNr.put(String.valueOf(str.hashCode()), bVar);
    }
}
