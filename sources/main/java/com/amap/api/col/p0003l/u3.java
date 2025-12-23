package com.amap.api.col.p0003l;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.amps.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class u3 extends com.amap.api.offlineservice.a implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {

    /* renamed from: b, reason: collision with root package name */
    private ImageView f7332b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f7333c;

    /* renamed from: d, reason: collision with root package name */
    private DownLoadExpandListView f7334d;

    /* renamed from: e, reason: collision with root package name */
    private ListView f7335e;

    /* renamed from: f, reason: collision with root package name */
    private ExpandableListView f7336f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f7337g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f7338h;

    /* renamed from: i, reason: collision with root package name */
    private AutoCompleteTextView f7339i;

    /* renamed from: j, reason: collision with root package name */
    private RelativeLayout f7340j;

    /* renamed from: k, reason: collision with root package name */
    private RelativeLayout f7341k;

    /* renamed from: l, reason: collision with root package name */
    private ImageView f7342l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f7343m;

    /* renamed from: n, reason: collision with root package name */
    private RelativeLayout f7344n;

    /* renamed from: p, reason: collision with root package name */
    private o3 f7346p;

    /* renamed from: r, reason: collision with root package name */
    private n3 f7348r;

    /* renamed from: s, reason: collision with root package name */
    private p3 f7349s;

    /* renamed from: x, reason: collision with root package name */
    private q3 f7354x;

    /* renamed from: o, reason: collision with root package name */
    private List<OfflineMapProvince> f7345o = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    private OfflineMapManager f7347q = null;

    /* renamed from: t, reason: collision with root package name */
    private boolean f7350t = true;

    /* renamed from: u, reason: collision with root package name */
    private boolean f7351u = true;

    /* renamed from: v, reason: collision with root package name */
    private int f7352v = -1;

    /* renamed from: w, reason: collision with root package name */
    private long f7353w = 0;

    /* renamed from: y, reason: collision with root package name */
    private boolean f7355y = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                u3.this.f7339i.setText("");
                u3.this.f7342l.setVisibility(8);
                u3.this.k(false);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) u3.this.f7343m.getLayoutParams();
                layoutParams.leftMargin = u3.this.a(95.0f);
                u3.this.f7343m.setLayoutParams(layoutParams);
                u3.this.f7339i.setPadding(u3.this.a(105.0f), 0, 0, 0);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class b implements Comparator<OfflineMapCity> {
        b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            return a(offlineMapCity, offlineMapCity2);
        }

        private static int a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            char[] charArray = offlineMapCity.getJianpin().toCharArray();
            char[] charArray2 = offlineMapCity2.getJianpin().toCharArray();
            if (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) {
                return 0;
            }
            return 1;
        }
    }

    public final void k(boolean z5) {
        if (z5) {
            this.f7340j.setVisibility(8);
            this.f7341k.setVisibility(8);
            this.f7334d.setVisibility(8);
            this.f7336f.setVisibility(8);
            this.f7344n.setVisibility(8);
            this.f7335e.setVisibility(0);
            return;
        }
        this.f7340j.setVisibility(0);
        this.f7341k.setVisibility(0);
        this.f7344n.setVisibility(0);
        this.f7334d.setVisibility(this.f7351u ? 0 : 8);
        this.f7336f.setVisibility(this.f7350t ? 0 : 8);
        this.f7335e.setVisibility(8);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i6) {
        if (i6 == 2) {
            this.f7355y = false;
        } else {
            this.f7355y = true;
        }
    }

    private void n() {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f7343m.getLayoutParams();
            layoutParams.leftMargin = a(18.0f);
            this.f7343m.setLayoutParams(layoutParams);
            this.f7339i.setPadding(a(30.0f), 0, 0, 0);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void p() {
        n3 n3Var = new n3(this.f9090a, this, this.f7347q, this.f7345o);
        this.f7348r = n3Var;
        this.f7334d.setAdapter(n3Var);
        this.f7348r.notifyDataSetChanged();
    }

    private void q() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.f7347q.getOfflineMapProvinceList();
        this.f7345o.clear();
        this.f7345o.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        for (int i6 = 0; i6 < offlineMapProvinceList.size(); i6++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i6);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.f7345o.add(i6 + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.f7345o.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName("直辖市");
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName("港澳");
        offlineMapProvince4.setCityList(arrayList2);
        this.f7345o.add(offlineMapProvince4);
    }

    private void r() {
        AutoCompleteTextView autoCompleteTextView = this.f7339i;
        if (autoCompleteTextView == null || !autoCompleteTextView.isFocused()) {
            return;
        }
        this.f7339i.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f9090a.getSystemService("input_method");
        if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
            inputMethodManager.hideSoftInputFromWindow(this.f7339i.getWindowToken(), 2);
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final void e() {
        View d6 = x3.d(this.f9090a, R.array.complain_list);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) d6.findViewById(2131165187);
        this.f7334d = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.f7340j = (RelativeLayout) d6.findViewById(2131165184);
        this.f7337g = (ImageView) d6.findViewById(2131165186);
        this.f7340j.setOnClickListener(this.f9090a);
        this.f7341k = (RelativeLayout) d6.findViewById(2131165189);
        this.f7338h = (ImageView) d6.findViewById(2131165190);
        this.f7341k.setOnClickListener(this.f9090a);
        this.f7344n = (RelativeLayout) d6.findViewById(2131165188);
        ImageView imageView = (ImageView) this.f7333c.findViewById(2131165205);
        this.f7332b = imageView;
        imageView.setOnClickListener(this.f9090a);
        this.f7343m = (ImageView) this.f7333c.findViewById(2131165207);
        ImageView imageView2 = (ImageView) this.f7333c.findViewById(2131165209);
        this.f7342l = imageView2;
        imageView2.setOnClickListener(new a());
        this.f7333c.findViewById(2131165210).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f7333c.findViewById(2131165208);
        this.f7339i = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.f7339i.setOnTouchListener(this);
        this.f7335e = (ListView) this.f7333c.findViewById(2131165212);
        ExpandableListView expandableListView = (ExpandableListView) this.f7333c.findViewById(2131165211);
        this.f7336f = expandableListView;
        expandableListView.addHeaderView(d6);
        this.f7336f.setOnTouchListener(this);
        this.f7336f.setOnScrollListener(this);
        try {
            OfflineMapManager offlineMapManager = new OfflineMapManager(this.f9090a, this);
            this.f7347q = offlineMapManager;
            offlineMapManager.setOnOfflineLoadedListener(this);
        } catch (Exception e6) {
            "e=".concat(String.valueOf(e6));
        }
        q();
        o3 o3Var = new o3(this.f7345o, this.f7347q, this.f9090a);
        this.f7346p = o3Var;
        this.f7336f.setAdapter(o3Var);
        this.f7336f.setOnGroupCollapseListener(this.f7346p);
        this.f7336f.setOnGroupExpandListener(this.f7346p);
        this.f7336f.setGroupIndicator(null);
        if (this.f7350t) {
            this.f7338h.setBackgroundResource(2130837504);
            this.f7336f.setVisibility(0);
        } else {
            this.f7338h.setBackgroundResource(2130837508);
            this.f7336f.setVisibility(8);
        }
        if (this.f7351u) {
            this.f7337g.setBackgroundResource(2130837504);
            this.f7334d.setVisibility(0);
        } else {
            this.f7337g.setBackgroundResource(2130837508);
            this.f7334d.setVisibility(8);
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final boolean f() {
        try {
            if (this.f7335e.getVisibility() == 0) {
                this.f7339i.setText("");
                this.f7342l.setVisibility(8);
                k(false);
                return false;
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        return super.f();
    }

    @Override // com.amap.api.offlineservice.a
    public final RelativeLayout g() {
        if (this.f7333c == null) {
            this.f7333c = (RelativeLayout) x3.d(this.f9090a, 2130903044);
        }
        return this.f7333c;
    }

    @Override // com.amap.api.offlineservice.a
    public final void h() {
        this.f7347q.destroy();
    }

    public final void j(OfflineMapCity offlineMapCity) {
        try {
            if (this.f7354x == null) {
                this.f7354x = new q3(this.f9090a, this.f7347q);
            }
            this.f7354x.c(offlineMapCity.getState(), offlineMapCity.getCity());
            this.f7354x.show();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onDownload(int i6, int i7, String str) {
        if (i6 == 101) {
            try {
                Toast.makeText(this.f9090a, "网络异常", 0).show();
                this.f7347q.pause();
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        if (i6 == 2) {
            this.f7348r.b();
        }
        if (this.f7352v == i6) {
            if (System.currentTimeMillis() - this.f7353w > 1200) {
                if (this.f7355y) {
                    this.f7348r.notifyDataSetChanged();
                }
                this.f7353w = System.currentTimeMillis();
                return;
            }
            return;
        }
        o3 o3Var = this.f7346p;
        if (o3Var != null) {
            o3Var.notifyDataSetChanged();
        }
        n3 n3Var = this.f7348r;
        if (n3Var != null) {
            n3Var.notifyDataSetChanged();
        }
        p3 p3Var = this.f7349s;
        if (p3Var != null) {
            p3Var.notifyDataSetChanged();
        }
        this.f7352v = i6;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onRemove(boolean z5, String str, String str2) {
        n3 n3Var = this.f7348r;
        if (n3Var != null) {
            n3Var.c();
        }
    }

    private void o() {
        q();
        p3 p3Var = new p3(this.f7347q, this.f9090a);
        this.f7349s = p3Var;
        this.f7335e.setAdapter((ListAdapter) p3Var);
    }

    @Override // com.amap.api.offlineservice.a
    public final void c(View view) {
        try {
            int id = view.getId();
            if (id == 2131165205) {
                this.f9090a.closeScr();
                return;
            }
            if (id == 2131165184) {
                if (this.f7351u) {
                    this.f7334d.setVisibility(8);
                    this.f7337g.setBackgroundResource(2130837508);
                    this.f7351u = false;
                    return;
                } else {
                    this.f7334d.setVisibility(0);
                    this.f7337g.setBackgroundResource(2130837504);
                    this.f7351u = true;
                    return;
                }
            }
            if (id == 2131165189) {
                if (this.f7350t) {
                    this.f7346p.c();
                    this.f7338h.setBackgroundResource(2130837508);
                    this.f7350t = false;
                } else {
                    this.f7346p.a();
                    this.f7338h.setBackgroundResource(2130837504);
                    this.f7350t = true;
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        if (TextUtils.isEmpty(charSequence)) {
            k(false);
            this.f7342l.setVisibility(8);
            return;
        }
        this.f7342l.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.f7345o;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            Iterator<OfflineMapProvince> it = this.f7345o.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(it.next().getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() > 0) {
            k(true);
            Collections.sort(arrayList, new b());
            p3 p3Var = this.f7349s;
            if (p3Var != null) {
                p3Var.b(arrayList);
                this.f7349s.notifyDataSetChanged();
                return;
            }
            return;
        }
        Toast.makeText(this.f9090a, "未找到相关城市", 0).show();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        r();
        if (view.getId() == 2131165208) {
            n();
            return false;
        }
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public final void onVerifyComplete() {
        o();
        p();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onCheckUpdate(boolean z5, String str) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i6, int i7, int i8) {
    }
}
