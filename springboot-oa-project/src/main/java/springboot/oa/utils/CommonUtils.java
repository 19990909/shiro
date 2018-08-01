package springboot.oa.utils;

/**
 * Created by Administrator on 2018/3/16.
 */
public class CommonUtils {
    public static final String  SESSION_USER = "user";
    public static final String  USER_STATUS_OK = "1"; //用户有效状态
    public static final String  ADMIN_SITE_ID = "1"; //确权登记系统
    public static final String  NO_USER_EXCEPTION = "no_user"; //用户不存在标识
    public static final String  NO_PERMISSION_EXCEPTION = "no_permission"; //没有权限标识


    public static final String  FUNC_TYPE_SITE = "0"; //功能类别的站点类别
    public static final String  FUNC_TYPE_SYSTEM_TITLE = "1";  //功能类别的标题
    public static final String  FUNC_TYPE_SYSTEM_BLOCK = "2";  //功能类别的模块
    public static final String  FUNC_TYPE_SYSTEM_MENU = "3";  //功能类别的菜单
    public static final String  FUNC_TYPE_SYSTEM_BUTTON = "4";  //功能类别的按钮

    public static void main(String[] args){
        String str ="https://106.3.43.155:9999";
        str = str.replace("\\\\","//").replace("\\","/");
        System.out.println(str.matches("((http://|https://){1}\\d{2,3}([.]\\d{1,3}){3}:\\d{2,5})"));
    }
}
