package com.acse.ottn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.acse.ottn.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class d0<T> extends PagerAdapter implements ViewPager.OnPageChangeListener {

    /* renamed from: e, reason: collision with root package name */
    public static final String f4393e = "BaseViewPagerAdapter";

    /* renamed from: a, reason: collision with root package name */
    public List<T> f4394a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4395b;

    /* renamed from: c, reason: collision with root package name */
    public s f4396c;

    /* renamed from: d, reason: collision with root package name */
    public b f4397d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4398a;

        public a(int i6) {
            this.f4398a = i6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d0.this.f4396c.f();
            if (d0.this.f4397d != null) {
                d0.this.f4397d.a(this.f4398a % d0.this.a(), d0.this.f4394a.get(this.f4398a % d0.this.a()));
            }
            d0.this.f4396c.e();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b<T> {
        void a(int i6, T t5);
    }

    public d0(List<T> list) {
        new ArrayList();
        this.f4394a = list;
    }

    public abstract void a(TextView textView, int i6, T t5);

    public abstract void a(RoundRectImageView roundRectImageView, int i6, T t5);

    public void a(s sVar, d0 d0Var) {
        this.f4396c = sVar;
        sVar.setAdapter(this);
        this.f4396c.addOnPageChangeListener(this);
        List<T> list = this.f4394a;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f4396c.setCurrentItem(kotlinx.coroutines.internal.a0.f49221j - (kotlinx.coroutines.internal.a0.f49221j % a()));
        if (this.f4396c.c()) {
            return;
        }
        this.f4396c.g();
        this.f4396c.b(a());
    }

    public void b(List<T> list) {
        if (this.f4394a == null) {
            this.f4394a = new ArrayList();
        }
        this.f4394a.clear();
        this.f4394a.addAll(list);
        notifyDataSetChanged();
        if (this.f4396c.c()) {
            return;
        }
        this.f4396c.g();
        this.f4396c.b(a());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i6, Object obj) {
        viewGroup.removeView((ImageView) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<T> list = this.f4394a;
        return (list == null || list.size() == 0) ? 0 : Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i6) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) LayoutInflater.from(this.f4395b).inflate(R.layout.imageview, viewGroup, false);
        a(roundRectImageView, i6, (int) this.f4394a.get(i6 % a()));
        viewGroup.addView(roundRectImageView);
        if (this.f4396c.getSubTitle() != null) {
            if (i6 == 0) {
                a(this.f4396c.getSubTitle(), i6, (int) this.f4394a.get(a() - 1));
            } else {
                a(this.f4396c.getSubTitle(), i6, (int) this.f4394a.get((i6 - 1) % a()));
            }
        }
        roundRectImageView.setOnClickListener(new a(i6));
        return roundRectImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i6) {
        this.f4396c.a(i6 % a());
    }

    public d0(Context context) {
        this.f4394a = new ArrayList();
        this.f4395b = context;
    }

    public d0(Context context, b bVar) {
        this.f4394a = new ArrayList();
        this.f4395b = context;
        this.f4397d = bVar;
    }

    public d0(Context context, List<T> list) {
        new ArrayList();
        this.f4395b = context;
        this.f4394a = list;
    }

    public void a(b bVar) {
        this.f4397d = bVar;
    }

    public void a(T t5) {
        if (this.f4396c.getAdapter() != null) {
            if (this.f4394a == null) {
                this.f4394a = new ArrayList();
            }
            int currentItem = this.f4396c.getCurrentItem() % a();
            this.f4394a.add(t5);
            this.f4396c.f();
            c2.a(f4393e, "当前显示第" + currentItem + "/" + this.f4396c.getCurrentItem());
            this.f4396c.a(a(), currentItem);
            this.f4396c.e();
            return;
        }
        throw new RuntimeException("必须先设置Adapter");
    }

    public d0(Context context, List<T> list, b bVar) {
        new ArrayList();
        this.f4395b = context;
        this.f4394a = list;
        this.f4397d = bVar;
    }

    public void a(List<T> list) {
        if (this.f4394a == null) {
            this.f4394a = new ArrayList();
        }
        this.f4394a.addAll(list);
        notifyDataSetChanged();
        this.f4396c.g();
        this.f4396c.b(a());
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i6) {
    }

    public int a() {
        List<T> list = this.f4394a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i6, float f6, int i7) {
    }
}
