package com.kwad.components.ad.reward.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class h extends s implements View.OnClickListener {
    protected ImageView BA;

    @Nullable
    protected KsAppTagsView BE;
    protected KsConvertButton BV;
    protected TextView BW;

    @Nullable
    protected TextView BX;

    @Nullable
    protected TextView BY;
    protected a BZ;

    @LayoutRes
    protected int Ca = R.layout.ksad_reward_apk_info_card_tag_item;
    protected boolean Cb = true;

    @Nullable
    protected KsLogoView mLogoView;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void jk();

        void jl();

        void jm();

        void jn();

        void jo();

        void jp();
    }

    public final void a(a aVar) {
        this.BZ = aVar;
    }

    private void ag(int i6) {
        KsConvertButton ksConvertButton = this.BV;
        if (ksConvertButton == null) {
            return;
        }
        if (i6 == 1) {
            ksConvertButton.getCornerConf().setAllCorner(true);
        } else if (i6 == 2) {
            ksConvertButton.getCornerConf().cp(false).cs(false).cr(true).cq(true);
        }
        this.BV.postInvalidate();
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.mLogoView = (KsLogoView) viewGroup.findViewById(R.id.ksad_common_app_logo);
        this.BA = (ImageView) viewGroup.findViewById(R.id.ksad_common_app_icon);
        this.BW = (TextView) viewGroup.findViewById(R.id.ksad_common_app_name);
        this.BE = (KsAppTagsView) viewGroup.findViewById(R.id.ksad_common_app_tags);
        this.BX = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc);
        this.BY = (TextView) viewGroup.findViewById(R.id.ksad_common_app_desc2);
        this.BV = (KsConvertButton) viewGroup.findViewById(R.id.ksad_common_app_action);
    }

    private static int le() {
        return R.id.ksad_common_app_card_root;
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) {
        super.a(rVar);
        a(com.kwad.components.ad.reward.model.a.a(rVar, this.Cb));
    }

    protected int jj() {
        return R.id.ksad_common_app_card_stub;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        if (view.equals(this.BV)) {
            a aVar2 = this.BZ;
            if (aVar2 != null) {
                aVar2.jk();
                return;
            }
            return;
        }
        if (view.equals(this.BA)) {
            a aVar3 = this.BZ;
            if (aVar3 != null) {
                aVar3.jl();
                return;
            }
            return;
        }
        if (view.equals(this.BW)) {
            a aVar4 = this.BZ;
            if (aVar4 != null) {
                aVar4.jm();
                return;
            }
            return;
        }
        if (view.equals(this.BX) || view.equals(this.BY)) {
            a aVar5 = this.BZ;
            if (aVar5 != null) {
                aVar5.jn();
                return;
            }
            return;
        }
        if (view.equals(this.BE)) {
            a aVar6 = this.BZ;
            if (aVar6 != null) {
                aVar6.jo();
                return;
            }
            return;
        }
        if (!view.equals(this.vV) || (aVar = this.BZ) == null) {
            return;
        }
        aVar.jp();
    }

    public final void show() {
        ViewGroup viewGroup = this.vV;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public final void f(ViewGroup viewGroup) {
        super.a(viewGroup, jj(), le());
        g(this.vV);
        ViewGroup viewGroup2 = this.vV;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
            this.BV.setOnClickListener(this);
            this.BA.setOnClickListener(this);
            this.BW.setOnClickListener(this);
            TextView textView = this.BX;
            if (textView != null) {
                textView.setOnClickListener(this);
            }
            TextView textView2 = this.BY;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
            }
            KsAppTagsView ksAppTagsView = this.BE;
            if (ksAppTagsView != null) {
                ksAppTagsView.setOnClickListener(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.components.ad.reward.model.a r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r6.im()
            r5.ag(r0)
            com.kwad.components.core.widget.KsLogoView r0 = r5.mLogoView
            if (r0 == 0) goto L15
            com.kwad.sdk.core.response.model.AdTemplate r1 = r6.ii()
            r0.aP(r1)
        L15:
            android.widget.TextView r0 = r5.BW
            java.lang.String r1 = r6.getTitle()
            r0.setText(r1)
            android.widget.TextView r0 = r5.BX
            if (r0 == 0) goto L29
            java.lang.String r1 = r6.hp()
            r0.setText(r1)
        L29:
            android.widget.TextView r0 = r5.BY
            r1 = 0
            r2 = 8
            if (r0 == 0) goto L5c
            java.lang.String r3 = r6.hp()
            r0.setText(r3)
            java.lang.String r0 = r6.hp()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L46
            r0 = 8
        L43:
            r3 = 8
            goto L52
        L46:
            boolean r0 = r6.il()
            if (r0 == 0) goto L50
            r0 = 8
            r3 = 0
            goto L52
        L50:
            r0 = 0
            goto L43
        L52:
            android.widget.TextView r4 = r5.BX
            if (r4 == 0) goto L59
            r4.setVisibility(r0)
        L59:
            android.widget.TextView r0 = r5.BY
            goto L6e
        L5c:
            android.widget.TextView r0 = r5.BX
            if (r0 == 0) goto L71
            java.lang.String r3 = r6.hp()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L6d
            r3 = 8
            goto L6e
        L6d:
            r3 = 0
        L6e:
            r0.setVisibility(r3)
        L71:
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.BE
            if (r0 == 0) goto L8b
            java.util.List r3 = r6.ik()
            int r4 = r5.Ca
            r0.a(r3, r4)
            com.kwad.components.ad.widget.KsAppTagsView r0 = r5.BE
            boolean r3 = r6.il()
            if (r3 == 0) goto L88
            r1 = 8
        L88:
            r0.setVisibility(r1)
        L8b:
            com.kwad.components.core.widget.KsConvertButton r0 = r5.BV
            if (r0 == 0) goto L9a
            com.kwad.components.core.e.d.c r1 = r6.ij()
            com.kwad.sdk.core.response.model.AdTemplate r2 = r6.ii()
            r0.a(r1, r2)
        L9a:
            android.widget.ImageView r0 = r5.BA
            java.lang.String r1 = r6.ho()
            com.kwad.sdk.core.response.model.AdTemplate r6 = r6.ii()
            r2 = 12
            com.kwad.sdk.core.imageloader.KSImageLoader.loadAppIcon(r0, r1, r6, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.n.h.a(com.kwad.components.ad.reward.model.a):void");
    }
}
