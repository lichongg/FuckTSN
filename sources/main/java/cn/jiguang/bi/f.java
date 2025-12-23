package cn.jiguang.bi;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Context f2232a;

    /* renamed from: b, reason: collision with root package name */
    private cn.jiguang.bm.a f2233b;

    /* renamed from: c, reason: collision with root package name */
    private long f2234c;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final f f2236a = new f();
    }

    private f() {
        this.f2233b = new cn.jiguang.bm.a() { // from class: cn.jiguang.bi.f.1
            @Override // cn.jiguang.bm.a
            public void a(Message message) {
                cn.jiguang.bb.f.c("PeriodWorker", "time is up, next period=" + (g.a().g() * 1000));
                f fVar = f.this;
                fVar.c(fVar.f2232a);
            }
        };
        this.f2232a = cn.jiguang.bz.d.a();
    }

    public void b() {
        this.f2234c = SystemClock.elapsedRealtime();
        cn.jiguang.bi.a.a(this.f2232a);
        cn.jiguang.bm.b.a().a(AVMDLDataLoader.KeyIsLiveSetLoaderType, g.a().f() * 1000, this.f2233b);
    }

    public static f a() {
        return a.f2236a;
    }

    private void b(Context context) {
        this.f2234c = SystemClock.elapsedRealtime();
        if (((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.af())).booleanValue()) {
            cn.jiguang.bi.a.a(context);
        } else {
            cn.jiguang.bi.a.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        cn.jiguang.bb.f.c("PeriodWorker", "periodTask...");
        if (cn.jiguang.ba.h.b()) {
            cn.jiguang.bb.f.d("PeriodWorker", "[key-step]Your sdk is disabled already, no receiver task can be handled.");
            return;
        }
        b(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("force", false);
        bundle.putLong("delay_time", 0L);
        a(context, false);
        g.a().a(bundle);
        b.a().a(context, 19, 0, "periodTask");
        cn.jiguang.v.a.a(context, "periodtask", null);
    }

    public void a(Context context) {
        this.f2232a = cn.jiguang.bz.d.a(context);
        cn.jiguang.bm.b.a().a(AVMDLDataLoader.KeyIsLiveSetLoaderType, g.a().f() * 1000, this.f2233b);
    }

    public void a(Context context, boolean z5) {
        cn.jiguang.bb.f.f("PeriodWorker", "PeriodWorker resume");
        if (this.f2234c > 0 && SystemClock.elapsedRealtime() > this.f2234c + ((g.a().f() + 5) * 1000)) {
            cn.jiguang.bb.f.f("PeriodWorker", "schedule time is expired, execute now");
            a(context);
            c(context);
        } else if (!z5) {
            cn.jiguang.bb.f.c("PeriodWorker", "need not change period task");
        } else {
            a(context);
            b(context);
        }
    }
}
