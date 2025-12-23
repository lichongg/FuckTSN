package com.baidu.mobads.sdk.internal.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final List<ViewPager2.OnPageChangeCallback> f11104a;

    void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f11104a.add(onPageChangeCallback);
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    void b(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f11104a.remove(onPageChangeCallback);
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i6) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.f11104a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrollStateChanged(i6);
            }
        } catch (ConcurrentModificationException e6) {
            a(e6);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i6, float f6, @Px int i7) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.f11104a.iterator();
            while (it.hasNext()) {
                it.next().onPageScrolled(i6, f6, i7);
            }
        } catch (ConcurrentModificationException e6) {
            a(e6);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i6) {
        try {
            Iterator<ViewPager2.OnPageChangeCallback> it = this.f11104a.iterator();
            while (it.hasNext()) {
                it.next().onPageSelected(i6);
            }
        } catch (ConcurrentModificationException e6) {
            a(e6);
        }
    }

    CompositeOnPageChangeCallback(int i6) {
        this.f11104a = new ArrayList(i6);
    }
}
