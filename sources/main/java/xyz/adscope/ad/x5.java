package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel;
import xyz.adscope.common.v2.image.loader.IImageFillResult;
import xyz.adscope.common.v2.image.loader.ImageLoader;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class x5 extends xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.b implements b4 {

    /* renamed from: g, reason: collision with root package name */
    private String f56127g;

    /* renamed from: h, reason: collision with root package name */
    protected RenderModel f56128h;

    /* renamed from: i, reason: collision with root package name */
    protected AssetModel f56129i;

    /* renamed from: j, reason: collision with root package name */
    private xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a f56130j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements IImageFillResult {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b4.a f56131a;

        a(b4.a aVar) {
            this.f56131a = aVar;
        }

        @Override // xyz.adscope.common.v2.image.loader.IImageFillResult
        public void onImageLoadFailed() {
            b4.a aVar = this.f56131a;
            if (aVar != null) {
                aVar.a(x5.this.f56128h.a());
            }
        }

        @Override // xyz.adscope.common.v2.image.loader.IImageFillResult
        public void onImageLoaded() {
            b4.a aVar = this.f56131a;
            if (aVar != null) {
                aVar.b(x5.this.f56128h.a());
            }
        }
    }

    @Override // xyz.adscope.ad.b4
    public void a() {
    }

    @Override // xyz.adscope.ad.b4
    public void a(RenderModel renderModel) {
        this.f56128h = renderModel;
        ViewModel f6 = renderModel.f();
        if (f6 != null) {
            setBorderColor(f6.d());
            setRectRadius(StringUtil.parseFloat(f6.e()));
            setBorderWidth(StringUtil.parseInt(f6.f()));
        }
    }

    @Override // xyz.adscope.ad.b4
    public xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a getExpressRoot() {
        return this.f56130j;
    }

    @Override // xyz.adscope.ad.b4
    public int getLayer() {
        return this.f56128h.c();
    }

    @Override // xyz.adscope.ad.b4
    public String getScopeViewID() {
        return this.f56127g;
    }

    @Override // xyz.adscope.ad.b4
    public void setExpressRoot(xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a aVar) {
        this.f56130j = aVar;
    }

    @Override // xyz.adscope.ad.b4
    public void setScopeViewID(String str) {
        this.f56127g = str;
        setId(StringUtil.parseInt(str));
    }

    public x5(@NonNull Context context) {
        super(context);
    }

    @Override // xyz.adscope.ad.b4
    public void a(AssetModel assetModel) {
        this.f56129i = assetModel;
    }

    public void a(b4.a aVar) {
        String j6;
        ViewModel f6 = this.f56128h.f();
        if (f6 == null) {
            if (aVar != null) {
                aVar.a(this.f56128h.a());
                return;
            }
            return;
        }
        AssetModel assetModel = this.f56129i;
        if (assetModel != null && assetModel.b() != null) {
            j6 = this.f56129i.b().c();
        } else {
            j6 = f6.j();
        }
        if (!TextUtils.isEmpty(j6)) {
            ImageLoader.getInstance().loadMainImage(this, j6, f6.r(), new a(aVar));
        } else if (TextUtils.isEmpty(f6.b())) {
            if (aVar != null) {
                aVar.b(this.f56128h.a());
            }
        } else if (aVar != null) {
            aVar.a(this.f56128h.a());
        }
    }

    @Override // xyz.adscope.ad.b4
    public void b() {
    }

    @Override // xyz.adscope.ad.b4
    public void c() {
    }
}
