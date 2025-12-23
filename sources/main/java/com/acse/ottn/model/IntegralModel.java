package com.acse.ottn.model;

import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class IntegralModel {
    private List<PointsListBean> points_list;

    /* renamed from: r, reason: collision with root package name */
    private int f4840r;
    private String total_points;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class PointsListBean {
        private String ctime;
        private String des;
        private String points;
        private String status;

        public String getCtime() {
            return this.ctime;
        }

        public String getDes() {
            return this.des;
        }

        public String getPoints() {
            return this.points;
        }

        public String getStatus() {
            return this.status;
        }

        public void setCtime(String str) {
            this.ctime = str;
        }

        public void setDes(String str) {
            this.des = str;
        }

        public void setPoints(String str) {
            this.points = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String toString() {
            return "PointsListBean{des='" + this.des + "', ctime='" + this.ctime + "', points='" + this.points + "', status='" + this.status + "'}";
        }
    }

    public List<PointsListBean> getPoints_list() {
        return this.points_list;
    }

    public int getR() {
        return this.f4840r;
    }

    public String getTotal_points() {
        return this.total_points;
    }

    public void setPoints_list(List<PointsListBean> list) {
        this.points_list = list;
    }

    public void setR(int i6) {
        this.f4840r = i6;
    }

    public void setTotal_points(String str) {
        this.total_points = str;
    }

    public String toString() {
        return "IntegralModel{r=" + this.f4840r + ", total_points='" + this.total_points + "', points_list=" + this.points_list + '}';
    }
}
