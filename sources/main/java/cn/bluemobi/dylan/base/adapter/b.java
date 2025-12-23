package cn.bluemobi.dylan.base.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.tabs.TabLayout;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b implements TabLayout.OnTabSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    private List<Fragment> f1108a;

    /* renamed from: b, reason: collision with root package name */
    private TabLayout f1109b;

    /* renamed from: c, reason: collision with root package name */
    private FragmentManager f1110c;

    /* renamed from: d, reason: collision with root package name */
    private int f1111d;

    /* renamed from: e, reason: collision with root package name */
    private int f1112e;

    /* renamed from: f, reason: collision with root package name */
    private a f1113f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1114g;

    public b(FragmentManager fragmentManager, List<Fragment> list, int i6, TabLayout tabLayout) {
        this(fragmentManager, list, i6, tabLayout, 0);
    }

    public void g(int i6) {
        for (int i7 = 0; i7 < this.f1108a.size(); i7++) {
            Fragment fragment = this.f1108a.get(i7);
            FragmentTransaction d6 = d(i6);
            if (i6 == i7) {
                d6.show(fragment);
            } else {
                d6.hide(fragment);
            }
            d6.commitAllowingStateLoss();
        }
        this.f1112e = i6;
    }

    public b(FragmentManager fragmentManager, List<Fragment> list, int i6, TabLayout tabLayout, int i7) {
        this.f1114g = true;
        this.f1108a = list;
        this.f1109b = tabLayout;
        this.f1110c = fragmentManager;
        this.f1111d = i6;
        this.f1112e = i7;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i6, list.get(i7), String.valueOf(i7));
        beginTransaction.commitAllowingStateLoss();
        if (tabLayout != null) {
            tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        }
    }

    private FragmentTransaction d(int i6) {
        return this.f1110c.beginTransaction();
    }

    public Fragment a() {
        return this.f1108a.get(this.f1112e);
    }

    public int b() {
        return this.f1112e;
    }

    public a c() {
        return this.f1113f;
    }

    public void e(boolean z5) {
        this.f1114g = z5;
    }

    public void f(a aVar) {
        this.f1113f = aVar;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (!this.f1114g) {
            a aVar = this.f1113f;
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        for (int i6 = 0; i6 < this.f1109b.getTabCount(); i6++) {
            try {
                if (this.f1109b.getTabAt(i6) == tab) {
                    Fragment fragment = this.f1108a.get(i6);
                    FragmentTransaction d6 = d(i6);
                    if (fragment.isAdded()) {
                        this.f1112e = i6;
                        if (!fragment.isResumed()) {
                            fragment.onResume();
                        }
                    } else {
                        d6.add(this.f1111d, fragment, String.valueOf(this.f1112e));
                    }
                    g(i6);
                    d6.commitAllowingStateLoss();
                    a aVar2 = this.f1113f;
                    if (aVar2 != null) {
                        aVar2.a(this.f1109b, tab, i6);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public void b() {
        }

        public void a(TabLayout tabLayout, TabLayout.Tab tab, int i6) {
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
    }
}
