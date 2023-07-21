

/**
 * A minimal program that applies RGB and HSV colors with JOGL in a Swing JFrame using the AWT GLCanvas.
 *
 * @author Belal Hmeidat
 */
    import com.jogamp.opengl.*;
    import com.jogamp.opengl.awt.GLCanvas;

    import javax.swing.*;

    import java.awt.*;
    import java.awt.event.WindowAdapter;
    import java.awt.event.WindowEvent;




    public class HSV2RGB implements GLEventListener{


        static int  red = ColorMath.r; //used across the class and to prevent issues with the math methods and the slider listeners
        static int green = ColorMath.g;
        static int blue  = ColorMath.b;
        //following are RGB color values to each element of the house graph
        static float drR = 0.5f, drG = 0.5f, drB = 0.5f; //right door
        static float fwR = 0.5f, fwG = 0.5f, fwB = 0.5f; //front wall
        static float dlR = 0.5f, dlG = 0.5f, dlB = 0.5f; //left door
        static float wlR = 0.5f, wlG = 0.5f, wlB = 0.5f; //left window
        static float wrR = 0.5f, wrG = 0.5f, wrB = 0.5f; //right window
        static float swR = 0.5f, swG = 0.5f, swB = 0.5f; //side wall
        static float sreR = 0.5f, sreG = 0.5f, sreB = 0.5f; //side edge of the roof

        static float rtR = 0.5f, rtG = 0.5f, rtB = 0.5f; //roof top




        //radio buttons used because I couldn't figure out how to use mouse clicks on the glcanvas elements
        static JRadioButton sideWallButton; //global as they are used in display method to change colors of indivisual elements and are implemented in the gui in the main method
        static JRadioButton facingWallButton;
        static JRadioButton windowLeftButton;
        static JRadioButton windowRightButton;
        static JRadioButton doorLeftButton;
        static JRadioButton doorRightButton;
        static JRadioButton roofTopButton;
        static JRadioButton sideEdgeRoofButton;




        public void display(GLAutoDrawable drawable) { //this method is called by the canvas to draw the house
            // each of the elements below has a skeleton and a fill area defined for it
                //THE facing wall
                final GL2 facingWall = drawable.getGL().getGL2();
                facingWall.glColor3f(1, 1, 1);
                facingWall.glBegin(GL2.GL_LINE_LOOP);
                facingWall.glVertex2f(0, 0.6f);
                facingWall.glVertex2f(-0.3f, 0.3f);
                facingWall.glVertex2f(-0.3f, -0.3f);
                facingWall.glVertex2f(0.3f, -0.3f);
                facingWall.glVertex2f(0.3f, 0.3f);
                facingWall.glEnd();

                final GL2 facingWallPoly = drawable.getGL().getGL2();
                if (facingWallButton.isSelected()) {
//            facingWallPoly.glColor3f(ColorMath.r/255f,ColorMath.g/255f,ColorMath.b/255f);
                    facingWallPoly.glColor3f(red / 255f, green / 255f, blue / 255f);
                    fwR = red/255f;
                    fwG = green/255f;
                    fwB = blue/255f;
                } else {
                    facingWallPoly.glColor3f(fwR, fwG, fwB);
                }
                facingWallPoly.glBegin(GL2.GL_POLYGON);
                facingWallPoly.glVertex2f(0.0f, 0.6f);
                facingWallPoly.glVertex2f(-0.3f, 0.3f);
                facingWallPoly.glVertex2f(-0.3f, -0.3f);
                facingWallPoly.glVertex2f(0.3f, -0.3f);
                facingWallPoly.glVertex2f(0.3f, 0.3f);
                facingWallPoly.glEnd();

            //THE door part1
                final GL2 doorLeft = drawable.getGL().getGL2();
                doorLeft.glColor3f(1, 1, 1);
                doorLeft.glBegin(GL2.GL_LINE_LOOP);
                doorLeft.glVertex2f(-0.1f, -0.3f);
                doorLeft.glVertex2f(0.0f, -0.3f);
                doorLeft.glVertex2f(0.0f, 0.0f);
                doorLeft.glVertex2f(-0.1f, 0.0f);
                doorLeft.glEnd();


                final GL2 doorLeftPoly = drawable.getGL().getGL2();
                if (doorLeftButton.isSelected()) {
                    doorLeftPoly.glColor3f(red/255f,green/255f,blue/255f);
                    dlR = red/255f;
                    dlG = green/255f;
                    dlB = blue/255f;
                }
                else {
                    doorLeftPoly.glColor3f(dlR, dlG, dlB);
                }
                doorLeftPoly.glBegin(GL2.GL_POLYGON);
                doorLeftPoly.glVertex2f(-0.1f, 0.0f);
                doorLeftPoly.glVertex2f(-0.1f, -0.3f);
                doorLeftPoly.glVertex2f(0.0f, -0.3f);
                doorLeftPoly.glVertex2f(0.0f, 0.0f);
                doorLeftPoly.glEnd();


//                door part2
                final GL2 doorRight = drawable.getGL().getGL2();
                doorRight.glColor3f(1, 1, 1);
                doorRight.glBegin(GL2.GL_LINE_LOOP);
                doorRight.glVertex2f(0.0f, 0.0f);
                doorRight.glVertex2f(0.0f, -0.3f);
                doorRight.glVertex2f(0.1f, -0.3f);
                doorRight.glVertex2f(0.1f, 0.0f);
                doorRight.glEnd();


                final GL2 doorRightPoly = drawable.getGL().getGL2();
                if (doorRightButton.isSelected()) {
                    doorRightPoly.glColor3f(red/255f,green/255f,blue/255f);
                    drR = red/255f;
                    drG = green/255f;
                    drB = blue/255f;
                }
                else {
                    doorRightPoly.glColor3f(drR, drG, drB);
                }
                doorRightPoly.glBegin(GL2.GL_QUADS);
                doorRightPoly.glVertex2f(0.0f, 0.0f);
                doorRightPoly.glVertex2f(0.0f, -0.3f);
                doorRightPoly.glVertex2f(0.1f, -0.3f);
                doorRightPoly.glVertex2f(0.1f, 0.0f);
                doorRightPoly.glEnd();

                //Windows
                final GL2 windowLeft = drawable.getGL().getGL2();
                windowLeft.glColor3f(1, 1, 1);
                windowLeft.glBegin(GL2.GL_LINE_LOOP);
                windowLeft.glVertex2f(-0.2f, 0.2f);
                windowLeft.glVertex2f(-0.1f, 0.2f);
                windowLeft.glVertex2f(-0.1f, 0.3f);
                windowLeft.glVertex2f(-0.2f, 0.3f);
                windowLeft.glEnd();

//                left Window
                final GL2 windowLeftPoly = drawable.getGL().getGL2();
                if (windowLeftButton.isSelected()) {
                    windowLeftPoly.glColor3f(red/255f,green/255f,blue/255f);
                    wlR = red/255f;
                    wlG = green/255f;
                    wlB = blue/255f;
                }
                else {
                    windowLeftPoly.glColor3f(wlR, wlG, wlB);
                }
                windowLeftPoly.glBegin(GL2.GL_POLYGON);
                windowLeftPoly.glVertex2f(-0.2f, 0.2f);
                windowLeftPoly.glVertex2f(-0.1f, 0.2f);
                windowLeftPoly.glVertex2f(-0.1f, 0.3f);
                windowLeftPoly.glVertex2f(-0.2f, 0.3f);
                windowLeftPoly.glEnd();

                //right Window
                final GL2 windowRight = drawable.getGL().getGL2();
                windowRight.glColor3f(1, 1, 1);
                windowRight.glBegin(GL2.GL_LINE_LOOP);
                windowRight.glVertex2f(0.1f, 0.2f);
                windowRight.glVertex2f(0.2f, 0.2f);
                windowRight.glVertex2f(0.2f, 0.3f);
                windowRight.glVertex2f(0.1f, 0.3f);
                windowRight.glEnd();

                final GL2 windowRightPoly = drawable.getGL().getGL2();
                if (windowRightButton.isSelected()) {
                    windowRightPoly.glColor3f(red/255f,green/255f,blue/255f);
                    wrR = red/255f;
                    wrG = green/255f;
                    wrB = blue/255f;
                }
                else {
                    windowRightPoly.glColor3f(wrR, wrG, wrB);
                }
                windowRightPoly.glBegin(GL2.GL_POLYGON);
                windowRightPoly.glVertex2f(0.1f, 0.2f);
                windowRightPoly.glVertex2f(0.2f, 0.2f);
                windowRightPoly.glVertex2f(0.2f, 0.3f);
                windowRightPoly.glVertex2f(0.1f, 0.3f);
                windowRightPoly.glEnd();


//                The side wall
                final GL2 sideWall = drawable.getGL().getGL2();
                sideWall.glColor3f(1,1,1);
                sideWall.glBegin(GL2.GL_LINE_LOOP);
                sideWall.glVertex2f(0.3f, -0.3f);
                sideWall.glVertex2f(0.7f, -0.15f);
                sideWall.glVertex2f(0.7f, 0.32f);
                sideWall.glVertex2f(0.4f, 0.2f);
                sideWall.glVertex2f(0.3f, 0.3f);
                sideWall.glEnd();


                final GL2 sideWallPoly = drawable.getGL().getGL2();
                if (sideWallButton.isSelected()) {
                    sideWallPoly.glColor3f(red / 255f, green / 255f, blue / 255f);
                    swR = red / 255f;
                    swG = green / 255f;
                    swB = blue / 255f;
                } else {
                    sideWallPoly.glColor3f(swR, swG, swB);
                }
                sideWallPoly.glBegin(GL2.GL_POLYGON);
                sideWallPoly.glVertex2f(0.3f, -0.3f);
                sideWallPoly.glVertex2f(0.7f, -0.15f);
                sideWallPoly.glVertex2f(0.7f, 0.32f);
                sideWallPoly.glVertex2f(0.4f, 0.2f);
                sideWallPoly.glVertex2f(0.3f, 0.3f);
                sideWallPoly.glEnd();


//
//            //sidewindow
//            gl.glBegin(GL2.GL_LINE_STRIP);
//            gl.glVertex2f(0.3f, 0.25f);
//            gl.glVertex2f(0.5f, 0.2f);
//            gl.glVertex2f(0.7f, 2.15f);
//            gl.glVertex2f(0.7f, 0.25f);
//            gl.glEnd();

//                side roof edge
                final GL2 sideRoofEdge = drawable.getGL().getGL2();
                sideRoofEdge.glColor3f(1, 1, 1);
                sideRoofEdge.glBegin(GL2.GL_LINE_STRIP);
                //lower line
                sideRoofEdge.glVertex2f(0.4f, 0.2f);
                sideRoofEdge.glVertex2f(0.8f, 0.35f);
                //upper line
                sideRoofEdge.glVertex2f(0.8f, 0.4f);
                sideRoofEdge.glVertex2f(0.4f, 0.25f);
                sideRoofEdge.glEnd();

                final GL2 sideRoofEdgePoly = drawable.getGL().getGL2();
                if (sideEdgeRoofButton.isSelected()) {
                    sideRoofEdgePoly.glColor3f(red / 255f, green / 255f, blue / 255f);
                    sreR = red / 255f;
                    sreG = green / 255f;
                    sreB = blue / 255f;
                } else {
                    sideRoofEdgePoly.glColor3f(sreR, sreG, sreB);
                }
                sideRoofEdgePoly.glBegin(GL2.GL_POLYGON);
                //lower line
                sideRoofEdgePoly.glVertex2f(0.4f, 0.2f);
                sideRoofEdgePoly.glVertex2f(0.8f, 0.35f);
                //upper line
                sideRoofEdgePoly.glVertex2f(0.8f, 0.4f);
                sideRoofEdgePoly.glVertex2f(0.4f, 0.25f);
                sideRoofEdgePoly.glEnd();

            //front edge
            final GL2 frontRoofEdge = drawable.getGL().getGL2();
            frontRoofEdge.glColor3f(1,1,1);
            frontRoofEdge.glBegin(GL2.GL_LINE_LOOP);
            frontRoofEdge.glVertex2f(-0.4f, 0.25f);
            frontRoofEdge.glVertex2f(-0.4f, 0.2f);
            frontRoofEdge.glVertex2f(0.0f, 0.6f);
            frontRoofEdge.glVertex2f(0.4f, 0.2f);
            frontRoofEdge.glVertex2f(0.4f, 0.25f);
            frontRoofEdge.glVertex2f(0.0f, 0.65f);
            frontRoofEdge.glEnd();

            //Not Working
//            final GL2 frontRoofEdgePoly = drawable.getGL().getGL2();
//            frontRoofEdgePoly.glColor3f(0,0,0.5f);
//            frontRoofEdgePoly.glBegin(GL2.GL_QUAD_STRIP);
//            frontRoofEdgePoly.glVertex2f(-0.4f, 0.25f);
//            frontRoofEdgePoly.glVertex2f(-0.4f, 0.2f);
//            frontRoofEdgePoly.glVertex2f(0.0f, 0.6f);
//            frontRoofEdgePoly.glVertex2f(0.4f, 0.2f);
//            frontRoofEdgePoly.glVertex2f(0.4f, 0.25f);
//            frontRoofEdgePoly.glVertex2f(0.0f, 0.65f);
//            frontRoofEdgePoly.glEnd();


//                rooftop
                final GL2 roofTop = drawable.getGL().getGL2();
                roofTop.glColor3f(1, 1, 1);
                roofTop.glBegin(GL2.GL_LINE_LOOP);
                roofTop.glVertex2f(0.0f, 0.65f);
                roofTop.glVertex2f(0.4f, 0.25f);
                roofTop.glVertex2f(0.8f, 0.4f);
                roofTop.glVertex2f(0.4f, 0.7f);
                roofTop.glEnd();

                final GL2 roofTopPoly = drawable.getGL().getGL2();
                if (roofTopButton.isSelected()) {
                    roofTopPoly.glColor3f(red / 255f, green / 255f, blue / 255f);
                    rtR = red / 255f;
                    rtG = green / 255f;
                    rtB = blue / 255f;
                } else {
                    roofTopPoly.glColor3f(rtR, rtG, rtB);
                }
                roofTopPoly.glBegin(GL2.GL_POLYGON);
                roofTopPoly.glVertex2f(0.0f, 0.65f);
                roofTopPoly.glVertex2f(0.4f, 0.25f);
                roofTopPoly.glVertex2f(0.8f, 0.4f);
                roofTopPoly.glVertex2f(0.4f, 0.7f);
                roofTopPoly.glEnd();
            }


         







            


        //unused

        public void dispose(GLAutoDrawable arg0) {}

        public void init(GLAutoDrawable arg0) {}

        public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4){}


        public static void main( String [] args ) {
            final GLProfile profile = GLProfile.get(GLProfile.GL2);
            GLCapabilities capabilities = new GLCapabilities(profile);
            final GLCanvas glcanvas = new GLCanvas(capabilities);
            HSV2RGB glInstance = new HSV2RGB();
            glcanvas.addGLEventListener(glInstance);

            glcanvas.setSize(50, 50);





//            JPanel glpanel = new JPanel();
//            glpanel.setLayout(new BorderLayout());
//            glpanel.add(glcanvas, BorderLayout.CENTER);

            //Setting up a frame for the UI
            final JFrame uiWindow = new JFrame( "UI Window" );
            uiWindow.addWindowListener( new WindowAdapter() {
                public void windowClosing( WindowEvent windowevent ) {
                    uiWindow.dispose();
                    System.exit( 0 );
                }
            });

            JPanel rgbPanel = new JPanel();
            JPanel hsvPanel =  new JPanel();
            JPanel cmyPanel = new JPanel();
            //setting up the RGB panel
            JLabel rgbTitle = new JLabel("RGB");
            rgbPanel.add(rgbTitle);

            rgbPanel.add(new JLabel("R:"));
            JSlider sliderR = new JSlider(0, 255,0);
            setupSlider(sliderR);
            rgbPanel.add(sliderR);

            rgbPanel.add(new JLabel("G:"));
            JSlider sliderG = new JSlider(0, 255,0);
            setupSlider(sliderG);
            rgbPanel.add(sliderG);

            rgbPanel.add(new JLabel("B:"));
            JSlider sliderB = new JSlider(0, 255,0);
            setupSlider(sliderB);
            rgbPanel.add(sliderB);
            rgbPanel.setLayout(new BoxLayout(rgbPanel, BoxLayout.Y_AXIS));
            //setting up the color indicator panel
            JPanel colorPanel = new JPanel();
            colorPanel.setSize(30,20);
            colorPanel.setBackground(Color.WHITE);
            //color indicator placed uder RGB Panel
            JSplitPane rgb2Color = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rgbPanel, colorPanel);

            //Setting up HSV Panel
            JLabel hsvTitle = new JLabel("HSV  ");
            hsvPanel.add(hsvTitle);

            //One slider for the Hue. Sat and Value have text fields
            JSlider sliderH = new JSlider(JSlider.VERTICAL,0,359,0);
            setupSlider(sliderH);

            hsvPanel.add(new JLabel("S:"));
            JTextField sliderS = new JTextField("0");
            sliderS.setMaximumSize(new Dimension(200, 30));
            hsvPanel.add(sliderS);

            hsvPanel.add(new JLabel("V:"));
            JTextField sliderV = new JTextField("0");
            sliderV.setMaximumSize(new Dimension(200, 30));

            hsvPanel.add(sliderV);
            //Organizing the HSV panel
            JPanel hsvExtra = new JPanel();
            hsvExtra.add(new JLabel("H:"));
            hsvExtra.add(sliderH);
            hsvExtra.add(hsvPanel);
            hsvExtra.setLayout(new BoxLayout(hsvExtra, BoxLayout.X_AXIS));

            hsvPanel.setLayout(new BoxLayout(hsvPanel, BoxLayout.Y_AXIS));
            //CMY Panel setup
            JLabel cmyTitle = new JLabel("CMY");
            cmyPanel.add(cmyTitle);

            cmyPanel.add(new JLabel("C:"));
            JTextField sliderC = new JTextField("0");
            cmyPanel.add(sliderC);

            cmyPanel.add(new JLabel("M:"));
            JTextField sliderM = new JTextField("0");
            cmyPanel.add(sliderM);

            cmyPanel.add(new JLabel("Y:"));
            JTextField sliderY = new JTextField("0");
            cmyPanel.add(sliderY);

            cmyPanel.setLayout(new BoxLayout(cmyPanel, BoxLayout.Y_AXIS));


            JPanel cmyAndhsvPanel = new JPanel(); //placing cmy under hsv panel
            cmyAndhsvPanel.add(hsvExtra);
            cmyAndhsvPanel.add(cmyPanel);
