package domain.user.Service;

public interface PersonalService {
    /**
     * 获取本月听课节数
     * @param listenerId 听课人员id
     * @return Integer
     */
    Integer getThisMonthCount(Long listenerId);

    /**
     * 获取当前登录人,累计听课节数
     * @param listnerId 听课人员id
     * @return Integer
     */
    Integer getAllCount(Long listnerId);
}
