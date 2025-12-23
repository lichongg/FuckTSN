package com.kwad.sdk.export.proxy;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bw;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdHttpResponseHelper {
    public static void notifyResponseEnd(@Nullable final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.2
            @Override // java.lang.Runnable
            public void run() {
                AdHttpResponseListener.this.onResponseEnd();
            }
        });
    }

    public static boolean notifyResponseProgress(@Nullable AdHttpResponseListener adHttpResponseListener, long j6, long j7) {
        if (adHttpResponseListener == null) {
            return false;
        }
        return adHttpResponseListener.onReadProgress(j6, j7);
    }

    public static void notifyResponseStart(@Nullable final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.1
            @Override // java.lang.Runnable
            public void run() {
                AdHttpResponseListener.this.onResponseStart();
            }
        });
    }
}
