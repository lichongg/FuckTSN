package com.huawei.hms.feature.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class DeferredLifecycleHelper<T extends LifecycleDelegate> {
    public static final int STATUS_ONCREATED = 1;
    public static final int STATUS_ONCREATEVIEW = 2;
    public static final int STATUS_ONINFLATE = 0;
    public static final int STATUS_ONRESUME = 5;
    public static final int STATUS_ONSTART = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final String f33131e = "DeferredLifecycleHelper";

    /* renamed from: a, reason: collision with root package name */
    public T f33132a;

    /* renamed from: b, reason: collision with root package name */
    public Bundle f33133b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<g> f33134c;

    /* renamed from: d, reason: collision with root package name */
    public OnDelegateCreatedListener<T> f33135d = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements OnDelegateCreatedListener<T> {
        public a() {
        }

        @Override // com.huawei.hms.feature.dynamic.OnDelegateCreatedListener
        public void onDelegateCreated(T t5) {
            DeferredLifecycleHelper.this.f33132a = t5;
            Iterator it = DeferredLifecycleHelper.this.f33134c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(DeferredLifecycleHelper.this.f33132a);
            }
            DeferredLifecycleHelper.this.f33134c.clear();
            DeferredLifecycleHelper.this.f33133b = null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f33137a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bundle f33138b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bundle f33139c;

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 0;
        }

        public b(Activity activity, Bundle bundle, Bundle bundle2) {
            this.f33137a = activity;
            this.f33138b = bundle;
            this.f33139c = bundle2;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            DeferredLifecycleHelper.this.f33132a.onInflate(this.f33137a, this.f33138b, this.f33139c);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f33141a;

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 1;
        }

        public c(Bundle bundle) {
            this.f33141a = bundle;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f33131e;
            lifecycleDelegate.onCreate(this.f33141a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f33143a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LayoutInflater f33144b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f33145c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bundle f33146d;

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 2;
        }

        public d(FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.f33143a = frameLayout;
            this.f33144b = layoutInflater;
            this.f33145c = viewGroup;
            this.f33146d = bundle;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            this.f33143a.removeAllViews();
            this.f33143a.addView(DeferredLifecycleHelper.this.f33132a.onCreateView(this.f33144b, this.f33145c, this.f33146d));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e implements g {
        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 4;
        }

        public e() {
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f33131e;
            lifecycleDelegate.onStart();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements g {
        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public int a() {
            return 5;
        }

        public f() {
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper.g
        public void a(LifecycleDelegate lifecycleDelegate) {
            String unused = DeferredLifecycleHelper.f33131e;
            lifecycleDelegate.onResume();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface g {
        int a();

        void a(LifecycleDelegate lifecycleDelegate);
    }

    public abstract void createDelegate(OnDelegateCreatedListener<T> onDelegateCreatedListener);

    public T getDelegate() {
        return this.f33132a;
    }

    public void onCreate(Bundle bundle) {
        a(bundle, new c(bundle));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, new d(frameLayout, layoutInflater, viewGroup, bundle));
        return frameLayout;
    }

    public void onDestroy() {
        T t5 = this.f33132a;
        if (t5 != null) {
            t5.onDestroy();
        } else {
            a(0);
        }
    }

    public void onDestroyView() {
        T t5 = this.f33132a;
        if (t5 != null) {
            t5.onDestroyView();
        } else {
            a(1);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, new b(activity, bundle, bundle2));
    }

    public void onLowMemory() {
        T t5 = this.f33132a;
        if (t5 != null) {
            t5.onLowMemory();
        }
    }

    public void onPause() {
        T t5 = this.f33132a;
        if (t5 != null) {
            t5.onPause();
        } else {
            a(5);
        }
    }

    public void onResume() {
        a((Bundle) null, new f());
    }

    public void onSaveInstanceState(Bundle bundle) {
        T t5 = this.f33132a;
        if (t5 != null) {
            t5.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.f33133b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        a((Bundle) null, new e());
    }

    public void onStop() {
        T t5 = this.f33132a;
        if (t5 != null) {
            t5.onStop();
        } else {
            a(4);
        }
    }

    private void a(int i6) {
        while (!this.f33134c.isEmpty() && this.f33134c.getLast().a() >= i6) {
            this.f33134c.removeLast();
        }
    }

    private void a(Bundle bundle, g gVar) {
        T t5 = this.f33132a;
        if (t5 != null) {
            gVar.a(t5);
            return;
        }
        if (this.f33134c == null) {
            this.f33134c = new LinkedList<>();
        }
        this.f33134c.add(gVar);
        if (bundle != null) {
            Bundle bundle2 = this.f33133b;
            if (bundle2 == null) {
                Object clone = bundle.clone();
                if (clone != null && (clone instanceof Bundle)) {
                    this.f33133b = (Bundle) clone;
                }
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.f33135d);
    }
}
