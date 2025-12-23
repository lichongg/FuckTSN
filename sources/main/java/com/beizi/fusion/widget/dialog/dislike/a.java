package com.beizi.fusion.widget.dialog.dislike;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beizi.fusion.R;
import com.beizi.fusion.tool.am;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends Dialog {

    /* renamed from: b, reason: collision with root package name */
    private static h f14016b;

    /* renamed from: a, reason: collision with root package name */
    private List<b> f14017a;

    /* renamed from: c, reason: collision with root package name */
    private int f14018c;

    /* renamed from: d, reason: collision with root package name */
    private int f14019d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$a, reason: collision with other inner class name */
    public static class C0139a {

        /* renamed from: a, reason: collision with root package name */
        private RecyclerView f14020a;

        /* renamed from: b, reason: collision with root package name */
        private View f14021b;

        /* renamed from: c, reason: collision with root package name */
        private a f14022c;

        /* renamed from: d, reason: collision with root package name */
        private c f14023d;

        public C0139a a(c cVar) {
            this.f14023d = cVar;
            return this;
        }

        public C0139a(Context context) {
            this.f14022c = new a(context, R.style.beizi_custom_dialog);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.beizi_dislike_dialog, (ViewGroup) null, false);
            this.f14021b = inflate;
            this.f14022c.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.f14020a = (RecyclerView) this.f14021b.findViewById(R.id.beizi_dislike_reasons_list_recycleview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.f14020a.setLayoutManager(linearLayoutManager);
            a.f14016b.a(new e() { // from class: com.beizi.fusion.widget.dialog.dislike.a.a.1
                @Override // com.beizi.fusion.widget.dialog.dislike.a.e
                public void a(View view, int i6) {
                    if (C0139a.this.f14022c != null) {
                        C0139a.this.f14022c.dismiss();
                    }
                    if (C0139a.this.f14023d != null) {
                        C0139a.this.f14023d.a();
                    }
                }
            });
            this.f14020a.setAdapter(a.f14016b);
            WindowManager.LayoutParams attributes = this.f14022c.getWindow().getAttributes();
            this.f14022c.getWindow().getWindowManager().getDefaultDisplay().getSize(new Point());
            attributes.width = (int) (r0.x * 0.85d);
            attributes.gravity = 17;
            this.f14022c.getWindow().setAttributes(attributes);
        }

        public a a() {
            this.f14022c.setContentView(this.f14021b);
            this.f14022c.setCancelable(true);
            this.f14022c.setCanceledOnTouchOutside(true);
            return this.f14022c;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b {

        /* renamed from: a, reason: collision with root package name */
        int f14025a;

        /* renamed from: b, reason: collision with root package name */
        String f14026b;

        /* renamed from: c, reason: collision with root package name */
        List<d> f14027c;

        public List<d> a() {
            return this.f14027c;
        }

        b() {
        }

        public void a(List<d> list) {
            this.f14027c = list;
        }

        public String b() {
            return this.f14026b;
        }

        public void a(int i6) {
            this.f14025a = i6;
        }

        public void a(String str) {
            this.f14026b = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d {

        /* renamed from: a, reason: collision with root package name */
        String f14029a;

        public String a() {
            return this.f14029a;
        }

        d() {
        }

        public void a(String str) {
            this.f14029a = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e {
        void a(View view, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface f {
        void a(View view, int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g extends RecyclerView.Adapter {

        /* renamed from: b, reason: collision with root package name */
        private List<d> f14032b;

        /* renamed from: c, reason: collision with root package name */
        private Context f14033c;

        /* renamed from: d, reason: collision with root package name */
        private f f14034d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$g$a, reason: collision with other inner class name */
        class C0140a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            TextView f14037a;

            public C0140a(View view) {
                super(view);
                this.f14037a = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_two_recycleview_item);
            }
        }

        public g(Context context, List<d> list) {
            this.f14033c = context;
            this.f14032b = list;
        }

        public void a(f fVar) {
            this.f14034d = fVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f14032b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @SuppressLint({"RecyclerView"}) final int i6) {
            C0140a c0140a = (C0140a) viewHolder;
            c0140a.f14037a.setText(this.f14032b.get(i6).a());
            am.a(c0140a.itemView, "#FFFAF6F6", 0, "", 10);
            c0140a.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.widget.dialog.dislike.a.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.f14034d != null) {
                        g.this.f14034d.a(view, i6);
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i6) {
            return new C0140a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_two_recycle_item, viewGroup, false));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        public e f14039a;

        /* renamed from: c, reason: collision with root package name */
        private Context f14041c;

        /* renamed from: d, reason: collision with root package name */
        private List<b> f14042d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.fusion.widget.dialog.dislike.a$h$a, reason: collision with other inner class name */
        public class C0141a extends RecyclerView.ViewHolder {

            /* renamed from: b, reason: collision with root package name */
            private TextView f14048b;

            public C0141a(View view) {
                super(view);
                this.f14048b = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_one_title);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class b extends RecyclerView.ViewHolder {

            /* renamed from: b, reason: collision with root package name */
            private TextView f14050b;

            /* renamed from: c, reason: collision with root package name */
            private RecyclerView f14051c;

            public b(View view) {
                super(view);
                this.f14050b = (TextView) view.findViewById(R.id.beizi_dislike_item_multi_two_title);
                this.f14051c = (RecyclerView) view.findViewById(R.id.beizi_dislike_item_multi_two_recycleview);
            }
        }

        public h(Context context, List<b> list) {
            this.f14041c = context;
            this.f14042d = list;
        }

        public void a(e eVar) {
            this.f14039a = eVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f14042d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i6) {
            return (this.f14042d.get(i6).a() == null || this.f14042d.get(i6).a().size() <= 0) ? a.this.f14018c : a.this.f14019d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i6) {
            if (viewHolder instanceof C0141a) {
                ((C0141a) viewHolder).f14048b.setText(this.f14042d.get(i6).b());
            } else {
                b bVar = (b) viewHolder;
                bVar.f14050b.setText(this.f14042d.get(i6).b());
                bVar.f14051c.setLayoutManager(new FlowLayoutManager());
                a aVar = a.this;
                g gVar = aVar.new g(aVar.getContext(), this.f14042d.get(i6).a());
                bVar.f14051c.setAdapter(gVar);
                gVar.a(new f() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.1
                    @Override // com.beizi.fusion.widget.dialog.dislike.a.f
                    public void a(View view, int i7) {
                        e eVar = h.this.f14039a;
                        if (eVar != null) {
                            eVar.a(view, i7);
                        }
                    }
                });
                bVar.f14051c.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.2
                    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                        super.getItemOffsets(rect, view, recyclerView, state);
                        rect.bottom = 30;
                        rect.left = 60;
                    }
                });
            }
            if (this.f14039a != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.fusion.widget.dialog.dislike.a.h.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int layoutPosition = viewHolder.getLayoutPosition();
                        if (a.this.f14019d != h.this.getItemViewType(layoutPosition)) {
                            h.this.f14039a.a(viewHolder.itemView, layoutPosition);
                        }
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i6) {
            return i6 == a.this.f14018c ? new C0141a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_one, viewGroup, false)) : new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_dislike_item_multi_two, viewGroup, false));
        }
    }

    private List<b> b() {
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.a("内容无法正常展示（卡顿、黑白屏）");
        bVar.a(this.f14018c);
        arrayList.add(bVar);
        b bVar2 = new b();
        bVar2.a("不感兴趣");
        bVar2.a(this.f14018c);
        arrayList.add(bVar2);
        b bVar3 = new b();
        bVar3.a("无法关闭");
        bVar3.a(this.f14018c);
        arrayList.add(bVar3);
        ArrayList arrayList2 = new ArrayList();
        d dVar = new d();
        dVar.a("疑似抄袭");
        arrayList2.add(dVar);
        d dVar2 = new d();
        dVar2.a("虚假欺诈");
        arrayList2.add(dVar2);
        d dVar3 = new d();
        dVar3.a("违法违规");
        arrayList2.add(dVar3);
        d dVar4 = new d();
        dVar4.a("低俗色情");
        arrayList2.add(dVar4);
        b bVar4 = new b();
        bVar4.a("举报广告");
        bVar4.a(arrayList2);
        bVar4.a(this.f14018c);
        arrayList.add(bVar4);
        return arrayList;
    }

    public a(@NonNull Context context, int i6) {
        super(context, i6);
        this.f14017a = null;
        this.f14018c = 1;
        this.f14019d = 2;
        List<b> b6 = b();
        this.f14017a = b6;
        f14016b = new h(context, b6);
    }
}
