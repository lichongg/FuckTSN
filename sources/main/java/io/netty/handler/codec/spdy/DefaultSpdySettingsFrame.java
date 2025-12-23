package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class DefaultSpdySettingsFrame implements SpdySettingsFrame {
    private boolean clear;
    private final Map<Integer, Setting> settingsMap = new TreeMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class Setting {
        private boolean persist;
        private boolean persisted;
        private int value;

        int getValue() {
            return this.value;
        }

        boolean isPersist() {
            return this.persist;
        }

        boolean isPersisted() {
            return this.persisted;
        }

        void setPersist(boolean z5) {
            this.persist = z5;
        }

        void setPersisted(boolean z5) {
            this.persisted = z5;
        }

        void setValue(int i6) {
            this.value = i6;
        }

        Setting(int i6, boolean z5, boolean z6) {
            this.value = i6;
            this.persist = z5;
            this.persisted = z6;
        }
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setValue(int i6, int i7) {
        return setValue(i6, i7, false, false);
    }

    private Set<Map.Entry<Integer, Setting>> getSettings() {
        return this.settingsMap.entrySet();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean clearPreviouslyPersistedSettings() {
        return this.clear;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public int getValue(int i6) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i6));
        if (setting != null) {
            return setting.getValue();
        }
        return -1;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public Set<Integer> ids() {
        return this.settingsMap.keySet();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isPersistValue(int i6) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i6));
        return setting != null && setting.isPersist();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isPersisted(int i6) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i6));
        return setting != null && setting.isPersisted();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isSet(int i6) {
        return this.settingsMap.containsKey(Integer.valueOf(i6));
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame removeValue(int i6) {
        this.settingsMap.remove(Integer.valueOf(i6));
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean z5) {
        this.clear = z5;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setPersistValue(int i6, boolean z5) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i6));
        if (setting != null) {
            setting.setPersist(z5);
        }
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setPersisted(int i6, boolean z5) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i6));
        if (setting != null) {
            setting.setPersisted(z5);
        }
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setValue(int i6, int i7, boolean z5, boolean z6) {
        if (i6 < 0 || i6 > 16777215) {
            throw new IllegalArgumentException("Setting ID is not valid: " + i6);
        }
        Integer valueOf = Integer.valueOf(i6);
        Setting setting = this.settingsMap.get(valueOf);
        if (setting == null) {
            this.settingsMap.put(valueOf, new Setting(i7, z5, z6));
            return this;
        }
        setting.setValue(i7);
        setting.setPersist(z5);
        setting.setPersisted(z6);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb.append(str);
        appendSettings(sb);
        sb.setLength(sb.length() - str.length());
        return sb.toString();
    }

    private void appendSettings(StringBuilder sb) {
        for (Map.Entry<Integer, Setting> entry : getSettings()) {
            Setting value = entry.getValue();
            sb.append("--> ");
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(value.getValue());
            sb.append(" (persist value: ");
            sb.append(value.isPersist());
            sb.append("; persisted: ");
            sb.append(value.isPersisted());
            sb.append(')');
            sb.append(StringUtil.NEWLINE);
        }
    }
}
