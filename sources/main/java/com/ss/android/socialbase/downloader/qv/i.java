package com.ss.android.socialbase.downloader.qv;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes6.dex */
class i {
    private boolean ae;
    final String cw;

    /* renamed from: g, reason: collision with root package name */
    private String f38917g;

    /* renamed from: j, reason: collision with root package name */
    final String f38918j;

    /* renamed from: m, reason: collision with root package name */
    private int f38919m;
    private final AtomicLong oq;

    /* renamed from: r, reason: collision with root package name */
    final boolean f38920r;
    private int tl;
    private final List<jy> up;
    final String xt;

    public i(String str, boolean z5) {
        this.up = new ArrayList();
        this.oq = new AtomicLong();
        this.f38918j = str;
        this.f38920r = z5;
        this.xt = null;
        this.cw = null;
    }

    private String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return null;
        }
    }

    public synchronized void cw() {
        this.ae = false;
    }

    public synchronized boolean r() {
        return this.ae;
    }

    public synchronized void xt(jy jyVar) {
        try {
            this.up.remove(jyVar);
        } catch (Throwable unused) {
        }
    }

    private String up() {
        if (this.f38917g == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f38918j);
            sb.append("_");
            String str = this.xt;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.f38920r);
            this.f38917g = sb.toString();
        }
        return this.f38917g;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            return up().equals(((i) obj).up());
        }
        return false;
    }

    public int hashCode() {
        if (this.tl == 0) {
            this.tl = up().hashCode();
        }
        return this.tl;
    }

    public String toString() {
        return "UrlRecord{url='" + this.f38918j + "', ip='" + this.xt + "', ipFamily='" + this.cw + "', isMainUrl=" + this.f38920r + ", failedTimes=" + this.f38919m + ", isCurrentFailed=" + this.ae + '}';
    }

    public synchronized void xt() {
        this.f38919m++;
        this.ae = true;
    }

    public synchronized void j(jy jyVar) {
        this.up.add(jyVar);
    }

    public i(String str, String str2) {
        this.up = new ArrayList();
        this.oq = new AtomicLong();
        this.f38918j = str;
        this.f38920r = false;
        this.xt = str2;
        this.cw = j(str2);
    }

    public synchronized int j() {
        return this.up.size();
    }

    public void j(long j6) {
        this.oq.addAndGet(j6);
    }
}
