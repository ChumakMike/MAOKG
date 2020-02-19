package kpi;

import com.sun.j3d.utils.geometry.*;

import javax.media.j3d.Appearance;
import javax.media.j3d.Material;
import javax.vecmath.Color3f;

public class PlaneBuilder {

    public static Primitive getCylinder() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.1f, 0.6f, primflags,  getPlaneAppearence());
    }

    private static Appearance getPlaneAppearence() {
        Appearance ap = new Appearance();
        Color3f emissive = new Color3f(0.0f, 0.00f, 0.0f);
        Color3f ambient = new Color3f(0.9f, 0.5f, 0.2f);
        Color3f diffuse = new Color3f(0.2f, 0.4f, 0.55f);
        Color3f specular = new Color3f(0.2f, 0.5f, 0.6f);
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    public static Primitive getSphere() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Sphere(0.1f, primflags, getPlaneAppearence());
    }

    public static Primitive getCone() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(0.1f, 0.15f, primflags, getPlaneAppearence());
    }

    public static Primitive getTailCone() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(0.09f, 0.25f, primflags, getPlaneAppearence());
    }

    public static Primitive getFly() {

        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(0.08f, 0.3f, primflags, getPlaneRedAppearence());
    }

    public static Primitive getShossi() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Sphere(0.02f, primflags, getPlaneRedAppearence());
    }

    private static Appearance getPlaneRedAppearence() {
        Appearance ap = new Appearance();
        Color3f emissive = new Color3f(0.0f, 0.00f, 0.0f);
        Color3f ambient = new Color3f(0.5f, 0.1f, 0.2f);
        Color3f diffuse = new Color3f(0.2f, 0.1f, 0.1f);
        Color3f specular = new Color3f(0.2f, 0.2f, 0.1f);
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    public static Primitive getBigBox() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(0.25f, 0.01f, 0.085f, primflags, getPlaneRedAppearence());
    }
}
