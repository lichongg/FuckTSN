package com.bytedance.sdk.component.cw.xt;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes4.dex */
final class ch implements up {
    final s cw;

    /* renamed from: j, reason: collision with root package name */
    final v f26122j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f26123m;

    /* renamed from: r, reason: collision with root package name */
    final boolean f26124r;
    private av up;
    final com.bytedance.sdk.component.cw.xt.j.cw.oq xt;

    final class j extends com.bytedance.sdk.component.cw.xt.j.xt {
        private final m cw;

        @Override // com.bytedance.sdk.component.cw.xt.j.xt
        protected void cw() {
            p g6;
            l lVar;
            boolean z5 = false;
            try {
                try {
                    try {
                        s sVar = ch.this.cw;
                        if (sVar != null && (lVar = sVar.f26363m) != null) {
                            lVar.j();
                        }
                        g6 = ch.this.g();
                    } catch (Exception e6) {
                        ch.this.up.j(ch.this, new IOException(e6));
                        this.cw.j(ch.this, new IOException(e6));
                    }
                } catch (Throwable th) {
                    ch.this.f26122j.mi().xt(this);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
            try {
                if (ch.this.xt.xt()) {
                    this.cw.j(ch.this, new IOException("Canceled"));
                } else {
                    this.cw.j(ch.this, g6);
                }
                if (g6.cw == 0) {
                    throw new IOException(g6.f26345r);
                }
            } catch (IOException e8) {
                e = e8;
                z5 = true;
                if (z5) {
                    com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j(4, "Callback failure for " + ch.this.ae(), e);
                } else {
                    ch.this.up.j(ch.this, e);
                    this.cw.j(ch.this, e);
                }
                ch.this.f26122j.mi().xt(this);
            }
            ch.this.f26122j.mi().xt(this);
        }

        j(m mVar) {
            super("OkHttp %s", ch.this.tl());
            this.cw = mVar;
        }

        String j() {
            return ch.this.cw.j().ae();
        }

        public void xt() {
            l lVar;
            s sVar = ch.this.cw;
            if (sVar == null || (lVar = sVar.f26363m) == null) {
                return;
            }
            lVar.qv();
        }
    }

    @Override // com.bytedance.sdk.component.cw.xt.up
    public p xt() throws IOException {
        synchronized (this) {
            if (this.f26123m) {
                throw new IllegalStateException("Already Executed");
            }
            this.f26123m = true;
        }
        oq();
        try {
            try {
                l lVar = this.cw.f26363m;
                if (lVar != null) {
                    lVar.j();
                }
                this.f26122j.mi().j(this);
                p g6 = g();
                if (g6 == null) {
                    throw new IOException("Canceled");
                }
                if (g6.cw == 0) {
                    throw new IOException(g6.f26345r);
                }
                this.f26122j.mi().xt(this);
                return g6;
            } catch (IOException e6) {
                this.up.j(this, e6);
                this.f26122j.mi().xt(this);
                return null;
            } catch (Exception e7) {
                this.up.j(this, new IOException(e7));
                this.f26122j.mi().xt(this);
                return null;
            }
        } catch (Throwable th) {
            this.f26122j.mi().xt(this);
            throw th;
        }
    }

    static ch j(v vVar, s sVar, boolean z5) {
        ch chVar = new ch(vVar, sVar, z5);
        chVar.up = vVar.x().j(chVar);
        return chVar;
    }

    String ae() {
        StringBuilder sb = new StringBuilder();
        sb.append(r() ? "canceled " : "");
        sb.append(this.f26124r ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(tl());
        return sb.toString();
    }

    @Override // com.bytedance.sdk.component.cw.xt.up
    public void cw() {
        this.xt.j();
    }

    p g() throws IOException {
        ArrayList arrayList = new ArrayList(this.f26122j.f());
        arrayList.add(this.xt);
        arrayList.add(new com.bytedance.sdk.component.cw.xt.j.cw.j(this.f26122j.m()));
        arrayList.add(new com.bytedance.sdk.component.cw.xt.j.j.j(this.f26122j.ae()));
        arrayList.add(new com.bytedance.sdk.component.cw.xt.j.xt.j(this.f26122j));
        if (!this.f26124r) {
            arrayList.addAll(this.f26122j.v());
        }
        arrayList.add(new com.bytedance.sdk.component.cw.xt.j.cw.xt(this.f26124r));
        return new com.bytedance.sdk.component.cw.xt.j.cw.ae(arrayList, null, null, null, 0, this.cw, this, this.up, this.f26122j.j(), this.f26122j.xt(), this.f26122j.cw()).j(this.cw);
    }

    @Override // com.bytedance.sdk.component.cw.xt.up
    /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public ch up() {
        return j(this.f26122j, this.cw, this.f26124r);
    }

    @Override // com.bytedance.sdk.component.cw.xt.up
    public boolean r() {
        return this.xt.xt();
    }

    String tl() {
        return this.cw.j().jy();
    }

    private ch(v vVar, s sVar, boolean z5) {
        this.f26122j = vVar;
        this.cw = sVar;
        this.f26124r = z5;
        this.xt = new com.bytedance.sdk.component.cw.xt.j.cw.oq(vVar, z5);
    }

    private void oq() {
        this.xt.j(com.bytedance.sdk.component.cw.xt.j.ae.up.xt().j("response.body().close()"));
    }

    @Override // com.bytedance.sdk.component.cw.xt.up
    public s j() {
        return this.cw;
    }

    @Override // com.bytedance.sdk.component.cw.xt.up
    public void j(m mVar) {
        try {
            synchronized (this) {
                if (!this.f26123m) {
                    this.f26123m = true;
                } else {
                    throw new IllegalStateException("Already Executed");
                }
            }
            oq();
            this.f26122j.mi().j(new j(mVar));
        } catch (Throwable th) {
            if (mVar != null) {
                mVar.j(this, new IOException(th.getMessage()));
            }
        }
    }
}
