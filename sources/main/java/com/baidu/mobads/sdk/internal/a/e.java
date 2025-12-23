package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class e implements a {

    /* renamed from: a, reason: collision with root package name */
    private c f10544a;

    public void a(IAdInterListener iAdInterListener) {
        if (iAdInterListener != null) {
            this.f10544a = c.a(iAdInterListener, this);
        }
    }

    public void b(@Nullable Bundle bundle) {
        this.f10544a.a("onActivityCreated", bundle);
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    public void a(Context context) {
        this.f10544a.a("onAttach", context);
    }

    public void b() {
        this.f10544a.a("onResume");
    }

    public void c() {
        this.f10544a.a("onPause");
    }

    public void d() {
        this.f10544a.a("onStop");
    }

    public void e() {
        this.f10544a.a("onDestroyView");
    }

    public void f() {
        this.f10544a.a("onDestroy");
    }

    public void g() {
        this.f10544a.a("onDetach");
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.f10544a.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.f10544a.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f10544a.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.f10544a.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f10544a.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.f10544a.getType();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.f10544a.setTarget(obj);
    }

    public void a(@Nullable Bundle bundle) {
        this.f10544a.a("onCreate", bundle);
    }

    @Nullable
    public View a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        Object a6 = this.f10544a.a("onCreateView", layoutInflater, viewGroup, bundle);
        if (a6 instanceof View) {
            return (View) a6;
        }
        return null;
    }

    public void a() {
        this.f10544a.a("onStart");
    }
}
