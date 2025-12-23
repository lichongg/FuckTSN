package org.apache.commons.net.nntp;

import io.netty.util.internal.StringUtil;
import java.util.Calendar;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final String f50928a;

    /* renamed from: b, reason: collision with root package name */
    private final String f50929b;

    /* renamed from: c, reason: collision with root package name */
    private StringBuffer f50930c = null;

    /* renamed from: d, reason: collision with root package name */
    private StringBuffer f50931d = null;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f50932e;

    public void a(String str) {
        StringBuffer stringBuffer = this.f50930c;
        if (stringBuffer != null) {
            stringBuffer.append(StringUtil.COMMA);
        } else {
            this.f50930c = new StringBuffer();
        }
        this.f50930c.append(str);
    }

    public void b(String str) {
        StringBuffer stringBuffer = this.f50931d;
        if (stringBuffer != null) {
            stringBuffer.append(StringUtil.COMMA);
        } else {
            this.f50931d = new StringBuffer();
        }
        this.f50931d.append(str);
    }

    public String c() {
        return this.f50928a;
    }

    public String d() {
        StringBuffer stringBuffer = this.f50930c;
        if (stringBuffer == null) {
            return null;
        }
        return stringBuffer.toString();
    }

    public String e() {
        StringBuffer stringBuffer = this.f50931d;
        if (stringBuffer == null) {
            return null;
        }
        return stringBuffer.toString();
    }

    public String f() {
        return this.f50929b;
    }

    public boolean g() {
        return this.f50932e;
    }

    public void h(String str) {
        b("!" + str);
    }

    public i(Calendar calendar, boolean z5) {
        this.f50932e = z5;
        StringBuilder sb = new StringBuilder();
        String num = Integer.toString(calendar.get(1));
        int length = num.length();
        if (length >= 2) {
            sb.append(num.substring(length - 2));
        } else {
            sb.append("00");
        }
        String num2 = Integer.toString(calendar.get(2) + 1);
        int length2 = num2.length();
        if (length2 == 1) {
            sb.append('0');
            sb.append(num2);
        } else if (length2 == 2) {
            sb.append(num2);
        } else {
            sb.append("01");
        }
        String num3 = Integer.toString(calendar.get(5));
        int length3 = num3.length();
        if (length3 == 1) {
            sb.append('0');
            sb.append(num3);
        } else if (length3 == 2) {
            sb.append(num3);
        } else {
            sb.append("01");
        }
        this.f50928a = sb.toString();
        sb.setLength(0);
        String num4 = Integer.toString(calendar.get(11));
        int length4 = num4.length();
        if (length4 == 1) {
            sb.append('0');
            sb.append(num4);
        } else if (length4 == 2) {
            sb.append(num4);
        } else {
            sb.append("00");
        }
        String num5 = Integer.toString(calendar.get(12));
        int length5 = num5.length();
        if (length5 == 1) {
            sb.append('0');
            sb.append(num5);
        } else if (length5 == 2) {
            sb.append(num5);
        } else {
            sb.append("00");
        }
        String num6 = Integer.toString(calendar.get(13));
        int length6 = num6.length();
        if (length6 == 1) {
            sb.append('0');
            sb.append(num6);
        } else if (length6 == 2) {
            sb.append(num6);
        } else {
            sb.append("00");
        }
        this.f50929b = sb.toString();
    }
}
