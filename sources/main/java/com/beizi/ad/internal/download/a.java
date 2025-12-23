package com.beizi.ad.internal.download;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.ad.lance.a.j;
import com.beizi.fusion.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends BaseExpandableListAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f11761a;

    /* renamed from: b, reason: collision with root package name */
    private List<com.beizi.ad.internal.download.b> f11762b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.download.a$a, reason: collision with other inner class name */
    public class C0105a {

        /* renamed from: a, reason: collision with root package name */
        TextView f11763a;

        /* renamed from: b, reason: collision with root package name */
        BeiZiWebView f11764b;

        public C0105a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        TextView f11766a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f11767b;

        /* renamed from: c, reason: collision with root package name */
        View f11768c;

        public b() {
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i6, int i7) {
        return i7;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i6) {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i6) {
        return i6;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i6, int i7) {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i6, int i7) {
        return this.f11762b.get(i6).c();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i6, int i7, boolean z5, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f11761a).inflate(R.layout.beizi_download_dialog_expand_child_item, (ViewGroup) null);
        C0105a c0105a = new C0105a();
        c0105a.f11763a = (TextView) inflate.findViewById(R.id.beizi_addeci_content_tv);
        c0105a.f11764b = (BeiZiWebView) inflate.findViewById(R.id.beizi_addeci_content_wb);
        inflate.setTag(c0105a);
        if (com.baidu.mobads.sdk.internal.a.f10501b.equals(this.f11762b.get(i6).b())) {
            c0105a.f11763a.setVisibility(0);
            c0105a.f11764b.setVisibility(8);
            c0105a.f11763a.setText(this.f11762b.get(i6).c());
            return inflate;
        }
        if ("h5".equals(this.f11762b.get(i6).b())) {
            c0105a.f11763a.setVisibility(8);
            c0105a.f11764b.setVisibility(0);
            c0105a.f11764b.loadUrl(this.f11762b.get(i6).c(), j.a());
        }
        return inflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i6) {
        return this.f11762b.get(i6);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f11762b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i6, boolean z5, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f11761a).inflate(R.layout.beizi_download_dialog_expand_parent_item, (ViewGroup) null);
            bVar = new b();
            bVar.f11766a = (TextView) view.findViewById(R.id.beizi_addep_title_tv);
            bVar.f11767b = (ImageView) view.findViewById(R.id.beizi_addep_fold_iv);
            bVar.f11768c = view.findViewById(R.id.beizi_addep_item_divider_view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f11766a.setText(this.f11762b.get(i6).a());
        if (z5) {
            bVar.f11766a.setTextColor(Color.parseColor("#FF8E15"));
            bVar.f11767b.setBackgroundResource(R.mipmap.beizi_icon_arrow_unfold);
        } else {
            bVar.f11766a.setTextColor(Color.parseColor("#333333"));
            bVar.f11767b.setBackgroundResource(R.mipmap.beizi_icon_arrow_fold);
        }
        if (i6 == 0) {
            bVar.f11768c.setVisibility(8);
            return view;
        }
        bVar.f11768c.setVisibility(0);
        return view;
    }

    public a(Context context, List<com.beizi.ad.internal.download.b> list) {
        ArrayList arrayList = new ArrayList();
        this.f11762b = arrayList;
        this.f11761a = context;
        arrayList.clear();
        this.f11762b.addAll(list);
    }
}
