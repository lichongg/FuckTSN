package com.bytedance.pangle.res.j;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    private int[] av;
    private int az;

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f25485g;

    /* renamed from: i, reason: collision with root package name */
    private int f25486i;
    private ae oq;
    private final tl tl;
    private int[] vl;
    private boolean ws;

    /* renamed from: j, reason: collision with root package name */
    HashMap<Integer, Integer> f25487j = new HashMap<>();
    boolean xt = false;
    private boolean qv = false;
    private final j jy = new j();
    int cw = 0;

    /* renamed from: r, reason: collision with root package name */
    int f25489r = 1;
    int up = 2;

    /* renamed from: m, reason: collision with root package name */
    int f25488m = 3;
    int ae = 4;

    private static final class j {
        private int cw;

        /* renamed from: j, reason: collision with root package name */
        private int[] f25490j = new int[32];
        private int xt;

        public void j() {
            this.xt = 0;
            this.cw = 0;
        }

        public void up() {
            j(2);
            int i6 = this.xt;
            int[] iArr = this.f25490j;
            iArr[i6] = 0;
            iArr[i6 + 1] = 0;
            this.xt = i6 + 2;
            this.cw++;
        }

        public boolean cw() {
            int[] iArr;
            int i6;
            int i7 = this.xt;
            if (i7 == 0 || (i6 = (iArr = this.f25490j)[i7 - 1]) == 0) {
                return false;
            }
            int i8 = i6 - 1;
            int i9 = i7 - 3;
            iArr[i9] = i8;
            iArr[i9 - ((i8 * 2) + 1)] = i8;
            this.xt = i7 - 2;
            return true;
        }

        public void m() {
            int i6 = this.xt;
            if (i6 == 0) {
                return;
            }
            int i7 = this.f25490j[i6 - 1] * 2;
            if ((i6 - 2) - i7 == 0) {
                return;
            }
            this.xt = i6 - (i7 + 2);
            this.cw--;
        }

        public int r() {
            return this.cw;
        }

        public int xt() {
            int i6 = this.xt;
            if (i6 == 0) {
                return 0;
            }
            return this.f25490j[i6 - 1];
        }

        public void j(int i6, int i7) {
            if (this.cw == 0) {
                up();
            }
            j(2);
            int i8 = this.xt;
            int i9 = i8 - 1;
            int[] iArr = this.f25490j;
            int i10 = iArr[i9];
            int i11 = (i8 - 2) - (i10 * 2);
            int i12 = i10 + 1;
            iArr[i11] = i12;
            iArr[i9] = i6;
            iArr[i8] = i7;
            iArr[i8 + 1] = i12;
            this.xt = i8 + 2;
        }

        private void j(int i6) {
            int[] iArr = this.f25490j;
            int length = iArr.length;
            int i7 = this.xt;
            int i8 = length - i7;
            if (i8 > i6) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i8) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i7);
            this.f25490j = iArr2;
        }
    }

    private void r() {
        this.az = -1;
        this.av = null;
        this.f25486i = -1;
    }

    public void j(InputStream inputStream) {
        j();
        if (inputStream != null) {
            this.oq = new ae(new g(new up(inputStream)));
        }
    }

    public int xt() throws IOException {
        if (this.oq == null) {
            throw new RuntimeException("Parser is not opened.");
        }
        try {
            up();
            return this.az;
        } catch (IOException e6) {
            j();
            throw e6;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x0215, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r2 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void up() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.j.xt.up():void");
    }

    public xt(byte[] bArr, tl tlVar) {
        this.tl = tlVar;
        this.f25485g = bArr;
        r();
    }

    public int cw() throws IOException {
        return xt();
    }

    public void j() {
        if (this.qv) {
            this.qv = false;
            this.oq = null;
            this.vl = null;
            this.jy.j();
            r();
        }
    }

    public void xt(InputStream inputStream) {
        j(inputStream);
    }
}
