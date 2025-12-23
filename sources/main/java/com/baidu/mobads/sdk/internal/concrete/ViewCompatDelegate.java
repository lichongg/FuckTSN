package com.baidu.mobads.sdk.internal.concrete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bn;
import com.tencent.bugly.BuglyStrategy;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ViewCompatDelegate implements a {

    /* renamed from: c, reason: collision with root package name */
    private final c f10948c;

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f10946b = new AtomicInteger(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);

    /* renamed from: a, reason: collision with root package name */
    private static final String f10945a = "generateViewId";

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f10947d = av.a((Class<?>) ViewCompat.class, f10945a, (Class<?>[]) new Class[0]);

    @SuppressLint({"NewApi"})
    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i6;
        int i7;
        if (f10947d) {
            return ViewCompat.generateViewId();
        }
        if (bn.a((Context) null).a() >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = f10946b;
            i6 = atomicInteger.get();
            i7 = i6 + 1;
            if (i7 > 16777215) {
                i7 = 1;
            }
        } while (!atomicInteger.compareAndSet(i6, i7));
        return i6;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f10948c.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f10948c.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f10948c.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f10948c.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f10948c.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f10948c.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f10945a.equals(str2)) {
            return Integer.valueOf(generateViewId());
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f10948c.setTarget(obj);
    }

    public ViewCompatDelegate(@NonNull IAdInterListener iAdInterListener) {
        this.f10948c = c.a(iAdInterListener, this);
    }
}
