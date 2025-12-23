package cn.bluemobi.dylan.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f1207c;

    /* renamed from: a, reason: collision with root package name */
    private Stack<Activity> f1208a = new Stack<>();

    /* renamed from: b, reason: collision with root package name */
    private List<Fragment> f1209b = new ArrayList();

    public void i(Class<?> cls) {
        int i6 = 0;
        while (i6 < this.f1208a.size()) {
            Activity activity = this.f1208a.get(i6);
            if (activity.getClass().equals(cls)) {
                h(activity);
                i6--;
            }
            i6++;
        }
    }

    public static a n() {
        if (f1207c == null) {
            f1207c = new a();
        }
        return f1207c;
    }

    public void c(Activity activity) {
        this.f1208a.add(activity);
    }

    public void d(Fragment fragment) {
        this.f1209b.add(fragment);
    }

    public Activity e() {
        if (this.f1208a.isEmpty()) {
            return null;
        }
        return this.f1208a.lastElement();
    }

    public void g() {
        if (this.f1208a.empty()) {
            return;
        }
        h(this.f1208a.lastElement());
    }

    public <T extends Activity> T getActivity(Class<?> cls) {
        Iterator<Activity> it = this.f1208a.iterator();
        while (it.hasNext()) {
            T t5 = (T) it.next();
            if (t5.getClass().equals(cls)) {
                return t5;
            }
        }
        return null;
    }

    public void h(Activity activity) {
        if (activity == null || !this.f1208a.remove(activity)) {
            return;
        }
        activity.finish();
    }

    public void j() {
        ArrayList arrayList = new ArrayList(this.f1208a);
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (arrayList.get(i6) != null) {
                ((Activity) arrayList.get(i6)).finish();
            }
        }
        this.f1208a.clear();
    }

    public void k() {
        ArrayList arrayList = new ArrayList(this.f1208a);
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            Activity activity = (Activity) arrayList.get(i6);
            if (arrayList.get(i6) != null && !((Activity) arrayList.get(i6)).getClass().getSimpleName().equals("LoginActivity")) {
                ((Activity) arrayList.get(i6)).finish();
                this.f1208a.remove(activity);
            }
        }
    }

    public void l() {
        int size = this.f1208a.size();
        if (size >= 1) {
            ArrayList arrayList = new ArrayList(this.f1208a.subList(1, size));
            int size2 = arrayList.size();
            for (int i6 = 0; i6 < size2; i6++) {
                Activity activity = (Activity) arrayList.get(i6);
                if (activity != null) {
                    activity.finish();
                    this.f1208a.remove(activity);
                }
            }
        }
    }

    public Stack<Activity> m() {
        return this.f1208a;
    }

    public <T extends Fragment> T o(Class<?> cls) {
        Iterator<Fragment> it = this.f1209b.iterator();
        while (it.hasNext()) {
            T t5 = (T) it.next();
            if (t5.getClass().equals(cls)) {
                return t5;
            }
        }
        return null;
    }

    public boolean p() {
        return this.f1208a.isEmpty();
    }

    public Activity q() {
        if (this.f1208a.size() < 2) {
            return null;
        }
        return this.f1208a.get(r0.size() - 1);
    }

    public Activity r() {
        if (this.f1208a.size() < 2) {
            return null;
        }
        Stack<Activity> stack = this.f1208a;
        return stack.get(stack.size() - 2);
    }

    public void s(Activity activity) {
        if (activity != null) {
            this.f1208a.remove(activity);
        }
    }

    public void t(Fragment fragment) {
        List<Fragment> list = this.f1209b;
        if (list != null) {
            try {
                list.remove(fragment);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    private a() {
    }

    public void a(Context context) {
        try {
            j();
        } catch (Exception unused) {
        }
    }

    public void b(Context context, Intent intent) {
        try {
            context.stopService(intent);
            j();
        } catch (Exception unused) {
        }
    }

    public void f(Context context) {
    }
}
