package com.bxkj.student.v2.ui;

import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.data.UserType;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.databinding.V2AcLoginBinding;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.v2.common.db.AppDatabase;
import com.bxkj.student.v2.common.utils.ThirdLogin;
import com.bxkj.student.v2.vm.LoginViewModel;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nLoginActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LoginActivity.kt\ncom/bxkj/student/v2/ui/LoginActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,280:1\n1#2:281\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class LoginActivity extends BaseActivity<V2AcLoginBinding, LoginViewModel> {

    @NotNull
    private UserType U = com.bxkj.base.v2.data.b.f16998d.a().T();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            g0.p(widget, "widget");
            iOSOneButtonDialog centerCustomView = new iOSOneButtonDialog(LoginActivity.this.H()).setTitle("隐私政策").setCenterCustomView(2131492946);
            ((SmartWebView) centerCustomView.findViewById(2131298538)).j(com.bxkj.student.v2.retrofit.b.f21275a.b());
            centerCustomView.show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            g0.p(widget, "widget");
            iOSOneButtonDialog centerCustomView = new iOSOneButtonDialog(LoginActivity.this.H()).setTitle("用户协议").setCenterCustomView(2131492946);
            ((SmartWebView) centerCustomView.findViewById(2131298538)).j(com.bxkj.student.v2.retrofit.b.f21275a.c());
            centerCustomView.show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.LoginActivity$observerData$1$1", f = "LoginActivity.kt", i = {0}, l = {150}, m = "invokeSuspend", n = {"intent"}, s = {"L$0"})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        Object f21294a;

        /* renamed from: b, reason: collision with root package name */
        int f21295b;

        c(kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return LoginActivity.this.new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intent putExtra;
            Intent intent;
            Object l6 = kotlin.coroutines.intrinsics.a.l();
            int i6 = this.f21295b;
            if (i6 != 0) {
                if (i6 == 1) {
                    intent = (Intent) this.f21294a;
                    kotlin.g0.n(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                kotlin.g0.n(obj);
                b.a aVar = com.bxkj.base.v2.data.b.f16998d;
                aVar.a().e();
                putExtra = new Intent(LoginActivity.this.H(), (Class<?>) MainActivity.class).putExtra("LoginSuccess", true);
                g0.o(putExtra, "putExtra(...)");
                if (LoginActivity.this.U != aVar.a().T()) {
                    com.bxkj.student.v2.common.db.dao.l w5 = AppDatabase.f20686a.a().w();
                    if (w5 != null) {
                        this.f21294a = putExtra;
                        this.f21295b = 1;
                        if (w5.a(this) == l6) {
                            return l6;
                        }
                        intent = putExtra;
                    }
                    b.a aVar2 = com.bxkj.base.v2.data.b.f16998d;
                    aVar2.a().u0(0L);
                    aVar2.a().t0(0L);
                    cn.bluemobi.dylan.base.utils.a.n().i(MainActivity.class);
                    putExtra.setFlags(335544320);
                }
                LoginActivity.this.startActivity(putExtra);
                LoginActivity.this.finish();
                return n1.f44123a;
            }
            putExtra = intent;
            b.a aVar22 = com.bxkj.base.v2.data.b.f16998d;
            aVar22.a().u0(0L);
            aVar22.a().t0(0L);
            cn.bluemobi.dylan.base.utils.a.n().i(MainActivity.class);
            putExtra.setFlags(335544320);
            LoginActivity.this.startActivity(putExtra);
            LoginActivity.this.finish();
            return n1.f44123a;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class d implements Observer, b0 {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f21297a;

        d(Function1 function) {
            g0.p(function, "function");
            this.f21297a = function;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof b0)) {
                return g0.g(getFunctionDelegate(), ((b0) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.b0
        @NotNull
        public final kotlin.n<?> getFunctionDelegate() {
            return this.f21297a;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f21297a.invoke(obj);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 N(LoginActivity loginActivity, String name, String linkUrl) {
        g0.p(name, "name");
        g0.p(linkUrl, "linkUrl");
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = loginActivity.r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, name);
        linkedHashMap.put("linkUrl", linkUrl);
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
        return n1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 P(LoginActivity loginActivity, String name, String linkUrl) {
        g0.p(name, "name");
        g0.p(linkUrl, "linkUrl");
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = loginActivity.r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, name);
        linkedHashMap.put("linkUrl", linkUrl);
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
        return n1Var;
    }

    private final void Q() {
        SpannableString spannableString = new SpannableString("阅读并接受《用户隐私政策》和《软件许可协议》");
        spannableString.setSpan(new a(), 5, 13, 33);
        spannableString.setSpan(new b(), 14, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 5, 13, 33);
        spannableString.setSpan(new ForegroundColorSpan(-16776961), 14, spannableString.length(), 33);
        L().tvAgree.setHighlightColor(0);
        L().tvAgree.setMovementMethod(LinkMovementMethod.getInstance());
        L().tvAgree.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 R(LoginActivity loginActivity, String it) {
        g0.p(it, "it");
        if (it.length() <= 0) {
            it = null;
        }
        if (it != null) {
            if (kotlin.text.u.M3(it)) {
                it = null;
            }
            if (it != null) {
                if (kotlin.text.u.l3(it, "1", false, 2, null)) {
                    loginActivity.L().tvLoginHint.setVisibility(0);
                    loginActivity.L().llAccount.setVisibility(0);
                    loginActivity.L().llPassword.setVisibility(0);
                    loginActivity.L().btLogin.setVisibility(0);
                } else {
                    loginActivity.L().tvLoginHint.setVisibility(8);
                    loginActivity.L().llAccount.setVisibility(8);
                    loginActivity.L().llPassword.setVisibility(8);
                    loginActivity.L().btLogin.setVisibility(8);
                }
                if (kotlin.text.u.l3(it, "2", false, 2, null)) {
                    loginActivity.L().ivWechat.setVisibility(0);
                    loginActivity.L().ivQq.setVisibility(0);
                } else {
                    loginActivity.L().ivWechat.setVisibility(8);
                    loginActivity.L().ivQq.setVisibility(8);
                }
                if (kotlin.text.u.l3(it, "3", false, 2, null)) {
                    loginActivity.L().btAuthCenter.setVisibility(0);
                    loginActivity.L().btAuthCenter.setVisibility(0);
                } else {
                    loginActivity.L().btAuthCenter.setVisibility(8);
                    loginActivity.L().btAuthCenter.setVisibility(8);
                }
            }
        }
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 V(LoginActivity loginActivity, String name, String linkUrl) {
        g0.p(name, "name");
        g0.p(linkUrl, "linkUrl");
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = loginActivity.r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, name);
        linkedHashMap.put("linkUrl", linkUrl);
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
        return n1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Y(final LoginActivity loginActivity, Map it) {
        g0.p(it, "it");
        c0 c0Var = c0.f16887a;
        final String t5 = c0Var.t(it, "uid");
        loginActivity.D().N(loginActivity.r(), t5, "2", c0Var.t(it, CommonNetImpl.NAME), c0Var.t(it, "iconurl"), new Function0() { // from class: com.bxkj.student.v2.ui.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 Z;
                Z = LoginActivity.Z(LoginActivity.this, t5);
                return Z;
            }
        });
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 b0(final LoginActivity loginActivity, Map it) {
        g0.p(it, "it");
        c0 c0Var = c0.f16887a;
        final String t5 = c0Var.t(it, "uid");
        loginActivity.D().N(loginActivity.r(), t5, "1", c0Var.t(it, CommonNetImpl.NAME), c0Var.t(it, "iconurl"), new Function0() { // from class: com.bxkj.student.v2.ui.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 c02;
                c02 = LoginActivity.c0(LoginActivity.this, t5);
                return c02;
            }
        });
        return n1.f44123a;
    }

    public final void T() {
        String t5 = c0.f16887a.t((Map) D().C().getValue(), "h5url");
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity r5 = r();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, "统一身份认证");
        linkedHashMap.put("linkUrl", t5);
        n1 n1Var = n1.f44123a;
        iVar.b(r5, linkedHashMap);
    }

    public final void W(@NotNull Map<String, ? extends Object> resultDataMap) {
        g0.p(resultDataMap, "resultDataMap");
        D().L(resultDataMap);
    }

    public final void e0() {
        startActivity(new Intent(H(), (Class<?>) SelectSchoolV2Activity.class));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().z0(false);
        L().setLoginViewModel(D());
        L().setActivity(this);
        L().setLoginInUser(aVar.a());
        D().I().set(aVar.a().S());
        aVar.a().z0(false);
        L().ivPhone.setVisibility(aVar.a().G() != 1 ? 8 : 0);
        Q();
        D().E(new Function1() { // from class: com.bxkj.student.v2.ui.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 R;
                R = LoginActivity.R(LoginActivity.this, (String) obj);
                return R;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 Z(LoginActivity loginActivity, String str) {
        loginActivity.D().M(str, "qqlogin ");
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 c0(LoginActivity loginActivity, String str) {
        loginActivity.D().M(str, "wechatlogin");
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 d0(LoginActivity loginActivity, Map map) {
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(loginActivity), g1.c(), null, loginActivity.new c(null), 2, null);
        return n1.f44123a;
    }

    public final void M() {
        D().z(new Function2() { // from class: com.bxkj.student.v2.ui.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                n1 N;
                N = LoginActivity.N(LoginActivity.this, (String) obj, (String) obj2);
                return N;
            }
        });
    }

    public final void O() {
        D().B(new Function2() { // from class: com.bxkj.student.v2.ui.i
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                n1 P;
                P = LoginActivity.P(LoginActivity.this, (String) obj, (String) obj2);
                return P;
            }
        });
    }

    public final void S() {
        String str = D().I().get();
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = D().G().get();
        if (str3 != null) {
            str2 = str3;
        }
        if (str.length() == 0) {
            new iOSOneButtonDialog(H()).setMessage("请输入账号").show();
            return;
        }
        if (str2.length() == 0) {
            new iOSOneButtonDialog(H()).setMessage("请输入密码").show();
        } else if (!L().cbAgree.isChecked()) {
            new iOSOneButtonDialog(H()).setMessage("请阅读并同意《用户隐私政策》和《软件许可协议》").show();
        } else {
            D().K();
        }
    }

    public final void U() {
        D().H(new Function2() { // from class: com.bxkj.student.v2.ui.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                n1 V;
                V = LoginActivity.V(LoginActivity.this, (String) obj, (String) obj2);
                return V;
            }
        });
    }

    public final void X() {
        if (L().cbAgree.isChecked()) {
            new ThirdLogin(r()).b(new Function1() { // from class: com.bxkj.student.v2.ui.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 Y;
                    Y = LoginActivity.Y(LoginActivity.this, (Map) obj);
                    return Y;
                }
            });
        } else {
            new iOSOneButtonDialog(H()).setMessage("请阅读并同意《用户隐私政策》和《软件许可协议》").show();
        }
    }

    public final void a0() {
        if (L().cbAgree.isChecked()) {
            new ThirdLogin(r()).c(new Function1() { // from class: com.bxkj.student.v2.ui.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 b02;
                    b02 = LoginActivity.b0(LoginActivity.this, (Map) obj);
                    return b02;
                }
            });
        } else {
            new iOSOneButtonDialog(H()).setMessage("请阅读并同意《用户隐私政策》和《软件许可协议》").show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i6, int i7, @Nullable Intent intent) {
        super.onActivityResult(i6, i7, intent);
        UMShareAPI.get(this).onActivityResult(i6, i7, intent);
    }

    @Override // com.bxkj.base.v2.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (L().tvAgree.getText() instanceof SpannableString) {
            CharSequence text = L().tvAgree.getText();
            g0.n(text, "null cannot be cast to non-null type android.text.SpannableString");
            SpannableString spannableString = (SpannableString) text;
            Iterator a6 = kotlin.jvm.internal.h.a((ClickableSpan[]) spannableString.getSpans(0, spannableString.length(), ClickableSpan.class));
            while (a6.hasNext()) {
                spannableString.removeSpan((ClickableSpan) a6.next());
            }
        }
        L().tvAgree.setText((CharSequence) null);
        L().tvAgree.setMovementMethod(null);
        super.onDestroy();
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        D().D().observe(r(), new d(new Function1() { // from class: com.bxkj.student.v2.ui.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 d02;
                d02 = LoginActivity.d0(LoginActivity.this, (Map) obj);
                return d02;
            }
        }));
    }
}
