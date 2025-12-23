package com.acse.ottn;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class p2 extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    public a f5002a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(int i6);
    }

    public p2(Context context) {
        super(context);
    }

    public p2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnScrollListener(a aVar) {
        this.f5002a = aVar;
    }

    public p2(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        a aVar = this.f5002a;
        if (aVar != null) {
            aVar.a(getScrollY());
        }
    }
}
