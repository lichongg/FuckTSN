package com.bxkj.student.v2.ui.sports.v3;

import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.data.ParcelableMap;
import com.bxkj.base.v2.data.b;
import com.bxkj.base.v2.view.a;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.databinding.AcV3SportsHomeBinding;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.common.utils.s;
import com.bxkj.student.v2.ui.dialog.FaceOutDialog;
import com.bxkj.student.v2.ui.dialog.NoticeDialog;
import com.bxkj.student.v2.ui.sports.set.PermissionSetActivity;
import com.bxkj.student.v2.ui.sports.set.SportsDescriptionActivity;
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity;
import com.bxkj.student.v2.ui.sports.v3.service.V3LocationService;
import com.bxkj.student.v2.ui.sports.v3.service.step.V3StepService;
import com.bxkj.student.v2.vm.sports.SportsHomeVM;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.tabs.TabLayout;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.b;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3SportsHomeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3SportsHomeActivity.kt\ncom/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1154:1\n1#2:1155\n1869#3,2:1156\n*S KotlinDebug\n*F\n+ 1 V3SportsHomeActivity.kt\ncom/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity\n*L\n984#1:1156,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3SportsHomeActivity extends BaseActivity<AcV3SportsHomeBinding, SportsHomeVM> {

    @Nullable
    private DialogFragment F0;

    @Nullable
    private e2 G0;
    private AMap U;

    @Nullable
    private LocationSource V;

    @Nullable
    private AMapLocationClient W;

    /* renamed from: a0, reason: collision with root package name */
    @Nullable
    private iOSTwoButtonDialog f21548a0;

    /* renamed from: b0, reason: collision with root package name */
    @Nullable
    private iOSTwoButtonDialog f21549b0;

    /* renamed from: c0, reason: collision with root package name */
    @Nullable
    private LatLng f21550c0;

    /* renamed from: p0, reason: collision with root package name */
    private long f21552p0;

    @NotNull
    private String X = "";
    private int Y = 1;
    private int Z = -1;

    /* renamed from: k0, reason: collision with root package name */
    private final long f21551k0 = 1000;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nV3SportsHomeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3SportsHomeActivity.kt\ncom/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$alertSelectCampus$2$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1154:1\n1#2:1155\n*E\n"})
    public static final class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<Map<String, Object>> f21553a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f21554b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ V3SportsHomeActivity f21555c;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends Map<String, ? extends Object>> list, Map<String, Object> map, V3SportsHomeActivity v3SportsHomeActivity) {
            this.f21553a = list;
            this.f21554b = map;
            this.f21555c = v3SportsHomeActivity;
        }

        @Override // com.bxkj.base.v2.view.a.b
        public void onMenuClick(String str) {
            Object obj;
            Iterator<T> it = this.f21553a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (kotlin.jvm.internal.g0.g(com.bxkj.base.v2.common.utils.c0.f16887a.t((Map) obj, CommonNetImpl.NAME), str)) {
                        break;
                    }
                }
            }
            Map<String, ? extends Object> map = (Map) obj;
            if (map != null) {
                Map<String, ? extends Object> map2 = map.isEmpty() ? null : map;
                if (map2 != null) {
                    Map<String, Object> map3 = this.f21554b;
                    V3SportsHomeActivity v3SportsHomeActivity = this.f21555c;
                    com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
                    List<Map<String, Object>> n6 = c0Var.n(map2, "point");
                    String t5 = c0Var.t(map2, com.umeng.analytics.pro.d.X);
                    map3.put("list", n6);
                    map3.put(com.umeng.analytics.pro.d.X, t5);
                    v3SportsHomeActivity.O1(map3);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f21557b;

        b(Map<String, Object> map) {
            this.f21557b = map;
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            V3SportsHomeActivity.this.S0(this.f21557b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity$checkSendFace$1$1", f = "V3SportsHomeActivity.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_REF_LEVEL}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
    static final class c extends SuspendLambda implements Function2<kotlinx.coroutines.r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21558a;

        /* renamed from: b, reason: collision with root package name */
        int f21559b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<Button> f21560c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Ref.ObjectRef<Button> objectRef, kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
            this.f21560c = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new c(this.f21560c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x004e -> B:5:0x0051). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.l()
                int r1 = r6.f21559b
                r2 = -1
                r3 = 1
                if (r1 == 0) goto L1a
                if (r1 != r3) goto L12
                int r1 = r6.f21558a
                kotlin.g0.n(r7)
                goto L51
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                kotlin.g0.n(r7)
                r7 = 10
                r1 = 10
            L21:
                if (r2 >= r1) goto L53
                kotlin.jvm.internal.Ref$ObjectRef<android.widget.Button> r7 = r6.f21560c
                T r7 = r7.element
                android.widget.Button r7 = (android.widget.Button) r7
                if (r7 == 0) goto L44
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "继续跑步("
                r4.append(r5)
                r4.append(r1)
                java.lang.String r5 = ")"
                r4.append(r5)
                java.lang.String r4 = r4.toString()
                r7.setText(r4)
            L44:
                r6.f21558a = r1
                r6.f21559b = r3
                r4 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r7 = kotlinx.coroutines.a1.b(r4, r6)
                if (r7 != r0) goto L51
                return r0
            L51:
                int r1 = r1 + r2
                goto L21
            L53:
                kotlin.jvm.internal.Ref$ObjectRef<android.widget.Button> r7 = r6.f21560c
                T r7 = r7.element
                android.widget.Button r7 = (android.widget.Button) r7
                if (r7 == 0) goto L60
                java.lang.String r0 = "继续跑步"
                r7.setText(r0)
            L60:
                kotlin.jvm.internal.Ref$ObjectRef<android.widget.Button> r7 = r6.f21560c
                T r7 = r7.element
                android.widget.Button r7 = (android.widget.Button) r7
                if (r7 == 0) goto L71
                java.lang.String r0 = "#2C7AD7"
                int r0 = android.graphics.Color.parseColor(r0)
                r7.setTextColor(r0)
            L71:
                kotlin.jvm.internal.Ref$ObjectRef<android.widget.Button> r7 = r6.f21560c
                T r7 = r7.element
                android.widget.Button r7 = (android.widget.Button) r7
                if (r7 == 0) goto L7c
                r7.setEnabled(r3)
            L7c:
                kotlin.n1 r7 = kotlin.n1.f44123a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f21562b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f21563a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f21564b;

            a(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f21563a = v3SportsHomeActivity;
                this.f21564b = map;
            }

            @Override // u.b.a
            public void a(int i6, Intent intent) {
                this.f21563a.c1(this.f21564b);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class b implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ V3SportsHomeActivity f21565a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Map<String, Object> f21566b;

            b(V3SportsHomeActivity v3SportsHomeActivity, Map<String, Object> map) {
                this.f21565a = v3SportsHomeActivity;
                this.f21566b = map;
            }

            @Override // u.b.a
            public void a(int i6, Intent intent) {
                this.f21565a.c1(this.f21566b);
            }
        }

        d(Map<String, Object> map) {
            this.f21562b = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 f(V3SportsHomeActivity v3SportsHomeActivity, Map map, iOSTwoButtonDialog it) {
            kotlin.jvm.internal.g0.p(it, "it");
            com.bxkj.base.util.v.p(v3SportsHomeActivity.r(), new a(v3SportsHomeActivity, map));
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 g(V3SportsHomeActivity v3SportsHomeActivity, Map map, iOSTwoButtonDialog it) {
            kotlin.jvm.internal.g0.p(it, "it");
            com.bxkj.base.util.v.p(v3SportsHomeActivity.r(), new b(v3SportsHomeActivity, map));
            return n1.f44123a;
        }

        @Override // t.b.a
        public void a() {
            V3SportsHomeActivity.this.S1(this.f21562b);
        }

        @Override // t.b.a
        public void b(String[] permission) {
            kotlin.jvm.internal.g0.p(permission, "permission");
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String string = v3SportsHomeActivity.H().getString(R.string.not_set_step_permission);
            kotlin.jvm.internal.g0.o(string, "getString(...)");
            final V3SportsHomeActivity v3SportsHomeActivity2 = V3SportsHomeActivity.this;
            final Map<String, Object> map = this.f21562b;
            ContextExtKt.h(v3SportsHomeActivity, "权限提示", string, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.y0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 g6;
                    g6 = V3SportsHomeActivity.d.g(V3SportsHomeActivity.this, map, (iOSTwoButtonDialog) obj);
                    return g6;
                }
            }, null, null, "去设置", 24, null);
        }

        @Override // t.b.a
        public void c(String[] permission) {
            kotlin.jvm.internal.g0.p(permission, "permission");
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String string = v3SportsHomeActivity.H().getString(R.string.not_set_step_permission);
            kotlin.jvm.internal.g0.o(string, "getString(...)");
            final V3SportsHomeActivity v3SportsHomeActivity2 = V3SportsHomeActivity.this;
            final Map<String, Object> map = this.f21562b;
            ContextExtKt.h(v3SportsHomeActivity, "权限提示", string, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.z0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 f6;
                    f6 = V3SportsHomeActivity.d.f(V3SportsHomeActivity.this, map, (iOSTwoButtonDialog) obj);
                    return f6;
                }
            }, null, null, "去设置", 24, null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class e implements WeatherSearch.OnWeatherSearchListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21568b;

        e(String str) {
            this.f21568b = str;
        }

        @Override // com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener
        public void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i6) {
            if (i6 != 1000 || localWeatherLiveResult == null || localWeatherLiveResult.getLiveResult() == null) {
                return;
            }
            LocalWeatherLive liveResult = localWeatherLiveResult.getLiveResult();
            V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
            String weather = liveResult.getWeather();
            kotlin.jvm.internal.g0.o(weather, "getWeather(...)");
            v3SportsHomeActivity.X = weather;
            V3SportsHomeActivity.this.L().tvWeather.setText(liveResult.getReportTime() + "发布天气:" + V3SportsHomeActivity.this.X);
            V3SportsHomeActivity.this.D().D0(this.f21568b, V3SportsHomeActivity.this.X);
        }

        @Override // com.amap.api.services.weather.WeatherSearch.OnWeatherSearchListener
        public void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f21570b;

        f(Map<String, Object> map) {
            this.f21570b = map;
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            V3SportsHomeActivity.this.i1(this.f21570b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g implements TabLayout.OnTabSelectedListener {
        g() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null) {
                V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
                s.a aVar = com.bxkj.student.v2.common.utils.s.f20923a;
                v3SportsHomeActivity.Y = aVar.c(tab.getText());
                int a6 = aVar.a(tab.getText());
                View findViewById = v3SportsHomeActivity.getWindow().findViewById(v3SportsHomeActivity.getResources().getIdentifier("statusBarBackground", "id", FaceEnvironment.OS));
                if (findViewById != null) {
                    findViewById.setBackgroundResource(a6);
                }
                v3SportsHomeActivity.L().llTitle.setBackgroundResource(a6);
                v3SportsHomeActivity.L().clData.setBackgroundResource(a6);
                int h6 = aVar.h(tab.getText());
                MyLocationStyle myLocationStyle = new MyLocationStyle();
                myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(h6));
                myLocationStyle.strokeColor(ContextCompat.getColor(v3SportsHomeActivity.H(), a6));
                myLocationStyle.radiusFillColor(ContextCompat.getColor(v3SportsHomeActivity.H(), aVar.i(tab.getText())));
                myLocationStyle.strokeWidth(1.0f);
                AMap aMap = v3SportsHomeActivity.U;
                if (aMap == null) {
                    kotlin.jvm.internal.g0.S("aMap");
                    aMap = null;
                }
                aMap.setMyLocationStyle(myLocationStyle);
                v3SportsHomeActivity.F1();
                v3SportsHomeActivity.L().ivDescription.setImageResource(aVar.e(tab.getText()));
                v3SportsHomeActivity.L().ivStart.setImageResource(aVar.g(tab.getText()));
                v3SportsHomeActivity.L().ivPermission.setImageResource(aVar.f(tab.getText()));
                v3SportsHomeActivity.L().tvDescriptionV3.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.H(), a6));
                v3SportsHomeActivity.L().tvPermissionV3.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.H(), a6));
                v3SportsHomeActivity.L().tvWeather.setTextColor(ContextCompat.getColor(v3SportsHomeActivity.H(), a6));
                int u5 = com.bxkj.student.run.app.utils.i.u(v3SportsHomeActivity.Z, v3SportsHomeActivity.Y);
                v3SportsHomeActivity.L().tvGps.setTextColor(u5 == 2131690189 ? ContextCompat.getColor(v3SportsHomeActivity.H(), R.color.privacy_grey_color) : ContextCompat.getColor(v3SportsHomeActivity.H(), aVar.a(aVar.d(v3SportsHomeActivity.Y))));
                v3SportsHomeActivity.L().ivGps.setImageResource(u5);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f21573b;

        h(Map<String, Object> map) {
            this.f21573b = map;
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            V3SportsHomeActivity.this.B1(this.f21573b);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class i implements Observer, kotlin.jvm.internal.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21574a;

        i(Function1 function) {
            kotlin.jvm.internal.g0.p(function, "function");
            this.f21574a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.b0)) {
                return kotlin.jvm.internal.g0.g(getFunctionDelegate(), ((kotlin.jvm.internal.b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final kotlin.n<?> getFunctionDelegate() {
            return this.f21574a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21574a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nV3SportsHomeActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3SportsHomeActivity.kt\ncom/bxkj/student/v2/ui/sports/v3/V3SportsHomeActivity$setUpMap$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1154:1\n1#2:1155\n*E\n"})
    public static final class j implements LocationSource {
        j() {
        }

        @Override // com.amap.api.maps.LocationSource
        public void activate(final LocationSource.OnLocationChangedListener listener) {
            kotlin.jvm.internal.g0.p(listener, "listener");
            if (V3SportsHomeActivity.this.W == null) {
                V3SportsHomeActivity.this.W = new AMapLocationClient(App.f17573d.a());
                AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                aMapLocationClientOption.setMockEnable(false);
                AMapLocationClient aMapLocationClient = V3SportsHomeActivity.this.W;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(aMapLocationClientOption);
                }
                AMapLocationClient aMapLocationClient2 = V3SportsHomeActivity.this.W;
                if (aMapLocationClient2 != null) {
                    final V3SportsHomeActivity v3SportsHomeActivity = V3SportsHomeActivity.this;
                    aMapLocationClient2.setLocationListener(new AMapLocationListener() { // from class: com.bxkj.student.v2.ui.sports.v3.a1
                        @Override // com.amap.api.location.AMapLocationListener
                        public final void onLocationChanged(AMapLocation aMapLocation) {
                            V3SportsHomeActivity.j.b(LocationSource.OnLocationChangedListener.this, v3SportsHomeActivity, aMapLocation);
                        }
                    });
                }
                AMapLocationClient aMapLocationClient3 = V3SportsHomeActivity.this.W;
                if (aMapLocationClient3 != null) {
                    aMapLocationClient3.startLocation();
                }
            }
        }

        @Override // com.amap.api.maps.LocationSource
        public void deactivate() {
            AMapLocationClient aMapLocationClient = V3SportsHomeActivity.this.W;
            if (aMapLocationClient != null) {
                aMapLocationClient.stopLocation();
            }
            AMapLocationClient aMapLocationClient2 = V3SportsHomeActivity.this.W;
            if (aMapLocationClient2 != null) {
                aMapLocationClient2.onDestroy();
            }
            V3SportsHomeActivity.this.W = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(LocationSource.OnLocationChangedListener onLocationChangedListener, V3SportsHomeActivity v3SportsHomeActivity, AMapLocation aMapLocation) {
            int color;
            AMapLocation aMapLocation2;
            onLocationChangedListener.onLocationChanged(aMapLocation);
            v3SportsHomeActivity.Z = aMapLocation.getGpsAccuracyStatus();
            int u5 = com.bxkj.student.run.app.utils.i.u(v3SportsHomeActivity.Z, v3SportsHomeActivity.Y);
            TextView textView = v3SportsHomeActivity.L().tvGps;
            if (u5 == 2131690189) {
                color = ContextCompat.getColor(v3SportsHomeActivity.H(), R.color.privacy_grey_color);
            } else {
                Context H = v3SportsHomeActivity.H();
                s.a aVar = com.bxkj.student.v2.common.utils.s.f20923a;
                color = ContextCompat.getColor(H, aVar.a(aVar.d(v3SportsHomeActivity.Y)));
            }
            textView.setTextColor(color);
            v3SportsHomeActivity.L().ivGps.setImageResource(u5);
            AMap aMap = null;
            if (aMapLocation.getErrorCode() == 0) {
                aMapLocation2 = aMapLocation;
            } else {
                aMapLocation2 = null;
            }
            if (aMapLocation2 != null) {
                v3SportsHomeActivity.f21550c0 = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                AMap aMap2 = v3SportsHomeActivity.U;
                if (aMap2 == null) {
                    kotlin.jvm.internal.g0.S("aMap");
                } else {
                    aMap = aMap2;
                }
                aMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude())));
                String city = aMapLocation.getCity();
                kotlin.jvm.internal.g0.o(city, "getCity(...)");
                if (city.length() > 0) {
                    String city2 = aMapLocation.getCity();
                    kotlin.jvm.internal.g0.o(city2, "getCity(...)");
                    v3SportsHomeActivity.f1(city2);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class k implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f21577b;

        k(Map<String, Object> map) {
            this.f21577b = map;
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            V3SportsHomeActivity.this.S1(this.f21577b);
        }
    }

    static {
        StubApp.interface11(17464);
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        com.orhanobut.logger.j.d("V3SportsHomeActivity->initUiData", new Object[0]);
        L().setBackEvent(this);
        AcV3SportsHomeBinding L = L();
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        L.setLoggedInUser(aVar.a());
        D().T();
        D().X();
        D().d0();
        D().n0();
        z1();
        if (getIntent().hasExtra("title")) {
            L().setTitle(getIntent().getStringExtra("title"));
        } else {
            L().setTitle("APP跑步");
        }
        G1();
        D().K();
        D().S(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.i0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 j12;
                j12 = V3SportsHomeActivity.j1(V3SportsHomeActivity.this, (Map) obj);
                return j12;
            }
        });
        if (aVar.a().b0() == 1) {
            App.f17573d.a().v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 A1() {
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 C1(V3SportsHomeActivity v3SportsHomeActivity, Map map, iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        it.dismiss();
        com.bxkj.base.util.u.c(v3SportsHomeActivity.r(), v3SportsHomeActivity.new h(map));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 D1(iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        it.dismiss();
        return n1.f44123a;
    }

    public static /* synthetic */ void I1(V3SportsHomeActivity v3SportsHomeActivity, m0.d dVar, Dialog dialog, DialogFragment dialogFragment, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            dialogFragment = null;
        }
        v3SportsHomeActivity.H1(dVar, dialog, dialogFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 M1(V3SportsHomeActivity v3SportsHomeActivity, m0.d dVar, Dialog dialog, DialogFragment faceOutDialog) {
        kotlin.jvm.internal.g0.p(faceOutDialog, "faceOutDialog");
        v3SportsHomeActivity.H1(dVar, dialog, faceOutDialog);
        return n1.f44123a;
    }

    private final void N0(final Map<String, Object> map) {
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        if (c0Var.d(map, "isFromLocalToContinue")) {
            P0(map);
            return;
        }
        if (c0Var.d(map, "serverUnavailable")) {
            P0(map);
        } else if (kotlin.text.u.M3(c0Var.t(map, "countAlertMsg"))) {
            P0(map);
        } else {
            ContextExtKt.h(this, "温馨提示", c0Var.t(map, "countAlertMsg"), new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.r0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 O0;
                    O0 = V3SportsHomeActivity.O0(V3SportsHomeActivity.this, map, (iOSTwoButtonDialog) obj);
                    return O0;
                }
            }, null, "取消跑步", "继续跑步", 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N1() {
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 O0(V3SportsHomeActivity v3SportsHomeActivity, Map map, iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        v3SportsHomeActivity.P0(map);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(final Map<String, Object> map) {
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        if (c0Var.k(map, "isStartFace") != 1 || c0Var.d(map, "isFromLocalToContinue")) {
            V1(map);
            return;
        }
        iOSTwoButtonDialog h6 = ContextExtKt.h(r(), null, com.bxkj.student.v2.common.utils.s.f20923a.d(c0Var.k(map, "runType")) + "开始前，请先进行人脸识别!\n请注意周边环境是否安全！", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 P1;
                P1 = V3SportsHomeActivity.P1(V3SportsHomeActivity.this, map, (iOSTwoButtonDialog) obj);
                return P1;
            }
        }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.n0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 R1;
                R1 = V3SportsHomeActivity.R1((iOSTwoButtonDialog) obj);
                return R1;
            }
        }, null, null, 49, null);
        h6.setClickAutoCancel(false);
        h6.setCancelable(false);
        h6.setCanceledOnTouchOutside(false);
    }

    private final void P0(Map<String, Object> map) {
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        if (c0Var.d(map, "isFromLocalToContinue")) {
            O1(map);
            return;
        }
        List<Map<String, Object>> n6 = c0Var.n(map, "campusList");
        if (n6.isEmpty()) {
            O1(map);
            return;
        }
        if (n6.size() <= 1) {
            Map<String, ? extends Object> map2 = (Map) kotlin.collections.f0.G2(n6);
            List<Map<String, Object>> n7 = c0Var.n(map2, "point");
            String t5 = c0Var.t(map2, com.umeng.analytics.pro.d.X);
            map.put("list", n7);
            map.put(com.umeng.analytics.pro.d.X, t5);
            O1(map);
            return;
        }
        com.bxkj.base.v2.view.a aVar = new com.bxkj.base.v2.view.a(r());
        aVar.i("请选择要锻炼的校区");
        Iterator<T> it = n6.iterator();
        while (it.hasNext()) {
            aVar.c(com.bxkj.base.v2.common.utils.c0.f16887a.t((Map) it.next(), CommonNetImpl.NAME));
        }
        aVar.g(new a(n6, map, this));
        aVar.h("取消");
        aVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 P1(final V3SportsHomeActivity v3SportsHomeActivity, final Map map, final iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        LatLng latLng = v3SportsHomeActivity.f21550c0;
        PointData pointData = new PointData(latLng != null ? latLng.latitude : 0.0d, latLng != null ? latLng.longitude : 0.0d, System.currentTimeMillis(), 0.0f, false, 0, 0L, 0);
        com.bxkj.student.v2.ui.face.f0 f0Var = com.bxkj.student.v2.ui.face.f0.f21370a;
        FragmentActivity r5 = v3SportsHomeActivity.r();
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        f0Var.d(r5, c0Var.k(map, "runType"), c0Var.k(map, "livingFace"), "1", c0Var.t(map, "identify"), pointData, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 Q1;
                Q1 = V3SportsHomeActivity.Q1(iOSTwoButtonDialog.this, v3SportsHomeActivity, map);
                return Q1;
            }
        });
        return n1.f44123a;
    }

    private final void Q0(final Map<String, Object> map) {
        com.bxkj.base.v2.common.ext.b0.u(this, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 R0;
                R0 = V3SportsHomeActivity.R0(V3SportsHomeActivity.this, map);
                return R0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 R1(iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        it.dismiss();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(final Map<String, Object> map) {
        Object systemService = getSystemService("power");
        kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        if (((PowerManager) systemService).isPowerSaveMode()) {
            ContextExtKt.h(this, "请勿开启省电模式", "开始锻炼前请关闭省电模式，否则轨迹记录可能不准确！", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.o0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 T0;
                    T0 = V3SportsHomeActivity.T0(V3SportsHomeActivity.this, map, (iOSTwoButtonDialog) obj);
                    return T0;
                }
            }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.p0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 U0;
                    U0 = V3SportsHomeActivity.U0((iOSTwoButtonDialog) obj);
                    return U0;
                }
            }, null, null, 48, null);
        } else {
            i1(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(final Map<String, Object> map) {
        Object systemService = getSystemService(SocializeConstants.KEY_LOCATION);
        kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        if (((LocationManager) systemService).isProviderEnabled(GeocodeSearch.GPS)) {
            B1(map);
            return;
        }
        String string = getString(R.string.run_request_location);
        kotlin.jvm.internal.g0.o(string, "getString(...)");
        ContextExtKt.h(this, "GPS未开启", string, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 T1;
                T1 = V3SportsHomeActivity.T1(V3SportsHomeActivity.this, map, (iOSTwoButtonDialog) obj);
                return T1;
            }
        }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 U1;
                U1 = V3SportsHomeActivity.U1((iOSTwoButtonDialog) obj);
                return U1;
            }
        }, null, null, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T0(V3SportsHomeActivity v3SportsHomeActivity, Map map, iOSTwoButtonDialog dialog) {
        kotlin.jvm.internal.g0.p(dialog, "dialog");
        dialog.dismiss();
        new u.b(v3SportsHomeActivity).startActivityForResult(new Intent("android.settings.BATTERY_SAVER_SETTINGS")).c(v3SportsHomeActivity.new b(map));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T1(V3SportsHomeActivity v3SportsHomeActivity, Map map, iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        it.dismiss();
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        new u.b(v3SportsHomeActivity.r()).startActivityForResult(intent).c(v3SportsHomeActivity.new k(map));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 U0(iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        it.dismiss();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 U1(iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        it.dismiss();
        return n1.f44123a;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, android.view.View] */
    private final void V0(final Map<String, Object> map) {
        String t5 = com.bxkj.base.v2.common.utils.c0.f16887a.t(map, "sendFace");
        if (kotlin.text.u.M3(t5)) {
            Z0(map);
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        iOSTwoButtonDialog g6 = ContextExtKt.g(this, "温馨提示", t5, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 W0;
                W0 = V3SportsHomeActivity.W0(Ref.ObjectRef.this, this, map, (iOSTwoButtonDialog) obj);
                return W0;
            }
        }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.g0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 Y0;
                Y0 = V3SportsHomeActivity.Y0(V3SportsHomeActivity.this, (iOSTwoButtonDialog) obj);
                return Y0;
            }
        }, "取消跑步", "继续跑步");
        objectRef.element = g6.findViewById(2131296668);
        g6.setClickAutoCancel(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final n1 W0(Ref.ObjectRef objectRef, final V3SportsHomeActivity v3SportsHomeActivity, final Map map, final iOSTwoButtonDialog dialog) {
        e2 f6;
        kotlin.jvm.internal.g0.p(dialog, "dialog");
        Button button = (Button) objectRef.element;
        if (button != null) {
            button.setEnabled(false);
        }
        Button button2 = (Button) objectRef.element;
        if (button2 != null) {
            button2.setTextColor(Color.parseColor("#999999"));
        }
        f6 = kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(v3SportsHomeActivity), null, null, new c(objectRef, null), 3, null);
        v3SportsHomeActivity.G0 = f6;
        v3SportsHomeActivity.D().L(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.h0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 X0;
                X0 = V3SportsHomeActivity.X0(V3SportsHomeActivity.this, map, dialog, obj);
                return X0;
            }
        });
        return n1.f44123a;
    }

    private final void W1(final Map<String, Object> map) {
        com.bxkj.base.v2.common.ext.b0.S(this, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 X1;
                X1 = V3SportsHomeActivity.X1(V3SportsHomeActivity.this, map);
                return X1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 X0(V3SportsHomeActivity v3SportsHomeActivity, Map map, iOSTwoButtonDialog iostwobuttondialog, Object obj) {
        e2 e2Var = v3SportsHomeActivity.G0;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        v3SportsHomeActivity.Z0(map);
        iostwobuttondialog.dismiss();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 X1(V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        if (Build.VERSION.SDK_INT >= 29) {
            v3SportsHomeActivity.Q0(map);
        } else {
            v3SportsHomeActivity.S1(map);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Y0(V3SportsHomeActivity v3SportsHomeActivity, iOSTwoButtonDialog dialog) {
        kotlin.jvm.internal.g0.p(dialog, "dialog");
        e2 e2Var = v3SportsHomeActivity.G0;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        dialog.dismiss();
        return n1.f44123a;
    }

    private final void Z0(final Map<String, Object> map) {
        final com.bxkj.base.v2.base.p pVar = new com.bxkj.base.v2.base.p(r());
        pVar.h();
        com.bxkj.student.v2.common.utils.q.f20918a.c(r(), new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 a12;
                a12 = V3SportsHomeActivity.a1(com.bxkj.base.v2.base.p.this, this, map);
                return a12;
            }
        }, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.c0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 b12;
                b12 = V3SportsHomeActivity.b1(com.bxkj.base.v2.base.p.this);
                return b12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1(Map<String, Object> map) {
        new t.b(r()).c("android.permission.ACTIVITY_RECOGNITION").d(new d(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(final String str) {
        if (this.X.length() > 0) {
            return;
        }
        D().l0(str, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 g12;
                g12 = V3SportsHomeActivity.g1(V3SportsHomeActivity.this, str, (Map) obj);
                return g12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 g1(V3SportsHomeActivity v3SportsHomeActivity, String str, Map it) {
        kotlin.jvm.internal.g0.p(it, "it");
        String t5 = com.bxkj.base.v2.common.utils.c0.f16887a.t(it, "weather");
        v3SportsHomeActivity.X = t5;
        if (t5.length() == 0) {
            v3SportsHomeActivity.h1(str);
        } else {
            v3SportsHomeActivity.L().tvWeather.setText(com.bxkj.base.v2.common.ext.g.b(System.currentTimeMillis()) + "发布天气:" + v3SportsHomeActivity.X);
        }
        return n1.f44123a;
    }

    private final void h1(String str) {
        WeatherSearchQuery weatherSearchQuery = new WeatherSearchQuery(str, 1);
        WeatherSearch weatherSearch = new WeatherSearch(this);
        weatherSearch.setOnWeatherSearchListener(new e(str));
        weatherSearch.setQuery(weatherSearchQuery);
        weatherSearch.searchWeatherAsyn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(Map<String, Object> map) {
        boolean isIgnoringBatteryOptimizations;
        if (Build.VERSION.SDK_INT < 23) {
            N0(map);
            return;
        }
        Object systemService = getSystemService("power");
        kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(getPackageName());
        if (isIgnoringBatteryOptimizations) {
            N0(map);
            return;
        }
        Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        try {
            new u.b(r()).startActivityForResult(intent).c(new f(map));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 j1(V3SportsHomeActivity v3SportsHomeActivity, Map noticeMap) {
        kotlin.jvm.internal.g0.p(noticeMap, "noticeMap");
        com.orhanobut.logger.j.d("latestUnreadNotice=" + noticeMap, new Object[0]);
        NoticeDialog noticeDialog = new NoticeDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", new ParcelableMap(i1.J0(noticeMap)));
        noticeDialog.setArguments(bundle);
        FragmentManager supportFragmentManager = v3SportsHomeActivity.getSupportFragmentManager();
        kotlin.jvm.internal.g0.o(supportFragmentManager, "getSupportFragmentManager(...)");
        noticeDialog.i(supportFragmentManager, "TSNDialog", true);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 o1(final V3SportsHomeActivity v3SportsHomeActivity, List list) {
        if (!com.bxkj.base.v2.data.b.f16998d.a().Y()) {
            return n1.f44123a;
        }
        iOSTwoButtonDialog iostwobuttondialog = v3SportsHomeActivity.f21549b0;
        if (iostwobuttondialog != null) {
            if (!iostwobuttondialog.isShowing()) {
                iostwobuttondialog = null;
            }
            if (iostwobuttondialog != null) {
                iostwobuttondialog.dismiss();
            }
        }
        if (list != null) {
            if (list.isEmpty()) {
                list = null;
            }
            if (list != null) {
                iOSTwoButtonDialog h6 = ContextExtKt.h(v3SportsHomeActivity, null, "系统检测到您还有" + list.size() + "条锻炼记录在本地暂存,是否上传？", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 p12;
                        p12 = V3SportsHomeActivity.p1(V3SportsHomeActivity.this, (iOSTwoButtonDialog) obj);
                        return p12;
                    }
                }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 q12;
                        q12 = V3SportsHomeActivity.q1((iOSTwoButtonDialog) obj);
                        return q12;
                    }
                }, null, null, 49, null);
                h6.setCancelable(false);
                h6.setClickAutoCancel(false);
                h6.setCanceledOnTouchOutside(false);
                h6.setLeftButtonText("暂存本地");
                h6.setRightButtonText("现在上传");
                v3SportsHomeActivity.f21549b0 = h6;
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 p1(V3SportsHomeActivity v3SportsHomeActivity, iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        it.dismiss();
        v3SportsHomeActivity.startActivity(v3SportsHomeActivity.getIntent().setClass(v3SportsHomeActivity.H(), V3RecordListActivity.class).putExtra("toLocal", true));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 q1(iOSTwoButtonDialog it) {
        kotlin.jvm.internal.g0.p(it, "it");
        it.dismiss();
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (r0.isShowing() != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.n1 s1(final com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity r12, java.util.List r13) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity.s1(com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity, java.util.List):kotlin.n1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 t1(V3SportsHomeActivity v3SportsHomeActivity, m0.d dVar, iOSTwoButtonDialog dialog) {
        kotlin.jvm.internal.g0.p(dialog, "dialog");
        v3SportsHomeActivity.L1(dVar, dialog);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 u1(V3SportsHomeActivity v3SportsHomeActivity, m0.d dVar, iOSTwoButtonDialog dialog) {
        kotlin.jvm.internal.g0.p(dialog, "dialog");
        I1(v3SportsHomeActivity, dVar, dialog, null, 4, null);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 v1(final V3SportsHomeActivity v3SportsHomeActivity, final Map map) {
        if (map != null) {
            com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
            String t5 = c0Var.t(map, "identify");
            if ((!c0Var.d(map, "isFromLocalToContinue") ? map : null) != null) {
                v3SportsHomeActivity.D().f0(t5);
            }
            if (c0Var.k(map, "needRegisterFace") == 1) {
                ContextExtKt.o(v3SportsHomeActivity, "对不起您未上传人脸照片，请先进行人脸采集！", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 w12;
                        w12 = V3SportsHomeActivity.w1(V3SportsHomeActivity.this, map, (iOSOneButtonDialog) obj);
                        return w12;
                    }
                });
            } else if (kotlin.jvm.internal.g0.g(c0Var.t(map, "limitWeather"), "1") && (kotlin.text.u.l3(v3SportsHomeActivity.X, "雨", false, 2, null) || kotlin.text.u.l3(v3SportsHomeActivity.X, "雪", false, 2, null) || kotlin.text.u.l3(v3SportsHomeActivity.X, "霾", false, 2, null))) {
                ContextExtKt.m(v3SportsHomeActivity, "当前天气：" + v3SportsHomeActivity.X + ",不能进行锻炼");
            } else {
                v3SportsHomeActivity.V0(map);
                n1 n1Var = n1.f44123a;
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 w1(V3SportsHomeActivity v3SportsHomeActivity, Map map, iOSOneButtonDialog dialog) {
        kotlin.jvm.internal.g0.p(dialog, "dialog");
        dialog.dismiss();
        com.bxkj.student.v2.common.utils.i.f20904a.b(v3SportsHomeActivity.H(), i1.j0(kotlin.o0.a(CommonNetImpl.NAME, "人脸管理"), kotlin.o0.a("linkUrl", com.bxkj.base.v2.common.utils.c0.f16887a.t(map, "faceUrl"))));
        return n1.f44123a;
    }

    private final void z1() {
        com.bxkj.base.v2.common.ext.b0.S(this, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.j0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 A1;
                A1 = V3SportsHomeActivity.A1();
                return A1;
            }
        });
    }

    public final void E1(@Nullable DialogFragment dialogFragment) {
        this.F0 = dialogFragment;
    }

    public final void H1(@NotNull final m0.d sportsDb, @NotNull final Dialog exceptionDialog, @Nullable final DialogFragment dialogFragment) {
        kotlin.jvm.internal.g0.p(sportsDb, "sportsDb");
        kotlin.jvm.internal.g0.p(exceptionDialog, "exceptionDialog");
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        aVar.B().clear();
        Map<String, Object> B = aVar.B();
        ArrayMap<String, Object> jsonToMap = JsonParse.jsonToMap(sportsDb.N());
        kotlin.jvm.internal.g0.o(jsonToMap, "jsonToMap(...)");
        B.putAll(jsonToMap);
        aVar.x().clear();
        List<Map<String, Object>> x5 = aVar.x();
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        x5.addAll(kotlin.collections.f0.d6(c0Var.z(sportsDb.L())));
        aVar.r0(Long.parseLong(sportsDb.Q()));
        aVar.U(Long.parseLong(sportsDb.B()));
        aVar.W(Double.parseDouble(sportsDb.C()));
        aVar.k0(Integer.parseInt(sportsDb.W()));
        aVar.Y(Double.parseDouble(sportsDb.F()));
        String M = sportsDb.M();
        if (kotlin.text.u.a2(M, "null", true)) {
            M = null;
        }
        if (M != null) {
            if (M.length() <= 0) {
                M = null;
            }
            if (M != null) {
                Map<String, Object> A = c0Var.A(M);
                aVar.o0(new LatLng(c0Var.f(A, "latitude"), c0Var.f(A, "longitude")));
            }
        }
        aVar.c0(sportsDb.H().length() == 0 ? 0.0d : Double.parseDouble(sportsDb.H()));
        String a6 = com.bxkj.student.run.app.utils.i.a(Double.parseDouble(sportsDb.C()), Long.parseLong(sportsDb.B()));
        kotlin.jvm.internal.g0.o(a6, "calAvgSpeed(...)");
        aVar.T(a6);
        String b6 = com.bxkj.student.run.app.utils.i.b(Double.parseDouble(sportsDb.C()), Long.parseLong(sportsDb.B()));
        kotlin.jvm.internal.g0.o(b6, "calPace(...)");
        aVar.m0(b6);
        aVar.j().setValue(Integer.valueOf(Integer.parseInt(sportsDb.G())));
        aVar.k().setValue(Boolean.valueOf(Boolean.parseBoolean(sportsDb.V())));
        aVar.S();
        List parseArray = JSON.parseArray(sportsDb.J(), PointData.class);
        aVar.s().clear();
        if (parseArray != null) {
            List list = parseArray.isEmpty() ? null : parseArray;
            if (list != null) {
                aVar.s().addAll(kotlin.collections.f0.x2(parseArray));
                PointData pointData = (PointData) list.get(list.size() - 1);
                if (pointData != null) {
                    pointData.setI(true);
                }
                LatLng latLng = new LatLng(((PointData) parseArray.get(0)).getA(), ((PointData) parseArray.get(0)).getO());
                aVar.q0(latLng);
                aVar.Q(latLng);
            }
        }
        List parseArray2 = JSON.parseArray(sportsDb.R(), Integer.TYPE);
        if (parseArray2 != null) {
            aVar.u0(kotlin.collections.f0.H5(parseArray2));
        }
        aVar.H().clear();
        List<Integer> H = aVar.H();
        kotlin.jvm.internal.g0.m(parseArray2);
        H.addAll(parseArray2);
        V3SportsFinishDialog v3SportsFinishDialog = new V3SportsFinishDialog();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        kotlin.jvm.internal.g0.o(supportFragmentManager, "getSupportFragmentManager(...)");
        v3SportsFinishDialog.show(supportFragmentManager, "finishDialog");
        v3SportsFinishDialog.s0(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean J1;
                J1 = V3SportsHomeActivity.J1(V3SportsHomeActivity.this, sportsDb, exceptionDialog);
                return Boolean.valueOf(J1);
            }
        });
        v3SportsFinishDialog.t0(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 K1;
                K1 = V3SportsHomeActivity.K1(exceptionDialog, dialogFragment);
                return K1;
            }
        });
    }

    public final void L1(@NotNull final m0.d sportsDb, @NotNull final Dialog exceptionDialog) {
        Dialog dialog;
        kotlin.jvm.internal.g0.p(sportsDb, "sportsDb");
        kotlin.jvm.internal.g0.p(exceptionDialog, "exceptionDialog");
        DialogFragment dialogFragment = this.F0;
        if (dialogFragment == null || (dialog = dialogFragment.getDialog()) == null || !dialog.isShowing()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f21552p0 > this.f21551k0) {
                if (Boolean.parseBoolean(sportsDb.V())) {
                    D().p0(sportsDb, new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            n1 N1;
                            N1 = V3SportsHomeActivity.N1();
                            return N1;
                        }
                    });
                    this.f21552p0 = currentTimeMillis;
                } else {
                    this.F0 = FaceOutDialog.f21310r.d(Integer.parseInt(sportsDb.G()) + 1, (int) (com.bxkj.base.v2.common.utils.c0.f16887a.f(JsonParse.jsonToMap(sportsDb.N()), "faceDistanceOut") * 1000), J(), new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.w
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            n1 M1;
                            M1 = V3SportsHomeActivity.M1(V3SportsHomeActivity.this, sportsDb, exceptionDialog, (DialogFragment) obj);
                            return M1;
                        }
                    });
                }
            }
        }
    }

    public final void Y1() {
        if (this.f21550c0 == null) {
            ContextExtKt.m(this, "当前未获取到您的位置信息，请开启定位并检测定位权限后再开始跑步");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f21552p0 > this.f21551k0) {
            SportsHomeVM D = D();
            s.a aVar = com.bxkj.student.v2.common.utils.s.f20923a;
            TabLayout.Tab tabAt = L().tab.getTabAt(L().tab.getSelectedTabPosition());
            D.b0(aVar.c(tabAt != null ? tabAt.getText() : null), this.f21550c0);
            this.f21552p0 = currentTimeMillis;
        }
    }

    public final void Z1() {
        startActivity(new Intent(H(), (Class<?>) SportsDescriptionActivity.class).putExtra("showBottom", false));
    }

    public final void a2() {
        startActivity(new Intent(H(), (Class<?>) PermissionSetActivity.class));
    }

    public final void b2() {
        startActivity(new Intent(H(), (Class<?>) V3RecordListActivity.class));
    }

    public final void c2() {
        startActivity(new Intent(H(), (Class<?>) V3RecordListActivity.class).putExtra("tabIndex", 1));
    }

    public final void d2() {
        startActivity(new Intent(H(), (Class<?>) SportsSetActivity.class));
    }

    @Nullable
    public final DialogFragment e1() {
        return this.F0;
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        e2 e2Var = this.G0;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        LocationSource locationSource = this.V;
        if (locationSource != null) {
            locationSource.deactivate();
        }
        AMapLocationClient aMapLocationClient = this.W;
        if (aMapLocationClient != null) {
            aMapLocationClient.onDestroy();
        }
        L().map.onDestroy();
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        kotlin.jvm.internal.g0.p(outState, "outState");
        super.onSaveInstanceState(outState);
        L().map.onSaveInstanceState(outState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        AMapLocationClient aMapLocationClient = this.W;
        if (aMapLocationClient != null) {
            aMapLocationClient.stopLocation();
        }
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(final Map<String, Object> map) {
        if (!com.bxkj.base.util.u.a(H())) {
            ContextExtKt.h(this, "允许体适能推送通知未开启", "为了能够让你在锻炼过程中不错过重要的通知消息,必须开启允许推送通知功能", new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 C1;
                    C1 = V3SportsHomeActivity.C1(V3SportsHomeActivity.this, map, (iOSTwoButtonDialog) obj);
                    return C1;
                }
            }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 D1;
                    D1 = V3SportsHomeActivity.D1((iOSTwoButtonDialog) obj);
                    return D1;
                }
            }, null, null, 48, null);
        } else {
            S0(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1() {
        L().setRecordMap(D().g0(this.Y));
    }

    private final void G1() {
        AMap map = L().map.getMap();
        kotlin.jvm.internal.g0.o(map, "getMap(...)");
        this.U = map;
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.mipmap.location_marker));
        myLocationStyle.strokeColor(ViewCompat.MEASURED_STATE_MASK);
        myLocationStyle.radiusFillColor(Color.argb(100, 0, 0, 180));
        myLocationStyle.strokeWidth(1.0f);
        myLocationStyle.myLocationType(5);
        AMap aMap = this.U;
        AMap aMap2 = null;
        if (aMap == null) {
            kotlin.jvm.internal.g0.S("aMap");
            aMap = null;
        }
        aMap.setMyLocationStyle(myLocationStyle);
        this.V = new j();
        AMap aMap3 = this.U;
        if (aMap3 == null) {
            kotlin.jvm.internal.g0.S("aMap");
            aMap3 = null;
        }
        aMap3.setLocationSource(this.V);
        AMap aMap4 = this.U;
        if (aMap4 == null) {
            kotlin.jvm.internal.g0.S("aMap");
            aMap4 = null;
        }
        aMap4.getUiSettings().setMyLocationButtonEnabled(true);
        AMap aMap5 = this.U;
        if (aMap5 == null) {
            kotlin.jvm.internal.g0.S("aMap");
            aMap5 = null;
        }
        aMap5.setMyLocationEnabled(true);
        CameraUpdate zoomTo = CameraUpdateFactory.zoomTo(19.0f);
        AMap aMap6 = this.U;
        if (aMap6 == null) {
            kotlin.jvm.internal.g0.S("aMap");
        } else {
            aMap2 = aMap6;
        }
        aMap2.moveCamera(zoomTo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J1(V3SportsHomeActivity v3SportsHomeActivity, m0.d dVar, Dialog dialog) {
        v3SportsHomeActivity.L1(dVar, dialog);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 K1(Dialog dialog, DialogFragment dialogFragment) {
        dialog.dismiss();
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Q1(iOSTwoButtonDialog iostwobuttondialog, V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        iostwobuttondialog.dismiss();
        v3SportsHomeActivity.V1(map);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 R0(V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        v3SportsHomeActivity.c1(map);
        return n1.f44123a;
    }

    private final void V1(Map<String, Object> map) {
        cn.bluemobi.dylan.base.utils.a.n().i(V4SportActivity.class);
        i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
        aVar.B().clear();
        aVar.B().putAll(map);
        String t5 = com.bxkj.base.v2.common.utils.c0.f16887a.t(map, "lastExerciseExplanationDate");
        b.a aVar2 = com.bxkj.base.v2.data.b.f16998d;
        if (aVar2.a().F() && kotlin.jvm.internal.g0.g(t5, aVar2.a().t())) {
            startActivity(new Intent(H(), (Class<?>) V4SportActivity.class));
            overridePendingTransition(R.anim.qr_code_zoom_in, R.anim.qr_code_zoom_out);
        } else {
            aVar2.a().E0(false);
            aVar2.a().r0(t5);
            startActivity(getIntent().setClass(H(), SportsDescriptionActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 a1(com.bxkj.base.v2.base.p pVar, V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        pVar.b();
        v3SportsHomeActivity.W1(map);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 b1(com.bxkj.base.v2.base.p pVar) {
        pVar.b();
        return n1.f44123a;
    }

    private final TabLayout.Tab d1(String str) {
        CharSequence charSequence;
        int tabCount = L().tab.getTabCount();
        TabLayout.Tab tab = null;
        for (int i6 = 0; i6 < tabCount; i6++) {
            TabLayout.Tab tabAt = L().tab.getTabAt(i6);
            if (tabAt != null) {
                charSequence = tabAt.getText();
            } else {
                charSequence = null;
            }
            if (kotlin.jvm.internal.g0.g(str, charSequence)) {
                tab = L().tab.getTabAt(i6);
            }
        }
        return tab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 k1(V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        v3SportsHomeActivity.F1();
        Map map2 = null;
        if (com.bxkj.base.v2.common.utils.c0.f16887a.k(map, "isShow") != 1) {
            map = null;
        }
        if (map != null) {
            if (v3SportsHomeActivity.d1("阳光跑") == null) {
                map2 = map;
            }
            if (map2 != null) {
                TabLayout.Tab text = v3SportsHomeActivity.L().tab.newTab().setText("阳光跑");
                kotlin.jvm.internal.g0.o(text, "setText(...)");
                v3SportsHomeActivity.L().tab.addTab(text);
                text.select();
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l1(V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        v3SportsHomeActivity.F1();
        Map map2 = null;
        if (com.bxkj.base.v2.common.utils.c0.f16887a.k(map, "isShow") != 1) {
            map = null;
        }
        if (map != null) {
            if (v3SportsHomeActivity.d1("自由跑") == null) {
                map2 = map;
            }
            if (map2 != null) {
                v3SportsHomeActivity.L().tab.addTab(v3SportsHomeActivity.L().tab.newTab().setText("自由跑"));
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 m1(V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        v3SportsHomeActivity.F1();
        Map map2 = null;
        if (com.bxkj.base.v2.common.utils.c0.f16887a.k(map, "isShow") != 1) {
            map = null;
        }
        if (map != null) {
            if (v3SportsHomeActivity.d1("场地锻炼") == null) {
                map2 = map;
            }
            if (map2 != null) {
                v3SportsHomeActivity.L().tab.addTab(v3SportsHomeActivity.L().tab.newTab().setText("场地锻炼"));
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 n1(V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        v3SportsHomeActivity.F1();
        Map map2 = null;
        if (com.bxkj.base.v2.common.utils.c0.f16887a.k(map, "isShow") != 1) {
            map = null;
        }
        if (map != null) {
            if (v3SportsHomeActivity.d1("定向越野") == null) {
                map2 = map;
            }
            if (map2 != null) {
                v3SportsHomeActivity.L().tab.addTab(v3SportsHomeActivity.L().tab.newTab().setText("定向越野"));
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 r1(V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        Context H = v3SportsHomeActivity.H();
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        cn.bluemobi.dylan.base.utils.o.f(H, c0Var.t(map, "imageRouteUrl"), v3SportsHomeActivity.L().ivHead, R.mipmap.v3_head_icon, R.mipmap.v3_head_icon);
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().X0(c0Var.t(map, "nickName"));
        v3SportsHomeActivity.L().tvName.setText(aVar.a().U());
        v3SportsHomeActivity.L().tvAccount.setText(aVar.a().S());
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 x1(V3SportsHomeActivity v3SportsHomeActivity, Map map) {
        v3SportsHomeActivity.F1();
        Map map2 = null;
        if (com.bxkj.base.v2.common.utils.c0.f16887a.k(map, "isShow") != 1) {
            map = null;
        }
        if (map != null) {
            if (v3SportsHomeActivity.d1("早操跑") == null) {
                map2 = map;
            }
            if (map2 != null) {
                v3SportsHomeActivity.L().tab.addTab(v3SportsHomeActivity.L().tab.newTab().setText("早操跑"));
            }
        }
        return n1.f44123a;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        L().map.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        CharSequence charSequence;
        super.onResume();
        Window window = getWindow();
        if (window != null) {
            Context H = H();
            s.a aVar = com.bxkj.student.v2.common.utils.s.f20923a;
            TabLayout.Tab tabAt = L().tab.getTabAt(L().tab.getSelectedTabPosition());
            if (tabAt != null) {
                charSequence = tabAt.getText();
            } else {
                charSequence = null;
            }
            window.setStatusBarColor(ContextCompat.getColor(H, aVar.a(charSequence)));
        }
        L().map.onResume();
        AMapLocationClient aMapLocationClient = this.W;
        if (aMapLocationClient != null) {
            aMapLocationClient.startLocation();
        }
        stopService(new Intent(this, (Class<?>) V3LocationService.class));
        stopService(new Intent(this, (Class<?>) V3StepService.class));
        Object systemService = getSystemService("notification");
        kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(100);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().j0().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 r12;
                r12 = V3SportsHomeActivity.r1(V3SportsHomeActivity.this, (Map) obj);
                return r12;
            }
        }));
        L().tab.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new g());
        D().W().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.u0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 x12;
                x12 = V3SportsHomeActivity.x1(V3SportsHomeActivity.this, (Map) obj);
                return x12;
            }
        }));
        D().h0().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.v0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 k12;
                k12 = V3SportsHomeActivity.k1(V3SportsHomeActivity.this, (Map) obj);
                return k12;
            }
        }));
        D().R().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l12;
                l12 = V3SportsHomeActivity.l1(V3SportsHomeActivity.this, (Map) obj);
                return l12;
            }
        }));
        D().P().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 m12;
                m12 = V3SportsHomeActivity.m1(V3SportsHomeActivity.this, (Map) obj);
                return m12;
            }
        }));
        D().N().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 n12;
                n12 = V3SportsHomeActivity.n1(V3SportsHomeActivity.this, (Map) obj);
                return n12;
            }
        }));
        D().i0().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.o
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 o12;
                o12 = V3SportsHomeActivity.o1(V3SportsHomeActivity.this, (List) obj);
                return o12;
            }
        }));
        D().O().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 s12;
                s12 = V3SportsHomeActivity.s1(V3SportsHomeActivity.this, (List) obj);
                return s12;
            }
        }));
        D().a0().observe(r(), new i(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 v12;
                v12 = V3SportsHomeActivity.v1(V3SportsHomeActivity.this, (Map) obj);
                return v12;
            }
        }));
    }

    public final void y1() {
        D().d0();
        D().n0();
    }
}
