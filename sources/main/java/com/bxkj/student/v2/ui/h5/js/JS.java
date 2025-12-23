package com.bxkj.student.v2.ui.h5.js;

import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.qrcode.b;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.base.v2.common.utils.j0;
import com.bxkj.base.v2.data.b;
import com.bxkj.student.splash.SelectSchoolV2Activity;
import com.bxkj.student.v2.common.ad.AdManager;
import com.bxkj.student.v2.common.utils.ThirdLogin;
import com.bxkj.student.v2.common.utils.w;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.ui.MainActivity;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.bxkj.student.v2.ui.main.MyFragment;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.bxkj.student.v2.ui.sports.v3.appeal.V3AppealActivity;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.g0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import kotlin.text.u;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJS.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JS.kt\ncom/bxkj/student/v2/ui/h5/js/JS\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,397:1\n1#2:398\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public class JS extends j {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private FragmentActivity f21400i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private WebView f21401j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.JS$getCircleImage$2$1", f = "JS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21402a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21404c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, kotlin.coroutines.e<? super a> eVar) {
            super(2, eVar);
            this.f21404c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return JS.this.new a(this.f21404c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((a) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21402a == 0) {
                g0.n(obj);
                JS.this.b().evaluateJavascript("sendImageBase64('" + this.f21404c + "')", null);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.JS$goPublish$1", f = "JS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21405a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21407c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21408d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ JS f21409a;

            @Override // u.b.a
            public void a(int i6, Intent intent) {
                if (i6 == -1) {
                    this.f21409a.b().loadUrl("javascript:refresh()");
                }
            }

            a(JS js) {
                this.f21409a = js;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, kotlin.coroutines.e<? super b> eVar) {
            super(2, eVar);
            this.f21407c = str;
            this.f21408d = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return JS.this.new b(this.f21407c, this.f21408d, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((b) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21405a == 0) {
                g0.n(obj);
                com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
                FragmentActivity a6 = JS.this.a();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                String str = this.f21407c;
                String str2 = this.f21408d;
                linkedHashMap.put(CommonNetImpl.NAME, str);
                linkedHashMap.put("linkUrl", str2);
                n1 n1Var = n1.f44123a;
                iVar.c(a6, linkedHashMap, new a(JS.this));
                return n1Var;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.JS$openScanQR$1", f = "JS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21410a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ JS f21412a;

            a(JS js) {
                this.f21412a = js;
            }

            @Override // com.bxkj.base.v2.common.qrcode.b.a
            public void a(String result) {
                kotlin.jvm.internal.g0.p(result, "result");
                com.orhanobut.logger.j.d("result=" + result, new Object[0]);
                if (!u.H2(result, master.flame.danmaku.danmaku.parser.b.f50154a, false, 2, null)) {
                    this.f21412a.b().loadUrl("javascript:getScanInfo('" + result + "')");
                    return;
                }
                com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
                FragmentActivity a6 = this.f21412a.a();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(CommonNetImpl.NAME, "扫一扫");
                linkedHashMap.put("linkUrl", result);
                n1 n1Var = n1.f44123a;
                iVar.b(a6, linkedHashMap);
            }
        }

        c(kotlin.coroutines.e<? super c> eVar) {
            super(2, eVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return JS.this.new c(eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((c) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21410a == 0) {
                g0.n(obj);
                new com.bxkj.base.v2.common.qrcode.b(JS.this.a()).m(new a(JS.this));
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.JS$requestAuthInfo$1", f = "JS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21413a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21415c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, kotlin.coroutines.e<? super d> eVar) {
            super(2, eVar);
            this.f21415c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return JS.this.new d(this.f21415c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((d) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21413a == 0) {
                g0.n(obj);
                JS.this.b().evaluateJavascript(this.f21415c, null);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "com.bxkj.student.v2.ui.h5.js.JS$saveImage$1", f = "JS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class e extends SuspendLambda implements Function2<r0, kotlin.coroutines.e<? super n1>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f21416a;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21418c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, kotlin.coroutines.e<? super e> eVar) {
            super(2, eVar);
            this.f21418c = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
            return JS.this.new e(this.f21418c, eVar);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(r0 r0Var, kotlin.coroutines.e<? super n1> eVar) {
            return ((e) create(r0Var, eVar)).invokeSuspend(n1.f44123a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.a.l();
            if (this.f21416a == 0) {
                g0.n(obj);
                j0.f16904a.d(JS.this.a(), this.f21418c);
                return n1.f44123a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @JavascriptInterface
    public final void getCircleImage() {
        com.orhanobut.logger.j.d("圈子获取图片", new Object[0]);
        if ((a().getIntent().hasExtra("imagePath") ? this : null) != null) {
            String stringExtra = a().getIntent().getStringExtra("imagePath");
            if (stringExtra == null) {
                stringExtra = "";
            }
            String b6 = com.bxkj.base.util.j.b(stringExtra);
            com.orhanobut.logger.j.d("imagePath=" + stringExtra, new Object[0]);
            kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(a()), g1.e(), null, new a(b6, null), 2, null);
        }
    }

    @JavascriptInterface
    public final void goPublish(@Nullable String str, @Nullable String str2) {
        com.orhanobut.logger.j.d("圈子->goPublish", new Object[0]);
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(a()), g1.e(), null, new b(str, str2, null), 2, null);
    }

    @JavascriptInterface
    public final void goThirdLogin() {
        com.orhanobut.logger.j.d("微信和QQ登录身份认证成功无需身份直接登录-->JS->goThirdLogin", new Object[0]);
        a().setResult(-1);
        a().finish();
    }

    @JavascriptInterface
    public final void publishSuccess() {
        com.orhanobut.logger.j.d("圈子发布成功", new Object[0]);
        a().setResult(-1);
        a().finish();
    }

    @JavascriptInterface
    public final void refreshUser() {
        com.orhanobut.logger.j.d("H5修改头像刷新用户信息-->JS->refreshUser", new Object[0]);
        MyFragment myFragment = (MyFragment) cn.bluemobi.dylan.base.utils.a.n().o(MyFragment.class);
        if (myFragment != null) {
            myFragment.h();
        }
    }

    @JavascriptInterface
    public final void requestAuthInfo() {
        com.orhanobut.logger.j.d("微信和QQ登录身份认证获取第三方信息-->JS->requestAuthInfo", new Object[0]);
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(a()), g1.e(), null, new d("getAuthInfo('" + com.bxkj.base.v2.data.b.f16998d.a().L() + "','" + a().getIntent().getStringExtra("openId") + "','" + a().getIntent().getStringExtra("type") + "','" + a().getIntent().getStringExtra("thirdName") + "','" + a().getIntent().getStringExtra("thirdImage") + "','" + a().getIntent().getStringExtra("isOpenRoleAuthAudit") + "')", null), 2, null);
    }

    @JavascriptInterface
    public final void setUserLogin(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        com.orhanobut.logger.j.d("用户完善完信息后设置用户登录状态-->JS->setUserLogin", new Object[0]);
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().z0(true);
        if (str != null) {
            aVar.a().e0(str);
        }
        if (str2 != null) {
            aVar.a().k0(str2);
        }
        if (str3 != null) {
            aVar.a().K0(str3);
        }
        if (str4 != null) {
            aVar.a().U0(str4);
        }
        if (str5 != null) {
            aVar.a().X0(str5);
        }
    }

    @JavascriptInterface
    public final void showRewardAd() {
        com.orhanobut.logger.j.d("展示激励广告-->JS->showRewardAd", new Object[0]);
        AdManager.f20633a.a(a(), new Function0() { // from class: com.bxkj.student.v2.ui.h5.js.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 D;
                D = JS.D(JS.this);
                return D;
            }
        });
    }

    @JavascriptInterface
    public final void skipBindPhone() {
        com.orhanobut.logger.j.d("H5绑定手机号跳过-->JS->skipBindPhone", new Object[0]);
        com.bxkj.base.v2.data.b.f16998d.a().S0(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JS(@NotNull FragmentActivity mActivity, @NotNull WebView mWebView) {
        super(mActivity, mWebView);
        kotlin.jvm.internal.g0.p(mActivity, "mActivity");
        kotlin.jvm.internal.g0.p(mWebView, "mWebView");
        this.f21400i = mActivity;
        this.f21401j = mWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 B(JS js, Map it) {
        kotlin.jvm.internal.g0.p(it, "it");
        WebView b6 = js.b();
        c0 c0Var = c0.f16887a;
        b6.loadUrl("javascript:bindQq('" + c0Var.t(it, "uid") + "','" + c0Var.t(it, CommonNetImpl.NAME) + "','" + c0Var.t(it, "iconurl") + "')");
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 C(JS js, Map it) {
        kotlin.jvm.internal.g0.p(it, "it");
        WebView b6 = js.b();
        c0 c0Var = c0.f16887a;
        b6.loadUrl("javascript:bindWechat('" + c0Var.t(it, "uid") + "','" + c0Var.t(it, CommonNetImpl.NAME) + "','" + c0Var.t(it, "iconurl") + "')");
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 D(JS js) {
        js.b().loadUrl("javascript:adRewardArrived()");
        return n1.f44123a;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.j, com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.l
    @NotNull
    public FragmentActivity a() {
        return this.f21400i;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.l
    @NotNull
    public WebView b() {
        return this.f21401j;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.j, com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.l
    public void c(@NotNull FragmentActivity fragmentActivity) {
        kotlin.jvm.internal.g0.p(fragmentActivity, "<set-?>");
        this.f21400i = fragmentActivity;
    }

    @Override // com.bxkj.student.v2.ui.h5.js.a, com.bxkj.base.v2.h5.l
    public void d(@NotNull WebView webView) {
        kotlin.jvm.internal.g0.p(webView, "<set-?>");
        this.f21401j = webView;
    }

    @JavascriptInterface
    public final void downloadBlobFile(@Nullable String str, @Nullable String str2, @NotNull String base64Data) {
        kotlin.jvm.internal.g0.p(base64Data, "base64Data");
        com.orhanobut.logger.j.d("JS：downloadBlobFile-> fileName=" + str + " mimeType=" + str2 + " base64Data=" + base64Data, new Object[0]);
        com.bxkj.base.v2.h5.e.f17046a.c(a(), str, str2, base64Data);
    }

    @JavascriptInterface
    public final void exerciseFeedBack(@Nullable String str, @NotNull String exerciseRecordId) {
        kotlin.jvm.internal.g0.p(exerciseRecordId, "exerciseRecordId");
        a().startActivity(new Intent(a(), (Class<?>) V3AppealActivity.class).putExtra("exerciseRecordId", exerciseRecordId));
    }

    @JavascriptInterface
    public final void goDetails(@Nullable String str, @Nullable String str2) {
        com.bxkj.student.v2.common.utils.i iVar = com.bxkj.student.v2.common.utils.i.f20904a;
        FragmentActivity a6 = a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(CommonNetImpl.NAME, str);
        linkedHashMap.put("linkUrl", str2);
        n1 n1Var = n1.f44123a;
        iVar.b(a6, linkedHashMap);
    }

    @JavascriptInterface
    public final void loginByPhone(@NotNull String access_token, @NotNull String dept_id, @NotNull String refresh_token, @NotNull String user_id, @NotNull String username) {
        kotlin.jvm.internal.g0.p(access_token, "access_token");
        kotlin.jvm.internal.g0.p(dept_id, "dept_id");
        kotlin.jvm.internal.g0.p(refresh_token, "refresh_token");
        kotlin.jvm.internal.g0.p(user_id, "user_id");
        kotlin.jvm.internal.g0.p(username, "username");
        com.orhanobut.logger.j.d("H5手机短信验证码登录-->JS->loginByPhone", new Object[0]);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("access_token", access_token);
        linkedHashMap.put("dept_id", dept_id);
        linkedHashMap.put("refresh_token", refresh_token);
        linkedHashMap.put(SocializeConstants.TENCENT_UID, user_id);
        linkedHashMap.put("username", username);
        LoginActivity loginActivity = (LoginActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(LoginActivity.class);
        if (loginActivity != null) {
            loginActivity.W(linkedHashMap);
        }
        a().finish();
    }

    @JavascriptInterface
    public final void loginTimeout() {
        com.bxkj.base.v2.data.b.f16998d.a().d();
        a().startActivity(new Intent(a(), (Class<?>) LoginActivity.class));
        cn.bluemobi.dylan.base.utils.a.n().i(H5AppActivity.class);
        MainActivity mainActivity = (MainActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MainActivity.class);
        if (mainActivity != null) {
            mainActivity.D().Z().postValue(Boolean.TRUE);
        }
        a().finish();
    }

    @JavascriptInterface
    public final void openApplet(@NotNull String username, @Nullable String str) {
        kotlin.jvm.internal.g0.p(username, "username");
        com.orhanobut.logger.j.d("username=" + username + " path=" + str, new Object[0]);
        w.f20952a.a(a(), username, str);
    }

    @JavascriptInterface
    public final void openQq() {
        new ThirdLogin(a()).b(new Function1() { // from class: com.bxkj.student.v2.ui.h5.js.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 B;
                B = JS.B(JS.this, (Map) obj);
                return B;
            }
        });
    }

    @JavascriptInterface
    public final void openWechat() {
        new ThirdLogin(a()).c(new Function1() { // from class: com.bxkj.student.v2.ui.h5.js.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                n1 C;
                C = JS.C(JS.this, (Map) obj);
                return C;
            }
        });
    }

    @JavascriptInterface
    public final void saveImage(@Nullable String str) {
        com.orhanobut.logger.j.d("保存图片-->JS->saveImage-url=" + str, new Object[0]);
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(a()), g1.e(), null, new e(str, null), 2, null);
    }

    @JavascriptInterface
    public final void share(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        SHARE_MEDIA share_media;
        UMWeb uMWeb = new UMWeb(str5);
        uMWeb.setTitle(str2);
        uMWeb.setThumb(new UMImage(a(), str4));
        uMWeb.setDescription(str3);
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1779587763) {
                if (hashCode != 2592) {
                    if (hashCode == 77564797 && str.equals("QZONE")) {
                        share_media = SHARE_MEDIA.QZONE;
                    }
                } else if (str.equals(Constants.SOURCE_QQ)) {
                    share_media = SHARE_MEDIA.QQ;
                }
            } else if (str.equals("WEIXIN_CIRCLE")) {
                share_media = SHARE_MEDIA.WEIXIN_CIRCLE;
            }
            new ShareAction(a()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.h5.js.JS$share$1
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(SHARE_MEDIA platform) {
                    kotlin.jvm.internal.g0.p(platform, "platform");
                    ContextExtKt.t(JS.this.a(), "分享取消了");
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(SHARE_MEDIA platform, Throwable t5) {
                    kotlin.jvm.internal.g0.p(platform, "platform");
                    kotlin.jvm.internal.g0.p(t5, "t");
                    t5.printStackTrace();
                    ContextExtKt.t(JS.this.a(), "分享失败啦");
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onResult(SHARE_MEDIA platform) {
                    kotlin.jvm.internal.g0.p(platform, "platform");
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onStart(SHARE_MEDIA share_media2) {
                    kotlin.jvm.internal.g0.p(share_media2, "share_media");
                }
            }).withMedia(uMWeb).share();
        }
        share_media = SHARE_MEDIA.WEIXIN;
        new ShareAction(a()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.h5.js.JS$share$1
            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                kotlin.jvm.internal.g0.p(platform, "platform");
                ContextExtKt.t(JS.this.a(), "分享取消了");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t5) {
                kotlin.jvm.internal.g0.p(platform, "platform");
                kotlin.jvm.internal.g0.p(t5, "t");
                t5.printStackTrace();
                ContextExtKt.t(JS.this.a(), "分享失败啦");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                kotlin.jvm.internal.g0.p(platform, "platform");
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media2) {
                kotlin.jvm.internal.g0.p(share_media2, "share_media");
            }
        }).withMedia(uMWeb).share();
    }

    @JavascriptInterface
    public final void startExercise(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        b.a aVar = com.bxkj.base.v2.data.b.f16998d;
        aVar.a().z0(true);
        if (str != null) {
            aVar.a().e0(str);
        }
        if (str2 != null) {
            aVar.a().M0(str2);
        }
        if (str3 != null) {
            aVar.a().W0(str3);
        }
        com.bxkj.student.v2.retrofit.e.f21288a.b();
        a().startActivity(new Intent(a(), (Class<?>) V3SportsHomeActivity.class));
    }

    @JavascriptInterface
    public void finish() {
        a().finish();
    }

    @JavascriptInterface
    public final void openScanQR() {
        kotlinx.coroutines.k.f(LifecycleOwnerKt.getLifecycleScope(a()), g1.e(), null, new c(null), 2, null);
    }

    @JavascriptInterface
    public final void selectSchool() {
        a().startActivity(new Intent(a(), (Class<?>) SelectSchoolV2Activity.class));
    }
}
