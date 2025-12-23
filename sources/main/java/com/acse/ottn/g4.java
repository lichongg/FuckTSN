package com.acse.ottn;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.acse.ottn.util.HelpShopAppUtil;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class g4 {

    /* renamed from: a, reason: collision with root package name */
    public static g4 f4547a;

    public static g4 a() {
        if (f4547a == null) {
            synchronized (g4.class) {
                try {
                    if (f4547a == null) {
                        f4547a = new g4();
                    }
                } finally {
                }
            }
        }
        return f4547a;
    }

    public String b() {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) HelpShopAppUtil.getContext().getSystemService("clipboard");
            return clipboardManager.getText() != null ? clipboardManager.getText().toString().trim() : "";
        } catch (Exception e6) {
            c2.a("SoftKeyboardUtil", e6.getMessage());
            return "";
        }
    }

    public void a(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public void a(Context context, List<View> list) {
        if (list == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            inputMethodManager.hideSoftInputFromWindow(it.next().getWindowToken(), 2);
        }
    }
}
