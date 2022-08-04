package com.dn.test;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxRecord;
import com.influxdb.query.FluxTable;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 *
 * @Date:2022/8/2 17:14
 * @Author:
 */
public class InfluxDB2Example {
    public static void main(final String[] args) throws InterruptedException {

        // You can generate a Token from the "Tokens Tab" in the UI
        String token = "ZR62OjUjQ6p-SwV8qUV7hSfXwO2ArTTWRYToNHX8pchsgjMDljgtq7mgVZlGus5e3HvgieGeh5AFsn-x-JEXIQ==";
        String bucket = "influxdb";
        String org = "tsp";
        InfluxDBClient client = InfluxDBClientFactory.create("http://192.168.161.131:8086", token.toCharArray());
        // System.out.println(client.getAuthorizationsApi().findAuthorizations());
        System.out.println(client.getUsersApi().me());
        String data = "mem,host=host1 used_percent=23.43234543";
        try (WriteApi writeApi = client.getWriteApi()) {
            writeApi.writeRecord(bucket, org, WritePrecision.NS, data);
        }
        Point point = Point
                .measurement("mem")
                .addTag("host", "host1")
                .addField("used_percent", 23.43234543)
                .time(Instant.now(), WritePrecision.NS);

        try (WriteApi writeApi = client.getWriteApi()) {
            writeApi.writePoint(bucket, org, point);
        }
        String query = "from(bucket: \"influxdb\") |> range(start: -1h)";
        List<FluxTable> tables = client.getQueryApi().query(query, org);

        int count = 0;
        for (FluxTable table : tables) {
            for (FluxRecord record : table.getRecords()) {
                count++;
                System.out.println(record);
            }
        }
        System.out.println("count===" + count);
/*        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    //准备完毕……运动员都阻塞在这，等待号令
                    countDownLatch.await();
                    String parter = "【" + Thread.currentThread().getName() + "】";
                    System.out.println(parter + "开始执行……");
                    extractedMem(bucket, org, client);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(1000);// 裁判准备发令
        countDownLatch.countDown();// 发令枪：执行发令*/


    }

    private static void extractedMem(String bucket, String org, InfluxDBClient client) {
        Mem mem = new Mem();
        mem.host = "host1";
        mem.used_percent = 23.43234543;
        mem.time = Instant.now();

        try (WriteApi writeApi = client.getWriteApi()) {
            writeApi.writeMeasurement(bucket, org, WritePrecision.NS, mem);
        }
    }

    @Measurement(name = "mem")
    public static class Mem {
        @Column(tag = true)
        String host;
        @Column
        Double used_percent;
        @Column(timestamp = true)
        Instant time;
    }


}
