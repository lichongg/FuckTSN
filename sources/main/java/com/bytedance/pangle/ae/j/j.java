package com.bytedance.pangle.ae.j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes3.dex */
class j {
    private boolean ae;

    /* renamed from: g, reason: collision with root package name */
    private int[] f25378g;

    /* renamed from: m, reason: collision with root package name */
    private int f25380m;
    private m qv;
    private xt tl;
    private boolean oq = false;
    private final cw vl = new cw();

    /* renamed from: j, reason: collision with root package name */
    int f25379j = 0;
    int xt = 1;
    int cw = 2;

    /* renamed from: r, reason: collision with root package name */
    int f25381r = 3;
    int up = 4;

    private int up(int i6) {
        if (this.f25380m != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i7 = i6 * 5;
        if (i7 < this.f25378g.length) {
            return i7;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i6 + ").");
    }

    public int cw() {
        if (this.f25380m != 2) {
            return -1;
        }
        return this.f25378g.length / 5;
    }

    public void j(InputStream inputStream) {
        j();
        if (inputStream != null) {
            this.tl = new xt(inputStream);
        }
    }

    public String r(int i6) {
        int up = up(i6);
        int[] iArr = this.f25378g;
        if (iArr[up + 3] != 3) {
            return "";
        }
        return this.qv.j(iArr[up + 2]);
    }

    public int xt() throws IOException {
        try {
            if (this.tl == null) {
                throw new IOException("Parser is not opened.");
            }
            up();
            return this.f25380m;
        } catch (IOException e6) {
            j();
            throw e6;
        }
    }

    public int cw(int i6) {
        return this.f25378g[up(i6) + 4];
    }

    public j() {
        r();
    }

    public void j() {
        if (this.oq) {
            this.oq = false;
            this.tl.j();
            this.qv = null;
            this.tl = null;
            this.vl.j();
            r();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x016d, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void up() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.ae.j.j.up():void");
    }

    private void r() {
        this.f25378g = null;
        this.f25380m = -1;
    }

    public int xt(int i6) {
        return this.f25378g[up(i6) + 3];
    }

    public String j(int i6) {
        int i7 = this.f25378g[up(i6) + 1];
        return i7 == -1 ? "" : this.qv.j(i7);
    }
}
