package com.sun.activation.registries;

import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d {

    /* renamed from: h, reason: collision with root package name */
    public static final int f39155h = 0;

    /* renamed from: i, reason: collision with root package name */
    public static final int f39156i = 1;

    /* renamed from: j, reason: collision with root package name */
    public static final int f39157j = 2;

    /* renamed from: k, reason: collision with root package name */
    public static final int f39158k = 5;

    /* renamed from: l, reason: collision with root package name */
    public static final int f39159l = 47;

    /* renamed from: m, reason: collision with root package name */
    public static final int f39160m = 59;

    /* renamed from: n, reason: collision with root package name */
    public static final int f39161n = 61;

    /* renamed from: a, reason: collision with root package name */
    private String f39162a;

    /* renamed from: c, reason: collision with root package name */
    private int f39164c;

    /* renamed from: b, reason: collision with root package name */
    private int f39163b = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f39165d = 1;

    /* renamed from: e, reason: collision with root package name */
    private String f39166e = "";

    /* renamed from: f, reason: collision with root package name */
    private boolean f39167f = false;

    /* renamed from: g, reason: collision with root package name */
    private char f39168g = ';';

    private static boolean e(char c6) {
        if (c6 == '\"' || c6 == ',' || c6 == '/' || c6 == '(' || c6 == ')') {
            return true;
        }
        switch (c6) {
            case ':':
            case ';':
            case '<':
            case '=':
            case '>':
            case '?':
            case '@':
                return true;
            default:
                switch (c6) {
                    case '[':
                    case '\\':
                    case ']':
                        return true;
                    default:
                        return false;
                }
        }
    }

    public static String h(int i6) {
        return i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 5 ? i6 != 47 ? i6 != 59 ? i6 != 61 ? "really unknown" : "'='" : "';'" : "'/'" : "EOI" : ResIdentify.RES_TYPE_STRING : "start" : "unknown";
    }

    private void j() {
        int i6;
        int i7 = this.f39163b;
        boolean z5 = false;
        while (true) {
            i6 = this.f39163b;
            if (i6 >= this.f39164c || z5) {
                break;
            } else if (this.f39162a.charAt(i6) != this.f39168g) {
                this.f39163b++;
            } else {
                z5 = true;
            }
        }
        this.f39165d = 2;
        this.f39166e = a(this.f39162a.substring(i7, i6));
    }

    private void k() {
        int i6 = this.f39163b;
        while (true) {
            int i7 = this.f39163b;
            if (i7 >= this.f39164c || !f(this.f39162a.charAt(i7))) {
                break;
            } else {
                this.f39163b++;
            }
        }
        this.f39165d = 2;
        this.f39166e = this.f39162a.substring(i6, this.f39163b);
    }

    public int b() {
        return this.f39165d;
    }

    public String c() {
        return this.f39166e;
    }

    public int i() {
        if (this.f39163b < this.f39164c) {
            while (true) {
                int i6 = this.f39163b;
                if (i6 >= this.f39164c || !g(this.f39162a.charAt(i6))) {
                    break;
                }
                this.f39163b++;
            }
            int i7 = this.f39163b;
            if (i7 < this.f39164c) {
                char charAt = this.f39162a.charAt(i7);
                if (this.f39167f) {
                    if (charAt == ';' || charAt == '=') {
                        this.f39165d = charAt;
                        this.f39166e = new Character(charAt).toString();
                        this.f39163b++;
                    } else {
                        j();
                    }
                } else if (f(charAt)) {
                    k();
                } else if (charAt == '/' || charAt == ';' || charAt == '=') {
                    this.f39165d = charAt;
                    this.f39166e = new Character(charAt).toString();
                    this.f39163b++;
                } else {
                    this.f39165d = 0;
                    this.f39166e = new Character(charAt).toString();
                    this.f39163b++;
                }
            } else {
                this.f39165d = 5;
                this.f39166e = null;
            }
        } else {
            this.f39165d = 5;
            this.f39166e = null;
        }
        return this.f39165d;
    }

    public void l(boolean z5) {
        this.f39167f = z5;
    }

    public d(String str) {
        this.f39162a = str;
        this.f39164c = str.length();
    }

    private static String a(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i6 = 0;
        while (i6 < length) {
            char charAt = str.charAt(i6);
            if (charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (i6 < length - 1) {
                i6++;
                stringBuffer.append(str.charAt(i6));
            } else {
                stringBuffer.append(charAt);
            }
            i6++;
        }
        return stringBuffer.toString();
    }

    private static boolean d(char c6) {
        return Character.isISOControl(c6);
    }

    private static boolean f(char c6) {
        if (!e(c6) && !d(c6) && !g(c6)) {
            return true;
        }
        return false;
    }

    private static boolean g(char c6) {
        return Character.isWhitespace(c6);
    }
}
