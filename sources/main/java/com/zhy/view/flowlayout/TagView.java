package com.zhy.view.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class TagView extends FrameLayout implements Checkable {

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f42956b = {android.R.attr.state_checked};

    /* renamed from: a, reason: collision with root package name */
    private boolean f42957a;

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f42957a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i6) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i6 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f42956b);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        if (this.f42957a != z5) {
            this.f42957a = z5;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f42957a);
    }

    public TagView(Context context) {
        super(context);
    }
}
