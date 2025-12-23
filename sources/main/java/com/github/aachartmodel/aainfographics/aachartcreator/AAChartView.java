package com.github.aachartmodel.aainfographics.aachartcreator;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAChart;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AAChartView extends WebView {
    private HashMap _$_findViewCache;

    @Nullable
    private AAChartViewCallBack callBack;

    @Nullable
    private Boolean chartSeriesHidden;

    @Nullable
    private Number contentHeight;

    @Nullable
    private Number contentWidth;

    @Nullable
    private Boolean isClearBackgroundColor;
    private String optionsJson;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface AAChartViewCallBack {
        void chartViewDidFinishLoad(@NotNull AAChartView aAChartView);

        void chartViewMoveOverEventMessage(@NotNull AAChartView aAChartView, @NotNull AAMoveOverEventMessageModel aAMoveOverEventMessageModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context) {
        super(context);
        g0.p(context, "context");
        setupBasicContent();
    }

    @JvmOverloads
    public final void aa_addPointToChartSeriesElement(int i6, @NotNull Object obj) {
        aa_addPointToChartSeriesElement$default(this, i6, obj, false, 4, null);
    }

    public final void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(@NotNull AASeriesElement[] seriesElementsArr) {
        g0.p(seriesElementsArr, "seriesElementsArr");
        aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(seriesElementsArr, true);
    }

    public static /* synthetic */ void aa_addPointToChartSeriesElement$default(AAChartView aAChartView, int i6, Object obj, boolean z5, int i7, Object obj2) {
        if ((i7 & 4) != 0) {
            z5 = true;
        }
        aAChartView.aa_addPointToChartSeriesElement(i6, obj, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureChartOptionsAndDrawChart(AAOptions aAOptions) {
        Boolean bool = this.isClearBackgroundColor;
        g0.m(bool);
        if (bool.booleanValue()) {
            AAChart chart = aAOptions.getChart();
            g0.m(chart);
            chart.backgroundColor("rgba(0,0,0,0)");
        }
        String json = new Gson().toJson(aAOptions);
        this.optionsJson = json;
        safeEvaluateJavaScriptString("loadTheHighChartView('" + json + "','" + this.contentWidth + "','" + this.contentHeight + "')");
    }

    private final AAMoveOverEventMessageModel getEventMessageModel(Map<String, ? extends Object> map) {
        AAMoveOverEventMessageModel aAMoveOverEventMessageModel = new AAMoveOverEventMessageModel();
        aAMoveOverEventMessageModel.setName(String.valueOf(map.get(CommonNetImpl.NAME)));
        aAMoveOverEventMessageModel.setX((Double) map.get("x"));
        aAMoveOverEventMessageModel.setY((Double) map.get("y"));
        aAMoveOverEventMessageModel.setCategory(String.valueOf(map.get("category")));
        aAMoveOverEventMessageModel.setOffset((LinkedTreeMap) map.get(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET));
        Double d6 = (Double) map.get("index");
        aAMoveOverEventMessageModel.setIndex(d6 != null ? Integer.valueOf((int) d6.doubleValue()) : null);
        return aAMoveOverEventMessageModel;
    }

    private final void loadLocalFilesAndDrawChart(final AAOptions aAOptions) {
        loadUrl("file:///android_asset/AAChartView.html");
        setWebViewClient(new WebViewClient() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$loadLocalFilesAndDrawChart$1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(@NotNull WebView view, @NotNull String url) {
                g0.p(view, "view");
                g0.p(url, "url");
                AAChartView.this.configureChartOptionsAndDrawChart(aAOptions);
                AAChartView.AAChartViewCallBack callBack = AAChartView.this.getCallBack();
                if (callBack != null) {
                    callBack.chartViewDidFinishLoad(AAChartView.this);
                }
            }
        });
    }

    private final void showJavaScriptAlertView() {
        setWebChromeClient(new WebChromeClient() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$showJavaScriptAlertView$1
            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(@NotNull WebView view, @NotNull String url, @NotNull String message, @NotNull JsResult result) {
                g0.p(view, "view");
                g0.p(url, "url");
                g0.p(message, "message");
                g0.p(result, "result");
                super.onJsAlert(view, url, message, result);
                new AlertDialog.Builder(AAChartView.this.getContext()).setTitle("JavaScript alert Information").setMessage(("url --->" + url + "\n\n\n") + ("message --->" + message + "\n\n\n") + ("result --->" + result)).setNeutralButton("sure", (DialogInterface.OnClickListener) null).show();
                return true;
            }
        });
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i6) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i6));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i6);
        this._$_findViewCache.put(Integer.valueOf(i6), findViewById);
        return findViewById;
    }

    public final void aa_addElementToChartSeries(@NotNull AASeriesElement aaSeriesElement) {
        g0.p(aaSeriesElement, "aaSeriesElement");
        safeEvaluateJavaScriptString("addElementToChartSeriesWithElement('" + new Gson().toJson(aaSeriesElement) + "')");
    }

    @JvmOverloads
    public final void aa_addPointToChartSeriesElement(int i6, @NotNull Object options, boolean z5) {
        g0.p(options, "options");
        aa_addPointToChartSeriesElement(i6, options, true, z5, true);
    }

    public final void aa_drawChartWithChartModel(@NotNull AAChartModel chartModel) {
        g0.p(chartModel, "chartModel");
        aa_drawChartWithChartOptions(AAChartModelKt.aa_toAAOptions(chartModel));
    }

    public final void aa_drawChartWithChartOptions(@NotNull AAOptions chartOptions) {
        g0.p(chartOptions, "chartOptions");
        if (this.optionsJson != null) {
            aa_refreshChartWithChartOptions(chartOptions);
        } else {
            loadLocalFilesAndDrawChart(chartOptions);
            showJavaScriptAlertView();
        }
    }

    public final void aa_evaluateTheJavaScriptStringFunction(@NotNull String jsFunctionStr) {
        g0.p(jsFunctionStr, "jsFunctionStr");
        safeEvaluateJavaScriptString("evaluateTheJavaScriptStringFunction('" + AAJSStringPurer.INSTANCE.pureJavaScriptFunctionString(jsFunctionStr) + "')");
    }

    public final void aa_hideTheSeriesElementContent(int i6) {
        safeEvaluateJavaScriptString("hideTheSeriesElementContentWithIndex('" + i6 + "')");
    }

    public final void aa_onlyRefreshTheChartDataWithChartOptionsSeriesArray(@NotNull AASeriesElement[] seriesElementsArr, boolean z5) {
        g0.p(seriesElementsArr, "seriesElementsArr");
        safeEvaluateJavaScriptString("onlyRefreshTheChartDataWithSeries('" + new Gson().toJson(seriesElementsArr) + "','" + z5 + "')");
    }

    public final void aa_refreshChartWithChartModel(@NotNull AAChartModel chartModel) {
        g0.p(chartModel, "chartModel");
        aa_refreshChartWithChartOptions(AAChartModelKt.aa_toAAOptions(chartModel));
    }

    public final void aa_refreshChartWithChartOptions(@NotNull AAOptions chartOptions) {
        g0.p(chartOptions, "chartOptions");
        configureChartOptionsAndDrawChart(chartOptions);
    }

    public final void aa_removeElementFromChartSeries(int i6) {
        safeEvaluateJavaScriptString("removeElementFromChartSeriesWithElementIndex('" + i6 + "')");
    }

    public final void aa_showTheSeriesElementContent(int i6) {
        safeEvaluateJavaScriptString("showTheSeriesElementContentWithIndex('" + i6 + "')");
    }

    public final void aa_updateChartWithOptions(@NotNull Object options, boolean z5) {
        String optionsStr;
        g0.p(options, "options");
        if (options instanceof AAOptions) {
            optionsStr = new Gson().toJson(options);
            g0.o(optionsStr, "aaOptionsMapStr");
        } else {
            String classNameStr = options.getClass().getSimpleName();
            g0.o(classNameStr, "classNameStr");
            String x22 = u.x2(classNameStr, "AA", "", false, 4, null);
            if (x22 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = x22.substring(0, 1);
            g0.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Locale locale = Locale.ROOT;
            g0.o(locale, "Locale.ROOT");
            if (substring == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = substring.toLowerCase(locale);
            g0.o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String substring2 = x22.substring(1);
            g0.o(substring2, "(this as java.lang.String).substring(startIndex)");
            String str = lowerCase + substring2;
            HashMap hashMap = new HashMap();
            hashMap.put(str, options);
            optionsStr = new Gson().toJson(hashMap);
            g0.o(optionsStr, "optionsStr");
        }
        safeEvaluateJavaScriptString("updateChart('" + optionsStr + "','" + z5 + "')");
    }

    @JavascriptInterface
    @NotNull
    public final String androidMethod(@Nullable String str) {
        Object fromJson = new Gson().fromJson(str, (Class<Object>) new HashMap().getClass());
        g0.o(fromJson, "Gson().fromJson(message, messageBody.javaClass)");
        AAMoveOverEventMessageModel eventMessageModel = getEventMessageModel((HashMap) fromJson);
        AAChartViewCallBack aAChartViewCallBack = this.callBack;
        if (aAChartViewCallBack == null) {
            return "";
        }
        aAChartViewCallBack.chartViewMoveOverEventMessage(this, eventMessageModel);
        return "";
    }

    @Nullable
    public final AAChartViewCallBack getCallBack() {
        return this.callBack;
    }

    @Nullable
    public final Boolean getChartSeriesHidden() {
        return this.chartSeriesHidden;
    }

    @Override // android.webkit.WebView
    @Nullable
    public final Number getContentHeight() {
        return this.contentHeight;
    }

    @Nullable
    public final Number getContentWidth() {
        return this.contentWidth;
    }

    @Nullable
    public final Boolean isClearBackgroundColor() {
        return this.isClearBackgroundColor;
    }

    public final void setCallBack(@Nullable AAChartViewCallBack aAChartViewCallBack) {
        this.callBack = aAChartViewCallBack;
    }

    public final void setChartSeriesHidden(@Nullable Boolean bool) {
        this.chartSeriesHidden = bool;
        safeEvaluateJavaScriptString("setChartSeriesHidden('" + this.chartSeriesHidden + "')");
    }

    public final void setClearBackgroundColor(@Nullable Boolean bool) {
        this.isClearBackgroundColor = bool;
        if (g0.g(bool, Boolean.TRUE)) {
            setBackgroundColor(0);
            Drawable background = getBackground();
            if (background != null) {
                background.setAlpha(0);
                return;
            }
            return;
        }
        setBackgroundColor(1);
        Drawable background2 = getBackground();
        if (background2 != null) {
            background2.setAlpha(255);
        }
    }

    public final void setContentHeight(@Nullable Number number) {
        this.contentHeight = number;
        safeEvaluateJavaScriptString("setTheChartViewContentHeight('" + this.contentHeight + "')");
    }

    public final void setContentWidth(@Nullable Number number) {
        this.contentWidth = number;
        safeEvaluateJavaScriptString("setTheChartViewContentWidth('" + this.contentWidth + "')");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g0.p(context, "context");
        setupBasicContent();
    }

    private final void safeEvaluateJavaScriptString(String str) {
        if (isInEditMode()) {
            return;
        }
        evaluateJavascript("javascript:" + str, new ValueCallback<String>() { // from class: com.github.aachartmodel.aainfographics.aachartcreator.AAChartView$safeEvaluateJavaScriptString$1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String str2) {
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void setupBasicContent() {
        if (isInEditMode()) {
            return;
        }
        setContentWidth(Float.valueOf(420.0f));
        setContentHeight(Float.valueOf(580.0f));
        setClearBackgroundColor(Boolean.FALSE);
        WebSettings settings = getSettings();
        g0.o(settings, "settings");
        settings.setJavaScriptEnabled(true);
        WebView.setWebContentsDebuggingEnabled(true);
        addJavascriptInterface(this, "androidObject");
    }

    public final void aa_addPointToChartSeriesElement(int i6, @NotNull Object options, boolean z5, boolean z6, boolean z7) {
        String obj;
        g0.p(options, "options");
        if (!(options instanceof Integer) && !(options instanceof Float) && !(options instanceof Double)) {
            obj = new Gson().toJson(options);
            g0.o(obj, "Gson().toJson(options)");
        } else {
            obj = options.toString();
        }
        safeEvaluateJavaScriptString("addPointToChartSeries('" + i6 + "','" + obj + "','" + z5 + "','" + z6 + "','" + z7 + "')");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AAChartView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        g0.p(context, "context");
        setupBasicContent();
    }
}
