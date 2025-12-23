package cn.easyar;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RefBase implements Cloneable {
    protected long cdata_;

    private static native void _c(Class<?> type, ArrayList<String> values);

    private native void _dtor();

    private native long _retain();

    private static native void _t(Class<?> type, ArrayList<String> values);

    private static String b(Class<?>[] parameterTypes, Class<?> returnType) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (Class<?> cls : parameterTypes) {
            sb.append(c(cls));
        }
        sb.append(")");
        sb.append(c(returnType));
        return sb.toString();
    }

    public Object clone() {
        if (this.cdata_ == 0) {
            throw new IllegalStateException("ObjectDisposed");
        }
        try {
            RefBase refBase = (RefBase) super.clone();
            refBase.cdata_ = _retain();
            return refBase;
        } catch (CloneNotSupportedException e6) {
            throw new RuntimeException(e6);
        }
    }

    protected RefBase(long ptr, RefBase dummy) {
        this.cdata_ = ptr;
    }

    private static String c(Class<?> type) {
        if (type.isPrimitive()) {
            if (type == Void.TYPE) {
                return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
            }
            if (type == Boolean.TYPE) {
                return "Z";
            }
            if (type == Byte.TYPE) {
                return "B";
            }
            if (type == Character.TYPE) {
                return "C";
            }
            if (type == Short.TYPE) {
                return ExifInterface.LATITUDE_SOUTH;
            }
            if (type == Integer.TYPE) {
                return "I";
            }
            if (type == Long.TYPE) {
                return "J";
            }
            if (type == Float.TYPE) {
                return "F";
            }
            if (type == Double.TYPE) {
                return "D";
            }
            throw new IllegalStateException("PrimitiveNotSupported");
        }
        if (type.isArray()) {
            return "[" + c(type.getComponentType());
        }
        return "L" + type.getName().replace('.', '/') + ";";
    }

    public static void e(Class<?> type) {
        String str;
        String str2;
        String replace = type.getName().replace('.', '/');
        Annotation[] annotations = type.getAnnotations();
        int length = annotations.length;
        int i6 = 0;
        while (true) {
            if (i6 < length) {
                Annotation annotation = annotations[i6];
                if (annotation.annotationType() == TypeId.class) {
                    str = ((TypeId) annotation).value();
                    break;
                }
                i6++;
            } else {
                str = null;
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(replace);
            arrayList.add(str);
            for (Method method : type.getDeclaredMethods()) {
                String name = method.getName();
                Annotation[] annotations2 = method.getAnnotations();
                int length2 = annotations2.length;
                int i7 = 0;
                while (true) {
                    if (i7 < length2) {
                        Annotation annotation2 = annotations2[i7];
                        if (annotation2.annotationType() == MethodId.class) {
                            str2 = ((MethodId) annotation2).value();
                            break;
                        }
                        i7++;
                    } else {
                        str2 = null;
                        break;
                    }
                }
                if (str2 != null) {
                    arrayList.add(name);
                    arrayList.add(str2);
                    arrayList.add(b(method.getParameterTypes(), method.getReturnType()));
                }
            }
            _c(type, arrayList);
            return;
        }
        throw new IllegalStateException("MissingTypeId");
    }

    public static void f(Class<?> type) {
        String str;
        String str2;
        String replace = type.getName().replace('.', '/');
        Annotation[] declaredAnnotations = type.getDeclaredAnnotations();
        int length = declaredAnnotations.length;
        int i6 = 0;
        while (true) {
            if (i6 < length) {
                Annotation annotation = declaredAnnotations[i6];
                if (annotation.annotationType() == TypeId.class) {
                    str = ((TypeId) annotation).value();
                    break;
                }
                i6++;
            } else {
                str = null;
                break;
            }
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(replace);
            arrayList.add(str);
            for (Method method : type.getDeclaredMethods()) {
                String name = method.getName();
                Annotation[] declaredAnnotations2 = method.getDeclaredAnnotations();
                int length2 = declaredAnnotations2.length;
                int i7 = 0;
                while (true) {
                    if (i7 < length2) {
                        Annotation annotation2 = declaredAnnotations2[i7];
                        if (annotation2.annotationType() == MethodId.class) {
                            str2 = ((MethodId) annotation2).value();
                            break;
                        }
                        i7++;
                    } else {
                        str2 = null;
                        break;
                    }
                }
                if (str2 != null) {
                    arrayList.add(name);
                    arrayList.add(str2);
                    arrayList.add(b(method.getParameterTypes(), method.getReturnType()));
                }
            }
            _t(type, arrayList);
            return;
        }
        throw new IllegalStateException("MissingTypeId");
    }

    public void a() {
        _dtor();
    }

    protected void finalize() throws Throwable {
        a();
        super.finalize();
    }
}
