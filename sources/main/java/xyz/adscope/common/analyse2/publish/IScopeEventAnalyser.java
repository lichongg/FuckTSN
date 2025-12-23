package xyz.adscope.common.analyse2.publish;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IScopeEventAnalyser {
    void initializeAnalyse(String str);

    void registerAnalyseUpdate(IScopeAnalyserUpdater iScopeAnalyserUpdater);

    void reportCrash(String str, String str2, String str3);

    void reportEvent(String str, String str2, String str3);

    void scheduleHistoryEvent(long j6, long j7, TimeUnit timeUnit, String str);
}
