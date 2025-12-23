package com.umeng.commonsdk.framework;

import android.content.Context;
import com.stub.StubApp;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMModuleRegister {
    public static final String ANALYTICS = "analytics";
    public static final String APPSTATUS = "appstatus";
    private static final int APPSTATUS_SWITCH_HIGH = 37136;
    private static final int APPSTATUS_SWITCH_LOW = 37121;
    public static final String INNER = "internal";
    private static final int INNER_EVENT_VALUE_HIGH = 36864;
    private static final int INNER_EVENT_VALUE_LOW = 32769;
    public static final String PROCESS = "process";
    private static final int PROCESS_EVENT_VALUE_HIGH = 37120;
    private static final int PROCESS_EVENT_VALUE_LOW = 36945;
    public static final String PUSH = "push";
    private static final int PUSH_EVENT_VALUE_HIGH = 20480;
    private static final int PUSH_EVENT_VALUE_LOW = 16385;
    public static final String SHARE = "share";
    private static final int SHARE_EVENT_VALUE_HIGH = 28672;
    private static final int SHARE_EVENT_VALUE_LOW = 24577;
    private static Context mModuleAppContext;
    private static HashMap<String, UMLogDataProtocol> mModuleMap;

    public static String eventType2ModuleName(int i6) {
        String str = (i6 < PUSH_EVENT_VALUE_LOW || i6 > PUSH_EVENT_VALUE_HIGH) ? "analytics" : "push";
        if (i6 >= 24577 && i6 <= SHARE_EVENT_VALUE_HIGH) {
            str = "share";
        }
        if (i6 >= 32769 && i6 <= INNER_EVENT_VALUE_HIGH) {
            str = INNER;
        }
        if (i6 >= 36945 && i6 <= PROCESS_EVENT_VALUE_HIGH) {
            str = PROCESS;
        }
        return (i6 < APPSTATUS_SWITCH_LOW || i6 > APPSTATUS_SWITCH_HIGH) ? str : APPSTATUS;
    }

    public static Context getAppContext() {
        return mModuleAppContext;
    }

    public static UMLogDataProtocol getCallbackFromModuleName(String str) {
        if (mModuleMap.containsKey(str)) {
            return mModuleMap.get(str);
        }
        return null;
    }

    public static void registerAppContext(Context context) {
        if (mModuleAppContext == null) {
            mModuleAppContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    public static boolean registerCallback(int i6, UMLogDataProtocol uMLogDataProtocol) {
        if (mModuleMap == null) {
            mModuleMap = new HashMap<>();
        }
        String eventType2ModuleName = eventType2ModuleName(i6);
        if (mModuleMap.containsKey(eventType2ModuleName)) {
            return true;
        }
        mModuleMap.put(eventType2ModuleName, uMLogDataProtocol);
        return true;
    }
}
