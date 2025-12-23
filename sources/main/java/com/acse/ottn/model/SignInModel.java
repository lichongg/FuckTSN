package com.acse.ottn.model;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class SignInModel {
    private String points;

    /* renamed from: r, reason: collision with root package name */
    private int f4841r;
    private List<SignBean> sign = new ArrayList();
    private int sign_in;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class SignBean {
        private String day;
        private String points;
        private int sign;

        public String getDay() {
            return this.day;
        }

        public String getPoints() {
            return this.points;
        }

        public int getSign() {
            return this.sign;
        }

        public void setDay(String str) {
            this.day = str;
        }

        public void setPoints(String str) {
            this.points = str;
        }

        public void setSign(int i6) {
            this.sign = i6;
        }
    }

    public String getPoints() {
        return this.points;
    }

    public int getR() {
        return this.f4841r;
    }

    public List<SignBean> getSign() {
        return this.sign;
    }

    public int getSign_in() {
        return this.sign_in;
    }

    public void setPoints(String str) {
        this.points = str;
    }

    public void setR(int i6) {
        this.f4841r = i6;
    }

    public void setSign(List<SignBean> list) {
        this.sign = list;
    }

    public void setSign_in(int i6) {
        this.sign_in = i6;
    }
}
