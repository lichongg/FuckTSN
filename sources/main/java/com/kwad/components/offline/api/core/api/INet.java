package com.kwad.components.offline.api.core.api;

import android.content.Context;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public interface INet {
    public static final int HTTP_STATUS_CODE_INVALID = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public @interface HostType {
        public static final String API = "api";
        public static final String CDN = "cdn";
        public static final String ULOG = "ulog";
        public static final String ZT = "zt";
    }

    int getActiveNetworkType(Context context);

    String getCurrHost(@HostType String str, String str2);

    void handleSwitchHost(String str, @HostType String str2, int i6, Throwable th);

    boolean isMobileConnected(Context context);

    boolean isNetworkConnected(Context context);

    boolean isWifiConnected(Context context);
}
