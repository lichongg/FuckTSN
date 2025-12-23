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
import com.baidu.idl.face.platform.ui.BaseFaceLivenessActivity;
import com.bxkj.base.v2.base.ProgressDialogFragment;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.utils.v;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.face.FaceCollectVM;
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
@SourceDebugExtension({"SMAP\nFaceCollectActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FaceCollectActivity.kt\ncom/bxkj/student/v2/ui/face/FaceCollectActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,202:1\n1#2:203\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class FaceCollectActivity extends BaseFaceLivenessActivity {

    @NotNull
    public static final a R;
    public static final int S = 170;
    private Context M;
    private FaceCollectVM N;
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
        private final /* synthetic */ Function1 f21338a;

        c(Function1 function) {
            g0.p(function, "function");
            this.f21338a = function;
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
            return this.f21338a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21338a.invoke(obj);
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
            ProgressDialogFragment Q = FaceCollectActivity.this.Q();
            if (Q != null) {
                Q.dismiss();
            }
            FaceCollectVM faceCollectVM = FaceCollectActivity.this.N;
            if (faceCollectVM == null) {
                g0.S("mViewModel");
                faceCollectVM = null;
            }
            e2 b6 = faceCollectVM.b();
            if (b6 == null) {
                return true;
            }
            b6.b(new CancellationException());
            return true;
        }

        d() {
        }
    }

    @Override // com.baidu.idl.face.platform.ui.FaceLivenessActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(@Nullable Bundle bundle);

    static {
        StubApp.interface11(17285);
        R = new a(null);
    }

    private final void E() {
        FaceCollectVM faceCollectVM = this.N;
        if (faceCollectVM == null) {
            g0.S("mViewModel");
            faceCollectVM = null;
        }
        faceCollectVM.c().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 n6;
                n6 = FaceCollectActivity.n(FaceCollectActivity.this, (Integer) obj);
                return n6;
            }
        }));
        faceCollectVM.e().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 M;
                M = FaceCollectActivity.M(FaceCollectActivity.this, (String) obj);
                return M;
            }
        }));
        faceCollectVM.f().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 O;
                O = FaceCollectActivity.O(FaceCollectActivity.this, (String) obj);
                return O;
            }
        }));
        faceCollectVM.h().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 l6;
                l6 = FaceCollectActivity.l(FaceCollectActivity.this, (String) obj);
                return l6;
            }
        }));
        faceCollectVM.g().observe(G(), new c(new Function1() { // from class: com.bxkj.student.v2.ui.face.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 m6;
                m6 = FaceCollectActivity.m(FaceCollectActivity.this, (String) obj);
                return m6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 M(final FaceCollectActivity faceCollectActivity, final String str) {
        if (str != null) {
            Context context = faceCollectActivity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.o(context, str, new Function1() { // from class: com.bxkj.student.v2.ui.face.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 N;
                    N = FaceCollectActivity.N(str, faceCollectActivity, (iOSOneButtonDialog) obj);
                    return N;
                }
            }).setCancelable(false);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(String str, FaceCollectActivity faceCollectActivity, iOSOneButtonDialog it) {
        g0.p(it, "it");
        Context context = null;
        if (kotlin.text.u.l3(str, "登录失效", false, 2, null)) {
            Context context2 = faceCollectActivity.M;
            if (context2 == null) {
                g0.S("mContext");
                context2 = null;
            }
            Context context3 = faceCollectActivity.M;
            if (context3 == null) {
                g0.S("mContext");
            } else {
                context = context3;
            }
            context2.startActivity(new Intent(context, (Class<?>) LoginActivity.class).setFlags(268468224));
        } else {
            faceCollectActivity.S();
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 O(FaceCollectActivity faceCollectActivity, String str) {
        if (str != null) {
            Context context = faceCollectActivity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.m(context, str);
        }
        return n1.f44123a;
    }

    private final void P(String str) {
        File file;
        Context context = null;
        if (g0.g("mounted", Environment.getExternalStorageState())) {
            Context context2 = this.M;
            if (context2 == null) {
                g0.S("mContext");
                context2 = null;
            }
            file = context2.getExternalCacheDir();
        } else {
            file = null;
        }
        if (file == null || !file.exists()) {
            Context context3 = this.M;
            if (context3 == null) {
                g0.S("mContext");
                context3 = null;
            }
            file = context3.getCacheDir();
        }
        File file2 = new File(file, "avatar");
        boolean exists = file2.exists();
        if (!exists) {
            exists = file2.mkdirs();
        }
        if (exists) {
            File file3 = new File(file2, "avatar_face.png");
            com.orhanobut.logger.j.d("avatar=" + file3.getPath(), new Object[0]);
            v.a aVar = com.bxkj.base.v2.common.utils.v.f16952a;
            String path = file3.getPath();
            g0.o(path, "getPath(...)");
            File a6 = aVar.a(str, path);
            Intent intent = getIntent();
            Context context4 = this.M;
            if (context4 == null) {
                g0.S("mContext");
            } else {
                context = context4;
            }
            startActivity(intent.setClass(context, FaceCollectConfirmActivity.class).putExtra("avatar", a6.getPath()));
        }
    }

    private final void S() {
        setResult(170, getIntent());
        finish();
    }

    private final void V(String str) {
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

    static /* synthetic */ void W(FaceCollectActivity faceCollectActivity, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = "loading...";
        }
        faceCollectActivity.V(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 l(FaceCollectActivity faceCollectActivity, String str) {
        if (str != null) {
            Context context = faceCollectActivity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.s(context, str, 0, 2, null);
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 m(FaceCollectActivity faceCollectActivity, String str) {
        if (str != null) {
            Context context = faceCollectActivity.M;
            if (context == null) {
                g0.S("mContext");
                context = null;
            }
            ContextExtKt.q(context, str);
        }
        return n1.f44123a;
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
    public final ProgressDialogFragment Q() {
        return this.Q;
    }

    public final void T(@Nullable ProgressDialogFragment progressDialogFragment) {
        this.Q = progressDialogFragment;
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        g0.p(lifecycleOwner, "<set-?>");
        this.O = lifecycleOwner;
    }

    public final void u() {
        ProgressDialogFragment progressDialogFragment = this.Q;
        if (progressDialogFragment == null || progressDialogFragment == null) {
            return;
        }
        progressDialogFragment.dismiss();
    }

    private final void R() {
        if (!FaceSDKManager.getInstance().getInitFlag()) {
            FaceSDKManager.getInstance().initialize(this, com.bxkj.student.run.app.face.a.f19804a, com.bxkj.student.run.app.face.a.f19805b, new b());
        }
    }

    private final void U(Activity activity, float f6) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = f6;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 n(FaceCollectActivity faceCollectActivity, Integer num) {
        if (num.intValue() > 0) {
            FaceCollectVM faceCollectVM = faceCollectActivity.N;
            if (faceCollectVM == null) {
                g0.S("mViewModel");
                faceCollectVM = null;
            }
            faceCollectActivity.V(faceCollectVM.d().getValue());
        } else {
            faceCollectActivity.u();
        }
        return n1.f44123a;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        u();
        U(this, -1.0f);
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
                P(str);
            }
        }
    }
}
