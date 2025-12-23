package xyz.adscope.amps.adapter.gdt.inner;

import xyz.adscope.amps.adapter.gdt.model.BidResponseModel;

/* loaded from: D:\Downloads\app\classes9.dex */
public interface BiddingRequestCallback {
    void fail(int i6, String str);

    void success(String str, int i6, BidResponseModel bidResponseModel);
}
