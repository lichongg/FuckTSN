package com.bytedance.sdk.component.m.r;

/* loaded from: D:\Downloads\app\classes4.dex */
public class qv extends j {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        com.bytedance.sdk.component.m.cw.cw cwVar2;
        final com.bytedance.sdk.component.m.cw.m kt = cwVar.kt();
        com.bytedance.sdk.component.m.r r5 = kt.r();
        cwVar.j(false);
        try {
            com.bytedance.sdk.component.m.m call = r5.call(new com.bytedance.sdk.component.m.xt.cw(cwVar.xt(), cwVar.ws(), cwVar.az(), cwVar.v()));
            int xt = call.xt();
            cwVar.j(call.j());
            cwVar2 = 200;
            try {
                if (call.xt() != 200) {
                    kt.tl();
                    String.valueOf(call);
                    Object cw = call.cw();
                    j(xt, call.r(), cw instanceof Throwable ? (Throwable) cw : null, cwVar);
                    return;
                }
                final byte[] bArr = (byte[]) call.cw();
                cwVar.j(new xt(bArr, call));
                final String m6 = cwVar.m();
                final com.bytedance.sdk.component.m.xt tj = cwVar.tj();
                if (tj.ae()) {
                    kt.xt(cwVar.tj()).j(m6, bArr);
                }
                final com.bytedance.sdk.component.m.cw.cw cwVar3 = cwVar;
                try {
                    kt.m().submit(new Runnable() { // from class: com.bytedance.sdk.component.m.r.qv.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (tj.r()) {
                                kt.cw(cwVar3.tj()).j(m6, bArr);
                            }
                        }
                    });
                } catch (Throwable th) {
                    th = th;
                    cwVar2 = cwVar3;
                    j(1004, "net request failed!", th, cwVar2);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cwVar2 = cwVar;
        }
    }

    private void j(int i6, String str, Throwable th, com.bytedance.sdk.component.m.cw.cw cwVar) {
        cwVar.j(new tl(i6, str, th));
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "net_request";
    }
}
