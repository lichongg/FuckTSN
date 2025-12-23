package com.amap.api.trace;

import android.content.Context;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c4;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.n4;
import com.stub.StubApp;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class LBSTraceClient {
    public static final String LOCATE_TIMEOUT_ERROR = "定位超时";
    public static final String MIN_GRASP_POINT_ERROR = "轨迹点太少或距离太近,轨迹纠偏失败";
    public static final String TRACE_SUCCESS = "纠偏成功";
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;

    /* renamed from: a, reason: collision with root package name */
    private static LBSTraceBase f9889a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile LBSTraceClient f9890b;

    public LBSTraceClient(Context context) throws Exception {
        a(context);
    }

    private static void a(Context context) throws Exception {
        n4 a6 = ft.a(context, b3.s());
        if (a6.f6803a != ft.c.SuccessCode) {
            throw new Exception(a6.f6804b);
        }
        if (context != null) {
            f9889a = new c4(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
    }

    public static LBSTraceClient getInstance(Context context) throws Exception {
        if (f9890b == null) {
            synchronized (LBSTraceClient.class) {
                try {
                    if (f9890b == null) {
                        a(context);
                        f9890b = new LBSTraceClient();
                    }
                } finally {
                }
            }
        }
        return f9890b;
    }

    public void destroy() {
        LBSTraceBase lBSTraceBase = f9889a;
        if (lBSTraceBase != null) {
            lBSTraceBase.destroy();
            a();
        }
    }

    public void queryProcessedTrace(int i6, List<TraceLocation> list, int i7, TraceListener traceListener) {
        LBSTraceBase lBSTraceBase = f9889a;
        if (lBSTraceBase != null) {
            lBSTraceBase.queryProcessedTrace(i6, list, i7, traceListener);
        }
    }

    public void startTrace(TraceStatusListener traceStatusListener) {
        LBSTraceBase lBSTraceBase = f9889a;
        if (lBSTraceBase != null) {
            lBSTraceBase.startTrace(traceStatusListener);
        }
    }

    public void stopTrace() {
        LBSTraceBase lBSTraceBase = f9889a;
        if (lBSTraceBase != null) {
            lBSTraceBase.stopTrace();
        }
    }

    private LBSTraceClient() {
    }

    private static void a() {
        f9889a = null;
        f9890b = null;
    }
}
