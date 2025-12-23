package xyz.adscope.amps.adapter.gdt.model;

import java.util.List;

/* loaded from: D:\Downloads\app\classes9.dex */
public class BidResponseModel {
    private String bidid;
    private String cur;
    private String id;
    private int nbr;
    private List<SeatBidModel> seatbid;
    private String token;

    public String getBidid() {
        return this.bidid;
    }

    public String getCur() {
        return this.cur;
    }

    public String getId() {
        return this.id;
    }

    public int getNbr() {
        return this.nbr;
    }

    public List<SeatBidModel> getSeatbid() {
        return this.seatbid;
    }

    public String getToken() {
        return this.token;
    }

    public void setBidid(String str) {
        this.bidid = str;
    }

    public void setCur(String str) {
        this.cur = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNbr(int i6) {
        this.nbr = i6;
    }

    public void setSeatbid(List<SeatBidModel> list) {
        this.seatbid = list;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
