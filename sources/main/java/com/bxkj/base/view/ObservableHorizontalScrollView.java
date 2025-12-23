package com.bxkj.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ObservableHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a, reason: collision with root package name */
    private a f17169a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(ObservableHorizontalScrollView observableHorizontalScrollView, int i6, int i7, int i8, int i9);
    }

    public ObservableHorizontalScrollView(Context context) {
        super(context);
        this.f17169a = null;
    }

    public void setScrollViewListener(a aVar) {
        this.f17169a = aVar;
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f17169a = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i6, int i7, int i8, int i9) {
        super.onScrollChanged(i6, i7, i8, i9);
        a aVar = this.f17169a;
        if (aVar != null) {
            aVar.a(this, i6, i7, i8, i9);
        }
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17169a = null;
    }
}
