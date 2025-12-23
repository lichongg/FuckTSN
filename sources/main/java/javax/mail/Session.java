package javax.mail;

import androidx.core.app.NotificationCompat;
import com.huawei.hms.framework.common.ContainerUtils;
import com.sun.mail.util.LineInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.Provider;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Session {
    private static Session defaultSession;
    private final Authenticator authenticator;
    private boolean debug;
    private PrintStream out;
    private final Properties props;
    private final Hashtable authTable = new Hashtable();
    private final Vector providers = new Vector();
    private final Hashtable providersByProtocol = new Hashtable();
    private final Hashtable providersByClassName = new Hashtable();
    private final Properties addressMap = new Properties();

    public static synchronized Session getDefaultInstance(Properties properties, Authenticator authenticator) {
        Session session;
        synchronized (Session.class) {
            try {
                Session session2 = defaultSession;
                if (session2 == null) {
                    defaultSession = new Session(properties, authenticator);
                } else {
                    Authenticator authenticator2 = session2.authenticator;
                    if (authenticator2 != authenticator && (authenticator2 == null || authenticator == null || authenticator2.getClass().getClassLoader() != authenticator.getClass().getClassLoader())) {
                        throw new SecurityException("Access to default session denied");
                    }
                }
                session = defaultSession;
            } catch (Throwable th) {
                throw th;
            }
        }
        return session;
    }

    public static Session getInstance(Properties properties, Authenticator authenticator) {
        return new Session(properties, authenticator);
    }

    public synchronized void addProvider(Provider provider) {
        this.providers.addElement(provider);
        this.providersByClassName.put(provider.getClassName(), provider);
        if (!this.providersByProtocol.containsKey(provider.getProtocol())) {
            this.providersByProtocol.put(provider.getProtocol(), provider);
        }
    }

    public synchronized boolean getDebug() {
        return this.debug;
    }

    public synchronized PrintStream getDebugOut() {
        PrintStream printStream = this.out;
        if (printStream != null) {
            return printStream;
        }
        return System.out;
    }

    public synchronized Provider getProvider(String str) throws NoSuchProviderException {
        Provider provider;
        if (str != null) {
            try {
                if (str.length() > 0) {
                    String property = this.props.getProperty("mail." + str + ".class");
                    if (property != null) {
                        if (this.debug) {
                            pr("DEBUG: mail." + str + ".class property exists and points to " + property);
                        }
                        provider = (Provider) this.providersByClassName.get(property);
                    } else {
                        provider = null;
                    }
                    if (provider != null) {
                        return provider;
                    }
                    Provider provider2 = (Provider) this.providersByProtocol.get(str);
                    if (provider2 == null) {
                        throw new NoSuchProviderException("No provider for " + str);
                    }
                    if (this.debug) {
                        pr("DEBUG: getProvider() returning " + provider2.toString());
                    }
                    return provider2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        throw new NoSuchProviderException("Invalid protocol: null");
    }

    public synchronized Provider[] getProviders() {
        Provider[] providerArr;
        providerArr = new Provider[this.providers.size()];
        this.providers.copyInto(providerArr);
        return providerArr;
    }

    public Store getStore() throws NoSuchProviderException {
        return getStore(getProperty("mail.store.protocol"));
    }

    public Transport getTransport() throws NoSuchProviderException {
        return getTransport(getProperty("mail.transport.protocol"));
    }

    public synchronized void setDebug(boolean z5) {
        this.debug = z5;
        if (z5) {
            pr("DEBUG: setDebug: JavaMail version 1.4.1");
        }
    }

    public synchronized void setDebugOut(PrintStream printStream) {
        this.out = printStream;
    }

    public synchronized void setProtocolForAddress(String str, String str2) {
        try {
            if (str2 == null) {
                this.addressMap.remove(str);
            } else {
                this.addressMap.put(str, str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setProvider(Provider provider) throws NoSuchProviderException {
        if (provider == null) {
            throw new NoSuchProviderException("Can't set null provider");
        }
        this.providersByProtocol.put(provider.getProtocol(), provider);
        this.props.put("mail." + provider.getProtocol() + ".class", provider.getClassName());
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.mail.Session.3
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }

    public static Session getInstance(Properties properties) {
        return new Session(properties, null);
    }

    private static InputStream getResourceAsStream(final Class cls, final String str) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: javax.mail.Session.4
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws IOException {
                    return cls.getResourceAsStream(str);
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getException());
        }
    }

    private static URL[] getResources(final ClassLoader classLoader, final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.mail.Session.5
            @Override // java.security.PrivilegedAction
            public Object run() {
                URL[] urlArr = null;
                try {
                    Vector vector = new Vector();
                    Enumeration<URL> resources = classLoader.getResources(str);
                    while (resources != null && resources.hasMoreElements()) {
                        URL nextElement = resources.nextElement();
                        if (nextElement != null) {
                            vector.addElement(nextElement);
                        }
                    }
                    if (vector.size() <= 0) {
                        return null;
                    }
                    urlArr = new URL[vector.size()];
                    vector.copyInto(urlArr);
                    return urlArr;
                } catch (IOException | SecurityException unused) {
                    return urlArr;
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: Exception -> 0x0041, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0041, blocks: (B:8:0x0026, B:27:0x002c, B:12:0x0038), top: B:7:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object getService(javax.mail.Provider r8, javax.mail.URLName r9) throws javax.mail.NoSuchProviderException {
        /*
            r7 = this;
            if (r8 == 0) goto L91
            if (r9 != 0) goto L13
            javax.mail.URLName r0 = new javax.mail.URLName
            java.lang.String r1 = r8.getProtocol()
            r5 = 0
            r6 = 0
            r2 = 0
            r3 = -1
            r4 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9 = r0
        L13:
            javax.mail.Authenticator r0 = r7.authenticator
            java.lang.Class<javax.mail.Session> r1 = javax.mail.Session.class
            if (r0 == 0) goto L22
            java.lang.Class r0 = r0.getClass()
            java.lang.ClassLoader r0 = r0.getClassLoader()
            goto L26
        L22:
            java.lang.ClassLoader r0 = r1.getClassLoader()
        L26:
            java.lang.ClassLoader r2 = getContextClassLoader()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L35
            java.lang.String r3 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L35 java.lang.Exception -> L41
            java.lang.Class r2 = r2.loadClass(r3)     // Catch: java.lang.ClassNotFoundException -> L35 java.lang.Exception -> L41
            goto L36
        L35:
            r2 = 0
        L36:
            if (r2 != 0) goto L49
            java.lang.String r2 = r8.getClassName()     // Catch: java.lang.Exception -> L41
            java.lang.Class r2 = r0.loadClass(r2)     // Catch: java.lang.Exception -> L41
            goto L49
        L41:
            java.lang.String r0 = r8.getClassName()     // Catch: java.lang.Exception -> L7a
            java.lang.Class r2 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L7a
        L49:
            r0 = 2
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L63
            r4 = 0
            r3[r4] = r1     // Catch: java.lang.Exception -> L63
            java.lang.Class<javax.mail.URLName> r1 = javax.mail.URLName.class
            r5 = 1
            r3[r5] = r1     // Catch: java.lang.Exception -> L63
            java.lang.reflect.Constructor r1 = r2.getConstructor(r3)     // Catch: java.lang.Exception -> L63
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L63
            r0[r4] = r7     // Catch: java.lang.Exception -> L63
            r0[r5] = r9     // Catch: java.lang.Exception -> L63
            java.lang.Object r8 = r1.newInstance(r0)     // Catch: java.lang.Exception -> L63
            return r8
        L63:
            r0 = move-exception
            r9 = r0
            boolean r0 = r7.debug
            if (r0 == 0) goto L70
            java.io.PrintStream r0 = r7.getDebugOut()
            r9.printStackTrace(r0)
        L70:
            javax.mail.NoSuchProviderException r9 = new javax.mail.NoSuchProviderException
            java.lang.String r8 = r8.getProtocol()
            r9.<init>(r8)
            throw r9
        L7a:
            r0 = move-exception
            r9 = r0
            boolean r0 = r7.debug
            if (r0 == 0) goto L87
            java.io.PrintStream r0 = r7.getDebugOut()
            r9.printStackTrace(r0)
        L87:
            javax.mail.NoSuchProviderException r9 = new javax.mail.NoSuchProviderException
            java.lang.String r8 = r8.getProtocol()
            r9.<init>(r8)
            throw r9
        L91:
            javax.mail.NoSuchProviderException r8 = new javax.mail.NoSuchProviderException
            java.lang.String r9 = "null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.getService(javax.mail.Provider, javax.mail.URLName):java.lang.Object");
    }

    private static URL[] getSystemResources(final String str) {
        return (URL[]) AccessController.doPrivileged(new PrivilegedAction() { // from class: javax.mail.Session.6
            @Override // java.security.PrivilegedAction
            public Object run() {
                URL[] urlArr = null;
                try {
                    Vector vector = new Vector();
                    Enumeration<URL> systemResources = ClassLoader.getSystemResources(str);
                    while (systemResources != null && systemResources.hasMoreElements()) {
                        URL nextElement = systemResources.nextElement();
                        if (nextElement != null) {
                            vector.addElement(nextElement);
                        }
                    }
                    if (vector.size() <= 0) {
                        return null;
                    }
                    urlArr = new URL[vector.size()];
                    vector.copyInto(urlArr);
                    return urlArr;
                } catch (IOException | SecurityException unused) {
                    return urlArr;
                }
            }
        });
    }

    private void loadAddressMap(Class cls) {
        StreamLoader streamLoader = new StreamLoader() { // from class: javax.mail.Session.2
            @Override // javax.mail.StreamLoader
            public void load(InputStream inputStream) throws IOException {
                Session.this.addressMap.load(inputStream);
            }
        };
        loadResource("/META-INF/javamail.default.address.map", cls, streamLoader);
        loadAllResources("META-INF/javamail.address.map", cls, streamLoader);
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("javamail.address.map");
            loadFile(sb.toString(), streamLoader);
        } catch (SecurityException e6) {
            if (this.debug) {
                pr("DEBUG: can't get java.home: " + e6);
            }
        }
        if (this.addressMap.isEmpty()) {
            if (this.debug) {
                pr("DEBUG: failed to load address map, using defaults");
            }
            this.addressMap.put("rfc822", "smtp");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(3:17|18|(2:20|(1:22))(2:31|(1:33)))|(2:30|28)|24|25|27|28) */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadAllResources(java.lang.String r9, java.lang.Class r10, javax.mail.StreamLoader r11) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.Session.loadAllResources(java.lang.String, java.lang.Class, javax.mail.StreamLoader):void");
    }

    private void loadFile(String str, StreamLoader streamLoader) {
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
                    try {
                        streamLoader.load(bufferedInputStream2);
                        if (this.debug) {
                            pr("DEBUG: successfully loaded file: " + str);
                        }
                        bufferedInputStream2.close();
                    } catch (IOException e6) {
                        e = e6;
                        bufferedInputStream = bufferedInputStream2;
                        if (this.debug) {
                            pr("DEBUG: not loading file: " + str);
                            pr("DEBUG: " + e);
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    } catch (SecurityException e7) {
                        e = e7;
                        bufferedInputStream = bufferedInputStream2;
                        if (this.debug) {
                            pr("DEBUG: not loading file: " + str);
                            pr("DEBUG: " + e);
                        }
                        if (bufferedInputStream == null) {
                            return;
                        }
                        bufferedInputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e = e8;
                } catch (SecurityException e9) {
                    e = e9;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void loadProviders(Class cls) {
        StreamLoader streamLoader = new StreamLoader() { // from class: javax.mail.Session.1
            @Override // javax.mail.StreamLoader
            public void load(InputStream inputStream) throws IOException {
                Session.this.loadProvidersFromStream(inputStream);
            }
        };
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("javamail.providers");
            loadFile(sb.toString(), streamLoader);
        } catch (SecurityException e6) {
            if (this.debug) {
                pr("DEBUG: can't get java.home: " + e6);
            }
        }
        loadAllResources("META-INF/javamail.providers", cls, streamLoader);
        loadResource("/META-INF/javamail.default.providers", cls, streamLoader);
        if (this.providers.size() == 0) {
            if (this.debug) {
                pr("DEBUG: failed to load any providers, using defaults");
            }
            Provider.Type type = Provider.Type.STORE;
            addProvider(new Provider(type, "imap", "com.sun.mail.imap.IMAPStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(type, "imaps", "com.sun.mail.imap.IMAPSSLStore", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(type, "pop3", "com.sun.mail.pop3.POP3Store", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(type, "pop3s", "com.sun.mail.pop3.POP3SSLStore", "Sun Microsystems, Inc.", Version.version));
            Provider.Type type2 = Provider.Type.TRANSPORT;
            addProvider(new Provider(type2, "smtp", "com.sun.mail.smtp.SMTPTransport", "Sun Microsystems, Inc.", Version.version));
            addProvider(new Provider(type2, "smtps", "com.sun.mail.smtp.SMTPSSLTransport", "Sun Microsystems, Inc.", Version.version));
        }
        if (this.debug) {
            pr("DEBUG: Tables of loaded providers");
            pr("DEBUG: Providers Listed By Class Name: " + this.providersByClassName.toString());
            pr("DEBUG: Providers Listed By Protocol: " + this.providersByProtocol.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadProvidersFromStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return;
        }
        LineInputStream lineInputStream = new LineInputStream(inputStream);
        while (true) {
            String readLine = lineInputStream.readLine();
            if (readLine == null) {
                return;
            }
            if (!readLine.startsWith("#")) {
                StringTokenizer stringTokenizer = new StringTokenizer(readLine, ";");
                Provider.Type type = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                while (stringTokenizer.hasMoreTokens()) {
                    String trim = stringTokenizer.nextToken().trim();
                    int indexOf = trim.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (trim.startsWith("protocol=")) {
                        str = trim.substring(indexOf + 1);
                    } else if (trim.startsWith("type=")) {
                        String substring = trim.substring(indexOf + 1);
                        if (substring.equalsIgnoreCase("store")) {
                            type = Provider.Type.STORE;
                        } else if (substring.equalsIgnoreCase(NotificationCompat.CATEGORY_TRANSPORT)) {
                            type = Provider.Type.TRANSPORT;
                        }
                    } else if (trim.startsWith("class=")) {
                        str2 = trim.substring(indexOf + 1);
                    } else if (trim.startsWith("vendor=")) {
                        str3 = trim.substring(indexOf + 1);
                    } else if (trim.startsWith("version=")) {
                        str4 = trim.substring(indexOf + 1);
                    }
                }
                if (type != null && str != null && str2 != null && str.length() > 0 && str2.length() > 0) {
                    addProvider(new Provider(type, str, str2, str3, str4));
                } else if (this.debug) {
                    pr("DEBUG: Bad provider entry: " + readLine);
                }
            }
        }
    }

    private void loadResource(String str, Class cls, StreamLoader streamLoader) {
        InputStream inputStream = null;
        try {
            try {
                try {
                    try {
                        InputStream resourceAsStream = getResourceAsStream(cls, str);
                        if (resourceAsStream != null) {
                            streamLoader.load(resourceAsStream);
                            if (this.debug) {
                                pr("DEBUG: successfully loaded resource: " + str);
                            }
                        } else if (this.debug) {
                            pr("DEBUG: not loading resource: " + str);
                        }
                        if (resourceAsStream != null) {
                            resourceAsStream.close();
                        }
                    } catch (IOException e6) {
                        if (this.debug) {
                            pr("DEBUG: " + e6);
                        }
                        if (0 == 0) {
                            return;
                        }
                        inputStream.close();
                    }
                } catch (SecurityException e7) {
                    if (this.debug) {
                        pr("DEBUG: " + e7);
                    }
                    if (0 == 0) {
                        return;
                    }
                    inputStream.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
        }
    }

    private static InputStream openStream(final URL url) throws IOException {
        try {
            return (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() { // from class: javax.mail.Session.7
                @Override // java.security.PrivilegedExceptionAction
                public Object run() throws IOException {
                    return url.openStream();
                }
            });
        } catch (PrivilegedActionException e6) {
            throw ((IOException) e6.getException());
        }
    }

    public PasswordAuthentication getPasswordAuthentication(URLName uRLName) {
        return (PasswordAuthentication) this.authTable.get(uRLName);
    }

    public Properties getProperties() {
        return this.props;
    }

    public String getProperty(String str) {
        return this.props.getProperty(str);
    }

    public Store getStore(String str) throws NoSuchProviderException {
        return getStore(new URLName(str, null, -1, null, null, null));
    }

    public Transport getTransport(String str) throws NoSuchProviderException {
        return getTransport(new URLName(str, null, -1, null, null, null));
    }

    public PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i6, String str, String str2, String str3) {
        Authenticator authenticator = this.authenticator;
        if (authenticator != null) {
            return authenticator.requestPasswordAuthentication(inetAddress, i6, str, str2, str3);
        }
        return null;
    }

    public void setPasswordAuthentication(URLName uRLName, PasswordAuthentication passwordAuthentication) {
        if (passwordAuthentication == null) {
            this.authTable.remove(uRLName);
        } else {
            this.authTable.put(uRLName, passwordAuthentication);
        }
    }

    private Session(Properties properties, Authenticator authenticator) {
        Class<?> cls;
        this.debug = false;
        this.props = properties;
        this.authenticator = authenticator;
        if (Boolean.valueOf(properties.getProperty("mail.debug")).booleanValue()) {
            this.debug = true;
        }
        if (this.debug) {
            pr("DEBUG: JavaMail version 1.4.1");
        }
        if (authenticator != null) {
            cls = authenticator.getClass();
        } else {
            cls = Session.class;
        }
        loadProviders(cls);
        loadAddressMap(cls);
    }

    private void pr(String str) {
        getDebugOut().getClass();
    }

    public Folder getFolder(URLName uRLName) throws MessagingException {
        Store store = getStore(uRLName);
        store.connect();
        return store.getFolder(uRLName);
    }

    public Store getStore(URLName uRLName) throws NoSuchProviderException {
        return getStore(getProvider(uRLName.getProtocol()), uRLName);
    }

    public Transport getTransport(URLName uRLName) throws NoSuchProviderException {
        return getTransport(getProvider(uRLName.getProtocol()), uRLName);
    }

    public Store getStore(Provider provider) throws NoSuchProviderException {
        return getStore(provider, null);
    }

    public Transport getTransport(Provider provider) throws NoSuchProviderException {
        return getTransport(provider, null);
    }

    private Store getStore(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider != null && provider.getType() == Provider.Type.STORE) {
            try {
                return (Store) getService(provider, uRLName);
            } catch (ClassCastException unused) {
                throw new NoSuchProviderException("incorrect class");
            }
        }
        throw new NoSuchProviderException("invalid provider");
    }

    public Transport getTransport(Address address) throws NoSuchProviderException {
        String str = (String) this.addressMap.get(address.getType());
        if (str != null) {
            return getTransport(str);
        }
        throw new NoSuchProviderException("No provider for Address type: " + address.getType());
    }

    public static Session getDefaultInstance(Properties properties) {
        return getDefaultInstance(properties, null);
    }

    private Transport getTransport(Provider provider, URLName uRLName) throws NoSuchProviderException {
        if (provider != null && provider.getType() == Provider.Type.TRANSPORT) {
            try {
                return (Transport) getService(provider, uRLName);
            } catch (ClassCastException unused) {
                throw new NoSuchProviderException("incorrect class");
            }
        }
        throw new NoSuchProviderException("invalid provider");
    }
}
