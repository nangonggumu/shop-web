package utils.log;

import java.util.List;

/**
 * @Description:
 * @Author zhangqiang
 * @Date Created by 2018/6/20 on 下午4:50.
 */
public class CustomListUtils {


    public static <T> boolean listIfNotNull(List<T> list){
        if(list!=null && list.size()>0){
            return true;
        }
        return false;
    }
    public static <T> boolean listIfOne(List<T> list){
        if(list!=null && list.size()==1){
            return true;
        }
        return false;
    }
}
