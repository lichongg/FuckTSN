package com.bytedance.sdk.openadsdk.ats.j;

import com.acse.ottn.l3;
import com.bytedance.sdk.component.r.up;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.lang.reflect.Method;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements up {
    private Method cw;

    /* renamed from: j, reason: collision with root package name */
    private Class f27612j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f27613m;

    /* renamed from: r, reason: collision with root package name */
    private Method f27614r;
    private Method up;
    private Method xt;

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(5)
    public void j(String str, String str2) {
    }

    private Method j(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.f27612j.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(3)
    public long cw(String str) {
        if (this.f27614r == null) {
            this.f27614r = j("getLong", String.class, Long.TYPE);
        }
        Long l6 = (Long) j(this.f27614r, str);
        if (l6 != null) {
            return l6.longValue();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(4)
    public boolean r(String str) {
        if (this.up == null) {
            this.up = j("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) j(this.up, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(2)
    public int xt(String str) {
        if (this.cw == null) {
            this.cw = j("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) j(this.cw, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public xt() {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass("android.os.SystemProperties");
            this.f27612j = loadClass;
            Method declaredMethod = loadClass.getDeclaredMethod(l3.f4736f, String.class);
            this.xt = declaredMethod;
            declaredMethod.setAccessible(true);
            this.f27613m = true;
        } catch (Exception unused) {
            this.f27612j = null;
            this.f27613m = false;
        }
    }

    private <T> T j(Method method, String str) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.f27612j, str);
        } catch (Exception e6) {
            vl.xt("SystemPropRefect", "invoke failed", e6);
            return null;
        }
    }

    public boolean j() {
        return this.f27613m;
    }

    @Override // com.bytedance.sdk.component.r.up
    @ATSMethod(1)
    public String j(String str) {
        return (String) j(this.xt, str);
    }
}
