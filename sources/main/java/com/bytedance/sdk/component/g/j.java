package com.bytedance.sdk.component.g;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.g.cw.ae;
import com.bytedance.sdk.component.g.cw.m;
import com.bytedance.sdk.component.g.r.cw;
import com.bytedance.sdk.component.g.xt.cw;
import com.bytedance.sdk.component.g.xt.up;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.xt.j.g;
import com.bytedance.sdk.component.xt.j.vl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private vl f26440j;
    private m xt;

    /* renamed from: com.bytedance.sdk.component.g.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: com.bytedance.sdk.component.g.j$j, reason: collision with other inner class name */
    public static final class C0409j {
        private Bundle ae;

        /* renamed from: m, reason: collision with root package name */
        private Set<String> f26442m;
        private com.bytedance.sdk.component.xt.j.j.j.j tl;

        /* renamed from: r, reason: collision with root package name */
        boolean f26443r = true;
        final List<g> up = new ArrayList();

        /* renamed from: j, reason: collision with root package name */
        int f26441j = 10000;
        int xt = 10000;
        int cw = 10000;

        public C0409j cw(long j6, TimeUnit timeUnit) {
            this.cw = j("timeout", j6, timeUnit);
            return this;
        }

        public C0409j j(long j6, TimeUnit timeUnit) {
            this.f26441j = j("timeout", j6, timeUnit);
            return this;
        }

        public C0409j xt(long j6, TimeUnit timeUnit) {
            this.xt = j("timeout", j6, timeUnit);
            return this;
        }

        public C0409j j(boolean z5) {
            this.f26443r = z5;
            return this;
        }

        public C0409j j(g gVar) {
            this.up.add(gVar);
            return this;
        }

        public C0409j j(Set<String> set) {
            this.f26442m = set;
            return this;
        }

        private static int j(String str, long j6, TimeUnit timeUnit) {
            if (j6 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j6);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                }
                if (millis != 0 || j6 <= 0) {
                    return (int) millis;
                }
                throw new IllegalArgumentException(str + " too small.");
            }
            throw new NullPointerException("unit == null");
        }

        public j j() {
            return new j(this, null);
        }
    }

    /* synthetic */ j(C0409j c0409j, AnonymousClass1 anonymousClass1) {
        this(c0409j);
    }

    public void j(Context context, boolean z5, com.bytedance.sdk.component.g.cw.xt xtVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (xtVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int j6 = xtVar.j();
        this.cw = j6;
        m mVar = this.xt;
        if (mVar != null) {
            mVar.j(j6);
        }
        ae.j().j(this.cw).j(z5);
        ae.j().j(this.cw).j(xtVar);
        ae.j().j(this.cw).j(context, i.j(context));
    }

    private j(C0409j c0409j) {
        vl.j jVar = new vl.j();
        long j6 = c0409j.f26441j;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        vl.j xt = jVar.j(j6, timeUnit).cw(c0409j.cw, timeUnit).xt(c0409j.xt, timeUnit);
        if (c0409j.f26443r) {
            m mVar = new m();
            this.xt = mVar;
            xt.j(mVar);
        }
        List<g> list = c0409j.up;
        if (list != null && list.size() > 0) {
            Iterator<g> it = c0409j.up.iterator();
            while (it.hasNext()) {
                xt.j(it.next());
            }
        }
        if (c0409j.ae != null) {
            xt.j(c0409j.ae);
        }
        xt.j(c0409j.f26442m);
        if (c0409j.tl == null) {
            xt.j(new com.bytedance.sdk.component.xt.j.j.j.xt());
        } else {
            xt.j(c0409j.tl);
        }
        this.f26440j = xt.j();
    }

    public cw cw() {
        return new cw(this.f26440j);
    }

    public vl m() {
        return this.f26440j;
    }

    public com.bytedance.sdk.component.g.xt.xt r() {
        return new com.bytedance.sdk.component.g.xt.xt(this.f26440j);
    }

    public com.bytedance.sdk.component.g.xt.j up() {
        return new com.bytedance.sdk.component.g.xt.j(this.f26440j);
    }

    public up xt() {
        return new up(this.f26440j);
    }

    public void j(Context context, boolean z5) {
        com.bytedance.sdk.component.g.cw.j.xt(true);
        if (j(context) || (!i.j(context) && z5)) {
            ae.j().j(this.cw, context).r();
            ae.j().j(this.cw, context).j();
        }
        if (i.j(context)) {
            ae.j().j(this.cw, context).r();
            ae.j().j(this.cw, context).j();
        }
    }

    public static void j() {
        com.bytedance.sdk.component.g.r.cw.j(cw.j.DEBUG);
    }

    private static boolean j(Context context) {
        String xt = i.xt(context);
        if (xt != null) {
            return xt.endsWith(":push") || xt.endsWith(":pushservice");
        }
        return false;
    }
}
