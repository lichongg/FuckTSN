package com.bytedance.sdk.openadsdk.ats;

import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.rn.g;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
final class j {
    private static volatile j cw;

    /* renamed from: j, reason: collision with root package name */
    static final Map<String, Pair<Class, Boolean>> f27607j = new HashMap();
    static final Map<Class, Pair<Class, Method>> xt = new HashMap();
    private final Map<Class, SparseArray<Method>> ae;

    /* renamed from: m, reason: collision with root package name */
    private final Map<Object, Object> f27608m;

    /* renamed from: r, reason: collision with root package name */
    private final Map<String, Object> f27609r;
    private r tl;
    private final Map<Object, Object> up;

    private static void cw(Class cls) {
        for (Method method : cls.getMethods()) {
            if (((ATSMethod) method.getAnnotation(ATSMethod.class)) != null) {
                xt.put(method.getReturnType(), new Pair<>(cls, method));
            }
        }
    }

    private Object r(Object obj, Class<?> cls) {
        if (obj == null || cls == Void.class) {
            return null;
        }
        return xt.xt(cls) == null ? obj : j(obj, cls);
    }

    private static void xt(Class cls) {
        String[] value;
        ATS ats = (ATS) cls.getAnnotation(ATS.class);
        if (ats == null || (value = ats.value()) == null) {
            return;
        }
        ats.single();
        for (String str : value) {
            f27607j.put(str, new Pair<>(cls, Boolean.valueOf(ats.single())));
        }
    }

    private j() {
        xt(up.class);
        xt(cw.class);
        xt(com.bytedance.sdk.openadsdk.core.kt.cw.class);
        xt(com.bytedance.sdk.openadsdk.core.kt.r.class);
        xt(com.bytedance.sdk.openadsdk.core.ch.up.class);
        xt(g.class);
        xt(com.bytedance.sdk.component.m.cw.xt.class);
        cw(com.bytedance.sdk.openadsdk.g.j.class);
        this.f27609r = new HashMap();
        this.up = new WeakHashMap();
        this.f27608m = new WeakHashMap();
        this.ae = new HashMap();
    }

    public static j j() {
        if (cw == null) {
            synchronized (j.class) {
                try {
                    if (cw == null) {
                        cw = new j();
                    }
                } finally {
                }
            }
        }
        return cw;
    }

