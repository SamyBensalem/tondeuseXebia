import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TestTondeuse {


    public static void main(String[] args) {

        Pattern patternPelouse = Pattern.compile("[0-9]\\s[0-9]");
        Pattern patternTondeuse = Pattern.compile("[0-9]\\s[0-9]\\s[A-Z]");
        Pattern patternDeplacement = Pattern.compile("([A-Z])*");

        ArrayList<String> pelouse = new ArrayList<>();
        ArrayList<String> positionInitiales = new ArrayList<>();
        ArrayList<String> deplacements = new ArrayList<>();



        String fileName = ".\\src\\TEST";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(p->{
                Matcher matcherPelouse = patternPelouse.matcher(p);
                Matcher matcherTondeuse = patternTondeuse.matcher(p);
                Matcher matcherDeplacement = patternDeplacement.matcher(p);

                if (matcherPelouse.matches()) {
                    pelouse.add(p);

                }
                if (matcherTondeuse.matches()) {
                    positionInitiales.add(p);

                }
                if (matcherDeplacement.matches()) {
                    deplacements.add(p);
                }


            });

        } catch (IOException e) {
            e.printStackTrace();
        }



        for(String p: pelouse){
            for(int i=0;i< positionInitiales.size();i++){
                afficheTest(p,positionInitiales.get(i),deplacements.get(i));
            }
        }




    }



    public static void afficheTest(String surfacePelouse,String tondeuseParam,String deplacement){
        Pelouse pelouse = new Pelouse(Integer.parseInt(surfacePelouse.substring(0, 1)), Integer.parseInt(surfacePelouse.substring(2, 3)));
        Tondeuse tondeuse = new Tondeuse(Integer.parseInt(tondeuseParam.substring(0, 1)),
                Integer.parseInt(tondeuseParam.substring(2, 3)),
                tondeuseParam.charAt(4),
                pelouse);
        tondeuse.deplacement(deplacement);
        System.out.println(tondeuse);
    }

}
