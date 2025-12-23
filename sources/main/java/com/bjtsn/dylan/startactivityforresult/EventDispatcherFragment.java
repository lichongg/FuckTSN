package com.bjtsn.dylan.startactivityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class EventDispatcherFragment extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private SparseArray<b.a> f14548c = new SparseArray<>();

    @NotNull
    public final SparseArray<b.a> b() {
        return this.f14548c;
    }

    public final void c(@NotNull SparseArray<b.a> sparseArray) {
        g0.p(sparseArray, "<set-?>");
        this.f14548c = sparseArray;
    }

    public final void startActivityForResult(@NotNull Intent intent, @NotNull b.a callback) {
        g0.p(intent, "intent");
        g0.p(callback, "callback");
        int size = this.f14548c.size();
        this.f14548c.put(size, callback);
        startActivityForResult(intent, size);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i6, int i7, @Nullable Intent intent) {
        super.onActivityResult(i6, i7, intent);
        b.a aVar = this.f14548c.get(i6);
        if (aVar != null) {
            this.f14548c.remove(i6);
            aVar.a(i7, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }
}
