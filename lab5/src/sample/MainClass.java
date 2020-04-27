package sample;

import com.sun.j3d.utils.universe.*;
import java.awt.Color;
import javax.media.j3d.*;
import javax.media.j3d.Material;
import javax.vecmath.*;
import javax.media.j3d.Background;

import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.loaders.lw3d.Lw3dLoader;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import javax.swing.JFrame;

public class MainClass extends JFrame {
    static SimpleUniverse universe;
    static Scene scene;
    static Map<String, Shape3D> nameMap;
    static BranchGroup root;
    static Canvas3D canvas;
    static TransformGroup wholeCow;
    static Transform3D transform3D;

    public MainClass() throws IOException{
        configureWindow();
        configureCanvas();
        configureUniverse();
        addModelToUniverse();
        setCowElementsList();
        addAppearance();
        addImageBackground();
        addLightToUniverse();
        addOtherLight();
        ChangeViewAngle();
        root.compile();
        universe.addBranchGraph(root);
    }

    private void configureWindow()  {
        setTitle("Cow's Animation");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void configureCanvas(){
        canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        canvas.setDoubleBufferEnable(true);
        getContentPane().add(canvas,BorderLayout.CENTER);
    }

    private void addModelToUniverse() throws IOException{
        scene = getSceneFromFile("source_folder//Cow.obj");
        root=scene.getSceneGroup();
    }

    private void addLightToUniverse(){
        Bounds bounds = new BoundingSphere();
        Color3f color = new Color3f(65/255f, 30/255f, 25/255f);
        Vector3f lightdirection = new Vector3f(-1f,-1f,-1f);
        DirectionalLight dirlight = new DirectionalLight(color,lightdirection);
        dirlight.setInfluencingBounds(bounds);
        root.addChild(dirlight);
    }

    private void printModelElementsList(Map<String,Shape3D> nameMap){
        for (String name : nameMap.keySet()) {
            System.out.printf("Name: %s\n", name);}
    }

    private void configureUniverse(){
        root = new BranchGroup();
        universe = new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
    }

    private void setCowElementsList() {
        nameMap = scene.getNamedObjects();
        //Print elements of your model:
        printModelElementsList(nameMap);

        wholeCow = new TransformGroup();
        transform3D = new Transform3D();
        wholeCow.setTransform(transform3D);
        transform3D.setTranslation(new Vector3f(0, -1.3f, 0));
        wholeCow.setTransform(transform3D);
        transform3D.setScale(0.5f);
        wholeCow.setTransform(transform3D);
        root.removeChild(nameMap.get("cow"));
        wholeCow.addChild(nameMap.get("cow"));
        wholeCow.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        root.addChild(wholeCow);
    }

    Texture getTexture(String path) {
        TextureLoader textureLoader = new TextureLoader(path, canvas);
        Texture texture = textureLoader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor( new Color4f(Color.WHITE));
        return texture;
    }

    Material getMaterial() {
        Material material = new Material();
        material.setAmbientColor ( new Color3f( 1f, 1f, 1f) );
        material.setDiffuseColor ( new Color3f( 1f, 1f, 1f ) );
        material.setSpecularColor( new Color3f( 1f, 1f, 1f ) );
        material.setShininess( 0.5f );
        material.setLightingEnable(true);
        return material;
    }

    private void addAppearance(){
        Appearance rexAppearance = new Appearance();
        rexAppearance.setTexture(getTexture("source_folder//cow_Diff.jpg"));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.COMBINE);
        rexAppearance.setTextureAttributes(texAttr);
        rexAppearance.setMaterial(getMaterial());
        Shape3D rex = nameMap.get("cow");
        rex.setAppearance(rexAppearance);
    }

    private void addImageBackground(){
        TextureLoader t = new TextureLoader("source_folder//shveycariya.jpg", canvas);
        Background background = new Background(t.getImage());
        background.setImageScaleMode(Background.SCALE_FIT_ALL);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        background.setApplicationBounds(bounds);
        root.addChild(background);
    }

    private void ChangeViewAngle(){
        ViewingPlatform vp = universe.getViewingPlatform();
        TransformGroup vpGroup = vp.getMultiTransformGroup().getTransformGroup(0);
        Transform3D vpTranslation = new Transform3D();
        Vector3f translationVector = new Vector3f(0.0F, -1.2F, 6F);
        vpTranslation.setTranslation(translationVector);
        vpGroup.setTransform(vpTranslation);
    }

    private void addOtherLight(){
        Color3f directionalLightColor = new Color3f(Color.BLACK);
        Color3f ambientLightColor = new Color3f(Color.WHITE);
        Vector3f lightDirection = new Vector3f(-1F, -1F, -1F);

        AmbientLight ambientLight = new AmbientLight(ambientLightColor);
        DirectionalLight directionalLight = new DirectionalLight(directionalLightColor, lightDirection);

        Bounds influenceRegion = new BoundingSphere();

        ambientLight.setInfluencingBounds(influenceRegion);
        directionalLight.setInfluencingBounds(influenceRegion);
        root.addChild(ambientLight);
        root.addChild(directionalLight);
    }

    public static Scene getSceneFromFile(String location) throws IOException {
        ObjectFile file = new ObjectFile(ObjectFile.RESIZE);
        file.setFlags (ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
        return file.load(new FileReader(location));
    }

    //Not always works
    public static Scene getSceneFromLwoFile(String location) throws IOException {
        Lw3dLoader loader = new Lw3dLoader();
        return loader.load(new FileReader(location));
    }

    public static void main(String[]args){
        try {
            MainClass window = new MainClass();
            AnimationCow CowMovement = new AnimationCow(wholeCow, transform3D, window);
            window.setVisible(true);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}