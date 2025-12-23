package com.danikula.videocache;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
class g {

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f32174d = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f32175e = Pattern.compile("GET /(.*) HTTP");

    /* renamed from: a, reason: collision with root package name */
    public final String f32176a;

    /* renamed from: b, reason: collision with root package name */
    public final long f32177b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f32178c;

    private long a(String str) {
        Matcher matcher = f32174d.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String b(String str) {
        Matcher matcher = f32175e.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public static g c(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                return new g(sb.toString());
            }
            sb.append(readLine);
            sb.append('\n');
        }
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.f32177b + ", partial=" + this.f32178c + ", uri='" + this.f32176a + "'}";
    }

    public g(String str) {
        boolean z5;
        n.d(str);
        long a6 = a(str);
        this.f32177b = Math.max(0L, a6);
        if (a6 >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.f32178c = z5;
        this.f32176a = b(str);
    }
}
