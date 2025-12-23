package com.ss.android.socialbase.appdownloader.m.j;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\Downloads\app\classes6.dex */
class c implements b {

    /* renamed from: b, reason: collision with root package name */
    private e f38502b;

    /* renamed from: d, reason: collision with root package name */
    private d f38504d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f38505e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f38507g;

    /* renamed from: h, reason: collision with root package name */
    private int f38508h;

    /* renamed from: i, reason: collision with root package name */
    private int f38509i;

    /* renamed from: j, reason: collision with root package name */
    private int f38510j;

    /* renamed from: k, reason: collision with root package name */
    private int f38511k;

    /* renamed from: l, reason: collision with root package name */
    private int[] f38512l;

    /* renamed from: m, reason: collision with root package name */
    private int f38513m;

    /* renamed from: n, reason: collision with root package name */
    private int f38514n;

    /* renamed from: o, reason: collision with root package name */
    private int f38515o;

    /* renamed from: c, reason: collision with root package name */
    private boolean f38503c = false;

    /* renamed from: f, reason: collision with root package name */
    private a f38506f = new a();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int[] f38516a = new int[32];

        /* renamed from: b, reason: collision with root package name */
        private int f38517b;

        /* renamed from: c, reason: collision with root package name */
        private int f38518c;

        public final void b() {
            this.f38517b = 0;
            this.f38518c = 0;
        }

        public final void g() {
            c(2);
            int i6 = this.f38517b;
            int[] iArr = this.f38516a;
            iArr[i6] = 0;
            iArr[i6 + 1] = 0;
            this.f38517b = i6 + 2;
            this.f38518c++;
        }

        private void c(int i6) {
            int[] iArr = this.f38516a;
            int length = iArr.length;
            int i7 = this.f38517b;
            int i8 = length - i7;
            if (i8 <= i6) {
                int[] iArr2 = new int[(iArr.length + i8) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i7);
                this.f38516a = iArr2;
            }
        }

        public final boolean a() {
            int[] iArr;
            int i6;
            int i7 = this.f38517b;
            if (i7 == 0 || (i6 = (iArr = this.f38516a)[i7 - 1]) == 0) {
                return false;
            }
            int i8 = i6 - 1;
            int i9 = i7 - 3;
            iArr[i9] = i8;
            iArr[i9 - ((i8 * 2) + 1)] = i8;
            this.f38517b = i7 - 2;
            return true;
        }

        public final void d(int i6, int i7) {
            if (this.f38518c == 0) {
                g();
            }
            c(2);
            int i8 = this.f38517b;
            int i9 = i8 - 1;
            int[] iArr = this.f38516a;
            int i10 = iArr[i9];
            int i11 = (i8 - 2) - (i10 * 2);
            int i12 = i10 + 1;
            iArr[i11] = i12;
            iArr[i9] = i6;
            iArr[i8] = i7;
            iArr[i8 + 1] = i12;
            this.f38517b = i8 + 2;
        }

        public final void e() {
            int i6 = this.f38517b;
            if (i6 != 0) {
                int i7 = this.f38516a[i6 - 1] * 2;
                if ((i6 - 2) - i7 != 0) {
                    this.f38517b = i6 - (i7 + 2);
                    this.f38518c--;
                }
            }
        }

        public final int f() {
            return this.f38518c;
        }

        public final int h() {
            int i6 = this.f38517b;
            if (i6 == 0) {
                return 0;
            }
            return this.f38516a[i6 - 1];
        }
    }

    private final void a() {
        this.f38508h = -1;
        this.f38509i = -1;
        this.f38510j = -1;
        this.f38511k = -1;
        this.f38512l = null;
        this.f38513m = -1;
        this.f38514n = -1;
        this.f38515o = -1;
    }

    @Override // com.ss.android.socialbase.appdownloader.m.j.a
    public int m() {
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0182, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r5 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void g() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.m.j.c.g():void");
    }

    private final int i(int i6) {
        if (this.f38508h != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i7 = i6 * 5;
        if (i7 < this.f38512l.length) {
            return i7;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i6 + ").");
    }

    @Override // com.ss.android.socialbase.appdownloader.m.j.a
    public int cw() {
        return this.f38509i;
    }

    public void d() {
        if (this.f38503c) {
            this.f38503c = false;
            this.f38502b.d();
            this.f38502b = null;
            this.f38504d = null;
            this.f38505e = null;
            this.f38506f.b();
            a();
        }
    }

    public int h() {
        if (this.f38508h != 2) {
            return -1;
        }
        return this.f38512l.length / 5;
    }

    public int j() throws tl, IOException {
        if (this.f38502b == null) {
            throw new tl("Parser is not opened.", this, null);
        }
        try {
            g();
            return this.f38508h;
        } catch (IOException e6) {
            d();
            throw e6;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.m.j.a
    public String r() {
        return "XML line #" + cw();
    }

    public c() {
        a();
    }

    public int b(int i6) {
        return this.f38512l[i(i6) + 4];
    }

    public String c(int i6) {
        int i7 = this.f38512l[i(i6) + 1];
        if (i7 == -1) {
            return "";
        }
        return this.f38504d.c(i7);
    }

    public void e(InputStream inputStream) {
        d();
        if (inputStream != null) {
            this.f38502b = new e(inputStream, false);
        }
    }

    public String f(int i6) {
        int i7 = i(i6);
        int[] iArr = this.f38512l;
        if (iArr[i7 + 3] == 3) {
            return this.f38504d.c(iArr[i7 + 2]);
        }
        return "";
    }

    public int k(int i6) {
        return this.f38512l[i(i6) + 3];
    }
}
