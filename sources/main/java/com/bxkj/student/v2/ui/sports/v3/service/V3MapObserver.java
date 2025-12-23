package com.bxkj.student.v2.ui.sports.v3.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.work.WorkRequest;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.common.utils.n0;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.run.app.utils.d0;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.db.dao.x;
import com.bxkj.student.v2.ui.dialog.FaceOutDialog;
import com.bxkj.student.v2.ui.sports.v3.V3SportsFinishDialog;
import com.bxkj.student.v2.ui.sports.v3.service.l;
import com.bxkj.student.v2.vm.sports.SportsVM;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.f0;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3MapObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3MapObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3MapObserver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,447:1\n1#2:448\n1869#3,2:449\n1869#3,2:451\n*S KotlinDebug\n*F\n+ 1 V3MapObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3MapObserver\n*L\n240#1:449,2\n426#1:451,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3MapObserver implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final FragmentActivity f21953a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private SportsVM f21954b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final AMap f21955c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final Context f21956d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final FragmentManager f21957e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private LatLngBounds.Builder f21958f;

    /* renamed from: g, reason: collision with root package name */
    private long f21959g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private LatLng f21960h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private LatLng f21961i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private List<Double> f21962j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private com.bxkj.student.v2.common.utils.g f21963k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private BroadcastReceiver f21964l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private LocationSource f21965m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private LocationSource.OnLocationChangedListener f21966n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private iOSOneButtonDialog f21967o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    private FaceOutDialog f21968p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$faceCheckOutDialog$2", f = "V3MapObserver.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21969a;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return V3MapObserver.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f21969a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                x x5 = AppDatabase.f20686a.a().x();
                if (x5 != null) {
                    String valueOf = String.valueOf(com.bxkj.student.v2.common.data.i.f20657a.k().getValue());
                    String t5 = c0.f16887a.t(V3MapObserver.this.C().M(), "identify");
                    this.f21969a = 1;
                    if (x5.c(valueOf, t5, this) == l6) {
                        return l6;
                    }
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements LocationSource {
        b() {
        }

        @Override // com.amap.api.maps.LocationSource
        public void activate(LocationSource.OnLocationChangedListener listener) {
            kotlin.jvm.internal.g0.p(listener, "listener");
            V3MapObserver.this.f21966n = listener;
        }

        @Override // com.amap.api.maps.LocationSource
        public void deactivate() {
        }
    }

    public V3MapObserver(@NotNull FragmentActivity mActivity, @NotNull SportsVM mViewModel, @NotNull AMap aMap) {
        kotlin.jvm.internal.g0.p(mActivity, "mActivity");
        kotlin.jvm.internal.g0.p(mViewModel, "mViewModel");
        kotlin.jvm.internal.g0.p(aMap, "aMap");
        this.f21953a = mActivity;
        this.f21954b = mViewModel;
        this.f21955c = aMap;
        this.f21956d = mActivity;
        FragmentManager supportFragmentManager = mActivity.getSupportFragmentManager();
        kotlin.jvm.internal.g0.o(supportFragmentManager, "getSupportFragmentManager(...)");
        this.f21957e = supportFragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 F(V3MapObserver v3MapObserver, int i6) {
        LatLng latLng = v3MapObserver.f21960h;
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        if (AMapUtils.calculateLineDistance(latLng, aVar.z()) > i6) {
            v3MapObserver.u();
        } else {
            MutableLiveData<Integer> j6 = aVar.j();
            Integer value = aVar.j().getValue();
            j6.setValue(Integer.valueOf((value != null ? value.intValue() : 0) + 1));
            d0.e().l(v3MapObserver.f21956d, f0.U(Integer.valueOf(R.raw.face_live_success_run_continue)));
            aVar.Y(0.0d);
            aVar.o0(null);
            aVar.Z(false);
        }
        new n0(v3MapObserver.f21953a).c();
        iOSOneButtonDialog iosonebuttondialog = v3MapObserver.f21967o;
        if (iosonebuttondialog != null) {
            iosonebuttondialog.dismiss();
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        List<Marker> mapScreenMarkers = this.f21955c.getMapScreenMarkers();
        kotlin.jvm.internal.g0.o(mapScreenMarkers, "getMapScreenMarkers(...)");
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

    private final void M(String str, final int i6) {
        new n0(this.f21953a).b();
        l.a.h(l.f22009a, this.f21956d, str, false, 4, null);
        String str2 = str + "\n请注意周边环境是否安全！";
        iOSOneButtonDialog iosonebuttondialog = this.f21967o;
        if (iosonebuttondialog != null) {
            iosonebuttondialog.dismiss();
        }
        iOSOneButtonDialog o5 = ContextExtKt.o(this.f21953a, str2, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.service.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 N;
                N = V3MapObserver.N(V3MapObserver.this, i6, (iOSOneButtonDialog) obj);
                return N;
            }
        });
        o5.setClickAutoCancel(false);
        o5.setCancelable(false);
        o5.setCanceledOnTouchOutside(false);
        this.f21967o = o5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(V3MapObserver v3MapObserver, int i6, iOSOneButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        new n0(v3MapObserver.f21953a).c();
        if (AMapUtils.calculateLineDistance(v3MapObserver.f21960h, com.bxkj.student.v2.common.data.i.f20657a.z()) > i6) {
            v3MapObserver.u();
            iOSOneButtonDialog iosonebuttondialog = v3MapObserver.f21967o;
            if (iosonebuttondialog != null) {
                iosonebuttondialog.dismiss();
            }
        } else {
            v3MapObserver.E(i6);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 v(V3MapObserver v3MapObserver, final DialogFragment dialog) {
        kotlin.jvm.internal.g0.p(dialog, "dialog");
        final V3SportsFinishDialog v3SportsFinishDialog = new V3SportsFinishDialog();
        v3SportsFinishDialog.show(v3MapObserver.f21957e, "finishDialog");
        v3SportsFinishDialog.s0(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.service.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean w5;
                w5 = V3MapObserver.w(V3SportsFinishDialog.this);
                return Boolean.valueOf(w5);
            }
        });
        v3SportsFinishDialog.t0(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.service.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 x5;
                x5 = V3MapObserver.x(DialogFragment.this);
                return x5;
            }
        });
        return n1.f44123a;
    }

    @NotNull
    public final Context A() {
        return this.f21956d;
    }

    @NotNull
    public final FragmentManager B() {
        return this.f21957e;
    }

    @NotNull
    public final SportsVM C() {
        return this.f21954b;
    }

    public final long D() {
        return this.f21959g;
    }

    public final void E(final int i6) {
        com.bxkj.student.v2.ui.face.f0 f0Var = com.bxkj.student.v2.ui.face.f0.f21370a;
        FragmentActivity fragmentActivity = this.f21953a;
        c0 c0Var = c0.f16887a;
        f0Var.d(fragmentActivity, c0Var.k(this.f21954b.M(), "runType"), c0Var.k(this.f21954b.M(), "isMidwayFace"), "2", c0Var.t(this.f21954b.M(), "identify"), com.bxkj.student.v2.common.data.i.f20657a.f(), new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.service.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 F;
                F = V3MapObserver.F(V3MapObserver.this, i6);
                return F;
            }
        });
    }

    public final void K(@NotNull SportsVM sportsVM) {
        kotlin.jvm.internal.g0.p(sportsVM, "<set-?>");
        this.f21954b = sportsVM;
    }

    public final void L(long j6) {
        this.f21959g = j6;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.f21964l;
        if (broadcastReceiver != null) {
            this.f21953a.unregisterReceiver(broadcastReceiver);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        LatLng latLng = this.f21960h;
        if (latLng != null) {
            this.f21955c.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng, 18.0f)), 1000L, null);
        }
        G();
    }

    public final void u() {
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        aVar.v0(true);
        aVar.k().setValue(Boolean.FALSE);
        Integer value = aVar.j().getValue();
        this.f21968p = FaceOutDialog.f21310r.d((value != null ? value.intValue() : 0) + 1, (int) (c0.f16887a.f(this.f21954b.M(), "faceDistanceOut") * 1000), this.f21957e, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.service.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 v5;
                v5 = V3MapObserver.v(V3MapObserver.this, (DialogFragment) obj);
                return v5;
            }
        });
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(this.f21953a), g1.c(), null, new a(null), 2, null);
    }

    @NotNull
    public final AMap y() {
        return this.f21955c;
    }

    @NotNull
    public final FragmentActivity z() {
        return this.f21953a;
    }

    private final void H(LatLng latLng) {
        this.f21955c.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_start)).zIndex(9.0f).draggable(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(V3MapObserver v3MapObserver, MotionEvent motionEvent) {
        v3MapObserver.f21959g = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(V3MapObserver v3MapObserver, LatLng latLng) {
        v3MapObserver.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(LatLng latLng) {
        ArrayList arrayList;
        LatLngBounds latLngBounds;
        H(latLng);
        LatLngBounds.Builder builder = this.f21958f;
        if (builder != null) {
            builder.include(latLng);
        }
        ArrayList<PointData> arrayList2 = new ArrayList();
        arrayList2.addAll(com.bxkj.student.v2.common.data.i.f20657a.s());
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            PointData pointData = (PointData) arrayList2.get(f0.L(arrayList2));
            this.f21961i = new LatLng(pointData.getA(), pointData.getO());
            try {
                com.bxkj.student.v2.common.utils.g gVar = this.f21963k;
                if (gVar != null) {
                    gVar.a(arrayList2);
                }
            } catch (Exception e6) {
                com.orhanobut.logger.j.c(e6.getMessage());
            }
            for (PointData pointData2 : arrayList2) {
                LatLngBounds.Builder builder2 = this.f21958f;
                if (builder2 != null) {
                    builder2.include(new LatLng(pointData2.getA(), pointData2.getO()));
                }
            }
            AMap aMap = this.f21955c;
            LatLngBounds.Builder builder3 = this.f21958f;
            if (builder3 != null) {
                latLngBounds = builder3.build();
            } else {
                latLngBounds = null;
            }
            aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, u.a(50.0f, this.f21956d)), 1000L, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(double d6, LatLng latLng) {
        int i6;
        List<Double> list;
        FaceOutDialog faceOutDialog;
        Integer valueOf = Integer.valueOf(R.raw.face_live);
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        Integer value = aVar.j().getValue();
        if (value != null) {
            i6 = value.intValue();
        } else {
            i6 = 0;
        }
        List<Double> list2 = this.f21962j;
        if (list2 != null && !list2.isEmpty() && (list = this.f21962j) != null && i6 < list.size()) {
            double d7 = 1000;
            if (d6 >= list.get(i6).doubleValue() * d7) {
                synchronized (V3MapObserver.class) {
                    FaceOutDialog faceOutDialog2 = this.f21968p;
                    if (faceOutDialog2 != null && faceOutDialog2.isAdded() && (faceOutDialog = this.f21968p) != null && faceOutDialog.isVisible()) {
                        return;
                    }
                    if (aVar.i() == 0.0d) {
                        aVar.Y(aVar.g());
                        aVar.o0(latLng);
                        d0.e().l(this.f21956d, f0.U(valueOf));
                        int f6 = (int) (c0.f16887a.f(this.f21954b.M(), "faceDistanceOut") * d7);
                        String str = "请在" + f6 + "米范围内进行人脸识别！";
                        com.orhanobut.logger.j.d(str, new Object[0]);
                        M(str, f6);
                    } else {
                        int f7 = (int) (c0.f16887a.f(this.f21954b.M(), "faceDistanceOut") * d7);
                        if (d6 - aVar.i() > f7) {
                            if (!aVar.l()) {
                                aVar.Z(true);
                                d0.e().l(this.f21956d, f0.U(Integer.valueOf(R.raw.run_pause_face_live)));
                                M("跑步已暂停，请在" + f7 + "米范围内进行人脸识别！", f7);
                            }
                        } else {
                            iOSOneButtonDialog iosonebuttondialog = this.f21967o;
                            if (iosonebuttondialog == null || (iosonebuttondialog != null && !iosonebuttondialog.isShowing())) {
                                d0.e().l(this.f21956d, f0.U(valueOf));
                                M("请在" + f7 + "米范围内进行人脸识别！", f7);
                            }
                        }
                    }
                    n1 n1Var = n1.f44123a;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(V3SportsFinishDialog v3SportsFinishDialog) {
        v3SportsFinishDialog.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 x(DialogFragment dialogFragment) {
        dialogFragment.dismissAllowingStateLoss();
        return n1.f44123a;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.f21959g = System.currentTimeMillis();
        this.f21958f = LatLngBounds.builder();
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.mipmap.v3_sports_location_mark3));
        myLocationStyle.strokeColor(ContextCompat.getColor(this.f21956d, R.color.v3_tab_color3));
        myLocationStyle.radiusFillColor(ContextCompat.getColor(this.f21956d, R.color.v3_location_color3));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(5);
        this.f21955c.setMyLocationStyle(myLocationStyle);
        b bVar = new b();
        this.f21965m = bVar;
        this.f21955c.setLocationSource(bVar);
        this.f21955c.getUiSettings().setMyLocationButtonEnabled(true);
        this.f21955c.setMyLocationEnabled(true);
        this.f21955c.getUiSettings().setZoomPosition(1);
        this.f21955c.moveCamera(CameraUpdateFactory.zoomTo(18.0f));
        this.f21955c.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
        this.f21955c.setOnMapTouchListener(new AMap.OnMapTouchListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.g
            @Override // com.amap.api.maps.AMap.OnMapTouchListener
            public final void onTouch(MotionEvent motionEvent) {
                V3MapObserver.I(V3MapObserver.this, motionEvent);
            }
        });
        this.f21955c.setOnMapClickListener(new AMap.OnMapClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.h
            @Override // com.amap.api.maps.AMap.OnMapClickListener
            public final void onMapClick(LatLng latLng) {
                V3MapObserver.J(V3MapObserver.this, latLng);
            }
        });
        this.f21963k = new com.bxkj.student.v2.common.utils.g(this.f21956d, this.f21955c);
        this.f21962j = JsonParse.getList(this.f21954b.M(), "middleFaces", Double.TYPE);
        LatLng C = com.bxkj.student.v2.common.data.i.f20657a.C();
        if (C != null) {
            s(C);
        }
        this.f21964l = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver$onCreate$5
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                LatLng latLng;
                LatLng latLng2;
                LatLng latLng3;
                LatLng latLng4;
                com.bxkj.student.v2.common.utils.g gVar;
                LatLng latLng5;
                LatLng latLng6;
                LatLng latLng7;
                LatLngBounds.Builder builder;
                LatLngBounds.Builder builder2;
                LocationSource.OnLocationChangedListener onLocationChangedListener;
                if (intent != null) {
                    V3MapObserver v3MapObserver = V3MapObserver.this;
                    if (intent.hasExtra("aMapLocation")) {
                        AMapLocation aMapLocation = (AMapLocation) intent.getParcelableExtra("aMapLocation");
                        onLocationChangedListener = v3MapObserver.f21966n;
                        if (onLocationChangedListener != null) {
                            onLocationChangedListener.onLocationChanged(aMapLocation);
                        }
                    }
                    if (intent.hasExtra("firstMapLocation")) {
                        LatLng latLng8 = (LatLng) intent.getParcelableExtra("firstMapLocation");
                        v3MapObserver.f21960h = latLng8;
                        builder = v3MapObserver.f21958f;
                        if (builder != null) {
                            builder.include(latLng8);
                        }
                        AMap y5 = v3MapObserver.y();
                        builder2 = v3MapObserver.f21958f;
                        y5.animateCamera(CameraUpdateFactory.newLatLngBounds(builder2 != null ? builder2.build() : null, u.a(50.0f, v3MapObserver.A())), 1000L, null);
                    }
                    if (intent.hasExtra("startPoint")) {
                        v3MapObserver.f21960h = (LatLng) intent.getParcelableExtra("startPoint");
                        latLng7 = v3MapObserver.f21960h;
                        if (latLng7 != null) {
                            v3MapObserver.s(latLng7);
                        }
                    }
                    if (intent.hasExtra("countTime") && System.currentTimeMillis() - v3MapObserver.D() > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                        AMap y6 = v3MapObserver.y();
                        latLng6 = v3MapObserver.f21960h;
                        y6.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng6, 18.0f)), 500L, null);
                    }
                    if (intent.hasExtra("newPoint")) {
                        PointData pointData = (PointData) intent.getParcelableExtra("newPoint");
                        latLng = v3MapObserver.f21961i;
                        if (latLng != null) {
                            if (pointData != null) {
                                v3MapObserver.f21960h = new LatLng(pointData.getA(), pointData.getO());
                                gVar = v3MapObserver.f21963k;
                                if (gVar != null) {
                                    latLng5 = v3MapObserver.f21960h;
                                    kotlin.jvm.internal.g0.m(latLng5);
                                    gVar.b(latLng5, latLng, pointData.getS(), pointData.isI());
                                }
                            }
                            latLng2 = v3MapObserver.f21960h;
                            v3MapObserver.f21961i = latLng2;
                            double g6 = com.bxkj.student.v2.common.data.i.f20657a.g();
                            latLng3 = v3MapObserver.f21960h;
                            kotlin.jvm.internal.g0.m(latLng3);
                            v3MapObserver.t(g6, latLng3);
                            if (System.currentTimeMillis() - v3MapObserver.D() > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                                v3MapObserver.L(System.currentTimeMillis());
                                AMap y7 = v3MapObserver.y();
                                latLng4 = v3MapObserver.f21960h;
                                y7.animateCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(latLng4, 18.0f)), 500L, null);
                                v3MapObserver.G();
                            }
                        }
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(App.f17573d.a().getPackageName() + ".run");
        BroadcastReceiver broadcastReceiver = this.f21964l;
        if (broadcastReceiver != null) {
            this.f21953a.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}
