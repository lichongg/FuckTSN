package com.kwad.components.core.t;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.KeyEvent;
import android.view.ViewGroup;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class j {
    public static void a(com.kwad.components.core.widget.e eVar, ViewGroup viewGroup) {
        if (eVar == null || viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof com.kwad.components.core.widget.d) {
                ((com.kwad.components.core.widget.d) childAt).a(eVar);
            } else if (childAt instanceof ViewGroup) {
                a(eVar, (ViewGroup) childAt);
            }
        }
    }

    public static void b(com.kwad.components.core.widget.e eVar, Drawable drawable) {
        if (drawable instanceof ShapeDrawable) {
            ((ShapeDrawable) drawable).getPaint().setColor(eVar.wf());
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(eVar.wf());
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(eVar.wf());
        }
    }
}
