package com.amap.api.col.p0003l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class n3 extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean[] f6792a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6793b;

    /* renamed from: c, reason: collision with root package name */
    private s3 f6794c;

    /* renamed from: d, reason: collision with root package name */
    private List<OfflineMapProvince> f6795d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    List<OfflineMapProvince> f6796e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private u3 f6797f;

    /* renamed from: g, reason: collision with root package name */
    private OfflineMapManager f6798g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OfflineMapCity f6799a;

        a(OfflineMapCity offlineMapCity) {
            this.f6799a = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            n3.this.f6797f.j(this.f6799a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public s3 f6801a;

        public b() {
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i6, int i7) {
        return i7;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i6) {
        return i6;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i6, int i7) {
        return true;
    }

    public final void b() {
        for (OfflineMapProvince offlineMapProvince : this.f6795d) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.f6796e.contains(offlineMapProvince)) {
                this.f6796e.add(offlineMapProvince);
            }
        }
        this.f6792a = new boolean[this.f6796e.size()];
        notifyDataSetChanged();
    }

    public final void c() {
        try {
            for (int size = this.f6796e.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.f6796e.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.f6796e.remove(offlineMapProvince);
                }
            }
            this.f6792a = new boolean[this.f6796e.size()];
            notifyDataSetChanged();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i6, int i7) {
        return this.f6796e.get(i6).getDownloadedCityList().get(i7);
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i6, int i7, boolean z5, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b();
            s3 s3Var = new s3(this.f6793b, this.f6798g);
            this.f6794c = s3Var;
            s3Var.b(2);
            view = this.f6794c.a();
            bVar.f6801a = this.f6794c;
            view.setTag(bVar);
        }
        OfflineMapProvince offlineMapProvince = this.f6796e.get(i6);
        if (i7 < offlineMapProvince.getDownloadedCityList().size()) {
            OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i7);
            bVar.f6801a.e(offlineMapCity);
            view.setOnClickListener(new a(offlineMapCity));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i6) {
        return this.f6796e.get(i6).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i6) {
        return this.f6796e.get(i6).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.f6796e.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i6, boolean z5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) x3.d(this.f6793b, 2130903043);
        }
        TextView textView = (TextView) view.findViewById(2131165201);
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        textView.setText(this.f6796e.get(i6).getProvinceName());
        if (this.f6792a[i6]) {
            imageView.setImageDrawable(x3.b().getDrawable(2130837509));
            return view;
        }
        imageView.setImageDrawable(x3.b().getDrawable(2130837510));
        return view;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i6) {
        this.f6792a[i6] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i6) {
        this.f6792a[i6] = true;
    }

    public n3(Context context, u3 u3Var, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.f6793b = context;
        this.f6797f = u3Var;
        this.f6798g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.f6795d.clear();
            this.f6795d.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.f6795d) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.f6796e.add(offlineMapProvince);
                }
            }
        }
        this.f6792a = new boolean[this.f6796e.size()];
    }
}
