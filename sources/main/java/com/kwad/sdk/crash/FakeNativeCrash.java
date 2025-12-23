package com.kwad.sdk.crash;

import androidx.annotation.Keep;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class FakeNativeCrash {
    public static final String TAG = "FakeNativeCrash";

    @Keep
    public static native void init(boolean z5, int i6);

    @Keep
    public static void upload(int i6, int i7, String str) {
        com.kwad.sdk.core.d.c.e(TAG, "upload: signal=" + i6 + ", code=" + i7 + ", nativeBacktraceStr=" + str);
    }
}
