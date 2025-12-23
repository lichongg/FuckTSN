package com.kwad.components.core.e.a;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h implements d {
    private static WeakReference<Window> OB;
    private final com.kwad.sdk.core.c.c<Activity> An = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.e.a.h.1
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(Activity activity) {
            super.b(activity);
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            if (activity.equals((Activity) h.this.OA.get())) {
                h.this.fZ();
            }
        }
    };
    private WeakReference<Activity> OA;
    private g Oy;
    private b Oz;
    private ViewGroup qT;
    private boolean qU;

    public static void a(Window window) {
        OB = new WeakReference<>(window);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fZ() {
        g gVar;
        if (this.qU) {
            return;
        }
        this.qU = true;
        this.Oz.fY();
        ViewGroup viewGroup = this.qT;
        if (viewGroup != null && (gVar = this.Oy) != null) {
            viewGroup.removeView(gVar);
        }
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this.An);
    }

    public static void oR() {
        WeakReference<Window> weakReference = OB;
        if (weakReference != null) {
            weakReference.clear();
        }
        OB = null;
    }

    public final boolean b(AdTemplate adTemplate, b bVar) {
        try {
            this.Oz = bVar;
            com.kwad.sdk.core.c.b.Ho();
            Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
            if (currentActivity != null && !currentActivity.isFinishing()) {
                WeakReference<Window> weakReference = OB;
                View findViewById = (weakReference != null ? weakReference.get() : currentActivity.getWindow()).getDecorView().findViewById(R.id.content);
                if (!(findViewById instanceof ViewGroup)) {
                    return false;
                }
                this.OA = new WeakReference<>(currentActivity);
                this.Oy = new g(m.wrapContextIfNeed(currentActivity), adTemplate, this);
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.a(this.An);
                this.qT = (ViewGroup) findViewById;
                this.qT.addView(this.Oy, new ViewGroup.LayoutParams(-1, -1));
                bVar.oI();
                return true;
            }
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail activity:" + currentActivity);
            return false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.d("InstalledActivateViewHelper", "showInWindow fail error:" + th);
            com.kwad.sdk.core.d.c.printStackTrace(th);
            return false;
        }
    }

    @Override // com.kwad.components.core.e.a.d
    public final void oJ() {
        fZ();
    }
}
