package com.bxkj.student.v2.common.utils;

import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.v2.common.data.PointData;
import com.umeng.analytics.pro.bi;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20949a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTestCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestCase.kt\ncom/bxkj/student/v2/common/utils/TestCase$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,107:1\n1563#2:108\n1634#2,3:109\n1563#2:112\n1634#2,3:113\n*S KotlinDebug\n*F\n+ 1 TestCase.kt\ncom/bxkj/student/v2/common/utils/TestCase$Companion\n*L\n24#1:108\n24#1:109,3\n75#1:112\n75#1:113,3\n*E\n"})
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final List<Map<String, Object>> a(@NotNull List<Map<String, Object>> jsonToListMap) {
            g0.p(jsonToListMap, "jsonToListMap");
            new com.bxkj.student.run.app.utils.o();
            List<Map<String, Object>> list = jsonToListMap;
            ArrayList arrayList = new ArrayList(f0.d0(list, 10));
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                Map map = (Map) it.next();
                arrayList.add(new PointData(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o"), (long) JsonParse.getDouble(map, bi.aL), JsonParse.getFloat(map, "s"), JsonParse.getBoolean(map, "i"), JsonParse.getInt(map, com.kuaishou.weapon.p0.t.f36143d), JsonParse.getLong(map, "c"), JsonParse.getInt(map, "e")));
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            arrayList2.add(arrayList.get(0));
            arrayList3.add(jsonToListMap.get(0));
            PointData pointData = (PointData) arrayList.get(0);
            int size = arrayList.size();
            for (int i6 = 1; i6 < size; i6++) {
                PointData pointData2 = (PointData) arrayList.get(i6);
                if (h.f20892a.E(pointData, pointData2)) {
                    arrayList2.add(pointData2);
                    arrayList3.add(jsonToListMap.get(i6));
                    pointData = pointData2;
                } else {
                    com.orhanobut.logger.j.d("漂移点", new Object[0]);
                }
            }
            return arrayList3;
        }

        public final void b(@NotNull List<? extends Map<String, ? extends Object>> dataList) {
            ArrayList arrayList;
            ArrayList arrayList2;
            g0.p(dataList, "dataList");
            new com.bxkj.student.run.app.utils.o();
            List<? extends Map<String, ? extends Object>> list = dataList;
            ArrayList arrayList3 = new ArrayList(f0.d0(list, 10));
            for (Map<String, ? extends Object> map : list) {
                c0 c0Var = c0.f16887a;
                arrayList3.add(new PointData(c0Var.f(map, "a"), c0Var.f(map, "o"), (long) c0Var.f(map, bi.aL), c0Var.i(map, "s"), c0Var.d(map, "i"), (int) c0Var.f(map, com.kuaishou.weapon.p0.t.f36143d), (long) c0Var.f(map, "c"), JsonParse.getInt(map, "e")));
            }
            PointData pointData = (PointData) arrayList3.get(0);
            long t5 = ((PointData) arrayList3.get(0)).getT();
            int size = arrayList3.size();
            double d6 = 0.0d;
            int i6 = 1;
            long j6 = 0;
            while (i6 < size) {
                PointData pointData2 = (PointData) arrayList3.get(i6);
                if (!h.f20892a.E(pointData, pointData2)) {
                    arrayList = arrayList3;
                    if (!pointData2.isI()) {
                        j6 += pointData2.getT() - t5;
                        if (pointData2.getC() == 0) {
                            pointData2.setC(j6);
                        }
                        BigDecimal divide = new BigDecimal(d6).divide(new BigDecimal(pointData2.getC()), 10, 4);
                        arrayList2 = arrayList;
                        BigDecimal divide2 = divide.multiply(new BigDecimal(pointData2.getT() - ((PointData) arrayList2.get(i6 - 1)).getT())).divide(new BigDecimal(1000), 10, 5);
                        com.orhanobut.logger.j.e("countDistance=" + d6 + " countTime=" + pointData2.getC() + " avg=" + divide + " appendDistance=" + divide2, new Object[0]);
                        d6 += divide2.doubleValue();
                        t5 = pointData2.getT();
                        i6++;
                        pointData = pointData2;
                        arrayList3 = arrayList2;
                    }
                } else if (pointData2.isI()) {
                    arrayList = arrayList3;
                } else {
                    j6 += pointData2.getT() - t5;
                    arrayList = arrayList3;
                    d6 += AMapUtils.calculateLineDistance(new LatLng(pointData2.getA(), pointData2.getO()), new LatLng(pointData.getA(), pointData.getO()));
                }
                arrayList2 = arrayList;
                t5 = pointData2.getT();
                i6++;
                pointData = pointData2;
                arrayList3 = arrayList2;
            }
            com.orhanobut.logger.j.m("最终countDistance=" + d6 + " countTime=" + com.bxkj.student.run.app.utils.i.g(((PointData) arrayList3.get(r9.size() - 1)).getC()), new Object[0]);
        }
    }
}
