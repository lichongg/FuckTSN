package com.sun.activation.registries;

import java.util.NoSuchElementException;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
class a {

    /* renamed from: e, reason: collision with root package name */
    private static final String f39143e = "=";

    /* renamed from: b, reason: collision with root package name */
    private int f39145b;

    /* renamed from: c, reason: collision with root package name */
    private String f39146c;

    /* renamed from: d, reason: collision with root package name */
    private Vector f39147d = new Vector();

    /* renamed from: a, reason: collision with root package name */
    private int f39144a = 0;

    private void d() {
        while (true) {
            int i6 = this.f39144a;
            if (i6 >= this.f39145b || !Character.isWhitespace(this.f39146c.charAt(i6))) {
                return;
            } else {
                this.f39144a++;
            }
        }
    }

    public boolean a() {
        if (this.f39147d.size() > 0) {
            return true;
        }
        d();
        return this.f39144a < this.f39145b;
    }

    public String b() {
        int size = this.f39147d.size();
        if (size > 0) {
            int i6 = size - 1;
            String str = (String) this.f39147d.elementAt(i6);
            this.f39147d.removeElementAt(i6);
            return str;
        }
        d();
        int i7 = this.f39144a;
        if (i7 >= this.f39145b) {
            throw new NoSuchElementException();
        }
        char charAt = this.f39146c.charAt(i7);
        if (charAt == '\"') {
            this.f39144a++;
            boolean z5 = false;
            while (true) {
                int i8 = this.f39144a;
                if (i8 >= this.f39145b) {
                    break;
                }
                String str2 = this.f39146c;
                this.f39144a = i8 + 1;
                char charAt2 = str2.charAt(i8);
                if (charAt2 == '\\') {
                    this.f39144a++;
                    z5 = true;
                } else if (charAt2 == '\"') {
                    if (!z5) {
                        return this.f39146c.substring(i7 + 1, this.f39144a - 1);
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i9 = i7 + 1; i9 < this.f39144a - 1; i9++) {
                        char charAt3 = this.f39146c.charAt(i9);
                        if (charAt3 != '\\') {
                            stringBuffer.append(charAt3);
                        }
                    }
                    return stringBuffer.toString();
                }
            }
        } else if ("=".indexOf(charAt) < 0) {
            while (true) {
                int i10 = this.f39144a;
                if (i10 >= this.f39145b || "=".indexOf(this.f39146c.charAt(i10)) >= 0 || Character.isWhitespace(this.f39146c.charAt(this.f39144a))) {
                    break;
                }
                this.f39144a++;
            }
        } else {
            this.f39144a++;
        }
        return this.f39146c.substring(i7, this.f39144a);
    }

    public void c(String str) {
        this.f39147d.addElement(str);
    }

    public a(String str) {
        this.f39146c = str;
        this.f39145b = str.length();
    }
}
