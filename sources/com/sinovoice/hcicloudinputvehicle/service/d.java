package com.sinovoice.hcicloudinputvehicle.service;

import com.sinovoice.hcicloudinputvehicle.taskscheduler.TaskSchedule;
/* compiled from: InputLogicControlProxy.java */
/* loaded from: classes.dex */
public class d implements InputLogicControlInterface {

    /* renamed from: a  reason: collision with root package name */
    private InputLogicControlInterface f193a;

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f194a;

        a(int i) {
            this.f194a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleCandChoosed(this.f194a);
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f196a;

        b(int i) {
            this.f196a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleSyllableChosen(this.f196a);
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleDelete();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* renamed from: com.sinovoice.hcicloudinputvehicle.service.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0013d implements Runnable {
        RunnableC0013d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleEnter();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleSpace();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleNextPage();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f202a;

        g(int i) {
            this.f202a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleShift(this.f202a);
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.clear();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.checkInitStatus();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.finishInput();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class k implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f207a;

        k(int i) {
            this.f207a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.onInputModeChange(this.f207a);
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.init();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.startSession();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.stopSession();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.release();
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f213a;

        p(int i) {
            this.f213a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleSymbol(this.f213a);
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f215a;

        q(String str) {
            this.f215a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.handleSymbol(this.f215a);
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class r implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f217a;

        r(CharSequence charSequence) {
            this.f217a = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.query(this.f217a);
        }
    }

    /* compiled from: InputLogicControlProxy.java */
    /* loaded from: classes.dex */
    class s implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ short[] f219a;

        s(short[] sArr) {
            this.f219a = sArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f193a.query(this.f219a);
        }
    }

    public void b(InputLogicControlInterface inputLogicControlInterface) {
        this.f193a = inputLogicControlInterface;
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void checkInitStatus() {
        TaskSchedule.runOnMainThread(new i());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void clear() {
        TaskSchedule.runOnChildThreadSync(new h());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void finishInput() {
        TaskSchedule.runOnChildThread(new j());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public com.sinovoice.hcicloudinputvehicle.input.d getCurrentInput() {
        return this.f193a.getCurrentInput();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public int getCurrentInputMode() {
        return this.f193a.getCurrentInputMode();
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleCandChoosed(int i2) {
        TaskSchedule.runOnChildThread(new a(i2));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleDelete() {
        TaskSchedule.runOnChildThread(new c());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleEnter() {
        TaskSchedule.runOnChildThread(new RunnableC0013d());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleNextPage() {
        TaskSchedule.runOnChildThread(new f());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleShift(int i2) {
        TaskSchedule.runOnChildThread(new g(i2));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleSpace() {
        TaskSchedule.runOnChildThread(new e());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleSyllableChosen(int i2) {
        TaskSchedule.runOnChildThread(new b(i2));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleSymbol(int i2) {
        TaskSchedule.runOnChildThread(new p(i2));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void init() {
        TaskSchedule.runOnChildThreadSync(new l());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void onInputModeChange(int i2) {
        TaskSchedule.runOnChildThreadSync(new k(i2));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void query(CharSequence charSequence) {
        TaskSchedule.runOnChildThread(new r(charSequence));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void release() {
        TaskSchedule.runOnChildThreadSync(new o());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void startSession() {
        TaskSchedule.runOnChildThreadSync(new m());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void stopSession() {
        TaskSchedule.runOnChildThreadSync(new n());
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void handleSymbol(String str) {
        TaskSchedule.runOnChildThread(new q(str));
    }

    @Override // com.sinovoice.hcicloudinputvehicle.service.InputLogicControlInterface
    public void query(short[] sArr) {
        TaskSchedule.runOnChildThread(new s(sArr));
    }
}
