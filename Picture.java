/*
 * name: riana fazir and anthony vivona
 * date: 4/17/23
 * file name: Picture
 * description: holds methods using 2d arrays and loops to manipulate photos
 */

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
    
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  // A5 exercise 3
  public void keepOnlyBlue() {
	 Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(0);
	        pixelObj.setGreen(0);
	      }
	    }
  }
  
  // A5 exercise 4
  public void negate() {
	  int tempR, tempG, tempB;
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	tempR = pixelObj.getRed();
	    	tempG = pixelObj.getGreen();
	    	tempB = pixelObj.getBlue();
	        pixelObj.setRed(255-tempR);
	        pixelObj.setGreen(255-tempG);
	        pixelObj.setBlue(255-tempB);
	      }
	    }
  }
  
  // A5 exercise 5
  public void grayscale() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	    	int avg = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
	        pixelObj.setRed(avg);
	        pixelObj.setGreen(avg);
	        pixelObj.setBlue(avg);
	      }
	    }
  }
  
  // A5 exercise 6 challenge
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels) {
	      for (Pixel pixelObj : rowArray) {
	    	  pixelObj.setRed(pixelObj.getRed()*10);
	      }
	    }
  }
  
  // A6 exercise 1
  public void mirrorVerticalRightToLeft() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width / 2; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][width - 1 - col];
	        leftPixel.setColor(rightPixel.getColor());
	      }
	  } 
  }
  
  // A6 exercise 2
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel downPixel = null;
	    Pixel upPixel = null;
	    int height = pixels.length;
	    for (int row = 0; row < height/2; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	        upPixel = pixels[row][col];
	        downPixel = pixels[height - 1 - row][col];
	        downPixel.setColor(upPixel.getColor());
	      }
	    }
  }
  
  // A6 exercise 3
  public void mirrorHorizontalBotToTop() {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel downPixel = null;
	    Pixel upPixel = null;
	    int height = pixels.length;
	    for (int row = 0; row < height/2; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	        upPixel = pixels[row][col];
	        downPixel = pixels[height - 1 - row][col];
	        upPixel.setColor(downPixel.getColor());
	      }
	    }
  }
  
  // A6 exercise 4 challenge
  public void mirrorDiagonal() {
	  Pixel[][] pixels = this.getPixels2D();
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length; col++)
	      {
	    	  if (col < pixels.length && row < pixels[0].length)
	    		  pixels[row][col].setColor(pixels[col][row].getColor());
	      }
	    }
  }
  
  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  // A7 exercise 2
  public void mirrorArms() {
	  int mirrorPoint = 191;
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    for (int row = 155; row < mirrorPoint; row++)
	    {
	      for (int col = 104; col < 171; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[mirrorPoint - row + mirrorPoint]                       
	                         [col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
	    
	    mirrorPoint = 195;
	    for (int row = 164; row < mirrorPoint; row++)
	    {
	      for (int col = 239; col < 294; col++)
	      {
	        
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[mirrorPoint - row + mirrorPoint]                       
	                         [col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
  }
  
  // A7 exercise 3
  public void mirrorGulls() {
	  int mirrorPoint = 346;
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel[][] pixels = this.getPixels2D();
	    
	    for (int row = 216; row < 339; row++)
	    {
	      for (int col = 221; col < mirrorPoint; col++)
	      {
	        leftPixel = pixels[row][col];      
	        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    }
	    
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  // A8 exercise 1
  public void copy2(Picture fromPic, 
                 int startRow, int endRow, int startCol, int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow;  fromRow <= endRow && toRow < toPixels.length; fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < endCol &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  // A8 exercise 2
  public void myCollage() {
	 Picture cp = new Picture("caterpillar.jpg");
	 Picture robot = new Picture("robot.jpg");
	 Picture snowman = new Picture("snowman.jpg");
	 cp.keepOnlyBlue();
	 this.copy(cp, 0, 0);
	 snowman.grayscale();
	 this.copy2(snowman, 72, 164, 164, 251);
	 robot.negate();
	 this.copy(robot,45, 450);
	 this.mirrorHorizontal();
  }
  
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    //this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
        edgeDist)
        	leftPixel.setColor(Color.BLACK);
        else
        	leftPixel.setColor(Color.WHITE);
      }
    }

    Pixel[][] copyPixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel botPixel = null;
    Color botColor = null;
    for (int row = 0; row < copyPixels.length-1; row++)
    {
    	for (int col = 0; col < copyPixels[0].length; col++)
    	{
    		topPixel = copyPixels[row][col];
    		botPixel = copyPixels[row+1][col];
    		botColor = botPixel.getColor();
    		if (topPixel.colorDistance(botColor) > edgeDist)
    		{
    			pixels[row][col].setColor(Color.BLACK);
    		}
    	}
    }
    
  }
  
  // chromakey method
  public void chromaKey(Picture background) {
	  
	  // make background and our base image into 2d arrays
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel[][] beach = background.getPixels2D();

	  // loop through rows and columns
	  for(int row = 0; row < pixels.length; row++) {
		  for(int col = 0; col < pixels[0].length; col++) {
			  // check if green is dominant RGB color and adjust red value so we dont have holes
			  // if pixel is green then switch color of pixel to the background image, aka replacing the "green screen"
			  if(pixels[row][col].getGreen() > pixels[row][col].getRed() + 28 && pixels[row][col].getGreen() > pixels[row][col].getBlue()) {
				  pixels[row][col].setGreen(beach[row][col].getGreen());
				  pixels[row][col].setRed(beach[row][col].getRed());
				  pixels[row][col].setBlue(beach[row][col].getBlue());
			  }
		  }
	  }
	  
  }
  
  // steganography encode and decode method
  public  void encodeAndDecode(Picture msg, Picture blank) {
	  Pixel[][] pixels = this.getPixels2D(); // picture to encode message in
	  Pixel[][] pixels2 = msg.getPixels2D(); // message being encoded
	  Pixel[][] pixels3 = blank.getPixels2D(); // blank background to decode onto
	  
	  // ENCODE
	  for (int i = 0; i<pixels.length-1; i++) { // outer  loop goes through rows
		  for (int j = 0; j<pixels[0].length-1; j++) { // inner loop goes through columns
			  if (i >= pixels2.length || j >= pixels2[0].length) // check that index does not go out of bounds
				  break;
			  if (pixels2[i][j].getRed() < 15) { // check if this pixel of the message is close to black
				  if (pixels[i][j].getRed() % 2 != 0) // check if red value of pixel in picture is odd
					  pixels[i][j].setRed(pixels[i][j].getRed()+1); // make pixel EVEN if its part of the message
			  }
			  else { // when pixel is not part of the message
				  if (pixels[i][j].getRed() % 2 == 0) // check if the red value of pixel in picture is even
				  pixels[i][j].setRed(pixels[i][j].getRed()+1); // make it odd since its not part of message
			  }  
		  }
	  }
	  
	  // DECODE
	  for (int i = 0; i<pixels.length-1; i++) { // outer goes through rows
		  for (int j = 0; j<pixels[0].length-1; j++) { // inner goes through columns
			  if (i >= pixels3.length || j >= pixels3[0].length) // check that index does not go out of bounds
				  break; 
			  if (pixels[i][j].getRed() % 2 == 0) { // check if red value of pixel is even + part of message
				  pixels3[i][j].setColor(Color.black); // if so, then make pixel black on the background
			  }
		  }  
	  }
  
  }
  
  // CUSTOM alternate method 
  public void alternate(Picture other) {
	  Pixel[][] pixels = this.getPixels2D(); // first picture
	  Pixel[][] pixels2 = other.getPixels2D(); // second picture
	  
	  for (int i = 0; i<pixels.length-1; i++) { // outer goes through rows
		  for (int j = 0; j<pixels[0].length-1; j++) { // inner goes through columns
			   if (i ==j) // check if rows value equals columns value... 
				   // if so make pixel on second picture the same color as the pixel on the first picture
			   pixels2[i][j].setRed(pixels[i][j].getRed());
			   pixels2[i][j].setGreen(pixels[i][j].getGreen());
			   pixels2[i][j].setBlue(pixels[i][j].getBlue());
		  }
	  }
	  
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
//    beach.explore();
//    beach.zeroBlue();
//    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
