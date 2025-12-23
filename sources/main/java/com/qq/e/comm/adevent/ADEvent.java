package com.qq.e.comm.adevent;

import com.qq.e.comm.util.GDTLogger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ADEvent {

    /* renamed from: a, reason: collision with root package name */
    private final int f36725a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f36726b;

    public <T> T getParam(int i6, Class<T> cls) {
        Object[] objArr;
        if (cls == null || (objArr = this.f36726b) == null || objArr.length <= i6) {
            return null;
        }
        T t5 = (T) objArr[i6];
        if (t5 == null) {
            GDTLogger.e("ADEvent 参数为空,type:" + this.f36725a);
            return null;
        }
        if (cls.isInstance(t5)) {
            return t5;
        }
        a("ADEvent" + this.f36725a + " 参数类型错误,期望类型" + cls.getName() + "实际类型 " + t5.getClass().getName());
        return null;
    }

    public <T> T getParam(Class<T> cls) {
        return (T) getParam(0, cls);
    }

    public int getType() {
        return this.f36725a;
    }

    public ADEvent(int i6, Object... objArr) {
        this.f36725a = i6;
        this.f36726b = objArr;
        if (i6 < 100) {
            a("EventId 错误" + i6);
        }
    }

    private void a(String str) {
        GDTLogger.e(str);
    }
}
