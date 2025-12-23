package com.hp.hpl.sparta.xpath;

import java.io.IOException;
import java.io.Reader;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class s {

    /* renamed from: j, reason: collision with root package name */
    public static final int f32887j = -1;

    /* renamed from: k, reason: collision with root package name */
    public static final int f32888k = -2;

    /* renamed from: l, reason: collision with root package name */
    public static final int f32889l = -3;

    /* renamed from: m, reason: collision with root package name */
    private static final int f32890m = -5;

    /* renamed from: n, reason: collision with root package name */
    private static final int f32891n = -6;

    /* renamed from: e, reason: collision with root package name */
    private int f32896e;

    /* renamed from: f, reason: collision with root package name */
    private final Reader f32897f;

    /* renamed from: a, reason: collision with root package name */
    public int f32892a = Integer.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public int f32893b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public String f32894c = "";

    /* renamed from: d, reason: collision with root package name */
    private final StringBuffer f32895d = new StringBuffer();

    /* renamed from: g, reason: collision with root package name */
    private final int[] f32898g = new int[256];

    /* renamed from: h, reason: collision with root package name */
    private boolean f32899h = false;

    /* renamed from: i, reason: collision with root package name */
    private char f32900i = 0;

    public void c() {
        this.f32899h = true;
    }

    public int a() throws IOException {
        int read;
        int i6;
        char c6;
        boolean z5;
        boolean z6;
        int i7;
        if (this.f32899h) {
            this.f32899h = false;
            return this.f32892a;
        }
        this.f32892a = this.f32896e;
        do {
            boolean z7 = false;
            do {
                read = this.f32897f.read();
                if (read != -1) {
                    i6 = this.f32898g[read];
                } else {
                    if (this.f32900i != 0) {
                        throw new IOException("Unterminated quote");
                    }
                    i6 = -1;
                }
                c6 = this.f32900i;
                z5 = c6 == 0 && i6 == -5;
                z7 = z7 || z5;
            } while (z5);
            if (i6 == 39 || i6 == 34) {
                if (c6 == 0) {
                    this.f32900i = (char) i6;
                } else if (c6 == i6) {
                    this.f32900i = (char) 0;
                }
            }
            char c7 = this.f32900i;
            if (c7 != 0) {
                i6 = c7;
            }
            z6 = z7 || !(((i7 = this.f32892a) < -1 || i7 == 39 || i7 == 34) && i7 == i6);
            if (z6) {
                int i8 = this.f32892a;
                if (i8 == -3) {
                    this.f32894c = this.f32895d.toString();
                    this.f32895d.setLength(0);
                } else if (i8 == -2) {
                    this.f32893b = Integer.parseInt(this.f32895d.toString());
                    this.f32895d.setLength(0);
                } else if (i8 == 34 || i8 == 39) {
                    this.f32894c = this.f32895d.toString().substring(1, this.f32895d.length() - 1);
                    this.f32895d.setLength(0);
                }
                if (i6 != -5) {
                    this.f32896e = i6 == -6 ? read : i6;
                }
            }
            if (i6 == -3 || i6 == -2 || i6 == 34 || i6 == 39) {
                this.f32895d.append((char) read);
            }
        } while (!z6);
        return this.f32892a;
    }

    public void b(char c6) {
        this.f32898g[c6] = c6;
    }

    public void d(char c6, char c7) {
        while (c6 <= c7) {
            this.f32898g[c6] = -3;
            c6 = (char) (c6 + 1);
        }
    }

    public String toString() {
        int i6 = this.f32892a;
        if (i6 != -3) {
            if (i6 == -2) {
                return Integer.toString(this.f32893b);
            }
            if (i6 == -1) {
                return "(EOF)";
            }
            if (i6 != 34) {
                if (i6 != 39) {
                    return "'" + ((char) this.f32892a) + "'";
                }
                return "'" + this.f32894c + "'";
            }
        }
        return "\"" + this.f32894c + "\"";
    }

    public s(Reader reader) throws IOException {
        char c6 = 0;
        this.f32897f = reader;
        while (true) {
            int[] iArr = this.f32898g;
            if (c6 < iArr.length) {
                if (('A' <= c6 && c6 <= 'Z') || (('a' <= c6 && c6 <= 'z') || c6 == '-')) {
                    iArr[c6] = -3;
                } else if ('0' <= c6 && c6 <= '9') {
                    iArr[c6] = -2;
                } else if (c6 >= 0 && c6 <= ' ') {
                    iArr[c6] = -5;
                } else {
                    iArr[c6] = c6;
                }
                c6 = (char) (c6 + 1);
            } else {
                a();
                return;
            }
        }
    }
}