//            cmyAndhsvPanel.add(glpanel); //Tried to implement the GLCanvas here, didn't work :/
            cmyAndhsvPanel.setLayout(new BoxLayout(cmyAndhsvPanel, BoxLayout.Y_AXIS));

            //Final layout of the UI
            //RGB:HSV
            //Color:CMY
            //Buttons


            //Setting up the buttons
            JPanel buttonsPanel = new JPanel();
            JButton set = new JButton("Set");
            JButton clear = new JButton("clear");
            buttonsPanel.add(set);
            buttonsPanel.add(clear);

            JPanel radioPanel = new JPanel();
            facingWallButton = new JRadioButton("Facing Wall");
            sideEdgeRoofButton = new JRadioButton("Side Edge");
            roofTopButton = new JRadioButton("Roof Top");
            sideWallButton = new JRadioButton("Side Wall");
            windowLeftButton = new JRadioButton("Left Window");
            windowRightButton = new JRadioButton("Right Window");
            doorLeftButton = new JRadioButton("Left Door");
            doorRightButton = new JRadioButton("Right Door");
            //implementing the button group
            radioPanel.add(facingWallButton);
            radioPanel.add(sideEdgeRoofButton);
            radioPanel.add(roofTopButton);
            radioPanel.add(sideWallButton);
            radioPanel.add(windowLeftButton);
            radioPanel.add(windowRightButton);
            radioPanel.add(doorLeftButton);
            radioPanel.add(doorRightButton);


            radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));

            JPanel radioAndButtonsPanel = new JPanel();
            radioAndButtonsPanel.add(radioPanel);
            radioAndButtonsPanel.add(buttonsPanel);
            radioAndButtonsPanel.setLayout(new BoxLayout(radioAndButtonsPanel, BoxLayout.Y_AXIS));




            //Final layout of the UI
            JSplitPane rgb2hsvPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, rgb2Color, cmyAndhsvPanel);
            rgb2hsvPane.setDividerLocation(320);
            JSplitPane rgb2hsvextended = new JSplitPane(JSplitPane.VERTICAL_SPLIT, rgb2hsvPane, radioAndButtonsPanel);

            uiWindow.add(rgb2hsvextended);


            uiWindow.setSize( 700, 480 );
            uiWindow.setVisible( true );

            final JFrame glWindow = new JFrame( "GL Window" );
            uiWindow.addWindowListener( new WindowAdapter() {
                public void windowClosing( WindowEvent windowevent ) {
                    glWindow.dispose();
                    System.exit( 0 );
                }
            });
            //differet window (frame) for the glcanvas
            glWindow.getContentPane().add(glcanvas);
            glWindow.setSize( 640, 480 );
