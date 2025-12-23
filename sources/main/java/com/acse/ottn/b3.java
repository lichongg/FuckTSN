package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b3 {

    /* renamed from: a, reason: collision with root package name */
    public static b3 f4247a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f4248b = "OpenMobileLocationPermissionUtil";

    public static b3 a() {
        if (f4247a == null) {
            synchronized (b3.class) {
                try {
                    if (f4247a == null) {
                        f4247a = new b3();
                    }
                } finally {
                }
            }
        }
        return f4247a;
    }

    public final Object b() throws ObjectStreamException {
        return f4247a;
    }

    public boolean a(AccessibilityService accessibilityService, String str) {
        c2.a(f4248b, "openPermission");
        if (!str.contains("com.android") || !str.contains(".ui.GrantPermissionsActivity")) {
            return false;
        }
        d.d().e(accessibilityService);
        if (!j3.a().a("battery_white")) {
            return true;
        }
        j3.a().a("battery_white", Boolean.FALSE);
        b.c().a(300L);
        String e6 = j3.a().e("location_permission_state");
        if (e6.equals("1")) {
            AccessibilityNodeInfo a6 = b.c().a(accessibilityService, "允许本次使用", true);
            if (a6 != null) {
                b.c().g(a6);
                return true;
            }
            AccessibilityNodeInfo a7 = b.c().a(accessibilityService, "仅在使用中允许", true);
            if (a7 != null) {
                b.c().g(a7);
                return true;
            }
            AccessibilityNodeInfo a8 = b.c().a(accessibilityService, "仅使用期间允许", true);
            if (a8 != null) {
                b.c().g(a8);
                return true;
            }
            AccessibilityNodeInfo a9 = b.c().a(accessibilityService, "本次使用允许", true);
            if (a9 != null) {
                b.c().g(a9);
                return true;
            }
            AccessibilityNodeInfo a10 = b.c().a(accessibilityService, "本次运行允许", true);
            if (a10 != null) {
                b.c().g(a10);
                return true;
            }
            AccessibilityNodeInfo a11 = b.c().a(accessibilityService, "本次使用时允许", true);
            if (a11 != null) {
                b.c().g(a11);
                return true;
            }
            AccessibilityNodeInfo a12 = b.c().a(accessibilityService, "仅本次使用时允许", true);
            if (a12 != null) {
                b.c().g(a12);
                return true;
            }
            AccessibilityNodeInfo a13 = b.c().a(accessibilityService, "允许", true);
            if (a13 != null) {
                b.c().g(a13);
                return true;
            }
        } else if (e6.equals("2")) {
            AccessibilityNodeInfo h6 = b.c().h(accessibilityService, "权限管理");
            if (h6 != null) {
                Rect rect = new Rect();
                h6.getBoundsInScreen(rect);
                int i6 = (rect.left + rect.right) / 2;
                c2.a(f4248b, "x=" + i6);
                int i7 = rect.bottom;
                int i8 = rect.top;
                int i9 = ((i7 - i8) / 2) + i8;
                if (Build.VERSION.SDK_INT >= 24) {
                    j3.a().a("battery_white", Boolean.TRUE);
                    try {
                        b.c().a(accessibilityService, i6, i9);
                    } catch (Throwable unused) {
                    }
                    c2.a(f4248b, "点击了");
                    return true;
                }
            }
            AccessibilityNodeInfo h7 = b.c().h(accessibilityService, "始终允许");
            if (h7 != null && h7.getText() != null) {
                c2.a(f4248b, h7.toString());
                if (h7.getText().equals("始终允许")) {
                    b.c().g(h7);
                    return true;
                }
                if (h7.getText().toString().equals("若同意，您可以去设置为始终允许。")) {
                    Rect rect2 = new Rect();
                    h7.getBoundsInScreen(rect2);
                    int i10 = rect2.right - rect2.left;
                    c2.a(f4248b, "x=" + i10);
                    int i11 = rect2.bottom;
                    int i12 = rect2.top;
                    int i13 = ((i11 - i12) / 2) + i12;
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (b.c().a(accessibilityService, i10, i13)) {
                            b.c().a(1000L);
                            b.c().a(accessibilityService, i10, i13);
                        }
                        c2.a(f4248b, "点击了");
                        j3.a().a("battery_white", Boolean.TRUE);
                    }
                    return true;
                }
            }
            AccessibilityNodeInfo h8 = b.c().h(accessibilityService, "在“设置”中允许");
            if (h8 != null) {
                c2.a(f4248b, "在“设置”中允许");
                Rect rect3 = new Rect();
                h8.getBoundsInScreen(rect3);
                int i14 = (rect3.left + rect3.right) / 2;
                c2.a(f4248b, "x=" + i14);
                int i15 = rect3.bottom + (-30);
                if (Build.VERSION.SDK_INT >= 24) {
                    b.c().a(accessibilityService, i14, i15);
                    c2.a(f4248b, "点击了");
                    j3.a().a("battery_white", Boolean.TRUE);
                }
                return true;
            }
            AccessibilityNodeInfo h9 = b.c().h(accessibilityService, "去设为始终允许");
            if (h9 != null) {
                Rect rect4 = new Rect();
                h9.getBoundsInScreen(rect4);
                int i16 = (rect4.left + rect4.right) / 2;
                c2.a(f4248b, "x=" + i16);
                int i17 = rect4.bottom + (-30);
                if (Build.VERSION.SDK_INT >= 24) {
                    b.c().a(accessibilityService, i16, i17);
                    c2.a(f4248b, "点击了");
                    j3.a().a("battery_white", Boolean.TRUE);
                }
                return true;
            }
            AccessibilityNodeInfo a14 = b.c().a(accessibilityService, "允许", true);
            if (a14 != null) {
                b.c().g(a14);
            }
        }
        return true;
    }
}
