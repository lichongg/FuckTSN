package com.bytedance.sdk.component.cw.xt.j.up;

import java.io.IOException;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public interface jy {

    /* renamed from: j, reason: collision with root package name */
    public static final jy f26273j = new jy() { // from class: com.bytedance.sdk.component.cw.xt.j.up.jy.1
        @Override // com.bytedance.sdk.component.cw.xt.j.up.jy
        public boolean j(int i6, List<cw> list) {
            return true;
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.jy
        public boolean j(int i6, List<cw> list, boolean z5) {
            return true;
        }

        @Override // com.bytedance.sdk.component.cw.xt.j.up.jy
        public boolean j(int i6, com.bytedance.sdk.component.cw.j.up upVar, int i7, boolean z5) throws IOException {
            upVar.tl(i7);
            return true;
        }
    };

    boolean j(int i6, com.bytedance.sdk.component.cw.j.up upVar, int i7, boolean z5) throws IOException;

    boolean j(int i6, List<cw> list);

    boolean j(int i6, List<cw> list, boolean z5);
}
