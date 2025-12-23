package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import okio.Buffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class f0 {

    /* renamed from: a, reason: collision with root package name */
    static final Type[] f52123a = new Type[0];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class a implements GenericArrayType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f52124a;

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && f0.d(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.f52124a;
        }

        public int hashCode() {
            return this.f52124a.hashCode();
        }

        public String toString() {
            return f0.t(this.f52124a) + "[]";
        }

        a(Type type) {
            this.f52124a = type;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b implements ParameterizedType {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final Type f52125a;

        /* renamed from: b, reason: collision with root package name */
        private final Type f52126b;

        /* renamed from: c, reason: collision with root package name */
        private final Type[] f52127c;

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && f0.d(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.f52127c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        @Nullable
        public Type getOwnerType() {
            return this.f52125a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f52126b;
        }

        public int hashCode() {
            int hashCode = Arrays.hashCode(this.f52127c) ^ this.f52126b.hashCode();
            Type type = this.f52125a;
            return hashCode ^ (type != null ? type.hashCode() : 0);
        }

        public String toString() {
            Type[] typeArr = this.f52127c;
            if (typeArr.length == 0) {
                return f0.t(this.f52126b);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(f0.t(this.f52126b));
            sb.append("<");
            sb.append(f0.t(this.f52127c[0]));
            for (int i6 = 1; i6 < this.f52127c.length; i6++) {
                sb.append(", ");
                sb.append(f0.t(this.f52127c[i6]));
            }
            sb.append(">");
            return sb.toString();
        }

        b(@Nullable Type type, Type type2, Type... typeArr) {
            boolean z5;
            if (type2 instanceof Class) {
                if (type == null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5 != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                f0.b(type3);
            }
            this.f52125a = type;
            this.f52126b = type2;
            this.f52127c = (Type[]) typeArr.clone();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class c implements WildcardType {

        /* renamed from: a, reason: collision with root package name */
        private final Type f52128a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Type f52129b;

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && f0.d(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.f52129b;
            return type != null ? new Type[]{type} : f0.f52123a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.f52128a};
        }

        public int hashCode() {
            Type type = this.f52129b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f52128a.hashCode() + 31);
        }

        public String toString() {
            if (this.f52129b != null) {
                return "? super " + f0.t(this.f52129b);
            }
            if (this.f52128a == Object.class) {
                return "?";
            }
            return "? extends " + f0.t(this.f52128a);
        }

        c(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length <= 1) {
                if (typeArr.length == 1) {
                    if (typeArr2.length == 1) {
                        typeArr2[0].getClass();
                        f0.b(typeArr2[0]);
                        if (typeArr[0] == Object.class) {
                            this.f52129b = typeArr2[0];
                            this.f52128a = Object.class;
                            return;
                        }
                        throw new IllegalArgumentException();
                    }
                    typeArr[0].getClass();
                    f0.b(typeArr[0]);
                    this.f52129b = null;
                    this.f52128a = typeArr[0];
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException();
        }
    }

    static boolean d(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return d(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    private static int k(Object[] objArr, Object obj) {
        for (int i6 = 0; i6 < objArr.length; i6++) {
            if (obj.equals(objArr[i6])) {
                return i6;
            }
        }
        throw new NoSuchElementException();
    }

    static boolean l(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    static RuntimeException m(Method method, String str, Object... objArr) {
        return n(method, null, str, objArr);
    }

    static ResponseBody a(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().readAll(buffer);
        return ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), buffer);
    }

    static void b(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    static Type e(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i6 = 0; i6 < length; i6++) {
                Class<?> cls3 = interfaces[i6];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i6];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return e(cls.getGenericInterfaces()[i6], interfaces[i6], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return e(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    static Class<?> h(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(h(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    static boolean j(@Nullable Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (j(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return j(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    static RuntimeException o(Method method, int i6, String str, Object... objArr) {
        return m(method, str + " (parameter #" + (i6 + 1) + ")", objArr);
    }

    static RuntimeException p(Method method, Throwable th, int i6, String str, Object... objArr) {
        return n(method, th, str + " (parameter #" + (i6 + 1) + ")", objArr);
    }

    static Type q(Type type, Class<?> cls, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type3;
            Type r5 = r(type, cls, typeVariable);
            if (r5 == typeVariable) {
                return r5;
            }
            type3 = r5;
        }
        if (type3 instanceof Class) {
            Class cls2 = (Class) type3;
            if (cls2.isArray()) {
                Class<?> componentType = cls2.getComponentType();
                Type q5 = q(type, cls, componentType);
                return componentType == q5 ? cls2 : new a(q5);
            }
        }
        if (type3 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type3;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type q6 = q(type, cls, genericComponentType);
            return genericComponentType == q6 ? genericArrayType : new a(q6);
        }
        if (type3 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type3;
            Type ownerType = parameterizedType.getOwnerType();
            Type q7 = q(type, cls, ownerType);
            boolean z5 = q7 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i6 = 0; i6 < length; i6++) {
                Type q8 = q(type, cls, actualTypeArguments[i6]);
                if (q8 != actualTypeArguments[i6]) {
                    if (!z5) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z5 = true;
                    }
                    actualTypeArguments[i6] = q8;
                }
            }
            return z5 ? new b(q7, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        boolean z6 = type3 instanceof WildcardType;
        Type type4 = type3;
        if (z6) {
            WildcardType wildcardType = (WildcardType) type3;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type q9 = q(type, cls, lowerBounds[0]);
                type4 = wildcardType;
                if (q9 != lowerBounds[0]) {
                    return new c(new Type[]{Object.class}, new Type[]{q9});
                }
            } else {
                type4 = wildcardType;
                if (upperBounds.length == 1) {
                    Type q10 = q(type, cls, upperBounds[0]);
                    type4 = wildcardType;
                    if (q10 != upperBounds[0]) {
                        return new c(new Type[]{q10}, f52123a);
                    }
                }
            }
        }
        return type4;
    }

    static void s(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    private f0() {
    }

    @Nullable
    private static Class<?> c(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static Type f(int i6, ParameterizedType parameterizedType) {
        Type type = parameterizedType.getActualTypeArguments()[i6];
        if (type instanceof WildcardType) {
            return ((WildcardType) type).getLowerBounds()[0];
        }
        return type;
    }

    static Type g(int i6, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i6 >= 0 && i6 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i6];
            if (type instanceof WildcardType) {
                return ((WildcardType) type).getUpperBounds()[0];
            }
            return type;
        }
        throw new IllegalArgumentException("Index " + i6 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    static Type i(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return q(type, cls, e(type, cls, cls2));
        }
        throw new IllegalArgumentException();
    }

    static RuntimeException n(Method method, @Nullable Throwable th, String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + method.getDeclaringClass().getSimpleName() + "." + method.getName(), th);
    }

    private static Type r(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> c6 = c(typeVariable);
        if (c6 != null) {
            Type e6 = e(type, cls, c6);
            if (e6 instanceof ParameterizedType) {
                return ((ParameterizedType) e6).getActualTypeArguments()[k(c6.getTypeParameters(), typeVariable)];
            }
        }
        return typeVariable;
    }
}
