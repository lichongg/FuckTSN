package com.bxkj.student.v2.common.utils;

import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.v2.common.data.PointData;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLineCheck.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LineCheck.kt\ncom/bxkj/student/v2/common/utils/LineCheck\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,32:1\n1563#2:33\n1634#2,3:34\n1761#2,3:37\n*S KotlinDebug\n*F\n+ 1 LineCheck.kt\ncom/bxkj/student/v2/common/utils/LineCheck\n*L\n15#1:33\n15#1:34,3\n17#1:37,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f20905a = new j();

    public final boolean a(@NotNull List<? extends Map<String, ? extends Object>> dataList) {
        g0.p(dataList, "dataList");
        if (dataList.size() < 2) {
            return false;
        }
        List<? extends Map<String, ? extends Object>> list = dataList;
        ArrayList arrayList = new ArrayList(f0.d0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf((long) c0.f16887a.f((Map) it.next(), bi.aL)));
        }
        List<Pair> s6 = f0.s6(arrayList);
        if ((s6 instanceof Collection) && s6.isEmpty()) {
            return false;
        }
        for (Pair pair : s6) {
            if (((Number) pair.component2()).longValue() - ((Number) pair.component1()).longValue() > 60000) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(@NotNull PointData prevPoint, @NotNull PointData currPoint) {
        g0.p(prevPoint, "prevPoint");
        g0.p(currPoint, "currPoint");
        return (prevPoint.getT() == 0 || currPoint.getT() == 0 || prevPoint.isI() || currPoint.isI() || currPoint.getT() - prevPoint.getT() <= 60000) ? false : true;
    }

    private j() {
    }
}
