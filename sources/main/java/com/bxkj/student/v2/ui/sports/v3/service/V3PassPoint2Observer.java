package com.bxkj.student.v2.ui.sports.v3.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.ext.b0;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.run.app.utils.d0;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer;
import com.bxkj.student.v2.vm.sports.SportsVM;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3PassPoint2Observer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3PassPoint2Observer.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,479:1\n1#2:480\n774#3:481\n865#3,2:482\n1011#3,2:484\n1869#3,2:486\n774#3:488\n865#3,2:489\n1869#3,2:491\n1869#3,2:493\n*S KotlinDebug\n*F\n+ 1 V3PassPoint2Observer.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer\n*L\n123#1:481\n123#1:482,2\n128#1:484,2\n142#1:486,2\n168#1:488\n168#1:489,2\n173#1:491,2\n283#1:493,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3PassPoint2Observer implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final FragmentActivity f21973a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final SportsVM f21974b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final MapView f21975c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final AMap f21976d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private LatLngBounds.Builder f21977e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private final List<Marker> f21978f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private List<Map<String, Object>> f21979g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f21980h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f21981i;

    /* renamed from: j, reason: collision with root package name */
    private int f21982j;

    /* renamed from: k, reason: collision with root package name */
    private double f21983k;

    /* renamed from: l, reason: collision with root package name */
    private double f21984l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f21985m;

    /* renamed from: n, reason: collision with root package name */
    private int f21986n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final BroadcastReceiver f21987o;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<File> f21989b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21990c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<n1> f21991d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\nV3PassPoint2Observer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3PassPoint2Observer.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer$camera$4$onActivityResult$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
        /* renamed from: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$a$a, reason: collision with other inner class name */
        public static final class C0298a implements top.zibin.luban.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ File f21992a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ V3PassPoint2Observer f21993b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f21994c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function0<n1> f21995d;

            C0298a(File file, V3PassPoint2Observer v3PassPoint2Observer, String str, Function0<n1> function0) {
                this.f21992a = file;
                this.f21993b = v3PassPoint2Observer;
                this.f21994c = str;
                this.f21995d = function0;
            }

            @Override // top.zibin.luban.d
            public void a(final File file) {
                g0.p(file, "file");
                File file2 = this.f21992a;
                if (!file2.exists()) {
                    file2 = null;
                }
                if (file2 != null) {
                    this.f21992a.delete();
                }
                SportsVM n6 = this.f21993b.n();
                String t5 = c0.f16887a.t(this.f21993b.n().M(), "identify");
                String str = this.f21994c;
                final Function0<n1> function0 = this.f21995d;
                n6.N(t5, str, file, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.service.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        n1 c6;
                        c6 = V3PassPoint2Observer.a.C0298a.c(Function0.this, file);
                        return c6;
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final n1 c(Function0 function0, File file) {
                File file2;
                function0.invoke();
                if (file.exists()) {
                    file2 = file;
                } else {
                    file2 = null;
                }
                if (file2 != null) {
                    file.delete();
                }
                return n1.f44123a;
            }

            @Override // top.zibin.luban.d
            public void onError(Throwable th) {
            }

            @Override // top.zibin.luban.d
            public void onStart() {
            }
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (i6 == -1) {
                if (!V3PassPoint2Observer.this.o()) {
                    ContextExtKt.t(V3PassPoint2Observer.this.l(), "未找到存储卡，无法存储照片！");
                } else {
                    File file = new File(this.f21989b.element.getPath());
                    top.zibin.luban.c.k(V3PassPoint2Observer.this.l()).f(file).h(new C0298a(file, V3PassPoint2Observer.this, this.f21990c, this.f21991d)).e();
                }
            }
        }

        a(Ref.ObjectRef<File> objectRef, String str, Function0<n1> function0) {
            this.f21989b = objectRef;
            this.f21990c = str;
            this.f21991d = function0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 V3PassPoint2Observer.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3PassPoint2Observer\n*L\n1#1,328:1\n128#2:329\n*E\n"})
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t5, T t6) {
            c0 c0Var = c0.f16887a;
            return kotlin.comparisons.a.l(Integer.valueOf(c0Var.k((Map) t5, "sort")), Integer.valueOf(c0Var.k((Map) t6, "sort")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 r(V3PassPoint2Observer v3PassPoint2Observer) {
        com.orhanobut.logger.j.d("已完成定向越野任务，请继续前往下一个点", new Object[0]);
        v3PassPoint2Observer.f21986n++;
        ContextExtKt.s(v3PassPoint2Observer.f21973a, "请继续前往下一个点", 0, 2, null);
        v3PassPoint2Observer.h(v3PassPoint2Observer.f21979g.subList(0, 1));
        v3PassPoint2Observer.f21985m = false;
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 s(V3PassPoint2Observer v3PassPoint2Observer) {
        v3PassPoint2Observer.f21985m = false;
        v3PassPoint2Observer.f21986n++;
        ContextExtKt.s(v3PassPoint2Observer.f21973a, "打卡识别拍照图片已上传成功！请继续前往下一个点", 0, 2, null);
        v3PassPoint2Observer.h(v3PassPoint2Observer.f21979g.subList(0, 1));
        return n1.f44123a;
    }

    public V3PassPoint2Observer(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull MapView mMapView) {
        g0.p(mActivity, "mActivity");
        g0.p(mViewModel, "mViewModel");
        g0.p(mMapView, "mMapView");
        this.f21973a = mActivity;
        this.f21974b = mViewModel;
        this.f21975c = mMapView;
        AMap map = mMapView.getMap();
        g0.o(map, "getMap(...)");
        this.f21976d = map;
        this.f21978f = new ArrayList();
        this.f21979g = new ArrayList();
        this.f21982j = 1;
        this.f21987o = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer$mGeoFenceReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                List list;
                g0.p(context, "context");
                g0.p(intent, "intent");
                list = V3PassPoint2Observer.this.f21979g;
                if (list.isEmpty()) {
                    V3PassPoint2Observer.this.onDestroy();
                } else if (intent.hasExtra("newLocationPoint")) {
                    V3PassPoint2Observer.this.q();
                    V3PassPoint2Observer.this.j((LatLng) intent.getParcelableExtra("newLocationPoint"));
                }
            }
        };
    }

    private final void h(List<? extends Map<String, ? extends Object>> list) {
        ArrayList<Map<String, ? extends Object>> arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            Object obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Map<String, ? extends Object> map = (Map) next;
            Iterator<T> it2 = this.f21978f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                String t5 = c0.f16887a.t(map, "id");
                Object object = ((Marker) next2).getObject();
                if (g0.g(t5, object != null ? object.toString() : null)) {
                    obj = next2;
                    break;
                }
            }
            if (obj == null) {
                arrayList.add(next);
            }
        }
        for (Map<String, ? extends Object> map2 : arrayList) {
            c0 c0Var = c0.f16887a;
            LatLng latLng = new LatLng(c0Var.f(map2, "latitude"), c0Var.f(map2, "longitude"));
            Marker addMarker = this.f21976d.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.c.f20881a.b(this.f21980h ? c0Var.t(map2, "sort") : "经"))).zIndex(9.0f).title("你还未通过" + (this.f21980h ? "第" + c0Var.t(map2, "sort") + "个" : "") + "必经点：" + c0Var.t(map2, "content")).draggable(false));
            addMarker.setObject(c0Var.t(map2, "id"));
            List<Marker> list2 = this.f21978f;
            g0.m(addMarker);
            list2.add(addMarker);
            this.f21977e = LatLngBounds.builder().include(latLng);
        }
        if ((!arrayList.isEmpty() ? this : null) != null) {
            AMap aMap = this.f21976d;
            LatLngBounds.Builder builder = this.f21977e;
            aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder != null ? builder.build() : null, u.a(10.0f, this.f21973a)), 2000L, null);
            this.f21973a.registerReceiver(this.f21987o, new IntentFilter(App.f17573d.a().getPackageName() + ".run"), com.bxkj.student.v2.common.data.k.f20685b, null);
            this.f21981i = true;
        }
    }

    private final boolean k(Map<String, ? extends Object> map) {
        Object obj;
        Object obj2;
        String str;
        Object obj3;
        String t5 = c0.f16887a.t(map, "id");
        Iterator<T> it = com.bxkj.student.v2.common.data.i.f20657a.x().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (g0.g(c0.f16887a.t((Map) obj, "id"), t5)) {
                break;
            }
        }
        if (((Map) obj) != null) {
            return false;
        }
        if (this.f21980h) {
            int k6 = c0.f16887a.k(map, "sort");
            Iterator<T> it2 = com.bxkj.student.v2.common.data.i.f20657a.x().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it2.next();
                if (c0.f16887a.k((Map) obj3, "sort") == k6 - 1) {
                    break;
                }
            }
            Map map2 = (Map) obj3;
            if (k6 > 1 && map2 == null) {
                return false;
            }
        }
        Iterator<T> it3 = this.f21978f.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            Object object = ((Marker) obj2).getObject();
            if (g0.g(t5, object != null ? object.toString() : null)) {
                break;
            }
        }
        Marker marker = (Marker) obj2;
        if (marker == null) {
            return false;
        }
        this.f21978f.remove(marker);
        marker.setVisible(false);
        marker.remove();
        marker.destroy();
        this.f21975c.postInvalidate();
        String t6 = this.f21980h ? c0.f16887a.t(map, "sort") : "√";
        if (this.f21980h) {
            str = "第" + c0.f16887a.t(map, "sort") + "个";
        } else {
            str = "";
        }
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.c.f20881a.c(t6));
        c0 c0Var = c0.f16887a;
        double f6 = c0Var.f(map, "latitude");
        double f7 = c0Var.f(map, "longitude");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String t7 = c0Var.t(map, "content");
        String t8 = c0Var.t(map, "sort");
        MarkerOptions draggable = new MarkerOptions().position(new LatLng(f6, f7)).icon(fromBitmap).zIndex(10.0f).title("你已经通过" + str + "必经点:" + t7).draggable(false);
        HashMap hashMap = new HashMap();
        hashMap.put("id", t5);
        hashMap.put("time", simpleDateFormat.format(new Date()));
        hashMap.put("content", t7);
        hashMap.put("latitude", Double.valueOf(f6));
        hashMap.put("longitude", Double.valueOf(f7));
        hashMap.put("sort", t8);
        com.orhanobut.logger.j.d(draggable.getTitle(), new Object[0]);
        this.f21976d.addMarker(draggable);
        d0.e().l(this.f21973a, f0.U(Integer.valueOf(R.raw.pass_asses)));
        com.bxkj.student.v2.common.data.i.f20657a.x().add(hashMap);
        FragmentActivity fragmentActivity = this.f21973a;
        String title = draggable.getTitle();
        g0.o(title, "getTitle(...)");
        ContextExtKt.s(fragmentActivity, title, 0, 2, null);
        return true;
    }

    private final void p() {
        String str;
        Object obj;
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        com.orhanobut.logger.j.d("恢复已经过的必经点" + aVar.x(), new Object[0]);
        Iterator<T> it = aVar.x().iterator();
        while (it.hasNext()) {
            Map<String, ? extends Object> map = (Map) it.next();
            String t5 = this.f21980h ? c0.f16887a.t(map, "sort") : "√";
            if (this.f21980h) {
                str = "第" + c0.f16887a.t(map, "sort") + "个";
            } else {
                str = "";
            }
            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(com.bxkj.student.v2.common.utils.c.f20881a.c(t5));
            c0 c0Var = c0.f16887a;
            this.f21976d.addMarker(new MarkerOptions().position(new LatLng(c0Var.f(map, "latitude"), c0Var.f(map, "longitude"))).icon(fromBitmap).zIndex(10.0f).title("你已经通过" + str + "必经点:" + c0Var.t(map, "content")).draggable(false));
            Iterator<T> it2 = this.f21979g.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                c0 c0Var2 = c0.f16887a;
                if (g0.g(c0Var2.t((Map) obj, "id"), c0Var2.t(map, "id"))) {
                    break;
                }
            }
            Map map2 = (Map) obj;
            if (map2 != null) {
                this.f21979g.remove(map2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (this.f21985m) {
            return;
        }
        V3PassPoint2Observer v3PassPoint2Observer = this.f21982j == 2 ? this : null;
        if (v3PassPoint2Observer != null) {
            if (this.f21979g.isEmpty()) {
                v3PassPoint2Observer = null;
            }
            if (v3PassPoint2Observer != null) {
                int i6 = this.f21986n;
                i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
                if (i6 >= aVar.x().size()) {
                    v3PassPoint2Observer = null;
                }
                if (v3PassPoint2Observer != null) {
                    if (aVar.g() - this.f21984l < this.f21983k) {
                        v3PassPoint2Observer = null;
                    }
                    if (v3PassPoint2Observer != null) {
                        c0 c0Var = c0.f16887a;
                        if (c0Var.k(this.f21974b.M(), "runType") == 6) {
                            if ((this.f21985m ? null : this) != null) {
                                this.f21985m = true;
                                new com.bxkj.student.v2.ui.sports.v3.dxyy.n(this.f21973a, c0Var.k(this.f21974b.M(), "pointPass"), new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.service.n
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        n1 r5;
                                        r5 = V3PassPoint2Observer.r(V3PassPoint2Observer.this);
                                        return r5;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!g0.g(c0Var.t(this.f21974b.M(), "takePicture"), "1")) {
                            h(this.f21979g.subList(0, 1));
                            n1 n1Var = n1.f44123a;
                            return;
                        }
                        if ((this.f21985m ? null : this) != null) {
                            this.f21985m = true;
                            t(c0Var.t((Map) f0.u3(aVar.x()), "content"), new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.service.o
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    n1 s5;
                                    s5 = V3PassPoint2Observer.s(V3PassPoint2Observer.this);
                                    return s5;
                                }
                            });
                            n1 n1Var2 = n1.f44123a;
                        }
                    }
                }
            }
        }
    }

    private final void t(final String str, final Function0<n1> function0) {
        iOSOneButtonDialog o5 = ContextExtKt.o(this.f21973a, "您已经过打卡点请拍照", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.service.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 u5;
                u5 = V3PassPoint2Observer.u(V3PassPoint2Observer.this, str, function0, (iOSOneButtonDialog) obj);
                return u5;
            }
        });
        o5.setCanceledOnTouchOutside(false);
        o5.setCancelable(false);
        o5.setClickAutoCancel(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 u(final V3PassPoint2Observer v3PassPoint2Observer, final String str, final Function0 function0, final iOSOneButtonDialog dialog) {
        g0.p(dialog, "dialog");
        b0.x(v3PassPoint2Observer.f21973a, "打卡点请拍照", new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.service.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 v5;
                v5 = V3PassPoint2Observer.v(V3PassPoint2Observer.this, str, dialog, function0);
                return v5;
            }
        });
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 v(V3PassPoint2Observer v3PassPoint2Observer, String str, final iOSOneButtonDialog iosonebuttondialog, final Function0 function0) {
        v3PassPoint2Observer.i(str, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.service.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 w5;
                w5 = V3PassPoint2Observer.w(iOSOneButtonDialog.this, function0);
                return w5;
            }
        });
        return n1.f44123a;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.io.File] */
    public final void i(@NotNull String remark, @NotNull Function0<n1> next) {
        Uri uriForFile;
        g0.p(remark, "remark");
        g0.p(next, "next");
        if (!o()) {
            Toast.makeText(this.f21973a, "未找到存储卡，无法拍照！", 0).show();
            return;
        }
        File externalCacheDir = g0.g("mounted", Environment.getExternalStorageState()) ? this.f21973a.getExternalCacheDir() : null;
        if ((externalCacheDir == null ? this : null) != null) {
            externalCacheDir = this.f21973a.getCacheDir();
        }
        if (externalCacheDir != null) {
            File file = externalCacheDir.exists() ? null : externalCacheDir;
            if (file != null) {
                file.mkdirs();
            }
        }
        File file2 = new File(externalCacheDir, "avatar");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? file3 = new File(file2, System.currentTimeMillis() + "_temp_photo.jpg");
        objectRef.element = file3;
        if (Build.VERSION.SDK_INT < 24) {
            uriForFile = Uri.fromFile(file3);
            g0.m(uriForFile);
        } else {
            uriForFile = FileProvider.getUriForFile(this.f21973a, "com.bxkj.student.provider", file3);
            g0.m(uriForFile);
        }
        Intent intent = new Intent();
        intent.putExtra("output", uriForFile);
        intent.setAction("android.media.action.IMAGE_CAPTURE");
        intent.addFlags(1);
        intent.addCategory("android.intent.category.DEFAULT");
        new u.b(this.f21973a).startActivityForResult(intent).c(new a(objectRef, remark, next));
    }

    public final void j(@Nullable LatLng latLng) {
        ArrayList<Map<String, ? extends Object>> arrayList = new ArrayList();
        arrayList.addAll(this.f21979g);
        for (Map<String, ? extends Object> map : arrayList) {
            c0 c0Var = c0.f16887a;
            float i6 = c0Var.i(map, "okRadius");
            double f6 = c0Var.f(map, "latitude");
            double f7 = c0Var.f(map, "longitude");
            c0Var.t(map, "content");
            if (AMapUtils.calculateLineDistance(new LatLng(f6, f7), latLng) <= i6 && k(map)) {
                this.f21984l = com.bxkj.student.v2.common.data.i.f20657a.g();
                this.f21979g.remove(map);
                q();
            }
        }
    }

    @NotNull
    public final FragmentActivity l() {
        return this.f21973a;
    }

    @NotNull
    public final MapView m() {
        return this.f21975c;
    }

    @NotNull
    public final SportsVM n() {
        return this.f21974b;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        Object obj;
        c0 c0Var = c0.f16887a;
        this.f21979g = f0.d6(c0Var.n(this.f21974b.M(), "list"));
        this.f21980h = g0.g("1", c0Var.t(this.f21974b.M(), "isSequencePoint"));
        this.f21982j = c0Var.l(this.f21974b.M(), "pointShowMode", 1);
        this.f21983k = c0Var.f(this.f21974b.M(), "pointShowDistance");
        List<Map<String, Object>> list = this.f21979g;
        if (list.isEmpty()) {
            list = null;
        }
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                Map<String, ? extends Object> map = (Map) obj2;
                Iterator<T> it = com.bxkj.student.v2.common.data.i.f20657a.x().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    c0 c0Var2 = c0.f16887a;
                    if (g0.g(c0Var2.t((Map) obj, "id"), c0Var2.t(map, "id"))) {
                        break;
                    }
                }
                if (obj == null) {
                    arrayList.add(obj2);
                }
            }
            List<Map<String, Object>> d6 = f0.d6(arrayList);
            this.f21979g = d6;
            if (d6.size() > 1) {
                f0.r0(d6, new b());
            }
            p();
            if (this.f21982j == 1) {
                h(this.f21979g);
            } else {
                if (this.f21979g.isEmpty()) {
                    return;
                }
                h(this.f21979g.subList(0, 1));
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f21987o;
        if (!this.f21981i) {
            broadcastReceiver = null;
        }
        if (broadcastReceiver != null) {
            this.f21981i = false;
            this.f21973a.unregisterReceiver(broadcastReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 w(iOSOneButtonDialog iosonebuttondialog, Function0 function0) {
        iosonebuttondialog.dismiss();
        function0.invoke();
        return n1.f44123a;
    }

    public final boolean o() {
        return g0.g(Environment.getExternalStorageState(), "mounted");
    }
}
