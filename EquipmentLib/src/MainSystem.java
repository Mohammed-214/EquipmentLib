import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainSystem {

	static String fileName = null;
	static EquipmentLibrary eqLi = new EquipmentLibrary();
	static Scanner in = new Scanner(System.in);
	static Boolean running = true;

	public static void main(String[] args) {
		while (running) {
			System.out.println("\nEnter 0 for load a library."
					+ "\nEnter 1 for save and quit"
					+ "\nEnter 2 for list all books in library"
					+ "\nEnter 3 for add book to library");

			int answer = in.nextInt();
			switch (answer) {
			case 0:
				System.out.println("Enter the file name to load");
				FileInputStream f = null;
				ObjectInputStream o = null;
				File file = new File(in.next() + ".ser");
				if (file.exists()) {
					try {
						f = new FileInputStream(file);
						o = new ObjectInputStream(f);
						eqLi = (EquipmentLibrary) o.readObject();
						f.close();
						o.close();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					System.out.println("\nThe file does not exist!");
				}				break;

			case 1:
				System.out.println("Enter file name: ");
				fileName = in.next() + ".ser";
				running = false;
				FileOutputStream ff = null;
				ObjectOutputStream oo = null;
				try {
					ff = new FileOutputStream(fileName);
					oo = new ObjectOutputStream(ff);
					oo.writeObject(eqLi);
					ff.close();
					oo.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				break;
			case 2:
				System.out.println(eqLi.toString());
				break;
			case 3:
				String equipName;
				String epuipManfc;
				String equipMod;
				String equipSerial;
				String equipMac;
				String equipIp;
				String equipLoc;

				System.out.println("\nEnter Title: ");
				equipName = in.next();

				System.out.println("\nEnter Author: ");
				epuipManfc = in.next();

				System.out.println("\nEnter ISBN: ");
				equipMod = in.next();

				System.out.println("\nEnter Price: ");
				equipSerial = in.next();

				System.out.println("\nEnter Author: ");
				equipMac = in.next();

				System.out.println("\nEnter ISBN: ");
				equipIp = in.next();

				System.out.println("\nEnter Price: ");
				equipLoc = in.next();

				EquipmentInfo eq = new EquipmentInfo( equipName,  epuipManfc,  equipMod,  equipSerial,  equipMac,  equipIp,  equipLoc);
				eqLi.addEquip(eq);				break;
			}
		}
		System.exit(0);
	}

	private static void addEquip() {
		// TODO Auto-generated method stub

	}

	private static void saveAndQuit() {
		// TODO Auto-generated method stub


	}

	private static void loadScript(String name) {
		// TODO Auto-generated method stub

	}

}

class EquipmentInfo implements Serializable {
	private String equipName;
	private String epuipManfc;
	private String equipMod;
	private String equipSerial;
	private String equipMac;
	private String equipIp;
	private String equipLoc;


	public EquipmentInfo(){
		equipIp = "";
		equipMod = "";
		equipName = "";
		epuipManfc= "";
		equipMod= "";
		equipSerial="";
		equipMac="";
		equipIp="";
		equipLoc="";

	}

	public EquipmentInfo(String equipName, String epuipManfc, String equipMod, String equipSerial, String equipMac, String equipIp, String equipLoc) {
		this.equipName = equipName;
		this.epuipManfc = epuipManfc;
		this.equipMod = equipMod;
		this.equipSerial = equipSerial;
		this.equipMac = equipMac;
		this.equipIp = equipIp;
		this.equipLoc = equipLoc;
	}

	public EquipmentInfo(String equipName, String equipIp, String equipMod, String equipSerial, String equipMac, String equipSerial1, String epuipManfc, String equipLoc) {
	}

	@Override
	public String toString() {
		return "Equipments details are: " +
				"\nequipName='" + equipName + '\'' +
				"\n, epuipManfc='" + epuipManfc + '\'' +
				"\n, equipMod='" + equipMod + '\'' +
				"\n, equipSerial='" + equipSerial + '\'' +
				"\n, equipMac='" + equipMac + '\'' +
				"\n, equipIp='" + equipIp + '\'' +
				"\n, equipLoc='" + equipLoc + '\'' +
				'}';
	}

}

class EquipmentLibrary extends Object implements Serializable {

	private List<EquipmentInfo> collection;

	public EquipmentLibrary(){
		collection = new ArrayList<EquipmentInfo>();
	}

	public void addEquip(EquipmentInfo equipmentInfo){
		collection.add(equipmentInfo);
	}

	@Override
	public String toString() {
		String total = "\n";
		/*
		for (int i=0; i<collection.size(); i++){
			Book b = collection.get(i);
			total = total + b.toString();

		}
		*/
		Iterator<EquipmentInfo> i = collection.iterator();
		while(i.hasNext()){
			EquipmentInfo b = (EquipmentInfo) i.next();
			total = total + b.toString();
		}
		return total;
	}

}
