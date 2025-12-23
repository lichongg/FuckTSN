package com.kwad.sdk.collector;

import androidx.annotation.Keep;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class AppStatusNative {
    public static native String[] analyseTaskGetPathSuffixSet(AnalyseTaskNative analyseTaskNative);

    public static native long analyseTaskGetRunningInfo(AnalyseTaskNative analyseTaskNative);

    public static native long analyseTaskGetStartTime(AnalyseTaskNative analyseTaskNative);

    public static native long[] analysis(long[] jArr, String str);

    public static native long appRunningInfoGetGranularity(AppRunningInfoNative appRunningInfoNative);

    public static native long appRunningInfoGetLastRunningTime(AppRunningInfoNative appRunningInfoNative);

    public static native String appRunningInfoGetName(AppRunningInfoNative appRunningInfoNative);

    public static native String appRunningInfoGetPackageName(AppRunningInfoNative appRunningInfoNative);

    public static native void appRunningInfoSetLastRunningTime(AppRunningInfoNative appRunningInfoNative, long j6);

    public static native long nativeCreateAnalyseTask(long j6, String[] strArr, long j7);

    public static native long nativeCreateAppRunningInfo(long j6, String str, String str2);

    public static native long nativeCreateRulesTarget();

    public static native long nativeCreateUploadEntry();

    public static native void nativeDeleteAnalyseTask(long j6);

    public static native void nativeDeleteAppRunningInfo(long j6);

    public static native void nativeDeleteRulesTarget(long j6);

    public static native void nativeDeleteUploadEntry(long j6);

    public static native long[] nativeGetUploadEntry(long[] jArr, long j6, String str);

    public static native String rulesTargetGetPackageName(RulesTargetNative rulesTargetNative);

    public static native String[] rulesTargetGetPaths(RulesTargetNative rulesTargetNative);

    public static native void rulesTargetSetPackageName(RulesTargetNative rulesTargetNative, String str);

    public static native void rulesTargetSetPaths(RulesTargetNative rulesTargetNative, String[] strArr);

    public static native String uploadEntryGetOriginFilePath(UploadEntryNative uploadEntryNative);

    public static native String uploadEntryGetPackageName(UploadEntryNative uploadEntryNative);

    public static native void uploadEntrySetOriginFilePath(UploadEntryNative uploadEntryNative, String str);

    public static native void uploadEntrySetPackageName(UploadEntryNative uploadEntryNative, String str);
}
