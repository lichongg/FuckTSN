package com.bytedance.msdk.m;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.up.m;
import com.bytedance.sdk.component.utils.vl;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static final Map<String, Boolean> f25181j = new ConcurrentHashMap();

    static final synchronized void j(String str) {
        synchronized (xt.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            f25181j.put(str, Boolean.TRUE);
        }
    }

    public static final synchronized boolean xt(String str) {
        synchronized (xt.class) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = f25181j.get(str);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    public static synchronized void j(Context context) {
        synchronized (xt.class) {
            List<com.bytedance.msdk.core.oq.j> xt = com.bytedance.msdk.ae.j.xt.j().xt();
            if (xt != null) {
                for (com.bytedance.msdk.core.oq.j jVar : xt) {
                    final com.bytedance.msdk.api.r.j.xt.cw.xt cw = jVar.cw();
                    try {
                        if (!xt(jVar.up())) {
                            j(context, cw, new com.bytedance.msdk.j.j.cw() { // from class: com.bytedance.msdk.m.xt.1
                                @Override // com.bytedance.msdk.j.j.cw
                                public void j() {
                                    com.bytedance.msdk.m.xt.j.j(com.bytedance.msdk.api.r.j.xt.cw.xt.this.xt(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
                                }

                                @Override // com.bytedance.msdk.j.j.cw
                                public void j(@NonNull com.bytedance.msdk.api.j jVar2) {
                                    if (jVar2 != null) {
                                        com.bytedance.msdk.m.xt.j.j(com.bytedance.msdk.api.r.j.xt.cw.xt.this.xt(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + jVar2.f24334j + " errorMessage = " + jVar2.xt));
                                    }
                                }
                            });
                            j(jVar.up());
                        }
                    } catch (Exception e6) {
                        vl.j(e6);
                        com.bytedance.msdk.m.xt.j.j(cw.xt(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, e6.toString()));
                        m.j(cw.xt(), (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, e6.toString()));
                    }
                }
                return;
            }
            m.j("", (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, "获取的自定义Adapter总配置为null"));
        }
    }

    public static boolean xt(Class<?> cls, Class<?> cls2) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass == cls2) {
                return true;
            }
        }
        return false;
    }

    private static com.bytedance.msdk.api.r.j.xt.m.j j(com.bytedance.msdk.api.r.j.xt.cw.xt xtVar, com.bytedance.msdk.j.j.cw cwVar) {
        com.bytedance.msdk.api.r.j.xt.m.j j6 = com.bytedance.msdk.m.xt.j.r().j(xtVar.xt());
        if (j6 == null) {
            if (com.bytedance.msdk.core.qv.j.j().cw()) {
                j6 = new com.bytedance.msdk.j.r.j.j();
            } else if (j((Class<?>) null)) {
                try {
                    Object newInstance = Class.forName(xtVar.cw()).newInstance();
                    if (newInstance instanceof com.bytedance.msdk.api.r.j.xt.m.j) {
                        j6 = (com.bytedance.msdk.api.r.j.xt.m.j) newInstance;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e6) {
                    e6.printStackTrace();
                }
            }
            com.bytedance.msdk.m.xt.j.r().j(xtVar.xt(), j6);
        }
        return j6;
    }

    private static void j(Context context, com.bytedance.msdk.api.r.j.xt.cw.xt xtVar, com.bytedance.msdk.j.j.cw cwVar) throws Exception {
        if (xtVar == null || TextUtils.isEmpty(xtVar.cw())) {
            if (xtVar == null) {
                throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置为null");
            }
            throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置初始化类名为空");
        }
        com.bytedance.msdk.api.r.j.xt.m.j j6 = j(xtVar, cwVar);
        if (j6 != null) {
            if (!j6.r()) {
                j(context, xtVar, j6);
            }
            cwVar.j();
            return;
        }
        throw new Exception("GMCustomAdapterConfiguration is null");
    }

    private static void j(Context context, com.bytedance.msdk.api.r.j.xt.cw.xt xtVar, com.bytedance.msdk.api.r.j.xt.m.j jVar) {
        if (context == null) {
            m.j(xtVar.xt(), (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, "context为null"));
            return;
        }
        try {
            jVar.xt(StubApp.getOrigApplicationContext(context.getApplicationContext()), xtVar, com.bytedance.msdk.core.j.qv().la());
        } catch (Exception e6) {
            m.j(xtVar.xt(), (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, "调用自定义Adapter初始化方法出现异常 " + e6.getClass().getName()));
            vl.j(e6);
        }
    }

    private static boolean j(Class<?> cls) {
        String j6;
        if (!xt(cls, com.bytedance.msdk.api.r.j.xt.m.j.class)) {
            j6 = "自定义ADN初始化失败  ---------  初始化类 " + cls.getSimpleName() + " 需要继承自自定义ADN的初始化Adapter类 " + com.bytedance.msdk.api.r.j.xt.m.j.class.getSimpleName();
        } else {
            j6 = j(cls, (Class<?>) com.bytedance.msdk.api.r.j.xt.m.j.class);
        }
        if (TextUtils.isEmpty(j6)) {
            return true;
        }
        com.bytedance.msdk.j.up.cw.r("TTMediationSDK_SDK_Init", j6);
        m.j("", (com.bytedance.msdk.xt.cw) null, (com.bytedance.msdk.api.j.xt) null, (oq) null, new com.bytedance.msdk.api.j(49013, j6));
        return false;
    }

    public static String j(Class<?> cls, Class<?> cls2) {
        for (Method method : cls2.getMethods()) {
            HashSet hashSet = new HashSet();
            for (Method method2 : Object.class.getMethods()) {
                hashSet.add(method2.getName());
            }
            if (!hashSet.contains(method.getName())) {
                try {
                    cls.getMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e6) {
                    vl.j(e6);
                    return "自定义ADN校验API失败接入API不符合版本需求，不符合的API的方法名为 " + method.getName();
                }
            }
        }
        return "";
    }

    public static synchronized void j(Context context, String str) {
        synchronized (xt.class) {
            if (!xt(str)) {
                j(context);
            }
        }
    }
}
