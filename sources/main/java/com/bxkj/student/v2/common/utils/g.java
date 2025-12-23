package com.bxkj.student.v2.common.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nDrawMapLineManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DrawMapLineManager.kt\ncom/bxkj/student/v2/common/utils/DrawMapLineManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f20885a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final AMap f20886b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private List<Integer> f20887c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private PolylineOptions f20888d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private Polyline f20889e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private PolylineOptions f20890f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private Polyline f20891g;

    public g(@NotNull Context mContext, @Nullable AMap aMap) {
        g0.p(mContext, "mContext");
        this.f20885a = mContext;
        this.f20886b = aMap;
        this.f20887c = new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(@org.jetbrains.annotations.Nullable java.util.List<? extends com.bxkj.student.v2.common.data.PointData> r17) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.utils.g.a(java.util.List):void");
    }

    public final void b(@NotNull LatLng newLatLng, @NotNull LatLng lastLatLng, float f6, boolean z5) {
        g0.p(newLatLng, "newLatLng");
        g0.p(lastLatLng, "lastLatLng");
        PolylineOptions polylineOptions = null;
        PolylineOptions polylineOptions2 = null;
        if (z5) {
            Polyline polyline = this.f20891g;
            if (polyline != null) {
                if (polyline != null) {
                    PolylineOptions polylineOptions3 = this.f20890f;
                    if (polylineOptions3 != null) {
                        polylineOptions3.add(newLatLng);
                        polylineOptions3.width(cn.bluemobi.dylan.base.utils.u.a(8.0f, this.f20885a));
                        polylineOptions3.setDottedLine(true);
                        polylineOptions3.color(ContextCompat.getColor(this.f20885a, 2131099715));
                        polylineOptions3.zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, this.f20885a));
                        polylineOptions2 = polylineOptions3;
                    }
                    polyline.setOptions(polylineOptions2);
                    return;
                }
                return;
            }
            this.f20888d = null;
            this.f20889e = null;
            this.f20887c = new ArrayList();
            PolylineOptions polylineOptions4 = new PolylineOptions();
            polylineOptions4.add(lastLatLng, newLatLng);
            polylineOptions4.width(cn.bluemobi.dylan.base.utils.u.a(8.0f, this.f20885a));
            polylineOptions4.setDottedLine(true);
            polylineOptions4.color(ContextCompat.getColor(this.f20885a, 2131099715));
            polylineOptions4.zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, this.f20885a));
            this.f20890f = polylineOptions4;
            AMap aMap = this.f20886b;
            this.f20891g = aMap != null ? aMap.addPolyline(polylineOptions4) : null;
            return;
        }
        this.f20887c.add(Integer.valueOf(com.bxkj.student.run.app.utils.i.s(this.f20885a, f6)));
        Polyline polyline2 = this.f20889e;
        if (polyline2 == null) {
            this.f20890f = null;
            this.f20891g = null;
            PolylineOptions polylineOptions5 = new PolylineOptions();
            polylineOptions5.add(lastLatLng, newLatLng);
            polylineOptions5.width(cn.bluemobi.dylan.base.utils.u.a(6.0f, this.f20885a));
            polylineOptions5.colorValues(this.f20887c);
            polylineOptions5.zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, this.f20885a));
            this.f20888d = polylineOptions5;
            AMap aMap2 = this.f20886b;
            this.f20889e = aMap2 != null ? aMap2.addPolyline(polylineOptions5) : null;
            return;
        }
        if (polyline2 != null) {
            PolylineOptions polylineOptions6 = this.f20888d;
            if (polylineOptions6 != null) {
                polylineOptions6.add(newLatLng);
                polylineOptions6.width(cn.bluemobi.dylan.base.utils.u.a(6.0f, this.f20885a));
                polylineOptions6.colorValues(this.f20887c);
                polylineOptions6.useGradient(true);
                polylineOptions6.zIndex(cn.bluemobi.dylan.base.utils.u.a(5.0f, this.f20885a));
                polylineOptions6.color(com.bxkj.student.run.app.utils.i.s(this.f20885a, f6));
                polylineOptions = polylineOptions6;
            }
            polyline2.setOptions(polylineOptions);
        }
    }

    @Nullable
    public final AMap c() {
        return this.f20886b;
    }

    @NotNull
    public final Context d() {
        return this.f20885a;
    }
}
