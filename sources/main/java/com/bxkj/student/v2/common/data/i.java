package com.bxkj.student.v2.common.data;

import android.content.Intent;
import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.App;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class i {
    private static boolean A;
    private static boolean B;
    private static boolean C;

    @Nullable
    private static LatLng D;
    private static double E;
    private static boolean F;
    private static int G;

    @NotNull
    private static final s<MutableLiveData<Boolean>> H;

    @NotNull
    private static final s<MutableLiveData<Integer>> I;

    @NotNull
    private static final List<LatLng> J;

    @NotNull
    private static LatLng K;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20657a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final s<Map<String, Object>> f20658b;

    /* renamed from: c, reason: collision with root package name */
    private static long f20659c;

    /* renamed from: d, reason: collision with root package name */
    private static long f20660d;

    /* renamed from: e, reason: collision with root package name */
    private static long f20661e;

    /* renamed from: f, reason: collision with root package name */
    private static long f20662f;

    /* renamed from: g, reason: collision with root package name */
    private static long f20663g;

    /* renamed from: h, reason: collision with root package name */
    private static long f20664h;

    /* renamed from: i, reason: collision with root package name */
    private static long f20665i;

    /* renamed from: j, reason: collision with root package name */
    private static double f20666j;

    /* renamed from: k, reason: collision with root package name */
    private static double f20667k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static String f20668l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static String f20669m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static String f20670n;

    /* renamed from: o, reason: collision with root package name */
    private static int f20671o;

    /* renamed from: p, reason: collision with root package name */
    private static int f20672p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    private static LatLng f20673q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    private static LatLng f20674r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    private static PointData f20675s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    private static PointData f20676t;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    private static final s<List<PointData>> f20677u;

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    private static final s<List<Map<String, Object>>> f20678v;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    private static final s<List<Integer>> f20679w;

    /* renamed from: x, reason: collision with root package name */
    private static int f20680x;

    /* renamed from: y, reason: collision with root package name */
    private static boolean f20681y;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f20682z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSportsDataAgent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsDataAgent.kt\ncom/bxkj/student/v2/common/data/SportsDataAgent$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,486:1\n1869#2,2:487\n*S KotlinDebug\n*F\n+ 1 SportsDataAgent.kt\ncom/bxkj/student/v2/common/data/SportsDataAgent$Companion\n*L\n276#1:487,2\n*E\n"})
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        public final void c() {
            com.orhanobut.logger.j.m("清除跑步数据", new Object[0]);
            r0(0L);
            U(0L);
            W(0.0d);
            c0(0.0d);
            T("0");
            m0("0");
            f0("GPS信号未知，正在搜寻···");
            e0(R.mipmap.ic_gps_unknow);
            a0(null);
            q0(null);
            h0(null);
            V(null);
            s().clear();
            H().clear();
            x().clear();
            u0(0);
            j().setValue(0);
            k().setValue(Boolean.TRUE);
            b0(false);
            Z(false);
            v0(false);
            n0(false);
            Y(0.0d);
            o0(null);
            i.J.clear();
            k0(0);
        }

        private a() {
        }

        public final void L(@NotNull AMapLocation aMapLocation) {
            g0.p(aMapLocation, "aMapLocation");
            Intent intent = new Intent();
            App.a aVar = App.f17573d;
            intent.setAction(aVar.a().getPackageName() + ".run");
            intent.putExtra("aMapLocation", aMapLocation);
            aVar.a().sendBroadcast(intent, k.f20685b);
        }

        public final void M(@Nullable LatLng latLng) {
            Intent intent = new Intent();
            App.a aVar = App.f17573d;
            intent.setAction(aVar.a().getPackageName() + ".run");
            intent.putExtra("firstMapLocation", latLng);
            aVar.a().sendBroadcast(intent, k.f20685b);
        }

        public final void N(@NotNull String gpsStatusString, int i6) {
            g0.p(gpsStatusString, "gpsStatusString");
            Intent intent = new Intent();
            App.a aVar = App.f17573d;
            intent.setAction(aVar.a().getPackageName() + ".run");
            intent.putExtra("gpsStatusString", gpsStatusString);
            intent.putExtra("gpsStatusImage", i6);
            aVar.a().sendBroadcast(intent, k.f20685b);
        }

        public final void O(@NotNull LatLng newLocationPoint) {
            g0.p(newLocationPoint, "newLocationPoint");
            Intent intent = new Intent();
            App.a aVar = App.f17573d;
            intent.setAction(aVar.a().getPackageName() + ".run");
            intent.putExtra("newLocationPoint", newLocationPoint);
            aVar.a().sendBroadcast(intent, k.f20685b);
        }

        public final void P(@NotNull PointData newPoint) {
            g0.p(newPoint, "newPoint");
            Intent intent = new Intent();
            App.a aVar = App.f17573d;
            intent.setAction(aVar.a().getPackageName() + ".run");
            intent.putExtra("newPoint", newPoint);
            aVar.a().sendBroadcast(intent, k.f20685b);
        }

        public final void Q(@Nullable LatLng latLng) {
            Intent intent = new Intent();
            App.a aVar = App.f17573d;
            intent.setAction(aVar.a().getPackageName() + ".run");
            intent.putExtra("startPoint", latLng);
            aVar.a().sendBroadcast(intent, k.f20685b);
        }

        public final void R(int i6) {
            Intent intent = new Intent();
            App.a aVar = App.f17573d;
            intent.setAction(aVar.a().getPackageName() + ".run");
            intent.putExtra("stepCount", i6);
            aVar.a().sendBroadcast(intent, k.f20685b);
        }

        public final void S() {
            Intent intent = new Intent();
            App.a aVar = App.f17573d;
            intent.setAction(aVar.a().getPackageName() + ".run");
            intent.putExtra("countTime", e());
            intent.putExtra("distance", g());
            intent.putExtra("avgSpeed", d());
            intent.putExtra("pace", y());
            aVar.a().sendBroadcast(intent, k.f20685b);
        }

        public final void T(@NotNull String str) {
            g0.p(str, "<set-?>");
            i.f20668l = str;
        }

        public final int a() {
            c0 c0Var = c0.f16887a;
            return j.f20683a.c(c0Var.k(B(), "isStepRecursion"), c0Var.f(B(), "totalRange"), c0Var.l(B(), "step", 0), com.bxkj.student.run.app.utils.i.e(g()) * 1000);
        }

        public final int b() {
            c0 c0Var = c0.f16887a;
            return j.f20683a.d(c0Var.f(B(), "totalRange"), c0Var.l(B(), "endQualifiedTime", -1), com.bxkj.student.run.app.utils.i.e(g()) * 1000);
        }

        public final void f0(@NotNull String str) {
            g0.p(str, "<set-?>");
            i.f20670n = str;
        }

        public final void m0(@NotNull String str) {
            g0.p(str, "<set-?>");
            i.f20669m = str;
        }

        public final boolean t(@NotNull AMapLocation location) {
            g0.p(location, "location");
            if (location.getTrustedLevel() != 1) {
                return false;
            }
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            if (AMapUtils.calculateLineDistance(i.K, latLng) > 10.0f) {
                i.K = latLng;
                i.J.clear();
                return false;
            }
            i.J.add(latLng);
            i.K = latLng;
            if (i.J.size() < 5) {
                return false;
            }
            i.J.clear();
            return true;
        }

        private final void p0() {
            boolean z5;
            if (!i.f20682z && !i.A && !i.B && !i.C) {
                z5 = false;
            } else {
                z5 = true;
            }
            n0(z5);
        }

        public final long A() {
            long v5;
            if (v() == 0) {
                v5 = System.currentTimeMillis();
            } else {
                v5 = v() + (SystemClock.elapsedRealtime() - w());
            }
            com.orhanobut.logger.j.d("真正的服务器时间：" + com.bxkj.base.v2.common.ext.g.d(v5), new Object[0]);
            return v5;
        }

        @NotNull
        public final Map<String, Object> B() {
            return (Map) i.f20658b.getValue();
        }

        @Nullable
        public final LatLng C() {
            return i.f20674r;
        }

        public final long D() {
            return i.f20659c;
        }

        public final long E() {
            return i.f20661e;
        }

        public final long F() {
            return i.f20662f;
        }

        public final int G() {
            return i.f20680x;
        }

        @NotNull
        public final List<Integer> H() {
            return (List) i.f20679w.getValue();
        }

        public final int I() {
            return i.G;
        }

        public final boolean J() {
            return i.F;
        }

        public final boolean K() {
            return i.f20681y;
        }

        public final void U(long j6) {
            i.f20665i = j6;
        }

        public final void V(@Nullable PointData pointData) {
            i.f20675s = pointData;
        }

        public final void W(double d6) {
            i.f20666j = d6;
        }

        public final void X(long j6) {
            i.f20660d = j6;
        }

        public final void Y(double d6) {
            i.E = d6;
        }

        public final void Z(boolean z5) {
            i.A = z5;
            p0();
        }

        public final void a0(@Nullable LatLng latLng) {
            i.f20673q = latLng;
        }

        public final void b0(boolean z5) {
            i.B = z5;
            p0();
        }

        public final void c0(double d6) {
            i.f20667k = d6;
        }

        @NotNull
        public final String d() {
            return i.f20668l;
        }

        public final void d0(int i6) {
            i.f20672p = i6;
        }

        public final long e() {
            return i.f20665i;
        }

        public final void e0(int i6) {
            i.f20671o = i6;
        }

        @Nullable
        public final PointData f() {
            return i.f20675s;
        }

        public final double g() {
            return i.f20666j;
        }

        public final void g0(boolean z5) {
            i.C = z5;
            p0();
        }

        public final long h() {
            long A = A();
            com.orhanobut.logger.j.d("真正的跑步结束时间：" + com.bxkj.base.v2.common.ext.g.d(A), new Object[0]);
            return A;
        }

        public final void h0(@Nullable PointData pointData) {
            i.f20676t = pointData;
        }

        public final double i() {
            return i.E;
        }

        public final void i0(long j6) {
            i.f20663g = j6;
        }

        @NotNull
        public final MutableLiveData<Integer> j() {
            return (MutableLiveData) i.I.getValue();
        }

        public final void j0(long j6) {
            i.f20664h = j6;
        }

        @NotNull
        public final MutableLiveData<Boolean> k() {
            return (MutableLiveData) i.H.getValue();
        }

        public final void k0(int i6) {
            i.G = i6;
        }

        public final boolean l() {
            return i.A;
        }

        public final void l0(boolean z5) {
            i.F = z5;
        }

        @NotNull
        public final List<Integer> m() {
            int i6;
            long j6 = 60;
            long e6 = e() / j6;
            int i7 = 0;
            if (e() % j6 == 0) {
                i6 = 0;
            } else {
                i6 = 1;
            }
            long j7 = e6 + i6;
            ArrayList arrayList = new ArrayList(H());
            Iterator<T> it = H().iterator();
            while (it.hasNext()) {
                i7 += ((Number) it.next()).intValue();
            }
            int G = G() - i7;
            if (arrayList.size() < j7) {
                arrayList.add(Integer.valueOf(G));
                return arrayList;
            }
            if (arrayList.size() == 0) {
                arrayList.add(Integer.valueOf(G));
                return arrayList;
            }
            arrayList.set(arrayList.size() - 1, Integer.valueOf(((Number) arrayList.get(arrayList.size() - 1)).intValue() + G));
            return arrayList;
        }

        @Nullable
        public final LatLng n() {
            return i.f20673q;
        }

        public final void n0(boolean z5) {
            i.f20681y = z5;
        }

        public final double o() {
            return i.f20667k;
        }

        public final void o0(@Nullable LatLng latLng) {
            i.D = latLng;
        }

        public final int p() {
            return i.f20672p;
        }

        public final int q() {
            return i.f20671o;
        }

        public final void q0(@Nullable LatLng latLng) {
            i.f20674r = latLng;
        }

        @NotNull
        public final String r() {
            return i.f20670n;
        }

        public final void r0(long j6) {
            i.f20659c = j6;
        }

        @NotNull
        public final List<PointData> s() {
            return (List) i.f20677u.getValue();
        }

        public final void s0(long j6) {
            i.f20661e = j6;
        }

        public final void t0(long j6) {
            i.f20662f = j6;
        }

        @Nullable
        public final PointData u() {
            return i.f20676t;
        }

        public final void u0(int i6) {
            i.f20680x = i6;
        }

        public final long v() {
            return i.f20663g;
        }

        public final void v0(boolean z5) {
            i.f20682z = z5;
            p0();
        }

        public final long w() {
            return i.f20664h;
        }

        @NotNull
        public final List<Map<String, Object>> x() {
            return (List) i.f20678v.getValue();
        }

        @NotNull
        public final String y() {
            return i.f20669m;
        }

        @Nullable
        public final LatLng z() {
            return i.D;
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        f20658b = t.b(lazyThreadSafetyMode, new Function0() { // from class: com.bxkj.student.v2.common.data.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Map w02;
                w02 = i.w0();
                return w02;
            }
        });
        f20660d = System.currentTimeMillis();
        f20668l = "0";
        f20669m = "0";
        f20670n = "GPS信号未知，正在搜寻···";
        f20671o = R.mipmap.ic_gps_unknow;
        f20672p = -1;
        f20677u = t.b(lazyThreadSafetyMode, new Function0() { // from class: com.bxkj.student.v2.common.data.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List u02;
                u02 = i.u0();
                return u02;
            }
        });
        f20678v = t.b(lazyThreadSafetyMode, new Function0() { // from class: com.bxkj.student.v2.common.data.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List v02;
                v02 = i.v0();
                return v02;
            }
        });
        f20679w = t.b(lazyThreadSafetyMode, new Function0() { // from class: com.bxkj.student.v2.common.data.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List x02;
                x02 = i.x0();
                return x02;
            }
        });
        H = t.b(lazyThreadSafetyMode, new Function0() { // from class: com.bxkj.student.v2.common.data.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MutableLiveData t02;
                t02 = i.t0();
                return t02;
            }
        });
        I = t.b(lazyThreadSafetyMode, new Function0() { // from class: com.bxkj.student.v2.common.data.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MutableLiveData s02;
                s02 = i.s0();
                return s02;
            }
        });
        J = new ArrayList();
        K = new LatLng(0.0d, 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableLiveData s0() {
        return new MutableLiveData(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableLiveData t0() {
        return new MutableLiveData(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u0() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List v0() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map w0() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List x0() {
        return new ArrayList();
    }

    private i() {
    }
}
