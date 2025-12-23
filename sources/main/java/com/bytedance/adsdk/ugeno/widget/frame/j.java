package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.acse.ottn.adapter.AutoScrollViewPager;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.adsdk.ugeno.xt.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.adsdk.ugeno.xt.j<UGFrameLayout> {
    private UGFrameLayout ll;

    /* renamed from: com.bytedance.adsdk.ugeno.widget.frame.j$j, reason: collision with other inner class name */
    public static class C0325j extends j.C0328j {

        /* renamed from: s, reason: collision with root package name */
        protected int f23811s;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private int xt(String str) {
            char c6;
            str.getClass();
            switch (str.hashCode()) {
                case -1383228885:
                    if (str.equals("bottom")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -1364013995:
                    if (str.equals(AutoScrollViewPager.f4187g)) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case -348726240:
                    if (str.equals("center_vertical")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 115029:
                    if (str.equals("top")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3317767:
                    if (str.equals(ScrollClickView.DIR_LEFT)) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c6 = 5;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 1063616078:
                    if (str.equals("center_horizontal")) {
                        c6 = 6;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                    return 80;
                case 1:
                    return 17;
                case 2:
                    return 16;
                case 3:
                    return 48;
                case 4:
                    return 3;
                case 5:
                    return 5;
                case 6:
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xt.j.C0328j
        public void j(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.j(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.f23811s = j(str2);
            }
        }

        @Override // com.bytedance.adsdk.ugeno.xt.j.C0328j
        /* renamed from: xt, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams j() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.f23891j, (int) this.xt);
            layoutParams.leftMargin = (int) this.f23892m;
            layoutParams.rightMargin = (int) this.ae;
            layoutParams.topMargin = (int) this.tl;
            layoutParams.bottomMargin = (int) this.f23889g;
            layoutParams.gravity = this.f23811s;
            return layoutParams;
        }

        public C0325j(com.bytedance.adsdk.ugeno.xt.j jVar) {
            super(jVar);
            this.f23811s = -1;
        }

        private int j(String str) {
            String[] split;
            if (TextUtils.isEmpty(str) || (split = str.split("\\|")) == null || split.length <= 0) {
                return -1;
            }
            int i6 = 0;
            for (String str2 : split) {
                i6 |= xt(str2);
            }
            return i6;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: qb, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout j() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.xt);
        this.ll = uGFrameLayout;
        uGFrameLayout.j(this);
        return this.ll;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public j.C0328j tl() {
        return new C0325j(this);
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j, com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        this.ll.setEventMap(this.ka);
        super.xt();
    }

    public j(Context context) {
        super(context);
    }
}
