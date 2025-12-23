package cn.jiguang.bg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import cn.jiguang.bz.v;
import cn.jiguang.bz.w;
import cn.jiguang.bz.y;
import cn.jiguang.internal.JConstants;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.ErrorCode;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static String f2070a;

    /* renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f2071b;

    public static class a {
        private static JSONObject a(int i6, String str) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("e_code", i6);
            if (str == null) {
                str = "";
            }
            jSONObject.put("e_msg", str);
            return jSONObject;
        }

        public static void a(Context context, int i6, String str) {
            if (context == null) {
                context = cn.jiguang.bz.d.a();
            }
            if (context == null) {
                cn.jiguang.bb.f.i("ConnectingHelper", "report failed: context is null");
            } else if (((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.m())).booleanValue()) {
                try {
                    cn.jiguang.be.b.a(context, a(i6, str), "tcp_exception");
                } catch (Throwable th) {
                    cn.jiguang.bb.f.d("ConnectingHelper", "Failed to report TCP exception", th);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r25, cn.jiguang.bl.a r26) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bg.c.a(android.content.Context, cn.jiguang.bl.a):int");
    }

    public static int b(Context context, cn.jiguang.bl.a aVar) {
        Object obj;
        String e6 = e(context);
        String str = cn.jiguang.bn.a.a(context).f2369a;
        String f6 = f(context);
        String g6 = g(context);
        long b6 = cn.jiguang.bi.b.a().b();
        String d6 = cn.jiguang.d.a.d(context);
        cn.jiguang.bb.f.c("ConnectingHelper", "Register with: \n key:" + e6 + "\n apkVersion:" + str + "\n clientInfo:" + f6 + "\n extKey:" + g6 + "\n reg business:" + b6 + "\n accountId:" + d6);
        byte[] a6 = cn.jiguang.bk.b.a(context, cn.jiguang.bk.b.a(c(context), e6, str, f6, g6, b6, d6));
        cn.jiguang.bq.b a7 = cn.jiguang.bq.b.a();
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.f2343h);
        sb.append(":");
        sb.append(aVar.f2344i);
        a7.b(sb.toString(), "register", (long) a6.length);
        if (aVar.a(a6) != 0) {
            cn.jiguang.bb.f.k("ConnectingHelper", "Register failed - send reg info failed");
            a.a(context, 1001, "Register failed - send reg info failed");
            return -2;
        }
        try {
            ByteBuffer a8 = aVar.a(20000);
            if (a8 == null) {
                cn.jiguang.bb.f.k("ConnectingHelper", "Register failed - recv buffer null");
                a.a(context, 1005, "Register failed - recv buffer null");
                return -6;
            }
            Pair<cn.jiguang.bk.c, ByteBuffer> a9 = cn.jiguang.bk.a.a(context, a8.array(), "");
            if (a9 == null || (obj = a9.first) == null || a9.second == null || ((cn.jiguang.bk.c) obj).f2311c != 0) {
                cn.jiguang.bb.f.j("ConnectingHelper", "Register failed - can't parse a Register Response");
                a.a(context, 1003, "Register failed - can't parse a Register Response");
                cn.jiguang.bq.b.a().c(aVar.f2343h + ":" + aVar.f2344i, "unknown_register", a8.array().length);
                return -4;
            }
            cn.jiguang.bq.b.a().c(aVar.f2343h + ":" + aVar.f2344i, "register", a8.array().length);
            cn.jiguang.bk.e eVar = new cn.jiguang.bk.e((cn.jiguang.bk.c) a9.first, (ByteBuffer) a9.second);
            cn.jiguang.bb.f.c("ConnectingHelper", "register response:" + eVar);
            int i6 = eVar.f2326a;
            cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ag().a((cn.jiguang.e.a<Integer>) Integer.valueOf(i6))});
            if (i6 != 0) {
                if (10000 == i6) {
                    a.a(context, 1004, "respCode == 10000, err code bytebuffer parse");
                }
                return i6;
            }
            long j6 = eVar.f2327b;
            String str2 = eVar.f2328c;
            String str3 = eVar.f2329d;
            String str4 = eVar.f2330e;
            cn.jiguang.bb.f.h("ConnectingHelper", "Register succeed - juid:" + j6 + ", registrationId:" + str3 + ", deviceId:" + str4);
            if (w.a(str3) || 0 == j6) {
                cn.jiguang.bb.f.n("ConnectingHelper", "Unexpected: registrationId/juid should not be empty. ");
                return -5;
            }
            cn.jiguang.be.b.a(context, str4);
            cn.jiguang.be.b.a(context, j6, str2, str3);
            cn.jiguang.ba.k.a(context, str4, j6, str2, str3);
            new cn.jiguang.bn.c().e(f2070a).b(context);
            return i6;
        } catch (cn.jiguang.bi.e e7) {
            cn.jiguang.bb.f.k("ConnectingHelper", "Register failed - recv msg failed with error:" + e7);
            a.a(context, 1002, "Register failed - recv msg failed with error:" + e7);
            return -3;
        }
    }

    private static String a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            if (i6 > 0) {
                sb.append(Logger.f33116c);
            }
            sb.append(jSONArray.optInt(i6));
        }
        return sb.toString();
    }

    private static String b(String str, String str2) {
        return !w.a(str) ? str : str2;
    }

    public static synchronized long c(Context context) {
        long j6;
        synchronized (c.class) {
            try {
                long longValue = ((Long) cn.jiguang.e.b.a(context, cn.jiguang.e.a.ao())).longValue();
                if (longValue == -1) {
                    longValue = Math.abs(new SecureRandom().nextInt(10000));
                }
                j6 = (longValue + (longValue % 2 == 0 ? 1L : 2L)) % 10000;
                cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.ao().a((cn.jiguang.e.a<Long>) Long.valueOf(j6))});
            } catch (Throwable th) {
                throw th;
            }
        }
        return j6;
    }

    public static synchronized boolean d(Context context) {
        boolean z5;
        synchronized (c.class) {
            try {
                if (f2071b == null) {
                    if (context == null) {
                        context = cn.jiguang.bz.d.a(null);
                    }
                    boolean booleanValue = ((Boolean) cn.jiguang.e.b.a(context, cn.jiguang.e.a.j())).booleanValue();
                    if (booleanValue) {
                        booleanValue = !TextUtils.isEmpty(cn.jiguang.ba.j.a());
                    }
                    f2071b = new AtomicBoolean(booleanValue);
                    cn.jiguang.bb.f.c("ConnectingHelper", "use tcp ssl state: " + f2071b.get());
                }
            } catch (Throwable unused) {
                f2071b = new AtomicBoolean(false);
                cn.jiguang.bb.f.i("ConnectingHelper", "use tcp ssl default state: false");
            }
            z5 = f2071b.get();
        }
        return z5;
    }

    private static String g(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONObject f6;
        try {
            String str7 = cn.jiguang.bn.a.a(context).f2378j;
            if ("unknown".equalsIgnoreCase(str7)) {
                str7 = " ";
            }
            String a6 = cn.jiguang.bz.h.a(context);
            int i6 = cn.jiguang.bz.h.f2740a;
            String str8 = cn.jiguang.bn.a.a(context).f2384p;
            String str9 = cn.jiguang.bn.a.a(context).f2377i;
            String b6 = cn.jiguang.bz.a.a().b(context, "", false);
            JSONObject a7 = cn.jiguang.x.a.a(context);
            if (a7 != null) {
                cn.jiguang.bb.f.c("ConnectingHelper", "parse ids:" + a7.toString());
                str2 = a7.optString("udid", "");
                str3 = a7.optString("joad", "");
                str4 = a7.optString("jvad", "");
                str5 = a7.optString("jaad", "");
                str = a7.optString("jgad", "");
            } else {
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
                str5 = str4;
            }
            try {
                f6 = cn.jiguang.u.a.f(context);
            } catch (Throwable unused) {
            }
            if (f6 != null) {
                str6 = f6.optString("new_cid_all");
                return i6 + "$$" + b(a6, " ") + "$$" + b(str8, " ") + "$$" + b(str9, " ") + "$$" + b(b6, " ") + "$$" + b(str7, " ") + "$$" + b(str2, " ") + "$$" + b(str3, " ") + "$$" + b(str4, " ") + "$$" + b(str5, " ") + "$$" + b(str, " ") + "$$" + b(str6, " ");
            }
            str6 = "";
            return i6 + "$$" + b(a6, " ") + "$$" + b(str8, " ") + "$$" + b(str9, " ") + "$$" + b(b6, " ") + "$$" + b(str7, " ") + "$$" + b(str2, " ") + "$$" + b(str3, " ") + "$$" + b(str4, " ") + "$$" + b(str5, " ") + "$$" + b(str, " ") + "$$" + b(str6, " ");
        } catch (Exception unused2) {
            return "";
        }
    }

    private static String h(Context context) {
        String str = JConstants.testCountry;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = (String) cn.jiguang.e.b.a(context, cn.jiguang.e.a.K());
        return !TextUtils.isEmpty(str2) ? str2 : cn.jiguang.bz.a.i(context);
    }

    public static void a(Context context) {
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.aq().a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.ar().a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.d(false).a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.d(true).a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.av().a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.as().a((cn.jiguang.e.a<Boolean>) null), cn.jiguang.e.a.at().a((cn.jiguang.e.a<Long>) null), cn.jiguang.e.a.b(true).a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.b(false).a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.c(true).a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.c(false).a((cn.jiguang.e.a<String>) null)});
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.B().a((cn.jiguang.e.a<Long>) null), cn.jiguang.e.a.C().a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.E().a((cn.jiguang.e.a<String>) null)});
    }

    public static void b(Context context) {
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.c(true).a((cn.jiguang.e.a<String>) null), cn.jiguang.e.a.c(false).a((cn.jiguang.e.a<String>) null)});
    }

    private static String e(Context context) {
        String a6 = cn.jiguang.bn.e.a(context);
        f2070a = a6;
        return b(a6, " ") + "$$" + b(cn.jiguang.bn.a.a(context).f2383o, " ") + "$$" + context.getPackageName() + "$$" + cn.jiguang.d.a.e(context);
    }

    private static String f(Context context) {
        String e6 = cn.jiguang.bi.b.a().e();
        cn.jiguang.bb.f.c("ConnectingHelper", "regVersion:" + e6);
        cn.jiguang.bn.a a6 = cn.jiguang.bn.a.a(context);
        return b(a6.f2370b, " ") + "$$" + b(a6.f2371c, " ") + "$$" + b(a6.f2372d, " ") + "$$" + b(a6.f2373e, " ") + "$$" + b(cn.jiguang.d.a.h(context), " ") + "$$" + e6 + "$$" + a6.f2375g + "$$" + a6.f2376h + "$$" + a6.f2380l + "$$" + a6.f2385q + ContainerUtils.FIELD_DELIMITER + a6.f2386r + "$$" + cn.jiguang.ba.k.a(context);
    }

    public static void a(Context context, int i6) {
        a(context, i6, true);
    }

    public static void a(Context context, int i6, boolean z5) {
        if (z5) {
            String a6 = cn.jiguang.bn.d.a(i6);
            cn.jiguang.bb.f.n("ConnectingHelper", "Register Failed with server error - code:" + i6);
            if (!TextUtils.isEmpty(a6)) {
                cn.jiguang.bb.f.k("ConnectingHelper", "Local error description: " + a6);
            }
            cn.jiguang.bi.b.a().a(context, 0, i6, a6);
        }
        String e6 = cn.jiguang.d.a.e(context);
        if (i6 != 11) {
            if (i6 == 1012) {
                a(context);
                return;
            }
            if (i6 == 10001) {
                cn.jiguang.bz.a.a(context, " 未在manifest中配置AppKey", -1);
                return;
            }
            switch (i6) {
                case 1005:
                    cn.jiguang.bz.a.a(context, "包名: " + context.getPackageName() + " 与 AppKey:" + e6 + "不匹配", -1);
                    break;
                case 1006:
                    cn.jiguang.bz.a.a(context, "包名: " + context.getPackageName() + " 不存在", -1);
                    break;
                case 1007:
                    cn.jiguang.bb.f.f("ConnectingHelper", "IMEI is duplicated reported by server. Give up now. ");
                    break;
                case 1008:
                    cn.jiguang.bz.a.a(context, " AppKey:" + e6 + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致", -1);
                    break;
                case 1009:
                    cn.jiguang.bz.a.a(context, " AppKey:" + e6 + " 非android AppKey", -1);
                    break;
                default:
                    cn.jiguang.bb.f.h("ConnectingHelper", "Unhandled server response error code - " + i6);
                    break;
            }
        }
    }

    private static void a(Context context, long j6) {
        if (j6 > 0) {
            String a6 = v.a("" + j6, cn.jiguang.a.a.f1451i);
            if (TextUtils.isEmpty(a6)) {
                return;
            }
            new String(Base64.encode(a6.getBytes(), 2));
        }
    }

    public static void a(Context context, boolean z5) {
        cn.jiguang.bb.f.c("ConnectingHelper", "setUseTcpSsl state: " + z5);
        cn.jiguang.e.b.a(context, (cn.jiguang.e.a<?>[]) new cn.jiguang.e.a[]{cn.jiguang.e.a.j().a((cn.jiguang.e.a<Boolean>) Boolean.valueOf(z5))});
    }

    public static void a(boolean z5) {
        cn.jiguang.bb.f.c("ConnectingHelper", "changeLocalTcpSslState, state: " + z5);
        AtomicBoolean atomicBoolean = f2071b;
        if (atomicBoolean == null) {
            f2071b = new AtomicBoolean(z5);
        } else {
            atomicBoolean.set(z5);
        }
    }

    private static synchronized byte[] a(String str, int i6, byte[] bArr, boolean z5, int i7) {
        byte[] b6;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str) || str.length() != 2 || bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("flag or body length error");
            }
            cn.jiguang.bn.b bVar = new cn.jiguang.bn.b(300);
            bVar.b(0);
            bVar.a(str.getBytes());
            bVar.a(i6);
            bVar.b(i7);
            bVar.a(bArr);
            bVar.b(bVar.a(), 0);
            bVar.a((int) ((byte) ((z5 ? (byte) 1 : (byte) 0) | 16)), 4);
            b6 = bVar.b();
        }
        return b6;
    }

    public static byte[] a(String str, String str2) {
        boolean z5;
        byte[] a6;
        byte[] j6 = w.j(str2);
        try {
            a6 = y.a(j6);
        } catch (IOException unused) {
        }
        if (a6.length < j6.length) {
            j6 = a6;
            z5 = true;
            int length = j6.length;
            int a7 = v.a();
            String a8 = v.a(a7);
            return a(str, a7, v.a(j6, a8, a8.substring(0, 16), true), z5, length);
        }
        z5 = false;
        int length2 = j6.length;
        int a72 = v.a();
        String a82 = v.a(a72);
        return a(str, a72, v.a(j6, a82, a82.substring(0, 16), true), z5, length2);
    }

    public static byte[] a(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        datagramSocket.setSoTimeout(ErrorCode.UNKNOWN_ERROR);
        datagramSocket.send(datagramPacket);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
        cn.jiguang.bb.f.d("ConnectingHelper", "udp Receiving...");
        datagramSocket.receive(datagramPacket2);
        int length = datagramPacket2.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(datagramPacket2.getData(), 0, bArr, 0, length);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new cn.jiguang.bi.e(4, "response is empty!");
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.getShort();
            wrap.getShort();
            int i6 = wrap.getInt();
            int i7 = i6 >>> 24;
            long j6 = i6 & 16777215;
            wrap.getShort();
            int remaining = wrap.remaining();
            byte[] bArr2 = new byte[remaining];
            wrap.get(bArr2, 0, remaining);
            if (j6 != 0) {
                String a6 = v.a(j6);
                try {
                    bArr2 = v.a(bArr2, a6, a6.substring(0, 16), false);
                    if (bArr2 == null) {
                        throw new cn.jiguang.bi.e(5, "decrypt response error");
                    }
                } catch (Exception unused) {
                    throw new cn.jiguang.bi.e(5, "decrypt response error");
                }
            }
            if ((i7 & 1) == 1) {
                try {
                    return y.b(bArr2);
                } catch (IOException unused2) {
                }
            }
            return bArr2;
        } catch (Throwable th) {
            throw new cn.jiguang.bi.e(4, "parse head error:" + th.getMessage());
        }
    }
}
