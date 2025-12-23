package com.bytedance.sdk.component.adexpress.dynamic.animation.j;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static volatile cw f25567j;

    public static cw j() {
        if (f25567j == null) {
            synchronized (cw.class) {
                try {
                    if (f25567j == null) {
                        f25567j = new cw();
                    }
                } finally {
                }
            }
        }
        return f25567j;
    }

    private cw() {
    }

    public r j(View view, com.bytedance.sdk.component.adexpress.dynamic.cw.j jVar) {
        if (jVar == null) {
            return null;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).setClipChildren(false);
        }
        if (view.getParent().getParent() != null) {
            ((ViewGroup) view.getParent().getParent()).setClipChildren(false);
        }
        if ("scale".equals(jVar.g())) {
            return new qv(view, jVar);
        }
        if ("translate".equals(jVar.g())) {
            return new az(view, jVar);
        }
        if ("ripple".equals(jVar.g())) {
            return new tl(view, jVar);
        }
        if ("marquee".equals(jVar.g())) {
            return new ae(view, jVar);
        }
        if ("waggle".equals(jVar.g())) {
            return new av(view, jVar);
        }
        if ("shine".equals(jVar.g())) {
            return new vl(view, jVar);
        }
        if ("swing".equals(jVar.g())) {
            return new ws(view, jVar);
        }
        if ("fade".equals(jVar.g())) {
            return new j(view, jVar);
        }
        if ("rubIn".equals(jVar.g())) {
            return new oq(view, jVar);
        }
        if ("rotate".equals(jVar.g())) {
            return new g(view, jVar);
        }
        if ("cutIn".equals(jVar.g())) {
            return new m(view, jVar);
        }
        if ("stretch".equals(jVar.g())) {
            return new jy(view, jVar);
        }
        if ("bounce".equals(jVar.g())) {
            return new up(view, jVar);
        }
        return null;
    }
}
