package com.bxkj.base.auth;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.AuthorizationDialog;
import com.bxkj.base.user.LoginUser;
import java.util.Map;
import x.h;
import x.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f16398a;

    /* renamed from: b, reason: collision with root package name */
    private g f16399b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.base.auth.a$a, reason: collision with other inner class name */
    class C0179a extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f16400a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.base.auth.a$a$a, reason: collision with other inner class name */
        class C0180a implements AuthorizationDialog.c {
            C0180a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInMall(true);
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                }
            }
        }

        C0179a(FragmentManager fragmentManager) {
            this.f16400a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInMall(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInMall()) {
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0180a()).e(0).show(this.f16400a, "mall");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f16403a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.base.auth.a$b$a, reason: collision with other inner class name */
        class C0181a implements AuthorizationDialog.c {
            C0181a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInLost(true);
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                }
            }
        }

        b(FragmentManager fragmentManager) {
            this.f16403a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInLost(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInLost()) {
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0181a()).e(1).show(this.f16403a, "mall");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f16406a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.base.auth.a$c$a, reason: collision with other inner class name */
        class C0182a implements AuthorizationDialog.c {
            C0182a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInSecondHand(true);
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                }
            }
        }

        c(FragmentManager fragmentManager) {
            this.f16406a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInSecondHand(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInSecondHand()) {
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0182a()).e(2).show(this.f16406a, "secondHand");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f16409a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.base.auth.a$d$a, reason: collision with other inner class name */
        class C0183a implements AuthorizationDialog.c {
            C0183a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInJob(true);
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                }
            }
        }

        d(FragmentManager fragmentManager) {
            this.f16409a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInJob(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInJob()) {
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0183a()).e(3).show(this.f16409a, "job");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f16412a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.base.auth.a$e$a, reason: collision with other inner class name */
        class C0184a implements AuthorizationDialog.c {
            C0184a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationInRuner(true);
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                }
            }
        }

        e(FragmentManager fragmentManager) {
            this.f16412a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationInRuner(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationInRuner()) {
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0184a()).e(4).show(this.f16412a, "job");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentManager f16415a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.base.auth.a$f$a, reason: collision with other inner class name */
        class C0185a implements AuthorizationDialog.c {
            C0185a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationDialog.c
            public void a() {
                LoginUser.getLoginUser().setAuthorizationDonation(true);
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                }
            }
        }

        f(FragmentManager fragmentManager) {
            this.f16415a = fragmentManager;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            LoginUser.getLoginUser().setAuthorizationDonation(JsonParse.getBoolean(map, "data"));
            if (LoginUser.getLoginUser().isAuthorizationDonation()) {
                if (a.this.f16399b != null) {
                    a.this.f16399b.a();
                    return;
                }
                return;
            }
            new AuthorizationDialog().f(new C0185a()).e(5).show(this.f16415a, "donation");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g {
        void a();
    }

    public a i(g gVar) {
        this.f16399b = gVar;
        return this;
    }

    public a(Context context) {
        this.f16398a = context;
    }

    private void c(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationDonation()) {
            g gVar = this.f16399b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f16398a).setObservable(((x.b) Http.getApiService(x.b.class)).f(LoginUser.getLoginUser().getOpenId())).setDataListener(new f(fragmentManager));
    }

    private void d(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInJob()) {
            g gVar = this.f16399b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f16398a).setObservable(((x.d) Http.getApiService(x.d.class)).j(LoginUser.getLoginUser().getOpenId())).setDataListener(new d(fragmentManager));
    }

    private void e(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInLost()) {
            g gVar = this.f16399b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f16398a).setObservable(((x.e) Http.getApiService(x.e.class)).f(LoginUser.getLoginUser().getOpenId())).setDataListener(new b(fragmentManager));
    }

    private void f(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInMall()) {
            g gVar = this.f16399b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f16398a).setObservable(((x.g) Http.getApiService(x.g.class)).z(LoginUser.getLoginUser().getOpenId())).setDataListener(new C0179a(fragmentManager));
    }

    private void g(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInRuner()) {
            g gVar = this.f16399b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f16398a).setObservable(((h) Http.getApiService(h.class)).c(LoginUser.getLoginUser().getOpenId())).setDataListener(new e(fragmentManager));
    }

    private void h(FragmentManager fragmentManager) {
        if (LoginUser.getLoginUser().isAuthorizationInSecondHand()) {
            g gVar = this.f16399b;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        Http.with(this.f16398a).setObservable(((i) Http.getApiService(i.class)).f(LoginUser.getLoginUser().getOpenId())).setDataListener(new c(fragmentManager));
    }

    public a b(FragmentManager fragmentManager, int i6) {
        if (!LoginUser.getLoginUser().isLogin()) {
            this.f16398a.startActivity(new Intent().setClassName(com.bxkj.student.d.f17843b, "com.bxkj.student.personal.login.LoginActivity"));
            return this;
        }
        if (i6 == 0) {
            f(fragmentManager);
            return this;
        }
        if (i6 == 1) {
            e(fragmentManager);
            return this;
        }
        if (i6 == 2) {
            h(fragmentManager);
            return this;
        }
        if (i6 == 3) {
            d(fragmentManager);
            return this;
        }
        if (i6 == 4) {
            g(fragmentManager);
            return this;
        }
        if (i6 == 5) {
            c(fragmentManager);
        }
        return this;
    }
}
