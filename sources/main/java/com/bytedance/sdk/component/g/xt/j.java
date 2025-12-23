package com.bytedance.sdk.component.g.xt;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.m;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends r {
    public void j(final com.bytedance.sdk.component.g.j.j jVar) {
        try {
            ws.j jVar2 = new ws.j();
            jVar2.j((Object) xt());
            xt("Range", "bytes=0-");
            if (TextUtils.isEmpty(this.f26458m)) {
                jVar.j(this, new IOException("Url is Empty"));
                return;
            }
            jVar2.j(this.f26458m);
            j(jVar2);
            this.cw.j(jVar2.j().xt()).j(new com.bytedance.sdk.component.xt.j.cw() { // from class: com.bytedance.sdk.component.g.xt.j.1
                @Override // com.bytedance.sdk.component.xt.j.cw
                public void onFailure(com.bytedance.sdk.component.xt.j.xt xtVar, IOException iOException) {
                    com.bytedance.sdk.component.g.j.j jVar3 = jVar;
                    if (jVar3 != null) {
                        jVar3.j(j.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.xt.j.cw
                public void onResponse(com.bytedance.sdk.component.xt.j.xt xtVar, av avVar) throws IOException {
                    if (jVar == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    if (avVar == null) {
                        return;
                    }
                    com.bytedance.sdk.component.g.xt xtVar2 = new com.bytedance.sdk.component.g.xt(avVar.r(), avVar.cw(), avVar.up(), hashMap, null, avVar.xt(), avVar.j());
                    if (!avVar.r()) {
                        jVar.j(j.this, xtVar2);
                        return;
                    }
                    InputStream inputStream = null;
                    try {
                        m ae = avVar.ae();
                        if (ae != null) {
                            for (int i6 = 0; i6 < ae.j(); i6++) {
                                hashMap.put(ae.j(i6), ae.xt(i6));
                            }
                        }
                        int intValue = Long.valueOf(avVar.m().j()).intValue();
                        byte[] bArr = new byte[intValue];
                        inputStream = avVar.m().cw();
                        if (inputStream.read(bArr) == intValue) {
                            xtVar2.j(bArr);
                        } else {
                            xtVar2 = new com.bytedance.sdk.component.g.xt(false, avVar.cw(), "Byte opt fail", hashMap, null, avVar.xt(), avVar.j());
                        }
                        jVar.j(j.this, xtVar2);
                        try {
                            inputStream.close();
                        } catch (Throwable unused) {
                        }
                    } catch (Throwable th) {
                        try {
                            vl.j(th);
                            jVar.j(j.this, new IOException(th.getMessage()));
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                        } finally {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            vl.j(th);
        }
    }

    public j(com.bytedance.sdk.component.xt.j.vl vlVar) {
        super(vlVar);
    }

    @Override // com.bytedance.sdk.component.g.xt.r
    public com.bytedance.sdk.component.g.xt j() {
        InputStream inputStream;
        try {
            ws.j jVar = new ws.j();
            jVar.j((Object) xt());
            xt("Range", "bytes=0-");
            if (TextUtils.isEmpty(this.f26458m)) {
                vl.r("ByteDownloadExecutor", "execute: Url is Empty");
                return null;
            }
            jVar.j(this.f26458m);
            j(jVar);
            av j6 = this.cw.j(jVar.j().xt()).j();
            if (j6 == null || !j6.r()) {
                return null;
            }
            HashMap hashMap = new HashMap();
            m ae = j6.ae();
            if (ae != null) {
                for (int i6 = 0; i6 < ae.j(); i6++) {
                    hashMap.put(ae.j(i6), ae.xt(i6));
                }
            }
            long j7 = j6.m().j();
            byte[] bArr = new byte[Long.valueOf(j7).intValue()];
            inputStream = j6.m().cw();
            try {
                if (inputStream.read(bArr) == j7) {
                    com.bytedance.sdk.component.g.xt xtVar = new com.bytedance.sdk.component.g.xt(j6.r(), j6.cw(), j6.up(), hashMap, null, j6.xt(), j6.j());
                    xtVar.j(bArr);
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                    }
                    return xtVar;
                }
                com.bytedance.sdk.component.g.xt xtVar2 = new com.bytedance.sdk.component.g.xt(false, j6.cw(), "Byte opt fail", hashMap, null, j6.xt(), j6.j());
                try {
                    inputStream.close();
                } catch (Throwable unused2) {
                }
                return xtVar2;
            } catch (Throwable th) {
                th = th;
                try {
                    vl.j(th);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }
}
