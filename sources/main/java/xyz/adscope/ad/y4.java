package xyz.adscope.ad;

import java.util.Comparator;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.render.RenderModel;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class y4 {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements Comparator<o2> {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(o2 o2Var, o2 o2Var2) {
            int parseInt = StringUtil.parseInt(o2Var.e());
            int parseInt2 = StringUtil.parseInt(o2Var2.e());
            if (parseInt < parseInt2) {
                return -1;
            }
            if (parseInt == parseInt2) {
                return 0;
            }
            return 1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements Comparator<RenderModel> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(RenderModel renderModel, RenderModel renderModel2) {
            if (renderModel.c() < renderModel2.c()) {
                return -1;
            }
            if (renderModel.c() == renderModel2.c()) {
                if (StringUtil.parseInt(renderModel.a()) < StringUtil.parseInt(renderModel2.a())) {
                    return -1;
                }
                return 0;
            }
            return 1;
        }
    }

    public static Comparator<o2> a() {
        return new b(null);
    }

    public static Comparator<RenderModel> b() {
        return new c(null);
    }
}
