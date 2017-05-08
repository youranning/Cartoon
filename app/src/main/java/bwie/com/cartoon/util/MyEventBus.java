package bwie.com.cartoon.util;

/**
 * Created by $USER_NAME on 2017/4/26.
 */

public class MyEventBus {
    boolean result;

    public MyEventBus(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
