package com.sinovoice.hcicloudinputvehicle.service;

import android.content.Context;
import android.os.Handler;
/* compiled from: InputLogicControl.java */
/* loaded from: classes.dex */
public class b implements InputLogicControlInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f191a = "com.sinovoice.hcicloudinputvehicle.service.b";

    /* renamed from: b  reason: collision with root package name */
    private final com.sinovoice.hcicloudinputvehicle.input.d f192b;
    private final com.sinovoice.hcicloudinputvehicle.input.d c;
    private final com.sinovoice.hcicloudinputvehicle.input.c d;
    private final com.sinovoice.hcicloudinputvehicle.input.d e;
    private com.sinovoice.hcicloudinputvehicle.input.d f;
    private int g;
    private Context h;
    private Handler i;
    private HciCloudInputConnection j;
    private boolean k;
    private boolean l;

    public b(Context context, Handler handler, HciCloudInputConnection hciCloudInputConnection) {
        this.h = context;
        this.i = handler;
        this.j = hciCloudInputConnection;
        this.c = new com.sinovoice.hcicloudinputvehicle.input.e(handler, this.h, hciCloudInputConnection);
        this.f192b = new com.sinovoice.hcicloudinputvehicle.input.b(handler, this.h, hciCloudInputConnection);
        this.d = new com.sinovoice.hcicloudinputvehicle.input.c(handler, this.h, hciCloudInputConnection);
        this.e = new com.sinovoice.hcicloudinputvehicle.input.a(handler, this.h, hciCloudInputConnection);
    }

    private void a() {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(12121, Boolean.valueOf(this.k)));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void checkInitStatus() {
        if (this.k) {
            return;
        }
        init();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void clear() {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.r();
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void finishInput() {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.d();
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public com.sinovoice.hcicloudinputvehicle.input.d getCurrentInput() {
        return this.f;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public int getCurrentInputMode() {
        return this.g;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleCandChoosed(int i) {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.h(i);
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleDelete() {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.i();
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleEnter() {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.j();
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleNextPage() {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.g();
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleShift(int i) {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.k(i);
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleSpace() {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.l();
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleSyllableChosen(int i) {
        this.f.m(i);
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleSymbol(int i) {
        handleSymbol(String.valueOf((char) i));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void init() {
        this.k = com.sinovoice.hcicloudinputvehicle.a.b.c().d(this.h);
        a();
        com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().init(this.h);
        com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().init();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void onInputModeChange(int i) {
        b.b.a.b.a.c(f191a, "onInputModeChange()");
        this.g = i;
        if (i == 0) {
            this.f = this.c;
        } else if (i == 1) {
            this.f = this.f192b;
        } else if (i == 2) {
            com.sinovoice.hcicloudinputvehicle.input.c cVar = this.d;
            this.f = cVar;
            cVar.z(0);
        } else if (i == 3) {
            this.f = this.e;
        } else if (i != 20) {
        } else {
            com.sinovoice.hcicloudinputvehicle.input.c cVar2 = this.d;
            this.f = cVar2;
            cVar2.z(1);
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void query(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.a(charAt);
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void release() {
        com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().release();
        com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().release();
        com.sinovoice.hcicloudinputvehicle.a.b.c().f();
        this.k = false;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void startSession() {
        if (this.l) {
            return;
        }
        com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().startKBSession();
        com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().startHwrSession();
        com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().startHwrAssSession();
        this.l = true;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void stopSession() {
        com.sinovoice.hcicloudinputvehicle.engine.keyboard.b.a().stopKBSession();
        com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().stopHwrSession();
        com.sinovoice.hcicloudinputvehicle.engine.handwrite.c.a().stopHwrAssSession();
        this.l = false;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleSymbol(String str) {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.n(str);
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void query(short[] sArr) {
        com.sinovoice.hcicloudinputvehicle.input.d dVar = this.f;
        if (dVar != null) {
            dVar.f(sArr);
        } else {
            b.b.a.b.a.c(f191a, "getInputMethod() return null");
        }
    }
}
