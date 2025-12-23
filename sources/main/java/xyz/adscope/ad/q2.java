package xyz.adscope.ad;

import android.content.Context;
import com.stub.StubApp;
import xyz.adscope.ad.e;
import xyz.adscope.ad.model.impl.resp.cfg.root.ConfigResponseModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public abstract class q2 implements q3 {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f55897a;

    /* renamed from: b, reason: collision with root package name */
    private final b f55898b = new b(this, null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b implements d3 {
        /* synthetic */ b(q2 q2Var, a aVar) {
            this();
        }

        private b() {
        }

        @Override // xyz.adscope.ad.d3
        public void a(ConfigResponseModel configResponseModel, e.a aVar, boolean z5) {
            if (aVar != e.a.EXPIRED) {
                q2.this.a(configResponseModel, aVar);
            }
        }
    }

    @Override // xyz.adscope.ad.q3
    public final void a() {
        e orCreateImplement = f.a().getOrCreateImplement(this.f55897a);
        if (orCreateImplement != null) {
            orCreateImplement.a(this.f55898b);
        }
    }

    protected abstract void a(ConfigResponseModel configResponseModel, e.a aVar);

    public q2(Context context) {
        this.f55897a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }
}
