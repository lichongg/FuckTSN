package com.ss.android.socialbase.downloader.g.j;

import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.up;
import com.ss.android.socialbase.downloader.g.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class r implements g {
    private g cw;

    /* renamed from: j, reason: collision with root package name */
    protected final Object f38809j;

    /* renamed from: m, reason: collision with root package name */
    private InputStream f38810m;

    /* renamed from: r, reason: collision with root package name */
    private boolean f38811r;
    private long up;
    private final List<up> xt;

    public boolean ae() {
        try {
            g gVar = this.cw;
            if (gVar != null) {
                if (j(gVar.xt())) {
                    return true;
                }
            }
            return false;
        } catch (IOException e6) {
            vl.j(e6);
            return false;
        }
    }

    public boolean j(int i6) {
        return i6 >= 200 && i6 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.g.ae
    public void cw() {
        g gVar = this.cw;
        if (gVar != null) {
            gVar.cw();
        }
    }

    @Override // com.ss.android.socialbase.downloader.g.g
    public InputStream j() throws IOException {
        InputStream inputStream = this.f38810m;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public List<up> m() {
        return this.xt;
    }

    @Override // com.ss.android.socialbase.downloader.g.g
    public void r() {
        g gVar = this.cw;
        if (gVar != null) {
            gVar.r();
        }
    }

    public void up() throws InterruptedException {
        synchronized (this.f38809j) {
            try {
                if (this.f38811r && this.cw == null) {
                    this.f38809j.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.g.ae
    public int xt() throws IOException {
        g gVar = this.cw;
        if (gVar != null) {
            return gVar.xt();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.g.ae
    public String j(String str) {
        g gVar = this.cw;
        if (gVar != null) {
            return gVar.j(str);
        }
        return null;
    }

    public boolean tl() {
        if (System.currentTimeMillis() - this.up < xt.f38812j) {
            return true;
        }
        return false;
    }
}
