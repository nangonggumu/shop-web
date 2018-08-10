import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.logging.log4j.core.util.UuidUtil;
import utils.log.Constant;
import utils.log.LogUtil;
import utils.log.TraceIDUtils;

/**
 * @Description:
 * @Author zhangqiang
 * @Date Created by 2018/7/10 on 下午4:18.
 */
public class Test {
    private static Logger logger = Logger.getLogger(Test.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println("This is println message.");

        TraceIDUtils.addTraceID();
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
        LogUtil.info("aaaaaaaaaaaaaaaaa");
    }

}
