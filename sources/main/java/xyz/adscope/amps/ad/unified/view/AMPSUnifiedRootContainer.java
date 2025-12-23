package xyz.adscope.amps.ad.unified.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSUnifiedRootContainer extends FrameLayout {
    public AMPSUnifiedRootContainer(Context context) {
        super(context);
    }

    public AMPSUnifiedRootContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AMPSUnifiedRootContainer(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    void insertChannelSpecifiedContainer(ViewGroup viewGroup) {
        if (getChildCount() > 0) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                removeView(childAt);
                viewGroup.addView(childAt, layoutParams);
            }
            addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    public AMPSUnifiedRootContainer(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }
}
