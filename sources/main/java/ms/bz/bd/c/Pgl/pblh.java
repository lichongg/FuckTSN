package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Pattern;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class pblh {

    /* renamed from: a, reason: collision with root package name */
    private static final String f50327a = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "d5091b", new byte[]{69, 37, 76, 78, 11, 102, 116, Ascii.ESC, 115});

    /* renamed from: b, reason: collision with root package name */
    private static final String f50328b = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7b0627", new byte[]{14, 97, 81, 70, 26, BinaryMemcacheOpcodes.SASL_AUTH, 38, 70});

    /* renamed from: c, reason: collision with root package name */
    private static final String f50329c = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7a875a", new byte[]{0, 102, 74, 87, Ascii.US, 100, 49, 83});

    /* renamed from: d, reason: collision with root package name */
    private static final String f50330d = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "4248f2", new byte[]{53, 51});

    /* renamed from: e, reason: collision with root package name */
    private static final String f50331e = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "b3baeb", new byte[]{123, 38});

    /* renamed from: f, reason: collision with root package name */
    private static final String f50332f = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "da47ac", new byte[]{115, 119});

    /* renamed from: g, reason: collision with root package name */
    private static final String f50333g = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "136059", new byte[]{45, 48, 93});

    /* renamed from: h, reason: collision with root package name */
    private static final String f50334h = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "53231e", new byte[]{41, 56, 79});

    /* renamed from: i, reason: collision with root package name */
    private static final String f50335i = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "9091ce", new byte[]{43, 61, 88, SignedBytes.MAX_POWER_OF_TWO});

    /* renamed from: j, reason: collision with root package name */
    private static final FileFilter f50336j = new pgla();

    final class pgla implements FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "60064c", new byte[]{BinaryMemcacheOpcodes.GATKQ, 34, 86, 121, 91, 57, 108, HttpConstants.COMMA}), file.getName());
        }

        pgla() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        if (r10 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(java.lang.String r10) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L23
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L23
            boolean r10 = r3.exists()     // Catch: java.lang.Throwable -> L23
            if (r10 != 0) goto L25
            java.lang.String r8 = "7d202f"
            byte[] r9 = new byte[r1]     // Catch: java.lang.Throwable -> L23
            r10 = 118(0x76, float:1.65E-43)
            r9[r0] = r10     // Catch: java.lang.Throwable -> L23
            r4 = 16777217(0x1000001, float:2.350989E-38)
            r5 = 0
            r6 = 0
            java.lang.Object r10 = com.volcengine.mobsecBiz.matrix.pgla.a(r4, r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L23
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L23
            return r10
        L23:
            goto L41
        L25:
            java.io.FileReader r10 = new java.io.FileReader     // Catch: java.lang.Throwable -> L23
            r10.<init>(r3)     // Catch: java.lang.Throwable -> L23
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3e
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L3c
            r3.close()     // Catch: java.lang.Throwable -> L36
        L36:
            r10.close()     // Catch: java.lang.Throwable -> L3a
            goto L4d
        L3a:
            goto L4d
        L3c:
            goto L43
        L3e:
            r3 = r2
            goto L43
        L41:
            r10 = r2
            r3 = r10
        L43:
            if (r3 == 0) goto L4a
            r3.close()     // Catch: java.lang.Throwable -> L49
            goto L4a
        L49:
        L4a:
            if (r10 == 0) goto L4d
            goto L36
        L4d:
            if (r2 != 0) goto L64
            byte[] r8 = new byte[r1]
            r10 = 112(0x70, float:1.57E-43)
            r8[r0] = r10
            r5 = 0
            java.lang.String r7 = "17fbff"
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            java.lang.Object r10 = com.volcengine.mobsecBiz.matrix.pgla.a(r3, r4, r5, r7, r8)
            java.lang.String r10 = (java.lang.String) r10
            return r10
        L64:
            java.lang.String r10 = r2.trim()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblh.c(java.lang.String):java.lang.String");
    }

    private static int a() {
        try {
            return new File((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "53512a", new byte[]{107, 34, 95, 86, 66, 114, 51, 4, 109, 98, BinaryMemcacheOpcodes.SASL_AUTH, 34, 9, 86, 20, 101, 34, 23, 105, 46, 39, BinaryMemcacheOpcodes.SASL_AUTH, 83, 10})).listFiles(f50336j).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String b() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> d6 = d();
            jSONObject.put(f50335i, a());
            String str3 = null;
            try {
                str = d6.get(f50327a);
            } catch (Throwable unused) {
                str = null;
            }
            jSONObject.put(f50330d, str == null ? "" : str.trim());
            try {
                str2 = d6.get(f50328b);
            } catch (Throwable unused2) {
                str2 = null;
            }
            jSONObject.put(f50331e, str2 == null ? "" : str2.trim());
            jSONObject.put(f50333g, c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "932a51", new byte[]{103, 34, 88, 6, 69, 34, Utf8.REPLACEMENT_BYTE, 4, 106, 50, 45, 34, 14, 6, 19, 53, 46, 23, 110, 126, 43, BinaryMemcacheOpcodes.SASL_AUTH, 84, 90, 9, 54, 47, 66, HttpConstants.COMMA, 50, 56, BinaryMemcacheOpcodes.GATKQ, 71, 7, 15, 55, 117, 17, 115, BinaryMemcacheOpcodes.GATKQ, BinaryMemcacheOpcodes.SASL_AUTH, Utf8.REPLACEMENT_BYTE, 71, 26, 53, 43, HttpConstants.SEMICOLON, 10, 92, 55, HttpConstants.COLON, 52, 80})));
            jSONObject.put(f50334h, c((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "81a9e0", new byte[]{102, 32, 11, 94, 21, BinaryMemcacheOpcodes.GATK, 62, 6, 57, 106, HttpConstants.COMMA, 32, 93, 94, 67, 52, 47, 21, 61, 38, 42, BinaryMemcacheOpcodes.GATK, 7, 2, 89, 55, 46, SignedBytes.MAX_POWER_OF_TWO, Byte.MAX_VALUE, 106, 57, 38, 20, 95, 95, 54, 116, 19, 32, 124, 32, 61, 20, 66, 101, 42, 50, 30, 15, 111, HttpConstants.SEMICOLON, 54, 3})));
            try {
                str3 = d6.get(f50329c);
            } catch (Throwable unused3) {
            }
            jSONObject.put(f50332f, str3 != null ? str3.trim() : "");
        } catch (Throwable unused4) {
        }
        String jSONObject2 = jSONObject.toString();
        return TextUtils.isEmpty(jSONObject2) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "672691", new byte[]{60, 40}) : jSONObject2.trim();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        if (r2 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.HashMap<java.lang.String, java.lang.String> d() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L6b
            java.lang.String r7 = "97b2d1"
            r3 = 13
            byte[] r8 = new byte[r3]     // Catch: java.lang.Throwable -> L6b
            r8 = {x0078: FILL_ARRAY_DATA , data: [103, 37, 3, 73, 88, 105, 57, 6, 38, 107, 38, 51, 30} // fill-array     // Catch: java.lang.Throwable -> L6b
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            r5 = 0
            java.lang.Object r3 = com.volcengine.mobsecBiz.matrix.pgla.a(r3, r4, r5, r7, r8)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L6b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6b
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L69
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L69
        L25:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L66
            if (r1 != 0) goto L32
            r3.close()     // Catch: java.lang.Throwable -> L2e
        L2e:
            r2.close()     // Catch: java.lang.Throwable -> L77
            goto L77
        L32:
            java.lang.String r8 = "69fbe5"
            r10 = 1
            byte[] r9 = new byte[r10]     // Catch: java.lang.Throwable -> L66
            r11 = 0
            r4 = 125(0x7d, float:1.75E-43)
            r9[r11] = r4     // Catch: java.lang.Throwable -> L66
            r4 = 16777217(0x1000001, float:2.350989E-38)
            r5 = 0
            r6 = 0
            java.lang.Object r4 = com.volcengine.mobsecBiz.matrix.pgla.a(r4, r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L66
            r5 = 2
            java.lang.String[] r1 = r1.split(r4, r5)     // Catch: java.lang.Throwable -> L66
            int r4 = r1.length     // Catch: java.lang.Throwable -> L66
            if (r4 < r5) goto L25
            r4 = r1[r11]     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L66
            r1 = r1[r10]     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L66
            java.lang.Object r5 = r0.get(r4)     // Catch: java.lang.Throwable -> L66
            if (r5 != 0) goto L25
            r0.put(r4, r1)     // Catch: java.lang.Throwable -> L66
            goto L25
        L66:
            r1 = r3
            goto L6d
        L69:
            goto L6d
        L6b:
            r2 = r1
        L6d:
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.lang.Throwable -> L73
            goto L74
        L73:
        L74:
            if (r2 == 0) goto L77
            goto L2e
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblh.d():java.util.HashMap");
    }
}
