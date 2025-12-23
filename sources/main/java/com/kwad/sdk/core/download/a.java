package com.kwad.sdk.core.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.be;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;
    private static volatile boolean mHasInit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.download.a$a, reason: collision with other inner class name */
    public interface InterfaceC0681a {
    }

    public static void I(@NonNull AdInfo adInfo) {
        a(adInfo, false);
    }

    private static void a(@NonNull AdInfo adInfo, boolean z5) {
        try {
            Context context = mContext;
            if (context == null) {
                return;
            }
            if (!ao.isNetworkConnected(context)) {
                Context context2 = mContext;
                ac.Q(context2, ae.cP(context2));
                return;
            }
            DownloadParams transform = DownloadParams.transform(adInfo);
            transform.requestInstallPermission = false;
            String str = transform.mFileUrl;
            if (!TextUtils.isEmpty(str) && URLUtil.isNetworkUrl(str)) {
                DownloadTask.DownloadRequest downloadRequest = new DownloadTask.DownloadRequest(transform.mFileUrl);
                downloadRequest.setDestinationFileName(dK(str));
                downloadRequest.setTag(transform);
                downloadRequest.setDownloadEnablePause(transform.downloadEnablePause);
                if (ServiceProvider.getSDKConfig().showNotification && bw(mContext)) {
                    downloadRequest.setNotificationVisibility(3);
                } else {
                    downloadRequest.setNotificationVisibility(0);
                }
                com.kwad.sdk.d.a.a(mContext, transform.mDownloadid, downloadRequest);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static boolean d(String str, File file) {
        try {
            return a(str, file, null, false);
        } catch (IOException e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public static synchronized void bv(Context context) {
        synchronized (a.class) {
            if (context != null) {
                if (!mHasInit) {
                    mContext = context;
                    com.kwad.sdk.c.AA().init(context);
                    b.GR().init(context);
                    mHasInit = true;
                }
            }
        }
    }

    private static boolean bw(Context context) {
        try {
            new NotificationCompat.Builder(context, "");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String dJ(String str) {
        if (mContext == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return be.dF(mContext) + File.separator + dK(str);
    }

    private static String dK(String str) {
        return al.md5(str) + ".apk";
    }

    public static void dL(String str) {
        if (mContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.d.a.E(mContext, str);
    }

    public static void dM(String str) {
        if (mContext == null) {
            return;
        }
        String dJ = dJ(str);
        com.kwad.sdk.d.a.e(mContext, al.md5(str), dJ);
    }

    private static URLConnection dN(String str) {
        URLConnection openConnection = new URL(str).openConnection();
        r.wrapHttpURLConnection(openConnection);
        openConnection.setRequestProperty("Accept-Language", "zh-CN");
        openConnection.setConnectTimeout(10000);
        openConnection.setReadTimeout(120000);
        openConnection.setUseCaches(false);
        openConnection.setDoInput(true);
        openConnection.setRequestProperty("Connection", "keep-alive");
        openConnection.setRequestProperty("Charset", "UTF-8");
        return openConnection;
    }

    @Nullable
    public static String H(AdInfo adInfo) {
        return dJ(DownloadParams.transform(adInfo).mFileUrl);
    }

    public static void a(String str, File file, boolean z5) {
        a(str, file, null, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011a A[Catch: all -> 0x011d, TryCatch #8 {all -> 0x011d, blocks: (B:16:0x0116, B:18:0x011a, B:22:0x0145, B:21:0x011f), top: B:15:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011f A[Catch: all -> 0x011d, TryCatch #8 {all -> 0x011d, blocks: (B:16:0x0116, B:18:0x011a, B:22:0x0145, B:21:0x011f), top: B:15:0x0116 }] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r10, java.io.File r11, com.kwad.sdk.core.download.a.InterfaceC0681a r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a(java.lang.String, java.io.File, com.kwad.sdk.core.download.a$a, boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0008, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.InputStream a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r3, java.io.InputStream r4) {
        /*
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L8:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L51
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "Content-Encoding"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L8
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L8
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L8
            java.util.Iterator r0 = r0.iterator()
        L34:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "gzip"
            boolean r1 = r2.equalsIgnoreCase(r1)
            if (r1 == 0) goto L34
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch: java.io.IOException -> L4f
            r0.<init>(r4)     // Catch: java.io.IOException -> L4f
            r4 = r0
            goto L51
        L4f:
            goto L8
        L51:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.download.a.a(java.util.Map, java.io.InputStream):java.io.InputStream");
    }
}
