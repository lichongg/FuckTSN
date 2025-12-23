package cn.bluemobi.dylan.base.adapter;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private List<Fragment> f1101a;

    /* renamed from: b, reason: collision with root package name */
    private RadioGroup f1102b;

    /* renamed from: c, reason: collision with root package name */
    private FragmentManager f1103c;

    /* renamed from: d, reason: collision with root package name */
    private int f1104d;

    /* renamed from: e, reason: collision with root package name */
    private int f1105e;

    /* renamed from: f, reason: collision with root package name */
    private C0014a f1106f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1107g;

    public a(FragmentManager fragmentManager, List<Fragment> list, int i6, RadioGroup radioGroup) {
        this(fragmentManager, list, i6, radioGroup, 0);
    }

    public void g(int i6) {
        for (int i7 = 0; i7 < this.f1101a.size(); i7++) {
            Fragment fragment = this.f1101a.get(i7);
            FragmentTransaction d6 = d(i6);
            if (i6 == i7) {
                d6.show(fragment);
            } else {
                d6.hide(fragment);
            }
            d6.commitAllowingStateLoss();
        }
        this.f1105e = i6;
    }

    public a(FragmentManager fragmentManager, List<Fragment> list, int i6, RadioGroup radioGroup, int i7) {
        this.f1107g = true;
        this.f1101a = list;
        this.f1102b = radioGroup;
        this.f1103c = fragmentManager;
        this.f1104d = i6;
        this.f1105e = i6;
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(i6, list.get(i7), String.valueOf(i7));
        beginTransaction.commitAllowingStateLoss();
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(this);
        }
    }

    private FragmentTransaction d(int i6) {
        return this.f1103c.beginTransaction();
    }

    public Fragment a() {
        return this.f1101a.get(this.f1105e);
    }

    public int b() {
        return this.f1105e;
    }

    public C0014a c() {
        return this.f1106f;
    }

    public void e(boolean z5) {
        this.f1107g = z5;
    }

    public void f(C0014a c0014a) {
        this.f1106f = c0014a;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i6) {
        if (!this.f1107g) {
            ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
            C0014a c0014a = this.f1106f;
            if (c0014a != null) {
                c0014a.b();
                return;
            }
            return;
        }
        for (int i7 = 0; i7 < this.f1102b.getChildCount(); i7++) {
            try {
                if (this.f1102b.getChildAt(i7).getId() == i6) {
                    Fragment fragment = this.f1101a.get(i7);
                    FragmentTransaction d6 = d(i7);
                    if (fragment.isAdded()) {
                        this.f1105e = i7;
                        if (!fragment.isResumed()) {
                            fragment.onResume();
                        }
                    } else {
                        d6.add(this.f1104d, fragment, String.valueOf(this.f1105e));
                    }
                    g(i7);
                    d6.commitAllowingStateLoss();
                    C0014a c0014a2 = this.f1106f;
                    if (c0014a2 != null) {
                        c0014a2.a(radioGroup, i6, i7);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: cn.bluemobi.dylan.base.adapter.a$a, reason: collision with other inner class name */
    public static class C0014a {
        public void b() {
        }

        public void a(RadioGroup radioGroup, int i6, int i7) {
        }
    }
}
