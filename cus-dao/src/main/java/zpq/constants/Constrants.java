package zpq.constants;

public class Constrants {
    public static final String MANAGER = "MANAGER";//管理员
    public static final String CUSSERVICER = "CUSSERVICER";//客服
    public static final String MAINMAN = "MAINMAN";//维修人员
    public static final String CUSTOMER = "CUSTOMER";//客户

    //
    private static Object domainClass;

    public static Object getDomainClass() {
        return domainClass;
    }

    public static void setDomainClass(Object domainClass) {
        Constrants.domainClass = domainClass;
    }

    public static void setDomainClassByHunmanType(String hunmanType) {
        switch (hunmanType) {
            case MANAGER:
                setDomainClass(zpq.bean.Manager.class);
                break;
            case CUSSERVICER:
                setDomainClass(zpq.bean.Css.class);
                break;
            case MAINMAN:
                setDomainClass(zpq.bean.MainMan.class);
                break;
            case CUSTOMER:
                setDomainClass(zpq.bean.Customer.class);
                break;
            default:
                break;
        }
    }

    //
    public static  final String REDIS_USER_ACCOUNT = "REDIS_USER_ACCOUNT";
}
