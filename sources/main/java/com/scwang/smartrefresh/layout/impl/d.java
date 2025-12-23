package com.scwang.smartrefresh.layout.impl;

import android.view.MotionEvent;
import android.view.View;
import m2.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class d implements i {

    /* renamed from: a, reason: collision with root package name */
    protected MotionEvent f37438a;

    /* renamed from: b, reason: collision with root package name */
    protected i f37439b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f37440c;

    @Override // m2.i
    public boolean a(View view) {
        i iVar = this.f37439b;
        return iVar != null ? iVar.a(view) : this.f37440c ? !com.scwang.smartrefresh.layout.util.d.d(view, this.f37438a) : com.scwang.smartrefresh.layout.util.d.a(view, this.f37438a);
    }

    @Override // m2.i
    public boolean b(View view) {
        i iVar = this.f37439b;
        return iVar != null ? iVar.b(view) : com.scwang.smartrefresh.layout.util.d.b(view, this.f37438a);
    }

    void c(MotionEvent motionEvent) {
        this.f37438a = motionEvent;
    }

    public void d(boolean z5) {
        this.f37440c = z5;
    }

    void e(i iVar) {
        this.f37439b = iVar;
    }
}
