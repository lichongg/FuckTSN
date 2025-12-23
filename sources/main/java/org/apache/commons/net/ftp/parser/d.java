package org.apache.commons.net.ftp.parser;

import java.util.Calendar;
import org.apache.commons.net.ftp.FTPFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends o {

    /* renamed from: f, reason: collision with root package name */
    private static final String f50735f = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)";

    /* renamed from: g, reason: collision with root package name */
    private static final String f50736g = "(([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z])([\\-]|[A-Z]))(\\S*)\\s*(\\S+)\\s*(\\S*)\\s*(\\d*)\\s*(\\d*)\\s*(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s*((?:[012]\\d*)|(?:3[01]))\\s*((\\d\\d\\d\\d)|((?:[01]\\d)|(?:2[0123])):([012345]\\d))\\s(\\S*)(\\s*.*)";

    public d() {
        super(f50736g);
    }

    @Override // org.apache.commons.net.ftp.f
    public FTPFile a(String str) {
        FTPFile fTPFile = new FTPFile();
        fTPFile.setRawListing(str);
        if (!i(str)) {
            return null;
        }
        String h6 = h(14);
        String h7 = h(15);
        String h8 = h(16);
        String h9 = h(17);
        String h10 = h(18);
        String h11 = h(20);
        String h12 = h(21);
        String h13 = h(22);
        String h14 = h(23);
        fTPFile.setType(0);
        fTPFile.setUser(h6);
        fTPFile.setGroup(h7);
        try {
            fTPFile.setSize(Long.parseLong(h8));
        } catch (NumberFormatException unused) {
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(14, 0);
        int i6 = 13;
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(11, 0);
        int indexOf = f50735f.indexOf(h9) / 4;
        try {
            if (h11 != null) {
                calendar.set(1, Integer.parseInt(h11));
                i6 = 11;
            } else {
                int i7 = calendar.get(1);
                if (calendar.get(2) < indexOf) {
                    i7--;
                }
                calendar.set(1, i7);
                calendar.set(11, Integer.parseInt(h12));
                calendar.set(12, Integer.parseInt(h13));
            }
            calendar.set(2, indexOf);
            calendar.set(5, Integer.parseInt(h10));
            calendar.clear(i6);
            fTPFile.setTimestamp(calendar);
        } catch (NumberFormatException unused2) {
        }
        fTPFile.setName(h14);
        return fTPFile;
    }
}
