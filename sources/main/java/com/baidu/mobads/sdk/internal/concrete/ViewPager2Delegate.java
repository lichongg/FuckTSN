package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes2.dex */
public class ViewPager2Delegate extends ViewPager2 implements a {

    /* renamed from: m, reason: collision with root package name */
    private static final String f10949m = "getScrollState";

    /* renamed from: n, reason: collision with root package name */
    private static final String f10950n = "getCurrentItem";

    /* renamed from: o, reason: collision with root package name */
    private static final String f10951o = "setCurrentItem";

    /* renamed from: p, reason: collision with root package name */
    private static final String f10952p = "setOrientation";

    /* renamed from: q, reason: collision with root package name */
    private static final String f10953q = "setAdapter";

    /* renamed from: r, reason: collision with root package name */
    private static final String f10954r = "setOffscreenPageLimit";

    /* renamed from: s, reason: collision with root package name */
    private static final String f10955s = "setUserInputEnabled";

    /* renamed from: t, reason: collision with root package name */
    private final c f10956t;

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f10956t.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f10956t.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f10956t.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f10956t.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f10956t.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f10956t.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f10949m.equals(str2)) {
            return Integer.valueOf(getScrollState());
        }
        if (f10950n.equals(str2)) {
            return Integer.valueOf(getCurrentItem());
        }
        if (f10951o.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setCurrentItem(((Integer) objArr[0]).intValue());
            return null;
        }
        if (f10952p.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setOrientation(((Integer) objArr[0]).intValue());
            return null;
        }
        if (f10953q.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{RecyclerView.Adapter.class})) {
            setAdapter((RecyclerView.Adapter) objArr[0]);
            return null;
        }
        if (f10954r.equals(str2) && c.a(objArr, (Class<?>[]) new Class[]{Integer.class})) {
            setOffscreenPageLimit(((Integer) objArr[0]).intValue());
            return null;
        }
        if (!f10955s.equals(str2) || !c.a(objArr, (Class<?>[]) new Class[]{Boolean.class})) {
            return null;
        }
        setUserInputEnabled(((Boolean) objArr[0]).booleanValue());
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f10956t.setTarget(obj);
    }

    public ViewPager2Delegate(IAdInterListener iAdInterListener, Context context) {
        super(context);
        this.f10956t = c.a(iAdInterListener, this);
        setOnOverScrollListener(new ViewPager2.OnOverScrollListener() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollEnd() {
                ViewPager2Delegate.this.f10956t.a("onOverScrollEnd");
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnOverScrollListener
            public void onOverScrollStart() {
                ViewPager2Delegate.this.f10956t.a("onOverScrollStart");
            }
        });
        registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i6) {
                ViewPager2Delegate.this.f10956t.a("onPageScrollStateChanged", Integer.valueOf(i6));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrolled(int i6, float f6, int i7) {
                ViewPager2Delegate.this.f10956t.a("onPageScrolled", Integer.valueOf(i6), Float.valueOf(f6), Integer.valueOf(i7));
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i6) {
                ViewPager2Delegate.this.f10956t.a("onPageSelected", Integer.valueOf(i6));
            }
        });
    }
}
