package xyz.adscope.common.v2.dev.oaid.sm.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IGetter;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDException;
import xyz.adscope.common.v2.dev.oaid.sm.oaid.OAIDLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CooseaImpl implements IOAID {
    private final Context context;
    private final KeyguardManager keyguardManager;

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        KeyguardManager keyguardManager = this.keyguardManager;
        if (keyguardManager == null) {
            iGetter.onOAIDGetError(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", null).invoke(this.keyguardManager, null);
            if (invoke == null) {
                throw new OAIDException("OAID obtain failed");
            }
            String obj = invoke.toString();
            OAIDLog.print("OAID obtain success: " + obj);
            iGetter.onOAIDGetComplete(obj);
        } catch (Exception e6) {
            OAIDLog.print(e6);
        }
    }

    @Override // xyz.adscope.common.v2.dev.oaid.sm.oaid.IOAID
    public boolean supported() {
        KeyguardManager keyguardManager;
        if (this.context == null || (keyguardManager = this.keyguardManager) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", null).invoke(this.keyguardManager, null);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e6) {
            OAIDLog.print(e6);
            return false;
        }
    }

    public CooseaImpl(Context context) {
        this.context = context;
        this.keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
    }
}
