package com.kwad.framework.filedownloader.f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.by;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.sdk.utils.ay;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f {
    private static int apM = 65536;
    private static long apN = 2000;
    private static String apO;
    private static Boolean apP;
    private static Boolean apQ;
    private static final Pattern apR = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static String a(String str, boolean z5, String str2) {
        if (str == null) {
            return null;
        }
        if (!z5) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return A(str, str2);
    }

    public static long b(int i6, com.kwad.framework.filedownloader.a.b bVar) {
        long bI = bI(bVar.bn("Content-Length"));
        String bn = bVar.bn("Transfer-Encoding");
        if (bI >= 0) {
            return bI;
        }
        if (bn != null && bn.equals(HttpHeaders.Values.CHUNKED)) {
            return -1L;
        }
        if (!e.zB().apG) {
            throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
        }
        if (d.apD) {
            d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i6));
        }
        return -1L;
    }

    public static String bD(String str) {
        return c("%s.temp", str);
    }

    public static String bE(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = apR.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String zH() {
        return c("FileDownloader/%s", BuildConfig.VERSION_NAME);
    }

    private static String A(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return c("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static String a(int i6, com.kwad.framework.filedownloader.a.b bVar) {
        if (bVar == null) {
            throw new RuntimeException("connection is null when findEtag");
        }
        String bn = bVar.bn("Etag");
        if (d.apD) {
            d.c(f.class, "etag find %s for task(%d)", bn, Integer.valueOf(i6));
        }
        return bn;
    }

    public static boolean aJ(Context context) {
        boolean endsWith;
        Boolean bool = apP;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.zB().apH) {
            endsWith = true;
        } else {
            if (((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
                d.d(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            endsWith = ay.getProcessName(context).endsWith(":filedownloader");
        }
        apP = Boolean.valueOf(endsWith);
        return endsWith;
    }

    private static File aL(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String bG(String str) {
        return "FileDownloader-" + str;
    }

    private static long bI(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    private static void bK(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bL(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String c(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String md5(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(by.f10823a).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b6 : digest) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i6));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e6) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e6);
        } catch (NoSuchAlgorithmException e7) {
            throw new RuntimeException("Huh, MD5 should be supported?", e7);
        }
    }

    private static int zD() {
        return apM;
    }

    private static long zE() {
        return apN;
    }

    private static String zF() {
        return !TextUtils.isEmpty(apO) ? apO : c.zz().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory().getAbsolutePath() : c.zz().getExternalCacheDir().getAbsolutePath();
    }

    public static int B(String str, String str2) {
        return com.kwad.framework.filedownloader.download.b.yc().yd().g(str, str2, false);
    }

    public static void C(String str, String str2) {
        bK(str2);
        bL(str);
    }

    public static void aK(Context context) {
        File aL = aL(context);
        try {
            aL.getParentFile().mkdirs();
            aL.createNewFile();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public static void ac(long j6) {
        if (aJ(c.zz())) {
            apN = j6;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    public static String bB(String str) {
        return A(zF(), bC(str));
    }

    private static String bC(String str) {
        return md5(str);
    }

    public static String bF(String str) {
        int i6;
        int length = str.length();
        char c6 = File.separatorChar;
        int i7 = 2;
        if (c6 == '\\' && length > 2 && str.charAt(1) == ':') {
            i6 = 2;
        } else {
            i6 = 0;
        }
        int lastIndexOf = str.lastIndexOf(c6);
        if (lastIndexOf != -1 || i6 <= 0) {
            i7 = lastIndexOf;
        }
        if (i7 != -1 && str.charAt(length - 1) != c6) {
            if (str.indexOf(c6) == i7 && str.charAt(i6) == c6) {
                return str.substring(0, i7 + 1);
            }
            return str.substring(0, i7);
        }
        return null;
    }

    public static boolean bH(String str) {
        if (c.zz().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static com.kwad.framework.filedownloader.e.a bJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                file.delete();
                if (!file.createNewFile()) {
                    throw new RuntimeException(c("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
                }
            }
            if (!file.exists() && !file.createNewFile()) {
                throw new IOException(c("create new file error  %s", file.getAbsolutePath()));
            }
            return com.kwad.framework.filedownloader.download.b.yc().b(file);
        }
        throw new RuntimeException("found invalid internal destination path, empty");
    }

    public static void cf(int i6) {
        if (aJ(c.zz())) {
            apM = i6;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static int g(String str, String str2, boolean z5) {
        return com.kwad.framework.filedownloader.download.b.yc().yd().g(str, str2, z5);
    }

    public static boolean i(long j6, long j7) {
        if (j6 > zD() && j7 > zE()) {
            return true;
        }
        return false;
    }

    public static boolean zG() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.zz().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            return false;
        }
        return true;
    }

    public static String a(com.kwad.framework.filedownloader.a.b bVar, String str) {
        String bE = bE(bVar.bn("Content-Disposition"));
        if (TextUtils.isEmpty(bE)) {
            bE = bC(str);
        }
        return bE.replaceAll("\\/", "_");
    }

    public static boolean b(int i6, com.kwad.framework.filedownloader.d.c cVar) {
        return a(i6, cVar, (Boolean) null);
    }

    private static boolean a(int i6, com.kwad.framework.filedownloader.d.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.apD) {
                d.c(f.class, "can't continue %d model == null", Integer.valueOf(i6));
            }
            return false;
        }
        if (cVar.yr() == null) {
            if (d.apD) {
                d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i6));
            }
            return false;
        }
        return a(i6, cVar, cVar.yr(), null);
    }

    public static boolean a(int i6, com.kwad.framework.filedownloader.d.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (d.apD) {
                d.c(f.class, "can't continue %d path = null", Integer.valueOf(i6));
                return false;
            }
        } else {
            File file = new File(str);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (exists && !isDirectory) {
                long length = file.length();
                long yZ = cVar.yZ();
                if (cVar.zc() <= 1 && yZ == 0) {
                    if (d.apD) {
                        d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i6));
                        return false;
                    }
                } else {
                    long total = cVar.getTotal();
                    if (length >= yZ && (total == -1 || (length <= total && yZ < total))) {
                        if (bool == null || bool.booleanValue() || total != length) {
                            return true;
                        }
                        if (d.apD) {
                            d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i6));
                            return false;
                        }
                    } else if (d.apD) {
                        d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i6), Long.valueOf(length), Long.valueOf(yZ), Long.valueOf(total));
                        return false;
                    }
                }
            } else if (d.apD) {
                d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i6), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
            }
        }
        return false;
    }
}
