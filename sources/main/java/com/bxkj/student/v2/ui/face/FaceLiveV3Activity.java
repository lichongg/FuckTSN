package com.bxkj.student.v2.ui.face;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity;
import com.bxkj.base.v2.base.ProgressDialogFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.v;
import com.bxkj.student.App;
import com.bxkj.student.v2.common.data.PointData;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.face.FaceDetectVM;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.stub.StubApp;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFaceLiveV3Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceLiveV3Activity.kt\ncom/bxkj/student/v2/ui/face/FaceLiveV3Activity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n1#2:203\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceLiveV3Activity extends BaseFaceLivenessActivity {

    @NotNull
    public static final a W;
    public static final int X = 170;
    private Context M;

    @Nullable
    private PointData Q;
    private FaceDetectVM S;
    public LifecycleOwner T;
    public FragmentManager U;

    @Nullable
    private ProgressDialogFragment V;

    @NotNull
    private String N = "";

    @NotNull
    private String O = "";
    private int P = 1;
    private boolean R = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements IInitCallback {
        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initSuccess() {
            com.orhanobut.logger.j.d("FaceSDKManager初始化成功", new Object[0]);
        }

        @Override // com.baidu.idl.face.platform.listener.IInitCallback
        public void initFailure(int i6, String s5) {
            g0.p(s5, "s");
            com.orhanobut.logger.j.e("FaceSDKManager初始化失败i=" + i6 + "s=" + s5, new Object[0]);
        }

        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c implements Observer, kotlin.jvm.internal.b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21342a;

        c(Function1 function) {
            g0.p(function, "function");
            this.f21342a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.b0)) {
                return g0.g(getFunctionDelegate(), ((kotlin.jvm.internal.b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final kotlin.n<?> getFunctionDelegate() {
            return this.f21342a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21342a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
            if (i6 != 4) {
                return false;
            }
            ProgressDialogFragment S = FaceLiveV3Activity.this.S();
            if (S != null) {
                S.dismiss();
            }
            FaceDetectVM faceDetectVM = FaceLiveV3Activity.this.S;
            if (faceDetectVM == null) {
                g0.S("mViewModel");
                faceDetectVM = null;
            }
            e2 b6 = faceDetectVM.b();
            if (b6 == null) {
                return true;
            }
            b6.b(new CancellationException());
            return true;
        }

        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 R(FaceLiveV3Activity faceLiveV3Activity) {
        ContextExtKt.s(faceLiveV3Activity, "人脸识别成功", 0, 2, null);
        faceLiveV3Activity.setResult(-1);
        faceLiveV3Activity.finish();
        return n1.f44123a;
    }

    @Override // com.baidu.idl.face.platform.ui.FaceLivenessActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    static {
        StubApp.interface11(17296);
        W = new a(null);
    }

    private final void E() {
        FaceDetectVM faceDetectVM = this.S;
        if (faceDetectVM == null) {
            g0.S("mViewModel");
            faceDetectVM = null;
        }
        faceDetectVM.c().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.w
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 M;
                M = FaceLiveV3Activity.M(FaceLiveV3Activity.this, (Integer) obj);
                return M;
            }
        }));
        faceDetectVM.e().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 N;
                N = FaceLiveV3Activity.N(FaceLiveV3Activity.this, (String) obj);
                return N;
            }
        }));
        faceDetectVM.f().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 P;
                P = FaceLiveV3Activity.P(FaceLiveV3Activity.this, (String) obj);
                return P;
            }
        }));
        faceDetectVM.h().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 m6;
                m6 = FaceLiveV3Activity.m(FaceLiveV3Activity.this, (String) obj);
                return m6;
            }
        }));
        faceDetectVM.g().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 n6;
                n6 = FaceLiveV3Activity.n(FaceLiveV3Activity.this, (String) obj);
                return n6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(final FaceLiveV3Activity faceLiveV3Activity, final String str) {
        if (str != null) {
            Context context = faceLiveV3Activity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.o(context, str, new Function1() { // from class: com.bxkj.student.v2.ui.face.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 O;
                    O = FaceLiveV3Activity.O(str, faceLiveV3Activity, (iOSOneButtonDialog) obj);
                    return O;
                }
            }).setCancelable(false);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 O(String str, FaceLiveV3Activity faceLiveV3Activity, iOSOneButtonDialog it) {
        g0.p(it, "it");
        Context context = null;
        if (kotlin.text.u.l3(str, "登录失效", false, 2, null)) {
            Context context2 = faceLiveV3Activity.M;
            if (context2 == null) {
                g0.S("mContext");
                context2 = null;
            }
            Context context3 = faceLiveV3Activity.M;
            if (context3 == null) {
                g0.S("mContext");
            } else {
                context = context3;
            }
            context2.startActivity(new Intent(context, (Class<?>) LoginActivity.class).setFlags(268468224));
        } else {
            faceLiveV3Activity.U();
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 P(FaceLiveV3Activity faceLiveV3Activity, String str) {
        if (str != null) {
            Context context = faceLiveV3Activity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.m(context, str);
        }
        return n1.f44123a;
    }

    private final void Q(String str) {
        File file = new File(App.f17573d.a().getFilesDir().getPath(), OptionalModuleUtils.FACE);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "avatar_face_" + this.O + "_" + System.currentTimeMillis() + com.bxkj.base.v2.common.utils.g0.f16898c);
        v.a aVar = com.bxkj.base.v2.common.utils.v.f16952a;
        String path = file2.getPath();
        g0.o(path, "getPath(...)");
        File a6 = aVar.a(str, path);
        com.orhanobut.logger.j.d("avatar.path=" + a6.getPath(), new Object[0]);
        FaceDetectVM faceDetectVM = this.S;
        if (faceDetectVM == null) {
            g0.S("mViewModel");
            faceDetectVM = null;
        }
        faceDetectVM.v(this.N, this.O, String.valueOf(this.P), a6, this.Q, new Function0() { // from class: com.bxkj.student.v2.ui.face.b0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 R;
                R = FaceLiveV3Activity.R(FaceLiveV3Activity.this);
                return R;
            }
        });
    }

    private final void U() {
        setResult(170, getIntent());
        finish();
    }

    private final void X(String str) {
        if (this.V == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(str);
            this.V = progressDialogFragment;
            progressDialogFragment.c(new d());
        }
        ProgressDialogFragment progressDialogFragment2 = this.V;
        if (progressDialogFragment2 != null) {
            progressDialogFragment2.e(J(), str, true);
        }
    }

    static /* synthetic */ void Y(FaceLiveV3Activity faceLiveV3Activity, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "loading...";
        }
        faceLiveV3Activity.X(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 m(FaceLiveV3Activity faceLiveV3Activity, String str) {
        if (str != null) {
            Context context = faceLiveV3Activity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.s(context, str, 0, 2, null);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 n(FaceLiveV3Activity faceLiveV3Activity, String str) {
        if (str != null) {
            Context context = faceLiveV3Activity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.q(context, str);
        }
        return n1.f44123a;
    }

    private final void u() {
        ProgressDialogFragment progressDialogFragment = this.V;
        if (progressDialogFragment == null || progressDialogFragment == null) {
            return;
        }
        progressDialogFragment.dismiss();
    }

    public final void F(@NotNull FragmentManager fragmentManager) {
        g0.p(fragmentManager, "<set-?>");
        this.U = fragmentManager;
    }

    @NotNull
    public final LifecycleOwner G() {
        LifecycleOwner lifecycleOwner = this.T;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        g0.S("lifecycleOwner");
        return null;
    }

    @NotNull
    public final FragmentManager J() {
        FragmentManager fragmentManager = this.U;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        g0.S("dialogFagmentManager");
        return null;
    }

    @Nullable
    public final ProgressDialogFragment S() {
        return this.V;
    }

    public final void V(@Nullable ProgressDialogFragment progressDialogFragment) {
        this.V = progressDialogFragment;
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        g0.p(lifecycleOwner, "<set-?>");
        this.T = lifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 M(FaceLiveV3Activity faceLiveV3Activity, Integer num) {
        if (num.intValue() > 0) {
            FaceDetectVM faceDetectVM = faceLiveV3Activity.S;
            if (faceDetectVM == null) {
                g0.S("mViewModel");
                faceDetectVM = null;
            }
            faceLiveV3Activity.X(faceDetectVM.d().getValue());
        } else {
            faceLiveV3Activity.u();
        }
        return n1.f44123a;
    }

    private final void T() {
        if (!FaceSDKManager.getInstance().getInitFlag()) {
            FaceSDKManager.getInstance().initialize(this, com.bxkj.student.run.app.face.a.f19804a, com.bxkj.student.run.app.face.a.f19805b, new b());
        }
    }

    private final void W(Activity activity, float f6) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f6;
        window.setAttributes(attributes);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        u();
        W(this, -1.0f);
        cn.bluemobi.dylan.base.utils.a.n().s(this);
        super.onDestroy();
    }

    @Override // com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity
    protected void onFace(@Nullable String str) {
        super.onFace(str);
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                Q(str);
            }
        }
    }
}
