package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\Downloads\app\classes8.dex */
final class w extends pbly.pgla {
    w() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object b(long j6, String str, Object obj) throws Throwable {
        Throwable b6 = p1.a().b();
        if (b6 == null) {
            return null;
        }
        StackTraceElement[] stackTrace = b6.getStackTrace();
        if (stackTrace.length < 4) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 1; i6 < 4; i6++) {
            StackTraceElement stackTraceElement = stackTrace[i6];
            if (stackTraceElement != null && !TextUtils.isEmpty(stackTraceElement.getClassName())) {
                Class<?> cls = Class.forName(stackTrace[i6].getClassName());
                p1 a6 = p1.a();
                String methodName = stackTrace[i6].getMethodName();
                a6.getClass();
                ArrayList arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(methodName)) {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method != null && method.getName().equals(methodName)) {
                            arrayList2.add(method);
                        }
                    }
                }
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }
}
