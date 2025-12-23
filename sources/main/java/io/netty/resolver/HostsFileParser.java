package io.netty.resolver;

import io.netty.util.NetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;
import master.flame.danmaku.danmaku.parser.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class HostsFileParser {
    private static final String WINDOWS_DEFAULT_SYSTEM_ROOT = "C:\\Windows";
    private static final String WINDOWS_HOSTS_FILE_RELATIVE_PATH = "\\system32\\drivers\\etc\\hosts";
    private static final String X_PLATFORMS_HOSTS_FILE_PATH = "/etc/hosts";
    private static final Pattern WHITESPACES = Pattern.compile("[ \t]+");
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) HostsFileParser.class);

    public static HostsFileEntries parse() throws IOException {
        return parse(locateHostsFile());
    }

    public static HostsFileEntries parseSilently() {
        return parseSilently(Charset.defaultCharset());
    }

    public static HostsFileEntries parse(File file) throws IOException {
        return parse(file, Charset.defaultCharset());
    }

    public static HostsFileEntries parseSilently(Charset... charsetArr) {
        File locateHostsFile = locateHostsFile();
        try {
            return parse(locateHostsFile, charsetArr);
        } catch (IOException e6) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to load and parse hosts file at " + locateHostsFile.getPath(), (Throwable) e6);
            }
            return HostsFileEntries.EMPTY;
        }
    }

    private HostsFileParser() {
    }

    private static File locateHostsFile() {
        if (PlatformDependent.isWindows()) {
            File file = new File(System.getenv("SystemRoot") + WINDOWS_HOSTS_FILE_RELATIVE_PATH);
            if (!file.exists()) {
                return new File("C:\\Windows\\system32\\drivers\\etc\\hosts");
            }
            return file;
        }
        return new File(X_PLATFORMS_HOSTS_FILE_PATH);
    }

    public static HostsFileEntries parse(File file, Charset... charsetArr) throws IOException {
        ObjectUtil.checkNotNull(file, b.f50156c);
        ObjectUtil.checkNotNull(charsetArr, "charsets");
        if (file.exists() && file.isFile()) {
            for (Charset charset : charsetArr) {
                HostsFileEntries parse = parse(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)));
                if (parse != HostsFileEntries.EMPTY) {
                    return parse;
                }
            }
        }
        return HostsFileEntries.EMPTY;
    }

    public static HostsFileEntries parse(Reader reader) throws IOException {
        byte[] createByteArrayFromIpAddressString;
        ObjectUtil.checkNotNull(reader, "reader");
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                int indexOf = readLine.indexOf(35);
                if (indexOf != -1) {
                    readLine = readLine.substring(0, indexOf);
                }
                String trim = readLine.trim();
                if (!trim.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    for (String str : WHITESPACES.split(trim)) {
                        if (!str.isEmpty()) {
                            arrayList.add(str);
                        }
                    }
                    if (arrayList.size() >= 2 && (createByteArrayFromIpAddressString = NetUtil.createByteArrayFromIpAddressString((String) arrayList.get(0))) != null) {
                        for (int i6 = 1; i6 < arrayList.size(); i6++) {
                            String str2 = (String) arrayList.get(i6);
                            String lowerCase = str2.toLowerCase(Locale.ENGLISH);
                            InetAddress byAddress = InetAddress.getByAddress(str2, createByteArrayFromIpAddressString);
                            if (byAddress instanceof Inet4Address) {
                                Inet4Address inet4Address = (Inet4Address) hashMap.put(lowerCase, (Inet4Address) byAddress);
                                if (inet4Address != null) {
                                    hashMap.put(lowerCase, inet4Address);
                                }
                            } else {
                                Inet6Address inet6Address = (Inet6Address) hashMap2.put(lowerCase, (Inet6Address) byAddress);
                                if (inet6Address != null) {
                                    hashMap2.put(lowerCase, inet6Address);
                                }
                            }
                        }
                    }
                }
            }
            HostsFileEntries hostsFileEntries = (hashMap.isEmpty() && hashMap2.isEmpty()) ? HostsFileEntries.EMPTY : new HostsFileEntries(hashMap, hashMap2);
            try {
                bufferedReader.close();
                return hostsFileEntries;
            } catch (IOException e6) {
                logger.warn("Failed to close a reader", (Throwable) e6);
                return hostsFileEntries;
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e7) {
                logger.warn("Failed to close a reader", (Throwable) e7);
            }
            throw th;
        }
    }
}
