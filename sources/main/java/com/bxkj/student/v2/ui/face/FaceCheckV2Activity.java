package com.bxkj.student.v2.ui.face;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.baidu.idl.face.platform.FaceSDKManager;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.baidu.idl.face.platform.ui.BaseFaceDetectActivity;
import com.bxkj.base.v2.base.ProgressDialogFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.v;
import com.bxkj.base.v2.http.exception.ApiException;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.face.FaceCheckVM;
import com.stub.StubApp;
import java.io.File;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFaceCheckV2Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceCheckV2Activity.kt\ncom/bxkj/student/v2/ui/face/FaceCheckV2Activity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1#2:209\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceCheckV2Activity extends BaseFaceDetectActivity {

    @NotNull
    public static final a R;
    public static final int S = 170;
    private Context M;
    private FaceCheckVM N;
    public LifecycleOwner O;
    public FragmentManager P;

    @Nullable
    private ProgressDialogFragment Q;

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
        private final /* synthetic */ Function1 f21336a;

        c(Function1 function) {
            g0.p(function, "function");
            this.f21336a = function;
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
            return this.f21336a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21336a.invoke(obj);
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
            ProgressDialogFragment U = FaceCheckV2Activity.this.U();
            if (U != null) {
                U.dismiss();
            }
            FaceCheckVM faceCheckVM = FaceCheckV2Activity.this.N;
            if (faceCheckVM == null) {
                g0.S("mViewModel");
                faceCheckVM = null;
            }
            e2 b6 = faceCheckVM.b();
            if (b6 == null) {
                return true;
            }
            b6.b(new CancellationException());
            return true;
        }

        d() {
        }
    }

    @Override // com.baidu.idl.face.platform.ui.FaceDetectActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    static {
        StubApp.interface11(17280);
        R = new a(null);
    }

    private final void E() {
        FaceCheckVM faceCheckVM = this.N;
        if (faceCheckVM == null) {
            g0.S("mViewModel");
            faceCheckVM = null;
        }
        faceCheckVM.c().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 O;
                O = FaceCheckV2Activity.O(FaceCheckV2Activity.this, (Integer) obj);
                return O;
            }
        }));
        faceCheckVM.e().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 P;
                P = FaceCheckV2Activity.P(FaceCheckV2Activity.this, (String) obj);
                return P;
            }
        }));
        faceCheckVM.f().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 n6;
                n6 = FaceCheckV2Activity.n(FaceCheckV2Activity.this, (String) obj);
                return n6;
            }
        }));
        faceCheckVM.h().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 M;
                M = FaceCheckV2Activity.M(FaceCheckV2Activity.this, (String) obj);
                return M;
            }
        }));
        faceCheckVM.g().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 N;
                N = FaceCheckV2Activity.N(FaceCheckV2Activity.this, (String) obj);
                return N;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 M(FaceCheckV2Activity faceCheckV2Activity, String str) {
        if (str != null) {
            Context context = faceCheckV2Activity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.s(context, str, 0, 2, null);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(FaceCheckV2Activity faceCheckV2Activity, String str) {
        if (str != null) {
            Context context = faceCheckV2Activity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.q(context, str);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 P(final FaceCheckV2Activity faceCheckV2Activity, final String str) {
        if (str != null) {
            Context context = faceCheckV2Activity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.o(context, str, new Function1() { // from class: com.bxkj.student.v2.ui.face.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 Q;
                    Q = FaceCheckV2Activity.Q(str, faceCheckV2Activity, (iOSOneButtonDialog) obj);
                    return Q;
                }
            }).setCancelable(false);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Q(String str, FaceCheckV2Activity faceCheckV2Activity, iOSOneButtonDialog it) {
        g0.p(it, "it");
        Context context = null;
        if (kotlin.text.u.l3(str, "登录失效", false, 2, null)) {
            Context context2 = faceCheckV2Activity.M;
            if (context2 == null) {
                g0.S("mContext");
                context2 = null;
            }
            Context context3 = faceCheckV2Activity.M;
            if (context3 == null) {
                g0.S("mContext");
            } else {
                context = context3;
            }
            context2.startActivity(new Intent(context, (Class<?>) LoginActivity.class).setFlags(268468224));
        } else {
            faceCheckV2Activity.W();
        }
        return n1.f44123a;
    }

    private final void R(String str) {
        File file;
        FaceCheckVM faceCheckVM = null;
        if (g0.g("mounted", Environment.getExternalStorageState())) {
            Context context = this.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            file = context.getExternalCacheDir();
        } else {
            file = null;
        }
        if (file == null || !file.exists()) {
            Context context2 = this.M;
            if (context2 == null) {
                g0.S("mContext");
                context2 = null;
            }
            file = context2.getCacheDir();
        }
        File file2 = new File(file, "avatar");
        boolean exists = file2.exists();
        if (!exists) {
            exists = file2.mkdirs();
        }
        if (exists) {
            File file3 = new File(file2, "avatar_face.png");
            v.a aVar = com.bxkj.base.v2.common.utils.v.f16952a;
            String path = file3.getPath();
            g0.o(path, "getPath(...)");
            File a6 = aVar.a(str, path);
            FaceCheckVM faceCheckVM2 = this.N;
            if (faceCheckVM2 == null) {
                g0.S("mViewModel");
            } else {
                faceCheckVM = faceCheckVM2;
            }
            faceCheckVM.t(a6, new Function1() { // from class: com.bxkj.student.v2.ui.face.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 S2;
                    S2 = FaceCheckV2Activity.S(FaceCheckV2Activity.this, (ApiException) obj);
                    return S2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 S(final FaceCheckV2Activity faceCheckV2Activity, ApiException it) {
        g0.p(it, "it");
        final Integer code = it.getCode();
        Integer code2 = it.getCode();
        if (code2 != null && code2.intValue() == 0) {
            ContextExtKt.s(faceCheckV2Activity, String.valueOf(it.getMessage()), 0, 2, null);
            Intent intent = new Intent();
            intent.putExtra("code", code);
            faceCheckV2Activity.setResult(-1, intent);
            faceCheckV2Activity.finish();
        } else {
            ContextExtKt.o(faceCheckV2Activity, String.valueOf(it.getMessage()), new Function1() { // from class: com.bxkj.student.v2.ui.face.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 T;
                    T = FaceCheckV2Activity.T(code, faceCheckV2Activity, (iOSOneButtonDialog) obj);
                    return T;
                }
            });
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 T(Integer num, FaceCheckV2Activity faceCheckV2Activity, iOSOneButtonDialog it) {
        g0.p(it, "it");
        Intent intent = new Intent();
        intent.putExtra("code", num);
        faceCheckV2Activity.setResult(-1, intent);
        faceCheckV2Activity.finish();
        return n1.f44123a;
    }

    private final void W() {
        setResult(170, getIntent());
        finish();
    }

    private final void Z(String str) {
        if (this.Q == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment(str);
            this.Q = progressDialogFragment;
            progressDialogFragment.c(new d());
        }
        ProgressDialogFragment progressDialogFragment2 = this.Q;
        if (progressDialogFragment2 != null) {
            progressDialogFragment2.e(J(), str, true);
        }
    }

    static /* synthetic */ void a0(FaceCheckV2Activity faceCheckV2Activity, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "loading...";
        }
        faceCheckV2Activity.Z(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 n(FaceCheckV2Activity faceCheckV2Activity, String str) {
        if (str != null) {
            Context context = faceCheckV2Activity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.m(context, str);
        }
        return n1.f44123a;
    }

    private final void u() {
        ProgressDialogFragment progressDialogFragment = this.Q;
        if (progressDialogFragment != null) {
            if (!progressDialogFragment.isAdded()) {
                progressDialogFragment = null;
            }
            if (progressDialogFragment != null) {
                progressDialogFragment.dismissAllowingStateLoss();
            }
        }
    }

    public final void F(@NotNull FragmentManager fragmentManager) {
        g0.p(fragmentManager, "<set-?>");
        this.P = fragmentManager;
    }

    @NotNull
    public final LifecycleOwner G() {
        LifecycleOwner lifecycleOwner = this.O;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        g0.S("lifecycleOwner");
        return null;
    }

    @NotNull
    public final FragmentManager J() {
        FragmentManager fragmentManager = this.P;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        g0.S("dialogFagmentManager");
        return null;
    }

    @Nullable
    public final ProgressDialogFragment U() {
        return this.Q;
    }

    public final void X(@Nullable ProgressDialogFragment progressDialogFragment) {
        this.Q = progressDialogFragment;
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        g0.p(lifecycleOwner, "<set-?>");
        this.O = lifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 O(FaceCheckV2Activity faceCheckV2Activity, Integer num) {
        if (num.intValue() > 0) {
            FaceCheckVM faceCheckVM = faceCheckV2Activity.N;
            if (faceCheckVM == null) {
                g0.S("mViewModel");
                faceCheckVM = null;
            }
            faceCheckV2Activity.Z(faceCheckVM.d().getValue());
        } else {
            faceCheckV2Activity.u();
        }
        return n1.f44123a;
    }

    private final void V() {
        if (!FaceSDKManager.getInstance().getInitFlag()) {
            FaceSDKManager.getInstance().initialize(this, com.bxkj.student.run.app.face.a.f19804a, com.bxkj.student.run.app.face.a.f19805b, new b());
        }
    }

    private final void Y(Activity activity, float f6) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f6;
        window.setAttributes(attributes);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        u();
        Y(this, -1.0f);
        super.onDestroy();
    }

    @Override // com.baidu.idl.face.platform.ui.BaseFaceDetectActivity
    protected void onFace(@Nullable String str) {
        super.onFace(str);
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                R(str);
            }
        }
    }
}
