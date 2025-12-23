package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bxkj.base.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class CycleViewPager extends FrameLayout implements ViewPager.OnPageChangeListener {
    private static final String B = "CycleViewPager";
    private int A;

    /* renamed from: a, reason: collision with root package name */
    private Context f16962a;

    /* renamed from: b, reason: collision with root package name */
    private ViewPager f16963b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f16964c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f16965d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f16966e;

    /* renamed from: f, reason: collision with root package name */
    private int f16967f;

    /* renamed from: g, reason: collision with root package name */
    private int f16968g;

    /* renamed from: h, reason: collision with root package name */
    private List<View> f16969h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView[] f16970i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16971j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f16972k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f16973l;

    /* renamed from: m, reason: collision with root package name */
    private int f16974m;

    /* renamed from: n, reason: collision with root package name */
    private int f16975n;

    /* renamed from: o, reason: collision with root package name */
    private long f16976o;

    /* renamed from: p, reason: collision with root package name */
    private e f16977p;

    /* renamed from: q, reason: collision with root package name */
    private c f16978q;

    /* renamed from: r, reason: collision with root package name */
    private d f16979r;

    /* renamed from: s, reason: collision with root package name */
    private List<String> f16980s;

    /* renamed from: t, reason: collision with root package name */
    private List<Integer> f16981t;

    /* renamed from: u, reason: collision with root package name */
    private int f16982u;

    /* renamed from: v, reason: collision with root package name */
    private int f16983v;

    /* renamed from: w, reason: collision with root package name */
    final Runnable f16984w;

    /* renamed from: x, reason: collision with root package name */
    private int f16985x;

    /* renamed from: y, reason: collision with root package name */
    private int f16986y;

    /* renamed from: z, reason: collision with root package name */
    private View f16987z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CycleViewPager.this.f16962a == null || !CycleViewPager.this.f16973l) {
                return;
            }
            if (System.currentTimeMillis() - CycleViewPager.this.f16976o > CycleViewPager.this.f16974m - 500) {
                CycleViewPager.this.f16966e.sendEmptyMessage(CycleViewPager.this.f16967f);
            } else {
                CycleViewPager.this.f16966e.sendEmptyMessage(CycleViewPager.this.f16968g);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == CycleViewPager.this.f16967f && CycleViewPager.this.f16969h.size() > 0) {
                if (!CycleViewPager.this.f16971j) {
                    CycleViewPager.this.f16963b.setCurrentItem((CycleViewPager.this.f16975n + 1) % CycleViewPager.this.f16969h.size(), true);
                }
                CycleViewPager.this.f16976o = System.currentTimeMillis();
                CycleViewPager.this.f16966e.removeCallbacks(CycleViewPager.this.f16984w);
                CycleViewPager.this.f16966e.postDelayed(CycleViewPager.this.f16984w, r0.f16974m);
                return;
            }
            if (message.what == CycleViewPager.this.f16968g && CycleViewPager.this.f16969h.size() > 0) {
                CycleViewPager.this.f16966e.removeCallbacks(CycleViewPager.this.f16984w);
                CycleViewPager.this.f16966e.postDelayed(CycleViewPager.this.f16984w, r0.f16974m);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void onImageClick(String str, int i6, View view);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void onItemSelect(int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class e extends PagerAdapter {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CycleViewPager.this.f16978q.onImageClick((String) CycleViewPager.this.f16980s.get(CycleViewPager.this.f16975n - 1), CycleViewPager.this.f16975n - 1, view);
            }
        }

        /* synthetic */ e(CycleViewPager cycleViewPager, com.bxkj.base.v2.common.view.a aVar) {
            this();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        private e() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i6, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CycleViewPager.this.f16969h.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup viewGroup, int i6) {
            View view = (View) CycleViewPager.this.f16969h.get(i6);
            if (CycleViewPager.this.f16978q != null) {
                view.setOnClickListener(new a());
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public CycleViewPager(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i6) {
        if (i6 == 1) {
            this.f16971j = true;
            return;
        }
        if (i6 == 0) {
            this.f16976o = System.currentTimeMillis();
            this.f16963b.setCurrentItem(this.f16975n, false);
        }
        this.f16971j = false;
    }

    public void w(List<String> list, c cVar) {
        x(list, cVar, 0);
    }

    public void y(List<Integer> list, c cVar) {
        z(list, cVar, 0);
    }

    public CycleViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static void C(TextView textView, int i6) {
        if (textView != null) {
            D(textView, i6 + "");
        }
    }

    public static void D(TextView textView, String str) {
        if (str == null || textView == null) {
            return;
        }
        textView.setText(str);
    }

    private View q(Context context, int i6) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        com.bumptech.glide.b.D(context).p(Integer.valueOf(i6)).m1(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    private View r(Context context, String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        try {
            com.bumptech.glide.b.D(context).p(Integer.valueOf(Integer.parseInt(str))).m1(imageView);
        } catch (NumberFormatException unused) {
            com.bumptech.glide.b.D(context).a(str).m1(imageView);
        }
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    private void s() {
        LayoutInflater.from(this.f16962a).inflate(R.layout.pub_layout_cycle_view, (ViewGroup) this, true);
        this.f16963b = (ViewPager) findViewById(R.id.cycle_view_pager);
        this.f16964c = (TextView) findViewById(R.id.cycle_title);
        this.f16965d = (LinearLayout) findViewById(R.id.cycle_indicator);
        this.f16966e = new b();
    }

    private void setIndicator(int i6) {
        ImageView[] imageViewArr;
        d dVar = this.f16979r;
        if (dVar != null) {
            dVar.onItemSelect(i6);
        }
        int i7 = 0;
        while (true) {
            try {
                imageViewArr = this.f16970i;
                if (i7 >= imageViewArr.length) {
                    break;
                }
                imageViewArr[i7].setBackgroundResource(this.f16983v);
                i7++;
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        if (imageViewArr.length > i6) {
            imageViewArr[i6].setBackgroundResource(this.f16982u);
        }
    }

    public void A(int i6, int i7) {
        this.f16985x = i6;
        this.f16986y = i7;
    }

    public void B(int i6, int i7) {
        this.f16982u = i6;
        this.f16983v = i7;
    }

    public void o(View view) {
        this.f16987z = view;
        this.f16969h.add(view);
        if (this.f16980s == null) {
            this.f16980s = new ArrayList();
        }
        if (!this.f16980s.isEmpty() && this.f16969h.size() > 1 && this.f16969h.size() > this.f16980s.size()) {
            this.f16969h.remove(r5.size() - 2);
        }
        this.f16969h.add(r(this.f16962a, this.f16980s.get(0)));
        int size = this.f16969h.size();
        this.f16970i = new ImageView[size];
        if (this.f16972k) {
            this.f16970i = new ImageView[size - 2];
        }
        this.f16965d.removeAllViews();
        int i6 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f16970i;
            if (i6 >= imageViewArr.length) {
                setIndicator(this.A);
                this.f16977p.notifyDataSetChanged();
                return;
            }
            imageViewArr[i6] = new ImageView(this.f16962a);
            this.f16970i[i6].setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f16985x, this.f16986y);
            layoutParams.setMargins(10, 0, 10, 0);
            this.f16970i[i6].setLayoutParams(layoutParams);
            this.f16965d.addView(this.f16970i[i6]);
            i6++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f16966e.removeCallbacks(this.f16984w);
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i6) {
        int size = this.f16969h.size();
        int i7 = size - 1;
        this.f16975n = i6;
        if (this.f16972k) {
            if (i6 == 0) {
                this.f16975n = size - 2;
            } else if (i6 == i7) {
                this.f16975n = 1;
            }
            i6 = this.f16975n - 1;
        }
        this.A = i6;
        setIndicator(i6);
    }

    public void p() {
        this.f16969h.remove(this.f16987z);
        int size = this.f16969h.size();
        this.f16970i = new ImageView[size];
        if (this.f16972k) {
            this.f16970i = new ImageView[size - 2];
        }
        this.f16965d.removeAllViews();
        int i6 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f16970i;
            if (i6 >= imageViewArr.length) {
                this.f16975n = 1;
                setIndicator(0);
                this.f16977p.notifyDataSetChanged();
                return;
            } else {
                imageViewArr[i6] = new ImageView(this.f16962a);
                this.f16970i[i6].setScaleType(ImageView.ScaleType.CENTER_CROP);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f16985x, this.f16986y);
                layoutParams.setMargins(10, 0, 10, 0);
                this.f16970i[i6].setLayoutParams(layoutParams);
                this.f16965d.addView(this.f16970i[i6]);
                i6++;
            }
        }
    }

    public void setCycle(boolean z5) {
        this.f16972k = z5;
    }

    public void setDelay(int i6) {
        this.f16974m = i6;
    }

    public void setImageCycleViewSelectListener(d dVar) {
        this.f16979r = dVar;
    }

    public void setWheel(boolean z5) {
        this.f16973l = z5;
        this.f16972k = true;
        if (z5) {
            this.f16966e.postDelayed(this.f16984w, this.f16974m);
        }
    }

    public boolean t() {
        return this.f16972k;
    }

    public boolean u() {
        return this.f16973l;
    }

    public void v() {
        e eVar = this.f16977p;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    public void x(List<String> list, c cVar, int i6) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        this.f16969h.clear();
        this.f16980s = list;
        if (this.f16972k) {
            this.f16969h.add(r(this.f16962a, list.get(list.size() - 1)));
            for (int i7 = 0; i7 < this.f16980s.size(); i7++) {
                this.f16969h.add(r(this.f16962a, this.f16980s.get(i7)));
            }
            this.f16969h.add(r(this.f16962a, this.f16980s.get(0)));
        } else {
            for (int i8 = 0; i8 < this.f16980s.size(); i8++) {
                this.f16969h.add(r(this.f16962a, this.f16980s.get(i8)));
            }
        }
        List<View> list2 = this.f16969h;
        if (list2 == null || list2.size() == 0) {
            setVisibility(8);
            return;
        }
        this.f16978q = cVar;
        int size = this.f16969h.size();
        this.f16970i = new ImageView[size];
        if (this.f16972k) {
            this.f16970i = new ImageView[size - 2];
        }
        this.f16965d.removeAllViews();
        int i9 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f16970i;
            if (i9 >= imageViewArr.length) {
                break;
            }
            imageViewArr[i9] = new ImageView(this.f16962a);
            this.f16970i[i9].setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f16985x, this.f16986y);
            layoutParams.setMargins(10, 0, 10, 0);
            this.f16970i[i9].setLayoutParams(layoutParams);
            this.f16965d.addView(this.f16970i[i9]);
            i9++;
        }
        this.f16977p = new e(this, null);
        setIndicator(0);
        this.f16963b.setOffscreenPageLimit(3);
        this.f16963b.setOnPageChangeListener(this);
        this.f16963b.setAdapter(this.f16977p);
        if (i6 < 0 || i6 >= this.f16969h.size()) {
            i6 = 0;
        }
        if (this.f16972k) {
            i6++;
        }
        this.f16963b.setCurrentItem(i6);
        setWheel(u());
    }

    public void z(List<Integer> list, c cVar, int i6) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        this.f16969h.clear();
        this.f16981t = list;
        if (this.f16972k) {
            this.f16969h.add(r(this.f16962a, this.f16980s.get(r3.size() - 1)));
            for (int i7 = 0; i7 < this.f16980s.size(); i7++) {
                this.f16969h.add(r(this.f16962a, this.f16980s.get(i7)));
            }
            this.f16969h.add(r(this.f16962a, this.f16980s.get(0)));
        } else {
            for (int i8 = 0; i8 < this.f16980s.size(); i8++) {
                this.f16969h.add(r(this.f16962a, this.f16980s.get(i8)));
            }
        }
        List<View> list2 = this.f16969h;
        if (list2 == null || list2.size() == 0) {
            setVisibility(8);
            return;
        }
        this.f16978q = cVar;
        int size = this.f16969h.size();
        this.f16970i = new ImageView[size];
        if (this.f16972k) {
            this.f16970i = new ImageView[size - 2];
        }
        this.f16965d.removeAllViews();
        int i9 = 0;
        while (true) {
            ImageView[] imageViewArr = this.f16970i;
            if (i9 >= imageViewArr.length) {
                break;
            }
            imageViewArr[i9] = new ImageView(this.f16962a);
            this.f16970i[i9].setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f16985x, this.f16986y);
            layoutParams.setMargins(10, 0, 10, 0);
            this.f16970i[i9].setLayoutParams(layoutParams);
            this.f16965d.addView(this.f16970i[i9]);
            i9++;
        }
        this.f16977p = new e(this, null);
        setIndicator(0);
        this.f16963b.setOffscreenPageLimit(3);
        this.f16963b.setOnPageChangeListener(this);
        this.f16963b.setAdapter(this.f16977p);
        if (i6 < 0 || i6 >= this.f16969h.size()) {
            i6 = 0;
        }
        if (this.f16972k) {
            i6++;
        }
        this.f16963b.setCurrentItem(i6);
        setWheel(u());
    }

    public CycleViewPager(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f16967f = 100;
        this.f16968g = 101;
        this.f16969h = new ArrayList();
        this.f16971j = false;
        this.f16972k = true;
        this.f16973l = true;
        this.f16974m = 5000;
        this.f16975n = 0;
        this.f16976o = 0L;
        this.f16984w = new a();
        this.f16985x = -2;
        this.f16986y = -2;
        this.f16987z = null;
        this.A = 0;
        this.f16962a = context;
        s();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i6, float f6, int i7) {
    }
}
