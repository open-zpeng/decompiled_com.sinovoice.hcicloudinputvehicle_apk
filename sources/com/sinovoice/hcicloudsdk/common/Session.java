package com.sinovoice.hcicloudsdk.common;
/* loaded from: classes.dex */
public class Session {
    public static final int INVALID_SESSION_ID = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f319a = -1;

    public Session copy() {
        Session session = new Session();
        session.setSessionId(this.f319a);
        return session;
    }

    public boolean equal(Session session) {
        return session != null && session.getSessionId() == this.f319a;
    }

    public int getSessionId() {
        return this.f319a;
    }

    public void setSessionId(int i) {
        this.f319a = i;
    }
}
