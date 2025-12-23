package org.apache.commons.net.smtp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f51073a;

    /* renamed from: b, reason: collision with root package name */
    private final String f51074b;

    /* renamed from: c, reason: collision with root package name */
    private final String f51075c;

    /* renamed from: d, reason: collision with root package name */
    private final StringBuffer f51076d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f51077e;

    /* renamed from: f, reason: collision with root package name */
    private StringBuffer f51078f;

    public void a(String str) {
        StringBuffer stringBuffer = this.f51078f;
        if (stringBuffer == null) {
            this.f51078f = new StringBuffer();
        } else {
            stringBuffer.append(", ");
        }
        this.f51078f.append(str);
    }

    public void b(String str, String str2) {
        if (!this.f51077e && "Date".equals(str)) {
            this.f51077e = true;
        }
        this.f51076d.append(str);
        this.f51076d.append(": ");
        this.f51076d.append(str2);
        this.f51076d.append('\n');
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
        if (!this.f51077e) {
            b("Date", simpleDateFormat.format(new Date()));
        }
        if (this.f51076d.length() > 0) {
            sb.append(this.f51076d.toString());
        }
        sb.append("From: ");
        sb.append(this.f51074b);
        sb.append(com.snail.antifake.deviceid.e.f37542d);
        if (this.f51075c != null) {
            sb.append("To: ");
            sb.append(this.f51075c);
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        if (this.f51078f != null) {
            sb.append("Cc: ");
            sb.append(this.f51078f.toString());
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        if (this.f51073a != null) {
            sb.append("Subject: ");
            sb.append(this.f51073a);
            sb.append(com.snail.antifake.deviceid.e.f37542d);
        }
        sb.append('\n');
        return sb.toString();
    }

    public g(String str, String str2, String str3) {
        if (str != null) {
            this.f51075c = str2;
            this.f51074b = str;
            this.f51073a = str3;
            this.f51076d = new StringBuffer();
            this.f51078f = null;
            return;
        }
        throw new IllegalArgumentException("From cannot be null");
    }
}
