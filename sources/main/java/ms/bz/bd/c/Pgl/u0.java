package ms.bz.bd.c.Pgl;

import io.netty.handler.codec.http.HttpConstants;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class u0 extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object b(long j6, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6d6ba", new byte[]{116, HttpConstants.SEMICOLON, 26, 12, 78, 101, 43, 22, HttpConstants.SEMICOLON, 98, 101, HttpConstants.SEMICOLON, 30, 70, 19, 99, 98, 20, 123, 119, 98, HttpConstants.SEMICOLON, 3, 67, 19, 84, 65, 57, 48, 114, 96, HttpConstants.SEMICOLON, 5, 73, 105, 119, 98, 52, HttpConstants.COLON, 104, 99, 49, 15, 86, 109, 100, 106, 1, 60, 98, 114, 38, 54, 70, 92, 102, 113, 18, 39}));
            Method declaredMethod = cls.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "512e9f", new byte[]{41, 50, 83, 26, 39, 98, 24, 21, 116, 0, 55, 54, 83}), null);
            declaredMethod.setAccessible(true);
            Object newInstance = cls.newInstance();
            if (newInstance != null ? ((Boolean) declaredMethod.invoke(newInstance, null)).booleanValue() : false) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3ec650", new byte[]{HttpConstants.COMMA, 98, 7, 119, 25, 34, 34});
            }
            return null;
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "047a81", new byte[]{38, 55, 66});
            return null;
        }
    }

    u0() {
    }
}
