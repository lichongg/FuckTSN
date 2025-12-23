package com.acse.ottn.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.b;
import com.acse.ottn.c2;
import com.acse.ottn.d;
import com.acse.ottn.j3;
import com.acse.ottn.z3;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ShopHelperService extends AccessibilityService {
    private static String TAG = "acse_ShopHelperService";
    public static ShopHelperService mService;
    String activityName = "";

    static {
        StubApp.interface11(9606);
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        mService = null;
        c2.a(TAG, "断开");
    }

    public static boolean isStart() {
        return mService != null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        mService = this;
        c2.a(TAG, "被锁定");
        super.onServiceConnected();
        if (j3.a() == null) {
            new AcseHelpManager.InitSdk().setContext(getApplication()).build();
        }
        d.d().e(this);
        d.d().a(this);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        c2.a(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    private boolean getCurrentAppLocation(String str) {
        str.getClass();
        switch (str) {
            case "com.miui.home.launcher.Launcher":
            case "com.bbk.launcher2.Launcher":
            case "com.huawei.android.launcher.unihome.UniHomeLauncher":
            case "com.android.launcher.Launcher":
            case "com.hihonor.android.launcher.unihome.UniHomeLauncher":
                return true;
            default:
                return false;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        if (eventType != 0) {
            if (eventType != 1) {
                if (eventType != 2) {
                    switch (eventType) {
                        case 4:
                            c2.a(TAG, "TYPE_VIEW_SELECTED");
                            break;
                        case 8:
                            break;
                        case 16:
                            c2.a(TAG, "TYPE_VIEW_TEXT_CHANGED");
                            break;
                        case 32:
                            c2.a(TAG, "TYPE_WINDOW_STATE_CHANGED");
                            d.d().a(this, accessibilityEvent);
                            break;
                        case 64:
                            c2.a(TAG, "TYPE_NOTIFICATION_STATE_CHANGED");
                            break;
                        case 128:
                            c2.a(TAG, "TYPE_VIEW_HOVER_ENTER");
                            break;
                        case 256:
                            c2.a(TAG, "TYPE_VIEW_HOVER_EXIT");
                            break;
                        case 500:
                            c2.a(TAG, "MAX_TEXT_LENGTH");
                            break;
                        case 512:
                            c2.a(TAG, "TYPE_TOUCH_EXPLORATION_GESTURE_START");
                            break;
                        case 1024:
                            c2.a(TAG, "TYPE_TOUCH_EXPLORATION_GESTURE_END");
                            break;
                        case 4096:
                            z3.c().a(this);
                            break;
                        case 8192:
                            c2.a(TAG, "TYPE_VIEW_TEXT_SELECTION_CHANGED");
                            if (AcseHelpManager.mIsDebug) {
                                c2.a(TAG, "当前页面--》" + ((Object) accessibilityEvent.getPackageName()) + "----" + ((Object) accessibilityEvent.getClassName()));
                                if (accessibilityEvent.getPackageName() != null && accessibilityEvent.getClassName() != null && accessibilityEvent.getPackageName().equals("com.tencent.mm") && accessibilityEvent.getClassName().equals("android.widget.TextView")) {
                                    b.c().a(2000L);
                                    d.d().e();
                                    break;
                                }
                            }
                            break;
                        case 16384:
                            c2.a(TAG, "TYPE_ANNOUNCEMENT");
                            break;
                        case 32768:
                            c2.a(TAG, "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
                            break;
                        case 65536:
                            c2.a(TAG, "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED");
                            break;
                        case 131072:
                            c2.a(TAG, "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY");
                            break;
                        case 262144:
                            c2.a(TAG, "TYPE_GESTURE_DETECTION_START");
                            break;
                        case 524288:
                            c2.a(TAG, "TYPE_GESTURE_DETECTION_END");
                            break;
                        case 1048576:
                            c2.a(TAG, "TYPE_TOUCH_INTERACTION_START");
                            break;
                        case 2097152:
                            c2.a(TAG, "TYPE_TOUCH_INTERACTION_END");
                            break;
                        case 4194304:
                            c2.a(TAG, "TYPE_WINDOWS_CHANGED");
                            d.d().h(this);
                            break;
                    }
                    return;
                }
                c2.a(TAG, "TYPE_VIEW_LONG_CLICKED");
                return;
            }
            d.d().b(this, accessibilityEvent);
            return;
        }
        c2.a(TAG, "CONTENT_CHANGE_TYPE_UNDEFINED");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        c2.a(TAG, "关闭");
        mService = null;
    }
}
