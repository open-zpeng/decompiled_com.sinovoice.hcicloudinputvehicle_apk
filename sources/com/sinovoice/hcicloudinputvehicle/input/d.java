package com.sinovoice.hcicloudinputvehicle.input;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.sinovoice.hcicloudinputvehicle.service.HciCloudInputConnection;
import com.sinovoice.hcicloudsdk.common.HciErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: InputMethod.java */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    protected Handler f178a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f179b;
    protected HciCloudInputConnection c;
    protected List<String> d = Collections.synchronizedList(new ArrayList());
    protected List<String> e = Collections.synchronizedList(new ArrayList());
    private List<String> f = Collections.synchronizedList(new ArrayList());
    protected int g;

    public d(Handler handler, Context context, HciCloudInputConnection hciCloudInputConnection) {
        this.f178a = handler;
        this.f179b = context;
        this.c = hciCloudInputConnection;
    }

    public abstract void a(char c);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        List<String> list = this.d;
        if (list != null) {
            list.clear();
        }
        List<String> list2 = this.e;
        if (list2 != null) {
            list2.clear();
        }
    }

    protected void c() {
        this.f.clear();
        this.f.addAll(this.d);
    }

    public abstract void d();

    public String e() {
        return "";
    }

    public abstract void f(short[] sArr);

    public abstract void g();

    public abstract void h(int i);

    public abstract void i();

    public abstract void j();

    public abstract void k(int i);

    public abstract void l();

    public abstract void m(int i);

    public abstract void n(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        Message obtainMessage = this.f178a.obtainMessage(HciErrorCode.HCI_ERR_HWR_CONFIRM_NO_TASK);
        obtainMessage.obj = this.e;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        c();
        Message obtainMessage = this.f178a.obtainMessage(HciErrorCode.HCI_ERR_HWR_ALREADY_INIT);
        obtainMessage.obj = this.f;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        b();
        this.c.commitComposingStr("");
        p();
    }

    public void r() {
        b();
        q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(int i) {
        t(this.f179b.getResources().getString(i));
    }

    protected void t(String str) {
        Message obtainMessage = this.f178a.obtainMessage(456);
        this.f178a.removeMessages(456);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }
}
