package cn.jpush.android.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes2.dex */
public class JPushCollectControl implements Serializable {
    private static final int APP_LISTS = 1001;
    public static final int APP_RUNNING = 1013;
    private static final int BSSID = 1007;
    private static final int CELL = 1008;
    private static final int GPS = 1000;
    private static final int IMEI = 1003;
    public static final int IMSI = 1010;
    private static final int MAC = 1005;
    private static final int SSID = 1006;
    public static final int WIFI = 1012;
    private static final long serialVersionUID = -3135447319267654288L;
    private ArrayList<Integer> mEnableDatas = new ArrayList<>();
    private ArrayList<Integer> mDisableDatas = new ArrayList<>();

    public static class Builder {
        private Set<Integer> mEnableDatas = new HashSet();
        private Set<Integer> mDisableDatas = new HashSet();

        private void disable(int i6) {
            this.mEnableDatas.remove(Integer.valueOf(i6));
            this.mDisableDatas.add(Integer.valueOf(i6));
        }

        private void enable(int i6) {
            this.mDisableDatas.remove(Integer.valueOf(i6));
            this.mEnableDatas.add(Integer.valueOf(i6));
        }

        private void set(boolean z5, int i6) {
            if (z5) {
                enable(i6);
            } else {
                disable(i6);
            }
        }

        public Builder bssid(boolean z5) {
            set(z5, 1007);
            if (!z5) {
                wifi(false);
            }
            return this;
        }

        public JPushCollectControl build() {
            return new JPushCollectControl(this);
        }

        public Builder cell(boolean z5) {
            set(z5, 1008);
            return this;
        }

        public Builder imei(boolean z5) {
            set(z5, 1003);
            return this;
        }

        public Builder imsi(boolean z5) {
            set(z5, 1010);
            return this;
        }

        public Builder mac(boolean z5) {
            set(z5, 1005);
            return this;
        }

        public Builder ssid(boolean z5) {
            set(z5, 1006);
            if (!z5) {
                wifi(false);
            }
            return this;
        }

        public Builder wifi(boolean z5) {
            set(z5, 1012);
            return this;
        }
    }

    public ArrayList<Integer> getDisableDatas() {
        return this.mDisableDatas;
    }

    public ArrayList<Integer> getEnableDatas() {
        return this.mEnableDatas;
    }

    public JPushCollectControl(Builder builder) {
        if (builder.mDisableDatas != null && !builder.mDisableDatas.isEmpty()) {
            this.mDisableDatas.addAll(builder.mDisableDatas);
        }
        if (builder.mEnableDatas != null && !builder.mEnableDatas.isEmpty()) {
            this.mEnableDatas.addAll(builder.mEnableDatas);
        }
    }
}