    private <T> T r(Class<T> cls) throws InvocationTargetException, IllegalAccessException {
        Object[] objArr;
        Pair<Class, Method> pair = xt.get(cls);
        Object obj = null;
        if (pair == null) {
            return null;
        }
        Method method = (Method) pair.second;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes == null || parameterTypes.length <= 0) {
            objArr = null;
        } else {
            objArr = new Object[parameterTypes.length];
            for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                objArr[i6] = r(parameterTypes[i6]);
            }
        }
        if (!Modifier.isStatic(method.getModifiers())) {
            try {
                obj = ((Class) pair.first).newInstance();
            } catch (Throwable unused) {
                if (this.tl != null) {
                    cls.getClass();
                }
                return null;
            }
        }
        return (T) method.invoke(obj, objArr);
    }

    private Object cw(Object obj, Class<?> cls) {
        if (obj == null || cls == Void.class) {
            return null;
        }
        return xt.xt(cls) == null ? obj : j(obj, cls);
    }

    private InvocationHandler xt(final Object obj, final Class cls) {
        return new InvocationHandler() { // from class: com.bytedance.sdk.openadsdk.ats.j.1
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) {
                Method method2;
                try {
                    method2 = method;
                    try {
                        return j.this.j(obj, obj2, method2, objArr, cls);
                    } catch (Throwable unused) {
                        if (j.this.tl == null) {
                            return null;
                        }
                        r unused2 = j.this.tl;
                        obj.getClass();
                        method2.getName();
                        return null;
                    }
                } catch (Throwable unused3) {
                    method2 = method;
                }
            }
        };
    }

    public <T> T j(Class<T> cls) {
        if (cls == null) {
            if (this.tl != null) {
                new RuntimeException("null api");
            }
            return null;
        }
        String j6 = xt.j(cls);
        if (j6 != null && j6 != "null") {
            Pair<Class, Boolean> pair = f27607j.get(j6);
            if (pair == null) {
                if (this.tl != null) {
                    new RuntimeException("clazz not register");
                }
                return null;
            }
            T t5 = (T) j(j6, pair, cls);
            if (t5 == null) {
                return null;
            }
            return t5.getClass().getClassLoader() == cls.getClassLoader() ? t5 : (T) j(t5, cls);
        }
        if (this.tl != null) {
            new RuntimeException("not decorate by ATSApi");
        }
        return null;
    }

    private Object j(Object obj, Class cls) {
        Object obj2 = this.f27608m.get(obj);
        if (obj2 != null) {
            return obj2;
        }
        Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, xt(obj, cls));
        this.f27608m.put(obj, newProxyInstance);
        return newProxyInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object j(Object obj, Object obj2, Method method, Object[] objArr, Class cls) throws Throwable {
        Annotation j6 = xt.j(cls, method);
        if (j6 == null) {
            try {
                Method declaredMethod = obj.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            } catch (Exception unused) {
                if (this.tl != null) {
                    obj.getClass();
                    method.getName();
                    method.getName();
                }
                return null;
            }
        }
        Method j7 = j(obj, ((Integer) xt.j(j6)).intValue());
        if (j7 == null) {
            if (this.tl != null) {
                obj.getClass();
                method.getName();
                method.getName();
            }
            return null;
        }
        Class<?>[] parameterTypes = j7.getParameterTypes();
        if (parameterTypes != null) {
            for (int i6 = 0; i6 < objArr.length; i6++) {
                objArr[i6] = cw(objArr[i6], parameterTypes[i6]);
            }
        }
        Object invoke = j7.invoke(obj, objArr);
        if (invoke == obj) {
            Object obj3 = this.up.get(invoke);
            if (obj3 != null) {
                return obj3;
            }
            Object r5 = r(invoke, method.getReturnType());
            this.up.put(invoke, r5);
            return r5;
        }
        return r(invoke, method.getReturnType());
    }

    private Method j(Object obj, int i6) {
        Method method;
        Class<?> cls = obj.getClass();
        SparseArray<Method> sparseArray = this.ae.get(cls);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.ae.put(cls, sparseArray);
            method = null;
        } else {
            method = sparseArray.get(i6);
        }
        return method == null ? j(cls, sparseArray, i6) : method;
    }

    private Method j(Class<?> cls, SparseArray<Method> sparseArray, int i6) {
        Method method;
        Integer num;
        Method[] methods = cls.getMethods();
        Method method2 = null;
        if (methods == null) {
            return null;
        }
        System.currentTimeMillis();
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            method = j(methods, sparseArray, i6);
        } else {
            Class cw2 = xt.cw(cls);
            if (cw2 == null) {
                return null;
            }
            for (Method method3 : methods) {
                Annotation annotation = method3.getAnnotation(cw2);
                if (annotation != null && (num = (Integer) xt.j(annotation)) != null) {
                    if (num.intValue() == i6) {
                        method2 = method3;
                    }
                    sparseArray.put(num.intValue(), method3);
                }
            }
            method = method2;
        }
        System.currentTimeMillis();
        return method;
    }

    private Method j(Method[] methodArr, SparseArray<Method> sparseArray, int i6) {
        Method method = null;
        for (Method method2 : methodArr) {
            ATSMethod aTSMethod = (ATSMethod) method2.getAnnotation(ATSMethod.class);
            if (aTSMethod != null) {
                if (aTSMethod.value() == i6) {
                    method = method2;
                }
                sparseArray.put(aTSMethod.value(), method2);
            }
        }
        return method;
    }

    private Object j(String str, Pair<Class, Boolean> pair, Class cls) {
        try {
            if (((Boolean) pair.second).booleanValue()) {
                Object obj = this.f27609r.get(str);
                if (obj != null) {
                    return obj;
                }
                try {
                    synchronized (this.f27609r) {
                        try {
                            obj = this.f27609r.get(str);
                            if (obj == null) {
                                obj = j((Class<Object>) pair.first, (Class<Object>) cls);
                                this.f27609r.put(str, obj);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return obj;
                } catch (Throwable unused) {
                    return obj;
                }
            }
            return j((Class) pair.first, cls);
        } catch (Throwable unused2) {
            return null;
        }
    }

    private <T> T j(Class<T> cls, Class<T> cls2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T t5 = (T) r(cls2);
        if (t5 != null) {
            return t5;
        }
        T t6 = (T) r(cls);
        if (t6 != null) {
            return t6;
        }
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            if (constructor.getAnnotation(ATSMethod.class) != null) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] objArr = new Object[parameterTypes.length];
                for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                    objArr[i6] = r(parameterTypes[i6]);
                }
                return (T) constructor.newInstance(objArr);
            }
        }
        return cls.newInstance();
    }
}
