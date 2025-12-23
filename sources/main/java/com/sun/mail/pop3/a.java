package com.sun.mail.pop3;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends Folder {
    @Override // javax.mail.Folder
    public boolean create(int i6) throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return true;
    }

    @Override // javax.mail.Folder
    public int getMessageCount() throws MessagingException {
        return 0;
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // javax.mail.Folder
    public int getType() {
        return 2;
    }

    @Override // javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public boolean isOpen() {
        return false;
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    @Override // javax.mail.Folder
    public void close(boolean z5) throws MessagingException {
        throw new MethodNotSupportedException("close");
    }

    @Override // javax.mail.Folder
    public boolean delete(boolean z5) throws MessagingException {
        throw new MethodNotSupportedException("delete");
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("expunge");
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        if (str.equalsIgnoreCase("INBOX")) {
            return b();
        }
        throw new MessagingException("only INBOX supported");
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return "";
    }

    @Override // javax.mail.Folder
    public Message getMessage(int i6) throws MessagingException {
        throw new MethodNotSupportedException("getMessage");
    }

    @Override // javax.mail.Folder
    public String getName() {
        return "";
    }

    @Override // javax.mail.Folder
    public Flags getPermanentFlags() {
        return new Flags();
    }

    @Override // javax.mail.Folder
    public char getSeparator() {
        return '/';
    }

    @Override // javax.mail.Folder
    public void open(int i6) throws MessagingException {
        throw new MethodNotSupportedException("open");
    }

    @Override // javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }

    a(e eVar) {
        super(eVar);
    }

    protected Folder b() throws MessagingException {
        return getStore().getFolder("INBOX");
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        return new Folder[]{b()};
    }
}
