package kpi;

import javafx.animation.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 800);

        //Background rectangle
        Rectangle rect1 = new Rectangle(0, 0, 240, 235);

        rect1.setFill(Color.LIGHTBLUE);
        root.getChildren().add(rect1);

        //Body
        {
            Ellipse ellipse = new Ellipse();
            ellipse.setCenterX(115);
            ellipse.setCenterY(140);
            ellipse.setRadiusX(95);
            ellipse.setRadiusY(95);
            ellipse.setFill(Color.BLACK);
            root.getChildren().add(ellipse);
        }



        // Hair
        {
            Path p = new Path();
            MoveTo mv = new MoveTo(135, 50);
            QuadCurveTo qt1 = new QuadCurveTo(122, 20, 85, 10);
            QuadCurveTo qt2 = new QuadCurveTo(56, 7, 58, 35);
            QuadCurveTo qt3 = new QuadCurveTo(84, 36, 95,46);
            p.setStrokeWidth(5);
            p.setStrokeLineJoin(StrokeLineJoin.ROUND);
            p.setStrokeLineCap(StrokeLineCap.ROUND);
            p.setStroke(Color.BLACK);
            p.setFill(Color.BLACK);
            p.getElements().addAll(mv, qt1, qt2, qt3);
            root.getChildren().add(p);

        }

        // Lower gray ellipse
        {
            Path p = new Path();
            MoveTo mv = new MoveTo(55, 213);
            QuadCurveTo qt1 = new QuadCurveTo(135, 120, 188, 200);
            QuadCurveTo qt2 = new QuadCurveTo(130, 265, 55, 213);
            p.setFill(Color.DARKGRAY);
            p.getElements().addAll(mv, qt1, qt2);
            root.getChildren().add(p);
        }

        // Hairstyle
        {
            Path p = new Path();
            p.getElements().addAll(
                    new MoveTo(88, 23),
                    new LineTo(99, 17),
                    new LineTo(78, 14),
                    new ArcTo(1, 1, 0, 73, 30, false, false),
                    new LineTo(90, 32),
                    new LineTo(88, 23)
            );
            p.setStrokeWidth(1);
            p.setFill(Color.DARKORANGE);
            root.getChildren().add(p);
        }

        //Head white round
        {
            Path p1 = new Path();
            MoveTo m = new MoveTo(145,80);
            QuadCurveTo qt = new QuadCurveTo(160, 65, 130, 60);
            p1.setFill(Color.WHITE);
            p1.setStroke(Color.WHITE);
            p1.getElements().addAll(m, qt);

            Line l = new Line();
            l.setStartX(145); l.setStartY(79);
            l.setEndX(130);   l.setEndY(62);
            l.setStrokeWidth(3);
            l.setStroke(Color.WHITE); l.setFill(Color.WHITE);

            Path p = new Path();
            MoveTo mv = new MoveTo(145, 80);
            QuadCurveTo qt1 = new QuadCurveTo(114, 76, 130, 60);
            p.setFill(Color.WHITE);
            p.setStroke(Color.WHITE);
            p.getElements().addAll(mv, qt1);
            root.getChildren().addAll(p, l, p1);
        }

        //mouth lower part
        {
            Path p = new Path();
            p.getElements().addAll(
                    new MoveTo(115, 140),
                    new LineTo(152, 121),
                    new LineTo(180, 130),
                    new ArcTo(6, 3, -15, 115, 140, false, true)
            );
            p.setStrokeWidth(1);
            p.setFill(Color.ORANGE);
            p.setStrokeLineCap(StrokeLineCap.ROUND);
            p.setStrokeLineJoin(StrokeLineJoin.ROUND);
            root.getChildren().add(p);
        }

        //mouth white part
        {
            Path p = new Path();
            p.setStrokeWidth(1);
            p.setStroke(Color.WHITE);
            p.setFill(Color.WHITE);
            p.getElements().add(new MoveTo(145, 120));
            p.getElements().add(new QuadCurveTo(122, 118, 116, 124));
            //p.getElements().add(new LineTo(116, 124));
            p.getElements().add(new ArcTo(3, 3, 0, 120, 133, false, false));
            root.getChildren().add(p);
        }

        //mouth upper part
        {
            Path p = new Path();
            p.getElements().addAll(
                    new MoveTo(115, 115),
                    new LineTo(132, 105),
                    new QuadCurveTo(169, 101, 193, 132),
                    new QuadCurveTo(160, 112, 115, 115)
            );
            p.setStrokeWidth(1);
            p.setFill(Color.ORANGE);
            root.getChildren().add(p);
        }

        //gray part
        {
            Path p = new Path();
            p.getElements().addAll(
                    new MoveTo(70, 95),
                    new ArcTo(4, 6,20, 104, 100, false, true),
                    new QuadCurveTo(70,115, 70, 95)
            );
            p.setStrokeWidth(1);
            p.setStroke(Color.GRAY);
            p.setFill(Color.GRAY);
            root.getChildren().add(p);

            Path path = new Path();
            path.getElements().addAll(
                    new MoveTo(160, 103),
                    new ArcTo(3, 6,0, 190, 120, false, true),
                    new QuadCurveTo(176,107, 160, 103)
            );

            path.setStrokeWidth(1);
            path.setStroke(Color.GRAY);
            path.setFill(Color.GRAY);
            root.getChildren().add(path);
        }

        //white part of eyes
        {
            Path p = new Path();
            p.getElements().addAll(
                    new MoveTo(102, 98),
                    new ArcTo(3, 6,15, 75, 99, false, false),
                    new QuadCurveTo(89,90, 102, 98)
            );
            p.setStrokeWidth(1);
            p.setStroke(Color.BLACK);
            p.setFill(Color.WHITE);
            root.getChildren().add(p);

            Path path = new Path();
            path.getElements().addAll(
                    new MoveTo(165, 102),
                    new ArcTo(4, 10,9, 185, 105, false, true),
                    new QuadCurveTo(179,98, 165, 102)
            );
            path.setStrokeWidth(1);
            path.setStroke(Color.BLACK);
            path.setFill(Color.WHITE);
            root.getChildren().add(path);
        }

        //eyes
        {
            Circle circle = new Circle(94,88, 6);
            circle.setFill(Color.BLACK);

            Circle circle1 = new Circle(179, 95, 5);
            circle1.setFill(Color.BLACK);

            root.getChildren().addAll(circle, circle1);
        }

        {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(new Double[]{
                    111.0, 75.0,
                    105.0, 85.0,
                    45.0, 55.0,
                    60.0, 45.0});
            polygon.setFill(Color.DARKORANGE);
            root.getChildren().add(polygon);
        }

        {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(new Double[]{
                    162.0, 82.0,
                    170.0, 93.0,
                    213.0, 76.0,
                    207.0, 67.0
            });
            polygon.setFill(Color.DARKORANGE);
            root.getChildren().add(polygon);
        }

        //Animation
        int cycleCount = 5;
        int time = 2000;

        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(2000), root);
        translateTransition.setFromX(50);
        translateTransition.setToX(600);
        translateTransition.setToY(550);
        translateTransition.setCycleCount(cycleCount);
        translateTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(time), root);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(cycleCount);
        rotateTransition.setAutoReverse(true);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(time), root);
        scaleTransition.setToX(-1);
        scaleTransition.setToY(-1);
        scaleTransition.setAutoReverse(true);


        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                rotateTransition,
                scaleTransition,
                translateTransition
        );
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();

        //End
        primaryStage.setResizable(true);
        primaryStage.setTitle("Lab3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
