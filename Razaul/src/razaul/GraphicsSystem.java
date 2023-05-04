package razaul;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public class GraphicsSystem extends LBUGraphics
{
        private static final long serialVersionUID = 1L;

		public static void main(String[] args)
        {
                new GraphicsSystem(); //create instance of class that extends LBUGraphics (could be separate class without main), gets out of static context
        }
		
		public void about() {
			setxPos(130);
	        setyPos(310);
	        setStroke(5);
	        turnRight(180);
	        penDown();
	        forward(150);
	        turnRight(90);
	        forward(50);
	        turnRight(45);
	        forward(20);
	        turnRight(45);
	        forward(60);
	        turnRight(90);
	        forward(30);
	        turnLeft(110);
	        forward(85);
	        
	        penUp();
	        turnLeft(70);
	        forward(30);
	        penDown();
	        turnLeft(80);
	        forward(150);
	        turnRight(80);
	        forward(20);
	        turnRight(80);
	        forward(150);
	        
	        penUp();
	        turnLeft(80);
	        forward(25);
	        turnLeft(90);
	        forward(50);
	        turnRight(180);
	        penDown();
	        forward(40);
	        turnLeft(90);
	        forward(50);
	        turnLeft();
	        forward(140);
	        
	        penUp();
	        turnRight(90);
	        forward(60);
	        
	        penDown();
	        turnLeft(260);
	        forward(150);
	        turnLeft(180);
	        penUp();
	        forward(150);
	        turnRight(80);
	        penDown();
	        forward(10);
	        turnRight(80);
	        forward(150);
	        
	        penUp();
	        turnLeft(90);
	        forward(35);
	        penDown();
	        turnLeft(80);
	        forward(130);
	        turnLeft(180);
	        penUp();
	        forward(130);
	        penDown();
	        turnLeft(90);
	        forward(55);
	        turnLeft(90);
	        forward(130);
	        
	        penUp();
	        turnRight(90);
	        forward(43);
	        penDown();
	        turnRight(90);
	        forward(130);
	        turnLeft(90);
	        forward(50);
	        reset();
		}
		
		public void square(int side) {
			turnRight();
			forward(side);
			penDown();
			forward(side);
			turnRight(90);
			forward(side);
			turnRight(90);
			forward(side);
			turnRight(90);
			forward(side);
			turnRight(90);
			reset();	
		}
		
		public void eqlTriangle(int size) {
			turnRight();
			forward(90);
			penDown();
			forward(size);
			turnLeft(60);
			forward(-size);
			turnLeft(60);
			forward(size);
			reset();	
		}
		
		public void triangle(int size1, int size2, int size3) {	
			penDown();
			forward(size1);  // move forward by the length of the first side
		    turnLeft(180 - (int)Math.toDegrees(Math.acos((size1*size1 + size2*size2 - size3*size3) / (2.0*size1*size2)))); // turn left by the angle opposite the second side
		    forward(size2); // move forward by the length of the second side
		    turnLeft(180 - (int)Math.toDegrees(Math.acos((size2*size2 + size3*size3 - size1*size1) / (2.0*size2*size3))));  // turn left by the angle opposite the third side
		    forward(size3);  // move forward by the length of the third side
		    reset();
		}

        public GraphicsSystem()
        {
                JFrame MainFrame = new JFrame();            //create a frame to display the turtle panel on
                MainFrame.setLayout(new FlowLayout());     //not strictly necessary
                MainFrame.add(this);                       //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
                MainFrame.pack();						   //set the frame to a prefer size we can see
                MainFrame.setVisible(true);                //now display it
                setTurtleImage("./src/razaul/cat.png");		//set turtle image
        }
        
        ArrayList<String> List=new ArrayList<>();
        public ArrayList<String> hist(String Command){
        	List.add(Command);
        	return List;
        }
        @Override
        public void processCommand(String command)              //this method must be provided because LBUGraphics will call it when it's JTextField is used
        {
        	hist(command);
    		String[] params = command.split(" ");
    		int length=params.length;
    		command = params[0];

    		//About
    		if (command.equalsIgnoreCase("about") && length==1) {
    			about();
    		}
    		
    		else if (command.equalsIgnoreCase("about") && length>1){
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//Forward
    		else if (command.equalsIgnoreCase("forward") && length ==1) {
    			forward(90);
    		}
    		
    		else if (command.equalsIgnoreCase("forward") && length==2){
    			try{
    				forward("+"+params[1]);
    			}
    			catch (Exception e){
    				System.out.println("Error: Sorry, You must pass a positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("forward") && length>2){
    			System.out.println("Error: This "+params[0]+" command takes only one or no arguments.");
    		}
    		
    		//Backward
    		else if (command.equalsIgnoreCase("backward") && length ==1) {
    			forward("-"+90);
    		}
    		
    		else if (command.equalsIgnoreCase("backward") && length==2){
    			try{
    				forward("-"+params[1]);
    			}
    			catch (Exception e){
    				System.out.println("Error: Sorry, You must pass a positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("backward") && length>2){
    			System.out.println("Error: This "+params[0]+" command takes only one or no arguments.");
    		}
    		
    		//Circle
    		else if (command.equalsIgnoreCase("circle") && length ==1) {
    			circle(90);
    		}
    		
    		else if (command.equalsIgnoreCase("circle") && length==2){
    			try{
    				int radius= Integer.parseInt("+"+params[1]);
    				circle(radius);
    			}
    			catch (Exception e){
    				System.out.println("Error: Sorry, You must pass a positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("circle") && length>2){
    			System.out.println("Error: This "+params[0]+" command takes only one or no arguments.");
    		}
    		
    		//TurnLeft
    		else if (command.equalsIgnoreCase("turnleft") && length ==1) {
    			turnLeft(90);
    		}
    		
    		else if (command.equalsIgnoreCase("turnleft") && length==2){
    			try{
    				turnLeft("+"+params[1]);
    			}
    			catch (Exception e){
    				System.out.println("Error: Sorry, You must pass a positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("turnleft") && length>2){
    			System.out.println("Error: This "+params[0]+" command takes only one or no arguments.");
    		}
    		
    		//TurnRight
    		else if (command.equalsIgnoreCase("turnright") && length ==1) {
    			turnRight(90);
    		}
    		
    		else if (command.equalsIgnoreCase("turnright") && length==2){
    			try{
    				turnRight("+"+params[1]);
    			}
    			catch (Exception e){
    				System.out.println("Error: Sorry, You must pass a positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("turnright") && length>2){
    			System.out.println("Error: This "+params[0]+" command takes only one or no arguments.");
    		}
    		
    		//PenUp
    		else if (command.equalsIgnoreCase("penup") &&length==1){
    			penUp();
    			}
    		else if (command.equalsIgnoreCase("penup") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//PenDown
    		else if (command.equalsIgnoreCase("pendown") &&length==1){
    			penDown();
    			}
    		else if (command.equalsIgnoreCase("pendown") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//reset
    		else if (command.equalsIgnoreCase("reset") &&length==1){
    			reset();
    			}
    		else if (command.equalsIgnoreCase("reset") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//clear
    		else if (command.equalsIgnoreCase("clear") &&length==1){
    			clear();
    			}
    		else if (command.equalsIgnoreCase("clear") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//PenColor_green
    		else if (command.equalsIgnoreCase("green") &&length==1){
    			setPenColour(Color.green);
    			}
    		else if (command.equalsIgnoreCase("green") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//PenColor_yellow
    		else if (command.equalsIgnoreCase("yellow") &&length==1){
    			setPenColour(Color.yellow);
    			}
    		else if (command.equalsIgnoreCase("yellow") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//PenColor_white
    		else if (command.equalsIgnoreCase("white") &&length==1){
    			setPenColour(Color.white);
    			}
    		else if (command.equalsIgnoreCase("white") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//PenColor_red
    		else if (command.equalsIgnoreCase("red") &&length==1){
    			setPenColour(Color.red);
    			}
    		else if (command.equalsIgnoreCase("red") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//PenColor_blue
    		else if (command.equalsIgnoreCase("blue") &&length==1){
    			setPenColour(Color.blue);
    			}
    		else if (command.equalsIgnoreCase("blue") &&length>1) {
    			System.out.println("Error: This "+params[0]+" command doesn't take any arguments");
    		}
    		
    		//Square
    		else if (command.equalsIgnoreCase("square") && length ==1) {
    			System.out.println("Error: You must pass a positive Integer as argument.");
    		}
    		
    		else if (command.equalsIgnoreCase("square") && length ==2) {
    			try {
				int side = Integer.parseInt("+"+params[1]);
				square(side);
    			}
    			catch (Exception e) {
    				System.out.println("Error: Sorry, You must pass a positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("square") && length >2){
    				System.out.println("Error: This "+params[0]+" command takes only one positive integer as arguments");
    			}
    		
    		//PenColor With three R, G, B values as argument
    		else if (command.equalsIgnoreCase("pencolor") && length ==1) {
    			System.out.println("Error: You must pass positive Integer as argument.");
    		}
    		
    		else if (command.equalsIgnoreCase("pencolor") && length ==4) {
    			try {
    				int r=Integer.parseInt("+"+params[1]);
    				int g=Integer.parseInt("+"+params[2]);
    				int b=Integer.parseInt("+"+params[3]);
    				Color color= new Color(r,g,b);
    				setPenColour(color);
    			}
    			catch (Exception e) {
    				System.out.println("Error: Sorry, You must pass three positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("pencolor") && length >4 || command.equalsIgnoreCase("pencolor") && length <4){
    				System.out.println("Error: This "+params[0]+" command takes only three positive integer as arguments");
    			}
    		
    		//PenWidth
    		else if (command.equalsIgnoreCase("penwidth") &&length==1) {
    			System.out.println("Error: You must pass a positive Integer as argument.");
    		}
    		
    		else if (command.equalsIgnoreCase("penwidth") &&length==2){
    			try{
    				int size1 = Integer.parseInt("+"+params[1]);
    				setStroke(size1);
    			}
    			catch (Exception e){
    				System.out.println("Error: Sorry, You must pass an positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("penwidth") && length >2){
				System.out.println("Error: This "+params[0]+" command takes only one positive integer as arguments");
			}
    		
    		//EquilateralTriangle
    		else if (command.equalsIgnoreCase("equaltriangle") && length ==1) {
    			System.out.println("Error: You must pass a positive Integer as argument.");
    		}
    		
    		else if (command.equalsIgnoreCase("equaltriangle") && length ==2) {
    			try {
				int size = Integer.parseInt("+"+params[1]);
				eqlTriangle(size);
    			}
    			catch (Exception e) {
    				System.out.println("Error: Sorry, You must pass a positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("equaltriangle") && length >2){
    				System.out.println("Error: This "+params[0]+" command takes only one positive integer as arguments");
    			}
    		
    		//Triangle having three sides 
    		else if (command.equalsIgnoreCase("triangle") && length ==1) {
    			System.out.println("Error: You must pass positive Integer as argument.");
    		}
    		
    		else if (command.equalsIgnoreCase("triangle") && length ==4) {
    			try {
    				int size1 = Integer.parseInt(params[1]); 
    			    int size2 = Integer.parseInt(params[2]); 
    			    int size3 = Integer.parseInt(params[3]); 
    			    
    			    triangle(size1, size2, size3); // call the drawTriangle method with the sides passed as parameters
    			}
    			catch (Exception e) {
    				System.out.println("Error: Sorry, You must pass three positive integer value as parameter.");
    			}
    		}
    		
    		else if (command.equalsIgnoreCase("triangle") && length >4 || command.equalsIgnoreCase("triangle") && length <4){
    				System.out.println("Error: This "+params[0]+" command takes only three positive integer as arguments");
    			}
    		
    		//Image Save
    		else if (command.equalsIgnoreCase("save") && length ==1) {
    			JFileChooser fileChooserobj = new JFileChooser();
    			int result = fileChooserobj.showSaveDialog(null);
    			if (result == JFileChooser.APPROVE_OPTION) {
    				File file = fileChooserobj.getSelectedFile();
    				String fileName = file.getName();
				    String fileExtension = "";
				    int i = fileName.lastIndexOf('.');
				    if (i > 0) {
				       fileExtension = fileName.substring(i + 1);
				    }
				    BufferedImage image = getBufferedImage();
				    try {
				       ImageIO.write(image, fileExtension, file);
				    } catch (IOException e) {
				       System.out.println(e);
				    }
				    }
               }
    		else if (command.equalsIgnoreCase("save") && length >1) {
    			System.out.println("Error: This "+params[0]+" command does't takes any arguments");
    		}
    		//Load Image
               
               else if (command.equalsIgnoreCase("load") && length ==1) {
            	   JFileChooser fileChooser = new JFileChooser();
            	   int result = fileChooser.showOpenDialog(null);
            	   if (result == JFileChooser.APPROVE_OPTION) {
            		   File file = fileChooser.getSelectedFile();
            		   try {
            			   BufferedImage image = ImageIO.read(file);
            			   setBufferedImage(image);
            			  }
            		   catch(Exception e) {
            			   System.out.println(e);
                       }
            	   }
               }
               else if (command.equalsIgnoreCase("load") && length >1) {
       			System.out.println("Error: This "+params[0]+" command does't takes any arguments");
       		}
    		
    		//save command
               else if (command.equalsIgnoreCase("savehistory")) {
            	   JFileChooser fileChooserobj = new JFileChooser();
	       			int result = fileChooserobj.showSaveDialog(null);
	       			if (result == JFileChooser.APPROVE_OPTION) {
	       				File file = fileChooserobj.getSelectedFile();
       				try {  	
       			        FileWriter fwrite = new FileWriter(file,true);
       			        for (String i: hist("")) {
       			        	String a= String.format("%s\n",i);
       			        	fwrite.write(a);
       			        }  
       			        fwrite.close();   
       			        System.out.println("Content is successfully executed.");  
       			    } catch (IOException e) {  
       			        System.out.println("Unexpected error occurred");  
       			        e.printStackTrace();  
       			        }  
       			}
               }
    		
    		
    		//Load Saved Command
               else if (command.equalsIgnoreCase("loadhistory")) {
            	   JFileChooser fileChooserobj = new JFileChooser();
	       			int result = fileChooserobj.showOpenDialog(null);
	       			if (result == JFileChooser.APPROVE_OPTION) {
	       				File file = fileChooserobj.getSelectedFile();
       				try {  	
       					String filePath = file.getAbsolutePath();
       					File f1 =new File(filePath);
       					Scanner dataReader=new Scanner(f1);
       					while(dataReader.hasNextLine()) {
       						String fileData=dataReader.nextLine();
       						if (fileData.equals("savehistory")) {
       							break;
       						}
       						else {
       							processCommand(fileData);
       						}
       					}
       				dataReader.close();
       			        System.out.println("Content is successfully wrote to the file.");  
       			    } catch (IOException e) {  
       			        System.out.println("Unexpected error occurred");  
       			        e.printStackTrace();  
       			        }  
       			}
               }
    		
    		//Else block shows command not found error...
    		else {
    			System.out.println("Error: This "+params[0]+" command not found.");
    		}
        }
}
