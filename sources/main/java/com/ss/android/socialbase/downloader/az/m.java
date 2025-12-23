package com.ss.android.socialbase.downloader.az;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.by;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.cw.a;
import com.ss.android.socialbase.downloader.r.c;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class m {

    /* renamed from: g, reason: collision with root package name */
    private static ConnectivityManager f38681g = null;

    /* renamed from: j, reason: collision with root package name */
    private static final String f38682j = "m";
    private static Boolean oq;
    private static Boolean qv;
    private static final Pattern xt = Pattern.compile(".*\\d+ *- *(\\d+) */ *\\d+");
    private static String cw = null;

    /* renamed from: r, reason: collision with root package name */
    private static volatile SparseArray<Boolean> f38684r = new SparseArray<>();
    private static volatile SparseArray<List<c>> up = new SparseArray<>();

    /* renamed from: m, reason: collision with root package name */
    private static final char[] f38683m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static Pattern ae = null;
    private static Pattern tl = null;

    public static String ae(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if (charAt <= 31 || charAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static boolean cw(int i6) {
        return i6 == 200 || i6 == 201 || i6 == 0;
    }

    private static String g() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (com.ss.android.socialbase.downloader.m.j.j()) {
                    com.ss.android.socialbase.downloader.m.j.xt("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                j(bufferedReader);
                return sb2;
            } catch (Throwable unused) {
                j(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static double j(long j6) {
        return j6 / 1048576.0d;
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String r5 = r(com.ss.android.socialbase.downloader.downloader.cw.nd());
        return r5 != null && r5.equals(str);
    }

    private static String oq(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            if (ae == null) {
                ae = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
            }
            matcher = ae.matcher(str);
        } catch (Exception unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        if (tl == null) {
            tl = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");
        }
        Matcher matcher2 = tl.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    private static boolean qv(String str) {
        String str2 = f38682j;
        vl.xt(str2, "deleteDirIfEmpty on thread: " + Thread.currentThread());
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                if (file.delete()) {
                    return true;
                }
                vl.xt(str2, "deleteDirIfEmpty return false");
                return false;
            }
        }
        return false;
    }

    public static boolean r(int i6) {
        return i6 == 206 || i6 == 200;
    }

    public static boolean tl(Throwable th) {
        if (th == null) {
            return false;
        }
        if (th instanceof com.ss.android.socialbase.downloader.up.j) {
            com.ss.android.socialbase.downloader.up.j jVar = (com.ss.android.socialbase.downloader.up.j) th;
            int j6 = jVar.j();
            if (j6 == 1006) {
                return true;
            }
            if (j6 == 1023 || j6 == 1039 || j6 == 1040 || j6 == 1054 || j6 == 1064) {
                String message = jVar.getMessage();
                return !TextUtils.isEmpty(message) && message.contains("ENOSPC");
            }
        } else if (th instanceof IOException) {
            String oq2 = oq(th);
            if (!TextUtils.isEmpty(oq2) && oq2.contains("ENOSPC")) {
                return true;
            }
        }
        return false;
    }

    public static String up(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance(by.f10823a);
                    messageDigest.update(str.getBytes("UTF-8"));
                    return j(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static boolean xt(long j6) {
        return j6 == -1;
    }

    public static String cw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return String.format("%s.tp", str);
    }

    public static boolean j(int i6) {
        return i6 == 0 || i6 == 2;
    }

    public static boolean r(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        boolean z5 = false;
        if (cwVar.im() || !TextUtils.isEmpty(cwVar.zz())) {
            com.ss.android.socialbase.downloader.m.j.xt(f38682j, "dcache::curt=" + System.currentTimeMillis() + " expired=" + cwVar.ff());
            if (System.currentTimeMillis() > cwVar.ff()) {
                z5 = true;
            }
        } else {
            com.ss.android.socialbase.downloader.m.j.xt(f38682j, "dcache::last modify is emtpy, so just return cache");
        }
        com.ss.android.socialbase.downloader.m.j.xt(f38682j, "cacheExpired::dcache::name=" + cwVar.tl() + " expired=" + z5);
        return z5;
    }

    public static long xt(com.ss.android.socialbase.downloader.g.ae aeVar) {
        if (aeVar == null) {
            return -1L;
        }
        String xt2 = xt(aeVar, "Content-Range");
        if (TextUtils.isEmpty(xt2)) {
            return -1L;
        }
        try {
            Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(xt2);
            if (matcher.find()) {
                return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            }
        } catch (Exception e6) {
            com.ss.android.socialbase.downloader.m.j.r(f38682j, "parse content-length from content-range failed " + e6);
        }
        return -1L;
    }

    public static String j(byte[] bArr) {
        if (bArr != null) {
            return j(bArr, 0, bArr.length);
        }
        throw new NullPointerException("bytes is null");
    }

    public static void cw(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            vl.r(f38682j, "deleteFile: " + str + "/" + str2);
            file.delete();
        }
    }

    public static boolean m(Throwable th) {
        if (th == null) {
            return false;
        }
        String oq2 = oq(th);
        return !TextUtils.isEmpty(oq2) && oq2.contains("Requested Range Not Satisfiable");
    }

    public static String j(byte[] bArr, int i6, int i7) {
        if (bArr != null) {
            if (i6 >= 0 && i6 + i7 <= bArr.length) {
                int i8 = i7 * 2;
                char[] cArr = new char[i8];
                int i9 = 0;
                for (int i10 = 0; i10 < i7; i10++) {
                    byte b6 = bArr[i10 + i6];
                    int i11 = i9 + 1;
                    char[] cArr2 = f38683m;
                    cArr[i9] = cArr2[(b6 & 255) >> 4];
                    i9 += 2;
                    cArr[i11] = cArr2[b6 & 15];
                }
                return new String(cArr, 0, i8);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new NullPointerException("bytes is null");
    }

    public static long m(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return 0L;
        }
        List<com.ss.android.socialbase.downloader.ae.xt> cw2 = com.ss.android.socialbase.downloader.downloader.cw.x().cw(cwVar.ae());
        int kj = cwVar.kj();
        boolean z5 = kj > 1;
        if (!cwVar.xj()) {
            return 0L;
        }
        if (z5) {
            if (cw2 == null || kj != cw2.size()) {
                return 0L;
            }
            return xt(cw2);
        }
        return cwVar.uq();
    }

    private static String up(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        if (com.ss.android.socialbase.downloader.m.j.j()) {
                            com.ss.android.socialbase.downloader.m.j.xt("Process", "processName = " + runningAppProcessInfo.processName);
                        }
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Exception e6) {
            vl.j(e6);
        }
        return null;
    }

    public static boolean ae(Throwable th) {
        return com.ss.android.socialbase.downloader.downloader.cw.n().j(th);
    }

    private static String qv() {
        String str;
        Throwable th;
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, null);
            if (!(invoke instanceof String)) {
                return null;
            }
            str = (String) invoke;
            try {
                if (TextUtils.isEmpty(str) || !com.ss.android.socialbase.downloader.m.j.j()) {
                    return str;
                }
                com.ss.android.socialbase.downloader.m.j.xt("Process", "processName = " + str);
                return str;
            } catch (Throwable th2) {
                th = th2;
                vl.j(th);
                return str;
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
    }

    public static long r(String str) throws com.ss.android.socialbase.downloader.up.j {
        try {
            return new StatFs(str).getAvailableBytes();
        } catch (IllegalArgumentException e6) {
            throw new com.ss.android.socialbase.downloader.up.j(1050, e6);
        } catch (Throwable th) {
            throw new com.ss.android.socialbase.downloader.up.j(1052, th);
        }
    }

    public static File ae() {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (Exception unused) {
            str = "";
        }
        if ("mounted".equals(str)) {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        }
        return null;
    }

    public static boolean cw(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        return j(cwVar, cwVar.ri(), cwVar.rn());
    }

    public static boolean tl(String str) {
        Context nd;
        if (com.ss.android.socialbase.downloader.jy.j.cw().xt("save_path_security") > 0 && (nd = com.ss.android.socialbase.downloader.downloader.cw.nd()) != null && !TextUtils.isEmpty(str) && !str.startsWith("/data")) {
            if (!str.contains("Android/data/" + nd.getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public static boolean cw(com.ss.android.socialbase.downloader.g.ae aeVar) {
        if (aeVar == null) {
            return false;
        }
        return j.j(8) ? HttpHeaders.Values.CHUNKED.equals(aeVar.j("Transfer-Encoding")) || j(aeVar) == -1 : j(aeVar) == -1;
    }

    public static boolean g(Throwable th) {
        if (!(th instanceof com.ss.android.socialbase.downloader.up.j)) {
            return false;
        }
        int j6 = ((com.ss.android.socialbase.downloader.up.j) th).j();
        return j6 == 1055 || j6 == 1023 || j6 == 1041 || j6 == 1022 || j6 == 1048 || j6 == 1056 || j6 == 1057 || j6 == 1058 || j6 == 1059 || j6 == 1060 || j6 == 1061 || j6 == 1067 || j6 == 1049 || j6 == 1047 || j6 == 1051 || j6 == 1004 || j6 == 1011 || j6 == 1002 || j6 == 1013;
    }

    public static long xt(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                com.ss.android.socialbase.downloader.m.j.r(f38682j, "parse instance length failed with " + str);
            }
        }
        return -1L;
    }

    private static String oq() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            processName = Application.getProcessName();
            if (!TextUtils.isEmpty(processName) && com.ss.android.socialbase.downloader.m.j.j()) {
                com.ss.android.socialbase.downloader.m.j.xt("Process", "processName = " + processName);
            }
            return processName;
        } catch (Exception e6) {
            vl.j(e6);
            return null;
        }
    }

    public static boolean r(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return new File(str, str2).exists();
    }

    public static String m() {
        return j(com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).r(), false);
    }

    public static boolean cw(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager j6 = j(context);
            if (j6 == null || (activeNetworkInfo = j6.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static long g(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            Matcher matcher = Pattern.compile("max-age=([0-9]+)").matcher(str);
            if (matcher.find()) {
                try {
                    return Long.parseLong(matcher.group(1));
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        } catch (Throwable th2) {
            vl.j(th2);
        }
        return 0L;
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i6 * 2;
            try {
                bArr[i6] = (byte) (Integer.parseInt(str.substring(i7, i7 + 2), 16) & 255);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception e7) {
            vl.j(e7);
            return str;
        }
    }

    public static String r(Context context) {
        String str = cw;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String oq2 = oq();
        cw = oq2;
        if (!TextUtils.isEmpty(oq2)) {
            return cw;
        }
        String qv2 = qv();
        cw = qv2;
        if (!TextUtils.isEmpty(qv2)) {
            return cw;
        }
        String up2 = up(context);
        cw = up2;
        if (!TextUtils.isEmpty(up2)) {
            return cw;
        }
        String g6 = g();
        cw = g6;
        return g6;
    }

    public static boolean tl() {
        Context nd = com.ss.android.socialbase.downloader.downloader.cw.nd();
        return (nd == null || xt(nd) || !cw(nd)) ? false : true;
    }

    public static boolean up(Throwable th) {
        if (th == null) {
            return false;
        }
        String oq2 = oq(th);
        return !TextUtils.isEmpty(oq2) && oq2.contains("Precondition Failed");
    }

    public static String xt(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return null;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public static boolean cw() {
        Boolean bool = qv;
        if (bool != null) {
            return bool.booleanValue();
        }
        String r5 = r(com.ss.android.socialbase.downloader.downloader.cw.nd());
        if (r5 != null) {
            if (r5.equals(com.ss.android.socialbase.downloader.downloader.cw.nd().getPackageName() + ":downloader")) {
                qv = Boolean.TRUE;
                return qv.booleanValue();
            }
        }
        qv = Boolean.FALSE;
        return qv.booleanValue();
    }

    public static String oq(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            return th.toString();
        } catch (Throwable th2) {
            vl.j(th2);
            return "throwable getMsg error";
        }
    }

    public static com.ss.android.socialbase.downloader.xt.tl up(int i6) {
        com.ss.android.socialbase.downloader.xt.tl tlVar = com.ss.android.socialbase.downloader.xt.tl.MAIN;
        com.ss.android.socialbase.downloader.xt.tl tlVar2 = com.ss.android.socialbase.downloader.xt.tl.SUB;
        if (i6 == tlVar2.ordinal()) {
            return tlVar2;
        }
        com.ss.android.socialbase.downloader.xt.tl tlVar3 = com.ss.android.socialbase.downloader.xt.tl.NOTIFICATION;
        return i6 == tlVar3.ordinal() ? tlVar3 : tlVar;
    }

    public static long xt(List<com.ss.android.socialbase.downloader.ae.xt> list) {
        Iterator<com.ss.android.socialbase.downloader.ae.xt> it = list.iterator();
        long j6 = 0;
        while (it.hasNext()) {
            j6 += it.next().az();
        }
        return j6;
    }

    public static void xt(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        com.ss.android.socialbase.downloader.jy.j j6;
        JSONObject r5;
        if (cwVar == null || (r5 = (j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae())).r("download_dir")) == null) {
            return;
        }
        String optString = r5.optString("ins_desc");
        if (!TextUtils.isEmpty(optString)) {
            cw(cwVar.qv(), optString);
        }
        String g6 = cwVar.g();
        if (TextUtils.isEmpty(g6)) {
            g6 = cwVar.tl();
        }
        String j7 = j(g6, j6);
        String qv2 = cwVar.qv();
        if (TextUtils.isEmpty(j7) || TextUtils.isEmpty(qv2)) {
            return;
        }
        File file = new File(j7);
        for (File file2 = new File(qv2); file != null && file2 != null && file2.isDirectory() && TextUtils.equals(file.getName(), file2.getName()); file2 = file2.getParentFile()) {
            qv(file2.getPath());
            file = file.getParentFile();
        }
    }

    public static long up(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return -1L;
        }
        List<com.ss.android.socialbase.downloader.ae.xt> cw2 = com.ss.android.socialbase.downloader.downloader.cw.x().cw(cwVar.ae());
        if (cwVar.kj() == 1) {
            return cwVar.uq();
        }
        if (cw2 != null && cw2.size() > 1) {
            long r5 = r(cw2);
            if (r5 >= 0) {
                return r5;
            }
        }
        return 0L;
    }

    public static long j(com.ss.android.socialbase.downloader.g.ae aeVar) {
        if (aeVar == null) {
            return -1L;
        }
        String xt2 = xt(aeVar, "Content-Length");
        if (TextUtils.isEmpty(xt2) && j.j(1)) {
            return xt(aeVar);
        }
        try {
            return Long.parseLong(xt2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean cw(Throwable th) {
        if (th == null) {
            return false;
        }
        String oq2 = oq(th);
        return !TextUtils.isEmpty(oq2) && oq2.contains("network not available");
    }

    public static String j(com.ss.android.socialbase.downloader.g.ae aeVar, String str) {
        String oq2 = oq(aeVar.j("Content-Disposition"));
        return TextUtils.isEmpty(oq2) ? up(str) : oq2;
    }

    public static String up() {
        return j(com.ss.android.socialbase.downloader.downloader.ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).cw(), true);
    }

    public static boolean cw(com.ss.android.socialbase.downloader.up.j jVar) {
        if (jVar == null) {
            return false;
        }
        if (jVar.j() != 1011) {
            return jVar.getCause() != null && (jVar.getCause() instanceof SSLHandshakeException);
        }
        return true;
    }

    private static void cw(Throwable th, String str) throws com.ss.android.socialbase.downloader.up.tl {
        com.ss.android.socialbase.downloader.up.tl j6 = com.ss.android.socialbase.downloader.downloader.cw.n().j(th, null);
        if (j6 == null) {
            j6 = com.ss.android.socialbase.downloader.downloader.cw.n().j(th.getCause(), null);
        }
        if (j6 == null) {
            return;
        }
        throw new com.ss.android.socialbase.downloader.up.tl(j6.j(), xt(j6, str)).cw(j6.r());
    }

    public static boolean r() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static String up(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String up2 = up(str2);
        return (TextUtils.isEmpty(up2) || str.contains(up2)) ? str : new File(str, up2).getAbsolutePath();
    }

    public static boolean r(Throwable th) {
        if (th == null) {
            return false;
        }
        String oq2 = oq(th);
        return !TextUtils.isEmpty(oq2) && oq2.contains("Exception in connect");
    }

    public static com.ss.android.socialbase.downloader.ae.ae j(com.ss.android.socialbase.downloader.ae.cw cwVar, String str, String str2, int i6) throws com.ss.android.socialbase.downloader.up.j {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str, str2);
            boolean z5 = false;
            if (file.exists() && file.isDirectory()) {
                throw new com.ss.android.socialbase.downloader.up.j(1035, new IOException(String.format("path is :%s, path is directory:%B:", str, Boolean.valueOf(file.isDirectory()))));
            }
            if (!file.exists()) {
                try {
                    File file2 = new File(str);
                    if (!file2.exists() || !file2.isDirectory()) {
                        if (!file2.exists()) {
                            if (!file2.mkdirs() && !file2.exists()) {
                                if (com.ss.android.socialbase.downloader.jy.j.j(cwVar).j("opt_mkdir_failed", 0) != 1) {
                                    throw new com.ss.android.socialbase.downloader.up.j(1030, "download savePath directory can not created:" + str);
                                }
                                int i7 = 0;
                                while (!z5) {
                                    int i8 = i7 + 1;
                                    if (i7 >= 3) {
                                        break;
                                    }
                                    try {
                                        Thread.sleep(10L);
                                        z5 = file2.mkdirs();
                                        i7 = i8;
                                    } catch (InterruptedException unused) {
                                    }
                                }
                                if (!z5) {
                                    if (r(cwVar.qv()) < 16384) {
                                        throw new com.ss.android.socialbase.downloader.up.j(1006, "download savePath directory can not created:" + str);
                                    }
                                    throw new com.ss.android.socialbase.downloader.up.j(1030, "download savePath directory can not created:" + str);
                                }
                            }
                        } else {
                            file2.delete();
                            if (!file2.mkdirs() && !file2.exists()) {
                                throw new com.ss.android.socialbase.downloader.up.j(1031, "download savePath is not directory:path=" + str);
                            }
                            throw new com.ss.android.socialbase.downloader.up.j(1031, "download savePath is not directory:" + str);
                        }
                    }
                    file.createNewFile();
                } catch (IOException e6) {
                    throw new com.ss.android.socialbase.downloader.up.j(1036, e6);
                }
            }
            return new com.ss.android.socialbase.downloader.ae.ae(file, i6);
        }
        throw new com.ss.android.socialbase.downloader.up.j(1021, new IOException("path must be not empty"));
    }

    private static long r(List<com.ss.android.socialbase.downloader.ae.xt> list) {
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        long j6 = -1;
        for (com.ss.android.socialbase.downloader.ae.xt xtVar : list) {
            if (xtVar != null && (xtVar.ws() <= xtVar.av() || xtVar.av() == 0)) {
                if (j6 == -1 || j6 > xtVar.ws()) {
                    j6 = xtVar.ws();
                }
            }
        }
        return j6;
    }

    public static long cw(long j6) {
        return System.currentTimeMillis() - j6;
    }

    public static boolean cw(List<com.ss.android.socialbase.downloader.ae.up> list) {
        if (list != null && list.size() != 0) {
            for (com.ss.android.socialbase.downloader.ae.up upVar : list) {
                if (upVar != null && !TextUtils.isEmpty(upVar.j()) && !TextUtils.isEmpty(upVar.xt()) && "download-tc21-1-15".equals(upVar.j()) && "download-tc21-1-15".equals(upVar.xt())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean xt(String str, String str2, String str3) {
        return j(j(str, str2, str3));
    }

    public static String xt(int i6) {
        String str = "ttmd5 check code = " + i6 + ", ";
        if (i6 != 99) {
            switch (i6) {
                case 0:
                    return str + "md5 match";
                case 1:
                    return str + "md5 not match";
                case 2:
                    return str + "md5 empty";
                case 3:
                    return str + "ttmd5 version not support";
                case 4:
                    return str + "ttmd5 tag parser error";
                case 5:
                    return str + "file not exist";
                case 6:
                    return str + "get file md5 error";
                default:
                    return str;
            }
        }
        return str + "unknown error";
    }

    @TargetApi(19)
    private static void xt(File file, File file2, boolean z5) throws IOException {
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileChannel channel = fileInputStream.getChannel();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileOutputStream.getChannel();
                    try {
                        long size = channel.size();
                        long j6 = 0;
                        while (j6 < size) {
                            long j7 = size - j6;
                            if (j7 > 31457280) {
                                j7 = 31457280;
                            }
                            long transferFrom = channel2.transferFrom(channel, j6, j7);
                            if (transferFrom == 0) {
                                break;
                            } else {
                                j6 += transferFrom;
                            }
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        fileOutputStream.close();
                        channel.close();
                        fileInputStream.close();
                        long length = file.length();
                        long length2 = file2.length();
                        if (length == length2) {
                            if (z5) {
                                file2.setLastModified(file.lastModified());
                                return;
                            }
                            return;
                        }
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static List<com.ss.android.socialbase.downloader.ae.xt> j(List<com.ss.android.socialbase.downloader.ae.xt> list) {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = new SparseArray();
        for (com.ss.android.socialbase.downloader.ae.xt xtVar : list) {
            if (xtVar != null) {
                if (xtVar.r()) {
                    sparseArray.put(xtVar.mi(), xtVar);
                    List<com.ss.android.socialbase.downloader.ae.xt> list2 = (List) sparseArray2.get(xtVar.mi());
                    if (list2 != null) {
                        Iterator<com.ss.android.socialbase.downloader.ae.xt> it = list2.iterator();
                        while (it.hasNext()) {
                            it.next().j(xtVar);
                        }
                        xtVar.j(list2);
                    }
                } else {
                    com.ss.android.socialbase.downloader.ae.xt xtVar2 = (com.ss.android.socialbase.downloader.ae.xt) sparseArray.get(xtVar.xt());
                    if (xtVar2 != null) {
                        List<com.ss.android.socialbase.downloader.ae.xt> ae2 = xtVar2.ae();
                        if (ae2 == null) {
                            ae2 = new ArrayList<>();
                            xtVar2.j(ae2);
                        }
                        xtVar.j(xtVar2);
                        ae2.add(xtVar);
                    } else {
                        List list3 = (List) sparseArray2.get(xtVar.xt());
                        if (list3 == null) {
                            list3 = new ArrayList();
                            sparseArray2.put(xtVar.xt(), list3);
                        }
                        list3.add(xtVar);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i6)));
        }
        return arrayList.isEmpty() ? list : arrayList;
    }

    public static boolean xt(File file, File file2) throws com.ss.android.socialbase.downloader.up.j {
        String str = f38682j;
        vl.r(str, "moveFile1: src:" + file.getPath() + " dest:" + file2.getPath());
        boolean renameTo = file.renameTo(file2);
        if (!renameTo) {
            renameTo = j(file, file2);
            try {
                vl.r(str, "moveFile2: src:" + file.getPath() + " dest:" + file2.getPath());
                file.delete();
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        return renameTo;
    }

    public static boolean xt(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager j6 = j(context);
            if (j6 != null && (activeNetworkInfo = j6.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                if (1 == activeNetworkInfo.getType()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static String j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return String.format("%s%s%s", str, File.separator, str2);
    }

    public static boolean xt() {
        return !cw() && com.ss.android.socialbase.downloader.downloader.cw.xt() && com.ss.android.socialbase.downloader.impls.vl.j(true).ae();
    }

    public static void j(com.ss.android.socialbase.downloader.ae.cw cwVar) {
        j(cwVar, true);
    }

    public static boolean xt(Throwable th) {
        if (th == null) {
            return false;
        }
        String oq2 = oq(th);
        if (!(th instanceof com.ss.android.socialbase.downloader.up.cw) || (((com.ss.android.socialbase.downloader.up.cw) th).r() != 403 && (TextUtils.isEmpty(oq2) || !oq2.contains("403")))) {
            return !TextUtils.isEmpty(oq2) && oq2.contains("Forbidden");
        }
        return true;
    }

    public static void j(com.ss.android.socialbase.downloader.ae.cw cwVar, boolean z5) {
        if (cwVar == null) {
            return;
        }
        if (z5) {
            try {
                cw(cwVar.qv(), cwVar.tl());
            } catch (Throwable th) {
                vl.j(th);
                return;
            }
        }
        cw(cwVar.vl(), cwVar.jy());
        if (cwVar.ag()) {
            xt(cwVar);
        }
        if (z5) {
            String up2 = up(cwVar.oq());
            if (TextUtils.isEmpty(up2) || TextUtils.isEmpty(cwVar.qv()) || !cwVar.qv().contains(up2)) {
                return;
            }
            qv(cwVar.qv());
        }
    }

    public static boolean xt(com.ss.android.socialbase.downloader.up.j jVar) {
        if (!(jVar instanceof com.ss.android.socialbase.downloader.up.cw)) {
            return false;
        }
        com.ss.android.socialbase.downloader.up.cw cwVar = (com.ss.android.socialbase.downloader.up.cw) jVar;
        return cwVar.r() == 412 || cwVar.r() == 416;
    }

    public static String xt(Throwable th, String str) {
        if (str == null) {
            return oq(th);
        }
        return str + "-" + oq(th);
    }

    public static void xt(List<com.ss.android.socialbase.downloader.ae.up> list, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        long lv = cwVar.lv();
        if (lv > 300) {
            list.add(new com.ss.android.socialbase.downloader.ae.up("extra_ttnet_protect_timeout", String.valueOf(lv)));
        }
    }

    public static boolean j(Context context, String str) {
        return (context == null || TextUtils.isEmpty(str) || context.checkCallingOrSelfPermission(str) != 0) ? false : true;
    }

    public static String xt(com.ss.android.socialbase.downloader.g.ae aeVar, String str) {
        if (aeVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String j6 = aeVar.j(str);
        if (!com.ss.android.socialbase.downloader.jy.j.cw().xt("fix_get_http_resp_head_ignore_case", true)) {
            return j6;
        }
        if (TextUtils.isEmpty(j6)) {
            j6 = aeVar.j(str.toLowerCase());
        }
        return TextUtils.isEmpty(j6) ? aeVar.j(str.toUpperCase()) : j6;
    }

    public static boolean j(com.ss.android.socialbase.downloader.ae.cw cwVar, boolean z5, String str) {
        if (!z5 && !TextUtils.isEmpty(cwVar.qv()) && !TextUtils.isEmpty(cwVar.tl())) {
            try {
                if (new File(cwVar.qv(), cwVar.tl()).exists()) {
                    if (xt(cwVar.qv(), cwVar.tl(), str)) {
                        return true;
                    }
                }
            } catch (OutOfMemoryError e6) {
                vl.j(e6);
            }
        }
        return false;
    }

    public static int j(String str, String str2, String str3) {
        return a.a(str3, new File(str, str2));
    }

    public static boolean xt(com.ss.android.socialbase.downloader.up.j jVar, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        return cwVar != null && cwVar.x() && cw(com.ss.android.socialbase.downloader.downloader.cw.nd());
    }

    public static int j(File file, String str) {
        return a.a(str, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(com.ss.android.socialbase.downloader.ae.cw r22, com.ss.android.socialbase.downloader.r.l r23, com.ss.android.socialbase.downloader.r.c r24) {
        /*
            Method dump skipped, instructions count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.az.m.j(com.ss.android.socialbase.downloader.ae.cw, com.ss.android.socialbase.downloader.r.l, com.ss.android.socialbase.downloader.r.c):void");
    }

    private static void j(int i6, boolean z5, com.ss.android.socialbase.downloader.up.j jVar) {
        synchronized (f38684r) {
            try {
                List<c> list = up.get(i6);
                if (list != null) {
                    for (c cVar : list) {
                        if (cVar != null) {
                            if (z5) {
                                cVar.j();
                            } else {
                                cVar.j(jVar);
                            }
                        }
                    }
                }
                com.ss.android.socialbase.downloader.m.j.xt(f38682j, "handleTempSaveCallback id:" + i6);
                f38684r.remove(i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void j(com.ss.android.socialbase.downloader.ae.cw cwVar, String str) throws com.ss.android.socialbase.downloader.up.j {
        if (cwVar == null || TextUtils.isEmpty(str) || str.equals(cwVar.tl())) {
            return;
        }
        File file = new File(cwVar.qv(), str);
        File file2 = new File(cwVar.qv(), cwVar.tl());
        vl.r(f38682j, "copyFileFromExistFileWithSameName: existFile:" + file.getPath() + " targetFile:" + file2.getPath());
        if (file2.exists() && !file2.canWrite()) {
            throw new com.ss.android.socialbase.downloader.up.j(1001, "targetPath file exists but read-only");
        }
        if (!j(file, file2)) {
            throw new com.ss.android.socialbase.downloader.up.j(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", cwVar.qv(), str, cwVar.qv(), cwVar.tl()));
        }
    }

    public static boolean j(File file, File file2) throws com.ss.android.socialbase.downloader.up.j {
        return j(file, file2, true);
    }

    public static boolean j(File file, File file2, boolean z5) throws com.ss.android.socialbase.downloader.up.j {
        if (file != null && file2 != null) {
            try {
                if (file.exists() && !file.isDirectory() && !file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    File parentFile = file2.getParentFile();
                    if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                        throw new com.ss.android.socialbase.downloader.up.j(1053, "Destination '" + parentFile + "' directory cannot be created");
                    }
                    vl.r(f38682j, "copyFile: srcFile:" + file.getPath() + " destFile:" + file2.getPath());
                    if (file2.exists() && !file2.canWrite()) {
                        throw new IOException("Destination '" + file2 + "' exists but is read-only");
                    }
                    xt(file, file2, z5);
                    return true;
                }
            } catch (com.ss.android.socialbase.downloader.up.j e6) {
                throw e6;
            } catch (Throwable th) {
                j(th, "CopyFile");
                return false;
            }
        }
        return false;
    }

    public static boolean j(int i6, String str) {
        if (j.j(16777216)) {
            return i6 == 206 || i6 == 1;
        }
        if (i6 >= 400) {
            return false;
        }
        return i6 == 206 || i6 == 1 || "bytes".equals(str);
    }

    public static List<com.ss.android.socialbase.downloader.ae.up> j(List<com.ss.android.socialbase.downloader.ae.up> list, String str, com.ss.android.socialbase.downloader.ae.xt xtVar) {
        return j(list, str, xtVar.jy(), xtVar.av());
    }

    public static List<com.ss.android.socialbase.downloader.ae.up> j(List<com.ss.android.socialbase.downloader.ae.up> list, String str, long j6, long j7) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.ae.up upVar : list) {
                if (upVar != null) {
                    arrayList.add(upVar);
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new com.ss.android.socialbase.downloader.ae.up("If-Match", str));
        }
        arrayList.add(new com.ss.android.socialbase.downloader.ae.up("Accept-Encoding", "identity"));
        String format = j7 <= 0 ? String.format("bytes=%s-", String.valueOf(j6)) : String.format("bytes=%s-%s", String.valueOf(j6), String.valueOf(j7));
        arrayList.add(new com.ss.android.socialbase.downloader.ae.up("Range", format));
        com.ss.android.socialbase.downloader.m.j.xt(f38682j, " range CurrentOffset:" + j6 + " EndOffset:" + j7 + ", range = " + format);
        return arrayList;
    }

    public static boolean j(int i6, String str, String str2) {
        return i6 == -3 && !r(str, str2);
    }

    public static ConnectivityManager j(Context context) {
        ConnectivityManager connectivityManager = f38681g;
        if (connectivityManager != null) {
            return connectivityManager;
        }
        ConnectivityManager connectivityManager2 = (ConnectivityManager) context.getSystemService("connectivity");
        f38681g = connectivityManager2;
        return connectivityManager2;
    }

    public static boolean j() {
        Boolean bool = oq;
        if (bool != null) {
            return bool.booleanValue();
        }
        String r5 = r(com.ss.android.socialbase.downloader.downloader.cw.nd());
        boolean z5 = (r5 == null || !r5.contains(":")) && r5 != null && r5.equals(com.ss.android.socialbase.downloader.downloader.cw.nd().getPackageName());
        oq = Boolean.valueOf(z5);
        return z5;
    }

    public static boolean j(Throwable th) {
        if (th == null) {
            return false;
        }
        String oq2 = oq(th);
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        return !TextUtils.isEmpty(oq2) && (oq2.contains("time out") || oq2.contains("Time-out"));
    }

    public static boolean j(com.ss.android.socialbase.downloader.up.j jVar) {
        return jVar != null && jVar.j() == 1051;
    }

    public static void j(Throwable th, String str) throws com.ss.android.socialbase.downloader.up.j {
        String str2 = !TextUtils.isEmpty(str) ? str : "";
        if (!(th instanceof com.ss.android.socialbase.downloader.up.j)) {
            if (!(th instanceof SSLHandshakeException)) {
                if (!j(th)) {
                    if (!up(th)) {
                        if (!m(th)) {
                            if (!xt(th)) {
                                if (!cw(th)) {
                                    if (!r(th)) {
                                        if (th instanceof IOException) {
                                            cw(th, str);
                                            j((IOException) th, str);
                                            return;
                                        }
                                        throw new com.ss.android.socialbase.downloader.up.j(1000, xt(th, str2));
                                    }
                                    throw new com.ss.android.socialbase.downloader.up.j(1041, xt(th, str2));
                                }
                                throw new com.ss.android.socialbase.downloader.up.j(1049, xt(th, str2));
                            }
                            throw new com.ss.android.socialbase.downloader.up.j(1047, xt(th, str2));
                        }
                        throw new com.ss.android.socialbase.downloader.up.cw(1004, TTAdConstant.LIVE_AD_CODE, xt(th, str2));
                    }
                    throw new com.ss.android.socialbase.downloader.up.cw(1004, 412, xt(th, str2));
                }
                throw new com.ss.android.socialbase.downloader.up.j(1048, xt(th, str2));
            }
            throw new com.ss.android.socialbase.downloader.up.j(1011, xt(th, str2));
        }
        com.ss.android.socialbase.downloader.up.j jVar = (com.ss.android.socialbase.downloader.up.j) th;
        jVar.j(str2 + "-" + jVar.xt());
        throw jVar;
    }

    public static void j(IOException iOException, String str) throws com.ss.android.socialbase.downloader.up.j {
        if (str == null) {
            str = "";
        }
        String xt2 = xt(iOException, str);
        if (!(iOException instanceof ConnectException)) {
            if (!(iOException instanceof UnknownHostException)) {
                if (!(iOException instanceof NoRouteToHostException)) {
                    if (!(iOException instanceof UnknownServiceException)) {
                        if (!(iOException instanceof PortUnreachableException)) {
                            if (!(iOException instanceof SocketTimeoutException)) {
                                if (!(iOException instanceof SocketException)) {
                                    if (!(iOException instanceof HttpRetryException)) {
                                        if (!(iOException instanceof ProtocolException)) {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                if (!(iOException instanceof FileNotFoundException)) {
                                                    if (!(iOException instanceof InterruptedIOException)) {
                                                        if (!(iOException instanceof UnsupportedEncodingException)) {
                                                            if (!(iOException instanceof EOFException)) {
                                                                if (!(iOException instanceof StreamResetException)) {
                                                                    if (!(iOException instanceof SSLException)) {
                                                                        if (tl(iOException)) {
                                                                            throw new com.ss.android.socialbase.downloader.up.j(1006, xt2);
                                                                        }
                                                                        throw new com.ss.android.socialbase.downloader.up.j(1023, xt2);
                                                                    }
                                                                    throw new com.ss.android.socialbase.downloader.up.j(1011, xt2);
                                                                }
                                                                throw new com.ss.android.socialbase.downloader.up.j(1067, xt2);
                                                            }
                                                            throw new com.ss.android.socialbase.downloader.up.j(1066, xt2);
                                                        }
                                                        throw new com.ss.android.socialbase.downloader.up.j(1065, xt2);
                                                    }
                                                    throw new com.ss.android.socialbase.downloader.up.j(1064, xt2);
                                                }
                                                throw new com.ss.android.socialbase.downloader.up.j(1063, xt2);
                                            }
                                            throw new com.ss.android.socialbase.downloader.up.j(1062, xt2);
                                        }
                                        throw new com.ss.android.socialbase.downloader.up.j(1061, xt2);
                                    }
                                    throw new com.ss.android.socialbase.downloader.up.j(1060, xt2);
                                }
                                throw new com.ss.android.socialbase.downloader.up.j(1059, xt2);
                            }
                            throw new com.ss.android.socialbase.downloader.up.j(1048, xt2);
                        }
                        throw new com.ss.android.socialbase.downloader.up.j(1058, xt2);
                    }
                    throw new com.ss.android.socialbase.downloader.up.j(1057, xt2);
                }
                throw new com.ss.android.socialbase.downloader.up.j(1056, xt2);
            }
            throw new com.ss.android.socialbase.downloader.up.j(1055, xt2);
        }
        throw new com.ss.android.socialbase.downloader.up.j(1041, xt2);
    }

    public static boolean j(com.ss.android.socialbase.downloader.up.j jVar, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (jVar == null) {
            return false;
        }
        int j6 = jVar.j();
        if (j6 == 1000 || j6 == 1032 || j6 == 1033 || j6 == 1034 || j6 == 1008 || j6 == 1026 || j6 == 1027 || j6 == 1044 || j6 == 1020) {
            return true;
        }
        return (j6 == 1049 || j6 == 1055 || j6 == 1006 || cwVar == null || cwVar.uq() >= 8388608) ? false : true;
    }

    public static <K> HashMap<Integer, K> j(SparseArray<K> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        HashMap<Integer, K> hashMap = new HashMap<>();
        int size = sparseArray.size();
        for (int i6 = 0; i6 < size; i6++) {
            int keyAt = sparseArray.keyAt(i6);
            hashMap.put(Integer.valueOf(keyAt), sparseArray.valueAt(i6));
        }
        return hashMap;
    }

    public static <K> void j(SparseArray<K> sparseArray, Map<Integer, K> map) {
        if (map == null || sparseArray == null) {
            return;
        }
        for (Integer num : map.keySet()) {
            if (num != null) {
                sparseArray.put(num.intValue(), map.get(num));
            }
        }
    }

    public static boolean j(List<com.ss.android.socialbase.downloader.ae.up> list, List<com.ss.android.socialbase.downloader.ae.up> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static void j(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }
    }

    public static void j(Cursor... cursorArr) {
        if (cursorArr == null) {
            return;
        }
        for (Cursor cursor : cursorArr) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    vl.j(th);
                }
            }
        }
    }

    public static String j(String str, int i6) {
        if (i6 == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i6) ? str : str.substring(0, i6);
    }

    public static String j(String str, com.ss.android.socialbase.downloader.jy.j jVar) {
        JSONObject r5;
        if (jVar != null && (r5 = jVar.r("download_dir")) != null) {
            String optString = r5.optString("dir_name");
            if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
                optString = optString.substring(1);
            }
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            if (!optString.contains("%s")) {
                optString = optString + str;
            } else {
                try {
                    optString = String.format(optString, str);
                } catch (Throwable unused) {
                }
            }
            return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
    
        if (r1 != false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        if (com.ss.android.socialbase.downloader.jy.j.cw().xt("fix_save_external_dir") > 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        r4 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(r0, android.os.Environment.DIRECTORY_DOWNLOADS);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (j(r4) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        return r4.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:
    
        if (r4 > 29) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String j(java.io.File r4, boolean r5) {
        /*
            android.content.Context r0 = com.ss.android.socialbase.downloader.downloader.cw.nd()
            boolean r1 = j(r4)
            if (r1 == 0) goto Lf
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        Lf:
            android.content.pm.ApplicationInfo r4 = r0.getApplicationInfo()
            int r4 = r4.targetSdkVersion
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "fix_save_external_dir"
            r3 = 29
            if (r1 < r3) goto L42
            if (r4 != r3) goto L25
            boolean r1 = com.bumptech.glide.load.model.stream.g.a()
            if (r1 == 0) goto L27
        L25:
            if (r4 <= r3) goto L42
        L27:
            com.ss.android.socialbase.downloader.jy.j r4 = com.ss.android.socialbase.downloader.jy.j.cw()
            int r4 = r4.xt(r2)
            if (r4 > 0) goto L6e
            java.lang.String r4 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r4 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(r0, r4)
            boolean r5 = j(r4)
            if (r5 == 0) goto L6e
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        L42:
            if (r5 == 0) goto L53
            java.io.File r4 = ae()
            boolean r5 = j(r4)
            if (r5 == 0) goto L53
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        L53:
            com.ss.android.socialbase.downloader.jy.j r4 = com.ss.android.socialbase.downloader.jy.j.cw()
            int r4 = r4.xt(r2)
            if (r4 > 0) goto L6e
            java.lang.String r4 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.io.File r4 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(r0, r4)
            boolean r5 = j(r4)
            if (r5 == 0) goto L6e
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        L6e:
            java.io.File r4 = com.bytedance.sdk.openadsdk.api.plugin.xt.j(r0)
            java.lang.String r4 = r4.getAbsolutePath()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.az.m.j(java.io.File, boolean):java.lang.String");
    }

    public static boolean j(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.exists() || file.mkdirs()) {
                return file.isDirectory();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void j(List<com.ss.android.socialbase.downloader.ae.up> list, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        long sh = cwVar.sh();
        if (sh > 0) {
            list.add(new com.ss.android.socialbase.downloader.ae.up("extra_throttle_net_speed", String.valueOf(sh)));
        }
    }

    public static int j(Object obj, int i6) {
        try {
            return ((Integer) obj).intValue();
        } catch (ClassCastException unused) {
            return i6;
        }
    }

    public static String j(Object obj, String str) {
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            return str;
        }
    }

    public static boolean j(Object obj, boolean z5) {
        try {
            return ((Boolean) obj).booleanValue();
        } catch (ClassCastException unused) {
            return z5;
        }
    }
}
