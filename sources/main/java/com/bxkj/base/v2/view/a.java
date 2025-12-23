package com.bxkj.base.v2.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.R;
import cn.bluemobi.dylan.base.utils.u;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final LinearLayout f17152a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final TextView f17153b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Button f17154c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private View.OnClickListener f17155d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private b f17156e;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.base.v2.view.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0194a implements View.OnClickListener {
        ViewOnClickListenerC0194a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            if (a.this.f17155d != null) {
                View.OnClickListener onClickListener = a.this.f17155d;
                g0.m(onClickListener);
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onMenuClick(@Nullable String str);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17159b;

        c(String str) {
            this.f17159b = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            b bVar = a.this.f17156e;
            if (bVar != null) {
                bVar.onMenuClick(this.f17159b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context) {
        super(context, R.style.ios_dialog_theme);
        g0.p(context, "context");
        requestWindowFeature(1);
        setContentView(com.bxkj.base.R.layout.dialog_select_item);
        Window window = getWindow();
        g0.m(window);
        window.setGravity(17);
        View findViewById = findViewById(com.bxkj.base.R.id.ll_content);
        g0.n(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.f17152a = (LinearLayout) findViewById;
        View findViewById2 = findViewById(com.bxkj.base.R.id.tv_title);
        g0.n(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.f17153b = (TextView) findViewById2;
        View findViewById3 = findViewById(com.bxkj.base.R.id.btn_one);
        g0.n(findViewById3, "null cannot be cast to non-null type android.widget.Button");
        Button button = (Button) findViewById3;
        this.f17154c = button;
        button.setOnClickListener(new ViewOnClickListenerC0194a());
    }

    @NotNull
    public final a c(@Nullable String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#2C7AD7"));
        textView.setTextSize(2, 18.0f);
        textView.setGravity(17);
        textView.setOnClickListener(new c(str));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, u.a(40.0f, getContext()));
        textView.setLayoutParams(layoutParams);
        this.f17152a.addView(textView, layoutParams);
        return this;
    }

    @NotNull
    public final a d(@Nullable List<String> list) {
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
        }
        return this;
    }

    @NotNull
    public final a e(@Nullable View.OnClickListener onClickListener) {
        this.f17155d = onClickListener;
        return this;
    }

    @NotNull
    public final a g(@Nullable b bVar) {
        this.f17156e = bVar;
        return this;
    }

    @NotNull
    public final a h(@Nullable CharSequence charSequence) {
        this.f17154c.setText(charSequence);
        return this;
    }

    @NotNull
    public final a i(@Nullable String str) {
        this.f17153b.setText(str);
        return this;
    }

    @NotNull
    public final a f(int i6) {
        LayoutInflater.from(getContext()).inflate(i6, this.f17152a);
        return this;
    }
}
