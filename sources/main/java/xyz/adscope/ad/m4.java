package xyz.adscope.ad;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.ad.nativead.render.view.asnp.prefab.a;
import xyz.adscope.ad.b4;
import xyz.adscope.ad.l6;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.BidModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.permission.PermissionModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.link.LinkModel;
import xyz.adscope.ad.publish.ad.unified.ASNPUnifiedPattern;
import xyz.adscope.ad.publish.ad.unified.IUnifiedAdBindListener;
import xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo;
import xyz.adscope.ad.publish.ad.unified.IUnifiedMediaController;
import xyz.adscope.ad.publish.ad.unified.UnifiedMediaConfig;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedExpressContainer;
import xyz.adscope.ad.publish.ad.unified.view.ASNPUnifiedMediaView;
import xyz.adscope.ad.w3;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.v2.dev.info.ResIdentify;
import xyz.adscope.common.v2.tool.collection.CollectionFetch;
import xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class m4 extends n0 implements h3 {
    private Map<String, List<String>> A;
    private IUnifiedAdBindListener B;

    /* renamed from: s, reason: collision with root package name */
    private final String f55407s;

    /* renamed from: t, reason: collision with root package name */
    private final String f55408t;

    /* renamed from: u, reason: collision with root package name */
    private final String f55409u;

    /* renamed from: v, reason: collision with root package name */
    private final String f55410v;

    /* renamed from: w, reason: collision with root package name */
    private final String f55411w;

    /* renamed from: x, reason: collision with root package name */
    private final String f55412x;

    /* renamed from: y, reason: collision with root package name */
    private final String f55413y;

    /* renamed from: z, reason: collision with root package name */
    private ASNPUnifiedExpressContainer f55414z;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ICollectionFetchCompare<AssetModel, Object> {
        a() {
        }

        @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(AssetModel assetModel, Object obj) {
            if (assetModel.d() != null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements IUnifiedDownloadInfo.IPermissionInfo {

        /* renamed from: a, reason: collision with root package name */
        private final PermissionModel f55416a;

        /* synthetic */ b(PermissionModel permissionModel, a aVar) {
            this(permissionModel);
        }

        private b(PermissionModel permissionModel) {
            this.f55416a = permissionModel;
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo.IPermissionInfo
        public String getDescribe() {
            return this.f55416a.a();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo.IPermissionInfo
        public String getPermissionType() {
            return this.f55416a.b();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo.IPermissionInfo
        public String getTitle() {
            return this.f55416a.c();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c implements z3 {
        private c() {
        }

        @Override // xyz.adscope.ad.z3
        public void a() {
        }

        /* synthetic */ c(m4 m4Var, a aVar) {
            this();
        }

        @Override // xyz.adscope.ad.m2
        public void a(y3 y3Var) {
        }

        @Override // xyz.adscope.ad.z3
        public void a(o2 o2Var) {
            b4 c6 = o2Var.c();
            if (c6 instanceof j3) {
                j3 j3Var = (j3) c6;
                i3 a6 = m4.this.a(o2Var.c(), j3Var.getInteractionType(), j3Var.getActionType());
                if (a6 != null) {
                    j3Var.a(a6);
                }
            }
        }

        @Override // xyz.adscope.ad.z3
        public void renderFailed() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d implements IUnifiedDownloadInfo {

        /* renamed from: a, reason: collision with root package name */
        private final DownloadInfoModel f55418a;

        /* synthetic */ d(DownloadInfoModel downloadInfoModel, a aVar) {
            this(downloadInfoModel);
        }

        private d(DownloadInfoModel downloadInfoModel) {
            this.f55418a = downloadInfoModel;
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getApkMD5() {
            return this.f55418a.a();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getAppIntroduction() {
            return this.f55418a.b();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getDeveloper() {
            return this.f55418a.d();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getIconUrl() {
            return this.f55418a.e();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getName() {
            return this.f55418a.f();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getPackageName() {
            return this.f55418a.c();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public List<IUnifiedDownloadInfo.IPermissionInfo> getPermission() {
            a aVar = null;
            if (this.f55418a.g() == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<PermissionModel> it = this.f55418a.g().iterator();
            while (it.hasNext()) {
                arrayList.add(new b(it.next(), aVar));
            }
            return arrayList;
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getPermissionUrl() {
            return this.f55418a.h();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getPolicy() {
            return this.f55418a.i();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getPolicyUrl() {
            return this.f55418a.j();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getSize() {
            return this.f55418a.k();
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedDownloadInfo
        public String getVersion() {
            return this.f55418a.l();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e implements IUnifiedMediaController {

        /* renamed from: a, reason: collision with root package name */
        private l6.f f55419a;

        /* synthetic */ e(Object obj, a aVar) {
            this(obj);
        }

        private e(Object obj) {
            if (obj instanceof l6.f) {
                this.f55419a = (l6.f) obj;
            }
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedMediaController
        public void pauseVideo() {
            l6.f fVar = this.f55419a;
            if (fVar != null) {
                fVar.a();
            }
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedMediaController
        public void playVideo() {
            l6.f fVar = this.f55419a;
            if (fVar != null) {
                fVar.b();
            }
        }

        @Override // xyz.adscope.ad.publish.ad.unified.IUnifiedMediaController
        public void setVideoSound(boolean z5) {
            l6.f fVar = this.f55419a;
            if (fVar != null) {
                fVar.a(z5);
            }
        }
    }

    private void a(View view, String[] strArr) {
        view.setTag(ResIdentify.getIDIdentify(this.f55660a, "scope_root_container"), this.f55414z);
        view.setTag(ResIdentify.getIDIdentify(this.f55660a, "scope_unified_negative"), strArr);
        a(view, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, "complain").a((i3) null);
    }

    private void b(View view) {
        view.setTag(ResIdentify.getIDIdentify(this.f55660a, "scope_root_container"), this.f55414z);
        a(view, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK).a((i3) null);
    }

    private void c(View view) {
        if (this.f55414z == null) {
            f();
        } else {
            view.setTag(ResIdentify.getIDIdentify(this.f55660a, "scope_root_container"), this.f55414z);
            a(view, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK, AMPSConstants.FrequencyEventType.FREQUENCY_EVENT_TYPE_CLICK).a((i3) null);
        }
    }

    private boolean d(View view) {
        while (view != null) {
            if (view instanceof ASNPUnifiedExpressContainer) {
                return true;
            }
            view = (View) view.getParent();
        }
        return false;
    }

    private void f() {
        IUnifiedAdBindListener iUnifiedAdBindListener = this.B;
        if (iUnifiedAdBindListener != null) {
            iUnifiedAdBindListener.onAdBindError();
        }
    }

    private List<AssetModel> g() {
        NativeModel b6 = b(this.f55661b);
        if (b6 != null) {
            return b6.a();
        }
        return null;
    }

    private List<String> h() {
        Map<String, List<String>> map = this.A;
        return map != null ? map.get(SocializeProtocolConstants.IMAGE) : Collections.EMPTY_LIST;
    }

    private void k() {
        w3 a6 = w3.a.a(this.f55660a, this.f55662c);
        a6.a(this.f55661b.d());
        if (a6 instanceof k2) {
            k2 k2Var = (k2) a6;
            if (k2Var.c() != null) {
                k2Var.c().a(new c(this, null));
            }
        }
        if (a6 instanceof j6) {
            ((j6) a6).a(this.f55414z);
        }
        a6.b();
    }

    @Override // xyz.adscope.ad.h3
    public void bindAdToMediaView(Activity activity, ASNPUnifiedMediaView aSNPUnifiedMediaView) {
        if (aSNPUnifiedMediaView == null) {
            f();
            return;
        }
        if (!d(aSNPUnifiedMediaView)) {
            f();
            return;
        }
        Object tag = aSNPUnifiedMediaView.getTag(ResIdentify.getIDIdentify(activity, "scope_unified_media_config"));
        l6 l6Var = new l6(activity);
        if (tag instanceof UnifiedMediaConfig) {
            l6Var.setVideoConfig((UnifiedMediaConfig) tag);
        } else {
            l6Var.setVideoConfig(new UnifiedMediaConfig.Builder().build());
        }
        l6Var.setExpressRoot(this.f55414z);
        l6Var.a(e());
        l6Var.a(i());
        l6Var.a((b4.a) null);
        aSNPUnifiedMediaView.setTag(ResIdentify.getIDIdentify(activity, "scope_unified_media_ctrl"), new e(l6Var.getVideoController(), null));
        aSNPUnifiedMediaView.addView(l6Var, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // xyz.adscope.ad.h3
    public void bindAdToRootContainer(Activity activity, ASNPUnifiedExpressContainer aSNPUnifiedExpressContainer, List<View> list) {
        this.f55414z = aSNPUnifiedExpressContainer;
        a.c.a(aSNPUnifiedExpressContainer, c(this.f55661b), d(), e());
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        k();
    }

    @Override // xyz.adscope.ad.h3
    public String getActionButtonText() {
        return a("actionText");
    }

    @Override // xyz.adscope.ad.h3
    public String getAdLogoUrl() {
        return a("adLogo");
    }

    @Override // xyz.adscope.ad.h3
    public String getDesc() {
        return a("desc");
    }

    @Override // xyz.adscope.ad.h3
    public IUnifiedDownloadInfo getDownloadInfo() {
        NativeModel b6 = b(this.f55661b);
        a aVar = null;
        if (b6 != null) {
            return new d(b6.b(), aVar);
        }
        return null;
    }

    @Override // xyz.adscope.ad.r2
    public View getExpressView() {
        return this.f55414z;
    }

    @Override // xyz.adscope.ad.h3
    public String getIconUrl() {
        return a("icon");
    }

    @Override // xyz.adscope.ad.h3
    public String getMainImageUrl() {
        return a(SocializeProtocolConstants.IMAGE);
    }

    @Override // xyz.adscope.ad.h3
    public String getTitle() {
        return a("title");
    }

    @Override // xyz.adscope.ad.h3
    public boolean isDownloadAd() {
        LinkModel c6;
        NativeModel b6 = b(this.f55661b);
        return (b6 == null || (c6 = b6.c()) == null || 1 != c6.c()) ? false : true;
    }

    @Override // xyz.adscope.ad.h3
    public void setBindAdListener(IUnifiedAdBindListener iUnifiedAdBindListener) {
        this.B = iUnifiedAdBindListener;
    }

    protected m4(Context context, BidModel bidModel, a2 a2Var, b1 b1Var) {
        super(context, bidModel, a2Var, b1Var);
        this.f55407s = "title";
        this.f55408t = "desc";
        this.f55409u = SocializeProtocolConstants.IMAGE;
        this.f55410v = "icon";
        this.f55411w = "video";
        this.f55412x = "actionText";
        this.f55413y = "adLogo";
        j();
    }

    private AssetModel i() {
        return (AssetModel) CollectionFetch.fetchFirstFromList(g(), null, new a());
    }

    private void j() {
        List<AssetModel> g6 = g();
        if (g6 != null) {
            this.A = new HashMap();
            for (AssetModel assetModel : g6) {
                String trim = assetModel.a().trim();
                if (!TextUtils.isEmpty(trim)) {
                    switch (trim.charAt(0)) {
                        case '1':
                            if (assetModel.b() != null) {
                                Map<String, List<String>> map = this.A;
                                map.put(SocializeProtocolConstants.IMAGE, a(map.get(SocializeProtocolConstants.IMAGE), assetModel.b().c()));
                                break;
                            } else {
                                break;
                            }
                        case '2':
                            if (assetModel.d() != null) {
                                Map<String, List<String>> map2 = this.A;
                                map2.put("video", a(map2.get("video"), assetModel.d().d()));
                                break;
                            } else {
                                break;
                            }
                        case '3':
                            if (assetModel.c() != null) {
                                Map<String, List<String>> map3 = this.A;
                                map3.put("title", a(map3.get("title"), assetModel.c().a()));
                                break;
                            } else {
                                break;
                            }
                        case '4':
                            if (assetModel.c() != null) {
                                Map<String, List<String>> map4 = this.A;
                                map4.put("desc", a(map4.get("desc"), assetModel.c().a()));
                                break;
                            } else {
                                break;
                            }
                        case '5':
                            if (assetModel.b() != null) {
                                Map<String, List<String>> map5 = this.A;
                                map5.put("icon", a(map5.get("icon"), assetModel.b().c()));
                                break;
                            } else {
                                break;
                            }
                        case '6':
                            if (assetModel.c() != null) {
                                Map<String, List<String>> map6 = this.A;
                                map6.put("actionText", a(map6.get("actionText"), assetModel.c().a()));
                                break;
                            } else {
                                break;
                            }
                        case '7':
                            if (assetModel.b() != null) {
                                Map<String, List<String>> map7 = this.A;
                                map7.put("adLogo", a(map7.get("adLogo"), assetModel.b().c()));
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        }
    }

    @Override // xyz.adscope.ad.h3
    public void bindAdActionView(List<View> list) {
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    @Override // xyz.adscope.ad.h3
    public void bindNegativeFeedbackView(View view, String[] strArr) {
        a(view, strArr);
    }

    @Override // xyz.adscope.ad.h3
    public ASNPUnifiedPattern getAdPattern() {
        if (getImagesUrl() != null && !getImagesUrl().isEmpty()) {
            return ASNPUnifiedPattern.PATTERN_3_IMAGES;
        }
        if (i() != null) {
            return ASNPUnifiedPattern.PATTERN_VIDEO;
        }
        return ASNPUnifiedPattern.PATTERN_TEXT_IMAGE;
    }

    @Override // xyz.adscope.ad.h3
    public List<String> getImagesUrl() {
        return h();
    }

    private String a(String str) {
        List<String> list;
        Map<String, List<String>> map = this.A;
        if (map != null && (list = map.get(str)) != null && !list.isEmpty()) {
            return list.get(0);
        }
        return "";
    }

    private List<String> a(List<String> list, String str) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(str);
        return list;
    }
}
