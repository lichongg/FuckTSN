package com.kwad.sdk.core.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.widget.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes6.dex */
public class AdBaseFrameLayout extends FrameLayout implements d, g {
    private static final aj.a aLL = new aj.a();
    private List<View.OnTouchListener> aLJ;
    private c aLK;

    public AdBaseFrameLayout(Context context) {
        super(context);
        this.aLJ = new ArrayList();
        this.aLK = new c();
    }

    @UiThread
    public final void a(View.OnTouchListener onTouchListener) {
        if (this.aLJ.contains(onTouchListener)) {
            return;
        }
        this.aLJ.add(onTouchListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.aLJ.isEmpty()) {
            Iterator<View.OnTouchListener> it = this.aLJ.iterator();
            while (it.hasNext()) {
                it.next().onTouch(this, motionEvent);
            }
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            aj.a aVar = aLL;
            aVar.B(getWidth(), getHeight());
            aVar.e(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            aLL.f(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.kwad.sdk.widget.g
    @MainThread
    public aj.a getTouchCoords() {
        return aLL;
    }

    @Override // com.kwad.sdk.core.view.d
    @NonNull
    public c getWindowFocusChangeHelper() {
        return this.aLK;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        try {
            super.dispatchRestoreInstanceState(sparseArray);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            com.kwad.sdk.service.d.gatherException(th);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        com.kwad.sdk.core.d.c.d("KsAdBaseFrameLayout", this + ": onWindowFocusChanged hasWindowFocus: " + z5);
        this.aLK.j(this, z5);
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLJ = new ArrayList();
        this.aLK = new c();
    }

    public AdBaseFrameLayout(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.aLJ = new ArrayList();
        this.aLK = new c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
    }

    @Override // android.view.View
    public void saveHierarchyState(SparseArray<Parcelable> sparseArray) {
    }
}
