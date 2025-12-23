package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
final class d {
    private static final Pattern aKR = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern aKS = Pattern.compile("GET /(.*) HTTP");
    public final long aKT;
    public final boolean aKU;
    public final String uri;

    public static d b(InputStream inputStream) {
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

    private static long eH(String str) {
        Matcher matcher = aKR.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String eI(String str) {
        Matcher matcher = aKS.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.aKT + ", partial=" + this.aKU + ", uri='" + this.uri + "'}";
    }

    private d(String str) {
        boolean z5;
        ax.hh(str);
        long eH = eH(str);
        this.aKT = Math.max(0L, eH);
        if (eH >= 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.aKU = z5;
        this.uri = eI(str);
    }
}
