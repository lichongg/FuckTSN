package com.bytedance.msdk.cw.cw.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.cw.cw.j.j;
import com.bytedance.msdk.tl.p;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae implements j.InterfaceC0365j {
    private int cw;

    /* renamed from: j, reason: collision with root package name */
    private List<j> f24833j;

    /* renamed from: r, reason: collision with root package name */
    private int f24834r;
    private com.bytedance.msdk.cw.m.j.xt xt;

    static /* synthetic */ int m(ae aeVar) {
        int i6 = aeVar.f24834r;
        aeVar.f24834r = i6 + 1;
        return i6;
    }

    static /* synthetic */ int r(ae aeVar) {
        int i6 = aeVar.cw;
        aeVar.cw = i6 + 1;
        return i6;
    }

    @Override // com.bytedance.msdk.cw.cw.j.j.InterfaceC0365j
    public void j(com.bytedance.msdk.cw.m.j.xt xtVar) {
        if (this.xt != xtVar && xtVar != null) {
            this.xt = xtVar;
        }
        if (p.j(this.f24833j)) {
            return;
        }
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.cw.cw.j.ae.1
            @Override // java.lang.Runnable
            public void run() {
                if (ae.this.cw == 0 && ae.this.xt != null) {
                    ae.this.xt.xt(SystemClock.elapsedRealtime());
                }
                if (ae.this.f24833j.size() > ae.this.cw) {
                    ((j) ae.this.f24833j.get(ae.r(ae.this))).j(ae.this);
                }
            }
        });
    }

    public ae(List<j> list) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f24833j = copyOnWriteArrayList;
        this.cw = 0;
        this.f24834r = 0;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    @Override // com.bytedance.msdk.cw.cw.j.j.InterfaceC0365j
    public com.bytedance.msdk.cw.m.j.xt j() {
        return this.xt;
    }

    @Override // com.bytedance.msdk.cw.cw.j.j.InterfaceC0365j
    public void j(String str) {
        com.bytedance.msdk.cw.m.j.xt xtVar;
        if (!TextUtils.isEmpty(str) && (xtVar = this.xt) != null) {
            xtVar.xt(str);
        }
        com.bytedance.msdk.j.up.m.j(new Runnable() { // from class: com.bytedance.msdk.cw.cw.j.ae.2
            @Override // java.lang.Runnable
            public void run() {
                if (ae.this.f24833j.size() > ae.this.f24834r) {
                    ((j) ae.this.f24833j.get(ae.m(ae.this))).xt(ae.this);
                }
            }
        });
    }
}
