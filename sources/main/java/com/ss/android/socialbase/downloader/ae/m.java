package com.ss.android.socialbase.downloader.ae;

import android.text.TextUtils;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes6.dex */
public class m {
    public final int cw;

    /* renamed from: j, reason: collision with root package name */
    public final String f38619j;

    /* renamed from: r, reason: collision with root package name */
    private long f38620r;
    private long up;
    public final com.ss.android.socialbase.downloader.g.ae xt;

    public String ae() {
        return com.ss.android.socialbase.downloader.az.m.xt(this.xt, "Cache-Control");
    }

    public String cw() {
        return this.xt.j("Etag");
    }

    public boolean g() {
        return com.ss.android.socialbase.downloader.az.j.j(8) ? com.ss.android.socialbase.downloader.az.m.cw(this.xt) : com.ss.android.socialbase.downloader.az.m.xt(tl());
    }

    public boolean j() {
        return com.ss.android.socialbase.downloader.az.m.cw(this.cw);
    }

    public String m() {
        String xt = com.ss.android.socialbase.downloader.az.m.xt(this.xt, "last-modified");
        return TextUtils.isEmpty(xt) ? com.ss.android.socialbase.downloader.az.m.xt(this.xt, "Last-Modified") : xt;
    }

    public long oq() {
        if (this.up <= 0) {
            if (g()) {
                this.up = -1L;
            } else {
                String up = up();
                if (!TextUtils.isEmpty(up)) {
                    this.up = com.ss.android.socialbase.downloader.az.m.xt(up);
                }
            }
        }
        return this.up;
    }

    public String r() {
        return this.xt.j("Content-Type");
    }

    public long tl() {
        if (this.f38620r <= 0) {
            this.f38620r = com.ss.android.socialbase.downloader.az.m.j(this.xt);
        }
        return this.f38620r;
    }

    public String up() {
        return com.ss.android.socialbase.downloader.az.m.xt(this.xt, "Content-Range");
    }

    public boolean xt() {
        return com.ss.android.socialbase.downloader.az.m.j(this.cw, this.xt.j("Accept-Ranges"));
    }

    public m(String str, com.ss.android.socialbase.downloader.g.ae aeVar) throws IOException {
        this.f38619j = str;
        this.cw = aeVar.xt();
        this.xt = aeVar;
    }

    public long qv() {
        return com.ss.android.socialbase.downloader.az.m.g(ae());
    }
}
