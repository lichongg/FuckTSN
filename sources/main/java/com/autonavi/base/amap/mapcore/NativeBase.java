package com.autonavi.base.amap.mapcore;

import androidx.activity.k;
import com.amap.api.col.p0003l.c3;
import com.amap.api.col.p0003l.d3;
import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class NativeBase {
    private static final String CREATE_OVERLAY = "createOverlay";
    private static final int LOG_SIZE = 10;
    private static final int STACK_NUMBER = 3;
    private static final String UPDATE_OPTIONS = "updateOptions";
    private boolean mCalledFuntion = false;
    protected boolean useRunnable = true;
    protected volatile boolean destroy = false;
    private int logSizeCount = 1;
    ArrayList<Method> methodMap = new ArrayList<>();
    ArrayList<NativeFunctionRunnable> runnableArrayList = new ArrayList<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Method {
        private boolean baseClass;
        private Class<?>[] clazz;
        private String methodName;
        private Object object;
        private Object[] param;

        public Method(Object obj, String str, boolean z5, Object... objArr) {
            this.object = obj;
            this.methodName = str;
            this.baseClass = z5;
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        this.clazz = new Class[objArr.length];
                        if (("createOverlay".equals(str) || "updateOptions".equals(str)) ? true : z5) {
                            for (int i6 = 0; i6 < objArr.length; i6++) {
                                if (i6 == 1) {
                                    this.clazz[i6] = objArr[i6].getClass().getSuperclass();
                                } else {
                                    this.clazz[i6] = objArr[i6].getClass();
                                }
                            }
                        } else {
                            for (int i7 = 0; i7 < objArr.length; i7++) {
                                this.clazz[i7] = objArr[i7].getClass();
                            }
                        }
                        this.param = new Object[objArr.length];
                        for (int i8 = 0; i8 < objArr.length; i8++) {
                            this.param[i8] = objArr[i8];
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void callAllFunction() {
        java.lang.reflect.Method declaredMethod;
        Runnable runnable;
        if (isReady() && !this.destroy) {
            if (this.mCalledFuntion) {
                return;
            }
            try {
                this.mCalledFuntion = true;
                if (this.useRunnable) {
                    while (this.runnableArrayList.size() > 0 && !this.destroy) {
                        NativeFunctionRunnable nativeFunctionRunnable = this.runnableArrayList.get(0);
                        if (nativeFunctionRunnable != null && (runnable = nativeFunctionRunnable.getRunnable()) != null) {
                            runnable.run();
                        }
                        this.runnableArrayList.remove(0);
                    }
                    this.logSizeCount = 1;
                    return;
                }
                Iterator<Method> it = this.methodMap.iterator();
                while (it.hasNext()) {
                    Method next = it.next();
                    if (this.destroy) {
                        break;
                    }
                    if (next.object != null && (declaredMethod = next.object.getClass().getDeclaredMethod(next.methodName, next.clazz)) != null) {
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(next.object, next.param);
                    }
                }
                this.methodMap.clear();
            } catch (Throwable unused) {
            }
        }
    }

    protected abstract void createNative();

    public void destroy() {
        this.destroy = true;
        synchronized (this) {
            this.runnableArrayList.clear();
            this.methodMap.clear();
        }
    }

    protected abstract void finalizeNative();

    protected abstract long getNative();

    public synchronized void storeUncallFunction(Object obj, Object obj2, String str, String str2, Object... objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                NativeFunctionRunnable nativeFunctionRunnable = new NativeFunctionRunnable(str2, str, (Runnable) obj2);
                synchronized (this.runnableArrayList) {
                    try {
                        int size = this.runnableArrayList.size();
                        if (size > this.logSizeCount * 10) {
                            d3.m(c3.f5804d, "storeUncallFunction size = ".concat(String.valueOf(size)));
                            this.logSizeCount++;
                        }
                        int findRunnableIndex = findRunnableIndex(nativeFunctionRunnable);
                        if (findRunnableIndex >= 0) {
                            this.runnableArrayList.remove(findRunnableIndex);
                        }
                        this.runnableArrayList.add(nativeFunctionRunnable);
                    } finally {
                    }
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public synchronized void storeUncallFunctionArray(Object obj, Object obj2, String[] strArr, String str, Object[] objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                StringBuilder sb = new StringBuilder("");
                for (String str2 : strArr) {
                    sb.append(str2);
                    sb.append(",");
                }
                NativeFunctionRunnable nativeFunctionRunnable = new NativeFunctionRunnable(str, sb.toString(), (Runnable) obj2);
                synchronized (this.runnableArrayList) {
                    try {
                        int size = this.runnableArrayList.size();
                        if (size > this.logSizeCount * 10) {
                            d3.m(c3.f5804d, "storeUncallFunctionArray size = ".concat(String.valueOf(size)));
                            this.logSizeCount++;
                        }
                        int findRunnableIndex = findRunnableIndex(nativeFunctionRunnable);
                        if (findRunnableIndex >= 0) {
                            this.runnableArrayList.remove(findRunnableIndex);
                        }
                        this.runnableArrayList.add(nativeFunctionRunnable);
                    } finally {
                    }
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public int findRunnableIndex(NativeFunctionRunnable nativeFunctionRunnable) {
        if (this.runnableArrayList == null || nativeFunctionRunnable == null) {
            return -1;
        }
        for (int i6 = 0; i6 < this.runnableArrayList.size(); i6++) {
            NativeFunctionRunnable nativeFunctionRunnable2 = this.runnableArrayList.get(i6);
            if (nativeFunctionRunnable2 != null && nativeFunctionRunnable2.getKey().equals(nativeFunctionRunnable.getKey())) {
                return i6;
            }
        }
        return -1;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            finalizeNative();
        } catch (Throwable th) {
            th.toString();
        }
    }

    protected boolean isReady() {
        if (getNative() != 0) {
            return true;
        }
        return false;
    }

    public void validate() {
        ParameterIsClass parameterIsClass;
        Class<?>[] parameterTypes;
        java.lang.reflect.Method[] methods = getClass().getMethods();
        if (methods != null) {
            for (java.lang.reflect.Method method : methods) {
                if (method.isAnnotationPresent(ParameterIsClass.class) && (parameterIsClass = (ParameterIsClass) method.getAnnotation(ParameterIsClass.class)) != null && parameterIsClass.required() && (parameterTypes = method.getParameterTypes()) != null) {
                    for (Class<?> cls : parameterTypes) {
                        if (!k.a(cls)) {
                            throw new RuntimeException("函数：" + method + " 参数不是对象类型");
                        }
                    }
                }
            }
        }
    }
}
