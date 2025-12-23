package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bg;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: D:\Downloads\app\classes6.dex */
public class ComplianceTextView extends TextView {
    private String aij;
    private String aik;
    private String ail;
    private String aim;
    private String ain;
    private String aio;
    private String aip;
    private int aiq;
    private AdTemplate mAdTemplate;

    @ColorInt
    private int textColor;

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            spannableStringBuilder.append((CharSequence) " | 版本 ").append((CharSequence) str4);
        }
        if (!TextUtils.isEmpty(this.aio)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str5);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0627a().az("功能介绍").aA(ComplianceTextView.this.aio).aF(true).aD(ComplianceTextView.this.mAdTemplate).qW());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.ain)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0627a().az("权限信息").aA(ComplianceTextView.this.ain).aF(true).aD(ComplianceTextView.this.mAdTemplate).qW());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.aip)) {
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str7);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.4
                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0627a().az("隐私政策").aA(ComplianceTextView.this.aip).aF(true).aD(ComplianceTextView.this.mAdTemplate).qW());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length3, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.aiq = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, 154);
        int color = obtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, Color.parseColor("#99FFFFFF"));
        this.textColor = color;
        setTextColor(color);
        if (aq.isOrientationPortrait()) {
            setBackgroundColor(0);
        } else {
            setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        final AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        this.aik = "功能";
        this.ail = "权限";
        this.aim = "隐私";
        AdInfo.DownloadSafeInfo downloadSafeInfo = el.downloadSafeInfo;
        this.ain = downloadSafeInfo.appPermissionInfoUrl;
        this.aip = downloadSafeInfo.appPrivacyUrl;
        this.aio = downloadSafeInfo.introductionInfoUrl;
        if (this.aiq > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            if (aq.QW()) {
                layoutParams.width = -1;
            } else {
                layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), this.aiq);
            }
            setLayoutParams(layoutParams);
        }
        post(new bg() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                AdInfo.DownloadSafeInfo downloadSafeInfo2 = el.downloadSafeInfo;
                complianceTextView.a(downloadSafeInfo2.appName, TextUtils.isEmpty(downloadSafeInfo2.corporationName) ? "" : el.downloadSafeInfo.corporationName, TextUtils.isEmpty(el.downloadSafeInfo.recordNumber) ? "" : el.downloadSafeInfo.recordNumber, el.downloadSafeInfo.appVersion, ComplianceTextView.this.aik, ComplianceTextView.this.ail, ComplianceTextView.this.aim);
            }
        });
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.aij = "...\n";
        this.aiq = 154;
        init(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int width;
        boolean z5;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        getContext();
        if (!aq.QW()) {
            width = (this.aiq - getPaddingLeft()) - getPaddingRight();
            z5 = true;
        } else {
            width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            z5 = false;
        }
        if (width < 0) {
            return;
        }
        if (!z5 && !TextUtils.isEmpty(str2)) {
            Paint paint = new Paint();
            paint.setTextSize(getTextSize());
            float measureText = width - paint.measureText(str);
            StringBuilder sb = new StringBuilder();
            sb.append(" ");
            sb.append(str2);
            if (paint.measureText(sb.toString()) > measureText && measureText > 0.0f) {
                while (str2.length() > 1) {
                    str2 = str2.substring(0, str2.length() - 1);
                    sb.setLength(0);
                    sb.append(" ");
                    sb.append(str2);
                    sb.append(this.aij);
                    if (paint.measureText(sb.toString()) <= measureText) {
                        break;
                    }
                }
            } else {
                this.aij = "";
            }
        } else {
            this.aij = "";
        }
        b(str, str2 + this.aij, str3, str4, str5, str6, str7);
        requestLayout();
    }
}
