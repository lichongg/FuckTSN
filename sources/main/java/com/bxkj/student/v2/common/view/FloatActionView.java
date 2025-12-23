package com.bxkj.student.v2.common.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.jpush.android.service.JNotifyActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.http.result.ApiResult;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.splash.OpenPrivacyAgreementActivity;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.splash.SplashActivity;
import com.bxkj.student.splash.WelcomeActivity;
import com.bxkj.student.v2.common.view.FloatActionView;
import com.bxkj.student.v2.common.view.a;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import kotlin.s;
import kotlin.t;
import kotlinx.coroutines.d3;
import kotlinx.coroutines.flow.x;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFloatActionView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatActionView.kt\ncom/bxkj/student/v2/common/view/FloatActionView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,317:1\n1#2:318\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public class FloatActionView {

    /* renamed from: g, reason: collision with root package name */
    private static int f20991g;

    /* renamed from: h, reason: collision with root package name */
    private static int f20992h;

    /* renamed from: k, reason: collision with root package name */
    private static float f20995k;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private Activity f20996a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f20997b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final s f20998c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private View f20999d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private final r0 f21000e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f20990f = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final float f20993i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private static final float f20994j = 0.2f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private float f21001a;

        /* renamed from: b, reason: collision with root package name */
        private float f21002b;

        /* renamed from: c, reason: collision with root package name */
        private float f21003c;

        /* renamed from: d, reason: collision with root package name */
        private float f21004d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f21005e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FloatActionView f21006f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ViewGroup f21007g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ WindowManager.LayoutParams f21008h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ WindowManager f21009i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f21010j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f21011k;

        b(View view, FloatActionView floatActionView, ViewGroup viewGroup, WindowManager.LayoutParams layoutParams, WindowManager windowManager, int i6, int i7) {
            this.f21005e = view;
            this.f21006f = floatActionView;
            this.f21007g = viewGroup;
            this.f21008h = layoutParams;
            this.f21009i = windowManager;
            this.f21010j = i6;
            this.f21011k = i7;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v5, MotionEvent event) {
            g0.p(v5, "v");
            g0.p(event, "event");
            int actionMasked = event.getActionMasked();
            if (actionMasked == 0) {
                com.bxkj.student.v2.common.view.a.f21069a.c();
                a aVar = FloatActionView.f20990f;
                FloatActionView.f20995k = FloatActionView.f20993i;
                this.f21005e.animate().alpha(FloatActionView.f20995k).setDuration(300L).start();
                this.f21006f.f20997b = false;
                this.f21001a = event.getRawX();
                this.f21002b = event.getRawY();
                this.f21003c = 0.0f;
                this.f21004d = 0.0f;
            } else {
                if (actionMasked == 1) {
                    com.bxkj.student.v2.common.view.a.f21069a.f();
                    if (this.f21003c == 0.0d && this.f21004d == 0.0d) {
                        com.orhanobut.logger.j.d("移动结束，没有位置移动,可以响应其他事件", new Object[0]);
                        this.f21006f.f20997b = false;
                        return false;
                    }
                    com.orhanobut.logger.j.d("移动结束，有位置移动,不要相应长按事件", new Object[0]);
                    this.f21006f.f20997b = true;
                    v5.getX();
                    float a6 = ((int) event.getRawX()) < this.f21010j ? u.a(10.0f, this.f21006f.t()) : (this.f21011k - v5.getWidth()) - u.a(10.0f, this.f21006f.t());
                    a aVar2 = FloatActionView.f20990f;
                    FloatActionView.f20991g = (int) a6;
                    FloatActionView.f20992h = ((int) event.getRawY()) - this.f21007g.getHeight();
                    this.f21008h.x = FloatActionView.f20991g;
                    this.f21008h.y = FloatActionView.f20992h;
                    this.f21009i.updateViewLayout(this.f21007g, this.f21008h);
                    return true;
                }
                if (actionMasked == 2) {
                    a aVar3 = FloatActionView.f20990f;
                    FloatActionView.f20991g = ((int) event.getRawX()) - (this.f21007g.getWidth() / 2);
                    FloatActionView.f20992h = ((int) event.getRawY()) - this.f21007g.getHeight();
                    this.f21008h.x = FloatActionView.f20991g;
                    this.f21008h.y = FloatActionView.f20992h;
                    this.f21003c = event.getRawX() - this.f21001a;
                    this.f21004d = event.getRawY() - this.f21002b;
                    if (Math.abs(this.f21003c) > 0.0d || Math.abs(this.f21004d) > 0.0d) {
                        this.f21009i.updateViewLayout(this.f21007g, this.f21008h);
                        this.f21006f.f20997b = true;
                        com.orhanobut.logger.j.d("移动过程中,不要相应长按事件", new Object[0]);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.view.FloatActionView$createFloatView$2$3$1", f = "FloatActionView.kt", i = {}, l = {org.apache.commons.net.telnet.f.f51102r}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21012a;

        c(kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return FloatActionView.this.new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f21012a;
            try {
                if (i6 == 0) {
                    kotlin.g0.n(obj);
                    com.bxkj.student.v2.repository.a u5 = FloatActionView.this.u();
                    this.f21012a = 1;
                    obj = u5.c(this);
                    if (obj == l6) {
                        return l6;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.g0.n(obj);
                }
                ApiResult apiResult = (ApiResult) obj;
                Map<String, ? extends Object> map = apiResult != null ? (Map) apiResult.apiData() : null;
                c0 c0Var = c0.f16887a;
                String t5 = c0Var.t(map, CommonNetImpl.NAME);
                String t6 = c0Var.t(map, "linkUrl");
                com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
                Activity t7 = FloatActionView.this.t();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(CommonNetImpl.NAME, t5);
                linkedHashMap.put("linkUrl", t6);
                n1 n1Var = n1.f44123a;
                iVar.b(t7, linkedHashMap);
            } catch (Exception e6) {
                com.orhanobut.logger.j.c(e6.getMessage());
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.common.view.FloatActionView$subscribeToCountdownEvents$1", f = "FloatActionView.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21021a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class a<T> implements kotlinx.coroutines.flow.j {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FloatActionView f21023a;

            a(FloatActionView floatActionView) {
                this.f21023a = floatActionView;
            }

            @Override // kotlinx.coroutines.flow.j
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object emit(a.AbstractC0279a abstractC0279a, kotlin.coroutines.e<? super n1> eVar) {
                if (!(abstractC0279a instanceof a.AbstractC0279a.c)) {
                    if (abstractC0279a instanceof a.AbstractC0279a.b) {
                        Activity t5 = this.f21023a.t();
                        final FloatActionView floatActionView = this.f21023a;
                        t5.runOnUiThread(new Runnable() { // from class: com.bxkj.student.v2.common.view.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                FloatActionView.d.a.f(FloatActionView.this);
                            }
                        });
                    } else if (!(abstractC0279a instanceof a.AbstractC0279a.C0280a) && !(abstractC0279a instanceof a.AbstractC0279a.d)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return n1.f44123a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void f(FloatActionView floatActionView) {
                floatActionView.w();
            }
        }

        d(kotlin.coroutines.e<? super d> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return FloatActionView.this.new d(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f21021a;
            if (i6 != 0) {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.g0.n(obj);
            } else {
                kotlin.g0.n(obj);
                x<a.AbstractC0279a> d6 = com.bxkj.student.v2.common.view.a.f21069a.d();
                a aVar = new a(FloatActionView.this);
                this.f21021a = 1;
                if (d6.collect(aVar, this) == l6) {
                    return l6;
                }
            }
            throw new KotlinNothingValueException();
        }
    }

    public FloatActionView(@NotNull Activity mActivity) {
        g0.p(mActivity, "mActivity");
        this.f20996a = mActivity;
        this.f20998c = t.c(new Function0() { // from class: com.bxkj.student.v2.common.view.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.bxkj.student.v2.repository.a v5;
                v5 = FloatActionView.v();
                return v5;
            }
        });
        this.f21000e = s0.a(g1.a().plus(d3.c(null, 1, null)));
    }

    private final void A() {
        k.f(this.f21000e, null, null, new d(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(FloatActionView floatActionView, View view) {
        Activity activity = floatActionView.f20996a;
        if ((activity instanceof ComponentActivity ? activity : null) != null) {
            g0.n(activity, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
            ComponentActivity componentActivity = (ComponentActivity) activity;
            if (componentActivity != null) {
                k.f(LifecycleOwnerKt.getLifecycleScope(componentActivity), g1.c(), null, floatActionView.new c(null), 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(final FloatActionView floatActionView, View view) {
        if (floatActionView.f20997b) {
            return true;
        }
        com.orhanobut.logger.j.d("长按了,不要相应移动事件", new Object[0]);
        ContextExtKt.h(floatActionView.f20996a, "是否关闭悬浮按钮?", "关闭后可在【我的】->【关于】->【悬浮开关】中再次开启和关闭", new Function1() { // from class: com.bxkj.student.v2.common.view.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 s5;
                s5 = FloatActionView.s(FloatActionView.this, (iOSTwoButtonDialog) obj);
                return s5;
            }
        }, null, "显示", "关闭", 8, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 s(FloatActionView floatActionView, iOSTwoButtonDialog it) {
        g0.p(it, "it");
        com.bxkj.base.v2.data.b.f16998d.a().l0(false);
        LocalBroadcastManager.getInstance(floatActionView.f20996a).sendBroadcast(new Intent(App.f17573d.a().getPackageName() + ".FloatActionView").putExtra("isShow", false));
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.a u() {
        return (com.bxkj.student.v2.repository.a) this.f20998c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.bxkj.student.v2.repository.a v() {
        return new com.bxkj.student.v2.repository.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        f20995k = f20994j;
        View view = this.f20999d;
        if (view == null || (animate = view.animate()) == null || (alpha = animate.alpha(f20995k)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        View view = this.f20999d;
        if (view == null || (animate = view.animate()) == null || (alpha = animate.alpha(f20995k)) == null || (duration = alpha.setDuration(0L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.content.BroadcastReceiver, com.bxkj.student.v2.common.view.FloatActionView$createFloatView$showHideBroadCast$1] */
    public final void p() {
        Activity activity = this.f20996a;
        if ((activity instanceof SplashActivity) || (activity instanceof SelectSchoolV2Activity) || (activity instanceof WelcomeActivity) || (activity instanceof OpenPrivacyAgreementActivity) || (activity instanceof JNotifyActivity) || (((activity instanceof H5AppActivity) && activity.getIntent().hasExtra("title") && (g0.g(this.f20996a.getIntent().getStringExtra("title"), "帮助与客服") || g0.g(this.f20996a.getIntent().getStringExtra("title"), "帮助中心"))) || LoginUser.getLoginUser().getSysType() != 2)) {
            return;
        }
        final WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        final WindowManager windowManager = this.f20996a.getWindowManager();
        layoutParams.type = 2;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f20996a.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i6 = displayMetrics.widthPixels;
        int i7 = displayMetrics.heightPixels;
        int i8 = i6 / 2;
        if (f20991g == 0) {
            f20991g = (int) (i6 - u.a(60.0f, this.f20996a));
        }
        if (f20992h == 0) {
            f20992h = i7 / 2;
        }
        layoutParams.x = f20991g;
        layoutParams.y = f20992h;
        layoutParams.width = u.a(50.0f, this.f20996a);
        layoutParams.height = u.a(50.0f, this.f20996a);
        LayoutInflater layoutInflater = this.f20996a.getLayoutInflater();
        g0.o(layoutInflater, "getLayoutInflater(...)");
        View inflate = layoutInflater.inflate(R.layout.floating_help, (ViewGroup) null);
        g0.n(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) inflate;
        final View findViewById = viewGroup.findViewById(R.id.ll_menu);
        this.f20999d = findViewById;
        windowManager.addView(viewGroup, layoutParams);
        if (f20995k == 0.0f) {
            f20995k = f20993i;
            com.bxkj.student.v2.common.view.a.f21069a.f();
        }
        x();
        A();
        findViewById.setOnTouchListener(new b(findViewById, this, viewGroup, layoutParams, windowManager, i8, i6));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.common.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatActionView.q(FloatActionView.this, view);
            }
        });
        findViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bxkj.student.v2.common.view.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean r5;
                r5 = FloatActionView.r(FloatActionView.this, view);
                return r5;
            }
        });
        final ?? r7 = new BroadcastReceiver() { // from class: com.bxkj.student.v2.common.view.FloatActionView$createFloatView$showHideBroadCast$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    if (!intent.hasExtra("isShow")) {
                        intent = null;
                    }
                    if (intent != null) {
                        FloatActionView.this.z(intent.getBooleanExtra("isShow", true));
                    }
                }
            }
        };
        LocalBroadcastManager.getInstance(this.f20996a).registerReceiver(r7, new IntentFilter(App.f17573d.a().getPackageName() + ".FloatActionView"));
        Activity activity2 = this.f20996a;
        if (activity2 instanceof ComponentActivity) {
            g0.n(activity2, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
            ((ComponentActivity) activity2).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.v2.common.view.FloatActionView$createFloatView$4
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public final void onDestroy() {
                    LocalBroadcastManager.getInstance(this.t()).unregisterReceiver(r7);
                    windowManager.removeViewImmediate(findViewById);
                }

                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                public final void onResume() {
                    layoutParams.x = FloatActionView.f20991g;
                    layoutParams.y = FloatActionView.f20992h;
                    windowManager.updateViewLayout(viewGroup, layoutParams);
                    this.x();
                }
            });
        }
        z(com.bxkj.base.v2.data.b.f16998d.a().n());
    }

    @NotNull
    public final Activity t() {
        return this.f20996a;
    }

    public final void y(@NotNull Activity activity) {
        g0.p(activity, "<set-?>");
        this.f20996a = activity;
    }

    public final void z(boolean z5) {
        View view = this.f20999d;
        if (view != null) {
            view.setVisibility(z5 ? 0 : 8);
        }
    }
}
