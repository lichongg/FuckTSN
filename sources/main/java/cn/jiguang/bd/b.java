package cn.jiguang.bd;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import cn.jiguang.net.SSLTrustManager;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import javax.net.ssl.X509TrustManager;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static SSLTrustManager f1984a;

    public static g a(Context context, String str, byte[] bArr, int i6, int i7, int i8, Set<String> set) {
        try {
            HttpRequest httpRequest = new HttpRequest(str);
            httpRequest.setType(set.toString());
            a(httpRequest, context, bArr, i6, i8);
            while (i7 > 0) {
                i7--;
                HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                int responseCode = httpPost.getResponseCode();
                cn.jiguang.bb.f.d("HttpHelper", "status code:" + responseCode + " retry left:" + i7);
                if (responseCode == 200) {
                    return new g(0, httpPost.getResponseBody());
                }
                if (responseCode == 401) {
                    return new g(-3, httpPost.getResponseBody());
                }
                if (responseCode == 404 || responseCode == 410 || responseCode == 429) {
                    return new g(-1, httpPost.getResponseBody());
                }
                if (responseCode == 503) {
                    return new g(-2, httpPost.getResponseBody());
                }
                if (responseCode != 3005) {
                    return responseCode >= 500 ? new g(-1, httpPost.getResponseBody()) : new g(-2, httpPost.getResponseBody());
                }
            }
            return new g(-2, "Failed - retry enough");
        } catch (AssertionError e6) {
            return new g(-2, "Catch AssertionError to avoid http close crash - " + e6.getMessage());
        } catch (Exception e7) {
            return new g(-2, "Exception - " + e7.getMessage());
        } catch (Throwable th) {
            return new g(-2, "Exception - " + th.getMessage());
        }
    }

    public static g a(String str, String str2, Context context, boolean z5, int i6, int i7) {
        try {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                if (z5) {
                    try {
                        bytes = y.a(bytes);
                    } catch (IOException e6) {
                        return new g(-2, "zip err:" + e6.getMessage());
                    }
                }
                HttpRequest httpRequest = new HttpRequest(str);
                a(httpRequest, context, bytes, i7);
                while (i6 > 0) {
                    i6--;
                    HttpResponse httpPost = HttpUtils.httpPost(context, httpRequest);
                    int responseCode = httpPost.getResponseCode();
                    cn.jiguang.bb.f.d("HttpHelper", "status code:" + responseCode + " retry left:" + i6);
                    if (responseCode == 200) {
                        return new g(0, httpPost.getResponseBody());
                    }
                    if (responseCode == 401) {
                        return new g(-3, httpPost.getResponseBody());
                    }
                    if (responseCode == 404 || responseCode == 410 || responseCode == 429) {
                        return new g(-1, httpPost.getResponseBody());
                    }
                    if (responseCode == 503) {
                        return new g(-2, httpPost.getResponseBody());
                    }
                    if (responseCode != 3005) {
                        return responseCode != 3006 ? responseCode >= 500 ? new g(-1, httpPost.getResponseBody()) : new g(-2, httpPost.getResponseBody()) : new g(PluginError.ERROR_INS_INSTALL_PATH, httpPost.getResponseBody());
                    }
                }
                return new g(-2, "Failed - retry enough");
            } catch (AssertionError e7) {
                return new g(-2, "Catch AssertionError to avoid http close crash - " + e7.getMessage());
            } catch (Exception e8) {
                return new g(-2, "Exception - " + e8.getMessage());
            } catch (Throwable th) {
                return new g(-2, "Exception - " + th.getMessage());
            }
        } catch (UnsupportedEncodingException e9) {
            return new g(-2, "Exception - " + e9.getMessage());
        }
    }

    private static void a(HttpRequest httpRequest, Context context, byte[] bArr, int i6) {
        String b6;
        httpRequest.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpRequest.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        String a6 = v.a(v.a());
        byte[] a7 = v.a(bArr, a6, (i6 == 2 || i6 == 3) ? f.f2006a : f.f2007b, true);
        httpRequest.setBody(a7);
        httpRequest.setRequestProperty("Content-Length", String.valueOf(a7.length));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        if (f1984a == null) {
            try {
                if (!TextUtils.isEmpty("")) {
                    f1984a = new SSLTrustManager("");
                }
            } catch (Throwable unused) {
            }
        }
        X509TrustManager x509TrustManager = f1984a;
        if (x509TrustManager != null) {
            httpRequest.setSslTrustManager(x509TrustManager);
        }
        httpRequest.setRequestProperty("Accept", "application/jason");
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("X-App-Key", cn.jiguang.d.a.e(context));
        if (i6 == 2 || i6 == 3) {
            httpRequest.setHaveRspData(true);
            httpRequest.setRspDatazip(true);
            httpRequest.setNeedErrorInput(true);
            httpRequest.setRequestProperty("FillType", "1");
            if (i6 == 3) {
                httpRequest.setRequestProperty("X-Real-IP", "jcore");
                b6 = f.c(a6);
            } else {
                b6 = f.b(a6);
            }
        } else {
            boolean z5 = i6 == 4;
            httpRequest.setHaveRspData(z5);
            httpRequest.setRspDatazip(z5);
            b6 = "Basic " + f.a(context, w.b(a7), a6, z5);
        }
        httpRequest.setRequestProperty("Authorization", b6);
        httpRequest.setRequestProperty("Charset", "UTF-8");
    }

    private static void a(HttpRequest httpRequest, Context context, byte[] bArr, int i6, int i7) {
        String str;
        httpRequest.setConnectTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpRequest.setReadTimeout(KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
        httpRequest.setDoOutPut(true);
        httpRequest.setDoInPut(true);
        httpRequest.setUseCaches(false);
        httpRequest.setBody(bArr);
        httpRequest.setRequestProperty("Content-Length", String.valueOf(bArr.length));
        httpRequest.setNeedRetryIfHttpsFailed(true);
        if (f1984a == null) {
            try {
                if (!TextUtils.isEmpty("")) {
                    f1984a = new SSLTrustManager("");
                }
            } catch (Throwable unused) {
            }
        }
        SSLTrustManager sSLTrustManager = f1984a;
        if (sSLTrustManager != null) {
            httpRequest.setSslTrustManager(sSLTrustManager);
        }
        httpRequest.setRequestProperty("Accept", "application/jason");
        httpRequest.setRequestProperty("Accept-Encoding", "gzip");
        httpRequest.setRequestProperty("X-App-Key", cn.jiguang.d.a.e(context));
        httpRequest.setRequestProperty("Charset", "UTF-8");
        String url = httpRequest.getUrl();
        String str2 = url.contains("ipv6") ? f.f2011f : f.f2010e;
        if (JCoreManager.isTestEnv()) {
            str2 = Uri.parse(url).getHost();
        }
        httpRequest.setRequestProperty("Host", str2);
        String a6 = v.a(i6);
        if (i7 == 2) {
            httpRequest.setHaveRspData(true);
            httpRequest.setRspDatazip(true);
            httpRequest.setNeedErrorInput(true);
            httpRequest.setRequestProperty("FillType", "1");
            str = f.b(a6);
        } else {
            httpRequest.setHaveRspData(false);
            httpRequest.setRspDatazip(false);
            str = "Basic " + f.a(context, w.b(bArr), a6);
        }
        httpRequest.setRequestProperty("Authorization", str);
    }
}
