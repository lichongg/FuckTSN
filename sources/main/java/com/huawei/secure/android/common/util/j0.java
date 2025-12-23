package com.huawei.secure.android.common.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    private String f35283a;

    /* renamed from: b, reason: collision with root package name */
    private Character f35284b;

    /* renamed from: c, reason: collision with root package name */
    private Character f35285c;

    /* renamed from: d, reason: collision with root package name */
    private int f35286d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f35287e = 0;

    public static boolean e(Character ch) {
        if (ch == null) {
            return false;
        }
        char charValue = ch.charValue();
        if (charValue >= '0' && charValue <= '9') {
            return true;
        }
        if (charValue < 'a' || charValue > 'f') {
            return charValue >= 'A' && charValue <= 'F';
        }
        return true;
    }

    public static boolean g(Character ch) {
        char charValue;
        return ch != null && (charValue = ch.charValue()) >= '0' && charValue <= '7';
    }

    public void a(Character ch) {
        this.f35284b = ch;
    }

    public boolean b() {
        if (this.f35284b != null) {
            return true;
        }
        String str = this.f35283a;
        return (str == null || str.length() == 0 || this.f35286d >= this.f35283a.length()) ? false : true;
    }

    public boolean c(char c6) {
        Character ch = this.f35284b;
        if (ch != null && ch.charValue() == c6) {
            return true;
        }
        String str = this.f35283a;
        return str != null && str.length() != 0 && this.f35286d < this.f35283a.length() && this.f35283a.charAt(this.f35286d) == c6;
    }

    public int d() {
        return this.f35286d;
    }

    public void f() {
        this.f35285c = this.f35284b;
        this.f35287e = this.f35286d;
    }

    public Character h() {
        Character ch = this.f35284b;
        if (ch != null) {
            this.f35284b = null;
            return ch;
        }
        String str = this.f35283a;
        if (str == null || str.length() == 0 || this.f35286d >= this.f35283a.length()) {
            return null;
        }
        String str2 = this.f35283a;
        int i6 = this.f35286d;
        this.f35286d = i6 + 1;
        return Character.valueOf(str2.charAt(i6));
    }

    public Character k() {
        Character ch = this.f35284b;
        if (ch != null) {
            return ch;
        }
        String str = this.f35283a;
        if (str == null || str.length() == 0 || this.f35286d >= this.f35283a.length()) {
            return null;
        }
        return Character.valueOf(this.f35283a.charAt(this.f35286d));
    }

    protected String l() {
        String substring = this.f35283a.substring(this.f35286d);
        if (this.f35284b == null) {
            return substring;
        }
        return this.f35284b + substring;
    }

    public void m() {
        this.f35284b = this.f35285c;
        this.f35286d = this.f35287e;
    }

    public j0(String str) {
        this.f35283a = str;
    }

    public Character i() {
        Character h6 = h();
        if (h6 == null || !e(h6)) {
            return null;
        }
        return h6;
    }

    public Character j() {
        Character h6 = h();
        if (h6 == null || !g(h6)) {
            return null;
        }
        return h6;
    }
}
