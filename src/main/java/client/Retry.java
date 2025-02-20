package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Retry {
    public static <T> List<T> exec(Supplier<List<T>> execBody) {
        return exec(execBody, 1000, 10);
    }

    private static final Logger log = LoggerFactory.getLogger(Retry.class);

    public static <T> List<T> exec(Supplier<List<T>> execBody, int retryTimes, int intervalTimes) {
        boolean isLoop = true;
        int count = 0;
        while (isLoop && count++ < retryTimes) {
            try {
                List<T> result = execBody.get();
                isLoop = result == null;
                if (isLoop == false) {
                    return result;
                }
                log.info("第{}次重试获取数据。", count);
                CmUtil.sleep(intervalTimes);
            } catch (Exception e) {
                log.error("第{}次重试获取数据失败。", count, e);
                CmUtil.sleep(intervalTimes);
            }
        }
        return new ArrayList<>();
    }

    public static boolean execBoolean(Supplier<Boolean> execBody, int retryTimes, int intervalTimes) {
        boolean isLoop = true;
        int count = 0;
        while (isLoop && count++ < retryTimes) {
            try {
                boolean isSuccess = execBody.get();
                if (isSuccess) {
                    return true;
                }
                log.info("第{}次重试获取数据。", count);
                TimeUnit.SECONDS.sleep(intervalTimes);
            } catch (Exception e) {
                log.error("第{}次重试获取数据失败。", count, e);
                CmUtil.sleep(intervalTimes);
            }
        }
        return false;
    }
}
