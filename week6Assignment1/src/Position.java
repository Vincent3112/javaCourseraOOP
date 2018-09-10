import java.util.ArrayList;

public class Position {

	double x;
	double y;
	
	
	Position(double x,double y){
		this.x = x;
		this.y = y;
	}
	
	Position(){
		x = 0;
		y = 0;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	
}

class Neurone {
	
	Position position;
	double signalInterne;
	double facteurAttenuation;
	ArrayList<Neurone> connexions = new ArrayList<Neurone>();
	
	Neurone(){
		
	}
	
	Neurone(Position position, double facteurAttenuation){
		this.position = position;
		this.facteurAttenuation = facteurAttenuation;
		signalInterne = 0;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public int getNbConnexions() {
		return connexions.size();
	}
	
	public Neurone getConnexion(int index) {
		return connexions.get(index);
	}
	
	public double getAttenuation() {
		return facteurAttenuation;
	}
	
	public double getSignal() {
		return signalInterne;
	}
	
	public void connexion(Neurone n) {
		connexions.add(n);
	}
	
	public void recoitStimulus(double stimulus) {
		signalInterne = stimulus*facteurAttenuation;
		for(Neurone neurone : connexions) {
			neurone.recoitStimulus(signalInterne);
		}
	}
	
	public String toString() {
		if(connexions.size() == 0) {
			System.out.println("Le neurone en position " + position + " avec attenuation " + facteurAttenuation + " sans connexions");
		}
		else {
			
		
		System.out.println("Le neurone en position " + position + " avec attenuation " + facteurAttenuation + " en connexion avec :");
		for(Neurone neurone : connexions) {
			System.out.println("	- Un neurone en position " + neurone.getPosition());
		}
	}
		return "";
	
}
	
}

class NeuroneCumulatif extends Neurone{
	
	NeuroneCumulatif(Position position, double facteurAttenuation){
		super(position , facteurAttenuation);
	}
	
	public void recoitStimulus(double stimulus) {
		signalInterne = signalInterne + stimulus*facteurAttenuation;
		for(Neurone neurone : connexions) {
			neurone.recoitStimulus(signalInterne);
		}
	}
	
	public double getSignal() {
		return signalInterne;
	}
}

class Cerveau{
	
	ArrayList<Neurone> cerveau = new ArrayList<Neurone>();
	
	Cerveau(){
		
	}
	
	
	public int getNbNeurones() {
		return cerveau.size();
	}
	
	public Neurone getNeurone(int index) {
		return cerveau.get(index);
	}
	
	public void ajouterNeurone(Position pos, double facteurAttenuation) {
		cerveau.add(new Neurone(pos, facteurAttenuation));
	}
	
	public void ajouterNeuroneCumulatif(Position pos, double facteurAttenuation) {
		cerveau.add(new Neurone(pos, facteurAttenuation));
	}
	
	public void stimuler(int index, double stimulus) {
		cerveau.get(index).recoitStimulus(stimulus);
	}
	
	public double sonder(int index) {
		return cerveau.get(index).getSignal();
	}
	
	public void creerConnexions() {
		
		int tailleCerveau = cerveau.size();
		int indiceCerveau = 0;
		
		cerveau.get(indiceCerveau).connexions.add(cerveau.get(indiceCerveau + 1));
		cerveau.get(indiceCerveau).connexions.add(cerveau.get(indiceCerveau + 2));
		
		indiceCerveau+=1;
		
		if (cerveau.size() != 0) {
			while (indiceCerveau  < tailleCerveau - 2) {
				if (tailleCerveau >= indiceCerveau + 1) {
					cerveau.get(indiceCerveau).connexions.add(cerveau.get(indiceCerveau + 1));
				}
				if (tailleCerveau >= indiceCerveau + 2) {
					cerveau.get(indiceCerveau + 1).connexions.add(cerveau.get(indiceCerveau + 2));
				}
				indiceCerveau +=2;
			}
			
		}
	}
	
	public String toString() {
		System.out.println("Le cerveau contient " + cerveau.size() + " neurones");
		for(Neurone neurone : cerveau) {
			System.out.println(neurone);
		}
		return "";
	}
	
}


class SimulateurNeurone {

    public static void main(String[] args) {
        // TEST DE LA PARTIE 1
        System.out.println("Test de la partie 1:");
        System.out.println("--------------------");

        Position position1 = new Position(0, 1);
        Position position2 = new Position(1, 0);
        Position position3 = new Position(1, 1);

        Neurone neuron1 = new Neurone(position1, 0.5);
        Neurone neuron2 = new Neurone(position2, 1.0);
        Neurone neuron3 = new Neurone(position3, 2.0);

        neuron1.connexion(neuron2);
        neuron2.connexion(neuron3);
        neuron1.recoitStimulus(10);

        System.out.println("Signaux : ");
        System.out.println(neuron1.getSignal());
        System.out.println(neuron2.getSignal());
        System.out.println(neuron3.getSignal());

        System.out.println();
        System.out.println("Premiere connexion du neurone 1");
        System.out.println(neuron1.getConnexion(0));


        // FIN TEST DE LA PARTIE 1

        // TEST DE LA PARTIE 2
        System.out.println("Test de la partie 2:");
        System.out.println("--------------------");

        Position position5 = new Position(0, 0);
        NeuroneCumulatif neuron5 = new NeuroneCumulatif(position5, 0.5);
        neuron5.recoitStimulus(10);
        neuron5.recoitStimulus(10);
        System.out.println("Signal du neurone cumulatif  -> " + neuron5.getSignal());

        // FIN TEST DE LA PARTIE 2

        // TEST DE LA PARTIE 3
        System.out.println();
        System.out.println("Test de la partie 3:");
        System.out.println("--------------------");
        Cerveau cerveau = new Cerveau();

        // parametres de construction du neurone:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeurone(new Position(0,0), 0.5);
        cerveau.ajouterNeurone(new Position(0,1), 0.2);
        cerveau.ajouterNeurone(new Position(1,0), 1.0);

        // parametres de construction du neurone cumulatif:
        // la  position et le facteur d'attenuation
        cerveau.ajouterNeuroneCumulatif(new Position(1,1), 0.8);
        cerveau.creerConnexions();
        cerveau.stimuler(0, 10);

        System.out.println("Signal du 3eme neurone -> " + cerveau.sonder(3));
        System.out.println(cerveau);
        // FIN TEST DE LA PARTIE 3
    }
}