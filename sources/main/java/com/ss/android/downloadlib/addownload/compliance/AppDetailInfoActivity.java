package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.gromore.R;
import com.ss.android.downloadlib.addownload.o;
import com.stub.StubApp;
import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public class AppDetailInfoActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f37626a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f37627b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f37628c;

    /* renamed from: d, reason: collision with root package name */
    private ListView f37629d;

    /* renamed from: e, reason: collision with root package name */
    private long f37630e;

    /* renamed from: f, reason: collision with root package name */
    private long f37631f;

    /* renamed from: g, reason: collision with root package name */
    private List<Pair<String, String>> f37632g;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_detail_click_close", AppDetailInfoActivity.this.f37631f);
            AppDetailInfoActivity.this.finish();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_detail_click_download", AppDetailInfoActivity.this.f37631f);
            f.a().i(AppDetailInfoActivity.this.f37631f);
            com.ss.android.socialbase.appdownloader.b.u(AppDetailInfoActivity.this);
            com.ss.android.socialbase.appdownloader.b.u(f.a().h());
        }
    }

    private class c extends BaseAdapter {
        private c() {
        }

        @Override // android.widget.Adapter
        public long getItemId(int i6) {
            return i6;
        }

        /* synthetic */ c(AppDetailInfoActivity appDetailInfoActivity, a aVar) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AppDetailInfoActivity.this.f37632g.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i6) {
            return AppDetailInfoActivity.this.f37632g.get(i6);
        }

        @Override // android.widget.Adapter
        public View getView(int i6, View view, ViewGroup viewGroup) {
            d dVar;
            if (view == null) {
                view = View.inflate(AppDetailInfoActivity.this, R.layout.ttdownloader_item_permission, null);
                dVar = new d(null);
                dVar.f37636a = (TextView) view.findViewById(R.id.tv_permission_title);
                dVar.f37637b = (TextView) view.findViewById(R.id.tv_permission_description);
                dVar.f37638c = view.findViewById(R.id.dash_line);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            dVar.f37636a.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.f37632g.get(i6)).first);
            dVar.f37637b.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.f37632g.get(i6)).second);
            if (i6 == getCount() - 1) {
                dVar.f37638c.setVisibility(8);
            }
            return view;
        }
    }

    private static class d {

        /* renamed from: a, reason: collision with root package name */
        public TextView f37636a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f37637b;

        /* renamed from: c, reason: collision with root package name */
        public View f37638c;

        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        StubApp.interface11(41138);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void b(Activity activity, long j6) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j6);
        activity.startActivity(intent);
    }

    private void e() {
        this.f37626a = (ImageView) findViewById(R.id.iv_detail_back);
        this.f37627b = (TextView) findViewById(R.id.tv_empty);
        this.f37629d = (ListView) findViewById(R.id.permission_list);
        this.f37628c = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f37632g.isEmpty()) {
            this.f37629d.setVisibility(8);
            this.f37627b.setVisibility(0);
        } else {
            this.f37629d.setAdapter((ListAdapter) new c(this, null));
        }
        this.f37626a.setOnClickListener(new a());
        this.f37628c.setOnClickListener(new b());
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.ss.android.downloadlib.addownload.compliance.a.c("lp_app_detail_click_close", this.f37631f);
        super.onBackPressed();
    }

    private boolean c() {
        this.f37630e = getIntent().getLongExtra("app_info_id", 0L);
        o.j j6 = cw.j().j(this.f37630e);
        if (j6 == null) {
            return false;
        }
        this.f37631f = j6.f37966b;
        this.f37632g = j6.f37972h;
        return true;
    }
}
