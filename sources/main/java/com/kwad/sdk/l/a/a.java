package com.kwad.sdk.l.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a implements c {
    protected List<c> aWE;
    protected boolean enabled;

    public a(boolean z5) {
        this.enabled = z5;
    }

    protected boolean cm(Context context) {
        return false;
    }

    private List<c> getChildren() {
        return this.aWE;
    }

    @Override // com.kwad.sdk.l.a.c
    public final boolean cl(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children == null || children.size() <= 0) {
            try {
                return cm(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        Iterator<c> it = children.iterator();
        while (it.hasNext()) {
            if (it.next().cl(context)) {
                return true;
            }
        }
        return false;
    }

    public a() {
        this.enabled = true;
    }
}
