package com.bxkj.student.v2.ui.sports.v3;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.common.view.LongPressButton;
import com.bxkj.student.databinding.AcV4SportsBinding;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.common.utils.s;
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;
import com.bxkj.student.v2.ui.sports.v3.service.V3GeoFenceObserver;
import com.bxkj.student.v2.ui.sports.v3.service.V3KillNotificationsService;
import com.bxkj.student.v2.ui.sports.v3.service.V3LocationService;
import com.bxkj.student.v2.ui.sports.v3.service.V3MapObserver;
import com.bxkj.student.v2.ui.sports.v3.service.V3PassPoint2Observer;
import com.bxkj.student.v2.ui.sports.v3.service.step.V3StepService;
import com.bxkj.student.v2.vm.sports.SportsVM;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.stub.StubApp;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV4SportActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V4SportActivity.kt\ncom/bxkj/student/v2/ui/sports/v3/V4SportActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,600:1\n1#2:601\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V4SportActivity extends BaseActivity<AcV4SportsBinding, SportsVM> {

    @Nullable
    private BroadcastReceiver F0;

    @Nullable
    private Handler U;

    @Nullable
    private Runnable V;

    @Nullable
    private V3MapObserver W;

    @Nullable
    private V3GeoFenceObserver X;

    @Nullable
    private V3PassPoint2Observer Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    private final kotlin.s f21579a0 = kotlin.t.c(new Function0() { // from class: com.bxkj.student.v2.ui.sports.v3.g1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            BottomSheetBehavior N;
            N = V4SportActivity.N(V4SportActivity.this);
            return N;
        }
    });

    /* renamed from: b0, reason: collision with root package name */
    @NotNull
    private final ServiceConnection f21580b0 = new b();

    /* renamed from: c0, reason: collision with root package name */
    private boolean f21581c0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f21582k0;

    /* renamed from: p0, reason: collision with root package name */
    @Nullable
    private BroadcastReceiver f21583p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (seekBar != null) {
                int progress = seekBar.getProgress();
                V4SportActivity v4SportActivity = V4SportActivity.this;
                if (progress < 100) {
                    seekBar.setProgress(0);
                    return;
                }
                seekBar.setProgress(100);
                v4SportActivity.h0();
                seekBar.setProgress(0);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i6, boolean z5) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName className, IBinder binder) {
            kotlin.jvm.internal.g0.p(className, "className");
            kotlin.jvm.internal.g0.p(binder, "binder");
            ((V3KillNotificationsService.a) binder).a().startService(new Intent(V4SportActivity.this.H(), (Class<?>) V3KillNotificationsService.class));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName className) {
            kotlin.jvm.internal.g0.p(className, "className");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends BottomSheetBehavior.BottomSheetCallback {
        c() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View bottomSheet, float f6) {
            kotlin.jvm.internal.g0.p(bottomSheet, "bottomSheet");
            V4SportActivity.this.L().expandView.setAlpha(f6);
            V4SportActivity.this.L().collapseView.setAlpha(1 - f6);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View bottomSheet, int i6) {
            kotlin.jvm.internal.g0.p(bottomSheet, "bottomSheet");
            if (i6 != 3) {
                if (i6 == 4) {
                    V4SportActivity.this.L().expandView.setVisibility(4);
                    V4SportActivity.this.L().collapseView.setVisibility(0);
                    V4SportActivity.this.L().bottomCard.setCardBackgroundColor(ContextCompat.getColor(V4SportActivity.this.H(), 2131099737));
                    return;
                } else if (i6 != 6) {
                    return;
                }
            }
            V4SportActivity.this.L().expandView.setVisibility(0);
            V4SportActivity.this.L().collapseView.setVisibility(4);
            V4SportActivity.this.L().bottomCard.setCardBackgroundColor(ContextCompat.getColor(V4SportActivity.this.H(), R.color.v3_sporting_color));
        }
    }

    static {
        StubApp.interface11(17472);
    }

    public final void P() {
        this.f21581c0 = true;
        f0();
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        i.a aVar;
        try {
            aVar = com.bxkj.student.v2.common.data.i.f20657a;
            aVar.c();
            L().setBackEvent(this);
            bindService(new Intent(H(), (Class<?>) V3KillNotificationsService.class), this.f21580b0, 1);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (aVar.B().isEmpty()) {
            ContextExtKt.q(this, "数据异常，没有运动类型");
            com.orhanobut.logger.j.e("数据异常，没有运动类型", new Object[0]);
            finish();
            return;
        }
        D().S(aVar.B());
        Object obj = D().M().get("runType");
        if (obj == null) {
            obj = -1;
        }
        int parseInt = Integer.parseInt(obj.toString());
        L().setSportType(parseInt);
        L().setTitle(com.bxkj.student.v2.common.utils.s.f20923a.d(parseInt) + "中");
        Object obj2 = D().M().get("identify");
        Object obj3 = "";
        if (obj2 == null) {
            obj2 = "";
        }
        String valueOf = String.valueOf(obj2);
        if (TextUtils.isEmpty(valueOf)) {
            ContextExtKt.q(this, "数据异常，没有身份");
            com.orhanobut.logger.j.e("数据异常，没有身份", new Object[0]);
            finish();
            return;
        }
        d0();
        M();
        Y();
        D().Q(valueOf, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj4) {
                n1 T;
                T = V4SportActivity.T(V4SportActivity.this, (m0.d) obj4);
                return T;
            }
        });
        Object obj4 = D().M().get(com.umeng.analytics.pro.d.X);
        if (obj4 != null) {
            obj3 = obj4;
        }
        String valueOf2 = String.valueOf(obj3);
        Object obj5 = D().M().get("isClock");
        if (obj5 == null) {
            obj5 = "0";
        }
        String valueOf3 = String.valueOf(obj5);
        L().setNotice(valueOf2);
        L().setIsClock(valueOf3);
        com.bxkj.base.v2.common.utils.c0 c0Var = com.bxkj.base.v2.common.utils.c0.f16887a;
        i.a aVar2 = com.bxkj.student.v2.common.data.i.f20657a;
        int k6 = c0Var.k(aVar2.B(), "runType");
        TabLayout.Tab tabAt = L().tab.getTabAt(0);
        if (tabAt != null) {
            tabAt.setText(com.bxkj.student.v2.common.utils.s.f20923a.d(k6));
        }
        int color = ContextCompat.getColor(H(), R.color.v3_tab_color3);
        L().titleLayout.setBackgroundResource(R.color.v3_tab_color3);
        com.bxkj.student.common.utils.k.g(this, color);
        L().tvGps.setTextColor(color);
        L().saDistance.k(c0Var.i(D().M(), "totalRange"));
        L().saDistance.p("目标里程：" + c0Var.t(D().M(), "totalRange") + "KM");
        L().saDistance.l((float) com.bxkj.student.run.app.utils.i.e(aVar2.g()));
        L().saDistance.n(com.bxkj.student.run.app.utils.i.c(aVar2.g()));
        L().saTime.k(c0Var.i(D().M(), "startQualifiedTime"));
        L().saTime.p("有效时间：(" + c0Var.t(D().M(), "startQualifiedTime") + "-" + c0Var.t(D().M(), "endQualifiedTime") + ")分");
        L().saTime.l(((float) aVar2.e()) / 60.0f);
        L().saTime.n(com.bxkj.base.v2.common.utils.g.b(aVar2.e()));
        Integer valueOf4 = Integer.valueOf(aVar2.b());
        if (valueOf4.intValue() == -1) {
            valueOf4 = null;
        }
        if (valueOf4 != null) {
            int intValue = valueOf4.intValue();
            L().saTime.o(intValue);
            L().saTime.p("有效时间：(" + c0Var.t(D().M(), "startQualifiedTime") + "-" + intValue + ")分");
        }
        int a6 = aVar2.a();
        L().saStep.k(a6);
        L().saStep.p("达标步数：" + a6);
        L().saStep.l((float) aVar2.G());
        L().saStep.n(String.valueOf(aVar2.G()));
        L().tvAvgSpeed.setText(aVar2.d());
        L().tvPaceSpeed.setText(aVar2.y());
        L().ivGps.setImageResource(com.bxkj.student.run.app.utils.i.u(aVar2.p(), 2));
        L().ivUnlock.setOnFinishListener(new LongPressButton.OnFinishListener() { // from class: com.bxkj.student.v2.ui.sports.v3.d1
            @Override // com.bxkj.student.common.view.LongPressButton.OnFinishListener
            public final void onFinish() {
                V4SportActivity.U(V4SportActivity.this);
            }
        });
        L().ivStop.setOnFinishListener(new LongPressButton.OnFinishListener() { // from class: com.bxkj.student.v2.ui.sports.v3.e1
            @Override // com.bxkj.student.common.view.LongPressButton.OnFinishListener
            public final void onFinish() {
                V4SportActivity.S(V4SportActivity.this);
            }
        });
        L().sbLock.setOnSeekBarChangeListener(new a());
    }

    private final void M() {
        this.f21583p0 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V4SportActivity$addBroadCastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int color;
                if (intent != null) {
                    V4SportActivity v4SportActivity = V4SportActivity.this;
                    if (intent.hasExtra("firstMapLocation")) {
                        v4SportActivity.b0(true);
                        if (v4SportActivity.V()) {
                            v4SportActivity.f0();
                        }
                    }
                    if (intent.hasExtra("gpsStatusImage")) {
                        int u5 = com.bxkj.student.run.app.utils.i.u(com.bxkj.student.v2.common.data.i.f20657a.p(), 0);
                        TextView textView = v4SportActivity.L().tvGps;
                        if (u5 == 2131690189) {
                            color = ContextCompat.getColor(v4SportActivity.H(), R.color.privacy_grey_color);
                        } else {
                            Context H = v4SportActivity.H();
                            s.a aVar = com.bxkj.student.v2.common.utils.s.f20923a;
                            color = ContextCompat.getColor(H, aVar.a(aVar.d(0)));
                        }
                        textView.setTextColor(color);
                        v4SportActivity.L().ivGps.setImageResource(u5);
                    }
                    if (intent.hasExtra("countTime")) {
                        long longExtra = intent.getLongExtra("countTime", 0L);
                        v4SportActivity.L().tvTime.setText(com.bxkj.base.v2.common.utils.g.b(longExtra));
                        v4SportActivity.L().saTime.l(longExtra / 60.0f);
                        v4SportActivity.L().saTime.n(com.bxkj.base.v2.common.utils.g.b(longExtra));
                    }
                    if (intent.hasExtra("distance")) {
                        double doubleExtra = intent.getDoubleExtra("distance", 0.0d);
                        v4SportActivity.L().tvDistance.setText(com.bxkj.student.run.app.utils.i.c(doubleExtra));
                        v4SportActivity.L().saDistance.l((float) com.bxkj.student.run.app.utils.i.e(doubleExtra));
                        v4SportActivity.L().saDistance.n(com.bxkj.student.run.app.utils.i.c(doubleExtra));
                        i.a aVar2 = com.bxkj.student.v2.common.data.i.f20657a;
                        Integer valueOf = Integer.valueOf(aVar2.b());
                        if (valueOf.intValue() == -1) {
                            valueOf = null;
                        }
                        if (valueOf != null) {
                            int intValue = valueOf.intValue();
                            v4SportActivity.L().saTime.o(intValue);
                            v4SportActivity.L().saTime.p("有效时间：(" + com.bxkj.base.v2.common.utils.c0.f16887a.t(v4SportActivity.D().M(), "startQualifiedTime") + "-" + intValue + ")分");
                        }
                        int a6 = aVar2.a();
                        v4SportActivity.L().saStep.k(a6);
                        v4SportActivity.L().saStep.p("达标步数：" + a6);
                    }
                    if (intent.hasExtra("avgSpeed")) {
                        v4SportActivity.L().tvAvgSpeed.setText(intent.getStringExtra("avgSpeed"));
                    }
                    if (intent.hasExtra("pace")) {
                        v4SportActivity.L().tvPaceSpeed.setText(intent.getStringExtra("pace"));
                    }
                    if (intent.hasExtra("stepCount")) {
                        int intExtra = intent.getIntExtra("stepCount", com.bxkj.student.v2.common.data.i.f20657a.G());
                        v4SportActivity.L().tvStep.setText(String.valueOf(intExtra));
                        v4SportActivity.L().saStep.l(intExtra);
                        v4SportActivity.L().saStep.n(String.valueOf(intExtra));
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter(App.f17573d.a().getPackageName() + ".run");
        BroadcastReceiver broadcastReceiver = this.f21583p0;
        if (broadcastReceiver != null) {
            registerReceiver(broadcastReceiver, intentFilter, com.bxkj.student.v2.common.data.k.f20685b, null);
        }
        BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.ui.sports.v3.V4SportActivity$addBroadCastReceiver$3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                kotlin.jvm.internal.g0.p(context, "context");
                kotlin.jvm.internal.g0.p(intent, "intent");
                if (kotlin.jvm.internal.g0.g("android.intent.action.SCREEN_OFF", intent.getAction())) {
                    V4SportActivity.this.r1();
                    V4SportActivity.this.X();
                }
            }
        };
        this.F0 = broadcastReceiver2;
        registerReceiver(broadcastReceiver2, new IntentFilter("android.intent.action.SCREEN_OFF"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(V4SportActivity v4SportActivity) {
        com.bxkj.student.v2.common.data.i.f20657a.v0(true);
        V3SportsFinishDialog v3SportsFinishDialog = new V3SportsFinishDialog();
        FragmentManager supportFragmentManager = v4SportActivity.getSupportFragmentManager();
        kotlin.jvm.internal.g0.o(supportFragmentManager, "getSupportFragmentManager(...)");
        v3SportsFinishDialog.show(supportFragmentManager, "finishDialog");
    }

    private final void d0() {
        if ((!this.Z ? this : null) != null) {
            startActivity(new Intent(H(), (Class<?>) V3ThreeTwoOneActivity.class));
            String t5 = com.bxkj.base.v2.common.utils.c0.f16887a.t(com.bxkj.student.v2.common.data.i.f20657a.B(), com.umeng.analytics.pro.d.X);
            String str = t5.length() > 0 ? t5 : null;
            if (str != null) {
                ContextExtKt.n(this, str, "温馨提示").setMessageGrivity(3);
            }
        }
    }

    @NotNull
    public final BottomSheetBehavior<View> R() {
        Object value = this.f21579a0.getValue();
        kotlin.jvm.internal.g0.o(value, "getValue(...)");
        return (BottomSheetBehavior) value;
    }

    public final boolean V() {
        return this.f21581c0;
    }

    public final boolean W() {
        return this.f21582k0;
    }

    public final void a0(boolean z5) {
        this.f21581c0 = z5;
    }

    public final void b0(boolean z5) {
        this.f21582k0 = z5;
    }

    public final void g0() {
        startActivity(new Intent(H(), (Class<?>) SportsSetActivity.class));
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        kotlin.jvm.internal.g0.p(outState, "outState");
        L().mMapView.onSaveInstanceState(outState);
        outState.putString("sportsSetMap", JSON.toJSONString(com.bxkj.student.v2.common.data.i.f20657a.B()));
        super.onSaveInstanceState(outState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BottomSheetBehavior N(V4SportActivity v4SportActivity) {
        return BottomSheetBehavior.from(v4SportActivity.L().bottomSheet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T(V4SportActivity v4SportActivity, m0.d dVar) {
        v4SportActivity.e0();
        SportsVM D = v4SportActivity.D();
        AMap map = v4SportActivity.L().mMapView.getMap();
        kotlin.jvm.internal.g0.o(map, "getMap(...)");
        V3MapObserver v3MapObserver = new V3MapObserver(v4SportActivity, D, map);
        v4SportActivity.W = v3MapObserver;
        v4SportActivity.getLifecycle().addObserver(v3MapObserver);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(V4SportActivity v4SportActivity) {
        v4SportActivity.h0();
    }

    private final void Y() {
        L().expandView.setVisibility(4);
        L().collapseView.post(new Runnable() { // from class: com.bxkj.student.v2.ui.sports.v3.f1
            @Override // java.lang.Runnable
            public final void run() {
                V4SportActivity.Z(V4SportActivity.this);
            }
        });
        R().addBottomSheetCallback(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(V4SportActivity v4SportActivity) {
        int height = v4SportActivity.L().collapseView.getHeight();
        com.orhanobut.logger.j.d("底部抽屉默认高度：" + height, new Object[0]);
        v4SportActivity.R().setPeekHeight(height + cn.bluemobi.dylan.base.utils.u.a(30.0f, v4SportActivity.H()));
    }

    private final void e0() {
        if (!com.bxkj.base.util.a0.a(H(), V3LocationService.class.getName())) {
            Intent intent = new Intent(this, (Class<?>) V3LocationService.class);
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0() {
        R().setDraggable(true);
        L().ivLock.setVisibility(0);
        L().cvToMap.setVisibility(0);
        L().ivStop.setVisibility(0);
        Object parent = L().sbLock.getParent();
        kotlin.jvm.internal.g0.n(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setVisibility(8);
        com.bxkj.base.v2.common.utils.c0.f16887a.k(com.bxkj.student.v2.common.data.i.f20657a.B(), "runType");
    }

    public final void O() {
        if (R().isDraggable()) {
            R().setState(4);
        }
    }

    public final void Q() {
        if (R().isDraggable()) {
            R().setState(3);
        }
    }

    public final void X() {
        R().setDraggable(false);
        L().ivLock.setVisibility(4);
        L().cvToMap.setVisibility(4);
        L().ivStop.setVisibility(4);
        Object parent = L().sbLock.getParent();
        kotlin.jvm.internal.g0.n(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setVisibility(0);
        com.bxkj.base.v2.common.utils.c0.f16887a.k(com.bxkj.student.v2.common.data.i.f20657a.B(), "runType");
    }

    public final void c0() {
        R().setState(4);
    }

    public final void f0() {
        long v5;
        long elapsedRealtime;
        long w5;
        long j6;
        if (!isFinishing() && !isDestroyed() && this.f21581c0 && this.f21582k0) {
            i.a aVar = com.bxkj.student.v2.common.data.i.f20657a;
            if (aVar.D() == 0) {
                if (aVar.v() == 0) {
                    if (aVar.E() == 0) {
                        j6 = System.currentTimeMillis();
                        aVar.r0(j6);
                        com.orhanobut.logger.j.d("真正的跑步开始时间：" + com.bxkj.base.v2.common.ext.g.d(aVar.D()), new Object[0]);
                    } else {
                        v5 = aVar.E();
                        elapsedRealtime = SystemClock.elapsedRealtime();
                        w5 = aVar.F();
                    }
                } else {
                    v5 = aVar.v();
                    elapsedRealtime = SystemClock.elapsedRealtime();
                    w5 = aVar.w();
                }
                j6 = v5 + (elapsedRealtime - w5);
                aVar.r0(j6);
                com.orhanobut.logger.j.d("真正的跑步开始时间：" + com.bxkj.base.v2.common.ext.g.d(aVar.D()), new Object[0]);
            }
            if (!this.Z) {
                n0.a.f50398a.b(H(), R.raw.run_start);
            }
            SportsVM D = D();
            AMap map = L().mMapView.getMap();
            kotlin.jvm.internal.g0.o(map, "getMap(...)");
            V3GeoFenceObserver v3GeoFenceObserver = new V3GeoFenceObserver(this, D, map);
            this.X = v3GeoFenceObserver;
            getLifecycle().addObserver(v3GeoFenceObserver);
            SportsVM D2 = D();
            MapView mMapView = L().mMapView;
            kotlin.jvm.internal.g0.o(mMapView, "mMapView");
            V3PassPoint2Observer v3PassPoint2Observer = new V3PassPoint2Observer(this, D2, mMapView);
            this.Y = v3PassPoint2Observer;
            getLifecycle().addObserver(v3PassPoint2Observer);
            Intent intent = new Intent(this, (Class<?>) V3LocationService.class);
            intent.putExtra("start", true);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 26) {
                startForegroundService(intent);
            } else {
                startService(intent);
            }
            if (!com.bxkj.base.util.a0.a(H(), V3StepService.class.getName())) {
                Intent intent2 = new Intent(this, (Class<?>) V3StepService.class);
                if (i6 >= 26) {
                    startForegroundService(intent2);
                } else {
                    startService(intent2);
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void r1() {
        R().setState(3);
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Handler handler;
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.f21583p0;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.F0;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
        }
        V3MapObserver v3MapObserver = this.W;
        if (v3MapObserver != null) {
            getLifecycle().removeObserver(v3MapObserver);
        }
        V3GeoFenceObserver v3GeoFenceObserver = this.X;
        if (v3GeoFenceObserver != null) {
            getLifecycle().removeObserver(v3GeoFenceObserver);
        }
        V3PassPoint2Observer v3PassPoint2Observer = this.Y;
        if (v3PassPoint2Observer != null) {
            getLifecycle().removeObserver(v3PassPoint2Observer);
        }
        stopService(new Intent(this, (Class<?>) V3LocationService.class));
        stopService(new Intent(this, (Class<?>) V3StepService.class));
        com.bxkj.student.v2.common.data.i.f20657a.c();
        this.f21582k0 = false;
        this.f21581c0 = false;
        L().mMapView.onDestroy();
        unbindService(this.f21580b0);
        Runnable runnable = this.V;
        if (runnable != null && (handler = this.U) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        L().mMapView.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        L().mMapView.onResume();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
