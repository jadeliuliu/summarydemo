package org.example.geometry;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: liuxuan
 * @date: 2022-11-21 22:40
 **/
public class GeoDemo2 {

    @Test
    public void test1() {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);
        Polygon polygon = geometryFactory.createPolygon(new Coordinate[]{
                new Coordinate(1, 2),
                new Coordinate(1, 2),
                new Coordinate(1, 2),
                new Coordinate(1, 2),
                new Coordinate(1, 2),
        });
        System.out.println(polygon.isValid());
    }

    @Test
    public void equalsGeometry() throws com.vividsolutions.jts.io.ParseException {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);
        WKTReader reader = new WKTReader( geometryFactory );
        String wkt1 = "LINESTRING(0 0, 3 0, 10 0)";
        String wkt2 = "LINESTRING(3 0, 1 0)";
        LineString geometry1 = (LineString) reader.read(wkt1);
        LineString geometry2 = (LineString) reader.read(wkt2);
        boolean b1 = geometry1.equals(geometry2);//false
        System.out.println(b1);

        wkt1 = "LINESTRING(0 0, 3 0, 10 0)";
        wkt2 = "LINESTRING(10 0, 0 0)";
        geometry1 = (LineString) reader.read(wkt1);
        geometry2 = (LineString) reader.read(wkt2);
        boolean b2 = geometry1.equals(geometry2);//true
        System.out.println(b2);
    }

    @Test
    public void crossGeometry() throws com.vividsolutions.jts.io.ParseException {
        GeometryFactory geometryFactory = new GeometryFactory();
        //情景1
        WKTReader reader = new WKTReader(geometryFactory);
        String wkt1 = "LINESTRING(0 0, 3 0, 10 0)";
        String wkt2 = "LINESTRING(3 0, 1 0)";
        LineString geometry1 = (LineString) reader.read(wkt1);
        LineString geometry2 = (LineString) reader.read(wkt2);
        boolean b1 = geometry1.crosses(geometry2);//false
        System.out.println(b1);
        //情景2
        wkt1 = "LINESTRING(0 0, 3 0, 10 0)";
        wkt2 = "LINESTRING(3 0, 1 1)";
        geometry1 = (LineString) reader.read(wkt1);
        geometry2 = (LineString) reader.read(wkt2);
        boolean b2 = geometry1.crosses(geometry2);//false
        System.out.println(b2);
        //情景3
        wkt1 = "LINESTRING(0 0, 3 0, 10 0)";
        wkt2 = "LINESTRING(4 0, -1 -1)";
        geometry1 = (LineString) reader.read(wkt1);
        geometry2 = (LineString) reader.read(wkt2);
        boolean b3 = geometry1.crosses(geometry2);//false
        System.out.println(b3);
        //情景4
        wkt1 = "LINESTRING(0 0, 3 0, 10 0)";
        wkt2 = "LINESTRING(0 4, 3 0, -1 -1)";
        geometry1 = (LineString) reader.read(wkt1);
        geometry2 = (LineString) reader.read(wkt2);
        boolean b4 = geometry1.crosses(geometry2);//true
        System.out.println(b4);
    }

    @Test
    public void testNearest() throws ParseException {
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(0, 1);
        WKTReader reader = new WKTReader(geometryFactory);
        String wkt = "LINESTRING(1 0, 2 0)";
        LineString road = (LineString) reader.read(wkt);
        Coordinate[] shadow = com.vividsolutions.jts.operation.distance.DistanceOp.nearestPoints(road,
                geometryFactory.createPoint(coordinate));
        System.out.println(Arrays.toString(shadow)); //[(1.0, 0.0, NaN), (1.0, 1.0, NaN)]

        Coordinate[] coor = road.getCoordinates();
        System.out.println(Arrays.toString(coor));

    }

}
