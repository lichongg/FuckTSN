package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class w0 {

    final class pblf extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return "np";
        }

        pblf() {
        }
    }

    final class pblg extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return "np";
        }

        pblg() {
        }
    }

    final class pbll extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sb;
            String str4 = "0";
            String str5 = "null";
            try {
                WifiInfo connectionInfo = ((WifiManager) pblv.a().c().getSystemService("wifi")).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pbla.a("6765744253534944")), null);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, null);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pbla.a("67657453534944")), null);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, null);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pbla.a("676574497041646472657373")), null);
                        declaredMethod3.setAccessible(true);
                        String num = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, null)).intValue());
                        String a6 = q1.a(str3);
                        String a7 = q1.a(str2);
                        String a8 = q1.a(num);
                        sb = new StringBuilder();
                        sb.append((a7 == null || a7.length() <= 0) ? "null" : a7.trim());
                        sb.append("[<!>]");
                        if (a6 != null && a6.length() > 0) {
                            str5 = a6.trim();
                        }
                        sb.append(str5);
                        sb.append("[<!>]");
                        if (a8 != null && a8.length() > 0) {
                            str4 = a8.trim();
                        }
                    } catch (Throwable unused) {
                        String a9 = q1.a(str3);
                        String a10 = q1.a(str2);
                        String a11 = q1.a(null);
                        sb = new StringBuilder();
                        sb.append((a10 == null || a10.length() <= 0) ? "null" : a10.trim());
                        sb.append("[<!>]");
                        if (a9 != null && a9.length() > 0) {
                            str5 = a9.trim();
                        }
                        sb.append(str5);
                        sb.append("[<!>]");
                        if (a11 != null && a11.length() > 0) {
                            str4 = a11.trim();
                        }
                        sb.append(str4);
                        sb.append("[<!>]");
                        return sb.toString().trim();
                    }
                } catch (Throwable unused2) {
                    str3 = null;
                }
            } catch (Throwable unused3) {
                str2 = null;
                str3 = null;
            }
            sb.append(str4);
            sb.append("[<!>]");
            return sb.toString().trim();
        }

        pbll() {
        }
    }

    final class pblb extends pbly.pgla {
        pblb() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            a1.b(pblv.a().c());
            return null;
        }
    }

    final class pblc extends pbly.pgla {
        pblc() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return a1.b(pblv.a().c()).a();
        }
    }

    final class pbld extends pbly.pgla {
        pbld() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return j1.b(pblv.a().c());
        }
    }

    final class pble extends pbly.pgla {
        pble() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return i1.a(pblv.a().c());
        }
    }

    final class pblh extends pbly.pgla {
        pblh() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return h1.a(pblv.a().c());
        }
    }

    final class pbli extends pbly.pgla {
        pbli() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return h1.b(pblv.a().c());
        }
    }

    final class pblj extends pbly.pgla {
        pblj() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return ms.bz.bd.c.Pgl.pblh.b();
        }
    }

    final class pblk extends pbly.pgla {
        pblk() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return k1.a(pblv.a().c());
        }
    }

    final class pblm extends pbly.pgla {
        pblm() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return j1.a(pblv.a().c());
        }
    }

    final class pgla extends pbly.pgla {
        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object b(long j6, String str, Object obj) throws Throwable {
            return null;
        }

        pgla() {
        }
    }

    public static void a() {
        pbly.b(268435457, new pble());
        pbly.b(268435458, new pblf());
        pbly.b(268435459, new pblg());
        pbly.b(268435460, new pblh());
        pbly.b(268435461, new pbli());
        pbly.b(268435462, new pblj());
        pbly.b(268435463, new pblk());
        pbly.b(268435464, new pbll());
        pbly.b(268435465, new pblm());
        pbly.b(268435466, new pgla());
        pbly.b(268435467, new pblb());
        pbly.b(268435468, new pblc());
        pbly.b(268435469, new pbld());
    }
}
