package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.annotation.SuppressLint;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.az;
import com.bytedance.sdk.component.xt.j.jy;
import com.bytedance.sdk.component.xt.j.m;
import com.bytedance.sdk.component.xt.j.vl;
import com.bytedance.sdk.component.xt.j.ws;
import com.bytedance.sdk.component.xt.j.xt;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static vl okHttpClient;

    @SuppressLint({"CI_DefaultLocale"})
    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i6) throws IOException {
        ws.j jVar = new ws.j();
        jVar.j(aVMDLRequest.urls[i6]);
        jVar.j("GET", (az) null);
        jVar.j(toOkHttpHeaders(aVMDLRequest));
        xt j6 = getOkHttpClient().j(jVar.xt());
        try {
            long currentTimeMillis = System.currentTimeMillis();
            av j7 = j6.j();
            long currentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i6;
            String.format("http open cost time:%d url:%s", Long.valueOf(currentTimeMillis2 - currentTimeMillis), aVMDLRequest.urls[i6]);
            return new AVMDLResponse(aVMDLRequest, j7, j6);
        } catch (Exception e6) {
            AVMDLLog.e(TAG, "request exception is " + e6.getLocalizedMessage());
            throw e6;
        }
    }

    public static String formRangeStrByPos(long j6, long j7) {
        if (j6 >= 0 && j7 > 0) {
            return j6 + "-" + j7;
        }
        if (j6 >= 0) {
            return j6 + "-";
        }
        if (j6 >= 0 || j7 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(j7));
    }

    public static String formRangeStrBySize(long j6, long j7) {
        return formRangeStrByPos(j6, j7 > 0 ? (j7 + j6) - 1 : -1L);
    }

    private static synchronized vl getOkHttpClient() {
        vl vlVar;
        long j6;
        synchronized (AVMDLHttpExcutor.class) {
            try {
                if (okHttpClient == null) {
                    AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
                    if (config != null) {
                        long j7 = config.mOpenTimeOut > 0 ? r4 * 1000 : 10000L;
                        long j8 = j7;
                        j6 = config.mRWTimeOut > 0 ? r1 * 1000 : 10000L;
                        r2 = j8;
                    } else {
                        j6 = 10000;
                    }
                    vl.j jVar = new vl.j();
                    jVar.j(Collections.singletonList(jy.HTTP_1_1));
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    jVar.j(r2, timeUnit).xt(j6, timeUnit).cw(j6, timeUnit);
                    okHttpClient = jVar.j();
                }
                vlVar = okHttpClient;
            } catch (Throwable th) {
                throw th;
            }
        }
        return vlVar;
    }

    private static m toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        m.j jVar = new m.j();
        HashMap<String, String> hashMap = aVMDLRequest.headers;
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                entry.getKey();
                entry.getValue();
                jVar.xt(entry.getKey(), entry.getValue());
            }
        }
        String buildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (buildRangeHeader != null) {
            jVar.xt("Range", buildRangeHeader);
        }
        jVar.xt("Accept-Encoding", "identity");
        return jVar.j();
    }

    public static String buildRangeHeader(long j6, long j7) {
        String formRangeStrBySize = formRangeStrBySize(j6, j7);
        if (formRangeStrBySize == null) {
            return null;
        }
        return "bytes=".concat(formRangeStrBySize);
    }
}
