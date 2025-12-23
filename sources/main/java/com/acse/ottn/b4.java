package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.SeedWebViewActivity;
import com.acse.ottn.m0;
import com.acse.ottn.widget.ContinueSlideScrollView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class b4 {

    /* renamed from: a, reason: collision with root package name */
    public static AlertDialog f4249a = null;

    /* renamed from: b, reason: collision with root package name */
    public static ContinueSlideScrollView f4250b = null;

    /* renamed from: c, reason: collision with root package name */
    public static TimerTask f4251c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final String f4252d = "在使用“一键开启必要权限”服务前，请您仔细阅读我们的《用户协议》和《隐私政策》。请您知悉，您同意用户协议和隐私政策将代表您已了解我们提供的功能，以及功能运行所需的必要个人信息。我们在向您提供服务的过程中，除非单独获得您的同意和授权，否则将不会收集您的非必要个人信息。";

    /* renamed from: e, reason: collision with root package name */
    public static final String f4253e = "《用户协议》";

    /* renamed from: f, reason: collision with root package name */
    public static final String f4254f = "《隐私政策》";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements ContinueSlideScrollView.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f4255a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f4256b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f4257c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.acse.ottn.b4$a$a, reason: collision with other inner class name */
        public class ViewOnClickListenerC0069a implements View.OnClickListener {
            public ViewOnClickListenerC0069a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f4256b.onOpen();
                b4.a(a.this.f4257c, b4.f4249a);
            }
        }

        public a(TextView textView, h hVar, Activity activity) {
            this.f4255a = textView;
            this.f4256b = hVar;
            this.f4257c = activity;
        }

        @Override // com.acse.ottn.widget.ContinueSlideScrollView.a
        public void a() {
            if (b4.f4251c != null) {
                b4.f4251c.cancel();
                this.f4255a.setText("我已知晓并同意");
                this.f4255a.setOnClickListener(new ViewOnClickListenerC0069a());
                g0.a().d(this.f4257c, this.f4255a);
            }
        }

        @Override // com.acse.ottn.widget.ContinueSlideScrollView.a
        public void b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4259a;

        public b(Activity activity) {
            this.f4259a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f4259a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().d(this.f4259a));
            this.f4259a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            g0.a().a(this.f4259a, textPaint);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4260a;

        public c(Activity activity) {
            this.f4260a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f4260a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().b(this.f4260a));
            this.f4260a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            g0.a().a(this.f4260a, textPaint);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class d extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4261a;

        public d(Activity activity) {
            this.f4261a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f4261a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().c(this.f4261a));
            this.f4261a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            g0.a().a(this.f4261a, textPaint);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class e extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4262a;

        public e(Activity activity) {
            this.f4262a = activity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f4262a, (Class<?>) SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().a(this.f4262a));
            this.f4262a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            g0.a().a(this.f4262a, textPaint);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class f implements m0.d {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f4263a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f4264b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Activity f4265c;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.f4264b.onOpen();
                b4.a(f.this.f4265c, b4.f4249a);
            }
        }

        @Override // com.acse.ottn.m0.d
        public void a(long j6) {
            this.f4263a.setText("请下拉阅读(" + (j6 / 1000) + "s)");
            this.f4263a.setOnClickListener(null);
        }

        public f(TextView textView, h hVar, Activity activity) {
            this.f4263a = textView;
            this.f4264b = hVar;
            this.f4265c = activity;
        }

        @Override // com.acse.ottn.m0.d
        public void a() {
            this.f4263a.setText("我已知晓并同意");
            this.f4263a.setOnClickListener(new a());
            g0.a().d(this.f4265c, this.f4263a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f4267a;

        public g(Activity activity) {
            this.f4267a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b4.a(this.f4267a, b4.f4249a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface h {
        void onDismiss();

        void onOpen();
    }

    public static AlertDialog a(Activity activity, h hVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.service_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_one);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_two);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_three);
        TextView textView4 = (TextView) inflate.findViewById(R.id.tv_four);
        TextView textView5 = (TextView) inflate.findViewById(R.id.tv_five);
        TextView textView6 = (TextView) inflate.findViewById(R.id.tv_six);
        TextView textView7 = (TextView) inflate.findViewById(R.id.tv_seven);
        TextView textView8 = (TextView) inflate.findViewById(R.id.tv_eight);
        TextView textView9 = (TextView) inflate.findViewById(R.id.tv_but2);
        g0.a().d(activity, textView9);
        TextView textView10 = (TextView) inflate.findViewById(R.id.tv_line);
        g0.a().a(activity, (TextView) inflate.findViewById(R.id.tv_line_short));
        g0.a().a(activity, textView10);
        f4250b = (ContinueSlideScrollView) inflate.findViewById(R.id.info_scroll);
        TextView textView11 = (TextView) inflate.findViewById(R.id.tv_version_info);
        g0.a().a(activity, (RelativeLayout) inflate.findViewById(R.id.relativeLayout_bg));
        f4250b.setScanScrollChangedListener(new a(textView9, hVar, activity));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(f4252d);
        spannableStringBuilder.setSpan(new b(activity), 26, 32, 33);
        spannableStringBuilder.setSpan(new c(activity), 33, 39, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
        String string = activity.getResources().getString(R.string.one_pilcrow);
        String str = k0.f4665a;
        textView2.setText(String.format(string, str));
        textView3.setText(activity.getResources().getString(R.string.two_pilcrow));
        textView4.setText(String.format(activity.getResources().getString(R.string.three_pilcrow), str));
        textView5.setText(activity.getResources().getString(R.string.four_pilcrow));
        textView6.setText(String.format(activity.getResources().getString(R.string.five_pilcrow), str));
        textView7.setText(String.format(activity.getResources().getString(R.string.six_pilcrow), str));
        String format = String.format(activity.getResources().getString(R.string.seven_pilcrow), str);
        int indexOf = format.indexOf(f4253e);
        int indexOf2 = format.indexOf(f4254f);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format);
        spannableStringBuilder2.setSpan(new d(activity), indexOf, indexOf + 6, 33);
        spannableStringBuilder2.setSpan(new e(activity), indexOf2, indexOf2 + 6, 33);
        textView8.setMovementMethod(LinkMovementMethod.getInstance());
        textView8.setText(spannableStringBuilder2);
        f4251c = m0.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType, 1000, new f(textView9, hVar, activity));
        TextView textView12 = (TextView) inflate.findViewById(R.id.tv_button);
        g0.a().a(activity, textView11, textView12);
        textView12.setOnClickListener(new g(activity));
        AlertDialog create = builder.create();
        f4249a = create;
        create.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        b(activity, f4249a);
        return f4249a;
    }

    public static void b(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception unused) {
        }
    }

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }
}
