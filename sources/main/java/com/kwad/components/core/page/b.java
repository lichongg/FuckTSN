package com.kwad.components.core.page;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.page.recycle.DetailWebRecycleView;
import com.kwad.components.core.page.recycle.e;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o.m;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.components.core.page.recycle.a {
    private WebView Ta;
    private FeedVideoView Tb;
    private LinearLayout Tc;
    private TextView Td;
    private ImageView Te;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends com.kwad.components.core.page.recycle.d {
        e Th;
        AdTemplate mAdTemplate;
        private Context mContext;

        @Override // com.kwad.components.core.page.recycle.d
        public final com.kwad.components.core.page.recycle.c c(ViewGroup viewGroup, int i6) {
            if (i6 == 1) {
                View a6 = m.a(this.mContext, R.layout.ksad_datail_webview_container, viewGroup, false);
                Presenter presenter = new Presenter();
                presenter.a(new com.kwad.components.core.page.c.b());
                return new com.kwad.components.core.page.recycle.c(a6, presenter, this.Th);
            }
            if (i6 != 0) {
                View view = new View(viewGroup.getContext());
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 64.0f)));
                return new com.kwad.components.core.page.recycle.c(view, new Presenter(), this.Th);
            }
            FeedVideoView feedVideoView = new FeedVideoView(viewGroup.getContext());
            Presenter presenter2 = new Presenter();
            presenter2.a(new com.kwad.components.core.page.c.a());
            return new com.kwad.components.core.page.recycle.c(feedVideoView, presenter2, this.Th);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate)) ? 3 : 2;
        }

        a(AdTemplate adTemplate, Context context, e eVar) {
            this.mAdTemplate = adTemplate;
            this.mContext = context;
            this.Th = eVar;
        }

        @Override // com.kwad.components.core.page.recycle.d, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public final void onBindViewHolder(com.kwad.components.core.page.recycle.c cVar, int i6) {
            super.onBindViewHolder(cVar, i6);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int i6) {
            return i6;
        }
    }

    public static b aC(AdTemplate adTemplate) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        bVar.setArguments(bundle);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view) {
        this.Tc = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        this.Td = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ImageView imageView = (ImageView) view.findViewById(R.id.ksad_web_tip_close_btn);
        this.Te = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.b.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.this.Tc.setVisibility(8);
            }
        });
        AdInfo el = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        boolean bz = com.kwad.sdk.core.response.b.a.bz(el);
        String bv = com.kwad.sdk.core.response.b.a.bv(el);
        if (!bz) {
            this.Tc.setVisibility(8);
            return;
        }
        this.Tc.setVisibility(0);
        this.Td.setText(bv);
        this.Td.setSelected(true);
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.m.a.b
    public final boolean onBackPressed() {
        WebView webView = this.Ta;
        if (webView != null && webView.canGoBack()) {
            this.Ta.goBack();
            return true;
        }
        FeedVideoView feedVideoView = this.Tb;
        if (feedVideoView != null) {
            return feedVideoView.wc();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int qN() {
        return R.layout.ksad_detail_webview;
    }

    public final void setApkDownloadHelper(com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.components.core.page.recycle.a, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        final DetailWebRecycleView detailWebRecycleView = (DetailWebRecycleView) ry();
        detailWebRecycleView.setInterceptRequestFocusForWeb(true);
        detailWebRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.core.page.b.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (detailWebRecycleView.getChildCount() > 0) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = detailWebRecycleView.findViewHolderForAdapterPosition(0);
                    com.kwad.sdk.core.d.c.d("AdRecycleWebFragment", "recycleView.setTopViewHeight(" + findViewHolderForAdapterPosition.itemView.getHeight() + ")");
                    detailWebRecycleView.setTopViewHeight(findViewHolderForAdapterPosition.itemView.getHeight());
                    View view2 = detailWebRecycleView.findViewHolderForAdapterPosition(0).itemView;
                    if (view2 instanceof FeedVideoView) {
                        b.this.Tb = (FeedVideoView) view2;
                    }
                }
                if (detailWebRecycleView.getChildCount() > 1) {
                    View view3 = detailWebRecycleView.findViewHolderForAdapterPosition(1).itemView;
                    b.this.Ta = (WebView) view3.findViewById(R.id.ksad_video_webView);
                    b.this.z(view3);
                }
                com.kwad.sdk.core.d.c.d("AdRecycleWebFragment", "onGlobalLayout");
                detailWebRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.kwad.components.core.page.recycle.a
    public final com.kwad.components.core.page.recycle.d a(RecyclerView recyclerView) {
        return new a(this.mAdTemplate, recyclerView.getContext(), new e(this.mAdTemplate, this.mApkDownloadHelper, recyclerView));
    }
}
