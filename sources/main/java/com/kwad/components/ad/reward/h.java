package com.kwad.components.ad.reward;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h extends com.kwad.components.core.proxy.j {
    private static String sM = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String sN = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a sL;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a extends com.kwad.components.core.webview.tachikoma.f.c {
        void h(int i6, int i7);

        void hh();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class c extends com.kwad.sdk.core.response.a.a {
        public String sS;
        public String sT;
        public String sU;
        public String sV;
        public String sW;
        public String sX;
        public String sY;
        public String sZ;
        public com.kwad.components.ad.reward.l.b.a sm;
        public com.kwad.components.ad.reward.l.a.a sn;
        public int style;
        public String title;

        static c a(com.kwad.components.ad.reward.l.b.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.sm = aVar;
            cVar.sV = str;
            cVar.sW = com.kwad.sdk.core.response.b.a.co(com.kwad.sdk.core.response.b.e.el(adTemplate));
            return cVar;
        }

        public static c h(String str, int i6) {
            c cVar = new c();
            cVar.style = 6;
            cVar.title = str;
            cVar.sS = "残忍离开";
            cVar.sT = "留下看看";
            if (i6 > 0) {
                cVar.sZ = String.valueOf(i6);
            }
            return cVar;
        }

        static c E(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.sS = "关闭广告";
            cVar.sT = "继续观看";
            return cVar;
        }

        public static c F(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        private void G(String str) {
            this.sZ = str;
        }

        static c n(long j6) {
            c cVar = new c();
            cVar.style = 6;
            cVar.sS = "残忍离开";
            cVar.sT = "留下看看";
            if (j6 > 0) {
                cVar.G(String.valueOf(j6));
                return cVar;
            }
            cVar.G(null);
            return cVar;
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String hk() {
            return TextUtils.isEmpty(this.sS) ? "关闭广告" : this.sS;
        }

        public final String hl() {
            return TextUtils.isEmpty(this.sT) ? "继续观看" : this.sT;
        }

        public final com.kwad.components.ad.reward.l.b.a hm() {
            return this.sm;
        }

        public final com.kwad.components.ad.reward.l.a.a hn() {
            return this.sn;
        }

        public final String ho() {
            return this.sW;
        }

        public final String hp() {
            return this.sX;
        }

        public final String hq() {
            return this.sY;
        }

        public final String hr() {
            return TextUtils.isEmpty(this.sZ) ? "" : String.format("再看%s秒，可获得优惠", this.sZ);
        }

        private c() {
        }

        static c c(AdTemplate adTemplate, long j6) {
            AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.sW = com.kwad.sdk.core.response.b.a.co(el);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j6));
            cVar.sX = com.kwad.sdk.core.response.b.a.cl(el);
            cVar.sY = com.kwad.sdk.core.response.b.a.au(el);
            cVar.sS = "放弃奖励";
            cVar.sT = "继续观看";
            cVar.sU = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate));
            return cVar;
        }

        static c d(AdTemplate adTemplate, long j6) {
            AdMatrixInfo.MerchantLiveReservationInfo dt = com.kwad.sdk.core.response.b.b.dt(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.sW = dt.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j6));
            cVar.sX = dt.title;
            cVar.sS = "放弃奖励";
            cVar.sT = "继续观看";
            cVar.sU = com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.el(adTemplate));
            return cVar;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (optJSONObject != null) {
                if (this.sm == null) {
                    this.sm = new com.kwad.components.ad.reward.l.b.a();
                }
                this.sm.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (optJSONObject2 != null) {
                if (this.sn == null) {
                    this.sn = new com.kwad.components.ad.reward.l.a.a();
                }
                this.sn.parseJson(optJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.l.b.a aVar = this.sm;
            if (aVar != null) {
                aa.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.l.a.a aVar2 = this.sn;
            if (aVar2 != null) {
                aa.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }

        static c a(com.kwad.components.ad.reward.l.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.sn = aVar;
            cVar.sV = str;
            cVar.sW = com.kwad.sdk.core.response.b.a.co(com.kwad.sdk.core.response.b.e.el(adTemplate));
            return cVar;
        }

        static c h(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo cV = com.kwad.sdk.core.response.b.a.cV(adInfo);
            cVar.title = com.kwad.sdk.core.response.b.a.au(adInfo);
            cVar.sW = cV.getIcon();
            return cVar;
        }

        public static c a(AdInfo adInfo, long j6) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo cV = com.kwad.sdk.core.response.b.a.cV(adInfo);
            cVar.sX = com.kwad.sdk.core.response.b.a.au(adInfo);
            String name = cV.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.b.a.ax(adInfo);
            }
            cVar.sW = cV.getIcon();
            if (j6 > 0) {
                cVar.G(String.valueOf(j6));
                return cVar;
            }
            cVar.G(null);
            return cVar;
        }
    }

    public static c a(g gVar, @Nullable String str) {
        int i6;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.components.ad.reward.l.b.a aVar = gVar.sm;
        com.kwad.components.ad.reward.l.a.a aVar2 = gVar.sn;
        int i7 = gVar.so;
        boolean k6 = com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.el(adTemplate)));
        int i8 = 0;
        if (k6 || com.kwad.sdk.core.response.b.e.O(adTemplate)) {
            int ad = (int) com.kwad.sdk.core.response.b.a.ad(el);
            int L = com.kwad.sdk.core.response.b.a.L(el);
            if (ad > L) {
                ad = L;
            }
            long playDuration = gVar.rE.getPlayDuration();
            if (playDuration < (ad * 1000) - 800 && (i6 = (int) (ad - ((playDuration / 1000.0f) + 0.5f))) >= 0) {
                i8 = i6;
            }
        }
        return (!k6 || aVar == null) ? (!com.kwad.sdk.core.response.b.e.O(adTemplate) || aVar2 == null) ? com.kwad.components.ad.reward.a.b.i(el) ? c.h(el) : (com.kwad.sdk.core.response.b.a.cj(el) == 1 && com.kwad.components.ad.reward.a.b.hJ() == 1) ? c.a(el, i7) : adTemplate.isNativeRewardPreview ? c.h(str, i7) : com.kwad.sdk.core.response.b.a.cR(el) ? c.c(adTemplate, i7) : com.kwad.sdk.core.response.b.a.co(adTemplate) ? c.d(adTemplate, i7) : com.kwad.components.ad.reward.a.b.hD() == 1 ? c.n(i7) : c.E(str) : c.a(aVar2, adTemplate, String.valueOf(i8)) : c.a(aVar, adTemplate, String.valueOf(i8));
    }

    private static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) inflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.sW, adTemplate);
        ((TextView) inflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hj();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.hh();
                }
            }
        });
        inflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        return inflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        int i6 = R.color.ksad_reward_main_color;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, i6));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, i6));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hn(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    public static c g(String str, int i6) {
        return c.h(str, i6);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window != null) {
            getDialog().setCanceledOnTouchOutside(false);
            window.setLayout(-1, -1);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            a aVar = this.sL;
            if (aVar != null) {
                aVar.ha();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b implements a {
        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void ha() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void hh() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hi() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hj() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void G(boolean z5) {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void h(int i6, int i7) {
        }
    }

    public static h a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        hVar.setArguments(bundle);
        hVar.a(aVar);
        hVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return hVar;
    }

    private void a(a aVar) {
        this.sL = aVar;
    }

    @Override // com.kwad.components.core.proxy.j
    @Nullable
    public final View a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        View a6;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c F = c.F(string);
        int style = F.getStyle();
        if (style == 1) {
            a6 = a(this, layoutInflater, viewGroup, F, this.mAdTemplate, this.sL);
        } else if (style == 2) {
            a6 = b(this, layoutInflater, viewGroup, F, this.mAdTemplate, this.sL);
        } else if (style == 4) {
            a6 = c(this, layoutInflater, viewGroup, F, this.mAdTemplate, this.sL);
            com.kwad.components.core.t.j.a(new com.kwad.components.core.widget.e(), (ViewGroup) a6);
        } else if (style == 5) {
            com.kwad.components.ad.reward.n.j jVar = new com.kwad.components.ad.reward.n.j(this, this.mAdTemplate, layoutInflater, viewGroup, this.sL);
            jVar.a(F);
            a6 = jVar.hP();
        } else if (style == 6) {
            a6 = a(this, layoutInflater, viewGroup, F, this.sL);
        } else if (style != 8) {
            a6 = a((DialogFragment) this, layoutInflater, viewGroup, F, this.sL);
        } else {
            com.kwad.components.ad.reward.n.m mVar = new com.kwad.components.ad.reward.n.m(this, this.mAdTemplate, layoutInflater, viewGroup, this.sL);
            mVar.a(F);
            a6 = mVar.hP();
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                return i6 == 4 && keyEvent.getAction() == 0;
            }
        });
        return a6;
    }

    private static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.hk());
        textView2.setText(cVar.hl());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hj();
                }
            }
        });
        return inflate;
    }

    private View a(final h hVar, LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, c cVar, final a aVar) {
        View inflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(inflate.getContext(), cVar.sZ));
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.hk());
        textView2.setText(cVar.hl());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hj();
                }
            }
        });
        return inflate;
    }

    private static View a(com.kwad.components.ad.reward.l.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) {
        String format;
        int i6;
        View inflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.l.b.a) {
            com.kwad.components.ad.reward.l.b.a.a((com.kwad.components.ad.reward.l.b.a) aVar, inflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) inflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.kA(), cVar.sV);
        KSImageLoader.loadAppIcon((ImageView) inflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.ho(), adTemplate, 12);
        TextView textView = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) inflate.findViewById(R.id.ksad_reward_task_dialog_title);
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.kB());
        String sb2 = sb.toString();
        String str = cVar.sV;
        boolean equals = "0".equals(str);
        if (equals) {
            format = String.format(sM, sb2);
        } else {
            format = String.format(sN, str);
        }
        int indexOf = equals ? format.indexOf(sb2) : format.indexOf(str);
        if (indexOf < 0) {
            textView3.setText(format);
        } else {
            if (equals) {
                i6 = indexOf + 1;
            } else {
                i6 = str.length() > 1 ? indexOf + 3 : indexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(inflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(foregroundColorSpan, indexOf, i6, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.hj();
                }
            }
        });
        return inflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hm(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }
}
