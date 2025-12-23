package org.apache.commons.net.nntp;

import io.netty.util.internal.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final String f50946a;

    /* renamed from: b, reason: collision with root package name */
    private final String f50947b;

    /* renamed from: c, reason: collision with root package name */
    private final StringBuilder f50948c = new StringBuilder();

    /* renamed from: d, reason: collision with root package name */
    private final StringBuilder f50949d = new StringBuilder();

    /* renamed from: e, reason: collision with root package name */
    private int f50950e = 0;

    public void a(String str, String str2) {
        this.f50949d.append(str);
        this.f50949d.append(": ");
        this.f50949d.append(str2);
        this.f50949d.append('\n');
    }

    public void b(String str) {
        int i6 = this.f50950e;
        this.f50950e = i6 + 1;
        if (i6 > 0) {
            this.f50948c.append(StringUtil.COMMA);
        }
        this.f50948c.append(str);
    }

    public String c() {
        return this.f50947b;
    }

    public String d() {
        return this.f50948c.toString();
    }

    public String e() {
        return this.f50946a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("From: ");
        sb.append(this.f50947b);
        sb.append("\nNewsgroups: ");
        sb.append(this.f50948c.toString());
        sb.append("\nSubject: ");
        sb.append(this.f50946a);
        sb.append('\n');
        if (this.f50949d.length() > 0) {
            sb.append(this.f50949d.toString());
        }
        sb.append('\n');
        return sb.toString();
    }

    public m(String str, String str2) {
        this.f50947b = str;
        this.f50946a = str2;
    }
}
