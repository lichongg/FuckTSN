package xyz.adscope.ad;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.update.UpdateModel;
import xyz.adscope.ad.publish.ASNPInitConfig;
import xyz.adscope.common.v2.encrypt.ILinkedEncrypt;
import xyz.adscope.common.v2.encrypt.LinkedEncryptManager;
import xyz.adscope.common.v2.thread.pool.ScopeThreadPoolManager;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    private ASNPInitConfig f55107c;

    /* renamed from: d, reason: collision with root package name */
    private ConfigResponseModel f55108d;

    /* renamed from: g, reason: collision with root package name */
    private final Context f55111g;

    /* renamed from: h, reason: collision with root package name */
    private j4 f55112h;

    /* renamed from: b, reason: collision with root package name */
    private final Object f55106b = new Object();

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<d3> f55109e = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private final CopyOnWriteArrayList<c3> f55110f = new CopyOnWriteArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    private final o3 f55105a = v.a().b();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum a {
        EXPIRED,
        PREFER_UPDATE,
        VALID
    }

    public j4 b() {
        j4 j4Var = this.f55112h;
        if (j4Var != null) {
            return j4Var.deepCopy();
        }
        return null;
    }

    public long c() {
        j4 j4Var = this.f55112h;
        if (j4Var != null) {
            return j4Var.b();
        }
        return 0L;
    }

    private ConfigResponseModel e() {
        ASNPInitConfig aSNPInitConfig = this.f55107c;
        String decrypt = LinkedEncryptManager.getInstance().getOrCreateImplement(this.f55111g).decrypt((aSNPInitConfig == null || !aSNPInitConfig.isUseHttps()) ? "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" : "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", ILinkedEncrypt.DEFAULT_DEF_CFG_PATTERN, ILinkedEncrypt.B64Model.STEP_BY_STEP, false);
        if (TextUtils.isEmpty(decrypt)) {
            return null;
        }
        ConfigResponseModel configResponseModel = new ConfigResponseModel(JsonUtil.parseJSONObject(decrypt));
        if (configResponseModel.hasParseException()) {
            return null;
        }
        return configResponseModel;
    }

    private void g() {
        if (this.f55111g != null) {
            Application.ActivityLifecycleCallbacks a6 = this.f55105a.a();
            Context context = this.f55111g;
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(a6);
            } else if (context instanceof Activity) {
                ((Activity) context).getApplication().registerActivityLifecycleCallbacks(a6);
            } else if (context instanceof Service) {
                ((Service) context).getApplication().registerActivityLifecycleCallbacks(a6);
            }
        }
    }

    public void a(j4 j4Var) {
        this.f55112h = j4Var;
    }

    public boolean d() {
        return this.f55108d != null;
    }

    public void f() {
        ConfigResponseModel a6;
        String a7 = i0.a(this.f55111g, i0.b(), "asnpConfig", "");
        String a8 = i0.a(this.f55111g, i0.b(), "asnpCfgPattern", "101,1001");
        if (!TextUtils.isEmpty(a7) && !TextUtils.isEmpty(a8)) {
            String decrypt = LinkedEncryptManager.getInstance().getOrCreateImplement(this.f55111g).decrypt(a7, a8, ILinkedEncrypt.B64Model.STEP_BY_STEP, false);
            if (!TextUtils.isEmpty(decrypt) && (a6 = a(decrypt)) != null) {
                a(a6, false, false);
                return;
            }
        }
        ConfigResponseModel e6 = e();
        if (e6 != null) {
            a(e6, false, true);
        }
    }

    public void h() {
        CopyOnWriteArrayList<c3> copyOnWriteArrayList = this.f55110f;
        if (copyOnWriteArrayList != null) {
            Iterator<c3> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    e(Context context) {
        this.f55111g = StubApp.getOrigApplicationContext(context.getApplicationContext());
        g();
    }

    private void b(final boolean z5) {
        final long currentTimeMillis = System.currentTimeMillis();
        ScopeThreadPoolManager.getInstance().getOrCreateImplement(this.f55111g).executeBasicAsyncTask(new Runnable() { // from class: xyz.adscope.ad.h7
            @Override // java.lang.Runnable
            public final void run() {
                e.this.a(currentTimeMillis, z5);
            }
        });
    }

    public ASNPInitConfig a() {
        return this.f55107c;
    }

    public boolean c(long j6) {
        if (this.f55108d != null) {
            long a6 = i0.a(this.f55111g, i0.b(), "asnpConfigLast", 0L);
            UpdateModel n6 = this.f55108d.n();
            if (n6 != null) {
                long j7 = j6 - a6;
                if (j7 > n6.b() && j7 < n6.c()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(ASNPInitConfig aSNPInitConfig) {
        this.f55107c = aSNPInitConfig;
    }

    public ConfigResponseModel a(boolean z5) {
        ConfigResponseModel configResponseModel;
        if (z5 && (configResponseModel = this.f55108d) != null) {
            return configResponseModel.deepCopy();
        }
        return this.f55108d;
    }

    public boolean b(long j6) {
        if (this.f55108d != null) {
            long a6 = i0.a(this.f55111g, i0.b(), "asnpConfigLast", 0L);
            UpdateModel n6 = this.f55108d.n();
            if (n6 != null && j6 - a6 > n6.c()) {
                return true;
            }
        }
        return false;
    }

    public void a(ConfigResponseModel configResponseModel, boolean z5, boolean z6) {
        ConfigResponseModel configResponseModel2 = this.f55108d;
        if (configResponseModel2 == null) {
            a(configResponseModel);
            if (z6) {
                return;
            }
            b(z5);
            return;
        }
        if (z5) {
            a(configResponseModel2.a(configResponseModel));
            b(true);
        }
    }

    private void a(ConfigResponseModel configResponseModel) {
        synchronized (this.f55106b) {
            this.f55108d = configResponseModel;
        }
    }

    private ConfigResponseModel a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConfigResponseModel configResponseModel = new ConfigResponseModel(JsonUtil.parseJSONObject(str));
        if (configResponseModel.hasParseException()) {
            return null;
        }
        return configResponseModel;
    }

    public void a(d3 d3Var) {
        this.f55109e.add(d3Var);
    }

    public void a(c3 c3Var) {
        CopyOnWriteArrayList<c3> copyOnWriteArrayList = this.f55110f;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.contains(c3Var)) {
            return;
        }
        this.f55110f.add(c3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(long j6, boolean z5) {
        a a6 = a(j6);
        CopyOnWriteArrayList<d3> copyOnWriteArrayList = this.f55109e;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        Iterator<d3> it = this.f55109e.iterator();
        while (it.hasNext()) {
            it.next().a(this.f55108d, a6, z5);
        }
    }

    public a a(long j6) {
        return b(j6) ? c(j6) ? a.PREFER_UPDATE : a.EXPIRED : a.VALID;
    }
}
