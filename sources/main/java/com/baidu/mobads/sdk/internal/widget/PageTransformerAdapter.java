package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Locale;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f11113a;

    /* renamed from: b, reason: collision with root package name */
    private ViewPager2.PageTransformer f11114b;

    ViewPager2.PageTransformer a() {
        return this.f11114b;
    }

    void a(@Nullable ViewPager2.PageTransformer pageTransformer) {
        this.f11114b = pageTransformer;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i6, float f6, int i7) {
        if (this.f11114b == null) {
            return;
        }
        float f7 = -f6;
        for (int i8 = 0; i8 < this.f11113a.getChildCount(); i8++) {
            View childAt = this.f11113a.getChildAt(i8);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i8), Integer.valueOf(this.f11113a.getChildCount())));
            }
            this.f11114b.transformPage(childAt, (this.f11113a.getPosition(childAt) - i6) + f7);
        }
    }

    PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f11113a = linearLayoutManager;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i6) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i6) {
    }
}
