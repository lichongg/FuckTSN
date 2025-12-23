package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.acse.ottn.activity.TransparentGreenActivity;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static a f4027e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f4028f = "AccessibilityUtil";

    /* renamed from: g, reason: collision with root package name */
    public static final int f4029g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final long f4030h = 60000;

    /* renamed from: a, reason: collision with root package name */
    public boolean f4031a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4032b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4033c = false;

    /* renamed from: d, reason: collision with root package name */
    public long[] f4034d = new long[3];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.acse.ottn.a$a, reason: collision with other inner class name */
    public class C0060a extends AccessibilityService.GestureResultCallback {
        public C0060a() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends AccessibilityService.GestureResultCallback {
        public b() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c extends AccessibilityService.GestureResultCallback {
        public c() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4038a;

        public d(Activity activity) {
            this.f4038a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(this.f4038a, (Class<?>) TransparentGreenActivity.class);
                intent.setFlags(268435456);
                this.f4038a.startActivity(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public static a c() {
        if (f4027e == null) {
            synchronized (a.class) {
                try {
                    if (f4027e == null) {
                        f4027e = new a();
                    }
                } finally {
                }
            }
        }
        return f4027e;
    }

    public void a(boolean z5) {
        this.f4031a = z5;
    }

    public String b(Context context) {
        if (j3.a() == null) {
            return "";
        }
        if (TextUtils.isEmpty(j3.a().e("appName"))) {
            try {
                j3.a().b("appName", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName);
            } catch (Exception e6) {
                c2.a("error", e6.getMessage());
            }
        }
        return j3.a().e("appName");
    }

    public boolean d() {
        return j3.a().a("red_package_state");
    }

    @RequiresApi(api = 18)
    public void e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(childCount);
                if (child != null) {
                    CharSequence text = child.getText();
                    if (text != null && (text.toString().equals("微信红包") || text.toString().contains("[微信红包]"))) {
                        AccessibilityNodeInfo parent = child.getParent();
                        while (true) {
                            if (parent == null) {
                                break;
                            }
                            if (parent.getChildCount() == 2) {
                                parent.performAction(16);
                                break;
                            }
                            parent = parent.getParent();
                        }
                    }
                    if (this.f4033c) {
                        return;
                    } else {
                        e(child);
                    }
                }
            }
        }
    }

    public boolean f() {
        return this.f4031a;
    }

    public final Object g() throws ObjectStreamException {
        return f4027e;
    }

    public void a(Activity activity, boolean z5) {
        if (activity != null) {
            if (z5) {
                l2.b().a("close_shophelp");
            } else {
                l2.b().a("open_shophelp");
            }
        }
        j3.a().a("AccessiblityOnOrOff", Boolean.valueOf(z5));
    }

    @RequiresApi(api = 16)
    public boolean d(AccessibilityService accessibilityService, String str, int i6) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        ArrayList arrayList = new ArrayList();
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return arrayList.size() > i6 ? f((AccessibilityNodeInfo) arrayList.get(i6)) : f((AccessibilityNodeInfo) arrayList.get(0));
    }

    public final boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isLongClickable()) {
            return accessibilityNodeInfo.performAction(32);
        }
        f(accessibilityNodeInfo.getParent());
        return false;
    }

    public void g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        while (accessibilityNodeInfo != null) {
            if (accessibilityNodeInfo.isClickable()) {
                accessibilityNodeInfo.performAction(16);
                return;
            }
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
        }
    }

    @RequiresApi(api = 16)
    public boolean h(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && ((accessibilityNodeInfo.getText() != null && accessibilityNodeInfo.getText().equals(str)) || (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().equals(str)))) {
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean i(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    public boolean a() {
        return d1.b().a(HelpShopAppUtil.getContext());
    }

    @RequiresApi(api = 16)
    public void f(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
    }

    @TargetApi(18)
    public List<AccessibilityNodeInfo> g(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    public void a(AppCompatActivity appCompatActivity, int i6) {
        d1.b().b(appCompatActivity, i6);
    }

    public boolean a(Context context, Class cls) {
        if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
            return false;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (!TextUtils.isEmpty(string)) {
            TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().equalsIgnoreCase(context.getPackageName() + "/" + cls.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean c(AccessibilityService accessibilityService, String str, int i6) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        if (findAccessibilityNodeInfosByViewId != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        if (arrayList.size() > i6) {
            return f((AccessibilityNodeInfo) arrayList.get(i6));
        }
        return f((AccessibilityNodeInfo) arrayList.get(0));
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo f(AccessibilityService accessibilityService, String str) {
        return a(accessibilityService, str, false);
    }

    public void b(Activity activity, boolean z5) {
        j3.a().a("red_package_state", Boolean.valueOf(z5));
    }

    public boolean b() {
        return j3.a().a("AccessiblityOnOrOff");
    }

    @RequiresApi(api = 16)
    public void e(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        accessibilityService.performGlobalAction(8192);
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str, int i6) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        ArrayList arrayList = new ArrayList();
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && ((accessibilityNodeInfo.getText() != null && accessibilityNodeInfo.getText().equals(str)) || (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().equals(str)))) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        if (arrayList.size() > i6) {
            return c((AccessibilityNodeInfo) arrayList.get(i6));
        }
        return c((AccessibilityNodeInfo) arrayList.get(0));
    }

    @RequiresApi(api = 16)
    public void d(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(150L);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
    }

    @RequiresApi(api = 18)
    public boolean a(AccessibilityService accessibilityService, String str, int i6) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        if (findAccessibilityNodeInfosByViewId != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        if (arrayList.size() > i6) {
            return c((AccessibilityNodeInfo) arrayList.get(i6));
        }
        return c((AccessibilityNodeInfo) arrayList.get(0));
    }

    @TargetApi(18)
    public AccessibilityNodeInfo e(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 16)
    public void d(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                g(accessibilityNodeInfo);
                return;
            }
        }
    }

    public final boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        c(accessibilityNodeInfo.getParent());
        return false;
    }

    public final boolean e() {
        return ((AppOpsManager) HelpShopAppUtil.getContext().getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", HelpShopAppUtil.getContext().getApplicationInfo().uid, HelpShopAppUtil.getContext().getPackageName()) == 0 && HelpShopAppUtil.getContext().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public final void c(AccessibilityService accessibilityService) {
        if (j3.a() == null && j3.a().a("show_red_package")) {
            return;
        }
        long[] jArr = this.f4034d;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f4034d;
        long j6 = jArr2[1];
        long j7 = jArr2[2];
        if (j6 == j7 || j7 == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.f4034d;
        long j8 = jArr3[jArr3.length - 1];
        long j9 = jArr3[0];
    }

    public void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
            AccessibilityNodeInfo a6 = a(accessibilityNodeInfo.getChild(i6), "com.tencent.mm:id/e7t");
            if (a6 != null && a6.getText() != null && a6.getText().toString().contains("[微信红包]")) {
                g(a6);
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && ((accessibilityNodeInfo.getText() != null && accessibilityNodeInfo.getText().equals(str)) || (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().equals(str)))) {
                    return c(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean a(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return c(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @TargetApi(18)
    public void c(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) == null || findAccessibilityNodeInfosByViewId.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
            if (accessibilityNodeInfo != null) {
                g(accessibilityNodeInfo);
                return;
            }
        }
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i6, int i7) {
        GestureDescription.Builder addStroke;
        GestureDescription build;
        boolean dispatchGesture;
        Path path = new Path();
        path.moveTo(i6, i7);
        addStroke = m.d.a().addStroke(m.e.a(path, 0L, 200L));
        build = addStroke.build();
        dispatchGesture = accessibilityService.dispatchGesture(build, new C0060a(), null);
        return dispatchGesture;
    }

    @RequiresApi(api = 24)
    public boolean b(AccessibilityService accessibilityService, int i6, int i7) {
        GestureDescription.Builder addStroke;
        GestureDescription build;
        boolean dispatchGesture;
        Path path = new Path();
        path.moveTo(i6, i7);
        addStroke = m.d.a().addStroke(m.e.a(path, 0L, 1000L));
        build = addStroke.build();
        dispatchGesture = accessibilityService.dispatchGesture(build, new b(), null);
        return dispatchGesture;
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i6, int i7, int i8, int i9, int i10) {
        GestureDescription.Builder addStroke;
        GestureDescription build;
        boolean dispatchGesture;
        Path path = new Path();
        path.moveTo(i6, i7);
        path.lineTo(i8, i9);
        GestureDescription.Builder a6 = m.d.a();
        m.f.a();
        addStroke = a6.addStroke(m.e.a(path, 0L, i10));
        build = addStroke.build();
        dispatchGesture = accessibilityService.dispatchGesture(build, new c(), null);
        return dispatchGesture;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean b(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        return accessibilityService.performGlobalAction(2);
    }

    public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityService == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
        return accessibilityNodeInfo.performAction(2097152, bundle);
    }

    public void b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
        accessibilityNodeInfo.performAction(2097152, bundle);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean a(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        return accessibilityService.performGlobalAction(1);
    }

    public boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.performAction(8192);
    }

    public void a(long j6) {
        try {
            Thread.sleep(j6);
        } catch (Exception unused) {
            System.exit(0);
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getParcelableData() == null || !(accessibilityEvent.getParcelableData() instanceof Notification)) {
            return;
        }
        try {
            ((Notification) accessibilityEvent.getParcelableData()).contentIntent.send();
        } catch (PendingIntent.CanceledException e6) {
            e6.printStackTrace();
        }
    }

    public void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i6);
            if ("android.widget.Button".equals(child.getClassName())) {
                child.performAction(16);
            }
            a(accessibilityService, child);
        }
    }

    public void a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    @RequiresApi(api = 24)
    public void a(AccessibilityService accessibilityService, float f6, float f7, int i6, AccessibilityService.GestureResultCallback gestureResultCallback) {
        Path path = new Path();
        path.moveTo(f6, f7);
        a(accessibilityService, path, 0L, i6, gestureResultCallback);
    }

    @RequiresApi(api = 24)
    public void a(AccessibilityService accessibilityService, Path path, long j6, long j7, AccessibilityService.GestureResultCallback gestureResultCallback) {
        GestureDescription build;
        GestureDescription.Builder a6 = m.d.a();
        a6.addStroke(m.e.a(path, j6, j7));
        build = a6.build();
        accessibilityService.dispatchGesture(build, gestureResultCallback, null);
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo a(AccessibilityService accessibilityService, String str, boolean z5) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            c2.b("AccessibilityUtil", "accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.isClickable() == z5) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z5) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        if (accessibilityNodeInfo != null && (findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.isClickable() == z5) {
                    return accessibilityNodeInfo2;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
        for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
            if (accessibilityNodeInfo.getChild(childCount) != null && !str2.equals(accessibilityNodeInfo.getChild(childCount).getText())) {
                return accessibilityNodeInfo.getChild(childCount);
            }
        }
        return null;
    }

    @TargetApi(18)
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        if (accessibilityNodeInfo != null && (findAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo2 != null) {
                    return accessibilityNodeInfo2;
                }
            }
        }
        return null;
    }

    public void a(Activity activity, int i6) {
        String b6 = j4.b();
        if ("redmi".equals(b6) || "xiaomi".equals(b6) || c3.a().b() || "vivo".equals(b6) || "oppo".equals(b6) || "realme".equals(b6) || "oneplus".equals(b6) || "samsung".equals(b6)) {
            new Handler().postDelayed(new d(activity), 500L);
        }
        l2.b().a("show_accessiblity_open_view");
        j3.a().a("battery_white_accessiblity", Boolean.TRUE);
        try {
            activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i6);
        } catch (Exception e6) {
            activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i6);
            e6.printStackTrace();
        }
    }
}
