package lab;

import javax.vecmath.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.behaviors.vp.*;
import javax.swing.JFrame;
import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class BlackWidow extends JFrame {
    public Canvas3D myCanvas3D;

    public BlackWidow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myCanvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        SimpleUniverse simpUniv = new SimpleUniverse(myCanvas3D);

        simpUniv.getViewingPlatform().setNominalViewingTransform();

        // set the geometry and transformations
        createSceneGraph(simpUniv);
        addLight(simpUniv);

        OrbitBehavior ob = new OrbitBehavior(myCanvas3D);
        ob.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE));
        simpUniv.getViewingPlatform().setViewPlatformBehavior(ob);

        setTitle("BlackWidow");
        setSize(800,600);

        getContentPane().add("Center", myCanvas3D);
        setVisible(true);
    }

    public static void setToMyDefaultAppearance(Appearance app, Color3f col)
    {
        app.setMaterial(new Material(col,col,col,col,150.0f));
    }


    public void createSceneGraph(SimpleUniverse su){
        // loading object
        ObjectFile f = new ObjectFile(ObjectFile.RESIZE);
        BoundingSphere bs = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);
        BranchGroup bwBranchGroup = new BranchGroup();
        Background bwBackground = new Background(new Color3f(1.0f,1.0f,1.0f));

        Scene bwScene = null;
        try {
            bwScene = f.load("model/black_widow.obj");
        } catch (Exception e) {
            System.out.println("File loading failed:" + e);
        }

        Hashtable roachNamedObjects = bwScene.getNamedObjects();
        Enumeration enumer = roachNamedObjects.keys();
        String name;
        while (enumer.hasMoreElements()){
            name = (String) enumer.nextElement();
            System.out.println("Name: " + name);
        }

        //Appearence
        Appearance blackApp = new Appearance();
        setToMyDefaultAppearance(blackApp,new Color3f(.0f,.0f,.0f));
        Shape3D dial = (Shape3D) roachNamedObjects.get("blkw_body");
        dial.setAppearance(blackApp);
        Shape3D[] d = new Shape3D[10];
        for (int i = 1; i <= 8; i++) {
            d[i] = (Shape3D) roachNamedObjects.get("leg" + i);
            d[i].setAppearance(blackApp);
        }

        // start animation
        Transform3D startTransformation = new Transform3D();
        startTransformation.setScale(1.0/3);
        Transform3D combinedStartTransformation = new Transform3D();
        combinedStartTransformation.rotY(-3*Math.PI/2);
        combinedStartTransformation.mul(startTransformation);


        TransformGroup bwStartTransformGroup = new TransformGroup(combinedStartTransformation);

        // legs
        int movesCount = 100; // moves count
        int movesDuration = 1000;
        int startTime = 0; // launch animation after timeStart seconds

        // leg 1
        Shape3D leg1 = (Shape3D) roachNamedObjects.get("leg1");
        TransformGroup legTG1 = new TransformGroup();
        legTG1.addChild(leg1.cloneTree());

        Transform3D legRotAxis = new Transform3D();
        legRotAxis.rotZ(Math.PI/6);

        Alpha leg1_1RotAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, movesDuration,0,0,0,0,0);
        RotationInterpolator leg1rot = new RotationInterpolator(leg1_1RotAlpha, legTG1, legRotAxis, 0.0f, (float) -Math.PI/2);
        leg1rot.setSchedulingBounds(bs);
        legTG1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        legTG1.addChild(leg1rot);

        // leg 2
        Shape3D leg2 = (Shape3D) roachNamedObjects.get("leg2");
        TransformGroup legTG2 = new TransformGroup();
        legTG2.addChild(leg2.cloneTree());

        Transform3D legRotAxis2 = new Transform3D();
        legRotAxis2.rotZ(Math.PI/6);

        Alpha leg2_1RotAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, movesDuration,0,0,0,0,0);
        RotationInterpolator leg2rot = new RotationInterpolator(leg2_1RotAlpha, legTG2, legRotAxis2, 0.0f, (float) -Math.PI/4);
        leg2rot.setSchedulingBounds(bs);
        legTG2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        legTG2.addChild(leg2rot);

        // leg 3
        Shape3D leg3 = (Shape3D) roachNamedObjects.get("leg3");
        TransformGroup legTG3 = new TransformGroup();
        legTG3.addChild(leg3.cloneTree());

        Transform3D legRotAxis3 = new Transform3D();
        legRotAxis3.rotZ(Math.PI/6);

        Alpha leg3_1RotAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, movesDuration,0,0,0,0,0);
        RotationInterpolator leg3rot = new RotationInterpolator(leg3_1RotAlpha, legTG3, legRotAxis3, 0.0f, (float) -Math.PI/4);
        leg3rot.setSchedulingBounds(bs);
        legTG3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        legTG3.addChild(leg3rot);

        // leg 4
        Shape3D leg4 = (Shape3D) roachNamedObjects.get("leg4");
        TransformGroup legTG4 = new TransformGroup();
        legTG3.addChild(leg4.cloneTree());

        Transform3D legRotAxis4 = new Transform3D();
        legRotAxis4.rotZ(Math.PI/6);

        Alpha leg4_1RotAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, movesDuration,0,0,0,0,0);
        RotationInterpolator leg4rot = new RotationInterpolator(leg4_1RotAlpha, legTG4, legRotAxis4, 0.0f, (float) -Math.PI/2);
        leg4rot.setSchedulingBounds(bs);
        legTG4.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        legTG4.addChild(leg4rot);

        // leg 5
        Shape3D leg5 = (Shape3D) roachNamedObjects.get("leg5");
        TransformGroup legTG5 = new TransformGroup();
        legTG3.addChild(leg5.cloneTree());

        Transform3D legRotAxis5 = new Transform3D();
        legRotAxis5.rotZ(Math.PI/6);

        Alpha leg5_1RotAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, movesDuration,0,0,0,0,0);
        RotationInterpolator leg5root = new RotationInterpolator(leg5_1RotAlpha, legTG5, legRotAxis5, 0.0f, (float) -Math.PI/2);
        leg5root.setSchedulingBounds(bs);
        legTG5.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        legTG5.addChild(leg5root);

        // leg 6
        Shape3D leg6 = (Shape3D) roachNamedObjects.get("leg6");
        TransformGroup legTG6 = new TransformGroup();
        legTG3.addChild(leg6.cloneTree());

        Transform3D legRotAxis6 = new Transform3D();
        legRotAxis6.rotZ(Math.PI/6);

        Alpha leg6_1RotAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, movesDuration,0,0,0,0,0);
        RotationInterpolator leg6root = new RotationInterpolator(leg6_1RotAlpha, legTG6, legRotAxis6, 0.0f, (float) -Math.PI);
        leg6root.setSchedulingBounds(bs);
        legTG6.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        legTG6.addChild(leg6root);

        // leg 7
        Shape3D leg7 = (Shape3D) roachNamedObjects.get("leg7");
        TransformGroup legTG7 = new TransformGroup();
        legTG3.addChild(leg7.cloneTree());

        Transform3D legRotAxis7 = new Transform3D();
        legRotAxis7.rotZ(Math.PI/6);

        Alpha leg7_1RotAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, movesDuration,0,0,0,0,0);
        RotationInterpolator leg7root = new RotationInterpolator(leg7_1RotAlpha, legTG7, legRotAxis7, 0.0f, (float) -Math.PI);
        leg7root.setSchedulingBounds(bs);
        legTG7.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        legTG7.addChild(leg7root);

        // leg 8
        Shape3D leg8 = (Shape3D) roachNamedObjects.get("leg8");
        TransformGroup legTG8 = new TransformGroup();
        legTG3.addChild(leg8.cloneTree());

        Transform3D legRotAxis8 = new Transform3D();
        legRotAxis8.rotZ(Math.PI/6);

        Alpha leg8_1RotAlpha = new Alpha(movesCount, Alpha.INCREASING_ENABLE, startTime, 0, movesDuration,0,0,0,0,0);
        RotationInterpolator leg8root = new RotationInterpolator(leg8_1RotAlpha, legTG8, legRotAxis8, 0.0f, (float) -Math.PI);
        leg8root.setSchedulingBounds(bs);
        legTG8.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        legTG8.addChild(leg8root);

        TransformGroup sceneGroup = new TransformGroup();
        sceneGroup.addChild(legTG1);
        sceneGroup.addChild(legTG2);
        sceneGroup.addChild(legTG3);
        sceneGroup.addChild(legTG4);
        sceneGroup.addChild(legTG5);
        sceneGroup.addChild(legTG6);
        sceneGroup.addChild(legTG7);
        sceneGroup.addChild(legTG8);

        TransformGroup tgBody = new TransformGroup();
        Shape3D bwBodyShape = (Shape3D) roachNamedObjects.get("blkw_body");
        tgBody.addChild(bwBodyShape.cloneTree());
        sceneGroup.addChild(tgBody.cloneTree());

        TransformGroup TransXformGroup = translate(bwStartTransformGroup, new Vector3f(0.0f,.0f,0.4f));

        TransformGroup RotXformGroup = rotate(TransXformGroup, new Alpha(10,10000));
        bwBranchGroup.addChild(RotXformGroup);
        bwStartTransformGroup.addChild(sceneGroup);

        // adding background to branch group
        BoundingSphere bounds = new BoundingSphere(new Point3d(120.0,250.0,100.0),Double.MAX_VALUE);
        bwBackground.setApplicationBounds(bounds);
        bwBranchGroup.addChild(bwBackground);
        bwBranchGroup.compile();
        su.addBranchGraph(bwBranchGroup);
    }

    TransformGroup rotate(Node node, Alpha alpha){
        TransformGroup xformGroup = new TransformGroup();
        xformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        //Create an interpolator for rotating the node.
        RotationInterpolator interpolator = new RotationInterpolator(alpha,xformGroup);
        //Establish the animation region for this
        // interpolator.
        interpolator.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),1.0));
        //Populate the xform group.
        xformGroup.addChild(interpolator);
        xformGroup.addChild(node);
        return xformGroup;

    }

    TransformGroup translate(Node node,Vector3f vector){
        Transform3D transform3D = new Transform3D();
        transform3D.setTranslation(vector);
        TransformGroup transformGroup = new TransformGroup();
        transformGroup.setTransform(transform3D);
        transformGroup.addChild(node);
        return transformGroup;
    }


    public void addLight(SimpleUniverse su){
        BranchGroup bgLight = new BranchGroup();
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        Color3f lightColour1 = new Color3f(1.0f,1.0f,1.0f);
        Vector3f lightDir1 = new Vector3f(-1.0f,0.0f,-0.5f);
        DirectionalLight light1 = new DirectionalLight(lightColour1, lightDir1);
        light1.setInfluencingBounds(bounds);
        bgLight.addChild(light1);
        su.addBranchGraph(bgLight);
    }

    public static void main(String[] args) {
        BlackWidow blackWidowScene = new BlackWidow();
    }
}
