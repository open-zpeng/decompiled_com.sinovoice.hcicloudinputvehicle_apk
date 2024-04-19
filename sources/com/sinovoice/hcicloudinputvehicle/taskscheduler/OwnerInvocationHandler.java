package com.sinovoice.hcicloudinputvehicle.taskscheduler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class OwnerInvocationHandler implements InvocationHandler {
    Object object;

    public OwnerInvocationHandler(Object obj) {
        this.object = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, final Method method, final Object[] objArr) {
        TaskType taskType = (TaskType) method.getAnnotation(TaskType.class);
        if (taskType == null) {
            try {
                method.invoke(this.object, objArr);
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return null;
            }
        } else if (taskType.taskType() == MethodRunOnThread.UI) {
            TaskSchedule.runOnMainThread(new Runnable() { // from class: com.sinovoice.hcicloudinputvehicle.taskscheduler.OwnerInvocationHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        method.invoke(OwnerInvocationHandler.this.object, objArr);
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                    } catch (InvocationTargetException e4) {
                        e4.printStackTrace();
                    }
                }
            });
            return null;
        } else if (taskType.taskType() == MethodRunOnThread.LOCAL) {
            TaskSchedule.runOnChildThread(new Runnable() { // from class: com.sinovoice.hcicloudinputvehicle.taskscheduler.OwnerInvocationHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        method.invoke(OwnerInvocationHandler.this.object, objArr);
                    } catch (IllegalAccessException e3) {
                        e3.printStackTrace();
                    } catch (InvocationTargetException e4) {
                        e4.printStackTrace();
                    }
                }
            });
            return null;
        } else {
            return null;
        }
    }
}
