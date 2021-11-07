package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author legol
 */
public class ImagePanel extends JPanel {
    
    private Image copyImg;
    private Mat image;
    private Mat imageUmbra;
    private Mat imageUmbraPrev;
    
    boolean imageSet = false;
    
    public ImagePanel(){
        super();
    }
    
    public void AddImage(File img){
        image = Imgcodecs.imread(img.getAbsolutePath());
        imageUmbra = image;
        this.setOpaque(true);
        imageSet = true;
        this.update(this.getGraphics());
    }
    
    public void SaveImage(File img){
        Imgcodecs.imwrite(img.getAbsolutePath(), imageUmbra);
    }
    
    public void undo(){
        imageUmbra = imageUmbraPrev;
        this.update(this.getGraphics());
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        if(imageSet){
            copyImg = HighGui.toBufferedImage(imageUmbra);
            Image img = copyImg.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
            g.drawImage(img, 0, 0, this);
        }
    }
    
    public void Umbrar(Integer umbral){
        imageUmbraPrev = imageUmbra;
        imageUmbra = umbralizar(image, umbral);
        this.update(this.getGraphics());
    }
    
    private Mat umbralizar(Mat imagen_original, Integer umbral) {
        // crear dos imágenes en niveles de gris con el mismo
        // tamaño que la original
        Mat imagenGris = new Mat(imagen_original.rows(), imagen_original.cols(), CvType.CV_8U);
        Mat imagenUmbralizada = new Mat(imagen_original.rows(), imagen_original.cols(), CvType.CV_8U);
        // convierte a niveles de grises la imagen original
        Imgproc.cvtColor(imagen_original, imagenGris, Imgproc.COLOR_BGR2GRAY);
        // umbraliza la imagen:
        // - píxeles con nivel de gris > umbral se ponen a 1
        // - píxeles con nivel de gris <= umbra se ponen a 0
        Imgproc.threshold(imagenGris, imagenUmbralizada, umbral, 255, Imgproc.THRESH_BINARY);
        // se devuelve la imagen umbralizada
        return imagenUmbralizada;
    }
}
