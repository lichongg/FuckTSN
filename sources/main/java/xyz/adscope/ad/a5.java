package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.List;
import java.util.Map;
import xyz.adscope.ad.h2;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.ext.DisplayExtModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel;
import xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare;
import xyz.adscope.common.v2.tool.json.JsonUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class a5 implements h2 {

    /* renamed from: a, reason: collision with root package name */
    private final h2.a f54791a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayModel f54792b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f54793c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, o2> f54794d;

    /* renamed from: e, reason: collision with root package name */
    private o2 f54795e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f54796f = false;

    /* renamed from: g, reason: collision with root package name */
    private String f54797g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ICollectionFetchCompare<AssetModel, String> {
        a() {
        }

        @Override // xyz.adscope.common.v2.tool.collection.ICollectionFetchCompare
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean fetch(AssetModel assetModel, String str) {
            if (assetModel == null) {
                return false;
            }
            String a6 = assetModel.a();
            if (TextUtils.isEmpty(a6)) {
                return false;
            }
            return a6.equals(str);
        }
    }

    @Override // xyz.adscope.ad.h2
    public void a() {
    }

    private void a(boolean z5) {
        h2.a aVar;
        this.f54794d = new ArrayMap();
        NativeModel d6 = this.f54792b.d();
        if (d6 != null) {
            this.f54797g = JsonUtil.getJSONArrayStr(d6.toJsonString(), "scheme");
            List<RenderModel> e6 = z5 ? d6.e() : null;
            if ((e6 == null || e6.isEmpty()) && (aVar = this.f54791a) != null) {
                e6 = aVar.a(d6.f());
            }
            a(this.f54793c, e6, d6.a(), d6.c() != null && d6.c().c() == 1, d6.b());
        }
    }

    @Override // xyz.adscope.ad.h2
    public void b() {
        if (this.f54791a != null) {
            a(false);
        } else {
            this.f54796f = false;
        }
    }

    @Override // xyz.adscope.ad.h2
    public boolean c() {
        return this.f54796f;
    }

    @Override // xyz.adscope.ad.h2
    public int d() {
        return this.f54794d.size();
    }

    @Override // xyz.adscope.ad.h2
    public o2 e() {
        return this.f54795e;
    }

    @Override // xyz.adscope.ad.h2
    public String f() {
        return this.f54797g;
    }

    a5(Context context, DisplayModel displayModel, h2.a aVar) {
        this.f54793c = context;
        this.f54792b = displayModel;
        this.f54791a = aVar;
        a(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r13, java.util.List<xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel> r14, java.util.List<xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel> r15, boolean r16, xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel r17) {
        /*
            r12 = this;
            r0 = 0
            if (r14 == 0) goto Lec
            boolean r1 = r14.isEmpty()
            if (r1 != 0) goto Lec
            java.util.Comparator r1 = xyz.adscope.ad.y4.b()
            java.util.Collections.sort(r14, r1)
            r1 = 0
        L11:
            int r2 = r14.size()
            r3 = 1
            if (r1 >= r2) goto Le9
            java.lang.Object r2 = r14.get(r1)
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel r2 = (xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel) r2
            if (r2 == 0) goto Le1
            java.lang.String r4 = r2.a()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto Le1
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel r4 = r2.f()
            java.lang.String r5 = ""
            if (r4 == 0) goto L3b
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel r4 = r2.f()
            java.lang.String r4 = r4.h()
            goto L3c
        L3b:
            r4 = r5
        L3c:
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.InteractionModel r6 = r2.b()
            if (r6 == 0) goto L4a
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.interaction.InteractionModel r5 = r2.b()
            java.lang.String r5 = r5.a()
        L4a:
            xyz.adscope.ad.b4 r5 = xyz.adscope.ad.m6.a(r13, r4, r5)
            boolean r6 = r5 instanceof xyz.adscope.ad.c4
            if (r6 == 0) goto L5b
            r6 = r5
            xyz.adscope.ad.c4 r6 = (xyz.adscope.ad.c4) r6
            r7 = r16
            r6.setRenderWithDownload(r7)
            goto L5d
        L5b:
            r7 = r16
        L5d:
            xyz.adscope.ad.b5 r6 = new xyz.adscope.ad.b5
            java.util.Map<java.lang.String, xyz.adscope.ad.o2> r8 = r12.f54794d
            r6.<init>(r5, r2, r8)
            java.lang.String r8 = r2.e()
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L9d
            java.util.Map<java.lang.String, xyz.adscope.ad.o2> r9 = r12.f54794d
            boolean r9 = r9.containsKey(r8)
            if (r9 == 0) goto L9d
            java.util.Map<java.lang.String, xyz.adscope.ad.o2> r9 = r12.f54794d
            java.lang.Object r9 = r9.get(r8)
            xyz.adscope.ad.o2 r9 = (xyz.adscope.ad.o2) r9
            if (r9 == 0) goto L9f
            java.lang.String r10 = r2.a()
            r11 = 2
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r11[r0] = r10
            r11[r3] = r8
            java.lang.String r3 = "当前model (%s) 的 父节点 (%s) 存在. 设置父子节点关系..."
            java.lang.String r3 = java.lang.String.format(r3, r11)
            java.lang.String r8 = "RenderHierarchy"
            xyz.adscope.common.v2.log.SDKLog.d(r8, r3)
            r9.a(r6)
            r6.b(r9)
            goto L9f
        L9d:
            r12.f54795e = r6
        L9f:
            xyz.adscope.ad.o2 r3 = r12.f54795e
            r6.c(r3)
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel r3 = r2.f()
            if (r3 == 0) goto Ld1
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel r3 = r2.f()
            r12.a(r4, r3)
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.view.ViewModel r2 = r2.f()
            java.lang.String r2 = r2.b()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto Ld1
            xyz.adscope.ad.a5$a r3 = new xyz.adscope.ad.a5$a
            r3.<init>()
            r4 = r15
            java.lang.Object r2 = xyz.adscope.common.v2.tool.collection.CollectionFetch.fetchFirstFromList(r15, r2, r3)
            xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel r2 = (xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.asset.AssetModel) r2
            if (r2 == 0) goto Ld2
            r6.a(r2)
            goto Ld2
        Ld1:
            r4 = r15
        Ld2:
            boolean r2 = r5 instanceof xyz.adscope.ad.u2
            if (r2 == 0) goto Lde
            xyz.adscope.ad.u2 r5 = (xyz.adscope.ad.u2) r5
            r2 = r17
            r5.a(r2)
            goto Le5
        Lde:
            r2 = r17
            goto Le5
        Le1:
            r4 = r15
            r7 = r16
            goto Lde
        Le5:
            int r1 = r1 + 1
            goto L11
        Le9:
            r12.f54796f = r3
            return
        Lec:
            r12.f54796f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.a5.a(android.content.Context, java.util.List, java.util.List, boolean, xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel):void");
    }

    private void a(String str, ViewModel viewModel) {
        DisplayExtModel b6;
        if (!CommonNetImpl.TAG.equalsIgnoreCase(str) || (b6 = this.f54792b.b()) == null) {
            return;
        }
        viewModel.a(b6.a());
    }

    @Override // xyz.adscope.ad.h2
    public o2 a(String str) {
        Map<String, o2> map = this.f54794d;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f54794d.get(str);
    }
}
