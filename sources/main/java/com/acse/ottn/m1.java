package com.acse.ottn;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bi;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.TreeMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    public static m1 f4791a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f4792b = "HttpUtil";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Consumer<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnIndividuationCallBack f4793a;

        public a(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
            this.f4793a = onIndividuationCallBack;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f4793a.onIndividuationState(true);
            c2.b("ShopHelperService", "报错了=" + th.getMessage());
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a0 {
        void a(AccessiblityModel accessiblityModel);

        void a(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Consumer<String> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k) != 1) {
                    return;
                }
                j3.a().b("tag_homepage_info", jSONObject.getString("data"));
            } catch (Throwable unused) {
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b0 {
        void a(int i6, int i7);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements Consumer<Throwable> {
        public c() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            c2.b("HttpUtil", "报错了=" + th.getMessage());
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements Consumer<String> {
        public d() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k) == 1) {
                j3.a().b("tag_homepage_info", jSONObject.getString("data"));
            } else {
                j3.a().b("tag_homepage_info", "");
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements Consumer<Throwable> {
        public e() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            c2.b("HttpUtil", "报错了=" + th.getMessage());
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements Consumer<AccessiblityModel> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4799a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a0 f4800b;

        public f(String str, a0 a0Var) {
            this.f4799a = str;
            this.f4800b = a0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AccessiblityModel accessiblityModel) throws Exception {
            c2.a(m1.f4792b, "请求成功 string =" + accessiblityModel.toString());
            l4.a().b(2, this.f4799a, " r =" + accessiblityModel.getR());
            com.acse.ottn.d.d().f4344p = false;
            com.acse.ottn.d.d().f4345q = 0;
            a0 a0Var = this.f4800b;
            if (a0Var != null) {
                a0Var.a(accessiblityModel);
            }
            j3.a().a("coupon_request_time", 0L);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements Consumer<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f4802a;

        public g(a0 a0Var) {
            this.f4802a = a0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            c2.b(m1.f4792b, "报错了=" + th.getMessage());
            a0 a0Var = this.f4802a;
            if (a0Var != null) {
                a0Var.a(th.getMessage());
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class h implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f4804a;

        public h(a0 a0Var) {
            this.f4804a = a0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            int i6 = new JSONObject(str).getInt(com.kuaishou.weapon.p0.t.f36150k);
            a0 a0Var = this.f4804a;
            if (a0Var != null) {
                if (i6 == 1) {
                    a0Var.a((AccessiblityModel) null);
                } else {
                    a0Var.a((String) null);
                }
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class i implements Consumer<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f4805a;

        public i(a0 a0Var) {
            this.f4805a = a0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            a0 a0Var = this.f4805a;
            if (a0Var != null) {
                a0Var.a((String) null);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class j implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f4806a;

        public j(a0 a0Var) {
            this.f4806a = a0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            int i6 = jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k);
            a0 a0Var = this.f4806a;
            if (a0Var != null) {
                if (i6 != 1) {
                    a0Var.a((String) null);
                    return;
                }
                int i7 = jSONObject.getInt("state");
                AccessiblityModel accessiblityModel = new AccessiblityModel();
                accessiblityModel.setRed_package(i7);
                this.f4806a.a(accessiblityModel);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class k implements Consumer<String> {
        public k() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class l implements Consumer<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f4808a;

        public l(a0 a0Var) {
            this.f4808a = a0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            a0 a0Var = this.f4808a;
            if (a0Var != null) {
                a0Var.a((String) null);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class m implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f4809a;

        public m(a0 a0Var) {
            this.f4809a = a0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            if (new JSONObject(str).getInt(com.kuaishou.weapon.p0.t.f36150k) == 1) {
                this.f4809a.a((AccessiblityModel) null);
            } else {
                this.f4809a.a((String) null);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class n implements Consumer<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f4810a;

        public n(a0 a0Var) {
            this.f4810a = a0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            a0 a0Var = this.f4810a;
            if (a0Var != null) {
                a0Var.a((String) null);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class q implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b0 f4811a;

        public q(b0 b0Var) {
            this.f4811a = b0Var;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            int i6 = jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k);
            int i7 = jSONObject.getInt("code");
            b0 b0Var = this.f4811a;
            if (b0Var != null) {
                b0Var.a(i6, i7);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class r implements Consumer<Throwable> {
        public r() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class s implements Consumer<Throwable> {
        public s() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class t implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f4815a;

        public t(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f4815a = onOpenPermission;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k) != 1) {
                AcseHelpManager.OnOpenPermission onOpenPermission = this.f4815a;
                if (onOpenPermission != null) {
                    onOpenPermission.openPermission(false);
                    return;
                }
                return;
            }
            if (jSONObject.getInt("open_plugin_permission") == 1) {
                AcseHelpManager.OnOpenPermission onOpenPermission2 = this.f4815a;
                if (onOpenPermission2 != null) {
                    onOpenPermission2.openPermission(true);
                    return;
                }
                return;
            }
            AcseHelpManager.OnOpenPermission onOpenPermission3 = this.f4815a;
            if (onOpenPermission3 != null) {
                onOpenPermission3.openPermission(false);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class u implements Consumer<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f4817a;

        public u(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f4817a = onOpenPermission;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            AcseHelpManager.OnOpenPermission onOpenPermission = this.f4817a;
            if (onOpenPermission != null) {
                onOpenPermission.openPermission(false);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class v implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f4819a;

        public v(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f4819a = onOpenPermission;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (this.f4819a != null) {
                if (jSONObject.getInt(com.kuaishou.weapon.p0.t.f36150k) == 1) {
                    this.f4819a.openPermission(AcseHelpManager.isOPenPermission());
                } else {
                    this.f4819a.openPermission(true);
                }
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class w implements Consumer<Throwable> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnOpenPermission f4821a;

        public w(AcseHelpManager.OnOpenPermission onOpenPermission) {
            this.f4821a = onOpenPermission;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            AcseHelpManager.OnOpenPermission onOpenPermission = this.f4821a;
            if (onOpenPermission != null) {
                onOpenPermission.openPermission(AcseHelpManager.isOPenPermission());
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class x implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f4823a;

        public x(String str) {
            this.f4823a = str;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            j1.c().a(this.f4823a);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class y implements Consumer<Throwable> {
        public y() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class z implements Consumer<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnIndividuationCallBack f4826a;

        public z(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
            this.f4826a = onIndividuationCallBack;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            if (new JSONObject(str).getInt("state") == 1) {
                this.f4826a.onIndividuationState(true);
            } else {
                this.f4826a.onIndividuationState(false);
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    public static m1 c() {
        if (f4791a == null) {
            synchronized (m1.class) {
                try {
                    if (f4791a == null) {
                        f4791a = new m1();
                    }
                } finally {
                }
            }
        }
        return f4791a;
    }

    public void b() {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put(bi.H, j4.i());
        treeMap.put("device_product", j4.j());
        treeMap.put(bi.F, j4.b());
        treeMap.put("system_model", j4.p());
        treeMap.put(bi.E, j4.a());
        treeMap.put("device_device", j4.d());
        treeMap.put("device_fubgerprint", j4.f());
        treeMap.put("device_SDK", j4.k() + "");
        treeMap.put("system_version", j3.a().e("getSystemVersion"));
        treeMap.put("plunin_version", "0");
        treeMap.put("is_snt", "0");
        new f0().e(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new k(), new s());
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class o implements Consumer<String> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class p implements Consumer<Throwable> {
        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public void a(Activity activity, AcseHelpManager.OnOpenPermission onOpenPermission) {
        boolean canDrawOverlays;
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put(bi.H, j4.i());
        treeMap.put("device_product", j4.j());
        treeMap.put(bi.F, j4.b());
        treeMap.put("system_model", j4.p());
        treeMap.put(bi.E, j4.a());
        treeMap.put("device_device", j4.d());
        treeMap.put("device_fubgerprint", j4.f());
        treeMap.put("device_SDK", j4.k() + "");
        treeMap.put("system_version", j4.q());
        treeMap.put("harmonyDisplayVersion", j4.e());
        treeMap.put("accessiblity_state", com.acse.ottn.b.c().e() ? "1" : "0");
        if (Build.VERSION.SDK_INT >= 23) {
            canDrawOverlays = Settings.canDrawOverlays(activity);
            treeMap.put("flow_window_state", canDrawOverlays ? "1" : "0");
        } else {
            treeMap.put("flow_window_state", "0");
        }
        treeMap.put("maven_version", e0.f4495f);
        if (activity != null) {
            treeMap.put("plunin_version", r1.a().a((Context) activity).getVersion());
        }
        treeMap.put("is_snt", "0");
        new f0().l(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new t(onOpenPermission), new u(onOpenPermission));
    }

    public final Object d() throws ObjectStreamException {
        return f4791a;
    }

    public void e() {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionExID());
        treeMap.put("new_version", k0.f4675k);
        treeMap.put("maven_version", e0.f4495f);
        new g1().a(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new d(), new e());
    }

    public static void c(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, str);
        treeMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        new g1().g(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new o(), new p());
    }

    public void b(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionExID());
        treeMap.put("new_version", k0.f4675k);
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, str);
        treeMap.put("maven_version", e0.f4495f);
        new g1().b(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new b(), new c());
    }

    public void a(AcseHelpManager.OnOpenPermission onOpenPermission) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put(bi.H, j4.i());
        treeMap.put("device_product", j4.j());
        treeMap.put(bi.F, j4.b());
        treeMap.put("system_model", j4.p());
        treeMap.put(bi.E, j4.a());
        treeMap.put("device_device", j4.d());
        treeMap.put("device_fubgerprint", j4.f());
        treeMap.put("device_SDK", j4.k() + "");
        treeMap.put("system_version", j3.a().e("getSystemVersion"));
        treeMap.put("plunin_version", r1.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        new f0().h(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new v(onOpenPermission), new w(onOpenPermission));
    }

    public static void b(String str, String str2, a0 a0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("username", str);
        treeMap.put("password", str2);
        new g1().l(RequestBody.create(MediaType.parse("application/json,utf-8"), JSON.toJSONString(treeMap))).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new h(a0Var), new i(a0Var));
    }

    public void a(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("version", r1.a().a(HelpShopAppUtil.getContext().getPackageName()).getVersion());
        treeMap.put("is_snt", "0");
        treeMap.put("state", str);
        new f0().d(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new x(str), new y());
    }

    public void a(AcseHelpManager.OnIndividuationCallBack onIndividuationCallBack) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        new f0().n(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new z(onIndividuationCallBack), new a(onIndividuationCallBack));
    }

    public void a(List<String> list, String str, String str2, String str3, a0 a0Var) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
            treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, str);
            HelpShopAppUtil.getInstance();
            treeMap.put("marker", HelpShopAppUtil.sessionExID());
            if (list != null) {
                String jSONString = JSON.toJSONString(list);
                if (j3.a().a("debug_state")) {
                    j3.a().b("title_data", jSONString);
                }
                treeMap.put("data", jSONString);
            } else {
                j3.a().b("title_data", "");
                treeMap.put("data", "");
            }
            treeMap.put("title", str3);
            treeMap.put("tb_title_pic", com.acse.ottn.d.d().f4342n);
            treeMap.put("tb_title_pic_by", com.acse.ottn.d.d().f4343o);
            treeMap.put("new_version", k0.f4675k);
            treeMap.put("coupon_type", s0.a().j(str));
            treeMap.put("genuine_packagename", str2);
            treeMap.put(bi.F, j4.b());
            treeMap.put("current_system_time", System.currentTimeMillis() + "");
            treeMap.put("is_snt", k0.f4675k);
            treeMap.put("version", k0.f4688x);
            treeMap.put("maven_version", e0.f4495f);
            treeMap.put("flow_permission", com.acse.ottn.b.c().a() ? "1" : "0");
            treeMap.put("mobile", j4.b());
            treeMap.put("mobile_version_release", k0.f4689y);
            treeMap.put("lon", j3.a().e("longitude"));
            treeMap.put(com.umeng.analytics.pro.d.C, j3.a().e("latitude"));
            treeMap.put("loca_type", j3.a().e("location_state"));
            treeMap.put("is_open_adb", j4.d(HelpShopAppUtil.getContext()) ? "1" : "0");
            treeMap.put("accession_size", j3.a().c("accession_size") + "");
            treeMap.put("is_ist_xp", j3.a().a("xposed_state") ? "1" : "0");
            treeMap.put("is_debug", "0");
            treeMap.put("is_developermode_enabled", j4.e(HelpShopAppUtil.getContext()) ? "1" : "0");
            if (list != null) {
                c2.a(f4792b, "getCouponInfo string =" + JSON.toJSONString(list));
            }
            new g1().c(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new f(str, a0Var), new g(a0Var));
            return;
        }
        c2.a(f4792b, "isShowConpunInfor is " + k0.f4669e);
    }

    public static void a(a0 a0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("secret", "abwvAq57vugUhUcTvDAVXWWV1gaqoNQA");
        new g1().e(RequestBody.create(MediaType.parse("application/json,utf-8"), JSON.toJSONString(treeMap))).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new j(a0Var), new l(a0Var));
    }

    public static void a(String str, String str2, a0 a0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("secret", "abwvAq57vugUhUcTvDAVXWWV1gaqoNQA");
        treeMap.put("password", str);
        treeMap.put("state", str2);
        new g1().k(RequestBody.create(MediaType.parse("application/json,utf-8"), JSON.toJSONString(treeMap))).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new m(a0Var), new n(a0Var));
    }

    public void a(String str, b0 b0Var) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("limitType", "coupon");
        treeMap.put("is_snt", "0");
        treeMap.put(bi.f40972o, str);
        new f0().i(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).I3(com.acse.ottn.h.a()).u5(new q(b0Var), new r());
    }
}
