package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: i, reason: collision with root package name */
    private static final String f15782i = "SupportRMFragment";

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f15783c;

    /* renamed from: d, reason: collision with root package name */
    private final r f15784d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<SupportRequestManagerFragment> f15785e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private SupportRequestManagerFragment f15786f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.i f15787g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private Fragment f15788h;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a implements r {
        a() {
        }

        @Override // com.bumptech.glide.manager.r
        @NonNull
        public Set<com.bumptech.glide.i> a() {
            Set<SupportRequestManagerFragment> c6 = SupportRequestManagerFragment.this.c();
            HashSet hashSet = new HashSet(c6.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : c6) {
                if (supportRequestManagerFragment.f() != null) {
                    hashSet.add(supportRequestManagerFragment.f());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f15784d = new a();
        this.f15785e = new HashSet();
        this.f15783c = aVar;
    }

    private void b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f15785e.add(supportRequestManagerFragment);
    }

    private void k(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f15785e.remove(supportRequestManagerFragment);
    }

    private void n() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f15786f;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.k(this);
            this.f15786f = null;
        }
    }

    @NonNull
    Set<SupportRequestManagerFragment> c() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f15786f;
        if (supportRequestManagerFragment == null) {
            return Collections.EMPTY_SET;
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f15785e);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f15786f.c()) {
            if (i(supportRequestManagerFragment2.e())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    com.bumptech.glide.manager.a d() {
        return this.f15783c;
    }

    @Nullable
    public com.bumptech.glide.i f() {
        return this.f15787g;
    }

    @NonNull
    public r g() {
        return this.f15784d;
    }

    void l(@Nullable Fragment fragment) {
        FragmentManager h6;
        this.f15788h = fragment;
        if (fragment == null || fragment.getContext() == null || (h6 = h(fragment)) == null) {
            return;
        }
        j(fragment.getContext(), h6);
    }

    public void m(@Nullable com.bumptech.glide.i iVar) {
        this.f15787g = iVar;
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }

    @Nullable
    private Fragment e() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f15788h;
    }

    @Nullable
    private static FragmentManager h(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean i(@NonNull Fragment fragment) {
        Fragment e6 = e();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment != null) {
                if (parentFragment.equals(e6)) {
                    return true;
                }
                fragment = fragment.getParentFragment();
            } else {
                return false;
            }
        }
    }

    private void j(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        n();
        SupportRequestManagerFragment s5 = com.bumptech.glide.b.e(context).n().s(fragmentManager);
        this.f15786f = s5;
        if (!equals(s5)) {
            this.f15786f.b(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager h6 = h(this);
        if (h6 == null) {
            Log.isLoggable(f15782i, 5);
            return;
        }
        try {
            j(getContext(), h6);
        } catch (IllegalStateException unused) {
            Log.isLoggable(f15782i, 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f15783c.c();
        n();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f15788h = null;
        n();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f15783c.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f15783c.e();
    }
}
