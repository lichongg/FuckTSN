package com.kwad.components.ad.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadProgressView extends FrameLayout {
    private int MA;
    protected Drawable MC;
    protected Drawable MD;
    private String ME;
    protected TextView Mw;

    @ColorInt
    private int Mx;

    @ColorInt
    private int My;

    @ColorInt
    private int Mz;
    private final KsAppDownloadListener dW;
    protected TextProgressBar fR;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;

    public DownloadProgressView(@NonNull Context context) {
        this(context, null);
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_DownloadProgressView);
        this.Mx = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadTextColor, -117146);
        this.My = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadLeftTextColor, -1);
        this.Mz = obtainStyledAttributes.getColor(R.styleable.ksad_DownloadProgressView_ksad_downloadRightTextColor, -117146);
        this.MA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_DownloadProgressView_ksad_downloadTextSize, com.kwad.sdk.c.a.a.a(getContext(), 11.0f));
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_progressDrawable);
        this.MC = drawable;
        if (drawable == null) {
            nO();
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ksad_DownloadProgressView_ksad_backgroundDrawable);
        this.MD = drawable2;
        if (drawable2 == null) {
            nP();
        }
        String string = obtainStyledAttributes.getString(R.styleable.ksad_DownloadProgressView_ksad_downloadingFormat);
        this.ME = string;
        if (string == null) {
            this.ME = "下载中  %s%%";
        }
        obtainStyledAttributes.recycle();
    }

    public final void at(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo el = e.el(adTemplate);
        this.mAdInfo = el;
        this.Mw.setText(com.kwad.sdk.core.response.b.a.aE(el));
        this.fR.setVisibility(8);
        this.Mw.setVisibility(0);
    }

    public KsAppDownloadListener getAppDownloadListener() {
        return this.dW;
    }

    public DownloadProgressView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(m.wrapContextIfNeed(context), attributeSet, i6);
        this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.widget.DownloadProgressView.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.Mw.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
                DownloadProgressView.this.Mw.setVisibility(0);
                DownloadProgressView.this.fR.setVisibility(8);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DownloadProgressView.this.Mw.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.fR.e(com.kwad.sdk.core.response.b.a.cl(downloadProgressView.mAdTemplate), DownloadProgressView.this.fR.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.Mw.setText(com.kwad.sdk.core.response.b.a.aE(downloadProgressView.mAdInfo));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DownloadProgressView.this.Mw.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.fR.e(com.kwad.sdk.core.response.b.a.ac(downloadProgressView.mAdInfo), DownloadProgressView.this.fR.getMax());
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i7) {
                DownloadProgressView.this.Mw.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView.this.fR.e(com.kwad.sdk.core.response.b.a.IQ(), i7);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i7) {
                DownloadProgressView.this.Mw.setVisibility(8);
                DownloadProgressView.this.fR.setVisibility(0);
                DownloadProgressView downloadProgressView = DownloadProgressView.this;
                downloadProgressView.fR.e(com.kwad.sdk.core.response.b.a.t(i7, downloadProgressView.ME), i7);
            }
        };
        initAttrs(context, attributeSet);
        initView();
    }

    private void initView() {
        nN();
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_progress_bar);
        this.fR = textProgressBar;
        textProgressBar.setTextDimen(this.MA);
        this.fR.setTextColor(this.My, this.Mz);
        this.fR.setProgressDrawable(this.MC);
        TextView textView = (TextView) findViewById(R.id.ksad_normal_text);
        this.Mw = textView;
        textView.setTextColor(this.Mx);
        this.Mw.setTextSize(0, this.MA);
        this.Mw.setVisibility(0);
        this.Mw.setBackground(this.MD);
        findViewById(R.id.ksad_foreground_cover).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.widget.DownloadProgressView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadProgressView.this.performClick();
            }
        });
    }

    protected void nN() {
        m.inflate(getContext(), R.layout.ksad_download_progress_layout, this);
    }

    protected void nO() {
        this.MC = getResources().getDrawable(R.drawable.ksad_feed_download_progress);
    }

    protected void nP() {
        this.MD = getResources().getDrawable(R.drawable.ksad_feed_app_download_before_bg);
    }
}
