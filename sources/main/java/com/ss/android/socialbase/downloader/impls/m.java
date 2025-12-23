package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\Downloads\app\classes6.dex */
public class m implements com.ss.android.socialbase.downloader.g.tl {
    @Override // com.ss.android.socialbase.downloader.g.tl
    public com.ss.android.socialbase.downloader.g.ae j(String str, List<com.ss.android.socialbase.downloader.ae.up> list) throws IOException {
        OkHttpClient w5 = com.ss.android.socialbase.downloader.downloader.cw.w();
        if (w5 != null) {
            Request.Builder head = new Request.Builder().url(str).head();
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.ae.up upVar : list) {
                    head.addHeader(upVar.j(), com.ss.android.socialbase.downloader.az.m.ae(upVar.xt()));
                }
            }
            final Call newCall = w5.newCall(head.build());
            final Response execute = newCall.execute();
            if (execute != null) {
                if (com.ss.android.socialbase.downloader.az.j.j(2097152)) {
                    execute.close();
                }
                return new com.ss.android.socialbase.downloader.g.ae() { // from class: com.ss.android.socialbase.downloader.impls.m.1
                    @Override // com.ss.android.socialbase.downloader.g.ae
                    public void cw() {
                        Call call = newCall;
                        if (call == null || call.isCanceled()) {
                            return;
                        }
                        newCall.cancel();
                    }

                    @Override // com.ss.android.socialbase.downloader.g.ae
                    public String j(String str2) {
                        return execute.header(str2);
                    }

                    @Override // com.ss.android.socialbase.downloader.g.ae
                    public int xt() throws IOException {
                        return execute.code();
                    }
                };
            }
            throw new IOException("can't get response");
        }
        throw new IOException("can't get httpClient");
    }
}
