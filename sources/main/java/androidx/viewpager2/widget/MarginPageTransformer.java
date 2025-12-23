package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(@Px int i6) {
        Preconditions.checkArgumentNonnegative(i6, "Margin must be non-negative");
        this.mMarginPx = i6;
    }

    private ViewPager2 requireViewPager(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f6) {
        ViewPager2 requireViewPager = requireViewPager(view);
        float f7 = this.mMarginPx * f6;
        if (requireViewPager.getOrientation() == 0) {
            if (requireViewPager.isRtl()) {
                f7 = -f7;
            }
            view.setTranslationX(f7);
            return;
        }
        view.setTranslationY(f7);
    }
}
