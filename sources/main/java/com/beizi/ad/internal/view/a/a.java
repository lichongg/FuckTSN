package com.beizi.ad.internal.view.a;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.beizi.ad.lance.a.m;
import com.beizi.fusion.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends Dialog {

    /* renamed from: b, reason: collision with root package name */
    private static e f12624b;

    /* renamed from: a, reason: collision with root package name */
    private List<c> f12625a;

    /* renamed from: c, reason: collision with root package name */
    private int f12626c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.beizi.ad.internal.view.a.a$a, reason: collision with other inner class name */
    public static class C0116a {

        /* renamed from: a, reason: collision with root package name */
        private RecyclerView f12627a;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f12628b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f12629c;

        /* renamed from: d, reason: collision with root package name */
        private RelativeLayout f12630d;

        /* renamed from: e, reason: collision with root package name */
        private RelativeLayout f12631e;

        /* renamed from: f, reason: collision with root package name */
        private EditText f12632f;

        /* renamed from: g, reason: collision with root package name */
        private TextView f12633g;

        /* renamed from: h, reason: collision with root package name */
        private Button f12634h;

        /* renamed from: i, reason: collision with root package name */
        private View f12635i;

        /* renamed from: j, reason: collision with root package name */
        private a f12636j;

        /* renamed from: k, reason: collision with root package name */
        private b f12637k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f12638l;

        public C0116a(final Context context) {
            this.f12636j = new a(context, R.style.beizi_ad_custom_dialog);
            View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.beizi_complaint_dialog, (ViewGroup) null, false);
            this.f12635i = inflate;
            this.f12636j.addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
            this.f12627a = (RecyclerView) this.f12635i.findViewById(R.id.dislike_reasons_list_recycleview);
            this.f12628b = (ImageView) this.f12635i.findViewById(R.id.complaint_dialog_close_view);
            this.f12629c = (TextView) this.f12635i.findViewById(R.id.complaint_other_suggest_view);
            this.f12630d = (RelativeLayout) this.f12635i.findViewById(R.id.complaint_normal_ui);
            this.f12631e = (RelativeLayout) this.f12635i.findViewById(R.id.complaint_other_suggest_layout);
            this.f12632f = (EditText) this.f12635i.findViewById(R.id.complaint_input_other_edittext);
            this.f12633g = (TextView) this.f12635i.findViewById(R.id.complaint_other_suggest_number_textview);
            this.f12634h = (Button) this.f12635i.findViewById(R.id.complaint_other_suggest_submit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(1);
            this.f12627a.setLayoutManager(linearLayoutManager);
            a.f12624b.a(new d() { // from class: com.beizi.ad.internal.view.a.a.a.1
                @Override // com.beizi.ad.internal.view.a.a.d
                public void a(View view, int i6, String str) {
                    C0116a.this.a(str);
                }
            });
            this.f12627a.setAdapter(a.f12624b);
            this.f12629c.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.a.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C0116a.this.f12638l = true;
                    C0116a c0116a = C0116a.this;
                    c0116a.a(context, c0116a.f12632f);
                }
            });
            this.f12628b.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.a.a.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (C0116a.this.f12638l) {
                        C0116a.this.f12638l = false;
                        C0116a c0116a = C0116a.this;
                        c0116a.a(context, c0116a.f12632f);
                    } else {
                        if (C0116a.this.f12636j != null) {
                            C0116a.this.f12636j.dismiss();
                        }
                        if (C0116a.this.f12637k != null) {
                            C0116a.this.f12637k.a();
                        }
                    }
                }
            });
            this.f12632f.addTextChangedListener(new TextWatcher() { // from class: com.beizi.ad.internal.view.a.a.a.4
                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
                    String charSequence2 = charSequence.toString();
                    int length = charSequence.length();
                    if (!charSequence2.isEmpty()) {
                        C0116a.this.f12634h.setBackground(ContextCompat.getDrawable(context, R.drawable.beizi_complaint_button_enable_shape));
                        C0116a.this.f12634h.setTextColor(context.getResources().getColor(android.R.color.black));
                        C0116a.this.f12634h.setEnabled(true);
                    } else {
                        C0116a.this.f12634h.setBackground(ContextCompat.getDrawable(context, R.drawable.beizi_complaint_button_disable_shape));
                        C0116a.this.f12634h.setTextColor(context.getResources().getColor(android.R.color.white));
                        C0116a.this.f12634h.setEnabled(false);
                    }
                    C0116a.this.f12633g.setText(String.valueOf(length));
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
                }
            });
            this.f12634h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.a.a.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C0116a.this.a(C0116a.this.f12632f.getText().toString());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            b bVar;
            if (!TextUtils.isEmpty(str) && (bVar = this.f12637k) != null) {
                bVar.a(str);
            }
            a aVar = this.f12636j;
            if (aVar != null) {
                aVar.dismiss();
            }
            m.b("BeiZisAd", str + " 被点击了");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Context context, EditText editText) {
            if (this.f12638l) {
                this.f12630d.setVisibility(8);
                this.f12631e.setVisibility(0);
                a(context, true, editText);
            } else {
                this.f12630d.setVisibility(0);
                this.f12631e.setVisibility(8);
                a(context, false, editText);
            }
        }

        private void a(final Context context, boolean z5, final EditText editText) {
            if (z5) {
                editText.requestFocus();
                new Timer().schedule(new TimerTask() { // from class: com.beizi.ad.internal.view.a.a.a.6
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                        inputMethodManager.showSoftInput(editText, 2);
                        inputMethodManager.toggleSoftInput(2, 1);
                    }
                }, 100L);
            } else {
                editText.clearFocus();
                ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        }

        public C0116a a(b bVar) {
            this.f12637k = bVar;
            return this;
        }

        public a a() {
            this.f12636j.setContentView(this.f12635i);
            this.f12636j.setCancelable(true);
            this.f12636j.setCanceledOnTouchOutside(false);
            return this.f12636j;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a();

        void a(String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c {

        /* renamed from: a, reason: collision with root package name */
        int f12650a;

        /* renamed from: b, reason: collision with root package name */
        String f12651b;

        public void a(int i6) {
            this.f12650a = i6;
        }

        c() {
        }

        public String a() {
            return this.f12651b;
        }

        public void a(String str) {
            this.f12651b = str;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a(View view, int i6, String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        public d f12653a;

        /* renamed from: c, reason: collision with root package name */
        private List<c> f12655c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.beizi.ad.internal.view.a.a$e$a, reason: collision with other inner class name */
        public class C0117a extends RecyclerView.ViewHolder {

            /* renamed from: b, reason: collision with root package name */
            private TextView f12660b;

            /* renamed from: c, reason: collision with root package name */
            private View f12661c;

            public C0117a(View view) {
                super(view);
                this.f12660b = (TextView) view.findViewById(R.id.dislike_item_multi_one_title);
                this.f12661c = view.findViewById(R.id.complaint_reason_item_divider);
            }
        }

        public e(Context context, List<c> list) {
            this.f12655c = list;
        }

        public void a(d dVar) {
            this.f12653a = dVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f12655c.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i6) {
            return a.this.f12626c;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i6) {
            final String a6 = this.f12655c.get(i6).a();
            if (viewHolder instanceof C0117a) {
                C0117a c0117a = (C0117a) viewHolder;
                c0117a.f12660b.setText(a6);
                if (this.f12655c.size() > 0 && i6 == this.f12655c.size() - 1) {
                    c0117a.f12661c.setVisibility(8);
                }
            }
            if (this.f12653a != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.view.a.a.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.f12653a.a(viewHolder.itemView, viewHolder.getLayoutPosition(), a6);
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i6) {
            return new C0117a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beizi_complaint_item_multi_one, viewGroup, false));
        }
    }

    private List<c> b() {
        ArrayList arrayList = new ArrayList();
        String[] strArr = {"垃圾广告", "感觉有被冒犯或被歧视", "广告涉及欺诈造假", "广告涉及色情暴力", "广告涉及违禁商品/服务", "对广告内容不感兴趣"};
        for (int i6 = 0; i6 < 6; i6++) {
            String str = strArr[i6];
            c cVar = new c();
            cVar.a(str);
            cVar.a(this.f12626c);
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public a(@NonNull Context context, int i6) {
        super(context, i6);
        this.f12625a = null;
        this.f12626c = 1;
        List<c> b6 = b();
        this.f12625a = b6;
        f12624b = new e(context, b6);
    }
}
