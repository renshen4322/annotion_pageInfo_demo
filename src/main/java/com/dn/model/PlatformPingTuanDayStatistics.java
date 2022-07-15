package com.dn.model;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * platform_pingtuan_day_statistics
 * @author 
 */

public class PlatformPingTuanDayStatistics implements Serializable {
    private static final long serialVersionUID = -546591990071959781L;
    /**
     * 主键
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStatisticsofday() {
        return statisticsofday;
    }

    public void setStatisticsofday(Date statisticsofday) {
        this.statisticsofday = statisticsofday;
    }

    public Integer getTotalpingtuancount() {
        return totalpingtuancount;
    }

    public void setTotalpingtuancount(Integer totalpingtuancount) {
        this.totalpingtuancount = totalpingtuancount;
    }

    public Integer getTotalpingtuanpersons() {
        return totalpingtuanpersons;
    }

    public void setTotalpingtuanpersons(Integer totalpingtuanpersons) {
        this.totalpingtuanpersons = totalpingtuanpersons;
    }

    public BigDecimal getPlatgranttotalmoney() {
        return platgranttotalmoney;
    }

    public void setPlatgranttotalmoney(BigDecimal platgranttotalmoney) {
        this.platgranttotalmoney = platgranttotalmoney;
    }

    public BigDecimal getGrantredbagamt() {
        return grantredbagamt;
    }

    public void setGrantredbagamt(BigDecimal grantredbagamt) {
        this.grantredbagamt = grantredbagamt;
    }

    public BigDecimal getAgentrebateamount() {
        return agentrebateamount;
    }

    public void setAgentrebateamount(BigDecimal agentrebateamount) {
        this.agentrebateamount = agentrebateamount;
    }

    public BigDecimal getTotalgrantjifeng() {
        return totalgrantjifeng;
    }

    public void setTotalgrantjifeng(BigDecimal totalgrantjifeng) {
        this.totalgrantjifeng = totalgrantjifeng;
    }

    /**
     * 拼团统计日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date statisticsofday;

    /**
     * 总拼团次数
     */
    private Integer totalpingtuancount;

    /**
     * 总拼团人数
     */
    private Integer totalpingtuanpersons;

    /**
     * 平台总发放金额
     */
    private BigDecimal platgranttotalmoney;

    /**
     * 发放红包金额
     */
    private BigDecimal grantredbagamt;

    /**
     * 代理返利金额
     */
    private BigDecimal agentrebateamount;

    /**
     * 总积分发放
     */
    private BigDecimal totalgrantjifeng;

}