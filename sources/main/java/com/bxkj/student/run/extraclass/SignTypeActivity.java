package com.bxkj.student.run.extraclass;

import androidx.work.WorkRequest;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.qrcode.b;
import com.bxkj.student.databinding.AcExtraExerciseTypeBinding;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SignTypeActivity extends BaseActivity<AcExtraExerciseTypeBinding, BaseViewModel> {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20426b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.run.extraclass.SignTypeActivity$a$a, reason: collision with other inner class name */
        public static final class C0272a extends HttpCallBack {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ SignTypeActivity f20427a;

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, ? extends Object> data) {
                g0.p(data, "data");
            }

            C0272a(SignTypeActivity signTypeActivity) {
                this.f20427a = signTypeActivity;
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, ? extends Object> data, String msg) {
                g0.p(data, "data");
                g0.p(msg, "msg");
                ContextExtKt.s(this.f20427a, msg, 0, 2, null);
            }
        }

        a(String str) {
            this.f20426b = str;
        }

        @Override // com.bxkj.base.v2.common.qrcode.b.a
        public void a(String result) {
            g0.p(result, "result");
            String substring = c0.b.f1042a.j(SignTypeActivity.this.H()).substring(0, 16);
            g0.o(substring, "substring(...)");
            String a6 = com.bxkj.base.util.a.a(result, substring);
            if (a6 == null || !u.l3(a6, "#", false, 2, null)) {
                ContextExtKt.q(SignTypeActivity.this, "无效码");
                return;
            }
            List m52 = u.m5(a6, new String[]{"#"}, false, 0, 6, null);
            String str = (String) m52.get(0);
            if (System.currentTimeMillis() - Long.parseLong((String) m52.get(1)) > WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                ContextExtKt.q(SignTypeActivity.this, "二维码已过期");
            } else {
                Http.with(SignTypeActivity.this.H()).hideSuccessMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).v0(str, LoginUser.getLoginUser().getAccount(), this.f20426b)).setDataListener(new C0272a(SignTypeActivity.this));
            }
        }
    }

    public final void M() {
        e("1");
    }

    public final void N() {
        e("0");
    }

    public final void e(@NotNull String type) {
        g0.p(type, "type");
        new b(r()).m(new a(type));
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setSignTypeActivity(this);
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
