package com.bxkj.student.v2.common.data;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.v2.common.utils.h;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bi;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20683a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSportsDataAnalysis.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportsDataAnalysis.kt\ncom/bxkj/student/v2/common/data/SportsDataAnalysis$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,532:1\n1563#2:533\n1634#2,3:534\n1563#2:537\n1634#2,3:538\n774#2:541\n865#2,2:542\n774#2:544\n865#2,2:545\n774#2:547\n865#2,2:548\n774#2:550\n865#2,2:551\n1#3:553\n*S KotlinDebug\n*F\n+ 1 SportsDataAnalysis.kt\ncom/bxkj/student/v2/common/data/SportsDataAnalysis$Companion\n*L\n35#1:533\n35#1:534,3\n176#1:537\n176#1:538,3\n188#1:541\n188#1:542,2\n191#1:544\n191#1:545,2\n194#1:547\n194#1:548,2\n197#1:550\n197#1:551,2\n*E\n"})
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        public final double a(double d6, long j6) {
            if (d6 == 0.0d) {
                return 0.0d;
            }
            return new BigDecimal(j6).divide(new BigDecimal(60), 10, 4).divide(new BigDecimal(d6), 10, 4).multiply(new BigDecimal(1000)).setScale(2, 4).doubleValue();
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x029b  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x02a0  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0319  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0371  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x038d  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0343  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x02ff  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x029d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(double r39, @org.jetbrains.annotations.NotNull java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r41, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.List<java.lang.Double>, kotlin.n1> r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.List<java.lang.Double>, kotlin.n1> r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.List<java.lang.Double>, kotlin.n1> r44, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.n1> r45) {
            /*
                Method dump skipped, instructions count: 1180
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.data.j.a.b(double, java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
        }

        public final int c(int i6, double d6, int i7, double d7) {
            if (i6 != 0) {
                double d8 = d6 * 1000;
                a aVar = i7 != 0 ? this : null;
                if (aVar != null) {
                    if (d8 == 0.0d) {
                        aVar = null;
                    }
                    if (aVar != null) {
                        if ((d7 > d8 ? aVar : null) != null) {
                            try {
                                return (int) Math.ceil(new BigDecimal(i7).multiply(new BigDecimal(d7).divide(new BigDecimal(d8), 10, 4)).doubleValue());
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                return -1;
                            }
                        }
                    }
                }
            }
            return i7;
        }

        public final int d(double d6, int i6, double d7) {
            double d8 = d6 * 1000;
            a aVar = i6 != -1 ? this : null;
            if (aVar != null) {
                if (d8 == 0.0d) {
                    aVar = null;
                }
                if (aVar != null) {
                    if ((d7 > d8 ? aVar : null) != null) {
                        try {
                            return (int) Math.ceil(new BigDecimal(i6).multiply(new BigDecimal(d7).divide(new BigDecimal(d8), 10, 4)).doubleValue());
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            return -1;
                        }
                    }
                }
            }
            return i6;
        }

        public final void e(@NotNull List<? extends Map<String, ? extends Object>> dataList) {
            BigDecimal bigDecimal;
            PointData pointData;
            g0.p(dataList, "dataList");
            if (dataList.isEmpty()) {
                return;
            }
            List<? extends Map<String, ? extends Object>> list = dataList;
            ArrayList arrayList = new ArrayList(f0.d0(list, 10));
            for (Map<String, ? extends Object> map : list) {
                c0 c0Var = c0.f16887a;
                arrayList.add(new PointData(c0Var.f(map, "a"), c0Var.f(map, "o"), (long) c0Var.f(map, bi.aL), c0Var.i(map, "s"), c0Var.d(map, "i"), (int) c0Var.f(map, t.f36143d), (long) c0Var.f(map, "c"), c0Var.k(map, "e")));
            }
            PointData pointData2 = (PointData) arrayList.get(0);
            double d6 = 0.0d;
            com.bxkj.student.v2.common.utils.h.f20892a.u(0.0d);
            int size = arrayList.size();
            double d7 = 0.0d;
            double d8 = 0.0d;
            int i6 = 1;
            PointData pointData3 = null;
            int i7 = 0;
            while (i6 < size) {
                PointData pointData4 = (PointData) arrayList.get(i6);
                double d9 = d6;
                ArrayList arrayList2 = arrayList;
                PointData pointData5 = pointData2;
                BigDecimal valueOf = BigDecimal.valueOf(AMapUtils.calculateLineDistance(new LatLng(pointData4.getA(), pointData4.getO()), new LatLng(pointData2.getA(), pointData5.getO())));
                if (pointData4.getE() == 0) {
                    pointData2 = pointData5;
                } else {
                    if (!pointData4.isI()) {
                        double s5 = pointData4.getS();
                        h.a aVar = com.bxkj.student.v2.common.utils.h.f20892a;
                        if (s5 > aVar.l()) {
                            BigDecimal divide = new BigDecimal(d7).divide(new BigDecimal(pointData4.getC()), 10, 4);
                            BigDecimal divide2 = new BigDecimal(pointData4.getT() - pointData5.getT()).abs().divide(new BigDecimal(1000), 10, 4);
                            com.orhanobut.logger.j.m("漂移点countDistance=" + d7 + " countTime=" + pointData4.getC() + " avg=" + divide + " time=" + divide2 + " appendDistance=" + valueOf, new Object[0]);
                            valueOf = divide.multiply(divide2);
                        }
                        if (pointData5.isI() || pointData4.isI()) {
                            if (pointData3 != null) {
                                com.orhanobut.logger.j.e("中途出现了暂停的点，将丢失的点位置空，重新按规则计算", new Object[0]);
                                bigDecimal = valueOf;
                                pointData = null;
                                double doubleValue = new BigDecimal(d7).add(valueOf).doubleValue();
                                d8 = new BigDecimal(d8).add(bigDecimal).doubleValue();
                                d7 = aVar.c((int) pointData4.getE(), pointData4.getC(), doubleValue, pointData4.getC());
                                pointData3 = pointData;
                            }
                            bigDecimal = valueOf;
                            pointData = pointData3;
                            double doubleValue2 = new BigDecimal(d7).add(valueOf).doubleValue();
                            d8 = new BigDecimal(d8).add(bigDecimal).doubleValue();
                            d7 = aVar.c((int) pointData4.getE(), pointData4.getC(), doubleValue2, pointData4.getC());
                            pointData3 = pointData;
                        } else if (pointData4.getT() - pointData5.getT() > 10000) {
                            com.orhanobut.logger.j.e("进入隧道算法，超过10秒未获取到定位点", new Object[0]);
                            valueOf = BigDecimal.valueOf(d9);
                            bigDecimal = BigDecimal.valueOf(d9);
                            pointData = pointData5;
                            i7 = 0;
                            double doubleValue22 = new BigDecimal(d7).add(valueOf).doubleValue();
                            d8 = new BigDecimal(d8).add(bigDecimal).doubleValue();
                            d7 = aVar.c((int) pointData4.getE(), pointData4.getC(), doubleValue22, pointData4.getC());
                            pointData3 = pointData;
                        } else {
                            if (pointData3 != null) {
                                i7++;
                                valueOf = BigDecimal.valueOf(d9);
                                bigDecimal = BigDecimal.valueOf(d9);
                                com.orhanobut.logger.j.e("扔掉第" + i7 + "个点", new Object[0]);
                                if (i7 == 10) {
                                    valueOf = BigDecimal.valueOf(AMapUtils.calculateLineDistance(new LatLng(pointData4.getA(), pointData4.getO()), new LatLng(pointData3.getA(), pointData3.getO())));
                                    com.orhanobut.logger.j.e("进入隧道算法，恢复10个定位点后补偿距离算法补偿后的appendDistance=" + valueOf + " gpsAppendDistance=" + valueOf, new Object[0]);
                                    bigDecimal = valueOf;
                                    pointData = null;
                                    double doubleValue222 = new BigDecimal(d7).add(valueOf).doubleValue();
                                    d8 = new BigDecimal(d8).add(bigDecimal).doubleValue();
                                    d7 = aVar.c((int) pointData4.getE(), pointData4.getC(), doubleValue222, pointData4.getC());
                                    pointData3 = pointData;
                                }
                                pointData = pointData3;
                                double doubleValue2222 = new BigDecimal(d7).add(valueOf).doubleValue();
                                d8 = new BigDecimal(d8).add(bigDecimal).doubleValue();
                                d7 = aVar.c((int) pointData4.getE(), pointData4.getC(), doubleValue2222, pointData4.getC());
                                pointData3 = pointData;
                            }
                            bigDecimal = valueOf;
                            pointData = pointData3;
                            double doubleValue22222 = new BigDecimal(d7).add(valueOf).doubleValue();
                            d8 = new BigDecimal(d8).add(bigDecimal).doubleValue();
                            d7 = aVar.c((int) pointData4.getE(), pointData4.getC(), doubleValue22222, pointData4.getC());
                            pointData3 = pointData;
                        }
                    }
                    pointData2 = pointData4;
                }
                i6++;
                d6 = d9;
                arrayList = arrayList2;
            }
            com.orhanobut.logger.j.e("最终countDistance=" + d7 + " \n时间" + com.bxkj.student.run.app.utils.i.g(((PointData) arrayList.get(arrayList.size() - 1)).getC()) + "\nGPS原始距离" + d8, new Object[0]);
        }

        @NotNull
        public final String f(double d6) {
            BigDecimal[] divideAndRemainder = new BigDecimal(d6).divideAndRemainder(BigDecimal.ONE);
            BigDecimal bigDecimal = divideAndRemainder[0];
            BigDecimal bigDecimal2 = divideAndRemainder[1];
            return bigDecimal.intValue() + "'" + new DecimalFormat("00").format(bigDecimal2.multiply(new BigDecimal(60)).setScale(0, 4)) + "\"";
        }

        @NotNull
        public final String g(@NotNull m0.d sportsDb) {
            g0.p(sportsDb, "sportsDb");
            c0 c0Var = c0.f16887a;
            Map<String, Object> A = c0Var.A(sportsDb.N());
            double d6 = 1000;
            if (Double.parseDouble(sportsDb.C()) < c0Var.f(A, "totalRange") * d6) {
                return "运动距离不符合";
            }
            if (com.bxkj.student.run.app.utils.i.t(sportsDb.R()) < c0Var.f(A, "step")) {
                return "运动步数不符合";
            }
            int k6 = c0Var.k(A, "startQualifiedTime");
            int d7 = d(c0Var.f(A, "totalRange"), c0Var.k(A, "endQualifiedTime"), com.bxkj.student.run.app.utils.i.e(Double.parseDouble(sportsDb.C())) * d6);
            if (Double.parseDouble(sportsDb.B()) >= k6 * 60 && (d7 == -1 || Double.parseDouble(sportsDb.B()) <= d7 * 60)) {
                return c0Var.z(sportsDb.L()).size() < c0Var.n(A, "list").size() ? "未经过必经点" : "";
            }
            com.orhanobut.logger.j.d("时间无效", new Object[0]);
            return "运动时间不符合";
        }

        public final double h(double d6) {
            if (d6 == 0.0d) {
                return -0.0d;
            }
            BigDecimal bigDecimal = new BigDecimal(1);
            BigDecimal bigDecimal2 = new BigDecimal(d6);
            BigDecimal bigDecimal3 = new BigDecimal(60);
            RoundingMode roundingMode = RoundingMode.HALF_UP;
            return bigDecimal.divide(bigDecimal2.divide(bigDecimal3, 10, roundingMode), 2, roundingMode).doubleValue();
        }

        public final double i(double d6) {
            if (d6 == 0.0d) {
                return 0.0d;
            }
            return new BigDecimal(1000).divide(new BigDecimal(d6).multiply(new BigDecimal(60)), 2, RoundingMode.HALF_UP).doubleValue();
        }

        public final double j(double d6) {
            if (d6 == 0.0d) {
                return 0.0d;
            }
            BigDecimal bigDecimal = new BigDecimal(1);
            BigDecimal bigDecimal2 = new BigDecimal(60);
            RoundingMode roundingMode = RoundingMode.HALF_UP;
            return bigDecimal.divide(bigDecimal2, 10, roundingMode).divide(new BigDecimal(d6).divide(new BigDecimal(1000), 10, roundingMode), 10, roundingMode).setScale(2, roundingMode).doubleValue();
        }
    }
}
