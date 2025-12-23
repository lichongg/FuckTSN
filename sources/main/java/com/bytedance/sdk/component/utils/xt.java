package com.bytedance.sdk.component.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    public interface j {
        void j();

        void j(Throwable th);
    }

    public static boolean j(Context context, Intent intent, j jVar) {
        if (context != null && intent != null) {
            try {
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                if (jVar == null) {
                    return true;
                }
                jVar.j();
                return true;
            } catch (Throwable th) {
                if (jVar != null) {
                    jVar.j(th);
                }
            }
        }
        return false;
    }

    public static void startActivity(Context context, Intent intent, boolean z5) {
        if (context == null || intent == null) {
            return;
        }
        if (z5) {
            intent.putExtra("start_only_for_android", true);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static boolean j(Context context, Intent intent, j jVar, boolean z5) {
        if (context == null || intent == null) {
            return false;
        }
        if (z5) {
            intent.putExtra("start_only_for_android", true);
        }
        return j(context, intent, jVar);
    }

    public static Activity j(View view) {
        View findViewById;
        Context context;
        if (view == null) {
            return null;
        }
        Context context2 = view.getContext();
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        View rootView = view.getRootView();
        if (rootView == null || (findViewById = rootView.findViewById(R.id.content)) == null || (context = findViewById.getContext()) == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }
}
