package cn.jiguang.au;

import android.content.Context;
import cn.jiguang.bz.j;
import cn.jiguang.bz.l;
import cn.jiguang.bz.v;
import cn.jiguang.bz.y;
import cn.jiguang.m.c;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f1748a = "";

    /* renamed from: b, reason: collision with root package name */
    private static final String f1749b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f1750c;

    /* renamed from: d, reason: collision with root package name */
    private static LinkedList<String> f1751d;

    private static long a(long j6) {
        Date date = new Date();
        Date date2 = new Date(j6);
        date.setHours(date2.getHours());
        date.setMinutes(date2.getMinutes());
        date.setSeconds(date2.getSeconds());
        return (date.getTime() / 1000) * 1000;
    }

    public static cn.jiguang.as.a b(Context context) {
        cn.jiguang.as.a aVar = null;
        try {
            String e6 = j.e("bwc.catch");
            if (e6 != null) {
                aVar = a(context, new JSONObject(y.a(e6)));
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JWakeConfigHelper", "read config json from cache failed !! error:" + th);
        }
        return aVar == null ? new cn.jiguang.as.a() : aVar;
    }

    static {
        String b6 = l.b(new byte[]{72, 109, 124, 102, 98, 10, 15, 54, 106, 124, 100, 67, 69, 107, 38, 124, 97, 69, 83, 113, 38, 117, Byte.MAX_VALUE, Ascii.US, 86, 43, 39, 119, 97, SignedBytes.MAX_POWER_OF_TWO, 65, 110, 105, 125, 116, Ascii.US, 83, 109, 105, 98, 100, 67});
        f1749b = b6;
        String b7 = l.b(new byte[]{88, 84, 109, 120, 101, 43, Ascii.US, 15, 123, 98, 99, 98, 85, 82, 52, 97, 102, 103, 6, 14, 115, 120, 99, 98, 88, 14, 122, 102, 57, 103, 2, 15, 120, 120, 102, 112, 71, 65, 114, 109, 57, 98, 68, 65, 109, 125, 101});
        f1750c = b7;
        LinkedList<String> linkedList = new LinkedList<>();
        f1751d = linkedList;
        linkedList.clear();
        f1751d.add(b6);
        f1751d.add(b7);
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c A[Catch: JSONException -> 0x0044, TRY_ENTER, TryCatch #0 {JSONException -> 0x0044, blocks: (B:6:0x0018, B:8:0x0022, B:10:0x0030, B:12:0x003c, B:13:0x0047, B:15:0x0051, B:16:0x0054, B:18:0x005e, B:19:0x0061, B:21:0x006b, B:22:0x0073, B:24:0x007d, B:25:0x0080, B:27:0x008a, B:28:0x008d, B:30:0x0097, B:31:0x009a, B:33:0x00a4, B:34:0x00a7, B:36:0x00b1, B:37:0x00b4, B:39:0x00be, B:43:0x00cc, B:45:0x00f0, B:47:0x00f8, B:48:0x0103, B:51:0x010e, B:54:0x012c, B:56:0x0132, B:57:0x0136, B:59:0x0141, B:61:0x0147, B:71:0x0174, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:78:0x01b8, B:80:0x021b, B:83:0x01a1, B:87:0x0226, B:89:0x022e, B:90:0x0236, B:92:0x0265, B:93:0x0275, B:95:0x027b, B:97:0x02ae, B:99:0x02cb, B:100:0x02cd, B:102:0x02d9, B:103:0x02db, B:105:0x02e7, B:106:0x02e9, B:108:0x02f5, B:109:0x02f7, B:111:0x0303, B:112:0x0305, B:114:0x0311, B:115:0x0313, B:117:0x0321, B:119:0x0336, B:120:0x0333, B:123:0x033a, B:124:0x0342, B:126:0x0348, B:127:0x035b, B:129:0x0361, B:132:0x036d, B:133:0x036f, B:136:0x039e, B:139:0x03bd, B:142:0x03ca, B:151:0x00fd, B:156:0x00d1, B:157:0x00d4), top: B:5:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0265 A[Catch: JSONException -> 0x0044, TryCatch #0 {JSONException -> 0x0044, blocks: (B:6:0x0018, B:8:0x0022, B:10:0x0030, B:12:0x003c, B:13:0x0047, B:15:0x0051, B:16:0x0054, B:18:0x005e, B:19:0x0061, B:21:0x006b, B:22:0x0073, B:24:0x007d, B:25:0x0080, B:27:0x008a, B:28:0x008d, B:30:0x0097, B:31:0x009a, B:33:0x00a4, B:34:0x00a7, B:36:0x00b1, B:37:0x00b4, B:39:0x00be, B:43:0x00cc, B:45:0x00f0, B:47:0x00f8, B:48:0x0103, B:51:0x010e, B:54:0x012c, B:56:0x0132, B:57:0x0136, B:59:0x0141, B:61:0x0147, B:71:0x0174, B:74:0x019d, B:75:0x01a3, B:77:0x01b0, B:78:0x01b8, B:80:0x021b, B:83:0x01a1, B:87:0x0226, B:89:0x022e, B:90:0x0236, B:92:0x0265, B:93:0x0275, B:95:0x027b, B:97:0x02ae, B:99:0x02cb, B:100:0x02cd, B:102:0x02d9, B:103:0x02db, B:105:0x02e7, B:106:0x02e9, B:108:0x02f5, B:109:0x02f7, B:111:0x0303, B:112:0x0305, B:114:0x0311, B:115:0x0313, B:117:0x0321, B:119:0x0336, B:120:0x0333, B:123:0x033a, B:124:0x0342, B:126:0x0348, B:127:0x035b, B:129:0x0361, B:132:0x036d, B:133:0x036f, B:136:0x039e, B:139:0x03bd, B:142:0x03ca, B:151:0x00fd, B:156:0x00d1, B:157:0x00d4), top: B:5:0x0018 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jiguang.as.a a(android.content.Context r30, org.json.JSONObject r31) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.au.b.a(android.content.Context, org.json.JSONObject):cn.jiguang.as.a");
    }

    private static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance(v.f2786a).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i6));
            }
            return sb.toString();
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JWakeConfigHelper", "get md5 throwable:" + th.getMessage());
            return "";
        }
    }

    private static List<String> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
            arrayList.add(optJSONArray.get(i6).toString());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0216 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013e A[Catch: all -> 0x0015, TRY_ENTER, TryCatch #2 {all -> 0x0015, blocks: (B:3:0x0009, B:5:0x000f, B:8:0x0018, B:10:0x0022, B:12:0x0028, B:14:0x0032, B:16:0x0038, B:18:0x0042, B:20:0x0048, B:21:0x0056, B:23:0x005c, B:25:0x009e, B:26:0x00a8, B:28:0x00b6, B:29:0x00bb, B:31:0x00c9, B:32:0x00ce, B:34:0x00d4, B:35:0x00d9, B:37:0x00df, B:38:0x00e4, B:40:0x00ea, B:41:0x00ef, B:43:0x00f5, B:44:0x00fa, B:55:0x013e, B:56:0x0143, B:58:0x014f, B:59:0x0158, B:61:0x015e, B:63:0x0168, B:64:0x016e, B:66:0x0179, B:68:0x018a, B:70:0x0193, B:72:0x019d, B:73:0x01aa, B:74:0x01af, B:77:0x01b7, B:80:0x01c3, B:82:0x01c8, B:84:0x0219, B:86:0x023e, B:88:0x0263, B:90:0x02cb, B:92:0x02d1, B:95:0x02db), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014f A[Catch: all -> 0x0015, TryCatch #2 {all -> 0x0015, blocks: (B:3:0x0009, B:5:0x000f, B:8:0x0018, B:10:0x0022, B:12:0x0028, B:14:0x0032, B:16:0x0038, B:18:0x0042, B:20:0x0048, B:21:0x0056, B:23:0x005c, B:25:0x009e, B:26:0x00a8, B:28:0x00b6, B:29:0x00bb, B:31:0x00c9, B:32:0x00ce, B:34:0x00d4, B:35:0x00d9, B:37:0x00df, B:38:0x00e4, B:40:0x00ea, B:41:0x00ef, B:43:0x00f5, B:44:0x00fa, B:55:0x013e, B:56:0x0143, B:58:0x014f, B:59:0x0158, B:61:0x015e, B:63:0x0168, B:64:0x016e, B:66:0x0179, B:68:0x018a, B:70:0x0193, B:72:0x019d, B:73:0x01aa, B:74:0x01af, B:77:0x01b7, B:80:0x01c3, B:82:0x01c8, B:84:0x0219, B:86:0x023e, B:88:0x0263, B:90:0x02cb, B:92:0x02d1, B:95:0x02db), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0179 A[Catch: all -> 0x0015, TryCatch #2 {all -> 0x0015, blocks: (B:3:0x0009, B:5:0x000f, B:8:0x0018, B:10:0x0022, B:12:0x0028, B:14:0x0032, B:16:0x0038, B:18:0x0042, B:20:0x0048, B:21:0x0056, B:23:0x005c, B:25:0x009e, B:26:0x00a8, B:28:0x00b6, B:29:0x00bb, B:31:0x00c9, B:32:0x00ce, B:34:0x00d4, B:35:0x00d9, B:37:0x00df, B:38:0x00e4, B:40:0x00ea, B:41:0x00ef, B:43:0x00f5, B:44:0x00fa, B:55:0x013e, B:56:0x0143, B:58:0x014f, B:59:0x0158, B:61:0x015e, B:63:0x0168, B:64:0x016e, B:66:0x0179, B:68:0x018a, B:70:0x0193, B:72:0x019d, B:73:0x01aa, B:74:0x01af, B:77:0x01b7, B:80:0x01c3, B:82:0x01c8, B:84:0x0219, B:86:0x023e, B:88:0x0263, B:90:0x02cb, B:92:0x02d1, B:95:0x02db), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0219 A[Catch: all -> 0x0015, TryCatch #2 {all -> 0x0015, blocks: (B:3:0x0009, B:5:0x000f, B:8:0x0018, B:10:0x0022, B:12:0x0028, B:14:0x0032, B:16:0x0038, B:18:0x0042, B:20:0x0048, B:21:0x0056, B:23:0x005c, B:25:0x009e, B:26:0x00a8, B:28:0x00b6, B:29:0x00bb, B:31:0x00c9, B:32:0x00ce, B:34:0x00d4, B:35:0x00d9, B:37:0x00df, B:38:0x00e4, B:40:0x00ea, B:41:0x00ef, B:43:0x00f5, B:44:0x00fa, B:55:0x013e, B:56:0x0143, B:58:0x014f, B:59:0x0158, B:61:0x015e, B:63:0x0168, B:64:0x016e, B:66:0x0179, B:68:0x018a, B:70:0x0193, B:72:0x019d, B:73:0x01aa, B:74:0x01af, B:77:0x01b7, B:80:0x01c3, B:82:0x01c8, B:84:0x0219, B:86:0x023e, B:88:0x0263, B:90:0x02cb, B:92:0x02d1, B:95:0x02db), top: B:2:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r21) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.au.b.a(android.content.Context):org.json.JSONObject");
    }

    public static void a(Context context, String str) {
        if (str != null) {
            cn.jiguang.bb.f.c("JWakeConfigHelper", "write wakeConfigJson:" + str);
            j.a("bwc.catch", str);
        }
    }

    public static void a(LinkedList<String> linkedList) {
        if (!c.a.f3097a || linkedList == null || linkedList.size() <= 0) {
            return;
        }
        cn.jiguang.bb.f.c("JWakeConfigHelper", "setTestUrls use wake url :" + linkedList);
        f1751d.clear();
        f1751d.addAll(linkedList);
    }
}
