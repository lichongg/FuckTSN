package cn.bluemobi.dylan.base.utils;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class q {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f1241a;

        /* renamed from: b, reason: collision with root package name */
        private final Class f1242b;

        Object a() {
            return this.f1241a;
        }

        Class getType() {
            return this.f1242b;
        }

        public a(Object obj, Class cls) {
            this.f1241a = obj;
            this.f1242b = cls;
        }
    }

    public static void a(Object obj, String str, a... aVarArr) {
        if (obj == null) {
            return;
        }
        try {
            Class<?>[] clsArr = aVarArr == null ? new Class[0] : new Class[aVarArr.length];
            Object[] objArr = aVarArr == null ? new Object[0] : new Object[aVarArr.length];
            if (aVarArr != null) {
                int length = clsArr.length;
                for (int i6 = 0; i6 < length; i6++) {
                    clsArr[i6] = aVarArr[i6].getType();
                    objArr[i6] = aVarArr[i6].a();
                }
            }
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, objArr);
        } catch (Throwable unused) {
        }
    }
}
