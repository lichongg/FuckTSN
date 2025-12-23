package com.bykv.vk.openvk.component.video.j.cw;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.openvk.component.video.j.xt.g;
import com.bykv.vk.openvk.component.video.j.xt.up;
import com.bykv.vk.openvk.component.video.j.xt.xt.cw;
import com.bytedance.sdk.component.oq.ae;
import com.bytedance.sdk.component.utils.vl;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class j {
    private static final Handler xt = new Handler(Looper.getMainLooper());

    /* renamed from: j, reason: collision with root package name */
    public static final Charset f22978j = Charset.forName("UTF-8");

    /* renamed from: com.bykv.vk.openvk.component.video.j.cw.j$1, reason: invalid class name */
    static class AnonymousClass1 implements FilenameFilter {

        /* renamed from: j, reason: collision with root package name */
        private Pattern f22979j = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f22979j.matcher(str).matches();
        }

        AnonymousClass1() {
        }
    }

    public static void j(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int xt(String str) {
        return j(str, 0);
    }

    public static boolean cw(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static void j(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String xt(int i6, int i7) {
        if (i6 >= 0 && i7 > 0) {
            return i6 + "-" + i7;
        }
        if (i6 > 0) {
            return i6 + "-";
        }
        if (i6 >= 0 || i7 <= 0) {
            return null;
        }
        return "-" + i7;
    }

    public static void j(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void j(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean j(String str) {
        if (str != null) {
            return str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE);
        }
        return false;
    }

    public static boolean xt() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static int j(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return i6;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i6;
        }
    }

    public static String xt(List<g.xt> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                g.xt xtVar = list.get(0);
                if (xtVar != null) {
                    sb.append(xtVar.f23051j);
                    sb.append(": ");
                    sb.append(xtVar.xt);
                    sb.append(org.apache.commons.net.g.f50795q);
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String j(com.bykv.vk.openvk.component.video.j.xt.up.j jVar, int i6) {
        int j6;
        if (jVar == null || !jVar.xt()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jVar.up().toUpperCase());
        sb.append(' ');
        sb.append(jVar.j());
        sb.append(' ');
        sb.append(jVar.m());
        sb.append(org.apache.commons.net.g.f50795q);
        if (up.cw) {
            vl.j("TAG_PROXY_headers", jVar.up().toUpperCase() + " " + jVar.j() + " " + jVar.m());
        }
        List<g.xt> j7 = j(jVar.cw());
        boolean z5 = true;
        if (j7 != null) {
            int size = j7.size();
            for (int i7 = 0; i7 < size; i7++) {
                g.xt xtVar = j7.get(i7);
                if (xtVar != null) {
                    String str = xtVar.f23051j;
                    String str2 = xtVar.xt;
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    sb.append(org.apache.commons.net.g.f50795q);
                    if ("Content-Range".equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z5 = false;
                    }
                }
            }
        }
        if (z5 && (j6 = j(jVar)) > 0) {
            sb.append("Content-Range: bytes ");
            sb.append(Math.max(i6, 0));
            sb.append("-");
            sb.append(j6 - 1);
            sb.append("/");
            sb.append(j6);
            sb.append(org.apache.commons.net.g.f50795q);
        }
        sb.append("Connection: close\r\n");
        sb.append(org.apache.commons.net.g.f50795q);
        String sb2 = sb.toString();
        if (up.cw) {
            vl.j("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static String xt(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append(": ");
                sb.append((Object) entry.getValue());
                sb.append(org.apache.commons.net.g.f50795q);
            }
            return sb.toString();
        }
        return "";
    }

    public static String j(int i6, int i7) {
        String xt2 = xt(i6, i7);
        if (xt2 == null) {
            return null;
        }
        return "bytes=" + xt2;
    }

    public static List<String> j(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (j(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static String j(com.bykv.vk.openvk.component.video.j.xt.xt.j jVar, int i6) {
        StringBuilder sb = new StringBuilder();
        if (i6 <= 0) {
            sb.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb.append("Accept-Ranges: bytes\r\n");
        sb.append("Content-Type: ");
        sb.append(jVar.xt);
        sb.append(org.apache.commons.net.g.f50795q);
        if (i6 <= 0) {
            sb.append("Content-Length: ");
            sb.append(jVar.cw);
            sb.append(org.apache.commons.net.g.f50795q);
        } else {
            sb.append("Content-Range: bytes ");
            sb.append(i6);
            sb.append("-");
            sb.append(jVar.cw - 1);
            sb.append("/");
            sb.append(jVar.cw);
            sb.append(org.apache.commons.net.g.f50795q);
            sb.append("Content-Length: ");
            sb.append(jVar.cw - i6);
            sb.append(org.apache.commons.net.g.f50795q);
        }
        sb.append("Connection: close\r\n");
        sb.append(org.apache.commons.net.g.f50795q);
        String sb2 = sb.toString();
        if (up.cw) {
            vl.j("TAG_PROXY_WRITE_TO_MP", sb2);
        }
        return sb2;
    }

    public static int j() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    public static int j(com.bykv.vk.openvk.component.video.j.xt.up.j jVar) {
        int lastIndexOf;
        if (jVar == null) {
            return -1;
        }
        if (jVar.j() == 200) {
            return j(jVar.j("Content-Length", null), -1);
        }
        if (jVar.j() == 206) {
            String j6 = jVar.j("Content-Range", null);
            if (!TextUtils.isEmpty(j6) && (lastIndexOf = j6.lastIndexOf("/")) >= 0 && lastIndexOf < j6.length() - 1) {
                return j(j6.substring(lastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static String j(com.bykv.vk.openvk.component.video.j.xt.up.j jVar, boolean z5, boolean z6) {
        String j6;
        if (jVar == null) {
            if (up.cw) {
                vl.r("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!jVar.xt()) {
            if (up.cw) {
                vl.r("TAG_PROXY_Response", "response code: " + jVar.j());
            }
            return "response code: " + jVar.j();
        }
        String j7 = jVar.j("Content-Type", null);
        if (!cw(j7)) {
            if (up.cw) {
                vl.r("TAG_PROXY_Response", "Content-Type: " + j7);
            }
            return "Content-Type: " + j7;
        }
        int j8 = j(jVar);
        if (j8 <= 0) {
            if (up.cw) {
                vl.r("TAG_PROXY_Response", "Content-Length: " + j8);
            }
            return "Content-Length: " + j8;
        }
        if (z5 && ((j6 = jVar.j("Accept-Ranges", null)) == null || !j6.contains("bytes"))) {
            if (up.cw) {
                vl.r("TAG_PROXY_Response", "Accept-Ranges: " + j6);
            }
            return "Accept-Ranges: " + j6;
        }
        if (!z6 || jVar.r() != null) {
            return null;
        }
        if (up.cw) {
            vl.r("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static void j(com.bytedance.sdk.component.oq.g gVar) {
        if (gVar != null) {
            if (xt()) {
                ae.xt(gVar);
                if (up.cw) {
                    vl.r("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            gVar.run();
            if (up.cw) {
                vl.r("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void j(Runnable runnable) {
        if (runnable != null) {
            if (xt()) {
                runnable.run();
            } else {
                xt.post(runnable);
            }
        }
    }

    public static List<g.xt> j(List<g.xt> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (up.cw) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                g.xt xtVar = list.get(i6);
                if (xtVar != null) {
                    vl.j("TAG_PROXY_PRE_FILTER", xtVar.f23051j + ": " + xtVar.f23051j);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (g.xt xtVar2 : list) {
            if ("Host".equals(xtVar2.f23051j) || "Keep-Alive".equals(xtVar2.f23051j) || "Connection".equals(xtVar2.f23051j) || "Proxy-Connection".equals(xtVar2.f23051j)) {
                arrayList.add(xtVar2);
            }
        }
        list.removeAll(arrayList);
        if (up.cw) {
            int size2 = list.size();
            for (int i7 = 0; i7 < size2; i7++) {
                g.xt xtVar3 = list.get(i7);
                if (xtVar3 != null) {
                    vl.j("TAG_PROXY_POST_FILTER", xtVar3.f23051j + ": " + xtVar3.xt);
                }
            }
        }
        return list;
    }

    public static List<g.xt> j(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : entrySet) {
                    arrayList.add(new g.xt(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return null;
    }

    public static com.bykv.vk.openvk.component.video.j.xt.xt.j j(com.bykv.vk.openvk.component.video.j.xt.up.j jVar, cw cwVar, String str, int i6) {
        String str2;
        String str3;
        com.bykv.vk.openvk.component.video.j.xt.xt.j query = cwVar.query(str, i6);
        if (query == null) {
            int j6 = j(jVar);
            String j7 = jVar.j("Content-Type", null);
            if (j6 > 0 && !TextUtils.isEmpty(j7)) {
                com.bykv.vk.openvk.component.video.j.xt.up.up ae = jVar.ae();
                String str4 = "";
                if (ae == null) {
                    str2 = "";
                    str3 = str2;
                } else {
                    str3 = ae.xt;
                    str2 = xt(ae.up);
                }
                String xt2 = xt(jVar.cw());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("requestUrl", str3);
                    jSONObject.put("requestHeaders", str2);
                    jSONObject.put("responseHeaders", xt2);
                    str4 = jSONObject.toString();
                } catch (Throwable unused) {
                }
                com.bykv.vk.openvk.component.video.j.xt.xt.j jVar2 = new com.bykv.vk.openvk.component.video.j.xt.xt.j(str, j7, j6, i6, str4);
                cwVar.insert(jVar2);
                return jVar2;
            }
        }
        return query;
    }
}
