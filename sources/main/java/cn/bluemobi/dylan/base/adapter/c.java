package cn.bluemobi.dylan.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.R;
import com.bumptech.glide.Priority;
import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f1115a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1116b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f1117c;

    /* renamed from: d, reason: collision with root package name */
    private int f1118d;

    /* renamed from: e, reason: collision with root package name */
    private int f1119e = R.drawable.image_add;

    /* renamed from: f, reason: collision with root package name */
    private int f1120f = 9;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f1121a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f1122b;

        a(File file, int i6) {
            this.f1121a = file;
            this.f1122b = i6;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f1121a.exists()) {
                this.f1121a.delete();
            }
            c.this.f1115a.remove(this.f1122b);
            c.this.notifyDataSetChanged();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public final ImageView f1124a;

        /* renamed from: b, reason: collision with root package name */
        public final Button f1125b;

        /* renamed from: c, reason: collision with root package name */
        public final View f1126c;

        public b(View view) {
            this.f1124a = (ImageView) view.findViewById(R.id.iv_image);
            this.f1125b = (Button) view.findViewById(R.id.bt_del);
            this.f1126c = view;
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i6) {
        return null;
    }

    @Override // android.widget.Adapter
    public View getView(int i6, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f1117c.inflate(R.layout.pub_item_grid_add_image, viewGroup, false);
            view.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1118d));
            bVar = new b(view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        List<String> list = this.f1115a;
        if (list == null || i6 >= list.size()) {
            com.bumptech.glide.b.D(this.f1116b).p(Integer.valueOf(this.f1119e)).A0(Priority.HIGH).m1(bVar.f1124a);
            bVar.f1124a.setScaleType(ImageView.ScaleType.FIT_XY);
            bVar.f1125b.setVisibility(8);
            return view;
        }
        File file = new File(this.f1115a.get(i6));
        com.bumptech.glide.b.D(this.f1116b).i(this.f1115a.get(i6).startsWith(master.flame.danmaku.danmaku.parser.b.f50154a) ? this.f1115a.get(i6) : file).A0(Priority.HIGH).m1(bVar.f1124a);
        bVar.f1125b.setVisibility(0);
        bVar.f1125b.setOnClickListener(new a(file, i6));
        return view;
    }

    public int b() {
        return this.f1120f;
    }

    public void c(List<String> list) {
        this.f1115a = list;
        notifyDataSetChanged();
    }

    public c d(int i6) {
        this.f1119e = i6;
        return this;
    }

    public c e(int i6) {
        this.f1120f = i6;
        return this;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<String> list = this.f1115a;
        int size = list != null ? 1 + list.size() : 1;
        return size > this.f1120f ? this.f1115a.size() : size;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i6) {
        return 0L;
    }

    public c(List<String> list, Context context, int i6, int i7) {
        this.f1115a = list;
        this.f1116b = context;
        this.f1118d = (context.getResources().getDisplayMetrics().widthPixels - (i7 * (i6 + 1))) / i6;
        this.f1117c = LayoutInflater.from(context);
    }
}
