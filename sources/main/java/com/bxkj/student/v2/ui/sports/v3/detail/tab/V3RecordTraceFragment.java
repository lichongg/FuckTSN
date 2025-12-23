package com.bxkj.student.v2.ui.sports.v3.detail.tab;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import cn.bluemobi.dylan.base.utils.o;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.bxkj.base.v2.base.BaseFragment;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.R;
import com.bxkj.student.databinding.FmV3SportsTraceBinding;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.bxkj.student.run.app.utils.p;
import com.bxkj.student.run.app.utils.q;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.utils.s;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import kotlin.n;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3RecordTraceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3RecordTraceFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 JsonGet.kt\ncom/bxkj/base/v2/common/utils/JsonGet\n*L\n1#1,413:1\n1869#2:414\n1563#2:415\n1634#2,3:416\n1870#2:419\n1869#2:420\n1870#2:422\n1056#2:423\n2756#2:424\n1563#2:426\n1634#2,3:427\n1563#2:430\n1634#2,3:431\n1#3:421\n1#3:425\n70#4,4:434\n*S KotlinDebug\n*F\n+ 1 V3RecordTraceFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment\n*L\n100#1:414\n102#1:415\n102#1:416,3\n100#1:419\n119#1:420\n119#1:422\n132#1:423\n132#1:424\n189#1:426\n189#1:427,3\n260#1:430\n260#1:431,3\n132#1:425\n80#1:434,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RecordTraceFragment extends BaseFragment<FmV3SportsTraceBinding, RecordDetailVM> {

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private AMap f21681l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private Bundle f21682m;

    /* renamed from: n, reason: collision with root package name */
    private final LatLngBounds.Builder f21683n = LatLngBounds.builder();

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private List<LatLng> f21684o = new ArrayList();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 V3RecordTraceFragment.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/tab/V3RecordTraceFragment\n*L\n1#1,328:1\n132#2:329\n*E\n"})
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            c0 c0Var = c0.f16887a;
            return kotlin.comparisons.a.l(Integer.valueOf(c0Var.k((Map) t5, "sort")), Integer.valueOf(c0Var.k((Map) t6, "sort")));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements AMap.OnCameraChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private boolean f21685a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<Map<String, Object>> f21687c;

        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends Map<String, ? extends Object>> list) {
            this.f21687c = list;
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChange(CameraPosition cameraPosition) {
            g0.p(cameraPosition, "cameraPosition");
        }

        @Override // com.amap.api.maps.AMap.OnCameraChangeListener
        public void onCameraChangeFinish(CameraPosition cameraPosition) {
            g0.p(cameraPosition, "cameraPosition");
            if (this.f21685a) {
                return;
            }
            this.f21685a = true;
            q qVar = new q();
            int size = V3RecordTraceFragment.this.f21684o.size();
            for (int i6 = 1; i6 < size; i6++) {
                LatLng latLng = (LatLng) V3RecordTraceFragment.this.f21684o.get(i6 - 1);
                LatLng latLng2 = (LatLng) V3RecordTraceFragment.this.f21684o.get(i6);
                AMap aMap = V3RecordTraceFragment.this.f21681l;
                g0.m(aMap);
                Point screenLocation = aMap.getProjection().toScreenLocation(latLng);
                AMap aMap2 = V3RecordTraceFragment.this.f21681l;
                g0.m(aMap2);
                Point screenLocation2 = aMap2.getProjection().toScreenLocation(latLng2);
                int color = ContextCompat.getColor(V3RecordTraceFragment.this.H(), 2131100565);
                qVar.a(screenLocation, screenLocation2, color, color);
            }
            V3RecordTraceFragment.this.L().rpv.setPath(qVar);
            RecordPathView recordPathView = V3RecordTraceFragment.this.L().rpv;
            final V3RecordTraceFragment v3RecordTraceFragment = V3RecordTraceFragment.this;
            final List<Map<String, Object>> list = this.f21687c;
            recordPathView.setOnAnimEnd(new RecordPathView.d() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.j
                @Override // com.bxkj.student.run.app.utils.RecordPathView.d
                public final void a() {
                    V3RecordTraceFragment.b.b(V3RecordTraceFragment.this, list);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(V3RecordTraceFragment v3RecordTraceFragment, List list) {
            v3RecordTraceFragment.L().map.setForeground(new ColorDrawable(ContextCompat.getColor(v3RecordTraceFragment.H(), 2131100584)));
            v3RecordTraceFragment.L().rpv.e();
            v3RecordTraceFragment.L().rpv.setVisibility(8);
            v3RecordTraceFragment.m(list, new ArrayList());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nJsonGet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonGet.kt\ncom/bxkj/base/v2/common/utils/JsonGet$jsonToObject$1\n*L\n1#1,575:1\n*E\n"})
    public static final class c extends TypeToken<List<? extends List<? extends Map<String, ? extends Object>>>> {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21688a;

        d(Function1 function) {
            g0.p(function, "function");
            this.f21688a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof b0)) {
                return g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final n<?> getFunctionDelegate() {
            return this.f21688a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21688a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e implements AMap.OnMapScreenShotListener {
        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap, int i6) {
            g0.p(bitmap, "bitmap");
        }

        e() {
        }

        @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
        public void onMapScreenShot(Bitmap bitmap) {
            g0.p(bitmap, "bitmap");
            V3RecordTraceFragment v3RecordTraceFragment = V3RecordTraceFragment.this;
            MaterialCardView cardBottom = v3RecordTraceFragment.L().cardBottom;
            g0.o(cardBottom, "cardBottom");
            Bitmap O = v3RecordTraceFragment.O(bitmap, v3RecordTraceFragment.N(cardBottom));
            if (O != null) {
                FragmentActivity r5 = V3RecordTraceFragment.this.r();
                g0.n(r5, "null cannot be cast to non-null type com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity");
                ((V3RecordDetailActivity) r5).Q(O);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap O(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        Bitmap createBitmap = Bitmap.createBitmap(width, bitmap2.getHeight() + height, Bitmap.Config.ARGB_8888);
        g0.o(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(255, 224, 224, 224);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(bitmap2, (width - width2) - u.a(10.0f, H()), height, (Paint) null);
        Paint paint = new Paint(1);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setTextSize(u.a(20.0f, H()));
        Rect rect = new Rect();
        String str = getString(2131951695) + "-" + s.f20923a.d(c0.f16887a.k(L().getDataMap(), "sportType"));
        paint.getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, u.a(20.0f, H()), u.a(20.0f, H()), paint);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private final void S(List<? extends Map<String, ? extends Object>> list) {
        List<? extends Map<String, ? extends Object>> list2 = list;
        ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            arrayList.add(new LatLng(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o")));
        }
        List<LatLng> d6 = f0.d6(arrayList);
        this.f21684o = d6;
        if (d6.isEmpty()) {
            return;
        }
        if (this.f21684o.size() > 2) {
            p pVar = new p();
            pVar.p(1);
            List<LatLng> k6 = pVar.k(this.f21684o);
            if (k6 != null && k6.size() > 0) {
                this.f21684o = k6;
            }
            com.orhanobut.logger.j.d("优化前latLngs=" + list.size() + "优化后latLngs=" + this.f21684o.size(), new Object[0]);
        }
        if (this.f21684o.size() == 1) {
            List<LatLng> list3 = this.f21684o;
            list3.add(list3.get(0));
        }
        MarkerOptions draggable = new MarkerOptions().position(this.f21684o.get(0)).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_start)).zIndex(9.0f).draggable(true);
        AMap aMap = this.f21681l;
        g0.m(aMap);
        Marker addMarker = aMap.addMarker(draggable);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f);
        scaleAnimation.setDuration(1000L);
        addMarker.setAnimation(scaleAnimation);
        addMarker.startAnimation();
        AMap aMap2 = this.f21681l;
        g0.m(aMap2);
        aMap2.setOnCameraChangeListener(new b(list));
        Iterator<LatLng> it2 = this.f21684o.iterator();
        while (it2.hasNext()) {
            this.f21683n.include(it2.next()).build();
        }
    }

    private final String M(long j6) {
        long j7 = 1024;
        long j8 = j7 * 1024;
        long j9 = j7 * j8;
        if (j6 >= j9) {
            t0 t0Var = t0.f44062a;
            String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Float.valueOf(j6 / j9)}, 1));
            g0.o(format, "format(...)");
            return format;
        }
        if (j6 >= j8) {
            float f6 = j6 / j8;
            t0 t0Var2 = t0.f44062a;
            String format2 = String.format(f6 > 100.0f ? "%.0f MB" : "%.1f MB", Arrays.copyOf(new Object[]{Float.valueOf(f6)}, 1));
            g0.o(format2, "format(...)");
            return format2;
        }
        if (j6 < 1024) {
            t0 t0Var3 = t0.f44062a;
            String format3 = String.format("%d B", Arrays.copyOf(new Object[]{Long.valueOf(j6)}, 1));
            g0.o(format3, "format(...)");
            return format3;
        }
        float f7 = j6 / 1024;
        t0 t0Var4 = t0.f44062a;
        String format4 = String.format(f7 > 100.0f ? "%.0f KB" : "%.1f KB", Arrays.copyOf(new Object[]{Float.valueOf(f7)}, 1));
        g0.o(format4, "format(...)");
        return format4;
    }

    private final void P(List<LatLng> list) {
        AMap aMap = this.f21681l;
        if (aMap != null) {
            aMap.addPolyline(new PolylineOptions().addAll(list).width(u.a(6.0f, H())).setDottedLine(true).color(ContextCompat.getColor(H(), 2131099715)).zIndex(u.a(5.0f, H())));
        }
    }

    private final void R() {
        List<Marker> mapScreenMarkers;
        AMap aMap = this.f21681l;
        if (aMap == null || (mapScreenMarkers = aMap.getMapScreenMarkers()) == null) {
            return;
        }
        for (Marker marker : mapScreenMarkers) {
            if (marker != null) {
                if (!marker.isInfoWindowShown()) {
                    marker = null;
                }
                if (marker != null) {
                    marker.hideInfoWindow();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T(final V3RecordTraceFragment v3RecordTraceFragment, Map map) {
        Object obj;
        List<Integer> m6 = c0.f16887a.m(map, "stepNumbers");
        int size = m6.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += m6.get(i7).intValue();
        }
        g0.m(map);
        Map<String, Object> J0 = i1.J0(map);
        J0.put("stepCount", String.valueOf(i6));
        v3RecordTraceFragment.L().setDataMap(J0);
        c0 c0Var = c0.f16887a;
        List<Map<String, Object>> n6 = c0Var.n(map, "pointList");
        List<Map<String, Object>> n7 = c0Var.n(map, "okPointList");
        int k6 = c0Var.k(map, "isSequencePoint");
        List<Map<String, Object>> list = JsonParse.getList(map, "gitudeLatitude");
        g0.o(list, "getList(...)");
        v3RecordTraceFragment.S(list);
        v3RecordTraceFragment.n(n6, n7, k6);
        try {
            obj = new Gson().fromJson(c0Var.t(map, "geofence"), new c().getType());
        } catch (Exception unused) {
            obj = null;
        }
        List<? extends List<? extends Map<String, ? extends Object>>> list2 = (List) obj;
        if (list2 != null) {
            v3RecordTraceFragment.l(list2);
        }
        AMap aMap = v3RecordTraceFragment.f21681l;
        if (aMap != null) {
            aMap.setOnMapClickListener(new AMap.OnMapClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.g
                @Override // com.amap.api.maps.AMap.OnMapClickListener
                public final void onMapClick(LatLng latLng) {
                    V3RecordTraceFragment.U(V3RecordTraceFragment.this, latLng);
                }
            });
        }
        return n1.f44123a;
    }

    private final void l(List<? extends List<? extends Map<String, ? extends Object>>> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<Map<String, ? extends Object>> list2 = (List) it.next();
            ArrayList arrayList = new ArrayList(f0.d0(list2, 10));
            for (Map<String, ? extends Object> map : list2) {
                c0 c0Var = c0.f16887a;
                arrayList.add(new LatLng(Double.parseDouble(c0Var.t(map, com.umeng.analytics.pro.d.C)), Double.parseDouble(c0Var.t(map, com.umeng.analytics.pro.d.D))));
            }
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.addAll(arrayList);
            polygonOptions.fillColor(r().getResources().getColor(R.color.fill));
            polygonOptions.strokeColor(r().getResources().getColor(R.color.stroke));
            polygonOptions.strokeWidth(4.0f);
            AMap aMap = this.f21681l;
            if (aMap != null) {
                aMap.addPolygon(polygonOptions);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(List<? extends Map<String, ? extends Object>> list, List<? extends Map<String, ? extends Object>> list2) {
        List<? extends Map<String, ? extends Object>> list3 = list;
        ArrayList arrayList = new ArrayList(f0.d0(list3, 10));
        for (Iterator it = list3.iterator(); it.hasNext(); it = it) {
            Map map = (Map) it.next();
            arrayList.add(new PointData(JsonParse.getDouble(map, "a"), JsonParse.getDouble(map, "o"), JsonParse.getLong(map, bi.aL), JsonParse.getFloat(map, "s"), JsonParse.getBoolean(map, "i"), JsonParse.getInt(map, t.f36143d), JsonParse.getLong(map, "c"), JsonParse.getInt(map, "e")));
        }
        new com.bxkj.student.v2.common.utils.g(H(), this.f21681l).a(arrayList);
        BitmapDescriptor fromResource = BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_end);
        MarkerOptions markerOptions = new MarkerOptions();
        List<LatLng> list4 = this.f21684o;
        MarkerOptions draggable = markerOptions.position(list4.get(list4.size() - 1)).icon(fromResource).zIndex(9.0f).draggable(true);
        AMap aMap = this.f21681l;
        g0.m(aMap);
        aMap.addMarker(draggable);
    }

    private final void n(List<? extends Map<String, ? extends Object>> list, List<? extends Map<String, ? extends Object>> list2, int i6) {
        Iterator it = f0.z5(list, new a()).iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Map<String, ? extends Object> map = (Map) it.next();
            LatLngBounds.Builder builder = this.f21683n;
            c0 c0Var = c0.f16887a;
            builder.include(new LatLng(c0Var.f(map, "latitude"), c0Var.f(map, "longitude")));
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                c0 c0Var2 = c0.f16887a;
                if (g0.g(c0Var2.t((Map) next, "id"), c0Var2.t(map, "id"))) {
                    obj = next;
                    break;
                }
            }
            Map<String, ? extends Object> map2 = (Map) obj;
            String str = "";
            if (map2 == null) {
                c0 c0Var3 = c0.f16887a;
                LatLng latLng = new LatLng(c0Var3.f(map, "latitude"), c0Var3.f(map, "longitude"));
                String t5 = i6 == 1 ? c0Var3.t(map, "sort") : "经";
                if (i6 == 1) {
                    str = "第" + c0Var3.t(map, "sort") + "个";
                }
                MarkerOptions draggable = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.c.f20881a.b(t5))).zIndex(9.0f).title("你未通过" + str + "必经点：" + c0Var3.t(map, "content")).draggable(false);
                AMap aMap = this.f21681l;
                if (aMap != null) {
                    aMap.addMarker(draggable);
                }
            } else {
                String t6 = i6 == 1 ? c0.f16887a.t(map2, "sort") : "√";
                if (i6 == 1) {
                    str = "第" + c0.f16887a.t(map2, "sort") + "个";
                }
                BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.c.f20881a.c(t6));
                c0 c0Var4 = c0.f16887a;
                MarkerOptions draggable2 = new MarkerOptions().position(new LatLng(c0Var4.f(map2, "latitude"), c0Var4.f(map2, "longitude"))).icon(fromBitmap).zIndex(9.0f).title("你已经通过" + str + "必经点:" + c0Var4.t(map2, "content")).draggable(false);
                AMap aMap2 = this.f21681l;
                if (aMap2 != null) {
                    aMap2.addMarker(draggable2);
                }
            }
        }
        AMap aMap3 = this.f21681l;
        if (aMap3 != null) {
            aMap3.animateCamera(CameraUpdateFactory.newLatLngBounds(this.f21683n.build(), u.a(50.0f, H())), 2000L, null);
        }
    }

    @NotNull
    public final Bitmap N(@NotNull View view) {
        g0.p(view, "view");
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        g0.o(drawingCache, "getDrawingCache(...)");
        return drawingCache;
    }

    public final LatLngBounds.Builder Q() {
        return this.f21683n;
    }

    public final void W() {
        AMap aMap = this.f21681l;
        if (aMap != null) {
            aMap.getMapScreenShot(new e());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        g0.p(outState, "outState");
        super.onSaveInstanceState(outState);
        L().map.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        FragmentActivity requireActivity = requireActivity();
        g0.o(requireActivity, "requireActivity(...)");
        x((BaseViewModel) new ViewModelProvider(requireActivity).get(RecordDetailVM.class));
        D().w().observe(requireActivity(), new d(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 T;
                T = V3RecordTraceFragment.T(V3RecordTraceFragment.this, (Map) obj);
                return T;
            }
        }));
        D().F().observe(requireActivity(), new d(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.tab.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 V;
                V = V3RecordTraceFragment.V(V3RecordTraceFragment.this, (Map) obj);
                return V;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(V3RecordTraceFragment v3RecordTraceFragment, LatLng latLng) {
        v3RecordTraceFragment.R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 V(V3RecordTraceFragment v3RecordTraceFragment, Map map) {
        o.f(v3RecordTraceFragment.H(), c0.f16887a.t(map, "imageRouteUrl"), v3RecordTraceFragment.L().ivHead, R.mipmap.v3_head_icon, R.mipmap.v3_head_icon);
        return n1.f44123a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.f21682m = bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        L().map.onDestroy();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        L().map.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        L().map.onResume();
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        FragmentActivity requireActivity = requireActivity();
        g0.o(requireActivity, "requireActivity(...)");
        d(requireActivity);
        this.f21681l = L().map.getMap();
        L().map.onCreate(this.f21682m);
        L().map.setForeground(new ColorDrawable(ContextCompat.getColor(H(), 2131100543)));
    }
}
