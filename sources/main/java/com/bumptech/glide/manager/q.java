package com.bumptech.glide.manager;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.c;
import com.bumptech.glide.load.resource.bitmap.a0;
import com.stub.StubApp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class q implements Handler.Callback {

    /* renamed from: j, reason: collision with root package name */
    @VisibleForTesting
    static final String f15810j = "com.bumptech.glide.manager";

    /* renamed from: k, reason: collision with root package name */
    private static final String f15811k = "RMRetriever";

    /* renamed from: l, reason: collision with root package name */
    private static final int f15812l = 1;

    /* renamed from: m, reason: collision with root package name */
    private static final int f15813m = 2;

    /* renamed from: n, reason: collision with root package name */
    private static final String f15814n = "key";

    /* renamed from: o, reason: collision with root package name */
    private static final b f15815o = new a();

    /* renamed from: a, reason: collision with root package name */
    private volatile com.bumptech.glide.i f15816a;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f15819d;

    /* renamed from: e, reason: collision with root package name */
    private final b f15820e;

    /* renamed from: i, reason: collision with root package name */
    private final k f15824i;

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final Map<FragmentManager, o> f15817b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f15818c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final ArrayMap<View, Fragment> f15821f = new ArrayMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f15822g = new ArrayMap<>();

    /* renamed from: h, reason: collision with root package name */
    private final Bundle f15823h = new Bundle();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements b {
        @Override // com.bumptech.glide.manager.q.b
        @NonNull
        public com.bumptech.glide.i a(@NonNull com.bumptech.glide.b bVar, @NonNull l lVar, @NonNull r rVar, @NonNull Context context) {
            return new com.bumptech.glide.i(bVar, lVar, rVar, context);
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        @NonNull
        com.bumptech.glide.i a(@NonNull com.bumptech.glide.b bVar, @NonNull l lVar, @NonNull r rVar, @NonNull Context context);
    }

    @Deprecated
    private void e(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        android.app.Fragment fragment;
        int i6 = 0;
        while (true) {
            int i7 = i6 + 1;
            this.f15823h.putInt(f15814n, i6);
            try {
                fragment = fragmentManager.getFragment(this.f15823h, f15814n);
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                d(fragment.getChildFragmentManager(), arrayMap);
            }
            i6 = i7;
        }
    }

    @NonNull
    SupportRequestManagerFragment s(androidx.fragment.app.FragmentManager fragmentManager) {
        return t(fragmentManager, null);
    }

    private static k b(com.bumptech.glide.e eVar) {
        return (a0.f15567i && a0.f15566h) ? eVar.b(c.f.class) ? new i() : new j() : new g();
    }

    @Nullable
    private static Activity c(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        List<android.app.Fragment> fragments;
        if (Build.VERSION.SDK_INT < 26) {
            e(fragmentManager, arrayMap);
            return;
        }
        fragments = fragmentManager.getFragments();
        for (android.app.Fragment fragment : fragments) {
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                d(fragment.getChildFragmentManager(), arrayMap);
            }
        }
    }

    private static void f(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                f(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    private android.app.Fragment g(@NonNull View view, @NonNull Activity activity) {
        this.f15822g.clear();
        d(activity.getFragmentManager(), this.f15822g);
        View findViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f15822g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f15822g.clear();
        return fragment;
    }

    @Nullable
    private Fragment h(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f15821f.clear();
        f(fragmentActivity.getSupportFragmentManager().getFragments(), this.f15821f);
        View findViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f15821f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f15821f.clear();
        return fragment;
    }

    @NonNull
    private com.bumptech.glide.i p(@NonNull Context context) {
        if (this.f15816a == null) {
            synchronized (this) {
                try {
                    if (this.f15816a == null) {
                        this.f15816a = this.f15820e.a(com.bumptech.glide.b.e(StubApp.getOrigApplicationContext(context.getApplicationContext())), new com.bumptech.glide.manager.b(), new h(), StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    }
                } finally {
                }
            }
        }
        return this.f15816a;
    }

    @NonNull
    private o r(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment) {
        o oVar = (o) fragmentManager.findFragmentByTag(f15810j);
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = this.f15817b.get(fragmentManager);
        if (oVar2 != null) {
            return oVar2;
        }
        o oVar3 = new o();
        oVar3.j(fragment);
        this.f15817b.put(fragmentManager, oVar3);
        fragmentManager.beginTransaction().add(oVar3, f15810j).commitAllowingStateLoss();
        this.f15819d.obtainMessage(1, fragmentManager).sendToTarget();
        return oVar3;
    }

    @NonNull
    private SupportRequestManagerFragment t(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(f15810j);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        SupportRequestManagerFragment supportRequestManagerFragment2 = this.f15818c.get(fragmentManager);
        if (supportRequestManagerFragment2 != null) {
            return supportRequestManagerFragment2;
        }
        SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
        supportRequestManagerFragment3.l(fragment);
        this.f15818c.put(fragmentManager, supportRequestManagerFragment3);
        fragmentManager.beginTransaction().add(supportRequestManagerFragment3, f15810j).commitAllowingStateLoss();
        this.f15819d.obtainMessage(2, fragmentManager).sendToTarget();
        return supportRequestManagerFragment3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        ComponentCallbacks remove;
        Object obj2;
        ComponentCallbacks componentCallbacks;
        int i6 = message.what;
        boolean z5 = true;
        if (i6 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f15817b.remove(obj);
        } else {
            if (i6 != 2) {
                componentCallbacks = null;
                z5 = false;
                obj2 = null;
                if (z5 && componentCallbacks == null && Log.isLoggable(f15811k, 5)) {
                    Objects.toString(obj2);
                }
                return z5;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f15818c.remove(obj);
        }
        ComponentCallbacks componentCallbacks2 = remove;
        obj2 = obj;
        componentCallbacks = componentCallbacks2;
        if (z5) {
            Objects.toString(obj2);
        }
        return z5;
    }

    @NonNull
    public com.bumptech.glide.i l(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (com.bumptech.glide.util.l.u() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return o((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return j((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (StubApp.getOrigApplicationContext(contextWrapper.getBaseContext().getApplicationContext()) != null) {
                    return l(contextWrapper.getBaseContext());
                }
            }
        }
        return p(context);
    }

    public q(@Nullable b bVar, com.bumptech.glide.e eVar) {
        this.f15820e = bVar == null ? f15815o : bVar;
        this.f15819d = new Handler(Looper.getMainLooper(), this);
        this.f15824i = b(eVar);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (!activity.isDestroyed()) {
        } else {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @NonNull
    @Deprecated
    private com.bumptech.glide.i i(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z5) {
        o r5 = r(fragmentManager, fragment);
        com.bumptech.glide.i e6 = r5.e();
        if (e6 == null) {
            com.bumptech.glide.i a6 = this.f15820e.a(com.bumptech.glide.b.e(context), r5.c(), r5.f(), context);
            if (z5) {
                a6.onStart();
            }
            r5.k(a6);
            return a6;
        }
        return e6;
    }

    private static boolean u(Context context) {
        Activity c6 = c(context);
        if (c6 != null && c6.isFinishing()) {
            return false;
        }
        return true;
    }

    @NonNull
    private com.bumptech.glide.i v(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z5) {
        SupportRequestManagerFragment t5 = t(fragmentManager, fragment);
        com.bumptech.glide.i f6 = t5.f();
        if (f6 == null) {
            com.bumptech.glide.i a6 = this.f15820e.a(com.bumptech.glide.b.e(context), t5.d(), t5.g(), context);
            if (z5) {
                a6.onStart();
            }
            t5.m(a6);
            return a6;
        }
        return f6;
    }

    @NonNull
    public com.bumptech.glide.i j(@NonNull Activity activity) {
        if (com.bumptech.glide.util.l.t()) {
            return l(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        }
        if (activity instanceof FragmentActivity) {
            return o((FragmentActivity) activity);
        }
        a(activity);
        this.f15824i.a(activity);
        return i(activity, activity.getFragmentManager(), null, u(activity));
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.i k(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!com.bumptech.glide.util.l.t()) {
                if (fragment.getActivity() != null) {
                    this.f15824i.a(fragment.getActivity());
                }
                return i(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return l(StubApp.getOrigApplicationContext(fragment.getActivity().getApplicationContext()));
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    public com.bumptech.glide.i m(@NonNull View view) {
        if (com.bumptech.glide.util.l.t()) {
            return l(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext()));
        }
        com.bumptech.glide.util.k.d(view);
        com.bumptech.glide.util.k.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity c6 = c(view.getContext());
        if (c6 == null) {
            return l(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext()));
        }
        if (c6 instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) c6;
            Fragment h6 = h(view, fragmentActivity);
            if (h6 != null) {
                return n(h6);
            }
            return o(fragmentActivity);
        }
        android.app.Fragment g6 = g(view, c6);
        if (g6 == null) {
            return j(c6);
        }
        return k(g6);
    }

    @NonNull
    public com.bumptech.glide.i n(@NonNull Fragment fragment) {
        com.bumptech.glide.util.k.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.util.l.t()) {
            return l(StubApp.getOrigApplicationContext(fragment.getContext().getApplicationContext()));
        }
        if (fragment.getActivity() != null) {
            this.f15824i.a(fragment.getActivity());
        }
        return v(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public com.bumptech.glide.i o(@NonNull FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.util.l.t()) {
            return l(StubApp.getOrigApplicationContext(fragmentActivity.getApplicationContext()));
        }
        a(fragmentActivity);
        this.f15824i.a(fragmentActivity);
        return v(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, u(fragmentActivity));
    }

    @NonNull
    @Deprecated
    o q(Activity activity) {
        return r(activity.getFragmentManager(), null);
    }
}
