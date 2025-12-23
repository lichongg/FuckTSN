package com.bxkj.student;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.jiguang.api.utils.JCollectionAuth;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushCollectControl;
import com.acse.ottn.activity.AcseHelpManager;
import com.amap.api.location.AMapLocationClient;
import com.baidu.idl.face.platform.FaceConfig;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.bxkj.base.BaseApp;
import com.bxkj.base.chat.db.ChatMessageDb;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.student.App;
import com.bxkj.student.common.db.HomeMenuDB;
import com.bxkj.student.common.versionupdate.a;
import com.bxkj.student.home.teaching.learning.detail.db.ReadExceptionDataDB;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.splash.SplashActivity;
import com.bxkj.student.v2.common.utils.w;
import com.bxkj.student.v2.common.view.FloatActionView;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.orhanobut.logger.l;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.stub.StubApp;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.tauth.Tencent;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w1;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.adscope.amps.AMPSSDK;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.init.inter.IAMPSInitCallback;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class App extends BaseApp {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17573d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static App f17574e;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Long f17575c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final App a() {
            App app = App.f17574e;
            if (app == null) {
                g0.S("instance");
                return null;
            }
            return app;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements IAMPSInitCallback {
        @Override // xyz.adscope.amps.init.inter.IAMPSInitCallback
        public void successCallback() {
            com.orhanobut.logger.j.g("BeiZisDemo->initAMPSSDK successCallback", new Object[0]);
        }

        @Override // xyz.adscope.amps.init.inter.IAMPSInitCallback
        public void failCallback(AMPSError aMPSError) {
            com.orhanobut.logger.j.e("BeiZisDemo->initAMPSSDK failCallback ampsError : " + aMPSError, new Object[0]);
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements m2.b {
        @Override // m2.b
        public m2.e a(Context context, m2.h layout) {
            g0.p(context, "context");
            g0.p(layout, "layout");
            layout.a0(false);
            return new MaterialHeader(context);
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d implements m2.a {
        @Override // m2.a
        public m2.d a(Context context, m2.h layout) {
            g0.p(context, "context");
            g0.p(layout, "layout");
            layout.V(true);
            return new ClassicsFooter(context);
        }

        d() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.App$initDataBase$1", f = "App.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f17576a;

        e(kotlin.coroutines.e<? super e> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return new e(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f17576a == 0) {
                kotlin.g0.n(obj);
                cn.bluemobi.dylan.sqlitelibrary.c h6 = cn.bluemobi.dylan.sqlitelibrary.c.h();
                App app = App.f17574e;
                if (app == null) {
                    g0.S("instance");
                    app = null;
                }
                h6.n(app, "xiaowei");
                cn.bluemobi.dylan.sqlitelibrary.c.h().b(ChatMessageDb.class);
                cn.bluemobi.dylan.sqlitelibrary.c.h().b(HomeMenuDB.class);
                cn.bluemobi.dylan.sqlitelibrary.c.h().b(ReadExceptionDataDB.class);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class f implements IInitCallback {
        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            com.orhanobut.logger.j.d("FaceSDKManager初始化成功", new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i6, String str) {
            com.orhanobut.logger.j.e("FaceSDKManager初始化失败i=" + i6 + "s=" + str, new Object[0]);
        }

        f() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class h implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        private View.OnLayoutChangeListener f17577a;

        h() {
        }

        public final void b(Activity activity) {
            g0.p(activity, "activity");
            View findViewById = activity.getWindow().findViewById(App.this.getResources().getIdentifier("statusBarBackground", "id", FaceEnvironment.OS));
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.statusbar_bg_color);
            }
        }

        public final void c(final Activity activity) {
            g0.p(activity, "activity");
            this.f17577a = new View.OnLayoutChangeListener() { // from class: com.bxkj.student.b
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                    App.h.d(App.h.this, activity, view, i6, i7, i8, i9, i10, i11, i12, i13);
                }
            };
            activity.getWindow().getDecorView().addOnLayoutChangeListener(this.f17577a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            g0.p(activity, "activity");
            activity.setRequestedOrientation(1);
            try {
                new FloatActionView(activity).p();
            } catch (Exception e6) {
                com.orhanobut.logger.j.e("FloatActionView：=" + e6.getMessage(), new Object[0]);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            g0.p(activity, "activity");
            activity.getWindow().getDecorView().removeOnLayoutChangeListener(this.f17577a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            g0.p(activity, "activity");
            if (LoginUser.getLoginUser().isAgreement()) {
                MobclickAgent.onPause(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            g0.p(activity, "activity");
            com.bxkj.student.v2.common.utils.a.f20868a.b(activity);
            if (LoginUser.getLoginUser().isAgreement()) {
                MobclickAgent.onResume(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            g0.p(activity, "activity");
            g0.p(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            g0.p(activity, "activity");
            if ((activity instanceof SplashActivity) || (activity instanceof SelectSchoolV2Activity) || (activity instanceof H5AppActivity)) {
                return;
            }
            View findViewById = activity.findViewById(2131298702);
            if (activity instanceof MainActivity) {
                findViewById = ((MainActivity) activity).findViewById(R.id.toolbar2);
            }
            if ((activity instanceof BaseActivity) || findViewById == null || findViewById.getVisibility() != 0) {
                return;
            }
            findViewById.setBackgroundResource(R.drawable.statusbar_bg_color);
            c(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            g0.p(activity, "activity");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(h hVar, Activity activity, View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
            hVar.b(activity);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class i implements a.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.common.versionupdate.a f17579a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f17580b;

        i(com.bxkj.student.common.versionupdate.a aVar, Context context) {
            this.f17579a = aVar;
            this.f17580b = context;
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void a(boolean z5, String str, String str2, String str3) {
            Dialog dialog;
            if (!z5) {
                new iOSOneButtonDialog(this.f17580b).setMessage("当前已是最新版本").show();
                return;
            }
            MainActivity mainActivity = (MainActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MainActivity.class);
            if (mainActivity == null || (dialog = mainActivity.f17627c0) == null || !dialog.isShowing()) {
                this.f17579a.d(str, str2, str3);
            }
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void b() {
        }
    }

    private final String p(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
        g0.n(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    @Nullable
    public final String o(@Nullable Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
                g0.o(applicationInfo, "getApplicationInfo(...)");
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    Object obj = bundle.get("UMENG_CHANNEL");
                    StringBuilder sb = new StringBuilder();
                    sb.append(obj);
                    str = sb.toString();
                }
            }
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
        }
        return TextUtils.isEmpty(str) ? "Unknown" : str;
    }

    @Override // com.bxkj.base.BaseApp, android.app.Application
    public void onCreate() {
        try {
            super.onCreate();
            f17574e = this;
            u();
            JCollectionAuth.setAuth(this, false);
            A(this);
            v();
            com.orhanobut.logger.j.d("当前进程名" + String.valueOf(p(this)), new Object[0]);
            if (f()) {
                q();
            }
        } catch (Exception e6) {
            com.orhanobut.logger.j.d("初始化异常" + e6.getMessage(), new Object[0]);
            CrashReport.postCatchedException(e6);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class g extends com.orhanobut.logger.a {
        @Override // com.orhanobut.logger.a, com.orhanobut.logger.g
        public boolean b(int i6, String str) {
            return false;
        }

        g(com.orhanobut.logger.f fVar) {
            super(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(String message) {
        g0.p(message, "message");
    }

    private final void s() {
        k.f(w1.f49676a, g1.c(), null, new e(null), 2, null);
    }

    private final void x() {
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.App$registerAppLifecycle$1
            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public final void onMoveToBackground() {
                App.this.f17575c = Long.valueOf(System.currentTimeMillis());
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public final void onMoveToForeground() {
                Long l6;
                Long l7;
                l6 = App.this.f17575c;
                if (l6 != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    l7 = App.this.f17575c;
                    g0.m(l7);
                    if (currentTimeMillis - l7.longValue() <= 1800000 || com.bxkj.base.v2.data.b.f16998d.a().a0() != 1) {
                        return;
                    }
                    App.this.startActivity(new Intent(App.f17573d.a(), (Class<?>) SplashActivity.class).setFlags(268435456).putExtra("onlyOpenAd", true));
                }
            }
        });
    }

    private final void y() {
        registerActivityLifecycleCallbacks(new h());
    }

    public final void A(@NotNull Application application) {
        g0.p(application, "application");
        String valueOf = String.valueOf(p(application));
        if (g0.g(application.getPackageName(), valueOf) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        WebView.setDataDirectorySuffix(valueOf);
    }

    @Override // com.bxkj.base.BaseApp
    public void i(@NotNull Context mContext) {
        g0.p(mContext, "mContext");
        com.bxkj.student.common.versionupdate.a aVar = new com.bxkj.student.common.versionupdate.a(mContext);
        aVar.b(new i(aVar, mContext));
    }

    private final void q() {
        LoginUser.getLoginUser().setUserType(1);
        Http.getHttp().setDebugMode(false);
        Http.getHttp().setLoadingDialog(R.layout.dialog_loading_view);
        Http.getHttp().addInterceptor(new h2.b(BaseApp.c()));
        Http.getHttp().addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.bxkj.student.a
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                App.r(str);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY));
        s();
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new c());
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new d());
        if (LoginUser.getLoginUser().isAgreement()) {
            n();
        }
        y();
        w();
        x();
    }

    private final void t() {
        z();
        FaceSDKManager faceSDKManager = FaceSDKManager.getInstance();
        App app = f17574e;
        if (app == null) {
            g0.S("instance");
            app = null;
        }
        faceSDKManager.initialize(app, "XiaoWeiFaceDetection-face-android", "baidu-idl-license.face-android", new f());
    }

    private final void u() {
        l a6 = l.k().f("TSNAPP").a();
        g0.o(a6, "build(...)");
        com.orhanobut.logger.j.b();
        com.orhanobut.logger.j.a(new g(a6));
    }

    private final void z() {
        FaceConfig faceConfig = FaceSDKManager.getInstance().getFaceConfig();
        faceConfig.setMinFaceSize(200);
        faceConfig.setNotFaceValue(0.6f);
        faceConfig.setBlurnessValue(0.4f);
        faceConfig.setBrightnessValue(0.0f);
        faceConfig.setBrightnessMaxValue(255.0f);
        faceConfig.setOcclusionValue(0.5f);
        faceConfig.setHeadPitchValue(15);
        faceConfig.setHeadYawValue(15);
        faceConfig.setHeadRollValue(15);
        faceConfig.setEyeClosedValue(0.4f);
        faceConfig.setCacheImageNum(1);
        faceConfig.setOpenMask(false);
        faceConfig.setMaskValue(0.7f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(LivenessTypeEnum.Eye);
        arrayList.add(LivenessTypeEnum.Mouth);
        arrayList.add(LivenessTypeEnum.HeadDown);
        faceConfig.setLivenessTypeList(arrayList);
        faceConfig.setLivenessRandom(true);
        faceConfig.setLivenessRandomCount(3);
        faceConfig.setSound(true);
        faceConfig.setScale(1.0f);
        faceConfig.setCropHeight(640);
        faceConfig.setEnlargeRatio(1.5f);
        faceConfig.setSecType(0);
        FaceSDKManager.getInstance().setFaceConfig(faceConfig);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(@Nullable Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public final void n() {
        v();
        t();
        App app = f17574e;
        App app2 = null;
        if (app == null) {
            g0.S("instance");
            app = null;
        }
        AMapLocationClient.updatePrivacyShow(app, true, true);
        App app3 = f17574e;
        if (app3 == null) {
            g0.S("instance");
            app3 = null;
        }
        AMapLocationClient.updatePrivacyAgree(app3, true);
        CrashReport.initCrashReport(StubApp.getOrigApplicationContext(getApplicationContext()), "ae6e27150a", false);
        UMConfigure.preInit(this, "59a61305a3251138c9000c17", o(this));
        UMConfigure.submitPolicyGrantResult(this, true);
        UMConfigure.setLogEnabled(false);
        UMConfigure.init(this, "59a61305a3251138c9000c17", o(this), 1, "");
        PlatformConfig.setWeixin(w.f20953b, "505a323b2213d09ca75c989ac6946943");
        PlatformConfig.setWXFileProvider("com.bxkj.student.provider");
        PlatformConfig.setQQZone("1106200175", "pTNnuKKrFFrM9SFa");
        PlatformConfig.setQQFileProvider("com.bxkj.student.provider");
        Tencent.setIsPermissionGranted(true);
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        AMPSSDK.init(this, new AMPSInitConfig.Builder().setAppId(com.bxkj.student.v2.common.data.a.f20652b).setAppName(getResources().getString(2131951695)).build(), new b());
        com.bxkj.student.v2.common.utils.safe.b.f20937a.b();
        if (com.bxkj.base.v2.data.b.f16998d.a().d0() == 1) {
            JPushInterface.setDebugMode(false);
            App app4 = f17574e;
            if (app4 == null) {
                g0.S("instance");
                app4 = null;
            }
            JPushInterface.setSmartPushEnable(app4, false);
            App app5 = f17574e;
            if (app5 == null) {
                g0.S("instance");
                app5 = null;
            }
            JPushInterface.setGeofenceEnable(app5, false);
            App app6 = f17574e;
            if (app6 == null) {
                g0.S("instance");
                app6 = null;
            }
            JCollectionAuth.enableAutoWakeup(app6, false);
            App app7 = f17574e;
            if (app7 == null) {
                g0.S("instance");
                app7 = null;
            }
            JPushInterface.setLinkMergeEnable(app7, false);
            App app8 = f17574e;
            if (app8 == null) {
                g0.S("instance");
                app8 = null;
            }
            JCollectionAuth.enableAppTerminate(app8, false);
            JPushCollectControl.Builder builder = new JPushCollectControl.Builder();
            builder.ssid(false);
            builder.bssid(false);
            builder.wifi(false);
            JPushCollectControl build = builder.build();
            App app9 = f17574e;
            if (app9 == null) {
                g0.S("instance");
                app9 = null;
            }
            JPushInterface.setCollectControl(app9, build);
            App app10 = f17574e;
            if (app10 == null) {
                g0.S("instance");
            } else {
                app2 = app10;
            }
            JCollectionAuth.setAuth(app2, true);
            JPushInterface.init(this);
            JPushInterface.resumePush(this);
        } else {
            JPushInterface.stopPush(this);
        }
        j2.a.a(this, "3604766");
    }

    public final void v() {
        if (LoginUser.getLoginUser().isAgreement()) {
            com.orhanobut.logger.j.d("初始化省钱助手", new Object[0]);
            new AcseHelpManager.InitSdk().setContext(this).build();
        }
    }

    private final void w() {
    }
}
