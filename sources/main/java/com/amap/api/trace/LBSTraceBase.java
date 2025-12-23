package com.amap.api.trace;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int i6, List<TraceLocation> list, int i7, TraceListener traceListener);

    void setLocationInterval(long j6);

    void setTraceStatusInterval(int i6);

    void startTrace(TraceStatusListener traceStatusListener);

    void stopTrace();
}
