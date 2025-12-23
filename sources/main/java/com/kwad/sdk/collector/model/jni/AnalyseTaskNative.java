package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.a;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class AnalyseTaskNative extends NativeObject implements a {
    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j6 = this.mPtr;
        if (j6 != 0) {
            AppStatusNative.nativeDeleteAnalyseTask(j6);
            this.mPtr = 0L;
        }
    }

    public AnalyseTaskNative(AppRunningInfoNative appRunningInfoNative, Set<String> set, long j6) {
        String[] strArr = new String[set.size()];
        set.toArray(strArr);
        this.mPtr = AppStatusNative.nativeCreateAnalyseTask(appRunningInfoNative.mPtr, strArr, j6);
    }
}
