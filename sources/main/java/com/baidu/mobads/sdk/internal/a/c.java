package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.bu;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c implements com.baidu.mobads.sdk.internal.a.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10526a = "ViewPager2";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10527b = "RVAdapter";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10528c = "RVViewHolder";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10529d = "ViewCompat";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10530e = "Fragment";

    /* renamed from: f, reason: collision with root package name */
    public static final String f10531f = "FragmentV4";

    /* renamed from: g, reason: collision with root package name */
    public static final String f10532g = "RLRecyclerView";

    /* renamed from: h, reason: collision with root package name */
    public static final String f10533h = "p_e";

    /* renamed from: i, reason: collision with root package name */
    private static final String f10534i = "p_init";

    /* renamed from: j, reason: collision with root package name */
    private static final String f10535j = "p_set_class";

    /* renamed from: k, reason: collision with root package name */
    private static final String f10536k = "e_t";

    /* renamed from: l, reason: collision with root package name */
    private static final String f10537l = "e_n";

    /* renamed from: m, reason: collision with root package name */
    private static final String f10538m = "e_a";

    /* renamed from: n, reason: collision with root package name */
    private static final String f10539n = "e_r";

    /* renamed from: o, reason: collision with root package name */
    private static final String f10540o = "e_d";

    /* renamed from: p, reason: collision with root package name */
    private final IAdInterListener f10541p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a implements IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            if (c.f10526a.equals(str) && c.a(objArr, (Class<?>[]) new Class[]{Context.class})) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if (c.f10527b.equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if (c.f10528c.equals(str) && c.a(objArr, (Class<?>[]) new Class[]{View.class})) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if (c.f10529d.equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            if (c.f10530e.equals(str)) {
                return new FragmentDelegate().setDispatcher(iAdInterListener);
            }
            if (c.f10531f.equals(str)) {
                return new FragmentV4Delegate().setDispatcher(iAdInterListener);
            }
            if (c.f10532g.equals(str)) {
                return new RLRecyclerViewDelegate(iAdInterListener, objArr);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a a6;
            if (iOAdEvent != null) {
                try {
                    if (c.f10533h.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get(c.f10536k);
                        Object obj2 = data.get(c.f10537l);
                        Object obj3 = data.get(c.f10538m);
                        Object[] objArr = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if (c.f10534i.equals((String) obj2)) {
                                Object obj4 = data.get(c.f10540o);
                                if (!(obj4 instanceof IAdInterListener) || (a6 = a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put(c.f10539n, a6);
                                return;
                            }
                            if (c.f10535j.equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put(c.f10526a, ViewPager2.class);
                                map.put(c.f10527b, RecyclerView.Adapter.class);
                                map.put(c.f10528c, RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th) {
                    bu.a().b(th.getMessage());
                }
            }
        }
    }

    public static c a(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        return new c(iAdInterListener, aVar);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    public final void a(String str) {
        this.f10541p.onAdTaskProcess(str);
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f10541p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f10541p;
    }

    private c(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        this.f10541p = iAdInterListener;
        iAdInterListener.addEventListener(f10533h, new d(this, aVar));
    }

    public final Object a(String str, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(f10538m, objArr);
        this.f10541p.onAdTaskProcess(str, hashMap);
        return hashMap.get(f10539n);
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        boolean z5 = objArr == null || objArr.length == 0;
        boolean z6 = clsArr == null || clsArr.length == 0;
        if (z5 && z6) {
            return true;
        }
        if (z5 || z6 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i6 = 0; i6 < clsArr.length; i6++) {
            if (!clsArr[i6].isInstance(objArr[i6])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
    }
}