//            glWindow.setVisible( true ); // Don't show at launch because default element colors will be incorrectly all black (initial values of red, green, and blue are 0)



            //listening to buttons
            set.addActionListener(e -> {
                if (glWindow.isVisible() == false) {
                    glWindow.setVisible(true);
                }
                //vars to store from text fields
                float sValue = 0 ;
                float vValue = 0;

                float cValue = 0;
                float mValue = 0;
                float yValue = 0;

                try {
                    sValue = Float.parseFloat(sliderS.getText());
                } catch (NumberFormatException ex) {
                    sValue = 0;
                }
                try {
                    vValue = Float.parseFloat(sliderV.getText());
                } catch (NumberFormatException ex) {
                    vValue = 0;
                }
                try {
                    cValue = Float.parseFloat(sliderC.getText());
                } catch (NumberFormatException ex) {
                    cValue = 0;
                }
                try {
                    mValue = Float.parseFloat(sliderM.getText());
                } catch (NumberFormatException ex) {
                    mValue = 0;
                }
                try {
                    yValue = Float.parseFloat(sliderY.getText());
                } catch (NumberFormatException ex) {
                    yValue = 0;
                    System.out.println("error in Y parse");
                }
                if (sValue > 1 || sValue < 0) {
                    sliderS.setText("S value must be between 0 and 1");
                    sValue = 0;
                }
                if(vValue > 1 || vValue < 0) {
                    sliderV.setText("V value must be between 0 and 1");
                    vValue = 0;
                }
                if(cValue > 1 || cValue < 0) {
                    sliderC.setText("C value must be between 0 and 1");
                    cValue = 0;
                }
                if(mValue > 1 || mValue < 0) {
                    sliderM.setText("M value must be between 0 and 1");
                    mValue = 0;
                }
                if(yValue > 1 || yValue < 0) {
                    sliderY.setText("Y value must be between 0 and 1");
                    yValue = 0;
                }
                //Storing old values used to check which system changes and thus which converts to which
                int preR = ColorMath.r;
                int preG = ColorMath.g;
                int preB = ColorMath.b;

                int preH = ColorMath.h;
                float preS = ColorMath.s;
                float preV = ColorMath.v;

                float preC = ColorMath.c;
                float preM = ColorMath.m;
                float preY = ColorMath.y;

                //Getting new values from sliders and text fields stored values
                ColorMath.r = sliderR.getValue();
                ColorMath.g = sliderG.getValue();
                ColorMath.b = sliderB.getValue();

                ColorMath.h = sliderH.getValue();
                ColorMath.s = sValue;
                ColorMath.v = vValue;

                ColorMath.c = cValue;
                ColorMath.m = mValue;
                ColorMath.y = yValue;
                //Checking which system changed and converting to the other two
                if (ColorMath.r != preR || ColorMath.g != preG || ColorMath.b != preB) {
                    ColorMath.rgb2hsv(sliderR.getValue(), sliderG.getValue(), sliderB.getValue());
//                    ColorMath.hsv2rgb(ColorMath.h, ColorMath.s, ColorMath.v);
                    sliderH.setValue(ColorMath.h);//(int)(ColorMath.h * 360));
                    sliderS.setText(String.valueOf(ColorMath.s));
                    sliderV.setText(String.valueOf(ColorMath.v));

                    System.out.println("H: " + ColorMath.h);
                    System.out.println("S: " + ColorMath.s);
                    System.out.println("V: " + ColorMath.v);

                    ColorMath.rgb2cmy(sliderR.getValue(), sliderG.getValue(), sliderB.getValue());
                    sliderC.setText(String.valueOf(ColorMath.c));
                    sliderM.setText(String.valueOf(ColorMath.m));
                    sliderY.setText(String.valueOf(ColorMath.y));


                }
                else if(ColorMath.h != preH || ColorMath.s != preS || ColorMath.v != preV){
                    ColorMath.hsv2rgb(sliderH.getValue(), sValue, vValue);
                    sliderR.setValue(ColorMath.r);
                    sliderG.setValue(ColorMath.g);
                    sliderB.setValue(ColorMath.b);

                    System.out.println("R: " + ColorMath.r);
                    System.out.println("G: " + ColorMath.g);
                    System.out.println("B: " + ColorMath.b);

                    ColorMath.rgb2cmy(ColorMath.r, ColorMath.g, ColorMath.b);
                    sliderC.setText(String.valueOf(ColorMath.c));
                    sliderM.setText(String.valueOf(ColorMath.m));
                    sliderY.setText(String.valueOf(ColorMath.y));

                } else if (ColorMath.c != preC || ColorMath.m != preM || ColorMath.y != preY) {
                    ColorMath.cmy2rgb(cValue, mValue, yValue);
                    sliderR.setValue(ColorMath.r);
                    sliderG.setValue(ColorMath.g);
                    sliderB.setValue(ColorMath.b);

                    System.out.println("R: " + ColorMath.r);
                    System.out.println("G: " + ColorMath.g);
                    System.out.println("B: " + ColorMath.b);

                    ColorMath.rgb2hsv(ColorMath.r, ColorMath.g, ColorMath.b);
                    sliderH.setValue(ColorMath.h);//(int)(ColorMath.h * 360));
                    sliderS.setText(String.valueOf(ColorMath.s));
                    sliderV.setText(String.valueOf(ColorMath.v));

                    System.out.println("H: " + ColorMath.h);
                    System.out.println("S: " + ColorMath.s);
                    System.out.println("V: " + ColorMath.v);
                }
                //storing results in the static variables
                red = ColorMath.r;
                green = ColorMath.g;
                blue = ColorMath.b;
                //Setting the color of the color preview
                Color colorPanelColor = new Color(red, green, blue);
                colorPanel.setBackground(colorPanelColor);







//
//                glWindow.getContentPane().add(glcanvas);
//                glWindow.setVisible( true );
                glcanvas.display();//updating the canvas



            });


            clear.addActionListener(e -> { //button to clear input
                sliderR.setValue(0);
                sliderG.setValue(0);
                sliderB.setValue(0);
                sliderH.setValue(0);
                sliderS.setText("0");
                sliderV.setText("0");
                sliderC.setText("0");
                sliderM.setText("0");
                sliderY.setText("0");
            });
        }
        //method that sets up the slider ticks and labels
        public static void setupSlider(JSlider slider){
            slider.setMinorTickSpacing(10);
            slider.setMajorTickSpacing(50);
            if (slider.getMaximum() >= 359) {
                slider.setMinorTickSpacing(10);
                slider.setMajorTickSpacing(60);
            }
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            return;
        }

   }



