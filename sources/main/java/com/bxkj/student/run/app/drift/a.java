package com.bxkj.student.run.app.drift;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.orhanobut.logger.j;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final C0264a f19783a = new C0264a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final int f19784b = 10;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.run.app.drift.a$a, reason: collision with other inner class name */
    public static final class C0264a {
        public /* synthetic */ C0264a(v vVar) {
            this();
        }

        private final double a(double[] dArr) {
            int length = dArr.length;
            double d6 = 0.0d;
            for (double d7 : dArr) {
                d6 += d7;
            }
            return d6 / length;
        }

        private final double d(double[] dArr) {
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

        private C0264a() {
        }

        public final double b(@NotNull LatLngTimeSpeed prePoint, @NotNull LatLngTimeSpeed curPoint) {
            g0.p(prePoint, "prePoint");
            g0.p(curPoint, "curPoint");
            BigDecimal bigDecimal = new BigDecimal(AMapUtils.calculateLineDistance(new LatLng(prePoint.getLatitude(), prePoint.getLongitude()), new LatLng(curPoint.getLatitude(), curPoint.getLongitude())));
            BigDecimal abs = new BigDecimal(curPoint.getTime() - prePoint.getTime()).divide(new BigDecimal(1000), 10, 4).abs();
            if (abs.compareTo(new BigDecimal(0)) == 0) {
                return bigDecimal.doubleValue();
            }
            BigDecimal abs2 = bigDecimal.divide(abs, 10, 4).abs();
            if (abs2.compareTo(new BigDecimal(10)) == 1) {
                j.m("漂移点轨迹过滤器 distance=" + bigDecimal + " time=" + abs + " speed=" + abs2, new Object[0]);
            } else if (bigDecimal.compareTo(new BigDecimal(10)) == 1) {
                j.d("漂移点轨迹过滤器 distance=" + bigDecimal + " time=" + abs + " speed=" + abs2 + " prePoint=" + prePoint + " curPoint=" + curPoint, new Object[0]);
            }
            return abs2.doubleValue();
        }

        public final boolean c(@NotNull LatLngTimeSpeed prePoint, @NotNull LatLngTimeSpeed curPoint) {
            g0.p(prePoint, "prePoint");
            g0.p(curPoint, "curPoint");
            return b(prePoint, curPoint) < 10.0d;
        }

        public final boolean e(@NotNull List<? extends LatLngTimeSpeed> list, @NotNull LatLngTimeSpeed curPoint) {
            g0.p(list, "list");
            g0.p(curPoint, "curPoint");
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i6 = 1; i6 < size; i6++) {
                arrayList.add(Double.valueOf(b(list.get(i6 - 1), list.get(i6))));
            }
            double d6 = d(f0.W5(arrayList));
            double a6 = a(f0.W5(arrayList));
            double b6 = b(list.get(list.size() - 1), curPoint);
            double pow = Math.pow(b6 - a6, 2.0d);
            if (b6 <= a6 || pow <= 10 * d6) {
                return true;
            }
            j.d("漂移点->方差" + d6 + " 平均速度" + a6 + " 当前速度" + b6 + " pow" + pow, new Object[0]);
            return false;
        }
    }
}
