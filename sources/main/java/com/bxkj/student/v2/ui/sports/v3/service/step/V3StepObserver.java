package com.bxkj.student.v2.ui.sports.v3.service.step;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.alibaba.fastjson.JSON;
import com.baidu.mobads.sdk.internal.cm;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.common.utils.n0;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.common.data.i;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.db.dao.x;
import com.bxkj.student.v2.common.utils.h;
import com.bxkj.student.v2.ui.sports.set.PermissionSetActivity;
import com.bxkj.student.v2.ui.sports.v3.V4SportActivity;
import com.bxkj.student.v2.ui.sports.v3.service.l;
import com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.analytics.pro.bi;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.j;
import kotlin.g0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3StepObserver implements LifecycleObserver, SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private V3StepService f22026a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private SensorManager f22027b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f22028c;

    /* renamed from: d, reason: collision with root package name */
    private int f22029d;

    /* renamed from: e, reason: collision with root package name */
    private int f22030e;

    /* renamed from: f, reason: collision with root package name */
    private int f22031f;

    /* renamed from: g, reason: collision with root package name */
    private int f22032g;

    /* renamed from: h, reason: collision with root package name */
    private int f22033h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private com.bxkj.student.run.app.step.accelerometer.a f22034i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private final ScheduledExecutorService f22035j;

    /* renamed from: k, reason: collision with root package name */
    private int f22036k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    private iOSTwoButtonDialog f22037l;

    /* renamed from: m, reason: collision with root package name */
    private long f22038m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$createRecorder$1", f = "V3StepObserver.kt", i = {0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL}, m = "invokeSuspend", n = {"identify", "userNumber", "sportsDb", "sportsType"}, s = {"L$0", "L$1", "L$2", "I$0"})
    @SourceDebugExtension({"SMAP\nV3StepObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3StepObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver$createRecorder$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,519:1\n1#2:520\n*E\n"})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22039a;

        /* renamed from: b, reason: collision with root package name */
        Object f22040b;

        /* renamed from: c, reason: collision with root package name */
        Object f22041c;

        /* renamed from: d, reason: collision with root package name */
        Object f22042d;

        /* renamed from: e, reason: collision with root package name */
        int f22043e;

        a(kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return V3StepObserver.this.new a(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22043e;
            try {
                if (i6 == 0) {
                    g0.n(obj);
                    i.a aVar = i.f20657a;
                    Object obj2 = aVar.B().get("runType");
                    if (obj2 == null) {
                        obj2 = kotlin.coroutines.jvm.internal.a.f(1);
                    }
                    if (obj2 == null) {
                        obj2 = kotlin.coroutines.jvm.internal.a.f(1);
                    }
                    int parseInt = Integer.parseInt(obj2.toString());
                    Object obj3 = aVar.B().get("identify");
                    if (obj3 == null) {
                        obj3 = "";
                    }
                    String valueOf = String.valueOf(obj3);
                    if (TextUtils.isEmpty(valueOf)) {
                        V3StepObserver.this.k().stopSelf();
                        return n1.f44123a;
                    }
                    String S = com.bxkj.base.v2.data.b.f16998d.a().S();
                    String valueOf2 = String.valueOf(parseInt);
                    String jSONString = JSON.toJSONString(aVar.B());
                    kotlin.jvm.internal.g0.o(jSONString, "toJSONString(...)");
                    String valueOf3 = String.valueOf(aVar.D());
                    String valueOf4 = String.valueOf(aVar.e());
                    String valueOf5 = String.valueOf(aVar.g());
                    String valueOf6 = String.valueOf(aVar.o());
                    String jSONString2 = JSON.toJSONString(aVar.s());
                    kotlin.jvm.internal.g0.o(jSONString2, "toJSONString(...)");
                    try {
                        String jSONString3 = JSON.toJSONString(aVar.m());
                        kotlin.jvm.internal.g0.o(jSONString3, "toJSONString(...)");
                        String jSONString4 = JSON.toJSONString(aVar.x());
                        kotlin.jvm.internal.g0.o(jSONString4, "toJSONString(...)");
                        String valueOf7 = String.valueOf(aVar.k().getValue());
                        String valueOf8 = String.valueOf(aVar.j().getValue());
                        String jSONString5 = JSON.toJSONString(aVar.z());
                        kotlin.jvm.internal.g0.o(jSONString5, "toJSONString(...)");
                        m0.d dVar = new m0.d(valueOf, S, valueOf2, jSONString, valueOf3, "", valueOf4, valueOf5, valueOf6, jSONString2, jSONString3, jSONString4, valueOf7, valueOf8, "0", "", "", "", "", "0", cm.f10901d, jSONString5, String.valueOf(aVar.I()), 0, 8388608, null);
                        x x5 = AppDatabase.f20686a.a().x();
                        if (x5 != null) {
                            m0.d[] dVarArr = {dVar};
                            this.f22040b = j.a(valueOf);
                            this.f22041c = j.a(S);
                            this.f22042d = j.a(dVar);
                            this.f22039a = parseInt;
                            this.f22043e = 1;
                            if (x5.i(dVarArr, this) == l6) {
                                return l6;
                            }
                        }
                    } catch (Exception e6) {
                        e = e6;
                        e.printStackTrace();
                        com.orhanobut.logger.j.e("createRecorder异常" + e.getMessage(), new Object[0]);
                        CrashReport.postCatchedException(e);
                        return n1.f44123a;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    g0.n(obj);
                }
            } catch (Exception e7) {
                e = e7;
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$recorderLocation$1", f = "V3StepObserver.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED}, m = "invokeSuspend", n = {"identify"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nV3StepObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3StepObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver$recorderLocation$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,519:1\n1#2:520\n*E\n"})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22045a;

        /* renamed from: b, reason: collision with root package name */
        int f22046b;

        b(kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return V3StepObserver.this.new b(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22046b;
            try {
                if (i6 == 0) {
                    g0.n(obj);
                    i.a aVar = i.f20657a;
                    Object obj2 = aVar.B().get("identify");
                    if (obj2 == null) {
                        obj2 = "";
                    }
                    String valueOf = String.valueOf(obj2);
                    if (TextUtils.isEmpty(valueOf)) {
                        V3StepObserver.this.k().stopSelf();
                        return n1.f44123a;
                    }
                    if (aVar.D() == 0) {
                        com.orhanobut.logger.j.e("记录跑步数据但是跑步已结束", new Object[0]);
                        V3StepObserver.this.k().stopSelf();
                        return n1.f44123a;
                    }
                    x x5 = AppDatabase.f20686a.a().x();
                    if (x5 != null) {
                        String valueOf2 = String.valueOf(aVar.e());
                        String valueOf3 = String.valueOf(aVar.g());
                        String valueOf4 = String.valueOf(aVar.o());
                        String jSONString = JSON.toJSONString(aVar.s());
                        kotlin.jvm.internal.g0.o(jSONString, "toJSONString(...)");
                        String jSONString2 = JSON.toJSONString(aVar.m());
                        kotlin.jvm.internal.g0.o(jSONString2, "toJSONString(...)");
                        String jSONString3 = JSON.toJSONString(aVar.x());
                        kotlin.jvm.internal.g0.o(jSONString3, "toJSONString(...)");
                        String valueOf5 = String.valueOf(aVar.k().getValue());
                        String valueOf6 = String.valueOf(aVar.j().getValue());
                        String t5 = c0.f16887a.t(aVar.B(), "identify");
                        String valueOf7 = String.valueOf(aVar.i());
                        String jSONString4 = JSON.toJSONString(aVar.z());
                        kotlin.jvm.internal.g0.o(jSONString4, "toJSONString(...)");
                        String valueOf8 = String.valueOf(aVar.I());
                        this.f22045a = j.a(valueOf);
                        this.f22046b = 1;
                        if (x5.j(valueOf2, valueOf3, valueOf4, jSONString, jSONString2, jSONString3, valueOf5, valueOf6, t5, valueOf7, jSONString4, valueOf8, this) == l6) {
                            return l6;
                        }
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    g0.n(obj);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                com.orhanobut.logger.j.e("recorderLocation异常" + e6.getMessage(), new Object[0]);
                CrashReport.postCatchedException(e6);
            }
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$showExceptionTraceDialog$1", f = "V3StepObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f22048a;

        c(kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return V3StepObserver.this.new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f22048a == 0) {
                g0.n(obj);
                Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                if (a6 != null) {
                    String string = App.f17573d.a().getString(R.string.exception_trace_alert_msg);
                    kotlin.jvm.internal.g0.o(string, "getString(...)");
                    ContextExtKt.m(a6, string);
                }
                Object systemService = V3StepObserver.this.k().getSystemService("vibrator");
                kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                ((Vibrator) systemService).vibrate(2000L);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$showExceptionTraceDialogConfirm$1", f = "V3StepObserver.kt", i = {0, 0, 0}, l = {273}, m = "invokeSuspend", n = {"mActivity", "msg", "$i$a$-let-V3StepObserver$showExceptionTraceDialogConfirm$1$2"}, s = {"L$0", "L$1", "I$0"})
    @SourceDebugExtension({"SMAP\nV3StepObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3StepObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/step/V3StepObserver$showExceptionTraceDialogConfirm$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,519:1\n1#2:520\n*E\n"})
    static final class d extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f22050a;

        /* renamed from: b, reason: collision with root package name */
        Object f22051b;

        /* renamed from: c, reason: collision with root package name */
        int f22052c;

        /* renamed from: d, reason: collision with root package name */
        int f22053d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @DebugMetadata(c = "com.bxkj.student.v2.ui.sports.v3.service.step.V3StepObserver$showExceptionTraceDialogConfirm$1$2$3", f = "V3StepObserver.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE}, m = "invokeSuspend", n = {"identify", "sportsSetJson"}, s = {"L$0", "L$1"})
        static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

            /* renamed from: a, reason: collision with root package name */
            Object f22055a;

            /* renamed from: b, reason: collision with root package name */
            Object f22056b;

            /* renamed from: c, reason: collision with root package name */
            int f22057c;

            a(kotlin.coroutines.e<? super a> eVar) {
                super(2, eVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
                return new a(eVar);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
                return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object l6 = kotlin.coroutines.intrinsics.a.l();
                int i6 = this.f22057c;
                if (i6 != 0) {
                    if (i6 == 1) {
                        g0.n(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    g0.n(obj);
                    i.a aVar = i.f20657a;
                    aVar.B().put("exceptionTrace", kotlin.coroutines.jvm.internal.a.a(true));
                    String t5 = c0.f16887a.t(aVar.B(), "identify");
                    String jSONString = JSON.toJSONString(aVar.B());
                    x x5 = AppDatabase.f20686a.a().x();
                    if (x5 != null) {
                        kotlin.jvm.internal.g0.m(jSONString);
                        this.f22055a = j.a(t5);
                        this.f22056b = j.a(jSONString);
                        this.f22057c = 1;
                        if (x5.e(jSONString, t5, this) == l6) {
                            return l6;
                        }
                    }
                }
                return n1.f44123a;
            }
        }

        d(kotlin.coroutines.e<? super d> eVar) {
            super(2, eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 j(Activity activity, iOSTwoButtonDialog iostwobuttondialog) {
            l.f22009a.c(activity);
            new n0(activity).c();
            activity.startActivity(new Intent(activity, (Class<?>) PermissionSetActivity.class));
            return n1.f44123a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 k(Activity activity, iOSTwoButtonDialog iostwobuttondialog) {
            l.f22009a.c(activity);
            new n0(activity).c();
            return n1.f44123a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return V3StepObserver.this.new d(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final Activity activity;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f22053d;
            if (i6 != 0) {
                if (i6 == 1) {
                    g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                g0.n(obj);
                Activity a6 = com.bxkj.student.v2.common.utils.a.f20868a.a();
                if (a6 != null) {
                    if (a6 instanceof V4SportActivity) {
                        activity = a6;
                    } else {
                        activity = null;
                    }
                    if (activity != null) {
                        V3StepObserver v3StepObserver = V3StepObserver.this;
                        iOSTwoButtonDialog i7 = v3StepObserver.i();
                        if (i7 != null && i7.isShowing()) {
                            return n1.f44123a;
                        }
                        if (System.currentTimeMillis() - v3StepObserver.j() < 60000) {
                            return n1.f44123a;
                        }
                        v3StepObserver.q(System.currentTimeMillis());
                        String string = App.f17573d.a().getString(R.string.exception_trace_alert_msg);
                        kotlin.jvm.internal.g0.o(string, "getString(...)");
                        l.f22009a.e(activity, "注意", string);
                        new n0(activity).b();
                        v3StepObserver.p(ContextExtKt.g(activity, "注意", string, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.service.step.d
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                n1 j6;
                                j6 = V3StepObserver.d.j(activity, (iOSTwoButtonDialog) obj2);
                                return j6;
                            }
                        }, new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.service.step.e
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                n1 k6;
                                k6 = V3StepObserver.d.k(activity, (iOSTwoButtonDialog) obj2);
                                return k6;
                            }
                        }, "继续跑步", "设置运动权限"));
                        m0 c6 = g1.c();
                        a aVar = new a(null);
                        this.f22050a = j.a(activity);
                        this.f22051b = j.a(string);
                        this.f22052c = 0;
                        this.f22053d = 1;
                        if (kotlinx.coroutines.i.h(c6, aVar, this) == l6) {
                            return l6;
                        }
                    }
                }
            }
            return n1.f44123a;
        }
    }

    public V3StepObserver(@NotNull V3StepService service) {
        kotlin.jvm.internal.g0.p(service, "service");
        this.f22026a = service;
        this.f22032g = -1;
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        kotlin.jvm.internal.g0.o(newSingleThreadScheduledExecutor, "newSingleThreadScheduledExecutor(...)");
        this.f22035j = newSingleThreadScheduledExecutor;
    }

    private final void c() {
        com.bxkj.student.run.app.step.accelerometer.a aVar = new com.bxkj.student.run.app.step.accelerometer.a();
        this.f22034i = aVar;
        aVar.f(this.f22030e);
        SensorManager sensorManager = this.f22027b;
        Sensor defaultSensor = sensorManager != null ? sensorManager.getDefaultSensor(1) : null;
        SensorManager sensorManager2 = this.f22027b;
        kotlin.jvm.internal.g0.m(sensorManager2);
        com.bxkj.student.run.app.step.accelerometer.a aVar2 = this.f22034i;
        boolean registerListener = sensorManager2.registerListener(aVar2 != null ? aVar2.b() : null, defaultSensor, 1);
        com.bxkj.student.run.app.step.accelerometer.a aVar3 = this.f22034i;
        if (aVar3 != null) {
            aVar3.c(new com.bxkj.student.run.app.step.accelerometer.d() { // from class: com.bxkj.student.v2.ui.sports.v3.service.step.c
                @Override // com.bxkj.student.run.app.step.accelerometer.d
                public final void a(int i6) {
                    V3StepObserver.d(V3StepObserver.this, i6);
                }
            });
        }
        if (registerListener) {
            com.orhanobut.logger.j.d("加速度传感器可以使用", new Object[0]);
        } else {
            com.orhanobut.logger.j.d("加速度传感器无法使用", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(V3StepObserver v3StepObserver, int i6) {
        v3StepObserver.f22030e = i6;
        i.a aVar = i.f20657a;
        aVar.u0(i6);
        aVar.R(v3StepObserver.f22030e);
    }

    private final void e() {
        SensorManager sensorManager = this.f22027b;
        Sensor defaultSensor = sensorManager != null ? sensorManager.getDefaultSensor(19) : null;
        SensorManager sensorManager2 = this.f22027b;
        Sensor defaultSensor2 = sensorManager2 != null ? sensorManager2.getDefaultSensor(18) : null;
        if (defaultSensor != null) {
            this.f22032g = 19;
            SensorManager sensorManager3 = this.f22027b;
            if (sensorManager3 != null) {
                sensorManager3.registerListener(this, defaultSensor, 0);
                return;
            }
            return;
        }
        if (defaultSensor2 == null) {
            com.orhanobut.logger.j.d("Count sensor not available!", new Object[0]);
            c();
            return;
        }
        this.f22032g = 18;
        SensorManager sensorManager4 = this.f22027b;
        if (sensorManager4 != null) {
            sensorManager4.registerListener(this, defaultSensor2, 0);
        }
    }

    private final void f() {
        c0 c0Var = c0.f16887a;
        i.a aVar = i.f20657a;
        if (c0Var.l(aVar.B(), "isCheckExceptionTrace", 1) == 0) {
            return;
        }
        double g6 = c0Var.g(aVar.B(), "exceptionRatio", 0.4d);
        if (aVar.e() == 30) {
            boolean d6 = h.f20892a.d(aVar.s(), g6);
            com.orhanobut.logger.j.d("第一次检测isExceptionPoint=" + d6, new Object[0]);
            if (d6) {
                this.f22036k = 1;
                s();
                return;
            }
            return;
        }
        if (aVar.e() == 60) {
            boolean d7 = h.f20892a.d(aVar.s(), g6);
            com.orhanobut.logger.j.d("第二次检测isExceptionPoint=" + d7, new Object[0]);
            if (d7) {
                if (this.f22036k == 1) {
                    t();
                } else {
                    s();
                }
            }
        }
    }

    private final void g() {
        c0 c0Var = c0.f16887a;
        i.a aVar = i.f20657a;
        if (c0Var.l(aVar.B(), "isCheckExceptionTrace2", 1) == 0) {
            return;
        }
        int l6 = c0Var.l(aVar.B(), "checkTraceDuration", 1);
        PointData f6 = aVar.f();
        if (f6 != null) {
            if (System.currentTimeMillis() - f6.getT() >= l6 * 60000) {
                t();
            }
        }
    }

    private final void h() {
        k.f(LifecycleOwnerKt.getLifecycleScope(this.f22026a), g1.c(), null, new a(null), 2, null);
    }

    private final void l() {
        int G = i.f20657a.G();
        this.f22030e = G;
        this.f22031f = G;
    }

    private final void m() {
        i.a aVar = i.f20657a;
        if (!aVar.K()) {
            long e6 = aVar.e() + 1;
            aVar.U(e6);
            aVar.S();
            String a6 = com.bxkj.student.run.app.utils.i.a(aVar.g(), e6);
            String b6 = com.bxkj.student.run.app.utils.i.b(aVar.g(), e6);
            kotlin.jvm.internal.g0.m(a6);
            aVar.T(a6);
            kotlin.jvm.internal.g0.m(b6);
            aVar.m0(b6);
            o(e6);
            n0.a.f50398a.a(this.f22026a, e6, aVar.g(), aVar.G());
            if (e6 % 60 == 0) {
                l.f22009a.a(this.f22026a);
            }
            l.f22009a.f(this.f22026a);
            f();
            g();
        }
        n();
    }

    private final void n() {
        k.f(LifecycleOwnerKt.getLifecycleScope(this.f22026a), g1.c(), null, new b(null), 2, null);
    }

    private final void o(long j6) {
        long j7 = 60;
        if (j6 % j7 == 0) {
            long j8 = j6 / j7;
            int i6 = this.f22030e - this.f22031f;
            i.a aVar = i.f20657a;
            if (aVar.H().size() < j8) {
                aVar.H().add(Integer.valueOf(i6));
            } else {
                aVar.H().set(aVar.H().size() - 1, Integer.valueOf(aVar.H().get(aVar.H().size() - 1).intValue() + i6));
            }
            this.f22031f = this.f22030e;
        }
    }

    private final void s() {
        k.f(LifecycleOwnerKt.getLifecycleScope(this.f22026a), g1.e(), null, new c(null), 2, null);
    }

    private final void t() {
        k.f(LifecycleOwnerKt.getLifecycleScope(this.f22026a), g1.e(), null, new d(null), 2, null);
    }

    private final void u() {
        if (this.f22027b != null) {
            this.f22027b = null;
        }
        Object systemService = this.f22026a.getSystemService(bi.ac);
        kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.f22027b = (SensorManager) systemService;
        e();
    }

    @Nullable
    public final iOSTwoButtonDialog i() {
        return this.f22037l;
    }

    public final long j() {
        return this.f22038m;
    }

    @NotNull
    public final V3StepService k() {
        return this.f22026a;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        l.f22009a.d(this.f22026a, null);
        l();
        v();
        u();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f22035j.shutdownNow();
        SensorManager sensorManager = this.f22027b;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.f22026a.stopForeground(true);
        l.f22009a.b(this.f22026a);
        com.orhanobut.logger.j.d("停止计步服务", new Object[0]);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(@NotNull SensorEvent event) {
        kotlin.jvm.internal.g0.p(event, "event");
        int i6 = this.f22032g;
        if (i6 != 19) {
            if (i6 == 18) {
                if (event.values[0] == 1.0f && !i.f20657a.K()) {
                    this.f22030e++;
                }
                i.a aVar = i.f20657a;
                aVar.u0(this.f22030e);
                aVar.R(this.f22030e);
                return;
            }
            return;
        }
        int i7 = (int) event.values[0];
        if (this.f22028c) {
            int i8 = i7 - this.f22029d;
            int i9 = i8 - this.f22033h;
            if (!i.f20657a.K()) {
                this.f22030e += i9;
            }
            this.f22033h = i8;
        } else {
            this.f22028c = true;
            this.f22029d = i7;
        }
        i.a aVar2 = i.f20657a;
        aVar2.u0(this.f22030e);
        aVar2.R(this.f22030e);
    }

    public final void p(@Nullable iOSTwoButtonDialog iostwobuttondialog) {
        this.f22037l = iostwobuttondialog;
    }

    public final void q(long j6) {
        this.f22038m = j6;
    }

    public final void r(@NotNull V3StepService v3StepService) {
        kotlin.jvm.internal.g0.p(v3StepService, "<set-?>");
        this.f22026a = v3StepService;
    }

    private final void v() {
        h();
        this.f22035j.scheduleAtFixedRate(new Runnable() { // from class: com.bxkj.student.v2.ui.sports.v3.service.step.b
            @Override // java.lang.Runnable
            public final void run() {
                V3StepObserver.w(V3StepObserver.this);
            }
        }, 0L, 1000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(V3StepObserver v3StepObserver) {
        v3StepObserver.m();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(@Nullable Sensor sensor, int i6) {
    }
}
