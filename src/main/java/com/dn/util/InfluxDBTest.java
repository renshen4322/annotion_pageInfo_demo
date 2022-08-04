package com.dn.util;

import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @Date:2022/8/3 14:24
 * @Author:
 */
public class InfluxDBTest {

    public static void main(String[] args) {

        BatchInsertData();

    }

    public static void BatchInsertData(){
        InfluxDBConnection influxDBConnection = new InfluxDBConnection("tspflux", "gu425006", "http://192.168.161.131:8086", "influxdb", "hour");
        Map<String, String> tags = new HashMap<String, String>();
        tags.put("tag1", "标签值");
        Map<String, Object> fields1 = new HashMap<String, Object>();
        fields1.put("field1", "abc");

        // 数值型，InfluxDB的字段类型，由第一天插入的值得类型决定
        fields1.put("field2", 123456);
        Map<String, Object> fields2 = new HashMap<String, Object>();
        fields2.put("field1", "String类型");
        fields2.put("field2", 3.141592657);
        // 一条记录值
        Point point1 = influxDBConnection.pointBuilder("表名", 2L,TimeUnit.MILLISECONDS, tags, fields1);
        Point point2 = influxDBConnection.pointBuilder("表名", 2L,TimeUnit.MILLISECONDS, tags, fields2);
        // 将两条记录添加到batchPoints中
        BatchPoints batchPoints1 = BatchPoints.database("influxdb").tag("tag1", "标签值1").retentionPolicy("hour")
                .consistency(InfluxDB.ConsistencyLevel.ALL).build();
        BatchPoints batchPoints2 = BatchPoints.database("influxdb").tag("tag2", "标签值2").retentionPolicy("hour")
                .consistency(InfluxDB.ConsistencyLevel.ALL).build();
        batchPoints1.point(point1);
        batchPoints2.point(point2);
        // 将两条数据批量插入到数据库中
        influxDBConnection.batchInsert(batchPoints1, TimeUnit.MILLISECONDS);
        influxDBConnection.batchInsert(batchPoints2,TimeUnit.MILLISECONDS);

    }
}
