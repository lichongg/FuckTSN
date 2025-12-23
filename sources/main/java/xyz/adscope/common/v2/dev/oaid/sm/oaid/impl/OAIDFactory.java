package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.app.Application;
import android.content.Context;
import com.stub.StubApp;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDRom;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class OAIDFactory {
    private static IOAID igaid;
    private static IOAID ioaid;

    public static IOAID create(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        IOAID ioaid2 = ioaid;
        if (ioaid2 != null) {
            return ioaid2;
        }
        IOAID createManufacturerImpl = createManufacturerImpl(context);
        ioaid = createManufacturerImpl;
        if (createManufacturerImpl == null || !createManufacturerImpl.supported()) {
            IOAID createUniversalImpl = createUniversalImpl(context);
            ioaid = createUniversalImpl;
            return createUniversalImpl;
        }
        OAIDLog.print("Manufacturer interface has been found: " + ioaid.getClass().getName());
        return ioaid;
    }

    public static IOAID createGaid(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        IOAID ioaid2 = igaid;
        if (ioaid2 != null) {
            return ioaid2;
        }
        IOAID createGaidUniversalImpl = createGaidUniversalImpl(context);
        igaid = createGaidUniversalImpl;
        return createGaidUniversalImpl;
    }

    private static IOAID createGaidUniversalImpl(Context context) {
        GmsImpl gmsImpl = new GmsImpl(context);
        igaid = gmsImpl;
        if (!gmsImpl.supported()) {
            return igaid;
        }
        OAIDLog.print("Google Play Service has been found: " + igaid.getClass().getName());
        return igaid;
    }

    private static IOAID createUniversalImpl(Context context) {
        MsaImpl msaImpl = new MsaImpl(context);
        if (msaImpl.supported()) {
            OAIDLog.print("Mobile Security Alliance has been found: " + MsaImpl.class.getName());
            return msaImpl;
        }
        GmsImpl gmsImpl = new GmsImpl(context);
        if (gmsImpl.supported()) {
            OAIDLog.print("Google Play Service has been found: " + GmsImpl.class.getName());
            return gmsImpl;
        }
        DefaultImpl defaultImpl = new DefaultImpl();
        OAIDLog.print("OAID was not supported: " + DefaultImpl.class.getName());
        return defaultImpl;
    }

    private OAIDFactory() {
    }

    private static IOAID createManufacturerImpl(Context context) {
        if (!OAIDRom.isLenovo() && !OAIDRom.isMotolora()) {
            if (OAIDRom.isMeizu()) {
                return new MeizuImpl(context);
            }
            if (OAIDRom.isNubia()) {
                return new NubiaImpl(context);
            }
            if (!OAIDRom.isXiaomi() && !OAIDRom.isMiui() && !OAIDRom.isBlackShark()) {
                if (OAIDRom.isSamsung()) {
                    return new SamsungImpl(context);
                }
                if (OAIDRom.isVivo()) {
                    return new VivoImpl(context);
                }
                if (OAIDRom.isASUS()) {
                    return new AsusImpl(context);
                }
                if (!OAIDRom.isHuawei() && !OAIDRom.isEmui()) {
                    if (!OAIDRom.isOppo() && !OAIDRom.isOnePlus()) {
                        if (OAIDRom.isCoolpad(context)) {
                            return new CoolpadImpl(context);
                        }
                        if (OAIDRom.isCoosea()) {
                            return new CooseaImpl(context);
                        }
                        if (OAIDRom.isFreeme()) {
                            return new FreemeImpl(context);
                        }
                        return null;
                    }
                    return new OppoImpl(context);
                }
                return new HuaweiImpl(context);
            }
            return new XiaomiImpl(context);
        }
        return new LenovoImpl(context);
    }
}
