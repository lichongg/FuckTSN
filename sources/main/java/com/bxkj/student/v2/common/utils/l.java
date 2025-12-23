package com.bxkj.student.v2.common.utils;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.common.qrcode.b;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.v2.ai.fitness.AIFitnessHomeActivity;
import com.bxkj.student.v2.ui.LoginActivity;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20907a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.v2.common.utils.l$a$a, reason: collision with other inner class name */
        public static final class C0277a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FragmentActivity f20908a;

            C0277a(FragmentActivity fragmentActivity) {
                this.f20908a = fragmentActivity;
            }

            @Override // com.bxkj.base.v2.common.qrcode.b.a
            public void a(String result) {
                g0.p(result, "result");
                if (!kotlin.text.u.H2(result, master.flame.danmaku.danmaku.parser.b.f50154a, false, 2, null)) {
                    ContextExtKt.m(this.f20908a, "扫码结果:" + result);
                    return;
                }
                i iVar = i.f20904a;
                FragmentActivity fragmentActivity = this.f20908a;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(CommonNetImpl.NAME, "扫一扫");
                linkedHashMap.put("linkUrl", result);
                n1 n1Var = n1.f44123a;
                iVar.b(fragmentActivity, linkedHashMap);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x004c, code lost:
        
            r8.startActivity(new android.content.Intent(r8, (java.lang.Class<?>) com.bxkj.student.v2.ui.my.AboutUsActivity.class).putExtra("title", r2));
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        
            if (r3.equals("appRunKey") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x00cb, code lost:
        
            r8.startActivity(new android.content.Intent(r8, (java.lang.Class<?>) com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity.class).putExtra("title", r0.t(r7, com.umeng.socialize.net.dplus.CommonNetImpl.NAME)));
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
        
            if (r3.equals("aboutKey-t") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
        
            if (r3.equals("ts-appRunRecord") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x008d, code lost:
        
            r8.startActivity(new android.content.Intent(r8, (java.lang.Class<?>) com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity.class).putExtra("title", r0.t(r7, com.umeng.socialize.net.dplus.CommonNetImpl.NAME)));
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
        
            if (r3.equals("myQrCodeKey-t") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00e7, code lost:
        
            r8.startActivity(new android.content.Intent(r8, (java.lang.Class<?>) com.bxkj.student.v2.ui.my.MyQRCodeActivity.class).putExtra("title", r2));
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
        
            if (r3.equals("appRunRecord") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00b6, code lost:
        
            if (r3.equals("appRunStatistics") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00ff, code lost:
        
            r8.startActivity(new android.content.Intent(r8, (java.lang.Class<?>) com.bxkj.student.v2.ui.sports.v3.set.V3StatisticsActivity.class).putExtra("title", r0.t(r7, com.umeng.socialize.net.dplus.CommonNetImpl.NAME)));
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00bf, code lost:
        
            if (r3.equals("scanQRCode") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0132, code lost:
        
            new com.bxkj.base.v2.common.qrcode.b(r8).m(new com.bxkj.student.v2.common.utils.l.a.C0277a(r8));
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00c8, code lost:
        
            if (r3.equals("ts-appRunKey") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00e4, code lost:
        
            if (r3.equals("myQrCodeKey") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00fc, code lost:
        
            if (r3.equals("ts-appRunStatistics") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0118, code lost:
        
            if (r3.equals("scanQRCode-t") == false) goto L67;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0034, code lost:
        
            if (r3.equals("aboutKey") == false) goto L67;
         */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void b(java.util.Map<java.lang.String, ? extends java.lang.Object> r7, final androidx.fragment.app.FragmentActivity r8) {
            /*
                Method dump skipped, instructions count: 382
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.utils.l.a.b(java.util.Map, androidx.fragment.app.FragmentActivity):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final n1 c(FragmentActivity fragmentActivity) {
            fragmentActivity.startActivity(new Intent(fragmentActivity, (Class<?>) AIFitnessHomeActivity.class));
            return n1.f44123a;
        }

        public final void d(@NotNull FragmentActivity mContext, @NotNull Map<String, ? extends Object> menu, @NotNull String menuType) {
            g0.p(mContext, "mContext");
            g0.p(menu, "menu");
            g0.p(menuType, "menuType");
            c0 c0Var = c0.f16887a;
            if (!g0.g(c0Var.t(menu, "isEnabled"), "1")) {
                ContextExtKt.t(mContext, "暂未开通此权限");
            } else if (!c0Var.d(menu, "isLogin") || com.bxkj.base.v2.data.b.f16998d.a().Y()) {
                b(menu, mContext);
            } else {
                mContext.startActivity(new Intent(mContext, (Class<?>) LoginActivity.class));
            }
        }
    }
}
