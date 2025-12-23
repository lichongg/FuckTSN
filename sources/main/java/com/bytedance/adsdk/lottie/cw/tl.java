package com.bytedance.adsdk.lottie.cw;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.lottie.vl;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class tl {

    /* renamed from: j, reason: collision with root package name */
    private final ae f23224j;
    private final m xt;

    @WorkerThread
    private com.bytedance.adsdk.lottie.m xt(Context context, String str, String str2) {
        ae aeVar;
        Pair<cw, InputStream> j6;
        if (str2 == null || (aeVar = this.f23224j) == null || (j6 = aeVar.j(str)) == null) {
            return null;
        }
        cw cwVar = (cw) j6.first;
        InputStream inputStream = (InputStream) j6.second;
        vl<com.bytedance.adsdk.lottie.m> j7 = cwVar == cw.ZIP ? com.bytedance.adsdk.lottie.ae.j(context, new ZipInputStream(inputStream), str2) : com.bytedance.adsdk.lottie.ae.xt(inputStream, str2);
        if (j7.j() != null) {
            return j7.j();
        }
        return null;
    }

    @WorkerThread
    public vl<com.bytedance.adsdk.lottie.m> j(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.m xt = xt(context, str, str2);
        if (xt != null) {
            return new vl<>(xt);
        }
        com.bytedance.adsdk.lottie.up.up.j("Animation for " + str + " not found in cache. Fetching from network.");
        return cw(context, str, str2);
    }

    @WorkerThread
    private vl<com.bytedance.adsdk.lottie.m> cw(Context context, String str, String str2) {
        vl<com.bytedance.adsdk.lottie.m> vlVar;
        com.bytedance.adsdk.lottie.up.up.j("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                r j6 = this.xt.j(str);
                if (j6.j()) {
                    vlVar = j(context, str, j6.xt(), j6.cw(), str2);
                    StringBuilder sb = new StringBuilder("Completed fetch from network. Success: ");
                    sb.append(vlVar.j() != null);
                    com.bytedance.adsdk.lottie.up.up.j(sb.toString());
                } else {
                    vlVar = new vl<>(new IllegalArgumentException(j6.r()));
                }
                try {
                    j6.close();
                    return vlVar;
                } catch (IOException e6) {
                    com.bytedance.adsdk.lottie.up.up.j("LottieFetchResult close failed ", e6);
                    return vlVar;
                }
            } catch (Exception e7) {
                vl<com.bytedance.adsdk.lottie.m> vlVar2 = new vl<>(e7);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e8) {
                        com.bytedance.adsdk.lottie.up.up.j("LottieFetchResult close failed ", e8);
                    }
                }
                return vlVar2;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                throw th;
            }
            try {
                closeable.close();
                throw th;
            } catch (IOException e9) {
                com.bytedance.adsdk.lottie.up.up.j("LottieFetchResult close failed ", e9);
                throw th;
            }
        }
    }

    public tl(ae aeVar, m mVar) {
        this.f23224j = aeVar;
        this.xt = mVar;
    }

    private vl<com.bytedance.adsdk.lottie.m> j(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        vl<com.bytedance.adsdk.lottie.m> j6;
        cw cwVar;
        ae aeVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (!str2.contains("application/zip") && !str2.contains("application/x-zip") && !str2.contains("application/x-zip-compressed") && !str.split("\\?")[0].endsWith(".lottie")) {
            com.bytedance.adsdk.lottie.up.up.j("Received json response.");
            cwVar = cw.JSON;
            j6 = j(str, inputStream, str3);
        } else {
            com.bytedance.adsdk.lottie.up.up.j("Handling zip response.");
            cw cwVar2 = cw.ZIP;
            j6 = j(context, str, inputStream, str3);
            cwVar = cwVar2;
        }
        if (str3 != null && j6.j() != null && (aeVar = this.f23224j) != null) {
            aeVar.j(str, cwVar);
        }
        return j6;
    }

    private vl<com.bytedance.adsdk.lottie.m> j(Context context, String str, InputStream inputStream, String str2) throws IOException {
        ae aeVar;
        if (str2 != null && (aeVar = this.f23224j) != null) {
            return com.bytedance.adsdk.lottie.ae.j(context, new ZipInputStream(new FileInputStream(aeVar.j(str, inputStream, cw.ZIP))), str);
        }
        return com.bytedance.adsdk.lottie.ae.j(context, new ZipInputStream(inputStream), (String) null);
    }

    private vl<com.bytedance.adsdk.lottie.m> j(String str, InputStream inputStream, String str2) throws IOException {
        ae aeVar;
        if (str2 != null && (aeVar = this.f23224j) != null) {
            return com.bytedance.adsdk.lottie.ae.xt(new FileInputStream(aeVar.j(str, inputStream, cw.JSON).getAbsolutePath()), str);
        }
        return com.bytedance.adsdk.lottie.ae.xt(inputStream, (String) null);
    }
}
