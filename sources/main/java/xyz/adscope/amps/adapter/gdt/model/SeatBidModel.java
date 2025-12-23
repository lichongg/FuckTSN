package xyz.adscope.amps.adapter.gdt.model;

import java.util.List;

/* loaded from: D:\Downloads\app\classes9.dex */
public class SeatBidModel {
    private List<BidModel> bid;
    private String seat;

    public List<BidModel> getBid() {
        return this.bid;
    }

    public String getSeat() {
        return this.seat;
    }

    public void setBid(List<BidModel> list) {
        this.bid = list;
    }

    public void setSeat(String str) {
        this.seat = str;
    }
}
