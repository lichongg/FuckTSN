package com.bxkj.student.v2.common.utils;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.v2.common.data.PointData;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    private static int f20893b;

    /* renamed from: l, reason: collision with root package name */
    private static double f20903l;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20892a = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static double f20894c = 5.0d;

    /* renamed from: d, reason: collision with root package name */
    private static double f20895d = 0.6d;

    /* renamed from: e, reason: collision with root package name */
    private static double f20896e = 0.8d;

    /* renamed from: f, reason: collision with root package name */
    private static double f20897f = 2.3d;

    /* renamed from: g, reason: collision with root package name */
    private static int f20898g = 80;

    /* renamed from: h, reason: collision with root package name */
    private static int f20899h = 150;

    /* renamed from: i, reason: collision with root package name */
    private static int f20900i = 220;

    /* renamed from: j, reason: collision with root package name */
    private static int f20901j = 300;

    /* renamed from: k, reason: collision with root package name */
    private static int f20902k = 1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nDriftUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DriftUtils.kt\ncom/bxkj/student/v2/common/utils/DriftUtils$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,305:1\n1788#2,4:306\n1#3:310\n*S KotlinDebug\n*F\n+ 1 DriftUtils.kt\ncom/bxkj/student/v2/common/utils/DriftUtils$Companion\n*L\n151#1:306,4\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private final double F(double[] dArr) {
            int length = dArr.length;
            double d6 = 0.0d;
            double d7 = 0.0d;
            for (double d8 : dArr) {
                d7 += d8;
            }
            double d9 = length;
            double d10 = d7 / d9;
            for (double d11 : dArr) {
                d6 += (d11 - d10) * (d11 - d10);
            }
            return d6 / d9;
        }

        private final double a(double[] dArr) {
            int length = dArr.length;
            double d6 = 0.0d;
            for (double d7 : dArr) {
                d6 += d7;
            }
            return d6 / length;
        }

        private final double q(int i6) {
            return i6 * f();
        }

        private a() {
        }

        private final double b(int i6, long j6) {
            if (j6 == 0) {
                return 0.0d;
            }
            BigDecimal bigDecimal = new BigDecimal(i6);
            BigDecimal bigDecimal2 = new BigDecimal(j6);
            RoundingMode roundingMode = RoundingMode.HALF_UP;
            return bigDecimal.divide(bigDecimal2, 10, roundingMode).multiply(new BigDecimal(60)).setScale(0, roundingMode).doubleValue();
        }

        public static /* synthetic */ boolean e(a aVar, List list, double d6, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                d6 = 0.0d;
            }
            return aVar.d(list, d6);
        }

        public final double D(@NotNull PointData prePoint, @NotNull PointData curPoint) {
            g0.p(prePoint, "prePoint");
            g0.p(curPoint, "curPoint");
            BigDecimal bigDecimal = new BigDecimal(AMapUtils.calculateLineDistance(new LatLng(prePoint.getA(), prePoint.getO()), new LatLng(curPoint.getA(), curPoint.getO())));
            BigDecimal abs = new BigDecimal(curPoint.getT() - prePoint.getT()).divide(new BigDecimal(1000), 10, 4).abs();
            return abs.doubleValue() == 0.0d ? bigDecimal.doubleValue() : bigDecimal.divide(abs, 10, 4).abs().doubleValue();
        }

        public final boolean E(@NotNull PointData prePoint, @NotNull PointData curPoint) {
            g0.p(prePoint, "prePoint");
            g0.p(curPoint, "curPoint");
            return D(prePoint, curPoint) < l();
        }

        public final double c(int i6, long j6, double d6, long j7) {
            if (j7 <= 180) {
                double b6 = b(i6, j6);
                if (b6 < k()) {
                    return Math.min(q(i6), d6);
                }
                if (b6 > m()) {
                    return Math.min(g(i6), d6);
                }
            }
            return d6;
        }

        public final boolean d(@NotNull List<PointData> latLngList, double d6) {
            int i6;
            g0.p(latLngList, "latLngList");
            List P5 = f0.P5(latLngList, 30);
            com.orhanobut.logger.j.d("lastList.size=" + P5.size() + " exceptionRatio=" + d6, new Object[0]);
            List list = P5;
            if ((list instanceof Collection) && list.isEmpty()) {
                i6 = 0;
            } else {
                Iterator it = list.iterator();
                i6 = 0;
                while (it.hasNext()) {
                    if (((PointData) it.next()).getS() > h.f20892a.l() && (i6 = i6 + 1) < 0) {
                        f0.a0();
                    }
                }
            }
            Integer valueOf = Integer.valueOf(i6);
            if (valueOf.intValue() <= P5.size() * d6) {
                valueOf = null;
            }
            return valueOf != null;
        }

        private final double g(int i6) {
            return m() * f();
        }

        public final void A(int i6) {
            h.f20899h = i6;
        }

        public final void B(double d6) {
            h.f20895d = d6;
        }

        public final void C(int i6) {
            h.f20893b = i6;
        }

        public final double f() {
            return h.f20896e;
        }

        public final int h() {
            return h.f20902k;
        }

        public final double i() {
            return h.f20903l;
        }

        public final int j() {
            return h.f20901j;
        }

        public final int k() {
            return h.f20898g;
        }

        public final double l() {
            return h.f20894c;
        }

        public final int m() {
            return h.f20900i;
        }

        public final double n() {
            return h.f20897f;
        }

        public final int o() {
            return h.f20899h;
        }

        public final double p() {
            return h.f20895d;
        }

        public final int r() {
            return h.f20893b;
        }

        public final void s(double d6) {
            h.f20896e = d6;
        }

        public final void t(int i6) {
            h.f20902k = i6;
        }

        public final void u(double d6) {
            h.f20903l = d6;
        }

        public final void v(int i6) {
            h.f20901j = i6;
        }

        public final void w(int i6) {
            h.f20898g = i6;
        }

        public final void x(double d6) {
            h.f20894c = d6;
        }

        public final void y(int i6) {
            h.f20900i = i6;
        }

        public final void z(double d6) {
            h.f20897f = d6;
        }
    }
}
