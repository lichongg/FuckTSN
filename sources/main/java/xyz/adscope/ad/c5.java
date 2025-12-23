package xyz.adscope.ad;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.beizi.fusion.widget.ScrollClickView;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.a4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.LayoutModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.par.LayoutParamModel;
import xyz.adscope.common.v2.dev.info.ScreenUtil;
import xyz.adscope.common.v2.log.SDKLog;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class c5 implements a4 {

    /* renamed from: a, reason: collision with root package name */
    private final LayoutModel f54910a;

    /* renamed from: b, reason: collision with root package name */
    private final b5 f54911b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f54912c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, o2> f54913d;

    /* renamed from: e, reason: collision with root package name */
    private final String f54914e;

    /* renamed from: f, reason: collision with root package name */
    private int f54915f;

    /* renamed from: g, reason: collision with root package name */
    private int f54916g;

    /* renamed from: h, reason: collision with root package name */
    private int f54917h;

    /* renamed from: i, reason: collision with root package name */
    private int f54918i;

    /* renamed from: j, reason: collision with root package name */
    private int f54919j;

    /* renamed from: k, reason: collision with root package name */
    private int f54920k;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout.LayoutParams f54922m;

    /* renamed from: n, reason: collision with root package name */
    private int f54923n;

    /* renamed from: o, reason: collision with root package name */
    private int f54924o;

    /* renamed from: p, reason: collision with root package name */
    private int f54925p;

    /* renamed from: q, reason: collision with root package name */
    private int f54926q;

    /* renamed from: t, reason: collision with root package name */
    private a4.a f54929t;

    /* renamed from: l, reason: collision with root package name */
    private boolean f54921l = false;

    /* renamed from: r, reason: collision with root package name */
    private o2 f54927r = null;

    /* renamed from: s, reason: collision with root package name */
    private boolean f54928s = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f54930u = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        public static int a(Context context, TextView textView) {
            if (textView == null) {
                return 0;
            }
            int lineCount = textView.getLineCount() > 0 ? textView.getLineCount() : 1;
            float lineSpacingExtra = textView.getLineSpacingExtra();
            float lineSpacingMultiplier = textView.getLineSpacingMultiplier();
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            return ((fontMetricsInt.bottom - fontMetricsInt.top) * lineCount) + (ScreenUtil.Calculate.dip2px(context, lineSpacingExtra * lineSpacingMultiplier) * (lineCount >= 1 ? lineCount - 1 : 0));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.par.LayoutParamModel r18, java.lang.String r19, android.widget.RelativeLayout.LayoutParams r20) {
        /*
            Method dump skipped, instructions count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.c5.c(xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.par.LayoutParamModel, java.lang.String, android.widget.RelativeLayout$LayoutParams):void");
    }

    private int d(int i6) {
        if (!this.f54910a.k()) {
            return i6;
        }
        SDKLog.renderInfo("RenderParams", "当前节点, 高度自动调节, 需要根据最大, 最小值修正高度...");
        float parseSizePercent = StringUtil.modelSizeByPercent(this.f54910a.h()) ? this.f54919j * StringUtil.parseSizePercent(this.f54910a.h()) : StringUtil.parseFloat(this.f54910a.h());
        float parseSizePercent2 = StringUtil.modelSizeByPercent(this.f54910a.i()) ? this.f54919j * StringUtil.parseSizePercent(this.f54910a.i()) : StringUtil.parseFloat(this.f54910a.i());
        SDKLog.renderInfo("RenderParams", "当前节点, 高度自动调节, 最大高度: " + parseSizePercent + " 最小高度: " + parseSizePercent2 + " calculate " + i6);
        StringBuilder sb = new StringBuilder();
        sb.append("parent width ");
        sb.append(this.f54923n);
        sb.append(" parent height ");
        sb.append(this.f54924o);
        SDKLog.renderInfo("RenderParams", sb.toString());
        return i6 <= this.f54924o ? i6 : (parseSizePercent <= 0.0f || ((float) i6) <= parseSizePercent) ? (parseSizePercent2 <= 0.0f || ((float) i6) >= parseSizePercent2) ? i6 : (int) parseSizePercent2 : (int) parseSizePercent;
    }

    private boolean e(int i6) {
        return i6 <= 0;
    }

    @Override // xyz.adscope.ad.a4
    public int a() {
        if (!this.f54921l) {
            d();
        }
        return this.f54917h;
    }

    @Override // xyz.adscope.ad.a4
    public int b() {
        if (!this.f54921l) {
            d();
        }
        return this.f54919j;
    }

    private void j() {
        if (this.f54920k < 0) {
            this.f54920k = -2;
        }
    }

    private int k() {
        int i6;
        SDKLog.renderInfo("RenderParams", "尝试根据[素材]计算高度...");
        int i7 = 0;
        if (this.f54911b.b()) {
            int i8 = this.f54925p;
            if (i8 > 0 && (i6 = this.f54926q) > 0) {
                int d6 = d((int) (i6 * (this.f54919j / (i8 * 1.0f))));
                SDKLog.renderInfo("RenderParams", this.f54911b.e() + " 主要资源view计算..." + this.f54920k + " calculate " + d6);
                if (this.f54924o > 0 && this.f54910a.k()) {
                    SDKLog.renderInfo("RenderParams", "容器高度固定时, 计算缩小的尺寸..." + this.f54927r);
                    o2 o2Var = this.f54927r;
                    if (o2Var != null) {
                        int c6 = this.f54924o - o2Var.a().c();
                        if (c6 > 0) {
                            if (c6 < d6) {
                                i7 = c6;
                            }
                        }
                        SDKLog.renderInfo("RenderParams", this.f54911b.e() + " 高度根据素材计算 " + i7);
                        return i7;
                    }
                }
                i7 = d6;
                SDKLog.renderInfo("RenderParams", this.f54911b.e() + " 高度根据素材计算 " + i7);
                return i7;
            }
        } else {
            Object c7 = this.f54911b.c();
            if (c7 instanceof TextView) {
                return d(a.a(this.f54912c, (TextView) c7));
            }
        }
        return 0;
    }

    private int l() {
        SDKLog.renderInfo("RenderParams", this.f54911b.e() + " 开始根据[展开]计算...");
        this.f54930u = true;
        List<o2> g6 = this.f54911b.g();
        if (g6 != null && !g6.isEmpty()) {
            int size = g6.size();
            int[] iArr = new int[size];
            for (int i6 = 0; i6 < g6.size(); i6++) {
                iArr[i6] = g6.get(i6).a().c();
            }
            Arrays.sort(iArr);
            int i7 = iArr[size - 1];
            if (i7 > 0) {
                return i7;
            }
        }
        return 0;
    }

    @Override // xyz.adscope.ad.a4
    public RelativeLayout.LayoutParams e() {
        RelativeLayout.LayoutParams layoutParams = this.f54922m;
        layoutParams.width = this.f54919j;
        layoutParams.height = this.f54920k;
        layoutParams.topMargin = this.f54916g;
        layoutParams.rightMargin = this.f54918i;
        layoutParams.bottomMargin = this.f54915f;
        layoutParams.leftMargin = this.f54917h;
        if (SDKLog.isLogLevel(SDKLog.LOG_LEVEL.LOG_LEVEL_RENDER)) {
            SDKLog.renderInfo("RenderParams", this.f54911b.e() + "最后的计算结果: 宽: " + this.f54922m.width + " 高: " + this.f54922m.height + " 左边距: " + this.f54922m.leftMargin + " 上边距: " + this.f54922m.topMargin + " 右边距: " + this.f54922m.rightMargin + " 下边距: " + this.f54922m.bottomMargin);
        }
        return this.f54922m;
    }

    @Override // xyz.adscope.ad.a4
    public int f() {
        if (!this.f54921l) {
            d();
        }
        return this.f54916g;
    }

    @Override // xyz.adscope.ad.a4
    public int g() {
        if (!this.f54921l) {
            d();
        }
        return this.f54920k;
    }

    @Override // xyz.adscope.ad.a4
    public int h() {
        if (!this.f54921l) {
            d();
        }
        return this.f54918i;
    }

    @Override // xyz.adscope.ad.a4
    public int i() {
        if (!this.f54921l) {
            d();
        }
        return this.f54915f;
    }

    public c5(Context context, LayoutModel layoutModel, b5 b5Var, String str) {
        this.f54912c = context;
        this.f54910a = layoutModel;
        this.f54911b = b5Var;
        this.f54914e = str;
        this.f54913d = b5Var.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.par.LayoutParamModel r18, java.lang.String r19, android.widget.RelativeLayout.LayoutParams r20) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.c5.b(xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.layout.par.LayoutParamModel, java.lang.String, android.widget.RelativeLayout$LayoutParams):void");
    }

    @Override // xyz.adscope.ad.a4
    public void a(int i6) {
        LayoutModel layoutModel = this.f54910a;
        if (layoutModel != null) {
            a(layoutModel.g(), "top", this.f54922m, i6);
            a(this.f54910a.d(), "bottom", this.f54922m, i6);
        }
    }

    private void a(LayoutParamModel layoutParamModel, String str, RelativeLayout.LayoutParams layoutParams, int i6) {
        if (layoutParamModel != null) {
            String c6 = layoutParamModel.c();
            String b6 = layoutParamModel.b();
            String a6 = layoutParamModel.a();
            if (TextUtils.isEmpty(c6) || !StringUtil.modelSizeByPercent(c6)) {
                return;
            }
            float parseSizePercent = StringUtil.parseSizePercent(c6);
            if ("super".equalsIgnoreCase(b6) && str.equalsIgnoreCase(a6)) {
                int abs = (!StringUtil.modelSizeByPercent(c6) || i6 <= 0) ? 0 : (int) (Math.abs(parseSizePercent) * i6);
                if ("top".equalsIgnoreCase(str)) {
                    layoutParams.topMargin = abs;
                }
                if ("bottom".equalsIgnoreCase(str)) {
                    layoutParams.bottomMargin = abs;
                }
            }
        }
    }

    @Override // xyz.adscope.ad.a4
    public void d() {
        SDKLog.renderInfo("RenderParams", "--------------------Render Calculate------------------ " + this.f54911b.e());
        if (this.f54921l) {
            SDKLog.renderInfo("RenderParams", this.f54911b.e() + "已经计算过宽高...");
            return;
        }
        if (this.f54922m == null) {
            this.f54922m = new RelativeLayout.LayoutParams(-1, -2);
        }
        try {
            if (this.f54910a != null) {
                if (e(this.f54923n)) {
                    this.f54923n = ScreenUtil.getScreenWidth(this.f54912c);
                }
                SDKLog.renderInfo("RenderParams", this.f54911b.e() + "开始计算[横向margin]...");
                b(this.f54910a.f(), "right", this.f54922m);
                b(this.f54910a.e(), ScrollClickView.DIR_LEFT, this.f54922m);
                a(this.f54910a.a(), "x", this.f54922m);
                SDKLog.renderInfo("RenderParams", this.f54911b.e() + "开始计算[纵向margin]...");
                c(this.f54910a.g(), "top", this.f54922m);
                c(this.f54910a.d(), "bottom", this.f54922m);
                a(this.f54910a.b(), "y", this.f54922m);
                SDKLog.renderInfo("RenderParams", this.f54911b.e() + "开始计算自身[宽]...");
                b(this.f54910a.j());
                a("width");
                SDKLog.renderInfo("RenderParams", this.f54911b.e() + "开始计算自身[高]...");
                a(this.f54910a.c());
                a("height");
                this.f54921l = true;
                SDKLog.renderInfo("RenderParams", "--------------------Calculate Finished------------------ " + this.f54911b.e());
                a4.a aVar = this.f54929t;
                if (aVar != null) {
                    aVar.b(this.f54911b);
                }
                if (this.f54911b.f() > 0) {
                    List<o2> g6 = this.f54911b.g();
                    Collections.sort(g6, y4.a());
                    for (o2 o2Var : g6) {
                        o2Var.a().d();
                        if (this.f54930u) {
                            o2Var.a().a(this.f54922m.height);
                        }
                    }
                    return;
                }
                return;
            }
            throw new z4("LayoutModel is null");
        } catch (z4 e6) {
            this.f54921l = false;
            this.f54922m = null;
            SDKLog.renderError("RenderParams", " RenderException " + e6.getLocalizedMessage());
            SDKLog.stack(e6);
            a4.a aVar2 = this.f54929t;
            if (aVar2 != null) {
                aVar2.a(this.f54911b);
            }
        }
    }

    private void a(LayoutParamModel layoutParamModel, String str, RelativeLayout.LayoutParams layoutParams) {
        if (layoutParamModel != null) {
            if ("x".equals(str)) {
                layoutParams.addRule(14, -1);
            }
            if ("y".equals(str)) {
                layoutParams.addRule(15, -1);
                String b6 = layoutParamModel.b();
                if (TextUtils.isEmpty(b6) || this.f54913d.get(b6) == null) {
                    return;
                }
                layoutParams.addRule(4, StringUtil.parseInt(b6));
            }
        }
    }

    private void a(LayoutParamModel layoutParamModel) {
        try {
            this.f54920k = c(layoutParamModel);
        } catch (z4 unused) {
            this.f54920k = -2;
        }
        if (this.f54920k <= 0) {
            try {
                this.f54920k = k();
            } catch (z4 unused2) {
                this.f54920k = -2;
            }
        }
        if (this.f54920k <= 0) {
            a("temp");
            this.f54920k = l();
        }
        try {
            j();
            if (this.f54928s) {
                this.f54919j = (int) (StringUtil.parseSizePercent(this.f54910a.j().c()) * this.f54920k);
            }
            SDKLog.renderInfo("RenderParams", this.f54911b.e() + " calculate self height " + this.f54920k);
        } catch (z4 unused3) {
            this.f54920k = -2;
            throw new z4("高度无法修正...");
        }
    }

    @Override // xyz.adscope.ad.a4
    public void a(a4.a aVar) {
        this.f54929t = aVar;
        if (this.f54911b.f() > 0) {
            Iterator<o2> it = this.f54911b.g().iterator();
            while (it.hasNext()) {
                it.next().a().a(this.f54929t);
            }
        }
    }

    private void a(String str) {
        List<o2> g6 = this.f54911b.g();
        if (g6 == null || g6.isEmpty()) {
            return;
        }
        for (o2 o2Var : g6) {
            a4 a6 = o2Var.a();
            if ("height".equalsIgnoreCase(str)) {
                a6.c(this.f54920k);
            }
            if ("width".equalsIgnoreCase(str)) {
                a6.b(this.f54919j);
            }
            if ("temp".equalsIgnoreCase(str) && o2Var.b()) {
                a6.c(this.f54924o);
            }
            SDKLog.renderInfo("RenderParams", o2Var.e() + " 设置宽高 " + this.f54920k + " " + this.f54919j);
        }
    }

    private void b(LayoutParamModel layoutParamModel) {
        o2 o2Var;
        if (layoutParamModel != null) {
            String c6 = layoutParamModel.c();
            String b6 = layoutParamModel.b();
            String a6 = layoutParamModel.a();
            int i6 = -2;
            if (!TextUtils.isEmpty(c6)) {
                if (StringUtil.modelSizeByPercent(c6)) {
                    float parseSizePercent = StringUtil.parseSizePercent(c6);
                    if ("own".equalsIgnoreCase(b6)) {
                        if ("height".equalsIgnoreCase(a6)) {
                            int i7 = this.f54920k;
                            if (i7 > 0) {
                                i6 = (int) (i7 * Math.abs(parseSizePercent));
                                SDKLog.renderInfo("RenderParams", "宽度根据[定高] * 百分比计算 " + parseSizePercent + " : " + i6);
                            } else {
                                SDKLog.renderError("RenderParams", "宽度根据[高]计算, 但高度不定...");
                                this.f54928s = true;
                            }
                        }
                    } else if ("super".equalsIgnoreCase(b6)) {
                        float abs = Math.abs(parseSizePercent);
                        int i8 = this.f54923n;
                        int i9 = (int) (abs * i8);
                        int i10 = this.f54917h;
                        int i11 = this.f54918i;
                        i6 = (i9 + i10) + i11 > i8 ? (i8 - i10) - i11 : i9;
                        SDKLog.renderInfo("RenderParams", "宽度根据父布局 * 百分比计算 " + parseSizePercent + " : " + i6);
                        int b7 = b(a6);
                        if (b7 > 0) {
                            i6 = (int) (parseSizePercent * b7);
                        }
                    } else {
                        Map<String, o2> map = this.f54913d;
                        if (map != null && map.get(b6) != null && (o2Var = this.f54913d.get(b6)) != null) {
                            if ("width".equalsIgnoreCase(a6)) {
                                i6 = (int) (o2Var.a().b() * Math.abs(parseSizePercent));
                                SDKLog.renderInfo("RenderParams", "宽度根据其他view的[宽]计算 " + i6);
                            }
                            if ("height".equalsIgnoreCase(a6)) {
                                i6 = (int) (o2Var.a().g() * Math.abs(parseSizePercent));
                                SDKLog.renderInfo("RenderParams", "宽度根据其他view的[高]计算 " + i6);
                            }
                        }
                    }
                } else {
                    i6 = ScreenUtil.Calculate.dip2px(this.f54912c, StringUtil.parseInt(c6));
                    SDKLog.renderInfo("RenderParams", "宽度根据model固定值计算 " + i6);
                }
            }
            this.f54919j = i6;
            return;
        }
        this.f54919j = (this.f54923n - this.f54917h) - this.f54918i;
    }

    private int c(LayoutParamModel layoutParamModel) {
        int dip2px;
        o2 o2Var;
        SDKLog.renderInfo("RenderParams", "尝试根据[model]计算高度...");
        if (layoutParamModel != null) {
            String c6 = layoutParamModel.c();
            String b6 = layoutParamModel.b();
            String a6 = layoutParamModel.a();
            if (!TextUtils.isEmpty(c6)) {
                if (StringUtil.modelSizeByPercent(c6)) {
                    float parseSizePercent = StringUtil.parseSizePercent(c6);
                    dip2px = 0;
                    if ("own".equalsIgnoreCase(b6)) {
                        if ("width".equalsIgnoreCase(a6)) {
                            if (!this.f54928s) {
                                dip2px = (int) (Math.abs(parseSizePercent) * this.f54919j);
                                SDKLog.renderInfo("RenderParams", "高度根据[宽] * 百分比计算 " + Math.abs(parseSizePercent) + " : " + dip2px);
                            } else {
                                throw new z4("宽高相互依赖自身值...");
                            }
                        }
                    } else if ("super".equalsIgnoreCase(b6)) {
                        if (this.f54924o > 0) {
                            int abs = (int) (Math.abs(parseSizePercent) * this.f54924o);
                            int i6 = this.f54916g;
                            int i7 = this.f54915f;
                            int i8 = abs + i6 + i7;
                            int i9 = this.f54923n;
                            dip2px = i8 > i9 ? (i9 - i6) - i7 : abs;
                            SDKLog.renderInfo("RenderParams", "高度根据父布局[定高] * 百分比计算 " + Math.abs(parseSizePercent) + " : " + dip2px);
                        }
                        int b7 = b(a6);
                        if (b7 > 0) {
                            dip2px = (int) (parseSizePercent * b7);
                        }
                    } else {
                        Map<String, o2> map = this.f54913d;
                        if (map != null && map.get(b6) != null && (o2Var = this.f54913d.get(b6)) != null) {
                            if ("width".equalsIgnoreCase(a6)) {
                                dip2px = (int) (o2Var.a().b() * Math.abs(parseSizePercent));
                                SDKLog.renderInfo("RenderParams", "高度根据其他view[宽] * 百分比计算 " + Math.abs(parseSizePercent) + " : " + dip2px);
                            }
                            if ("height".equalsIgnoreCase(a6)) {
                                dip2px = (int) (o2Var.a().g() * Math.abs(parseSizePercent));
                                SDKLog.renderInfo("RenderParams", "高度根据其他view[高] * 百分比计算 " + Math.abs(parseSizePercent) + " : " + dip2px);
                            }
                        }
                    }
                } else {
                    dip2px = ScreenUtil.Calculate.dip2px(this.f54912c, StringUtil.parseInt(c6));
                    SDKLog.renderInfo("RenderParams", "高度根据model固定值计算 " + dip2px);
                }
                SDKLog.renderInfo("RenderParams", this.f54911b.e() + " 高度根据model计算 " + dip2px);
                return dip2px;
            }
        }
        throw new z4("height结构为空...");
    }

    @Override // xyz.adscope.ad.a4
    public void a(String str, String str2) {
        this.f54925p = StringUtil.parseInt(str);
        this.f54926q = StringUtil.parseInt(str2);
    }

    private int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        str.getClass();
        switch (str) {
            case "bottom":
                return this.f54915f;
            case "top":
                return this.f54916g;
            case "left":
                return this.f54917h;
            case "right":
                return this.f54918i;
            default:
                return 0;
        }
    }

    @Override // xyz.adscope.ad.a4
    public void c(int i6) {
        this.f54924o = i6;
    }

    @Override // xyz.adscope.ad.a4
    public int c() {
        if (!this.f54921l) {
            d();
        }
        int i6 = this.f54915f + this.f54916g + this.f54920k;
        o2 o2Var = this.f54927r;
        return o2Var != null ? i6 + o2Var.a().c() : i6;
    }

    @Override // xyz.adscope.ad.a4
    public void b(int i6) {
        this.f54923n = i6;
    }
}
