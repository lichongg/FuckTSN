package xyz.adscope.common.analyse.publish;

import java.util.List;
import java.util.concurrent.TimeUnit;
import xyz.adscope.common.analyse.model.IBaseEventReportModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public interface IEventAnalyser {
    void initializeQueueLinked(List<IEventConfigModel> list, String str);

    void reportCrashEvent(List<IBaseEventReportModel> list, String str);

    void reportRealtimeEvent(IBaseEventReportModel iBaseEventReportModel, String str);

    void scheduleHistoryEvent(long j6, long j7, TimeUnit timeUnit);
}
