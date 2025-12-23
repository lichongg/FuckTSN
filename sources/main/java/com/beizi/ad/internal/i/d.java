package com.beizi.ad.internal.i;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class d {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f12211d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f12212e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a, reason: collision with root package name */
    public final String f12213a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12214b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12215c;

    public static d a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new d(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    private String b(String str) {
        Matcher matcher = f12212e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f12214b + ", partial=" + this.f12215c + ", uri='" + this.f12213a + "'}";
    }

    public d(String str) {
        boolean z5;
        k.a(str);
        long a6 = a(str);
        this.f12214b = Math.max(0L, a6);
        if (a6 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f12215c = z5;
        this.f12213a = b(str);
    }

    private long a(String str) {
        Matcher matcher = f12211d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }
}
