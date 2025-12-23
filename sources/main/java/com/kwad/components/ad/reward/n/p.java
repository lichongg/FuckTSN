package com.kwad.components.ad.reward.n;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p extends s implements View.OnClickListener {
    private ImageView Dh;
    private TextView Di;
    private TextView Dj;
    private TextView Dk;
    private TextView Dl;
    private TextView Dm;
    private TextView Dn;
    private TextView Do;
    private com.kwad.components.ad.reward.g tm;

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        super.a(rVar);
        j(rVar.getAdTemplate());
    }

    private void initView() {
        if (this.vV == null) {
            return;
        }
        if (this.tm.mContext.getResources().getConfiguration().orientation == 2) {
            this.Dh = (ImageView) this.vV.findViewById(R.id.ksad_live_end_page_author_icon_landscape);
            this.Di = (TextView) this.vV.findViewById(R.id.ksad_author_name_txt_landscape);
            this.Dj = (TextView) this.vV.findViewById(R.id.ksad_live_end_detail_watch_person_count_landscape);
            this.Dk = (TextView) this.vV.findViewById(R.id.ksad_live_end_detail_like_person_count_landscape);
            this.Dl = (TextView) this.vV.findViewById(R.id.ksad_live_end_detail_watch_time_landscape);
            this.Dm = (TextView) this.vV.findViewById(R.id.ksad_live_end_bottom_title_landscape);
            this.Dn = (TextView) this.vV.findViewById(R.id.ksad_live_end_bottom_action_btn_landscape);
            this.Do = (TextView) this.vV.findViewById(R.id.ksad_live_end_bottom_des_btn_landscape);
        } else {
            this.Dh = (ImageView) this.vV.findViewById(R.id.ksad_live_end_page_author_icon);
            this.Di = (TextView) this.vV.findViewById(R.id.ksad_author_name_txt);
            this.Dj = (TextView) this.vV.findViewById(R.id.ksad_live_end_detail_watch_person_count);
            this.Dk = (TextView) this.vV.findViewById(R.id.ksad_live_end_detail_like_person_count);
            this.Dl = (TextView) this.vV.findViewById(R.id.ksad_live_end_detail_watch_time);
            this.Dm = (TextView) this.vV.findViewById(R.id.ksad_live_end_bottom_title);
            this.Dn = (TextView) this.vV.findViewById(R.id.ksad_live_end_bottom_action_btn);
            this.Do = (TextView) this.vV.findViewById(R.id.ksad_live_end_bottom_des_btn);
        }
        this.Dn.setOnClickListener(this);
        this.Do.setOnClickListener(this);
    }

    public final void ah(int i6) {
        TextView textView = this.Dm;
        if (textView != null) {
            if (i6 <= 0) {
                textView.setText("已获得奖励");
                return;
            }
            if (!this.tm.rS) {
                textView.setText("已获得奖励");
                return;
            }
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i6));
            SpannableString spannableString = new SpannableString(format);
            int color = hP().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.Dm.setText(spannableString);
        }
    }

    public final void h(ViewGroup viewGroup) {
        if (this.tm.mContext.getResources().getConfiguration().orientation == 2) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub_landscape, R.id.ksad_live_end_page_layout_root_landscape);
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub, R.id.ksad_live_end_page_layout_root);
        }
        initView();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.dm(24);
        if (view.equals(this.Dn)) {
            this.tm.a(2, view.getContext(), 38, 1, 0L, false, bVar);
        } else if (view.equals(this.Do)) {
            this.tm.a(2, view.getContext(), 37, 1, 0L, false, bVar);
        }
    }

    public p(com.kwad.components.ad.reward.g gVar) {
        this.tm = gVar;
    }

    private void j(AdTemplate adTemplate) {
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        KSImageLoader.loadCircleIcon(this.Dh, com.kwad.sdk.core.response.b.a.co(el), this.Dh.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        this.Di.setText(com.kwad.sdk.core.response.b.a.cl(el));
    }

    private static String r(long j6) {
        long j7 = (j6 / 3600000) % 24;
        long j8 = (j6 / 60000) % 60;
        long j9 = (j6 / 1000) % 60;
        if (j7 > 0) {
            return String.format("%02d:%02d:%02d", Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9));
        }
        return String.format("%02d:%02d", Long.valueOf(j8), Long.valueOf(j9));
    }

    public final void a(com.kwad.components.ad.reward.g gVar, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j6) {
        this.Dk.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.Dl.setText(r(adLivePushEndInfo.mLiveDuration));
        this.Dj.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (gVar.rS) {
            String format = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(com.kwad.sdk.core.response.b.a.ag(com.kwad.sdk.core.response.b.e.el(gVar.mAdTemplate)) - j6, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(format);
            int color = hP().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = format.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.Dm.setText(spannableString);
            return;
        }
        this.Dm.setText("内容很精彩，不要错过哦");
    }
}
