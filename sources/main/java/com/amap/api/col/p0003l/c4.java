package com.amap.api.col.p0003l;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.work.WorkRequest;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.trace.LBSTraceBase;
import com.amap.api.trace.LBSTraceClient;
import com.amap.api.trace.TraceListener;
import com.amap.api.trace.TraceLocation;
import com.amap.api.trace.TraceStatusListener;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class c4 implements LocationSource.OnLocationChangedListener, LBSTraceBase {

    /* renamed from: a, reason: collision with root package name */
    private Context f5808a;

    /* renamed from: b, reason: collision with root package name */
    private CoordinateConverter f5809b;

    /* renamed from: c, reason: collision with root package name */
    private a8 f5810c;

    /* renamed from: d, reason: collision with root package name */
    private a8 f5811d;

    /* renamed from: g, reason: collision with root package name */
    private TraceStatusListener f5814g;

    /* renamed from: h, reason: collision with root package name */
    private b0 f5815h;

    /* renamed from: m, reason: collision with root package name */
    private c f5820m;

    /* renamed from: e, reason: collision with root package name */
    private long f5812e = 2000;

    /* renamed from: f, reason: collision with root package name */
    private int f5813f = 5;

    /* renamed from: i, reason: collision with root package name */
    private List<TraceLocation> f5816i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    private int f5817j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f5818k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f5819l = 0;

    /* renamed from: n, reason: collision with root package name */
    private TraceLocation f5821n = null;

    /* renamed from: o, reason: collision with root package name */
    private List<LatLng> f5822o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    private List<LatLng> f5823p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private List<LatLng> f5824q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    int f5825r = Runtime.getRuntime().availableProcessors();

    /* renamed from: s, reason: collision with root package name */
    private BlockingQueue<Runnable> f5826s = new LinkedBlockingQueue();

    /* renamed from: t, reason: collision with root package name */
    private BlockingQueue<Runnable> f5827t = new LinkedBlockingQueue();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends b8 {

        /* renamed from: e, reason: collision with root package name */
        private int f5829e;

        /* renamed from: g, reason: collision with root package name */
        private int f5830g;

        /* renamed from: h, reason: collision with root package name */
        private List<TraceLocation> f5831h;

        /* renamed from: j, reason: collision with root package name */
        private TraceListener f5833j;

        /* renamed from: d, reason: collision with root package name */
        private List<TraceLocation> f5828d = new ArrayList();

        /* renamed from: i, reason: collision with root package name */
        private String f5832i = t2.a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.amap.api.col.3l.c4$a$a, reason: collision with other inner class name */
        final class C0089a extends b8 {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ b4 f5835d;

            C0089a(b4 b4Var) {
                this.f5835d = b4Var;
            }

            @Override // com.amap.api.col.p0003l.b8
            public final void runTask() {
                this.f5835d.run();
            }
        }

        public a(int i6, List<TraceLocation> list, int i7, TraceListener traceListener) {
            this.f5829e = i7;
            this.f5830g = i6;
            this.f5831h = list;
            this.f5833j = traceListener;
        }

        private int d() {
            List<TraceLocation> list = this.f5831h;
            int i6 = 0;
            if (list != null && list.size() != 0) {
                ArrayList arrayList = new ArrayList();
                for (TraceLocation traceLocation : this.f5831h) {
                    if (traceLocation != null) {
                        if (traceLocation.getSpeed() < 0.01d) {
                            arrayList.add(traceLocation);
                        } else {
                            i6 += e(arrayList);
                            arrayList.clear();
                        }
                    }
                }
            }
            return i6;
        }

        @Override // com.amap.api.col.p0003l.b8
        public final void runTask() {
            try {
                c4.this.f5820m.a(this.f5833j);
                int d6 = d();
                List<TraceLocation> list = this.f5831h;
                if (list != null && list.size() >= 2) {
                    Iterator<TraceLocation> it = this.f5831h.iterator();
                    while (it.hasNext()) {
                        TraceLocation copy = it.next().copy();
                        if (copy != null && copy.getLatitude() > 0.0d && copy.getLongitude() > 0.0d) {
                            this.f5828d.add(copy);
                        }
                    }
                    int size = (this.f5828d.size() - 2) / 500;
                    d4.b().d(this.f5832i, this.f5830g, size, d6);
                    int i6 = 500;
                    int i7 = 0;
                    while (i7 <= size) {
                        if (i7 == size) {
                            i6 = this.f5828d.size();
                        }
                        int i8 = i6;
                        ArrayList arrayList = new ArrayList();
                        for (int i9 = 0; i9 < i8; i9++) {
                            TraceLocation remove = this.f5828d.remove(0);
                            if (remove != null) {
                                int i10 = this.f5829e;
                                if (i10 != 1) {
                                    if (i10 == 3) {
                                        c4.this.f5809b.from(CoordinateConverter.CoordType.BAIDU);
                                    } else if (i10 == 2) {
                                        c4.this.f5809b.from(CoordinateConverter.CoordType.GPS);
                                    }
                                    c4.this.f5809b.coord(new LatLng(remove.getLatitude(), remove.getLongitude()));
                                    LatLng convert = c4.this.f5809b.convert();
                                    if (convert != null) {
                                        remove.setLatitude(convert.latitude);
                                        remove.setLongitude(convert.longitude);
                                    }
                                }
                                arrayList.add(remove);
                            }
                        }
                        if (arrayList.size() >= 2 && arrayList.size() <= 500) {
                            c4.this.f5811d.b(new C0089a(new b4(c4.this.f5808a, c4.this.f5820m, arrayList, this.f5832i, this.f5830g, i7)));
                            i7++;
                            try {
                                Thread.sleep(50L);
                            } catch (InterruptedException e6) {
                                e6.printStackTrace();
                            }
                        }
                        i6 = i8;
                    }
                    return;
                }
                d4.b();
                d4.c(c4.this.f5820m, this.f5830g, LBSTraceClient.MIN_GRASP_POINT_ERROR);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private static int e(List<TraceLocation> list) {
            int size = list.size();
            if (size <= 1) {
                return 0;
            }
            TraceLocation traceLocation = list.get(0);
            TraceLocation traceLocation2 = list.get(size - 1);
            if (traceLocation == null || traceLocation2 == null) {
                return 0;
            }
            return (int) ((traceLocation2.getTime() - traceLocation.getTime()) / 1000);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements TraceListener {

        /* renamed from: a, reason: collision with root package name */
        private final List<TraceLocation> f5837a;

        public b(List<TraceLocation> list) {
            this.f5837a = list;
        }

        private void a(int i6, List<LatLng> list) {
            try {
                synchronized (c4.this.f5824q) {
                    c4.this.f5824q.clear();
                    c4.this.f5824q.addAll(list);
                }
                c4.this.f5823p.clear();
                if (i6 == 0) {
                    c4.this.f5823p.addAll(c4.this.f5824q);
                } else {
                    c4.this.f5823p.addAll(c4.this.f5822o);
                    c4.this.f5823p.addAll(c4.this.f5824q);
                }
                c4.this.f5814g.onTraceStatus(c4.this.f5816i, c4.this.f5823p, LBSTraceClient.TRACE_SUCCESS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onRequestFailed(int i6, String str) {
            ArrayList arrayList = new ArrayList();
            if (c4.this.f5824q != null) {
                arrayList.addAll(c4.this.f5824q);
            }
            List<TraceLocation> list = this.f5837a;
            if (list != null) {
                int size = list.size();
                if (this.f5837a.size() > c4.this.f5813f) {
                    for (int i7 = size - c4.this.f5813f; i7 < size; i7++) {
                        TraceLocation traceLocation = this.f5837a.get(i7);
                        if (traceLocation != null) {
                            arrayList.add(new LatLng(traceLocation.getLatitude(), traceLocation.getLongitude()));
                        }
                    }
                }
            }
            a(i6, arrayList);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onFinished(int i6, List<LatLng> list, int i7, int i8) {
            a(i6, list);
        }

        @Override // com.amap.api.trace.TraceListener
        public final void onTraceProcessing(int i6, int i7, List<LatLng> list) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private TraceListener f5839a;

        public final void a(TraceListener traceListener) {
            this.f5839a = traceListener;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Bundle data;
            try {
                if (this.f5839a != null && (data = message.getData()) != null) {
                    int i6 = data.getInt("lineID");
                    switch (message.what) {
                        case 100:
                            this.f5839a.onTraceProcessing(i6, message.arg1, (List) message.obj);
                            break;
                        case 101:
                            this.f5839a.onFinished(i6, (List) message.obj, message.arg1, message.arg2);
                            break;
                        case 102:
                            this.f5839a.onRequestFailed(i6, (String) message.obj);
                            break;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public c(Looper looper) {
            super(looper);
        }
    }

    private static boolean e(TraceLocation traceLocation, TraceLocation traceLocation2) {
        return traceLocation != null && traceLocation.getLatitude() == traceLocation2.getLatitude() && traceLocation.getLongitude() == traceLocation2.getLongitude();
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void destroy() {
        try {
            stopTrace();
            a8 a8Var = this.f5810c;
            if (a8Var != null) {
                a8Var.g();
                this.f5810c = null;
            }
            a8 a8Var2 = this.f5811d;
            if (a8Var2 != null) {
                a8Var2.g();
                this.f5811d = null;
            }
            this.f5816i = null;
            this.f5814g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f5808a = null;
        this.f5809b = null;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setTraceStatusInterval(int i6) {
        this.f5813f = Math.max(i6, 2);
    }

    private static double a(double d6, double d7, double d8, double d9) {
        double d10 = d6 > d8 ? d6 - d8 : d8 - d6;
        double d11 = d7 > d9 ? d7 - d9 : d9 - d7;
        return Math.sqrt((d10 * d10) + (d11 * d11));
    }

    private void c() {
        int size = this.f5816i.size();
        if (size < this.f5813f) {
            return;
        }
        if (size <= 50) {
            ArrayList arrayList = new ArrayList(this.f5816i);
            queryProcessedTrace(0, arrayList, 1, new b(arrayList));
            return;
        }
        int i6 = size - 50;
        if (i6 < 0) {
            return;
        }
        d(new ArrayList(this.f5816i.subList(i6 - this.f5813f, i6)));
        ArrayList arrayList2 = new ArrayList(this.f5816i.subList(i6, size));
        queryProcessedTrace(i6, arrayList2, 1, new b(arrayList2));
    }

    private void d(List<TraceLocation> list) {
        synchronized (this.f5824q) {
            try {
                if (list.size() <= 0) {
                    return;
                }
                if (this.f5824q.size() <= 0) {
                    return;
                }
                LatLng latLng = null;
                double d6 = 0.0d;
                TraceLocation traceLocation = null;
                double d7 = 0.0d;
                for (TraceLocation traceLocation2 : list) {
                    if (traceLocation2 != null) {
                        if (traceLocation != null) {
                            double a6 = a(traceLocation.getLatitude(), traceLocation.getLongitude(), traceLocation2.getLatitude(), traceLocation2.getLongitude());
                            if (a6 <= 100.0d) {
                                d7 += a6;
                            }
                        }
                        traceLocation = traceLocation2;
                    }
                }
                Iterator<LatLng> it = this.f5824q.iterator();
                while (it.hasNext()) {
                    LatLng next = it.next();
                    if (next == null) {
                        it.remove();
                    } else {
                        if (latLng != null) {
                            d6 += a(latLng.latitude, latLng.longitude, next.latitude, next.longitude);
                            if (d6 >= d7) {
                                break;
                            }
                            this.f5822o.add(next);
                            it.remove();
                        } else {
                            this.f5822o.add(next);
                            it.remove();
                        }
                        latLng = next;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g() {
        b0 b0Var = this.f5815h;
        if (b0Var != null) {
            b0Var.deactivate();
            this.f5815h = null;
        }
    }

    private void i() {
        this.f5826s.clear();
        this.f5827t.clear();
        List<TraceLocation> list = this.f5816i;
        if (list != null) {
            synchronized (list) {
                try {
                    List<TraceLocation> list2 = this.f5816i;
                    if (list2 != null) {
                        list2.clear();
                    }
                    this.f5818k = 0;
                    this.f5817j = 0;
                    this.f5819l = 0L;
                    this.f5821n = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        TraceStatusListener traceStatusListener;
        if (this.f5814g != null) {
            try {
                if (System.currentTimeMillis() - this.f5819l >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS && (traceStatusListener = this.f5814g) != null) {
                    traceStatusListener.onTraceStatus(null, null, LBSTraceClient.LOCATE_TIMEOUT_ERROR);
                }
                this.f5819l = System.currentTimeMillis();
                Bundle extras = location.getExtras();
                if (extras.getInt("errorCode") != 0) {
                    extras.getString(MyLocationStyle.ERROR_INFO);
                    return;
                }
                synchronized (this.f5816i) {
                    try {
                        TraceLocation traceLocation = new TraceLocation(location.getLatitude(), location.getLongitude(), location.getSpeed(), location.getBearing(), location.getTime());
                        if (e(this.f5821n, traceLocation)) {
                            return;
                        }
                        this.f5816i.add(traceLocation);
                        this.f5821n = traceLocation;
                        int i6 = this.f5817j + 1;
                        this.f5817j = i6;
                        if (i6 == this.f5813f) {
                            this.f5818k += i6;
                            c();
                            this.f5817j = 0;
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void queryProcessedTrace(int i6, List<TraceLocation> list, int i7, TraceListener traceListener) {
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f5810c.b(new a(i6, list, i7, traceListener));
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void setLocationInterval(long j6) {
        this.f5812e = j6;
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void startTrace(TraceStatusListener traceStatusListener) {
        if (this.f5808a == null) {
            return;
        }
        this.f5819l = System.currentTimeMillis();
        this.f5814g = traceStatusListener;
        if (this.f5815h == null) {
            b0 b0Var = new b0(this.f5808a);
            this.f5815h = b0Var;
            b0Var.d(this.f5812e);
            this.f5815h.activate(this);
        }
    }

    public c4(Context context) {
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f5808a = origApplicationContext;
        this.f5809b = new CoordinateConverter(origApplicationContext);
        this.f5820m = new c(Looper.getMainLooper());
        k4.a().c(this.f5808a);
        this.f5810c = a3.a(this.f5825r * 2, this.f5826s, "AMapTraceManagerProcess");
        this.f5811d = a3.a(this.f5825r * 2, this.f5827t, "AMapTraceManagerRequest");
    }

    @Override // com.amap.api.trace.LBSTraceBase
    public final void stopTrace() {
        g();
        i();
    }
}
