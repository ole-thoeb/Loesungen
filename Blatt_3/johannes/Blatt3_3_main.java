
public class Blatt3_3_main {

	public static void main(String[] args) {

		Stereoanlage s=new Stereoanlage();
		Playable pl=new CD();
		s.play(pl);
		pl=new Kassette();
		s.play(pl);
	}
	
	//Methode "play(Playable p)" in Stereoanlage ruft "song()" auf. Welches der "song"s tats�chlich aufgerufen wird,
	//h�ngt am Typ des Imputparameters; im ersten Fall ist es eine CD, im zweiten eine Kassette
	
}
