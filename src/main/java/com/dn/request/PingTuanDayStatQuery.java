/*
package com.dn.request;

import com.dn.page.Query;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * Description:
 *
 * @Date:2022/7/13 14:20
 * @Author: mark
 *//*

public class PingTuanDayStatQuery extends Query<PlatformPingTuanDayStatistics> {
    private String querystarttime;
    private String queryendtime;

    public String getQuerystarttime() {
        return querystarttime;
    }

    public void setQuerystarttime(String querystarttime) {
        this.querystarttime = querystarttime;
    }

    public String getQueryendtime() {
        return queryendtime;
    }

    public void setQueryendtime(String queryendtime) {
        this.queryendtime = queryendtime;
    }

    @Override
    protected Map<String, String> initAllowSortBy() {
        return new HashMap<String, String>() {{
            put("id", "id");
            put("statisticsofday","statisticsofday");
        }};
    }

    @Override
    protected String[] initQueryFields() {
        return new String[]{"id","statisticsofday","totalpingtuancount","totalpingtuanpersons","platgranttotalmoney","grantredbagamt","agentrebateamount","totalgrantjifeng"};
    }
}
*/
