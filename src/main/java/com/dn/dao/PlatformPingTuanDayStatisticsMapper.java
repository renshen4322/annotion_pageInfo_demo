package com.dn.dao;


import com.dn.model.PlatformPingTuanDayStatistics;
import com.dn.request.PingTuanDayStatQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlatformPingTuanDayStatisticsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PlatformPingTuanDayStatistics record);

    int insertSelective(PlatformPingTuanDayStatistics record);

    PlatformPingTuanDayStatistics selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PlatformPingTuanDayStatistics record);

    int updateByPrimaryKey(PlatformPingTuanDayStatistics record);

    /**
     * 查询某天的拼团数据总计
     * @param currDate
     * @return
     */
    PlatformPingTuanDayStatistics queryPingTuanInfoByDate(@Param("currDate")String currDate);

    /**
     * 月总计拼团数据
     * @param currMonth
     * @return
     */
    PlatformPingTuanDayStatistics querySumPingTuanInfoByMonth(@Param("currMonth")String currMonth);

    /**
     * 查询count
     * @param query
     * @return
     */
    Integer getDayPingTuanInfoCount(PingTuanDayStatQuery query);

    /**
     * 查询日拼团列表数据
     * @param query
     * @return
     */
    List<PlatformPingTuanDayStatistics> getPingTuanDayStatList(PingTuanDayStatQuery query);
}