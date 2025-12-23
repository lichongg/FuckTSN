package com.amap.api.col.p0003l;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class p3 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<OfflineMapCity> f6886a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private OfflineMapManager f6887b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f6888c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6889a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OfflineMapCity f6890b;

        a(b bVar, OfflineMapCity offlineMapCity) {
            this.f6889a = bVar;
            this.f6890b = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f6889a.f6895d.setVisibility(8);
            this.f6889a.f6894c.setVisibility(0);
            this.f6889a.f6894c.setText("下载中");
            try {
                p3.this.f6887b.downloadByCityName(this.f6890b.getCity());
            } catch (AMapException e6) {
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f6892a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f6893b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f6894c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f6895d;

        public b() {
        }
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i6) {
        return i6;
    }

    public final void b(List<OfflineMapCity> list) {
        this.f6886a = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f6886a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i6) {
        return this.f6886a.get(i6);
    }

    @Override // android.widget.Adapter
    public final View getView(int i6, View view, ViewGroup viewGroup) {
        b bVar;
        try {
            OfflineMapCity offlineMapCity = this.f6886a.get(i6);
            if (view == null) {
                bVar = new b();
                view = x3.d(this.f6888c, 2130903042);
                bVar.f6892a = (TextView) view.findViewById(2131165195);
                bVar.f6893b = (TextView) view.findViewById(2131165199);
                bVar.f6894c = (TextView) view.findViewById(2131165197);
                bVar.f6895d = (ImageView) view.findViewById(2131165198);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f6895d.setOnClickListener(new a(bVar, offlineMapCity));
            bVar.f6894c.setVisibility(0);
            bVar.f6892a.setText(offlineMapCity.getCity());
            TextView textView = bVar.f6893b;
            textView.setText(String.valueOf(((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d) + " M");
            int state = offlineMapCity.getState();
            if (state != -1) {
                if (state == 0 || state == 1) {
                    bVar.f6895d.setVisibility(8);
                    bVar.f6894c.setText("下载中");
                    return view;
                }
                if (state == 2) {
                    bVar.f6895d.setVisibility(8);
                    bVar.f6894c.setText("等待下载");
                    return view;
                }
                if (state == 3) {
                    bVar.f6895d.setVisibility(8);
                    bVar.f6894c.setText("暂停中");
                    return view;
                }
                if (state == 4) {
                    bVar.f6895d.setVisibility(8);
                    bVar.f6894c.setText("已下载");
                    return view;
                }
                if (state != 6) {
                    switch (state) {
                    }
                    return view;
                }
                bVar.f6895d.setVisibility(0);
                bVar.f6894c.setVisibility(8);
                return view;
            }
            bVar.f6895d.setVisibility(8);
            bVar.f6894c.setText("下载失败");
            return view;
        } catch (Exception e6) {
            e6.printStackTrace();
            return view;
        }
    }

    public p3(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.f6887b = offlineMapManager;
        this.f6888c = offlineMapActivity;
    }
}
