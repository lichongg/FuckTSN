package com.bytedance.sdk.component.panglearmor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.sdk.component.utils.vl;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends View.AccessibilityDelegate {
    public static Field xt;
    public View ae;

    /* renamed from: m, reason: collision with root package name */
    public View.AccessibilityDelegate f26690m;

    /* renamed from: j, reason: collision with root package name */
    public static j f26688j = new j(null, null);
    public static int cw = 0;

    /* renamed from: r, reason: collision with root package name */
    public static String f26689r = "";
    public static Set<Integer> up = new HashSet();

    public static void j(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (up.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z5 = true;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                Field field = xt;
                if (field != null) {
                    accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
                }
            } catch (Throwable th) {
                vl.j(th);
            }
            accessibilityDelegate = null;
            z5 = false;
        }
        if (!(accessibilityDelegate instanceof j) && z5) {
            view.setAccessibilityDelegate(new j(accessibilityDelegate, view));
            up.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f26675f = true;
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        view.setAccessibilityDelegate(this.f26690m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        view.setAccessibilityDelegate(this);
    }

    static {
        xt = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                xt = declaredField;
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    public j(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.f26690m = accessibilityDelegate;
        this.ae = view;
        SoftDecTool.f26676h = true;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        view.setAccessibilityDelegate(this.f26690m);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                } else {
                    super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                }
            } catch (Throwable th) {
                vl.j(th);
            }
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean dispatchPopulateAccessibilityEvent;
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        view.setAccessibilityDelegate(this.f26690m);
        view.setAccessibilityDelegate(this.f26690m);
        View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
        if (accessibilityDelegate != null) {
            dispatchPopulateAccessibilityEvent = accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            dispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        view.setAccessibilityDelegate(this);
        return dispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        view.setAccessibilityDelegate(this.f26690m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        if (j()) {
            return;
        }
        view.setAccessibilityDelegate(this.f26690m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean onRequestSendAccessibilityEvent;
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        viewGroup.setAccessibilityDelegate(this.f26690m);
        View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
        if (accessibilityDelegate != null) {
            onRequestSendAccessibilityEvent = accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        } else {
            onRequestSendAccessibilityEvent = super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        viewGroup.setAccessibilityDelegate(this);
        return onRequestSendAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i6, Bundle bundle) {
        boolean performAccessibilityAction;
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        SoftDecTool.f26674a = true;
        view.setAccessibilityDelegate(this.f26690m);
        View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
        if (accessibilityDelegate != null) {
            performAccessibilityAction = accessibilityDelegate.performAccessibilityAction(view, i6, bundle);
        } else {
            performAccessibilityAction = super.performAccessibilityAction(view, i6, bundle);
        }
        view.setAccessibilityDelegate(this);
        return performAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i6) {
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        view.setAccessibilityDelegate(this.f26690m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i6);
            } else {
                super.sendAccessibilityEvent(view, i6);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        cw = hashCode();
        f26689r = String.valueOf(this.f26690m);
        view.setAccessibilityDelegate(this.f26690m);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f26690m;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            vl.j(th);
        }
        view.setAccessibilityDelegate(this);
    }

    public boolean j() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4 || (stackTraceElement = stackTrace[3]) == null) {
            return false;
        }
        for (int i6 = 4; i6 < stackTrace.length; i6++) {
            if (stackTrace[i6] != null && stackTraceElement.getMethodName().equals(stackTrace[i6].getMethodName()) && stackTraceElement.getClassName().equals(stackTrace[i6].getClassName())) {
                return true;
            }
        }
        return false;
    }
}
