package com.github.wslf.utils.time;

import java.util.concurrent.TimeUnit;

/**
 * Class is used for making delays without exceptions.
 *
 * @author Wsl_F
 */
public class Expector {

    /**
     * Waits specified time.
     *
     * @param time_ms time in milliseconds
     * @return successfulness
     */
    public boolean delay(int time_ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(time_ms);
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    /**
     * Waits specified time.
     *
     * @param time_s time in seconds
     * @return successfulness
     */
    public boolean delaySec(int time_s) {
        return delay(1000 * time_s);
    }

    /**
     * Waits specified time.
     *
     * @param time_s time in seconds
     * @return successfulness
     */
    public boolean delaySec(double time_s) {
        return delay((int) (1000 * time_s));
    }

}
