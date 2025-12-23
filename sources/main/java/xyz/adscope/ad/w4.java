package xyz.adscope.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.OptimizeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.par.ClickAreaParams;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.optimize.par.SlideParams;
import xyz.adscope.common.v2.tool.roll.RandomProbability;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class w4 {

    /* renamed from: a, reason: collision with root package name */
    private final OptimizeModel f56032a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f56033b;

    /* renamed from: c, reason: collision with root package name */
    private final String f56034c;

    /* renamed from: d, reason: collision with root package name */
    private w2 f56035d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<View> f56036e;

    /* renamed from: f, reason: collision with root package name */
    private f1 f56037f;

    /* renamed from: g, reason: collision with root package name */
    private f1 f56038g;

    /* renamed from: h, reason: collision with root package name */
    private f1 f56039h;

    /* renamed from: i, reason: collision with root package name */
    private f1 f56040i;

    /* renamed from: j, reason: collision with root package name */
    private n3 f56041j;

    /* renamed from: k, reason: collision with root package name */
    private final Handler f56042k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f56043a;

        a(View view) {
            this.f56043a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f56043a.getContext();
            if (context == null || !(this.f56043a instanceof ViewGroup)) {
                return;
            }
            w4 w4Var = w4.this;
            w4Var.f56038g = w4Var.b(context);
            if (w4.this.f56038g != null) {
                w4 w4Var2 = w4.this;
                w4Var2.a("opt", w4Var2.f56038g);
                w4.this.f56038g.a();
            }
            w4 w4Var3 = w4.this;
            w4Var3.f56037f = w4Var3.c(context);
            if (w4.this.f56037f != null) {
                w4 w4Var4 = w4.this;
                w4Var4.a("opts", w4Var4.f56037f);
                w4.this.f56037f.a(this.f56043a);
                w4.this.f56037f.a();
            }
            w4 w4Var5 = w4.this;
            w4Var5.f56040i = w4Var5.b();
            if (w4.this.f56040i != null) {
                w4 w4Var6 = w4.this;
                w4Var6.a("optt", w4Var6.f56040i);
                w4.this.f56040i.a(this.f56043a);
                w4.this.f56040i.a();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f56045a;

        b(View view) {
            this.f56045a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f56045a.getContext();
            if (context != null) {
                w4 w4Var = w4.this;
                w4Var.f56039h = w4Var.a(context);
                if (w4.this.f56039h != null) {
                    w4 w4Var2 = w4.this;
                    w4Var2.a("opt", w4Var2.f56039h);
                    w4.this.f56039h.a(this.f56045a);
                    w4.this.f56039h.a();
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w4.this.f56037f != null) {
                w4.this.f56037f.d();
            }
            if (w4.this.f56039h != null) {
                w4.this.f56039h.d();
            }
            if (w4.this.f56038g != null) {
                w4.this.f56038g.d();
            }
            if (w4.this.f56040i != null) {
                w4.this.f56040i.d();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w4.this.f56039h != null) {
                w4.this.f56039h.b();
            }
            if (w4.this.f56037f != null) {
                w4.this.f56037f.b();
            }
        }
    }

    void e() {
        this.f56042k.post(new c());
    }

    w4(@NonNull Context context, String str, @NonNull OptimizeModel optimizeModel) {
        this.f56033b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f56034c = str;
        this.f56032a = optimizeModel;
        this.f56042k = new Handler(context.getMainLooper());
    }

    public f1 b() {
        boolean roll = RandomProbability.roll(this.f56032a.e());
        boolean roll2 = RandomProbability.roll(this.f56032a.c());
        if (roll || roll2) {
            return new z6(this.f56033b, this.f56032a, roll, roll2);
        }
        return null;
    }

    public f1 c(Context context) {
        SlideParams d6 = this.f56032a.d();
        if (d6 == null || !RandomProbability.roll(d6.c())) {
            return null;
        }
        return new s6(context, this.f56032a);
    }

    public void d() {
        f1 f1Var = this.f56037f;
        if (f1Var != null) {
            f1Var.c();
        }
    }

    public f1 a(Context context) {
        ClickAreaParams a6 = this.f56032a.a();
        if (a6 == null || !RandomProbability.roll(a6.e())) {
            return null;
        }
        return new d1(context, this.f56032a);
    }

    public f1 b(Context context) {
        if (!RandomProbability.roll(this.f56032a.b())) {
            return null;
        }
        f1 f1Var = new f1(context, this.f56032a);
        WeakReference<View> weakReference = this.f56036e;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        f1Var.a(this.f56036e.get());
        return f1Var;
    }

    public void c() {
        this.f56042k.post(new d());
    }

    void a(w2 w2Var, Object obj) {
        if (w2Var instanceof f2) {
            this.f56035d = w2Var;
        }
        if ((w2Var instanceof q0) && (obj instanceof View)) {
            this.f56036e = new WeakReference<>((View) obj);
        }
    }

    void a(View view) {
        this.f56042k.post(new a(view));
        this.f56042k.postDelayed(new b(view), a());
    }

    private long a() {
        OptimizeModel optimizeModel = this.f56032a;
        if (optimizeModel == null || optimizeModel.a() == null) {
            return 0L;
        }
        return this.f56032a.a().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, f1 f1Var) {
        i3 a6 = o4.a(this.f56033b, this.f56034c, str, false);
        a6.a((i3) this.f56032a);
        a6.a(f1Var, null);
        a6.a(this.f56035d);
        if (a6 instanceof k2) {
            ((k2) a6).c().a(this.f56041j);
        }
        f1Var.a(a6);
    }

    void a(n3 n3Var) {
        this.f56041j = n3Var;
    }
}
