package application;


import Oxyz.plane_line_vector.Point;
import Oxyz.plane_line_vector.Vector;
import Oxyz.room.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller {
	
	private Room room;
	private boolean check = false; // bien kiem tra da tao room hay chua, neu chua se khong the chuyen pane
	
	
	/********************************[ Switch Pane Event ]***********************************/

	@FXML AnchorPane createRoomPane;
	@FXML AnchorPane addObjectPane;
	@FXML AnchorPane addCameraPane;
	@FXML TabPane viewPane;
	@FXML AnchorPane detailPane;
	
	@FXML Button createRoomButton;
	@FXML Button addObjectButton;
	@FXML Button addCameraButton;
	@FXML Button viewButton;
	@FXML Button checkPointButton;
	@FXML Button DetailButton;
	
	
	// Switch Pane Event
	
	public void accessCreateRoomPane(ActionEvent e) {
		createRoomPane.setVisible(true);
		addObjectPane.setVisible(false);
		addCameraPane.setVisible(false);
		viewPane.setVisible(false);
		detailPane.setVisible(false);
	}
	
	public void accessAddObjectPane(ActionEvent e) {
		if(check) {
			createRoomPane.setVisible(false);
			addObjectPane.setVisible(true);
			addCameraPane.setVisible(false);
			viewPane.setVisible(false);
			detailPane.setVisible(false);
		} else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setTitle("NOTIFICATION");
			dialog.setContentText("Please create new room first!");
			dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
			dialog.show();
		}
	}
	
	public void accessAddCameraPane(ActionEvent e) {
		if(check) {
			createRoomPane.setVisible(false);
			addObjectPane.setVisible(false);
			addCameraPane.setVisible(true);
			viewPane.setVisible(false);
			detailPane.setVisible(false);
		} else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setTitle("NOTIFICATION");
			dialog.setContentText("Please create new room first!");
			dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
			dialog.show();
		}		
	}
	
	public void accessViewPane(ActionEvent e) {
		if(check) {
			createRoomPane.setVisible(false);
			addObjectPane.setVisible(false);
			addCameraPane.setVisible(false);
			viewPane.setVisible(true);
			detailPane.setVisible(false);
		} else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setTitle("NOTIFICATION");
			dialog.setContentText("Please create new room first!");
			dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
			dialog.show();
		}		
	}
	
	public void accessDetailPane(ActionEvent e) {
		if(check) {
			createRoomPane.setVisible(false);
			addObjectPane.setVisible(false);
			addCameraPane.setVisible(false);
			viewPane.setVisible(false);
			detailPane.setVisible(true);
		} else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setTitle("NOTIFICATION");
			dialog.setContentText("Please create new room first!");
			dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
			dialog.show();
		}
	}
	
	/********************************[ Button Event ]***********************************/
	
	// create room event
	
	@FXML TextField widthTextFieldCreateRoom, lengthTextFieldCreateRoom, heightTextFieldCreateRoom; // TextField nhap gia tri chieu rong, dai, cao cua can phong
	@FXML Label widthLabelCreateRoom, lengthLabelCreateRoom, heightLabelCreateRoom; // Cac canh bao input loi tuong ung
	@FXML Button addButtonCreateRoom;
	
	/**
	 * event handle create-room-task
	 * */
		
	public void createRoomEvent(ActionEvent e) {
		float width, length, height;
		
		width = getAndParse(widthTextFieldCreateRoom, widthLabelCreateRoom);
		if(width != -1) {
			length = getAndParse(lengthTextFieldCreateRoom, lengthLabelCreateRoom);
			if(length != -1) {
				height = getAndParse(heightTextFieldCreateRoom, heightLabelCreateRoom);
				if(height != -1) {
					room = new Room(width, length, height);
					
					Dialog<String> dialog = new Dialog<>();
					dialog.setTitle("NOTIFICATION");
					dialog.setContentText("Create room success!");
					dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
					dialog.show();
					
					widthTextFieldCreateRoom.setEditable(false);
					lengthTextFieldCreateRoom.setEditable(false);
					heightTextFieldCreateRoom.setEditable(false);
					
					check = true;
					
//					System.out.println(width + "-" + length + "-" +height);
					
//					widthLabelCreateRoom.setVisible(false);
//					lengthLabelCreateRoom.setVisible(false);
//					heightLabelCreateRoom.setVisible(false);
				}
			}
		}
	}
	
	
	// Add Object Event
	
	@FXML TextField XA1TextFieldAddObject, YA1TextFieldAddObject, ZA1TextFieldAddObject; // TextField nhap toa do x, y, z cua dinh A1 cua vat the
	@FXML Label XA1LabelAddObject, YA1LabelAddObject, ZA1LabelAddObject; // Cac canh bao loi lien quan
	
	@FXML TextField XB1TextFieldAddObject, YB1TextFieldAddObject, ZB1TextFieldAddObject;
	@FXML Label XB1LabelAddObject, YB1LabelAddObject, ZB1LabelAddObject;
	
	@FXML TextField XC1TextFieldAddObject, YC1TextFieldAddObject, ZC1TextFieldAddObject;
	@FXML Label XC1LabelAddObject, YC1LabelAddObject, ZC1LabelAddObject;
	
	@FXML TextField heightTextFieldAddObject; // TextField nhap chieu cao vat the
	@FXML Label heightLabelAddObject;
	
	public void addObjectEvent(ActionEvent e) {
		
		Point A1 = new Point(), B1 = new Point(), C1 = new Point();
		
		// Lay du lieu cho A1
		float xA1 = 0, yA1 = 0, zA1 = 0;
		
		xA1 = getAndParse(XA1TextFieldAddObject, XA1LabelAddObject);
		if(xA1 != -1) {
			yA1 = getAndParse(YA1TextFieldAddObject, YA1LabelAddObject);
			if(yA1 != -1) {
				zA1 = getAndParse(ZA1TextFieldAddObject, ZA1LabelAddObject);
				if(zA1 != -1) {
					A1 = new Point(xA1, yA1, zA1);
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			return;
		}
		
		// Lay du lieu cho B1
		float xB1 = 0, yB1 = 0, zB1 = 0;
		xB1 = getAndParse(XB1TextFieldAddObject, XB1LabelAddObject);
		if(xB1 != -1) {
			yB1 = getAndParse(YB1TextFieldAddObject, YB1LabelAddObject);
			if(yB1 != -1) {
				zB1 = getAndParse(ZB1TextFieldAddObject, ZB1LabelAddObject);
				if(zB1 != -1) {
					B1 = new Point(xB1, yB1, zB1);
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			return;
		}
			
		// Lay du lieu cho C1
		float xC1 = 0, yC1 = 0, zC1 = 0;
		xC1 = getAndParse(XC1TextFieldAddObject, XC1LabelAddObject);
		if(xC1 != -1) {
			yC1 = getAndParse(YC1TextFieldAddObject, YC1LabelAddObject);
			if(yC1 != -1) {
				zC1 = getAndParse(ZC1TextFieldAddObject, ZC1LabelAddObject);
				if(zC1 != -1) {
					C1 = new Point(xC1, yC1, zC1);
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			return;
		}
			
		// Lay du lieu cho height
			
		float height = getAndParse(heightTextFieldAddObject, heightLabelAddObject);
		if(height != -1) {
			if(height == 0) {
				heightLabelAddObject.setText("Height must be greater than 0!");
				heightLabelAddObject.setVisible(true);
				return;
			} else {
				heightLabelAddObject.setVisible(false);
			}
		} else {
			heightLabelAddObject.setText("Invalid Input!");
			return;
		}
		
		Dialog<String> dialog = new Dialog<>();
		
		if(Vector.isPerpendicular(A1, B1, C1)) {
			if(room.addObject(A1, B1, C1, height)) {
				dialog.setTitle("NOTIFICATION");
				dialog.setContentText("Add Object Success!");
			} else {
				dialog.setTitle("WARNING");
				dialog.setHeaderText("Invalid Position!");
				dialog.setContentText("This Object's Position is Invalid!");
			}
		} else {
			dialog.setTitle("WARNING");
			dialog.setHeaderText("Invalid Shape!");
			dialog.setContentText("This Object isnot rectangular!");
		}
		
		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
		dialog.show();
			
	}
	
	
	// Add Camera Event
	
	@FXML TextField xTextFieldAddCamera, yTextFieldAddCamera, zTextFieldAddCamera;
	@FXML Label xLabelAddCamera, yLabelAddCamera, zLabelAddCamera;
	
	@FXML TextField alphaTextFieldAddCamera, betaTextFieldAddCamera;
	@FXML Label alphaLabelAddCamera, betaLabelAddCamera;
	
	public void addCameraEvent(ActionEvent e) {
		float x = 0, y = 0, z = 0;
		Point p = new Point();
		
		x = getAndParse(xTextFieldAddCamera, xLabelAddCamera);
		if(x != -1) {
			y = getAndParse(yTextFieldAddCamera, yLabelAddCamera);
			if(y != -1) {
				z = getAndParse(zTextFieldAddCamera, zLabelAddCamera);
				if(z != -1) {
					p = new Point(x, y, z);
				} else {
					return;
				}
			} else {
				return;
			}
		} else {
			return;
		}
		
		float alpha, beta;
		alpha = getAndParse(alphaTextFieldAddCamera, alphaLabelAddCamera);
		if(alpha != -1) {
			if(alpha > 90) {
				alphaLabelAddCamera.setVisible(true);
				return;
			} else {
				alphaLabelAddCamera.setVisible(false);
			}
		} else {
			return;
		}
		
		beta = getAndParse(betaTextFieldAddCamera, betaLabelAddCamera);
		if(beta != -1) {
			if(beta > 90) {
				betaLabelAddCamera.setVisible(true);
				return;
			} else {
				betaLabelAddCamera.setVisible(false);
			}
		} else {
			return;
		}
		
		Dialog<String> dialog = new Dialog<>();
		
		if(room.addCameara(p, alpha, beta)) {
			dialog.setTitle("NOTIFICATION");
			dialog.setContentText("Add Camera Success!");
		} else {
			dialog.setTitle("WARNING");
			dialog.setHeaderText("Invalid Position!");
			dialog.setContentText("This Camera's Position is Invalid!");
		}
//		System.out.println(p.getX() + "-" + p.getY() + "-" + p.getZ());
//		System.out.println(alpha + "-" + beta);
		
		dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
		dialog.show();
	}
	
	/****************************[ Other Method ]****************************************/

	/**
	 * Lay text trong TextField, chuyen ve float, in ra loi neu that bai
	 * */
	
	public float getAndParse(TextField inputTextField, Label errorLabel) { 
		float inputFloat;
		try {
			inputFloat = Float.parseFloat(inputTextField.getText().trim());
			if(inputFloat < 0) {
				errorLabel.setVisible(true);
				return -1;
			} else {
				errorLabel.setVisible(false);
				return inputFloat;
			}
			
		} catch (Exception e) {
			errorLabel.setVisible(true);
			return -1;
		}
	}
	
}
