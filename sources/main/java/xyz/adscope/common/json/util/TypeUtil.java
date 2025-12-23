package xyz.adscope.common.json.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class TypeUtil {
    public static boolean isWrapType(Class<?> cls) {
        return ((Class) cls.getField("TYPE").get(null)).isPrimitive();
    }

    public static boolean isBasicType(Class<?> cls) {
        if (!cls.isPrimitive() && !String.class.isAssignableFrom(cls)) {
            return isWrapType(cls);
        }
        return true;
    }
}
