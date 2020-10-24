package employer;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class graphique extends JFrame     {

	
	private JTextField nom;
	private JLabel lblIdDeLemployer;
	private JTextField id;
	private JLabel lblPosteDeLemployer;
	private JLabel lblSalaireDeLemployer;
	private JTextField salaire;
	private JButton btnRecherche;
	private JLabel lblNewLabel;
	private JLabel lblNom;
	private JLabel lblId;
	private JTextField nom2;
	private JTextField id2;
	private JButton btnAjouter;
	private JButton btnSupprimer;
	public   String[] res=new String[3];
	private JLabel lblPoste;
	private JLabel lblSalaire;
	private JLabel lbposte;
	private JLabel lbsalaire;
	private HashMap<String,Component> comp;

	/**
	 * Launch the application.
	 **/
	
	
	
	 public static Connection getConnection(){
		 try {
			   //connection to database
			   Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employers", "root", "");
			  
			   //create statement 
			   Statement myStmt = myConn.createStatement();
			   }
		 catch (Exception exc) {
			   exc.printStackTrace();
			  } return null;
	
	}
	
	/**
	 * Create the application.
	 */
	
	public graphique() {
		
		initialize();
		
		this.setVisible(true);
		
		
		
		
	}
	/**methodes to get components by name**/
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("gestion d'employer"); 
		this.setBounds(100, 100, 444, 475);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		
		//nom de l'employer  
		JLabel lblNomDeLemployer = new JLabel("nom de l'employer:");
		lblNomDeLemployer.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNomDeLemployer.setBackground(Color.DARK_GRAY);
		lblNomDeLemployer.setBounds(0, 0, 142, 27);
		this.getContentPane().add(lblNomDeLemployer);
		
		nom = new JTextField();
		nom.setBounds(245, 4, 142, 20);
	this.getContentPane().add(nom);
		nom.setColumns(10);
		
		//id de l'employer 
		lblIdDeLemployer = new JLabel("ID de l'employer:");
		lblIdDeLemployer.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblIdDeLemployer.setBackground(Color.DARK_GRAY);
		lblIdDeLemployer.setBounds(0, 38, 142, 27);
		this.getContentPane().add(lblIdDeLemployer);
		
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(245, 42, 142, 20);
	    this.getContentPane().add(id);
		
		//poste de l'employer 
		lblPosteDeLemployer = new JLabel("poste de l'employer:");
		lblPosteDeLemployer.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblPosteDeLemployer.setBackground(Color.DARK_GRAY);
		lblPosteDeLemployer.setBounds(0, 76, 142, 27);
    	this.getContentPane().add(lblPosteDeLemployer);
		String[] e= new String [] {"Directeur","Ingénieur","Technicien","Ouvrier","Responsable"};
		JComboBox poste = new JComboBox(e);
		poste.setBounds(245, 80, 135, 20);
	   this.getContentPane().add(poste);
		
		//salaire de l'employer
		lblSalaireDeLemployer = new JLabel("salaire de l'employer:");
		lblSalaireDeLemployer.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblSalaireDeLemployer.setBackground(Color.DARK_GRAY);
		lblSalaireDeLemployer.setBounds(0, 114, 142, 27);
	    this.getContentPane().add(lblSalaireDeLemployer);
		
		 
		salaire = new JTextField();
		salaire.setColumns(10);
		salaire.setBounds(245, 118, 142, 20);
	    this.getContentPane().add(salaire);
	
		// buttons ajouter 
		btnAjouter = new JButton("ajouter");
		btnAjouter.setBounds(44, 167, 118, 23);
	    this.getContentPane().add(btnAjouter);
        btnAjouter.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0) {
        		
        		  
        		try{
        			Connection myConn = getConnection();
        			   
      			  
      			 String nom1= nom.getText();
     			   int id1=Integer.parseInt(id.getText());
     			String poste1= poste.getToolTipText();
     			  int salaire1=Integer.parseInt(salaire.getText());
     			 String  req="INSERT INTO employer(id,name,poste, salary) VALUES ('"+id1+"','"+nom1+"','"+poste1+"','"+salaire1+"')";
     			   //create statement 
     			  PreparedStatement ps =myConn.prepareStatement(req);
     			 ps.execute(req);
     			JOptionPane.showMessageDialog(null, "l'employer a été ajouté" );
 			   }catch(Exception e){
 				   e.getStackTrace();
 				  JOptionPane.showMessageDialog(null, "l'employer n'a pas été ajouté" );
 			   }
        		//alert si un textfield est vide
        		if(nom.getText().isEmpty()|| id.getText().isEmpty()||salaire.getText().isEmpty())
        		{
        			JOptionPane.showMessageDialog(null, "entrer toute les donneés");
        		}
        	}});
        		
		//button supprimer
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(213, 167, 118, 23);
	     this.getContentPane().add(btnSupprimer);
		btnSupprimer.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg) {
        		try{
        			Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employers", "root", "");
     			   
       			 String nom2= nom.getText();
   			   int id2=Integer.parseInt(id.getText());
   			 String  req2="DELETE FROM employer WHERE id='"+id2+"' OR name='"+nom2+"'";
   			 PreparedStatement preparedStmt = myConn.prepareStatement(req2);
   		      preparedStmt.execute();
			 
   		     myConn.close();
			 
 			
   			JOptionPane.showMessageDialog(null, "l'employer a été supprimé" );
			   }catch(Exception e){
				   e.getStackTrace();
				  JOptionPane.showMessageDialog(null, "l'employer n'a pas été supprimé ");
			   }
        		

        	}});
		
		
		lblNewLabel = new JLabel("Rechrche un employer:");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 227, 186, 27);
	    this.getContentPane().add(lblNewLabel);
		
		lblNom = new JLabel("par Nom:");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNom.setBounds(44, 254, 71, 14);
	   this.getContentPane().add(lblNom);
		
		lblId = new JLabel("par ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBounds(213, 254, 46, 14);
	     this.getContentPane().add(lblId);
		
		nom2 = new JTextField();
		nom2.setBounds(29, 279, 86, 20);
	    this.getContentPane().add(nom2);
		nom2.setColumns(10);
		
		id2 = new JTextField();
		id2.setBounds(183, 279, 86, 20);
	      this.getContentPane().add(id2);
		id2.setColumns(10);
		
		JLabel lbnom = new JLabel("nom");
		lbnom.setBounds(122, 373, 94, 14);
		getContentPane().add(lbnom);
		
		
		
		JLabel lbid = new JLabel("id");
		lbid.setBounds(108, 406, 94, 14);
		getContentPane().add(lbid);
		
		lbposte = new JLabel("poste");
		lbposte.setBounds(334, 373, 94, 14);
		getContentPane().add(lbposte);
		
		lbsalaire = new JLabel("salaire");
		lbsalaire.setBounds(344, 406, 94, 14);
		getContentPane().add(lbsalaire);
		
		
		//buttton recherche
		btnRecherche = new JButton("Recherche");
		btnRecherche.setBounds(84, 318, 118, 23);
	    this.getContentPane().add(btnRecherche);
	    btnRecherche.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0) {
        		try{
        			Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employers", "root", "");
     			   
          			String nom3=nom2.getText();
          			int id3=Integer.parseInt(id2.getText());
          			
       			   PreparedStatement ps =myConn.prepareStatement("SELECT FROM employer WHERE nom ='"+nom3+"' OR id='"+id3+"'");
       			   
       			   ResultSet rs = ps.executeQuery();
       			   String nom=rs.getString("name");
       			   int id=rs.getInt("id");
       			   String poste=rs.getString("poste");
       			   int salaire=rs.getInt("salary");
       			   Employer em= new Employer(nom,id,poste,salaire);
       			   lbnom.setText(em.getNom());
       			   lbid.setText(String.valueOf(em.getId()));
       			   lbposte.setText(em.getPoste());
       			   lbsalaire.setText(String.valueOf(em.getSalaire()));
       			   myConn.close();
       			   JOptionPane.showMessageDialog(null,"element trouvé");
       			   
       			   
     			   }catch(Exception e){
     				   e.getMessage();
     				  JOptionPane.showMessageDialog(null,"élement non trouvé");
           	}}});
        		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(223, 224, -22, -21);
		this.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 230, 422, 2);
		this.getContentPane().add(separator_1);
		
		JLabel label = new JLabel("");
		label.setBounds(72, 327, 46, 14);
		this.getContentPane().add(label);
		
		JLabel resultat = new JLabel("");
		resultat.setBounds(54, 189, 277, 27);
		this.getContentPane().add(resultat);
		
		JLabel label_1 = new JLabel("nom de l'employer:");
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		label_1.setBackground(Color.DARK_GRAY);
		label_1.setBounds(0, 366, 124, 27);
		this.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("ID de l'employer:");
		label_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		label_2.setBackground(Color.DARK_GRAY);
		label_2.setBounds(0, 399, 118, 27);
		this.getContentPane().add(label_2);
		
		
		JLabel lb_3 = new JLabel("poste de l'employer:");
		lb_3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lb_3.setBackground(Color.DARK_GRAY);
		lb_3.setBounds(213, 366, 135, 27);
		this.getContentPane().add(lb_3);
		
		JLabel lb_4 = new JLabel("salaire de l'employer:");
		lb_4.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lb_4.setBackground(Color.DARK_GRAY);
		lb_4.setBounds(213, 399, 135, 27);
		this.getContentPane().add(lb_4);
		
		
		
		
	}
	}

	

