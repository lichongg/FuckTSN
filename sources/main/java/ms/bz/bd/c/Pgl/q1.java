package ms.bz.bd.c.Pgl;

import io.netty.util.internal.StringUtil;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class q1 {
    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7480c0", new byte[]{29, 106, 10, 26, 97});
    }

    public static String a(String str) {
        return (str == null || str.length() <= 0) ? "" : str.trim().replace('\'', ' ').replace('\"', ' ').replace(StringUtil.CARRIAGE_RETURN, ' ').replace('\n', ' ');
    }
}
