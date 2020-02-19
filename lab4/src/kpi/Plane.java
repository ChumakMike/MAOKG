package kpi;

import com.sun.j3d.utils.geometry.Cone;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

public class Plane {

    private TransformGroup objectTransformGroup;
    private Transform3D planeTransform3D = new Transform3D();
    private float angle = 0;

    public BranchGroup createSceneGraph() {
        BranchGroup objRoot = new BranchGroup();

        objectTransformGroup = new TransformGroup();
        objectTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        makeObj();
        objRoot.addChild(objectTransformGroup);

        //налаштовуємо освітлення
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
                100.0);
        Color3f light1Color = new Color3f(0.8f, 0.0f, .2f);
        Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
        DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
        light1.setInfluencingBounds(bounds);
        objRoot.addChild(light1);

        // встановлюємо навколишнє освітлення
        Color3f ambientColor = new Color3f(1f, 1f, 1f);
        AmbientLight ambientLightNode = new AmbientLight(ambientColor);
        ambientLightNode.setInfluencingBounds(bounds);
        objRoot.addChild(ambientLightNode);

        return  objRoot;
    }

    public void makeObj() {

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();
            transform3D.rotX(Math.PI/2);
            transform3D.rotZ(Math.PI/2);
            transform3D.setTranslation(new Vector3f(0.0f, 0.0f, 0.0f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getCylinder());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();
            transform3D.setTranslation(new Vector3f(0.3f, 0f, 0.0f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getSphere());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();
            transform3D.rotX(Math.PI/2);
            transform3D.rotZ(Math.PI/2);
            transform3D.setTranslation(new Vector3f(-0.375f, 0f, 0.0f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getCone());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();

            transform3D.rotZ(Math.PI/3);
            transform3D.setTranslation(new Vector3f(-0.35f, 0.08f, 0.0f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getTailCone());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();

            transform3D.rotZ(Math.PI/3);
            transform3D.setTranslation(new Vector3f(-0.1f, 0.08f, 0.0f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getTailCone());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();

            transform3D.rotX(1.78*Math.PI/3);
            transform3D.setTranslation(new Vector3f(0.0f, -0.02f, 0.1f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getFly());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();

            transform3D.rotX(-1.78*Math.PI/3);

            transform3D.setTranslation(new Vector3f(0.0f, -0.02f, -0.1f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getFly());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();
            transform3D.setTranslation(new Vector3f(0.3f, -0.1f, 0.0f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getShossi());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();
            transform3D.setTranslation(new Vector3f(-0.21f, -0.095f, 0.05f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getShossi());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();
            transform3D.setTranslation(new Vector3f(-0.21f, -0.095f, -0.05f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getShossi());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();
            transform3D.setTranslation(new Vector3f(0.f, 0.05f, 0.0f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getBigBox());
            objectTransformGroup.addChild(transformGroup);
        }

        {
            Transform3D transform3D = new Transform3D();
            TransformGroup transformGroup = new TransformGroup();
            transform3D.setTranslation(new Vector3f(0.f, -0.05f, 0.0f));
            transformGroup.setTransform(transform3D);

            transformGroup.addChild(PlaneBuilder.getBigBox());
            objectTransformGroup.addChild(transformGroup);
        }
    }

    public void rotate() {
        planeTransform3D.rotY(angle);
        angle += 0.05;
        objectTransformGroup.setTransform(planeTransform3D);

    }
}
