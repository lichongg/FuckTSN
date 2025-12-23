package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.p0003l.by;
import com.amap.api.col.p0003l.x0;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class i0 extends b8 implements x0.a {

    /* renamed from: d, reason: collision with root package name */
    private x0 f6457d;

    /* renamed from: e, reason: collision with root package name */
    private z0 f6458e;

    /* renamed from: g, reason: collision with root package name */
    private c1 f6459g;

    /* renamed from: h, reason: collision with root package name */
    private Context f6460h;

    /* renamed from: i, reason: collision with root package name */
    private Bundle f6461i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6462j;

    private i0(c1 c1Var, Context context) {
        this.f6461i = new Bundle();
        this.f6462j = false;
        this.f6459g = c1Var;
        this.f6460h = context;
    }

    public final void a() {
        this.f6462j = true;
        x0 x0Var = this.f6457d;
        if (x0Var != null) {
            x0Var.d();
        } else {
            cancelTask();
        }
        z0 z0Var = this.f6458e;
        if (z0Var != null) {
            z0Var.b();
        }
    }

    private String d() {
        return b3.f0(this.f6460h);
    }

    private void e() throws IOException {
        x0 x0Var = new x0(new y0(this.f6459g.getUrl(), d(), this.f6459g.v(), this.f6459g.w()), this.f6459g.getUrl(), this.f6460h, this.f6459g);
        this.f6457d = x0Var;
        x0Var.c(this);
        c1 c1Var = this.f6459g;
        this.f6458e = new z0(c1Var, c1Var);
        if (this.f6462j) {
            return;
        }
        this.f6457d.a();
    }

    public final void b() {
        Bundle bundle = this.f6461i;
        if (bundle != null) {
            bundle.clear();
            this.f6461i = null;
        }
    }

    @Override // com.amap.api.col.3l.x0.a
    public final void c() {
        z0 z0Var = this.f6458e;
        if (z0Var != null) {
            z0Var.h();
        }
    }

    @Override // com.amap.api.col.p0003l.b8
    public final void runTask() {
        if (this.f6459g.d()) {
            this.f6459g.b(by.a.file_io_exception);
            return;
        }
        try {
            e();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public i0(c1 c1Var, Context context, byte b6) {
        this(c1Var, context);
    }
}
