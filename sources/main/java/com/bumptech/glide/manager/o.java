package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Deprecated
/* loaded from: D:\Downloads\app\classes3.dex */
public class o extends Fragment {

    /* renamed from: g, reason: collision with root package name */
    private static final String f15802g = "RMFragment";

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f15803a;

    /* renamed from: b, reason: collision with root package name */
    private final r f15804b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<o> f15805c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.i f15806d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private o f15807e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Fragment f15808f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements r {
        a() {
        }

        @Override // com.bumptech.glide.manager.r
        @NonNull
        public Set<com.bumptech.glide.i> a() {
            Set<o> b6 = o.this.b();
            HashSet hashSet = new HashSet(b6.size());
            for (o oVar : b6) {
                if (oVar.e() != null) {
                    hashSet.add(oVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new com.bumptech.glide.manager.a());
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    o(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f15804b = new a();
        this.f15805c = new HashSet();
        this.f15803a = aVar;
    }

    private void a(o oVar) {
        this.f15805c.add(oVar);
    }

    private void i(o oVar) {
        this.f15805c.remove(oVar);
    }

    private void l() {
        o oVar = this.f15807e;
        if (oVar != null) {
            oVar.i(this);
            this.f15807e = null;
        }
    }

    @NonNull
    @TargetApi(17)
    Set<o> b() {
        if (equals(this.f15807e)) {
            return Collections.unmodifiableSet(this.f15805c);
        }
        if (this.f15807e == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        for (o oVar : this.f15807e.b()) {
            if (g(oVar.getParentFragment())) {
                hashSet.add(oVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    com.bumptech.glide.manager.a c() {
        return this.f15803a;
    }

    @Nullable
    public com.bumptech.glide.i e() {
        return this.f15806d;
    }

    @NonNull
    public r f() {
        return this.f15804b;
    }

    void j(@Nullable Fragment fragment) {
        this.f15808f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(@Nullable com.bumptech.glide.i iVar) {
        this.f15806d = iVar;
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @Nullable
    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f15808f;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 != null) {
                if (parentFragment2.equals(parentFragment)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void h(@NonNull Activity activity) {
        l();
        o q5 = com.bumptech.glide.b.e(activity).n().q(activity);
        this.f15807e = q5;
        if (!equals(q5)) {
            this.f15807e.a(this);
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable(f15802g, 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f15803a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f15803a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f15803a.e();
    }
}
