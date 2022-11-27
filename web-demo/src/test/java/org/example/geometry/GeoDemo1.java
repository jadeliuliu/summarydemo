package org.example.geometry;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.WKBReader;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;
import org.junit.Test;

import java.text.ParseException;

/**
 * @author: liuxuan
 * @date: 2022-09-11 16:26
 **/
public class GeoDemo1 {

    @Test
    public void geoTest() throws ParseException, com.vividsolutions.jts.io.ParseException {
        //1.string类型转为geometry
        /**
         * GeometryFactory工厂，参数一：数据精度 参数二空间参考系SRID
         */
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);

        /**
         * 熟知文本WKT阅读器，可以将WKT文本转换为Geometry对象
         */
        WKTReader wktReader = new WKTReader(geometryFactory);

        /**
         * Geometry对象，包含Point、LineString、Polygon等子类
         */
        Geometry geometry = wktReader.read("POINT (113.53896635 22.36429837)");
        System.out.println("geometry:" + geometry);


        //2.geometry对象转为string
        /**
         * 单纯的一个坐标点，单点可以创建Point，多点可以创建LineString、Polygon等
         */
        Coordinate coordinate = new Coordinate(113.53896635, 22.36429837);
        Point point = geometryFactory.createPoint(coordinate);

        Polygon polygon = geometryFactory.createPolygon(new Coordinate[]{
                new Coordinate(1, 2),
                new Coordinate(1, 2),
                new Coordinate(1, 2),
                new Coordinate(1, 2),
                new Coordinate(1, 2),
        });
        Geometry geometry1 = point;
        Geometry geometry2 = polygon;

        /**
         * WKT输出器，将Geometry对象写出为WKT文本
         */
        WKTWriter wktWriter = new WKTWriter();
        String pointString = wktWriter.write(point);
        System.out.println("point string: " + pointString);
        String geoString = wktWriter.write(geometry1);
        System.out.println("geo string: " + geoString);
    }

    @Test
    public void test2() throws com.vividsolutions.jts.io.ParseException {
        WKTReader wktReader = new WKTReader();
        Geometry geometry1 = wktReader.read("LineString(113.53896635 22.36429837, 113.53896645 22.36429847)");
        Geometry geometry2 = wktReader.read("LineString(113.53896645 22.36429847, 113.53896655 22.36429857)");
        Geometry geometry3 = geometry1.union(geometry2);
        System.out.println(geometry3);
    }


}
