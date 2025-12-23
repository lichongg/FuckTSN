package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.r.la;
import com.ss.android.socialbase.downloader.r.wq;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\Downloads\app\classes6.dex */
public class tl {
    private com.ss.android.socialbase.downloader.g.tl ae;
    private ExecutorService av;
    private ExecutorService az;
    private int ch;
    private jy cw;

    /* renamed from: f, reason: collision with root package name */
    private ExecutorService f38769f;

    /* renamed from: g, reason: collision with root package name */
    private ws f38770g;

    /* renamed from: i, reason: collision with root package name */
    private ExecutorService f38771i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f38772j;
    private ExecutorService kt;

    /* renamed from: m, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.g.oq f38774m;
    private ExecutorService mi;
    private g oq;
    private w qv;

    /* renamed from: r, reason: collision with root package name */
    private oq f38775r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f38776s;
    private ExecutorService tj;
    private com.ss.android.socialbase.downloader.g.m tl;
    private wq up;

    /* renamed from: v, reason: collision with root package name */
    private f f38777v;
    private com.ss.android.socialbase.downloader.tl.xt vl;

    /* renamed from: w, reason: collision with root package name */
    private ExecutorService f38778w;
    private la ws;

    /* renamed from: x, reason: collision with root package name */
    private int f38779x;
    private vl xt;
    private List<com.ss.android.socialbase.downloader.r.ws> jy = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private boolean f38768a = true;

    /* renamed from: l, reason: collision with root package name */
    private int f38773l = 1056964607;

    public tl j(com.ss.android.socialbase.downloader.g.oq oqVar) {
        this.f38774m = oqVar;
        return this;
    }

    public com.ss.android.socialbase.downloader.g.m a() {
        return this.tl;
    }

    public ExecutorService ae() {
        return this.av;
    }

    public oq av() {
        return this.f38775r;
    }

    public int az() {
        return this.f38779x;
    }

    public la ch() {
        return this.ws;
    }

    public com.ss.android.socialbase.downloader.g.oq cw() {
        return this.f38774m;
    }

    public f f() {
        return this.f38777v;
    }

    public ExecutorService g() {
        return this.f38778w;
    }

    public Context getContext() {
        return this.f38772j;
    }

    public g i() {
        return this.oq;
    }

    public tl j(com.ss.android.socialbase.downloader.r.ws wsVar) {
        synchronized (this.jy) {
            if (wsVar != null) {
                try {
                    if (!this.jy.contains(wsVar)) {
                        this.jy.add(wsVar);
                        return this;
                    }
                } finally {
                }
            }
            return this;
        }
    }

    public ExecutorService jy() {
        return this.f38769f;
    }

    public w kt() {
        return this.qv;
    }

    public ae l() {
        return new ae(this);
    }

    public ExecutorService m() {
        return this.az;
    }

    public boolean mi() {
        return this.f38776s;
    }

    public ExecutorService oq() {
        return this.mi;
    }

    public ExecutorService qv() {
        return this.kt;
    }

    public com.ss.android.socialbase.downloader.g.tl r() {
        return this.ae;
    }

    public com.ss.android.socialbase.downloader.tl.xt s() {
        return this.vl;
    }

    public int tj() {
        return this.f38773l;
    }

    public ExecutorService tl() {
        return this.f38771i;
    }

    public ws up() {
        return this.f38770g;
    }

    public boolean v() {
        return this.f38768a;
    }

    public ExecutorService vl() {
        return this.tj;
    }

    public int w() {
        return this.ch;
    }

    public List<com.ss.android.socialbase.downloader.r.ws> ws() {
        return this.jy;
    }

    public wq x() {
        return this.up;
    }

    public jy xt() {
        return this.cw;
    }

    public tl(Context context) {
        this.f38772j = context;
    }

    public tl j(wq wqVar) {
        this.up = wqVar;
        return this;
    }

    public tl j(la laVar) {
        this.ws = laVar;
        return this;
    }

    public vl j() {
        return this.xt;
    }
}
