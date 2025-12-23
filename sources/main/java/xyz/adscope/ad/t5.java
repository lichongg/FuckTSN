package xyz.adscope.ad;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import xyz.adscope.ad.t5;
import xyz.adscope.amps.R;
import xyz.adscope.common.v2.log.SDKLog;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class t5 extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private b f55977a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f55978b;

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f55979c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f55980d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f55981e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f55982f;

    /* renamed from: g, reason: collision with root package name */
    private RelativeLayout f55983g;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f55984h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f55985i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f55986j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f55987k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            if (charSequence != null) {
                t5.this.a(!charSequence.toString().isEmpty());
                t5.this.f55986j.setText(String.valueOf(charSequence.length()));
            } else {
                t5.this.a(false);
                t5.this.f55986j.setText("0");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f55989a;

        /* renamed from: b, reason: collision with root package name */
        private e f55990b;

        public b a(e eVar) {
            this.f55990b = eVar;
            return this;
        }

        public b(Context context) {
            this.f55989a = context;
        }

        public Dialog a() {
            return new t5(this, (a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c extends RecyclerView.Adapter<d> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f55991a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f55992b;

        /* renamed from: c, reason: collision with root package name */
        private f f55993c;

        /* synthetic */ c(Context context, a aVar) {
            this(context);
        }

        private c(Context context) {
            this.f55991a = context;
            this.f55992b = context.getResources().getStringArray(R.array.complain_list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            String[] strArr = this.f55992b;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(f fVar) {
            this.f55993c = fVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i6) {
            return new d(View.inflate(this.f55991a, R.layout.asnp_complain_item_multi_one, null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull final d dVar, int i6) {
            String[] strArr = this.f55992b;
            if (strArr == null || strArr.length <= 0) {
                return;
            }
            final String str = strArr[i6];
            dVar.f55994a.setText(str);
            dVar.f55994a.setTextColor(Color.parseColor(b7.a().a("#000000")));
            if (i6 == this.f55992b.length - 1) {
                dVar.f55995b.setVisibility(8);
            }
            dVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.c8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t5.c.this.a(dVar, str, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(d dVar, String str, View view) {
            f fVar = this.f55993c;
            if (fVar != null) {
                fVar.a(view, dVar.getLayoutPosition(), str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class d extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        private final TextView f55994a;

        /* renamed from: b, reason: collision with root package name */
        private final View f55995b;

        public d(@NonNull View view) {
            super(view);
            this.f55994a = (TextView) view.findViewById(R.id.complain_item_multi_one_title);
            this.f55995b = view.findViewById(R.id.complain_reason_item_divider);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface e extends DialogInterface.OnDismissListener, DialogInterface.OnCancelListener, DialogInterface.OnShowListener {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface f {
        void a(View view, int i6, String str);
    }

    /* synthetic */ t5(b bVar, a aVar) {
        this(bVar);
    }

    private t5(b bVar) {
        this(bVar.f55989a, R.style.adscope_complaint_dialog);
        this.f55977a = bVar;
    }

    private void b() {
        View inflate = View.inflate(getContext(), R.layout.asnp_complain_dialog, null);
        addContentView(inflate, new ViewGroup.LayoutParams(-1, -2));
        this.f55978b = (RelativeLayout) inflate.findViewById(R.id.complain_dialog_container_rl);
        this.f55979c = (RecyclerView) inflate.findViewById(R.id.complain_reasons_list_recycleview);
        this.f55980d = (ImageView) inflate.findViewById(R.id.complain_dialog_close_view);
        this.f55981e = (TextView) inflate.findViewById(R.id.complain_other_suggest_view);
        this.f55982f = (TextView) inflate.findViewById(R.id.complain_other_suggest_title);
        this.f55983g = (RelativeLayout) inflate.findViewById(R.id.complain_normal_ui);
        this.f55984h = (RelativeLayout) inflate.findViewById(R.id.complain_other_suggest_layout);
        this.f55985i = (EditText) inflate.findViewById(R.id.complain_input_other_edittext);
        this.f55986j = (TextView) inflate.findViewById(R.id.complain_other_suggest_number_textview);
        this.f55987k = (TextView) inflate.findViewById(R.id.complain_other_suggest_submit);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.f55979c.setLayoutManager(linearLayoutManager);
        try {
            d();
        } catch (Exception unused) {
        }
    }

    private void c() {
        c cVar = new c(getContext(), null);
        cVar.a(new f() { // from class: xyz.adscope.ad.b8
            @Override // xyz.adscope.ad.t5.f
            public final void a(View view, int i6, String str) {
                t5.this.a(view, i6, str);
            }
        });
        this.f55979c.setAdapter(cVar);
    }

    private void d() {
        try {
            if (b7.a().b()) {
                this.f55978b.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.asnp_complaint_dialog_shape_black));
            } else {
                this.f55978b.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.asnp_complaint_dialog_shape));
            }
            this.f55981e.setHintTextColor(Color.parseColor(b7.a().a("#666666")));
            this.f55985i.setHintTextColor(Color.parseColor(b7.a().a("#0A0A0A")));
            this.f55985i.setTextColor(Color.parseColor(b7.a().a("#000000")));
            this.f55982f.setTextColor(Color.parseColor(b7.a().a("#000000")));
            q6.a(getContext(), this.f55987k, b7.a().a("#B4B4B4"), 0, "", 10);
            q6.a(getContext(), this.f55985i, b7.a().a("#F3F3F3"), 0, "", 3);
        } catch (Exception e6) {
            SDKLog.stack(e6);
        }
    }

    private void e() {
        this.f55981e.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.y7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t5.this.a(view);
            }
        });
        this.f55985i.addTextChangedListener(new a());
    }

    private void f() {
        this.f55980d.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.z7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t5.this.b(view);
            }
        });
        this.f55987k.setOnClickListener(new View.OnClickListener() { // from class: xyz.adscope.ad.a8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t5.this.c(view);
            }
        });
    }

    private void g() {
        if (this.f55983g.getVisibility() == 0) {
            this.f55983g.setVisibility(8);
            this.f55984h.setVisibility(0);
            c(this.f55985i);
        } else {
            this.f55983g.setVisibility(0);
            this.f55984h.setVisibility(8);
            a(this.f55985i);
        }
    }

    private t5(@NonNull Context context, int i6) {
        super(context, i6);
        b();
        c();
        e();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, int i6, String str) {
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        a(this.f55985i.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z5) {
        String str;
        int i6;
        if (z5) {
            str = "#3380FF";
            i6 = ViewCompat.MEASURED_STATE_MASK;
        } else {
            str = "#B4B4B4";
            i6 = -1;
        }
        q6.a(getContext(), this.f55987k, str, 0, "", 10);
        this.f55987k.setTextColor(i6);
        this.f55987k.setEnabled(z5);
    }

    private void c(final EditText editText) {
        editText.requestFocus();
        new Handler().postDelayed(new Runnable() { // from class: xyz.adscope.ad.x7
            @Override // java.lang.Runnable
            public final void run() {
                t5.this.b(editText);
            }
        }, 100L);
    }

    private void a(EditText editText) {
        editText.clearFocus();
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void a(String str) {
        if (this.f55977a.f55990b != null) {
            this.f55977a.f55990b.a(str);
        }
        a();
    }

    private void a() {
        if (isShowing()) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.f55984h.getVisibility() == 4) {
            g();
        } else {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        inputMethodManager.showSoftInput(editText, 2);
        inputMethodManager.toggleSoftInput(2, 1);
    }
}
