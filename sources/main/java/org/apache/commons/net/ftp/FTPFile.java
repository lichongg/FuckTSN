package org.apache.commons.net.ftp;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.TimeZone;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class FTPFile implements Serializable {
    public static final int DIRECTORY_TYPE = 1;
    public static final int EXECUTE_PERMISSION = 2;
    public static final int FILE_TYPE = 0;
    public static final int GROUP_ACCESS = 1;
    public static final int READ_PERMISSION = 0;
    public static final int SYMBOLIC_LINK_TYPE = 2;
    public static final int UNKNOWN_TYPE = 3;
    public static final int USER_ACCESS = 0;
    public static final int WORLD_ACCESS = 2;
    public static final int WRITE_PERMISSION = 1;
    private static final long serialVersionUID = 9010790363003271996L;
    private Calendar _date;
    private String _group;
    private int _hardLinkCount;
    private String _link;
    private String _name;
    private final boolean[][] _permissions;
    private String _rawListing;
    private long _size;
    private int _type;
    private String _user;

    public FTPFile() {
        this._permissions = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 3, 3);
        this._type = 3;
        this._hardLinkCount = 0;
        this._size = -1L;
        this._user = "";
        this._group = "";
        this._date = null;
        this._name = null;
    }

    public String toFormattedString() {
        return toFormattedString(null);
    }

    private char formatType() {
        int i6 = this._type;
        if (i6 == 0) {
            return '-';
        }
        if (i6 != 1) {
            return i6 != 2 ? '?' : 'l';
        }
        return 'd';
    }

    private String permissionToString(int i6) {
        StringBuilder sb = new StringBuilder();
        if (hasPermission(i6, 0)) {
            sb.append('r');
        } else {
            sb.append('-');
        }
        if (hasPermission(i6, 1)) {
            sb.append('w');
        } else {
            sb.append('-');
        }
        if (hasPermission(i6, 2)) {
            sb.append('x');
        } else {
            sb.append('-');
        }
        return sb.toString();
    }

    public String getGroup() {
        return this._group;
    }

    public int getHardLinkCount() {
        return this._hardLinkCount;
    }

    public String getLink() {
        return this._link;
    }

    public String getName() {
        return this._name;
    }

    public String getRawListing() {
        return this._rawListing;
    }

    public long getSize() {
        return this._size;
    }

    public Calendar getTimestamp() {
        return this._date;
    }

    public int getType() {
        return this._type;
    }

    public String getUser() {
        return this._user;
    }

    public boolean hasPermission(int i6, int i7) {
        boolean[][] zArr = this._permissions;
        if (zArr == null) {
            return false;
        }
        return zArr[i6][i7];
    }

    public boolean isDirectory() {
        return this._type == 1;
    }

    public boolean isFile() {
        return this._type == 0;
    }

    public boolean isSymbolicLink() {
        return this._type == 2;
    }

    public boolean isUnknown() {
        return this._type == 3;
    }

    public boolean isValid() {
        return this._permissions != null;
    }

    public void setGroup(String str) {
        this._group = str;
    }

    public void setHardLinkCount(int i6) {
        this._hardLinkCount = i6;
    }

    public void setLink(String str) {
        this._link = str;
    }

    public void setName(String str) {
        this._name = str;
    }

    public void setPermission(int i6, int i7, boolean z5) {
        this._permissions[i6][i7] = z5;
    }

    public void setRawListing(String str) {
        this._rawListing = str;
    }

    public void setSize(long j6) {
        this._size = j6;
    }

    public void setTimestamp(Calendar calendar) {
        this._date = calendar;
    }

    public void setType(int i6) {
        this._type = i6;
    }

    public void setUser(String str) {
        this._user = str;
    }

    public String toFormattedString(String str) {
        if (!isValid()) {
            return "[Invalid: could not parse file entry]";
        }
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        sb.append(formatType());
        sb.append(permissionToString(0));
        sb.append(permissionToString(1));
        sb.append(permissionToString(2));
        formatter.format(" %4d", Integer.valueOf(getHardLinkCount()));
        formatter.format(" %-8s %-8s", getUser(), getGroup());
        formatter.format(" %8d", Long.valueOf(getSize()));
        Calendar timestamp = getTimestamp();
        if (timestamp != null) {
            if (str != null) {
                TimeZone timeZone = TimeZone.getTimeZone(str);
                if (!timeZone.equals(timestamp.getTimeZone())) {
                    Date time = timestamp.getTime();
                    Calendar calendar = Calendar.getInstance(timeZone);
                    calendar.setTime(time);
                    timestamp = calendar;
                }
            }
            formatter.format(" %1$tY-%1$tm-%1$td", timestamp);
            if (timestamp.isSet(11)) {
                formatter.format(" %1$tH", timestamp);
                if (timestamp.isSet(12)) {
                    formatter.format(":%1$tM", timestamp);
                    if (timestamp.isSet(13)) {
                        formatter.format(":%1$tS", timestamp);
                        if (timestamp.isSet(14)) {
                            formatter.format(".%1$tL", timestamp);
                        }
                    }
                }
                formatter.format(" %1$tZ", timestamp);
            }
        }
        sb.append(' ');
        sb.append(getName());
        formatter.close();
        return sb.toString();
    }

    public String toString() {
        return getRawListing();
    }

    FTPFile(String str) {
        this._permissions = null;
        this._rawListing = str;
        this._type = 3;
        this._hardLinkCount = 0;
        this._size = -1L;
        this._user = "";
        this._group = "";
        this._date = null;
        this._name = null;
    }
}
