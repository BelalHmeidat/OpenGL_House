//import com.jogamp.opengl.GL;
//import com.jogamp.opengl.GL2;
//import com.jogamp.opengl.glu.GLU;
//
//public class GraphicsGL {
//    protected static void setup( GL2 gl2, int width, int height ) {
//        gl2.glMatrixMode( GL2.GL_PROJECTION );
//        gl2.glLoadIdentity();
//
//        // coordinate system origin at lower left with width and height same as the window
//        GLU glu = new GLU();
//        glu.gluOrtho2D( 0.0f, width, 0.0f, height );
//
//        gl2.glMatrixMode( GL2.GL_MODELVIEW );
//        gl2.glLoadIdentity();
//
//        gl2.glViewport( 0, 0, width, height );
//    }
//
//    protected static void render( GL2 gl2, int width, int height ) {
//        gl2.glClear( GL.GL_COLOR_BUFFER_BIT );
//
//        // draw a triangle filling the window
//        gl2.glLoadIdentity();
//        gl2.glBegin( GL.GL_TRIANGLES );
//        gl2.glColor3f( (float)ColorMath.r/255, (float) ColorMath.g/255,(float) ColorMath.b/255 );
//        gl2.glVertex2f( 0, 0 );
//        gl2.glVertex2f( width, 0 );
//        gl2.glVertex2f( width/2, height );
//        gl2.glEnd();
//
//
//    }
//}