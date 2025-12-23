package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40553a = "com.tencent.open.c.a";

    /* renamed from: b, reason: collision with root package name */
    private Rect f40554b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40555c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0814a f40556d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0814a {
        void a();

        void a(int i6);
    }

    public void a(InterfaceC0814a interfaceC0814a) {
        this.f40556d = interfaceC0814a;
    }

    public a(Context context) {
        super(context);
        this.f40554b = null;
        this.f40555c = false;
        this.f40556d = null;
        this.f40554b = new Rect();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        int size = View.MeasureSpec.getSize(i7);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f40554b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f40554b.top) - size;
        InterfaceC0814a interfaceC0814a = this.f40556d;
        if (interfaceC0814a != null && size != 0) {
            if (height > 100) {
                interfaceC0814a.a((Math.abs(this.f40554b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0814a.a();
            }
        }
        super.onMeasure(i6, i7);
    }
}
