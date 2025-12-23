package xyz.adscope.amps.tool;

import java.lang.reflect.Constructor;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.init.inter.AMPSChannelInitMediation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSAdapterFactory {
    protected static AMPSAdapterFactory instance = new AMPSAdapterFactory();

    public static AMPSBaseAdapter createAdapterClass(String str) {
        if (str != null) {
            try {
                return instance.internalCreateClass(Class.forName(str).asSubclass(AMPSBaseAdapter.class));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static AMPSChannelInitMediation createAdapterInit(String str) {
        if (str != null) {
            try {
                return instance.internalCreateInit(Class.forName(str).asSubclass(AMPSChannelInitMediation.class));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    protected AMPSBaseAdapter internalCreateClass(Class<? extends AMPSBaseAdapter> cls) throws Exception {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<? extends AMPSBaseAdapter> declaredConstructor = cls.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    protected AMPSChannelInitMediation internalCreateInit(Class<? extends AMPSChannelInitMediation> cls) throws Exception {
        if (cls == null) {
            return null;
        }
        try {
            return (AMPSChannelInitMediation) cls.getMethod("getInstance", null).invoke(new Class[0], null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
