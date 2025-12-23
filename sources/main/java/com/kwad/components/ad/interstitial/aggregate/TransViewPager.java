package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.h.c;
import com.kwad.sdk.widget.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class TransViewPager extends f {
    private float lu;

    @SlideType
    private int lv;
    private Map<Integer, c> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    private void a(View view, View view2, float f6) {
        if (this.lv == 0 && f6 != 0.0f) {
            float f7 = this.lu;
            if (f7 != 0.0f) {
                if (f6 > f7) {
                    this.lv = 1;
                } else {
                    this.lv = 2;
                }
            }
        }
        if (this.lv == 1 && view2 != null) {
            if (f6 > 0.5d || f6 <= 0.0f) {
                view2.setTranslationX((1.0f - f6) * 240.0f);
            } else {
                view2.setTranslationX(240.0f * f6);
            }
        }
        if (this.lv == 2 && view != null) {
            if (f6 > 0.5d || f6 < 0.0f) {
                view.setTranslationX((1.0f - f6) * (-240.0f));
            } else {
                view.setTranslationX((-240.0f) * f6);
            }
        }
        this.lu = f6;
        if (f6 == 0.0f) {
            this.lv = 0;
        }
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.lv = 0;
    }

    public final c J(int i6) {
        return this.map.get(Integer.valueOf(i6));
    }

    @Override // androidx.viewpager.widget.ViewPager
    protected void onPageScrolled(int i6, float f6, int i7) {
        a(J(i6), J(i6 + 1), f6);
        super.onPageScrolled(i6, f6, i7);
    }

    public final void a(int i6, c cVar) {
        this.map.put(Integer.valueOf(i6), cVar);
    }
}
