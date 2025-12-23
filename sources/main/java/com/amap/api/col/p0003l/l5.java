package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003l.i4;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class l5 {

    /* renamed from: b, reason: collision with root package name */
    private static final String f6734b = q4.u("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: c, reason: collision with root package name */
    private static final String f6735c = q4.u("FbGJzX3Nkaw");

    /* renamed from: d, reason: collision with root package name */
    private static final String f6736d = q4.u("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");

    /* renamed from: e, reason: collision with root package name */
    private static final String f6737e = q4.u("FQU5EU0RLMTA");

    /* renamed from: f, reason: collision with root package name */
    private static final String f6738f = q4.u("FMTAw");

    /* renamed from: g, reason: collision with root package name */
    private static boolean f6739g = false;

    /* renamed from: a, reason: collision with root package name */
    private String f6740a = "";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements i4.c {

        /* renamed from: a, reason: collision with root package name */
        private l5 f6741a = new l5();

        @Override // com.amap.api.col.3l.i4.c
        public final Cif a(byte[] bArr, Map<String, String> map) {
            return new q6(bArr, map);
        }

        @Override // com.amap.api.col.3l.i4.c
        public final Map<String, String> b() {
            return this.f6741a.d();
        }

        @Override // com.amap.api.col.3l.i4.c
        public final String a() {
            return l5.e();
        }

        @Override // com.amap.api.col.3l.i4.c
        public final String b(String str, String str2, String str3, String str4) {
            return this.f6741a.c(str, str2, str3, str4);
        }

        a() {
        }

        @Override // com.amap.api.col.3l.i4.c
        public final String a(Context context, String str) {
            return l5.b(context, str);
        }
    }

    public final synchronized Map<String, String> d() {
        if (f6739g) {
            return null;
        }
        f6739g = true;
        HashMap hashMap = new HashMap();
        hashMap.put(q4.u("FZW50"), q4.u("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(q4.u("SY2hhbm5lbD0"));
        String str = f6735c;
        sb.append(str);
        sb.append(q4.u("SJmRpdj0"));
        String str2 = f6737e;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(q4.u("FQA"));
        stringBuffer.append(f6736d);
        String d6 = o5.d(stringBuffer.toString());
        sb.append(q4.u("FJnNpZ249"));
        sb.append(d6.toUpperCase(Locale.US));
        sb.append(q4.u("SJm91dHB1dD1qc29u") + "\u0000");
        hashMap.put(q4.u("FaW4"), j5.a(n6.a(sb.toString().getBytes(), f6734b.getBytes())));
        hashMap.put(q4.u("Sa2V5dA"), f6738f);
        return hashMap;
    }

    public static i4.c a() {
        return new a();
    }

    public static String b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(q4.u("UY29kZQ")) != 1) {
                return "";
            }
            String optString = new JSONObject(jSONObject.optString(q4.u("FZGF0YQ"))).optString(q4.u("FYWRpdQ"));
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            m5.b(optString);
            g5.a(context).c(optString);
            return optString;
        } catch (JSONException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.f6740a)) {
            return this.f6740a;
        }
        String a6 = j4.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i6 = 0; i6 < a6.length(); i6++) {
            stringBuffer.append((char) (a6.charAt(i6) - (i6 % 48)));
        }
        String stringBuffer2 = stringBuffer.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i7 = 0; i7 < stringBuffer2.length() / 2; i7++) {
            stringBuffer3.append((char) ((stringBuffer2.charAt(i7) + stringBuffer2.charAt((stringBuffer2.length() - 1) - i7)) / 2));
        }
        String stringBuffer4 = stringBuffer3.toString();
        this.f6740a = stringBuffer4;
        return stringBuffer4;
    }

    public final String c(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(q4.u("LdGlk"), str);
            jSONObject.put(q4.u("FZGl1"), str2);
            jSONObject.put(q4.u("AZGl1Mg"), str3);
            jSONObject.put(q4.u("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        if (TextUtils.isEmpty(jSONObject2)) {
            return null;
        }
        String b6 = o5.b();
        if (!TextUtils.isEmpty(b6)) {
            String a6 = j5.a(n6.a((jSONObject2 + "\u0000").getBytes(), b6.getBytes()));
            if (!TextUtils.isEmpty(a6)) {
                try {
                    return q4.u("Fa2V5PQ") + URLEncoder.encode(j5.a(n5.b(b6.getBytes("utf-8"), n5.a(f())))) + q4.u("SJmRhdGE9") + URLEncoder.encode(a6);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String e() {
        return m5.a();
    }
}
