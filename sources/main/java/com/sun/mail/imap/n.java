package com.sun.mail.imap;

import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class n implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private boolean[] f39377a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        private static a[] f39378b = new a[128];

        /* renamed from: c, reason: collision with root package name */
        public static final a f39379c = a('l');

        /* renamed from: d, reason: collision with root package name */
        public static final a f39380d = a('r');

        /* renamed from: e, reason: collision with root package name */
        public static final a f39381e = a('s');

        /* renamed from: f, reason: collision with root package name */
        public static final a f39382f = a('w');

        /* renamed from: g, reason: collision with root package name */
        public static final a f39383g = a('i');

        /* renamed from: h, reason: collision with root package name */
        public static final a f39384h = a('p');

        /* renamed from: i, reason: collision with root package name */
        public static final a f39385i = a('c');

        /* renamed from: j, reason: collision with root package name */
        public static final a f39386j = a('d');

        /* renamed from: k, reason: collision with root package name */
        public static final a f39387k = a('a');

        /* renamed from: a, reason: collision with root package name */
        char f39388a;

        public static synchronized a a(char c6) {
            a aVar;
            synchronized (a.class) {
                try {
                    if (c6 >= 128) {
                        throw new IllegalArgumentException("Right must be ASCII");
                    }
                    a[] aVarArr = f39378b;
                    if (aVarArr[c6] == null) {
                        aVarArr[c6] = new a(c6);
                    }
                    aVar = f39378b[c6];
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }

        public String toString() {
            return String.valueOf(this.f39388a);
        }

        private a(char c6) {
            if (c6 < 128) {
                this.f39388a = c6;
                return;
            }
            throw new IllegalArgumentException("Right must be ASCII");
        }
    }

    public n() {
        this.f39377a = new boolean[128];
    }

    public void b(n nVar) {
        int i6 = 0;
        while (true) {
            boolean[] zArr = nVar.f39377a;
            if (i6 >= zArr.length) {
                return;
            }
            if (zArr[i6]) {
                this.f39377a[i6] = true;
            }
            i6++;
        }
    }

    public Object clone() {
        try {
            n nVar = (n) super.clone();
            try {
                boolean[] zArr = new boolean[128];
                nVar.f39377a = zArr;
                boolean[] zArr2 = this.f39377a;
                System.arraycopy(zArr2, 0, zArr, 0, zArr2.length);
                return nVar;
            } catch (CloneNotSupportedException unused) {
                return nVar;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public boolean e(n nVar) {
        int i6 = 0;
        while (true) {
            boolean[] zArr = nVar.f39377a;
            if (i6 >= zArr.length) {
                return true;
            }
            if (zArr[i6] && !this.f39377a[i6]) {
                return false;
            }
            i6++;
        }
    }

    public void h(n nVar) {
        int i6 = 0;
        while (true) {
            boolean[] zArr = nVar.f39377a;
            if (i6 >= zArr.length) {
                return;
            }
            if (zArr[i6]) {
                this.f39377a[i6] = false;
            }
            i6++;
        }
    }

    public int hashCode() {
        int i6 = 0;
        int i7 = 0;
        while (true) {
            boolean[] zArr = this.f39377a;
            if (i6 >= zArr.length) {
                return i7;
            }
            if (zArr[i6]) {
                i7++;
            }
            i6++;
        }
    }

    public void a(a aVar) {
        this.f39377a[aVar.f39388a] = true;
    }

    public boolean c(a aVar) {
        return this.f39377a[aVar.f39388a];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        int i6 = 0;
        while (true) {
            boolean[] zArr = nVar.f39377a;
            if (i6 >= zArr.length) {
                return true;
            }
            if (zArr[i6] != this.f39377a[i6]) {
                return false;
            }
            i6++;
        }
    }

    public a[] f() {
        Vector vector = new Vector();
        int i6 = 0;
        while (true) {
            boolean[] zArr = this.f39377a;
            if (i6 >= zArr.length) {
                a[] aVarArr = new a[vector.size()];
                vector.copyInto(aVarArr);
                return aVarArr;
            }
            if (zArr[i6]) {
                vector.addElement(a.a((char) i6));
            }
            i6++;
        }
    }

    public void g(a aVar) {
        this.f39377a[aVar.f39388a] = false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i6 = 0;
        while (true) {
            boolean[] zArr = this.f39377a;
            if (i6 >= zArr.length) {
                return stringBuffer.toString();
            }
            if (zArr[i6]) {
                stringBuffer.append((char) i6);
            }
            i6++;
        }
    }

    public n(n nVar) {
        boolean[] zArr = new boolean[128];
        this.f39377a = zArr;
        System.arraycopy(nVar.f39377a, 0, zArr, 0, zArr.length);
    }

    public n(String str) {
        this.f39377a = new boolean[128];
        for (int i6 = 0; i6 < str.length(); i6++) {
            a(a.a(str.charAt(i6)));
        }
    }

    public n(a aVar) {
        boolean[] zArr = new boolean[128];
        this.f39377a = zArr;
        zArr[aVar.f39388a] = true;
    }
}
