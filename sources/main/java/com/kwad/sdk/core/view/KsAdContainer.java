package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.annotation.MainThread;
import com.kwad.sdk.utils.aj;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class KsAdContainer extends RelativeLayout {
    protected aj.a aLL;

    public KsAdContainer(Context context) {
        super(context);
        this.aLL = new aj.a();
    }

    @MainThread
    public aj.a getTouchCoords() {
        return this.aLL;
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLL = new aj.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.aLL.f(motionEvent.getX(), motionEvent.getY());
            }
        } else {
            aj.a aVar = new aj.a(getWidth(), getHeight());
            this.aLL = aVar;
            aVar.e(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.aLL = new aj.a();
    }
}
