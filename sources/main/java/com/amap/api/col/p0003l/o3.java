package com.amap.api.col.p0003l;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class o3 extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean[] f6828a;

    /* renamed from: b, reason: collision with root package name */
    private int f6829b = -1;

    /* renamed from: c, reason: collision with root package name */
    private List<OfflineMapProvince> f6830c;

    /* renamed from: d, reason: collision with root package name */
    private OfflineMapManager f6831d;

    /* renamed from: e, reason: collision with root package name */
    private Context f6832e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        public s3 f6833a;

        public a() {
        }
    }

    public final void a() {
        this.f6829b = -1;
        notifyDataSetChanged();
    }

    public final void c() {
        this.f6829b = 0;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i6, int i7) {
        return null;
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
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i6, int i7) {
        return true;
    }

    private boolean b(int i6) {
        return (i6 == 0 || i6 == getGroupCount() - 1) ? false : true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i6, int i7, boolean z5, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            s3 s3Var = new s3(this.f6832e, this.f6831d);
            s3Var.b(1);
            View a6 = s3Var.a();
            aVar.f6833a = s3Var;
            a6.setTag(aVar);
            view = a6;
        }
        aVar.f6833a.e(this.f6830c.get(i6).getCityList().get(i7));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i6) {
        return this.f6830c.get(i6).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        int i6 = this.f6829b;
        return i6 == -1 ? this.f6830c.size() : i6;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i6, boolean z5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) x3.d(this.f6832e, 2130903043);
        }
        TextView textView = (TextView) view.findViewById(2131165201);
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        textView.setText(this.f6830c.get(i6).getProvinceName());
        if (this.f6828a[i6]) {
            imageView.setImageDrawable(x3.b().getDrawable(2130837509));
            return view;
        }
        imageView.setImageDrawable(x3.b().getDrawable(2130837510));
        return view;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i6) {
        this.f6828a[i6] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i6) {
        this.f6828a[i6] = true;
    }

    public o3(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.f6830c = list;
        this.f6831d = offlineMapManager;
        this.f6832e = context;
        this.f6828a = new boolean[list.size()];
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i6) {
        if (b(i6)) {
            return this.f6830c.get(i6).getCityList().size();
        }
        return this.f6830c.get(i6).getCityList().size();
    }
}
