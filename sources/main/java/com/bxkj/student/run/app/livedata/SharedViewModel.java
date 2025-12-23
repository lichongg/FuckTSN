package com.bxkj.student.run.app.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SharedViewModel extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private MutableLiveData<String> f19844a = new MutableLiveData<>();

    @NotNull
    public final LiveData<String> a() {
        return this.f19844a;
    }

    public final void b(@NotNull String value) {
        g0.p(value, "value");
        this.f19844a.setValue(value);
    }
}
