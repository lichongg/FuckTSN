package com.bxkj.student.v2.ui.sports.v3.service;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.work.WorkRequest;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.model.LatLng;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.ui.sports.v3.service.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3LocationObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3LocationObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3LocationObserver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,472:1\n1#2:473\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3LocationObserver implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final LifecycleService f21921a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private AMapLocationClient f21922b;

    /* renamed from: c, reason: collision with root package name */
    private LatLng f21923c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private PointData f21924d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f21925e;

    /* renamed from: f, reason: collision with root package name */
    private final int f21926f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private PointData f21927g;

    /* renamed from: h, reason: collision with root package name */
    private double f21928h;

    /* renamed from: i, reason: collision with root package name */
    private int f21929i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    private iOSOneButtonDialog f21930j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationChangeListener$1", f = "V3LocationObserver.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21931a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ AMapLocation f21933c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AMapLocation aMapLocation, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f21933c = aMapLocation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return V3LocationObserver.this.new a(this.f21933c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f21931a;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                V3LocationObserver v3LocationObserver = V3LocationObserver.this;
                AMapLocation aMapLocation = this.f21933c;
                this.f21931a = 1;
                if (v3LocationObserver.m(aMapLocation, this) == l6) {
                    return l6;
                }
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$10$1", f = "V3LocationObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21934a;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new b(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21934a == 0) {
                g0.n(obj);
                Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                if (a6 != null) {
                    ContextExtKt.q(a6, "超过10秒未获取到定位点");
                    return n1.f44123a;
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$12$1", f = "V3LocationObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super Toast>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21935a;

        c(kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return V3LocationObserver.this.new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super Toast> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21935a == 0) {
                g0.n(obj);
                Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                if (a6 != null) {
                    return ContextExtKt.s(a6, "扔掉第" + V3LocationObserver.this.f21929i + "个点", 0, 2, null);
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$15$1", f = "V3LocationObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super Toast>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21937a;

        d(kotlin.coroutines.e<? super d> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new d(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super Toast> eVar) {
            return ((d) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21937a == 0) {
                g0.n(obj);
                Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                if (a6 == null) {
                    return null;
                }
                return ContextExtKt.s(a6, "恢复10个定位点后补偿距离算法", 0, 2, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver$onLocationSuccessListener$17$1", f = "V3LocationObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super Toast>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21938a;

        e(kotlin.coroutines.e<? super e> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new e(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super Toast> eVar) {
            return ((e) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21938a == 0) {
                g0.n(obj);
                Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                if (a6 == null) {
                    return null;
                }
                return ContextExtKt.s(a6, "中途出现了暂停的点，将丢失的点位置空，重新按规则计算", 0, 2, null);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver", f = "V3LocationObserver.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400, 407, 421}, m = "onLocationSuccessListener", n = {SocializeConstants.KEY_LOCATION, "curPoint", "sb", "distance", "appendDistance", "it", "countTime", "gpsDistance", "$i$a$-let-V3LocationObserver$onLocationSuccessListener$10", SocializeConstants.KEY_LOCATION, "curPoint", "sb", "distance", "appendDistance", "it", "countTime", "gpsDistance", "$i$a$-let-V3LocationObserver$onLocationSuccessListener$12", SocializeConstants.KEY_LOCATION, "curPoint", "sb", "distance", "appendDistance", "it", "countTime", "gpsDistance", "$i$a$-let-V3LocationObserver$onLocationSuccessListener$15", SocializeConstants.KEY_LOCATION, "curPoint", "sb", "distance", "appendDistance", "it", "countTime", "gpsDistance", "$i$a$-let-V3LocationObserver$onLocationSuccessListener$17"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "D$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "D$0", "I$0"})
    static final class f extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f21939a;

        /* renamed from: b, reason: collision with root package name */
        Object f21940b;

        /* renamed from: c, reason: collision with root package name */
        Object f21941c;

        /* renamed from: d, reason: collision with root package name */
        Object f21942d;

        /* renamed from: e, reason: collision with root package name */
        Object f21943e;

        /* renamed from: f, reason: collision with root package name */
        Object f21944f;

        /* renamed from: g, reason: collision with root package name */
        long f21945g;

        /* renamed from: h, reason: collision with root package name */
        double f21946h;

        /* renamed from: i, reason: collision with root package name */
        int f21947i;

        /* renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f21948j;

        /* renamed from: l, reason: collision with root package name */
        int f21950l;

        f(kotlin.coroutines.e<? super f> eVar) {
            super(eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f21948j = obj;
            this.f21950l |= Integer.MIN_VALUE;
            return V3LocationObserver.this.m(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(V3LocationObserver v3LocationObserver, DialogInterface dialogInterface) {
        v3LocationObserver.f21930j = null;
    }

    private final void n() {
        com.orhanobut.logger.j.d("开启前台服务广播", new Object[0]);
        AMapLocationClient aMapLocationClient = this.f21922b;
        if (aMapLocationClient != null) {
            l.f22009a.d(this.f21921a, aMapLocationClient);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        com.orhanobut.logger.j.d("开启定位监听startGetLocation", new Object[0]);
        h();
        AMapLocationClient aMapLocationClient = this.f21922b;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
            aMapLocationClient.startLocation();
            n();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        com.orhanobut.logger.j.d("停止定位服务", new Object[0]);
        AMapLocationClient aMapLocationClient = this.f21922b;
        if (aMapLocationClient != null) {
            aMapLocationClient.disableBackgroundLocation(true);
            aMapLocationClient.stopLocation();
            aMapLocationClient.onDestroy();
        }
        this.f21921a.stopForeground(true);
        l.f22009a.b(this.f21921a);
    }

    public V3LocationObserver(@NotNull LifecycleService service) {
        kotlin.jvm.internal.g0.p(service, "service");
        this.f21921a = service;
        this.f21926f = 100;
    }

    private final AMapLocationClientOption f() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(true);
        aMapLocationClientOption.setHttpTimeOut(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        aMapLocationClientOption.setInterval(1000L);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setOnceLocation(false);
        aMapLocationClientOption.setOnceLocationLatest(false);
        aMapLocationClientOption.setSensorEnable(true);
        aMapLocationClientOption.setWifiScan(true);
        aMapLocationClientOption.setLocationCacheEnable(true);
        aMapLocationClientOption.setMockEnable(false);
        return aMapLocationClientOption;
    }

    private final void h() {
        AMapLocationClient aMapLocationClient = new AMapLocationClient(StubApp.getOrigApplicationContext(this.f21921a.getApplicationContext()));
        aMapLocationClient.setLocationOption(f());
        aMapLocationClient.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.d
            @Override // com.amap.api.location.AMapLocationListener
            public final void onLocationChanged(AMapLocation aMapLocation) {
                V3LocationObserver.i(V3LocationObserver.this, aMapLocation);
            }
        });
        this.f21922b = aMapLocationClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(final V3LocationObserver v3LocationObserver, AMapLocation aMapLocation) {
        iOSOneButtonDialog m6;
        if (aMapLocation != null) {
            c0 c0Var = c0.f16887a;
            i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
            if (c0Var.l(aVar.B(), "isCheckDevelop", 1) == 1) {
                com.bxkj.student.v2.ui.sports.safe.b bVar = com.bxkj.student.v2.ui.sports.safe.b.f21524a;
                if (bVar.b()) {
                    aVar.g0(true);
                    iOSOneButtonDialog iosonebuttondialog = v3LocationObserver.f21930j;
                    iOSOneButtonDialog iosonebuttondialog2 = null;
                    com.orhanobut.logger.j.d("devDialog?.isShowing=" + (iosonebuttondialog != null ? Boolean.valueOf(iosonebuttondialog.isShowing()) : null), new Object[0]);
                    iOSOneButtonDialog iosonebuttondialog3 = v3LocationObserver.f21930j;
                    if (iosonebuttondialog3 == null || !(iosonebuttondialog3 == null || iosonebuttondialog3.isShowing())) {
                        aVar.k0(aVar.I() + 1);
                        String a6 = bVar.a();
                        l.a.h(l.f22009a, App.f17573d.a(), a6, false, 4, null);
                        Activity a7 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                        if (a7 != null && (m6 = ContextExtKt.m(a7, a6)) != null) {
                            m6.setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.b
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    V3LocationObserver.j(view);
                                }
                            });
                            m6.setClickAutoCancel(false);
                            m6.setCancelable(false);
                            m6.setCanceledOnTouchOutside(false);
                            m6.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bxkj.student.v2.ui.sports.v3.service.c
                                @Override // android.content.DialogInterface.OnDismissListener
                                public final void onDismiss(DialogInterface dialogInterface) {
                                    V3LocationObserver.k(V3LocationObserver.this, dialogInterface);
                                }
                            });
                            iosonebuttondialog2 = m6;
                        }
                        v3LocationObserver.f21930j = iosonebuttondialog2;
                        return;
                    }
                    return;
                }
            }
            iOSOneButtonDialog iosonebuttondialog4 = v3LocationObserver.f21930j;
            if (iosonebuttondialog4 != null) {
                iosonebuttondialog4.dismiss();
            }
            aVar.g0(false);
            v3LocationObserver.l(aMapLocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(View view) {
        com.bxkj.student.v2.ui.sports.safe.b.f21524a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Type inference failed for: r10v10, types: [T, java.lang.Object, java.math.BigDecimal] */
    /* JADX WARN: Type inference failed for: r2v14, types: [T, java.lang.Object, java.math.BigDecimal] */
    /* JADX WARN: Type inference failed for: r2v20, types: [T, java.lang.Object, java.math.BigDecimal] */
    /* JADX WARN: Type inference failed for: r3v33, types: [T, java.lang.Object, java.math.BigDecimal] */
    /* JADX WARN: Type inference failed for: r4v26, types: [T, java.math.BigDecimal] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(com.amap.api.location.AMapLocation r27, kotlin.coroutines.e<? super kotlin.n1> r28) {
        /*
            Method dump skipped, instructions count: 1288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.service.V3LocationObserver.m(com.amap.api.location.AMapLocation, kotlin.coroutines.e):java.lang.Object");
    }

    @NotNull
    public final LifecycleService g() {
        return this.f21921a;
    }

    private final void l(AMapLocation aMapLocation) {
        String str;
        String j6 = com.bxkj.student.run.app.utils.i.j(aMapLocation.getLocationQualityReport().getGPSStatus(), aMapLocation.getGpsAccuracyStatus());
        int k6 = com.bxkj.student.run.app.utils.i.k(aMapLocation.getGpsAccuracyStatus());
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        aVar.d0(aMapLocation.getGpsAccuracyStatus());
        kotlin.jvm.internal.g0.m(j6);
        aVar.f0(j6);
        aVar.e0(k6);
        aVar.N(j6, k6);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("回调时间:");
        sb.append(com.bxkj.student.run.app.utils.i.h(currentTimeMillis, "yyyy-MM-dd HH:mm:ss"));
        sb.append(com.snail.antifake.deviceid.e.f37542d);
        if (aMapLocation.getErrorCode() == 0) {
            sb.append("定位成功\n");
            sb.append("定位类型:" + aMapLocation.getLocationType() + " \n");
            sb.append("经\u3000\u3000度:" + aMapLocation.getLongitude() + " \n");
            sb.append("纬\u3000\u3000度:" + aMapLocation.getLatitude() + " \n");
            sb.append("精\u3000\u3000度:" + aMapLocation.getAccuracy() + " \n");
            sb.append("提供者\u3000:" + aMapLocation.getProvider() + " \n");
            sb.append("速\u3000\u3000度:" + aMapLocation.getSpeed() + " \n");
            sb.append("角\u3000\u3000度:" + aMapLocation.getBearing() + " \n");
            sb.append("星\u3000\u3000数:" + aMapLocation.getSatellites() + " \n");
            sb.append("国\u3000\u3000家:" + aMapLocation.getCountry() + " \n");
            sb.append("省\u3000\u3000\u3000:" + aMapLocation.getProvince() + " \n");
            sb.append("市\u3000\u3000\u3000:" + aMapLocation.getCity() + " \n");
            sb.append("城市编码:" + aMapLocation.getCityCode() + " \n");
            sb.append("区\u3000\u3000\u3000:" + aMapLocation.getDistrict() + " \n");
            sb.append("区域码\u3000:" + aMapLocation.getAdCode() + " \n");
            sb.append("地\u3000\u3000址:" + aMapLocation.getAddress() + " \n");
            sb.append("兴趣点\u3000:" + aMapLocation.getPoiName() + " \n");
            sb.append("定位时间:" + com.bxkj.student.run.app.utils.i.h(aMapLocation.getTime(), "yyyy-MM-dd HH:mm:ss") + " \n");
            kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(this.f21921a), g1.a(), null, new a(aMapLocation, null), 2, null);
        } else {
            sb.append("定位失败\n");
            sb.append("错误码\u3000:" + aMapLocation.getErrorCode() + com.snail.antifake.deviceid.e.f37542d);
            sb.append("错误信息:" + aMapLocation.getErrorInfo() + com.snail.antifake.deviceid.e.f37542d);
            sb.append("错误描述:" + aMapLocation.getLocationDetail() + com.snail.antifake.deviceid.e.f37542d);
            com.orhanobut.logger.j.d(sb.toString(), new Object[0]);
        }
        sb.append("***定位质量报告***\n");
        if (aMapLocation.getLocationQualityReport().isWifiAble()) {
            str = "开启";
        } else {
            str = "关闭";
        }
        sb.append("* WIFI开关：" + str + com.snail.antifake.deviceid.e.f37542d);
        sb.append("* GPS状态：" + com.bxkj.student.run.app.utils.i.m(aMapLocation.getLocationQualityReport().getGPSStatus()) + com.snail.antifake.deviceid.e.f37542d);
        sb.append("* GPS星数：" + aMapLocation.getLocationQualityReport().getGPSSatellites() + com.snail.antifake.deviceid.e.f37542d);
        sb.append("****************\n");
        kotlin.jvm.internal.g0.o(sb.toString(), "toString(...)");
    }
}
