package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.m0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.fastjson.JSON;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    public static b f4221f = null;

    /* renamed from: g, reason: collision with root package name */
    public static String f4222g = "acse_AccessibilityUtil";

    /* renamed from: h, reason: collision with root package name */
    public static final int f4223h = 3;

    /* renamed from: i, reason: collision with root package name */
    public static final long f4224i = 60000;

    /* renamed from: d, reason: collision with root package name */
    public CountDownTimer f4228d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f4225a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4226b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4227c = false;

    /* renamed from: e, reason: collision with root package name */
    public long[] f4229e = new long[3];

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a extends AccessibilityService.GestureResultCallback {
        public a() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
            c2.a("samonp-->", "点击回调");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.acse.ottn.b$b, reason: collision with other inner class name */
    public class C0068b extends AccessibilityService.GestureResultCallback {
        public C0068b() {
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
    public class d implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f4233a;

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            if (this.f4233a == null || b.c().f(this.f4233a, "com.tencent.mm:id/gix") == null) {
                return;
            }
            b.c().a(this.f4233a, "com.tencent.mm:id/gix");
            CountDownTimer countDownTimer = b.this.f4228d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                b.this.f4228d = null;
            }
        }

        public d(AccessibilityService accessibilityService) {
            this.f4233a = accessibilityService;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            b.this.f4228d = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements Consumer<String> {
        public e() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements Consumer<Throwable> {
        public f() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public static b c() {
        if (f4221f == null) {
            synchronized (b.class) {
                try {
                    if (f4221f == null) {
                        f4221f = new b();
                    }
                } finally {
                }
            }
        }
        return f4221f;
    }

    public void a(boolean z5) {
        this.f4225a = z5;
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
        return arrayList.size() > i6 ? c((AccessibilityNodeInfo) arrayList.get(i6)) : c((AccessibilityNodeInfo) arrayList.get(0));
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
                if (accessibilityNodeInfo != null && ((accessibilityNodeInfo.getText() != null && accessibilityNodeInfo.getText().equals(str)) || (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().equals(str)))) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return arrayList.size() > i6 ? f((AccessibilityNodeInfo) arrayList.get(i6)) : f((AccessibilityNodeInfo) arrayList.get(0));
    }

    public boolean e() {
        int i6;
        String string;
        String b6 = com.acse.ottn.a.c().b(HelpShopAppUtil.getContext());
        try {
            i6 = Settings.Secure.getInt(HelpShopAppUtil.getContext().getContentResolver(), "accessibility_enabled");
        } catch (Exception e6) {
            c2.b("AccessibilityIntroduce", "Error finding setting, default accessibility to not found: " + e6.getMessage());
            i6 = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i6 == 1 && (string = Settings.Secure.getString(HelpShopAppUtil.getContext().getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().contains(b6)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean f() {
        return this.f4225a;
    }

    public final Object g() throws ObjectStreamException {
        return f4221f;
    }

    public void h(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (!TextUtils.isEmpty(accessibilityNodeInfo.getText())) {
                accessibilityNodeInfo.getText().toString().getClass();
                return;
            } else {
                if (TextUtils.isEmpty(accessibilityNodeInfo.getContentDescription())) {
                    return;
                }
                accessibilityNodeInfo.getContentDescription().toString();
                return;
            }
        }
        if (accessibilityNodeInfo != null) {
            for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
                try {
                    if (accessibilityNodeInfo.getChild(i6) != null) {
                        h(accessibilityNodeInfo.getChild(i6));
                    }
                } catch (Throwable th) {
                    c2.a(f4222g, th.getMessage());
                }
            }
        }
    }

    public boolean a() {
        return d1.b().a(HelpShopAppUtil.getContext());
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

    public void a(AppCompatActivity appCompatActivity, int i6) {
        d1.b().b(appCompatActivity, i6);
    }

    @RequiresApi(api = 16)
    public void i(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            c2.a(f4222g, "findViewByText2 accessibilityNodeInfo is null");
            return;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            c2.a(f4222g, "nodeInfoList size =" + findAccessibilityNodeInfosByText.size());
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null) {
                    c().g(accessibilityNodeInfo);
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo j(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            c2.b(f4222g, "findViewByText3 accessibilityNodeInfo is null");
            return null;
        }
        h(rootInActiveWindow);
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && ((accessibilityNodeInfo.getText() != null && str.equals(accessibilityNodeInfo.getText().toString().trim())) || (accessibilityNodeInfo.getContentDescription() != null && str.equals(accessibilityNodeInfo.getContentDescription().toString().trim())))) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    public List<AccessibilityNodeInfo> k(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    @RequiresApi(api = 16)
    public boolean l(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean m(AccessibilityService accessibilityService, String str) {
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

    @RequiresApi(api = 16)
    public void f(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        accessibilityService.performGlobalAction(8192);
    }

    @RequiresApi(api = 16)
    public void g(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
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

    @TargetApi(18)
    public AccessibilityNodeInfo f(AccessibilityService accessibilityService, String str) {
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
    public AccessibilityNodeInfo g(AccessibilityService accessibilityService, String str) {
        return a(accessibilityService, str, false);
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

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo h(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            c2.b(f4222g, "findViewByText1 accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return c(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    public void d(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        CountDownTimer countDownTimer = this.f4228d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f4228d = null;
        }
        CountDownTimer a6 = m0.a().a(2000, 50, new d(accessibilityService));
        this.f4228d = a6;
        a6.start();
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
                    if (this.f4227c) {
                        return;
                    } else {
                        e(child);
                    }
                }
            }
        }
    }

    public boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        c(accessibilityNodeInfo.getParent());
        return false;
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

    @RequiresApi(api = 24)
    public boolean b(AccessibilityService accessibilityService, int i6, int i7) {
        GestureDescription.Builder addStroke;
        GestureDescription build;
        boolean dispatchGesture;
        Path path = new Path();
        path.moveTo(i6, i7);
        addStroke = m.d.a().addStroke(m.e.a(path, 0L, 1000L));
        build = addStroke.build();
        dispatchGesture = accessibilityService.dispatchGesture(build, new C0068b(), null);
        return dispatchGesture;
    }

    public final void c(AccessibilityService accessibilityService) {
        if (j3.a().a("show_red_package")) {
            return;
        }
        long[] jArr = this.f4229e;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f4229e;
        long j6 = jArr2[1];
        long j7 = jArr2[2];
        if (j6 == j7 || j7 == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.f4229e;
        long j8 = jArr3[jArr3.length - 1];
        long j9 = jArr3[0];
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

    public void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i6 = 0; i6 < accessibilityNodeInfo.getChildCount(); i6++) {
            AccessibilityNodeInfo a6 = a(accessibilityNodeInfo.getChild(i6), "com.tencent.mm:id/e7t");
            if (a6 != null && a6.getText() != null && a6.getText().toString().contains("[微信红包]")) {
                g(a6);
                return;
            }
        }
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

    @RequiresApi(api = 16)
    public void e(AccessibilityService accessibilityService) {
        try {
            c2.a("openOppenBatteryButton", "调用返回");
            Thread.sleep(150L);
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
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
        try {
            Path path = new Path();
            path.moveTo(i6, i7);
            m.g.a();
            GestureDescription.Builder a6 = m.d.a();
            m.f.a();
            addStroke = a6.addStroke(m.e.a(path, 0L, 200L));
            build = addStroke.build();
            dispatchGesture = accessibilityService.dispatchGesture(build, new a(), null);
            return dispatchGesture;
        } catch (Throwable unused) {
            c2.a("samonp-->", "点击失败 x= " + i6 + "   y = " + i7);
            return false;
        }
    }

    public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    public String d() {
        if (TextUtils.isEmpty(j3.a().e("plunin_id"))) {
            return "";
        }
        return j3.a().e("plunin_id");
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo e(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            c2.b(f4222g, "findViewByText3 accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        return a(accessibilityNodeInfo, str, false);
    }

    public void b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
        accessibilityNodeInfo.performAction(2097152, bundle);
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i6, int i7, int i8, int i9, int i10) {
        GestureDescription.Builder addStroke;
        GestureDescription build;
        boolean dispatchGesture;
        try {
            Path path = new Path();
            path.moveTo(i6, i7);
            path.lineTo(i8, i9);
            m.g.a();
            GestureDescription.Builder a6 = m.d.a();
            m.f.a();
            addStroke = a6.addStroke(m.e.a(path, 0L, i10));
            build = addStroke.build();
            dispatchGesture = accessibilityService.dispatchGesture(build, new c(), null);
            return dispatchGesture;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
        List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) HelpShopAppUtil.getContext().getSystemService("accessibility")).getInstalledAccessibilityServiceList();
        ArrayList arrayList = new ArrayList();
        for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
            String str = accessibilityServiceInfo.getResolveInfo().serviceInfo.name;
            String str2 = accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName;
            arrayList.add("应用名称：" + accessibilityServiceInfo.getResolveInfo().loadLabel(HelpShopAppUtil.getContext().getPackageManager()).toString() + "--->app包名：" + str2 + "---->service路径：" + str);
        }
        l2.b().b("accessiblity_list", JSON.toJSONString(arrayList));
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
        try {
            m.g.a();
            GestureDescription.Builder a6 = m.d.a();
            m.f.a();
            a6.addStroke(m.e.a(path, j6, j7));
            build = a6.build();
            accessibilityService.dispatchGesture(build, gestureResultCallback, null);
        } catch (Throwable unused) {
        }
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo a(AccessibilityService accessibilityService, String str, boolean z5) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            c2.b(f4222g, "findViewByText accessibilityNodeInfo is null text =" + str);
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null && str.equals(accessibilityNodeInfo.getText().toString().trim()) && accessibilityNodeInfo.isClickable() == z5) {
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

    public void a(String str, String str2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("is_snt", "0");
        if (TextUtils.isEmpty(str)) {
            str = "n";
        }
        treeMap.put("state", str);
        treeMap.put("schoolId", str2);
        new f0().j(s0.a().a(treeMap, "")).w5(Schedulers.newThread()).u5(new e(), new f());
    }

    public void a(String str) {
        if (j3.a() != null) {
            j3.a().b("plunin_id", str);
        }
    }
}
