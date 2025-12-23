package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private final Appendable f16060a;

    /* renamed from: b, reason: collision with root package name */
    private final String f16061b;

    /* renamed from: c, reason: collision with root package name */
    private final int f16062c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f16063d;

    /* renamed from: e, reason: collision with root package name */
    private final StringBuilder f16064e = new StringBuilder();

    /* renamed from: f, reason: collision with root package name */
    private int f16065f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f16066g = -1;

    private void b(boolean z5) throws IOException {
        int i6;
        if (z5) {
            this.f16060a.append('\n');
            int i7 = 0;
            while (true) {
                i6 = this.f16066g;
                if (i7 >= i6) {
                    break;
                }
                this.f16060a.append(this.f16061b);
                i7++;
            }
            int length = i6 * this.f16061b.length();
            this.f16065f = length;
            this.f16065f = length + this.f16064e.length();
        } else {
            this.f16060a.append(' ');
        }
        this.f16060a.append(this.f16064e);
        StringBuilder sb = this.f16064e;
        sb.delete(0, sb.length());
        this.f16066g = -1;
    }

    void a(String str) throws IOException {
        if (this.f16063d) {
            throw new IllegalStateException("closed");
        }
        if (this.f16066g != -1) {
            int indexOf = str.indexOf(10);
            if (indexOf == -1 && this.f16065f + str.length() <= this.f16062c) {
                this.f16064e.append(str);
                this.f16065f += str.length();
                return;
            }
            b(indexOf == -1 || this.f16065f + indexOf > this.f16062c);
        }
        this.f16060a.append(str);
        int lastIndexOf = str.lastIndexOf(10);
        this.f16065f = lastIndexOf != -1 ? (str.length() - lastIndexOf) - 1 : str.length() + this.f16065f;
    }

    void c(int i6) throws IOException {
        if (this.f16063d) {
            throw new IllegalStateException("closed");
        }
        if (this.f16066g != -1) {
            b(false);
        }
        this.f16065f++;
        this.f16066g = i6;
    }

    h(Appendable appendable, String str, int i6) {
        n.c(appendable, "out == null", new Object[0]);
        this.f16060a = appendable;
        this.f16061b = str;
        this.f16062c = i6;
    }
}
